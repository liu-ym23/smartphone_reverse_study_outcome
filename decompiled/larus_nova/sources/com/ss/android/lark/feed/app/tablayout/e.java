package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f420835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedSelectorConfig f420836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f420837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f420838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<View> f420839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f420840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f420841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f420842h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f420843a;

        public a(e r100) {
            this.f420843a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = ((ArrayList) this.f420843a.f420837c).indexOf(r100);
            this.f420843a.f420836b.getClass();
            e r102 = this.f420843a;
            List<View> r103 = r102.f420837c;
            boolean r104 = true;
            if (r101 >= 0) goto L5;
        L7:
            boolean r105 = false;
        L8:
            if (r105 == false) goto L11;
            r104 = r102.f420836b.f420764f.invoke(ListProtector.get(r103, r101), Integer.valueOf(r101), true, Boolean.TRUE).booleanValue();
        L11:
            if (r104 == true) goto L17;
            e r106 = this.f420843a;
            int r107 = ((ArrayList) r106.f420837c).indexOf(r100);
            if ((r100 instanceof CompoundButton) == false) goto L15;
            this.f420843a.f420836b.getClass();
        L15:
            r106.d(r107, true, true, true, false);
            return;
        L17:
            return;
        L5:
            if (r101 >= ((ArrayList) r103).size()) goto L7;
            r105 = true;
            goto L8
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f420844a;

        public b(e r100) {
            this.f420844a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            int r101 = ((ArrayList) this.f420844a.f420837c).indexOf(r100);
            e r102 = this.f420844a;
            List<View> r103 = r102.f420837c;
            if (r101 >= 0) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == true) goto L11;
            return false;
        L11:
            return r102.f420836b.f420765g.invoke(ListProtector.get(r103, r101), Integer.valueOf(r101)).booleanValue();
        L5:
            if (r101 >= ((ArrayList) r103).size()) goto L7;
            r104 = true;
            goto L8
        }
    }

    public final List<Integer> a() {
        ((ArrayList) this.f420838d).clear();
        Iterator r100 = ((ArrayList) this.f420837c).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L13;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (c((View) r102) == false) goto L11;
        List<Integer> r104 = this.f420838d;
        ArrayList r105 = (ArrayList) r104;
        r105.add(Integer.valueOf(r101));
    L11:
        r101 = r103;
        goto L4
    L13:
        return this.f420838d;
    }

    public final List<View> b() {
        ((ArrayList) this.f420839e).clear();
        Iterator r100 = ((ArrayList) this.f420837c).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r104 = (View) r102;
        if (c(r104) == false) goto L11;
    L12:
        ((ArrayList) this.f420839e).add(r104);
    L13:
        r101 = r103;
        goto L4
    L11:
        if (r101 != this.f420842h) goto L13;
    L15:
        return this.f420839e;
    }

    public final void g() {
        ViewGroup r100 = this.f420835a;
        if (r100 == null) goto L10;
        int r101 = r100.getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        View r103 = r100.getChildAt(r102);
        if (r103 == null) goto L9;
        r103.setOnClickListener(this.f420840f);
        r103.setOnLongClickListener(this.f420841g);
    L9:
        r102 = r102 + 1;
        goto L5
    L14:
        return;
    }

    public final void h() {
        Iterator r100 = ((ArrayList) this.f420837c).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L16;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r104 = (View) r102;
        if (this.f420842h != r101) goto L11;
    L14:
        boolean r105 = true;
    L15:
        this.f420836b.f420761c.invoke(r104, Integer.valueOf(r101), Boolean.valueOf(r105));
        r101 = r103;
        goto L4
    L11:
        if (c(r104) == true) goto L14;
        r105 = false;
        goto L15
    }

    public final void i() {
        ((ArrayList) this.f420837c).clear();
        ViewGroup r100 = this.f420835a;
        boolean r101 = false;
        if (r100 == null) goto L13;
        int r102 = r100.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        View r104 = r100.getChildAt(r103);
        if (r104 == null) goto L12;
        if (r104.getVisibility() != 0) goto L11;
        ((ArrayList) this.f420837c).add(r104);
        goto L12
    L11:
        f(r104, false);
    L12:
        r103 = r103 + 1;
    L13:
        int r105 = ((ArrayList) this.f420837c).size();
        int r106 = this.f420842h;
        if (r106 < 0) goto L17;
        if (r106 >= r105) goto L17;
        r101 = true;
    L17:
        if (r101 == true) goto L19;
        this.f420842h = -1;
        return;
    L19:
        if (c((View) ListProtector.get(this.f420837c, r106)) == true) goto L27;
        f((View) ListProtector.get(this.f420837c, this.f420842h), true);
        return;
    }

    public e() {
        this.f420836b = new FeedSelectorConfig();
        this.f420837c = new ArrayList();
        this.f420838d = new ArrayList();
        this.f420839e = new ArrayList();
        this.f420840f = new a(this);
        this.f420841g = new b(this);
        this.f420842h = -1;
    }

    public static boolean c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isSelected() == false) goto L5;
    L9:
        return true;
    L5:
        if ((r100 instanceof CompoundButton) == false) goto L7;
        boolean r101 = ((CompoundButton) r100).isChecked();
    L8:
        if (r101 == true) goto L9;
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public static void f(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setSelected(r101);
        if ((r100 instanceof CompoundButton) == false) goto L6;
        ((CompoundButton) r100).setChecked(r101);
        return;
    }

    public final void d(int r110, boolean r111, boolean r112, boolean r210, boolean r211) {
        List<Integer> r100 = a();
        Integer r101 = (Integer) CollectionsKt.lastOrNull(r100);
        this.f420836b.getClass();
        ArrayList r102 = (ArrayList) r100;
        boolean r103 = true;
        if ((!r102.isEmpty()) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        List<View> r105 = this.f420837c;
        if (r110 >= 0) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L16;
        Intrinsics.checkNotNullParameter("index out of list.", "<this>");
        Log.i("FeedTabLayout", "index out of list.");
    L37:
        r103 = false;
    L47:
        if (r103 == true) goto L49;
        if (r211 == true) goto L49;
        return;
    L49:
        Integer r107 = (Integer) CollectionsKt.lastOrNull(a());
        int r108 = -1;
        if (r107 == null) goto L52;
        int r109 = r107.intValue();
    L53:
        this.f420842h = r109;
        if (r112 == false) goto L72;
        if (r101 == null) goto L57;
        r108 = r101.intValue();
    L57:
        List<Integer> r113 = a();
        this.f420836b.f420762d.invoke(CollectionsKt.getOrNull(this.f420837c, r108), b(), Boolean.valueOf(r104), Boolean.valueOf(r210));
        this.f420836b.f420763e.invoke(Integer.valueOf(r108), r113, Boolean.valueOf(r104), Boolean.valueOf(r210));
        return;
    L72:
        return;
    L52:
        r109 = -1;
        goto L53
    L16:
        List<Integer> r114 = a();
        List<View> r115 = b();
        ArrayList r116 = (ArrayList) r114;
        if ((!r116.isEmpty()) == false) goto L31;
        if (r111 == false) goto L29;
        this.f420836b.getClass();
        Iterator r117 = r116.iterator();
    L21:
        if (r117.hasNext() == false) goto L26;
        int r118 = ((Number) r117.next()).intValue();
        if (r118 == r110) goto L21;
        f((View) ListProtector.get(r105, r118), false);
        goto L21
    L26:
        if (r116.contains(Integer.valueOf(r110)) == false) goto L31;
    L29:
        if (r116.contains(Integer.valueOf(r110)) == false) goto L37;
    L31:
        if (r111 == false) goto L36;
        if ((((ArrayList) r115).size() + 1) > this.f420836b.f420760b) goto L37;
    L38:
        View r119 = (View) ListProtector.get(r105, r110);
        f(r119, r111);
        this.f420836b.getClass();
        Iterator r120 = ((ArrayList) r115).iterator();
    L40:
        if (r120.hasNext() == false) goto L46;
        View r121 = (View) r120.next();
        int r122 = ((ArrayList) r105).indexOf(r121);
        if (r122 == r110) goto L40;
        Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> r123 = this.f420836b.f420764f;
        Integer r124 = Integer.valueOf(r122);
        Boolean r125 = Boolean.FALSE;
        if (r123.invoke(r121, r124, r125, Boolean.valueOf(r210)).booleanValue() == true) goto L40;
        f(r121, false);
        this.f420836b.f420761c.invoke(r121, Integer.valueOf(r122), r125);
        goto L40
    L46:
        this.f420836b.f420761c.invoke(r119, Integer.valueOf(r110), Boolean.valueOf(r111));
        goto L47
    L36:
        if ((((ArrayList) r115).size() - 1) >= this.f420836b.f420759a) goto L38;
    L11:
        if (r110 >= ((ArrayList) r105).size()) goto L13;
        r106 = true;
        goto L14
    L5:
        if (r102.contains(Integer.valueOf(r110)) == false) goto L7;
        r104 = true;
        goto L8
    }

    public static /* synthetic */ void e(e r100, int r101, boolean r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r113 & 4) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r113 & 8) == 0) goto L13;
        boolean r104 = false;
    L14:
        r100.d(r101, r102, r103, r104, false);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
