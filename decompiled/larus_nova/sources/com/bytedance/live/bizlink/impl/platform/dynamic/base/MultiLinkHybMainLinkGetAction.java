package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.e;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMainLinkGetAction;", "", "Lch6/e;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMainLinkGetAction extends Enum<MultiLinkHybMainLinkGetAction> implements e {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMainLinkGetAction[] f254891a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    static {
        f254891a = new MultiLinkHybMainLinkGetAction[0];
        Companion = new a();
    }

    public static MultiLinkHybMainLinkGetAction valueOf(String r100) {
        return (MultiLinkHybMainLinkGetAction) r27.a.a(MultiLinkHybMainLinkGetAction.class, r100);
    }

    public static MultiLinkHybMainLinkGetAction[] values() {
        return (MultiLinkHybMainLinkGetAction[]) f254891a.clone();
    }

    public final String getActionType() {
        return this.actionType;
    }
}
