package okio.internal;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.b0;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f524039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f524040b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ByteString f524041c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f524042d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f524043e = null;

    static {
        ByteString.Companion.getClass();
        f524039a = ByteString.a.b(HTTP.URL_DEFAULT);
        f524040b = ByteString.a.b("\\");
        f524041c = ByteString.a.b("/\\");
        f524042d = ByteString.a.b(".");
        f524043e = ByteString.a.b(DownloadConstants.VULNERABILITY_PATH);
    }

    public static final int a(b0 r100) {
        if (r100.f523974a.size() == 0) goto L46;
        boolean r101 = false;
        if (r100.f523974a.getByte(0) != 47) goto L9;
    L7:
        return 1;
    L9:
        if (r100.f523974a.getByte(0) != 92) goto L19;
        if (r100.f523974a.size() <= 2) goto L7;
        if (r100.f523974a.getByte(1) != 92) goto L7;
        int r102 = r100.f523974a.indexOf(f524040b, 2);
        if (r102 != (-1)) goto L42;
        return r100.f523974a.size();
    L42:
        return r102;
    L19:
        if (r100.f523974a.size() > 2) goto L21;
        return -1;
    L21:
        if (r100.f523974a.getByte(1) == 58) goto L23;
        return -1;
    L23:
        if (r100.f523974a.getByte(2) != 92) goto L45;
        char r103 = (char) r100.f523974a.getByte(0);
        if ('a' <= r103) goto L27;
    L29:
        boolean r104 = false;
    L30:
        if (r104 == false) goto L32;
    L38:
        return 3;
    L32:
        if ('A' <= r103) goto L34;
    L36:
        if (r101 == true) goto L38;
        return -1;
    L34:
        if (r103 >= '[') goto L36;
        r101 = true;
        goto L36
    L27:
        if (r103 >= '{') goto L29;
        r104 = true;
        goto L30
    L45:
        return -1;
    L46:
        return -1;
    }

    public static final ByteString c(b0 r100) {
        ByteString r101 = r100.f523974a;
        ByteString r102 = f524039a;
        if (ByteString.indexOf$default(r101, r102, 0, 2, null) != (-1)) goto L10;
        ByteString r103 = r100.f523974a;
        ByteString r104 = f524040b;
        if (ByteString.indexOf$default(r103, r104, 0, 2, null) == (-1)) goto L9;
        return r104;
    L9:
        return null;
    L10:
        return r102;
    }

    public static final ByteString e(byte r100) {
        if (r100 == 47) goto L10;
        if (r100 != 92) goto L8;
        return f524040b;
    L8:
        throw new IllegalArgumentException("not a directory separator: " + r100);
    L10:
        return f524039a;
    }

    public static final ByteString f(String r100) {
        if (Intrinsics.areEqual(r100, HTTP.URL_DEFAULT) == false) goto L6;
        return f524039a;
    L6:
        if (Intrinsics.areEqual(r100, "\\") == false) goto L10;
        return f524040b;
    L10:
        throw new IllegalArgumentException("not a directory separator: " + r100);
    }

    public static final b0 d(Buffer r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Buffer r100 = new Buffer();
        ByteString r101 = null;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r110.rangeEquals(0, f524039a) == true) goto L99;
        ByteString r104 = f524040b;
        if (r110.rangeEquals(0, r104) == true) goto L99;
        if (r103 >= 2) goto L11;
    L13:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
        Intrinsics.checkNotNull(r101);
        r100.write(r101);
        r100.write(r101);
    L57:
        if (r100.size() <= 0) goto L59;
        boolean r106 = true;
    L60:
        ArrayList r107 = new ArrayList();
    L62:
        if (r110.exhausted() == true) goto L89;
        long r112 = r110.indexOfElement(f524041c);
        if (r112 != (-1)) goto L66;
        ByteString r113 = r110.readByteString();
    L67:
        ByteString r114 = f524043e;
        if (Intrinsics.areEqual(r113, r114) == true) goto L69;
        if (Intrinsics.areEqual(r113, f524042d) == true) goto L62;
        if (Intrinsics.areEqual(r113, ByteString.EMPTY) == true) goto L62;
        r107.add(r113);
        goto L62
    L69:
        if (r106 == false) goto L72;
        if (r107.isEmpty() == true) goto L62;
    L72:
        if (r111 == false) goto L83;
        if (r106 == true) goto L79;
        if (r107.isEmpty() == true) goto L83;
        if (Intrinsics.areEqual(CollectionsKt.last(r107), r114) == true) goto L83;
    L79:
        if (r105 == false) goto L82;
        if (r107.size() == 1) goto L62;
    L82:
        CollectionsKt.removeLastOrNull(r107);
    L83:
        r107.add(r113);
        goto L62
    L66:
        r113 = r110.readByteString(r112);
        r110.readByte();
        goto L67
    L89:
        int r108 = r107.size();
    L90:
        if (r102 >= r108) goto L95;
        if (r102 <= 0) goto L93;
        r100.write(r101);
    L93:
        r100.write((ByteString) ListProtector.get(r107, r102));
        r102 = r102 + 1;
        goto L90
    L95:
        if (r100.size() != 0) goto L98;
        r100.write(f524042d);
    L98:
        return new b0(r100.readByteString());
    L59:
        r106 = false;
        goto L60
    L17:
        if (r103 <= 0) goto L19;
        Intrinsics.checkNotNull(r101);
        r100.write(r101);
        goto L57
    L19:
        long r115 = r110.indexOfElement(f524041c);
        if (r101 != null) goto L26;
        if (r115 != (-1)) goto L24;
        r101 = f(b0.f523973b);
        goto L26
    L24:
        r101 = e(r110.getByte(r115));
    L26:
        if (Intrinsics.areEqual(r101, r104) == true) goto L29;
    L49:
        boolean r109 = false;
    L51:
        if (r109 == false) goto L57;
        if (r115 != 2) goto L55;
        r100.write(r110, 3);
        goto L57
    L55:
        r100.write(r110, 2);
        goto L57
    L29:
        if (r110.size() < 2) goto L49;
        if (r110.getByte(1) != 58) goto L49;
        char r116 = (char) r110.getByte(0);
        if ('a' <= r116) goto L37;
    L39:
        boolean r117 = false;
    L40:
        if (r117 == false) goto L42;
    L50:
        r109 = true;
        goto L51
    L42:
        if ('A' <= r116) goto L44;
    L46:
        boolean r118 = false;
    L47:
        if (r118 == false) goto L49;
    L44:
        if (r116 >= '[') goto L46;
        r118 = true;
        goto L47
    L37:
        if (r116 >= '{') goto L39;
        r117 = true;
        goto L40
    L11:
        if (Intrinsics.areEqual(r101, r104) == false) goto L13;
        r105 = true;
    L99:
        byte r119 = r110.readByte();
        if (r101 != null) goto L102;
        r101 = e(r119);
    L102:
        r103 = r103 + 1;
        goto L4
    }

    public static final b0 b(b0 r100, b0 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r101.getClass();
        if (a(r101) == (-1)) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L20:
        return r101;
    L8:
        if (r101.d() != null) goto L20;
        ByteString r104 = c(r100);
        if (r104 != null) goto L15;
        r104 = c(r101);
        if (r104 != null) goto L15;
        r104 = f(b0.f523973b);
    L15:
        Buffer r105 = new Buffer();
        r105.write(r100.f523974a);
        if (r105.size() <= 0) goto L18;
        r105.write(r104);
    L18:
        r105.write(r101.f523974a);
        return d(r105, r102);
    L5:
        r103 = false;
        goto L6
    }
}
