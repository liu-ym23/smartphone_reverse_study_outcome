package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Iterable<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>>, KMappedMarker {
    public final List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> a;

    public final class a implements Iterator<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>>, KMappedMarker {
        public int a;
        public final /* synthetic */ l b;

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.a >= ((ArrayList) this.b.a).size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>> next() {
            List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> r0 = this.b.a;
            int r1 = this.a;
            this.a = r1 + 1;
            return (Pair) ListProtector.get(r0, r1);
        }

        public a(l r1) {
            this.b = r1;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> iterator() {
        return new a(this);
    }

    public l() {
        this.a = new ArrayList();
    }

    public final <T extends com.bytedance.android.livesdk.ktvimpl.base.sei.a> void a(String r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "model");
        List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(TuplesKt.to(r2, r3));
    }
}
