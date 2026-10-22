package com.bytedance.ee.bear.bitable.superagent;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.databinding.BitableSuperagentPanelInputBinding;
import com.bytedance.ee.bear.bitable.superagent.at.BitableSuperAgentAtView;
import com.bytedance.ee.bear.bitable.superagent.voice.BitableSuperAgentVoiceStateButton;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010!H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u0019H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentPanel;", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "<init>", "()V", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "isGenerating", "", "isRecording", "panelHistory", "Landroidx/appcompat/widget/AppCompatImageView;", "panelAddChat", "panelClose", "collapsedInputSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "expandedInputSet", "typingDotSpan", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentTypingDotSpan;", "atWindow", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtWindow;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "applyConversationPayload", "data", "Lorg/json/JSONObject;", "saveInputSet", "setupTitle", "setupInputExpansion", "notifyComposerFocus", "isFocused", "refreshSendUi", "injectMention", "dispatchVoiceInput", "applyVoiceInputPayload", WsConstants.KEY_PAYLOAD, "refreshRecordingInputUi", "attachTypingDot", "detachTypingDot", "setVoiceMode", "status", WidgetCostModule.TYPE_ON_START, "handleBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentPanel extends BitableSuperAgentBasePanel {
    public com.bytedance.ee.bear.bitable.superagent.at.h A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f215757t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f215758u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f215759v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AppCompatImageView f215760w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ConstraintSet f215761x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ConstraintSet f215762y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ev4.a f215763z;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentPanel f215764a;

        public b(BitableSuperAgentPanel r100) {
            this.f215764a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
        L7:
            return false;
        L5:
            if (r102.getAction() != 1) goto L7;
            tt5.a.h(this.f215764a.f215757t, "onBackKeyUp");
            return BitableSuperAgentPanel.ja0(this.f215764a);
        }
    }

    static {
    }

    public BitableSuperAgentPanel() {
        this.f215757t = "BitableSuperAgentPanel#" + hashCode();
    }

    public final void ka0() {
        if (getView() != null) goto L5;
        return;
    L5:
        BitableSuperagentPanelInputBinding r100 = ea0().f211044d;
        ConstraintLayout r101 = r100.f211056d;
        BitableAtEditText r102 = r100.f211055c;
        AppCompatImageView r103 = r100.f211057e;
        boolean r104 = this.f215758u;
        boolean r105 = this.f215759v;
        Editable r106 = r102.getText();
        boolean r107 = false;
        if (r106 != null) goto L8;
    L11:
        boolean r108 = true;
    L12:
        boolean r109 = !r108;
        if (r102.hasFocus() == true) goto L18;
        if (r109 == true) goto L18;
        if (r105 == true) goto L18;
        boolean r110 = false;
    L19:
        if (r110 == false) goto L21;
        ConstraintSet r111 = this.f215762y;
    L22:
        if (r111 == null) goto L24;
        r111.applyTo(r101);
    L24:
        if (r110 == false) goto L27;
        int r112 = 12;
    L26:
        int r113 = com.bytedance.ee.util.ui.n.d(r112);
        com.bytedance.ee.bear.bitable.m.q(r101, Integer.valueOf(r113), null, Integer.valueOf(r113), null);
        int r114 = R.drawable.bitable_superagent_send_disabled_bg;
        if (r104 == false) goto L35;
        boolean r115 = !r105;
        com.bytedance.ee.bear.bitable.m.z(r103, true);
        r103.setEnabled(r115);
        r103.setImageResource(R.drawable.ud_icon_base_agent_stop_filled);
        r103.setBackgroundResource(R.drawable.bitable_superagent_send_disabled_bg);
        Context r116 = r103.getContext();
        if (r115 == false) goto L33;
        int r117 = R.color.ud_N900;
    L34:
        r103.setImageTintList(ContextCompat.getColorStateList(r116, r117));
        int r118 = com.bytedance.ee.util.ui.n.d(10);
        r103.setPadding(r118, r118, r118, r118);
        return;
    L33:
        r117 = R.color.ud_N400;
        goto L34
    L35:
        if (r109 == true) goto L39;
        if (r110 == true) goto L39;
        com.bytedance.ee.bear.bitable.m.z(r103, false);
        return;
    L39:
        if (r105 == true) goto L42;
        if (r109 == false) goto L42;
        r107 = true;
    L42:
        com.bytedance.ee.bear.bitable.m.z(r103, true);
        r103.setEnabled(r107);
        r103.setImageResource(R.drawable.ud_icon_send_colorful);
        if (r107 == false) goto L45;
        r114 = R.drawable.bitable_superagent_send_enabled_bg;
    L45:
        r103.setBackgroundResource(r114);
        r103.setImageTintList(ContextCompat.getColorStateList(r103.getContext(), R.color.udtoken_btn_pri_text_disabled));
        r103.setPadding(com.bytedance.ee.util.ui.n.d(11), r103.getPaddingTop(), com.bytedance.ee.util.ui.n.d(9), r103.getPaddingBottom());
        return;
    L27:
        r112 = 24;
        goto L26
    L21:
        r111 = this.f215761x;
    L18:
        r110 = true;
        goto L19
    L8:
        if (r106.length() == 0) goto L11;
        r108 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ev4.a r100 = this.f215763z;
        if (r100 == null) goto L5;
        r100.f474247e.stop();
    L5:
        ha0(MobileSuperAgentAction.EXIT_CONVERSATION.getValue(), null);
        String r101 = MobileSuperAgentAction.MODULE_DID_EXIT.getValue();
        JSONObject r102 = new JSONObject();
        r102.put2("moduleId", MobileSuperAgentModuleId.CONVERSATION.getValue());
        r102.put2("lifecycleId", this.f215731p);
        Unit r103 = Unit.INSTANCE;
        ha0(r101, r102);
        r r104 = this.f215733r;
        if (r104 == null) goto L9;
        r104.forcePortrait();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        r r100 = this.f215733r;
        if (r100 == null) goto L5;
        r100.forcePortraitAndLock();
    L5:
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        r101.setOnKeyListener(new b(this));
    L8:
        ea0().f211045e.setOnTouchUp(new AnonymousClass2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final String fa0() {
        return this.f215757t;
    }

    public static final boolean ja0(BitableSuperAgentPanel r100) {
        BitableAtEditText r101 = r100.ea0().f211044d.f211055c;
        String r102 = r100.f215757t;
        StringBuilder r103 = new StringBuilder("handleBackPressed: atShowing=");
        com.bytedance.ee.bear.bitable.superagent.at.h r104 = r100.A;
        if (r104 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r104.f215866g);
    L6:
        r103.append(r105);
        r103.append(", hasFocus=");
        r103.append(r101.hasFocus());
        tt5.a.h(r102, r103.toString());
        com.bytedance.ee.bear.bitable.superagent.at.h r106 = r100.A;
        if (r106 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L16;
        if (r106 == null) goto L20;
        r106.j();
        return true;
    L20:
        return true;
    L16:
        if (r101.hasFocus() == false) goto L18;
        rcb.c.d(r101);
        r101.clearFocus();
        return true;
    L18:
        return false;
    L9:
        if (r106.f215866g != true) goto L11;
        r107 = true;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final void ba0(org.json.JSONObject r100) {
        super.ba0(r100);
        if (r100 == null) goto L11;
        org.json.JSONObject r101 = r100.optJSONObject("data");
        if (r101 == null) goto L11;
        org.json.JSONObject r102 = r101.optJSONObject("data");
        if (r102 == null) goto L11;
        org.json.JSONObject r103 = r102.optJSONObject("state");
        if (r103 == null) goto L11;
        String r104 = r103.optString("threadId");
    L13:
        if (com.larksuite.component.card.utils.k.b(r104) == false) goto L17;
        AppCompatImageView r105 = this.f215760w;
        if (r105 == null) goto L17;
        com.bytedance.ee.bear.bitable.m.z(r105, true);
    L17:
        boolean r106 = false;
        if (r100 == null) goto L28;
        org.json.JSONObject r107 = r100.optJSONObject("data");
        if (r107 == null) goto L28;
        org.json.JSONObject r108 = r107.optJSONObject("data");
        if (r108 == null) goto L28;
        org.json.JSONObject r109 = r108.optJSONObject("state");
        if (r109 == null) goto L28;
        ChatStatus r110 = ChatStatus.FINISHED;
        if (r109.optInt("status", r110.getValue()) != r110.getValue()) goto L28;
        r106 = true;
    L28:
        boolean r111 = !r106;
        if (r111 == this.f215758u) goto L32;
        this.f215758u = r111;
        ka0();
        return;
    L32:
        return;
    L11:
        r104 = null;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = q.f215917a;
        tt5.a.h("SuperAgentSettings", "config loaded, disableWidgetSender=" + q.a().d() + ", disableWidgetRender=" + q.a().c() + ", onlyLowDevice=" + q.a().e() + ", disableFabCarouselAnim=" + q.a().a() + ", disableLandingGlowAnim=" + q.a().b());
        String r102 = MobileSuperAgentAction.MODULE_DID_ENTER.getValue();
        JSONObject r103 = new JSONObject();
        r103.put2("moduleId", MobileSuperAgentModuleId.CONVERSATION.getValue());
        r103.put2("lifecycleId", this.f215731p);
        Unit r104 = Unit.INSTANCE;
        ha0(r102, r103);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        com.bytedance.ee.bear.bitable.m.z(ea0().f211043c, true);
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L5;
        ea0().f211043c.addView(new KeyboardPlaceholderView(r102), new LinearLayout.LayoutParams(-1, -2));
    L5:
        ConstraintLayout r103 = ea0().f211044d.f211056d;
        ConstraintSet r104 = new ConstraintSet();
        r104.clone(r103);
        ConstraintSet r105 = new ConstraintSet();
        r105.clone(r104);
        r105.connect(R.id.bitable_superagent_input_edit, 6, 0, 6);
        r105.connect(R.id.bitable_superagent_input_edit, 7, 0, 7);
        r105.clear(R.id.bitable_superagent_input_edit, 4);
        r105.connect(R.id.bitable_superagent_input_at, 3, R.id.bitable_superagent_input_edit, 4);
        r105.connect(R.id.bitable_superagent_input_send, 3, R.id.bitable_superagent_input_edit, 4);
        r105.connect(R.id.bitable_superagent_input_voice, 3, R.id.bitable_superagent_input_edit, 4);
        this.f215761x = r104;
        this.f215762y = r105;
        AppCompatImageView r106 = ea0().f211049i;
        r106.setImageResource(R.drawable.ud_icon_history_outlined);
        Intrinsics.checkNotNull(r106);
        com.bytedance.ee.bear.bitable.m.z(r106, true);
        AppCompatImageView r107 = ea0().f211050j;
        r107.setImageResource(R.drawable.ud_icon_close_outlined);
        Intrinsics.checkNotNull(r107);
        com.bytedance.ee.bear.bitable.m.z(r107, true);
        AppCompatImageView r108 = ea0().f211051k;
        r108.setImageResource(R.drawable.ud_icon_add_chat_ai_outlined);
        Intrinsics.checkNotNull(r108);
        com.bytedance.ee.bear.bitable.m.z(r108, false);
        this.f215760w = r108;
        ea0().f211047g.setText(getString(R.string.Bitable_AISidebar_NewChat_Title_Mob));
        r107.setOnClickListener(new m(this));
        r106.setOnClickListener(new n(this));
        r108.setOnClickListener(new o(this));
        BitableSuperagentPanelInputBinding r109 = ea0().f211044d;
        BitableAtEditText r110 = r109.f211055c;
        BitableSuperAgentVoiceStateButton r111 = r109.f211058f;
        AppCompatImageView r112 = r109.f211057e;
        AppCompatImageView r113 = r109.f211054b;
        r110.setOnPasteListener(r110.getPresenter());
        r110.getPresenter().f208235j = null;
        r110.setCopyAtMentionEnable(true);
        r110.E(null, f.f215890a);
        r111.setOnClickListener(new g(this, r110));
        r113.setOnClickListener(new h(this, r110));
        r112.setOnClickListener(new i(this, r110));
        r110.setOnFocusChangeListener(new j(this));
        r110.setOnClickListener(new k(this));
        r110.addTextChangedListener(new l(this));
        FragmentActivity r114 = getActivity();
        if (r114 == null) goto L9;
        BitableAtEditText r115 = ea0().f211044d.f211055c;
        BitableSuperAgentAtView r116 = ea0().f211042b;
        com.bytedance.ee.bear.bitable.superagent.at.h r117 = new com.bytedance.ee.bear.bitable.superagent.at.h(r114, this.f215730o, r116, this.f215732q);
        e r118 = new e(this, r115);
        Intrinsics.checkNotNullParameter(r118, "callback");
        r117.f215865f = r118;
        r115.setAtWindow(r117);
        this.A = r117;
    L9:
        ca0(13, "bitable.update.conversation");
    }
}
