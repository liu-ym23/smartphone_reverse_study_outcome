package vv;

import com.bytedance.android.gamecp.host_api.im.LiveImType;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final void a(c r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$decode");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "msg");
        LiveImType[] r103 = LiveImType.values();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        LiveImType r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getWsMethod(), r101) == true) goto L10;
        r105 = r105 + 1;
    L10:
        if (r106 != null) goto L21;
        LocalTestManager.a(new Class[]{uv.a.class});
        int r107 = x8.a.f562881a;
        x8.a.b("Gamecp-LiveMessage", r101 + " LiveMessage should register in LiveImType", false);
        return;
    L21:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        r100.onMessage(r106, (b) GsonHelper.a.f57435c.fromJson(r102, r106.getClz()));     // Catch: Throwable -> L15
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L25;
        LocalTestManager.a(new Class[]{uv.a.class});
        int r111 = x8.a.f562881a;
        x8.a.b("Gamecp-LiveMessage", "decode im " + r101 + " fail: " + r110.getMessage(), false);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L8:
        r106 = null;
        goto L10
    }
}
