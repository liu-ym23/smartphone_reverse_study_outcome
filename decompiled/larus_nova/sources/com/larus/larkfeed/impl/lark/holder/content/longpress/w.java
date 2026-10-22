package com.larus.larkfeed.impl.lark.holder.content.longpress;

import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.log.Log;
import hq9.n3;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements o99.a {
    public w() {
    }

    @Override // o99.b
    public final void d() {
    }

    @Override // o99.c
    public final void e(q99.d r100) {
    }

    @Override // o99.b
    public final void h() {
    }

    @Override // o99.b
    public final void i() {
    }

    @Override // o99.b
    public final Bundle b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return r100;
    }

    @Override // o99.b
    public final n3 f(n3 r100) {
        Intrinsics.checkNotNullParameter(r100, "originalRequest");
        Intrinsics.checkNotNullParameter(r100, "originalRequest");
        return r100;
    }

    @Override // o99.a
    public final void a(q99.m r100, q99.l r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "error");
        Log.v("yyytest!!", "send [" + r101.f532169a + "]:" + r101.f532170b);
    }

    @Override // o99.b
    public final void c(q99.e r100, q99.a r101) {
        o99.a.C7024a.a(r100, r101);
    }

    @Override // o99.a
    public final void g(q99.m r100, q99.n r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "result");
        Message r102 = r101.f532178a;
        StringBuilder r103 = new StringBuilder("send ok;[feedback]");
        Map<String, String> r104 = null;
        if (r102 == null) goto L5;
        Integer r105 = r102.getFeedback();
    L6:
        r103.append(r105);
        r103.append("[ext]");
        if (r102 == null) goto L9;
        r104 = r102.getExt();
    L9:
        r103.append(r104);
        Log.v("yyytest!!", r103.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // o99.b
    public final void j(q99.e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r100, "delivery");
    }
}
