package com.larus.enterprise.impl.apptheme;

import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowOfficeThemeConfigProvider;", "Lcom/larus/platform/api/IFlowOfficeThemeConfigProvider;", "<init>", "()V", "disableFeature", "", "srcFeature", "Lkotlin/Function0;", "", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowOfficeThemeConfigProvider implements IFlowOfficeThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowOfficeThemeConfigProvider() {
    }

    @Override // com.larus.platform.api.IFlowOfficeThemeConfigProvider
    public final boolean a(Function0<Unit> r100, AdaptThemeFeatureKey r101) {
        Intrinsics.checkNotNullParameter(r101, "featureKey");
        boolean r102 = n0.f365775a.b();
        FLogger.f375446a.i("FlowChatThemeConfigProvider", "disableFeature to srcFeature isInEnterpriseMode=" + r102 + " featureKey=" + r101);
        if (r102 == false) goto L6;
        return true;
    L6:
        r100.invoke();
        return false;
    }
}
