package com.bytedance.ee.bear.bitable.superagent.conversationmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel;
import com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentAction;
import com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentModuleId;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/conversationmanager/ConversationManagerPanel;", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "<init>", "()V", "panelBack", "Landroidx/appcompat/widget/AppCompatImageView;", "panelAddChat", "panelClose", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationManagerPanel extends BitableSuperAgentBasePanel {
    public AppCompatImageView t;
    public AppCompatImageView u;
    public AppCompatImageView v;
    public final String w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ConversationManagerPanel a;

        public b(ConversationManagerPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(this.a.w, "onBackClick");
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ConversationManagerPanel a;

        public c(ConversationManagerPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(this.a.w, "onCloseClick");
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ConversationManagerPanel a;

        public d(ConversationManagerPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h(this.a.w, "onAddChatClick");
            this.a.ha0(MobileSuperAgentAction.START_NEW_CONVERSATION.getValue(), null);
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public ConversationManagerPanel() {
        this.w = "ConversationManagerPanel#" + hashCode();
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        ha0(MobileSuperAgentAction.EXIT_CONVERSATION_MANAGER.getValue(), null);
        String r0 = MobileSuperAgentAction.MODULE_DID_EXIT.getValue();
        JSONObject r1 = new JSONObject();
        r1.put("moduleId", MobileSuperAgentModuleId.CONVERSATION_MANAGER.getValue());
        r1.put("lifecycleId", this.p);
        Unit r2 = Unit.INSTANCE;
        ha0(r0, r1);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final String fa0() {
        return this.w;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        String r5 = MobileSuperAgentAction.MODULE_DID_ENTER.getValue();
        JSONObject r0 = new JSONObject();
        r0.put("moduleId", MobileSuperAgentModuleId.CONVERSATION_MANAGER.getValue());
        r0.put("lifecycleId", this.p);
        Unit r1 = Unit.INSTANCE;
        ha0(r5, r0);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        AppCompatImageView r4 = ea0().i;
        r4.setImageResource(2131254998);
        m.z(r4, true);
        this.t = r4;
        AppCompatImageView r5 = ea0().k;
        r5.setImageResource(2131253533);
        m.z(r5, true);
        this.u = r5;
        AppCompatImageView r6 = ea0().j;
        r6.setImageResource(2131254123);
        m.z(r6, true);
        this.v = r6;
        ea0().g.setText(getString(2131886090));
        ImageView r7 = this.t;
        ImageView r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("panelBack");
        r7 = null;
    L5:
        r7.setOnClickListener(new b(this));
        ImageView r9 = this.v;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("panelClose");
        r9 = null;
    L8:
        r9.setOnClickListener(new c(this));
        ImageView r10 = this.u;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("panelAddChat");
    L12:
        r8.setOnClickListener(new d(this));
        ca0(15, "bitable.update.conversationManager");
        BitableLynxViewHolder r11 = this.j;
        if (r11 == null) goto L16;
        r11.h(new dv4.a());
        return;
    L16:
        return;
    L11:
        r8 = r10;
        goto L12
    }
}
