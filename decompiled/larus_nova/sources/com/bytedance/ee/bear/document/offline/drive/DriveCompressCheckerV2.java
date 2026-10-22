package com.bytedance.ee.bear.document.offline.drive;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import du5.b;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveCompressCheckerV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f220405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f220406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f220407c;

    public static final enum CoverSize extends Enum<CoverSize> {
        public static final CoverSize HIGH = null;
        public static final CoverSize LOW = null;
        public static final CoverSize MIDDLE = null;
        public static final CoverSize ORIGINAL = null;
        public static final CoverSize XHIGH = null;
        public static final CoverSize XXHIGH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoverSize[] f220408a = null;
        public final int size;

        static {
            CoverSize r100 = new CoverSize("LOW", 0, 360);
            LOW = r100;
            CoverSize r101 = new CoverSize("MIDDLE", 1, 480);
            MIDDLE = r101;
            CoverSize r102 = new CoverSize("HIGH", 2, 720);
            HIGH = r102;
            CoverSize r103 = new CoverSize("XHIGH", 3, 850);
            XHIGH = r103;
            CoverSize r104 = new CoverSize("XXHIGH", 4, 1280);
            XXHIGH = r104;
            CoverSize r105 = new CoverSize("ORIGINAL", 5, 1);
            ORIGINAL = r105;
            f220408a = new CoverSize[]{r100, r101, r102, r103, r104, r105};
        }

        public static CoverSize[] values() {
            return (CoverSize[]) f220408a.clone();
        }

        public static CoverSize valueOf(String r100) {
            return (CoverSize) a.a(CoverSize.class, r100);
        }

        public CoverSize(String r100, int r101, int r102) {
            super(r100, r101);
            this.size = r102;
        }
    }

    public DriveCompressCheckerV2(Context r100) {
        this.f220405a = ((Integer) c.a.f206237a.d("drive_rust_cover_size", 1280)).intValue();
        Resources r101 = r100.getResources();
        this.f220406b = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        this.f220407c = (n.v() - (n.d(26) * 2)) / 2;
    }

    public final Pair<Boolean, Integer> a(String r110) {
        tt5.a.b("DriveCompressCheckerV2", "Pic url: " + r110);
        Uri r100 = UriProtector.parse(r110);
        String r101 = UriProtector.getQueryParameter(r100, "useOrigin");
        if (r101 != null) goto L5;
    L8:
        String r102 = UriProtector.getQueryParameter(r100, "contentType");
        if (r102 != null) goto L11;
    L14:
        String r103 = UriProtector.getQueryParameter(r100, "width");
        String r104 = UriProtector.getQueryParameter(r100, "height");
        String r105 = UriProtector.getQueryParameter(r100, "scale");
        String r106 = UriProtector.getQueryParameter(r100, "useDisplayParams");
        tt5.a.b("DriveCompressCheckerV2", "width: " + r103 + "--height: " + r104 + "--scale: " + r105 + "--useDisplay: " + r106);
        if (TextUtils.isEmpty(r103) == false) goto L17;
    L61:
        tt5.a.k("DriveCompressCheckerV2", "The pic width or height is illegal and the url is " + b.g(r110));
        return new Pair(Boolean.TRUE, Integer.valueOf(this.f220405a));
    L17:
        if (TextUtils.isEmpty(r104) == true) goto L61;
        int r111 = CastIntegerProtector.parseInt(r103);     // Catch: NumberFormatException -> L58
        int r107 = CastIntegerProtector.parseInt(r104);     // Catch: NumberFormatException -> L58
        if (TextUtils.isEmpty(r106) == true) goto L21;
        int r108 = CastIntegerProtector.parseInt(r106);     // Catch: NumberFormatException -> L58
    L22:
        int r109 = Math.max(r111, r107);     // Catch: NumberFormatException -> L58
        if (r108 != 1) goto L25;
        r109 = (int) (r109 * this.f220406b);     // Catch: NumberFormatException -> L58
    L25:
        int r112 = this.f220405a;     // Catch: NumberFormatException -> L58
        if (r109 <= r112) goto L35;
        float r113 = (r112 * 1.0f) / r109;     // Catch: NumberFormatException -> L58
        if (r108 != 1) goto L30;
        float r114 = r111 * this.f220406b;     // Catch: NumberFormatException -> L58
    L32:
        if (((int) (r114 * r113)) >= this.f220407c) goto L35;
        tt5.a.h("DriveCompressCheckerV2", "Long pic shouldn't compress");     // Catch: NumberFormatException -> L58
        return new Pair(Boolean.FALSE, Integer.valueOf(this.f220405a));
    L30:
        r114 = r111;
    L35:
        Boolean r115 = Boolean.TRUE;     // Catch: NumberFormatException -> L58
        float r116 = CastFloatProtector.parseFloat(r105);     // Catch: NumberFormatException -> L58
        if (r116 != 0.0f) goto L38;
        r116 = 1.0f;
    L38:
        if (r108 != 1) goto L41;
        float r117 = this.f220406b;     // Catch: NumberFormatException -> L58
        r111 = (int) (r111 * r117);     // Catch: NumberFormatException -> L58
        float r118 = r107;
    L44:
        r107 = (int) (r118 * r117);     // Catch: NumberFormatException -> L58
    L45:
        int r119 = Math.max(r111, r107);     // Catch: NumberFormatException -> L58
        int r120 = CoverSize.XHIGH.size;     // Catch: NumberFormatException -> L58
        if (r119 <= r120) goto L48;
        r120 = CoverSize.XXHIGH.size;     // Catch: NumberFormatException -> L58
    L57:
        return new Pair(r115, Integer.valueOf(r120));
    L48:
        int r121 = CoverSize.HIGH.size;     // Catch: NumberFormatException -> L58
        if (r119 > r121) goto L57;
        r120 = CoverSize.MIDDLE.size;     // Catch: NumberFormatException -> L58
        if (r119 <= r120) goto L54;
    L53:
        r120 = r121;
        goto L57
    L54:
        r121 = CoverSize.LOW.size;     // Catch: NumberFormatException -> L58
        if (r119 <= r121) goto L53;
    L41:
        if (r116 == 1.0f) goto L45;
        r117 = this.f220406b;     // Catch: NumberFormatException -> L58
        r111 = (int) ((r111 * r116) * r117);     // Catch: NumberFormatException -> L58
        r118 = r107 * r116;     // Catch: NumberFormatException -> L58
        goto L44
    L21:
        r108 = 0;
    L58:
        e = move-exception;
        tt5.a.l("DriveCompressCheckerV2", "Failed to parse download pic params.", e);
        return new Pair(Boolean.TRUE, Integer.valueOf(this.f220405a));
    L11:
        if (r102.contains("gif") == false) goto L14;
        tt5.a.h("DriveCompressCheckerV2", "The pic is gif.");
        return new Pair(Boolean.FALSE, Integer.valueOf(this.f220405a));
    L5:
        if ("1".equals(r101) == false) goto L8;
        tt5.a.h("", "useOrigin equals 1.");
        return new Pair(Boolean.FALSE, Integer.valueOf(this.f220405a));
    }
}
