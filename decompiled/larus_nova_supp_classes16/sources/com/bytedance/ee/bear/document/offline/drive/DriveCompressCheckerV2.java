package com.bytedance.ee.bear.document.offline.drive;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import du5.b;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveCompressCheckerV2 {
    public final int a;
    public final float b;
    public final int c;

    public static final enum CoverSize extends Enum<CoverSize> {
        public static final CoverSize HIGH = null;
        public static final CoverSize LOW = null;
        public static final CoverSize MIDDLE = null;
        public static final CoverSize ORIGINAL = null;
        public static final CoverSize XHIGH = null;
        public static final CoverSize XXHIGH = null;
        public static final /* synthetic */ CoverSize[] a = null;
        public final int size;

        static {
            CoverSize r0 = new CoverSize("LOW", 0, 360);
            LOW = r0;
            CoverSize r1 = new CoverSize("MIDDLE", 1, 480);
            MIDDLE = r1;
            CoverSize r2 = new CoverSize("HIGH", 2, 720);
            HIGH = r2;
            CoverSize r4 = new CoverSize("XHIGH", 3, 850);
            XHIGH = r4;
            CoverSize r6 = new CoverSize("XXHIGH", 4, 1280);
            XXHIGH = r6;
            CoverSize r8 = new CoverSize("ORIGINAL", 5, 1);
            ORIGINAL = r8;
            a = new CoverSize[]{r0, r1, r2, r4, r6, r8};
        }

        public static CoverSize[] values() {
            return (CoverSize[]) a.clone();
        }

        public static CoverSize valueOf(String r1) {
            return (CoverSize) a.a(CoverSize.class, r1);
        }

        public CoverSize(String r1, int r2, int r3) {
            super(r1, r2);
            this.size = r3;
        }
    }

    public DriveCompressCheckerV2(Context r4) {
        this.a = ((Integer) c.a.a.d("drive_rust_cover_size", 1280)).intValue();
        Resources r5 = r4.getResources();
        this.b = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        this.c = (n.v() - (n.d(26) * 2)) / 2;
    }

    public final Pair<Boolean, Integer> a(String r10) {
        tt5.a.b("DriveCompressCheckerV2", "Pic url: " + r10);
        Uri r0 = UriProtector.parse(r10);
        String r2 = UriProtector.getQueryParameter(r0, "useOrigin");
        if (r2 != null) goto L5;
    L8:
        String r3 = UriProtector.getQueryParameter(r0, "contentType");
        if (r3 != null) goto L11;
    L14:
        String r4 = UriProtector.getQueryParameter(r0, "width");
        String r5 = UriProtector.getQueryParameter(r0, "height");
        String r6 = UriProtector.getQueryParameter(r0, "scale");
        String r1 = UriProtector.getQueryParameter(r0, "useDisplayParams");
        tt5.a.b("DriveCompressCheckerV2", "width: " + r4 + "--height: " + r5 + "--scale: " + r6 + "--useDisplay: " + r1);
        if (TextUtils.isEmpty(r4) == false) goto L17;
    L61:
        tt5.a.k("DriveCompressCheckerV2", "The pic width or height is illegal and the url is " + b.g(r10));
        return new Pair(Boolean.TRUE, Integer.valueOf(this.a));
    L17:
        if (TextUtils.isEmpty(r5) == true) goto L61;
        int r11 = CastIntegerProtector.parseInt(r4);     // Catch: NumberFormatException -> L58
        int r7 = CastIntegerProtector.parseInt(r5);     // Catch: NumberFormatException -> L58
        if (TextUtils.isEmpty(r1) == true) goto L21;
        int r8 = CastIntegerProtector.parseInt(r1);     // Catch: NumberFormatException -> L58
    L22:
        int r9 = Math.max(r11, r7);     // Catch: NumberFormatException -> L58
        if (r8 != 1) goto L25;
        r9 = (int) (r9 * this.b);     // Catch: NumberFormatException -> L58
    L25:
        int r12 = this.a;     // Catch: NumberFormatException -> L58
        if (r9 <= r12) goto L35;
        float r13 = (r12 * 1.0f) / r9;     // Catch: NumberFormatException -> L58
        if (r8 != 1) goto L30;
        float r14 = r11 * this.b;     // Catch: NumberFormatException -> L58
    L32:
        if (((int) (r14 * r13)) >= this.c) goto L35;
        tt5.a.h("DriveCompressCheckerV2", "Long pic shouldn't compress");     // Catch: NumberFormatException -> L58
        return new Pair(Boolean.FALSE, Integer.valueOf(this.a));
    L30:
        r14 = r11;
    L35:
        Boolean r16 = Boolean.TRUE;     // Catch: NumberFormatException -> L58
        float r17 = CastFloatProtector.parseFloat(r6);     // Catch: NumberFormatException -> L58
        if (r17 != 0.0f) goto L38;
        r17 = 1.0f;
    L38:
        if (r8 != 1) goto L41;
        float r18 = this.b;     // Catch: NumberFormatException -> L58
        r11 = (int) (r11 * r18);     // Catch: NumberFormatException -> L58
        float r19 = r7;
    L44:
        r7 = (int) (r19 * r18);     // Catch: NumberFormatException -> L58
    L45:
        int r110 = Math.max(r11, r7);     // Catch: NumberFormatException -> L58
        int r20 = CoverSize.XHIGH.size;     // Catch: NumberFormatException -> L58
        if (r110 <= r20) goto L48;
        r20 = CoverSize.XXHIGH.size;     // Catch: NumberFormatException -> L58
    L57:
        return new Pair(r16, Integer.valueOf(r20));
    L48:
        int r21 = CoverSize.HIGH.size;     // Catch: NumberFormatException -> L58
        if (r110 > r21) goto L57;
        r20 = CoverSize.MIDDLE.size;     // Catch: NumberFormatException -> L58
        if (r110 <= r20) goto L54;
    L53:
        r20 = r21;
        goto L57
    L54:
        r21 = CoverSize.LOW.size;     // Catch: NumberFormatException -> L58
        if (r110 <= r21) goto L53;
    L41:
        if (r17 == 1.0f) goto L45;
        r18 = this.b;     // Catch: NumberFormatException -> L58
        r11 = (int) ((r11 * r17) * r18);     // Catch: NumberFormatException -> L58
        r19 = r7 * r17;     // Catch: NumberFormatException -> L58
        goto L44
    L21:
        r8 = 0;
    L58:
        e = move-exception;
        tt5.a.l("DriveCompressCheckerV2", "Failed to parse download pic params.", e);
        return new Pair(Boolean.TRUE, Integer.valueOf(this.a));
    L11:
        if (r3.contains("gif") == false) goto L14;
        tt5.a.h("DriveCompressCheckerV2", "The pic is gif.");
        return new Pair(Boolean.FALSE, Integer.valueOf(this.a));
    L5:
        if (DiagramData$RESULT.SUCCESS.equals(r2) == false) goto L8;
        tt5.a.h("", "useOrigin equals 1.");
        return new Pair(Boolean.FALSE, Integer.valueOf(this.a));
    }
}
