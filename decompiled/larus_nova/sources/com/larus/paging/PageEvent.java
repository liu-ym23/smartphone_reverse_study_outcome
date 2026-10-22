package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class PageEvent<T> {

    public static final class Insert<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Insert<Object> f363671g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LoadType f363672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<d1<T>> f363673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f363674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f363675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final v f363676e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final v f363677f;

        public static final class a {
            public static Insert a(List r100, int r101, int r110, v r111, v r112) {
                Intrinsics.checkNotNullParameter(r100, "pages");
                Intrinsics.checkNotNullParameter(r111, "sourceLoadStates");
                return new Insert(LoadType.REFRESH, r100, r101, r110, r111, r112);
            }
        }

        public /* synthetic */ Insert() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Insert) == true) goto L8;
            return false;
        L8:
            Insert r101 = (Insert) r100;
            if (this.f363672a == r101.f363672a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363673b, r101.f363673b) == true) goto L15;
            return false;
        L15:
            if (this.f363674c == r101.f363674c) goto L18;
            return false;
        L18:
            if (this.f363675d == r101.f363675d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f363676e, r101.f363676e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f363677f, r101.f363677f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f363672a.hashCode() * 31) + this.f363673b.hashCode()) * 31) + this.f363674c) * 31) + this.f363675d) * 31) + this.f363676e.hashCode()) * 31;
            v r101 = this.f363677f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Insert(loadType=" + this.f363672a + ", pages=" + this.f363673b + ", placeholdersBefore=" + this.f363674c + ", placeholdersAfter=" + this.f363675d + ", sourceLoadStates=" + this.f363676e + ", mediatorLoadStates=" + this.f363677f + ')';
        }

        static {
            List r100 = CollectionsKt.listOf(d1.f363801e);
            u.c r101 = u.c.f363923c;
            u.c r102 = u.c.f363922b;
            f363671g = a.a(r100, 0, 0, new v(r101, r102, r102), null);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0095 -> B:18:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ec -> B:27:0x00f3). Please report as a decompilation issue!!! */
        @Override // com.larus.paging.PageEvent
        public final Object a(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r110, Continuation<? super PageEvent<T>> r210) {
            if ((r210 instanceof PageEvent$Insert$filter$1) == false) goto L7;
            PageEvent$Insert$filter$1 r100 = (PageEvent$Insert$filter$1) r210;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            int r105 = r100.I$1;
            int r106 = r100.I$0;
            Collection r107 = (Collection) r100.L$10;
            Object r108 = r100.L$9;
            Iterator<T> r109 = (Iterator) r100.L$8;
            List r111 = (List) r100.L$7;
            List r112 = (List) r100.L$6;
            d1 r113 = (d1) r100.L$5;
            Iterator<T> r114 = (Iterator) r100.L$4;
            Collection r115 = (Collection) r100.L$3;
            LoadType r116 = (LoadType) r100.L$2;
            Insert<T> r117 = (Insert) r100.L$1;
            Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r118 = (Function2) r100.L$0;
            ResultKt.throwOnFailure(r102);
            int r119 = r106;
            Insert<T> r120 = r117;
            Collection r121 = r115;
            Object r122 = r108;
            List r123 = r112;
            int r124 = r105;
            Iterator<T> r125 = r114;
            Object r126 = r103;
        L28:
            if (((Boolean) r102).booleanValue() == false) goto L33;
            r123.add(r122);
            List<Integer> r127 = r113.f363805d;
            if (r127 == null) goto L32;
            r124 = ((Number) ListProtector.get(r127, r124)).intValue();
        L32:
            r111.add(Boxing.boxInt(r124));
        L33:
            r124 = r119;
            Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r128 = r118;
            LoadType r129 = r116;
        L19:
            if (r109.hasNext() == false) goto L34;
            r122 = r109.next();
            int r130 = r124 + 1;
            if (r124 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            r100.L$0 = r128;
            r100.L$1 = r120;
            r100.L$2 = r129;
            r100.L$3 = r121;
            r100.L$4 = r125;
            r100.L$5 = r113;
            r100.L$6 = r123;
            r100.L$7 = r111;
            r100.L$8 = r109;
            r100.L$9 = r122;
            r100.L$10 = r107;
            r100.I$0 = r130;
            r100.I$1 = r124;
            r100.label = 1;
            Object r131 = r128.invoke(r122, r100);
            if (r131 != r126) goto L26;
            return r126;
        L26:
            Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r132 = r128;
            r102 = r131;
            r119 = r130;
            r116 = r129;
            r118 = r132;
            goto L28
        L34:
            r107.add(new d1(r113.f363802a, r123, r113.f363804c, r111));
            Object r133 = r126;
        L16:
            if (r125.hasNext() == false) goto L36;
            d1 r134 = (d1) r125.next();
            r123 = new ArrayList();
            ArrayList r135 = new ArrayList();
            Iterator<T> r136 = r134.f363803b.iterator();
            r124 = 0;
            r113 = r134;
            r126 = r133;
            r107 = r121;
            r111 = r135;
            r109 = r136;
            goto L19
        L36:
            return new Insert(r129, (List) r121, r120.f363674c, r120.f363675d, r120.f363676e, r120.f363677f);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            r133 = r103;
            ResultKt.throwOnFailure(r102);
            LoadType r137 = this.f363672a;
            List<d1<T>> r138 = this.f363673b;
            ArrayList r139 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r138, 10));
            r120 = this;
            r121 = r139;
            r125 = r138.iterator();
            r129 = r137;
            r128 = r110;
        L7:
            r100 = new PageEvent$Insert$filter$1(this, r210);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0096 -> B:18:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f2 -> B:27:0x0101). Please report as a decompilation issue!!! */
        @Override // com.larus.paging.PageEvent
        public final <R> Object b(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r110, Continuation<? super PageEvent<R>> r210) {
            if ((r210 instanceof PageEvent$Insert$flatMap$1) == false) goto L7;
            PageEvent$Insert$flatMap$1 r100 = (PageEvent$Insert$flatMap$1) r210;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            int r105 = r100.I$1;
            int r106 = r100.I$0;
            Collection r107 = (Collection) r100.L$10;
            Collection r108 = (Collection) r100.L$9;
            Iterator<T> r109 = (Iterator) r100.L$8;
            List r111 = (List) r100.L$7;
            List r112 = (List) r100.L$6;
            d1 r113 = (d1) r100.L$5;
            Iterator<T> r114 = (Iterator) r100.L$4;
            Collection r115 = (Collection) r100.L$3;
            LoadType r116 = (LoadType) r100.L$2;
            Insert<T> r117 = (Insert) r100.L$1;
            Object r118 = r103;
            Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r119 = (Function2) r100.L$0;
            ResultKt.throwOnFailure(r102);
            Insert<T> r120 = r117;
            Collection r121 = r115;
            d1 r122 = r113;
            int r123 = r106;
        L27:
            CollectionsKt.addAll(r108, (Iterable) r102);
            List<Integer> r124 = r122.f363805d;
            if (r124 == null) goto L31;
            r105 = ((Number) ListProtector.get(r124, r105)).intValue();
        L31:
            if (r111.size() >= r112.size()) goto L33;
            r111.add(Boxing.boxInt(r105));
            goto L31
        L33:
            Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r125 = r119;
            List r126 = r112;
            int r127 = r123;
            Iterator<T> r128 = r114;
            d1 r129 = r122;
            LoadType r130 = r116;
            Object r131 = r118;
        L19:
            if (r109.hasNext() == false) goto L34;
            T r132 = r109.next();
            int r133 = r127 + 1;
            if (r127 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            List r134 = r126;
            r100.L$0 = r125;
            r100.L$1 = r120;
            r100.L$2 = r130;
            r100.L$3 = r121;
            r100.L$4 = r128;
            r100.L$5 = r129;
            r100.L$6 = r126;
            r100.L$7 = r111;
            r100.L$8 = r109;
            r100.L$9 = r134;
            r100.L$10 = r107;
            r100.I$0 = r133;
            r100.I$1 = r127;
            r100.label = 1;
            Object r135 = r125.invoke(r132, r100);
            if (r135 != r131) goto L26;
            return r131;
        L26:
            r118 = r131;
            r114 = r128;
            r105 = r127;
            r112 = r126;
            r108 = r134;
            LoadType r136 = r130;
            r119 = r125;
            r102 = r135;
            r122 = r129;
            r123 = r133;
            r116 = r136;
            goto L27
        L34:
            r107.add(new d1(r129.f363802a, r126, r129.f363804c, r111));
            Object r137 = r131;
        L16:
            if (r128.hasNext() == false) goto L36;
            d1 r138 = (d1) r128.next();
            r126 = new ArrayList();
            ArrayList r139 = new ArrayList();
            Iterator<T> r140 = r138.f363803b.iterator();
            r127 = 0;
            r129 = r138;
            r131 = r137;
            r107 = r121;
            r111 = r139;
            r109 = r140;
            goto L19
        L36:
            return new Insert(r130, (List) r121, r120.f363674c, r120.f363675d, r120.f363676e, r120.f363677f);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            r137 = r103;
            ResultKt.throwOnFailure(r102);
            LoadType r141 = this.f363672a;
            List<d1<T>> r142 = this.f363673b;
            ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r142, 10));
            r120 = this;
            r121 = r143;
            r128 = r142.iterator();
            r130 = r141;
            r125 = r110;
        L7:
            r100 = new PageEvent$Insert$flatMap$1(this, r210);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008e -> B:18:0x00ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00d7 -> B:24:0x00df). Please report as a decompilation issue!!! */
        @Override // com.larus.paging.PageEvent
        public final <R> Object c(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r110, Continuation<? super PageEvent<R>> r210) {
            if ((r210 instanceof PageEvent$Insert$map$1) == false) goto L7;
            PageEvent$Insert$map$1 r100 = (PageEvent$Insert$map$1) r210;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            Collection r105 = (Collection) r100.L$10;
            Collection r106 = (Collection) r100.L$9;
            Iterator<T> r107 = (Iterator) r100.L$8;
            Collection r108 = (Collection) r100.L$7;
            int[] r111 = (int[]) r100.L$6;
            d1 r112 = (d1) r100.L$5;
            Iterator<T> r113 = (Iterator) r100.L$4;
            Collection r114 = (Collection) r100.L$3;
            LoadType r115 = (LoadType) r100.L$2;
            Insert<T> r116 = (Insert) r100.L$1;
            Function2<? super T, ? super Continuation<? super R>, ? extends Object> r109 = (Function2) r100.L$0;
            ResultKt.throwOnFailure(r102);
            d1 r117 = r112;
            Iterator<T> r118 = r107;
            Insert<T> r119 = r116;
            Collection r120 = r108;
            LoadType r121 = r115;
        L24:
            r106.add(r102);
            Function2<? super T, ? super Continuation<? super R>, ? extends Object> r122 = r109;
            Iterator<T> r123 = r113;
            Collection r124 = r114;
            Collection r125 = r120;
            d1 r126 = r117;
        L19:
            if (r118.hasNext() == false) goto L25;
            T r127 = r118.next();
            r100.L$0 = r122;
            r100.L$1 = r119;
            r100.L$2 = r121;
            r100.L$3 = r124;
            r100.L$4 = r123;
            r100.L$5 = r126;
            r100.L$6 = r111;
            r100.L$7 = r125;
            r100.L$8 = r118;
            r100.L$9 = r125;
            r100.L$10 = r105;
            r100.label = 1;
            Object r128 = r122.invoke(r127, r100);
            if (r128 != r103) goto L23;
            return r103;
        L23:
            r117 = r126;
            r114 = r124;
            r106 = r125;
            r113 = r123;
            r109 = r122;
            r102 = r128;
            r120 = r106;
            goto L24
        L25:
            r105.add(new d1(r111, (List) r125, r126.f363804c, r126.f363805d));
            Iterator<T> r129 = r123;
            Collection r130 = r124;
            Insert<T> r131 = r119;
            LoadType r132 = r121;
        L16:
            if (r129.hasNext() == false) goto L27;
            d1 r133 = (d1) r129.next();
            r111 = r133.f363802a;
            List<T> r134 = r133.f363803b;
            r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
            r118 = r134.iterator();
            r126 = r133;
            r121 = r132;
            r119 = r131;
            r124 = r130;
            r123 = r129;
            r105 = r124;
            goto L19
        L27:
            return new Insert(r132, (List) r130, r131.f363674c, r131.f363675d, r131.f363676e, r131.f363677f);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            LoadType r135 = this.f363672a;
            List<d1<T>> r136 = this.f363673b;
            r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
            r129 = r136.iterator();
            r131 = this;
            r132 = r135;
            r122 = r110;
        L7:
            r100 = new PageEvent$Insert$map$1(this, r210);
            goto L8
        }

        public Insert(LoadType r100, List<d1<T>> r101, int r102, int r103, v r104, v r105) {
            this.f363672a = r100;
            this.f363673b = r101;
            this.f363674c = r102;
            this.f363675d = r103;
            this.f363676e = r104;
            this.f363677f = r105;
            boolean r106 = false;
            if (r100 == LoadType.APPEND) goto L7;
            if (r102 >= 0) goto L7;
            boolean r107 = false;
        L8:
            if (r107 == false) goto L28;
            if (r100 == LoadType.PREPEND) goto L14;
            if (r103 >= 0) goto L14;
            boolean r108 = false;
        L15:
            if (r108 == false) goto L26;
            if (r100 == LoadType.REFRESH) goto L19;
        L20:
            r106 = true;
        L21:
            if (r106 == false) goto L24;
            return;
        L24:
            throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
        L19:
            if ((!r101.isEmpty()) == false) goto L21;
        L26:
            throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + r103).toString());
        L14:
            r108 = true;
            goto L15
        L28:
            throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + r102).toString());
        L7:
            r107 = true;
            goto L8
        }
    }

    public static final class a<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LoadType f363678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f363679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f363680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f363681d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f363678a == r101.f363678a) goto L12;
            return false;
        L12:
            if (this.f363679b == r101.f363679b) goto L15;
            return false;
        L15:
            if (this.f363680c == r101.f363680c) goto L18;
            return false;
        L18:
            if (this.f363681d == r101.f363681d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f363678a.hashCode() * 31) + this.f363679b) * 31) + this.f363680c) * 31) + this.f363681d;
        }

        public final String toString() {
            return "Drop(loadType=" + this.f363678a + ", minPageOffset=" + this.f363679b + ", maxPageOffset=" + this.f363680c + ", placeholdersRemaining=" + this.f363681d + ')';
        }

        public final int d() {
            return (this.f363680c - this.f363679b) + 1;
        }

        public a(LoadType r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "loadType");
            this.f363678a = r100;
            this.f363679b = r101;
            this.f363680c = r102;
            this.f363681d = r103;
            boolean r104 = true;
            if (r100 == LoadType.REFRESH) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L22;
            if (d() <= 0) goto L10;
            boolean r106 = true;
        L11:
            if (r106 == false) goto L20;
            if (r103 >= 0) goto L15;
            r104 = false;
        L15:
            if (r104 == false) goto L18;
            return;
        L18:
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + r103).toString());
        L20:
            throw new IllegalArgumentException(("Drop count must be > 0, but was " + d()).toString());
        L10:
            r106 = false;
            goto L11
        L22:
            throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class b<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f363682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v f363683b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f363682a, r101.f363682a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363683b, r101.f363683b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f363682a.hashCode() * 31;
            v r101 = this.f363683b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "LoadStateUpdate(source=" + this.f363682a + ", mediator=" + this.f363683b + ')';
        }

        public b(v r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f363682a = r100;
            this.f363683b = r101;
        }
    }

    public PageEvent() {
    }

    public Object a(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r100, Continuation<? super PageEvent<T>> r101) {
        return this;
    }

    public <R> Object b(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r100, Continuation<? super PageEvent<R>> r101) {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.larus.paging.PageEvent<R of com.larus.paging.PageEvent.flatMap>");
        return this;
    }

    public <R> Object c(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super PageEvent<R>> r101) {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.larus.paging.PageEvent<R of com.larus.paging.PageEvent.map>");
        return this;
    }
}
