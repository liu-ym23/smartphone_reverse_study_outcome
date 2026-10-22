package si2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends lg.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f542181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f542182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f542183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f542184h;

    @Override // lg.d
    public final String a() {
        return this.f542178b;
    }

    @Override // lg.j
    public final Unit c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        String r101 = this.f542179c;
        JSONObject r102 = r100.optJSONObject(r101);
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        String r103 = this.f509124a;
        JSONObject r104 = new JSONObject();
        r104.put("logId", this.f542180d);
        r104.putOpt("detailUrl", this.f542181e);
        r104.putOpt("orderUrl", this.f542182f);
        r104.putOpt("jumpDestination", this.f542183g);
        r104.putOpt("eventParams", this.f542184h);
        Unit r105 = Unit.INSTANCE;
        r102.putOpt(r103, r104);
        r100.put(r101, r102);
        return Unit.INSTANCE;
    }

    public l(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "originPath");
        Intrinsics.checkNotNullParameter(r101, "promotionId");
        Intrinsics.checkNotNullParameter(r102, "logId");
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L8
        String r108 = UriProtector.parse(r100).getPath();     // Catch: Throwable -> L8
        String r109 = r108;
        if (r108 != null) goto L6;
        r109 = r100;
    L6:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L8
    L10:
        Object r111 = r100;
        if (Result.m9455isFailureimpl(r110) == true) goto L14;
        r111 = r110;
    L14:
        super((String) r111);
        this.f542179c = r101;
        this.f542180d = r102;
        this.f542181e = r103;
        this.f542182f = r104;
        this.f542183g = r105;
        this.f542184h = r106;
        this.f542178b = "a1128.b3295";
        return;
    L8:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
