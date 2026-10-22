package com.larus.bmhome.chat.list.cell.text.components.middle;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f306265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gw8.c f306266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f306267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f306268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f306269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BotModel f306270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f306271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final lw8.d f306272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f306273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f306274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<pw8.b> f306275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f306276l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f306265a == r101.f306265a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f306266b, r101.f306266b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f306267c, r101.f306267c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f306268d, r101.f306268d) == true) goto L21;
        return false;
    L21:
        if (this.f306269e == r101.f306269e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f306270f, r101.f306270f) == true) goto L27;
        return false;
    L27:
        if (this.f306271g == r101.f306271g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f306272h, r101.f306272h) == true) goto L33;
        return false;
    L33:
        if (this.f306273i == r101.f306273i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f306274j, r101.f306274j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f306275k, r101.f306275k) == true) goto L42;
        return false;
    L42:
        if (this.f306276l == r101.f306276l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f306265a;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f306266b.hashCode()) * 31) + this.f306267c.hashCode()) * 31) + this.f306268d.hashCode()) * 31;
        int r102 = 1231;
        if (this.f306269e == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (((r101 + r103) * 31) + this.f306270f.hashCode()) * 31;
        if (this.f306271g == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((((((r104 + r105) * 31) + this.f306272h.hashCode()) * 31) + this.f306273i) * 31) + this.f306274j.hashCode()) * 31) + this.f306275k.hashCode()) * 31;
        if (this.f306276l == true) goto L15;
        r102 = 1237;
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "RenderParams(startTime=" + this.f306265a + ", markdownService=" + this.f306266b + ", context=" + this.f306267c + ", data=" + this.f306268d + ", finished=" + this.f306269e + ", bot=" + this.f306270f + ", enableDataTagOptimize=" + this.f306271g + ", customMarkDownInfo=" + this.f306272h + ", maxContentWidth=" + this.f306273i + ", contentViewGroup=" + this.f306274j + ", mdWidgetsHandlerList=" + this.f306275k + ", needForceUpdate=" + this.f306276l + ')';
    }

    public final Context getContext() {
        return this.f306267c;
    }

    public static h0 a(h0 r110, Message r111) {
        long r100 = r110.f306265a;
        gw8.c r101 = r110.f306266b;
        Context r102 = r110.f306267c;
        boolean r103 = r110.f306269e;
        BotModel r104 = r110.f306270f;
        boolean r105 = r110.f306271g;
        lw8.d r106 = r110.f306272h;
        int r112 = r110.f306273i;
        LinearLayout r113 = r110.f306274j;
        List<pw8.b> r114 = r110.f306275k;
        boolean r115 = r110.f306276l;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "markdownService");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r104, "bot");
        Intrinsics.checkNotNullParameter(r106, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r113, "contentViewGroup");
        Intrinsics.checkNotNullParameter(r114, "mdWidgetsHandlerList");
        return new h0(r100, r101, r102, r111, r103, r104, r105, r106, r112, r113, r114, r115);
    }

    public h0(long r100, gw8.c r101, Context r102, Message r103, boolean r104, BotModel r105, boolean r106, lw8.d r110, int r111, LinearLayout r112, List<pw8.b> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r101, "markdownService");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "data");
        Intrinsics.checkNotNullParameter(r105, "bot");
        Intrinsics.checkNotNullParameter(r110, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r112, "contentViewGroup");
        Intrinsics.checkNotNullParameter(r113, "mdWidgetsHandlerList");
        this.f306265a = r100;
        this.f306266b = r101;
        this.f306267c = r102;
        this.f306268d = r103;
        this.f306269e = r104;
        this.f306270f = r105;
        this.f306271g = r106;
        this.f306272h = r110;
        this.f306273i = r111;
        this.f306274j = r112;
        this.f306275k = r113;
        this.f306276l = r114;
    }
}
