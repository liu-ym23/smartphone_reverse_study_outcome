package com.larus.drive.biz.impl.utils;

import com.larus.drive.biz.api.model.DriveUploadStatus;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f341283a = 0;

    static {
    }

    public static int a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadItems");
        if (r100.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator r101 = r100.entrySet().iterator();
        int r102 = 3;
    L7:
        if (r101.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r101.next();
        if (CollectionsKt.listOf(new DriveUploadStatus[]{DriveUploadStatus.UPLOADING, DriveUploadStatus.UNSTARTED}).contains(((com.larus.drive.biz.api.model.a) r103.getValue()).f341033f) == true) goto L10;
        if (((com.larus.drive.biz.api.model.a) r103.getValue()).f341033f != DriveUploadStatus.FAILED) goto L7;
        r102 = 2;
        goto L7
    L10:
        return 1;
    L14:
        return r102;
    }
}
