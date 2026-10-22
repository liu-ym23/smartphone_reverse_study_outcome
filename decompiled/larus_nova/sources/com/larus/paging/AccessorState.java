package com.larus.paging;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class AccessorState<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockState[] f363628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u.a[] f363629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<a<Key, Value>> f363630c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/paging/AccessorState$BlockState;", "", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common_release"}, k = 1, mv = {1, 7, 1})
    public static final enum BlockState extends Enum<BlockState> {
        public static final BlockState COMPLETED = null;
        public static final BlockState REQUIRES_REFRESH = null;
        public static final BlockState UNBLOCKED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlockState[] f363631a = null;

        public static BlockState valueOf(String r100) {
            return (BlockState) r27.a.a(BlockState.class, r100);
        }

        public static BlockState[] values() {
            return (BlockState[]) f363631a.clone();
        }

        static {
            BlockState r100 = new BlockState("UNBLOCKED", 0);
            UNBLOCKED = r100;
            BlockState r101 = new BlockState("COMPLETED", 1);
            COMPLETED = r101;
            BlockState r102 = new BlockState("REQUIRES_REFRESH", 2);
            REQUIRES_REFRESH = r102;
            f363631a = new BlockState[]{r100, r101, r102};
        }

        public BlockState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LoadType f363632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w0<Key, Value> f363633b;

        public a(LoadType r100, w0<Key, Value> r101) {
            Intrinsics.checkNotNullParameter(r100, "loadType");
            Intrinsics.checkNotNullParameter(r101, "pagingState");
            this.f363632a = r100;
            this.f363633b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363634a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f363635b = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            f363634a = r100;
            int[] r101 = new int[BlockState.values().length];
            r101[BlockState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r101[BlockState.REQUIRES_REFRESH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r101[BlockState.UNBLOCKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            f363635b = r101;
        }
    }

    public final Pair<LoadType, w0<Key, Value>> c() {
        Iterator<a<Key, Value>> r100 = this.f363630c.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        a<Key, Value> r101 = r100.next();
        LoadType r102 = r101.f363632a;
        if (r102 != LoadType.REFRESH) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L4;
    L14:
        a<Key, Value> r104 = r101;
        if (r104 != null) goto L17;
        return null;
    L17:
        return TuplesKt.to(r104.f363632a, r104.f363633b);
    L8:
        if (this.f363628a[r102.ordinal()] != BlockState.UNBLOCKED) goto L10;
        r103 = true;
        goto L11
    L13:
        r101 = null;
        goto L14
    }

    public AccessorState() {
        int r100 = LoadType.values().length;
        BlockState[] r101 = new BlockState[r100];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r101[r103] = BlockState.UNBLOCKED;
        r103 = r103 + 1;
        goto L3
    L5:
        this.f363628a = r101;
        int r104 = LoadType.values().length;
        u.a[] r105 = new u.a[r104];
    L6:
        if (r102 >= r104) goto L8;
        r105[r102] = null;
        r102 = r102 + 1;
        goto L6
    L8:
        this.f363629b = r105;
        this.f363630c = new ArrayDeque();
    }

    public final void a(final LoadType r100) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        CollectionsKt.removeAll(this.f363630c, new AccessorState$clearPendingRequest$1(r100));
    }

    public final u b(LoadType r100) {
        BlockState r101 = this.f363628a[r100.ordinal()];
        ArrayDeque<a<Key, Value>> r102 = this.f363630c;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<a<Key, Value>> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        if (r104.next().f363632a != r100) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        r103 = true;
        goto L16
    L13:
        r105 = false;
    L16:
        if (r103 == true) goto L18;
    L21:
        u.a r106 = this.f363629b[r100.ordinal()];
        if (r106 == null) goto L24;
        return r106;
    L24:
        int r107 = b.f363635b[r101.ordinal()];
        if (r107 == 1) goto L35;
        if (r107 != 2) goto L29;
        u.c r108 = u.c.f363922b;
        return u.c.f363923c;
    L29:
        if (r107 != 3) goto L32;
        u.c r109 = u.c.f363922b;
        return u.c.f363923c;
    L32:
        throw new NoWhenBranchMatchedException();
    L35:
        if (b.f363634a[r100.ordinal()] != 1) goto L37;
        u.c r110 = u.c.f363922b;
        return u.c.f363923c;
    L37:
        u.c r111 = u.c.f363922b;
        return u.c.f363922b;
    L18:
        if (r101 == BlockState.REQUIRES_REFRESH) goto L21;
        return u.b.f363921b;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    public final void d(LoadType r100, BlockState r101) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f363628a[r100.ordinal()] = r101;
    }
}
