package ia4;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f488908b;

    public d(a.b r100, a r101) {
        this.f488908b = r100;
        this.f488907a = r101;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        this.f488908b.f488900f.onClick(this.f488907a.f488875b, r102);
        this.f488908b.getClass();
        this.f488907a.f488875b.dismiss();
    }
}
