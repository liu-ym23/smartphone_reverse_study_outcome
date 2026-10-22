package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.e;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybGuestLinkGetAction;", "", "Lch6/e;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CheckChannel", "GetLinkState", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybGuestLinkGetAction extends Enum<MultiLinkHybGuestLinkGetAction> implements e {
    public static final MultiLinkHybGuestLinkGetAction CheckChannel = null;
    public static final a Companion = null;
    public static final MultiLinkHybGuestLinkGetAction GetLinkState = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybGuestLinkGetAction[] f254887a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    static {
        MultiLinkHybGuestLinkGetAction r100 = new MultiLinkHybGuestLinkGetAction("CheckChannel", 0, "check_channel");
        CheckChannel = r100;
        MultiLinkHybGuestLinkGetAction r101 = new MultiLinkHybGuestLinkGetAction("GetLinkState", 1, "get_link_state");
        GetLinkState = r101;
        f254887a = new MultiLinkHybGuestLinkGetAction[]{r100, r101};
        Companion = new a();
    }

    public static MultiLinkHybGuestLinkGetAction valueOf(String r100) {
        return (MultiLinkHybGuestLinkGetAction) r27.a.a(MultiLinkHybGuestLinkGetAction.class, r100);
    }

    public static MultiLinkHybGuestLinkGetAction[] values() {
        return (MultiLinkHybGuestLinkGetAction[]) f254887a.clone();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public MultiLinkHybGuestLinkGetAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionType = r102;
    }
}
