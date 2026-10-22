package com.bytedance.ee.bear.lark;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/lark/NewerOnboardingBannerAbTestExperiment;", "Lcom/ss/android/lark/abtest/api/experiment/LarkExperimentConfig;", "", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "getLarkExperimentInfo", "Lcom/ss/android/lark/abtest/api/experiment/LarkExperimentInfo;", "getDefault", "isSticky", "", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewerOnboardingBannerAbTestExperiment extends iua.a<String> implements NonProguard {
    public static final a Companion = null;
    public static final String GUIDE_FLOW_BANNER = "guide_flow_banner";
    private static final String KEY = "new_user_onboarding_banner_ab";
    public static final String TEMPLATE_RECOMMEND_BANNER = "template_recommend_banner";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // iua.a
    /* JADX INFO: renamed from: getDefault, reason: avoid collision after fix types in other method */
    public String getDefault2() {
        return GUIDE_FLOW_BANNER;
    }

    @Override // iua.a
    public boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public iua.b getLarkExperimentInfo() {
        return new iua.b(KEY, "套件内云空间新用户引导AB-Test");
    }

    @Override // iua.a
    public /* bridge */ /* synthetic */ String getDefault() {
        return getDefault2();
    }

    public NewerOnboardingBannerAbTestExperiment() {
    }
}
