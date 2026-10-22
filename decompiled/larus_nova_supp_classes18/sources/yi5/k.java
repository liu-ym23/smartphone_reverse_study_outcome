package yi5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Observer<Boolean> {
    public final /* synthetic */ PrivacyFragment a;

    public k(PrivacyFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        PrivacyFragment r0 = this.a;
        boolean r5 = ((Boolean) r4).booleanValue();
        r0.j.setOnCheckedChangeListener(null);
        r0.j.setChecked(r5);
        r0.j.setOnCheckedChangeListener(new h(r0));
    }
}
