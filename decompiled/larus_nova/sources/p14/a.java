package p14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lp14/a;", "Ln14/a;", "Lp14/a$a;", "data", "Lp14/a$a;", "getData", "()Lp14/a$a;", "setData", "(Lp14/a$a;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a extends n14.a {

    @SerializedName("data")
    private C7140a data;

    /* JADX INFO: renamed from: p14.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lp14/a$a;", "", "", "saved", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setSaved", "(Z)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final class C7140a {

        @SerializedName("saved")
        private boolean saved;

        public C7140a() {
        }

        public final boolean a() {
            return this.saved;
        }
    }

    public final boolean e() {
        C7140a r100 = this.data;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public a() {
    }
}
