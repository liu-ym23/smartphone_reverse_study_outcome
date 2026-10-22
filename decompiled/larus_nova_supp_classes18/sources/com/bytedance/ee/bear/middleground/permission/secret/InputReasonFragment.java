package com.bytedance.ee.bear.middleground.permission.secret;

import android.R;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.secret.ApprovalDialogCallbacks;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.framework.utils.DevEnvUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0016J\u001a\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020$H\u0002J\u0012\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020$H\u0002J \u0010@\u001a\u00020$2\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`DH\u0002J \u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020G2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0007H\u0002J\"\u0010I\u001a\u00020$2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0002J\b\u0010N\u001a\u00020$H\u0016J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\u000e\u0010T\u001a\u00020$H\u0082@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020WH\u0082@¢\u0006\u0002\u0010UJ\b\u0010X\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/InputReasonFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "secLabelId", "name", "level", "applyTips", "applyTipsV2", "enableShareExternal", "", "noEditing", WikiFolderPushPlugin.WIKI_TOKEN, "oldSerretLevel", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "newSerretLevel", "defModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel;", "escapeRuleDefModel", "extParams", "", "Ljava/io/Serializable;", "lynxCallback", "Lcom/bytedance/ee/bear/secret/ApprovalDialogCallbacks;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isShowToastLoading", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isLoading", "requestFocusAndSelection", "onResume", "onViewCreated", "view", "showLoading", "hideLoading", "onDestroy", "handleNoEditing", "isShowNewWarnTip", "handleTvOperationTips", "onApproveSuccess", "sessionCode", "onApproveFailure", "error", "", "shouldWaitForApprovalResult", "isApproveOpen", "handleApproveShow", "showAvartarUi", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel$Reviewer;", "Lkotlin/collections/ArrayList;", "setNameView", "nameView", "Landroid/widget/TextView;", "maxWidth", "loadIcon", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", ResourceData.KEY_URL, "uerId", "onStart", "addWatermark", "commitWithoutWaiting", "waitForApproveJob", "Lkotlinx/coroutines/Job;", "commitAndWait", "observeSecretPushOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendApprovalRequest", "Lcom/bytedance/ee/bear/middleground/permission/secret/UpdateSecretLevelResult;", "toString", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputReasonFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int B = 0;
    public Job A;
    public String h;
    public int i;
    public String j;
    public String k;
    public int l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    public SecretLevel r;
    public SecretLevel s;
    public SecretApprovalDefModel t;
    public SecretApprovalDefModel u;
    public Map<String, ? extends Serializable> v;
    public ApprovalDialogCallbacks w;
    public final Lazy x;
    public boolean y;
    public boolean z;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r14, String r15, int r16, String r17, String r18, int r19, String r20, String r21, SecretLevel r22, SecretApprovalDefModel r23, boolean r24, Map r25, SecretLevel r26) {
            Intrinsics.checkNotNullParameter(r14, "activity");
            Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r17, "secLabelId");
            Intrinsics.checkNotNullParameter(r18, "name");
            Intrinsics.checkNotNullParameter(r20, "applyTips");
            Intrinsics.checkNotNullParameter(r21, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r22, "oldSerretLevel");
            b(r14.getSupportFragmentManager(), r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel, java.io.Serializable] */
        public static void b(FragmentManager r12, String r13, int r14, String r15, String r16, int r17, String r18, String r19, SecretLevel r20, SecretApprovalDefModel r21, boolean r22, Map r23, SecretLevel r24) {
            Serializable r6 = null;
            ApprovalDialogCallbacks r7 = null;
            if (r12.findFragmentByTag("InputReasonFragment") != null) goto L5;
            InputReasonFragment r5 = new InputReasonFragment();
            Bundle r8 = new Bundle();
            r8.putString("extra_token", r13);
            r8.putInt("extra_type", r14);
            r8.putString("extra_secret_label_id", r15);
            r8.putString("extra_name", r16);
            r8.putInt("extra_level", r17);
            r8.putString("apply_tips", r18);
            if (r24 == null) goto L27;
            String r9 = r24.getApplyTipsV2();
        L28:
            r8.putString("apply_tips_v2", r9);
            StringBuilder r10 = new StringBuilder("show, newSerretLevel = ");
            if (r24 == null) goto L33;
            PermissionControl r11 = r24.getPermissionControl();
            if (r11 == null) goto L33;
            Boolean r25 = Boolean.valueOf(r11.isCanShareExternal());
        L34:
            r10.append(r25);
            r10.append(", isOpen = ");
            if (r21 == 0) goto L37;
            Boolean r26 = Boolean.valueOf(r21.isIs_open());
        L38:
            r10.append(r26);
            tt5.a.h("InputReasonFragment", r10.toString());
            if (r24 == null) goto L45;
            PermissionControl r110 = r24.getPermissionControl();
            if (r110 == null) goto L45;
            if (r110.isCanShareExternal() != true) goto L45;
            boolean r111 = true;
        L46:
            r8.putBoolean("enable_share_external", r111);
            r8.putBoolean("no_editing", r22);
            r8.putString("extra_wiki_token", r19);
            r8.putSerializable("extra_old_secret", r20);
            r8.putSerializable("extra_new_secret", r24);
            if (r21 == 0) goto L49;
            r8.putSerializable("extra_def_model", r21);
        L50:
            if (r23 != null) goto L52;
        L65:
            r5.setArguments(r8);
            FragmentTransaction r0 = r12.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "InputReasonFragment", 0) == true) goto L69;
            r0 = r0.add(r5, "InputReasonFragment");
        L69:
            r0.commitAllowingStateLoss();
            return;
        L52:
            if ((!r23.isEmpty()) == false) goto L54;
            Map r1 = r23;
        L55:
            if (r1 == null) goto L65;
        L63:
            e = move-exception;
            tt5.a.e("InputReasonFragment", "show, serialize extParams failed", e, false);
            goto L65
        L57:
            if ((r23 instanceof Serializable) == false) goto L59;
            r6 = (Serializable) r23;     // Catch: Exception -> L63
        L59:
            if (r6 != null) goto L61;
            r6 = new HashMap(r1);     // Catch: Exception -> L63
        L61:
            r8.putSerializable("extra_ext_params", r6);     // Catch: Exception -> L63
            goto L65
        L54:
            r1 = null;
            goto L55
        L49:
            ?? r2 = new SecretApprovalDefModel();
            r2.setSuccess(false);
            r8.putSerializable("extra_def_model", r2);
        L45:
            r111 = false;
            goto L46
        L37:
            r26 = null;
        L33:
            r25 = null;
            goto L34
        L27:
            r9 = null;
            goto L28
        L5:
            if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L73;
            if (r23 == null) goto L8;
            Serializable r3 = (Serializable) r23.get("wait_for_approval_result");
        L10:
            if ((r3 instanceof Boolean) == false) goto L12;
            Boolean r4 = (Boolean) r3;
        L14:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L74;
            if (r23 == null) goto L17;
            Serializable r27 = (Serializable) r23.get("lynx_call_back");
        L19:
            if ((r27 instanceof ApprovalDialogCallbacks) == false) goto L21;
            r7 = (ApprovalDialogCallbacks) r27;
        L21:
            if (r7 == null) goto L75;
            r7.onCancel();
            return;
        L75:
            return;
        L17:
            r27 = null;
            goto L19
        L74:
            return;
        L12:
            r4 = null;
            goto L14
        L8:
            r3 = null;
            goto L10
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ String c;

        public b(String r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(this.c, "");
        }
    }

    public static final class c extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ View c;
        public final /* synthetic */ InputReasonFragment d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            rcb.c.d(this.c.findViewById(2131375324));
            InputReasonFragment r3 = this.d;
            int r0 = InputReasonFragment.B;
            if (r3.ca0() == false) goto L16;
            ApprovalDialogCallbacks r4 = this.d.w;
            if (r4 == null) goto L16;
            r4.onCancel();
        L16:
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L10
        L14:
            com.bytedance.ee.bear.middleground.permission.c.P(DocFeed$Value$Result.CANCEL, this.d.t.isIs_open());
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L14;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L14
        }

        public c(View r1, InputReasonFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ View a;
        public final /* synthetic */ InputReasonFragment b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            boolean r0 = false;
            if (r4 == null) goto L5;
            int r5 = r4.length();
        L6:
            UDButton r1 = this.a.findViewById(2131369397);
            if (r5 > 0) goto L9;
        L11:
            r1.setEnabled(r0);
            return;
        L9:
            if (this.b.z == true) goto L11;
            r0 = true;
            goto L11
        L5:
            r5 = 0;
            goto L6
        }

        public d(View r1, InputReasonFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ View c;
        public final /* synthetic */ InputReasonFragment d;

        public static void b(InputReasonFragment r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r6) {
            rcb.c.d(this.c.findViewById(2131375324));
            InputReasonFragment r7 = this.d;
            int r0 = InputReasonFragment.B;
            if (r7.ca0() == false) goto L9;
            ApprovalDialogCallbacks r8 = this.d.w;
            if (r8 == null) goto L7;
            r8.onCancel();
        L7:
            b(this.d);
            com.bytedance.ee.bear.middleground.permission.c.P(DocFeed$Value$Result.CANCEL, this.d.t.isIs_open());
            return;
        L9:
            Map<String, ? extends Serializable> r9 = this.d.v;
            Boolean r1 = null;
            if (r9 == null) goto L12;
            Serializable r10 = r9.get("update_permission_info");
        L14:
            if ((r10 instanceof String) == false) goto L16;
            String r11 = (String) r10;
        L17:
            Map<String, ? extends Serializable> r2 = this.d.v;
            if (r2 == null) goto L20;
            Serializable r3 = r2.get("is_need_edit");
        L22:
            if ((r3 instanceof Boolean) == false) goto L24;
            r1 = (Boolean) r3;
        L24:
            Boolean r4 = com.bytedance.ee.bear.middleground.permission.b.h();
            Boolean r5 = Boolean.TRUE;
            if (Intrinsics.areEqual(r4, r5) == true) goto L27;
        L46:
            b(this.d);
            com.bytedance.ee.bear.middleground.permission.c.P(DocFeed$Value$Result.CANCEL, this.d.t.isIs_open());
            return;
        L27:
            if (this.d.w == null) goto L46;
            if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r5) == false) goto L46;
            if (Intrinsics.areEqual(r1, r5) == false) goto L46;
            boolean r12 = false;
            if (r11 != null) goto L35;
        L40:
            if (r12 == false) goto L46;
            tt5.a.h("InputReasonFragment", "updateSecret, isNeedEdit: " + r1 + ", updatePermissionInfo: " + du5.b.h(r11));
            ApprovalDialogCallbacks r13 = this.d.w;
            if (r13 == null) goto L44;
            r13.onCancel();
        L44:
            b(this.d);
            return;
        L35:
            if (r11.length() <= 0) goto L37;
            boolean r14 = true;
        L38:
            if (r14 != true) goto L40;
            r12 = true;
            goto L40
        L37:
            r14 = false;
            goto L38
        L20:
            r3 = null;
            goto L22
        L16:
            r11 = null;
            goto L17
        L12:
            r10 = null;
            goto L14
        }

        public e(View r1, InputReasonFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class f extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ View c;
        public final /* synthetic */ InputReasonFragment d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r13) {
            Editable r14 = ((SpaceEditText) this.c.findViewById(2131375324)).getText();
            boolean r1 = false;
            if (r14 == null) goto L5;
            int r15 = r14.length();
        L7:
            if (r15 <= 1024) goto L10;
            Toast.showText(this.d.getContext(), 2131887385);
            return;
        L10:
            Map<String, ? extends Serializable> r16 = this.d.v;
            SpaceEditText r2 = null;
            if (r16 == null) goto L13;
            Serializable r17 = r16.get("update_permission_info");
        L15:
            if ((r17 instanceof String) == false) goto L17;
            String r18 = (String) r17;
        L18:
            Map<String, ? extends Serializable> r3 = this.d.v;
            if (r3 == null) goto L21;
            Serializable r4 = r3.get("is_need_edit");
        L23:
            if ((r4 instanceof Boolean) == false) goto L25;
            Boolean r5 = (Boolean) r4;
        L26:
            Boolean r6 = com.bytedance.ee.bear.middleground.permission.b.h();
            Boolean r7 = Boolean.TRUE;
            if (Intrinsics.areEqual(r6, r7) == true) goto L29;
        L54:
            Toast.showLoading(this.d.getContext(), eu5.b.a.getText(2131889910));
            this.d.y = true;
            this.c.findViewById(2131369397).setEnabled(false);
            InputReasonFragment r19 = this.d;
            r19.z = true;
            com.bytedance.ee.bear.middleground.permission.c.P("apply", r19.t.isIs_open());
            InputReasonFragment r110 = this.d;
            if (r110.t.isSuccess() == false) goto L60;
            if (r110.t.isIs_open() == false) goto L60;
            r1 = true;
        L60:
            if (r1 == false) goto L70;
            InputReasonFragment r0 = this.d;
            r0.getClass();
            tt5.a.h("InputReasonFragment", "(" + r0 + ") commitAndWait");
            Job r8 = r0.A;
            if (r8 != null) goto L64;
        L69:
            r0.A = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new InputReasonFragment$commitAndWait$3(r0, null), 3, null);
            return;
        L64:
            if (r8.isActive() == true) goto L67;
            r8 = null;
        L67:
            if (r8 == null) goto L69;
            tt5.a.h("InputReasonFragment", "(" + r0 + ") commitAndWait, waitForApproveJob is already working.");
            return;
        L70:
            InputReasonFragment r9 = this.d;
            r9.getClass();
            tt5.a.h("InputReasonFragment", "(" + r9 + ") commitWithoutWaiting");
            SecretViewModel r10 = (SecretViewModel) r9.x.getValue();
            String r11 = r9.h;
            int r12 = r9.i;
            String r20 = r9.j;
            View r111 = r9.getView();
            if (r111 == null) goto L73;
            r2 = (SpaceEditText) r111.findViewById(2131375324);
        L73:
            if (r2 == null) goto L78;
            Editable r112 = r2.getText();
            if (r112 == null) goto L78;
            String r113 = r112.toString();
            if (r113 == null) goto L78;
        L79:
            r10.updateSecret(r11, r12, r20, r113, r9.k, r9.l, r9.q, r9.s);
            return;
        L78:
            r113 = "";
            goto L79
        L29:
            if (this.d.w == null) goto L54;
            if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r7) == false) goto L54;
            if (Intrinsics.areEqual(r5, r7) == false) goto L54;
            if (r18 != null) goto L36;
        L41:
            boolean r21 = false;
        L42:
            if (r21 == false) goto L54;
            tt5.a.h("InputReasonFragment", "updateSecret, isNeedEdit: " + r5 + ", updatePermissionInfo: " + du5.b.h(r18));
            ApprovalDialogCallbacks r114 = this.d.w;
            if (r114 == null) goto L81;
            r114.onConfirm();
        L81:
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L49
            return;
        L49:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r115 = DialogFragmentLancet.sLastShowStack;
            if (r115 == null) goto L83;
            com.bytedance.crash.d.d(r115, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L83:
            return;
        L36:
            if (r18.length() <= 0) goto L38;
            boolean r22 = true;
        L39:
            if (r22 != true) goto L41;
            r21 = true;
            goto L42
        L38:
            r22 = false;
            goto L39
        L25:
            r5 = null;
            goto L26
        L21:
            r4 = null;
            goto L23
        L17:
            r18 = null;
            goto L18
        L13:
            r17 = null;
            goto L15
        L5:
            r15 = 0;
            goto L7
        }

        public f(View r1, InputReasonFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ InputReasonFragment a;
        public final /* synthetic */ View b;

        public g(InputReasonFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            UpdateSecretLevelResult r7 = (UpdateSecretLevelResult) r6;
            InputReasonFragment r0 = this.a;
            if (r0.t.isSuccess() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L15;
            if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L13;
            tt5.a.d("InputReasonFragment", "(" + this.a + ") getUpdateSecLiveData, isApproveOpen, but still observing LiveData.");
            return;
        L13:
            throw new IllegalStateException("isApproveOpen, but still observing LiveData.");
        L15:
            if (this.a.y == false) goto L17;
            Toast.cancelLoading();
            this.a.y = false;
        L17:
            this.a.z = false;
            UDButton r2 = this.b.findViewById(2131369397);
            CharSequence r3 = this.b.findViewById(2131369397).getText();
            if (r3 == null) goto L20;
            int r4 = r3.length();
        L21:
            if (r4 <= 0) goto L23;
            boolean r5 = true;
        L24:
            r2.setEnabled(r5);
            String r8 = null;
            if (r7.getSuccess() == false) goto L39;
            rcb.c.d(this.b.findViewById(2131375324));
            com.bytedance.ee.bear.middleground.permission.c.L(false);
            Toast.showSuccessText(this.a.getContext(), 2131889256);
            if (this.a.ca0() == false) goto L49;
            ApprovalDialogCallbacks r9 = this.a.w;
            if (r9 == null) goto L49;
            ApprovalDialogCallbacks.onSuccessResult$default(r9, null, 1, null);
        L49:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L34
            return;
        L34:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L52;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L52:
            return;
        L39:
            if (r7.getSuccess() == true) goto L54;
            Toast.showFailureText(this.a.getContext(), 2131887364);
            if (this.a.ca0() == false) goto L55;
            InputReasonFragment r11 = this.a;
            ApprovalDialogCallbacks r12 = r11.w;
            if (r12 == null) goto L56;
            Context r13 = r11.getContext();
            if (r13 == null) goto L47;
            r8 = r13.getString(2131887364);
        L47:
            r12.onFail(r8);
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L23:
            r5 = false;
            goto L24
        L20:
            r4 = 0;
            goto L21
        L5:
            if (r0.t.isIs_open() == false) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ InputReasonFragment a;

        public h(InputReasonFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            SecretApprovalDefModel r6 = (SecretApprovalDefModel) r5;
            tt5.a.h("InputReasonFragment", "Escape rule data changed: " + r6);
            InputReasonFragment r0 = this.a;
            Intrinsics.checkNotNull(r6);
            r0.u = r6;
            this.a.aa0();
            InputReasonFragment r7 = this.a;
            View r1 = r7.getView();
            NestedScrollView r2 = null;
            if (r1 == null) goto L5;
            RelativeLayout r3 = (RelativeLayout) r1.findViewById(2131384692);
        L7:
            if (r3 == null) goto L9;
            r3.setVisibility(8);
        L9:
            View r4 = r7.getView();
            if (r4 == null) goto L12;
            BearLottieView r8 = r4.findViewById(2131378988);
        L13:
            if (r8 == null) goto L15;
            r8.setVisibility(8);
        L15:
            View r9 = r7.getView();
            if (r9 == null) goto L18;
            BearLottieView r10 = (BearLottieView) r9.findViewById(2131378988);
        L19:
            if (r10 == null) goto L21;
            r10.cancelAnimation();
        L21:
            View r11 = r7.getView();
            if (r11 == null) goto L24;
            r2 = r11.findViewById(2131381074);
        L24:
            if (r2 == null) goto L27;
            r2.setVisibility(0);
            return;
        L27:
            return;
        L18:
            r10 = null;
            goto L19
        L12:
            r8 = null;
            goto L13
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    public final void aa0() {
        UDNotice r5 = null;
        if (this.i != 125) goto L16;
        View r0 = getView();
        if (r0 == null) goto L7;
        UDNotice r1 = r0.findViewById(2131363916);
    L8:
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        View r2 = getView();
        if (r2 == null) goto L13;
        r5 = (TipsNotice) r2.findViewById(2131363920);
    L13:
        if (r5 == null) goto L169;
        r5.setVisibility(8);
        return;
    L169:
        return;
    L7:
        r1 = null;
        goto L8
    L16:
        Boolean r3 = com.bytedance.ee.bear.middleground.permission.b.i();
        Boolean r4 = Boolean.TRUE;
        boolean r7 = true;
        if (Intrinsics.areEqual(r3, r4) == false) goto L36;
        SecretLevel r6 = this.r;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r6 = null;
    L22:
        if (r6.getApplyWarnTips() == null) goto L35;
        String r8 = this.n;
        if (r8 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == false) goto L35;
        if (this.o == false) goto L36;
        if (this.u.isIs_open() == false) goto L36;
    L26:
        if (r8.length() == 0) goto L29;
        r9 = false;
    L35:
        boolean r10 = true;
    L37:
        if (r10 == false) goto L156;
        View r11 = getView();
        if (r11 == null) goto L41;
        UDNotice r12 = r11.findViewById(2131363916);
    L42:
        if (r12 == null) goto L44;
        r12.setVisibility(8);
    L44:
        View r13 = getView();
        if (r13 == null) goto L47;
        TipsNotice r14 = (TipsNotice) r13.findViewById(2131363920);
    L48:
        if (r14 == null) goto L50;
        r14.R5(null, 0, 2131953855);
        r14.U5();
    L50:
        View r15 = getView();
        if (r15 == null) goto L53;
        TipsNotice r16 = (TipsNotice) r15.findViewById(2131363920);
    L54:
        if (r16 == null) goto L60;
        SecretLevel r17 = this.r;
        if (r17 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r17 = null;
    L58:
        r16.setTextV1(r17.getApplyWarnTips());
    L60:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.h(), r4) == false) goto L74;
        SecretLevel r18 = this.s;
        if (r18 == null) goto L69;
        Integer r19 = r18.isSelectedSearch();
        int r20 = SearchableStatus.NOT_SEARCHABLE.getValue();
        if (r19 == null) goto L69;
        if (r19.intValue() != r20) goto L69;
        boolean r21 = true;
    L70:
        if (r21 == false) goto L74;
        SecretLevel r22 = this.s;
        if (r22 == null) goto L77;
        r22.getApplyTipsNotSearchable();
    L77:
        View r23 = getView();
        if (r23 == null) goto L80;
        TipsNotice r24 = (TipsNotice) r23.findViewById(2131363920);
    L81:
        String r25 = "";
        if (r24 == null) goto L87;
        String r26 = this.n;
        if (r26 != null) goto L86;
        r26 = "";
    L86:
        r24.setTextV2(r26);
    L87:
        View r27 = getView();
        if (r27 == null) goto L90;
        TipsNotice r28 = (TipsNotice) r27.findViewById(2131363920);
    L91:
        if (r28 == null) goto L103;
        SecretLevel r29 = this.r;
        if (r29 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r29 = null;
    L95:
        String r30 = r29.getApplyWarnTips();
        if (r30 != null) goto L98;
    L101:
        boolean r31 = true;
    L102:
        r28.setVisibleV1(!r31);
        goto L103
    L98:
        if (r30.length() == 0) goto L101;
        r31 = false;
    L103:
        View r32 = getView();
        if (r32 == null) goto L106;
        TipsNotice r33 = (TipsNotice) r32.findViewById(2131363920);
    L107:
        if (r33 == null) goto L117;
        String r34 = this.n;
        if (r34 != null) goto L111;
    L114:
        boolean r35 = true;
    L115:
        r33.setVisibleV2(!r35);
        goto L117
    L111:
        if (r34.length() == 0) goto L114;
        r35 = false;
    L117:
        if (this.o == true) goto L119;
    L144:
        View r36 = getView();
        if (r36 == null) goto L147;
        ConstraintLayout r37 = (TipsNotice) r36.findViewById(2131363920);
    L148:
        if (r37 == null) goto L150;
        r37.setVisibility(0);
    L150:
        View r38 = getView();
        if (r38 == null) goto L153;
        r5 = (TextView) r38.findViewById(2131370181);
    L153:
        if (r5 == null) goto L170;
        r5.setTextSize(14.0f);
        return;
    L170:
        return;
    L147:
        r37 = null;
        goto L148
    L119:
        if (this.u.isIs_open() == false) goto L144;
        View r39 = getView();
        if (r39 == null) goto L123;
        TipsNotice r40 = (TipsNotice) r39.findViewById(2131363920);
    L124:
        if (r40 != null) goto L126;
    L132:
        View r41 = getView();
        if (r41 == null) goto L135;
        TipsNotice r42 = (TipsNotice) r41.findViewById(2131363920);
    L136:
        if (r42 == null) goto L144;
        Context r43 = getContext();
        if (r43 == null) goto L143;
        String r44 = r43.getString(2131889720);
        if (r44 == null) goto L143;
        r25 = r44;
    L143:
        r42.setTextV3(r25);
        goto L144
    L135:
        r42 = null;
        goto L136
    L126:
        if (this.o == true) goto L128;
    L130:
        r7 = false;
    L131:
        r40.setVisibleV3(r7);
        goto L132
    L128:
        if (this.u.isIs_open() == false) goto L130;
    L123:
        r40 = null;
        goto L124
    L106:
        r33 = null;
        goto L107
    L90:
        r28 = null;
        goto L91
    L80:
        r24 = null;
    L69:
        r21 = false;
    L74:
        SecretLevel r45 = this.s;
        if (r45 == null) goto L77;
        r45.getApplyTipsV2();
        goto L77
    L53:
        r16 = null;
        goto L54
    L47:
        r14 = null;
        goto L48
    L41:
        r12 = null;
        goto L42
    L156:
        View r46 = getView();
        if (r46 == null) goto L159;
        r5 = (UDNotice) r46.findViewById(2131363916);
    L159:
        if (r5 == null) goto L171;
        String r47 = this.m;
        if (r47 != null) goto L163;
    L166:
        if (r7 == true) goto L172;
        r5.setText(this.m);
        r5.setVisibility(0);
        return;
    L172:
        return;
    L163:
        if (r47.length() == 0) goto L166;
        r7 = false;
        goto L166
    L171:
        return;
    L36:
        r10 = false;
        goto L37
    }

    public final String toString() {
        return "InputReasonFragment(" + hashCode() + "){token: " + du5.b.i(this.h) + ", type: " + this.i + '}';
    }

    public InputReasonFragment() {
        this.h = "";
        this.i = sbb.e.g.b;
        this.j = "";
        this.k = "";
        this.m = "";
        this.q = "";
        this.t = new SecretApprovalDefModel();
        this.u = new SecretApprovalDefModel();
        this.x = LazyKt.lazy(new InputReasonFragment$viewModel$2(this));
    }

    public final boolean ca0() {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L5;
    L16:
        return false;
    L5:
        if (this.w == null) goto L16;
        Map<String, ? extends Serializable> r0 = this.v;
        Boolean r1 = null;
        if (r0 == null) goto L9;
        Serializable r2 = r0.get("wait_for_approval_result");
    L11:
        if ((r2 instanceof Boolean) == false) goto L14;
        r1 = (Boolean) r2;
    L14:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L16;
        return true;
    L9:
        r2 = null;
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        Job r0 = this.A;
        if (r0 == null) goto L9;
        if (r0.isActive() == false) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L7:
        this.A = null;
    L9:
        if (this.y == false) goto L12;
        Toast.cancelLoading();
        this.y = false;
    L12:
        if (ca0() == false) goto L17;
        ApprovalDialogCallbacks r1 = this.w;
        if (r1 == null) goto L18;
        r1.onCancel();
        return;
    L18:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = getView();
        UDEditText r2 = null;
        if (r0 == null) goto L5;
        UDEditText r1 = (SpaceEditText) r0.findViewById(2131375324);
    L6:
        if (r1 == null) goto L8;
        r1.requestFocus();
    L8:
        View r3 = getView();
        if (r3 == null) goto L11;
        UDEditText r4 = (SpaceEditText) r3.findViewById(2131375324);
    L13:
        if (r4 == null) goto L15;
        r4.setFocusable(true);
    L15:
        View r5 = getView();
        if (r5 == null) goto L18;
        UDEditText r6 = (SpaceEditText) r5.findViewById(2131375324);
    L19:
        if (r6 == null) goto L21;
        r6.setFocusableInTouchMode(true);
    L21:
        View r7 = getView();
        if (r7 == null) goto L24;
        UDEditText r8 = (SpaceEditText) r7.findViewById(2131375324);
    L25:
        if (r8 == null) goto L27;
        int r9 = r8.getSelectionStart();
    L28:
        View r10 = getView();
        if (r10 == null) goto L31;
        r2 = (SpaceEditText) r10.findViewById(2131375324);
    L31:
        if (r2 == null) goto L34;
        r2.setSelection(r9);
    L34:
        if (this.p == false) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), Boolean.FALSE) == false) goto L40;
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.ee.bear.middleground.permission.secret.e(this), 100);
        return;
    L40:
        return;
    L27:
        r9 = 0;
        goto L28
    L24:
        r8 = null;
        goto L25
    L18:
        r6 = null;
        goto L19
    L11:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public final void da0(ArrayList<SecretApprovalDefModel.Reviewer> r14) {
        Iterator<SecretApprovalDefModel.Reviewer> r0 = r14.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L106;
        SecretApprovalDefModel.Reviewer r3 = r0.next();
        if (r3.getUser_avatar_url() == null) goto L105;
        int r4 = b0.b(r14.size());
        TextView r10 = null;
        if (r2 != 0) goto L11;
        View r11 = getView();
        if (r11 == null) goto L78;
        LinearLayout r12 = (LinearLayout) r11.findViewById(2131363704);
    L80:
        if (r12 == null) goto L82;
        View r13 = r12.findViewById(2131363722);
    L83:
        if (r13 == null) goto L85;
        r13.setVisibility(0);
    L85:
        View r15 = getView();
        if (r15 == null) goto L88;
        LinearLayout r16 = (LinearLayout) r15.findViewById(2131363704);
    L89:
        if (r16 == null) goto L91;
        View r17 = r16.findViewById(2131363722);
    L92:
        if (r17 == null) goto L94;
        UDAvatar r8 = (UDAvatar) r17.findViewById(2131392467);
    L95:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r8, r3.getUser_avatar_url(), r3.getUser_id());
        View r7 = getView();
        if (r7 == null) goto L98;
        LinearLayout r9 = (LinearLayout) r7.findViewById(2131363704);
    L99:
        if (r9 == null) goto L101;
        View r18 = r9.findViewById(2131363722);
    L102:
        if (r18 == null) goto L104;
        r10 = (TextView) r18.findViewById(2131363719);
    L104:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.TextView");
        r10.setText(r3.getUser_name());
        r10.setMaxWidth(r4);
        goto L105
    L101:
        r18 = null;
        goto L102
    L98:
        r9 = null;
        goto L99
    L94:
        r8 = null;
        goto L95
    L91:
        r17 = null;
        goto L92
    L88:
        r16 = null;
        goto L89
    L82:
        r13 = null;
        goto L83
    L78:
        r12 = null;
        goto L80
    L11:
        if (r2 != 1) goto L13;
        View r19 = getView();
        if (r19 == null) goto L48;
        LinearLayout r110 = (LinearLayout) r19.findViewById(2131363704);
    L50:
        if (r110 == null) goto L52;
        View r111 = r110.findViewById(2131363748);
    L53:
        if (r111 == null) goto L55;
        r111.setVisibility(0);
    L55:
        View r112 = getView();
        if (r112 == null) goto L58;
        LinearLayout r113 = (LinearLayout) r112.findViewById(2131363704);
    L59:
        if (r113 == null) goto L61;
        View r114 = r113.findViewById(2131363748);
    L62:
        if (r114 == null) goto L64;
        UDAvatar r20 = (UDAvatar) r114.findViewById(2131392467);
    L65:
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r20, r3.getUser_avatar_url(), r3.getUser_id());
        View r21 = getView();
        if (r21 == null) goto L68;
        LinearLayout r22 = (LinearLayout) r21.findViewById(2131363704);
    L69:
        if (r22 == null) goto L71;
        View r23 = r22.findViewById(2131363748);
    L72:
        if (r23 == null) goto L74;
        r10 = (TextView) r23.findViewById(2131363719);
    L74:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.TextView");
        r10.setText(r3.getUser_name());
        r10.setMaxWidth(r4);
        goto L105
    L71:
        r23 = null;
        goto L72
    L68:
        r22 = null;
        goto L69
    L64:
        r20 = null;
        goto L65
    L61:
        r114 = null;
        goto L62
    L58:
        r113 = null;
        goto L59
    L52:
        r111 = null;
        goto L53
    L48:
        r110 = null;
        goto L50
    L13:
        if (r2 != 2) goto L105;
        View r115 = getView();
        if (r115 == null) goto L18;
        LinearLayout r116 = (LinearLayout) r115.findViewById(2131363704);
    L20:
        if (r116 == null) goto L22;
        View r117 = r116.findViewById(2131363740);
    L23:
        if (r117 == null) goto L25;
        r117.setVisibility(0);
    L25:
        View r118 = getView();
        if (r118 == null) goto L28;
        LinearLayout r119 = (LinearLayout) r118.findViewById(2131363704);
    L29:
        if (r119 == null) goto L31;
        View r120 = r119.findViewById(2131363740);
    L32:
        if (r120 == null) goto L34;
        UDAvatar r24 = (UDAvatar) r120.findViewById(2131392467);
    L35:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
        ba0(r24, r3.getUser_avatar_url(), r3.getUser_id());
        View r25 = getView();
        if (r25 == null) goto L38;
        LinearLayout r26 = (LinearLayout) r25.findViewById(2131363704);
    L39:
        if (r26 == null) goto L41;
        View r27 = r26.findViewById(2131363740);
    L42:
        if (r27 == null) goto L44;
        r10 = (TextView) r27.findViewById(2131363719);
    L44:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.TextView");
        r10.setText(r3.getUser_name());
        r10.setMaxWidth(r4);
        goto L105
    L41:
        r27 = null;
        goto L42
    L38:
        r26 = null;
        goto L39
    L34:
        r24 = null;
        goto L35
    L31:
        r120 = null;
        goto L32
    L28:
        r119 = null;
        goto L29
    L22:
        r117 = null;
        goto L23
    L18:
        r116 = null;
    L105:
        r2 = r2 + 1;
        goto L4
    }

    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        Bundle r13 = getArguments();
        if (r13 == null) goto L35;
        this.h = r13.getString("extra_token", "");
        this.i = r13.getInt("extra_type");
        this.j = r13.getString("extra_secret_label_id", "");
        this.k = r13.getString("extra_name", "");
        this.l = r13.getInt("extra_level");
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        jdb.g r1 = com.bytedance.ee.bear.middleground.permission.b.d(LarkContext.getApplication());
        if (r1 == null) goto L7;
        boolean r2 = r1.isEnable("ccm.permission.secret_level_searchable_tip");
    L8:
        tt5.a.h("PermFGUtils", "isEnableSecretLevelSearchableTip()...isEnable = " + r2);
        if (Intrinsics.areEqual(Boolean.valueOf(r2), Boolean.TRUE) == false) goto L11;
        this.m = r13.getString("apply_tips", "");
    L11:
        this.n = r13.getString("apply_tips_v2");
        this.o = r13.getBoolean("enable_share_external", false);
        this.p = r13.getBoolean("no_editing", false);
        this.q = r13.getString("extra_wiki_token", "");
        if (r13.getSerializable("extra_old_secret") == null) goto L15;
        Serializable r3 = r13.getSerializable("extra_old_secret");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.secret.SecretLevel");
        this.r = (SecretLevel) r3;
    L15:
        if (r13.getSerializable("extra_new_secret") == null) goto L18;
        Serializable r4 = r13.getSerializable("extra_new_secret");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.secret.SecretLevel");
        this.s = (SecretLevel) r4;
    L18:
        if (r13.getSerializable("extra_def_model") == null) goto L41;
        Object r5 = r13.getSerializable("extra_def_model");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel");
        this.t = (SecretApprovalDefModel) r5;
    L41:
        Serializable r14 = r13.getSerializable("extra_ext_params");     // Catch: Exception -> L33
        ApprovalDialogCallbacks r6 = null;
        if ((r14 instanceof Map) == false) goto L23;
        Map<String, ? extends Serializable> r15 = (Map) r14;     // Catch: Exception -> L33
    L24:
        this.v = r15;     // Catch: Exception -> L33
        if (r15 == null) goto L27;
        Serializable r16 = r15.get("lynx_call_back");     // Catch: Exception -> L33
    L29:
        if ((r16 instanceof ApprovalDialogCallbacks) == false) goto L31;
        r6 = (ApprovalDialogCallbacks) r16;     // Catch: Exception -> L33
    L31:
        this.w = r6;     // Catch: Exception -> L33
        goto L35
    L27:
        r16 = null;
        goto L29
    L23:
        r15 = null;
    L33:
        e = move-exception;
        tt5.a.e("InputReasonFragment", "onCreate, deserialize extParams failed", e, false);
        goto L35
    L7:
        r2 = false;
    L35:
        boolean r17 = this.t.isIs_open();
        String r7 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r8 = new JSONObject();
        String r9 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r10 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L38;
        String r11 = ThumbGlideUrl.SOURCE_VC;
    L39:
        com.bytedance.ee.bear.middleground.permission.c.a(r8, r9, r10, r11, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r8.put("is_check_open", r17);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_security_demotion_view", r8);
        return;
    L38:
        r11 = "none";
        goto L39
    }

    public static final Object Z90(InputReasonFragment r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof InputReasonFragment$observeSecretPushOnce$1) == false) goto L7;
        InputReasonFragment$observeSecretPushOnce$1 r0 = (InputReasonFragment$observeSecretPushOnce$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: TimeoutCancellationException -> L14
    L54:
        tt5.a.b("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, called back before timeout");     // Catch: TimeoutCancellationException -> L14
    L59:
        bu5.a r13 = (bu5.a) r4.element;
        if (r13 == null) goto L62;
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, coroutine finished, unregister RnPush");
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r13);
    L63:
        r4.element = null;
        return Unit.INSTANCE;
    L62:
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, coroutine finished, RnPush is null");
    L14:
        TimeoutCancellationException e2 = e;
    L58:
        tt5.a.e("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, push listener timeout", e2, false);
        goto L59
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        SecretApprovalDefModel r14 = r10.t;
        ArrayList<SecretApprovalDefModel.Reviewer> r5 = r14.getCcUsers();
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L35;
        ArrayList<SecretApprovalDefModel.Reviewer> r15 = r14.getReviewers();
        if (r15 != null) goto L29;
    L32:
        boolean r16 = true;
    L33:
        if (r16 == false) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == true) goto L39;
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, not CC only.");
        return Unit.INSTANCE;
    L39:
        if (idb.f.a().isCurrentEnable("ccm.mobile.subscribe_secret_level_updated") == true) goto L42;
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, FG is off.");
        return Unit.INSTANCE;
    L42:
        if (r10.h.length() != 0) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L47;
    L64:
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, invalid params.");
        return Unit.INSTANCE;
    L47:
        if (r10.i < 0) goto L64;
        tt5.a.h("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, create RnPush.");
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        tt5.a.b("InputReasonFragment", "(" + r10 + ") observeSecretPushOnce, will start timeout timer.");     // Catch: TimeoutCancellationException -> L56
        CoroutineDispatcher r7 = Dispatchers.getIO();     // Catch: TimeoutCancellationException -> L56
        InputReasonFragment$observeSecretPushOnce$2 r8 = new InputReasonFragment$observeSecretPushOnce$2(r10, r19, null);     // Catch: TimeoutCancellationException -> L56
        r0.L$0 = r19;     // Catch: TimeoutCancellationException -> L56
        r0.label = 1;     // Catch: TimeoutCancellationException -> L56
        if (BuildersKt.withContext(r7, r8, r0) == r2) goto L73;
        r4 = r19;
        goto L54
    L73:
        return r2;
    L56:
        e = move-exception;
        r4 = r19;
        e2 = e;
        goto L58
    L44:
        r18 = false;
        goto L45
    L29:
        if (r15.isEmpty() == true) goto L32;
        r16 = false;
    L35:
        r17 = false;
        goto L36
    L21:
        if (r5.isEmpty() == true) goto L24;
        r6 = false;
    L7:
        r0 = new InputReasonFragment$observeSecretPushOnce$1(r10, r11);
        goto L8
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r11, r12);
        ((BaseTitleBar) r11.findViewById(2131388775)).setLeftClickListener(new c(r11, this));
        ((SpaceEditText) r11.findViewById(2131375324)).addTextChangedListener(new d(r11, this));
        r11.findViewById(2131365115).setOnClickListener(new e(r11, this));
        r11.findViewById(2131369397).setOnClickListener(new f(r11, this));
        ((SecretViewModel) this.x.getValue()).getUpdateSecLiveData().observe(this, new g(this, r11));
        ((SecretViewModel) this.x.getValue()).getEscapeRuleLiveData().observe(this, new h(this));
        Boolean r13 = com.bytedance.ee.bear.middleground.permission.b.i();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r1) == false) goto L30;
        View r14 = getView();
        if (r14 == null) goto L7;
        RelativeLayout r15 = (RelativeLayout) r14.findViewById(2131384692);
    L8:
        if (r15 == null) goto L10;
        r15.setVisibility(0);
    L10:
        View r16 = getView();
        if (r16 == null) goto L13;
        BearLottieView r17 = r16.findViewById(2131378988);
    L14:
        if (r17 == null) goto L16;
        r17.setVisibility(0);
    L16:
        View r18 = getView();
        if (r18 == null) goto L19;
        BearLottieView r19 = (BearLottieView) r18.findViewById(2131378988);
    L20:
        if (r19 == null) goto L22;
        r19.playAnimation();
    L22:
        View r110 = getView();
        if (r110 == null) goto L25;
        NestedScrollView r111 = r110.findViewById(2131381074);
    L26:
        if (r111 == null) goto L28;
        r111.setVisibility(8);
    L28:
        ((SecretViewModel) this.x.getValue()).fetchEscapeRule(this.h, this.i);
        goto L30
    L25:
        r111 = null;
        goto L26
    L19:
        r19 = null;
        goto L20
    L13:
        r17 = null;
        goto L14
    L7:
        r15 = null;
    L30:
        if (this.t.isSuccess() == false) goto L108;
        if (this.t.isIs_open() == false) goto L108;
        if (TextUtils.isEmpty(this.t.getApproval_code()) == true) goto L108;
        View r112 = getView();
        if (r112 == null) goto L39;
        TextView r113 = (TextView) r112.findViewById(2131370181);
    L40:
        if (r113 == null) goto L59;
        ArrayList<SecretApprovalDefModel.Reviewer> r6 = this.t.getReviewers();
        ArrayList<SecretApprovalDefModel.Reviewer> r7 = this.t.getCcUsers();
        int r8 = b0.a;
        Application r9 = eu5.b.a;
        if (r6 == null) goto L50;
        if (r6.size() <= 0) goto L50;
        if (r6.size() != 1) goto L48;
        String r10 = r9.getString(2131889914);
    L57:
        r113.setText(r10);
        goto L59
    L48:
        r10 = r9.getString(2131889907);
    L50:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L56;
        if (r7 != null) goto L53;
    L55:
        r10 = r9.getString(2131888710);
        Intrinsics.checkNotNull(r10);
        goto L57
    L53:
        if (r7.size() <= 0) goto L55;
        r10 = r9.getString(2131889718);
        Intrinsics.checkNotNull(r10);
        goto L57
    L56:
        r10 = r9.getString(2131888710);
    L59:
        if (this.t.getReviewers() == null) goto L63;
        if (this.t.getReviewers().size() <= 0) goto L63;
    L68:
        View r114 = getView();
        if (r114 == null) goto L71;
        LinearLayout r115 = (LinearLayout) r114.findViewById(2131363704);
    L72:
        if (r115 == null) goto L74;
        r115.setVisibility(0);
    L74:
        View r116 = getView();
        if (r116 == null) goto L77;
        LinearLayout r117 = (LinearLayout) r116.findViewById(2131363704);
    L78:
        if (r117 == null) goto L80;
        View r118 = r117.findViewById(2131363722);
    L81:
        if (r118 == null) goto L83;
        r118.setVisibility(8);
    L83:
        View r119 = getView();
        if (r119 == null) goto L86;
        LinearLayout r120 = (LinearLayout) r119.findViewById(2131363704);
    L87:
        if (r120 == null) goto L89;
        View r121 = r120.findViewById(2131363748);
    L90:
        if (r121 == null) goto L92;
        r121.setVisibility(8);
    L92:
        View r122 = getView();
        if (r122 == null) goto L95;
        LinearLayout r123 = (LinearLayout) r122.findViewById(2131363704);
    L96:
        if (r123 == null) goto L98;
        View r124 = r123.findViewById(2131363740);
    L99:
        if (r124 == null) goto L102;
        r124.setVisibility(8);
    L102:
        if (this.t.getReviewers() != null) goto L104;
    L106:
        da0(this.t.getCcUsers());
        goto L108
    L104:
        if (this.t.getReviewers().size() <= 0) goto L106;
        da0(this.t.getReviewers());
        goto L108
    L98:
        r124 = null;
        goto L99
    L95:
        r123 = null;
        goto L96
    L89:
        r121 = null;
        goto L90
    L86:
        r120 = null;
        goto L87
    L80:
        r118 = null;
        goto L81
    L77:
        r117 = null;
        goto L78
    L71:
        r115 = null;
    L63:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L108;
        if (this.t.getCcUsers() == null) goto L108;
        if (this.t.getCcUsers().size() <= 0) goto L108;
    L39:
        r113 = null;
    L108:
        if (this.p == false) goto L148;
        View r125 = getView();
        if (r125 == null) goto L112;
        BaseTitleBar r126 = (BaseTitleBar) r125.findViewById(2131388775);
    L113:
        if (r126 == null) goto L115;
        r126.setTitle(2131888907);
    L115:
        SecretLevel r127 = this.s;
        if (r127 != null) goto L118;
    L130:
        View r128 = getView();
        if (r128 == null) goto L133;
        FrameLayout r129 = (FrameLayout) r128.findViewById(2131375355);
    L134:
        if (r129 == null) goto L136;
        r129.setVisibility(8);
    L136:
        View r130 = getView();
        if (r130 == null) goto L139;
        UDButton r131 = r130.findViewById(2131369397);
    L140:
        if (r131 == null) goto L142;
        r131.setEnabled(true);
    L142:
        View r132 = getView();
        if (r132 == null) goto L145;
        UDButton r133 = r132.findViewById(2131369397);
    L146:
        if (r133 == null) goto L167;
        r133.setText(getString(2131895971));
    L167:
        aa0();
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.h, this.i, getDialog());
        return;
    L145:
        r133 = null;
        goto L146
    L139:
        r131 = null;
        goto L140
    L133:
        r129 = null;
        goto L134
    L118:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.i(), r1) == false) goto L130;
        SecretLevel r2 = this.r;
        if (r2 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("oldSerretLevel");
        r2 = null;
    L123:
        if (r2.getLevel() <= r127.getLevel()) goto L130;
        View r134 = getView();
        if (r134 == null) goto L127;
        BaseTitleBar r135 = (BaseTitleBar) r134.findViewById(2131388775);
    L128:
        if (r135 == null) goto L130;
        r135.setTitle(2131889717);
        goto L130
    L127:
        r135 = null;
        goto L128
    L112:
        r126 = null;
        goto L113
    L148:
        View r136 = getView();
        if (r136 == null) goto L151;
        BaseTitleBar r137 = (BaseTitleBar) r136.findViewById(2131388775);
    L152:
        if (r137 == null) goto L167;
        ArrayList<SecretApprovalDefModel.Reviewer> r138 = this.t.getReviewers();
        ArrayList<SecretApprovalDefModel.Reviewer> r0 = this.t.getCcUsers();
        int r3 = b0.a;
        Application r4 = eu5.b.a;
        if (r138 == null) goto L159;
        if (r138.size() <= 0) goto L159;
        String r139 = r4.getString(2131889894);
    L166:
        r137.setTitle(r139);
    L159:
        if (com.bytedance.ee.bear.middleground.permission.b.n() == false) goto L165;
        if (r0 != null) goto L162;
    L164:
        r139 = r4.getString(2131887380);
        Intrinsics.checkNotNull(r139);
        goto L166
    L162:
        if (r0.size() <= 0) goto L164;
        r139 = r4.getString(2131889894);
        goto L166
    L165:
        r139 = r4.getString(2131887380);
        goto L166
    L151:
        r137 = null;
        goto L152
    }

    public final void ba0(UDAvatar r3, String r4, String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Glide.with(this).load(new BearGlideUrl(r4)).placeholder(2131235295).into(r3);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r3.setOnClickListener(new b(r5));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564173, r3, false);
    }
}
