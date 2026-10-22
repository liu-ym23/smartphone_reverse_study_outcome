package u56;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f548851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f548852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f548853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f548854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f548855e;

    public e(String r100, LinkedHashMap<String, String> r101, a r102, Integer r103, int r104) {
        this.f548851a = r100;
        this.f548852b = r101;
        this.f548853c = r102;
        this.f548854d = r103;
        this.f548855e = r104;
    }

    public final void a() {
        String r100 = this.f548851a;
        LinkedHashMap<String, String> r110 = this.f548852b;
        a r101 = this.f548853c;
        Integer r111 = this.f548854d;
        int r102 = this.f548855e;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L35
        JSONObject r104 = new JSONObject(r100);     // Catch: Throwable -> L6
        String r105 = null;
        String r106 = null;
        JSONObject r112 = r104;
        th = null;
    L13:
        boolean r107 = false;
        if (r105 != null) goto L16;
    L21:
        if (r107 == true) goto L26;
        if (th != null) goto L26;
        if (r106 != null) goto L26;
        r101.a(r112, r110, r111, r102);     // Catch: Throwable -> L35
    L33:
        int r108 = com.bytedance.ies.xbridge.utils.i.f249562a;     // Catch: Throwable -> L35
        com.bytedance.ies.xbridge.utils.i.a("x.request response:" + r112 + " header:" + r110 + " respCode:" + r111);     // Catch: Throwable -> L35
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        a r113 = this.f548853c;
        LinkedHashMap<String, String> r114 = this.f548852b;
        Integer r115 = this.f548854d;
        int r116 = this.f548855e;
        Throwable r117 = Result.m9452exceptionOrNullimpl(r109);
        if (r117 == null) goto L46;
        r113.b(new JSONObject(), r114, "", r117, r115, r116);
        return;
    L46:
        return;
    L26:
        if (r106 != null) goto L28;
        String r118 = "";
    L29:
        if (th != null) goto L31;
        Throwable r119 = new Throwable(r105);     // Catch: Throwable -> L35
    L32:
        r101.b(r112, r110, r118, r119, r111, r102);     // Catch: Throwable -> L35
        goto L33
    L31:
        r119 = th;
        goto L32
    L28:
        r118 = r106;
        goto L29
    L16:
        if (r105.length() <= 0) goto L18;
        boolean r120 = true;
    L19:
        if (r120 != true) goto L21;
        r107 = true;
        goto L21
    L18:
        r120 = false;
        goto L19
    L6:
        th = th;
        JSONObject r121 = new JSONObject();     // Catch: Throwable -> L35
        d.f548844a.getClass();     // Catch: Throwable -> L35
        if (r110.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L11;
        String r122 = r110.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L35
        if (r122 == null) goto L11;
    L12:
        r112 = r121.put("_Header_RequestID", r122);     // Catch: Throwable -> L35
        r106 = r100;
        r105 = th.getClass().toString() + ':' + th.getMessage();     // Catch: Throwable -> L35
    L11:
        r122 = "";
    L35:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
