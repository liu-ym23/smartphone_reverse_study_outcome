package com.ss.android.lark.passport.flow.core.network.handler;

import android.content.Context;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437774a = 0;

    static {
    }

    public static boolean b(Context r100, NetworkErrorResult r101) {
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L6;
        return a(r100, r101, Boolean.FALSE);
    L6:
        return a(r100, r101, Boolean.TRUE);
    }

    public static boolean a(Context r100, NetworkErrorResult r101, Boolean r102) {
        if (r101 == null) goto L30;
        if (r100 == null) goto L44;
        int r103 = r101.getErrorCode();
        ArrayList r104 = new ArrayList();
        int r105 = f.f437773a;
        ArrayList r106 = new ArrayList();
        r106.add(new d());
        r106.add(b.f437772a);
        r104.addAll(r106);
        if (r102 != null) goto L8;
    L10:
        Iterator r107 = r104.iterator();
    L12:
        if (r107.hasNext() == false) goto L20;
        Integer r108 = c.a((e) r107.next());
        if (r108 == null) goto L12;
        if (r103 != r108.intValue()) goto L12;
        return true;
    L20:
        ArrayList r109 = new ArrayList();
        int r110 = f.f437773a;
        ArrayList r111 = new ArrayList();
        r111.add(new AlertCodeHandler());
        r109.addAll(r111);
        Iterator r112 = r109.iterator();
    L22:
        if (r112.hasNext() == false) goto L45;
        e r113 = (e) r112.next();
        Integer r114 = c.a(r113);
        if (r114 == null) goto L22;
        if (r103 != r114.intValue()) goto L22;
        return r113.a(r100, r101);
    L45:
        return false;
    L8:
        if (r102.booleanValue() == false) goto L10;
        ArrayList r115 = new ArrayList();
        r115.add(new a());
        r104.addAll(r115);
        goto L10
    L44:
        return false;
    L30:
        return false;
    }
}
