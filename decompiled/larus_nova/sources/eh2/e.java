package eh2;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECBindCouponFragment f472648a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public e(ECBindCouponFragment r100) {
        this.f472648a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        int r104 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L13;
        if (this.f472648a.getContext() != null) goto L7;
        return;
    L7:
        ECBindCouponFragment r105 = this.f472648a;
        r105.f147657k.setTextColor(th.a.a(r105.getContext(), R.color.ec_color_action_text));
        this.f472648a.f147657k.setEnabled(true);
        this.f472648a.f147658l.setVisibility(8);
        this.f472648a.f147659m.setVisibility(8);
        this.f472648a.f147664r.setVisibility(0);
        StringBuilder r106 = new StringBuilder();
        String r107 = r100.toString().replace(" ", "");
    L9:
        if (r104 > (r107.length() / 4)) goto L11;
        int r108 = r104 * 4;
        r106.append(r107.subSequence(r108, Math.min(r108 + 4, r107.length())));
        r106.append(" ");
        r104 = r104 + 1;
        goto L9
    L11:
        this.f472648a.f147656j.removeTextChangedListener(this);
        String r109 = r106.toString().trim();
        this.f472648a.f147656j.setText(r109);
        this.f472648a.f147656j.setSelection(r109.length());
        this.f472648a.f147656j.addTextChangedListener(this);
        return;
    L13:
        if (this.f472648a.getContext() != null) goto L15;
        return;
    L15:
        ECBindCouponFragment r110 = this.f472648a;
        r110.f147657k.setTextColor(th.a.a(r110.getContext(), R.color.ec_color_unable_text));
        ECBindCouponFragment r111 = this.f472648a;
        r111.f147669w = null;
        r111.f147661o.setVisibility(8);
        this.f472648a.f147658l.setVisibility(0);
        ECBindCouponFragment r112 = this.f472648a;
        r112.f147658l.setText(r112.f147667u);
        this.f472648a.f147657k.setEnabled(false);
        this.f472648a.f147664r.setVisibility(8);
    }
}
