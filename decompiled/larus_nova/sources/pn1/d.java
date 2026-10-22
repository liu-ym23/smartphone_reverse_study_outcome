package pn1;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f529955a;

    public d(a r100) {
        this.f529955a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        List<ef1.a> r102 = ((ef1.c) r101.data).a();
        if (r102 == null) goto L15;
        HashMap<Integer, ef1.a> r103 = this.f529955a.f529946d;
        List<ef1.a> r104 = r102;
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        T r107 = r106.next();
        r105.put(Integer.valueOf(((ef1.a) r107).b()), r107);
        goto L6
    L8:
        r103.putAll(r105);
        a r108 = this.f529955a;
        ef1.d r109 = (ef1.d) r101.extra;
        if (r109 == null) goto L11;
        int r110 = r109.a();
    L12:
        r108.f529945c = r110;
        this.f529955a.f529947e.g(CollectionsKt.reversed(r104));
        a r111 = this.f529955a;
        r111.f529947e.a(r111.f529946d.size(), this.f529955a.f529945c);
        return;
    L11:
        r110 = 0;
        goto L12
    }
}
