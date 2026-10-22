package com.bytedance.ee.bear.bitable.superagent;

import android.text.Editable;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;
    public final /* synthetic */ BitableAtEditText b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BitableSuperAgentPanel a;
        public final /* synthetic */ BitableAtEditText b;
        public final /* synthetic */ boolean c;

        public a(BitableSuperAgentPanel r1, BitableAtEditText r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            db5.a r5 = (db5.a) r4;
            if (this.a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.a.getView() == null) goto L13;
            List r6 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(r5);
            JSONObject r0 = new JSONObject();
            boolean r1 = this.c;
            r0.put("contentJson", r6);
            r0.put("disableWidgetSender", Boolean.valueOf(r1));
            this.a.ha0(MobileSuperAgentAction.SEND_MESSAGE.getValue(), r0);
            Editable r7 = this.b.getText();
            if (r7 == null) goto L10;
            r7.clear();
        L10:
            rcb.c.d(this.b);
            this.b.clearFocus();
            this.a.ka0();
            BitableSuperAgentPanel r8 = this.a;
            JSONObject r2 = new JSONObject();
            r2.put("type", "click");
            r2.put(JSEventListener.ACTION, "send_question");
            Unit r3 = Unit.INSTANCE;
            r8.ia0("bitable.superagent.track", r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BitableSuperAgentPanel a;

        public b(BitableSuperAgentPanel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = this.a.t;
            tt5.a.e(r0, "sync text failed ", (Throwable) r4, false);
        }
    }

    public i(BitableSuperAgentPanel r1, BitableAtEditText r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        BitableSuperAgentPanel r6 = this.a;
        if (r6.u == false) goto L6;
        tt5.a.h(r6.t, "onSendClick: stopAnswer");
        this.a.ha0(MobileSuperAgentAction.STOP_ANSWER.getValue(), null);
        return;
    L6:
        if (q.a().d() == true) goto L8;
    L12:
        boolean r7 = false;
    L13:
        tt5.a.h(this.a.t, "onSendClick, disableWidgetSender=" + r7);
        Single r0 = this.b.getPresenter().r();
        BitableSuperAgentPanel r2 = this.a;
        r0.subscribe(new a(r2, this.b, r7), new b(r2));
        return;
    L8:
        if (q.a().e() == true) goto L10;
    L11:
        r7 = true;
        goto L13
    L10:
        if (DevicePerfUtils.f() == false) goto L12;
        goto L11
    }
}
