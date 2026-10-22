package com.larus.av_call.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f290642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<h88.b> f290643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h88.d f290644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f290645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends h88.d>, Function3<View, Boolean, Boolean, Unit>> f290646e;

    public static final class a {
    }

    static {
    }

    public final void a(h88.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        h88.d r101 = this.f290644c;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r103, r100.getType()) == false) goto L10;
        FLogger.f375446a.w("DynamicButton", "curState don't need change, type(" + r101.getType() + ')');
        return;
    L10:
        if (r101 == null) goto L12;
        r101.f484289a = null;
        r101.f484292d = null;
    L12:
        this.f290644c = r100;
        View r104 = this.f290642a;
        Function0<h88.b> r105 = this.f290643b;
        r100.f484289a = r104;
        r100.f484292d = r105;
        r100.d(this.f290645d);
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("button state changed from ");
        if (r101 == null) goto L15;
        r102 = r101.getType();
    L15:
        r107.append(r102);
        r107.append(" to ");
        r107.append(r100.getType());
        r106.w("DynamicButton", r107.toString());
        return;
    L5:
        r103 = null;
        goto L7
    }

    public b(AppCompatImageView r100, h88.d r101, z0 r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "realtimeRuntimeDataProvider");
        this.f290642a = r100;
        this.f290643b = r102;
        this.f290646e = new LinkedHashMap();
        if (r101 == null) goto L5;
        a(r101);
    L5:
        com.larus.utils.e1.d(r100, new com.larus.av_call.view.a(this));
    }
}
