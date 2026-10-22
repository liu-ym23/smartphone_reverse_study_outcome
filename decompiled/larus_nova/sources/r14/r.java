package r14;

import com.bytedance.awemeopen.bizmodels.feed.ContentSdkFilterItemsAsStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(ContentSdkFilterItemsAsStringAdapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lr14/r;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f535646a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f535648b;

        public final int hashCode() {
            return Objects.hashCode(this.f535647a);
        }

        public final String toString() {
            return "aid : " + this.f535647a + " reason : " + this.f535648b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if ((r100 instanceof a) == true) goto L11;
        L13:
            return false;
        L11:
            if (Intrinsics.areEqual(this.f535647a, ((a) r100).f535647a) == false) goto L13;
            return true;
        }

        public a(String r100, String r101) {
            this.f535647a = r100;
            this.f535648b = r101;
        }
    }

    public r() {
    }
}
