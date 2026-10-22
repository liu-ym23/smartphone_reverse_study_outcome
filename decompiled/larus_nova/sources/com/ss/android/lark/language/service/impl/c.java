package com.ss.android.lark.language.service.impl;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import e0c.k;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Locale f431100a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f431101a = null;

        static {
            f431101a = new c();
        }
    }

    public final Locale a() {
        if (this.f431100a != null) goto L6;
        this.f431100a = ((apb.a) k.a(LarkAppContext.inst().getContext(), apb.a.class)).getLanguageSetting();
    L6:
        return this.f431100a;
    }

    public final boolean b() {
        return "en".equals(a().getLanguage().toLowerCase());
    }

    public final boolean c() {
        Locale r100 = a();
        if ("zh".equals(r100.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("CN".equals(r100.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public final boolean d() {
        Locale r100 = a();
        if ("zh".equals(r100.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HK".equals(r100.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public final boolean e() {
        Locale r100 = a();
        if ("zh".equals(r100.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("TW".equals(r100.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public c() {
    }
}
