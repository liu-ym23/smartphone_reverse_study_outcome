package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headgausee/HeadGaussViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headgausee/HeadGaussItemViewHolder;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadGaussViewAdapter extends RecyclerView.Adapter<HeadGaussItemViewHolder> {
    public List<String> a;
    public final ConcurrentHashMap<String, Bitmap> b;
    public final Context c;

    public final int getItemCount() {
        List<String> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final Context getContext() {
        return this.c;
    }

    public HeadGaussViewAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.b = new ConcurrentHashMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        HeadGaussItemViewHolder r6 = (HeadGaussItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        View r7 = ((RecyclerView.ViewHolder) r6).itemView;
        if ((r7 instanceof HeadGaussItemView) == true) goto L5;
        r7 = null;
    L5:
        HeadGaussItemView r8 = (HeadGaussItemView) r7;
        List<String> r0 = this.a;
        if (r0 == null) goto L9;
        final String r9 = (String) CollectionsKt.getOrNull(r0, r5);
        if (r9 == null) goto L9;
    L10:
        Bitmap r1 = this.b.get(r9);
        if (r1 == null) goto L14;
        if (r8 == null) goto L23;
        r8.setImageBitmap(r1);
        return;
    L23:
        return;
    L14:
        if (r8 == null) goto L25;
        Function1<Bitmap, Unit> r2 = new AnonymousClass1(this, r9);
        Intrinsics.checkNotNullParameter(r9, "url");
        if (r9.length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        fa3.c.a(Observable.create(new d(r9)).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).map(new e(r8, r2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r8)), r8);
        return;
    L21:
        r8.setImageBitmap(null);
        r8.setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        return;
    L18:
        r3 = false;
        goto L19
    L25:
        return;
    L9:
        r9 = "";
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new HeadGaussItemViewHolder(new HeadGaussItemView(this.c));
    }
}
