package com.ss.android.lark.usersetting.service.timezone;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/usersetting/service/timezone/ExposureTimeZoneServiceImpl$updateExposureTimeZoneSetting$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "data", "(Ljava/lang/Boolean;)V", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "usersetting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExposureTimeZoneServiceImpl$updateExposureTimeZoneSetting$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public ExposureTimeZoneServiceImpl$updateExposureTimeZoneSetting$1(Function1<? super Boolean, Unit> r100) {
        this.$callback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("ExposureTimeZoneServiceImpl", r100.getDisplayMsg());
        this.$callback.invoke(Boolean.FALSE);
    }

    public void onSuccess(Boolean r100) {
        Log.i("ExposureTimeZoneServiceImpl", "update timezone " + r100);
        this.$callback.invoke(Boolean.TRUE);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }
}
