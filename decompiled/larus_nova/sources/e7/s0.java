package e7;

import com.amap.api.col.s.ce;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006,"}, d2 = {"Le7/s0;", "", "", "url", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", com.alipay.sdk.m.p.e.f25671s, "c", ce.f26395j, "Lcom/google/gson/JsonObject;", "header", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", RXScreenCaptureService.KEY_INDEX, "(Lcom/google/gson/JsonObject;)V", "Lcom/google/gson/JsonElement;", ContainerPosition.BODY, "Lcom/google/gson/JsonElement;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonElement;", "setBody", "(Lcom/google/gson/JsonElement;)V", "responseType", "f", "l", "params", "e", "setParams", "", "usePrefetch", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "setUsePrefetch", "(Ljava/lang/Boolean;)V", "needCommonParams", "d", ce.f26396k, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName(ContainerPosition.BODY)
    private JsonElement body;

    @SerializedName("header")
    private JsonObject header;

    @SerializedName(com.alipay.sdk.m.p.e.f25671s)
    private String method;

    @SerializedName("needCommonParams")
    private Boolean needCommonParams;

    @SerializedName("params")
    private JsonObject params;

    @SerializedName("responseType")
    private String responseType;

    @SerializedName("url")
    private String url;

    @SerializedName("usePrefetch")
    private Boolean usePrefetch;

    public s0() {
    }

    public final JsonElement a() {
        return this.body;
    }

    public final JsonObject b() {
        return this.header;
    }

    public final String c() {
        return this.method;
    }

    public final Boolean d() {
        return this.needCommonParams;
    }

    public final JsonObject e() {
        return this.params;
    }

    public final String f() {
        return this.responseType;
    }

    public final String g() {
        return this.url;
    }

    public final Boolean h() {
        return this.usePrefetch;
    }

    public final void i(JsonObject r100) {
        this.header = r100;
    }

    public final void j(String r100) {
        this.method = r100;
    }

    public final void k(Boolean r100) {
        this.needCommonParams = r100;
    }

    public final void l(String r100) {
        this.responseType = r100;
    }

    public final void m(String r100) {
        this.url = r100;
    }
}
