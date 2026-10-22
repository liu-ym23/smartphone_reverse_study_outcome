package zdc;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.recyclerview.FpsRecyclerView;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f571494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FpsRecyclerView f571495b;

    public b(FpsRecyclerView r100) {
        this.f571495b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 != 0) goto L5;
        this.f571494a = false;
        return;
    L5:
        if (r101 == 1) goto L8;
        return;
    L8:
        if (this.f571494a == true) goto L12;
        FpsRecyclerView r102 = this.f571495b;
        r102.getInputMethodManager().hideSoftInputFromWindow(r102.getWindowToken(), 0);
        r102.clearFocus();
        this.f571494a = !this.f571494a;
        return;
    }
}
