package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class MessagePayload extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f270994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f270995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f270996d;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((d) r100).f271003a), Integer.valueOf(((d) r101).f271003a));
        }
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int b() {
        return ((Number) this.f270995c.getValue()).intValue();
    }

    public final boolean d() {
        return !this.f270996d.isEmpty();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int c() {
        return this.f270994b;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Iterator r101 = CollectionsKt.sortedWith(this.f270996d, new a()).iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        d r102 = (d) r101.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r103 = r102.f271003a;
        if (r103 <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L15;
        r100.f271006b.writeVarint32((r103 << 3) | r102.c());
        if (r102.c() != 2) goto L13;
        r100.f271006b.writeVarint32(r102.b());
    L13:
        r102.a(r100);
        goto L4
    L15:
        throw new IllegalStateException(("illegal tag: " + r102.f271003a).toString());
    L8:
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagePayload(int r100, List<? extends d> r101) {
        Intrinsics.checkNotNullParameter(r101, "payloads");
        super(r100);
        this.f270996d = r101;
        this.f270994b = 2;
        this.f270995c = LazyKt.lazy(new MessagePayload$encodedSize$2(this));
    }
}
