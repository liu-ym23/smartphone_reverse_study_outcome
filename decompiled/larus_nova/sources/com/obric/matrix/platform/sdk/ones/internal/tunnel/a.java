package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import io.reactivex.j;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f396997a = null;

    public a() {
    }

    static {
        SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        f396997a = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        new HashSet();
    }

    public static final void a(int r100, j r101, bka.b r102, int r103, String r104) {
        gka.b.a("CmdManager", "handleBinderCallFail, errorCode: " + r103 + ", errorMsg: " + r104);
        Response r105 = new Response.Builder().statusCode(Integer.valueOf(r103)).errorMsg(r104).build();
        int r106 = fka.a.f477673a;
        bka.a r107 = bka.a.f19387a;
        fka.a.a(r100, r105);
        if (r101 == null) goto L5;
        r101.onSuccess(new Pair(Integer.valueOf(r100), r105));
    L5:
        if (r102 == null) goto L8;
        r102.a(r105);
        return;
    }
}
