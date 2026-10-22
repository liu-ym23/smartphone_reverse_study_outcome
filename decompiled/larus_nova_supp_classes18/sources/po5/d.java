package po5;

import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements hw4.d {
    public final /* synthetic */ mo5.g a;
    public final /* synthetic */ TtsOptionsView b;
    public final /* synthetic */ mo5.a c;

    public static final class a implements mo5.b {
        public final /* synthetic */ float a;
        public final /* synthetic */ mo5.a b;

        public a(float r1, mo5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // mo5.b
        public final void a(TtsResult r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            tt5.a.h("TtsChangeSpeedCommand", "handleAction, onClick speed: " + this.a + ", result: " + r3);
            mo5.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.g(r3);
            return;
        }
    }

    public final void a(int r3, CommonMorePanelItemData r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        Float r5 = StringsKt.toFloatOrNull(r4.a);
        if (r5 == null) goto L5;
        float r6 = r5.floatValue();
    L6:
        this.a.k(r6, new a(r6, this.c));
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L16;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L5:
        r6 = 1.0f;
        goto L6
    }

    public d(mo5.g r1, TtsOptionsView r2, mo5.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
