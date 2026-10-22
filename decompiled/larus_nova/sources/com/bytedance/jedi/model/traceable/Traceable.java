package com.bytedance.jedi.model.traceable;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/traceable/Traceable;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Companion", "model_release"}, k = 1, mv = {1, 7, 1})
public final class Traceable<T> implements ITraceable<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f251191c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f251192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<Pair<ITracePoint<?>, Long>> f251193b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/traceable/Traceable$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static ITraceable a(Companion r100, Pair r101) {
            Traceable r102 = new Traceable(r101, new LinkedHashSet());
            r100.getClass();
            Intrinsics.checkNotNullParameter(r102, "parent");
            return r102.c(r101);
        }
    }

    static {
        f251191c = new Companion(0);
    }

    @Override // com.bytedance.jedi.model.traceable.ITraceable
    public final T payload() {
        return this.f251192a;
    }

    @Override // com.bytedance.jedi.model.traceable.ITraceable
    public final boolean a(ITracePoint<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        LinkedHashSet<Pair<ITracePoint<?>, Long>> r101 = this.f251193b;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add((ITracePoint) ((Pair) r103.next()).getFirst());
        goto L4
    L7:
        return r102.contains(r100);
    }

    @Override // com.bytedance.jedi.model.traceable.ITraceable
    public final boolean b(ITracePoint<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        return this.f251193b.add(TuplesKt.to(r100, Long.valueOf(System.currentTimeMillis())));
    }

    @Override // com.bytedance.jedi.model.traceable.ITraceable
    public final Traceable c(Object r100) {
        if (Intrinsics.areEqual(this.f251192a, r100) == false) goto L5;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.bytedance.jedi.model.traceable.ITraceable<V of com.bytedance.jedi.model.traceable.Traceable.clone>");
        return this;
    L5:
        int r101 = this.f251193b.size();
        Pair[] r102 = new Pair[r101];
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L9;
        r102[r103] = (Pair) CollectionsKt.elementAt(this.f251193b, r103);
        r103 = r103 + 1;
        goto L6
    L9:
        return new Traceable(r100, SetsKt.linkedSetOf(r102));
    }

    public Traceable(T r100, LinkedHashSet<Pair<ITracePoint<?>, Long>> r101) {
        this.f251192a = r100;
        this.f251193b = r101;
    }
}
