package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.export.entity.preview.Gradient;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ChattersPreviewComponent extends q6c.e<ChattersPreviewProperty, CrescentAvatarListView, r6c.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.chat.preview.actions.b f415989f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415990a = null;

        static {
            int[] r100 = new int[Theme.values().length];
            r100[Theme.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Theme.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f415990a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChattersPreviewComponent f415991a;

        public c(ChattersPreviewComponent r100) {
            this.f415991a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f415991a.f415989f.a(1);
        }
    }

    static {
    }

    @Override // q6c.a
    public final String i() {
        return "com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView";
    }

    @Override // q6c.e
    public final boolean j() {
        return true;
    }

    @Override // q6c.e, s6c.b
    public final View a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Dp r101 = this.f531875a;
        if (r101 != 0) goto L5;
        Intrinsics.checkNotNullParameter(r100, "size");
        return null;
    L5:
        return new CrescentAvatarListView(r101.getContext());
    }

    @Override // q6c.e, s6c.b
    public final s6c.b.a d(s6c.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        int r101 = CrescentAvatarListView.f416013k;
        TCStyle r102 = this.f531877c;
        if ((r102 instanceof Style) == false) goto L5;
        Style r103 = (Style) r102;
    L7:
        if (r103 == null) goto L9;
        float r104 = r103.getWidth();
    L10:
        float r105 = UIHelper.dp2px(r104);
        Integer r106 = ((ChattersPreviewProperty) this.f531880e).getChatterCounts();
        int r107 = 5;
        if (r106 == null) goto L13;
        int r108 = r106.intValue();
    L14:
        Integer r109 = ((ChattersPreviewProperty) this.f531880e).getMaxShowCount();
        if (r109 == null) goto L17;
        int r110 = r109.intValue();
    L18:
        int r111 = Math.min(r108, r110);
        Integer r112 = ((ChattersPreviewProperty) this.f531880e).getChatterCounts();
        int r113 = 0;
        if (r112 == null) goto L21;
        int r114 = r112.intValue();
    L22:
        Integer r115 = ((ChattersPreviewProperty) this.f531880e).getMaxShowCount();
        if (r115 == null) goto L25;
        r107 = r115.intValue();
    L25:
        if (r114 <= r107) goto L27;
        r113 = 1;
    L27:
        int r116 = r111 + r113;
        if (r105 <= 0.0f) goto L30;
        int r117 = (int) r105;
    L31:
        float r118 = zz7.b.f(r101);
        return new s6c.b.a(Math.min(r100.f540895a, UIHelper.px2dp(zz7.b.f(r117))), UIHelper.px2dp(r118));
    L30:
        r117 = r101 * r116;
        goto L31
    L21:
        r114 = 0;
        goto L22
    L17:
        r110 = 5;
        goto L18
    L13:
        r108 = 5;
        goto L14
    L9:
        r104 = 0.0f;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.ss.android.lark.chat.preview.components.ChattersPreviewComponent$update$1$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void update(final CrescentAvatarListView r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        float r100 = r110.getLayoutParams().width;
        Integer r101 = ((ChattersPreviewProperty) this.f531880e).getChatterCounts();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = ((ChattersPreviewProperty) this.f531880e).getMaxShowCount();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L11:
        if (r102 <= r104) goto L13;
        int r105 = 1;
    L14:
        float r106 = zz7.b.d().getMultiplier() * CrescentAvatarListView.f416013k;
        ChattersPreviewProperty r107 = (ChattersPreviewProperty) this.f531880e;
        int r108 = MathKt.roundToInt((r100 / r106) - r105);
        Integer r109 = ((ChattersPreviewProperty) this.f531880e).getMaxShowCount();
        if (r109 == null) goto L17;
        int r111 = r109.intValue();
    L18:
        r107.setMaxShowCount(Integer.valueOf(Math.min(r108, r111)));
        List<ChatterPreviewChatterInfo> r112 = ((ChattersPreviewProperty) this.f531880e).getChatterInfoList();
        if (r112 == null) goto L42;
        Iterator<ChatterPreviewChatterInfo> r113 = r112.iterator();
    L22:
        if (r113.hasNext() == false) goto L39;
        String r114 = r113.next().getAvatarKey();
        if (r114 != null) goto L26;
    L29:
        boolean r115 = true;
    L30:
        if (r115 == false) goto L22;
        g6b.a.InterfaceC5990a r116 = g6b.a.f480178a;
        if (r116 == 0) goto L38;
        List<ChatterPreviewChatterInfo> r117 = r112;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L35:
        if (r119.hasNext() == false) goto L37;
        r118.add(((ChatterPreviewChatterInfo) r119.next()).getChatterId());
        goto L35
    L37:
        r116.f(r118, new ChattersPreviewComponent$update$1$2(r110, this));
    L38:
        boolean r120 = true;
    L40:
        if (r120 == true) goto L42;
        r110.setData((ChattersPreviewProperty) this.f531880e);
        goto L42
    L26:
        if (r114.length() == 0) goto L29;
        r115 = false;
        goto L30
    L39:
        r120 = false;
    L42:
        TextView r121 = r110.getParticipantsNumbView();
        TCStyle r122 = this.f531877c;
        Style r123 = null;
        if ((r122 instanceof Style) == false) goto L45;
        Style r124 = (Style) r122;
    L46:
        if (r124 == null) goto L48;
        Gradient r125 = r124.getBackgroundColor();
    L49:
        int r126 = -1;
        if (r125 == null) goto L66;
        TCStyle r127 = this.f531877c;
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Gradient r128 = ((Style) r127).getBackgroundColor();
        Intrinsics.checkNotNull(r128);
        Gradient.Content r129 = r128.getContent();
        Intrinsics.checkNotNull(r129, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
        ArrayList<ThemeColor> r130 = ((Gradient.Linear) r129).getThemeColors();
        if (r130 == null) goto L76;
        int[] r131 = new int[r130.size()];
        int r132 = r130.size();
        int r133 = 0;
    L54:
        if (r133 >= r132) goto L59;
        int r134 = com.ss.android.lark.export.entity.preview.a.a((ThemeColor) ListProtector.get(r130, r133), r121.getContext(), null);
        if (r134 != 0) goto L58;
        r134 = UIUtils.getColor(r121.getContext(), R.color.bg_filler);
    L58:
        r131[r133] = r134;
        r133 = r133 + 1;
        goto L54
    L59:
        GradientDrawable r135 = new GradientDrawable();
        if (r130.size() != 1) goto L63;
        r135.setColor(r131[0]);
    L65:
        r135.setShape(1);
        r135.setCornerRadius(UIHelper.dp2px(4.0f));
        r121.setBackground(r135);
        goto L76
    L63:
        if (r130.size() <= 1) goto L65;
        r135.setColors(r131);
    L76:
        TextView r136 = r110.getParticipantsNumbView();
        Intrinsics.checkNotNullParameter(r110, "view");
        TCStyle r137 = this.f531877c;
        if ((r137 instanceof Style) == false) goto L79;
        Style r138 = (Style) r137;
    L80:
        if (r138 == null) goto L84;
        ThemeColor r139 = r138.getTextColorV2();
        if (r139 == null) goto L84;
        int r140 = com.ss.android.lark.export.entity.preview.a.a(r139, r110.getContext(), null);
    L94:
        r136.setTextColor(r140);
        TCStyle r141 = this.f531877c;
        if ((r141 instanceof Style) == false) goto L97;
        r123 = (Style) r141;
    L97:
        if (r123 == null) goto L99;
        TextPaint r142 = r110.getParticipantsNumbView().getPaint();
        int r143 = h6b.a.f483930a;
        r142.setFakeBoldText(h6b.a.a(r123.getFontLevel()));
    L99:
        r110.setOnClickListener(new c(this));
        return;
    L84:
        Theme r144 = ((ChattersPreviewProperty) this.f531880e).getTheme();
        if (r144 == null) goto L89;
        r126 = b.f415990a[r144.ordinal()];
    L89:
        if (r126 == 1) goto L93;
        if (r126 == 2) goto L92;
        r140 = UDColorUtils.getAlphaColor(r110.getContext(), R.color.static_black, 0.5f);
        goto L94
    L92:
        r140 = UDColorUtils.getColor(r110.getContext(), R.color.ud_N200);
        goto L94
    L93:
        r140 = UDColorUtils.getAlphaColor(r110.getContext(), R.color.static_black, 0.5f);
        goto L94
    L79:
        r138 = null;
        goto L80
    L66:
        GradientDrawable r145 = new GradientDrawable();
        r145.setShape(1);
        Theme r146 = ((ChattersPreviewProperty) this.f531880e).getTheme();
        if (r146 != null) goto L69;
        int r147 = -1;
    L70:
        if (r147 == 1) goto L74;
        if (r147 != 2) goto L75;
        r145.setColor(UDColorUtils.getAlphaColor(r121.getContext(), R.color.ud_N1000, 0.1f));
    L75:
        r121.setBackground(r145);
        goto L76
    L74:
        r145.setColor(UDColorUtils.getAlphaColor(r121.getContext(), R.color.static_black, 0.2f));
        goto L75
    L69:
        r147 = b.f415990a[r146.ordinal()];
        goto L70
    L48:
        r125 = null;
        goto L49
    L45:
        r124 = null;
        goto L46
    L17:
        r111 = 0;
        goto L18
    L13:
        r105 = 0;
        goto L14
    L9:
        r104 = 5;
        goto L11
    L5:
        r102 = 0;
        goto L6
    }

    @Override // q6c.e
    public /* bridge */ /* synthetic */ void update(View r100) {
        update((CrescentAvatarListView) r100);
    }

    public ChattersPreviewComponent(ChattersPreviewProperty r100, Style r101, vcb.d r102, com.ss.android.lark.chat.preview.creator.b r103) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        Intrinsics.checkNotNullParameter(r103, "action");
        super(r100, r101, r102);
        this.f415989f = r103;
    }
}
