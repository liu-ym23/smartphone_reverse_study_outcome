package hqa;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gqa.a f486828a;

    public a(gqa.a r100) {
        this.f486828a = r100;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout r100, int r101) {
        gqa.a r102 = this.f486828a;
        boolean r103 = true;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r100.getTotalScrollRange() + r101) <= 0) goto L10;
        r103 = false;
    L10:
        eqa.a r105 = (eqa.a) r102;
        r105.f473556g = r104;
        r105.f473557h = r103;
        return;
    L5:
        r104 = false;
        goto L7
    }
}
