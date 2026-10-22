package com.bytedance.ee.bear.lark.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: classes16.dex */
public interface r {

    public interface a {
        void a(Activity r100, POIInfo r101);
    }

    Fragment a(FragmentActivity r100, Token r101, wb5.c r102);

    void b(Context r100, Token r101, com.ss.android.lark.location.service.g.a r102);

    void c(Context r100, double r101, double r102, com.ss.android.lark.location.service.h.a r103);

    Fragment d(FragmentActivity r100, Token r101, vp4.h r102);

    void e(Activity r100, Token r101, wb5.c r102);

    void f(Activity r100, Token r101, a r102);

    void g(Context r100, Token r101, String r102, LocationHelper.d.a r103);
}
