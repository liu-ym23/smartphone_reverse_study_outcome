package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;
    public final /* synthetic */ BitableAtEditText b;

    public static final class a implements com.ss.android.lark.utils.h.e {
        public final /* synthetic */ BitableSuperAgentPanel a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ BitableAtEditText c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.superagent.g$a$a, reason: collision with other inner class name */
        public static final class C0026a<T> implements Consumer {
            public final /* synthetic */ BitableSuperAgentPanel a;
            public final /* synthetic */ BitableAtEditText b;

            public C0026a(BitableSuperAgentPanel r1, BitableAtEditText r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                db5.a r5 = (db5.a) r4;
                if (this.a.isAdded() == true) goto L5;
                return;
            L5:
                if (this.a.getView() == null) goto L10;
                List r6 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(r5);
                int r0 = RangesKt.coerceAtLeast(this.b.getSelectionStart(), 0);
                JSONObject r1 = new JSONObject();
                r1.put("contentJson", r6);
                r1.put("cursorPosition", Integer.valueOf(r0));
                this.a.ha0(MobileSuperAgentAction.START_VOICE_INPUT.getValue(), r1);
                BitableSuperAgentPanel r7 = this.a;
                JSONObject r2 = new JSONObject();
                r2.put("type", "click");
                r2.put(JSEventListener.ACTION, "voice_input");
                Unit r3 = Unit.INSTANCE;
                r7.ia0("bitable.superagent.track", r2);
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
                tt5.a.e(r0, "read atContent for startVoice failed", (Throwable) r4, false);
            }
        }

        public a(BitableSuperAgentPanel r1, FragmentActivity r2, BitableAtEditText r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(boolean r4) {
            if (this.a.isAdded() == true) goto L5;
        L12:
            tt5.a.h(this.a.t, "onVoiceClick: fragment detached, skip");
            return;
        L5:
            if (this.a.getView() == null) goto L12;
            if (r4 == true) goto L10;
            tt5.a.h(this.a.t, "onVoiceClick: audio permission denied");
            UDToast.show(this.b, 2131886588, 2131243840);
            return;
        L10:
            Single r5 = this.c.getPresenter().r();
            BitableSuperAgentPanel r1 = this.a;
            r5.subscribe(new C0026a(r1, this.c), new b(r1));
        }
    }

    public g(BitableSuperAgentPanel r1, BitableAtEditText r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BitableSuperAgentPanel r5 = this.a;
        if (r5.v == false) goto L5;
        tt5.a.h(r5.t, "onVoiceClick: stopVoiceInput");
        this.a.ha0(MobileSuperAgentAction.STOP_VOICE_INPUT.getValue(), null);
        BitableSuperAgentPanel r6 = this.a;
        JSONObject r0 = new JSONObject();
        r0.put("type", "click");
        r0.put(JSEventListener.ACTION, "stop_answer");
        Unit r1 = Unit.INSTANCE;
        r6.ia0("bitable.superagent.track", r0);
        return;
    L5:
        tt5.a.h(r5.t, "onVoiceClick: startVoiceInput");
        FragmentActivity r7 = this.a.getActivity();
        if (r7 != null) goto L8;
        return;
    L8:
        AudioRecordHelper r2 = AudioRecordHelper.a;
        AudioRecordHelper.c(r7, new a(this.a, r7, this.b));
    }
}
