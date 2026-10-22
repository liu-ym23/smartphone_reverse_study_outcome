package com.ss.android.lark.widget.photo.preview.image;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f446699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f446700c;

    public s(n r100, PhotoItem r101, Serializable r102) {
        this.f446698a = r100;
        this.f446699b = r101;
        this.f446700c = r102;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == true) goto L12;
        n r101 = this.f446698a;
        PhotoItem r102 = this.f446699b;
        Serializable r103 = this.f446700c;
        ErrorResult r104 = null;
        if ((r103 instanceof EncryptImage) == false) goto L7;
        EncryptImage r105 = (EncryptImage) r103;
    L8:
        if (r105 == null) goto L10;
        r104 = r105.getErrorResult();
    L10:
        n.a(r101, r102, PerfPhotoViewMonitor.ErrorReason.PIC_DOWNLOAD_ORIGIN_FAILED, r104);
        return;
    L7:
        r105 = null;
        goto L8
    }
}
