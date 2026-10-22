package yi5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements Observer<Integer> {
    public final /* synthetic */ PrivacyFragment a;

    public l(PrivacyFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        int r5 = ((Integer) r4).intValue();
        if (r5 != 11) goto L5;
        PrivacyFragment.V90(this.a);
        this.a.W90(true);
        this.a.Y90(true);
    L32:
        PrivacyFragment.V90(this.a);
        return;
    L5:
        if (r5 == 12) goto L32;
        switch(r5) {
            case 0: goto L25;
            case 1: goto L21;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L46;
        };
    L9:
        PrivacyFragment.V90(this.a);
        this.a.W90(true);
        return;
    L10:
        PrivacyFragment.V90(this.a);
        ((HashSet) this.a.x).remove("avatarKey");
        this.a.W90(false);
        if (hu5.a.d(this.a.x) == false) goto L35;
        this.a.X90();
        return;
    L35:
        return;
    L13:
        this.a.n.getData();
        return;
    L14:
        PrivacyFragment.V90(this.a);
        this.a.l.a();
        Toast.showFailureText(this.a.getContext(), com.bytedance.ee.util.ui.n.x(this.a.getContext(), 2131887802));
        PrivacyFragment r6 = this.a;
        boolean r0 = !r6.j.isChecked();
        r6.j.setOnCheckedChangeListener(null);
        r6.j.setChecked(r0);
        r6.j.setOnCheckedChangeListener(new h(r6));
        return;
    L15:
        PrivacyFragment r7 = this.a;
        if (r7.y == true) goto L18;
        r7.l.a();
        this.a.X90();
        return;
    L18:
        PrivacyFragment.V90(r7);
        ((HashSet) this.a.x).remove("privacyKey");
        this.a.Y90(false);
        if (hu5.a.d(this.a.x) == false) goto L40;
        this.a.X90();
        return;
    L40:
        return;
    L21:
        PrivacyFragment r8 = this.a;
        if (r8.y == false) goto L24;
        PrivacyFragment.V90(r8);
        this.a.Y90(true);
    L24:
        this.a.l.a();
        return;
    L25:
        PrivacyFragment r9 = this.a;
        if (r9.y == false) goto L29;
        r9.q.playAnimation();
        return;
    L29:
        if (r9.l.c() == true) goto L44;
        this.a.l.d();
        return;
    L44:
        return;
    }
}
