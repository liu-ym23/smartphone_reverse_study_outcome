package ty8;

import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Message;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f548005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f548006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f548007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GalleryType f548009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f548010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c4 f548011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f548012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f548013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f548014j;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f548005a, r101.f548005a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548006b, r101.f548006b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548007c, r101.f548007c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548008d, r101.f548008d) == true) goto L21;
        return false;
    L21:
        if (this.f548009e == r101.f548009e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548010f, r101.f548010f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f548011g, r101.f548011g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f548012h, r101.f548012h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f548013i, r101.f548013i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f548014j, r101.f548014j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f548005a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m1 r104 = this.f548006b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.f548007c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f548008d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f548009e.hashCode()) * 31;
        JSONObject r113 = this.f548010f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        c4 r116 = this.f548011g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f548012h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f548013i;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return ((r121 + r101) * 31) + this.f548014j.hashCode();
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatGalleryData(message=" + this.f548005a + ", imageData=" + this.f548006b + ", videoData=" + this.f548007c + ", botId=" + this.f548008d + ", resourceType=" + this.f548009e + ", reportParams=" + this.f548010f + ", videoParams=" + this.f548011g + ", key=" + this.f548012h + ", desc=" + this.f548013i + ", ext=" + this.f548014j + ')';
    }

    public b(Message r100, m1 r101, g r102, GalleryType r103, JSONObject r104, c4 r105, String r106, String r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 32) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 64) == 0) goto L18;
        r105 = null;
    L18:
        if ((r111 & 128) == 0) goto L21;
        r106 = null;
    L21:
        if ((r111 & 256) == 0) goto L24;
        r110 = null;
    L24:
        if ((r111 & 512) == 0) goto L26;
        ConcurrentHashMap<String, String> r112 = new ConcurrentHashMap();
    L27:
        Intrinsics.checkNotNullParameter(r103, "resourceType");
        Intrinsics.checkNotNullParameter(r112, "ext");
        this.f548005a = r100;
        this.f548006b = r101;
        this.f548007c = r102;
        this.f548008d = null;
        this.f548009e = r103;
        this.f548010f = r104;
        this.f548011g = r105;
        this.f548012h = r106;
        this.f548013i = r110;
        this.f548014j = r112;
        return;
    L26:
        r112 = null;
        goto L27
    }
}
