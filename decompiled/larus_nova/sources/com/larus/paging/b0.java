package com.larus.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f363777a = 0;

    public static final class a<T> implements ListUpdateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0<T> f363778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0<T> f363779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ListUpdateCallback f363780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f363781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f363782e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f363783f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f363784g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f363785h;

        /* JADX INFO: renamed from: com.larus.paging.b0$a$a, reason: collision with other inner class name */
        public static final class C4462a {
        }

        static {
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void onInserted(int r100, int r110) {
            boolean r101 = true;
            if (r100 >= this.f363783f) goto L6;
        L4:
            boolean r102 = false;
        L15:
            if (r102 == true) goto L29;
            if (r100 <= 0) goto L19;
        L17:
            r101 = false;
        L27:
            if (r101 == true) goto L29;
            this.f363780c.onInserted(r100 + this.f363781d, r110);
            goto L29
        L19:
            if (this.f363784g == 2) goto L17;
            int r103 = Math.min(r110, this.f363781d);
            if (r103 <= 0) goto L24;
            this.f363784g = 3;
            this.f363780c.onChanged((0 - r103) + this.f363781d, r103, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
            this.f363781d -= r103;
        L24:
            int r104 = r110 - r103;
            if (r104 <= 0) goto L27;
            this.f363780c.onInserted(this.f363781d + 0, r104);
        L29:
            this.f363783f += r110;
            return;
        L6:
            if (this.f363785h == 2) goto L4;
            int r105 = Math.min(r110, this.f363782e);
            if (r105 <= 0) goto L11;
            this.f363785h = 3;
            this.f363780c.onChanged(this.f363781d + r100, r105, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
            this.f363782e -= r105;
        L11:
            int r106 = r110 - r105;
            if (r106 <= 0) goto L14;
            this.f363780c.onInserted((r105 + r100) + this.f363781d, r106);
        L14:
            r102 = true;
            goto L15
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void onMoved(int r100, int r101) {
            ListUpdateCallback r102 = this.f363780c;
            int r103 = this.f363781d;
            r102.onMoved(r100 + r103, r101 + r103);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void onRemoved(int r110, int r111) {
            boolean r100 = true;
            if ((r110 + r111) >= this.f363783f) goto L6;
        L4:
            boolean r101 = false;
        L14:
            if (r101 == true) goto L27;
            if (r110 <= 0) goto L18;
        L16:
            r100 = false;
        L25:
            if (r100 == true) goto L27;
            this.f363780c.onRemoved(r110 + this.f363781d, r111);
            goto L27
        L18:
            if (this.f363784g == 3) goto L16;
            int r102 = RangesKt.coerceAtLeast(Math.min(this.f363779b.a() - this.f363781d, r111), 0);
            int r103 = r111 - r102;
            if (r103 <= 0) goto L23;
            this.f363780c.onRemoved(this.f363781d + 0, r103);
        L23:
            if (r102 <= 0) goto L25;
            this.f363784g = 2;
            this.f363780c.onChanged(this.f363781d + 0, r102, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.f363781d += r102;
        L27:
            this.f363783f -= r111;
            return;
        L6:
            if (this.f363785h == 3) goto L4;
            int r104 = RangesKt.coerceAtLeast(Math.min(this.f363779b.e() - this.f363782e, r111), 0);
            int r105 = r111 - r104;
            if (r104 <= 0) goto L11;
            this.f363785h = 2;
            this.f363780c.onChanged(this.f363781d + r110, r104, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.f363782e += r104;
        L11:
            if (r105 <= 0) goto L13;
            this.f363780c.onRemoved((r104 + r110) + this.f363781d, r105);
        L13:
            r101 = true;
            goto L14
        }

        public a(a0<T> r100, a0<T> r101, ListUpdateCallback r102) {
            Intrinsics.checkNotNullParameter(r100, "oldList");
            Intrinsics.checkNotNullParameter(r101, "newList");
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.f363778a = r100;
            this.f363779b = r101;
            this.f363780c = r102;
            this.f363781d = r100.a();
            this.f363782e = r100.e();
            this.f363783f = r100.d();
            this.f363784g = 1;
            this.f363785h = 1;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void onChanged(int r100, int r101, Object r102) {
            this.f363780c.onChanged(r100 + this.f363781d, r101, r102);
        }
    }

    static {
    }
}
