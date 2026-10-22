package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class k0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f496042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient.h f496043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f496044c;

    public /* synthetic */ k0(BrowserCdpClient r100, BrowserCdpClient.h r101, Integer r102) {
        this.f496042a = r100;
        this.f496043b = r101;
        this.f496044c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        final BrowserCdpClient r100 = this.f496042a;
        final BrowserCdpClient.h r101 = this.f496043b;
        Integer r102 = this.f496044c;
        JSONObject r111 = (JSONObject) r110;
        Intrinsics.checkNotNullParameter(r111, "response");
        boolean r103 = true;
        Integer r104 = null;
        if (r111.has("error") == true) goto L48;
        JSONObject r112 = r111.optJSONObject("result");
        r100.getClass();
        if (r112 == null) goto L48;
        JSONArray r105 = r112.optJSONArray("entries");
        if (r105 == null) goto L48;
        Integer r113 = BrowserCdpClient.F(r112, "currentIndex");
        if (r113 == null) goto L48;
        int r114 = r113.intValue();
        if (r114 >= r105.length()) goto L48;
        JSONObject r106 = r105.optJSONObject(r114);
        if (r106 == null) goto L48;
        Integer r107 = BrowserCdpClient.F(r106, "id");
        if (r107 == null) goto L48;
        r107.intValue();
        if (r114 <= 0) goto L26;
        JSONObject r108 = r105.optJSONObject(r114 - 1);
        if (r108 == null) goto L26;
        Integer r109 = BrowserCdpClient.F(r108, "id");
    L27:
        int r115 = r114 + 1;
        if (r115 >= r105.length()) goto L32;
        JSONObject r116 = r105.optJSONObject(r115);
        if (r116 == null) goto L32;
        Integer r117 = BrowserCdpClient.F(r116, "id");
    L33:
        Object r118 = r106.opt("url");
        if ((r118 instanceof String) == false) goto L36;
        String r119 = (String) r118;
    L37:
        if (r119 != null) goto L39;
    L46:
        r119 = null;
    L47:
        BrowserCdpClient.g r120 = new BrowserCdpClient.g(r109, r117, r119);
    L49:
        if (r120 != null) goto L51;
        r100.L(new BrowserCdpClient.i(false, false));
        r100.O(r101);
        return Unit.INSTANCE;
    L51:
        String r121 = r120.f319429c;
        if (r121 == null) goto L54;
        r100.I(r121, r101.f319430a.f319435a, r100.f319405y, Integer.valueOf(r101.f319431b));
    L54:
        if (r102 != null) goto L57;
    L60:
        if (r102 == null) goto L64;
        if (r104 == null) goto L64;
        r100.Z(r101, "Page.navigateToHistoryEntry", new JSONObject().put("entryId", r104.intValue()), new q0(r100, r101));
    L76:
        return Unit.INSTANCE;
    L64:
        if (r120.f319427a == null) goto L66;
        boolean r122 = true;
    L68:
        if (r120.f319428b != null) goto L71;
        r103 = false;
    L71:
        r100.L(new BrowserCdpClient.i(r122, r103));
        if (r120.f319429c != null) goto L74;
        r100.O(r101);
        goto L76
    L74:
        r100.l(r101, false);
        goto L76
    L66:
        r122 = false;
        goto L68
    L57:
        if (r102.intValue() >= 0) goto L59;
        r104 = r120.f319427a;
        goto L60
    L59:
        r104 = r120.f319428b;
        goto L60
    L39:
        if ((!StringsKt.isBlank(r119)) == true) goto L41;
    L43:
        boolean r123 = false;
    L44:
        if (r123 == false) goto L46;
    L41:
        if (r119.length() > 8192) goto L43;
        r123 = true;
        goto L44
    L36:
        r119 = null;
    L32:
        r117 = null;
    L26:
        r109 = null;
    L48:
        r120 = null;
        goto L49
    }
}
