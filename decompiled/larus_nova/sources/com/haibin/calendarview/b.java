package com.haibin.calendarview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class b<T> extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f276142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f276143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f276144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f276145d;

    public class a extends AbstractViewOnClickListenerC3865b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f276146a;

        public a(b r100) {
            this.f276146a = r100;
        }
    }

    /* JADX INFO: renamed from: com.haibin.calendarview.b$b, reason: collision with other inner class name */
    public static abstract class AbstractViewOnClickListenerC3865b implements View.OnClickListener {
        public AbstractViewOnClickListenerC3865b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            RecyclerView.ViewHolder r111 = (RecyclerView.ViewHolder) r110.getTag();
            int r100 = r111.getAdapterPosition();
            r111.getItemId();
            c r112 = ((a) this).f276146a.f276143b;
            if (r112 == null) goto L40;
            YearRecyclerView.a r113 = (YearRecyclerView.a) r112;
            YearRecyclerView r101 = r113.f276117a;
            if (r101.f276116c != null) goto L7;
            return;
        L7:
            if (r101.f276114a == null) goto L42;
            z r102 = r101.f276115b;
            if (r100 >= 0) goto L11;
            r102.getClass();
        L15:
            Object r103 = null;
        L16:
            Month r104 = (Month) r103;
            if (r104 == null) goto L43;
            int r105 = r104.getYear();
            int r106 = r104.getMonth();
            YearRecyclerView r107 = r113.f276117a;
            l r108 = r107.f276114a;
            int r109 = r108.T;
            int r114 = r108.V;
            int r115 = r108.U;
            int r116 = r108.W;
            if (r105 < r109) goto L27;
            if (r105 > r115) goto L27;
            if (r105 != r109) goto L24;
            if (r106 < r114) goto L27;
        L24:
            if (r105 != r115) goto L26;
            if (r106 > r116) goto L27;
        L26:
            boolean r117 = true;
        L28:
            if (r117 == false) goto L44;
            YearRecyclerView.b r118 = r107.f276116c;
            int r119 = r104.getYear();
            int r120 = r104.getMonth();
            i r121 = (i) r118;
            CalendarView r122 = r121.f276152a;
            l r123 = r122.f276090a;
            int r124 = (((r119 - r123.T) * 12) + r120) - r123.V;
            r122.f276094e.setVisibility(8);
            r122.f276095f.setVisibility(0);
            if (r124 != r122.f276091b.getCurrentItem()) goto L37;
            l r125 = r122.f276090a;
            CalendarView.e r126 = r125.f276177k0;
            if (r126 != null) goto L35;
        L38:
            r122.f276095f.animate().translationY(0.0f).setInterpolator(new LinearInterpolator()).setDuration(280).setListener(new j(r122));
            r122.f276091b.animate().scaleX(1.0f).scaleY(1.0f).setDuration(180).setInterpolator(new LinearInterpolator()).setListener(new k(r122));
            r121.f276152a.f276090a.getClass();
            r113.f276117a.f276114a.getClass();
            return;
        L35:
            if (r125.f276160c == 1) goto L38;
            ql5.t r127 = (ql5.t) r126;
            r127.a(r125.f276183n0, false);
            goto L38
        L37:
            r122.f276091b.setCurrentItem(r124, false);
            goto L38
        L44:
            return;
        L27:
            r117 = false;
            goto L28
        L43:
            return;
        L11:
            if (r100 >= ((ArrayList) r102.f276142a).size()) goto L15;
            r103 = ListProtector.get(r102.f276142a, r100);
            goto L16
        L42:
            return;
        }
    }

    public interface c {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f276142a).size();
    }

    public b(Context r100) {
        this.f276145d = r100;
        this.f276142a = new ArrayList();
        LayoutInflater.from(r100);
        this.f276144c = new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Object r102 = ListProtector.get(this.f276142a, r101);
        z r103 = (z) this;
        Month r104 = (Month) r102;
        YearView r105 = ((z.a) r100).f276252a;
        int r106 = r104.getYear();
        int r107 = r104.getMonth();
        r105.f276133p = r106;
        r105.f276134q = r107;
        int r108 = r105.f276118a.f276156a;
        r105.f276135r = f.d(r106, r107, f.c(r106, r107), r108);
        f.f(r105.f276133p, r105.f276134q, r105.f276118a.f276156a);
        int r109 = r105.f276133p;
        int r110 = r105.f276134q;
        l r111 = r105.f276118a;
        r105.f276127j = f.m(r109, r110, r111.f276165e0, r111.f276156a);
        r105.f276136s = 6;
        Map<String, Calendar> r112 = r105.f276118a.f276175j0;
        if (r112 != null) goto L5;
    L18:
        r105.a(r103.f276250f, r103.f276251g);
        return;
    L5:
        if (r112.size() == 0) goto L18;
        Iterator r113 = ((ArrayList) r105.f276127j).iterator();
    L9:
        if (r113.hasNext() == false) goto L18;
        Calendar r114 = (Calendar) r113.next();
        if (r105.f276118a.f276175j0.containsKey(r114.toString()) == true) goto L12;
        r114.setScheme("");
        r114.setSchemeColor(0);
        r114.setSchemes(null);
        goto L9
    L12:
        Calendar r115 = r105.f276118a.f276175j0.get(r114.toString());
        if (TextUtils.isEmpty(r115.getScheme()) == false) goto L15;
        String r116 = r105.f276118a.S;
    L16:
        r114.setScheme(r116);
        r114.setSchemeColor(r115.getSchemeColor());
        r114.setSchemes(r115.getSchemes());
        goto L9
    L15:
        r116 = r115.getScheme();
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        z r102 = (z) this;
        if (TextUtils.isEmpty(r102.f276249e.O) == false) goto L11;
        YearView r103 = new o(r102.f276145d);
    L9:
        r103.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        z.a r104 = new z.a(r103, r102.f276249e);
        r104.itemView.setTag(r104);
        r104.itemView.setOnClickListener(this.f276144c);
        return r104;
    L11:
        r103 = (YearView) r102.f276249e.P.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r102.f276145d});     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        r103 = new o(r102.f276145d);
        goto L9
    }
}
