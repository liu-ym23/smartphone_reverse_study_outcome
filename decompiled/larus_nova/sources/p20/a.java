package p20;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.IHybridBaseService;
import com.bytedance.android.live.core.utils.ContextUtil;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f527356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f527357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f527358c;

    public a(String r100, String r101) {
        this.f527356a = r100;
        this.f527357b = true;
        this.f527358c = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FragmentActivity r101 = ContextUtil.contextToFragmentActivity(r100.getContext());
        if (r101 == null) goto L8;
        IHybridBaseService r102 = (IHybridBaseService) k.f(IHybridBaseService.class);
        if (r102 == null) goto L9;
        r102.showHybridDebugFragment(r101, this.f527356a, this.f527357b, this.f527358c);
        return;
    L9:
        return;
    }
}
