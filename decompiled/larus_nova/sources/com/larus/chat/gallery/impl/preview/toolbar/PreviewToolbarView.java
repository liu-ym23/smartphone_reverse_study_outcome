package com.larus.chat.gallery.impl.preview.toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J0\u0010&\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u0014\u0010'\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016J\"\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001a2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0,J\u0016\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mode", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarLayoutMode;", "visualStyle", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarVisualStyle;", "listener", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView$OnToolbarActionListener;", "emphasizedKeys", "", "", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "lastButtonSignature", "", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView$ToolbarButtonSignature;", "itemViewMap", "", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonType;", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarItemView;", "mainItems", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonItem;", "overflowItems", "overflowMenu", "Lcom/larus/bmhome/view/menu/CreateMenu;", "overflowAnchor", "allItems", "updateEmphasizedKeys", "", "emphasizedButtons", "init", "setButtons", "items", "updateButton", "type", "updater", "Lkotlin/Function1;", "setButtonLoading", "loading", "", "findCurrentItem", "showOverflowMenu", "anchor", "Companion", "OnToolbarActionListener", "ToolbarButtonSignature", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewToolbarView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f324652m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ToolbarLayoutMode f324653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ToolbarVisualStyle f324654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f324655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f324656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f324657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<c> f324658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<ToolbarButtonType, PreviewToolbarItemView> f324659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<j> f324660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<j> f324661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CreateMenu f324662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PreviewToolbarItemView f324663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<j> f324664l;

    public static final class a {
    }

    public interface b {
        void a(ToolbarButtonType r100, boolean r101);
    }

    public static final class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f324665h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ToolbarButtonType f324666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f324667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f324668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f324669d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f324670e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f324671f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f324672g;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f324666a == r101.f324666a) goto L12;
            return false;
        L12:
            if (this.f324667b == r101.f324667b) goto L15;
            return false;
        L15:
            if (this.f324668c == r101.f324668c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f324669d, r101.f324669d) == true) goto L21;
            return false;
        L21:
            if (this.f324670e == r101.f324670e) goto L24;
            return false;
        L24:
            if (this.f324671f == r101.f324671f) goto L27;
            return false;
        L27:
            if (this.f324672g == r101.f324672g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f324666a.hashCode() * 31) + this.f324667b) * 31) + this.f324668c) * 31;
            String r101 = this.f324669d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            int r104 = 1231;
            if (this.f324670e == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f324671f == false) goto L13;
            int r107 = 1231;
        L14:
            int r108 = (r106 + r107) * 31;
            if (this.f324672g == true) goto L19;
            r104 = 1237;
        L19:
            return r108 + r104;
        L13:
            r107 = 1237;
            goto L14
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ToolbarButtonSignature(type=" + this.f324666a + ", iconRes=" + this.f324667b + ", textRes=" + this.f324668c + ", textHardcode=" + this.f324669d + ", visible=" + this.f324670e + ", enabled=" + this.f324671f + ", overflow=" + this.f324672g + ')';
        }

        public final ToolbarButtonType getType() {
            return this.f324666a;
        }

        public c(ToolbarButtonType r100, int r101, int r102, String r103, boolean r104, boolean r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f324666a = r100;
            this.f324667b = r101;
            this.f324668c = r102;
            this.f324669d = r103;
            this.f324670e = r104;
            this.f324671f = r105;
            this.f324672g = r106;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324673a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324674b = null;

        static {
            int[] r100 = new int[ToolbarLayoutMode.values().length];
            r100[ToolbarLayoutMode.VERTICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ToolbarLayoutMode.HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f324673a = r100;
            int[] r101 = new int[ToolbarVisualStyle.values().length];
            r101[ToolbarVisualStyle.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[ToolbarVisualStyle.MEDIA_SOURCE_V4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f324674b = r101;
        }
    }

    static {
    }

    public PreviewToolbarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PreviewToolbarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setButtons(List<j> r110) {
        Intrinsics.checkNotNullParameter(r110, "items");
        List<j> r100 = r110;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        j r103 = (j) r102.next();
        int r104 = c.f324665h;
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r101.add(new c(r103.getType(), r103.f324805b, r103.f324807d, r103.f324808e, r103.f324809f, r103.f324810g, r103.f324811h));
        goto L4
    L7:
        if (Intrinsics.areEqual(r101, this.f324658f) == false) goto L10;
        FLogger.f375446a.d("PreviewToolbarView", "setButtons 签名未变化，跳过重建");
        return;
    L10:
        this.f324658f = r101;
        this.f324664l = r110;
        this.f324657e.removeAllViews();
        ((LinkedHashMap) this.f324659g).clear();
        ToolbarLayoutMode r105 = this.f324653a;
        int r106 = d.f324673a[r105.ordinal()];
        if (r106 == 1) goto L22;
        if (r106 != 2) goto L21;
        ToolbarVisualStyle r107 = this.f324654b;
        int r108 = d.f324674b[r107.ordinal()];
        if (r108 == 1) goto L19;
        if (r108 != 2) goto L18;
        int r109 = i5.h();
    L23:
        int r111 = 0;
        if (this.f324653a != ToolbarLayoutMode.VERTICAL) goto L26;
        boolean r112 = true;
    L27:
        ArrayList r113 = new ArrayList();
        ArrayList r114 = new ArrayList();
        Iterator<j> r115 = r110.iterator();
        int r116 = 0;
    L29:
        if (r115.hasNext() == false) goto L150;
        final j r117 = r115.next();
        if (r117.f324809f == false) goto L29;
        if (r117.f324811h == false) goto L35;
        r113.add(r117);
        goto L29
    L35:
        r114.add(r117);
        boolean r118 = this.f324656d.contains(r117.getType().getKey());
        if (r112 == false) goto L38;
    L44:
        AttributeSet r119 = null;
        final PreviewToolbarItemView r120 = new PreviewToolbarItemView(getContext(), r119, 6, r111);
        ToolbarLayoutMode r121 = this.f324653a;
        Intrinsics.checkNotNullParameter(r117, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r121, "mode");
        r120.f324648d = r117;
        r120.f324649e = r121;
        r120.f324650f = r118;
        r120.f324647c = null;
        r120.removeAllViews();
        int r122 = PreviewToolbarItemView.b.f324651a[r121.ordinal()];
        if (r122 != 1) goto L47;
        int r123 = R.layout.larus_preview_toolbar_item_vertical;
    L58:
        LayoutInflater.from(r120.getContext()).inflate(r123, r120);
        r120.f324645a = (ImageView) r120.findViewById(R.id.iv_icon);
        r120.f324646b = (TextView) r120.findViewById(R.id.tv_text);
        ToolbarLayoutMode r124 = ToolbarLayoutMode.VERTICAL;
        if (r121 == r124) goto L61;
    L72:
        ImageView r125 = r120.f324645a;
        if (r125 == null) goto L92;
        if (r121 == ToolbarLayoutMode.HORIZONTAL) goto L77;
    L79:
        int r126 = i5.A();
    L80:
        ViewGroup.LayoutParams r127 = r125.getLayoutParams();
        if ((r127 instanceof LinearLayout.LayoutParams) == false) goto L83;
        LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) r127;
    L84:
        if (r128 == null) goto L86;
        r128.width = r126;
        r128.height = r126;
    L87:
        r125.setLayoutParams(r128);
        int r129 = r117.f324805b;
        if (r129 == 0) goto L90;
        r125.setImageResource(r129);
        r125.setVisibility(0);
        goto L92
    L90:
        r125.setVisibility(8);
        goto L92
    L86:
        r128 = null;
        goto L87
    L83:
        r128 = null;
        goto L84
    L77:
        if (r117.getType() != ToolbarButtonType.CROP) goto L79;
        r126 = i5.E();
    L92:
        if (r121 == r124) goto L94;
    L95:
        TextView r130 = r120.f324646b;
        if (r130 == null) goto L123;
        Object r131 = r117.f324812i.get("selected");
        if ((r131 instanceof Boolean) == false) goto L101;
        Boolean r132 = (Boolean) r131;
    L102:
        boolean r133 = Intrinsics.areEqual(r132, Boolean.TRUE);
        if (r120.f324649e == ToolbarLayoutMode.HORIZONTAL) goto L105;
    L110:
        String r134 = r117.f324808e;
        if (r134 != null) goto L113;
    L116:
        boolean r135 = true;
    L117:
        if (r135 == true) goto L119;
        r130.setText(r117.f324808e);
        goto L123
    L119:
        int r136 = r117.f324807d;
        if (r136 == 0) goto L123;
        r130.setText(r136);
        goto L123
    L113:
        if (r134.length() == 0) goto L116;
        r135 = false;
        goto L117
    L105:
        if (r117.getType() != ToolbarButtonType.SELECT) goto L110;
        if (r120.f324650f == false) goto L110;
        if (r133 == false) goto L110;
        r130.setText(R.string.larus_button_select);
        goto L123
    L101:
        r132 = null;
    L123:
        if (r120.f324649e == ToolbarLayoutMode.HORIZONTAL) goto L125;
    L142:
        r111 = 0;
    L143:
        r120.a();
        r120.setClickable(true);
        r120.setFocusable(true);
        r120.setOnClickListener(new g(r117, this, r120));
        LinearLayout.LayoutParams r137 = new LinearLayout.LayoutParams(-2, -2);
        if (r116 <= 0) goto L148;
        if (r112 == false) goto L147;
        r137.topMargin = r109;
        goto L148
    L147:
        r137.setMarginStart(r109);
    L148:
        this.f324657e.addView(r120, r137);
        this.f324659g.put(r117.getType(), r120);
        r116 = r116 + 1;
        goto L29
    L125:
        if (r117.getType() != ToolbarButtonType.SELECT) goto L142;
        if (r120.f324650f == false) goto L142;
        Object r138 = r117.f324812i.get("selected");
        if ((r138 instanceof Boolean) == false) goto L132;
        Boolean r139 = (Boolean) r138;
    L133:
        boolean r140 = Intrinsics.areEqual(r139, Boolean.TRUE);
        r111 = 0;
        View r141 = r120.getChildAt(0);
        if (r141 == null) goto L139;
        if (r140 == false) goto L137;
        int r142 = R.drawable.larus_preview_toolbar_select_bg_selected;
    L138:
        r141.setBackgroundResource(r142);
        goto L139
    L137:
        r142 = R.drawable.larus_preview_toolbar_select_bg_normal_v4;
    L139:
        ImageView r143 = r120.f324645a;
        if (r143 == null) goto L143;
        r143.setImageResource(r117.f324805b);
        goto L143
    L132:
        r139 = null;
        goto L133
    L94:
        if (r117.getType() == ToolbarButtonType.MORE) goto L123;
    L61:
        if (r117.getType() != ToolbarButtonType.MORE) goto L72;
        int r144 = r120.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_44, null, R.dimen.larus_dp_44));
        View r145 = r120.getChildAt(0);
        if (r145 == null) goto L69;
        ViewGroup.LayoutParams r146 = r145.getLayoutParams();
        if (r146 == null) goto L67;
        r146.width = r144;
        r146.height = r144;
    L68:
        r145.setLayoutParams(r146);
        goto L69
    L67:
        r146 = new FrameLayout.LayoutParams(r144, r144);
    L69:
        TextView r147 = r120.f324646b;
        if (r147 == null) goto L72;
        r147.setVisibility(8);
        goto L72
    L47:
        if (r122 != 2) goto L56;
        if (r117.getType() != ToolbarButtonType.SELECT) goto L52;
        if (r118 == false) goto L52;
        r123 = R.layout.larus_preview_toolbar_item_horizontal_select;
    L52:
        if (r118 == false) goto L54;
        r123 = R.layout.larus_preview_toolbar_item_horizontal_enhanced;
        goto L58
    L54:
        r123 = R.layout.larus_preview_toolbar_item_horizontal;
        goto L58
    L56:
        throw new NoWhenBranchMatchedException();
    L38:
        if (this.f324654b != ToolbarVisualStyle.MEDIA_SOURCE_V4) goto L44;
        if (r116 <= 0) goto L44;
        if (r117.getType() != ToolbarButtonType.SELECT) goto L44;
        if (r118 == false) goto L44;
        LinearLayout r148 = this.f324657e;
        View r149 = new View(getContext());
        r149.setBackgroundColor(ContextCompat.getColor(r149.getContext(), R.color.static_white_transparent_2));
        LinearLayout.LayoutParams r150 = new LinearLayout.LayoutParams(i5.b(), i5.q());
        r150.gravity = 16;
        r150.setMarginStart(r109);
        Unit r151 = Unit.INSTANCE;
        r148.addView(r149, r150);
        goto L44
    L150:
        this.f324661i = r113;
        return;
    L26:
        r112 = false;
        goto L27
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r109 = i5.r0();
        goto L23
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r109 = i5.Y();
        goto L23
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(ToolbarButtonType r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        PreviewToolbarItemView r101 = (PreviewToolbarItemView) ((LinkedHashMap) this.f324659g).get(r100);
        if (r101 == null) goto L5;
        r101.setLoading(r110);
        return;
    L5:
        CreateMenu r102 = this.f324662j;
        if (r102 == null) goto L57;
        Iterator<T> r103 = this.f324661i.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if (((j) r104).getType() != r100) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
    L17:
        j r106 = (j) r104;
        if (r106 == null) goto L57;
        int r107 = r106.f324806c;
        if (r107 != 0) goto L23;
        r107 = r106.f324805b;
    L23:
        boolean r108 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L26;
        int r109 = R.drawable.larus_ic_preview_gallery_download_loading_h;
    L27:
        int r111 = r100.ordinal();
        if (r110 == true) goto L31;
        r109 = 0;
    L31:
        if (r110 == false) goto L34;
        r107 = 0;
    L34:
        LarusCreateMenuItemLayoutBinding r112 = r102.f317042b.get(r111);
        if (r112 == null) goto L52;
        SimpleDraweeView r113 = r112.f326630c;
        if (r110 == false) goto L42;
        if (r109 == 0) goto L41;
        r113.setImageDrawable(AppCompatResources.getDrawable(r102.getContext(), r109));
    L41:
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r113, "rotation", new float[]{0.0f, 360.0f});
        r114.setDuration(1000);
        r114.setRepeatCount(-1);
        r114.setInterpolator(new LinearInterpolator());
        r114.start();
        r113.setTag(R.id.view_create_menu, r114);
        r112.f326628a.setEnabled(false);
        r112.f326628a.setClickable(false);
        goto L52
    L42:
        Object r115 = r113.getTag(R.id.view_create_menu);
        if ((r115 instanceof ObjectAnimator) == false) goto L45;
        ObjectAnimator r116 = (ObjectAnimator) r115;
    L46:
        if (r116 == null) goto L48;
        r116.cancel();
    L48:
        r113.setRotation(0.0f);
        r113.setTag(R.id.view_create_menu, null);
        if (r107 == 0) goto L51;
        r113.setImageResource(r107);
    L51:
        r112.f326628a.setEnabled(true);
        r112.f326628a.setClickable(true);
        goto L52
    L45:
        r116 = null;
    L52:
        if (r110 == true) goto L66;
        PreviewToolbarItemView r117 = this.f324663k;
        if (r117 == null) goto L67;
        com.larus.bmhome.view.screenmenu.d r118 = com.larus.bmhome.view.screenmenu.d.f317270a;
        com.larus.bmhome.view.screenmenu.d.b(r117);
        return;
    L67:
        return;
    L66:
        return;
    L26:
        r109 = R.drawable.larus_ic_preview_gallery_download_loading_e;
        goto L27
    L13:
        r105 = false;
        goto L14
    L16:
        r104 = null;
    L57:
        PreviewToolbarItemView r119 = (PreviewToolbarItemView) ((LinkedHashMap) this.f324659g).get(ToolbarButtonType.MORE);
        if (r119 == null) goto L69;
        r119.setLoading(r110);
        return;
    }

    public final void b(ToolbarButtonType r100, Function1<? super j, j> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "updater");
        List<j> r102 = this.f324664l;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        j r105 = (j) r104.next();
        if (r105.getType() != r100) goto L8;
        r105 = r101.invoke(r105);
    L8:
        r103.add(r105);
        goto L4
    L10:
        if (Intrinsics.areEqual(r103, this.f324664l) == false) goto L12;
        return;
    L12:
        setButtons(r103);
    }

    public PreviewToolbarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f324653a = ToolbarLayoutMode.VERTICAL;
        this.f324654b = ToolbarVisualStyle.LEGACY;
        this.f324656d = SetsKt.emptySet();
        this.f324657e = new LinearLayout(r100);
        this.f324658f = CollectionsKt.emptyList();
        this.f324659g = new LinkedHashMap();
        this.f324660h = CollectionsKt.emptyList();
        this.f324661i = CollectionsKt.emptyList();
        this.f324664l = CollectionsKt.emptyList();
    }

    public /* synthetic */ PreviewToolbarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
