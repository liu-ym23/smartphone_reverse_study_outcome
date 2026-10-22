package t94;

import android.view.View;
import com.bytedance.bdp.appbase.locate.map.BdpMapActivity;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpMapActivity f545085a;

    public f(BdpMapActivity r100) {
        this.f545085a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f545085a.finish();
    }
}
