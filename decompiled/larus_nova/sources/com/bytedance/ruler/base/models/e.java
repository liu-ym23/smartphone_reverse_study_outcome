package com.bytedance.ruler.base.models;

import com.amap.api.col.s.ce;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ruler/base/models/e;", "", "", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonElement;", "conf", "Lcom/google/gson/JsonElement;", "b", "()Lcom/google/gson/JsonElement;", "f", "(Lcom/google/gson/JsonElement;)V", "cel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "key", "c", ce.f26391f, "ruler-base_release"}, k = 1, mv = {1, 4, 0})
public class e {

    @SerializedName("cel")
    private String cel;

    @SerializedName("conf")
    private JsonElement conf;

    @SerializedName("key")
    private String key;

    @SerializedName("title")
    private String title;

    public e() {
        this(null, null, null, null);
    }

    public final String a() {
        return this.cel;
    }

    public final JsonElement b() {
        return this.conf;
    }

    public final String c() {
        return this.key;
    }

    public final String d() {
        return this.title;
    }

    public final void e(String r100) {
        this.cel = r100;
    }

    public final void f(JsonElement r100) {
        this.conf = r100;
    }

    public final void g(String r100) {
        this.key = r100;
    }

    public final void h(String r100) {
        this.title = r100;
    }

    public e(String r100, JsonElement r101, String r102, String r103) {
        this.title = r100;
        this.conf = r101;
        this.cel = r102;
        this.key = r103;
    }
}
