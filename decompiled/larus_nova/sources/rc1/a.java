package rc1;

import android.view.View;
import com.bytedance.android.live.vip.adapter.EmojiBubbleAdapter;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiBubbleAdapter f537070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f537071b;

    public a(EmojiBubbleAdapter r100, int r101) {
        this.f537070a = r100;
        this.f537071b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f537071b;
        this.f537070a.getClass();
        if (r101 != 0) goto L5;
        return;
    L5:
        this.f537070a.getClass();
        throw null;
    }
}
