package com.bytedance.ee.bear.bitable.superagent.cardexpand;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel;
import com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentAction;
import com.bytedance.ee.bear.bitable.superagent.r;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.card.utils.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/cardexpand/CardExpandPanel;", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "<init>", "()V", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "panelBack", "Landroidx/appcompat/widget/AppCompatImageView;", "panelRotate", "panelCopy", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "applyConversationPayload", "data", "Lorg/json/JSONObject;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "applyPanelStyleByOrientation", "orientation", "", "onStart", "onDestroy", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardExpandPanel extends BitableSuperAgentBasePanel {
    public final String t;
    public AppCompatImageView u;
    public AppCompatImageView v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CardExpandPanel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(CardExpandPanel r1, String r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            j.e(this.a.t, "panelCopy click");
            CardExpandPanel r9 = this.a;
            String r0 = MobileSuperAgentAction.COPY_TABLE_CARD.getValue();
            JSONObject r1 = new JSONObject();
            String r2 = this.b;
            String r3 = this.c;
            String r4 = this.d;
            String r5 = this.e;
            r1.put("baseId", r2);
            r1.put("tableId", r3);
            r1.put("jobId", r4);
            r1.put("processId", r5);
            Unit r6 = Unit.INSTANCE;
            r9.ha0(r0, r1);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CardExpandPanel a;

        public b(CardExpandPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            j.e(this.a.t, "panelBack click");
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CardExpandPanel a;

        public c(CardExpandPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            j.e(this.a.t, "panelRotate click");
            r r3 = this.a.r;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }
    }

    public CardExpandPanel() {
        this.t = "CardExpandPanel#" + hashCode();
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        r r0 = this.r;
        if (r0 == null) goto L6;
        r0.forcePortraitAndLock();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        r r0 = this.r;
        if (r0 == null) goto L6;
        r0.forcePortrait();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final String fa0() {
        return this.t;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final void ba0(org.json.JSONObject r8) {
        org.json.JSONObject r0 = null;
        if (r8 == null) goto L18;
        org.json.JSONObject r2 = r8.optJSONObject("data");
        if (r2 == null) goto L18;
        org.json.JSONObject r3 = r2.optJSONObject("data");
        if (r3 == null) goto L18;
        org.json.JSONObject r4 = r3.optJSONObject("data");
        if (r4 == null) goto L18;
        String r5 = r4.optString("title");
        if (r5 == null) goto L18;
        if (k.b(r5) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
    L19:
        ea0().g.setText(r5);
        if (r8 == null) goto L26;
        org.json.JSONObject r6 = r8.optJSONObject("data");
        if (r6 == null) goto L26;
        org.json.JSONObject r7 = r6.optJSONObject("data");
        if (r7 == null) goto L26;
        String r9 = r7.optString("cardType");
    L28:
        if (Intrinsics.areEqual(r9, "DATA_QA_TABLE") == false) goto L37;
        org.json.JSONObject r10 = r8.optJSONObject("data");
        if (r10 == null) goto L34;
        org.json.JSONObject r11 = r10.optJSONObject("data");
        if (r11 == null) goto L34;
        r0 = r11.optJSONObject("copyTableCardParams");
    L34:
        if (r0 == null) goto L38;
        String r12 = r0.optString("baseId");
        String r13 = r0.optString("tableId");
        String r14 = r0.optString("jobId");
        String r16 = r0.optString("processId");
        AppCompatImageView r17 = ea0().k;
        r17.setImageResource(2131253723);
        Intrinsics.checkNotNull(r17);
        m.z(r17, true);
        r17.setOnClickListener(new a(this, r12, r13, r14, r16));
        return;
    L38:
        return;
    L37:
        return;
    L26:
        r9 = null;
    L18:
        r5 = "";
        goto L19
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r5);
        int r6 = r5.orientation;
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6 != 2) goto L13;
        Dialog r7 = getDialog();
        if (r7 == null) goto L12;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L12;
        r8.addFlags(1024);
    L12:
        m.u(ea0().f, 0, false);
        ea0().f.setBackgroundColor(r0.getResources().getColor(2131100548));
        return;
    L13:
        Dialog r9 = getDialog();
        if (r9 == null) goto L18;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L18;
        r10.clearFlags(1024);
    L18:
        m.u(ea0().f, n.d(60), false);
        ea0().f.setBackgroundResource(2131232318);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ConstraintLayout r6 = ea0().h;
        ConstraintSet r7 = new ConstraintSet();
        r7.clone(r6);
        r7.setHorizontalBias(2131364246, 0.0f);
        r7.setMargin(2131364246, 6, n.d(46));
        r7.applyTo(r6);
        AppCompatImageView r8 = ea0().i;
        r8.setImageResource(2131254998);
        m.z(r8, true);
        this.u = r8;
        AppCompatImageView r9 = ea0().j;
        r9.setImageResource(2131255605);
        m.z(r9, true);
        this.v = r9;
        ImageView r10 = this.u;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("panelBack");
        r10 = null;
    L5:
        r10.setOnClickListener(new b(this));
        ImageView r11 = this.v;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("panelRotate");
        r11 = null;
    L8:
        r11.setOnClickListener(new c(this));
        ca0(14, null);
    }
}
