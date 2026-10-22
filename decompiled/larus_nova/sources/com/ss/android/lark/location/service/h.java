package com.ss.android.lark.location.service;

import android.content.Context;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface h {

    public interface a {
        void a(POIInfo r100);
    }

    public interface b {
        void a(k r100);

        void b(List<POIInfo> r100);
    }

    void q(Context r100, POIInfo r101, com.ss.android.lark.location_ui.picklocation.k.a r102);

    void q0(double r100, double r101);

    double r0();

    void release();

    void s0(Context r100, Scene r101, b r102, int r103);

    double t0();

    void u0(Context r100, String r101, Scene r102, com.ss.android.lark.location_ui.picklocation.f r103);

    void v0(Context r100, double r101, double r102, Scene r103, com.ss.android.lark.location_ui.picklocation.h r104);
}
