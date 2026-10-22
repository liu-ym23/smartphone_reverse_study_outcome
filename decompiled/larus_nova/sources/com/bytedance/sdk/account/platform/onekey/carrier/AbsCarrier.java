package com.bytedance.sdk.account.platform.onekey.carrier;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.platform.onekey.OnekeyDataHelper;
import com.bytedance.sdk.account.platform.onekey.OnekeyResponseCallable;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsCarrier implements ICarrierService {
    protected boolean isCancel;
    protected final IServiceContainer mContainer;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnekeyResponseCallable f269273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsCarrier f269274b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f269274b.notifyTimeout(this.f269273a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AbsCarrier r100, OnekeyResponseCallable r101) {
            this.f269274b = r100;
            this.f269273a = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnekeyResponseCallable f269275a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            OnekeyResponseCallable r100 = this.f269275a;     // Catch: Throwable -> L8
            AuthorizeCallback r101 = r100.mCallback;     // Catch: Throwable -> L8
            if (r101 == null) goto L11;
            T r102 = r100.response;     // Catch: Throwable -> L8
            if ((r102 instanceof OnekeyLoginErrorResponse) == false) goto L15;
            r101.onError((OnekeyLoginErrorResponse) r102);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public b(OnekeyResponseCallable r100) {
            this.f269275a = r100;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnekeyResponseCallable f269276a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            OnekeyResponseCallable r100 = this.f269276a;     // Catch: Throwable -> L9
            AuthorizeCallback r101 = r100.mCallback;     // Catch: Throwable -> L9
            if (r101 == null) goto L14;
            T r102 = r100.response;     // Catch: Throwable -> L9
            if ((r102 instanceof Bundle) == false) goto L7;
            r101.onSuccess((Bundle) r102);     // Catch: Throwable -> L9
            goto L14
        L7:
            r101.onError(new AuthorizeErrorResponse("-1", "unknown"));     // Catch: Throwable -> L9
        L14:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public c(OnekeyResponseCallable r100) {
            this.f269276a = r100;
        }
    }

    private String getMonitorEvent(int r100) {
        if (r100 != 1) goto L5;
        return OnekeyDataHelper.GET_PHONE_EVENT;
    L5:
        if (r100 != 2) goto L7;
    L9:
        return OnekeyDataHelper.GET_TOKEN_EVENT;
    L7:
        if (r100 == 3) goto L9;
        return "";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.ICarrierService
    public void cancel() {
        this.isCancel = false;
    }

    public abstract String getCarrierName();

    public void notifyTimeout(OnekeyResponseCallable<?> r100) {
    }

    public abstract String settingKey();

    private Handler getHandler() {
        IServiceContainer r100 = this.mContainer;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHandler();
    }

    public Context getContext() {
        IServiceContainer r100 = this.mContainer;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getApplicationContext();
    }

    public boolean isEnable() {
        IServiceContainer r100 = this.mContainer;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.getSetting().isEnable(settingKey());
    }

    public boolean needReadPhonePermission() {
        IServiceContainer r100 = this.mContainer;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getSetting().needReadPhonePermission(settingKey());
    }

    public void clearTimer() {
        Handler r100 = getHandler();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeCallbacksAndMessages(null);
    }

    public AbsCarrier(IServiceContainer r100) {
        this.mContainer = r100;
    }

    public long getTimeout(String r100) {
        IServiceContainer r101 = this.mContainer;
        if (r101 != null) goto L5;
        return 4000;
    L5:
        return r101.getSetting().getSceneTimeOut(r100, settingKey(), getCarrierName());
    }

    public boolean needDataMobile(boolean r100) {
        IServiceContainer r101 = this.mContainer;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.getSetting().needDataMobile(settingKey(), r100);
    }

    public void sendOneKeyFailedMessage(OnekeyResponseCallable<?> r100) {
        if (this.isCancel == true) goto L11;
        if (r100 == null) goto L12;
        Handler r101 = getHandler();
        if (r101 != null) goto L9;
        return;
    L9:
        r101.post(new b(r100));
        return;
    L12:
        return;
    }

    public void sendOneKeySuccessMessage(OnekeyResponseCallable<?> r100) {
        if (this.isCancel == true) goto L11;
        if (r100 == null) goto L12;
        Handler r101 = getHandler();
        if (r101 != null) goto L9;
        return;
    L9:
        r101.post(new c(r100));
        return;
    L12:
        return;
    }

    public void onEvent(String r100, JSONObject r101) {
        IServiceContainer r102 = this.mContainer;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    public void startTimer(long r100, OnekeyResponseCallable<?> r101) {
        Handler r102 = getHandler();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.postDelayed(new a(this, r101), r100);
    }

    public OnekeyLoginErrorResponse getErrorResponse(String r100, String r101, String r102, int r103, int r104) {
        OnekeyLoginErrorResponse r105 = new OnekeyLoginErrorResponse();
        r105.netType = r102;
        r105.netStatus = r103;
        r105.platformErrorCode = r100;
        r105.platformErrorMsg = r101;
        r105.errorType = r104;
        r105.rawResult = null;
        return r105;
    }

    public void postDataMobileDisableError(String r210, String r211, String r212, int r213, AuthorizeCallback r214) {
        if (r214 != null) goto L5;
    L7:
        onEvent(OnekeyDataHelper.GET_PHONE_EVENT, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DATA_MOBILE_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DATA_MOBILE_DISABLED_MSG, 0, null, r210, r211, r212, r213, r214));
        return;
    L5:
        if (this.isCancel == true) goto L7;
        r214.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DATA_MOBILE_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DATA_MOBILE_DISABLED_MSG, r210, r213, 1));
        goto L7
    }

    public void postCarrierDisableError(String r210, String r211, String r212, int r213, String r214, int r215, AuthorizeCallback r216) {
        if (r216 != null) goto L5;
    L7:
        onEvent(r214, OnekeyDataHelper.generateMonitorJson(getContext(), false, OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DISABLED_MSG, 0, null, r210, r211, r212, r213, r216));
        return;
    L5:
        if (this.isCancel == true) goto L7;
        r216.onError(getErrorResponse(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED, OnekeyLoginConstants.ErrorMsg.ERROR_CARRIER_DISABLED_MSG, r210, r213, r215));
        goto L7
    }

    public void postLoginErrorResponse(String r110, String r111, String r112, String r113, String r210, String r211, int r212, int r213, long r214, JSONObject r215, AuthorizeCallback r216) {
        sendOneKeyFailedMessage(new OnekeyResponseCallable(r216, OnekeyDataHelper.getErrorResponse(r110, r111, r113, r212, r213, r215)));
        onEvent(getMonitorEvent(r213), OnekeyDataHelper.generateMonitorJson(getContext(), false, r110, r111, r214, r112, OnekeyDataHelper.getCarrierEvent(r113), r210, r211, r212, r216));
    }
}
