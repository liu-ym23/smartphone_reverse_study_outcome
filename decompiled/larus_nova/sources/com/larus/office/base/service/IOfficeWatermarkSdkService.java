package com.larus.office.base.service;

import android.app.Dialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ,\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/office/base/service/IOfficeWatermarkSdkService;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "detachDialogWatermark", "", "dialog", "Landroid/app/Dialog;", "attachDialogWatermark", "awaitWatermarkService", "", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWatermarkedImageResource", "Lcom/larus/office/base/service/WatermarkedImageResource;", "scene", "", "path", "data", "", "(Ljava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeWatermarkSdkService extends ISdkLifecycleV2 {
    void K(Dialog r100);

    Object L(String r100, String r101, byte[] r102, Continuation<? super o> r103);

    void M(Dialog r100);

    Object N(long r100, Continuation<? super Boolean> r101);
}
