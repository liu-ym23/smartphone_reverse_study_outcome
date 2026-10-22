package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.byted.cast.common.CommonOptionConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.JsonException;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.StatusCodeException;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseNetworkTask<T, R extends com.ss.ugc.effectplatform.model.e<T>> extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f457524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final INetworkClient f457525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final dlc.a f457526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final hlc.a f457527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f457528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f457529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final EffectConfig f457530m;

    public abstract NetRequest f();

    public String g(String r100) {
        return r100;
    }

    public int h() {
        return 10002;
    }

    public int i() {
        return 1;
    }

    public R o(dlc.a r100, ByteReadStream r101) {
        return null;
    }

    public abstract R p(dlc.a r100, String r101);

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public void a() {
        int r100 = b0.a.f16820a;
        long r110 = System.currentTimeMillis();
        int r101 = i();
        NetRequest r111 = f();
        String r102 = null;
    L3:
        int r112 = r101 - 1;
        if (r101 == 0) goto L93;
    L65:
        th = th;
        String r210 = r102;
    L58:
        int r113 = -2;
    L67:
        if (r112 == 0) goto L73;
        if ((th instanceof StatusCodeException) == true) goto L73;
        r102 = r210;
    L72:
        r101 = r112;
    L73:
        String r103 = r111.getUrl();
        String r104 = bytekn.foundation.utils.e.a(r103);     // Catch: Exception -> L76
    L78:
        if ((th instanceof Exception) == false) goto L80;
        ExceptionResult r105 = new ExceptionResult(th);
    L82:
        if (Intrinsics.areEqual(th.getMessage(), "java.io.IOException: Underlying input stream returned zero bytes") == false) goto L85;
        r105.setErrorCode(r113);
    L85:
        if ((!StringsKt.isBlank(this.f457524g)) == false) goto L91;
        String r106 = r105.getMsg();
        if (r106 != null) goto L89;
    L90:
        r105.setMsg("[LogId:" + this.f457524g + "], " + r105.getMsg());
        goto L91
    L89:
        if (StringsKt.contains$default(r106, "logId", false, 2, null) != true) goto L90;
    L91:
        r105.setLogId(this.f457524g);
        k(r103, r104, r105);
        Logger.INSTANCE.e("BaseNetworkTask", "fetch from network failed", th);
        return;
    L80:
        r105 = new ExceptionResult(CommonOptionConstants.OPTION_SET_SINK_DATA_LISTENER_AUDIO);
        r105.setMsg(th.getMessage());
    L76:
        r104 = null;
        goto L78
    L7:
        if (this.f457532b == true) goto L8;
        INetworkClient r107 = this.f457525h;     // Catch: Throwable -> L65
        if (r107 == null) goto L62;
        NetResponse r108 = r107.fetchFromNetwork(r111);     // Catch: Throwable -> L65
        if (r108 == null) goto L62;
        String r109 = r108.getLogId();     // Catch: Throwable -> L65
        String r114 = "";
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        this.f457524g = r109;     // Catch: Throwable -> L65
        int r115 = b0.a.f16820a;     // Catch: Throwable -> L65
        long r116 = System.currentTimeMillis();     // Catch: Throwable -> L65
        dlc.a r117 = this.f457526i;     // Catch: Throwable -> L65
        if (r117 == null) goto L60;
        EffectConfig r118 = this.f457530m;     // Catch: Throwable -> L65
        if (r118 != null) goto L105;
    L34:
        String r211 = r102;
        Pair<R, String> r119 = n(r108, r117);     // Catch: Throwable -> L56
        String r120 = r119.getSecond();     // Catch: Throwable -> L56
        com.ss.ugc.effectplatform.model.e r121 = r119.getFirst();     // Catch: Throwable -> L56
        String r122 = r120;
    L35:
        if (r121 == null) goto L55;
        long r123 = System.currentTimeMillis();     // Catch: Throwable -> L56
        if (r121.getStatusCode() != 0) goto L53;
        if (r121.checkValue() == false) goto L100;
    L56:
        th = th;
    L57:
        r210 = r211;
        goto L58
    L41:
        if (this.f457529l == true) goto L46;
        m(r110, r116, r123, r122, r121);     // Catch: Throwable -> L63
        j(r110, r116, r123);     // Catch: Throwable -> L63
        return;
    L46:
        if (r121.verifySign() == false) goto L50;
        m(r110, r116, r123, r122, r121);     // Catch: Throwable -> L63
        j(r110, r116, r123);     // Catch: Throwable -> L63
        return;
    L50:
        throw new IllegalArgumentException('[' + getTag() + "][verify failed][LogId:" + this.f457524g + ']');     // Catch: Throwable -> L63
    L100:
        r210 = r211;
        r113 = -2;
        r102 = "logId: " + this.f457524g + ", " + r121.getResponseMessage();     // Catch: Throwable -> L63
    L63:
        th = th;
        goto L67
    L53:
        throw new StatusCodeException(r121.getStatusCode(), '[' + getTag() + "][LogId:" + this.f457524g + "], " + r121.getResponseMessage());     // Catch: Throwable -> L63
    L55:
        throw new JsonException('[' + getTag() + "][json parser returned null!][LogId:" + this.f457524g + ']');     // Catch: Throwable -> L63
    L105:
    L32:
        th = th;
        r211 = r102;
        goto L57
    L23:
        if (r118.W != 1) goto L34;
        R r124 = o(r117, r108.getBodyStream());     // Catch: Throwable -> L65
        if (r124 == null) goto L30;
        Logger r125 = Logger.INSTANCE;     // Catch: Throwable -> L65
        StringBuilder r126 = new StringBuilder();     // Catch: Throwable -> L65
        r126.append("[FetchList][ID: ");     // Catch: Throwable -> L65
        r126.append(this.f457528k);     // Catch: Throwable -> L65
        r126.append("][");     // Catch: Throwable -> L65
        r126.append(getTag());     // Catch: Throwable -> L65
        r126.append("][Json-2][");     // Catch: Throwable -> L65
        r211 = r102;
        r126.append(System.currentTimeMillis() - r116);     // Catch: Throwable -> L56
        r126.append(']');     // Catch: Throwable -> L56
        r125.d("JKL", r126.toString());     // Catch: Throwable -> L56
    L31:
        r121 = r124;
        r122 = r114;
        goto L35
    L30:
        r211 = r102;
        Pair<R, String> r127 = n(r108, this.f457526i);     // Catch: Throwable -> L56
        r114 = r127.getSecond();     // Catch: Throwable -> L56
        r124 = r127.getFirst();     // Catch: Throwable -> L56
        goto L31
    L60:
        throw new RuntimeException('[' + getTag() + "][json converter is null][LogId:" + this.f457524g + ']');     // Catch: Throwable -> L63
    L62:
        throw new NetException(-2, '[' + getTag() + "][Net response returned null!]");     // Catch: Throwable -> L63
    L8:
        return;
    L93:
        String r212 = r102;
        ExceptionResult r128 = new ExceptionResult(h());
        if (r212 == null) goto L96;
        r128.setMsg(r212);
    L96:
        r128.setLogId(this.f457524g);
        k(null, null, r128);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new BaseNetworkTask$onCancel$1(this));
    }

    public final Pair<R, String> n(NetResponse r100, dlc.a r110) {
        int r101 = b0.a.f16820a;
        long r102 = System.currentTimeMillis();
        String r103 = com.ss.ugc.effectplatform.extension.c.a(r100.getBodyStream());
        long r104 = System.currentTimeMillis() - r102;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L11;
        String r106 = g(r103);
        long r107 = System.currentTimeMillis();
        com.ss.ugc.effectplatform.model.e r111 = p(r110, r106);
        Logger.INSTANCE.d("JKL", "[FetchList][ID: " + this.f457528k + "][" + getTag() + "][String - " + r104 + "][Json - " + (System.currentTimeMillis() - r107) + ']');
        return new Pair(r111, r106);
    L11:
        throw new NetException(-2, "[LogId:" + this.f457524g + "][net response returned empty response!][LogId:" + this.f457524g + "][errorMsg: " + r100.getErrorMsg() + ']');
    L5:
        r105 = false;
        goto L7
    }

    public final void j(long r100, long r101, long r102) {
        Logger r103 = Logger.INSTANCE;
        StringBuilder r104 = new StringBuilder("[FetchList][ID: ");
        r104.append(this.f457528k);
        r104.append("][");
        r104.append(getTag());
        r104.append("][Net - ");
        r104.append(r101 - r100);
        r104.append("][Json - ");
        r104.append(r102 - r101);
        r104.append("][Disk - ");
        int r105 = b0.a.f16820a;
        r104.append(System.currentTimeMillis() - r102);
        r104.append("][Total - ");
        r104.append(System.currentTimeMillis() - r100);
        r104.append(']');
        r103.w("JKL", r104.toString());
    }

    public void k(String r100, String r101, final ExceptionResult r102) {
        if (this.f457528k == null) goto L6;
        e(new BaseNetworkTask$onFailure$$inlined$apply$lambda$1(this, r102));
        return;
    }

    public void l(long r100, long r101, long r102, R r103) {
        final Object r104 = r103.getResponseData();
        if (r104 != null) goto L5;
        return;
    L5:
        if (this.f457528k == null) goto L9;
        e(new BaseNetworkTask$onSuccess$$inlined$apply$lambda$1(this, r104));
        return;
    }

    public /* synthetic */ BaseNetworkTask(INetworkClient r100, dlc.a r101, hlc.a r110, String r111, boolean r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public void m(long r100, long r110, long r111, String r112, R r113) {
        l(r100, r110, r111, r113);
    }

    public BaseNetworkTask(INetworkClient r100, dlc.a r101, hlc.a r102, String r103, boolean r104, EffectConfig r105) {
        super(r103, r102);
        this.f457525h = r100;
        this.f457526i = r101;
        this.f457527j = r102;
        this.f457528k = r103;
        this.f457529l = r104;
        this.f457530m = r105;
        this.f457524g = "";
    }
}
