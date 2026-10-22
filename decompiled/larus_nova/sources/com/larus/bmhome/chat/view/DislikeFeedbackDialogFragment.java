package com.larus.bmhome.chat.view;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.databinding.LarusDialogfragDislikeFeedbackBinding;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.x1;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.d;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import po8.g;
import po8.h;
import po8.i;
import po8.j;
import po8.k;
import t19.s;
import v19.o5;
import yc9.m;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J0\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010 H\u0002J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/view/DislikeFeedbackDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogfragDislikeFeedbackBinding;", "conversationType", "", "Ljava/lang/Integer;", "directReportReason", "", "Ljava/lang/Boolean;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "close", "setResult", "manualDismiss", "isSubmit", "selectedTag", "Lcom/larus/bmhome/chat/view/FlowTagLayout$TagBean;", "inputContent", "", LocationMonitorConst.SUBMIT, "copyFeedbackID", "doOnCopy", "logID", "onDestroyView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DislikeFeedbackDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f310328g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogfragDislikeFeedbackBinding f310329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f310330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f310331f;

    public static final class a {
    }

    static {
    }

    public final void close() {
        setResult(true, false, null, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f310329d = null;
    }

    public DislikeFeedbackDialogFragment() {
    }

    public static void S90(DislikeFeedbackDialogFragment r100) {
        LarusDialogfragDislikeFeedbackBinding r101 = r100.f310329d;
        String r102 = null;
        if (r101 == null) goto L7;
        FlowTagLayout r103 = r101.f310867f;
        if (r103 == null) goto L7;
        FlowTagLayout.a r104 = r103.getCurSelectedTagBean();
    L8:
        LarusDialogfragDislikeFeedbackBinding r105 = r100.f310329d;
        if (r105 == null) goto L15;
        NestedScrollEditText r106 = r105.f310866e;
        if (r106 == null) goto L15;
        Editable r107 = r106.getText();
        if (r107 == null) goto L15;
        r102 = r107.toString();
    L15:
        r100.setResult(true, true, r104, r102);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void T90(String r100) {
        ClipData r101 = ClipData.newPlainText("message_log_id", r100);
        Context r102 = getContext();
        if (r102 == null) goto L9;
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L7;
        r103.d0();
        i1 r104 = i1.f346188a;
        Intrinsics.checkNotNull(r101);
        r104.i(r102, r101, "bpea-user-report-message");
    L7:
        s r105 = s.f544207a;
        Context r106 = getContext();
        r105.getClass();
        s.o(r106, R.string.larus_text_copied_tip, false);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        setResult(false, false, null, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(2, R.style.Theme_FlowFullScreenDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogfragDislikeFeedbackBinding r102 = this.f310329d;
        if (r102 == null) goto L54;
        r102.f310865d.setOnClickListener(new g());
        r102.f310868g.setOnClickListener(new h(this));
        r102.f310864c.setOnClickListener(new i(this));
        Bundle r103 = getArguments();
        boolean r104 = false;
        if (r103 == null) goto L10;
        Bundle r105 = r103.getBundle("extra_data");
        if (r105 == null) goto L10;
        r104 = r105.getBoolean("disable_copy_button", false);
    L10:
        if (z2.f365865a.L1() == false) goto L14;
        if (r104 == true) goto L14;
        r102.f310863b.setOnClickListener(new j(this));
    L15:
        r102.f310862a.setOnClickListener(new k(this));
        Bundle r106 = getArguments();
        if (r106 == null) goto L22;
        Bundle r107 = r106.getBundle("extra_data");
        if (r107 == null) goto L22;
        String r108 = r107.getString("feedback_title");
        if (r108 == null) goto L22;
        r102.f310869h.setText(r108);
    L22:
        Bundle r109 = getArguments();
        Integer r110 = null;
        if (r109 == null) goto L25;
        ArrayList r111 = r109.getParcelableArrayList("unlike_feedback_meta_list");
    L26:
        String r112 = "";
        if (r111 == null) goto L36;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r114 = r111.iterator();
    L30:
        if (r114.hasNext() == false) goto L35;
        FeedbackMeta r115 = (FeedbackMeta) r114.next();
        String r116 = r115.b();
        if (r116 != null) goto L34;
        r116 = "";
    L34:
        r113.add(new FlowTagLayout.a(r116, r115.a(), r115));
        goto L30
    L35:
        FlowTagLayout r117 = r102.f310867f;
        int r118 = FlowTagLayout.f310338t;
        r117.a(r113, true);
    L36:
        Bundle r119 = getArguments();
        if (r119 == null) goto L42;
        String r120 = r119.getString("unlike_feedback_placeholder");
        if (r120 == null) goto L42;
        r112 = r120;
    L42:
        r102.f310866e.setHint(r112);
        Bundle r121 = getArguments();
        if (r121 == null) goto L45;
        r110 = Integer.valueOf(r121.getInt("conversation_type"));
    L45:
        this.f310330e = r110;
        Bundle r122 = getArguments();
        if (r122 == null) goto L48;
        Boolean r123 = Boolean.valueOf(r122.getBoolean("direct_report_reason"));
    L49:
        this.f310331f = r123;
        return;
    L48:
        r123 = Boolean.FALSE;
        goto L49
    L25:
        r111 = null;
    L14:
        r102.f310863b.setVisibility(8);
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialogfrag_dislike_feedback, r111, false);
        int r114 = R.id.btn_copy_id;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r113, R.id.btn_copy_id);
        if (r100 == null) goto L26;
        r114 = R.id.btn_submit;
        RoundTextView r101 = (RoundTextView) ViewBindings.findChildViewById(r113, R.id.btn_submit);
        if (r101 == null) goto L26;
        r114 = R.id.container_layout;
        RoundLinearLayout r102 = (RoundLinearLayout) ViewBindings.findChildViewById(r113, R.id.container_layout);
        if (r102 == null) goto L26;
        r114 = R.id.et_input;
        NestedScrollEditText r103 = (NestedScrollEditText) ViewBindings.findChildViewById(r113, R.id.et_input);
        if (r103 == null) goto L26;
        r114 = R.id.flow_tag_layout;
        FlowTagLayout r104 = (FlowTagLayout) ViewBindings.findChildViewById(r113, R.id.flow_tag_layout);
        if (r104 == null) goto L26;
        r114 = R.id.input_container;
        if (((RoundFrameLayout) ViewBindings.findChildViewById(r113, R.id.input_container)) == null) goto L26;
        r114 = R.id.iv_close;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_close);
        if (r105 == null) goto L26;
        r114 = R.id.tv_title;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.tv_title);
        if (r106 == null) goto L26;
        FrameLayout r115 = (FrameLayout) r113;
        LarusDialogfragDislikeFeedbackBinding r116 = new LarusDialogfragDislikeFeedbackBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        Dialog r117 = getDialog();
        if (r117 == null) goto L23;
        Window r118 = r117.getWindow();
        if (r118 == null) goto L23;
        r118.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), android.R.color.transparent)));
    L23:
        this.f310329d = r116;
        return r115;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    private final void setResult(boolean r210, boolean r211, FlowTagLayout.a r212, String r213) {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        Bundle r101 = r100.getBundle("extra_data");
    L6:
        if (r101 == null) goto L9;
        String r102 = r101.getString("feedback_request_key");
        if (r102 == null) goto L9;
    L10:
        Bundle r103 = new Bundle();
        r103.putBoolean("is_submit", r211);
        r103.putBundle("extra_data", r101);
        if (r212 == null) goto L13;
        int r104 = r212.f310359b;
    L14:
        r103.putInt("selected_code", r104);
        if (r212 == null) goto L17;
        Object r105 = r212.f310360c;
    L19:
        if ((r105 instanceof FeedbackMeta) == false) goto L22;
        r103.putParcelable("selected_tag", (Parcelable) r212.f310360c);
    L22:
        if (r213 != null) goto L24;
        String r106 = "";
    L25:
        r103.putString("input_txt", r106);
        Unit r107 = Unit.INSTANCE;
        o5.a(this, r102, r103);
        if (Intrinsics.areEqual(this.f310331f, Boolean.TRUE) == false) goto L47;
        Bundle r108 = getArguments();
        if (r108 == null) goto L32;
        Bundle r109 = r108.getBundle("extra_data");
        if (r109 == null) goto L32;
        String r110 = r109.getString(MusicAppletPage.KEY_MESSAGE_ID);
    L33:
        if (r110 != null) goto L35;
        String r111 = "";
    L36:
        MsgFeedbackType r112 = MsgFeedbackType.MsgFeedbackTypeDislike;
        if (r212 == null) goto L39;
        int r113 = r212.f310359b;
    L41:
        if (r213 != null) goto L43;
        String r114 = "";
    L44:
        d.e().t(new m(null, r111, r112, r113, null, r114, null, null, null, null, this.f310330e, true, null, 5073), null);
        if (r211 == false) goto L47;
        s r115 = s.f544207a;
        Context r116 = getContext();
        r115.getClass();
        s.o(r116, R.string.larus_dislike_feedback_submit_toast, false);
        goto L47
    L43:
        r114 = r213;
        goto L44
    L39:
        r113 = 0;
        goto L41
    L35:
        r111 = r110;
    L32:
        r110 = null;
    L47:
        LarusDialogfragDislikeFeedbackBinding r117 = this.f310329d;
        if (r117 == null) goto L52;
        NestedScrollEditText r118 = r117.f310866e;
        if (r118 == null) goto L52;
        new x1(r118).a(false);
    L52:
        if (r210 == false) goto L62;
        dismissAllowingStateLoss();     // Catch: Exception -> L55
        return;
    L55:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r119 = DialogFragmentLancet.sLastShowStack;
        if (r119 == null) goto L63;
        com.bytedance.crash.d.d(r119, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L63:
        return;
    L62:
        return;
    L24:
        r106 = r213;
        goto L25
    L17:
        r105 = null;
        goto L19
    L13:
        r104 = 0;
    L9:
        r102 = "dislikeDialogClose";
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
