package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdp.bdpbase.util.o;
import com.bytedance.bdp.bdpplatform.service.ui.BdpGameHostBaseUIServiceImpl;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpNormalPickerCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ib4.g;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> extends d {
    public List<T> R;
    public final List<String> S;
    public WheelView T;
    public InterfaceC2904b<T> U;
    public int V;
    public final String W;
    public final int X;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f201485a;

        public a(b r100) {
            this.f201485a = r100;
        }

        @Override // ib4.g
        public final void a(int r100) {
            b r101 = this.f201485a;
            r101.V = r100;
            r101.getClass();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.b$b, reason: collision with other inner class name */
    public interface InterfaceC2904b<T> {
    }

    @Override // ja4.e
    public final View e() {
        if (this.R.size() == 0) goto L13;
        LinearLayout r100 = new LinearLayout(this.f497851a);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r100.setOrientation(0);
        r100.setGravity(17);
        WheelView r101 = g();
        this.T = r101;
        r100.addView(r101);
        if (TextUtils.isEmpty(this.W) == false) goto L7;
        this.T.setLayoutParams(new LinearLayout.LayoutParams(this.f497852b, -2));
    L8:
        this.T.e(this.S, this.V);
        this.T.setOnItemSelectListener(new a(this));
        if (this.X == (-99)) goto L11;
        ViewGroup.LayoutParams r102 = this.T.getLayoutParams();
        r102.width = (int) o.a(this.f497851a, this.X);
        this.T.setLayoutParams(r102);
    L11:
        return r100;
    L7:
        this.T.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView r103 = new TextView(this.f497851a);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r103.setTextColor(this.K);
        r103.setTextSize(this.F);
        r103.setText(this.W);
        r100.addView(r103);
        goto L8
    L13:
        throw new IllegalArgumentException("Items can't be empty");
    }

    @Override // ja4.e
    public final void f() {
        InterfaceC2904b<T> r100 = this.U;
        if (r100 == null) goto L6;
        int r101 = this.T.getSelectedIndex();
        Object r102 = ListProtector.get(this.R, this.V);
        BdpGameHostBaseUIServiceImpl.d.c r103 = (BdpGameHostBaseUIServiceImpl.d.c) r100;
        r103.getClass();
        BdpNormalPickerCallback r104 = r103.f201411a.f201407c;
        r104.onItemPicked(r101, (String) r102);
        return;
    }

    public b(Activity r100, List<T> r101) {
        super(r100);
        this.R = new ArrayList();
        ArrayList r102 = new ArrayList();
        this.S = r102;
        this.V = 0;
        this.W = "";
        this.X = -99;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() == 0) goto L27;
        this.R = r101;
        r102.clear();
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        T r104 = r103.next();
        List<String> r105 = this.S;
        if ((r104 instanceof Float) == false) goto L13;
    L16:
        String r106 = new DecimalFormat("0.00").format(r104);
    L17:
        r105.add(r106);
        goto L9
    L13:
        if ((r104 instanceof Double) == true) goto L16;
        r106 = r104.toString();
        goto L17
    L18:
        WheelView r107 = this.T;
        if (r107 == null) goto L26;
        r107.e(this.S, this.V);
        return;
    L26:
        return;
    }
}
