package obb;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f522646p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f522648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f522651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f522652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f522653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f522654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f522655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f522656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable f522657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IconShape f522658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final obb.a f522659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IconScene f522660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f522661o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f522662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f522663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f522664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f522665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f522666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f522667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f522668g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f522669h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Drawable f522670i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f522671j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public IconShape f522672k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public obb.a f522673l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconScene f522674m;

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "iconKey");
            this.f522672k = IconShape.SQUARE;
            this.f522674m = IconScene.UNKNOW;
            this.f522666e = Integer.valueOf(r100);
            this.f522667f = r101;
        }

        public a(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.f522672k = IconShape.SQUARE;
            this.f522674m = IconScene.UNKNOW;
            this.f522662a = r100;
            this.f522663b = Integer.valueOf(r101);
            this.f522665d = r102;
        }
    }

    public static final class b {
        public static a a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "iconKey");
            return new a(r100, r101);
        }
    }

    static {
    }

    public final String a() {
        return this.f522647a + '-' + this.f522648b + '-' + this.f522652f + '-' + this.f522653g;
    }

    public final Integer getType() {
        return this.f522648b;
    }

    public c(a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        String r100 = r110.f522662a;
        Integer r101 = r110.f522663b;
        String r102 = r110.f522664c;
        String r103 = r110.f522665d;
        Integer r104 = r110.f522666e;
        String r105 = r110.f522667f;
        Integer r106 = r110.f522668g;
        Integer r107 = r110.f522669h;
        Drawable r108 = r110.f522670i;
        Drawable r109 = r110.f522671j;
        IconShape r111 = r110.f522672k;
        obb.a r112 = r110.f522673l;
        IconScene r113 = r110.f522674m;
        Intrinsics.checkNotNullParameter(r111, "iconShape");
        Intrinsics.checkNotNullParameter(r113, "scene");
        this.f522647a = r100;
        this.f522648b = r101;
        this.f522649c = r102;
        UserSession r114 = null;
        this.f522650d = null;
        this.f522651e = r103;
        this.f522652f = r104;
        this.f522653g = r105;
        this.f522654h = r106;
        this.f522655i = r107;
        this.f522656j = r108;
        this.f522657k = r109;
        this.f522658l = r111;
        this.f522659m = r112;
        this.f522660n = r113;
        this.f522661o = null;
        int r115 = 0;
        String r116 = "";
        if (TextUtils.isEmpty(r103) == true) goto L7;
        sbb.c.f541290a.getClass();
        if (sbb.c.c(null, r103) == null) goto L7;
        obb.b r117 = sbb.c.c(null, r103);
    L28:
        if (r117 == null) goto L48;
        com.ss.android.lark.storage.a r118 = nbb.b.f518595a;
        String r119 = r117.f522638b;
        if (r119 == null) goto L33;
        r116 = r119;
    L33:
        if (r112 == null) goto L35;
        r114 = r112.f522636g;
    L35:
        obb.b r120 = nbb.b.a(r116, r114);
        if (r120 == null) goto L46;
        Integer r121 = r117.f522642f;
        if (r121 == null) goto L40;
        int r122 = r121.intValue();
    L41:
        Integer r123 = r120.f522642f;
        if (r123 == null) goto L44;
        r115 = r123.intValue();
    L44:
        if (r122 >= r115) goto L46;
        r117 = r120;
        goto L46
    L40:
        r122 = 0;
    L46:
        this.f522647a = r117.f522638b;
        this.f522648b = Integer.valueOf(r117.getType());
        this.f522652f = r117.f522640d;
        this.f522653g = r117.f522641e;
        this.f522650d = r117.f522639c;
        return;
    L48:
        return;
    L7:
        if (r102 == null) goto L20;
        boolean r124 = true;
        if (r102.length() <= 0) goto L11;
        boolean r125 = true;
    L12:
        if (r125 == true) goto L15;
        r124 = false;
    L15:
        if (r124 == false) goto L20;
        sbb.c.f541290a.getClass();
        if (sbb.c.e(r102) == null) goto L20;
        r117 = sbb.c.e(r102);
        goto L28
    L11:
        r125 = false;
    L20:
        if (TextUtils.isEmpty(this.f522647a) == true) goto L27;
        Integer r126 = this.f522648b;
        if (r126 == null) goto L27;
        sbb.c r127 = sbb.c.f541290a;
        String r128 = this.f522647a;
        if (r128 != null) goto L26;
        r128 = "";
    L26:
        int r129 = r126.intValue();
        r127.getClass();
        r117 = sbb.c.a(r128, r129);
    L27:
        r117 = null;
        goto L28
    }
}
