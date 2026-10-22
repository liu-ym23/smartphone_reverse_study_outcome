package evc;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f474509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f474510b = null;

    static {
        f474509a = ByteString.encodeUtf8("\"\\");
        f474510b = ByteString.encodeUtf8("\t ,=");
    }

    public static long a(Response r100) {
        String r101 = r100.headers().get("Content-Length");
        if (r101 != null) goto L10;
    L7:
        return -1;
    L10:
        return CastLongProtector.parseLong(r101);
    }

    public static boolean b(Response r100) {
        if (r100.request().method().equals("HEAD") == false) goto L5;
        return false;
    L5:
        int r101 = r100.code();
        if (r101 < 100) goto L10;
        if (r101 >= 200) goto L10;
    L15:
        if (a(r100) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (DownloadHelper.VALUE_CHUNKED.equalsIgnoreCase(r100.header("Transfer-Encoding")) == true) goto L20;
        return false;
    L10:
        if (r101 == 204) goto L15;
        if (r101 == 304) goto L15;
        return true;
    }

    public static String d(Buffer r100) {
        long r101 = r100.indexOfElement(f474510b);     // Catch: EOFException -> L11
        if (r101 != (-1)) goto L6;
        r101 = r100.size();     // Catch: EOFException -> L11
    L6:
        if (r101 == 0) goto L9;
        return r100.readUtf8(r101);
    L9:
        return null;
    L12:
        throw new AssertionError();
    }

    public static int f(Buffer r100) {
        int r101 = 0;
    L4:
        if (r100.exhausted() == true) goto L8;
        if (r100.getByte(0) != 61) goto L8;
        r101 = r101 + 1;
        r100.readByte();
    L8:
        return r101;
    }

    public static boolean h(Buffer r100) {
        boolean r101 = false;
    L4:
        if (r100.exhausted() == true) goto L13;
        byte r102 = r100.getByte(0);
        if (r102 == 44) goto L7;
        if (r102 != 32) goto L11;
    L12:
        r100.readByte();
        goto L4
    L11:
        if (r102 != 9) goto L13;
    L7:
        r100.readByte();
        r101 = true;
    L13:
        return r101;
    }

    public static Set<String> i(Headers r100) {
        Set<String> r101 = Collections.emptySet();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        if ("Vary".equalsIgnoreCase(r100.name(r103)) == false) goto L13;
        String r104 = r100.value(r103);
        if (r101.isEmpty() == false) goto L10;
        r101 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    L10:
        String[] r105 = r104.split(",");
        int r106 = r105.length;
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L13;
        r101.add(r105[r107].trim());
        r107 = r107 + 1;
    L13:
        r103 = r103 + 1;
        goto L3
    L14:
        return r101;
    }

    public static int c(String r100, int r101) {
        long r102 = CastLongProtector.parseLong(r100);     // Catch: NumberFormatException -> L13
        if (r102 <= SieveCacheKt.NodeLinkMask) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r102 >= 0) goto L12;
        return 0;
    L12:
        return (int) r102;
    L16:
        return r101;
    }

    public static void e(okhttp3.h r100, HttpUrl r101, Headers r102) {
        if (r100 != okhttp3.h.f523873a) goto L5;
        return;
    L5:
        Pattern r103 = okhttp3.g.f523851j;
        List<String> r104 = r102.values("Set-Cookie");
        int r105 = r104.size();
        ArrayList r106 = null;
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L14;
        okhttp3.g r108 = okhttp3.g.c(r101, (String) ListProtector.get(r104, r107));
        if (r108 == null) goto L13;
        if (r106 != null) goto L12;
        r106 = new ArrayList();
    L12:
        r106.add(r108);
    L13:
        r107 = r107 + 1;
        goto L6
    L14:
        if (r106 == null) goto L16;
        List<okhttp3.g> r109 = Collections.unmodifiableList(r106);
    L18:
        if (r109.isEmpty() == false) goto L20;
        return;
    L20:
        r100.b(r101, r109);
        return;
    L16:
        r109 = Collections.emptyList();
        goto L18
    }

    public static int g(String r100, int r101, String r102) {
    L3:
        if (r101 >= r100.length()) goto L8;
        if (r102.indexOf(r100.charAt(r101)) != (-1)) goto L8;
        r101 = r101 + 1;
    L8:
        return r101;
    }
}
