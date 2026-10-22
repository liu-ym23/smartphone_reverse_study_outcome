package com.larus.enterprise.impl.apptheme;

import android.view.View;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\u0006\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowSettingThemeConfigProvider;", "Lcom/larus/platform/api/IFlowSettingThemeConfigProvider;", "<init>", "()V", "getHelpFeedbackUrl", "", "disableFeature", "", "itemView", "Landroid/view/View;", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "srcFeature", "Lkotlin/Function0;", "", "shouldDisableFeature", "isInEnterpriseMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSettingThemeConfigProvider implements IFlowSettingThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowSettingThemeConfigProvider() {
    }

    @Override // com.larus.platform.api.IFlowSettingThemeConfigProvider
    public final String c() {
        if (n0.f365775a.b() == true) goto L5;
        return "";
    L5:
        int r100 = pa9.a.f528395a;
        return ga9.a.e("enterprise_help_feedback_url", "");
    }

    @Override // com.larus.platform.api.IFlowSettingThemeConfigProvider
    public final boolean b(View r100, AdaptThemeFeatureKey r101) {
        Intrinsics.checkNotNullParameter(r101, "featureKey");
        FLogger.f375446a.d("FlowSettingThemeConfigProvider", "disableFeature featureKey=" + r101);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (n0.f365775a.b() == true) goto L9;
    L13:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L18;
        e1.o(r100);
        return true;
    L18:
        return false;
    L9:
        if (r101 == AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK) goto L11;
    L14:
        r102 = true;
        goto L15
    L11:
        if (StringsKt.isBlank(c()) == false) goto L13;
        goto L13
    }

    @Override // com.larus.platform.api.IFlowSettingThemeConfigProvider
    public final boolean a(Function0<Unit> r100, Function0<Unit> r101, AdaptThemeFeatureKey r102) {
        Intrinsics.checkNotNullParameter(r102, "featureKey");
        boolean r103 = n0.f365775a.b();
        FLogger.f375446a.i("FlowSettingThemeConfigProvider", "disableFeature to srcFeature>disableFeature isInEnterpriseMode=" + r103 + " featureKey=" + r102);
        if (r103 == true) goto L6;
    L10:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L15;
        r101.invoke();
        return true;
    L15:
        r100.invoke();
        return false;
    L6:
        if (r102 == AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK) goto L8;
    L11:
        r104 = true;
        goto L12
    L8:
        if (StringsKt.isBlank(c()) == false) goto L10;
        goto L10
    }
}
