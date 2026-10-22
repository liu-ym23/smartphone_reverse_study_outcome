package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433772a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final eub.f f433773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f433774b;

        public a() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f433773a, r101.f433773a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f433774b, r101.f433774b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            eub.f r100 = this.f433773a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f433774b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NormalizeResult(param=" + this.f433773a + ", errorMessage=" + this.f433774b + ')';
        }

        public a(eub.f r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this.f433773a = r100;
            this.f433774b = r101;
        }
    }

    static {
    }

    public static void a(eub.f r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        MmRecordingSource r100 = r110.f474154b;
        if (r100 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L5;
    L34:
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: skip hardware taskId=" + r110.f474153a);
        return;
    L5:
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L34;
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L34;
        List<eub.d> r101 = r110.f474155c;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r102.add(((eub.d) r103.next()).f474142a);
        goto L11
    L13:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L15:
        if (r105.hasNext() == false) goto L22;
        Object r106 = r105.next();
        if (((String) r106).length() <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L15;
        r104.add(r106);
        goto L15
    L19:
        r107 = false;
        goto L20
    L22:
        List r108 = CollectionsKt.distinct(r104);
        long r109 = System.currentTimeMillis();
        Iterator r111 = r108.iterator();
    L24:
        if (r111.hasNext() == false) goto L32;
        String r112 = (String) r111.next();
        VFSFile r113 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r112);     // Catch: Throwable -> L30
        if (r113.exists() == false) goto L24;
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: taskId=" + r110.f474153a + ", path=" + r112 + ", deleted=" + r113.delete());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        lvb.a.b("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles failed: taskId=" + r110.f474153a + ", path=" + r112 + ", err=" + th.getClass().getSimpleName() + ", msg=" + th.getMessage());
        goto L24
    L32:
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: taskId=" + r110.f474153a + ", fileCount=" + r108.size() + ", cost=" + (System.currentTimeMillis() - r109) + "ms");
    }
}
