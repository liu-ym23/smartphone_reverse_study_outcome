package com.bytedance.android.shopping.yata.business.function;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Comparator<T> {
    public final /* synthetic */ e a;
    public final /* synthetic */ Ref.ObjectRef b;

    public f(e r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.Comparator
    public final int compare(T r6, T r7) {
        return ComparisonsKt.compareValues((Integer) this.a.a.d().a(((com.bytedance.kmp.ec.yata.store.node.c) r7).s(), ((String) this.b.element) + ".validate_priority", null), (Integer) this.a.a.d().a(((com.bytedance.kmp.ec.yata.store.node.c) r6).s(), ((String) this.b.element) + ".validate_priority", null));
    }
}
