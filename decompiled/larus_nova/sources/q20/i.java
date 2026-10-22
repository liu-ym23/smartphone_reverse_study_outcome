package q20;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.browser.debug.mock.MappingConfigAdapter;
import com.bytedance.android.live.browser.debug.mock.MappingConfigDetailFragment;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MappingConfigAdapter f531347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r20.b f531348b;

    public i(MappingConfigAdapter r100, r20.b r101) {
        this.f531347a = r100;
        this.f531348b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Uri r101 = UriProtector.parse(this.f531348b.f535712a);     // Catch: Exception -> L4
        int r102 = MappingConfigDetailFragment.f62625e;     // Catch: Exception -> L4
        MappingConfigAdapter r103 = this.f531347a;     // Catch: Exception -> L4
        MappingConfigDetailFragment.a.a(r103.f62621b, r103.f62622c, r101);     // Catch: Exception -> L4
        return;
    L4:
        int r104 = MappingConfigDetailFragment.f62625e;
        MappingConfigAdapter r105 = this.f531347a;
        MappingConfigDetailFragment.a.a(r105.f62621b, r105.f62622c, null);
    }
}
