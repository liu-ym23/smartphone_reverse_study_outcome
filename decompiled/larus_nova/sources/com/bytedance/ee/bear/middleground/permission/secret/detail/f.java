package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f234072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f234074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f234076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f234077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f234078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f234079h;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f234072a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f234072a = r100;
        this.f234073b = 47;
        this.f234074c = 14;
        this.f234075d = 73;
        this.f234076e = 12;
        this.f234077f = 18;
        this.f234078g = 2;
    }

    public final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        Rect r101 = new Rect();
        Paint r102 = new Paint();
        r102.setTextSize(n.G(this.f234074c));
        r102.getTextBounds(r100, 0, r100.length(), r101);
        float r103 = (float) Math.ceil(r101.width() / (n.d(this.f234075d) - (n.d(this.f234076e) * this.f234078g)));
        float r104 = r101.height() * r103;
        int r105 = n.d(this.f234077f);
        int r106 = this.f234078g;
        return (int) ((r104 + (r105 * r106)) + ((r103 - 1) * n.d(r106)));
    }
}
