package com.bytedance.ee.bear.templates.center;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.category.CategoryFragment;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.scene.SceneFragment;
import com.bytedance.ee.bear.templates.topic.TopicFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0006\u0010\u0016\u001a\u00020\u0010J\"\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/TemplateCenterContainerFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "selectedCallback", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getTemplateSource", "", "getString", "key", "jumpToTemplateSearch", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "onDestroy", "onBackPressed", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCenterContainerFragment extends BaseCCMForsetiFragment implements sa5.a {
    public BinderISelectTemplateCallback.Stub f;

    public static final class a {
    }

    static {
    }

    public final boolean onBackPressed() {
        BinderISelectTemplateCallback.Stub r0 = this.f;
        if (r0 == null) goto L6;
        r0.onCancel(false);
        TemplateReportV2 r1 = TemplateReportV2.a;
        JSONObject r2 = new JSONObject();
        r2.put("click_type", "click_close");
        r2.put("target", "ccm_docs_page_view");
        r2.put("template_source", TemplateReportV2.c);
        TemplateReportV2.a().n("ccm_template_banner_view_click", r2);
    L6:
        return super.onBackPressed();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (km4.a.a == false) goto L5;
        TemplateReportV2 r0 = TemplateReportV2.a;
        JSONObject r1 = new JSONObject();
        r1.put("click_type", DocFeed$Value$Result.CANCEL);
        TemplateReportV2.a().n(TemplateReportV2.b, r1);
        String r2 = TemplateReport.a;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        TemplateReport.a = "";
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).p("template_center", null);
    L5:
        BinderISelectTemplateCallback.Stub r3 = this.f;
        if (r3 == null) goto L9;
        r3.onTemplateCenterDestroy();
        return;
    }

    public TemplateCenterContainerFragment() {
    }

    public final String X90(String r3) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString(r3);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        Bundle r2 = getArguments();
        if (r2 == null) goto L15;
        Serializable r4 = r2.getSerializable("extra_data_map");
        if (r4 == null) goto L15;
        String r5 = (String) ((Map) r4).get(r3);
        if (r5 == null) goto L15;
        return r5;
    L15:
        return "";
    L5:
        r1 = null;
        goto L6
    }

    public static FragmentTransaction W90(FragmentTransaction r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131367728) == false) goto L6;
        return r3;
    L6:
        return r3.add(2131367728, r4);
    }

    public final void onViewCreated(View r34, Bundle r35) {
        Intrinsics.checkNotNullParameter(r34, "view");
        super.onViewCreated(r34, r35);
        r34.setBackgroundColor(r34.getContext().getResources().getColor(2131100548));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).k("template_center");
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        long r7 = r1.getLong("topicId", -1);
    L6:
        Bundle r2 = getArguments();
        if (r2 == null) goto L9;
        long r9 = r2.getLong("sceneId", -1);
    L10:
        Bundle r3 = getArguments();
        if (r3 == null) goto L13;
        long r11 = r3.getLong("categoryId", -1);
    L14:
        Bundle r4 = getArguments();
        int r14 = -1;
        if (r4 == null) goto L17;
        r14 = r4.getInt("objType", -1);
    L17:
        Bundle r5 = getArguments();
        if (r5 == null) goto L20;
        boolean r6 = r5.getBoolean("fixedFilter", false);
    L21:
        Bundle r15 = getArguments();
        if (r15 == null) goto L26;
        Bundle r8 = r15.getBundle("key_template_select_callback_bundle");
        if (r8 == null) goto L26;
        IBinder r10 = r8.getBinder("key_template_select_callback");
    L28:
        if ((r10 instanceof BinderISelectTemplateCallback.Stub) == false) goto L30;
        this.f = (BinderISelectTemplateCallback.Stub) r10;
    L32:
        if (r7 <= 0) goto L35;
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        int r13 = TopicFragment.i;
        W90(r12, TopicFragment.a.a(requireActivity(), String.valueOf(r7), r14, r6)).commitAllowingStateLoss();
    L40:
        String r30 = "";
    L88:
        String r16 = TemplateReport.a;
        String r17 = r30;
        Intrinsics.checkNotNullParameter(r17, r15);
        TemplateReport.a = r17;
        Bundle r18 = getArguments();
        boolean r19 = true;
        if (r18 == null) goto L102;
        String r20 = r18.getString("fromAppLink");
        if (r20 == null) goto L102;
        if (r20.length() != 0) goto L95;
        boolean r21 = true;
    L97:
        if ((!r21) == false) goto L99;
        String r22 = r20;
    L100:
        if (r22 == null) goto L102;
        TemplateReport.c(r22);
        Intrinsics.checkNotNullParameter(r22, r15);
        TemplateReport.a = r22;
        goto L102
    L99:
        r22 = null;
        goto L100
    L95:
        r21 = false;
    L102:
        TemplateReportV2 r23 = TemplateReportV2.a;
        String r24 = X90("clickFrom");
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        TemplateReportV2.d = r24;
        if (Intrinsics.areEqual(r24, "template_center") == true) goto L112;
        String r25 = X90("template_source");
        if (r25.length() == 0) goto L108;
        r19 = false;
    L108:
        if (r19 == false) goto L110;
        r25 = X90("enterSource");
    L110:
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        TemplateReportV2.c = r25;
        return;
    L112:
        return;
    L35:
        if (r9 <= 0) goto L38;
        FragmentTransaction r26 = getChildFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        int r27 = SceneFragment.f;
        FragmentActivity r28 = requireActivity();
        String r29 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "topicId");
        Fragment r31 = Fragment.instantiate(r28, SceneFragment.class.getName(), new Bundle());
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.scene.SceneFragment");
        SceneFragment r32 = (SceneFragment) r31;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r32.e = r29;
        W90(r26, r32).commitAllowingStateLoss();
        goto L40
    L38:
        if (r11 <= 0) goto L41;
        FragmentTransaction r33 = getChildFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        int r36 = CategoryFragment.f;
        FragmentActivity r37 = requireActivity();
        Intrinsics.checkNotNullParameter(r37, "context");
        Fragment r38 = Fragment.instantiate(r37, CategoryFragment.class.getName(), new Bundle());
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.category.CategoryFragment");
        CategoryFragment r39 = (CategoryFragment) r38;
        r39.e = r11;
        W90(r33, r39).commitAllowingStateLoss();
        goto L40
    L41:
        Bundle r40 = getArguments();
        if (r40 == null) goto L45;
        String r41 = r40.getString("openTemplateCenter");
        if (r41 == null) goto L45;
    L46:
        Bundle r42 = getArguments();
        if (r42 == null) goto L52;
        String r43 = r42.getString("enterSource");
        if (r43 == null) goto L52;
        String r110 = r43;
    L53:
        Bundle r44 = getArguments();
        if (r44 == null) goto L56;
        long r111 = r44.getLong("templateCategory", -1);
    L57:
        Bundle r45 = getArguments();
        if (r45 == null) goto L63;
        String r46 = r45.getString("ROOT_TOKEN");
        if (r46 == null) goto L63;
        String r210 = r46;
    L64:
        Bundle r47 = getArguments();
        if (r47 == null) goto L67;
        boolean r211 = r47.getBoolean("key_folder_version", false);
    L68:
        Bundle r48 = getArguments();
        if (r48 == null) goto L74;
        String r49 = r48.getString("MODULE");
        if (r49 == null) goto L74;
        String r212 = r49;
    L75:
        Bundle r50 = getArguments();
        if (r50 == null) goto L79;
        CreateSelectResult r51 = (CreateSelectResult) r50.getParcelable("CREATION_LOCATION");
        if (r51 == null) goto L79;
    L80:
        CreateSelectResult r213 = r51;
        Bundle r52 = getArguments();
        r30 = "";
        if (r52 == null) goto L86;
        String r53 = r52.getString("SPACE_ID");
        if (r53 == null) goto L86;
        String r214 = r53;
    L87:
        d r54 = new d(r41, r111, r110, r210, r212, r14, r6, r211, X90("template_source"), r213, r214, Boolean.parseBoolean(X90("createblank")));
        int r55 = TemplateCenterFragment.h;
        FragmentActivity r56 = requireActivity();
        Intrinsics.checkNotNullParameter(r56, "context");
        Intrinsics.checkNotNullParameter(r54, "params");
        Bundle r57 = new Bundle();
        r57.putString("extra_open_template_center", r54.a);
        r57.putLong("extra_open_template_center_category_id", r54.b);
        r57.putString("enterSource", r54.c);
        r57.putString("ROOT_TOKEN", r54.d);
        r57.putString("MODULE", r54.e);
        r57.putInt("objType", r54.f);
        r57.putBoolean("fixedFilter", r54.g);
        r57.putBoolean("key_folder_version", r54.h);
        r57.putString("template_source", r54.i);
        r57.putParcelable("CREATION_LOCATION", r54.j);
        r57.putString("SPACE_ID", r54.k);
        r57.putBoolean("createblank", r54.l);
        W90(getChildFragmentManager().beginTransaction(), Fragment.instantiate(r56, TemplateCenterFragment.class.getName(), r57)).commitAllowingStateLoss();
    L86:
        r214 = r30;
    L79:
        CreateSelectResult.CREATOR.getClass();
        r51 = CreateSelectResult.a.b();
    L74:
        r212 = "";
        goto L75
    L67:
        r211 = false;
    L63:
        r210 = "";
        goto L64
    L56:
        r111 = -1;
    L52:
        r110 = "";
    L45:
        r41 = "";
        goto L46
    L30:
        tt5.a.d("TemplateCenterContainerFragment", "selectedCallback wrong");
    L26:
        r10 = null;
        goto L28
    L20:
        r6 = false;
        goto L21
    L13:
        r11 = -1;
        goto L14
    L9:
        r9 = -1;
        goto L10
    L5:
        r7 = -1;
        goto L6
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (isDetached() == false) goto L7;
        return;
    L7:
        if (getActivity() == null) goto L28;
        super.onActivityResult(r3, r4, r5);
        if (r5 == null) goto L13;
        Bundle r6 = r5.getExtras();
        if (r6 == null) goto L13;
    L14:
        r6.putAll(getArguments());
        if (r4 != 205) goto L22;
        tt5.a.h("TemplateCenterContainerFragment", "DocActivity return result");
        ViewModelProvider.NewInstanceFactory r0 = ForsetiViewModelProvider.c;
        TemplateV4 r1 = ((TemplateCenterViewModel) ForsetiViewModelProvider.a.a(this).get(TemplateCenterViewModel.class)).getSelectedTemplate();
        if (r1 != null) goto L20;
        goBack();
        tt5.a.d("TemplateCenterContainerFragment", "onActivityResult(): template == null");
        return;
    L20:
        r6.putString("templateId", r1.getObjToken());
        r6.putInt("templateType", r1.getObjType());
        V90(r6);
    L22:
        if (r4 != 100) goto L27;
        V90(r6);
        return;
    L27:
        return;
    L13:
        r6 = new Bundle();
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558520, r3, false);
    }
}
