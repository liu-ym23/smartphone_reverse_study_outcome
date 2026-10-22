package gc1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lgc1/d;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "content", "b", "setContent", "", "show", "Z", "e", "()Z", "setShow", "(Z)V", "toastContent", ce.f26391f, "setToastContent", "Lgc1/a;", "certificationData", "Lgc1/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lgc1/a;", "setCertificationData", "(Lgc1/a;)V", "Lgc1/b;", "contentData", "Lgc1/b;", "c", "()Lgc1/b;", "setContentData", "(Lgc1/b;)V", "Lgc1/c;", "relationData", "Lgc1/c;", "d", "()Lgc1/c;", "setRelationData", "(Lgc1/c;)V", "<init>", "()V", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("user_certification")
    private a certificationData;

    @SerializedName("content")
    private String content;

    @SerializedName("user_content")
    private b contentData;

    @SerializedName("user_relation")
    private c relationData;

    @SerializedName("show")
    private boolean show;

    @SerializedName("title")
    private String title;

    @SerializedName("toast")
    private String toastContent;

    public d() {
    }

    public final a a() {
        return this.certificationData;
    }

    public final String b() {
        return this.content;
    }

    public final b c() {
        return this.contentData;
    }

    public final c d() {
        return this.relationData;
    }

    public final boolean e() {
        return this.show;
    }

    public final String f() {
        return this.title;
    }

    public final String g() {
        return this.toastContent;
    }
}
