package com.larus.im.internal.jni.service;

import com.larus.im.internal.jni.bean.OMNIAVRTCTokenRequest;
import com.larus.im.internal.jni.bean.OMNIAVRTCTokenResponse;
import juc.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wt7.a;
import wt7.c;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a:\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\t¨\u0006\r"}, d2 = {"prefetchTokens", "", "Lcom/larus/im/internal/jni/service/OmniTokenService;", "request", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenRequest;", "getToken", "callback", "Lcom/larus/im/internal/jni/service/OmniTokenService$Callback;", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenResponse;", "onFailed", "", "omnisdk-av_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniTokenServiceKt {
    public static final void prefetchTokens(OmniTokenService r100, OMNIAVRTCTokenRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "request");
        c r102 = a.f561230a;
        d<OMNIAVRTCTokenRequest> r103 = OMNIAVRTCTokenRequest.Companion.serializer();
        r102.getClass();
        String r104 = c.b(r101, r103);
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r100.prefetchTokens(r104);
    }

    public static final void getToken(OmniTokenService r100, OMNIAVRTCTokenRequest r101, OmniTokenService.Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "callback");
        c r103 = a.f561230a;
        d<OMNIAVRTCTokenRequest> r104 = OMNIAVRTCTokenRequest.Companion.serializer();
        r103.getClass();
        String r105 = c.b(r101, r104);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r100.getToken(r105, r102);
    }

    public static final void getToken(OmniTokenService r100, OMNIAVRTCTokenRequest r101, final Function1<? super OMNIAVRTCTokenResponse, Unit> r102, final Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFailed");
        getToken(r100, r101, new AnonymousClass1(r102, r103));
    }
}
