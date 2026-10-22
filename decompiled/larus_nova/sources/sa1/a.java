package sa1;

import android.view.View;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchHistoryAdapter;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f541142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qa1.b f541143b;

    public a(boolean r100, LiveSearchHistoryAdapter.b r101) {
        this.f541142a = r100;
        this.f541143b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f541142a == false) goto L5;
        this.f541143b.a();
        return;
    L5:
        this.f541143b.deleteAll();
    }
}
