package com.larus.dora.obric.device_management.device_home;

import androidx.core.view.OneShotPreDrawListener;
import com.larus.dora.impl.databinding.LarusDoraPageObricDeviceHomeBinding;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricDeviceHomeFragment f339211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoraObricDeviceHomeViewModel.c f339212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f339213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f339214d;

    public /* synthetic */ e0(DoraObricDeviceHomeFragment r100, DoraObricDeviceHomeViewModel.c r101, RecyclerView r102, boolean r103) {
        this.f339211a = r100;
        this.f339212b = r101;
        this.f339213c = r102;
        this.f339214d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final DoraObricDeviceHomeFragment r100 = this.f339211a;
        DoraObricDeviceHomeViewModel.c r101 = this.f339212b;
        RecyclerView r102 = this.f339213c;
        boolean r103 = this.f339214d;
        int r104 = DoraObricDeviceHomeFragment.R;
        r r105 = r101.f339098h;
        long r106 = r100.H;
        if (r105.f339333d == true) goto L5;
    L8:
        if (r103 == false) goto L29;
        final int r107 = r101.f339097g;
        LarusDoraPageObricDeviceHomeBinding r108 = r100.f339034f;
        if (r108 == null) goto L30;
        final RecyclerView r109 = r108.f333120n;
        if (r109 == null) goto L31;
        final LinearLayoutManager r110 = r100.f339047s;
        if (r110 == null) goto L32;
        boolean r111 = false;
        if (r107 < 0) goto L25;
        j r112 = r100.f339045q;
        if (r112 == null) goto L22;
        int r113 = r112.a();
    L23:
        if (r107 >= r113) goto L25;
        r111 = true;
        goto L25
    L22:
        r113 = 0;
    L25:
        if (r111 == false) goto L33;
        r109.post(new o0(r100, r109, r107, r110));
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L5:
        if (r106 == 0) goto L8;
        OneShotPreDrawListener.add(r102, new h1(r102, r100, r106));
        goto L8
    }
}
