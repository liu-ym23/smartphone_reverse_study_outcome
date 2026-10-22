package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public FrameLayout a;
    public a b;
    public View.OnClickListener c;
    public final Map<Integer, String> d;
    public final Map<Integer, String> e;
    public final Map<String, Integer> f;
    public List<String> g;
    public final List<TextView> h;
    public View i;
    public View j;

    public interface a {
        void a(int r1);
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ViewGroup c;

        public b(TextView r1, int r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            TextView r0 = this.a;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            r1.width = -2;
            r1.height = -2;
            Unit r2 = Unit.INSTANCE;
            r0.setLayoutParams(r1);
            TextView r3 = this.a;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r4 = null;
        L5:
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
            if (r5 != null) goto L8;
            return;
        L8:
            if (this.b != 0) goto L10;
            int r6 = 0;
        L11:
            r5.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6));
            r3.setLayoutParams(r5);
            return;
        L10:
            r6 = 24;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ViewGroup c;

        public c(e r1, String r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Map<String, Integer> r3 = this.a.f;
            HashMap r4 = (HashMap) r3;
            Integer r5 = (Integer) r4.get(this.b);
            if (r5 == null) goto L8;
            int r6 = r5.intValue();
            a r0 = this.a.b;
            if (r0 == null) goto L9;
            r0.a(r6);
            return;
        L9:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public e() {
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = CollectionsKt.emptyList();
        this.h = new ArrayList();
    }

    public final void a(ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "root");
        ((ArrayList) this.h).clear();
        View r0 = th.a.c(r12.getContext(), 2131560495, r12, true);
        if (r0 == null) goto L58;
        FrameLayout r1 = (FrameLayout) r0;
        this.a = r1;
        Context r2 = r1.getContext();
        ViewGroup r3 = null;
        if (r2 == null) goto L16;
        int r4 = eh.b.b(r2);
        FrameLayout r5 = this.a;
        if (r5 == null) goto L16;
        View r6 = r5.findViewById(2131374270);
        if (r6 == null) goto L16;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r7 = null;
    L13:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L16;
        r8.topMargin = r4;
        r6.setLayoutParams(r8);
    L16:
        FrameLayout r9 = this.a;
        if (r9 == null) goto L19;
        View r10 = r9.findViewById(2131376107);
    L20:
        this.j = r10;
        if (r10 == null) goto L24;
        r10.setOnClickListener(new d(this));
    L24:
        if (this.g.size() > 1) goto L26;
        return;
    L26:
        FrameLayout r11 = this.a;
        if (r11 == null) goto L29;
        r3 = (ViewGroup) r11.findViewById(2131390776);
    L29:
        if (r3 == null) goto L31;
        r3.removeAllViews();
    L31:
        Iterator<T> r13 = this.g.iterator();
        int r14 = 0;
    L33:
        if (r13.hasNext() == false) goto L47;
        String r15 = (String) r13.next();
        TextView r16 = new TextView(r12.getContext());
        int r17 = g.a;
        Intrinsics.checkNotNullParameter(r15, "type");
        String r18 = (String) ((LinkedHashMap) g.b).get(r15);
        if (r18 != null) goto L38;
        r18 = "";
    L38:
        if (r18.length() != 0) goto L40;
        boolean r19 = true;
    L41:
        if (r19 == true) goto L46;
        r16.setBackgroundResource(2131233416);
        r16.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r16.setText(r18);
        r16.setTextSize(17.0f);
        r16.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-1, r16.getContext().getResources().getColor(2131105971)}));
        r16.post(new b(r16, r14, r3));
        r16.setOnClickListener(new c(this, r15, r3));
        if (r3 == null) goto L45;
        r3.addView(r16);
    L45:
        ((ArrayList) this.h).add(r16);
    L46:
        r14 = r14 + 1;
        goto L33
    L40:
        r19 = false;
        goto L41
    L47:
        if (r3 == null) goto L49;
        int r110 = r3.getChildCount();
    L50:
        if (r110 > 1) goto L53;
        if (r3 == null) goto L62;
        r3.setVisibility(4);
        return;
    L62:
        return;
    L53:
        this.i = r3;
        if (r3 == null) goto L64;
        r3.setVisibility(0);
        return;
    L64:
        return;
    L49:
        r110 = 0;
        goto L50
    L19:
        r10 = null;
        goto L20
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void b(List<h> r11) {
        Intrinsics.checkNotNullParameter(r11, "galleryMediaModelGroupList");
        ((HashMap) this.d).clear();
        ((HashMap) this.f).clear();
        ((HashMap) this.e).clear();
        Iterator r0 = ((ArrayList) r11).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L10;
        h r3 = (h) r0.next();
        Iterator<T> r4 = r3.b.iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next();
        Map<Integer, String> r6 = this.d;
        int r7 = r2 + r5;
        HashMap r8 = (HashMap) r6;
        r8.put(Integer.valueOf(r7), r3.getType());
        Map<Integer, String> r9 = this.e;
        HashMap r10 = (HashMap) r9;
        r10.put(Integer.valueOf(r7), r3.c);
        r5 = r5 + 1;
        goto L7
    L9:
        Map<String, Integer> r12 = this.f;
        HashMap r13 = (HashMap) r12;
        r13.put(r3.getType(), Integer.valueOf(r2));
        r2 = r2 + r3.b.size();
        goto L4
    L10:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r14 = r11.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r1.add(((h) r14.next()).getType());
        goto L12
    L14:
        this.g = r1;
    }

    public final void c(int r4) {
        Map<Integer, String> r0 = this.d;
        HashMap r1 = (HashMap) r0;
        String r5 = (String) r1.get(Integer.valueOf(r4));
        if (r5 == null) goto L20;
        Iterator<String> r2 = this.g.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r2.next(), r5) == true) goto L12;
        r3 = r3 + 1;
    L12:
        int r6 = ((ArrayList) this.h).size();
        if (r3 < 0) goto L25;
        if (r6 <= r3) goto L24;
        TextView r7 = (TextView) ListProtector.get(this.h, r3);
        Intrinsics.checkNotNullParameter(r7, "indicatorSelected");
        Iterator r8 = ((ArrayList) this.h).iterator();
    L18:
        if (r8.hasNext() == false) goto L26;
        TextView r9 = (TextView) r8.next();
        r9.setSelected(Intrinsics.areEqual(r7, r9));
        goto L18
    L26:
        return;
    L24:
        return;
    L25:
        return;
    L11:
        r3 = -1;
        goto L12
    }
}
