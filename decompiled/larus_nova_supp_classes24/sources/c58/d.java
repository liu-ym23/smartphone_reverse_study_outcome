package c58;

import android.view.MotionEvent;
import com.larus.asr.direct.AsrDirectFillComponent;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ AsrDirectFillComponent a;

    public /* synthetic */ d(AsrDirectFillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        AsrDirectFillComponent r0 = this.a;
        MotionEvent r5 = (MotionEvent) r4;
        int r1 = AsrDirectFillComponent.A;
        Intrinsics.checkNotNullParameter(r5, "it");
        l r2 = r0.U2();
        if (r2 == null) goto L5;
        AsrInputMode r3 = r2.B5();
    L7:
        if (r3 != AsrInputMode.HANDSFREE) goto L10;
        boolean r6 = false;
    L15:
        return Boolean.valueOf(r6);
    L10:
        if (r5.getAction() != 0) goto L13;
        r0.cancel();
    L13:
        r6 = true;
        goto L15
    L5:
        r3 = null;
        goto L7
    }
}
