package com.bytedance.ee.bear.bitable.superagent.subconversation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel;
import com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentAction;
import com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentModuleId;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/subconversation/SubConversationPanel;", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentBasePanel;", "<init>", "()V", "sTAG", "", "getSTAG", "()Ljava/lang/String;", "setSTAG", "(Ljava/lang/String;)V", "panelClose", "Landroidx/appcompat/widget/AppCompatImageView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubConversationPanel extends BitableSuperAgentBasePanel {
    public final String t;
    public AppCompatImageView u;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SubConversationPanel a;

        public b(SubConversationPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(this.a.t, "onCloseClick");
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

    static {
    }

    public SubConversationPanel() {
        this.t = "SubConversationPanel#" + hashCode();
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        ha0(MobileSuperAgentAction.EXIT_SUB_CONVERSATION.getValue(), null);
        String r0 = MobileSuperAgentAction.MODULE_DID_EXIT.getValue();
        JSONObject r1 = new JSONObject();
        r1.put("moduleId", MobileSuperAgentModuleId.SUB_CONVERSATION.getValue());
        r1.put("lifecycleId", this.p);
        Unit r2 = Unit.INSTANCE;
        ha0(r0, r1);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel
    public final String fa0() {
        return this.t;
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        String r5 = MobileSuperAgentAction.MODULE_DID_ENTER.getValue();
        JSONObject r0 = new JSONObject();
        r0.put("moduleId", MobileSuperAgentModuleId.SUB_CONVERSATION.getValue());
        r0.put("lifecycleId", this.p);
        Unit r1 = Unit.INSTANCE;
        ha0(r5, r0);
    }

    @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentBasePanel, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        AppCompatImageView r4 = ea0().j;
        r4.setImageResource(2131254123);
        m.z(r4, true);
        this.u = r4;
        ea0().g.setText(getString(2131886088));
        ImageView r5 = this.u;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("panelClose");
        r5 = null;
    L5:
        r5.setOnClickListener(new b(this));
        ca0(16, "bitable.update.subConversation");
    }
}
