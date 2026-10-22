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
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.databinding.BitableSuperagentPanelInputBinding;
import com.bytedance.ee.bear.bitable.superagent.at.BitableSuperAgentAtView;
import com.bytedance.ee.bear.bitable.superagent.voice.BitableSuperAgentVoiceStateButton;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010!H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u0019H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentPanel;", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "<init>", "()V", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "isGenerating", "", "isRecording", "panelHistory", "Landroidx/appcompat/widget/AppCompatImageView;", "panelAddChat", "panelClose", "collapsedInputSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "expandedInputSet", "typingDotSpan", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentTypingDotSpan;", "atWindow", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtWindow;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "applyConversationPayload", "data", "Lorg/json/JSONObject;", "saveInputSet", "setupTitle", "setupInputExpansion", "notifyComposerFocus", "isFocused", "refreshSendUi", "injectMention", "dispatchVoiceInput", "applyVoiceInputPayload", "payload", "refreshRecordingInputUi", "attachTypingDot", "detachTypingDot", "setVoiceMode", "status", "onStart", "handleBackPressed", "onDestroy", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentPanel extends BitableSuperAgentBasePanel {
    public com.bytedance.ee.bear.bitable.superagent.at.h A;
    public final String t;
    public boolean u;
    public boolean v;
    public AppCompatImageView w;
    public ConstraintSet x;
    public ConstraintSet y;
    public ev4.a z;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ BitableSuperAgentPanel a;

        public b(BitableSuperAgentPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 == 4) goto L5;
        L7:
            return false;
        L5:
            if (r3.getAction() != 1) goto L7;
            tt5.a.h(this.a.t, "onBackKeyUp");
            return BitableSuperAgentPanel.ja0(this.a);
        }
    }

    static {
    }

    public BitableSuperAgentPanel() {
        this.t = "BitableSuperAgentPanel#" + hashCode();
    }

    public final void ka0() {
        if (getView() != null) goto L5;
        return;
    L5:
        BitableSuperagentPanelInputBinding r0 = ea0().d;
        ConstraintLayout r1 = r0.d;
        BitableAtEditText r2 = r0.c;
        AppCompatImageView r3 = r0.e;
        boolean r4 = this.u;
        boolean r5 = this.v;
        Editable r6 = r2.getText();
        boolean r7 = false;
        if (r6 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        boolean r9 = !r8;
        if (r2.hasFocus() == true) goto L18;
        if (r9 == true) goto L18;
        if (r5 == true) goto L18;
        boolean r10 = false;
    L19:
        if (r10 == false) goto L21;
        ConstraintSet r11 = this.y;
    L22:
        if (r11 == null) goto L24;
        r11.applyTo(r1);
    L24:
        if (r10 == false) goto L27;
        int r12 = 12;
    L26:
        int r13 = com.bytedance.ee.util.ui.n.d(r12);
        com.bytedance.ee.bear.bitable.m.q(r1, Integer.valueOf(r13), null, Integer.valueOf(r13), null);
        int r14 = 2131232379;
        if (r4 == false) goto L35;
        boolean r16 = !r5;
        com.bytedance.ee.bear.bitable.m.z(r3, true);
        r3.setEnabled(r16);
        r3.setImageResource(2131253749);
        r3.setBackgroundResource(2131232379);
        Context r17 = r3.getContext();
        if (r16 == false) goto L33;
        int r18 = 2131108730;
    L34:
        r3.setImageTintList(ContextCompat.getColorStateList(r17, r18));
        int r19 = com.bytedance.ee.util.ui.n.d(10);
        r3.setPadding(r19, r19, r19, r19);
        return;
    L33:
        r18 = 2131108721;
        goto L34
    L35:
        if (r9 == true) goto L39;
        if (r10 == true) goto L39;
        com.bytedance.ee.bear.bitable.m.z(r3, false);
        return;
    L39:
        if (r5 == true) goto L42;
        if (r9 == false) goto L42;
        r7 = true;
    L42:
        com.bytedance.ee.bear.bitable.m.z(r3, true);
        r3.setEnabled(r7);
        r3.setImageResource(2131255630);
        if (r7 == false) goto L45;
        r14 = 2131232380;
    L45:
        r3.setBackgroundResource(r14);
        r3.setImageTintList(ContextCompat.getColorStateList(r3.getContext(), 2131109013));
        r3.setPadding(com.bytedance.ee.util.ui.n.d(11), r3.getPaddingTop(), com.bytedance.ee.util.ui.n.d(9), r3.getPaddingBottom());
        return;
    L27:
        r12 = 24;
        goto L26
    L21:
        r11 = this.x;
    L18:
        r10 = true;
        goto L19
    L8:
        if (r6.length() == 0) goto L11;
        r8 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        ev4.a r0 = this.z;
        if (r0 == null) goto L5;
        r0.e.stop();
    L5:
        ha0(MobileSuperAgentAction.EXIT_CONVERSATION.getValue(), null);
        String r1 = MobileSuperAgentAction.MODULE_DID_EXIT.getValue();
        JSONObject r2 = new JSONObject();
        r2.put("moduleId", MobileSuperAgentModuleId.CONVERSATION.getValue());
        r2.put("lifecycleId", this.p);
        Unit r3 = Unit.INSTANCE;
        ha0(r1, r2);
        r r4 = this.r;
        if (r4 == null) goto L9;
        r4.forcePortrait();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        r r0 = this.r;
        if (r0 == null) goto L5;
        r0.forcePortraitAndLock();
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        r1.setOnKeyListener(new b(this));
    L8:
        ea0().e.setOnTouchUp(new AnonymousClass2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final String fa0() {
        return this.t;
    }

    public static final boolean ja0(BitableSuperAgentPanel r4) {
        BitableAtEditText r0 = r4.ea0().d.c;
        String r1 = r4.t;
        StringBuilder r2 = new StringBuilder("handleBackPressed: atShowing=");
        com.bytedance.ee.bear.bitable.superagent.at.h r3 = r4.A;
        if (r3 == null) goto L5;
        Boolean r5 = Boolean.valueOf(r3.g);
    L6:
        r2.append(r5);
        r2.append(", hasFocus=");
        r2.append(r0.hasFocus());
        tt5.a.h(r1, r2.toString());
        com.bytedance.ee.bear.bitable.superagent.at.h r6 = r4.A;
        if (r6 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        if (r7 == false) goto L16;
        if (r6 == null) goto L20;
        r6.j();
        return true;
    L20:
        return true;
    L16:
        if (r0.hasFocus() == false) goto L18;
        rcb.c.d(r0);
        r0.clearFocus();
        return true;
    L18:
        return false;
    L9:
        if (r6.g != true) goto L11;
        r7 = true;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final void ba0(org.json.JSONObject r6) {
        super.ba0(r6);
        if (r6 == null) goto L11;
        org.json.JSONObject r2 = r6.optJSONObject("data");
        if (r2 == null) goto L11;
        org.json.JSONObject r3 = r2.optJSONObject("data");
        if (r3 == null) goto L11;
        org.json.JSONObject r4 = r3.optJSONObject("state");
        if (r4 == null) goto L11;
        String r5 = r4.optString("threadId");
    L13:
        if (com.larksuite.component.card.utils.k.b(r5) == false) goto L17;
        AppCompatImageView r7 = this.w;
        if (r7 == null) goto L17;
        com.bytedance.ee.bear.bitable.m.z(r7, true);
    L17:
        boolean r8 = false;
        if (r6 == null) goto L28;
        org.json.JSONObject r9 = r6.optJSONObject("data");
        if (r9 == null) goto L28;
        org.json.JSONObject r10 = r9.optJSONObject("data");
        if (r10 == null) goto L28;
        org.json.JSONObject r11 = r10.optJSONObject("state");
        if (r11 == null) goto L28;
        ChatStatus r0 = ChatStatus.FINISHED;
        if (r11.optInt("status", r0.getValue()) != r0.getValue()) goto L28;
        r8 = true;
    L28:
        boolean r12 = !r8;
        if (r12 == this.u) goto L32;
        this.u = r12;
        ka0();
        return;
    L32:
        return;
    L11:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        int r5 = q.a;
        tt5.a.h("SuperAgentSettings", "config loaded, disableWidgetSender=" + q.a().d() + ", disableWidgetRender=" + q.a().c() + ", onlyLowDevice=" + q.a().e() + ", disableFabCarouselAnim=" + q.a().a() + ", disableLandingGlowAnim=" + q.a().b());
        String r6 = MobileSuperAgentAction.MODULE_DID_ENTER.getValue();
        JSONObject r0 = new JSONObject();
        r0.put("moduleId", MobileSuperAgentModuleId.CONVERSATION.getValue());
        r0.put("lifecycleId", this.p);
        Unit r1 = Unit.INSTANCE;
        ha0(r6, r0);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        com.bytedance.ee.bear.bitable.m.z(ea0().c, true);
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L5;
        ea0().c.addView(new KeyboardPlaceholderView(r9), new LinearLayout.LayoutParams(-1, -2));
    L5:
        ConstraintLayout r10 = ea0().d.d;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(r10);
        ConstraintSet r11 = new ConstraintSet();
        r11.clone(r0);
        r11.connect(2131364237, 6, 0, 6);
        r11.connect(2131364237, 7, 0, 7);
        r11.clear(2131364237, 4);
        r11.connect(2131364236, 3, 2131364237, 4);
        r11.connect(2131364239, 3, 2131364237, 4);
        r11.connect(2131364240, 3, 2131364237, 4);
        this.x = r0;
        this.y = r11;
        AppCompatImageView r12 = ea0().i;
        r12.setImageResource(2131254879);
        Intrinsics.checkNotNull(r12);
        com.bytedance.ee.bear.bitable.m.z(r12, true);
        AppCompatImageView r1 = ea0().j;
        r1.setImageResource(2131254123);
        Intrinsics.checkNotNull(r1);
        com.bytedance.ee.bear.bitable.m.z(r1, true);
        AppCompatImageView r2 = ea0().k;
        r2.setImageResource(2131253533);
        Intrinsics.checkNotNull(r2);
        com.bytedance.ee.bear.bitable.m.z(r2, false);
        this.w = r2;
        ea0().g.setText(getString(2131886094));
        r1.setOnClickListener(new m(this));
        r12.setOnClickListener(new n(this));
        r2.setOnClickListener(new o(this));
        BitableSuperagentPanelInputBinding r13 = ea0().d;
        BitableAtEditText r3 = r13.c;
        BitableSuperAgentVoiceStateButton r4 = r13.f;
        AppCompatImageView r5 = r13.e;
        AppCompatImageView r14 = r13.b;
        r3.setOnPasteListener(r3.getPresenter());
        r3.getPresenter().j = null;
        r3.setCopyAtMentionEnable(true);
        r3.E(null, f.a);
        r4.setOnClickListener(new g(this, r3));
        r14.setOnClickListener(new h(this, r3));
        r5.setOnClickListener(new i(this, r3));
        r3.setOnFocusChangeListener(new j(this));
        r3.setOnClickListener(new k(this));
        r3.addTextChangedListener(new l(this));
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L9;
        BitableAtEditText r17 = ea0().d.c;
        BitableSuperAgentAtView r6 = ea0().b;
        com.bytedance.ee.bear.bitable.superagent.at.h r18 = new com.bytedance.ee.bear.bitable.superagent.at.h(r16, this.o, r6, this.q);
        e r19 = new e(this, r17);
        Intrinsics.checkNotNullParameter(r19, "callback");
        r18.f = r19;
        r17.setAtWindow(r18);
        this.A = r18;
    L9:
        ca0(13, "bitable.update.conversation");
    }
}
