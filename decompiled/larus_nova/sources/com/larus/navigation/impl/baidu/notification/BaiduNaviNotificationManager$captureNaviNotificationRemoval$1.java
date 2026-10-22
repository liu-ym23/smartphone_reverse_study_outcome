package com.larus.navigation.impl.baidu.notification;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class BaiduNaviNotificationManager$captureNaviNotificationRemoval$1 extends FunctionReferenceImpl implements Function1<tl9.c, Unit> {
    public BaiduNaviNotificationManager$captureNaviNotificationRemoval$1(Object r100) {
        super(1, r100, BaiduNaviNotificationManager.class, "removeNotification", "removeNotification(Lcom/larus/navigation/api/baidu/BaiduNaviNotificationCallback;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(tl9.c r100) {
        BaiduNaviNotificationManager r101 = (BaiduNaviNotificationManager) this.receiver;
        BaiduNaviNotificationManager r102 = BaiduNaviNotificationManager.f359788a;
        r101.getClass();
        BaiduNaviNotificationManager.f359789b = false;
        BaiduNaviForegroundService.f359784a.stopService();
        Bitmap r103 = BaiduNaviNotificationManager.f359790c;
        if (r103 == null) goto L5;
        r103.recycle();
    L5:
        BaiduNaviNotificationManager.f359790c = null;
        if (r100 == null) goto L9;
        r100.a();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(tl9.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
