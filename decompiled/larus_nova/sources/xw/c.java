package xw;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lxw/c;", "", "", "category", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "message", "d", "h", "extra", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", ce.f26391f, "(Ljava/lang/Object;)V", "contentType", "b", "f", "<init>", "()V", "runtime"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("category")
    private String category;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("extra")
    private Object extra;

    @SerializedName("message")
    private String message;

    public final void f() {
        this.contentType = "application/json";
    }

    public c() {
        this.category = "";
        this.message = "";
        this.contentType = "";
    }

    public final String a() {
        return this.category;
    }

    public final String b() {
        return this.contentType;
    }

    public final Object c() {
        return this.extra;
    }

    public final String d() {
        return this.message;
    }

    public final void e(String r100) {
        this.category = r100;
    }

    public final void g(Object r100) {
        this.extra = r100;
    }

    public final void h(String r100) {
        this.message = r100;
    }
}
