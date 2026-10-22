package com.bytedance.awemeopen.bizmodels.user;

import android.app.Activity;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e f198221i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f198222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f198224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f198225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c24.b f198226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b24.a f198227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function4<Activity, LoginMethod, String, Map<String, String>, Unit> f198228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function6<Activity, LoginMethod, String, Map<String, String>, Integer, String, Unit> f198229h;

    public static final class a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.f198222a;
    }

    public f(Activity r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        this.f198222a = r100;
        this.f198223b = r101;
        this.f198224c = r102;
        Function6<Activity, LoginMethod, String, Map<String, String>, Integer, String, Unit> r103 = null;
        if (r100 == null) goto L7;
        e r104 = f198221i;
        if (r104 == null) goto L7;
        i04.b r105 = r104.d();
    L8:
        this.f198226e = r105;
        if (r100 == null) goto L13;
        e r106 = f198221i;
        if (r106 == null) goto L13;
        r106.b();
    L13:
        if (r100 == null) goto L17;
        e r107 = f198221i;
        if (r107 == null) goto L17;
        com.bytedance.awemeopen.awemesdk.se.a r108 = r107.e();
    L18:
        this.f198227f = r108;
        if (r100 == null) goto L23;
        e r109 = f198221i;
        if (r109 == null) goto L23;
        Function4<Activity, LoginMethod, String, Map<String, String>, Unit> r110 = r109.a();
    L24:
        this.f198228g = r110;
        if (r100 == null) goto L29;
        e r111 = f198221i;
        if (r111 == null) goto L29;
        r103 = r111.c();
    L29:
        this.f198229h = r103;
        return;
    L23:
        r110 = null;
    L17:
        r108 = null;
    L7:
        r105 = null;
        goto L8
    }
}
