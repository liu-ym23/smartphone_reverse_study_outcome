package com.bytedance.android.shopping.mall.feed.help;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/mall/feed/help/EventExposureTime$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EventExposureTime$scrollListener$1 extends RecyclerView.OnScrollListener {
    public boolean a;
    public final /* synthetic */ EventExposureTime b;

    public EventExposureTime$scrollListener$1(EventExposureTime r1) {
        this.b = r1;
    }

    public final void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L48;
        EventExposureTime r12 = this.b;
        if (r12.d <= 6) goto L7;
        return;
    L7:
        if (this.a == false) goto L9;
        r12.b = System.currentTimeMillis();
        this.a = false;
    L9:
        EventExposureTime r13 = this.b;
        if (r13.l == true) goto L16;
        r13.b = System.currentTimeMillis();
        Iterator<T> r14 = this.b.a.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        BaseViewHolder r15 = (BaseViewHolder) r14.next();
        this.b.j.put(r15, Boolean.valueOf(((RecyclerView.ViewHolder) r15).itemView.getLocalVisibleRect(this.b.n)));
        goto L13
    L15:
        this.b.l = true;
        return;
    L16:
        Ref.IntRef r16 = new Ref.IntRef();
        r16.element = 0;
        Iterator<T> r17 = this.b.a.iterator();
    L18:
        if (r17.hasNext() == false) goto L34;
        BaseViewHolder r0 = (BaseViewHolder) r17.next();
        boolean r2 = ((RecyclerView.ViewHolder) r0).itemView.getLocalVisibleRect(this.b.n);
        if (r2 == true) goto L23;
        r16.element++;
    L23:
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.b.j).get(r0), Boolean.valueOf(r2))) == false) goto L18;
        this.b.j.put(r0, Boolean.valueOf(r2));
        if (r2 == true) goto L26;
        ECHybridListItemVO r3 = r0.c;
        if (r3 == null) goto L32;
        r3.N = System.currentTimeMillis();
    L32:
        BuildersKt.launch$default(this.b.o.c, Dispatchers.getDefault(), null, new EventExposureTime$scrollListener$1$onScrollStateChanged$$inlined$forEach$lambda$1(r0, null, this, r16), 2, null);
        goto L18
    L26:
        ECHybridListItemVO r1 = r0.c;
        if (r1 == null) goto L18;
        r1.m();
        goto L18
    L34:
        if (r16.element != this.b.a.size()) goto L51;
        EventExposureTime r18 = this.b;
        r18.l(r18.b, System.currentTimeMillis());
        this.a = true;
        return;
    L51:
        return;
    }
}
