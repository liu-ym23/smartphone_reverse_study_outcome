package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.LinkedHashMap;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f457227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f457228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f457229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f457230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f457231e;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.a$a, reason: collision with other inner class name */
    public static final class C5468a {
    }

    static {
    }

    public a() {
        this.f457228b = true;
        this.f457229c = true;
        this.f457230d = true;
        this.f457231e = new String[0];
        new LinkedHashMap();
        this.f457227a = true;
    }

    public final boolean a(Effect r100) {
        if (this.f457227a == false) goto L5;
    L13:
        return true;
    L5:
        if (r100 != null) goto L7;
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        if (this.f457228b == true) goto L12;
        return false;
    L12:
        if (this.f457229c == true) goto L13;
        return false;
    L7:
        r101 = ArraysKt.contains(this.f457231e, r100.getPanel());
        goto L8
    }
}
