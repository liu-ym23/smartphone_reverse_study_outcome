package com.bytedance.android.shopping.api.mall.common.homepage.card;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yj.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BigFontAdapter {
    public static final Lazy a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/BigFontAdapter$FontType;", "", "", "size", "I", "getSize", "()I", "", "scale", "F", "getScale", "()F", "Companion", "a", "MINI", "MEDIUM", "LARGE", "LARGER", "LARGEST", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FontType extends Enum<FontType> {
        public static final a Companion = null;
        public static final FontType LARGE = null;
        public static final FontType LARGER = null;
        public static final FontType LARGEST = null;
        public static final FontType MEDIUM = null;
        public static final FontType MINI = null;
        public static final /* synthetic */ FontType[] a = null;
        private final float scale;
        private final int size;

        public static final class a {
            public static int a() {
                IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
                if (r0 == null) goto L9;
                i r1 = r0.getIHybridHostAppInfo();
                if (r1 == null) goto L9;
                Float r2 = r1.getCurrentFontScale();
                if (r2 == null) goto L9;
                float r3 = r2.floatValue();
            L10:
                FontType r4 = FontType.MEDIUM;
                if (r3 < (r4.getScale() - 1.0E-4f)) goto L24;
                FontType r5 = FontType.LARGE;
                if (r3 < (r5.getScale() - 1.0E-4f)) goto L25;
                FontType r6 = FontType.LARGER;
                if (r3 < (r6.getScale() - 1.0E-4f)) goto L26;
                Lazy r7 = HybridAppInfoService.a;
                if (HybridAppInfoService.l() == false) goto L23;
                return r5.getSize();
            L23:
                return r6.getSize();
            L26:
                return r5.getSize();
            L25:
                return r4.getSize();
            L24:
                return FontType.MINI.getSize();
            L9:
                r3 = 1.0f;
                goto L10
            }

            public a() {
            }
        }

        static {
            FontType r1 = new FontType("MINI", 0, 1, 0.9f);
            MINI = r1;
            FontType r2 = new FontType("MEDIUM", 1, 0, 1.0f);
            MEDIUM = r2;
            FontType r3 = new FontType("LARGE", 2, 2, 1.15f);
            LARGE = r3;
            FontType r4 = new FontType("LARGER", 3, 3, 1.3f);
            LARGER = r4;
            FontType r5 = new FontType("LARGEST", 4, 4, 1.3f);
            LARGEST = r5;
            a = new FontType[]{r1, r2, r3, r4, r5};
            Companion = new a();
        }

        public static FontType valueOf(String r1) {
            return (FontType) r27.a.a(FontType.class, r1);
        }

        public static FontType[] values() {
            return (FontType[]) a.clone();
        }

        public final float getScale() {
            return this.scale;
        }

        public final int getSize() {
            return this.size;
        }

        public FontType(String r1, int r2, int r3, float r4) {
            super(r1, r2);
            this.size = r3;
            this.scale = r4;
        }
    }

    public BigFontAdapter() {
    }

    static {
        a = LazyKt.lazy(BigFontAdapter$bigFontPageName$2.INSTANCE);
    }

    public static FontType a() {
        FontType[] r0 = FontType.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        FontType r4 = r0[r3];
        int r5 = r4.getSize();
        IHybridHostService r6 = a.h();
        if (r6 == null) goto L13;
        i r7 = r6.getIHybridHostAppInfo();
        if (r7 == null) goto L13;
        Float r8 = r7.getCurrentFontScale();
        if (r8 == null) goto L13;
        if (r5 != ((int) r8.floatValue())) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L18;
        r3 = r3 + 1;
    L18:
        if (r4 == null) goto L20;
        return r4;
    L20:
        return FontType.MEDIUM;
    L13:
        r9 = false;
        goto L14
    L17:
        r4 = null;
        goto L18
    }

    public static boolean b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "pageName");
        List r0 = StringsKt.split$default((String) a.getValue(), new String[]{","}, false, 0, 6, null);
        if (r7.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if ((!r0.isEmpty()) == true) goto L10;
        return false;
    L10:
        if (r0.contains(r7) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public static boolean c(Map r1) {
        Intrinsics.checkNotNullParameter(r1, "config");
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L12;
        Object r2 = r1.get("big_font_enabled");
        if ((r2 instanceof Boolean) == true) goto L8;
        r2 = null;
    L8:
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L12;
        if (a() == FontType.MEDIUM) goto L12;
        return true;
    L12:
        return false;
    }

    public static void d(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        r2.setTextSize(0, r2.getTextSize() * a().getScale());
        r2.setMaxLines(1);
    }

    public static void e(View r3, int r4) {
        boolean r1 = true;
        if ((r4 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 4) != 0) goto L10;
        r1 = false;
    L10:
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        if (r0 == false) goto L13;
        r3.getLayoutParams().width = (int) (r3.getLayoutParams().width * a().getScale());
    L13:
        if (r1 == false) goto L16;
        r3.getLayoutParams().height = (int) (r3.getLayoutParams().height * a().getScale());
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L7
    }
}
