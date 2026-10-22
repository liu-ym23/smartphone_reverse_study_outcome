package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f398829f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f398830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kla.a f398831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f398832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoroutineScope f398833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f398834e;

    public abstract void U3(b r100);

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.banner.c] */
    public BannerViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f398832c = -1;
        this.f398834e = new c(this);
    }

    public final void T3(boolean r100) {
        kla.a r101 = this.f398831b;
        if (r101 == null) goto L14;
        LiveData<Integer> r102 = r101.getSelectedPosition();
        if (r102 == null) goto L14;
        Integer r103 = r102.getValue();
        int r104 = this.f398832c;
        if (r103 == null) goto L14;
        if (r103.intValue() != r104) goto L14;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L21;
        if (r100 == false) goto L19;
    L20:
        CoroutineScope r106 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f398833d = r106;
        this.f398830a = true;
        goto L21
    L19:
        if (this.f398830a == false) goto L20;
    L21:
        kla.a r107 = this.f398831b;
        if (r107 == null) goto L33;
        LiveData<Integer> r108 = r107.getSelectedPosition();
        if (r108 == null) goto L33;
        Integer r109 = r108.getValue();
        int r110 = this.f398832c;
        if (r109 == null) goto L33;
        if (r109.intValue() != r110) goto L33;
        boolean r111 = true;
    L34:
        if (r111 == true) goto L43;
        if (r100 == false) goto L37;
    L38:
        CoroutineScope r112 = this.f398833d;
        if (r112 == null) goto L41;
        CoroutineScopeKt.cancel$default(r112, null, 1, null);
    L41:
        this.f398830a = false;
        return;
    L37:
        if (this.f398830a == true) goto L38;
        return;
    L43:
        return;
    L33:
        r111 = false;
    L14:
        r105 = false;
        goto L16
    }
}
