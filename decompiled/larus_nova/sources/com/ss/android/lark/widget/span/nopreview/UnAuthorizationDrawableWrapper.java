package com.ss.android.lark.widget.span.nopreview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class UnAuthorizationDrawableWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Style f448718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f448721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f448722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f448723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f448724g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/widget/span/nopreview/UnAuthorizationDrawableWrapper$Style;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "TIP_HOLDER", "ICON_HOLDER", "COLOR_HOLDER", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style AUTO = null;
        public static final Style COLOR_HOLDER = null;
        public static final Style ICON_HOLDER = null;
        public static final Style TIP_HOLDER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f448725a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f448726b = null;

        public static EnumEntries<Style> getEntries() {
            return f448726b;
        }

        static {
            Style r100 = new Style("AUTO", 0);
            AUTO = r100;
            Style r101 = new Style("TIP_HOLDER", 1);
            TIP_HOLDER = r101;
            Style r102 = new Style("ICON_HOLDER", 2);
            ICON_HOLDER = r102;
            Style r103 = new Style("COLOR_HOLDER", 3);
            COLOR_HOLDER = r103;
            Style[] r104 = {r100, r101, r102, r103};
            f448725a = r104;
            f448726b = EnumEntriesKt.enumEntries(r104);
        }

        public static Style[] values() {
            return (Style[]) f448725a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Style f448727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f448728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f448729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f448730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f448731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f448732f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f448733g;

        public a() {
            this.f448727a = Style.AUTO;
        }

        public final Drawable a(Context r110) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r100 = this.f448728b;
            int r101 = this.f448729c;
            UnAuthorizationDrawableWrapper r102 = new UnAuthorizationDrawableWrapper(this.f448727a, r100, r101, this.f448730d, this.f448731e, this.f448732f, this.f448733g);
            Style r103 = r102.f448718a;
            int r104 = c.f448734a[r103.ordinal()];
            int r105 = 16;
            if (r104 == 1) goto L40;
            if (r104 != 2) goto L7;
            Drawable r106 = r102.b(r110);
            if (r106 == null) goto L59;
            return r106;
        L59:
            return r102.a(r110);
        L7:
            if (r104 == 3) goto L57;
            if (r104 != 4) goto L34;
            if (r102.f448719b <= UIUtils.dp2px(r110, 80.0f)) goto L26;
            if (r102.f448720c <= UIUtils.dp2px(r110, 80.0f)) goto L26;
            if (r102.f448719b >= UIUtils.dp2px(r110, 120.0f)) goto L17;
        L19:
            r105 = 12;
        L20:
            com.ss.android.lark.widget.span.nopreview.a r107 = r102.c(r110, r105);
            if (r107 != null) goto L51;
            Drawable r108 = r102.b(r110);
            if (r108 == null) goto L53;
            return r108;
        L53:
            return r102.a(r110);
        L51:
            return r107;
        L17:
            if (r102.f448720c < UIUtils.dp2px(r110, 120.0f)) goto L19;
        L26:
            if (r102.f448719b < UIUtils.dp2px(r110, 22.0f)) goto L56;
            if (r102.f448720c < UIUtils.dp2px(r110, 22.0f)) goto L56;
            Drawable r109 = r102.b(r110);
            if (r109 == null) goto L55;
            return r109;
        L55:
            return r102.a(r110);
        L56:
            return r102.a(r110);
        L34:
            throw new NoWhenBranchMatchedException();
        L57:
            return r102.a(r110);
        L40:
            if (r102.f448719b >= UIUtils.dp2px(r110, 120.0f)) goto L42;
        L44:
            r105 = 12;
        L45:
            com.ss.android.lark.widget.span.nopreview.a r111 = r102.c(r110, r105);
            if (r111 != null) goto L60;
            Drawable r112 = r102.b(r110);
            if (r112 == null) goto L50;
            return r112;
        L50:
            return r102.a(r110);
        L60:
            return r111;
        L42:
            if (r102.f448720c < UIUtils.dp2px(r110, 120.0f)) goto L44;
            goto L44
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448734a = null;

        static {
            int[] r100 = new int[Style.values().length];
            r100[Style.TIP_HOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Style.ICON_HOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Style.COLOR_HOLDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Style.AUTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f448734a = r100;
        }
    }

    static {
    }

    public final Drawable a(Context r100) {
        ColorDrawable r101 = new ColorDrawable(UIUtils.getColor(r100, R.color.bg_float_overlay));
        r101.setBounds(0, 0, this.f448719b, this.f448720c);
        return r101;
    }

    public final Drawable b(Context r110) {
        if (this.f448719b >= UIUtils.dp2px(r110, 22.0f)) goto L5;
        return null;
    L5:
        if (this.f448720c < UIUtils.dp2px(r110, 22.0f)) goto L21;
        int r100 = com.ss.android.lark.widget.span.nopreview.a.f448735k;
        com.ss.android.lark.widget.span.nopreview.a.C5434a r101 = com.ss.android.lark.widget.span.nopreview.a.b.a(r110);
        if (this.f448722e == false) goto L17;
        r101.f448755j = UIUtils.getColor(r110, R.color.ud_border_color);
        float r102 = this.f448723f;
        if (r102 > 0.0f) goto L12;
        r102 = UIUtils.dp2px(r110, 6.0f);
    L12:
        r101.f448754i = r102;
        float r103 = this.f448724g;
        if (r103 > 0.0f) goto L16;
        r103 = UIUtils.dp2px(r110, 1.0f);
    L16:
        r101.f448753h = r103;
    L17:
        int r104 = this.f448719b;
        int r105 = this.f448720c;
        r101.f448750e = r104;
        r101.f448751f = r105;
        com.ss.android.lark.widget.span.nopreview.a r106 = r101.a();
        Drawable r107 = UDIconUtils.getIconDrawable(r110, R.drawable.ud_icon_ban_outlined, UDColorUtils.getColor(r110, R.color.icon_disable));
        r107.setBounds(0, 0, UIUtils.dp2px(r110, 20.0f), UIUtils.dp2px(r110, 20.0f));
        LayerDrawable r108 = new LayerDrawable(new Drawable[]{r106, r107});
        int r109 = r106.f448737b;
        int r111 = r106.f448738c;
        int r112 = (r109 - r107.getIntrinsicWidth()) / 2;
        int r113 = (r111 - r107.getIntrinsicHeight()) / 2;
        r108.setLayerInset(1, r112, r113, r112, r113);
        return r108;
    L21:
        return null;
    }

    public final com.ss.android.lark.widget.span.nopreview.a c(Context r100, int r101) {
        if (this.f448721d != null) goto L6;
        return null;
    L6:
        int r102 = com.ss.android.lark.widget.span.nopreview.a.f448735k;
        com.ss.android.lark.widget.span.nopreview.a.C5434a r103 = com.ss.android.lark.widget.span.nopreview.a.b.a(r100);
        String r104 = this.f448721d;
        Intrinsics.checkNotNullParameter(r104, "text");
        r103.f448752g = r104;
        Resources r105 = r103.f448746a.getResources();
        r103.f448749d = TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        if (this.f448722e == false) goto L17;
        r103.f448755j = UIUtils.getColor(r100, R.color.ud_border_color);
        float r106 = this.f448723f;
        if (r106 > 0.0f) goto L12;
        r106 = UIUtils.dp2px(r100, 6.0f);
    L12:
        r103.f448754i = r106;
        float r107 = this.f448724g;
        if (r107 > 0.0f) goto L16;
        r107 = UIUtils.dp2px(r100, 1.0f);
    L16:
        r103.f448753h = r107;
    L17:
        int r108 = this.f448719b;
        if (r108 <= 0) goto L23;
        int r109 = this.f448720c;
        if (r109 <= 0) goto L23;
        r103.f448750e = r108;
        r103.f448751f = r109;
    L23:
        return r103.a();
    }

    public UnAuthorizationDrawableWrapper(Style r100, int r101, int r102, String r103, boolean r104, float r105, float r106) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f448718a = r100;
        this.f448719b = r101;
        this.f448720c = r102;
        this.f448721d = r103;
        this.f448722e = r104;
        this.f448723f = r105;
        this.f448724g = r106;
    }
}
