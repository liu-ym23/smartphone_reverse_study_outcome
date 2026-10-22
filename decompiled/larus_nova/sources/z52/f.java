package z52;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f570093a;

    public f(b r100) {
        this.f570093a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f570093a.f570084y.setGiftOpen(r101);
        b r102 = this.f570093a;
        r102.e(r102.f570084y);
        xs2.b.a().post(new q22.b(this.f570093a.f570084y));
    }
}
