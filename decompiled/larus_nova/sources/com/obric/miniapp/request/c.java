package com.obric.miniapp.request;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import d3.w;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398380a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f398380a = 2;
    }

    public static final void a(final c r100, final w r101, final String r102, final CompletableDeferred r103) {
        r100.getClass();
        JsonObject r104 = new JsonObject();
        r104.addProperty(WsConstants.KEY_PAYLOAD, r102);
        Unit r105 = Unit.INSTANCE;
        r101.i("applet.newMemoryRequest", r104, new NewMemoryRequest$executeFunction$2(r103), new NewMemoryRequest$executeFunction$3(r100, r101, r102, r103));
    }
}
