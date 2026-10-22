package com.facebook.soloader;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes23.dex */
public final class ExoSoSource extends UnpackingSoSource {

    /* JADX INFO: renamed from: com.facebook.soloader.ExoSoSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        private final FileDso[] mDsos;
        final /* synthetic */ ExoSoSource this$0;

        public final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;
            final /* synthetic */ ExoUnpacker this$1;

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                if (this.mCurrentDso >= ExoUnpacker.access$100(this.this$1).length) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] r100 = ExoUnpacker.access$100(this.this$1);
                int r101 = this.mCurrentDso;
                this.mCurrentDso = r101 + 1;
                FileDso r102 = r100[r101];
                PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r102.backingFile);
                return new UnpackingSoSource.InputDsoStream(r102, r103);
            L5:
                th = move-exception;
                r103.close();
                throw th;
            }

            private FileBackedInputDsoIterator(ExoUnpacker r100) {
                this.this$1 = r100;
            }

            public /* synthetic */ FileBackedInputDsoIterator(ExoUnpacker r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator(this, null);
        }

        public static /* synthetic */ FileDso[] access$100(ExoUnpacker r100) {
            return r100.mDsos;
        }

        public ExoUnpacker(ExoSoSource r110, UnpackingSoSource r111) throws IOException {
            this.this$0 = r110;
            PolarisFileWrapper r100 = new PolarisFileWrapper("/data/local/tmp/exopackage/" + r110.mContext.getPackageName() + "/native-libs/");
            ArrayList r101 = new ArrayList();
            LinkedHashSet r102 = new LinkedHashSet();
            String[] r103 = SysUtil.getSupportedAbis();
            int r104 = r103.length;
            int r105 = 0;
            int r106 = 0;
        L3:
            if (r106 >= r104) goto L49;
            String r107 = r103[r106];
            PolarisFileWrapper r108 = new PolarisFileWrapper(r100, r107);
            if (r108.isDirectory() == false) goto L33;
            r102.add(r107);
            PolarisFileWrapper r109 = new PolarisFileWrapper(r108, "metadata.txt");
            if (r109.isFile() == false) goto L33;
            PolarisFileReaderWrapper r112 = new PolarisFileReaderWrapper(r109);
            BufferedReader r113 = new BufferedReader(r112);     // Catch: Throwable -> L42
        L54:
            String r114 = r113.readLine();     // Catch: Throwable -> L34
            if (r114 == null) goto L31;
            if (r114.length() == 0) goto L54;
            int r115 = r114.indexOf(32);     // Catch: Throwable -> L34
            if (r115 == (-1)) goto L30;
            String r116 = r114.substring(r105, r115) + ".so";     // Catch: Throwable -> L34
            int r117 = r101.size();     // Catch: Throwable -> L34
            int r118 = 0;
        L20:
            if (r118 >= r117) goto L25;
            if (((FileDso) r101.get(r118)).name.equals(r116) == true) goto L23;
            r118 = r118 + 1;     // Catch: Throwable -> L34
            goto L20
        L23:
            boolean r119 = true;
        L26:
            if (r119 == false) goto L28;
        L27:
            r105 = 0;
            goto L54
        L28:
            String r120 = r114.substring(r115 + 1);     // Catch: Throwable -> L34
            r101.add(new FileDso(r116, r120, new PolarisFileWrapper(r108, r120)));     // Catch: Throwable -> L34
            goto L27
        L25:
            r119 = false;
            goto L26
        L30:
            throw new RuntimeException("illegal line in exopackage metadata: [" + r114 + "]");     // Catch: Throwable -> L34
        L31:
            r113.close();     // Catch: Throwable -> L42
            r112.close();
        L34:
            th = move-exception;
            r113.close();     // Catch: Throwable -> L38
        L71:
            throw th;     // Catch: Throwable -> L42
        L38:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L42
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            r112.close();     // Catch: Throwable -> L46
            throw th;
        L46:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L33:
            r106 = r106 + 1;
            r105 = 0;
            goto L3
        L49:
            r111.setSoSourceAbis((String[]) r102.toArray(new String[r102.size()]));
            this.mDsos = (FileDso[]) r101.toArray(new FileDso[r101.size()]);
        }
    }

    public static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        public FileDso(String r100, String r101, File r102) {
            super(r100, r101);
            this.backingFile = r102;
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker(byte r100) throws IOException {
        return new ExoUnpacker(this, this);
    }

    public ExoSoSource(Context r100, String r101) {
        super(r100, r101);
    }
}
