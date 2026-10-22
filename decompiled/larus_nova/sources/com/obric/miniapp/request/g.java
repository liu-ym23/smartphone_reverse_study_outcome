package com.obric.miniapp.request;

import com.google.gson.JsonObject;
import d3.w;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398388a;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f398388a = 2;
    }

    public static final void a(final g r100, final w r110, final long r111, final CompletableDeferred r112) {
        r100.getClass();
        JsonObject r101 = new JsonObject();
        r101.addProperty("date", Long.valueOf(r111));
        Unit r102 = Unit.INSTANCE;
        r110.i("applet.queryHolidays", r101, new QueryDayTypeRequest$executeFunction$2(r112), new QueryDayTypeRequest$executeFunction$3(r100, r110, r111, r112));
    }
}
