package com.bytedance.caijing.sdk.infra.base.impl.jsb.h5jsb.geninfo;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import of4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class CJJsbError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CJJsbError f202601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f202602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f202603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f202604d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f202605e = null;

    public CJJsbError() {
    }

    static {
        f202601a = new CJJsbError();
        f202602b = LazyKt.lazy(CJJsbError$jsbDefaultError$2.INSTANCE);
        f202603c = LazyKt.lazy(CJJsbError$jsbExecuteError$2.INSTANCE);
        f202604d = LazyKt.lazy(CJJsbError$jsbCanceled$2.INSTANCE);
        f202605e = LazyKt.lazy(CJJsbError$jsbNoPermissionError$2.INSTANCE);
        CJJsbError$jsbSaveImgToAlbumError$1 r100 = CJJsbError$jsbSaveImgToAlbumError$1.INSTANCE;
        CJJsbError$jsbGetAppInfoError$1 r101 = CJJsbError$jsbGetAppInfoError$1.INSTANCE;
        CJJsbError$jsbDypayError$1 r102 = CJJsbError$jsbDypayError$1.INSTANCE;
        CJJsbError$jsbVipInfoError$1 r103 = CJJsbError$jsbVipInfoError$1.INSTANCE;
        CJJsbError$jsbGetH5InitTimeError$1 r104 = CJJsbError$jsbGetH5InitTimeError$1.INSTANCE;
        CJJsbError$jsbAlogError$1 r105 = CJJsbError$jsbAlogError$1.INSTANCE;
        CJJsbError$jsbUploadMediaError$1 r106 = CJJsbError$jsbUploadMediaError$1.INSTANCE;
        CJJsbError$jsbChooseMediaError$1 r107 = CJJsbError$jsbChooseMediaError$1.INSTANCE;
        CJJsbError$jsbSetDeviceInfoError$1 r108 = CJJsbError$jsbSetDeviceInfoError$1.INSTANCE;
        CJJsbError$jsbDownloadFileError$1 r109 = CJJsbError$jsbDownloadFileError$1.INSTANCE;
        CJJsbError$jsbSendDeviceInfoError$1 r110 = CJJsbError$jsbSendDeviceInfoError$1.INSTANCE;
        CJJsbError$jsbSendPageStatusError$1 r111 = CJJsbError$jsbSendPageStatusError$1.INSTANCE;
        CJJsbError$jsbFaceppError$1 r112 = CJJsbError$jsbFaceppError$1.INSTANCE;
        CJJsbError$jsbSignAlipayError$1 r113 = CJJsbError$jsbSignAlipayError$1.INSTANCE;
        CJJsbError$jsbBlockNativeBackError$1 r114 = CJJsbError$jsbBlockNativeBackError$1.INSTANCE;
        CJJsbError$jsbGetPhoneInfoError$1 r115 = CJJsbError$jsbGetPhoneInfoError$1.INSTANCE;
        CJJsbError$jsbTtpayError$1 r116 = CJJsbError$jsbTtpayError$1.INSTANCE;
        CJJsbError$jsbCJAuthError$1 r117 = CJJsbError$jsbCJAuthError$1.INSTANCE;
        CJJsbError$jsbLoginAPIError$1 r118 = CJJsbError$jsbLoginAPIError$1.INSTANCE;
        CJJsbError$jsbFaceVerificationError$1 r119 = CJJsbError$jsbFaceVerificationError$1.INSTANCE;
        CJJsbError$jsbSendMonitorError$1 r120 = CJJsbError$jsbSendMonitorError$1.INSTANCE;
        CJJsbError$jsbOcrError$1 r121 = CJJsbError$jsbOcrError$1.INSTANCE;
        CJJsbError$jsbPrefetchDataError$1 r122 = CJJsbError$jsbPrefetchDataError$1.INSTANCE;
        CJJsbError$jsbBioPaymentShowStateError$1 r123 = CJJsbError$jsbBioPaymentShowStateError$1.INSTANCE;
        CJJsbError$jsbSwitchBioPaymentStateError$1 r124 = CJJsbError$jsbSwitchBioPaymentStateError$1.INSTANCE;
        CJJsbError$jsbGoMyBankCardError$1 r125 = CJJsbError$jsbGoMyBankCardError$1.INSTANCE;
        CJJsbError$jsbShowToastError$1 r126 = CJJsbError$jsbShowToastError$1.INSTANCE;
        CJJsbError$jsbAuthAlipayError$1 r127 = CJJsbError$jsbAuthAlipayError$1.INSTANCE;
        CJJsbError$jsbSetTitleError$1 r128 = CJJsbError$jsbSetTitleError$1.INSTANCE;
        CJJsbError$jsbSupportFileError$1 r129 = CJJsbError$jsbSupportFileError$1.INSTANCE;
        CJJsbError$jsbRequestWXH5PaymentError$1 r130 = CJJsbError$jsbRequestWXH5PaymentError$1.INSTANCE;
        CJJsbError$jsbUpdatePayTypeInfoError$1 r131 = CJJsbError$jsbUpdatePayTypeInfoError$1.INSTANCE;
        CJJsbError$jsbPayInfoError$1 r132 = CJJsbError$jsbPayInfoError$1.INSTANCE;
        CJJsbError$jsbGoSettingsError$1 r133 = CJJsbError$jsbGoSettingsError$1.INSTANCE;
        CJJsbError$jsbLoginError$1 r134 = CJJsbError$jsbLoginError$1.INSTANCE;
        CJJsbError$jsbDecryptError$1 r135 = CJJsbError$jsbDecryptError$1.INSTANCE;
        CJJsbError$jsbEncryptError$1 r136 = CJJsbError$jsbEncryptError$1.INSTANCE;
        CJJsbError$jsbNotifyOrderResultError$1 r137 = CJJsbError$jsbNotifyOrderResultError$1.INSTANCE;
        CJJsbError$jsbCallHostAppError$1 r138 = CJJsbError$jsbCallHostAppError$1.INSTANCE;
        CJJsbError$jsbRequestError$1 r139 = CJJsbError$jsbRequestError$1.INSTANCE;
        CJJsbError$jsbAbTestError$1 r140 = CJJsbError$jsbAbTestError$1.INSTANCE;
        CJJsbError$jsbSendLogError$1 r141 = CJJsbError$jsbSendLogError$1.INSTANCE;
        CJJsbError$jsbCloseError$1 r142 = CJJsbError$jsbCloseError$1.INSTANCE;
        CJJsbError$jsbSendNotificationError$1 r143 = CJJsbError$jsbSendNotificationError$1.INSTANCE;
        CJJsbError$jsbDisableHistoryError$1 r144 = CJJsbError$jsbDisableHistoryError$1.INSTANCE;
        CJJsbError$jsbOpenAppBySchemeError$1 r145 = CJJsbError$jsbOpenAppBySchemeError$1.INSTANCE;
        CJJsbError$jsbCheckAppInstalledError$1 r146 = CJJsbError$jsbCheckAppInstalledError$1.INSTANCE;
        CJJsbError$jsbIsAppInstalledError$1 r147 = CJJsbError$jsbIsAppInstalledError$1.INSTANCE;
        CJJsbError$jsbOpenPageError$1 r148 = CJJsbError$jsbOpenPageError$1.INSTANCE;
        CJJsbError$jsbHideLoadingError$1 r149 = CJJsbError$jsbHideLoadingError$1.INSTANCE;
        CJJsbError$jsbShowLoadingError$1 r150 = CJJsbError$jsbShowLoadingError$1.INSTANCE;
        CJJsbError$jsbPayError$1 r151 = CJJsbError$jsbPayError$1.INSTANCE;
        CJJsbError$jsbCloseCallbackError$1 r152 = CJJsbError$jsbCloseCallbackError$1.INSTANCE;
        CJJsbError$jsbSetVisibleError$1 r153 = CJJsbError$jsbSetVisibleError$1.INSTANCE;
        CJJsbError$jsbBackBlockError$1 r154 = CJJsbError$jsbBackBlockError$1.INSTANCE;
        CJJsbError$jsbDisableDragBackError$1 r155 = CJJsbError$jsbDisableDragBackError$1.INSTANCE;
        CJJsbError$jsbSetWebviewInfoError$1 r156 = CJJsbError$jsbSetWebviewInfoError$1.INSTANCE;
        CJJsbError$jsbGoH5Error$1 r157 = CJJsbError$jsbGoH5Error$1.INSTANCE;
        CJJsbError$jsbCJModalViewError$1 r158 = CJJsbError$jsbCJModalViewError$1.INSTANCE;
        CJJsbError$jsbDisallowCaptureError$1 r159 = CJJsbError$jsbDisallowCaptureError$1.INSTANCE;
        CJJsbError$jsbCloseWebviewError$1 r160 = CJJsbError$jsbCloseWebviewError$1.INSTANCE;
        CJJsbError$jsbDeviceInfoError$1 r161 = CJJsbError$jsbDeviceInfoError$1.INSTANCE;
        CJJsbError$jsbGetMegaObjectError$1 r162 = CJJsbError$jsbGetMegaObjectError$1.INSTANCE;
        CJJsbError$jsbSetShareInfoError$1 r163 = CJJsbError$jsbSetShareInfoError$1.INSTANCE;
        CJJsbError$jsbPia_rendering_executeError$1 r164 = CJJsbError$jsbPia_rendering_executeError$1.INSTANCE;
        CJJsbError$jsbGoRechargeError$1 r165 = CJJsbError$jsbGoRechargeError$1.INSTANCE;
        CJJsbError$jsbCopyToClipboardError$1 r166 = CJJsbError$jsbCopyToClipboardError$1.INSTANCE;
        CJJsbError$jsbPublishEventError$1 r167 = CJJsbError$jsbPublishEventError$1.INSTANCE;
        CJJsbError$jsbPreconnectError$1 r168 = CJJsbError$jsbPreconnectError$1.INSTANCE;
        CJJsbError$jsbFaceVerifyFullPageError$1 r169 = CJJsbError$jsbFaceVerifyFullPageError$1.INSTANCE;
        CJJsbError$jsbAiError$1 r170 = CJJsbError$jsbAiError$1.INSTANCE;
    }

    public final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbName");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L37
        Field[] r102 = CJJsbError.class.getDeclaredFields();     // Catch: Throwable -> L37
        int r103 = r102.length;     // Catch: Throwable -> L37
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L35;
        Field r105 = r102[r104];     // Catch: Throwable -> L37
        r105.setAccessible(true);     // Catch: Throwable -> L37
        JSBError r106 = (JSBError) r105.getAnnotation(JSBError.class);     // Catch: Throwable -> L37
        if (r106 == null) goto L34;
        b r107 = null;
        if (Intrinsics.areEqual(r100, r106.fieldName()) == false) goto L11;
        CJJsbError r108 = this;
    L12:
        if (r108 == null) goto L34;
        Object r109 = r105.get(this);     // Catch: Throwable -> L37
        if (r109 == null) goto L33;
        if (TypeIntrinsics.isFunctionOfArity(r109, 0) == true) goto L19;
        r109 = null;
    L19:
        if (r109 == null) goto L33;
        if (TypeIntrinsics.isFunctionOfArity(r109, 0) == false) goto L23;
        Function0 r110 = (Function0) r109;     // Catch: Throwable -> L37
    L24:
        if (r110 == null) goto L33;
        Object r111 = r110.invoke();     // Catch: Throwable -> L37
        if (r111 == null) goto L33;
        if ((r111 instanceof b) == false) goto L30;
        r107 = (b) r111;     // Catch: Throwable -> L37
    L30:
        if (r107 == null) goto L33;
        return r107;
    L23:
        r110 = null;
    L33:
        return (b) f202602b.getValue();
    L11:
        r108 = null;
    L34:
        r104 = r104 + 1;     // Catch: Throwable -> L37
        goto L4
    L35:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L40:
        return (b) f202602b.getValue();
    L37:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    }
}
