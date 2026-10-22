package cx2;

import android.graphics.Typeface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.textra.PlatformFontCaps;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f465679a = null;

    public static final class a {
        public static C5600b b(String r110) {
            Intrinsics.checkNotNullParameter(r110, "fontStyle");
            C5600b r100 = new C5600b();
            List r111 = StringsKt.split$default(r110, new String[]{" "}, false, 0, 6, null);
            int r101 = r111.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L31;
            if (StringsKt.contains$default((CharSequence) ListProtector.get(r111, r102), GXTemplateKey.GAIAX_PX, false, 2, null) == false) goto L8;
            r100.f465683d = Float.valueOf(CastFloatProtector.parseFloat(StringsKt.replace$default((String) ListProtector.get(r111, r102), GXTemplateKey.GAIAX_PX, "", false, 4, null)));
        L30:
            r102 = r102 + 1;
            goto L3
        L8:
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "small-caps") == true) goto L30;
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "italic") == false) goto L13;
        L29:
            String r103 = (String) ListProtector.get(r111, r102);
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f465680a = r103;
            goto L30
        L13:
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "normal") == true) goto L29;
            if (r100.f465682c == null) goto L19;
            String r104 = (String) ListProtector.get(r111, r102);
            r100.f465682c = b.f465679a.get(r104);
            goto L30
        L19:
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "serif") == false) goto L21;
        L28:
            String r105 = (String) ListProtector.get(r111, r102);
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r100.f465681b = r105;
            goto L30
        L21:
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), PlatformFontCaps.DEFAULT_FAMILY_NAME) == true) goto L28;
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "cursive") == true) goto L28;
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "monospace") == true) goto L28;
            if (Intrinsics.areEqual(ListProtector.get(r111, r102), "fantasy") == false) goto L30;
        L31:
            return r100;
        }

        public static Typeface a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "fontName");
            Intrinsics.checkNotNullParameter(r101, "fontStyle");
            boolean r103 = Intrinsics.areEqual(r101, "italic");
            if (r102 <= 500) goto L6;
            if (r103 == false) goto L6;
            int r104 = 3;
        L12:
            switch(r100.hashCode()) {
                case -1536685117: goto L31;
                case -1431958525: goto L27;
                case -1081737434: goto L23;
                case 109326717: goto L19;
                case 1126973893: goto L15;
                default: goto L35;
            };
        L15:
            if (r100.equals("cursive") == false) goto L35;
            return Typeface.create(Typeface.SANS_SERIF, r104);
        L19:
            if (r100.equals("serif") == false) goto L35;
            return Typeface.create(Typeface.SERIF, r104);
        L23:
            if (r100.equals("fantasy") == false) goto L35;
            return Typeface.create(Typeface.SANS_SERIF, r104);
        L27:
            if (r100.equals("monospace") == false) goto L35;
            return Typeface.create(Typeface.MONOSPACE, r104);
        L31:
            if (r100.equals(PlatformFontCaps.DEFAULT_FAMILY_NAME) == false) goto L35;
            return Typeface.create(Typeface.SANS_SERIF, r104);
        L35:
            return Typeface.create(Typeface.SERIF, r104);
        L6:
            if (r102 <= 500) goto L8;
            r104 = 1;
            goto L12
        L8:
            if (r103 == false) goto L10;
            r104 = 2;
            goto L12
        L10:
            r104 = 0;
            goto L12
        }
    }

    /* JADX INFO: renamed from: cx2.b$b, reason: collision with other inner class name */
    public static final class C5600b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f465680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f465681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f465682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Float f465683d;

        public C5600b() {
            this.f465680a = "normal";
            this.f465681b = "serif";
        }
    }

    static {
        HashMap<String, Integer> r100 = new HashMap(13);
        f465679a = r100;
        r100.put("normal", 400);
        r100.put(CommodityText.BOLD, 700);
        r100.put("bolder", 1);
        r100.put("lighter", -1);
        r100.put("100", 100);
        r100.put("200", 200);
        r100.put("300", 300);
        r100.put("400", 400);
        r100.put("500", 500);
        r100.put("600", 600);
        r100.put("700", 700);
        r100.put("800", 800);
        r100.put("900", 900);
    }
}
