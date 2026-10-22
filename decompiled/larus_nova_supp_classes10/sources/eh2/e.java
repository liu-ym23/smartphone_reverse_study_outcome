package eh2;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements TextWatcher {
    public final /* synthetic */ ECBindCouponFragment a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public e(ECBindCouponFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r4, int r5, int r6, int r7) {
        int r8 = 0;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (this.a.getContext() != null) goto L7;
        return;
    L7:
        ECBindCouponFragment r9 = this.a;
        r9.k.setTextColor(th.a.a(r9.getContext(), 2131101601));
        this.a.k.setEnabled(true);
        this.a.l.setVisibility(8);
        this.a.m.setVisibility(8);
        this.a.r.setVisibility(0);
        StringBuilder r10 = new StringBuilder();
        String r11 = r4.toString().replace(" ", "");
    L9:
        if (r8 > (r11.length() / 4)) goto L11;
        int r12 = r8 * 4;
        r10.append(r11.subSequence(r12, Math.min(r12 + 4, r11.length())));
        r10.append(" ");
        r8 = r8 + 1;
        goto L9
    L11:
        this.a.j.removeTextChangedListener(this);
        String r13 = r10.toString().trim();
        this.a.j.setText(r13);
        this.a.j.setSelection(r13.length());
        this.a.j.addTextChangedListener(this);
        return;
    L13:
        if (this.a.getContext() != null) goto L15;
        return;
    L15:
        ECBindCouponFragment r14 = this.a;
        r14.k.setTextColor(th.a.a(r14.getContext(), 2131101702));
        ECBindCouponFragment r15 = this.a;
        r15.w = null;
        r15.o.setVisibility(8);
        this.a.l.setVisibility(0);
        ECBindCouponFragment r16 = this.a;
        r16.l.setText(r16.u);
        this.a.k.setEnabled(false);
        this.a.r.setVisibility(8);
    }
}
