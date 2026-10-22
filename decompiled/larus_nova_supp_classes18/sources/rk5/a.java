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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final OfficeThumbnailUrlRepository a;
    public final Function0<Boolean> b;
    public final Function4<String, Integer, Integer, String, Unit> c;
    public final Map<d, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> d;
    public final Map<c, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> e;
    public final Set<d> f;
    public final Map<d, OfficeThumbnailUrlRepository.b> g;
    public final LinkedHashMap<d, b> h;
    public final rk5.b i;
    public OfficeThumbnailUrlRepository.b j;
    public int k;
    public final Handler l;

    /* JADX INFO: renamed from: rk5.a$a, reason: collision with other inner class name */
    public static final class C0301a {
    }

    public static final class b {
        public final d a;
        public final Document b;
        public final List<Document> c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "PendingThumbnailRequest(key=" + this.a + ", document=" + this.b + ", documents=" + this.c + ", width=" + this.d + ", height=" + this.e + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(d r2, Document r3, List<? extends Document> r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "document");
            Intrinsics.checkNotNullParameter(r4, "documents");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final String c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d;
        }

        public final String toString() {
            return "ThumbnailIdentity(token=" + this.a + ", type=" + this.b + ", url=" + this.c + ", nodeType=" + this.d + ')';
        }

        public final int getType() {
            return this.b;
        }

        public c(String r2, int r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d {
        public final String a;
        public final int b;
        public final String c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "ThumbnailKey(token=" + this.a + ", type=" + this.b + ", url=" + this.c + ", nodeType=" + this.d + ", width=" + this.e + ", height=" + this.f + ')';
        }

        public final int getType() {
            return this.b;
        }

        public d(String r2, int r3, String r4, int r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    static {
    }

    public static c b(Document r5) {
        String r1 = r5.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r3 = r5.getType();
        String r4 = r5.p;
        if (r4 == null) goto L10;
        r2 = r4;
    L10:
        return new c(r1, r3, r2, r5.M1);
    }

    public static boolean d(Document r3) {
        if (r3.getType() != e.f.b) goto L6;
        return false;
    L6:
        if (r3.p1 == true) goto L8;
        return false;
    L8:
        if (r3.b2 == false) goto L11;
        return false;
    L11:
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r3) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r3.q) == true) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(r3.V0) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public a(Function0 r3, Function4 r4) {
        OfficeThumbnailUrlRepository r0 = new OfficeThumbnailUrlRepository();
        Intrinsics.checkNotNullParameter(r0, "repository");
        Intrinsics.checkNotNullParameter(r3, "canApplyResult");
        Intrinsics.checkNotNullParameter(r4, "onThumbnailReady");
        this.a = r0;
        this.b = r3;
        this.c = r4;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new rk5.b(this);
        this.l = new Handler(Looper.getMainLooper());
    }

    public static void e(Document r2, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r3) {
        if (r3.getEncrypted() == false) goto L5;
        r2.q = "";
        r2.V0 = r3.getUrl();
        r2.b1 = r3.getSecret();
        r2.g1 = r3.getNonce();
        r2.h1 = r3.getEncryptType();
        return;
    L5:
        r2.q = r3.getUrl();
        r2.V0 = "";
        r2.b1 = null;
        r2.g1 = null;
        r2.h1 = 0;
    }

    public final void a(Document r8, List<? extends Document> r9, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r10) {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<? extends Document> r0 = r9.iterator();
        int r2 = 0;
    L6:
        String r4 = "";
        if (r0.hasNext() == false) goto L27;
        Document r3 = r0.next();
        if (Intrinsics.areEqual(r3.d, r8.d) == true) goto L11;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L28;
        r2 = r2 + 1;
    L28:
        if (r2 >= 0) goto L30;
        return;
    L30:
        Document r11 = (Document) ListProtector.get(r9, r2);
        e(r11, r10);
        Function4<String, Integer, Integer, String, Unit> r12 = this.c;
        String r13 = r11.d;
        if (r13 != null) goto L33;
        r13 = "";
    L33:
        Integer r1 = Integer.valueOf(r11.getType());
        Integer r6 = Integer.valueOf(r11.M1);
        String r14 = r11.p;
        if (r14 == null) goto L37;
        r4 = r14;
    L37:
        r12.invoke(r13, r1, r6, r4);
        return;
    L11:
        if (r3.getType() != r8.getType()) goto L23;
        if (r3.M1 != r8.M1) goto L23;
        String r7 = r3.p;
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        String r15 = r8.p;
        if (r15 != null) goto L21;
        r15 = "";
    L21:
        if (Intrinsics.areEqual(r7, r15) == false) goto L23;
        r5 = true;
        goto L24
    L27:
        r2 = -1;
        goto L28
    }

    public final void c(Document r22, List<? extends Document> r23, ImageView r24) {
        Intrinsics.checkNotNullParameter(r22, "document");
        Intrinsics.checkNotNullParameter(r23, "documents");
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L6;
        return;
    L6:
        if (d(r22) == true) goto L8;
        return;
    L8:
        String r0 = r22.d;
        String r10 = "";
        if (r0 != null) goto L11;
        String r6 = "";
    L13:
        if (StringsKt.isBlank(r6) == false) goto L15;
        return;
    L15:
        boolean r18 = false;
        if (r24 == null) goto L18;
        int r4 = r24.getWidth();
    L19:
        if (r24 == null) goto L21;
        int r3 = r24.getHeight();
    L22:
        int r13 = r22.getType();
        String r1 = r22.p;
        if (r1 != null) goto L25;
        String r14 = "";
    L26:
        int r15 = r22.M1;
        Integer r2 = Integer.valueOf(r4);
        if (r2.intValue() <= 0) goto L29;
        boolean r5 = true;
    L30:
        String r19 = null;
        if (r5 == true) goto L35;
        r2 = null;
    L35:
        if (r2 == null) goto L37;
        int r16 = r2.intValue();
    L38:
        Integer r7 = Integer.valueOf(r3);
        if (r7.intValue() <= 0) goto L41;
        boolean r11 = true;
    L42:
        if (r11 == true) goto L45;
        r7 = null;
    L45:
        if (r7 == null) goto L47;
        int r17 = r7.intValue();
    L48:
        d r8 = new d(r6, r13, r14, r15, r16, r17);
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r9 = (OfficeThumbnailUrlRepository.ThumbnailUrlInfo) ((LinkedHashMap) this.d).get(r8);
        if (r9 == null) goto L53;
        a(r22, r23, r9);
        return;
    L53:
        if (this.f.add(r8) == true) goto L55;
        return;
    L55:
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r22, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r22) == false) goto L59;
        this.h.put(r8, new b(r8, r22, r23, r8.e, r8.f));
        this.l.removeCallbacks(this.i);
        this.l.postDelayed(this.i, 32);
        return;
    L59:
        int r12 = this.k;
        OfficeThumbnailUrlRepository r110 = this.a;
        int r111 = r3;
        int r20 = r4;
        final rk5.d r112 = new rk5.d(this, r12, r8, r22, r23, r6);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r22, "document");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r22, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r22) == false) goto L63;
        NetService.f r21 = new NetService.f("/space/api/box/file/cdn_url/");
        ((NetService.e) r21).c = 1;
        ((NetService.e) r21).j = OfficeThumbnailUrlRepository.c(CollectionsKt.listOf(new OfficeThumbnailUrlRepository.i(r22, 360, 360))).toString();
        Flowable r25 = r110.a.Vc(new OfficeThumbnailUrlRepository.f(OfficeThumbnailUrlRepository.c.b(r22))).a(r21).map(com.bytedance.ee.bear.list.thumbnail.c.a).onErrorReturn(new i(r110, r22, r20, r111));
        Intrinsics.checkNotNull(r25);
    L91:
        this.g.put(r8, new OfficeThumbnailUrlRepository.d(r25.subscribe(new g(r112), new h(r112))));
        return;
    L63:
        if (r22.getType() == e.l.b) goto L65;
        boolean r26 = false;
    L72:
        if (r26 == false) goto L74;
        r25 = Flowable.just(r110.b(r22, r20, r111));
        Intrinsics.checkNotNull(r25);
        goto L91
    L74:
        NetService.f r27 = new NetService.f("/api/file/get_thumbnail_url");
        r27.b("obj_type", String.valueOf(r22.getType()));
        String r28 = r22.d;
        if (r28 == null) goto L78;
        r10 = r28;
    L78:
        r27.b(ResourceData.KEY_OBJ_TOKEN, r10);
        String r29 = r22.p;
        if (r29 != null) goto L81;
    L84:
        boolean r30 = true;
    L85:
        if (r30 == true) goto L87;
        r27.b(ResourceData.KEY_URL, r22.p);
    L87:
        r27.b("preview_scene", ThumbGlideUrl.SOURCE_SPACE_LIST);
        r27.b("preview_party", "ccm_space");
        if (r22.M1 != 1) goto L90;
        r18 = true;
    L90:
        r27.b("is_shortcut", String.valueOf(r18));
        r25 = r110.a.Vc(new OfficeThumbnailUrlRepository.j()).a(r27).map(f.a);
        goto L91
    L81:
        if (StringsKt.isBlank(r29) == true) goto L84;
        r30 = false;
        goto L85
    L65:
        String r31 = r22.F;
        if (r31 == null) goto L68;
        r19 = r31.toLowerCase(Locale.ROOT);
    L68:
        if (r19 != null) goto L70;
        String r32 = "";
    L71:
        r26 = !OfficeThumbnailUrlRepository.c.contains(r32);
        goto L72
    L70:
        r32 = r19;
        goto L71
    L47:
        r17 = 240;
        goto L48
    L41:
        r11 = false;
        goto L42
    L37:
        r16 = 240;
        goto L38
    L29:
        r5 = false;
        goto L30
    L25:
        r14 = r1;
        goto L26
    L21:
        r3 = 0;
        goto L22
    L18:
        r4 = 0;
        goto L19
    L11:
        r6 = r0;
        goto L13
    }
}
