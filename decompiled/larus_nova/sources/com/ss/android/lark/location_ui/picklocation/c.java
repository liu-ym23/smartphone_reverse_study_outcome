package com.ss.android.lark.location_ui.picklocation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void E2(double r100, double r101);

        void J3(Context r100, Bitmap r101, q r102);

        void S0(Context r100, Token r101, Scene r102, LocationView.d r103);

        void U4(Context r100, POIInfo r101, boolean r102);

        void i6(Context r100, String r101, Scene r102, LocationView.c.a r103);

        boolean isAdminGpsEnabled();

        void q(Context r100, POIInfo r101, k.a r102);

        void s5(Context r100, double r101, double r102, Scene r103, LocationView.a r104);

        List v5(boolean r100);

        void w6(Context r100, Scene r101, LocationView.i r102, int r103);
    }

    boolean i5();

    boolean onBackPressed();
}
