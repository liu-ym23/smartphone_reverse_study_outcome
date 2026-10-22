package lh3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Llh3/e;", "", "", "cancel", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "confirm", "b", "d", "normalDesc", "getNormalDesc", "f", "", "Llh3/d;", "laws", "Ljava/util/List;", "getLaws", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("cancel")
    private String cancel;

    @SerializedName("confirm")
    private String confirm;

    @SerializedName("laws")
    private List<d> laws;

    @SerializedName("normal_desc")
    private String normalDesc;

    public e() {
    }

    public final String a() {
        return this.cancel;
    }

    public final String b() {
        return this.confirm;
    }

    public final void c(String r100) {
        this.cancel = r100;
    }

    public final void d(String r100) {
        this.confirm = r100;
    }

    public final void e(List<d> r100) {
        this.laws = r100;
    }

    public final void f(String r100) {
        this.normalDesc = r100;
    }
}
