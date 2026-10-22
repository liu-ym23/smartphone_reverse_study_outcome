package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.secret.ApprovalDialogCallbacks;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0016J\u001a\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020$H\u0002J\u0012\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020$H\u0002J \u0010@\u001a\u00020$2\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`DH\u0002J \u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020G2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0007H\u0002J\"\u0010I\u001a\u00020$2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0002J\b\u0010N\u001a\u00020$H\u0016J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\u000e\u0010T\u001a\u00020$H\u0082@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020WH\u0082@¢\u0006\u0002\u0010UJ\b\u0010X\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/InputReasonFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "token", "", "type", "", "secLabelId", "name", "level", "applyTips", "applyTipsV2", "enableShareExternal", "", "noEditing", WikiFolderPushPlugin.WIKI_TOKEN, "oldSerretLevel", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "newSerretLevel", "defModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel;", "escapeRuleDefModel", "extParams", "", "Ljava/io/Serializable;", "lynxCallback", "Lcom/bytedance/ee/bear/secret/ApprovalDialogCallbacks;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isShowToastLoading", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "isLoading", "requestFocusAndSelection", "onResume", "onViewCreated", "view", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", LiveCommonConstants.REASON_ON_DEDTROY, "handleNoEditing", "isShowNewWarnTip", "handleTvOperationTips", "onApproveSuccess", "sessionCode", "onApproveFailure", "error", "", "shouldWaitForApprovalResult", "isApproveOpen", "handleApproveShow", "showAvartarUi", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel$Reviewer;", "Lkotlin/collections/ArrayList;", "setNameView", "nameView", "Landroid/widget/TextView;", "maxWidth", "loadIcon", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "url", "uerId", WidgetCostModule.TYPE_ON_START, "addWatermark", "commitWithoutWaiting", "waitForApproveJob", "Lkotlinx/coroutines/Job;", "commitAndWait", "observeSecretPushOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendApprovalRequest", "Lcom/bytedance/ee/bear/middleground/permission/secret/UpdateSecretLevelResult;", "toString", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputReasonFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int B = 0;
    public Job A;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f233902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f233903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f233904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f233905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f233906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f233907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f233908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f233909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f233910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f233911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SecretLevel f233912r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SecretLevel f233913s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SecretApprovalDefModel f233914t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SecretApprovalDefModel f233915u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, ? extends Serializable> f233916v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ApprovalDialogCallbacks f233917w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f233918x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f233919y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f233920z;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r110, String r111, int r112, String r113, String r114, int r115, String r210, String r211, SecretLevel r212, SecretApprovalDefModel r213, boolean r214, Map r215, SecretLevel r216) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            Intrinsics.checkNotNullParameter(r111, "token");
            Intrinsics.checkNotNullParameter(r113, "secLabelId");
            Intrinsics.checkNotNullParameter(r114, "name");
            Intrinsics.checkNotNullParameter(r210, "applyTips");
            Intrinsics.checkNotNullParameter(r211, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r212, "oldSerretLevel");
            b(r110.getSupportFragmentManager(), r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215, r216);
        }

        public static void b(FragmentManager r110, String r111, int r112, String r113, String r114, int r115, String r116, String r117, SecretLevel r210, SecretApprovalDefModel r211, boolean r212, Map r213, SecretLevel r214) {
            Serializable r100 = null;
            ApprovalDialogCallbacks r101 = null;
            if (r110.findFragmentByTag("InputReasonFragment") != null) goto L5;
            Fragment r102 = new InputReasonFragment();
            Bundle r103 = new Bundle();
            r103.putString("extra_token", r111);
            r103.putInt("extra_type", r112);
            r103.putString("extra_secret_label_id", r113);
            r103.putString("extra_name", r114);
            r103.putInt("extra_level", r115);
            r103.putString("apply_tips", r116);
            if (r214 == null) goto L27;
            String r104 = r214.getApplyTipsV2();
        L28:
            r103.putString("apply_tips_v2", r104);
            StringBuilder r105 = new StringBuilder("show, newSerretLevel = ");
            if (r214 == null) goto L33;
            PermissionControl r106 = r214.getPermissionControl();
            if (r106 == null) goto L33;
            Boolean r107 = Boolean.valueOf(r106.isCanShareExternal());
        L34:
            r105.append(r107);
            r105.append(", isOpen = ");
            if (r211 == null) goto L37;
            Boolean r108 = Boolean.valueOf(r211.isIs_open());
        L38:
            r105.append(r108);
            tt5.a.h("InputReasonFragment", r105.toString());
            if (r214 == null) goto L45;
            PermissionControl r118 = r214.getPermissionControl();
            if (r118 == null) goto L45;
            if (r118.isCanShareExternal() != true) goto L45;
            boolean r119 = true;
        L46:
            r103.putBoolean("enable_share_external", r119);
            r103.putBoolean("no_editing", r212);
            r103.putString("extra_wiki_token", r117);
            r103.putSerializable("extra_old_secret", r210);
            r103.putSerializable("extra_new_secret", r214);
            if (r211 == null) goto L49;
            r103.putSerializable("extra_def_model", r211);
        L50:
            if (r213 != null) goto L52;
        L65:
            r102.setArguments(r103);
            FragmentTransaction r109 = r110.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "InputReasonFragment", 0) == true) goto L69;
            r109 = r109.add(r102, "InputReasonFragment");
        L69:
            r109.commitAllowingStateLoss();
            return;
        L52:
            if ((!r213.isEmpty()) == false) goto L54;
            Map r120 = r213;
        L55:
            if (r120 == null) goto L65;
        L63:
            e = move-exception;
            tt5.a.e("InputReasonFragment", "show, serialize extParams failed", e, false);
            goto L65
        L57:
            if ((r213 instanceof Serializable) == false) goto L59;
            r100 = (Serializable) r213;     // Catch: Exception -> L63
        L59:
            if (r100 != null) goto L61;
            r100 = new HashMap(r120);     // Catch: Exception -> L63
        L61:
            r103.putSerializable("extra_ext_params", r100);     // Catch: Exception -> L63
            goto L65
        L54:
            r120 = null;
            goto L55
        L49:
            SecretApprovalDefModel r121 = new SecretApprovalDefModel();
            r121.setSuccess(false);
            r103.putSerializable("extra_def_model", r121);
        L45:
            r119 = false;
            goto L46
        L37:
            r108 = null;
        L33:
            r107 = null;
            goto L34
        L27:
            r104 = null;
            goto L28
        L5:
            if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L73;
            if (r213 == null) goto L8;
            Serializable r122 = (Serializable) r213.get("wait_for_approval_result");
        L10:
            if ((r122 instanceof Boolean) == false) goto L12;
            Boolean r123 = (Boolean) r122;
        L14:
            if (Intrinsics.areEqual(r123, Boolean.TRUE) == false) goto L74;
            if (r213 == null) goto L17;
            Serializable r124 = (Serializable) r213.get("lynx_call_back");
        L19:
            if ((r124 instanceof ApprovalDialogCallbacks) == false) goto L21;
            r101 = (ApprovalDialogCallbacks) r124;
        L21:
            if (r101 == null) goto L75;
            r101.onCancel();
            return;
        L75:
            return;
        L17:
            r124 = null;
            goto L19
        L74:
            return;
        L12:
            r123 = null;
            goto L14
        L8:
            r122 = null;
            goto L10
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f233921c;

        public b(String r100) {
            this.f233921c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(this.f233921c, "");
        }
    }

    public static final class c extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f233922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233923d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            rcb.c.d(this.f233922c.findViewById(R.id.input));
            InputReasonFragment r101 = this.f233923d;
            int r102 = InputReasonFragment.B;
            if (r101.ca0() == false) goto L16;
            ApprovalDialogCallbacks r103 = this.f233923d.f233917w;
            if (r103 == null) goto L16;
            r103.onCancel();
        L16:
            this.f233923d.dismissAllowingStateLoss();     // Catch: Exception -> L10
        L14:
            com.bytedance.ee.bear.middleground.permission.c.P("cancel", this.f233923d.f233914t.isIs_open());
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r104 = DialogFragmentLancet.sLastShowStack;
            if (r104 == null) goto L14;
            com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L14
        }

        public c(View r100, InputReasonFragment r101) {
            this.f233922c = r100;
            this.f233923d = r101;
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f233924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233925b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            boolean r101 = false;
            if (r100 == null) goto L5;
            int r102 = r100.length();
        L6:
            UDButton r103 = (UDButton) this.f233924a.findViewById(R.id.doneBtn);
            if (r102 > 0) goto L9;
        L11:
            r103.setEnabled(r101);
            return;
        L9:
            if (this.f233925b.f233920z == true) goto L11;
            r101 = true;
            goto L11
        L5:
            r102 = 0;
            goto L6
        }

        public d(View r100, InputReasonFragment r101) {
            this.f233924a = r100;
            this.f233925b = r101;
        }
    }

    public static final class e extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f233926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233927d;

        public static void b(InputReasonFragment r100) {
            r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L11;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            rcb.c.d(this.f233926c.findViewById(R.id.input));
            InputReasonFragment r101 = this.f233927d;
            int r102 = InputReasonFragment.B;
            if (r101.ca0() == false) goto L9;
            ApprovalDialogCallbacks r103 = this.f233927d.f233917w;
            if (r103 == null) goto L7;
            r103.onCancel();
        L7:
            b(this.f233927d);
            com.bytedance.ee.bear.middleground.permission.c.P("cancel", this.f233927d.f233914t.isIs_open());
            return;
        L9:
            Map<String, ? extends Serializable> r104 = this.f233927d.f233916v;
            Boolean r105 = null;
            if (r104 == null) goto L12;
            Serializable r106 = r104.get("update_permission_info");
        L14:
            if ((r106 instanceof String) == false) goto L16;
            String r107 = (String) r106;
        L17:
            Map<String, ? extends Serializable> r108 = this.f233927d.f233916v;
            if (r108 == null) goto L20;
            Serializable r109 = r108.get("is_need_edit");
        L22:
            if ((r109 instanceof Boolean) == false) goto L24;
            r105 = (Boolean) r109;
        L24:
            Boolean r110 = com.bytedance.ee.bear.middleground.permission.b.h();
            Boolean r111 = Boolean.TRUE;
            if (Intrinsics.areEqual(r110, r111) == true) goto L27;
        L46:
            b(this.f233927d);
            com.bytedance.ee.bear.middleground.permission.c.P("cancel", this.f233927d.f233914t.isIs_open());
            return;
        L27:
            if (this.f233927d.f233917w == null) goto L46;
            if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r111) == false) goto L46;
            if (Intrinsics.areEqual(r105, r111) == false) goto L46;
            boolean r112 = false;
            if (r107 != null) goto L35;
        L40:
            if (r112 == false) goto L46;
            tt5.a.h("InputReasonFragment", "updateSecret, isNeedEdit: " + r105 + ", updatePermissionInfo: " + du5.b.h(r107));
            ApprovalDialogCallbacks r113 = this.f233927d.f233917w;
            if (r113 == null) goto L44;
            r113.onCancel();
        L44:
            b(this.f233927d);
            return;
        L35:
            if (r107.length() <= 0) goto L37;
            boolean r114 = true;
        L38:
            if (r114 != true) goto L40;
            r112 = true;
            goto L40
        L37:
            r114 = false;
            goto L38
        L20:
            r109 = null;
            goto L22
        L16:
            r107 = null;
            goto L17
        L12:
            r106 = null;
            goto L14
        }

        public e(View r100, InputReasonFragment r101) {
            this.f233926c = r100;
            this.f233927d = r101;
        }
    }

    public static final class f extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f233928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233929d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r110) {
            Editable r111 = ((SpaceEditText) this.f233928c.findViewById(R.id.input)).getText();
            boolean r100 = false;
            if (r111 == null) goto L5;
            int r112 = r111.length();
        L7:
            if (r112 <= 1024) goto L10;
            Toast.showText(this.f233929d.getContext(), R.string.CreationMobile_SecureLabel_MaxLength);
            return;
        L10:
            Map<String, ? extends Serializable> r113 = this.f233929d.f233916v;
            SpaceEditText r101 = null;
            if (r113 == null) goto L13;
            Serializable r114 = r113.get("update_permission_info");
        L15:
            if ((r114 instanceof String) == false) goto L17;
            String r115 = (String) r114;
        L18:
            Map<String, ? extends Serializable> r102 = this.f233929d.f233916v;
            if (r102 == null) goto L21;
            Serializable r103 = r102.get("is_need_edit");
        L23:
            if ((r103 instanceof Boolean) == false) goto L25;
            Boolean r104 = (Boolean) r103;
        L26:
            Boolean r105 = com.bytedance.ee.bear.middleground.permission.b.h();
            Boolean r106 = Boolean.TRUE;
            if (Intrinsics.areEqual(r105, r106) == true) goto L29;
        L54:
            Toast.showLoading(this.f233929d.getContext(), eu5.b.f474075a.getText(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Submitting_Mob));
            this.f233929d.f233919y = true;
            ((UDButton) this.f233928c.findViewById(R.id.doneBtn)).setEnabled(false);
            InputReasonFragment r116 = this.f233929d;
            r116.f233920z = true;
            com.bytedance.ee.bear.middleground.permission.c.P(e1.REPLY_ACTION_APPLY, r116.f233914t.isIs_open());
            InputReasonFragment r117 = this.f233929d;
            if (r117.f233914t.isSuccess() == false) goto L60;
            if (r117.f233914t.isIs_open() == false) goto L60;
            r100 = true;
        L60:
            if (r100 == false) goto L70;
            InputReasonFragment r107 = this.f233929d;
            r107.getClass();
            tt5.a.h("InputReasonFragment", "(" + r107 + ") commitAndWait");
            Job r108 = r107.A;
            if (r108 != null) goto L64;
        L69:
            r107.A = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new InputReasonFragment$commitAndWait$3(r107, null), 3, null);
            return;
        L64:
            if (r108.isActive() == true) goto L67;
            r108 = null;
        L67:
            if (r108 == null) goto L69;
            tt5.a.h("InputReasonFragment", "(" + r107 + ") commitAndWait, waitForApproveJob is already working.");
            return;
        L70:
            InputReasonFragment r109 = this.f233929d;
            r109.getClass();
            tt5.a.h("InputReasonFragment", "(" + r109 + ") commitWithoutWaiting");
            SecretViewModel r118 = (SecretViewModel) r109.f233918x.getValue();
            String r119 = r109.f233902h;
            int r120 = r109.f233903i;
            String r121 = r109.f233904j;
            View r122 = r109.getView();
            if (r122 == null) goto L73;
            r101 = (SpaceEditText) r122.findViewById(R.id.input);
        L73:
            if (r101 == null) goto L78;
            Editable r123 = r101.getText();
            if (r123 == null) goto L78;
            String r124 = r123.toString();
            if (r124 == null) goto L78;
        L79:
            r118.updateSecret(r119, r120, r121, r124, r109.f233905k, r109.f233906l, r109.f233911q, r109.f233913s);
            return;
        L78:
            r124 = "";
            goto L79
        L29:
            if (this.f233929d.f233917w == null) goto L54;
            if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r106) == false) goto L54;
            if (Intrinsics.areEqual(r104, r106) == false) goto L54;
            if (r115 != null) goto L36;
        L41:
            boolean r125 = false;
        L42:
            if (r125 == false) goto L54;
            tt5.a.h("InputReasonFragment", "updateSecret, isNeedEdit: " + r104 + ", updatePermissionInfo: " + du5.b.h(r115));
            ApprovalDialogCallbacks r126 = this.f233929d.f233917w;
            if (r126 == null) goto L81;
            r126.onConfirm();
        L81:
            this.f233929d.dismissAllowingStateLoss();     // Catch: Exception -> L49
            return;
        L49:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r127 = DialogFragmentLancet.sLastShowStack;
            if (r127 == null) goto L83;
            com.bytedance.crash.d.d(r127, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L83:
            return;
        L36:
            if (r115.length() <= 0) goto L38;
            boolean r128 = true;
        L39:
            if (r128 != true) goto L41;
            r125 = true;
            goto L42
        L38:
            r128 = false;
            goto L39
        L25:
            r104 = null;
            goto L26
        L21:
            r103 = null;
            goto L23
        L17:
            r115 = null;
            goto L18
        L13:
            r114 = null;
            goto L15
        L5:
            r112 = 0;
            goto L7
        }

        public f(View r100, InputReasonFragment r101) {
            this.f233928c = r100;
            this.f233929d = r101;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f233931b;

        public g(InputReasonFragment r100, View r101) {
            this.f233930a = r100;
            this.f233931b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            UpdateSecretLevelResult r101 = (UpdateSecretLevelResult) r100;
            InputReasonFragment r102 = this.f233930a;
            if (r102.f233914t.isSuccess() == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == false) goto L15;
            if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L13;
            tt5.a.d("InputReasonFragment", "(" + this.f233930a + ") getUpdateSecLiveData, isApproveOpen, but still observing LiveData.");
            return;
        L13:
            throw new IllegalStateException("isApproveOpen, but still observing LiveData.");
        L15:
            if (this.f233930a.f233919y == false) goto L17;
            Toast.cancelLoading();
            this.f233930a.f233919y = false;
        L17:
            this.f233930a.f233920z = false;
            UDButton r104 = (UDButton) this.f233931b.findViewById(R.id.doneBtn);
            CharSequence r105 = ((UDButton) this.f233931b.findViewById(R.id.doneBtn)).getText();
            if (r105 == null) goto L20;
            int r106 = r105.length();
        L21:
            if (r106 <= 0) goto L23;
            boolean r107 = true;
        L24:
            r104.setEnabled(r107);
            String r108 = null;
            if (r101.getSuccess() == false) goto L39;
            rcb.c.d(this.f233931b.findViewById(R.id.input));
            com.bytedance.ee.bear.middleground.permission.c.L(false);
            Toast.showSuccessText(this.f233930a.getContext(), R.string.LarkCCM_Docs_SecurityLevel_SetasDefault_Toast);
            if (this.f233930a.ca0() == false) goto L49;
            ApprovalDialogCallbacks r109 = this.f233930a.f233917w;
            if (r109 == null) goto L49;
            ApprovalDialogCallbacks.onSuccessResult$default(r109, null, 1, null);
        L49:
            this.f233930a.dismissAllowingStateLoss();     // Catch: Exception -> L34
            return;
        L34:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r110 = DialogFragmentLancet.sLastShowStack;
            if (r110 == null) goto L52;
            com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L52:
            return;
        L39:
            if (r101.getSuccess() == true) goto L54;
            Toast.showFailureText(this.f233930a.getContext(), R.string.CreationMobile_SecureLabel_Change_Failed);
            if (this.f233930a.ca0() == false) goto L55;
            InputReasonFragment r111 = this.f233930a;
            ApprovalDialogCallbacks r112 = r111.f233917w;
            if (r112 == null) goto L56;
            Context r113 = r111.getContext();
            if (r113 == null) goto L47;
            r108 = r113.getString(R.string.CreationMobile_SecureLabel_Change_Failed);
        L47:
            r112.onFail(r108);
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L23:
            r107 = false;
            goto L24
        L20:
            r106 = 0;
            goto L21
        L5:
            if (r102.f233914t.isIs_open() == false) goto L7;
            r103 = true;
            goto L8
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputReasonFragment f233932a;

        public h(InputReasonFragment r100) {
            this.f233932a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            SecretApprovalDefModel r101 = (SecretApprovalDefModel) r100;
            tt5.a.h("InputReasonFragment", "Escape rule data changed: " + r101);
            InputReasonFragment r102 = this.f233932a;
            Intrinsics.checkNotNull(r101);
            r102.f233915u = r101;
            this.f233932a.aa0();
            InputReasonFragment r103 = this.f233932a;
            View r104 = r103.getView();
            NestedScrollView r105 = null;
            if (r104 == null) goto L5;
            RelativeLayout r106 = (RelativeLayout) r104.findViewById(R.id.rl_loading);
        L7:
            if (r106 == null) goto L9;
            r106.setVisibility(8);
        L9:
            View r107 = r103.getView();
            if (r107 == null) goto L12;
            BearLottieView r108 = (BearLottieView) r107.findViewById(R.id.loadingView);
        L13:
            if (r108 == null) goto L15;
            r108.setVisibility(8);
        L15:
            View r109 = r103.getView();
            if (r109 == null) goto L18;
            BearLottieView r110 = (BearLottieView) r109.findViewById(R.id.loadingView);
        L19:
            if (r110 == null) goto L21;
            r110.cancelAnimation();
        L21:
            View r111 = r103.getView();
            if (r111 == null) goto L24;
            r105 = (NestedScrollView) r111.findViewById(R.id.ns_perm_input_content);
        L24:
            if (r105 == null) goto L27;
            r105.setVisibility(0);
            return;
        L27:
            return;
        L18:
            r110 = null;
            goto L19
        L12:
            r108 = null;
            goto L13
        L5:
            r106 = null;
            goto L7
        }
    }

    static {
    }

    public final void aa0() {
        UDNotice r100 = null;
        TipsNotice r101 = null;
        TextView r102 = null;
        if (this.f233903i != 125) goto L16;
        View r103 = getView();
        if (r103 == null) goto L7;
        UDNotice r104 = (UDNotice) r103.findViewById(R.id.bannerTipsLayout);
    L8:
        if (r104 == null) goto L10;
        r104.setVisibility(8);
    L10:
        View r105 = getView();
        if (r105 == null) goto L13;
        r101 = (TipsNotice) r105.findViewById(R.id.bannerWarnTipsLayout);
    L13:
        if (r101 == null) goto L169;
        r101.setVisibility(8);
        return;
    L169:
        return;
    L7:
        r104 = null;
        goto L8
    L16:
        Boolean r106 = com.bytedance.ee.bear.middleground.permission.b.i();
        Boolean r107 = Boolean.TRUE;
        boolean r108 = true;
        if (Intrinsics.areEqual(r106, r107) == false) goto L36;
        SecretLevel r109 = this.f233912r;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r109 = null;
    L22:
        if (r109.getApplyWarnTips() == null) goto L35;
        String r110 = this.f233908n;
        if (r110 != null) goto L26;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == false) goto L35;
        if (this.f233909o == false) goto L36;
        if (this.f233915u.isIs_open() == false) goto L36;
    L26:
        if (r110.length() == 0) goto L29;
        r111 = false;
    L35:
        boolean r112 = true;
    L37:
        if (r112 == false) goto L156;
        View r113 = getView();
        if (r113 == null) goto L41;
        UDNotice r114 = (UDNotice) r113.findViewById(R.id.bannerTipsLayout);
    L42:
        if (r114 == null) goto L44;
        r114.setVisibility(8);
    L44:
        View r115 = getView();
        if (r115 == null) goto L47;
        TipsNotice r116 = (TipsNotice) r115.findViewById(R.id.bannerWarnTipsLayout);
    L48:
        if (r116 == null) goto L50;
        r116.R5(null, 0, R.style.UDNotice_Warning);
        r116.U5();
    L50:
        View r117 = getView();
        if (r117 == null) goto L53;
        TipsNotice r118 = (TipsNotice) r117.findViewById(R.id.bannerWarnTipsLayout);
    L54:
        if (r118 == null) goto L60;
        SecretLevel r119 = this.f233912r;
        if (r119 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r119 = null;
    L58:
        r118.setTextV1(r119.getApplyWarnTips());
    L60:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.h(), r107) == false) goto L74;
        SecretLevel r120 = this.f233913s;
        if (r120 == null) goto L69;
        Integer r121 = r120.isSelectedSearch();
        int r122 = SearchableStatus.NOT_SEARCHABLE.getValue();
        if (r121 == null) goto L69;
        if (r121.intValue() != r122) goto L69;
        boolean r123 = true;
    L70:
        if (r123 == false) goto L74;
        SecretLevel r124 = this.f233913s;
        if (r124 == null) goto L77;
        r124.getApplyTipsNotSearchable();
    L77:
        View r125 = getView();
        if (r125 == null) goto L80;
        TipsNotice r126 = (TipsNotice) r125.findViewById(R.id.bannerWarnTipsLayout);
    L81:
        String r127 = "";
        if (r126 == null) goto L87;
        String r128 = this.f233908n;
        if (r128 != null) goto L86;
        r128 = "";
    L86:
        r126.setTextV2(r128);
    L87:
        View r129 = getView();
        if (r129 == null) goto L90;
        TipsNotice r130 = (TipsNotice) r129.findViewById(R.id.bannerWarnTipsLayout);
    L91:
        if (r130 == null) goto L103;
        SecretLevel r131 = this.f233912r;
        if (r131 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r131 = null;
    L95:
        String r132 = r131.getApplyWarnTips();
        if (r132 != null) goto L98;
    L101:
        boolean r133 = true;
    L102:
        r130.setVisibleV1(!r133);
        goto L103
    L98:
        if (r132.length() == 0) goto L101;
        r133 = false;
    L103:
        View r134 = getView();
        if (r134 == null) goto L106;
        TipsNotice r135 = (TipsNotice) r134.findViewById(R.id.bannerWarnTipsLayout);
    L107:
        if (r135 == null) goto L117;
        String r136 = this.f233908n;
        if (r136 != null) goto L111;
    L114:
        boolean r137 = true;
    L115:
        r135.setVisibleV2(!r137);
        goto L117
    L111:
        if (r136.length() == 0) goto L114;
        r137 = false;
    L117:
        if (this.f233909o == true) goto L119;
    L144:
        View r138 = getView();
        if (r138 == null) goto L147;
        TipsNotice r139 = (TipsNotice) r138.findViewById(R.id.bannerWarnTipsLayout);
    L148:
        if (r139 == null) goto L150;
        r139.setVisibility(0);
    L150:
        View r140 = getView();
        if (r140 == null) goto L153;
        r102 = (TextView) r140.findViewById(R.id.download_msg);
    L153:
        if (r102 == null) goto L170;
        r102.setTextSize(14.0f);
        return;
    L170:
        return;
    L147:
        r139 = null;
        goto L148
    L119:
        if (this.f233915u.isIs_open() == false) goto L144;
        View r141 = getView();
        if (r141 == null) goto L123;
        TipsNotice r142 = (TipsNotice) r141.findViewById(R.id.bannerWarnTipsLayout);
    L124:
        if (r142 != null) goto L126;
    L132:
        View r143 = getView();
        if (r143 == null) goto L135;
        TipsNotice r144 = (TipsNotice) r143.findViewById(R.id.bannerWarnTipsLayout);
    L136:
        if (r144 == null) goto L144;
        Context r145 = getContext();
        if (r145 == null) goto L143;
        String r146 = r145.getString(R.string.LarkCCM_SecurityLvAdjust_ToL1ExternalInstead_Desc);
        if (r146 == null) goto L143;
        r127 = r146;
    L143:
        r144.setTextV3(r127);
        goto L144
    L135:
        r144 = null;
        goto L136
    L126:
        if (this.f233909o == true) goto L128;
    L130:
        r108 = false;
    L131:
        r142.setVisibleV3(r108);
        goto L132
    L128:
        if (this.f233915u.isIs_open() == false) goto L130;
    L123:
        r142 = null;
        goto L124
    L106:
        r135 = null;
        goto L107
    L90:
        r130 = null;
        goto L91
    L80:
        r126 = null;
    L69:
        r123 = false;
    L74:
        SecretLevel r147 = this.f233913s;
        if (r147 == null) goto L77;
        r147.getApplyTipsV2();
        goto L77
    L53:
        r118 = null;
        goto L54
    L47:
        r116 = null;
        goto L48
    L41:
        r114 = null;
        goto L42
    L156:
        View r148 = getView();
        if (r148 == null) goto L159;
        r100 = (UDNotice) r148.findViewById(R.id.bannerTipsLayout);
    L159:
        if (r100 == null) goto L171;
        String r149 = this.f233907m;
        if (r149 != null) goto L163;
    L166:
        if (r108 == true) goto L172;
        r100.setText(this.f233907m);
        r100.setVisibility(0);
        return;
    L172:
        return;
    L163:
        if (r149.length() == 0) goto L166;
        r108 = false;
        goto L166
    L171:
        return;
    L36:
        r112 = false;
        goto L37
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        return "InputReasonFragment(" + hashCode() + "){token: " + du5.b.i(this.f233902h) + ", type: " + this.f233903i + '}';
    }

    public InputReasonFragment() {
        this.f233902h = "";
        this.f233903i = sbb.e.f541296g.f541317b;
        this.f233904j = "";
        this.f233905k = "";
        this.f233907m = "";
        this.f233911q = "";
        this.f233914t = new SecretApprovalDefModel();
        this.f233915u = new SecretApprovalDefModel();
        this.f233918x = LazyKt.lazy(new InputReasonFragment$viewModel$2(this));
    }

    public final boolean ca0() {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L5;
    L16:
        return false;
    L5:
        if (this.f233917w == null) goto L16;
        Map<String, ? extends Serializable> r100 = this.f233916v;
        Boolean r101 = null;
        if (r100 == null) goto L9;
        Serializable r102 = r100.get("wait_for_approval_result");
    L11:
        if ((r102 instanceof Boolean) == false) goto L14;
        r101 = (Boolean) r102;
    L14:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L16;
        return true;
    L9:
        r102 = null;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Job r100 = this.A;
        if (r100 == null) goto L9;
        if (r100.isActive() == false) goto L7;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L7:
        this.A = null;
    L9:
        if (this.f233919y == false) goto L12;
        Toast.cancelLoading();
        this.f233919y = false;
    L12:
        if (ca0() == false) goto L17;
        ApprovalDialogCallbacks r101 = this.f233917w;
        if (r101 == null) goto L18;
        r101.onCancel();
        return;
    L18:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        View r100 = getView();
        SpaceEditText r101 = null;
        if (r100 == null) goto L5;
        SpaceEditText r102 = (SpaceEditText) r100.findViewById(R.id.input);
    L6:
        if (r102 == null) goto L8;
        r102.requestFocus();
    L8:
        View r103 = getView();
        if (r103 == null) goto L11;
        SpaceEditText r104 = (SpaceEditText) r103.findViewById(R.id.input);
    L13:
        if (r104 == null) goto L15;
        r104.setFocusable(true);
    L15:
        View r105 = getView();
        if (r105 == null) goto L18;
        SpaceEditText r106 = (SpaceEditText) r105.findViewById(R.id.input);
    L19:
        if (r106 == null) goto L21;
        r106.setFocusableInTouchMode(true);
    L21:
        View r107 = getView();
        if (r107 == null) goto L24;
        SpaceEditText r108 = (SpaceEditText) r107.findViewById(R.id.input);
    L25:
        if (r108 == null) goto L27;
        int r109 = r108.getSelectionStart();
    L28:
        View r110 = getView();
        if (r110 == null) goto L31;
        r101 = (SpaceEditText) r110.findViewById(R.id.input);
    L31:
        if (r101 == null) goto L34;
        r101.setSelection(r109);
    L34:
        if (this.f233910p == false) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), Boolean.FALSE) == false) goto L40;
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.ee.bear.middleground.permission.secret.e(this), 100);
        return;
    L40:
        return;
    L27:
        r109 = 0;
        goto L28
    L24:
        r108 = null;
        goto L25
    L18:
        r106 = null;
        goto L19
    L11:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -2;
        r102.softInputMode = 16;
        r102.gravity = 80;
        r101.setAttributes(r102);
        r101.setDimAmount(0.2f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        return;
    L9:
        return;
    }

    public final void da0(ArrayList<SecretApprovalDefModel.Reviewer> r110) {
        Iterator<SecretApprovalDefModel.Reviewer> r100 = r110.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L106;
        SecretApprovalDefModel.Reviewer r102 = r100.next();
        if (r102.getUser_avatar_url() == null) goto L105;
        int r103 = b0.b(r110.size());
        TextView r111 = null;
        if (r101 != 0) goto L11;
        View r112 = getView();
        if (r112 == null) goto L78;
        LinearLayout r113 = (LinearLayout) r112.findViewById(R.id.avatar_layout);
    L80:
        if (r113 == null) goto L82;
        View r114 = r113.findViewById(R.id.avatar_one);
    L83:
        if (r114 == null) goto L85;
        r114.setVisibility(0);
    L85:
        View r115 = getView();
        if (r115 == null) goto L88;
        LinearLayout r116 = (LinearLayout) r115.findViewById(R.id.avatar_layout);
    L89:
        if (r116 == null) goto L91;
        View r117 = r116.findViewById(R.id.avatar_one);
    L92:
        if (r117 == null) goto L94;
        UDAvatar r104 = (UDAvatar) r117.findViewById(R.id.view_avatar);
    L95:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r104, r102.getUser_avatar_url(), r102.getUser_id());
        View r105 = getView();
        if (r105 == null) goto L98;
        LinearLayout r106 = (LinearLayout) r105.findViewById(R.id.avatar_layout);
    L99:
        if (r106 == null) goto L101;
        View r107 = r106.findViewById(R.id.avatar_one);
    L102:
        if (r107 == null) goto L104;
        r111 = (TextView) r107.findViewById(R.id.avatar_name);
    L104:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.TextView");
        r111.setText(r102.getUser_name());
        r111.setMaxWidth(r103);
        goto L105
    L101:
        r107 = null;
        goto L102
    L98:
        r106 = null;
        goto L99
    L94:
        r104 = null;
        goto L95
    L91:
        r117 = null;
        goto L92
    L88:
        r116 = null;
        goto L89
    L82:
        r114 = null;
        goto L83
    L78:
        r113 = null;
        goto L80
    L11:
        if (r101 != 1) goto L13;
        View r118 = getView();
        if (r118 == null) goto L48;
        LinearLayout r119 = (LinearLayout) r118.findViewById(R.id.avatar_layout);
    L50:
        if (r119 == null) goto L52;
        View r120 = r119.findViewById(R.id.avatar_two);
    L53:
        if (r120 == null) goto L55;
        r120.setVisibility(0);
    L55:
        View r121 = getView();
        if (r121 == null) goto L58;
        LinearLayout r122 = (LinearLayout) r121.findViewById(R.id.avatar_layout);
    L59:
        if (r122 == null) goto L61;
        View r123 = r122.findViewById(R.id.avatar_two);
    L62:
        if (r123 == null) goto L64;
        UDAvatar r108 = (UDAvatar) r123.findViewById(R.id.view_avatar);
    L65:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r108, r102.getUser_avatar_url(), r102.getUser_id());
        View r109 = getView();
        if (r109 == null) goto L68;
        LinearLayout r124 = (LinearLayout) r109.findViewById(R.id.avatar_layout);
    L69:
        if (r124 == null) goto L71;
        View r125 = r124.findViewById(R.id.avatar_two);
    L72:
        if (r125 == null) goto L74;
        r111 = (TextView) r125.findViewById(R.id.avatar_name);
    L74:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.TextView");
        r111.setText(r102.getUser_name());
        r111.setMaxWidth(r103);
        goto L105
    L71:
        r125 = null;
        goto L72
    L68:
        r124 = null;
        goto L69
    L64:
        r108 = null;
        goto L65
    L61:
        r123 = null;
        goto L62
    L58:
        r122 = null;
        goto L59
    L52:
        r120 = null;
        goto L53
    L48:
        r119 = null;
        goto L50
    L13:
        if (r101 != 2) goto L105;
        View r126 = getView();
        if (r126 == null) goto L18;
        LinearLayout r127 = (LinearLayout) r126.findViewById(R.id.avatar_layout);
    L20:
        if (r127 == null) goto L22;
        View r128 = r127.findViewById(R.id.avatar_three);
    L23:
        if (r128 == null) goto L25;
        r128.setVisibility(0);
    L25:
        View r129 = getView();
        if (r129 == null) goto L28;
        LinearLayout r130 = (LinearLayout) r129.findViewById(R.id.avatar_layout);
    L29:
        if (r130 == null) goto L31;
        View r131 = r130.findViewById(R.id.avatar_three);
    L32:
        if (r131 == null) goto L34;
        UDAvatar r132 = (UDAvatar) r131.findViewById(R.id.view_avatar);
    L35:
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r132, r102.getUser_avatar_url(), r102.getUser_id());
        View r133 = getView();
        if (r133 == null) goto L38;
        LinearLayout r134 = (LinearLayout) r133.findViewById(R.id.avatar_layout);
    L39:
        if (r134 == null) goto L41;
        View r135 = r134.findViewById(R.id.avatar_three);
    L42:
        if (r135 == null) goto L44;
        r111 = (TextView) r135.findViewById(R.id.avatar_name);
    L44:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.TextView");
        r111.setText(r102.getUser_name());
        r111.setMaxWidth(r103);
        goto L105
    L41:
        r135 = null;
        goto L42
    L38:
        r134 = null;
        goto L39
    L34:
        r132 = null;
        goto L35
    L31:
        r131 = null;
        goto L32
    L28:
        r130 = null;
        goto L29
    L22:
        r128 = null;
        goto L23
    L18:
        r127 = null;
    L105:
        r101 = r101 + 1;
        goto L4
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        Bundle r111 = getArguments();
        if (r111 == null) goto L35;
        this.f233902h = r111.getString("extra_token", "");
        this.f233903i = r111.getInt("extra_type");
        this.f233904j = r111.getString("extra_secret_label_id", "");
        this.f233905k = r111.getString("extra_name", "");
        this.f233906l = r111.getInt("extra_level");
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        jdb.g r101 = com.bytedance.ee.bear.middleground.permission.b.d(LarkContext.getApplication());
        if (r101 == null) goto L7;
        boolean r102 = r101.isEnable("ccm.permission.secret_level_searchable_tip");
    L8:
        tt5.a.h("PermFGUtils", "isEnableSecretLevelSearchableTip()...isEnable = " + r102);
        if (Intrinsics.areEqual(Boolean.valueOf(r102), Boolean.TRUE) == false) goto L11;
        this.f233907m = r111.getString("apply_tips", "");
    L11:
        this.f233908n = r111.getString("apply_tips_v2");
        this.f233909o = r111.getBoolean("enable_share_external", false);
        this.f233910p = r111.getBoolean("no_editing", false);
        this.f233911q = r111.getString("extra_wiki_token", "");
        if (r111.getSerializable("extra_old_secret") == null) goto L15;
        Serializable r103 = r111.getSerializable("extra_old_secret");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.secret.SecretLevel");
        this.f233912r = (SecretLevel) r103;
    L15:
        if (r111.getSerializable("extra_new_secret") == null) goto L18;
        Serializable r104 = r111.getSerializable("extra_new_secret");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.secret.SecretLevel");
        this.f233913s = (SecretLevel) r104;
    L18:
        if (r111.getSerializable("extra_def_model") == null) goto L41;
        Serializable r105 = r111.getSerializable("extra_def_model");
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel");
        this.f233914t = (SecretApprovalDefModel) r105;
    L41:
        Serializable r112 = r111.getSerializable("extra_ext_params");     // Catch: Exception -> L33
        ApprovalDialogCallbacks r106 = null;
        if ((r112 instanceof Map) == false) goto L23;
        Map<String, ? extends Serializable> r113 = (Map) r112;     // Catch: Exception -> L33
    L24:
        this.f233916v = r113;     // Catch: Exception -> L33
        if (r113 == null) goto L27;
        Serializable r114 = r113.get("lynx_call_back");     // Catch: Exception -> L33
    L29:
        if ((r114 instanceof ApprovalDialogCallbacks) == false) goto L31;
        r106 = (ApprovalDialogCallbacks) r114;     // Catch: Exception -> L33
    L31:
        this.f233917w = r106;     // Catch: Exception -> L33
        goto L35
    L27:
        r114 = null;
        goto L29
    L23:
        r113 = null;
    L33:
        e = move-exception;
        tt5.a.e("InputReasonFragment", "onCreate, deserialize extParams failed", e, false);
        goto L35
    L7:
        r102 = false;
    L35:
        boolean r115 = this.f233914t.isIs_open();
        String r107 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r108 = new JSONObject();
        String r109 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r116 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L38;
        String r117 = ThumbGlideUrl.SOURCE_VC;
    L39:
        com.bytedance.ee.bear.middleground.permission.c.a(r108, r109, r116, r117, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r108.put("is_check_open", r115);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_security_demotion_view", r108);
        return;
    L38:
        r117 = "none";
        goto L39
    }

    public static final Object Z90(InputReasonFragment r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof InputReasonFragment$observeSecretPushOnce$1) == false) goto L7;
        InputReasonFragment$observeSecretPushOnce$1 r100 = (InputReasonFragment$observeSecretPushOnce$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        Ref.ObjectRef r104 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: TimeoutCancellationException -> L14
    L54:
        tt5.a.b("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, called back before timeout");     // Catch: TimeoutCancellationException -> L14
    L59:
        bu5.a r113 = (bu5.a) r104.element;
        if (r113 == null) goto L62;
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, coroutine finished, unregister RnPush");
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r113);
    L63:
        r104.element = null;
        return Unit.INSTANCE;
    L62:
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, coroutine finished, RnPush is null");
    L14:
        TimeoutCancellationException e100 = e;
    L58:
        tt5.a.e("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, push listener timeout", e100, false);
        goto L59
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        SecretApprovalDefModel r114 = r110.f233914t;
        ArrayList<SecretApprovalDefModel.Reviewer> r105 = r114.getCcUsers();
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L35;
        ArrayList<SecretApprovalDefModel.Reviewer> r115 = r114.getReviewers();
        if (r115 != null) goto L29;
    L32:
        boolean r116 = true;
    L33:
        if (r116 == false) goto L35;
        boolean r117 = true;
    L36:
        if (r117 == true) goto L39;
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, not CC only.");
        return Unit.INSTANCE;
    L39:
        if (idb.f.a().isCurrentEnable("ccm.mobile.subscribe_secret_level_updated") == true) goto L42;
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, FG is off.");
        return Unit.INSTANCE;
    L42:
        if (r110.f233902h.length() != 0) goto L44;
        boolean r118 = true;
    L45:
        if (r118 == false) goto L47;
    L64:
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, invalid params.");
        return Unit.INSTANCE;
    L47:
        if (r110.f233903i < 0) goto L64;
        tt5.a.h("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, create RnPush.");
        Ref.ObjectRef r119 = new Ref.ObjectRef();
        tt5.a.b("InputReasonFragment", "(" + r110 + ") observeSecretPushOnce, will start timeout timer.");     // Catch: TimeoutCancellationException -> L56
        CoroutineDispatcher r107 = Dispatchers.getIO();     // Catch: TimeoutCancellationException -> L56
        InputReasonFragment$observeSecretPushOnce$2 r108 = new InputReasonFragment$observeSecretPushOnce$2(r110, r119, null);     // Catch: TimeoutCancellationException -> L56
        r100.L$0 = r119;     // Catch: TimeoutCancellationException -> L56
        r100.label = 1;     // Catch: TimeoutCancellationException -> L56
        if (BuildersKt.withContext(r107, r108, r100) == r102) goto L73;
        r104 = r119;
        goto L54
    L73:
        return r102;
    L56:
        e = move-exception;
        r104 = r119;
        e100 = e;
        goto L58
    L44:
        r118 = false;
        goto L45
    L29:
        if (r115.isEmpty() == true) goto L32;
        r116 = false;
    L35:
        r117 = false;
        goto L36
    L21:
        if (r105.isEmpty() == true) goto L24;
        r106 = false;
    L7:
        r100 = new InputReasonFragment$observeSecretPushOnce$1(r110, r111);
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ((BaseTitleBar) r110.findViewById(R.id.titleBar)).setLeftClickListener(new c(r110, this));
        ((SpaceEditText) r110.findViewById(R.id.input)).addTextChangedListener(new d(r110, this));
        ((UDButton) r110.findViewById(R.id.cancelBtn)).setOnClickListener(new e(r110, this));
        ((UDButton) r110.findViewById(R.id.doneBtn)).setOnClickListener(new f(r110, this));
        ((SecretViewModel) this.f233918x.getValue()).getUpdateSecLiveData().observe(this, new g(this, r110));
        ((SecretViewModel) this.f233918x.getValue()).getEscapeRuleLiveData().observe(this, new h(this));
        Boolean r112 = com.bytedance.ee.bear.middleground.permission.b.i();
        Boolean r100 = Boolean.TRUE;
        if (Intrinsics.areEqual(r112, r100) == false) goto L30;
        View r113 = getView();
        if (r113 == null) goto L7;
        RelativeLayout r114 = (RelativeLayout) r113.findViewById(R.id.rl_loading);
    L8:
        if (r114 == null) goto L10;
        r114.setVisibility(0);
    L10:
        View r115 = getView();
        if (r115 == null) goto L13;
        BearLottieView r116 = (BearLottieView) r115.findViewById(R.id.loadingView);
    L14:
        if (r116 == null) goto L16;
        r116.setVisibility(0);
    L16:
        View r117 = getView();
        if (r117 == null) goto L19;
        BearLottieView r118 = (BearLottieView) r117.findViewById(R.id.loadingView);
    L20:
        if (r118 == null) goto L22;
        r118.playAnimation();
    L22:
        View r119 = getView();
        if (r119 == null) goto L25;
        NestedScrollView r120 = (NestedScrollView) r119.findViewById(R.id.ns_perm_input_content);
    L26:
        if (r120 == null) goto L28;
        r120.setVisibility(8);
    L28:
        ((SecretViewModel) this.f233918x.getValue()).fetchEscapeRule(this.f233902h, this.f233903i);
        goto L30
    L25:
        r120 = null;
        goto L26
    L19:
        r118 = null;
        goto L20
    L13:
        r116 = null;
        goto L14
    L7:
        r114 = null;
    L30:
        if (this.f233914t.isSuccess() == false) goto L108;
        if (this.f233914t.isIs_open() == false) goto L108;
        if (TextUtils.isEmpty(this.f233914t.getApproval_code()) == true) goto L108;
        View r121 = getView();
        if (r121 == null) goto L39;
        TextView r122 = (TextView) r121.findViewById(R.id.download_msg);
    L40:
        if (r122 == null) goto L59;
        ArrayList<SecretApprovalDefModel.Reviewer> r101 = this.f233914t.getReviewers();
        ArrayList<SecretApprovalDefModel.Reviewer> r102 = this.f233914t.getCcUsers();
        int r103 = b0.f234026a;
        Application r104 = eu5.b.f474075a;
        if (r101 == null) goto L50;
        if (r101.size() <= 0) goto L50;
        if (r101.size() != 1) goto L48;
        String r105 = r104.getString(R.string.LarkCCM_Workspace_SecLeviI_NApprovers);
    L57:
        r122.setText(r105);
        goto L59
    L48:
        r105 = r104.getString(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Note);
    L50:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L56;
        if (r102 != null) goto L53;
    L55:
        r105 = r104.getString(R.string.LarkCCM_AdjustSecLv_ReasonRequired_Desc);
        Intrinsics.checkNotNull(r105);
        goto L57
    L53:
        if (r102.size() <= 0) goto L55;
        r105 = r104.getString(R.string.LarkCCM_SecurityLvAdjust_PersonWillBeInformed_Desc);
        Intrinsics.checkNotNull(r105);
        goto L57
    L56:
        r105 = r104.getString(R.string.LarkCCM_AdjustSecLv_ReasonRequired_Desc);
    L59:
        if (this.f233914t.getReviewers() == null) goto L63;
        if (this.f233914t.getReviewers().size() <= 0) goto L63;
    L68:
        View r123 = getView();
        if (r123 == null) goto L71;
        LinearLayout r124 = (LinearLayout) r123.findViewById(R.id.avatar_layout);
    L72:
        if (r124 == null) goto L74;
        r124.setVisibility(0);
    L74:
        View r125 = getView();
        if (r125 == null) goto L77;
        LinearLayout r126 = (LinearLayout) r125.findViewById(R.id.avatar_layout);
    L78:
        if (r126 == null) goto L80;
        View r127 = r126.findViewById(R.id.avatar_one);
    L81:
        if (r127 == null) goto L83;
        r127.setVisibility(8);
    L83:
        View r128 = getView();
        if (r128 == null) goto L86;
        LinearLayout r129 = (LinearLayout) r128.findViewById(R.id.avatar_layout);
    L87:
        if (r129 == null) goto L89;
        View r130 = r129.findViewById(R.id.avatar_two);
    L90:
        if (r130 == null) goto L92;
        r130.setVisibility(8);
    L92:
        View r131 = getView();
        if (r131 == null) goto L95;
        LinearLayout r132 = (LinearLayout) r131.findViewById(R.id.avatar_layout);
    L96:
        if (r132 == null) goto L98;
        View r133 = r132.findViewById(R.id.avatar_three);
    L99:
        if (r133 == null) goto L102;
        r133.setVisibility(8);
    L102:
        if (this.f233914t.getReviewers() != null) goto L104;
    L106:
        da0(this.f233914t.getCcUsers());
        goto L108
    L104:
        if (this.f233914t.getReviewers().size() <= 0) goto L106;
        da0(this.f233914t.getReviewers());
        goto L108
    L98:
        r133 = null;
        goto L99
    L95:
        r132 = null;
        goto L96
    L89:
        r130 = null;
        goto L90
    L86:
        r129 = null;
        goto L87
    L80:
        r127 = null;
        goto L81
    L77:
        r126 = null;
        goto L78
    L71:
        r124 = null;
    L63:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L108;
        if (this.f233914t.getCcUsers() == null) goto L108;
        if (this.f233914t.getCcUsers().size() <= 0) goto L108;
    L39:
        r122 = null;
    L108:
        if (this.f233910p == false) goto L148;
        View r134 = getView();
        if (r134 == null) goto L112;
        BaseTitleBar r135 = (BaseTitleBar) r134.findViewById(R.id.titleBar);
    L113:
        if (r135 == null) goto L115;
        r135.setTitle(R.string.LarkCCM_Common_Notice_Title);
    L115:
        SecretLevel r136 = this.f233913s;
        if (r136 != null) goto L118;
    L130:
        View r137 = getView();
        if (r137 == null) goto L133;
        FrameLayout r138 = (FrameLayout) r137.findViewById(R.id.input_container);
    L134:
        if (r138 == null) goto L136;
        r138.setVisibility(8);
    L136:
        View r139 = getView();
        if (r139 == null) goto L139;
        UDButton r140 = (UDButton) r139.findViewById(R.id.doneBtn);
    L140:
        if (r140 == null) goto L142;
        r140.setEnabled(true);
    L142:
        View r141 = getView();
        if (r141 == null) goto L145;
        UDButton r142 = (UDButton) r141.findViewById(R.id.doneBtn);
    L146:
        if (r142 == null) goto L167;
        r142.setText(getString(R.string.common_confirm));
    L167:
        aa0();
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.f233902h, this.f233903i, getDialog());
        return;
    L145:
        r142 = null;
        goto L146
    L139:
        r140 = null;
        goto L140
    L133:
        r138 = null;
        goto L134
    L118:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r100) == false) goto L130;
        SecretLevel r106 = this.f233912r;
        if (r106 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r106 = null;
    L123:
        if (r106.getLevel() <= r136.getLevel()) goto L130;
        View r143 = getView();
        if (r143 == null) goto L127;
        BaseTitleBar r144 = (BaseTitleBar) r143.findViewById(R.id.titleBar);
    L128:
        if (r144 == null) goto L130;
        r144.setTitle(R.string.LarkCCM_SecurityLvAdjust_ConfirmLowerL2_Title);
        goto L130
    L127:
        r144 = null;
        goto L128
    L112:
        r135 = null;
        goto L113
    L148:
        View r145 = getView();
        if (r145 == null) goto L151;
        BaseTitleBar r146 = (BaseTitleBar) r145.findViewById(R.id.titleBar);
    L152:
        if (r146 == null) goto L167;
        ArrayList<SecretApprovalDefModel.Reviewer> r147 = this.f233914t.getReviewers();
        ArrayList<SecretApprovalDefModel.Reviewer> r107 = this.f233914t.getCcUsers();
        int r108 = b0.f234026a;
        Application r109 = eu5.b.f474075a;
        if (r147 == null) goto L159;
        if (r147.size() <= 0) goto L159;
        String r148 = r109.getString(R.string.LarkCCM_Workspace_SecLevII_DowngradeRequest);
    L166:
        r146.setTitle(r148);
    L159:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L165;
        if (r107 != null) goto L162;
    L164:
        r148 = r109.getString(R.string.CreationMobile_SecureLabel_Edit_ModifyTitle);
        Intrinsics.checkNotNull(r148);
        goto L166
    L162:
        if (r107.size() <= 0) goto L164;
        r148 = r109.getString(R.string.LarkCCM_Workspace_SecLevII_DowngradeRequest);
        goto L166
    L165:
        r148 = r109.getString(R.string.CreationMobile_SecureLabel_Edit_ModifyTitle);
        goto L166
    L151:
        r146 = null;
        goto L152
    }

    public final void ba0(UDAvatar r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Glide.with(this).load(new BearGlideUrl(r101)).placeholder(R.drawable.facade_common_avatar_place_holder).into(r100);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r100.setOnClickListener(new b(r102));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.perm_input_reason_fragment, r101, false);
    }
}
