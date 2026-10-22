package com.larus.bmhome.upload;

import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.bmhome.upload.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4108a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314746a = null;

        static {
            int[] r100 = new int[UploadDataType.values().length];
            r100[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[UploadDataType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[UploadDataType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f314746a = r100;
        }
    }

    public static final FlowResourceType a(mr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FlowResourceType r101 = mr9.a.a(r100.f515013o.f514996c);
        FlowResourceType r102 = FlowResourceType.Unknown;
        if (r101 == r102) goto L5;
        return r101;
    L5:
        UploadDataType r103 = r100.f515001c;
        int r104 = C4108a.f314746a[r103.ordinal()];
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L21;
        if (r104 == 3) goto L20;
        if (r104 != 4) goto L15;
        return r102;
    L15:
        throw new NoWhenBranchMatchedException();
    L20:
        return FlowResourceType.Video;
    L21:
        return FlowResourceType.File;
    L19:
        return FlowResourceType.Image;
    }
}
