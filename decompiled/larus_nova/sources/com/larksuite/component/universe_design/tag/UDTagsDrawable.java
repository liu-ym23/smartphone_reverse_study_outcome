package com.larksuite.component.universe_design.tag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class UDTagsDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f285312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f285313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f285314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f285315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f285316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f285317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f285318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f285319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f285320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f285321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<d> f285322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f285323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f285324m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagColorSet;", "", "backgroundColorRes", "", "textColorRes", "iconColorRes", "<init>", "(Ljava/lang/String;IIII)V", "getBackgroundColorRes", "()I", "getTextColorRes", "getIconColorRes", "GRAY", "BLUE", "INDIGO", "WATHET", "RAD", "GREEN", "ORANGE", "VIOLET", "PURPLE", "THROUGH", "LIME", "YELLOW", "CARMINE", "DARK_BLUE", "DARK_CARMINE", "DARK_RAD", "DARK_GRAY", "LIGHT_GRAY", "universe-ui-tag_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TagColorSet extends Enum<TagColorSet> {
        public static final TagColorSet BLUE = null;
        public static final TagColorSet CARMINE = null;
        public static final TagColorSet DARK_BLUE = null;
        public static final TagColorSet DARK_CARMINE = null;
        public static final TagColorSet DARK_GRAY = null;
        public static final TagColorSet DARK_RAD = null;
        public static final TagColorSet GRAY = null;
        public static final TagColorSet GREEN = null;
        public static final TagColorSet INDIGO = null;
        public static final TagColorSet LIGHT_GRAY = null;
        public static final TagColorSet LIME = null;
        public static final TagColorSet ORANGE = null;
        public static final TagColorSet PURPLE = null;
        public static final TagColorSet RAD = null;
        public static final TagColorSet THROUGH = null;
        public static final TagColorSet VIOLET = null;
        public static final TagColorSet WATHET = null;
        public static final TagColorSet YELLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TagColorSet[] f285325a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285326b = null;
        private final int backgroundColorRes;
        private final int iconColorRes;
        private final int textColorRes;

        public static EnumEntries<TagColorSet> getEntries() {
            return f285326b;
        }

        static {
            TagColorSet r100 = new TagColorSet("GRAY", 0, R.color.udtoken_tag_neutral_bg_normal, R.color.udtoken_tag_neutral_text_normal, R.color.udtoken_tag_neutral_text_normal);
            GRAY = r100;
            TagColorSet r101 = new TagColorSet("BLUE", 1, R.color.udtoken_tag_bg_blue, R.color.udtoken_tag_text_s_blue, R.color.udtoken_tag_text_s_blue);
            BLUE = r101;
            TagColorSet r102 = new TagColorSet("INDIGO", 2, R.color.udtoken_tag_bg_indigo, R.color.udtoken_tag_text_s_indigo, R.color.udtoken_tag_text_s_indigo);
            INDIGO = r102;
            TagColorSet r103 = new TagColorSet("WATHET", 3, R.color.udtoken_tag_bg_wathet, R.color.udtoken_tag_text_s_wathet, R.color.udtoken_tag_text_s_wathet);
            WATHET = r103;
            TagColorSet r104 = new TagColorSet("RAD", 4, R.color.udtoken_tag_bg_red, R.color.udtoken_tag_text_s_red, R.color.udtoken_tag_text_s_red);
            RAD = r104;
            TagColorSet r105 = new TagColorSet("GREEN", 5, R.color.udtoken_tag_bg_green, R.color.udtoken_tag_text_s_green, R.color.udtoken_tag_text_s_green);
            GREEN = r105;
            TagColorSet r106 = new TagColorSet("ORANGE", 6, R.color.udtoken_tag_bg_orange, R.color.udtoken_tag_text_s_orange, R.color.udtoken_tag_text_s_orange);
            ORANGE = r106;
            TagColorSet r110 = new TagColorSet("VIOLET", 7, R.color.udtoken_tag_bg_violet, R.color.udtoken_tag_text_s_violet, R.color.udtoken_tag_text_s_violet);
            VIOLET = r110;
            TagColorSet r107 = new TagColorSet("PURPLE", 8, R.color.udtoken_tag_bg_purple, R.color.udtoken_tag_text_s_purple, R.color.udtoken_tag_text_s_purple);
            PURPLE = r107;
            TagColorSet r108 = new TagColorSet("THROUGH", 9, R.color.udtoken_tag_bg_turquoise, R.color.udtoken_tag_text_s_turquoise, R.color.udtoken_tag_text_s_turquoise);
            THROUGH = r108;
            TagColorSet r109 = new TagColorSet("LIME", 10, R.color.udtoken_tag_bg_lime, R.color.udtoken_tag_text_s_lime, R.color.udtoken_tag_text_s_lime);
            LIME = r109;
            TagColorSet r111 = new TagColorSet("YELLOW", 11, R.color.udtoken_tag_bg_yellow, R.color.udtoken_tag_text_s_yellow, R.color.udtoken_tag_text_s_yellow);
            YELLOW = r111;
            TagColorSet r112 = new TagColorSet("CARMINE", 12, R.color.udtoken_tag_bg_carmine, R.color.udtoken_tag_text_s_carmine, R.color.udtoken_tag_text_s_carmine);
            CARMINE = r112;
            TagColorSet r113 = new TagColorSet("DARK_BLUE", 13, R.color.function_info_fill_hover, R.color.udtoken_tag_neutral_text_inverse, R.color.static_white);
            DARK_BLUE = r113;
            TagColorSet r210 = new TagColorSet("DARK_CARMINE", 14, R.color.ud_C400, R.color.udtoken_tag_neutral_text_inverse, R.color.static_white);
            DARK_CARMINE = r210;
            TagColorSet r114 = new TagColorSet("DARK_RAD", 15, R.color.function_danger_fill_hover, R.color.udtoken_tag_neutral_text_inverse, R.color.static_white);
            DARK_RAD = r114;
            TagColorSet r115 = new TagColorSet("DARK_GRAY", 16, R.color.udtoken_tag_neutral_bg_inverse, R.color.udtoken_tag_neutral_text_inverse, R.color.static_white);
            DARK_GRAY = r115;
            TagColorSet r116 = new TagColorSet("LIGHT_GRAY", 17, R.color.udtoken_tag_neutral_bg_solid, R.color.udtoken_tag_neutral_text_normal, R.color.udtoken_tag_neutral_text_normal);
            LIGHT_GRAY = r116;
            TagColorSet[] r117 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116};
            f285325a = r117;
            f285326b = EnumEntriesKt.enumEntries(r117);
        }

        public static TagColorSet[] values() {
            return (TagColorSet[]) f285325a.clone();
        }

        public final int getBackgroundColorRes() {
            return this.backgroundColorRes;
        }

        public final int getIconColorRes() {
            return this.iconColorRes;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public static TagColorSet valueOf(String r100) {
            return (TagColorSet) r27.a.a(TagColorSet.class, r100);
        }

        public TagColorSet(String r100, int r101, int r102, int r103, int r104) {
            super(r100, r101);
            this.backgroundColorRes = r102;
            this.textColorRes = r103;
            this.iconColorRes = r104;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f285327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f285328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f285329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f285330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f285331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f285332f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f285333g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f285334h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f285335i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<d> f285336j;

        public final UDTagsDrawable b() {
            if (((ArrayList) this.f285336j).isEmpty() == false) goto L6;
            return null;
        L6:
            return new UDTagsDrawable(this);
        }

        public final int hashCode() {
            return ((((((((((((0 + this.f285336j.hashCode()) * 31) + Float.floatToIntBits(this.f285328b)) * 31) + Float.floatToIntBits(this.f285329c)) * 31) + Float.floatToIntBits(this.f285330d)) * 31) + Float.floatToIntBits(this.f285331e)) * 31) + Float.floatToIntBits(this.f285333g)) * 31) + Float.floatToIntBits(this.f285334h);
        }

        public final Context getContext() {
            return this.f285327a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f285327a = r100;
            this.f285328b = h18.d.f(r100, 12.0f);
            this.f285329c = h18.d.a(r100, 4.0f);
            this.f285330d = h18.d.a(r100, 18.0f);
            this.f285331e = h18.d.a(r100, 18.0f);
            this.f285332f = Float.MAX_VALUE;
            this.f285333g = h18.d.a(r100, 4.0f);
            this.f285334h = h18.d.a(r100, 12.0f);
            this.f285336j = new ArrayList(2);
        }

        public final void a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            ((ArrayList) this.f285336j).add(r100);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.Builder");
            a r102 = (a) r100;
            if (Intrinsics.areEqual(this.f285336j, r102.f285336j) == true) goto L16;
            return false;
        L16:
            if (this.f285328b != r102.f285328b) goto L18;
            boolean r103 = true;
        L19:
            if (r103 == true) goto L22;
            return false;
        L22:
            if (this.f285329c != r102.f285329c) goto L24;
            boolean r104 = true;
        L25:
            if (r104 == true) goto L28;
            return false;
        L28:
            if (this.f285330d != r102.f285330d) goto L30;
            boolean r105 = true;
        L31:
            if (r105 == true) goto L34;
            return false;
        L34:
            if (this.f285331e != r102.f285331e) goto L36;
            boolean r106 = true;
        L37:
            if (r106 == true) goto L40;
            return false;
        L40:
            if (this.f285333g != r102.f285333g) goto L42;
            boolean r107 = true;
        L43:
            if (r107 == true) goto L46;
            return false;
        L46:
            if (this.f285334h != r102.f285334h) goto L48;
            boolean r108 = true;
        L49:
            if (r108 == true) goto L51;
            return false;
        L51:
            return true;
        L48:
            r108 = false;
            goto L49
        L42:
            r107 = false;
            goto L43
        L36:
            r106 = false;
            goto L37
        L30:
            r105 = false;
            goto L31
        L24:
            r104 = false;
            goto L25
        L18:
            r103 = false;
            goto L19
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c extends GradientDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f285337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f285338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f285339c;

        public final int hashCode() {
            return (((this.f285337a * 31) + Float.floatToIntBits(this.f285338b)) * 31) + this.f285339c;
        }

        public c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(c.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.SimpleGradientDrawable");
            c r102 = (c) r100;
            if (this.f285337a == r102.f285337a) goto L16;
            return false;
        L16:
            if (this.f285338b != r102.f285338b) goto L18;
            boolean r103 = true;
        L19:
            if (r103 == true) goto L22;
            return false;
        L22:
            if (this.f285339c == r102.f285339c) goto L24;
            return false;
        L24:
            return true;
        L18:
            r103 = false;
            goto L19
        L8:
            r101 = null;
            goto L10
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setColor(int r100) {
            super.setColor(r100);
            this.f285339c = r100;
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setCornerRadius(float r100) {
            super.setCornerRadius(r100);
            this.f285338b = r100;
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setShape(int r100) {
            super.setShape(r100);
            this.f285337a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f285340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f285341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f285342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable f285343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f285344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Drawable f285345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f285346g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f285347h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f285348i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Rect f285349j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Rect f285350k;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f285351a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f285352b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f285353c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f285354d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Drawable f285355e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Integer f285356f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Drawable f285357g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f285358h;

            public final d b() {
                Drawable r100 = this.f285355e;
                if (r100 == null) goto L8;
                Integer r101 = this.f285356f;
                if (r101 == null) goto L8;
                int r102 = r101.intValue();
                r100.mutate();
                r100.setTint(r102);
            L8:
                return new d(this);
            }

            public a(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                this.f285351a = r100;
                this.f285352b = 10;
                this.f285354d = UDColorUtils.getColor(r100, R.color.udtoken_tag_neutral_text_inverse);
            }

            public final void a(int r100) {
                Drawable r101 = this.f285357g;
                if (r101 != null) goto L5;
            L6:
                c r102 = new c();
                r102.setShape(0);
                r102.setCornerRadius(h18.d.a(this.f285351a, 4.0f));
                this.f285357g = r102;
            L7:
                Drawable r103 = this.f285357g;
                if (r103 != null) goto L10;
                return;
            L10:
                if ((r103 instanceof GradientDrawable) == false) goto L14;
                ((GradientDrawable) r103).setColor(r100);
                return;
            L14:
                return;
            L5:
                if ((r101 instanceof c) == true) goto L7;
                goto L6
            }

            public final void c(TagColorSet r100) {
                Intrinsics.checkNotNullParameter(r100, "colorSet");
                a(UDColorUtils.getColor(this.f285351a, r100.getBackgroundColorRes()));
                this.f285354d = UDColorUtils.getColor(this.f285351a, r100.getTextColorRes());
                this.f285356f = Integer.valueOf(UDColorUtils.getColor(this.f285351a, r100.getIconColorRes()));
            }
        }

        public final int hashCode() {
            int r100 = this.f285340a * 31;
            String r101 = this.f285341b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (((r100 + r103) * 31) + this.f285342c) * 31;
            Drawable r105 = this.f285343d;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            Integer r108 = this.f285344e;
            if (r108 == null) goto L13;
            int r109 = r108.intValue();
        L14:
            int r110 = (r107 + r109) * 31;
            Drawable r111 = this.f285345f;
            if (r111 == null) goto L18;
            r102 = r111.hashCode();
        L18:
            return r110 + r102;
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public d(a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.f285348i = true;
            this.f285349j = new Rect();
            Rect r101 = new Rect();
            this.f285350k = r101;
            this.f285340a = r100.f285352b;
            this.f285341b = r100.f285353c;
            this.f285342c = r100.f285354d;
            this.f285343d = r100.f285355e;
            this.f285344e = r100.f285356f;
            Drawable r102 = r100.f285357g;
            this.f285345f = r102;
            this.f285346g = r100.f285358h;
            if (r102 == null) goto L6;
            r101.set(r102.getBounds());
            return;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(d.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable.TagModel");
            d r102 = (d) r100;
            if (this.f285340a == r102.f285340a) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f285341b, r102.f285341b) == true) goto L19;
            return false;
        L19:
            if (this.f285342c == r102.f285342c) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f285343d, r102.f285343d) == true) goto L25;
            return false;
        L25:
            if (Intrinsics.areEqual(this.f285344e, r102.f285344e) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.f285345f, r102.f285345f) == true) goto L30;
            return false;
        L30:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((d) r100).f285340a), Integer.valueOf(((d) r101).f285340a));
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final TextPaint a() {
        return (TextPaint) this.f285321j.getValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f285323l.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f285323l.width();
    }

    public final int hashCode() {
        return this.f285312a.hashCode();
    }

    public UDTagsDrawable(a r100) {
        this.f285312a = r100;
        this.f285321j = LazyKt.lazy(new UDTagsDrawable$textPaint$2(this));
        this.f285323l = new Rect();
        this.f285324m = new Rect();
        this.f285313b = r100.f285328b;
        this.f285314c = r100.f285329c;
        this.f285315d = r100.f285330d;
        this.f285316e = r100.f285331e;
        this.f285317f = r100.f285332f;
        this.f285318g = r100.f285333g;
        this.f285319h = r100.f285334h;
        this.f285320i = r100.f285335i;
        ArrayList r101 = (ArrayList) r100.f285336j;
        if (r101.size() <= 1) goto L5;
        CollectionsKt.sortWith(r101, new e());
    L5:
        this.f285322k = r100.f285336j;
        b(true);
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    public final void b(boolean r110) {
        a().setTextSize(this.f285313b);
        List<d> r100 = this.f285322k;
        ?? r101 = 0;
        if (r100 == null) goto L51;
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r102.hasNext() == false) goto L52;
        d r106 = (d) r102.next();
        Rect r107 = new Rect(r105, r101, r105, r101);
        int r108 = Integer.MAX_VALUE;
        if (this.f285320i == true) goto L10;
    L12:
        float r109 = Math.min(r108, this.f285317f);
        float r111 = this.f285316e;
        float r112 = this.f285315d;
        r106.f285348i = true;
        r106.f285347h = null;
        if (r109 > 0.0f) goto L15;
        r106.f285348i = r101;
        r106.f285347h = null;
    L50:
        r106.f285349j.set(r107);
        r103 = r107.right;
        r105 = (int) (r103 + this.f285318g);
        r104 = Math.max(r104, r107.bottom);
        r101 = 0;
        goto L6
    L15:
        Drawable r113 = r106.f285343d;
        if (r113 == null) goto L21;
        float r114 = this.f285319h;
        float r115 = Math.max(r111, r114);
        if (r115 <= r109) goto L20;
        r106.f285348i = r101;
    L20:
        float r116 = Math.min(r115, r109);
        r112 = Math.max(r112, r114);
        int r117 = r107.left;
        r107.set(r117, r107.top, ((int) Math.ceil(r116)) + r117, r107.top + ((int) Math.ceil(r112)));
        float r118 = 2;
        float r119 = (r116 - r114) / r118;
        float r120 = (r112 - r114) / r118;
        r113.setBounds(r107.left + ((int) Math.ceil(r119)), (int) Math.ceil(r107.top + r120), (int) Math.ceil(r107.right - r119), (int) Math.ceil(r107.bottom - r120));
        float r121 = r116;
        r106 = r106;
    L22:
        String r122 = r106.f285341b;
        if (r122 == null) goto L38;
        Paint.FontMetrics r123 = a().getFontMetrics();
        float r124 = a().measureText(r122, 0, r122.length());
        float r125 = r123.descent - r123.ascent;
        if (((int) r116) != 0) goto L27;
        float r126 = this.f285314c;
        float r127 = r116 + (((int) r126) * 2);
        r121 = Math.max(r121, r124 + (r126 * 2));
    L29:
        if (r121 <= r109) goto L37;
        float r128 = r109 - r127;
        if (r128 <= 0.0f) goto L36;
        String r129 = TextUtils.ellipsize(r122, a(), r128, TextUtils.TruncateAt.END).toString();
        r106.f285347h = r129;
        float r130 = r127 + a().measureText(r129, 0, r129.length());
        if (StringsKt.isBlank(r129) == false) goto L35;
        r106.f285348i = false;
    L35:
        r121 = r130;
        goto L37
    L36:
        r106.f285347h = "";
        r106.f285348i = false;
    L37:
        r112 = Math.max(r112, r125);
        goto L38
    L27:
        float r131 = this.f285314c;
        r127 = r116 + ((int) r131);
        r121 = r121 + (r124 + r131);
    L38:
        Drawable r132 = r106.f285345f;
        if (r132 != null) goto L41;
    L49:
        int r133 = r107.left;
        r107.set(r133, r107.top, ((int) Math.ceil(r121)) + r133, r107.top + ((int) Math.ceil(r112)));
        goto L50
    L41:
        if (r106.f285350k.isEmpty() == false) goto L43;
        int r134 = r132.getIntrinsicWidth();
    L45:
        if (r106.f285350k.isEmpty() == false) goto L47;
        int r135 = r132.getIntrinsicHeight();
    L48:
        r121 = Math.min(Math.max(r121, r134), this.f285317f);
        r112 = Math.max(r112, r135);
        int r136 = r107.left;
        r132.setBounds(r136, r107.top, ((int) Math.ceil(r121)) + r136, r107.top + ((int) Math.ceil(r112)));
        goto L49
    L47:
        r135 = r106.f285350k.height();
        goto L48
    L43:
        r134 = r106.f285350k.width();
        goto L45
    L21:
        r121 = r111;
        r116 = 0.0f;
        goto L22
    L10:
        if (getBounds().isEmpty() == true) goto L12;
        r108 = getBounds().right - r105;
    L52:
        this.f285324m.set(0, 0, r103, r104);
        if (r110 == false) goto L59;
        this.f285323l.set(0, 0, r103, r104);
        super.setBounds(0, 0, r103, r104);
        invalidateSelf();
        return;
    L59:
        return;
    L51:
        r103 = 0;
        r104 = 0;
        goto L52
    }

    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Drawable[] r101 = r100.getCompoundDrawables();
        if (Intrinsics.areEqual(r101[2], this) == true) goto L6;
        r100.setCompoundDrawablePadding((int) h18.d.a(this.f285312a.getContext(), 4.0f));
        r100.setCompoundDrawables(r101[0], r101[1], this, r101[3]);
        return;
    }

    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(r100.getBackground(), this) == true) goto L6;
        r100.setBackground(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        List<d> r101 = this.f285322k;
        if (r101 == null) goto L23;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L30;
        d r103 = (d) r102.next();
        if (r103.f285348i == false) goto L9;
        Rect r104 = r103.f285349j;
        int r105 = r104.left;
        Drawable r106 = r103.f285345f;
        if (r106 == null) goto L13;
        r106.draw(r100);
    L13:
        Drawable r107 = r103.f285343d;
        if (r107 == null) goto L16;
        r107.draw(r100);
        r105 = r107.getBounds().right;
    L16:
        String r108 = r103.f285341b;
        if (r108 == null) goto L6;
        a().setTextSize(this.f285313b);
        a().setColor(r103.f285342c);
        a().setStrikeThruText(r103.f285346g);
        Paint.FontMetrics r109 = a().getFontMetrics();
        float r110 = (r109.ascent + r109.descent) / 2;
        String r111 = r103.f285347h;
        if (r111 == null) goto L22;
        r108 = r111;
    L22:
        r100.drawText(r108, (r105 + r104.right) / 2.0f, r104.exactCenterY() - r110, a());
        goto L6
    L9:
        return;
    L30:
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(UDTagsDrawable.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.universe_design.tag.UDTagsDrawable");
        UDTagsDrawable r102 = (UDTagsDrawable) r100;
        if (this.f285313b != r102.f285313b) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L19;
        return false;
    L19:
        if (this.f285314c != r102.f285314c) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == true) goto L25;
        return false;
    L25:
        if (this.f285315d != r102.f285315d) goto L27;
        boolean r105 = true;
    L28:
        if (r105 == true) goto L31;
        return false;
    L31:
        if (this.f285316e != r102.f285316e) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == true) goto L37;
        return false;
    L37:
        if (this.f285317f != r102.f285317f) goto L39;
        boolean r107 = true;
    L40:
        if (r107 == true) goto L43;
        return false;
    L43:
        if (this.f285318g != r102.f285318g) goto L45;
        boolean r108 = true;
    L46:
        if (r108 == true) goto L49;
        return false;
    L49:
        if (this.f285319h != r102.f285319h) goto L51;
        boolean r109 = true;
    L52:
        if (r109 == true) goto L55;
        return false;
    L55:
        if (Intrinsics.areEqual(this.f285322k, r102.f285322k) == true) goto L57;
        return false;
    L57:
        return true;
    L51:
        r109 = false;
        goto L52
    L45:
        r108 = false;
        goto L46
    L39:
        r107 = false;
        goto L40
    L33:
        r106 = false;
        goto L34
    L27:
        r105 = false;
        goto L28
    L21:
        r104 = false;
        goto L22
    L15:
        r103 = false;
        goto L16
    L8:
        r101 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        b(false);
    }
}
