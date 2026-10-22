package si2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends lg.j {
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public final String a() {
        return this.b;
    }

    public final Unit c(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        String r0 = this.c;
        JSONObject r1 = r7.optJSONObject(r0);
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        String r2 = ((lg.j) this).a;
        JSONObject r3 = new JSONObject();
        r3.put("logId", this.d);
        r3.putOpt("detailUrl", this.e);
        r3.putOpt("orderUrl", this.f);
        r3.putOpt("jumpDestination", this.g);
        r3.putOpt("eventParams", this.h);
        Unit r4 = Unit.INSTANCE;
        r1.putOpt(r2, r3);
        r7.put(r0, r1);
        return Unit.INSTANCE;
    }

    public l(String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "originPath");
        Intrinsics.checkNotNullParameter(r4, "promotionId");
        Intrinsics.checkNotNullParameter(r5, "logId");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        String r1 = UriProtector.parse(r3).getPath();     // Catch: Throwable -> L8
        String r2 = r1;
        if (r1 != null) goto L6;
        r2 = r3;
    L6:
        Object r10 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L10:
        Object r11 = r3;
        if (Result.isFailure-impl(r10) == true) goto L14;
        r11 = r10;
    L14:
        super((String) r11);
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.b = "a1128.b3295";
        return;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
