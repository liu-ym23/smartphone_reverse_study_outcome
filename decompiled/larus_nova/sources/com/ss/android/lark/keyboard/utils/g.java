package com.ss.android.lark.keyboard.utils;

import com.bytedance.lark.pb.basic.v1.ResourceFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceFile.FileType f430965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f430966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f430967c;

    public final String toString() {
        return "FlowResourceUploadInfo(fileType=" + this.f430965a + ", compressPath='" + this.f430966b + "', imageInfo=" + this.f430967c + ')';
    }

    public g(ResourceFile.FileType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileType");
        Intrinsics.checkNotNullParameter(r101, "compressPath");
        this.f430965a = r100;
        this.f430966b = r101;
        this.f430967c = null;
    }
}
