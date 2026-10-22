package com.larus.browsertakeover.cdp;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.browsertakeover.transport.f;
import com.larus.utils.logger.FLogger;
import iv8.i0;
import iv8.o;
import iv8.p;
import iv8.q;
import iv8.r;
import iv8.x;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements BrowserTransport.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f319462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f319463b;

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onConnected() {
        if (this.f319462a == this.f319463b.f319387g.get()) goto L5;
        return;
    L5:
        if (this.f319463b.f319403w == false) goto L7;
        return;
    L7:
        if (this.f319463b.f319402v == true) goto L17;
        this.f319463b.f319402v = true;
        this.f319463b.H("cdp");
        if (this.f319463b.y() == false) goto L12;
        BrowserCdpClient r100 = this.f319463b;
        int r101 = this.f319462a;
        r100.f319388h.incrementAndGet();
        r100.f319404x = "bound-page";
        r100.f319405y = r100.G;
        r100.G = null;
        r100.F = null;
        r100.J(BrowserCdpClient.State.ATTACHING);
        r100.r("bound-page", r101);
        return;
    L12:
        BrowserCdpClient r102 = this.f319463b;
        int r103 = this.f319462a;
        r102.getClass();
        r102.J(BrowserCdpClient.State.ATTACHING);
        BrowserCdpClient.Y(r102, "Target.setDiscoverTargets", new JSONObject().put("discover", true), null, false, null, 28);
        r102.k(r103);
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onDisconnected() {
        if (this.f319462a == this.f319463b.f319387g.get()) goto L5;
        return;
    L5:
        if (this.f319463b.f319403w == true) goto L19;
        this.f319463b.G(NotificationCompat.CATEGORY_TRANSPORT, "peer_disconnected");
        this.f319463b.f319402v = false;
        this.f319463b.f319392l.clear();
        BrowserCdpClient r100 = this.f319463b;
        LinkedHashMap<Integer, String> r101 = r100.f319394n;
        monitor-enter(r101);
        r100.f319394n.clear();     // Catch: Throwable -> L13
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        this.f319463b.Q();
        this.f319463b.J(BrowserCdpClient.State.DISCONNECTED);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onError() {
        if (this.f319462a == this.f319463b.f319387g.get()) goto L5;
        return;
    L5:
        if (this.f319463b.f319403w == true) goto L19;
        this.f319463b.G(NotificationCompat.CATEGORY_TRANSPORT, "connection_error");
        this.f319463b.f319402v = false;
        this.f319463b.f319392l.clear();
        BrowserCdpClient r100 = this.f319463b;
        LinkedHashMap<Integer, String> r101 = r100.f319394n;
        monitor-enter(r101);
        r100.f319394n.clear();     // Catch: Throwable -> L13
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        this.f319463b.Q();
        this.f319463b.J(BrowserCdpClient.State.ERROR);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f319462a == this.f319463b.f319387g.get()) goto L5;
        return;
    L5:
        if (this.f319463b.f319403w == true) goto L33;
        BrowserCdpClient r100 = this.f319463b;
        int r101 = this.f319462a;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (r100.n() == true) goto L11;
    L25:
        monitor-exit(r100);
        return;
    L11:
        if (r100.f319402v == false) goto L25;
        if (r100.w("bound-page", r101) == false) goto L25;
        String r102 = r110.optString(e.f25671s);     // Catch: Throwable -> L27
        BrowserCdpClient.C(r100, "cdp_receive", "event", r102, null, 24);     // Catch: Throwable -> L27
        if (r110.has("id") == false) goto L18;
    L23:
        monitor-exit(r100);
        return;
    L18:
        if (Intrinsics.areEqual(r102, "Page.screencastFrame") == false) goto L23;
        r100.o(r110.optJSONObject("params"), "bound-page", r101, true);     // Catch: Throwable -> L27
        monitor-exit(r100);
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onMessage(String r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if (this.f319462a == this.f319463b.f319387g.get()) goto L5;
        return;
    L5:
        if (this.f319463b.f319403w == true) goto L254;
        final BrowserCdpClient r100 = this.f319463b;
        final int r101 = this.f319462a;
        monitor-enter(r100);
    L245:
        th = move-exception;
        throw th;
    L9:
        if (r100.f319402v == true) goto L11;
    L243:
        monitor-exit(r100);
        return;
    L11:
        if (r100.f319403w == true) goto L243;
        if (r101 != r100.f319387g.get()) goto L243;
        if (r110.length() <= 8388608) goto L252;
        FLogger.f375446a.e("BrowserCdpClient", "CDP message exceeded limit");     // Catch: Throwable -> L245
        r100.g();     // Catch: Throwable -> L245
        r100.G("cdp", "message_too_large");     // Catch: Throwable -> L245
        r100.J(BrowserCdpClient.State.ERROR);     // Catch: Throwable -> L245
        monitor-exit(r100);
        return;
    L252:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        Object r111 = Result.m9449constructorimpl(new JSONObject(r110));     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r111) != null) goto L240;
        JSONObject r112 = (JSONObject) r111;     // Catch: Throwable -> L245
        boolean r103 = true;
        final String r113 = null;
        if (r112.has("id") == false) goto L77;
        int r114 = r112.optInt("id", -1);     // Catch: Throwable -> L245
        BrowserCdpClient.k r115 = r100.f319392l.get(Integer.valueOf(r114));     // Catch: Throwable -> L245
        LinkedHashMap<Integer, String> r104 = r100.f319394n;     // Catch: Throwable -> L245
        monitor-enter(r104);     // Catch: Throwable -> L245
        String r105 = r100.f319394n.remove(Integer.valueOf(r114));     // Catch: Throwable -> L74
        monitor-exit(r104);     // Catch: Throwable -> L245
        if (r105 != null) goto L36;
        if (r115 == null) goto L35;
        r105 = r115.f319438a;     // Catch: Throwable -> L245
        goto L36
    L35:
        String r106 = null;
    L37:
        if (r115 != null) goto L41;
        r100.D("cdp_response_ignored", r106);     // Catch: Throwable -> L245
        monitor-exit(r100);
        return;
    L41:
        BrowserCdpClient.C(r100, "cdp_receive", "response", r106, Integer.valueOf(r114), 16);     // Catch: Throwable -> L245
        if (r115.f319441d == false) goto L44;
    L47:
        String r107 = r112.optString("sessionId");     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L245
        if ((!StringsKt.isBlank(r107)) == true) goto L51;
        r107 = null;
    L51:
        if (r107 != null) goto L54;
        r107 = "bound-page";
        if (r100.y() == true) goto L54;
    L55:
        String r108 = r115.f319439b;     // Catch: Throwable -> L245
        if (r108 == null) goto L62;
        if (Intrinsics.areEqual(r113, r108) == true) goto L62;
        monitor-exit(r100);
        return;
    L62:
        if (r100.N(r114) == r115) goto L66;
        monitor-exit(r100);
        return;
    L66:
        if (r112.has("error") == false) goto L69;
        r100.B("cdp_command_failed", "response", r115.f319438a, Integer.valueOf(r114), true);     // Catch: Throwable -> L245
    L71:
        r115.f319442e.invoke(r112);     // Catch: Throwable -> L245
        monitor-exit(r100);
        return;
    L69:
        if (r115.f319443f == null) goto L71;
        FLogger.f375446a.i("BrowserCdpClient", "client=" + r100.f319395o + " generation=" + r101 + " event=page_enable_ready id=" + r114 + " retries=" + (r115.f319443f.size() - 1));     // Catch: Throwable -> L245
    L54:
        r113 = r107;
        goto L55
    L44:
        if (r115.f319440c == r100.f319388h.get()) goto L47;
        monitor-exit(r100);
        return;
    L36:
        r106 = r105;
        goto L37
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L245
    L77:
        String r109 = r112.optString(e.f25671s);     // Catch: Throwable -> L245
        if (r100.y() == false) goto L87;
        f r116 = f.f319693a;     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L245
        boolean r117 = r100.n();     // Catch: Throwable -> L245
        r116.getClass();     // Catch: Throwable -> L245
        Intrinsics.checkNotNullParameter(r109, e.f25671s);     // Catch: Throwable -> L245
        if (Intrinsics.areEqual(r109, "Page.screencastFrame") == false) goto L82;
        boolean r118 = !r117;     // Catch: Throwable -> L245
    L83:
        if (r118 == true) goto L87;
        r100.D("cdp_event_ignored", r109);     // Catch: Throwable -> L245
        monitor-exit(r100);
        return;
    L82:
        r118 = f.f319694b.contains(r109);     // Catch: Throwable -> L245
    L87:
        BrowserCdpClient.C(r100, "cdp_receive", "event", r109, null, 24);     // Catch: Throwable -> L245
        JSONObject r119 = r112.optJSONObject("params");     // Catch: Throwable -> L245
        final String r120 = r112.optString("sessionId");     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L245
        if ((!StringsKt.isBlank(r120)) == true) goto L91;
        r120 = null;
    L91:
        if (r120 != null) goto L96;
        r120 = "bound-page";
        if (r100.y() == true) goto L96;
        r120 = null;
    L96:
        if (r109 != null) goto L98;
    L238:
        monitor-exit(r100);
        return;
    L98:
        switch(r109.hashCode()) {
            case -1378624189: goto L226;
            case -789158631: goto L219;
            case -654646050: goto L210;
            case -494332091: goto L185;
            case -29564360: goto L181;
            case -26394982: goto L177;
            case 793870872: goto L165;
            case 795089482: goto L150;
            case 1174023384: goto L133;
            case 1593801818: goto L127;
            case 1792618827: goto L110;
            case 1798530217: goto L101;
            default: goto L238;
        };     // Catch: Throwable -> L245
    L101:
        if (r109.equals("Inspector.detached") == false) goto L238;
        if (r120 != null) goto L107;
        monitor-exit(r100);
        return;
    L107:
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L238;
        r100.f319384d.post(new r(r100, r120, r101));     // Catch: Throwable -> L245
        goto L238
    L110:
        if (r109.equals("Target.targetDestroyed") == false) goto L238;
        if (r119 == null) goto L238;
        String r121 = r119.optString("targetId");     // Catch: Throwable -> L245
        if (r121 == null) goto L238;
        if ((!StringsKt.isBlank(r121)) == false) goto L118;
        r113 = r121;
    L118:
        if (r113 == null) goto L238;
        if (Intrinsics.areEqual(r113, r100.f319405y) == false) goto L123;
    L125:
        r100.Q();     // Catch: Throwable -> L245
        r100.J(BrowserCdpClient.State.ATTACHING);     // Catch: Throwable -> L245
        r100.f319384d.postDelayed(new i0(r101, r100), 250);     // Catch: Throwable -> L245
        goto L238
    L123:
        if (Intrinsics.areEqual(r113, r100.f319406z) == true) goto L125;
    L127:
        if (r109.equals("Page.navigatedWithinDocument") == false) goto L238;
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L238;
        r100.U(true);     // Catch: Throwable -> L245
        goto L238
    L133:
        if (r109.equals("Target.targetInfoChanged") == false) goto L238;
        if (r119 == null) goto L137;
        JSONObject r122 = r119.optJSONObject("targetInfo");     // Catch: Throwable -> L245
    L138:
        if (r122 == null) goto L140;
        String r123 = r122.optString("targetId");     // Catch: Throwable -> L245
    L142:
        if (Intrinsics.areEqual(r123, r100.f319405y) == false) goto L238;
        if (r122 == null) goto L145;
        String r124 = r122.optString("url");     // Catch: Throwable -> L245
    L146:
        if (r124 != null) goto L148;
        r124 = "";
    L148:
        r100.I(r124, r101, r100.f319405y, null);     // Catch: Throwable -> L245
        goto L238
    L145:
        r124 = null;
        goto L146
    L140:
        r123 = null;
        goto L142
    L137:
        r122 = null;
        goto L138
    L150:
        if (r109.equals("Target.detachedFromTarget") == false) goto L238;
        if (r119 == null) goto L238;
        String r125 = r119.optString("sessionId");     // Catch: Throwable -> L245
        if (r125 == null) goto L238;
        if ((!StringsKt.isBlank(r125)) == false) goto L158;
        r113 = r125;
    L158:
        if (r113 == null) goto L238;
        if (Intrinsics.areEqual(r113, r100.f319404x) == false) goto L238;
        r100.Q();     // Catch: Throwable -> L245
        r100.J(BrowserCdpClient.State.ATTACHING);     // Catch: Throwable -> L245
        r100.f319384d.postDelayed(new x(r101, r100), 250);     // Catch: Throwable -> L245
        goto L238
    L165:
        if (r109.equals("Page.screencastVisibilityChanged") == false) goto L238;
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L238;
        if (r119 != null) goto L171;
    L173:
        r103 = false;
    L174:
        if (r103 == false) goto L238;
        BrowserCdpClient.a0(r100, "Page.bringToFront", new JSONObject());     // Catch: Throwable -> L245
        goto L238
    L171:
        if (r119.optBoolean("visible", true) == true) goto L173;
    L177:
        if (r109.equals("Target.targetCreated") == false) goto L238;
        r100.q(r119, r101);     // Catch: Throwable -> L245
        goto L238
    L181:
        if (r109.equals("Target.targetCrashed") == false) goto L238;
        r100.p(r119);     // Catch: Throwable -> L245
        goto L238
    L185:
        if (r109.equals("Page.frameNavigated") == false) goto L238;
        if (r119 == null) goto L191;
        JSONObject r126 = r119.optJSONObject("frame");     // Catch: Throwable -> L245
        if (r126 == null) goto L191;
        String r127 = r126.optString("parentId");     // Catch: Throwable -> L245
    L192:
        if (r127 != null) goto L194;
        r127 = "";
    L194:
        if (r120 == null) goto L238;
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L238;
        if (r127.length() == 0) goto L201;
        r103 = false;
    L201:
        if (r103 == false) goto L238;
        if (r119 == null) goto L206;
        JSONObject r128 = r119.optJSONObject("frame");     // Catch: Throwable -> L245
        if (r128 == null) goto L206;
        r113 = r128.optString("url");     // Catch: Throwable -> L245
    L206:
        if (r113 != null) goto L208;
        r113 = "";
    L208:
        r100.f319384d.post(new o(r100, r120, r101, r113));     // Catch: Throwable -> L245
    L191:
        r127 = null;
        goto L192
    L210:
        if (r109.equals("Inspector.targetCrashed") == false) goto L238;
        if (r120 != null) goto L216;
        monitor-exit(r100);
        return;
    L216:
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L238;
        r100.f319384d.post(new q(r100, r120, r101));     // Catch: Throwable -> L245
        goto L238
    L219:
        if (r109.equals("Page.loadEventFired") == false) goto L238;
        if (r120 != null) goto L224;
        monitor-exit(r100);
        return;
    L224:
        r100.f319384d.postDelayed(new p(r100, r120, r101), 250);     // Catch: Throwable -> L245
        goto L238
    L226:
        if (r109.equals("Page.screencastFrame") == false) goto L238;
        if (r100.n() == false) goto L232;
        monitor-exit(r100);
        return;
    L232:
        if (r120 == null) goto L238;
        if (Intrinsics.areEqual(r120, r100.f319404x) == false) goto L236;
        r113 = r120;
    L236:
        if (r113 == null) goto L238;
        r100.o(r119, r113, r101, false);     // Catch: Throwable -> L245
        goto L238
    L240:
        FLogger.f375446a.e("BrowserCdpClient", "received malformed CDP JSON");     // Catch: Throwable -> L245
        monitor-exit(r100);
        return;
    L22:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L245
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L245
        goto L25
    }

    public a(int r100, BrowserCdpClient r101) {
        this.f319462a = r100;
        this.f319463b = r101;
    }
}
