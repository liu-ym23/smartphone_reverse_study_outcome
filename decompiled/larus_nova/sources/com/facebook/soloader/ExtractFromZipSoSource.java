package com.facebook.soloader;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ExtractFromZipSoSource extends UnpackingSoSource {
    protected final File mZipFileName;
    protected final String mZipSearchPattern;

    /* JADX INFO: renamed from: com.facebook.soloader.ExtractFromZipSoSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ZipDso extends UnpackingSoSource.Dso implements Comparable {
        final int abiScore;
        final ZipEntry backingEntry;

        private static String makePseudoHash(ZipEntry r100) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[]{r100.getName(), Long.valueOf(r100.getSize()), Long.valueOf(r100.getCompressedSize()), Long.valueOf(r100.getCrc())});
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r100) {
            return this.name.compareTo(((ZipDso) r100).name);
        }

        public ZipDso(String r100, ZipEntry r101, int r102) {
            super(r100, makePseudoHash(r101));
            this.backingEntry = r101;
            this.abiScore = r102;
        }
    }

    public class ZipUnpacker extends UnpackingSoSource.Unpacker {

        @Nullable
        private ZipDso[] mDsos;
        private final UnpackingSoSource mSoSource;
        private final ZipFile mZipFile;
        final /* synthetic */ ExtractFromZipSoSource this$0;

        public final class ZipBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;
            final /* synthetic */ ZipUnpacker this$1;

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                this.this$1.ensureDsos();
                if (this.mCurrentDso >= ZipUnpacker.access$100(this.this$1).length) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                this.this$1.ensureDsos();
                ZipDso[] r100 = ZipUnpacker.access$100(this.this$1);
                int r101 = this.mCurrentDso;
                this.mCurrentDso = r101 + 1;
                ZipDso r102 = r100[r101];
                InputStream r103 = ZipUnpacker.access$200(this.this$1).getInputStream(r102.backingEntry);
                return new UnpackingSoSource.InputDsoStream(r102, r103);
            L5:
                th = move-exception;
                if (r103 == null) goto L8;
                r103.close();
            L8:
                throw th;
            }

            private ZipBackedInputDsoIterator(ZipUnpacker r100) {
                this.this$1 = r100;
            }

            public /* synthetic */ ZipBackedInputDsoIterator(ZipUnpacker r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        public boolean shouldExtract(ZipEntry r100, String r101) {
            return true;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mZipFile.close();
        }

        public final ZipDso[] ensureDsos() {
            if (this.mDsos != null) goto L33;
            LinkedHashSet r100 = new LinkedHashSet();
            HashMap r101 = new HashMap();
            Pattern r102 = Pattern.compile(this.this$0.mZipSearchPattern);
            String[] r103 = SysUtil.getSupportedAbis();
            Enumeration<? extends ZipEntry> r104 = this.mZipFile.entries();
        L6:
            if (r104.hasMoreElements() == false) goto L16;
            ZipEntry r105 = r104.nextElement();
            Matcher r106 = r102.matcher(r105.getName());
            if (r106.matches() == false) goto L6;
            String r107 = r106.group(1);
            String r108 = r106.group(2);
            int r109 = SysUtil.findAbiScore(r103, r107);
            if (r109 < 0) goto L6;
            r100.add(r107);
            ZipDso r110 = (ZipDso) r101.get(r108);
            if (r110 == null) goto L15;
            if (r109 >= r110.abiScore) goto L6;
        L15:
            r101.put(r108, new ZipDso(r108, r105, r109));
            goto L6
        L16:
            this.mSoSource.setSoSourceAbis((String[]) r100.toArray(new String[r100.size()]));
            ZipDso[] r111 = (ZipDso[]) r101.values().toArray(new ZipDso[r101.size()]);
            Arrays.sort(r111);
            int r112 = 0;
            int r113 = 0;
            int r114 = 0;
        L18:
            if (r113 >= r111.length) goto L24;
            ZipDso r115 = r111[r113];
            if (shouldExtract(r115.backingEntry, r115.name) == false) goto L22;
            r114 = r114 + 1;
        L23:
            r113 = r113 + 1;
            goto L18
        L22:
            r111[r113] = null;
            goto L23
        L24:
            ZipDso[] r116 = new ZipDso[r114];
            int r117 = 0;
        L26:
            if (r112 >= r111.length) goto L31;
            ZipDso r118 = r111[r112];
            if (r118 == null) goto L30;
            r116[r117] = r118;
            r117 = r117 + 1;
        L30:
            r112 = r112 + 1;
            goto L26
        L31:
            this.mDsos = r116;
        L33:
            return this.mDsos;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(ensureDsos());
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new ZipBackedInputDsoIterator(this, null);
        }

        public static /* synthetic */ ZipDso[] access$100(ZipUnpacker r100) {
            return r100.mDsos;
        }

        public static /* synthetic */ ZipFile access$200(ZipUnpacker r100) {
            return r100.mZipFile;
        }

        public ZipUnpacker(ExtractFromZipSoSource r100, UnpackingSoSource r101) throws IOException {
            this.this$0 = r100;
            this.mZipFile = new PolarisZipFileWrapper(r100.mZipFileName);
            this.mSoSource = r101;
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker(byte r100) throws IOException {
        return new ZipUnpacker(this, this);
    }

    public ExtractFromZipSoSource(Context r100, String r101, File r102, String r103) {
        super(r100, r101);
        this.mZipFileName = r102;
        this.mZipSearchPattern = r103;
    }
}
