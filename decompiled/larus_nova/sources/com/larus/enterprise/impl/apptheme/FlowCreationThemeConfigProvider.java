package com.larus.enterprise.impl.apptheme;

import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowCreationThemeConfigProvider;", "Lcom/larus/platform/api/IFlowCreationThemeConfigProvider;", "<init>", "()V", "disableFeature", "", "entryView", "Landroid/view/View;", "srcFeature", "Lkotlin/Function0;", "", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCreationThemeConfigProvider implements IFlowCreationThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowCreationThemeConfigProvider() {
    }

    @Override // com.larus.platform.api.IFlowCreationThemeConfigProvider
    public final boolean a(CreationOperateContainerView r100, AdaptThemeFeatureKey r101) {
        Intrinsics.checkNotNullParameter(r101, "featureKey");
        boolean r102 = n0.f365775a.b();
        FLogger.f375446a.i("FlowProfileThemeConfigProvider", "disableFeature to view isInEnterpriseMode=" + r102 + " featureKey=" + r101);
        if (r102 == false) goto L8;
        if (r100 == null) goto L10;
        e1.o(r100);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    @Override // com.larus.platform.api.IFlowCreationThemeConfigProvider
    public final boolean b(CreateBotButton r100, Function0 r101, AdaptThemeFeatureKey r102) {
        Intrinsics.checkNotNullParameter(r101, "srcFeature");
        Intrinsics.checkNotNullParameter(r102, "featureKey");
        boolean r103 = n0.f365775a.b();
        FLogger.f375446a.i("FlowProfileThemeConfigProvider", "disableFeature to view isInEnterpriseMode=" + r103 + " featureKey=" + r102);
        if (r103 == false) goto L8;
        if (r100 == null) goto L10;
        e1.o(r100);
        return true;
    L10:
        return true;
    L8:
        r101.invoke();
        return false;
    }
}
