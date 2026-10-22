package ly4;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment$setTipTextStyle$underLineSpan$1;
import com.bytedance.ee.bear.facade.common.widget.u;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;
    public final /* synthetic */ TextView d;
    public final /* synthetic */ float e;
    public final /* synthetic */ Ref.ObjectRef<String> f;
    public final /* synthetic */ LocalCoverSelectionFragment g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.element == false) goto L5;
        return;
    L5:
        int r0 = this.b;
        float r1 = r0 - (this.c % r0);
        int r2 = this.d.getLineCount();
        double r3 = Math.ceil(this.c / this.b);
        if (r1 < (this.e * 1.5f)) goto L8;
    L10:
        final LocalCoverSelectionFragment r4 = this.g;
        TextView r5 = this.d;
        String r6 = ((String) this.f.element) + this.h;
        String r7 = (String) this.f.element;
        String r8 = this.i;
        int r9 = LocalCoverSelectionFragment.g;
        r4.getClass();
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        r10.append(r6);
        r10.setSpan(new d(r8), r7.length(), r6.length(), 33);
        r10.setSpan(new LocalCoverSelectionFragment$setTipTextStyle$underLineSpan$1(r4), r7.length(), r6.length(), 33);
        r10.setSpan(new ForegroundColorSpan(r4.getResources().getColor(2131106607)), 0, r7.length(), 33);
        r5.setText(r10);
        r5.setMovementMethod(u.a());
        this.a.element = true;
        return;
    L8:
        if (r3 < r2) goto L10;
        this.f.element = ((String) this.f.element) + '\n';
        goto L10
    }

    public c(Ref.BooleanRef r1, int r2, float r3, TextView r4, float r5, Ref.ObjectRef<String> r6, LocalCoverSelectionFragment r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
