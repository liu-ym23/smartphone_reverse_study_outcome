package com.bytedance.ies.argus.bean;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.argus.strategy.a;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class i<REWRITE_PAYLOAD extends com.bytedance.ies.argus.strategy.a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f246029k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f246030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArgusVerifyAction f246031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public REWRITE_PAYLOAD f246032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f246033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f246034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f246035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f246036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f246037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<o> f246038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f246039j;

    public static final class a {
    }

    public final class b extends com.bytedance.ies.argus.strategy.b {
        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "ruleName");
        }
    }

    static {
    }

    public final REWRITE_PAYLOAD b() {
        if (this.f246030a.f246021c == true) goto L7;
        return null;
    L7:
        return this.f246032c;
    }

    public final boolean c() {
        if (this.f246031b != ArgusVerifyAction.BLOCK) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.f246031b != ArgusVerifyAction.PASS) goto L5;
        return true;
    L5:
        return false;
    }

    public final JSONObject l() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.d(r100, "action", this.f246031b.getStringValue());
        JSONUtilsKt.d(r100, "reason", this.f246034e);
        REWRITE_PAYLOAD r101 = this.f246032c;
        if (r101 == null) goto L8;
        JSONObject r102 = r101.d(this.f246031b);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        JSONUtilsKt.d(r100, WsConstants.KEY_PAYLOAD, r101);
        JSONUtilsKt.d(r100, "extra", this.f246036g);
        return r100;
    L8:
        r101 = null;
        goto L9
    }

    public final JSONObject m(ArgusVerifyAction r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Map r100 = MapsKt.toMap(this.f246036g);
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "action", r110.getStringValue());
        JSONUtilsKt.d(r101, FlowNetworkIDLStub.OMNI_UPLOAD_REASON_CODE_KEY, Integer.valueOf(this.f246035f));
        JSONUtilsKt.d(r101, "reason", this.f246034e);
        ArrayList r102 = (ArrayList) this.f246037h;
        boolean r103 = true;
        if (r102.size() > 1) goto L6;
        r103 = false;
    L6:
        String r104 = null;
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L14;
        List r105 = CollectionsKt.toList(r102);
        if (r105 == null) goto L14;
        String r106 = CollectionsKt.joinToString$default(r105, ">", null, null, 0, null, null, 62, null);
    L15:
        JSONUtilsKt.d(r101, "reason_trace", r106);
        REWRITE_PAYLOAD r107 = this.f246032c;
        if (r107 == null) goto L20;
        JSONObject r111 = r107.d(r110);
        if (r111 == null) goto L20;
        r104 = r111.toString();
    L20:
        JSONUtilsKt.d(r101, "rewrite_payload", r104);
        Iterator r112 = r100.entrySet().iterator();
    L22:
        if (r112.hasNext() == false) goto L24;
        Map.Entry r108 = (Map.Entry) r112.next();
        JSONUtilsKt.d(r101, (String) r108.getKey(), ArgusGsonUtils.b(r108.getValue()));
        goto L22
    L24:
        return r101;
    L14:
        r106 = null;
        goto L15
    }

    public i(e r100, REWRITE_PAYLOAD r101) {
        Intrinsics.checkNotNullParameter(r100, "verifyMode");
        this.f246030a = r100;
        this.f246031b = ArgusVerifyAction.PASS;
        this.f246032c = r101;
        ArgusCommonVerifyReason r102 = ArgusCommonVerifyReason.UN_SET;
        this.f246034e = r102.getStrValue();
        this.f246035f = r102.getCode();
        this.f246036g = new ConcurrentHashMap();
        this.f246037h = new ArrayList();
        this.f246038i = new ArrayList();
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f246036g.put(r100, r101);
    }

    public final void n(o r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (r101 == null) goto L5;
        String r102 = r100.getStrValue() + ": " + r101;
    L6:
        ((ArrayList) this.f246037h).add(r102);
        this.f246034e = r102;
        this.f246035f = r100.getCode();
        return;
    L5:
        r102 = r100.getStrValue();
        goto L6
    }

    public final void e(o r100, String r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        setResult(ArgusVerifyAction.BLOCK, r100, r101, Boolean.TRUE);
        if (r102 == null) goto L8;
        REWRITE_PAYLOAD r103 = this.f246032c;
        if (r103 == null) goto L9;
        r102.invoke(r103);
        return;
    L9:
        return;
    }

    public final void h(o r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        setResult(ArgusVerifyAction.PASS, r100, r101, r102);
    }

    public static void g(i r100, o r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (r102 == null) goto L8;
        String r104 = r101.getStrValue() + ": " + r102;
    L9:
        ((ArrayList) r100.f246037h).add(r104);
        ((ArrayList) r100.f246038i).add(r101);
        return;
    L8:
        r104 = r101.getStrValue();
        goto L9
    }

    public static /* synthetic */ void i(i r100, o r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.h(r101, r102, null);
    }

    private final void setResult(ArgusVerifyAction r100, o r101, String r102, Boolean r103) {
        this.f246031b = r100;
        if (r103 == null) goto L5;
        this.f246033d = r103.booleanValue();
    L5:
        n(r101, r102);
        this.f246039j = true;
    }

    public final void j(o r100, String r101, Boolean r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r103, "rewrite");
        setResult(ArgusVerifyAction.REWRITE, r100, r101, r102);
        REWRITE_PAYLOAD r104 = this.f246032c;
        if (r104 == null) goto L6;
        r103.invoke(r104);
        return;
    }

    public static /* synthetic */ void f(i r100, o r101, String r102, Function1 r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.e(r101, r102, r103);
    }

    public static /* synthetic */ void k(i r100, o r101, String r102, Function1 r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.j(r101, r102, null, r103);
    }
}
