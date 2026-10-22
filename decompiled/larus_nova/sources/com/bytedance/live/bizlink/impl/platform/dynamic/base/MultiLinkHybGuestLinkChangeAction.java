package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.b;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybGuestLinkChangeAction;", "", "Lch6/b;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OwnerJoinChannel", "OnlookerEnterChannel", "OwnerFinishChannel", "OnlookerLeaveChannel", "ReleaseRtcEngine", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybGuestLinkChangeAction extends Enum<MultiLinkHybGuestLinkChangeAction> implements b {
    public static final a Companion = null;
    public static final MultiLinkHybGuestLinkChangeAction OnlookerEnterChannel = null;
    public static final MultiLinkHybGuestLinkChangeAction OnlookerLeaveChannel = null;
    public static final MultiLinkHybGuestLinkChangeAction OwnerFinishChannel = null;
    public static final MultiLinkHybGuestLinkChangeAction OwnerJoinChannel = null;
    public static final MultiLinkHybGuestLinkChangeAction ReleaseRtcEngine = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybGuestLinkChangeAction[] f254886a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    static {
        MultiLinkHybGuestLinkChangeAction r100 = new MultiLinkHybGuestLinkChangeAction("OwnerJoinChannel", 0, "owner_join_channel");
        OwnerJoinChannel = r100;
        MultiLinkHybGuestLinkChangeAction r101 = new MultiLinkHybGuestLinkChangeAction("OnlookerEnterChannel", 1, "onlooker_enter_channel");
        OnlookerEnterChannel = r101;
        MultiLinkHybGuestLinkChangeAction r102 = new MultiLinkHybGuestLinkChangeAction("OwnerFinishChannel", 2, "owner_finish_channel");
        OwnerFinishChannel = r102;
        MultiLinkHybGuestLinkChangeAction r103 = new MultiLinkHybGuestLinkChangeAction("OnlookerLeaveChannel", 3, "onlooker_leave_channel");
        OnlookerLeaveChannel = r103;
        MultiLinkHybGuestLinkChangeAction r104 = new MultiLinkHybGuestLinkChangeAction("ReleaseRtcEngine", 4, "release_rtc_engine");
        ReleaseRtcEngine = r104;
        f254886a = new MultiLinkHybGuestLinkChangeAction[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static MultiLinkHybGuestLinkChangeAction valueOf(String r100) {
        return (MultiLinkHybGuestLinkChangeAction) r27.a.a(MultiLinkHybGuestLinkChangeAction.class, r100);
    }

    public static MultiLinkHybGuestLinkChangeAction[] values() {
        return (MultiLinkHybGuestLinkChangeAction[]) f254886a.clone();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public MultiLinkHybGuestLinkChangeAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionType = r102;
    }
}
