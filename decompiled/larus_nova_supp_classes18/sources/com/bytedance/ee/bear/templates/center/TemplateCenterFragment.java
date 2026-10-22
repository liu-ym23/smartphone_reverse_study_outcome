package com.bytedance.ee.bear.templates.center;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/TemplateCenterFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterPresenter;", "openTemplateCenter", "", "viewModel", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onDestroyView", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCenterFragment extends BaseFragment implements sa5.a {
    public static final /* synthetic */ int h = 0;
    public f e;
    public String f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final TemplateCenterViewModel U90() {
        return (TemplateCenterViewModel) this.g.getValue();
    }

    public TemplateCenterFragment() {
        this.f = "";
        this.g = LazyKt.lazy(new TemplateCenterFragment$viewModel$2(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        f r0 = this.e;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).a("ccm_template_center");
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Bundle r10 = getArguments();
        String r0 = "";
        if (r10 == null) goto L6;
        String r11 = r10.getString("extra_open_template_center", "");
        if (r11 == null) goto L6;
    L7:
        this.f = r11;
        TemplateCenterViewModel.a r12 = TemplateCenterViewModel.Companion;
        Bundle r1 = getArguments();
        long r2 = -1;
        if (r1 == null) goto L10;
        r2 = r1.getLong("extra_open_template_center_category_id", -1);
    L10:
        r12.getClass();
        TemplateCenterViewModel.access$setCATEGORY_ID$cp(r2);
        boolean r3 = false;
        boolean r4 = true;
        if (StringsKt.contains$default(this.f, "custom", false, 2, null) == false) goto L14;
        TemplateCenterViewModel.access$setLAST_INDEX$cp(1);
    L25:
        Bundle r13 = getArguments();
        if (r13 == null) goto L28;
        int r14 = r13.getInt("objType", -1);
    L29:
        if (r14 == (-1)) goto L31;
        U90().saveFilter(r14);
    L31:
        TemplateCenterViewModel r5 = U90();
        Bundle r6 = getArguments();
        if (r6 == null) goto L35;
        String r7 = r6.getString("MODULE");
        if (r7 == null) goto L35;
    L36:
        r5.setModule(r7);
        TemplateCenterViewModel r8 = U90();
        Bundle r15 = getArguments();
        if (r15 == null) goto L40;
        String r16 = r15.getString("enterSource", "");
        if (r16 == null) goto L40;
    L41:
        r8.setEnterSource(r16);
        TemplateCenterViewModel r17 = U90();
        Bundle r18 = getArguments();
        if (r18 == null) goto L45;
        String r19 = r18.getString("template_source", "");
        if (r19 == null) goto L45;
    L46:
        r17.setTemplateSource(r19);
        TemplateCenterViewModel r20 = U90();
        Bundle r21 = getArguments();
        if (r21 == null) goto L49;
        boolean r22 = r21.getBoolean("createblank", false);
    L50:
        r20.setCreateBlank(r22);
        U90().setInitFilterType(r14);
        TemplateCenterViewModel r23 = U90();
        if (r14 == (-1)) goto L58;
        Bundle r24 = getArguments();
        if (r24 == null) goto L55;
        boolean r25 = r24.getBoolean("fixedFilter", false);
    L56:
        if (r25 == false) goto L58;
    L59:
        r23.setFixedFilter(r4);
        TemplateCenterViewModel r26 = U90();
        Bundle r27 = getArguments();
        if (r27 == null) goto L62;
        r3 = r27.getBoolean("key_folder_version");
    L62:
        r26.setSpaceV2(r3);
        TemplateCenterViewModel r28 = U90();
        Bundle r29 = getArguments();
        if (r29 == null) goto L66;
        CreateSelectResult r30 = (CreateSelectResult) r29.getParcelable("CREATION_LOCATION");
        if (r30 == null) goto L66;
    L67:
        r28.setCreateSelectResult(r30);
        TemplateCenterViewModel r31 = U90();
        Bundle r32 = getArguments();
        if (r32 == null) goto L73;
        String r33 = r32.getString("SPACE_ID", "");
        if (r33 == null) goto L73;
        r0 = r33;
    L73:
        r31.setSpaceId(r0);
        Context r34 = getContext();
        if (r34 == null) goto L77;
        ((yw4.a) org.koin.java.a.c(yw4.a.class, null, null, 6)).b("ccm_template_center", r34, null);
        return;
    L77:
        return;
    L66:
        CreateSelectResult.CREATOR.getClass();
        r30 = CreateSelectResult.a.b();
        goto L67
    L55:
        r25 = false;
    L58:
        r4 = false;
        goto L59
    L49:
        r22 = false;
    L45:
        r19 = "";
    L40:
        r16 = "";
    L35:
        r7 = "";
        goto L36
    L28:
        r14 = -1;
        goto L29
    L14:
        if (StringsKt.contains$default(this.f, "corporate", false, 2, null) == false) goto L20;
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_optimization_v4_business", false) == false) goto L18;
        TemplateCenterViewModel.access$setLAST_INDEX$cp(2);
        goto L25
    L18:
        TemplateCenterViewModel.access$setLAST_INDEX$cp(0);
        goto L25
    L20:
        if (this.f.length() <= 0) goto L22;
        boolean r35 = true;
    L23:
        if (r35 == false) goto L25;
        TemplateCenterViewModel.access$setLAST_INDEX$cp(0);
        goto L25
    L22:
        r35 = false;
    L6:
        r11 = "";
        goto L7
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        f r6 = new f(new e(), new TemplateCenterView(requireActivity(), getChildFragmentManager(), r4, this), requireContext());
        this.e = r6;
        r6.create();
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        if (205 != r2) goto L9;
        if (r3 == null) goto L10;
        String r4 = r3.getStringExtra(ResourceData.KEY_TOKEN);
        if (r4 == null) goto L11;
        ViewModelProvider.NewInstanceFactory r5 = ForsetiViewModelProvider.c;
        ((TemplateCenterViewModel) ForsetiViewModelProvider.a.a(requireActivity()).get(TemplateCenterViewModel.class)).getDeleteToken().setValue(r4);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561249, r3, false);
    }
}
