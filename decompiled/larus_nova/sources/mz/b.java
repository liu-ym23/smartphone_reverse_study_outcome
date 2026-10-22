package mz;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f516438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f516439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f516440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f516441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f516442e;

    public final int a() {
        if (this.f516439b == false) goto L6;
        return 1;
    L6:
        if (this.f516440c == false) goto L9;
        return 2;
    L9:
        if (this.f516441d == false) goto L12;
        return 3;
    L12:
        if (this.f516442e == false) goto L14;
        return 4;
    L14:
        return 0;
    }

    public b(String r100) {
        if (r100 == null) goto L12;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        b(new JSONObject(r100), null);     // Catch: Throwable -> L6
        ALogger.d("RoomItemExplicitInfo", "info:" + r100 + ",isBaseSend:" + this.f516439b + ",isEcomSend:" + this.f516440c + ",isRevenueSend:" + this.f516441d + ",isGrouponSend:" + this.f516442e + "，stayTime:" + this.f516438a);     // Catch: Throwable -> L6
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Result.m9448boximpl(r102);
        return;
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public b(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        b(r100, r101);
    }

    public final void b(JSONObject r100, JSONObject r101) {
        boolean r102 = false;
        if (r100.optInt("mq2_is_base_send") != 1) goto L5;
        boolean r103 = true;
    L6:
        this.f516439b = r103;
        if (r100.optInt("mq2_is_ecom_send") != 1) goto L9;
        boolean r104 = true;
    L10:
        this.f516440c = r104;
        if (r100.optInt("mq2_is_revenue_send") != 1) goto L13;
        boolean r105 = true;
    L14:
        this.f516441d = r105;
        if (r100.optInt("mq2_is_groupon_send") != 1) goto L17;
        r102 = true;
    L17:
        this.f516442e = r102;
        float r106 = 0.0f;
        if (r101 == null) goto L25;
        String r107 = r101.optString("staytime");
        if (r107 == null) goto L24;
        Float r108 = StringsKt.toFloatOrNull(r107);
        if (r108 == null) goto L24;
        r106 = r108.floatValue();
    L24:
        this.f516438a = r106;
        return;
    L25:
        String r109 = r100.optString("feed_draw_client_targets_rec_info");
        if ((!StringsKt.isBlank(r109)) == true) goto L29;
        r109 = null;
    L29:
        if (r109 == null) goto L41;
        String r110 = new JSONObject(r109).optString("staytime");     // Catch: Exception -> L37
        if (r110 == null) goto L35;
        Float r111 = StringsKt.toFloatOrNull(r110);     // Catch: Exception -> L37
        if (r111 == null) goto L35;
        r106 = r111.floatValue();     // Catch: Exception -> L37
    L35:
        this.f516438a = r106;     // Catch: Exception -> L37
        return;
    L42:
        return;
    L41:
        return;
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
