package fob;

import android.text.Spannable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import hob.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
public abstract class f<I extends hob.b> implements c<Spannable, List<? extends b<I>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f478193b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<I> f478194a;

    public static final class a {
    }

    public static final class b<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final I f478195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IntRange f478196b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f478195a, r101.f478195a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f478196b, r101.f478196b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            I r100 = this.f478195a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f478196b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedUrl(info=" + this.f478195a + ", range=" + this.f478196b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(hob.b r100, IntRange r101) {
            Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
            this.f478195a = r100;
            this.f478196b = r101;
        }
    }

    static {
    }

    public abstract List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r100);

    public abstract I b(com.ss.android.lark.keyboard.edittext2.utils.b.a r100);

    public c.a<List<b<I>>> c(Spannable r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        List<com.ss.android.lark.keyboard.edittext2.utils.b.a> r101 = a(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r104 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r103.next();
        hob.b r105 = b(r104);
        int r106 = r104.f429251b;
        r102.add(new b(r105, new IntRange(r106, r104.f429250a.length() + r106)));
        goto L4
    L7:
        return new c.a(!r102.isEmpty(), r102);
    }

    @Override // fob.c
    public /* bridge */ /* synthetic */ c.a resolve(Spannable r100) {
        return c(r100);
    }

    public f(d<I> r100, eob.a r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "editor");
        this.f478194a = r100;
    }
}
