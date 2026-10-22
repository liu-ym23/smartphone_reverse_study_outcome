package com.larus.asr;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b2 implements n58.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.platform.api.f0 f287202a;

    public static final class a {
    }

    static {
    }

    public b2() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.P();
        ChatServiceImpl r101 = ChatServiceImpl.f346124a;
    L6:
        this.f287202a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // n58.b
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "convId");
        com.larus.platform.api.f0 r102 = this.f287202a;
        if (r102 == null) goto L5;
        r102.c(r100, r101);
    L5:
        FLogger.f375446a.b("ASR", "AsrStart", r100);
    }

    @Override // n58.b
    public final void a(String r110, AsrCallBackType r111, String r112, String r113, long r114, String r115, int r116, String r117, String r210, String r211) {
        Intrinsics.checkNotNullParameter(r115, "vid");
        if (r110 != null) goto L5;
        return;
    L5:
        AsrCallBackType r100 = AsrCallBackType.AS_SUCCESS;
        if (r111 != r100) goto L14;
        if (r112 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == true) goto L14;
    L17:
        if (r111 != r100) goto L19;
    L28:
        if (r111 != r100) goto L30;
    L36:
        FLogger.f375446a.c("ASR", r111.name(), r110);
        return;
    L30:
        if (r111 == AsrCallBackType.ASR_CANCEL) goto L36;
        AsrCallBackType r102 = AsrCallBackType.ASR_FAILED_TOKEN;
        if (r111 == r102) goto L36;
        if (r111 == r102) goto L36;
        if (r111 == AsrCallBackType.ASR_FAILED) goto L36;
        return;
    L19:
        if (r111 == AsrCallBackType.ASR_CANCEL) goto L28;
        if (r111 == AsrCallBackType.ASR_FAILED_TOKEN) goto L28;
        com.larus.platform.api.f0 r103 = this.f287202a;
        if (r103 == null) goto L28;
        if (r113 != null) goto L26;
        String r104 = "";
    L27:
        r103.b(r110, r104, r114, r115);
        goto L28
    L26:
        r104 = r113;
        goto L27
    L9:
        if (r112.length() == 0) goto L12;
        r101 = false;
    L14:
        com.larus.platform.api.f0 r105 = this.f287202a;
        if (r105 == null) goto L17;
        r105.setScene(r110);
        goto L17
    }
}
