package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class UsageCardTemplateRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f387152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, Vote, Unit> f387153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, String, Unit> f387154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, String, Unit> f387155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f387156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<z4.a, Unit> f387157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<View, Unit> f387158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<View> f387159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<String, Integer, Unit> f387160i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/UsageCardTemplateRenderer$TemplateTagPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "HEADER", "FOOT", "FEEDBACK", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TemplateTagPlacement extends Enum<TemplateTagPlacement> {
        public static final TemplateTagPlacement FEEDBACK = null;
        public static final TemplateTagPlacement FOOT = null;
        public static final TemplateTagPlacement HEADER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TemplateTagPlacement[] f387161a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f387162b = null;

        public static EnumEntries<TemplateTagPlacement> getEntries() {
            return f387162b;
        }

        static {
            TemplateTagPlacement r100 = new TemplateTagPlacement("HEADER", 0);
            HEADER = r100;
            TemplateTagPlacement r101 = new TemplateTagPlacement("FOOT", 1);
            FOOT = r101;
            TemplateTagPlacement r102 = new TemplateTagPlacement("FEEDBACK", 2);
            FEEDBACK = r102;
            TemplateTagPlacement[] r103 = {r100, r101, r102};
            f387161a = r103;
            f387162b = EnumEntriesKt.enumEntries(r103);
        }

        public static TemplateTagPlacement[] values() {
            return (TemplateTagPlacement[]) f387161a.clone();
        }

        public static TemplateTagPlacement valueOf(String r100) {
            return (TemplateTagPlacement) r27.a.a(TemplateTagPlacement.class, r100);
        }

        public TemplateTagPlacement(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f387163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f387164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f387165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f387166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f387167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f387168f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f387163a, r101.f387163a) == 0) goto L12;
            return false;
        L12:
            if (this.f387164b == r101.f387164b) goto L15;
            return false;
        L15:
            if (this.f387165c == r101.f387165c) goto L18;
            return false;
        L18:
            if (this.f387166d == r101.f387166d) goto L21;
            return false;
        L21:
            if (this.f387167e == r101.f387167e) goto L24;
            return false;
        L24:
            if (this.f387168f == r101.f387168f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((Float.floatToIntBits(this.f387163a) * 31) + this.f387164b) * 31) + this.f387165c) * 31) + this.f387166d) * 31) + this.f387167e) * 31) + this.f387168f;
        }

        public final String toString() {
            return "TemplateTagStyle(textSizeSp=" + this.f387163a + ", radiusDp=" + this.f387164b + ", horizontalPaddingDp=" + this.f387165c + ", textColor=" + this.f387166d + ", fillColor=" + this.f387167e + ", strokeColor=" + this.f387168f + ')';
        }

        public /* synthetic */ b(float r100, int r101, int r110) {
            this(r100, r101, r110, -9735552, -1, -1973274);
        }

        public static b a(b r100, int r101, int r110, int r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            float r102 = r100.f387163a;
        L7:
            if ((r112 & 2) == 0) goto L9;
            int r103 = r100.f387164b;
        L11:
            if ((r112 & 4) == 0) goto L13;
            int r104 = r100.f387165c;
        L15:
            if ((r112 & 8) == 0) goto L17;
            r101 = r100.f387166d;
        L17:
            int r105 = r101;
            if ((r112 & 16) == 0) goto L20;
            r110 = r100.f387167e;
        L20:
            int r106 = r110;
            if ((r112 & 32) == 0) goto L24;
            r111 = r100.f387168f;
        L24:
            return new b(r102, r103, r104, r105, r106, r111);
        L13:
            r104 = 0;
            goto L15
        L9:
            r103 = 0;
            goto L11
        L5:
            r102 = 0.0f;
            goto L7
        }

        public b(float r100, int r101, int r102, int r103, int r104, int r105) {
            this.f387163a = r100;
            this.f387164b = r101;
            this.f387165c = r102;
            this.f387166d = r103;
            this.f387167e = r104;
            this.f387168f = r105;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387169a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f387170b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f387171c = null;

        static {
            int[] r100 = new int[TemplateTagPlacement.values().length];
            r100[TemplateTagPlacement.HEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L41:
            r100[TemplateTagPlacement.FOOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L57:
            r100[TemplateTagPlacement.FEEDBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            f387169a = r100;
            int[] r101 = new int[Vote.values().length];
            r101[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L45:
            r101[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L11:
            f387170b = r101;
            int[] r102 = new int[CardTemplateTagTone.values().length];
            r102[CardTemplateTagTone.NEUTRAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L47:
            r102[CardTemplateTagTone.ACCENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L35:
            r102[CardTemplateTagTone.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L49:
            r102[CardTemplateTagTone.WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L39:
            r102[CardTemplateTagTone.DANGER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L51:
            r102[CardTemplateTagTone.METRIC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L53:
            r102[CardTemplateTagTone.FEEDBACK_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L43:
            r102[CardTemplateTagTone.FEEDBACK_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L20:
            f387171c = r102;
        }
    }

    static {
    }

    public static Integer b(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        return null;
    L9:
        int r104 = 0;
    L11:
        if (r104 >= r101.length()) goto L21;
        char r105 = r101.charAt(r104);
        if ('0' <= r105) goto L15;
    L17:
        boolean r106 = false;
    L18:
        if (r106 == false) goto L19;
        r104 = r104 + 1;
        goto L11
    L19:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L24;
        return null;
    L24:
        Integer r108 = StringsKt.toIntOrNull(r101);
        if (r108 == null) goto L36;
        Integer r109 = Integer.valueOf(r108.intValue());
        int r110 = r109.intValue();
        if (r110 >= 0) goto L29;
    L31:
        if (r102 == true) goto L33;
        return null;
    L33:
        return r109;
    L29:
        if (r110 >= 10000) goto L31;
        r102 = true;
        goto L31
    L36:
        return null;
    L15:
        if (r105 >= ':') goto L17;
        r106 = true;
        goto L18
    L21:
        r107 = true;
        goto L22
    L5:
        r103 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [com.obric.assistant.cocreationreview.i6] */
    public final View c(final w5 r410) {
        final UsageCardTemplateRenderer r100 = this;
        Intrinsics.checkNotNullParameter(r410, ThumbGlideUrl.SOURCE_TEMPLATE);
        Context r101 = r100.f387152a;
        LinearLayout r102 = c4.k(r101);
        r102.setPadding(c4.c(r101, 14), c4.c(r101, 14), c4.c(r101, 14), c4.c(r101, 14));
        r102.setBackground(c4.h(r101, -1, 18, -1973274, 1));
        Context r110 = r100.f387152a;
        LinearLayout r111 = c4.e(r110);
        r111.setGravity(16);
        LinearLayout r103 = c4.e(r110);
        Iterator<T> r104 = r410.f387776f.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        int r112 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r107 = r100.e((d) r106, TemplateTagPlacement.HEADER, null);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, c4.c(r110, 30));
        if (r105 >= CollectionsKt.getLastIndex(r410.f387776f)) goto L11;
        r113.setMargins(0, 0, c4.c(r110, 7), 0);
    L11:
        Unit r108 = Unit.INSTANCE;
        r103.addView(r107, r113);
        r105 = r112;
        goto L4
    L12:
        HorizontalScrollView r109 = new HorizontalScrollView(r110);
        r109.setHorizontalScrollBarEnabled(false);
        r109.setOverScrollMode(2);
        r109.addView(r103, new ViewGroup.LayoutParams(-2, -2));
        r111.addView(r109, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (r410.f387774d.f387184b != Vote.UP) goto L15;
        boolean r114 = true;
    L16:
        View r115 = g("赞", r114, -14979842, !r410.f387775e, new f6(r100, r410));
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(c4.c(r110, 32), c4.c(r110, 32));
        r116.setMargins(c4.c(r110, 5), 0, 0, 0);
        Unit r117 = Unit.INSTANCE;
        r111.addView(r115, r116);
        if (r410.f387774d.f387184b != Vote.DOWN) goto L19;
        boolean r118 = true;
    L20:
        View r119 = g("踩", r118, -2076093, !r410.f387775e, new g6(r100, r410));
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(c4.c(r110, 32), c4.c(r110, 32));
        r120.setMargins(c4.c(r110, 5), 0, 0, 0);
        r111.addView(r119, r120);
        c4.b(r102, r111, 0, 0, 0, 14);
        Context r121 = r100.f387152a;
        String r122 = r410.f387773c.f387259b;
        if (r122 == null) goto L25;
        int r123 = 1;
        if ((!StringsKt.isBlank(r122)) == true) goto L27;
    L26:
        r122 = null;
    L27:
        LinearLayout r124 = c4.k(r121);
        c4.b(r124, c4.f(r121, r410.f387773c.f387258a, 16.0f, -15656921, r123), 0, 0, 0, 14);
        if (r122 == null) goto L58;
        Context r125 = r100.f387152a;
        List r126 = StringsKt.split$default(r122, new char[]{'\n'}, false, 0, 6, null);
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L31:
        if (r128.hasNext() == false) goto L33;
        r127.add(StringsKt.trim((String) r128.next()).toString());
        goto L31
    L33:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r127.iterator();
    L35:
        if (r130.hasNext() == false) goto L43;
        Object r131 = r130.next();
        if (((String) r131).length() <= 0) goto L39;
        boolean r210 = true;
    L40:
        if (r210 == false) goto L35;
        r129.add(r131);
        goto L35
    L39:
        r210 = false;
        goto L40
    L43:
        if (r129.size() > 1) goto L45;
        View r211 = c4.f(r125, r122, 13.0f, -9735552, 1);
    L57:
        c4.b(r124, r211, 0, c4.c(r121, 4), 0, 10);
        goto L58
    L45:
        LinearLayout r132 = c4.k(r125);
        Iterator r133 = r129.iterator();
        int r134 = 0;
    L47:
        if (r133.hasNext() == false) goto L56;
        Object r212 = r133.next();
        int r310 = r134 + 1;
        if (r134 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        TextView r135 = c4.f(r125, (String) r212, 13.0f, -9735552, 1);
        r135.setMaxLines(1);
        r135.setEllipsize(TextUtils.TruncateAt.END);
        if (r134 != 0) goto L54;
        int r213 = 0;
    L55:
        c4.b(r132, r135, 0, r213, 0, 10);
        r134 = r310;
        goto L47
    L54:
        r213 = c4.c(r125, 2);
        goto L55
    L56:
        r211 = r132;
    L58:
        TextView r214 = c4.f(r121, r410.f387773c.f387260c, 12.5f, -9735552, 0);
        if (r122 != null) goto L61;
        int r136 = 5;
    L62:
        c4.b(r124, r214, 0, c4.c(r121, r136), 0, 10);
        c4.b(r102, r124, 0, c4.c(r101, 10), 0, 10);
        final z4 r137 = r410.f387780j;
        if (r410.f387778h == true) goto L65;
    L68:
        View r138 = r410.f387777g;
    L69:
        c4.b(r102, r138, 0, c4.c(r101, 14), 0, 10);
        int r139 = 17;
        if (r410.f387783m == false) goto L125;
        final String r140 = r410.f387771a;
        Integer r141 = r410.f387774d.f387190h;
        if (r410.f387775e == false) goto L74;
    L76:
        boolean r142 = false;
    L77:
        Context r143 = r100.f387152a;
        LinearLayout r215 = c4.k(r143);
        c4.b(r215, r100.f387159h.invoke(), c4.c(r143, 1), 0, c4.c(r143, 15), 4);
        TextView r144 = c4.f(r143, "这条建议对你的价值？", 12.0f, -9735552, 1);
        r144.setGravity(17);
        c4.b(r215, r144, 0, 0, c4.c(r143, 9), 6);
        LinearLayout r145 = c4.e(r143);
        r145.setPadding(c4.c(r143, 3), c4.c(r143, 3), c4.c(r143, 3), c4.c(r143, 3));
        r145.setBackground(c4.h(r143, -459777, 999, 0, 0));
        Iterator r146 = t3.f387735a.iterator();
    L79:
        if (r146.hasNext() == false) goto L102;
        final int r147 = ((Number) r146.next()).intValue();
        if (r141 != null) goto L84;
    L86:
        final boolean r148 = false;
    L87:
        String r149 = "¥" + r147;
        if (r148 == false) goto L90;
        int r150 = 1;
        int r151 = -15656921;
    L91:
        TextView r152 = c4.f(r143, r149, 12.0f, r151, r150);
        r152.setGravity(r139);
        r152.setMinHeight(c4.c(r143, 28));
        if (r148 == false) goto L94;
        r152.setBackground(c4.h(r143, -1, 999, 0, 0));
    L94:
        r152.setEnabled(r142);
        if (r142 == false) goto L97;
        float r153 = 1.0f;
    L98:
        r152.setAlpha(r153);
        if (r142 == false) goto L101;
        r152.setClickable(true);
        r152.setOnClickListener(new y5(r100, r140, r148, r147));
    L101:
        r145.addView(r152, new LinearLayout.LayoutParams(0, -2, 1.0f));
        r146 = r146;
        r139 = 17;
        goto L79
    L97:
        r153 = 0.75f;
        goto L98
    L90:
        r151 = -5721662;
        r150 = 1;
        goto L91
    L84:
        if (r141.intValue() != r147) goto L86;
        r148 = true;
        goto L87
    L102:
        c4.b(r215, r145, 0, 0, 0, 14);
        Context r154 = r100.f387152a;
        final LinearLayout r155 = c4.e(r154);
        r155.setId(R.id.action_bar_panel);
        r155.setVisibility(8);
        LinearLayout r156 = c4.e(r154);
        r156.setPadding(c4.c(r154, 10), 0, c4.c(r154, 10), 0);
        r156.setMinimumHeight(c4.c(r154, 30));
        r156.setBackground(c4.h(r154, -459777, 999, -1973274, 1));
        r156.addView(c4.f(r154, "¥", 12.0f, -9735552, 1));
        final EditText r157 = new EditText(r154);
        r157.setId(R.id.action_bar_panel_click_area);
        r157.setHint("自定义金额");
        r157.setTextSize(12.0f);
        r157.setTextColor(-15656921);
        r157.setHintTextColor(-5721662);
        r157.setTypeface(Typeface.DEFAULT_BOLD);
        r157.setInputType(2);
        r157.setMaxLines(1);
        r157.setBackground(null);
        r157.setEnabled(r142);
        r157.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(4)});
        if (r141 != null) goto L105;
    L107:
        r157.setPadding(c4.c(r154, 4), 0, 0, 0);
        r157.setOnFocusChangeListener(new k6(r100));
        r156.addView(r157, new LinearLayout.LayoutParams(0, -2, 1.0f));
        r155.addView(r156, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r158 = c4.j(r154, "确定", true, -14979842, new l6(r100, r157, r140));
        r158.setMinHeight(c4.c(r154, 30));
        r157.addTextChangedListener(new m6(r142, r100, r157, r158));
        a(r142, r100, r157, r158);
        LinearLayout.LayoutParams r159 = new LinearLayout.LayoutParams(-2, -2);
        r159.setMargins(c4.c(r154, 6), 0, 0, 0);
        Unit r160 = Unit.INSTANCE;
        r155.addView(r158, r159);
        TextView r161 = c4.f(r154, "取消", 12.0f, -9735552, 1);
        r161.setId(R.id.action_bar_panel_close);
        r161.setGravity(17);
        r161.setMinHeight(c4.c(r154, 30));
        int r162 = 12;
        r161.setPadding(c4.c(r154, 12), 0, c4.c(r154, 12), 0);
        r161.setBackground(c4.h(r154, -459777, 999, 0, 0));
        r161.setClickable(true);
        LinearLayout.LayoutParams r163 = new LinearLayout.LayoutParams(-2, -2);
        r163.setMargins(c4.c(r154, 6), 0, 0, 0);
        r155.addView(r161, r163);
        final LinearLayout r164 = c4.e(r143);
        r164.setGravity(17);
        if (r141 == null) goto L110;
        String r165 = "已记录 ¥ " + r141;
    L111:
        r164.addView(c4.f(r143, r165, 12.0f, -5721662, 0));
        if (r141 == null) goto L114;
        String r166 = "修改金额";
    L115:
        if (r142 == false) goto L117;
        int r167 = -14979842;
    L118:
        TextView r168 = c4.f(r143, r166, 12.0f, r167, 1);
        r168.setPadding(c4.c(r143, 10), 0, 0, 0);
        if (r142 == false) goto L121;
        r168.setClickable(true);
        r168.setOnClickListener(new d6(r164, r155, r100));
    L121:
        r164.addView(r168);
        c4.b(r215, r164, 0, c4.c(r143, 7), 0, 10);
        View r169 = r155.findViewById(R.id.action_bar_panel_close);
        if (r169 == null) goto L124;
        r169.setOnClickListener(new e6(r155, r164));
    L124:
        c4.b(r215, r155, 0, c4.c(r143, 7), 0, 10);
        c4.b(r102, r215, 0, c4.c(r101, 14), 0, 10);
    L127:
        if ((!r410.f387779i.isEmpty()) == false) goto L129;
    L130:
        c4.a(r102, r100.f387159h.invoke(), c4.c(r101, 1), c4.c(r101, 14), c4.c(r101, r162));
        Context r170 = r100.f387152a;
        LinearLayout r171 = c4.e(r170);
        r171.setGravity(16);
        if ((!r410.f387779i.isEmpty()) == false) goto L148;
        List<com.obric.assistant.cocreationreview.c> r172 = r410.f387779i;
        final z4 r173 = r410.f387780j;
        if ((r173 instanceof z4.a) == false) goto L147;
        List<com.obric.assistant.cocreationreview.c> r174 = r172;
        ArrayList r175 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r174, 10));
        Iterator r176 = r174.iterator();
    L137:
        if (r176.hasNext() == false) goto L146;
        com.obric.assistant.cocreationreview.c r177 = (com.obric.assistant.cocreationreview.c) r176.next();
        final String r178 = r177.f387217g;
        if (r178 == null) goto L145;
        if (r177.f387218h != null) goto L145;
        Function0 r179 = new z5(r100, r173, r178);
        String r180 = r177.f387211a;
        CardTemplateTagTone r181 = r177.f387212b;
        Integer r182 = r177.f387213c;
        Integer r183 = r177.f387214d;
        Function1<Context, Drawable> r184 = r177.f387215e;
        Integer r185 = r177.f387216f;
        Intrinsics.checkNotNullParameter(r180, "text");
        Intrinsics.checkNotNullParameter(r181, "tone");
        r177 = new com.obric.assistant.cocreationreview.c(r180, r181, r182, r183, r184, r185, r178, r179);
    L145:
        r175.add(r177);
        r176 = r176;
        r173 = r173;
        goto L137
    L146:
        r172 = r175;
    L147:
        r171.addView(r100.d(r172), new LinearLayout.LayoutParams(0, -2, 1.0f));
    L149:
        final z4 r186 = r410.f387780j;
        if ((r186 instanceof z4.a) == false) goto L152;
        final ?? r187 = new i6(r100, r186);
        Context r188 = r100.f387152a;
        TextView r189 = c4.f(r188, "查看详情  ›", 10.5f, -14979842, 1);
        r189.setGravity(17);
        r189.setPadding(c4.c(r188, 12), 0, c4.c(r188, 10), 0);
        r189.setBackground(c4.h(r188, -1, 15, -1512723, 1));
        r189.setOnClickListener(new a6(r187));
        LinearLayout.LayoutParams r190 = new LinearLayout.LayoutParams(-2, c4.c(r170, 30));
        r190.setMargins(c4.c(r170, 10), 0, 0, 0);
        Unit r191 = Unit.INSTANCE;
        r171.addView(r189, r190);
    L152:
        c4.b(r102, r171, 0, 0, 0, 14);
    L153:
        com.obric.assistant.cocreationreview.b r192 = r410.f387781k;
        if (Intrinsics.areEqual(r192, com.obric.assistant.cocreationreview.b.C4599b.f387192a) == false) goto L156;
        LinearLayout r216 = r102;
    L270:
        int r193 = RangesKt.coerceIn(r410.f387772b, 0, 3);
        if (r193 == 0) goto L307;
        Context r194 = this.f387152a;
        int r195 = y3.f387800a;
        FrameLayout r196 = new FrameLayout(r194);
        r196.setClipChildren(false);
        r196.setClipToPadding(false);
        int r197 = 0;
    L274:
        if (r197 >= r193) goto L276;
        int r198 = c4.c(r194, (r193 - r197) * 9);
        View r199 = new View(r194);
        r199.setImportantForAccessibility(2);
        r199.setBackground(c4.h(r194, -1, 18, -1973274, 1));
        FrameLayout.LayoutParams r200 = new FrameLayout.LayoutParams(-1, c4.c(r194, 58));
        r200.setMargins(r198, c4.c(r194, r197 * 7), r198, 0);
        Unit r201 = Unit.INSTANCE;
        r196.addView(r199, r200);
        r197 = r197 + 1;
        goto L274
    L276:
        FrameLayout.LayoutParams r202 = new FrameLayout.LayoutParams(-1, -2);
        r202.topMargin = c4.c(r194, r193 * 7);
        Unit r203 = Unit.INSTANCE;
        r196.addView(r216, r202);
        return r196;
    L307:
        return r216;
    L156:
        if ((r192 instanceof com.obric.assistant.cocreationreview.b.a) == false) goto L203;
        ((com.obric.assistant.cocreationreview.b.a) r192).getClass();
        Context r204 = r100.f387152a;
        a5 r205 = r410.f387774d;
        LinearLayout r206 = c4.k(r204);
        c4.b(r206, r100.f387159h.invoke(), c4.c(r204, 1), 0, c4.c(r204, 15), 4);
        Vote r207 = r205.f387184b;
        if (r207 != null) goto L160;
        int r208 = -1;
    L162:
        if (r208 != (-1)) goto L164;
        List r209 = CollectionsKt.emptyList();
        if (r205.f387184b != Vote.DOWN) goto L176;
        String r217 = "点踩原因（单选）";
    L177:
        r206.addView(c4.f(r204, r217, 13.5f, -9735552, 1));
        if (r209.isEmpty() == true) goto L199;
        final String r218 = r410.f387771a;
        Context r219 = r100.f387152a;
        LinearLayout r1100 = c4.k(r219);
        LinearLayout r220 = c4.e(r219);
        Iterator r221 = r209.iterator();
        LinearLayout r222 = r220;
        int r223 = 0;
        int r224 = 0;
    L181:
        if (r221.hasNext() == false) goto L196;
        Object r1101 = r221.next();
        int r1102 = r223 + 1;
        if (r223 >= 0) goto L185;
        CollectionsKt.throwIndexOverflow();
    L185:
        final String r1103 = (String) r1101;
        int r1104 = r1103.length() + 4;
        if (r223 <= 0) goto L191;
        if ((r224 + r1104) <= 22) goto L191;
        c4.b(r1100, r222, 0, 0, c4.c(r219, 8), 6);
        r222 = c4.e(r219);
        r224 = 0;
    L191:
        if (r205.f387185c.contains(r1103) == false) goto L193;
        CardTemplateTagTone r225 = CardTemplateTagTone.ACCENT;
    L194:
        View r226 = r100.e(new d(r1103, r225, null, null, 28), TemplateTagPlacement.FEEDBACK, null);
        r226.setOnClickListener(new c6(r100, r218, r1103));
        LinearLayout.LayoutParams r1105 = new LinearLayout.LayoutParams(-2, c4.c(r219, 32));
        r1105.setMargins(0, 0, c4.c(r219, 8), 0);
        Unit r1106 = Unit.INSTANCE;
        r222.addView(r226, r1105);
        r224 = r224 + r1104;
        r223 = r1102;
        goto L181
    L193:
        r225 = CardTemplateTagTone.NEUTRAL;
        goto L194
    L196:
        if (r222.getChildCount() <= 0) goto L198;
        c4.b(r1100, r222, 0, 0, 0, 14);
    L198:
        c4.b(r206, r1100, 0, c4.c(r204, 10), 0, 10);
    L200:
        new EditText(r204).setText(r205.f387186d);
        t3.a(null, r205.f387184b);
        throw null;
    L199:
        c4.b(r206, c4.f(r204, "需先选择点赞或点踩", 12.0f, -9735552, 0), 0, c4.c(r204, 10), 0, 10);
        goto L200
    L176:
        r217 = "点赞原因（单选）";
        goto L177
    L164:
        if (r208 == 1) goto L172;
        if (r208 != 2) goto L170;
        throw null;
    L170:
        throw new NoWhenBranchMatchedException();
    L172:
        throw null;
    L160:
        r208 = c.f387170b[r207.ordinal()];
        goto L162
    L203:
        if (Intrinsics.areEqual(r192, com.obric.assistant.cocreationreview.b.c.f387193a) == false) goto L268;
        Context r227 = r100.f387152a;
        a5 r228 = r410.f387774d;
        LinearLayout r229 = c4.k(r227);
        c4.b(r229, r100.f387159h.invoke(), c4.c(r227, 1), 0, c4.c(r227, 15), 4);
        LinearLayout r1107 = c4.e(r227);
        r1107.setGravity(16);
        r1107.addView(c4.f(r227, "标注结果", 13.5f, -15656921, 1), new LinearLayout.LayoutParams(0, -2, 1.0f));
        long r230 = r228.f387188f;
        if (r230 > 0) goto L207;
        String r231 = "提交时间未知";
    L208:
        r1107.addView(c4.f(r227, r231, 12.0f, -9735552, 0));
        c4.b(r229, r1107, 0, 0, c4.c(r227, 10), 6);
        Vote r232 = r228.f387184b;
        if (r232 != null) goto L211;
        int r233 = -1;
    L213:
        if (r233 != (-1)) goto L215;
        d r1108 = null;
    L224:
        List r234 = CollectionsKt.listOfNotNull(r1108);
        Set<String> r235 = r228.f387185c;
        ArrayList r236 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r235, 10));
        Iterator<T> r237 = r235.iterator();
    L226:
        if (r237.hasNext() == false) goto L228;
        r236.add(new d((String) r237.next(), CardTemplateTagTone.NEUTRAL, null, null, 28));
        goto L226
    L228:
        List r238 = CollectionsKt.plus(r234, r236);
        Intrinsics.checkNotNullParameter(r238, PromotionProductPrivilegesStruct.TAGS);
        Context r239 = r100.f387152a;
        LinearLayout r240 = c4.k(r239);
        LinearLayout r1109 = c4.e(r239);
        Iterator r241 = r238.iterator();
        LinearLayout r1110 = r1109;
        int r1111 = 0;
        int r1112 = 0;
    L230:
        if (r241.hasNext() == false) goto L242;
        Object r1113 = r241.next();
        int r242 = r1111 + 1;
        if (r1111 >= 0) goto L234;
        CollectionsKt.throwIndexOverflow();
    L234:
        d r1114 = (d) r1113;
        int r311 = r1114.f387226a.length() + 4;
        if (r1111 <= 0) goto L240;
        if ((r1112 + r311) <= 22) goto L240;
        c4.b(r240, r1110, 0, 0, c4.c(r239, 8), 6);
        r1110 = c4.e(r239);
        r1112 = 0;
    L240:
        View r243 = r100.e(r1114, TemplateTagPlacement.FEEDBACK, null);
        LinearLayout.LayoutParams r1115 = new LinearLayout.LayoutParams(-2, c4.c(r239, 32));
        r1115.setMargins(0, 0, c4.c(r239, 8), 0);
        Unit r1116 = Unit.INSTANCE;
        r1110.addView(r243, r1115);
        r1112 = r1112 + r311;
        r1111 = r242;
        r241 = r241;
        goto L230
    L242:
        if (r1110.getChildCount() <= 0) goto L244;
        c4.b(r240, r1110, 0, 0, 0, 14);
    L244:
        c4.b(r229, r240, 0, 0, 0, 14);
        if ((!StringsKt.isBlank(r228.f387186d)) == false) goto L248;
        c4.b(r229, c4.f(r227, "补充说明", 12.0f, -9735552, 1), 0, c4.c(r227, 12), c4.c(r227, 6), 2);
        TextView r1117 = c4.f(r227, r228.f387186d, 12.5f, -13418155, 0);
        r1117.setPadding(c4.c(r227, 12), c4.c(r227, 10), c4.c(r227, 12), c4.c(r227, 10));
        r1117.setBackground(c4.h(r227, -459777, 10, -1512723, 1));
        c4.b(r229, r1117, 0, 0, 0, 14);
    L248:
        if ((!r410.f387782l.isEmpty()) == false) goto L265;
        List<b5> r244 = r410.f387782l;
        Context r245 = r100.f387152a;
        LinearLayout r246 = c4.k(r245);
        c4.b(r246, c4.f(r245, "上传内容 · " + r244.size(), 12.0f, -9735552, 1), 0, 0, c4.c(r245, 6), 6);
        LinearLayout r247 = c4.e(r245);
        r247.setGravity(48);
        Iterator r1118 = r244.iterator();
        int r1119 = 0;
    L251:
        if (r1118.hasNext() == false) goto L264;
        Object r1120 = r1118.next();
        int r1121 = r1119 + 1;
        if (r1119 >= 0) goto L255;
        CollectionsKt.throwIndexOverflow();
    L255:
        b5 r1122 = (b5) r1120;
        Context r1123 = r100.f387152a;
        FrameLayout r1124 = new FrameLayout(r1123);
        Iterator r1125 = r1118;
        r1124.setBackground(c4.h(r1123, -1, 9, -1512723, 1));
        ImageView r248 = new ImageView(r1123);
        r248.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r248.setBackground(c4.h(r1123, -1512205, 9, 0, 0));
        r248.setClipToOutline(true);
        r248.setContentDescription(r1122.f387201d);
        FrameLayout.LayoutParams r1126 = new FrameLayout.LayoutParams(-1, -1);
        LinearLayout r249 = r102;
        Context r250 = r101;
        LinearLayout r312 = r229;
        r1126.setMargins(c4.c(r1123, 1), c4.c(r1123, 1), c4.c(r1123, 1), c4.c(r1123, 1));
        Unit r251 = Unit.INSTANCE;
        r1124.addView(r248, r1126);
        ExecutorService r252 = p.f387634a;
        p.c(r248, r1122, c4.c(r1123, 64));
        if (r1122.getType() != FeedbackMediaType.VIDEO) goto L258;
        TextView r253 = c4.f(r1123, "视频", 9.0f, -1, 1);
        r253.setGravity(17);
        r253.setBackground(c4.h(r1123, -1728053248, 4, 0, 0));
        FrameLayout.LayoutParams r254 = new FrameLayout.LayoutParams(c4.c(r1123, 30), c4.c(r1123, 18), 8388691);
        int r1127 = 0;
        r254.setMargins(c4.c(r1123, 4), 0, 0, c4.c(r1123, 4));
        r1124.addView(r253, r254);
    L259:
        LinearLayout.LayoutParams r255 = new LinearLayout.LayoutParams(c4.c(r245, 64), c4.c(r245, 64));
        if (r1119 >= CollectionsKt.getLastIndex(r244)) goto L263;
        r255.setMargins(r1127, r1127, c4.c(r245, 8), r1127);
    L263:
        r247.addView(r1124, r255);
        r100 = this;
        r1118 = r1125;
        r1119 = r1121;
        r102 = r249;
        r101 = r250;
        r229 = r312;
        goto L251
    L258:
        r1127 = 0;
        goto L259
    L264:
        LinearLayout r313 = r229;
        Context r256 = r101;
        r216 = r102;
        HorizontalScrollView r1128 = new HorizontalScrollView(r245);
        r1128.setHorizontalScrollBarEnabled(false);
        r1128.setOverScrollMode(2);
        r1128.addView(r247, new ViewGroup.LayoutParams(-2, -2));
        c4.b(r246, r1128, 0, 0, 0, 14);
        c4.b(r313, r246, 0, c4.c(r227, 12), 0, 10);
    L266:
        c4.b(r216, r313, 0, c4.c(r256, 15), 0, 10);
        goto L270
    L265:
        r313 = r229;
        r256 = r101;
        r216 = r102;
        goto L266
    L215:
        if (r233 != 1) goto L217;
        d r257 = new d("点赞", CardTemplateTagTone.FEEDBACK_UP, null, null, 28);
    L222:
        r1108 = r257;
        goto L224
    L217:
        if (r233 != 2) goto L220;
        r257 = new d("点踩", CardTemplateTagTone.FEEDBACK_DOWN, null, null, 28);
        goto L222
    L220:
        throw new NoWhenBranchMatchedException();
    L211:
        r233 = c.f387170b[r232.ordinal()];
        goto L213
    L207:
        r231 = "提交于 " + new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(new Date(r230));
        goto L208
    L268:
        throw new NoWhenBranchMatchedException();
    L148:
        r171.addView(new View(r170), new LinearLayout.LayoutParams(0, 1, 1.0f));
        goto L149
    L129:
        if ((r410.f387780j instanceof z4.a) == false) goto L153;
    L117:
        r167 = -5721662;
        goto L118
    L114:
        r166 = "自定义金额";
        goto L115
    L110:
        r165 = "未选择金额";
        goto L111
    L105:
        if (t3.f387735a.contains(r141) == true) goto L107;
        r157.setText(r141.toString());
        r157.setSelection(r157.getText().length());
        goto L107
    L74:
        if ((r410.f387781k instanceof com.obric.assistant.cocreationreview.b.c) == true) goto L76;
        r142 = true;
        goto L77
    L125:
        r162 = 12;
        goto L127
    L65:
        if ((r137 instanceof z4.a) == false) goto L68;
        r138 = r410.f387777g;
        r138.setClickable(true);
        r138.setFocusable(true);
        r138.setOnClickListener(new h6(r100, r137));
        goto L69
    L61:
        r136 = 3;
        goto L62
    L25:
        r123 = 1;
        goto L26
    L19:
        r118 = false;
        goto L20
    L15:
        r114 = false;
        goto L16
    }

    public final View d(List<com.obric.assistant.cocreationreview.c> r110) {
        Intrinsics.checkNotNullParameter(r110, PromotionProductPrivilegesStruct.TAGS);
        Context r100 = this.f387152a;
        LinearLayout r101 = c4.e(r100);
        Iterator<T> r102 = r110.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L21;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.assistant.cocreationreview.c r106 = (com.obric.assistant.cocreationreview.c) r104;
        Integer r107 = r106.f387216f;
        if (r107 == null) goto L11;
        Integer r108 = Integer.valueOf(c4.c(this.f387152a, r107.intValue()));
    L12:
        View r109 = e(new d(r106.f387211a, r106.f387212b, r106.f387213c, r106.f387214d, r106.f387215e), TemplateTagPlacement.FOOT, r108);
        final Function0<Unit> r111 = r106.f387218h;
        if (r111 == null) goto L16;
        r109.setClickable(true);
        r109.setFocusable(true);
        r109.setOnClickListener(new b6(r111));
    L16:
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, c4.c(r100, 30));
        if (r103 >= CollectionsKt.getLastIndex(r110)) goto L20;
        r112.setMargins(0, 0, c4.c(r100, 7), 0);
    L20:
        Unit r113 = Unit.INSTANCE;
        r101.addView(r109, r112);
        r103 = r105;
        goto L4
    L11:
        r108 = null;
        goto L12
    L21:
        return r101;
    }

    public static b f(CardTemplateTagTone r100, TemplateTagPlacement r101) {
        int r102 = c.f387169a[r101.ordinal()];
        int r103 = 8;
        int r104 = 15;
        float r105 = 10.5f;
        if (r102 != 1) goto L5;
        b r106 = new b(r105, r104, r103);
    L14:
        switch(c.f387171c[r100.ordinal()]) {
            case 1: goto L25;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            default: goto L16;
        };
    L16:
        throw new NoWhenBranchMatchedException();
    L26:
        return b.a(r106, -2076093, -3598, -79158, 7);
    L27:
        return b.a(r106, -14979842, -1379585, -14979842, 7);
    L28:
        return b.a(r106, -13418155, -459777, -1512723, 7);
    L29:
        return b.a(r106, -2349530, -3598, -79158, 7);
    L30:
        return b.a(r106, -680437, -2067, -75862, 7);
    L31:
        return b.a(r106, -15293622, -1378321, -3807022, 7);
    L32:
        return b.a(r106, -14979842, -1378561, -4661249, 7);
    L25:
        return b.a(r106, -9735552, -1, -1973274, 7);
    L5:
        if (r102 != 2) goto L7;
        r106 = new b(r105, r104, r103);
        goto L14
    L7:
        if (r102 != 3) goto L10;
        float r107 = 12.0f;
        r106 = new b(r107, 16, 10);
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final View e(d r110, TemplateTagPlacement r111, Integer r112) {
        Context r100 = this.f387152a;
        int[] r101 = c.f387169a;
        int r102 = r101[r111.ordinal()];
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L12;
        if (r102 != 3) goto L11;
        Integer r103 = r110.f387228c;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
        b r105 = b.a(f(r110.f387227b, r111), r104, c4.g(r104), c4.i(r104), 7);
    L14:
        GradientDrawable r113 = c4.h(r100, r105.f387167e, r105.f387164b, r105.f387168f, 1);
        Function1<Context, Drawable> r114 = r110.f387230e;
        if (r114 == null) goto L17;
        Drawable r115 = r114.invoke(r100);
    L18:
        Integer r116 = r110.f387229d;
        if (r115 != null) goto L25;
        if (r116 != null) goto L25;
        TextView r106 = c4.f(r100, r110.f387226a, r105.f387163a, r105.f387166d, 1);
        r106.setGravity(17);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        if (r112 == null) goto L24;
        r106.setMaxWidth(r112.intValue());
    L24:
        r106.setPadding(c4.c(r100, r105.f387165c), 0, c4.c(r100, r105.f387165c), 0);
        r106.setBackground(r113);
        return r106;
    L25:
        int r117 = c4.c(r100, r105.f387165c);
        LinearLayout r118 = c4.e(r100);
        r118.setGravity(17);
        r118.setPadding(r117, 0, r117, 0);
        r118.setBackground(r113);
        int r107 = r101[r111.ordinal()];
        if (r107 == 1) goto L32;
        if (r107 == 2) goto L32;
        if (r107 != 3) goto L31;
        int r108 = 15;
    L33:
        ImageView r109 = new ImageView(r100);
        if (r115 == null) goto L36;
        r109.setImageDrawable(r115);
        r109.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r109.setBackground(c4.h(r100, -1, 5, 0, 0));
        r109.setClipToOutline(true);
    L38:
        r109.setContentDescription(r110.f387226a);
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(c4.c(r100, r108), c4.c(r100, r108));
        r119.setMargins(0, 0, c4.c(r100, 5), 0);
        Unit r120 = Unit.INSTANCE;
        r118.addView(r109, r119);
        TextView r121 = c4.f(r100, r110.f387226a, r105.f387163a, r105.f387166d, 1);
        r121.setMaxLines(1);
        r121.setEllipsize(TextUtils.TruncateAt.END);
        if (r112 == null) goto L41;
        r121.setMaxWidth(RangesKt.coerceAtLeast(r112.intValue() - (((r117 * 2) + c4.c(r100, r108)) + c4.c(r100, 5)), c4.c(r100, 24)));
    L41:
        r118.addView(r121);
        return r118;
    L36:
        if (r116 == null) goto L38;
        r109.setImageResource(r116.intValue());
        r109.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L38
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r108 = 16;
        goto L33
    L17:
        r115 = null;
        goto L18
    L9:
        r105 = f(r110.f387227b, r111);
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r105 = b.a(f(CardTemplateTagTone.NEUTRAL, r111), 0, 0, 0, 47);
        goto L14
    L13:
        r105 = f(CardTemplateTagTone.NEUTRAL, r111);
        goto L14
    }

    public static final void a(boolean r100, UsageCardTemplateRenderer r101, EditText r102, TextView r103) {
        if (r100 == false) goto L6;
        String r104 = r102.getText().toString();
        r101.getClass();
        if (b(r104) == null) goto L6;
        boolean r105 = true;
    L7:
        r103.setEnabled(r105);
        r103.setClickable(r105);
        if (r105 == false) goto L10;
        float r106 = 1.0f;
    L11:
        r103.setAlpha(r106);
        return;
    L10:
        r106 = 0.45f;
    L6:
        r105 = false;
        goto L7
    }

    public final ImageView g(String r100, boolean r101, int r102, boolean r103, final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r110, SendEventContainerMethodParamModel.EventKinds.onClick);
        Context r104 = this.f387152a;
        if (Intrinsics.areEqual(r100, "踩") == false) goto L5;
        int r105 = R.drawable.ic_cocreation_thumb_down;
    L6:
        ImageView r106 = new ImageView(r104);
        r106.setContentDescription(r100);
        r106.setImageResource(r105);
        if (r101 == false) goto L9;
        int r107 = -1;
    L10:
        r106.setColorFilter(r107);
        r106.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r106.setPadding(c4.c(r104, 7), c4.c(r104, 7), c4.c(r104, 7), c4.c(r104, 7));
        GradientDrawable r108 = new GradientDrawable();
        r108.setShape(1);
        if (r101 == false) goto L13;
        int r109 = r102;
    L14:
        r108.setColor(r109);
        int r111 = c4.c(r104, 1);
        if (r101 == true) goto L18;
        r102 = -1512723;
    L18:
        r108.setStroke(r111, r102);
        r106.setBackground(r108);
        r106.setEnabled(r103);
        r106.setClickable(r103);
        r106.setFocusable(r103);
        if (r103 == false) goto L21;
        r106.setOnClickListener(new j6(r110));
    L21:
        return r106;
    L13:
        r109 = -459777;
        goto L14
    L9:
        r107 = -9735552;
        goto L10
    L5:
        r105 = R.drawable.ic_cocreation_thumb_up;
        goto L6
    }

    public UsageCardTemplateRenderer(CocreationReviewActivity r100, Function2 r101, Function2 r102, b2 r103, Function1 r104, Function1 r105, Function1 r106, Function0 r107, Function2 r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onVote");
        Intrinsics.checkNotNullParameter(r102, "onReasonToggle");
        Intrinsics.checkNotNullParameter(r103, "onCommentChange");
        Intrinsics.checkNotNullParameter(r104, "onComplete");
        Intrinsics.checkNotNullParameter(r105, "onShowDetail");
        Intrinsics.checkNotNullParameter(r106, "onInputFocus");
        Intrinsics.checkNotNullParameter(r107, ItemStyle.ITEM_STYLE_DIVIDER);
        Intrinsics.checkNotNullParameter(r110, "onFeedbackValueSelect");
        this.f387152a = r100;
        this.f387153b = r101;
        this.f387154c = r102;
        this.f387155d = r103;
        this.f387156e = r104;
        this.f387157f = r105;
        this.f387158g = r106;
        this.f387159h = r107;
        this.f387160i = r110;
    }
}
