package com.ss.android.lark.vfs;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class FileAccessCompatManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f444802a;

    public static final class a implements VFSFiles.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, b> f444803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f444804b;

        public a() {
            this.f444803a = new ConcurrentHashMap();
        }

        @Override // com.ss.android.lark.vfs.VFSFiles.a
        public final File a(PolarisFileWrapper r100) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            Iterator<T> r101 = this.f444803a.entrySet().iterator();
            if (r101.hasNext() == false) goto L5;
            Object r102 = r101.next();
            ((b) ((Map.Entry) r102).getValue()).accept(r100);
        L6:
            Map.Entry r103 = (Map.Entry) r102;
            if (r103 == null) goto L10;
            b r104 = (b) r103.getValue();
            if (r104 == null) goto L10;
        L11:
            if (r104 == null) goto L17;
            File r105 = r104.a(r100);
            if (r105 != null) goto L16;
            return r100;
        L16:
            return r105;
        L17:
            return r100;
        L10:
            r104 = this.f444804b;
            goto L11
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.ss.android.lark.vfs.VFSFiles.a
        public final File b(File r100) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            Iterator<T> r101 = this.f444803a.entrySet().iterator();
            if (r101.hasNext() == false) goto L5;
            Object r102 = r101.next();
            ((b) ((Map.Entry) r102).getValue()).accept(r100);
        L6:
            Map.Entry r103 = (Map.Entry) r102;
            if (r103 == null) goto L10;
            b r104 = (b) r103.getValue();
            if (r104 == null) goto L10;
        L11:
            if (r104 == null) goto L17;
            File r105 = r104.b(r100);
            if (r105 != null) goto L16;
            return r100;
        L16:
            return r105;
        L17:
            return r100;
        L10:
            r104 = this.f444804b;
            goto L11
        L5:
            r102 = null;
            goto L6
        }
    }

    public interface b {
        File a(PolarisFileWrapper r100);

        void accept(File r100);

        File b(File r100);
    }

    public FileAccessCompatManager() {
        this.f444802a = LazyKt.lazy(FileAccessCompatManager$fileAccessCompatHub$2.INSTANCE);
    }
}
