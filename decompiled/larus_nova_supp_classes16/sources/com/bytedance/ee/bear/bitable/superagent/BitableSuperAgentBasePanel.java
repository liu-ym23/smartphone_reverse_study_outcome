package com.bytedance.ee.bear.bitable.superagent;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.databinding.BitableSuperagentBasePanelBinding;
import com.bytedance.ee.bear.bitable.databinding.BitableSuperagentPanelInputBinding;
import com.bytedance.ee.bear.bitable.superagent.at.BitableSuperAgentAtView;
import com.bytedance.ee.bear.bitable.superagent.voice.BitableSuperAgentVoiceStateButton;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.q1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J$\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020>2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u00020:H\u0002J\b\u0010G\u001a\u00020:H\u0016J\b\u0010H\u001a\u00020:H\u0016J\b\u0010I\u001a\u00020:H\u0016J\u0010\u0010J\u001a\u00020:2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010P\u001a\u00020:2\b\u0010Q\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010R\u001a\u00020:2\b\u0010S\u001a\u0004\u0018\u00010\u001fH\u0014J\u001c\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH\u0004J\u001c\u0010X\u001a\u00020:2\u0006\u0010U\u001a\u00020\f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH\u0004J\b\u0010Y\u001a\u00020:H\u0002J\u001c\u0010Z\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\fH\u0004J\b\u0010^\u001a\u00020:H\u0002J\u0012\u0010_\u001a\u00020:2\b\u0010S\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010`\u001a\u00020:H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\fX¤\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010K\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bL\u0010M¨\u0006b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "Lcom/bytedance/ee/bear/bitable/anniex/xbridge/common/ILynxBitableClosePageInterface;", "<init>", "()V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableSuperagentBasePanelBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableSuperagentBasePanelBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableSuperagentBasePanelBinding;)V", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "dragView", "Lcom/bytedance/ee/bear/facade/common/widget/DraggerView;", "lynxViewHolder", "Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "getLynxViewHolder", "()Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "setLynxViewHolder", "(Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;)V", "isLoadSuccess", "", "()Z", "setLoadSuccess", "(Z)V", "pendingConversation", "Lorg/json/JSONObject;", "nativeToLynxMethod", "props", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentProps;", "getProps", "()Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentProps;", "setProps", "(Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentProps;)V", "baseId", "getBaseId", "setBaseId", "lifecycleId", "getLifecycleId", "setLifecycleId", "execJS", "Lcom/bytedance/ee/bear/bitable/common/web/IWebJSExecutor;", "getExecJS", "()Lcom/bytedance/ee/bear/bitable/common/web/IWebJSExecutor;", "setExecJS", "(Lcom/bytedance/ee/bear/bitable/common/web/IWebJSExecutor;)V", "delegate", "Lcom/bytedance/ee/bear/bitable/superagent/IBitableSuperAgentDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/superagent/IBitableSuperAgentDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/superagent/IBitableSuperAgentDelegate;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "addWatermark", "onResume", "onDestroy", "closePage", "init", "user", "getUser", "()Lorg/json/JSONObject;", "user$delegate", "Lkotlin/Lazy;", "dispatchConversation", "obj", "applyConversationPayload", "data", "sendToJS", JSEventListener.ACTION, "extra", "Lcom/alibaba/fastjson/JSONObject;", "sendToLynx", "setupDrag", "bindLynxView", "viewType", "", "lynxUpdateMethod", "flushPendingInputEvents", "sendConversation", "releaseLynxView", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BitableSuperAgentBasePanel extends BaseDialogFragment implements ko4.e {
    public BitableSuperagentBasePanelBinding h;
    public com.bytedance.ee.bear.facade.common.widget.e i;
    public BitableLynxViewHolder j;
    public boolean k;
    public JSONObject l;
    public String m;
    public p n;
    public String o;
    public String p;
    public r q;
    public r r;
    public final Lazy s;

    public static final class a {
    }

    public static final class b extends q1 {
        public final /* synthetic */ BitableSuperAgentBasePanel a;

        public static final class a implements Runnable {
            public final /* synthetic */ BitableSuperAgentBasePanel a;

            public a(BitableSuperAgentBasePanel r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BitableSuperAgentBasePanel r0 = this.a;     // Catch: Throwable -> L16
                if (r0.k == false) goto L19;
                JSONObject r1 = r0.l;     // Catch: Throwable -> L16
                if (r1 == null) goto L23;
                r0.l = null;     // Catch: Throwable -> L16
                BitableLynxViewHolder r2 = r0.j;     // Catch: Throwable -> L16
                if (r2 == null) goto L24;
                String r3 = r0.m;     // Catch: Throwable -> L16
                if (r3 == null) goto L25;
                r2.k(r3, CollectionsKt.listOf(r1.toString()));     // Catch: Throwable -> L16
                return;
            L25:
                return;
            L24:
                return;
            L23:
                return;
            L19:
                return;
            L16:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L26;
                throw th;
            }
        }

        public final void onLoadSuccess() {
            tt5.a.h(this.a.fa0(), "lynx onLoadSuccess");
            BitableSuperAgentBasePanel r0 = this.a;
            r0.k = true;
            com.bytedance.ee.util.ui.j.c(new a(r0));
        }

        public b(BitableSuperAgentBasePanel r1) {
            this.a = r1;
        }

        public final void onLoadFailed(String r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            tt5.a.h(this.a.fa0(), "lynx onLoadFailed: " + r4);
        }
    }

    public static final class c implements zm4.a {
        public final /* synthetic */ BitableSuperAgentBasePanel a;

        public c(BitableSuperAgentBasePanel r1) {
            this.a = r1;
        }

        public final void a(String r4) {
            tt5.a.h(this.a.fa0(), "lifecycle onLoadFailed: " + r4);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BitableSuperAgentBasePanel a;

        public d(BitableSuperAgentBasePanel r1) {
            this.a = r1;
        }

        public final void a() {
            BitableSuperAgentBasePanel r0 = this.a;
            if (r0.i != null) goto L13;
            Context r1 = r0.getContext();
            if (r1 == null) goto L14;
            LinearLayout r2 = r0.ea0().f;
            float r3 = r2.getHeight();
            if (r3 <= 0.0f) goto L15;
            com.bytedance.ee.bear.facade.common.widget.e r4 = new com.bytedance.ee.bear.facade.common.widget.e(r1, r2, r3);
            r4.a = 0.7f;
            r4.b = 0.7f;
            r4.j = false;
            r4.i(r0.ea0().h);
            r4.h = new com.bytedance.ee.bear.bitable.superagent.b(r0);
            r0.i = r4;
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BitableSuperAgentBasePanel a;

        public e(BitableSuperAgentBasePanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(this.a.fa0(), "onScrimClick");
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public abstract String fa0();

    public final BitableSuperagentBasePanelBinding ea0() {
        BitableSuperagentBasePanelBinding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public BitableSuperAgentBasePanel() {
        this.o = "";
        this.p = "";
        this.s = LazyKt.lazy(BitableSuperAgentBasePanel$user$2.INSTANCE);
    }

    public final void closePage() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public void onDestroy() {
        super.onDestroy();
        tt5.a.h(fa0(), "onDestroy");
        BitableLynxViewHolder r0 = this.j;
        if (r0 == null) goto L10;
        r0.b();
        this.j = null;
        if (this.h == null) goto L8;
        ea0().e.removeAllViews();
    L8:
        this.l = null;
        this.k = false;
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h(fa0(), "onResume");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        tt5.a.h(fa0(), "onStart");
        Dialog r0 = getDialog();
        if (r0 == null) goto L9;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setLayout(-1, -1);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.dimAmount = 0.5f;
        r2.windowAnimations = 2131951906;
        r1.setAttributes(r2);
        r1.addFlags(2);
        r1.addFlags(512);
        r1.addFlags(67108864);
        r1.setSoftInputMode(16);
        ea0().f.post(new d(this));
        FrameLayout r3 = ea0().a;
        r3.post(new com.bytedance.ee.bear.bitable.superagent.a(this, r3));
        return;
    L10:
        return;
    }

    public void ba0(JSONObject r2) {
        if (r2 == null) goto L10;
        JSONObject r3 = r2.optJSONObject("data");
        if (r3 == null) goto L10;
        JSONObject r4 = r3.optJSONObject("data");
        if (r4 == null) goto L10;
        JSONObject r5 = r4.optJSONObject("state");
        if (r5 == null) goto L10;
        String r6 = r5.optString("title");
    L12:
        if (com.larksuite.component.card.utils.k.b(r6) == false) goto L15;
        ea0().g.setText(r6);
        return;
    L15:
        return;
    L10:
        r6 = null;
        goto L12
    }

    public final void da0(JSONObject r6) {
        JSONObject r0 = new JSONObject();
        boolean r2 = false;
        r0.put("code", 0);
        r0.put("msg", "");
        JSONObject r1 = new JSONObject();
        r1.put("data", r6);
        r1.put("landingUser", (JSONObject) this.s.getValue());
        if (q.a().c() == true) goto L5;
    L9:
        r1.put("disableWidget", r2);
        Unit r7 = Unit.INSTANCE;
        r0.put("data", r1);
        if (this.h == null) goto L13;
        ba0(r0);
    L13:
        if (this.k == false) goto L21;
        BitableLynxViewHolder r8 = this.j;
        if (r8 == null) goto L24;
        String r3 = this.m;
        if (r3 == null) goto L25;
        r8.k(r3, CollectionsKt.listOf(r0.toString()));
        return;
    L25:
        return;
    L24:
        return;
    L21:
        this.l = r0;
        return;
    L5:
        if (q.a().e() == true) goto L7;
    L8:
        r2 = true;
        goto L9
    L7:
        if (DevicePerfUtils.f() == false) goto L9;
        goto L8
    }

    public final void ga0(p r3) {
        this.n = r3;
        String r0 = "";
        if (r3 == null) goto L6;
        String r1 = r3.a;
        if (r1 == null) goto L6;
    L7:
        this.o = r1;
        if (r3 == null) goto L13;
        String r2 = r3.b;
        if (r2 == null) goto L13;
        r0 = r2;
    L13:
        this.p = r0;
        r r4 = null;
        if (r3 == null) goto L16;
        r r5 = r3.c;
    L17:
        this.r = r5;
        if (r3 == null) goto L20;
        r4 = r3.c;
    L20:
        this.q = r4;
        return;
    L16:
        r5 = null;
    L6:
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        tt5.a.h(fa0(), "onCreate");
        aa0(2131100548);
    }

    public final boolean ca0(int r12, String r13) {
        if (this.j == null) goto L5;
        return true;
    L5:
        Context r0 = getContext();
        if (r0 != null) goto L8;
        return false;
    L8:
        fo4.a r3 = new fo4.a(r0, r12);
        JSONObject r14 = this.l;
        if (r14 == null) goto L11;
        r3.a(TemplateData.fromString(r14.toString()));
        this.l = null;
    L11:
        LynxGroup r16 = LynxGroup.Create("BITABLE_SUPER_AGENT_LYNX_GROUP", "BITABLE_SUPER_AGENT_LYNX_GROUP", null, false, true, true, true);
        Intrinsics.checkNotNullParameter(r16, "group");
        r3.g = r16;
        b r17 = new b(this);
        Intrinsics.checkNotNullParameter(r17, "lynxViewClient");
        r3.e = r17;
        c r18 = new c(this);
        Intrinsics.checkNotNullParameter(r18, "lifecycle");
        r3.d = r18;
        go4.a r19 = new go4.a(r0);
        Intrinsics.checkNotNullParameter(r19, "fetcher");
        r3.h = r19;
        BitableLynxViewHolder r110 = eo4.a.a(r3);
        View r1 = r110.c(true);
        if (r1 != null) goto L15;
        tt5.a.d(fa0(), "create lynx view failed for SuperAgentPanel");
        r110.b();
        return false;
    L15:
        BitableSuperAgentLynxContainer r2 = ea0().e;
        r2.removeAllViews();
        r2.addView(r1, new ViewGroup.LayoutParams(-1, -1));
        r110.i(ko4.e.class, this);
        r r4 = this.q;
        if (r4 == null) goto L18;
        r110.i(or4.a.class, r4);
    L18:
        r110.h(new cv4.a(getParentFragmentManager(), this.n));
        this.m = r13;
        this.j = r110;
        return true;
    }

    public final void ha0(String r4, com.alibaba.fastjson.JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject();
        r1.put(JSEventListener.ACTION, r4);
        r1.put("baseId", this.o);
        if (r5 == null) goto L5;
        r1.putAll(r5);
    L5:
        tt5.a.h(fa0(), "sendToJS, action: " + r4 + ", baseId: " + this.o);
        r r6 = this.q;
        if (r6 == null) goto L9;
        r6.a("javascript:window.lark.bitable.super.agent.action", r1, null);
        return;
    }

    public final void ia0(String r5, com.alibaba.fastjson.JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, JSEventListener.ACTION);
        BitableLynxViewHolder r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject();
        r1.put("code", 0);
        r1.put("msg", "");
        r1.put("data", r6);
        r0.k(r5, CollectionsKt.listOf(r1.toString()));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ba0(this.l);
        ea0().l.setOnClickListener(new e(this));
        ea0().f.setClickable(true);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        LayoutInflater r1 = LayoutInflater.from(r0);
        if (r1 == null) goto L6;
    L7:
        View r2 = r1.inflate(2131559167, r18, false);
        int r3 = 2131363295;
        BitableSuperAgentAtView r5 = (BitableSuperAgentAtView) ViewBindings.findChildViewById(r2, 2131363295);
        if (r5 == null) goto L46;
        r3 = 2131364235;
        if (ViewBindings.findChildViewById(r2, 2131364235) == null) goto L46;
        r3 = 2131364241;
        if (ViewBindings.findChildViewById(r2, 2131364241) == null) goto L46;
        r3 = 2131364242;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131364242);
        if (r6 == null) goto L46;
        r3 = 2131364243;
        UDShadowLayout r4 = ViewBindings.findChildViewById(r2, 2131364243);
        if (r4 == null) goto L46;
        int r7 = 2131364236;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r4, 2131364236);
        if (r9 == null) goto L45;
        r7 = 2131364237;
        BitableAtEditText r10 = ViewBindings.findChildViewById(r4, 2131364237);
        if (r10 == null) goto L45;
        r7 = 2131364238;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r4, 2131364238);
        if (r11 == null) goto L45;
        r7 = 2131364239;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r4, 2131364239);
        if (r12 == null) goto L45;
        r7 = 2131364240;
        BitableSuperAgentVoiceStateButton r13 = (BitableSuperAgentVoiceStateButton) ViewBindings.findChildViewById(r4, 2131364240);
        if (r13 == null) goto L45;
        BitableSuperagentPanelInputBinding r8 = new BitableSuperagentPanelInputBinding(r4, r9, r10, r11, r12, r13);
        int r14 = 2131364244;
        BitableSuperAgentLynxContainer r16 = (BitableSuperAgentLynxContainer) ViewBindings.findChildViewById(r2, 2131364244);
        if (r16 == null) goto L48;
        r14 = 2131364245;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131364245);
        if (r20 == null) goto L48;
        r14 = 2131364246;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r2, 2131364246);
        if (r110 == null) goto L48;
        r14 = 2131364247;
        ConstraintLayout r111 = ViewBindings.findChildViewById(r2, 2131364247);
        if (r111 == null) goto L48;
        r14 = 2131364248;
        AppCompatImageView r112 = ViewBindings.findChildViewById(r2, 2131364248);
        if (r112 == null) goto L48;
        r14 = 2131364249;
        AppCompatImageView r113 = ViewBindings.findChildViewById(r2, 2131364249);
        if (r113 == null) goto L48;
        r14 = 2131364250;
        AppCompatImageView r114 = ViewBindings.findChildViewById(r2, 2131364250);
        if (r114 == null) goto L48;
        FrameLayout r115 = (FrameLayout) r2;
        BitableSuperagentBasePanelBinding r21 = new BitableSuperagentBasePanelBinding(r115, r5, r6, r8, r16, r20, r110, r111, r112, r113, r114, r115);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        this.h = r21;
        return ea0().a;
    L48:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r14)));
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r7)));
    L46:
        r14 = r3;
    L6:
        r1 = r17;
        goto L7
    }
}
