package teb;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f545642a;

    public b(d r100) {
        this.f545642a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 != 0) goto L5;
        d r102 = this.f545642a;
        r102.f545647b.postOnAnimation(r102.f545651f);
        return;
    }
}
