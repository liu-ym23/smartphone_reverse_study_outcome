package yi5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyFragment f567947a;

    public k(PrivacyFragment r100) {
        this.f567947a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean r100) {
        PrivacyFragment r101 = this.f567947a;
        boolean r102 = r100.booleanValue();
        r101.f234313j.setOnCheckedChangeListener(null);
        r101.f234313j.setChecked(r102);
        r101.f234313j.setOnCheckedChangeListener(new h(r101));
    }
}
