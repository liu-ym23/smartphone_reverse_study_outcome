package com.bytedance.android.livesdk.liveinit.community;

import com.bytedance.android.live.core.monitor.trace.b;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profile.api.IProfileService;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.customize.DouyinAccountFollowTool;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.dslservice.DSLServiceImpl;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.liveinit.a;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.service.RoomReadOnlyHookSet;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/community/LiveCommunityBaseUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "CLASS_LIVE_SDK_PROJECT_MODE_SERVICE", "", "CLASS_LIVE_SDK_PROJECT_MODE_SERVICE_DUMMY", "CLASS_SaaSEmptyStub", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommunityBaseUnit extends AbsLiveInitUnit {
    private static final String CLASS_LIVE_SDK_PROJECT_MODE_SERVICE = "com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceImpl";
    private static final String CLASS_LIVE_SDK_PROJECT_MODE_SERVICE_DUMMY = "com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceDummy";
    private static final String CLASS_SaaSEmptyStub = "com.bytedance.android.livesdk.utils.SaaSEmptyStub";
    public static final LiveCommunityBaseUnit INSTANCE = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.liveinit.community.LiveCommunityBaseUnit$initialize$7, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/customize/IInternalFollowTool;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass7 extends Lambda implements Function0<IInternalFollowTool> {
        public static final AnonymousClass7 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass7();
        }

        public AnonymousClass7() {
            super(0);
        }

        public final IInternalFollowTool invoke() {
            return new DouyinAccountFollowTool();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1319invoke() {
            return invoke();
        }
    }

    static {
        INSTANCE = new LiveCommunityBaseUnit();
    }

    public void initialize() {
        a.c(CLASS_LIVE_SDK_PROJECT_MODE_SERVICE, CLASS_LIVE_SDK_PROJECT_MODE_SERVICE_DUMMY);
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getLazyInitTopService() == true) goto L5;
        a.b(IBaseLiveActionHandler.class, AnonymousClass1.INSTANCE);
    L5:
        k.m(ILiveSDKService.class, AnonymousClass2.INSTANCE);
        k.m(IHostFeed.class, AnonymousClass3.INSTANCE);
        k.m(IProfileService.class, AnonymousClass4.INSTANCE);
        k.m(IUserServiceV2.class, AnonymousClass5.INSTANCE);
        a.b(IRoomModuleService.class, AnonymousClass6.INSTANCE);
        new RoomReadOnlyHookSet();
        k.m(b.class, AnonymousClass8.INSTANCE);
        a.b(ILiveAudienceSDKService.class, AnonymousClass9.INSTANCE);
        a.b(IInteractService.class, AnonymousClass10.INSTANCE);
        k.l(IDSLManagerService.class, new DSLServiceImpl());
    }

    private LiveCommunityBaseUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveCommunityInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
