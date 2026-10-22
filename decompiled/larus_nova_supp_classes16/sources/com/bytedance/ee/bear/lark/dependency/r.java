package com.bytedance.ee.bear.lark.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface r {

    public interface a {
        void a(Activity r1, POIInfo r2);
    }

    Fragment a(FragmentActivity r1, Token r2, wb5.c r3);

    void b(Context r1, Token r2, com.ss.android.lark.location.service.g.a r3);

    void c(Context r1, double r2, double r4, com.ss.android.lark.location.service.h.a r6);

    Fragment d(FragmentActivity r1, Token r2, vp4.h r3);

    void e(Activity r1, Token r2, wb5.c r3);

    void f(Activity r1, Token r2, a r3);

    void g(Context r1, Token r2, String r3, LocationHelper.d.a r4);
}
