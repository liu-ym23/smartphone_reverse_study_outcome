package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.b;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMainLinkChangeAction;", "", "Lch6/b;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AudienceApplyLink", "PermitLink", "InviteLink", "AudienceReplyLink", "AudienceApplySilenceLink", "JoinLink", "KickOut", "CloseLink", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMainLinkChangeAction extends Enum<MultiLinkHybMainLinkChangeAction> implements b {
    public static final MultiLinkHybMainLinkChangeAction AudienceApplyLink = null;
    public static final MultiLinkHybMainLinkChangeAction AudienceApplySilenceLink = null;
    public static final MultiLinkHybMainLinkChangeAction AudienceReplyLink = null;
    public static final MultiLinkHybMainLinkChangeAction CloseLink = null;
    public static final a Companion = null;
    public static final MultiLinkHybMainLinkChangeAction InviteLink = null;
    public static final MultiLinkHybMainLinkChangeAction JoinLink = null;
    public static final MultiLinkHybMainLinkChangeAction KickOut = null;
    public static final MultiLinkHybMainLinkChangeAction PermitLink = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMainLinkChangeAction[] f254890a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    public static MultiLinkHybMainLinkChangeAction valueOf(String r100) {
        return (MultiLinkHybMainLinkChangeAction) r27.a.a(MultiLinkHybMainLinkChangeAction.class, r100);
    }

    public static MultiLinkHybMainLinkChangeAction[] values() {
        return (MultiLinkHybMainLinkChangeAction[]) f254890a.clone();
    }

    static {
        MultiLinkHybMainLinkChangeAction r100 = new MultiLinkHybMainLinkChangeAction("AudienceApplyLink", 0, "audience_apply_link");
        AudienceApplyLink = r100;
        MultiLinkHybMainLinkChangeAction r101 = new MultiLinkHybMainLinkChangeAction("PermitLink", 1, "permit_link");
        PermitLink = r101;
        MultiLinkHybMainLinkChangeAction r102 = new MultiLinkHybMainLinkChangeAction("InviteLink", 2, "invite_link");
        InviteLink = r102;
        MultiLinkHybMainLinkChangeAction r103 = new MultiLinkHybMainLinkChangeAction("AudienceReplyLink", 3, "audience_reply_link");
        AudienceReplyLink = r103;
        MultiLinkHybMainLinkChangeAction r104 = new MultiLinkHybMainLinkChangeAction("AudienceApplySilenceLink", 4, "audience_apply_silence_link");
        AudienceApplySilenceLink = r104;
        MultiLinkHybMainLinkChangeAction r105 = new MultiLinkHybMainLinkChangeAction("JoinLink", 5, "join_link");
        JoinLink = r105;
        MultiLinkHybMainLinkChangeAction r106 = new MultiLinkHybMainLinkChangeAction("KickOut", 6, "kick_out");
        KickOut = r106;
        MultiLinkHybMainLinkChangeAction r107 = new MultiLinkHybMainLinkChangeAction("CloseLink", 7, "close_link");
        CloseLink = r107;
        f254890a = new MultiLinkHybMainLinkChangeAction[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public MultiLinkHybMainLinkChangeAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionType = r102;
    }
}
