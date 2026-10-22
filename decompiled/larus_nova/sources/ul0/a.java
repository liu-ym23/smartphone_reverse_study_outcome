package ul0;

import android.view.View;
import com.bytedance.android.live.lynx.ui.paidlive.LynxLiveFeature;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLiveFeature f550589a;

    public a(LynxLiveFeature r100) {
        this.f550589a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LynxLiveFeature r101 = this.f550589a;
        if (r101.f82754m == false) goto L11;
        com.bytedance.ies.xelement.live.a r102 = r101.f250108a;
        if (r102 == null) goto L12;
        HashMap<String, Object> r103 = r101.f82753l;
        if (r103 != null) goto L9;
        r103 = new HashMap();
    L9:
        r102.b(r103);
        return;
    L12:
        return;
    }
}
