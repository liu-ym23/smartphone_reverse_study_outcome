package wyb;

import com.alibaba.fastjson.JSONObject;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f561896b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561897a;

    /* JADX INFO: renamed from: wyb.a$a, reason: collision with other inner class name */
    public static final class C8175a {
        public static a a(JSONObject r100) {
            if (r100 == null) goto L5;
            String r101 = r100.getString("channel");
        L7:
            return new a(r101);
        L5:
            r101 = null;
            goto L7
        }

        public static boolean b(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            String r101 = r100.toLowerCase(Locale.US);
            if (StringsKt.isBlank(r101) == false) goto L7;
        L10:
            return true;
        L7:
            if (a.f561896b.contains(r101) == true) goto L10;
            return false;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f561897a, ((a) r100).f561897a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f561897a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FlowIdpAuthInfo(channel=" + this.f561897a + ')';
    }

    static {
        f561896b = SetsKt.setOf(new String[]{"enterprise", "b_idp", "bidp"});
    }

    public final boolean a() {
        return C8175a.b(this.f561897a);
    }

    public a(String r100) {
        this.f561897a = r100;
    }
}
