package no;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zq3.f;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends no.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f519881b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lno/b$a;", "", "", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btm", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("btm")
        private final String btm;

        @SerializedName("schema")
        private final String schema;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.schema;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.btm;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "OpenSchemaEventParams(schema=" + this.schema + ", btm=" + this.btm + ")";
        }

        public final String a() {
            return this.btm;
        }

        public final String b() {
            return this.schema;
        }
    }

    static {
        f519881b = new b();
    }

    public b() {
        super("open_schema");
    }

    @Override // no.a
    public final a b(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (a) uo.a.b(r100, a.class);
    }

    @Override // no.a
    public final void a(View r100, a r101) {
        a r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r102 == null) goto L13;
        String r103 = r102.b();
        if (r103 == null) goto L14;
        String r104 = r102.a();
        if (r104 == null) goto L11;
        int r105 = f.f573300a;
        r103 = f.c(r103, r104, PageFinder.via(r100), null);
    L11:
        p.f48130a.openSchema(r100.getContext(), r103);
        return;
    L14:
        return;
    }
}
