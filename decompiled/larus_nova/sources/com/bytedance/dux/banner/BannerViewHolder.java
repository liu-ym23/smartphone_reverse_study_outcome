package com.bytedance.dux.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dux_release"}, k = 1, mv = {1, 7, 1})
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f204851f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f204852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ol4.a f204853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f204854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoroutineScope f204855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f204856e;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerViewHolder f204857a;

        public a(BannerViewHolder r100) {
            this.f204857a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            BannerViewHolder r102 = this.f204857a;
            int r103 = BannerViewHolder.f204851f;
            r102.T3(false);
        }
    }

    public abstract void U3(b r100);

    public BannerViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f204854c = -1;
        this.f204856e = new a(this);
    }

    public final void T3(boolean r100) {
        ol4.a r101 = this.f204853b;
        if (r101 == null) goto L12;
        LiveData<Integer> r102 = r101.getSelectedPosition();
        if (r102 == null) goto L12;
        Integer r103 = r102.getValue();
        int r104 = this.f204854c;
        if (r103 == null) goto L12;
        if (r103.intValue() != r104) goto L12;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L19;
        if (r100 == false) goto L17;
    L18:
        CoroutineScope r106 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f204855d = r106;
        this.f204852a = true;
        goto L19
    L17:
        if (this.f204852a == false) goto L18;
    L19:
        ol4.a r107 = this.f204853b;
        if (r107 == null) goto L29;
        LiveData<Integer> r108 = r107.getSelectedPosition();
        if (r108 == null) goto L29;
        Integer r109 = r108.getValue();
        int r110 = this.f204854c;
        if (r109 == null) goto L29;
        if (r109.intValue() != r110) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == true) goto L39;
        if (r100 == false) goto L33;
    L34:
        CoroutineScope r112 = this.f204855d;
        if (r112 == null) goto L37;
        CoroutineScopeKt.cancel$default(r112, null, 1, null);
    L37:
        this.f204852a = false;
        return;
    L33:
        if (this.f204852a == true) goto L34;
        return;
    L39:
        return;
    L29:
        r111 = false;
    L12:
        r105 = false;
        goto L14
    }
}
