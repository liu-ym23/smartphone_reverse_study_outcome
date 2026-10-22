package okio;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b0 implements Comparable<b0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f523973b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f523974a;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static b0 a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            ByteString r102 = okio.internal.c.f524039a;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return okio.internal.c.d(new Buffer().writeUtf8(r100), r101);
        }
    }

    static {
        new a();
        f523973b = File.separator;
    }

    public final List<ByteString> a() {
        ArrayList r100 = new ArrayList();
        int r101 = okio.internal.c.a(this);
        if (r101 != (-1)) goto L6;
        r101 = 0;
    L10:
        int r102 = this.f523974a.size();
        int r103 = r101;
    L11:
        if (r101 >= r102) goto L19;
        if (this.f523974a.getByte(r101) != 47) goto L15;
    L16:
        r100.add(this.f523974a.substring(r103, r101));
        r103 = r101 + 1;
    L17:
        r101 = r101 + 1;
        goto L11
    L15:
        if (this.f523974a.getByte(r101) != 92) goto L17;
    L19:
        if (r103 >= this.f523974a.size()) goto L21;
        ByteString r104 = this.f523974a;
        r100.add(r104.substring(r103, r104.size()));
    L21:
        return r100;
    L6:
        if (r101 >= this.f523974a.size()) goto L10;
        if (this.f523974a.getByte(r101) != 92) goto L10;
        r101 = r101 + 1;
        goto L10
    }

    public final b0 b() {
        ByteString r100 = this.f523974a;
        ByteString r101 = okio.internal.c.f524042d;
        if (Intrinsics.areEqual(r100, r101) == true) goto L51;
        ByteString r102 = this.f523974a;
        ByteString r103 = okio.internal.c.f524039a;
        if (Intrinsics.areEqual(r102, r103) == true) goto L52;
        ByteString r104 = this.f523974a;
        ByteString r105 = okio.internal.c.f524040b;
        if (Intrinsics.areEqual(r104, r105) == false) goto L9;
        return null;
    L9:
        if (this.f523974a.endsWith(okio.internal.c.f524043e) == true) goto L11;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == true) goto L56;
        int r107 = ByteString.lastIndexOf$default(this.f523974a, r103, 0, 2, null);
        if (r107 != (-1)) goto L26;
        r107 = ByteString.lastIndexOf$default(this.f523974a, r105, 0, 2, null);
    L26:
        if (r107 == 2) goto L28;
    L34:
        if (r107 == 1) goto L36;
    L38:
        if (r107 == (-1)) goto L40;
    L45:
        if (r107 == (-1)) goto L55;
        if (r107 != 0) goto L50;
        b0 r108 = new b0(ByteString.substring$default(this.f523974a, 0, 1, 1, null));
    L54:
        return r108;
    L50:
        return new b0(ByteString.substring$default(this.f523974a, 0, r107, 1, null));
    L55:
        return new b0(r101);
    L40:
        if (d() == null) goto L45;
        if (this.f523974a.size() == 2) goto L59;
        r108 = new b0(ByteString.substring$default(this.f523974a, 0, 2, 1, null));
        goto L54
    L59:
        return null;
    L36:
        if (this.f523974a.startsWith(r105) == false) goto L38;
        return null;
    L28:
        if (d() == null) goto L34;
        if (this.f523974a.size() == 3) goto L57;
        r108 = new b0(ByteString.substring$default(this.f523974a, 0, 3, 1, null));
        goto L54
    L57:
        return null;
    L56:
        return null;
    L11:
        if (this.f523974a.size() == 2) goto L18;
        ByteString r109 = this.f523974a;
        if (r109.rangeEquals(r109.size() - 3, r103, 0, 1) == true) goto L18;
        ByteString r110 = this.f523974a;
        if (r110.rangeEquals(r110.size() - 3, r105, 0, 1) == false) goto L19;
    L18:
        r106 = true;
        goto L20
    L52:
        return null;
    L51:
        return null;
    }

    public final Character d() {
        boolean r100 = false;
        if (ByteString.indexOf$default(this.f523974a, okio.internal.c.f524039a, 0, 2, null) == (-1)) goto L6;
        return null;
    L6:
        if (this.f523974a.size() >= 2) goto L9;
        return null;
    L9:
        if (this.f523974a.getByte(1) != 58) goto L29;
        char r101 = (char) this.f523974a.getByte(0);
        if ('a' <= r101) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L26;
        if ('A' <= r101) goto L21;
    L23:
        if (r100 == true) goto L26;
        return null;
    L21:
        if (r101 >= '[') goto L23;
        r100 = true;
    L26:
        return Character.valueOf(r101);
    L14:
        if (r101 >= '{') goto L16;
        r102 = true;
        goto L17
    L29:
        return null;
    }

    public final int hashCode() {
        return this.f523974a.hashCode();
    }

    public final String toString() {
        return this.f523974a.utf8();
    }

    public b0(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        this.f523974a = r100;
    }

    public final b0 c(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return okio.internal.c.b(this, okio.internal.c.d(new Buffer().writeUtf8(r100), false), false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(b0 r100) {
        b0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f523974a.compareTo2(r101.f523974a);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((b0) r100).f523974a, this.f523974a) == false) goto L7;
        return true;
    }
}
