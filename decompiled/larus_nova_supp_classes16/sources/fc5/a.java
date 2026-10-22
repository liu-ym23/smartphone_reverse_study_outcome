package fc5;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import db5.g;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Consumer<g> {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ c c;

    public final void accept(Object r6) throws Exception {
        c r0 = this.c;
        int r1 = this.a;
        int r2 = this.b;
        SpannableStringBuilder r7 = ((g) r6).a;
        Editable r3 = r0.a.getText();
        if (r1 >= 0) goto L5;
    L11:
        tt5.a.d("HyperLinkProcessorV2", "replace entire failed");
        return;
    L5:
        if (r1 > r3.length()) goto L11;
        if (r2 > r3.length()) goto L11;
        if (r1 > r2) goto L11;
        r0.b.Sw();
        r3.replace(r1, r2, r7);
        r0.b.gr();
    }

    public a(c r1, int r2, int r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
