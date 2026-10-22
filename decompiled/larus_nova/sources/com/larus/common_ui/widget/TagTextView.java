package com.larus.common_ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import z19.a0;
import z19.y;
import z19.z;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002!\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u001a\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/common_ui/widget/TagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "orangeStyle", "Lcom/larus/common_ui/widget/TagTextView$TagStyleData;", "getOrangeStyle", "()Lcom/larus/common_ui/widget/TagTextView$TagStyleData;", "orangeStyle$delegate", "Lkotlin/Lazy;", "blueStyle", "getBlueStyle", "blueStyle$delegate", "blueStyleForImmerse", "getBlueStyleForImmerse", "blueStyleForImmerse$delegate", "setTagFromFreeStyle", "tagName", "", "darkMode", "", "fontColor", "backgroundColor", "edgeColor", "setTag", "style", "Lcom/larus/common_ui/widget/TagTextView$TagStyle;", "TagStyleData", "TagStyle", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f328538d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f328539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f328540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f328541c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/widget/TagTextView$TagStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BLUE", "BLUE_IMMERSE", "ORANGE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TagStyle extends Enum<TagStyle> {
        public static final TagStyle BLUE = null;
        public static final TagStyle BLUE_IMMERSE = null;
        public static final TagStyle ORANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TagStyle[] f328542a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f328543b = null;

        public static EnumEntries<TagStyle> getEntries() {
            return f328543b;
        }

        static {
            TagStyle r100 = new TagStyle("BLUE", 0);
            BLUE = r100;
            TagStyle r101 = new TagStyle("BLUE_IMMERSE", 1);
            BLUE_IMMERSE = r101;
            TagStyle r102 = new TagStyle("ORANGE", 2);
            ORANGE = r102;
            TagStyle[] r103 = {r100, r101, r102};
            f328542a = r103;
            f328543b = EnumEntriesKt.enumEntries(r103);
        }

        public static TagStyle[] values() {
            return (TagStyle[]) f328542a.clone();
        }

        public static TagStyle valueOf(String r100) {
            return (TagStyle) r27.a.a(TagStyle.class, r100);
        }

        public TagStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f328544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f328545b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f328544a == r101.f328544a) goto L12;
            return false;
        L12:
            if (this.f328545b == r101.f328545b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f328544a * 31) + this.f328545b;
        }

        public final String toString() {
            return "TagStyleData(textColor=" + this.f328544a + ", bgDrawable=" + this.f328545b + ')';
        }

        public a(int r100, int r101) {
            this.f328544a = r100;
            this.f328545b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328546a = null;

        static {
            int[] r100 = new int[TagStyle.values().length];
            r100[TagStyle.BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TagStyle.ORANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TagStyle.BLUE_IMMERSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f328546a = r100;
        }
    }

    public TagTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TagTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final a getBlueStyle() {
        return (a) this.f328540b.getValue();
    }

    private final a getBlueStyleForImmerse() {
        return (a) this.f328541c.getValue();
    }

    private final a getOrangeStyle() {
        return (a) this.f328539a.getValue();
    }

    @Deprecated(message = "deprecated for setTag by tag info ui kit")
    public final void x(String r100, TagStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "tagName");
        Intrinsics.checkNotNullParameter(r101, "style");
        int r102 = b.f328546a[r101.ordinal()];
        if (r102 != 1) goto L5;
        a r103 = getBlueStyle();
    L13:
        setText(r100);
        setTextColor(ContextCompat.getColor(getContext(), r103.f328544a));
        setBackground(ContextCompat.getDrawable(getContext(), r103.f328545b));
        return;
    L5:
        if (r102 != 2) goto L7;
        r103 = getOrangeStyle();
        goto L13
    L7:
        if (r102 != 3) goto L10;
        r103 = getBlueStyleForImmerse();
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public TagTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328539a = LazyKt.lazy(new y());
        this.f328540b = LazyKt.lazy(new z());
        this.f328541c = LazyKt.lazy(new a0());
        setTextSize(11.0f);
        setTypeface(getTypeface(), 1);
        setPadding(i5.j0(), 0, i5.j0(), 0);
        setGravity(16);
    }

    public /* synthetic */ TagTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void y(String r100, boolean r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "tagName");
        setText(r100);
        GradientDrawable r105 = null;
        if (r101 == false) goto L7;
        Drawable r106 = ContextCompat.getDrawable(getContext(), R.drawable.larus_bg_tag_textview_blue_immerse);
        if (r106 == null) goto L10;
        Drawable r107 = r106.mutate();
    L11:
        if (r102 != 0) goto L15;
        if (r103 != 0) goto L15;
        if (r104 != 0) goto L15;
        setTextColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    L22:
        setBackground(r107);
        return;
    L15:
        setTextColor(r102);
        if (r107 == null) goto L22;
        if ((r107 instanceof GradientDrawable) == false) goto L20;
        r105 = (GradientDrawable) r107;
    L20:
        if (r105 == null) goto L22;
        r105.setColor(r103);
        r105.setStroke(1, r104);
        Unit r108 = Unit.INSTANCE;
    L10:
        r107 = null;
        goto L11
    L7:
        Drawable r109 = ContextCompat.getDrawable(getContext(), c.b(R.attr.larus_bg_tag_textview_blue, getContext(), R.drawable.larus_bg_tag_textview_blue));
        if (r109 == null) goto L10;
        r107 = r109.mutate();
        goto L11
    }
}
