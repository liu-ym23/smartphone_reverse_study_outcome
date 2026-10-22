package com.larus.doc.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ixigua.lib.track.TrackParams;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.util.DocUtils;
import com.larus.doc.impl.view.InterceptTouchFrameLayout;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.nova.R;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.view.DocLoadAndErrorLayout;
import com.larus.office.base.view.TextLoadingView;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J0\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\b\u00105\u001a\u000200H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\b\u0010<\u001a\u00020!H\u0016J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020!H\u0016J\b\u0010?\u001a\u00020!H\u0016J\b\u0010@\u001a\u00020!H\u0016J\f\u0010A\u001a\u00020\u000f*\u00020\u0017H\u0002J\f\u0010B\u001a\u00020\u000f*\u00020\u0017H\u0002J\b\u0010C\u001a\u00020\u000fH\u0002J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010G\u001a\u00020\u000f2\b\u0010H\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010I\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\u0016\u0010L\u001a\u00020\u000f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0NH\u0016J\b\u0010O\u001a\u00020PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006S"}, d2 = {"Lcom/larus/doc/impl/DocFragmentV2;", "Lcom/larus/doc/impl/DocFragment;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "initialDocId", "", "getInitialDocId", "()Ljava/lang/String;", "initialDocId$delegate", "Lkotlin/Lazy;", "getPermissionAbility", "setupServices", "", "attachComponentBeforeCreateDocx", "initPermissionAbility", "initFragment", "it", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "generateDocLogicKeyForFindService", "createOfficeFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyChatInputVisibilityChanged", "visible", "", "onFloatChatFragmentCreated", "updateArtifactInfo", "artifactMetaId", "artifactVersionId", "conversationId", "bindedMessageId", "buildEnterPageExtraParams", "Lorg/json/JSONObject;", "updateDocOpBarVisibility", "tryShow", "needAdjustPanelHeight", "notifyEditPanelHeightChanged", "updateDocBrief", "getChatPanelHeight", "", "getChatInputFragmentHeight", "onBackPressed", "foldStatusChanged", "setupChatAndOpBarContainer", "getChatContainerId", "getTitleView", "Landroid/view/ViewGroup;", LiveCommonConstants.REASON_ON_DEDTROY, "canManage", "canCopy", "canShare", "canRead", "canDelete", "canEdit", "reviewSuccess", "isOwner", "gray", "available", "adaptViewByPermission", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", WidgetService.PARAM_FRAGMENT, "getToken", "getNoPermissionContainerId", "getOfficeContainerId", "runWhenAdded", "action", "Lkotlin/Function0;", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFragmentV2 extends DocFragment implements com.larus.office.base.component.permission.c {
    public static final /* synthetic */ int O2 = 0;
    public com.larus.office.base.component.permission.a M2;
    public final Lazy N2;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.office.base.component.permission.c
    public final int C3() {
        return R.id.doc_fragment_container;
    }

    @Override // com.larus.office.base.component.permission.c
    public final int J7() {
        return R.id.doc_no_permission_fragment_container;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final int Z90() {
        return R.id.doc_chat_input_container_v2;
    }

    public final void Ca0() {
        k1a.b.a(this, new j1(this));
        com.larus.office.base.component.permission.a r100 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
        this.M2 = r100;
        if (r100 == null) goto L5;
        r100.mW(this);
    L5:
        com.larus.office.base.component.permission.a r101 = this.M2;
        if (r101 == null) goto L9;
        r101.R20(new r1(this));
    L9:
        if (this.X != null) goto L31;
        s1a.a.g(this).c(this.Y, com.larus.doc.impl.offline.d.class);
        k1a.b.a(this, new g(this));
        this.X = (com.larus.doc.impl.offline.c) s1a.a.g(this).getAbility(com.larus.doc.impl.offline.c.class);
        if (z2.f365865a.getDocFusionConfig().f547230a == false) goto L14;
        int r102 = 10;
    L15:
        Bundle r103 = getArguments();
        boolean r104 = false;
        if (r103 == null) goto L18;
        r104 = r103.getBoolean("key_is_in_main_conversation", false);
    L18:
        if (r104 == false) goto L20;
        int r105 = 2;
    L21:
        com.larus.doc.impl.offline.c r106 = this.X;
        if (r106 == null) goto L30;
        String r107 = this.H;
        String r108 = this.f330987f;
        String r109 = this.P;
        Bundle r110 = getArguments();
        Long r111 = null;
        if (r110 == null) goto L28;
        String r112 = r110.getString("key_message_id", null);
        if (r112 == null) goto L28;
        r111 = StringsKt.toLongOrNull(r112);
    L28:
        r106.QN(new com.larus.doc.impl.offline.f(r107, r108, r109, r111, r102, r105, this.f330996k));
        return;
    L30:
        return;
    L20:
        r105 = 1;
        goto L21
    L14:
        r102 = 3;
        goto L15
    }

    public final JSONObject Da0() {
        JSONObject r100 = new JSONObject();
        com.larus.office.base.component.permission.a r101 = Ea0();
        String r102 = null;
        if (r101 == null) goto L18;
        DocPermissionFullData r103 = r101.C4();
        if (r103 == null) goto L18;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (fo9.e.f(r103) == true) goto L10;
        String r104 = "review_rejected";
    L19:
        JSONObject r105 = r100.put("doc_status", r104);
        com.larus.office.base.component.permission.a r106 = Ea0();
        if (r106 == null) goto L27;
        DocPermissionFullData r107 = r106.C4();
        if (r107 == null) goto L27;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if (fo9.e.e(r107) == false) goto L26;
        String r108 = "self_created";
    L28:
        JSONObject r109 = r105.put("ai_doc_owner_type", r108);
        Bundle r110 = getArguments();
        if (r110 == null) goto L31;
        String r111 = r110.getString("feishu_record_id", null);
    L32:
        JSONObject r112 = r109.put("feishu_record_id", r111);
        Bundle r113 = getArguments();
        if (r113 == null) goto L35;
        String r114 = r113.getString("feishu_record_generated_type", null);
    L36:
        JSONObject r115 = r112.put("feishu_record_generated_type", r114);
        Bundle r116 = getArguments();
        if (r116 == null) goto L39;
        String r117 = r116.getString("record_scene", null);
    L40:
        JSONObject r118 = r115.put("record_scene", r117);
        Bundle r119 = getArguments();
        if (r119 == null) goto L43;
        String r120 = r119.getString("is_general_agent", null);
    L45:
        if (r120 != null) goto L47;
    L50:
        boolean r121 = true;
    L52:
        if ((true ^ r121) == true) goto L55;
        r120 = null;
    L55:
        if (r120 != null) goto L57;
        r120 = "0";
    L57:
        JSONObject r122 = r118.put("is_general_agent", r120);
        Bundle r123 = getArguments();
        if (r123 == null) goto L60;
        r102 = r123.getString("chat_id", null);
    L60:
        if (r102 != null) goto L63;
        r102 = "";
    L63:
        return r122.put("chat_id", r102);
    L47:
        if (r120.length() == 0) goto L50;
        r121 = false;
        goto L52
    L43:
        r120 = null;
        goto L45
    L39:
        r117 = null;
        goto L40
    L35:
        r114 = null;
        goto L36
    L31:
        r111 = null;
        goto L32
    L26:
        r108 = "other_created";
    L27:
        r108 = null;
        goto L28
    L10:
        if (fo9.e.c(r103) == true) goto L12;
    L17:
        r104 = "lack_permission";
        goto L19
    L12:
        if (fo9.e.a(r103) == false) goto L17;
        if (fo9.e.b(r103) == false) goto L17;
        r104 = "normal";
    L18:
        r104 = null;
        goto L19
    }

    public final com.larus.office.base.component.permission.a Ea0() {
        com.larus.office.base.component.permission.a r100 = this.M2;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final String Y90() {
        String r100 = "fake_offline_doc_id";
        if (Intrinsics.areEqual((String) this.N2.getValue(), "fake_offline_doc_id") == true) goto L6;
        r100 = this.f330987f;
    L6:
        DocUtils r101 = DocUtils.f331466a;
        long r102 = this.f330990g2;
        r101.getClass();
        return r100 + '_' + r102;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final int aa0() {
        ViewGroup r100 = this.f331010t;
        int r101 = 0;
        if (r100 == null) goto L7;
        View r102 = r100.findViewById(R.id.bottom_layout);
        if (r102 == null) goto L7;
        int r103 = r102.getBottom();
    L11:
        View r104 = this.f331007q;
        boolean r105 = true;
        if (r104 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L23;
        View r107 = this.f331007q;
        if (r107 == null) goto L21;
        int r108 = r107.getHeight();
    L22:
        r103 = r103 + r108;
        goto L23
    L21:
        r108 = 0;
    L23:
        TextLoadingView r109 = this.f331011u;
        if (r109 != null) goto L26;
    L28:
        r105 = false;
    L29:
        if (r105 == false) goto L35;
        TextLoadingView r110 = this.f331011u;
        if (r110 == null) goto L34;
        r101 = r110.getHeight();
    L34:
        return r103 + r101;
    L35:
        return r103;
    L26:
        if (r109.getVisibility() != 0) goto L28;
    L14:
        if (r104.getVisibility() != 0) goto L16;
        r106 = true;
    L7:
        ViewGroup r111 = this.f331010t;
        if (r111 == null) goto L10;
        r103 = r111.getHeight();
        goto L11
    L10:
        r103 = 0;
        goto L11
    }

    @Override // com.larus.doc.impl.DocFragment
    public final ViewGroup fa0() {
        LarusLayoutDocDetailFragmentBinding r100 = this.f330988g;
        if (r100 == null) goto L5;
        ConstraintLayout r101 = r100.f330955h;
    L6:
        if (r101 == null) goto L8;
        ViewParent r102 = r101.getParent();
    L9:
        if (r102 == null) goto L16;
        ViewParent r103 = r101.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L13;
        ViewGroup r104 = (ViewGroup) r103;
    L14:
        if (r104 == null) goto L16;
        r104.removeView(r101);
        goto L16
    L13:
        r104 = null;
    L16:
        LarusLayoutDocDetailFragmentBinding r105 = this.f330988g;
        if (r105 == null) goto L32;
        DocLoadAndErrorLayout r106 = r105.f330951d;
        if (r106 == null) goto L32;
        if (r105 == null) goto L23;
        if (r106 == null) goto L23;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L25:
        if ((r107 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r107;
    L28:
        if (r108 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r108).topMargin = i5.k0();
    L31:
        r106.setLayoutParams(r108);
        goto L32
    L30:
        r108 = null;
        goto L31
    L27:
        r108 = null;
    L23:
        r107 = null;
    L32:
        LarusLayoutDocDetailFragmentBinding r109 = this.f330988g;
        if (r109 != null) goto L35;
        return null;
    L35:
        return r109.f330955h;
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void la0() {
        FLogger.f375446a.i("[doc_input_focus]", "notifyEditPanelHeightChanged called");
        Lazy r100 = com.larus.office.base.service.m.f361113a;
        ym9.c r101 = com.larus.office.base.service.m.a(Y90());
        if (r101 == null) goto L6;
        r101.onEditPanelHeightChanged(36);
        return;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ma0() {
        if (this.f331005p1 == false) goto L5;
    L24:
        SoftReference<Handler> r100 = com.larus.utils.y.f375498a;
        Runnable r101 = new l1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        com.larus.utils.y.d(r101, 500);
        return;
    L5:
        if (this.f330998k1 <= 0) goto L24;
        long r102 = System.currentTimeMillis() - this.f330998k1;
        if (r102 >= 0) goto L10;
        FLogger.f375446a.i("DocFragment", "[reportDocFloatChatCreatedDurationIfNeeded] invalid duration=" + r102);
        goto L24
    L10:
        FLogger.f375446a.i("DocFragment", "[reportDocFloatChatCreatedDurationIfNeeded] duration=" + r102);
        boolean r103 = true;
        this.f331005p1 = true;
        com.larus.doc.impl.offline.c r104 = this.X;
        if (r104 != null) goto L13;
    L15:
        r103 = false;
    L16:
        Boolean r105 = Boolean.valueOf(r103);
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("duration", r102);     // Catch: JSONException -> L21
        if (r105 == null) goto L23;
        r106.put("isOfflineDocCreated", r105.booleanValue());     // Catch: JSONException -> L21
    L23:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("doc_float_chat_created_duration");
        r108.f21463a.merge(r107);
        r108.b();
    L21:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocFloatChatCreatedDuration: " + e.getLocalizedMessage());
        goto L23
    L13:
        if (r104.BK() != true) goto L15;
        goto L15
    }

    public final void onBackPressed() {
        Fragment r100 = this.f330991h;
        boolean r101 = true;
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L28;
        Fragment r104 = this.f330991h;
        if (r104 == null) goto L18;
        t1a.b r105 = s1a.a.g(r104);
        if (r105 == null) goto L18;
        va8.g0 r106 = (va8.g0) r105.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r106 == null) goto L18;
        if (r106.YC() != true) goto L18;
    L19:
        if (r101 == false) goto L28;
        Fragment r107 = this.f330991h;
        if (r107 == null) goto L36;
        t1a.b r108 = s1a.a.g(r107);
        if (r108 == null) goto L37;
        va8.g0 r109 = (va8.g0) r108.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r109 == null) goto L38;
        r109.km("ai_doc_detail");
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L18:
        r101 = false;
    L28:
        vm9.d r110 = com.larus.office.base.service.m.b();
        if (r110 == null) goto L31;
        r102 = r110.onBackPressed(this.f330994i);
    L31:
        if (r102 == true) goto L39;
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L40;
        r111.finish();
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (r100.isAdded() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.larus.doc.impl.DocFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.f330986e == true) goto L9;
        this.f330986e = true;
        int r100 = com.larus.doc.impl.offline.k.f331281a;
        String r101 = this.H;
        if (Intrinsics.areEqual(this.f330999l, "answer_manual_create") == false) goto L7;
        String r102 = "send_message_create";
    L8:
        String r103 = r102;
        String r104 = this.f330987f;
        String r105 = this.f330995j;
        int r106 = ga0();
        int r107 = ga0();
        String r108 = ea0();
        JSONObject r109 = Da0();
        com.larus.doc.impl.offline.k.a(r101, r103, r104, r105, Integer.valueOf(r106), Integer.valueOf(r107), r108, r109, this);
        goto L9
    L7:
        r102 = this.f330999l;
    L9:
        super.onDestroy();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ra0() {
        ViewGroup r100 = this.f331009s;
        if (r100 == null) goto L48;
        FLogger.f375446a.i("DocFragmentV2", "setupChatAndOpBarContainer");
        r100.removeAllViews();
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.larus_layout_doc_chat_and_op_bar, r100, false);
        r100.addView(r101);
        int r102 = R.id.chat_input_bg_mask_v2;
        View r103 = ViewBindings.findChildViewById(r101, R.id.chat_input_bg_mask_v2);
        if (r103 == null) goto L47;
        r102 = R.id.doc_chat_input_container_v2;
        InterceptTouchFrameLayout r104 = (InterceptTouchFrameLayout) ViewBindings.findChildViewById(r101, R.id.doc_chat_input_container_v2);
        if (r104 == null) goto L47;
        r102 = R.id.doc_operation_bar_v2;
        ViewStub r105 = (ViewStub) ViewBindings.findChildViewById(r101, R.id.doc_operation_bar_v2);
        if (r105 == null) goto L47;
        r102 = R.id.loading_text_v2;
        TextLoadingView r106 = (TextLoadingView) ViewBindings.findChildViewById(r101, R.id.loading_text_v2);
        if (r106 == null) goto L47;
        ConstraintLayout r107 = (ConstraintLayout) r101;
        this.f331010t = r104;
        this.f331011u = r106;
        com.larus.utils.e1.d(r106, new m1(this));
        this.f331012v = r103;
        r103.setOnClickListener(new n1(this));
        int r108 = da0();
        if (r108 != 1) goto L15;
        int r109 = R.layout.larus_doc_operation_bar_edit_on_right_bottom;
    L19:
        r105.setLayoutResource(r109);
        this.f331007q = r105.inflate();
        W90();
        View r110 = this.f331007q;
        if (r110 == null) goto L22;
        com.larus.utils.e1.o(r110);
    L22:
        la0();
        if (da0() == 1) goto L29;
        View r111 = this.f331007q;
        if (r111 == null) goto L29;
        View r112 = r111.findViewById(R.id.doc_copy_all_btn);
        if (r112 == null) goto L29;
        com.larus.utils.e1.d(r112, new o1(this));
    L29:
        View r113 = this.f331007q;
        if (r113 == null) goto L35;
        View r114 = r113.findViewById(R.id.doc_edit_all);
        if (r114 == null) goto L35;
        com.larus.utils.e1.d(r114, new p1(this));
    L35:
        if (canEdit() == true) goto L42;
        View r115 = this.f331007q;
        if (r115 == null) goto L42;
        View r116 = r115.findViewById(R.id.doc_edit_all);
        if (r116 == null) goto L42;
        r116.setAlpha(0.5f);
    L42:
        if (this.J2 == false) goto L49;
        DocFragment$initChatService$1 r117 = this.R;
        if (r117 == null) goto L50;
        r117.setChatInputVisibility(true);
        return;
    L50:
        return;
    L49:
        return;
    L15:
        if (r108 == 2) goto L17;
        r109 = R.layout.larus_doc_operation_bar_edit_on_left_bottom;
        goto L19
    L17:
        r109 = R.layout.larus_doc_operation_bar_edit_on_center_bottom;
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void xa0() {
        Aa0(10);
    }

    public DocFragmentV2() {
        this.N2 = LazyKt.lazy(new i1(this));
    }

    @Override // com.larus.office.base.component.permission.c
    public final com.larus.office.base.component.permission.b X2() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 == null) goto L12;
        DocPermissionFullData r101 = r100.C4();
        if (r101 == null) goto L12;
        fo9.f r102 = r101.getOwner();
        if (r102 == null) goto L12;
        String r103 = r102.f478181a;
        if (r103 == null) goto L12;
    L11:
        String r104 = r103;
    L31:
        return new com.larus.office.base.component.permission.b(this.f330987f, this.C, r104, 22, this.f330999l, this.A, this.f331022z, this.f331019y);
    L12:
        r103 = null;
        if (r100 == null) goto L19;
        DocPermissionFullData r105 = r100.C4();
        if (r105 == null) goto L19;
        fo9.f r106 = r105.getOwner();
        if (r106 == null) goto L19;
        String r107 = r106.f478182b;
    L20:
        if (r107 != null) goto L29;
        if (r100 == null) goto L27;
        DocPermissionFullData r108 = r100.C4();
        if (r108 == null) goto L27;
        fo9.f r109 = r108.getOwner();
        if (r109 == null) goto L27;
        r103 = r109.f478183c;
    L27:
        if (r103 != null) goto L11;
        r103 = "";
        goto L11
    L29:
        r104 = r107;
    L19:
        r107 = null;
        goto L20
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canCopy() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canCopy();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canEdit() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canEdit();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canRead() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canRead();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canShare() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canShare();
    }

    @Override // com.larus.doc.impl.DocFragment, va8.d
    public final void foldStatusChanged() {
        super.foldStatusChanged();
        Fragment r100 = this.f330991h;
        int r101 = 0;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        ViewGroup.MarginLayoutParams r103 = null;
        if (r102 == false) goto L35;
        Fragment r104 = this.f330991h;
        if (r104 == null) goto L19;
        t1a.b r105 = s1a.a.g(r104);
        if (r105 == null) goto L19;
        va8.g0 r106 = (va8.g0) r105.getAbility(va8.g0.class);
        if (r106 == null) goto L19;
        if (r106.YC() != true) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L35;
        LarusLayoutDocDetailFragmentBinding r108 = this.f330988g;
        if (r108 == null) goto L26;
        FrameLayout r109 = r108.f330968u;
        if (r109 == null) goto L26;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
    L28:
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        r103 = (ViewGroup.MarginLayoutParams) r110;
    L30:
        if (r103 == null) goto L32;
        r103.topMargin = 0;
    L32:
        IDocSdkServiceV2 r111 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r111 == null) goto L53;
        r111.notifyChatInputFoldStatusChanged(false, Y90());
        return;
    L53:
        return;
    L26:
        r110 = null;
    L19:
        r107 = false;
    L35:
        LarusLayoutDocDetailFragmentBinding r112 = this.f330988g;
        if (r112 == null) goto L40;
        FrameLayout r113 = r112.f330968u;
        if (r113 == null) goto L40;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L42:
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        r103 = (ViewGroup.MarginLayoutParams) r114;
    L44:
        if (r103 == null) goto L49;
        FragmentActivity r115 = getActivity();
        if (r115 == null) goto L48;
        r101 = com.larus.utils.u.c(r115);
    L48:
        r103.topMargin = r101;
    L49:
        IDocSdkServiceV2 r116 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r116 == null) goto L55;
        r116.notifyChatInputFoldStatusChanged(true, Y90());
        return;
    L55:
        return;
    L40:
        r114 = null;
        goto L42
    L5:
        if (r100.isAdded() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.office.base.component.permission.c
    public final Context getHostContext() {
        return getContext();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean isOwner() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isOwner();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean p6() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.p6();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean s8() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.s8();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void sa0() {
        super.sa0();
        Ca0();
    }

    @Override // com.larus.office.base.component.permission.c
    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean y4() {
        com.larus.office.base.component.permission.a r100 = Ea0();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.y4();
    }

    @Override // com.larus.office.base.component.permission.c
    public final Fragment d5() {
        return this.f330994i;
    }

    @Override // com.larus.office.base.component.permission.c
    public final String getToken() {
        return this.f330987f;
    }

    @Override // com.larus.office.base.component.permission.c
    public final void d7(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (isAdded() == false) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ha0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DocFragmentV2$initFragment$1(r100, this, null), 3, null);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ka0(boolean r100) {
        Lazy r101 = com.larus.office.base.service.m.f361113a;
        ym9.c r102 = com.larus.office.base.service.m.a(Y90());
        if (r102 == null) goto L6;
        r102.onEditPanelActive(r100);
        return;
    }

    @Override // com.larus.office.base.component.permission.c
    public final void x5(Fragment r100) {
        this.f330994i = r100;
    }

    @Override // com.larus.office.base.component.permission.c
    public final Object V3(Context r210, Continuation<? super Fragment> r211) {
        if ((r211 instanceof DocFragmentV2$createOfficeFragment$1) == false) goto L7;
        DocFragmentV2$createOfficeFragment$1 r100 = (DocFragmentV2$createOfficeFragment$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DocFragmentV2$createOfficeFragment$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L122:
        return (Fragment) r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r106 = (String) r110.L$2;
        Context r107 = (Context) r110.L$1;
        IDocSdkServiceV2 r108 = (IDocSdkServiceV2) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r109 = r106;
        IDocSdkServiceV2 r111 = r108;
    L26:
        String r112 = (String) r102;
        Bundle r113 = getArguments();
        if (r113 == null) goto L29;
        String r114 = r113.getString("key_message_id");
    L30:
        Bundle r115 = getArguments();
        if (r115 == null) goto L33;
        Long r116 = Boxing.boxLong(r115.getLong("key_click_timestamp"));
    L34:
        OfficeInputParam r117 = new OfficeInputParam();
        r117.setResourceId(this.f330987f);
        r117.setDocLogicKey(Y90());
        r117.setResourceType(this.f331000m);
        Bundle r118 = getArguments();
        String r119 = "";
        if (r118 == null) goto L38;
        String r120 = r118.getString("artifact_meta_id");
        if (r120 == null) goto L38;
    L39:
        r117.setArtifactMetaId(r120);
        Bundle r121 = getArguments();
        if (r121 == null) goto L43;
        String r122 = r121.getString("argConversationId");
        if (r122 == null) goto L43;
    L44:
        r117.setConversationId(r122);
        Bundle r123 = getArguments();
        if (r123 == null) goto L47;
        long r124 = r123.getLong("key_click_timestamp");
    L48:
        Context r212 = r107;
        r117.setClickTimestamp(r124);
        r117.setBeginLoadTimestamp(System.currentTimeMillis());
        String r125 = this.f330999l;
        if (r125 != null) goto L51;
        r125 = "";
    L51:
        r117.setEnterMethod(r125);
        r117.setDocTitle(this.C);
        Bundle r126 = getArguments();
        if (r126 == null) goto L54;
        boolean r127 = r126.getBoolean("has_report_finish_event");
    L55:
        r117.setHasReportFinishEvent(r127);
        Bundle r128 = getArguments();
        if (r128 != null) goto L58;
    L60:
        boolean r129 = false;
    L61:
        r117.setColdStart(r129);
        Bundle r130 = getArguments();
        if (r130 == null) goto L64;
        String r131 = r130.getString("argPreviousPage");
    L65:
        r117.setPreviousPage(r131);
        r117.setApplyPermissionConversationId(this.f331022z);
        r117.setApplyPermissionMessageId(this.A);
        r117.setObjType(Boxing.boxInt(22));
        Bundle r132 = getArguments();
        if (r132 == null) goto L68;
        String r133 = r132.getString("feishu_record_id");
    L69:
        r117.setFeishuRecordId(r133);
        Bundle r134 = getArguments();
        if (r134 == null) goto L72;
        String r135 = r134.getString("feishu_record_generated_type");
    L73:
        r117.setFeishuRecordContentType(r135);
        Bundle r136 = getArguments();
        if (r136 == null) goto L76;
        String r137 = r136.getString("record_scene");
    L77:
        r117.setRecordScene(r137);
        Bundle r138 = getArguments();
        if (r138 == null) goto L80;
        String r139 = r138.getString("is_general_agent");
    L81:
        if (r139 != null) goto L83;
    L86:
        boolean r140 = true;
    L88:
        if (Boxing.boxBoolean(!r140).booleanValue() == true) goto L91;
        r139 = null;
    L91:
        if (r139 != null) goto L93;
        r139 = "0";
    L93:
        r117.setGeneralAgent(r139);
        Bundle r141 = getArguments();
        if (r141 == null) goto L96;
        String r142 = r141.getString("chat_id");
    L97:
        if (r142 == null) goto L100;
        r119 = r142;
    L100:
        r117.setAgentChatId(r119);
        Bundle r143 = getArguments();
        if (r143 != null) goto L103;
    L105:
        boolean r144 = false;
    L106:
        r117.setDocPreloaded(r144);
        r117.setOfflineCreateAttemptId(this.H);
        r117.setFakeOfflineDoc(Intrinsics.areEqual(this.f330987f, "fake_offline_doc_id"));
        Bundle r145 = getArguments();
        if (r145 == null) goto L109;
        String r146 = r145.getString("key_source_url_for_params");
    L110:
        r117.setSourceUrlForParams(r146);
        Bundle r147 = getArguments();
        if (r147 != null) goto L113;
    L115:
        r105 = false;
    L116:
        r117.setOpenChatWithNewLocalConv(r105);
        Unit r148 = Unit.INSTANCE;
        com.larus.office.base.component.permission.a r149 = this.M2;
        r110.L$0 = null;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.label = 2;
        r102 = r111.openAndGetDocFragment(r212, r109, r112, r114, r116, r117, r149, null, r110);
        if (r102 != r103) goto L122;
        return r103;
    L113:
        if (r147.getBoolean("open_chat_with_new_local_conv", false) != true) goto L115;
    L109:
        r146 = null;
        goto L110
    L103:
        if (r143.getBoolean("key_office_preloaded", false) != true) goto L105;
        r144 = true;
        goto L106
    L96:
        r142 = null;
        goto L97
    L83:
        if (r139.length() == 0) goto L86;
        r140 = false;
        goto L88
    L80:
        r139 = null;
        goto L81
    L76:
        r137 = null;
        goto L77
    L72:
        r135 = null;
        goto L73
    L68:
        r133 = null;
        goto L69
    L64:
        r131 = null;
        goto L65
    L58:
        if (r128.getBoolean("is_cold_start") != true) goto L60;
        r129 = true;
        goto L61
    L54:
        r127 = false;
        goto L55
    L47:
        r124 = System.currentTimeMillis();
    L43:
        r122 = "";
    L38:
        r120 = "";
        goto L39
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L16:
        ResultKt.throwOnFailure(r102);
        Ca0();
        IDocSdkServiceV2 r150 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r150 == null) goto L121;
        String r151 = this.f330987f;
        DocUtils r152 = DocUtils.f331466a;
        Bundle r153 = getArguments();
        if (r153 == null) goto L21;
        String r154 = r153.getString("key_message_id");
    L22:
        r110.L$0 = r150;
        r110.L$1 = r210;
        r110.L$2 = r151;
        r110.label = 1;
        Object r155 = r152.b(r151, r154, r110);
        if (r155 != r103) goto L25;
        return r103;
    L25:
        r109 = r151;
        r111 = r150;
        r102 = r155;
        r107 = r210;
        goto L26
    L21:
        r154 = null;
        goto L22
    L121:
        return null;
    L7:
        r100 = new DocFragmentV2$createOfficeFragment$1(this, r211);
        goto L8
    }

    @Override // com.larus.doc.impl.DocFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ya0(boolean r100, boolean r101) {
        super.ya0(r100, r101);
        if (r101 == true) goto L5;
        return;
    L5:
        if (this.f331008r == false) goto L9;
        la0();
        return;
    }

    @Override // com.larus.doc.impl.DocFragment, g39.a
    public final void F8(String r110, String r111, String r112, String r113) {
        FLogger.f375446a.i("DocFragmentV2", "updateArtifactId, artifactId = " + r110);
        this.f330995j = r110;
        this.f330996k = r111;
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        this.f331016x = r112;
        this.f331015w = r113;
        if (r110 == null) goto L9;
        String r114 = m39.a.f511797a;
        Intrinsics.checkNotNullParameter(r110, "artifactId");
        m39.a.f511798b = r110;
    L9:
        if (this.f330986e == true) goto L16;
        this.f330986e = true;
        int r115 = com.larus.doc.impl.offline.k.f331281a;
        String r100 = this.H;
        if (Intrinsics.areEqual(this.f330999l, "answer_manual_create") == false) goto L13;
        String r116 = "send_message_create";
    L14:
        String r101 = r116;
        String r102 = this.f330987f;
        int r117 = ga0();
        int r118 = ga0();
        com.larus.doc.impl.offline.k.a(r100, r101, r102, r110, Integer.valueOf(r117), Integer.valueOf(r118), ea0(), Da0(), this);
        return;
    L13:
        r116 = this.f330999l;
        goto L14
    }
}
