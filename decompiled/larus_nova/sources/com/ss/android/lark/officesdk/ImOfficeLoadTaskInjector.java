package com.ss.android.lark.officesdk;

import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.flow.notification.offline.InitFlowReportSameDeviceJudgeTask;
import com.ss.android.lark.flow.notification.online.InitFlowNotificationTask;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitFullImSdkTask;
import com.ss.android.lark.officesdk.integrator.im.InitMixFeedMoltenCacheTask;
import com.ss.android.lark.officesdk.integrator.im.OfficeInitSDKLanguageTask;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class ImOfficeLoadTaskInjector implements com.ss.android.lark.officesdk.launcher.load.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433088a;

    @Inject
    public ImOfficeLoadTaskInjector() {
        this.f433088a = LazyKt.lazy(ImOfficeLoadTaskInjector$isLaunchIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.load.a
    public final OfficeBizType getBizType() {
        return OfficeBizType.IM;
    }

    @Override // com.ss.android.lark.officesdk.launcher.load.a
    public final void a(com.ss.android.lark.officesdk.launcher.load.c r100) {
        Intrinsics.checkNotNullParameter(r100, "collector");
        if (((Boolean) this.f433088a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        r100.a(new InitDbCorruptPushTask());
        r100.a(new InitImSdkServiceTask());
        r100.a(new InitFullImSdkTask());
        r100.a(new OfficeInitAvatarLoaderTask());
        r100.a(new OfficeInitSDKLanguageTask());
        r100.a(new UpdateEmojiTask());
        r100.a(new InitFlowNotificationTask());
        r100.a(new InitMixFeedMoltenCacheTask());
        r100.a(new InitFlowReportSameDeviceJudgeTask());
    }
}
