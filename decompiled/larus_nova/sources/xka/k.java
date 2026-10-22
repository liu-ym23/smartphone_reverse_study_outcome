package xka;

import android.database.Cursor;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f564318b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564319a;

    public static final class a {
    }

    static {
        f564318b = new String[]{DBDefinition.ID, "event_id", DocumentType.MINUTES_NAME, com.alipay.sdk.m.p.e.f25671s};
    }

    public final JsonArray a() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonArray r101 = new JsonArray();
        Cursor r102 = r100.query(new ala.d(null, 3), f564318b, "event_id=?", new String[]{String.valueOf(this.f564319a)}, null);
        if (r102 == null) goto L20;
        Cursor r103 = r102;
        Cursor r104 = r103;     // Catch: Throwable -> L15
    L7:
        if (r104.moveToNext() == false) goto L13;
        long r105 = r104.getLong(0);     // Catch: Throwable -> L15
        long r106 = r104.getLong(1);     // Catch: Throwable -> L15
        if (r104.isNull(2) == false) goto L11;
        Integer r110 = null;
    L12:
        int r111 = r104.getInt(3);     // Catch: Throwable -> L15
        JsonObject r112 = new JsonObject();     // Catch: Throwable -> L15
        r112.addProperty("id", Long.valueOf(r105));     // Catch: Throwable -> L15
        r112.addProperty(com.heytap.mcssdk.constant.b.f276361k, Long.valueOf(r106));     // Catch: Throwable -> L15
        r112.addProperty(DocumentType.MINUTES_NAME, r110);     // Catch: Throwable -> L15
        r112.addProperty(com.alipay.sdk.m.p.e.f25671s, Integer.valueOf(r111));     // Catch: Throwable -> L15
        r101.add(r112);     // Catch: Throwable -> L15
        goto L7
    L11:
        r110 = Integer.valueOf(r104.getInt(2));     // Catch: Throwable -> L15
        goto L12
    L13:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r103, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L20:
        return r101;
    }

    @Override // vka.b
    public final /* bridge */ /* synthetic */ Object execute() {
        vka.f r100 = vka.f.f555548a;
        return a();
    }

    public k(long r100) {
        this.f564319a = r100;
    }
}
