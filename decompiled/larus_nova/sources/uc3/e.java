package uc3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Luc3/e;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f549457id;

    @SerializedName("type")
    private Integer type;

    public e() {
        this(0);
    }

    public final Integer getType() {
        return this.type;
    }

    public e(int r100) {
        this.f549457id = null;
        this.type = null;
    }

    public final void a(String r100) {
        this.f549457id = r100;
    }

    public final void b(Integer r100) {
        this.type = r100;
    }
}
