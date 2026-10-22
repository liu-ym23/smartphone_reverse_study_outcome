package rk5;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.bytedance.ee.bear.list.thumbnail.f;
import com.bytedance.ee.bear.list.thumbnail.g;
import com.bytedance.ee.bear.list.thumbnail.h;
import com.bytedance.ee.bear.list.thumbnail.i;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeThumbnailUrlRepository f538256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f538257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<String, Integer, Integer, String, Unit> f538258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<d, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> f538259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<c, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> f538260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<d> f538261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<d, OfficeThumbnailUrlRepository.b> f538262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap<d, b> f538263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final rk5.b f538264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OfficeThumbnailUrlRepository.b f538265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f538266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f538267l;

    /* JADX INFO: renamed from: rk5.a$a, reason: collision with other inner class name */
    public static final class C7496a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f538268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Document f538269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Document> f538270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f538271d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f538272e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f538268a, r101.f538268a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f538269b, r101.f538269b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f538270c, r101.f538270c) == true) goto L18;
            return false;
        L18:
            if (this.f538271d == r101.f538271d) goto L21;
            return false;
        L21:
            if (this.f538272e == r101.f538272e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f538268a.hashCode() * 31) + this.f538269b.hashCode()) * 31) + this.f538270c.hashCode()) * 31) + this.f538271d) * 31) + this.f538272e;
        }

        public final String toString() {
            return "PendingThumbnailRequest(key=" + this.f538268a + ", document=" + this.f538269b + ", documents=" + this.f538270c + ", width=" + this.f538271d + ", height=" + this.f538272e + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(d r100, Document r101, List<? extends Document> r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "document");
            Intrinsics.checkNotNullParameter(r102, "documents");
            this.f538268a = r100;
            this.f538269b = r101;
            this.f538270c = r102;
            this.f538271d = r103;
            this.f538272e = r104;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f538273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f538274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f538275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f538276d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f538273a, r101.f538273a) == true) goto L12;
            return false;
        L12:
            if (this.f538274b == r101.f538274b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f538275c, r101.f538275c) == true) goto L18;
            return false;
        L18:
            if (this.f538276d == r101.f538276d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f538273a.hashCode() * 31) + this.f538274b) * 31) + this.f538275c.hashCode()) * 31) + this.f538276d;
        }

        public final String toString() {
            return "ThumbnailIdentity(token=" + this.f538273a + ", type=" + this.f538274b + ", url=" + this.f538275c + ", nodeType=" + this.f538276d + ')';
        }

        public final int getType() {
            return this.f538274b;
        }

        public c(String r100, int r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r102, "url");
            this.f538273a = r100;
            this.f538274b = r101;
            this.f538275c = r102;
            this.f538276d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f538277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f538278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f538279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f538280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f538281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f538282f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f538277a, r101.f538277a) == true) goto L12;
            return false;
        L12:
            if (this.f538278b == r101.f538278b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f538279c, r101.f538279c) == true) goto L18;
            return false;
        L18:
            if (this.f538280d == r101.f538280d) goto L21;
            return false;
        L21:
            if (this.f538281e == r101.f538281e) goto L24;
            return false;
        L24:
            if (this.f538282f == r101.f538282f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f538277a.hashCode() * 31) + this.f538278b) * 31) + this.f538279c.hashCode()) * 31) + this.f538280d) * 31) + this.f538281e) * 31) + this.f538282f;
        }

        public final String toString() {
            return "ThumbnailKey(token=" + this.f538277a + ", type=" + this.f538278b + ", url=" + this.f538279c + ", nodeType=" + this.f538280d + ", width=" + this.f538281e + ", height=" + this.f538282f + ')';
        }

        public final int getType() {
            return this.f538278b;
        }

        public d(String r100, int r101, String r102, int r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r102, "url");
            this.f538277a = r100;
            this.f538278b = r101;
            this.f538279c = r102;
            this.f538280d = r103;
            this.f538281e = r104;
            this.f538282f = r105;
        }
    }

    static {
    }

    public static c b(Document r100) {
        String r101 = r100.f227873d;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        int r103 = r100.getType();
        String r104 = r100.f227891p;
        if (r104 == null) goto L10;
        r102 = r104;
    L10:
        return new c(r101, r103, r102, r100.M1);
    }

    public static boolean d(Document r100) {
        if (r100.getType() != e.f541295f.f541317b) goto L6;
        return false;
    L6:
        if (r100.f227893p1 == true) goto L8;
        return false;
    L8:
        if (r100.f227871b2 == false) goto L11;
        return false;
    L11:
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r100) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r100.f227895q) == true) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(r100.V0) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public a(Function0 r100, Function4 r101) {
        OfficeThumbnailUrlRepository r102 = new OfficeThumbnailUrlRepository();
        Intrinsics.checkNotNullParameter(r102, "repository");
        Intrinsics.checkNotNullParameter(r100, "canApplyResult");
        Intrinsics.checkNotNullParameter(r101, "onThumbnailReady");
        this.f538256a = r102;
        this.f538257b = r100;
        this.f538258c = r101;
        this.f538259d = new LinkedHashMap();
        this.f538260e = new LinkedHashMap();
        this.f538261f = new LinkedHashSet();
        this.f538262g = new LinkedHashMap();
        this.f538263h = new LinkedHashMap();
        this.f538264i = new rk5.b(this);
        this.f538267l = new Handler(Looper.getMainLooper());
    }

    public static void e(Document r100, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r101) {
        if (r101.getEncrypted() == false) goto L5;
        r100.f227895q = "";
        r100.V0 = r101.getUrl();
        r100.f227870b1 = r101.getSecret();
        r100.f227877g1 = r101.getNonce();
        r100.f227880h1 = r101.getEncryptType();
        return;
    L5:
        r100.f227895q = r101.getUrl();
        r100.V0 = "";
        r100.f227870b1 = null;
        r100.f227877g1 = null;
        r100.f227880h1 = 0;
    }

    public final void a(Document r100, List<? extends Document> r101, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r110) {
        if (this.f538257b.invoke().booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<? extends Document> r102 = r101.iterator();
        int r103 = 0;
    L6:
        String r104 = "";
        if (r102.hasNext() == false) goto L27;
        Document r105 = r102.next();
        if (Intrinsics.areEqual(r105.f227873d, r100.f227873d) == true) goto L11;
    L23:
        boolean r106 = false;
    L24:
        if (r106 == true) goto L28;
        r103 = r103 + 1;
    L28:
        if (r103 >= 0) goto L30;
        return;
    L30:
        Document r107 = (Document) ListProtector.get(r101, r103);
        e(r107, r110);
        Function4<String, Integer, Integer, String, Unit> r108 = this.f538258c;
        String r111 = r107.f227873d;
        if (r111 != null) goto L33;
        r111 = "";
    L33:
        Integer r109 = Integer.valueOf(r107.getType());
        Integer r112 = Integer.valueOf(r107.M1);
        String r113 = r107.f227891p;
        if (r113 == null) goto L37;
        r104 = r113;
    L37:
        r108.invoke(r111, r109, r112, r104);
        return;
    L11:
        if (r105.getType() != r100.getType()) goto L23;
        if (r105.M1 != r100.M1) goto L23;
        String r114 = r105.f227891p;
        if (r114 != null) goto L17;
        r114 = "";
    L17:
        String r115 = r100.f227891p;
        if (r115 != null) goto L21;
        r115 = "";
    L21:
        if (Intrinsics.areEqual(r114, r115) == false) goto L23;
        r106 = true;
        goto L24
    L27:
        r103 = -1;
        goto L28
    }

    public final void c(Document r210, List<? extends Document> r211, ImageView r212) {
        Intrinsics.checkNotNullParameter(r210, "document");
        Intrinsics.checkNotNullParameter(r211, "documents");
        if (this.f538257b.invoke().booleanValue() == true) goto L6;
        return;
    L6:
        if (d(r210) == true) goto L8;
        return;
    L8:
        String r100 = r210.f227873d;
        String r110 = "";
        if (r100 != null) goto L11;
        String r101 = "";
    L13:
        if (StringsKt.isBlank(r101) == false) goto L15;
        return;
    L15:
        boolean r111 = false;
        if (r212 == null) goto L18;
        int r102 = r212.getWidth();
    L19:
        if (r212 == null) goto L21;
        int r103 = r212.getHeight();
    L22:
        int r112 = r210.getType();
        String r104 = r210.f227891p;
        if (r104 != null) goto L25;
        String r113 = "";
    L26:
        int r114 = r210.M1;
        Integer r105 = Integer.valueOf(r102);
        if (r105.intValue() <= 0) goto L29;
        boolean r106 = true;
    L30:
        String r115 = null;
        if (r106 == true) goto L35;
        r105 = null;
    L35:
        if (r105 == null) goto L37;
        int r116 = r105.intValue();
    L38:
        Integer r107 = Integer.valueOf(r103);
        if (r107.intValue() <= 0) goto L41;
        boolean r117 = true;
    L42:
        if (r117 == true) goto L45;
        r107 = null;
    L45:
        if (r107 == null) goto L47;
        int r118 = r107.intValue();
    L48:
        d r108 = new d(r101, r112, r113, r114, r116, r118);
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r109 = (OfficeThumbnailUrlRepository.ThumbnailUrlInfo) ((LinkedHashMap) this.f538259d).get(r108);
        if (r109 == null) goto L53;
        a(r210, r211, r109);
        return;
    L53:
        if (this.f538261f.add(r108) == true) goto L55;
        return;
    L55:
        this.f538256a.getClass();
        Intrinsics.checkNotNullParameter(r210, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r210) == false) goto L59;
        this.f538263h.put(r108, new b(r108, r210, r211, r108.f538281e, r108.f538282f));
        this.f538267l.removeCallbacks(this.f538264i);
        this.f538267l.postDelayed(this.f538264i, 32);
        return;
    L59:
        int r119 = this.f538266k;
        OfficeThumbnailUrlRepository r120 = this.f538256a;
        int r121 = r103;
        int r213 = r102;
        final rk5.d r122 = new rk5.d(this, r119, r108, r210, r211, r101);
        r120.getClass();
        Intrinsics.checkNotNullParameter(r210, "document");
        Intrinsics.checkNotNullParameter(r122, "callback");
        Intrinsics.checkNotNullParameter(r210, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r210) == false) goto L63;
        NetService.f r123 = new NetService.f("/space/api/box/file/cdn_url/");
        r123.f216906c = 1;
        r123.f216913j = OfficeThumbnailUrlRepository.c(CollectionsKt.listOf(new OfficeThumbnailUrlRepository.i(r210, 360, 360))).toString();
        Flowable r124 = r120.f229773a.Vc(new OfficeThumbnailUrlRepository.f(OfficeThumbnailUrlRepository.c.b(r210))).a(r123).map(com.bytedance.ee.bear.list.thumbnail.c.f229789a).onErrorReturn(new i(r120, r210, r213, r121));
        Intrinsics.checkNotNull(r124);
    L91:
        this.f538262g.put(r108, new OfficeThumbnailUrlRepository.d(r124.subscribe(new g(r122), new h(r122))));
        return;
    L63:
        if (r210.getType() == e.f541301l.f541317b) goto L65;
        boolean r125 = false;
    L72:
        if (r125 == false) goto L74;
        r124 = Flowable.just(r120.b(r210, r213, r121));
        Intrinsics.checkNotNull(r124);
        goto L91
    L74:
        NetService.f r126 = new NetService.f("/api/file/get_thumbnail_url");
        r126.b("obj_type", String.valueOf(r210.getType()));
        String r127 = r210.f227873d;
        if (r127 == null) goto L78;
        r110 = r127;
    L78:
        r126.b("obj_token", r110);
        String r128 = r210.f227891p;
        if (r128 != null) goto L81;
    L84:
        boolean r129 = true;
    L85:
        if (r129 == true) goto L87;
        r126.b("url", r210.f227891p);
    L87:
        r126.b("preview_scene", ThumbGlideUrl.SOURCE_SPACE_LIST);
        r126.b("preview_party", "ccm_space");
        if (r210.M1 != 1) goto L90;
        r111 = true;
    L90:
        r126.b("is_shortcut", String.valueOf(r111));
        r124 = r120.f229773a.Vc(new OfficeThumbnailUrlRepository.j()).a(r126).map(f.f229794a);
        goto L91
    L81:
        if (StringsKt.isBlank(r128) == true) goto L84;
        r129 = false;
        goto L85
    L65:
        String r130 = r210.F;
        if (r130 == null) goto L68;
        r115 = r130.toLowerCase(Locale.ROOT);
    L68:
        if (r115 != null) goto L70;
        String r131 = "";
    L71:
        r125 = !OfficeThumbnailUrlRepository.f229772c.contains(r131);
        goto L72
    L70:
        r131 = r115;
        goto L71
    L47:
        r118 = 240;
        goto L48
    L41:
        r117 = false;
        goto L42
    L37:
        r116 = 240;
        goto L38
    L29:
        r106 = false;
        goto L30
    L25:
        r113 = r104;
        goto L26
    L21:
        r103 = 0;
        goto L22
    L18:
        r102 = 0;
        goto L19
    L11:
        r101 = r100;
        goto L13
    }
}
