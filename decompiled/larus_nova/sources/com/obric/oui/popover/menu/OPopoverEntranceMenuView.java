package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.nova.R;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "", "maxHeight", "", "setPopoverMaxHeight", "getAvailableItemWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Builder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPopoverEntranceMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f402261w = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super View, Unit> f402262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<b> f402263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f402264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f402265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f402269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f402270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super Integer, ? extends Drawable> f402271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Integer, ? extends Drawable> f402272o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f402273p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f402274q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Pair<Integer, Integer> f402275r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f402276s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f402277t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f402278u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MaxHeightNestedScrollView f402279v;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f402280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super View, Unit> f402281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<b> f402282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f402283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f402284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function1<? super Integer, ? extends Drawable> f402285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super Integer, ? extends Drawable> f402286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f402287h;

        public final OPopoverEntranceMenuView e() {
            OPopoverEntranceMenuView r100 = new OPopoverEntranceMenuView(this.f402280a, null, 6, 0);
            r100.f402263f = this.f402282c;
            r100.setPressedWithArrow(false);
            r100.setForceDark(false);
            r100.f402262e = this.f402281b;
            r100.f402266i = 0;
            r100.f402267j = 0;
            r100.f402269l = 0;
            r100.f402264g = null;
            r100.f402265h = null;
            r100.f402270m = this.f402284e;
            r100.f402271n = this.f402285f;
            r100.f402272o = this.f402286g;
            r100.f402275r = null;
            r100.f402278u = this.f402287h;
            r100.f402268k = this.f402283d;
            r100.d();
            return r100;
        }

        public final Context getContext() {
            return this.f402280a;
        }

        public Builder(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f402280a = r100;
            this.f402281b = OPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE;
            this.f402282c = new ArrayList();
            int r101 = OPopoverEntranceMenuView.f402261w;
            this.f402283d = d.c(r100, 184);
        }

        public final void f(WidthLevel r100) {
            Intrinsics.checkNotNullParameter(r100, "level");
            this.f402283d = d.c(this.f402280a, r100.getValue());
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final void b(Integer r110, Integer r111, Integer r112, CharSequence r113, CharSequence r114, CharSequence r115, boolean r116, Function2 r210) {
            a(0, false, r110, r111, r112, r113, r114, r115, r116, null, r210);
        }

        @Deprecated(message = "请使用 addStartOptionItem() 替代")
        public final void c(Integer r110, Integer r111, Integer r112, CharSequence r113, CharSequence r114, boolean r115, boolean r210, boolean r211, Function2 r212) {
            if (r211 == false) goto L4;
            int r100 = 5;
        L5:
            a(r100, r210, r110, r111, r112, r113, r114, null, r115, null, r212);
            return;
        L4:
            r100 = 1;
            goto L5
        }

        public static void d(Builder r110, Integer r111, Integer r112, Integer r113, CharSequence r210, CharSequence r211, boolean r212, boolean r213, Function2 r214, int r215) {
            boolean r100 = false;
            if ((r215 & 1) == 0) goto L5;
            Integer r101 = 0;
        L7:
            if ((r215 & 2) == 0) goto L9;
            Integer r102 = 0;
        L11:
            if ((r215 & 4) == 0) goto L13;
            Integer r103 = 0;
        L15:
            if ((r215 & 8) == 0) goto L17;
            CharSequence r114 = "";
        L19:
            if ((r215 & 16) == 0) goto L21;
            CharSequence r115 = null;
        L23:
            if ((r215 & 64) == 0) goto L25;
            boolean r104 = true;
        L27:
            if ((r215 & 128) != 0) goto L31;
            r100 = r213;
        L31:
            if ((r215 & 2048) == 0) goto L33;
            Function2 r116 = null;
        L34:
            if (r100 == false) goto L36;
            int r105 = 5;
        L37:
            r110.a(r105, r104, r101, r102, r103, r114, r115, null, false, null, r116);
            return;
        L36:
            r105 = 1;
            goto L37
        L33:
            r116 = r214;
            goto L34
        L25:
            r104 = r212;
            goto L27
        L21:
            r115 = r211;
            goto L23
        L17:
            r114 = r210;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }

        public final void a(int r110, boolean r111, Integer r112, Integer r210, Integer r211, CharSequence r212, CharSequence r213, CharSequence r214, boolean r215, Integer r216, Function2 r217) {
            if (this.f402284e <= 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L11;
            if (r110 != 0) goto L11;
            throw new IllegalArgumentException("option menu item 请使用 addStartOptionItem() 或者 addEndOptionItem()");
        L11:
            if (r100 == true) goto L16;
            if (r110 == 0) goto L16;
            throw new IllegalArgumentException("menu item 请不要使用 addStartOptionItem() 或者 addEndOptionItem()");
        L16:
            ArrayList<b> r113 = this.f402282c;
            if (r112 != null) goto L19;
            int r101 = 0;
        L20:
            if (r210 != null) goto L22;
            int r102 = 0;
        L23:
            if (r211 != null) goto L25;
            int r103 = 0;
        L26:
            r113.add(new b(r110, r111, r101, r102, r103, r212, r213, r214, r215, true, r217, 0, r216));
            return;
        L25:
            r103 = r211.intValue();
            goto L26
        L22:
            r102 = r210.intValue();
            goto L23
        L19:
            r101 = r112.intValue();
            goto L20
        L5:
            r100 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", "", "value", "I", "getValue", "()I", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum WidthLevel extends Enum<WidthLevel> {
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidthLevel[] f402289a = null;
        private final int value;

        public static WidthLevel valueOf(String r100) {
            return (WidthLevel) r27.a.a(WidthLevel.class, r100);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) f402289a.clone();
        }

        static {
            int r100 = OPopoverEntranceMenuView.f402261w;
            WidthLevel r101 = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, 184);
            WIDTH_LEVEL_STANDARD = r101;
            WidthLevel r102 = new WidthLevel("WIDTH_LEVEL_BROAD", 1, 208);
            WIDTH_LEVEL_BROAD = r102;
            f402289a = new WidthLevel[]{r101, r102};
        }

        public final int getValue() {
            return this.value;
        }

        public WidthLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f402290n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f402291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f402292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f402293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f402294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f402295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CharSequence f402296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final CharSequence f402297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CharSequence f402298h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f402299i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f402300j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function2<? super View, ? super Integer, Unit> f402301k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f402302l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Integer f402303m;

        public static final class a {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            CharSequence r100 = null;
            Object[] r101 = 0 == true ? 1 : 0;
            this(r100, false, r101, 16383);
        }

        static {
            CharSequence r100 = null;
            boolean r101 = false;
            f402290n = new b(r100, r101, 1, 14335);
        }

        public /* synthetic */ b(CharSequence r110, boolean r111, int r112, int r113) {
            if ((r113 & 32) == 0) goto L5;
            CharSequence r100 = "";
        L7:
            if ((r113 & 512) == 0) goto L9;
            boolean r114 = true;
        L11:
            if ((r113 & 2048) == 0) goto L13;
            int r115 = 0;
        L14:
            this(0, false, 0, 0, 0, r100, null, null, false, r114, null, r115, null);
            return;
        L13:
            r115 = r112;
            goto L14
        L9:
            r114 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }

        public b(int r100, boolean r101, int r102, int r103, int r104, CharSequence r105, CharSequence r106, CharSequence r107, boolean r108, boolean r110, Function2 r111, int r112, Integer r113) {
            this.f402291a = r100;
            this.f402292b = r101;
            this.f402293c = r102;
            this.f402294d = r103;
            this.f402295e = r104;
            this.f402296f = r105;
            this.f402297g = r106;
            this.f402298h = r107;
            this.f402299i = r108;
            this.f402300j = r110;
            this.f402301k = r111;
            this.f402302l = r112;
            this.f402303m = r113;
        }
    }

    static {
    }

    public OPopoverEntranceMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPopoverEntranceMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void d() {
        int r100 = 1;
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.o_view_popover_menu_type, this, true);
        MaxHeightNestedScrollView r101 = (MaxHeightNestedScrollView) findViewById(R.id.popover_scroll);
        this.f402279v = r101;
        if (r101 == null) goto L6;
        r101.setMaxHeight(this.f402277t);
    L6:
        MaxHeightNestedScrollView r102 = this.f402279v;
        boolean r103 = false;
        if (r102 == null) goto L10;
        int r104 = this.f402273p;
        r102.setPadding(0, r104, 0, r104);
    L10:
        MaxHeightNestedScrollView r105 = this.f402279v;
        if (r105 == null) goto L14;
        r105.setScrollBarStyle(33554432);
    L14:
        MaxHeightNestedScrollView r106 = this.f402279v;
        if (r106 == null) goto L18;
        r106.setClipToPadding(false);
    L18:
        int r110 = -1;
        int r111 = -2;
        if (this.f402264g == null) goto L28;
        ViewGroup r107 = (ViewGroup) findViewById(R.id.top_container);
        r107.addView(this.f402264g, new ViewGroup.LayoutParams(-1, -2));
        if (this.f402275r == null) goto L23;
        r107.getLayoutParams().width = -2;
    L24:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        int r109 = this.f402266i;
        if (r109 != 0) goto L27;
        r109 = -2;
    L27:
        r108.height = r109;
        goto L28
    L23:
        ViewGroup.LayoutParams r112 = r107.getLayoutParams();
        r112.width = getAvailableItemWidth();
    L28:
        LinearLayout r113 = (LinearLayout) findViewById(R.id.popover_container);
        Iterator r114 = this.f402263f.iterator();
        int r115 = 0;
        int r116 = 0;
    L30:
        if (r114.hasNext() == false) goto L214;
        Object r117 = r114.next();
        r115 = r115 + 1;
        if (r115 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        final b r118 = (b) r117;
        int r119 = r118.f402302l;
        if (r119 == r100) goto L36;
        if (r119 == 2) goto L39;
        int r120 = r118.f402291a;
        if ((r120 & 1) == 0) goto L48;
        boolean r121 = true;
    L49:
        if (r121 == false) goto L51;
    L57:
        boolean r122 = true;
    L59:
        if (r122 == false) goto L65;
        View r123 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_filter, r113, r103);
        if (r123 == null) goto L64;
        PopoverMenuLinearLayout r124 = (PopoverMenuLinearLayout) r123;
    L68:
        final PopoverMenuLinearLayout r125 = r124;
        OStateGradientDrawable r126 = new OStateGradientDrawable();
        r126.setCornerRadius(d.e(getContext(), 20));
        ColorStateList r127 = ContextCompat.getColorStateList(getContext(), R.color.o_pop_list_item_bg_color);
        Intrinsics.checkNotNull(r127);
        r126.setSolidColors(r127);
        r125.setBackground(r126);
        LinearLayout r128 = (LinearLayout) r125.findViewById(R.id.item_container);
        ImageView r129 = (ImageView) r125.findViewById(R.id.iv_popover_action);
        ImageView r130 = (ImageView) r125.findViewById(R.id.iv_popover_tail_image);
        OTextView r131 = (OTextView) r125.findViewById(R.id.tv_popover_action);
        OTextView r132 = (OTextView) r125.findViewById(R.id.tv_popover_action_sub);
        OTextView r133 = (OTextView) r125.findViewById(R.id.tv_popover_value);
        if (r122 == false) goto L71;
        CheckableImageView r134 = (CheckableImageView) r125.findViewById(R.id.popover_menu_radio);
    L72:
        r125.findViewById(R.id.popover_badge_default);
        OBadgeView r135 = (OBadgeView) r125.findViewById(R.id.popover_badge_number);
        OBadgeView r136 = (OBadgeView) r125.findViewById(R.id.popover_badge_ellipsis);
        LinearLayout r137 = (LinearLayout) r125.findViewById(R.id.ll_popover_text_container);
        if (r134 != null) goto L76;
    L80:
        final CheckableImageView r210 = r134;
        final LinearLayout r138 = r113;
        Iterator r211 = r114;
        LinearLayout r212 = r113;
        final int r139 = r116;
        r125.setOnClickListener(new com.obric.oui.popover.menu.a(r118, r210, r138, this, r139));
        if (this.f402275r == null) goto L83;
        r125.getLayoutParams().width = -2;
    L85:
        if (r118.f402297g != null) goto L90;
        int r140 = 8;
        r132.setVisibility(8);
        ViewGroup.LayoutParams r141 = r125.getLayoutParams();
        int r142 = this.f402269l;
        if (r142 != 0) goto L89;
        r142 = -2;
    L89:
        r141.height = r142;
    L94:
        r132.setText(r118.f402297g);
        r133.setText(r118.f402298h);
        if (TextUtils.isEmpty(r118.f402298h) == false) goto L97;
        int r143 = 8;
    L98:
        r133.setVisibility(r143);
        if (this.f402263f.size() != 1) goto L108;
        r125.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        ViewGroup.LayoutParams r144 = r125.getLayoutParams();
        if ((r144 instanceof LinearLayout.LayoutParams) == false) goto L103;
        LinearLayout.LayoutParams r145 = (LinearLayout.LayoutParams) r144;
    L104:
        if (r145 == null) goto L126;
        r145.topMargin = 0;
        r145.bottomMargin = 0;
        Unit r146 = Unit.INSTANCE;
    L126:
        Intrinsics.checkNotNullParameter(r125, "itemView");
        if (this.f402306b == false) goto L130;
        r125.setNotifyPressedCallback(new OPopoverMenuView$registerPressedCallback$1(this, r125));
    L130:
        if (r118.f402293c == 0) goto L135;
        ImageView r147 = r129;
        r147.setVisibility(0);
        Function1<? super Integer, ? extends Drawable> r148 = this.f402271n;
        if (r148 == null) goto L134;
        r147.setImageDrawable(r148.invoke(Integer.valueOf(r118.f402293c)));
    L137:
        if (r118.f402294d == 0) goto L142;
        ImageView r149 = r130;
        r149.setVisibility(0);
        Function1<? super Integer, ? extends Drawable> r150 = this.f402272o;
        if (r150 == null) goto L141;
        r149.setImageDrawable(r150.invoke(Integer.valueOf(r118.f402294d)));
    L143:
        CharSequence r151 = r118.f402296f;
        if (r151 == null) goto L146;
        r131.setText(r151);
    L146:
        r131.setSingleLine(this.f402278u);
        r131.setEllipsize(TextUtils.TruncateAt.END);
        if (this.f402278u == false) goto L149;
        int r152 = 1;
    L150:
        r131.setMaxLines(r152);
        int r153 = r118.f402295e;
        if (r153 == 0) goto L153;
        r147.setImageTintList(ColorStateList.valueOf(r153));
        r149.setImageTintList(ColorStateList.valueOf(r118.f402295e));
    L153:
        Integer r154 = r118.f402303m;
        if (r154 == null) goto L158;
        r131.setTextColor(r154.intValue());
        Unit r155 = Unit.INSTANCE;
    L158:
        if (getForceDark() == false) goto L162;
        int r156 = ContextCompat.getColor(getContext(), R.color.ConstTextInverse2);
        r131.setTextColor(r156);
        r147.setImageTintList(ColorStateList.valueOf(r156));
        r149.setImageTintList(ColorStateList.valueOf(r156));
        r125.setForceDark(true);
    L162:
        if (r118.f402299i == false) goto L165;
        int r157 = ContextCompat.getColor(getContext(), R.color.Negative);
        r131.setTextColor(r157);
        r147.setImageTintList(ColorStateList.valueOf(r157));
    L165:
        if (r210 == null) goto L206;
        int r158 = r118.f402295e;
        if (r158 != 0) goto L171;
        r158 = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
    L171:
        r210.setImageTintList(ColorStateList.valueOf(r158));
        r210.setVisibility(0);
        if ((r118.f402291a & 4) == 0) goto L174;
        boolean r159 = true;
    L175:
        r210.setChecked(r159);
        if ((r118.f402291a & 2) == 0) goto L178;
        boolean r160 = true;
    L179:
        if (r160 == false) goto L205;
        ViewGroup.LayoutParams r161 = r210.getLayoutParams();
        if ((r161 instanceof LinearLayout.LayoutParams) == false) goto L183;
        LinearLayout.LayoutParams r162 = (LinearLayout.LayoutParams) r161;
    L184:
        if (r162 == null) goto L187;
        r162.setMarginStart(0);
        r162.setMarginEnd(d.c(getContext(), r140));
        Unit r163 = Unit.INSTANCE;
    L187:
        r128.removeView(r210);
        r128.addView(r210);
        ViewGroup.LayoutParams r164 = r147.getLayoutParams();
        if ((r164 instanceof LinearLayout.LayoutParams) == false) goto L190;
        LinearLayout.LayoutParams r165 = (LinearLayout.LayoutParams) r164;
    L192:
        if (r165 == null) goto L196;
        r165.setMarginStart(d.c(getContext(), 12));
        Unit r166 = Unit.INSTANCE;
    L196:
        if (r147.getVisibility() != r140) goto L205;
        if (r137 == null) goto L205;
        ViewGroup.LayoutParams r167 = r137.getLayoutParams();
        if ((r167 instanceof LinearLayout.LayoutParams) == false) goto L201;
        LinearLayout.LayoutParams r168 = (LinearLayout.LayoutParams) r167;
    L202:
        if (r168 == null) goto L205;
        r168.setMarginStart(d.c(getContext(), 12));
        Unit r169 = Unit.INSTANCE;
        goto L205
    L201:
        r168 = null;
        goto L202
    L190:
        r165 = null;
        goto L192
    L183:
        r162 = null;
    L205:
        Unit r170 = Unit.INSTANCE;
        goto L206
    L178:
        r160 = false;
        goto L179
    L174:
        r159 = false;
    L206:
        this.f402262e.invoke(r125);
        boolean r171 = r118.f402300j;
        r125.setEnabled(r171);
        r125.setClickable(r171);
        if (r171 == false) goto L209;
        float r172 = 1.0f;
    L210:
        r125.setAlpha(r172);
        r212.addView(r125);
        r116 = r116 + 1;
        r113 = r212;
        r114 = r211;
        r100 = 1;
        r103 = false;
        r110 = -1;
        r111 = -2;
        goto L30
    L209:
        r172 = 0.3f;
        goto L210
    L149:
        r152 = 6;
        goto L150
    L141:
        r149.setImageResource(r118.f402294d);
        goto L143
    L142:
        r149 = r130;
        r149.setVisibility(r140);
        goto L143
    L134:
        r147.setImageResource(r118.f402293c);
        goto L137
    L135:
        r147 = r129;
        r147.setVisibility(r140);
        goto L137
    L103:
        r145 = null;
        goto L104
    L108:
        if (r115 != (this.f402263f.size() - 1)) goto L116;
        r125.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        ViewGroup.LayoutParams r173 = r125.getLayoutParams();
        if ((r173 instanceof LinearLayout.LayoutParams) == false) goto L112;
        LinearLayout.LayoutParams r174 = (LinearLayout.LayoutParams) r173;
    L113:
        if (r174 == null) goto L126;
        r174.topMargin = 0;
        r174.bottomMargin = 0;
        Unit r175 = Unit.INSTANCE;
        goto L126
    L112:
        r174 = null;
        goto L113
    L116:
        if (r115 < 0) goto L126;
        if (r115 != 0) goto L119;
        r125.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L119:
        ViewGroup.LayoutParams r176 = r125.getLayoutParams();
        if ((r176 instanceof LinearLayout.LayoutParams) == false) goto L122;
        LinearLayout.LayoutParams r177 = (LinearLayout.LayoutParams) r176;
    L123:
        if (r177 == null) goto L126;
        r177.topMargin = 0;
        r177.bottomMargin = this.f402274q;
        Unit r178 = Unit.INSTANCE;
        goto L126
    L122:
        r177 = null;
        goto L123
    L97:
        r143 = 0;
        goto L98
    L90:
        r140 = 8;
        r132.setVisibility(0);
        ViewGroup.LayoutParams r179 = r125.getLayoutParams();
        int r180 = this.f402269l;
        if (r180 != 0) goto L93;
        r180 = -2;
    L93:
        r179.height = r180;
        goto L94
    L83:
        ViewGroup.LayoutParams r181 = r125.getLayoutParams();
        r181.width = getAvailableItemWidth();
        goto L85
    L76:
        if (r118.f402292b == false) goto L78;
        int r182 = 0;
    L79:
        r134.setVisibility(r182);
        goto L80
    L78:
        r182 = 4;
        goto L79
    L71:
        r134 = null;
        goto L72
    L64:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L65:
        View r183 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_type, r113, r103);
        if (r183 == null) goto L212;
        r124 = (PopoverMenuLinearLayout) r183;
        goto L68
    L212:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L51:
        if ((r120 & 2) == 0) goto L53;
        boolean r184 = true;
    L54:
        if (r184 == true) goto L57;
        r122 = false;
        goto L59
    L53:
        r184 = false;
        goto L54
    L48:
        r121 = false;
        goto L49
    L39:
        View r185 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_sectionbar, r113, r103);
        if (r185 == null) goto L44;
        OSectionTitleBar r186 = (OSectionTitleBar) r185;
        r186.setTitleText(String.valueOf(r118.f402296f));
        LinearLayout.LayoutParams r187 = new LinearLayout.LayoutParams(r110, r111);
        r187.bottomMargin = this.f402274q;
        r113.addView(r186, r187);
        goto L30
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
    L36:
        View r188 = new ODivider(getContext(), null, 6, r103 ? 1 : 0);
        r188.setBackground(getContext().getDrawable(R.drawable.o_item_vertical_divider));
        int r189 = d.c(getContext(), 8);
        r188.setPadding(r189, r103 ? 1 : 0, r189, r103 ? 1 : 0);
        ViewGroup.MarginLayoutParams r190 = new ViewGroup.MarginLayoutParams(r110, r111);
        int r191 = getContext().getResources().getDimensionPixelSize(R.dimen.oui_popover_divider_margin);
        r190.leftMargin = r191;
        r190.rightMargin = r191;
        r190.bottomMargin = this.f402274q;
        r113.addView(r188, r190);
        goto L30
    L214:
        if (this.f402265h == null) goto L225;
        ViewGroup r192 = (ViewGroup) findViewById(R.id.bottom_container);
        r192.addView(this.f402265h, new ViewGroup.LayoutParams(-1, -2));
        if (this.f402275r == null) goto L218;
        r192.getLayoutParams().width = -2;
    L219:
        ViewGroup.LayoutParams r193 = r192.getLayoutParams();
        int r194 = this.f402267j;
        if (r194 != 0) goto L222;
        int r195 = -2;
    L223:
        r193.height = r195;
        goto L225
    L222:
        r195 = r194;
        goto L223
    L218:
        ViewGroup.LayoutParams r196 = r192.getLayoutParams();
        r196.width = getAvailableItemWidth();
    L225:
        if (this.f402275r == null) goto L238;
        measure(0, 0);
        Objects.toString(this.f402275r);
        getMeasuredWidth();
        int r197 = getMeasuredWidth();
        Pair<Integer, Integer> r198 = this.f402275r;
        Intrinsics.checkNotNull(r198);
        int r199 = r198.getFirst().intValue();
        Pair<Integer, Integer> r200 = this.f402275r;
        Intrinsics.checkNotNull(r200);
        this.f402268k = RangesKt.coerceIn(r197, r199, r200.getSecond().intValue());
        this.f402275r = null;
        ((FrameLayout) findViewById(R.id.top_container)).removeAllViews();
        ((LinearLayout) findViewById(R.id.popover_container)).removeAllViews();
        ((FrameLayout) findViewById(R.id.bottom_container)).removeAllViews();
        d();
        return;
    }

    private final int getAvailableItemWidth() {
        return this.f402268k;
    }

    public final PopoverMenuLinearLayout c(int r100) {
        if (r100 >= 0) goto L5;
        Intrinsics.stringPlus("getItemView: invalid position=", Integer.valueOf(r100));
        return null;
    L5:
        PopoverMenuLinearLayout r101 = (PopoverMenuLinearLayout) SequencesKt.elementAtOrNull(SequencesKt.filter(ViewGroupKt.getChildren((LinearLayout) findViewById(R.id.popover_container)), OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1.INSTANCE), r100);
        if (r101 != null) goto L8;
        Intrinsics.stringPlus("getItemView: no item view for position=", Integer.valueOf(r100));
    L8:
        return r101;
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r100) {
        int r101 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, d.n(this, 40)), this.f402276s);
        if (this.f402277t != r101) goto L5;
        return;
    L5:
        this.f402277t = r101;
        MaxHeightNestedScrollView r102 = this.f402279v;
        if (r102 == null) goto L9;
        r102.setMaxHeight(r101);
    L9:
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 != Integer.MIN_VALUE) goto L5;
        int r104 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r103, this.f402277t), Integer.MIN_VALUE);
    L9:
        super.onMeasure(r100, r104);
        if (getMeasuredHeight() <= this.f402277t) goto L13;
        setMeasuredDimension(getMeasuredWidth(), this.f402277t);
        return;
    L13:
        return;
    L5:
        if (r102 == 1073741824) goto L7;
        r104 = View.MeasureSpec.makeMeasureSpec(this.f402277t, Integer.MIN_VALUE);
        goto L9
    L7:
        r104 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r103, this.f402277t), 1073741824);
        goto L9
    }

    public OPopoverEntranceMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402262e = OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        this.f402263f = new ArrayList();
        this.f402268k = d.c(r100, 184);
        this.f402273p = d.c(r100, 8);
        this.f402274q = d.c(r100, 4);
        if (r100.getResources().getConfiguration().orientation != 2) goto L5;
        int r103 = r100.getResources().getDimensionPixelSize(R.dimen.oui_popover_max_height_landscape);
    L6:
        this.f402276s = r103;
        this.f402277t = r103;
        return;
    L5:
        r103 = r100.getResources().getDimensionPixelSize(R.dimen.oui_popover_max_height);
        goto L6
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
