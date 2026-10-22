package com.bytedance.ee.bear.templates.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\"\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/templates/recommend/NewRecommendTemplateFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "parentToken", "", "module", "subModule", "isFolder", "", "isFromEmpty", "showTitleBg", "createSelectResult", "Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;", "spaceId", "presenter", "Lcom/bytedance/ee/bear/templates/recommend/NewRecommendTemplatePresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onDestroyView", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewRecommendTemplateFragment extends BaseFragment {
    public static final /* synthetic */ int l = 0;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public CreateSelectResult i;
    public String j;
    public g k;

    public static final class a {
    }

    static {
    }

    public NewRecommendTemplateFragment() {
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = true;
        CreateSelectResult.CREATOR.getClass();
        this.i = CreateSelectResult.a.b();
        this.j = "";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        g r0 = this.k;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        this.e = r5.getString("extra_parent_token", "");
        this.f = r5.getString("extra_module", "");
        this.g = r5.getString("extra_sub_module", "");
        this.h = r5.getBoolean("extra_show_title_bg", true);
        CreateSelectResult r0 = r5.getParcelable("CREATION_LOCATION");
        if (r0 != null) goto L7;
        CreateSelectResult.CREATOR.getClass();
        r0 = CreateSelectResult.a.b();
    L7:
        this.i = r0;
        this.j = r5.getString("SPACE_ID", "");
        return;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        NewRecommendTemplateModel r2 = new NewRecommendTemplateModel(this);
        Context r13 = getContext();
        Intrinsics.checkNotNull(r13);
        g r14 = new g(r2, new i(r13, this, r11, this.h), this, this.f, this.g, this.e, this.i, this.j);
        this.k = r14;
        r14.create();
    }

    public final void onActivityResult(int r50, int r51, Intent r52) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r50, r51, r52);
        tt5.a.h("NewRecommendTemplateFragment", "onActivityResult()...");
        g r3 = this.k;
        if (r3 == null) goto L16;
        tt5.a.h("NewRecommendTemplatePresenter", "onActivityResult()...resultCode = " + r51);
        if (r51 != (-1)) goto L17;
        if (r52 == null) goto L9;
        String r0 = r52.getStringExtra("templateId");
        if (r0 == null) goto L9;
    L10:
        String r6 = r0;
        if (r52 == null) goto L13;
        int r8 = r52.getIntExtra("templateType", -1);
    L14:
        ((com.bytedance.ee.bear.templates.recommend.a) r3.getModel()).n7(new TemplateV4(r6, null, r8, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, false, null, 0, 0, null, -6, 7, null), false);
        return;
    L13:
        r8 = -1;
    L9:
        r0 = "";
        goto L10
    L17:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564268, r3, false);
    }
}
