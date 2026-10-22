package r6a;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q6a.a f536384a;

    public a(q6a.a r100) {
        this.f536384a = r100;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout r100, int r101) {
        q6a.a r102 = this.f536384a;
        boolean r103 = true;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r100.getTotalScrollRange() + r101) <= 0) goto L10;
        r103 = false;
    L10:
        o6a.a r105 = (o6a.a) r102;
        r105.f522219g = r104;
        r105.f522220h = r103;
        return;
    L5:
        r104 = false;
        goto L7
    }
}
