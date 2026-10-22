package com.ss.android.lark.passport.flow.mfa;

import com.lynx.tasm.LynxError;
import com.ss.android.lark.passport.flow.core.network.PassportHttpBusinessException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpDeviceIdException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpStatusException;
import com.ss.android.lark.passport.flow.core.network.PassportHttpTransportException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437896a = 0;

    static {
    }

    public static FlowMfaError d() {
        return new FlowMfaError(FlowMfaErrorCategory.UNSUPPORTED_IDP_CHANNEL, "Only BIDP is supported by Flow MFA", null, null, null, null, 60, null);
    }

    public static FlowMfaError a(Throwable r110) {
        Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
        if ((r110 instanceof FlowMfaException) == false) goto L6;
        return ((FlowMfaException) r110).getError();
    L6:
        if ((r110 instanceof CancellationException) == false) goto L9;
        return new FlowMfaError(FlowMfaErrorCategory.USER_CANCEL, "MFA flow was cancelled", null, null, null, null, 60, null);
    L9:
        if ((r110 instanceof PassportHttpStatusException) == false) goto L23;
        PassportHttpStatusException r100 = (PassportHttpStatusException) r110;
        if (r100.getStatusCode() != 401) goto L13;
        FlowMfaErrorCategory r111 = FlowMfaErrorCategory.AUTH_EXPIRED;
    L14:
        FlowMfaErrorCategory r101 = r111;
        String r112 = r100.getServerMessage();
        if (r112 != null) goto L17;
        r112 = "Passport server returned HTTP " + r100.getStatusCode();
    L17:
        String r102 = r112;
        Integer r113 = r100.getServerCode();
        if (r113 == null) goto L20;
        int r114 = r113.intValue();
    L21:
        FlowMfaError r103 = new FlowMfaError(r101, r102, r100, null, Integer.valueOf(r114), r100.getLogId(), 8, null);
    L51:
        return r103;
    L20:
        r114 = r100.getStatusCode();
        goto L21
    L13:
        r111 = FlowMfaErrorCategory.SERVER;
        goto L14
    L23:
        if ((r110 instanceof PassportHttpBusinessException) == false) goto L30;
        FlowMfaErrorCategory r104 = FlowMfaErrorCategory.SERVER;
        String r105 = r110.getMessage();
        if (r105 != null) goto L27;
        r105 = "Passport business response requires unsupported handling";
    L27:
        PassportHttpBusinessException r106 = (PassportHttpBusinessException) r110;
        int r115 = r106.getCode();
        r103 = new FlowMfaError(r104, r105, r106, r106.getNextStep(), Integer.valueOf(r115), r106.getLogId());
        goto L51
    L30:
        if ((r110 instanceof PassportHttpDeviceIdException) == false) goto L36;
        FlowMfaErrorCategory r107 = FlowMfaErrorCategory.NETWORK;
        String r108 = r110.getMessage();
        if (r108 != null) goto L34;
        r108 = "Passport device id is unavailable";
    L34:
        r103 = new FlowMfaError(r107, r108, r110, null, null, null, 56, null);
        goto L51
    L36:
        if ((r110 instanceof PassportHttpTransportException) == false) goto L39;
        PassportHttpTransportException r109 = (PassportHttpTransportException) r110;
        return new FlowMfaError(FlowMfaErrorCategory.NETWORK, "Passport network request failed", r109, null, r109.getRustCode(), r109.getLogId(), 8, null);
    L39:
        if ((r110 instanceof IOException) == false) goto L44;
        FlowMfaErrorCategory r116 = FlowMfaErrorCategory.NETWORK;
        String r117 = r110.getMessage();
        if (r117 != null) goto L43;
        r117 = "Passport network request failed";
    L43:
        r103 = new FlowMfaError(r116, r117, r110, null, null, null, 56, null);
        goto L51
    L44:
        String r118 = r110.getMessage();
        if (r118 != null) goto L48;
        r118 = "Flow MFA failed";
    L48:
        return b(r118, r110);
    }

    public static FlowMfaError c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        return new FlowMfaError(FlowMfaErrorCategory.INVALID_ARGUMENT, r110, null, null, null, null, 60, null);
    }

    public static FlowMfaError e(String r110) {
        return new FlowMfaError(FlowMfaErrorCategory.UNSUPPORTED_STEP, "Unsupported MFA step", null, r110, null, null, 52, null);
    }

    public static FlowMfaError b(String r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r110, "message");
        return new FlowMfaError(FlowMfaErrorCategory.INTERNAL, r110, r111, null, null, null, 56, null);
    }
}
