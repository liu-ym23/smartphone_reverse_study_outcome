package v9b;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.light.processor.t;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValidateResult f553906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f553907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ValidateIMFileResult f553908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t.a f553909d;

    public static final class a {
    }

    /* JADX INFO: renamed from: v9b.b$b, reason: collision with other inner class name */
    public static final class C7975b<T> implements Comparator {
        public C7975b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((String) ((Map.Entry) r100).getKey(), (String) ((Map.Entry) r101).getKey());
        }
    }

    static {
    }

    public b() {
        this(null, false, null, 15);
    }

    public final String toString() {
        return "PermissionContextData(previewValidateResult=" + this.f553906a + ", hasPreviewPermission=" + this.f553907b + ", validateIMFileResult=" + this.f553908c + ", noPreviewDrawableConfig=" + this.f553909d + ')';
    }

    public final int hashCode() {
        int r100 = a(this.f553906a) * 31;
        if (this.f553907b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        t.a r103 = this.f553909d;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = (r102 + r105) * 31;
        ValidateIMFileResult r107 = this.f553908c;
        HashMap<String, ValidateIMFileResult> r108 = null;
        if (r107 == null) goto L13;
        IMFileResult r109 = r107.getResultType();
    L14:
        if (r109 == null) goto L16;
        int r110 = r109.hashCode();
    L17:
        int r111 = (r106 + r110) * 31;
        ValidateIMFileResult r112 = this.f553908c;
        if (r112 == null) goto L22;
        ValidateResult r113 = r112.getValidateResult();
        if (r113 == null) goto L22;
        r104 = a(r113);
    L22:
        int r114 = (r111 + r104) * 31;
        ValidateIMFileResult r115 = this.f553908c;
        if (r115 == null) goto L26;
        r108 = r115.getResultMap();
    L26:
        return r114 + b(r108);
    L16:
        r110 = 0;
        goto L17
    L13:
        r109 = null;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public static int a(ValidateResult r100) {
        if (r100.getResult() != ResultType.NULL) goto L5;
        return 0;
    L5:
        if (r100.getResult() != ResultType.ALLOW) goto L8;
        return 0;
    L8:
        return r100.getResult().hashCode();
    }

    public static int b(Map r100) {
        int r101 = 1;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return 0;
    L11:
        Iterator r103 = CollectionsKt.sortedWith(r100.entrySet(), new C7975b()).iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        Map.Entry r104 = (Map.Entry) r103.next();
        r101 = (((((r101 * 31) + ((String) r104.getKey()).hashCode()) * 31) + ((ValidateIMFileResult) r104.getValue()).getResultType().hashCode()) * 31) + a(((ValidateIMFileResult) r104.getValue()).getValidateResult());
        goto L13
    L15:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        HashMap<String, ValidateIMFileResult> r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r102) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.coremd.facade.bizext.context.PermissionContextData");
        b r103 = (b) r100;
        if (Intrinsics.areEqual(this.f553906a, r103.f553906a) == true) goto L16;
        return false;
    L16:
        if (this.f553907b == r103.f553907b) goto L18;
        return false;
    L18:
        ValidateIMFileResult r104 = this.f553908c;
        int r105 = 4;
        if (r104 == null) goto L23;
        IMFileResult r106 = r104.getResultType();
        if (r106 == null) goto L23;
        int r107 = r106.getValue();
    L24:
        ValidateIMFileResult r108 = r103.f553908c;
        if (r108 == null) goto L29;
        IMFileResult r109 = r108.getResultType();
        if (r109 == null) goto L29;
        r105 = r109.getValue();
    L29:
        if (r107 == r105) goto L31;
        return false;
    L31:
        ValidateIMFileResult r110 = this.f553908c;
        if (r110 == null) goto L34;
        HashMap<String, ValidateIMFileResult> r111 = r110.getResultMap();
    L35:
        int r112 = b(r111);
        ValidateIMFileResult r113 = r103.f553908c;
        if (r113 == null) goto L39;
        r101 = r113.getResultMap();
    L39:
        if (r112 == b(r101)) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f553909d, r103.f553909d) == true) goto L44;
        return false;
    L44:
        return true;
    L34:
        r111 = null;
    L23:
        r107 = 4;
        goto L24
    L8:
        r102 = null;
        goto L10
    }

    public b(ValidateResult r100, boolean r101, ValidateIMFileResult r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ValidateResult(ResultType.ALLOW);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "previewValidateResult");
        this.f553906a = r100;
        this.f553907b = r101;
        this.f553908c = r102;
        this.f553909d = null;
    }
}
