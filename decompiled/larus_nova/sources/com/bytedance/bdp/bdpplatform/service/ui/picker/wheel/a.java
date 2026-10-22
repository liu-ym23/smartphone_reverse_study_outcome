package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdp.bdpplatform.service.ui.BdpGameHostBaseUIServiceImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import ib4.g;
import ib4.h;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> extends d implements ib4.b<T> {
    public List<List<T>> R;
    public final List<List<String>> S;
    public int[] T;
    public final String U;
    public ib4.f V;
    public h W;
    public List<ib4.d> X;

    /* JADX INFO: renamed from: com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a$a, reason: collision with other inner class name */
    public class C2903a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ib4.d f201483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f201484b;

        @Override // ib4.g
        public final void a(int r100) {
            a r101 = this.f201484b;
            ib4.d r102 = this.f201483a;
            r101.getClass();
            int r103 = ((Integer) r102.getTag()).intValue();
            if (r101.V == null) goto L12;
            List r104 = (List) ListProtector.get(r101.R, r103);
            if (r104 == null) goto L12;
            if (r104.size() == 0) goto L12;
            if (r104.size() <= r100) goto L12;
            ib4.f r105 = r101.V;
            Object r106 = ListProtector.get((List) ListProtector.get(r101.R, r103), r100);
            ((BdpGameHostBaseUIServiceImpl.g.d) r105).f201422a.f201418d.onWheeled(r103, r100, r106);
        L12:
            this.f201484b.getClass();
        }

        public C2903a(a r100, WheelView r101) {
            this.f201484b = r100;
            this.f201483a = r101;
        }
    }

    @Override // ja4.e
    public final View e() {
        if (this.R.size() == 0) goto L23;
        LinearLayout r100 = new LinearLayout(this.f497851a);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r100.setOrientation(0);
        r100.setGravity(17);
        int r101 = this.R.size();
        this.X = new ArrayList();
        Context r102 = getContext();
        if (r102 == null) goto L9;
        Resources r103 = r102.getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        if (r104 == null) goto L9;
        int r105 = r104.widthPixels;
    L11:
        int r106 = (int) ((r105 / 1.0f) / r101);
        int r107 = 0;
    L12:
        if (r107 >= r101) goto L21;
        WheelView r108 = g();
        ((ArrayList) this.X).add(r108);
        r100.addView(r108.getWheelView());
        if (TextUtils.isEmpty(this.U) == false) goto L16;
        r108.setLayoutParams(new LinearLayout.LayoutParams(r106, -2));
    L16:
        int[] r109 = this.T;
        if (r109 == null) goto L19;
        int r110 = r109[r107];
    L20:
        r108.e((List) ListProtector.get(this.S, r107), r110);
        r108.setTag(Integer.valueOf(r107));
        r108.setOnItemSelectListener(new C2903a(this, r108));
        r107 = r107 + 1;
        goto L12
    L19:
        r110 = 0;
        goto L20
    L21:
        return r100;
    L9:
        r105 = 0;
        goto L11
    L23:
        throw new IllegalArgumentException("Items can't be empty");
    }

    @Override // ja4.e
    public final void f() {
        if (this.W == null) goto L12;
        List<ib4.d> r100 = this.X;
        if (r100 == null) goto L13;
        int r101 = ((ArrayList) r100).size();
        int[] r102 = new int[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        r102[r103] = ((ib4.d) ListProtector.get(this.X, r103)).getSelectedIndex();
        r103 = r103 + 1;
        goto L7
    L9:
        ((BdpGameHostBaseUIServiceImpl.g.c) this.W).f201421a.f201418d.onConfirm(r102);
        return;
    L13:
        return;
    }

    public a(Activity r100, List<List<T>> r101) {
        super(r100);
        this.R = new ArrayList();
        ArrayList r102 = new ArrayList();
        this.S = r102;
        this.U = "";
        if (r101 != null) goto L5;
    L25:
        ka4.a r103 = ka4.a.C6525a.f502185a;
        r103.f502184a = new WeakReference(this);
        return;
    L5:
        if (r101.size() == 0) goto L25;
        this.R = r101;
        r102.clear();
        Iterator<List<T>> r104 = r101.iterator();
    L9:
        if (r104.hasNext() == false) goto L25;
        List<T> r105 = r104.next();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L24;
        T r108 = r107.next();
        r101.size();
        if (this.O == false) goto L17;
        String r109 = r108.toString();
    L23:
        r106.add(r109);
        goto L12
    L17:
        if ((r108 instanceof Float) == false) goto L19;
    L22:
        r109 = new DecimalFormat("0.00").format(r108);
        goto L23
    L19:
        if ((r108 instanceof Double) == true) goto L22;
        r109 = r108.toString();
        goto L23
    L24:
        this.S.add(r106);
        goto L9
    }
}
