package com.bytedance.ee.bear.templates.topic;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/templates/topic/BaseTopicFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/templates/topic/BaseTopicPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initMVP", "rootView", "getIModel", "Lcom/bytedance/ee/bear/templates/topic/TopicModel;", "getIView", "Lcom/bytedance/ee/bear/templates/topic/ITopicView;", "getIPresenter", "model", "onDestroyView", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTopicFragment extends Fragment {
    public BaseTopicPresenter d;

    public abstract TopicModel S90();

    public abstract BaseTopicPresenter T90(TopicModel r1, e r2);

    public abstract BaseTopicView U90(View r1);

    public final void onDestroy() {
        TemplateReportV2 r0 = TemplateReportV2.a;
        Intrinsics.checkNotNullParameter("ccm_template_systemcenter_view_click", "<set-?>");
        TemplateReportV2.b = "ccm_template_systemcenter_view_click";
        super.onDestroy();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        BaseTopicPresenter r0 = this.d;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public BaseTopicFragment() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        BaseTopicPresenter r3 = this.d;
        if (r3 == null) goto L8;
        e r4 = r3.c;
        if (r4 == null) goto L9;
        r4.b();
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BaseTopicPresenter r4 = T90(S90(), U90(r2));
        this.d = r4;
        if (r4 == null) goto L6;
        r4.create();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        TemplateReportV2 r5 = TemplateReportV2.a;
        Intrinsics.checkNotNullParameter("ccm_template_banner_view_click", "<set-?>");
        TemplateReportV2.b = "ccm_template_banner_view_click";
        return r2.inflate(2131561252, r3, false);
    }
}
