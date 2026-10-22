package com.bytedance.android.shopping.anchorv4.voavhs.jedi;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorJediSyncListDiffer<T> {
    public int a;
    public List<? extends T> b;
    public final ListUpdateCallback c;
    public final a<T> d;

    public AnchorJediSyncListDiffer(JediListUpdateCallback r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mUpdateCallback");
        Intrinsics.checkNotNullParameter(r3, "mConfig");
        this.c = r2;
        this.d = r3;
        this.b = CollectionsKt.emptyList();
    }

    public final synchronized T a(int r2, boolean r3) {
        monitor-enter(this);
        List<? extends T> r4 = this.b;     // Catch: Throwable -> L13
        if (r2 >= r4.size()) goto L10;
        if (r2 < 0) goto L10;
        T r5 = (T) ListProtector.get(r4, r2);
        monitor-exit(this);
        return r5;
    L10:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(final List<? extends T> r5, Function0<Unit> r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "newList");     // Catch: Throwable -> L22
        int r0 = this.a + 1;     // Catch: Throwable -> L22
        this.a = r0;     // Catch: Throwable -> L22
        final List<? extends T> r1 = this.b;     // Catch: Throwable -> L22
        if (r5 != r1) goto L6;
    L20:
        monitor-exit(this);
        return;
    L6:
        if (r5.isEmpty() == false) goto L11;
        int r7 = r1.size();     // Catch: Throwable -> L22
        this.b = CollectionsKt.emptyList();     // Catch: Throwable -> L22
        this.c.onRemoved(0, r7);     // Catch: Throwable -> L22
        if (r6 == null) goto L20;
        Unit r8 = (Unit) r6.invoke();     // Catch: Throwable -> L22
        goto L20
    L11:
        if (r1.isEmpty() == false) goto L15;
        this.b = r5;     // Catch: Throwable -> L22
        this.c.onInserted(0, r5.size());     // Catch: Throwable -> L22
        if (r6 == null) goto L20;
        Unit r9 = (Unit) r6.invoke();     // Catch: Throwable -> L22
        goto L20
    L15:
        DiffUtil.DiffResult r2 = DiffUtil.calculateDiff(new AnchorJediSyncListDiffer$submitList$result$1(this, r1, r5));     // Catch: Throwable -> L22
        if (this.a != r0) goto L20;
        this.b = r5;     // Catch: Throwable -> L22
        r2.dispatchUpdatesTo(this.c);     // Catch: Throwable -> L22
        if (r6 == null) goto L20;
        Unit r10 = (Unit) r6.invoke();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
