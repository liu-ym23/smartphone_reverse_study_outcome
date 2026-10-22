package rca;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricCardItemStyleClockBinding;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsCardItemClockStyle f537185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CharSequence f537186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CharSequence f537187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f537188d;

    public e(AbsCardItemClockStyle r100, CharSequence r101, CharSequence r102, boolean r103) {
        this.f537185a = r100;
        this.f537186b = r101;
        this.f537187c = r102;
        this.f537188d = r103;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        AbsCardItemClockStyle r109 = this.f537185a;
        int r110 = AbsCardItemClockStyle.f386424u;
        int r111 = ((ObricCardItemStyleClockBinding) r109.f386391a).f386136f.getWidth();
        float r112 = ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386137g.getPaint().measureText(this.f537186b.toString());
        ViewGroup.LayoutParams r113 = ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386138h.getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        int r115 = (((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386138h.getMeasuredWidth() + r114.getMarginStart()) + r114.getMarginEnd();
        int r116 = this.f537185a.getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
        if (r111 <= 0) goto L20;
        float r117 = r111;
        if (r112 > r117) goto L20;
        if (this.f537187c.length() != 0) goto L10;
        boolean r118 = true;
    L11:
        if (r118 == true) goto L19;
        float r119 = r115;
        if (((r112 + r119) + r116) > r117) goto L19;
        if (this.f537188d == false) goto L18;
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386135e.setMaxWidth((int) ((r117 - r112) - r119));
    L18:
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386136f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386135e.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386138h.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386137g.setVisibility(0);
        return;
    L19:
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386136f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386135e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386138h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386137g.setVisibility(0);
        return;
    L10:
        r118 = false;
    L20:
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386136f.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386135e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386138h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f537185a.f386391a).f386137g.setVisibility(8);
    }
}
