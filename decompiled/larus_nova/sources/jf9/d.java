package jf9;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import com.larus.im.internal.trace.manager.definition.GetTokenType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class d extends if9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f498917k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f498918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f498919m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f498920n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GetTokenType f498921o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f498922p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f498923q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f498924r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AVCommonError f498925s;

    public final String toString() {
        return "RTCGetTokenStep(" + c() + ", httStatusCode=" + this.f498917k + ", retryCount=" + this.f498918l + ", serverErrorCode=" + this.f498919m + ", logId=" + this.f498923q + ", roomId=" + this.f498920n + ", roomIsPreCreated=" + this.f498922p + ", json=" + this.f498924r + ')';
    }

    @Override // if9.a
    public final AVCommonError j() {
        return this.f498925s;
    }

    public d(long r100) {
        super("RTCGetTokenStep", r100);
        this.f498925s = AVCommonError.Connect_Timeout_Get_Token;
    }

    @Override // if9.a
    public final void g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        long r101 = k(this);
        long r102 = k(this.f489634i);
        r100.put("status_code", this.f489629d);
        r100.put("status_msg", this.f489630e);
        r100.putOpt("sub_status_code", this.f489631f);
        r100.putOpt("sub_status_msg", this.f489632g);
        r100.put("log_id", this.f498923q);
        r100.put("http_status_code", this.f498917k);
        r100.put("server_error_code", this.f498919m);
        r100.put("get_token_duration", r101);
        r100.put("get_token_retry_count", this.f498918l);
        r100.put(BindCardPayConfirmConstants.Key.TRACE_ID, this.f498920n);
        String r103 = this.f498924r;
        int r104 = 0;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L12;
        r100.put("ext", this.f498924r);
    L12:
        if (this.f498921o != GetTokenType.CACHE) goto L14;
        r104 = 1;
    L14:
        r100.put("is_token_preload", r104);
        r100.put("get_token_to_start_duration", r102);
        Boolean r106 = this.f498922p;
        if (r106 == null) goto L17;
        Integer r107 = Integer.valueOf(r106.booleanValue() ? 1 : 0);
    L18:
        r100.putOpt("server_pre_connect", r107);
        return;
    L17:
        r107 = null;
        goto L18
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r105 = false;
        goto L9
    }
}
