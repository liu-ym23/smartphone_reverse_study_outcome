package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewGroupKt;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.I18nText;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SystemGuideCTAItem;
import com.bytedance.lark.pb.basic.v1.SystemGuideContent;
import com.bytedance.lark.pb.basic.v1.SystemMessageItemAction;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.d;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.f;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SysChatGuideContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<d>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f413234h;

    public static final class a implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f413236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f413237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final FrameLayout f413238d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FrameLayout f413239e;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413235a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413235a = r100;
            this.f413236b = r100.findViewById(R.id.system_message_check_label);
            this.f413237c = r100.findViewById(R.id.system_label);
            this.f413238d = (FrameLayout) r100.findViewById(R.id.system_message_open_area_mask);
            this.f413239e = (FrameLayout) r100.findViewById(R.id.system_message_open_area);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f413233g;
    }

    public SysChatGuideContentBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413233g = IMMessageKeys$Blocks.SYS_CHAT_GUIDE;
        this.f413234h = zz7.b.g(getContext(), 16);
    }

    public void update(m<y6b.a<d>> r310, q<y6b.a<d>> r311, y6b.a<d> r312) {
        Intrinsics.checkNotNullParameter(r310, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r311, "layout");
        Intrinsics.checkNotNullParameter(r312, "data");
        Content.SystemExtraContent r100 = ((SystemContent) r312.b().f553338a).getSystemExtraContent();
        if (r100 == null) goto L110;
        SystemGuideContent r101 = r100.guide_content;
        if (r101 == null) goto L110;
        a r102 = (a) r311.c(this.f413233g, IMMessageKeys$Slots.CONTENT, SysChatGuideContentBlock$update$blockView$1.INSTANCE);
        r102.f413236b.setVisibility(8);
        r102.f413237c.setVisibility(8);
        r102.f413239e.setVisibility(0);
        r102.f413238d.setVisibility(0);
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setGravity(1);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r103.setOrientation(1);
        LinearLayout r104 = new LinearLayout(getContext());
        r104.setGravity(1);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        View r105 = new View(getContext());
        r105.setBackground(UIUtils.getDrawable(this.f412673c.getContext(), R.drawable.bg_system_msg));
        TextView r110 = new TextView(getContext());
        r110.setGravity(1);
        I18nText r111 = r101.title;
        if (r111 == null) goto L10;
        String r112 = r111.localized_text;
    L11:
        String r113 = "";
        if (r112 != null) goto L14;
        r112 = "";
    L14:
        r110.setText(r112);
        r110.setTextColor(UDColorUtils.getColor(r110.getContext(), R.color.text_title));
        zz7.a.d(r110, LarkFont.TITLE3);
        r110.setTypeface(Typeface.DEFAULT_BOLD);
        TextView r114 = new TextView(getContext());
        r114.setGravity(1);
        I18nText r115 = r101.sub_title;
        if (r115 == null) goto L17;
        String r116 = r115.localized_text;
    L18:
        if (r116 != null) goto L20;
        r116 = "";
    L20:
        r114.setText(r116);
        r114.setTextColor(UDColorUtils.getColor(r114.getContext(), R.color.text_placeholder));
        zz7.a.d(r114, LarkFont.BODY1);
        AppCompatImageView r117 = new AppCompatImageView(getContext());
        r117.setVisibility(8);
        if (f.a(r117.getContext()) == false) goto L23;
        ImageSetPassThrough r118 = r101.dm_image;
    L24:
        IRequestCreator r119 = ImageLoader.with(r117.getContext());
        if (r118 == null) goto L27;
        String r106 = r118.key;
    L28:
        if (r106 != null) goto L30;
        r106 = "";
    L30:
        if (r118 == null) goto L32;
        String r120 = r118.fs_unit;
    L33:
        r119.load(new PassThroughImage(r106, r120)).override(UIHelper.dp2px(176.0f), UIHelper.dp2px(132.0f)).listener(new c(r117)).into(r117);
        r103.addView(r110);
        r103.addView(r114);
        r103.addView(r117);
        r104.addView(r105);
        Iterator<SystemGuideCTAItem> r107 = r101.items.iterator();
    L35:
        if (r107.hasNext() == false) goto L73;
        SystemGuideCTAItem r108 = r107.next();
        if (f.a(r103.getContext()) == false) goto L39;
        ImageSetPassThrough r121 = r108.dm_icon;
    L40:
        String r109 = r108.f253565id;
        I18nText r122 = r108.text;
        if (r122 == null) goto L43;
        String r123 = r122.localized_text;
    L44:
        SystemMessageItemAction r124 = r108.action;
        if (r124 == null) goto L58;
        SystemMessageItemAction.Url r125 = r124.url;
        if (r125 == null) goto L58;
        String r126 = r125.f253567android;
        if (r126 != null) goto L51;
    L54:
        boolean r127 = true;
    L55:
        if (r127 == false) goto L57;
        String r128 = r125.common;
    L59:
        UDButton r129 = new UDButton(getContext(), null, 0, 6, null);
        Iterator<SystemGuideCTAItem> r130 = r107;
        r129.setGravity(1);
        String r210 = r113;
        View r211 = r105;
        SystemGuideContent r212 = r101;
        r129.setPadding(UIHelper.dp2px(16.0f), UIHelper.dp2px(7.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(7.0f));
        r129.setBackgroundColor(UDColorUtils.getColorStateList(r129.getContext(), R.color.ud_button_white_grey_bg));
        r129.setTextColor(UDColorUtils.getColor(r129.getContext(), R.color.ud_button_grey_text));
        r129.setStrokeColor(UDColorUtils.getColor(r129.getContext(), R.color.line_border_component));
        r129.setStrokeWidth(UIHelper.dp2px(1.0f));
        r129.setCornerRadius(UIHelper.dp2px(6.0f));
        r129.setSingleLine();
        if (r123 != null) goto L62;
        String r131 = r210;
    L63:
        r129.setText(r131);
        zz7.a.d(r129, LarkFont.HEADLINE);
        IRequestCreator r132 = ImageLoader.with(r129.getContext()).asDrawable();
        if (r121 == null) goto L66;
        String r133 = r121.key;
    L67:
        if (r133 != null) goto L69;
        r133 = r210;
    L69:
        if (r121 == null) goto L71;
        String r134 = r121.fs_unit;
    L72:
        IRequestCreator r135 = r132.load(new PassThroughImage(r133, r134));
        int r136 = this.f413234h;
        r135.override(r136, r136).into(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.a(this, r129, r123));
        r129.setOnClickListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.b(r129, r128, r109));
        r103.addView(r129);
        r107 = r130;
        r113 = r210;
        r105 = r211;
        r101 = r212;
        goto L35
    L71:
        r134 = null;
        goto L72
    L66:
        r133 = null;
        goto L67
    L62:
        r131 = r123;
        goto L63
    L57:
        r128 = r125.f253567android;
        goto L59
    L51:
        if (r126.length() == 0) goto L54;
        r127 = false;
    L58:
        r128 = null;
        goto L59
    L43:
        r123 = null;
        goto L44
    L39:
        r121 = r108.lm_icon;
        goto L40
    L73:
        SystemGuideContent r213 = r101;
        View r214 = r105;
        String r215 = r113;
        FrameLayout r137 = r102.f413239e;
        r137.removeAllViews();
        r137.addView(r103);
        ViewGroup.LayoutParams r138 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r138, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r138).gravity = 1;
        r110.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r139 = new LinearLayout.LayoutParams(-2, -2);
        r139.topMargin = UIHelper.dp2px(4.0f);
        r114.setLayoutParams(r139);
        LinearLayout.LayoutParams r140 = new LinearLayout.LayoutParams(-2, -2);
        r140.topMargin = UIHelper.dp2px(20.0f);
        r140.bottomMargin = UIHelper.dp2px(4.0f);
        r117.setLayoutParams(r140);
        Iterator<View> r141 = ViewGroupKt.getChildren(r103).iterator();
    L75:
        if (r141.hasNext() == false) goto L79;
        View r142 = r141.next();
        if ((r142 instanceof UDButton) == false) goto L75;
        LinearLayout.LayoutParams r143 = new LinearLayout.LayoutParams(-2, -2);
        r143.topMargin = UIHelper.dp2px(16.0f);
        ((UDButton) r142).setLayoutParams(r143);
        goto L75
    L79:
        ChatThemeInfo r144 = this.f412673c.r8();
        if (r144 != null) goto L82;
        return;
    L82:
        if (p.g(r144.getComponentScene()) == false) goto L108;
        r102.f413238d.setVisibility(0);
        FrameLayout r145 = r102.f413238d;
        r145.removeAllViews();
        r145.addView(r104);
        ViewGroup.LayoutParams r146 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r146, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r146).gravity = 1;
        Rect r147 = new Rect();
        I18nText r148 = r213.sub_title;
        if (r148 == null) goto L86;
        String r149 = r148.localized_text;
    L87:
        if (r149 != null) goto L89;
        r149 = r215;
    L89:
        r114.getPaint().getTextBounds(r149, 0, r149.length(), r147);
        int r150 = r147.width() + (UIUtils.dp2px(getContext(), 8.0f) * 2);
        Rect r151 = new Rect();
        Rect r152 = new Rect();
        I18nText r153 = r213.title;
        if (r153 == null) goto L92;
        String r154 = r153.localized_text;
    L93:
        if (r154 != null) goto L95;
        String r155 = r215;
    L96:
        I18nText r156 = r213.sub_title;
        if (r156 == null) goto L99;
        String r157 = r156.localized_text;
    L100:
        if (r157 != null) goto L102;
        String r158 = r215;
    L103:
        r110.getPaint().getTextBounds(r155, 0, r155.length(), r151);
        r114.getPaint().getTextBounds(r158, 0, r158.length(), r152);
        Integer r159 = f3b.b.a(this.f412673c);
        if (r159 == null) goto L106;
        int r160 = r159.intValue();
        Context r161 = getContext();
        Intrinsics.checkNotNullParameter(r161, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r162 = UIUtils.dp2px(r161, 24.0f);
    L107:
        int r216 = r160 - (r162 * 2);
        r214.setLayoutParams(new LinearLayout.LayoutParams(r150, ((new StaticLayout(r155, r110.getPaint(), r216, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getHeight() + new StaticLayout(r158, r114.getPaint(), r216, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getHeight()) + UIUtils.dp2px(getContext(), 4.0f)) + UIUtils.dp2px(getContext(), 4.0f)));
        return;
    L106:
        r160 = DeviceUtils.getScreenWidth(getContext());
        Context r163 = getContext();
        Intrinsics.checkNotNullParameter(r163, PerfLog.PARAM_KEY_CONTEXT_ID);
        r162 = UIUtils.dp2px(r163, 24.0f);
        goto L107
    L102:
        r158 = r157;
        goto L103
    L99:
        r157 = null;
        goto L100
    L95:
        r155 = r154;
        goto L96
    L92:
        r154 = null;
        goto L93
    L86:
        r149 = null;
        goto L87
    L108:
        r102.f413238d.setVisibility(8);
        return;
    L32:
        r120 = null;
        goto L33
    L27:
        r106 = null;
        goto L28
    L23:
        r118 = r101.lm_image;
        goto L24
    L17:
        r116 = null;
        goto L18
    L10:
        r112 = null;
    L110:
        Log.e("SysChatGuideContentBlock", "chat guide system content is empty, id：" + r312.getId());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
