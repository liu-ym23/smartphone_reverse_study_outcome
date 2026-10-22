package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f299871e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f299872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f299873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f299874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f299875d;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        com.larus.bmhome.chat.component.cvs.y r102 = (com.larus.bmhome.chat.component.cvs.y) this.f299875d.getValue();     // Catch: Throwable -> L16
        String r103 = null;
        if (r102 == null) goto L6;
        String r104 = r102.getBotId();     // Catch: Throwable -> L16
    L7:
        r100.put("bot_id", r104);     // Catch: Throwable -> L16
        com.larus.bmhome.chat.component.trace.z r105 = (com.larus.bmhome.chat.component.trace.z) this.f299873b.getValue();     // Catch: Throwable -> L16
        if (r105 == null) goto L10;
        String r106 = r105.getChatType();     // Catch: Throwable -> L16
    L11:
        r100.put("chat_type", r106);     // Catch: Throwable -> L16
        r100.put("current_page", "chat");     // Catch: Throwable -> L16
        de8.c r107 = (de8.c) this.f299874c.getValue();     // Catch: Throwable -> L16
        if (r107 == null) goto L14;
        r103 = r107.p();     // Catch: Throwable -> L16
    L14:
        Object r108 = Result.m9449constructorimpl(r100.put("previous_page", r103));     // Catch: Throwable -> L16
    L18:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L21;
        FLogger.f375446a.e("LatestPhotoShortcutComponent", "[buildCommonParams] failed, " + r109);
    L21:
        return r100;
    L10:
        r106 = null;
        goto L11
    L6:
        r104 = null;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public g0(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        this.f299872a = r100;
        this.f299873b = LazyKt.lazy(new d0(this));
        this.f299874c = LazyKt.lazy(new e0(this));
        this.f299875d = LazyKt.lazy(new f0(this));
    }
}
