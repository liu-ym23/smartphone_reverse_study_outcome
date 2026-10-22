package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.drawable.RoundedDrawable;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MsgBubbleUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416621a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/utils/MsgBubbleUtil$GroupMode;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GroupMode {
        public static final int ALONE = 0;
        public static final int BOTTOM = 3;
        public static final a Companion = null;
        public static final int MIDDLE = 2;
        public static final int NONE = 4;
        public static final int TOP = 1;
        public static final int UNKNOWN = -1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f416622a = null;

            static {
                f416622a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f416622a;
        }
    }

    static {
    }

    public static int b(View r100, View r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r101 != null) goto L7;
        return 0;
    L7:
        if (r100 != null) goto L10;
        return 0;
    L10:
        return ((int) r100.getY()) + b((View) r100.getParent(), r101);
    }

    public static RoundedDrawable a(View r210, @BubbleStyle.ColorType int r310, boolean r311, @GroupMode int r312, int[] r313, boolean r314) {
        if (r312 != (-1)) goto L6;
        return null;
    L6:
        if (r312 != 0) goto L8;
        if (r311 == false) goto L52;
        int r100 = UIHelper.dp2px(10.0f);
    L53:
        if (r311 == false) goto L55;
        int r110 = 0;
    L56:
        if (r311 == false) goto L58;
        int r111 = UIHelper.dp2px(10.0f);
    L59:
        if (r311 == false) goto L61;
    L60:
        int r101 = 0;
    L62:
        float[] r102 = {0.0f, 0.0f, 0.0f, 0.0f};
        if (r314 == true) goto L65;
        r102[0] = r100;
        r102[1] = r110;
        r102[2] = r111;
        r102[3] = r101;
    L66:
        if (r313 != null) goto L68;
        if (r311 == false) goto L71;
        int r211 = 2;
    L72:
        Context r103 = r210.getContext();
        if (r310 == 0) goto L105;
        if (r310 != 1) goto L76;
        int r104 = p3b.a.b(false);
    L106:
        int r112 = r104;
        int r105 = -1;
    L107:
        int r212 = UIHelper.dp2px(1.0f);
        if (r105 == (-1)) goto L111;
        return new RoundedDrawable(r102[0], r102[1], r102[2], r102[3], r105, r212, r112, r112, r211);
    L111:
        return new RoundedDrawable(r102[0], r102[1], r102[2], r102[3], 0, 0, r112, r112, 0);
    L76:
        if (r310 != 2) goto L78;
        int r106 = UIUtils.getColor(r103, R.color.bg_body);
        r105 = UIUtils.getColor(r103, R.color.line_border_component);
    L103:
        r112 = r106;
        goto L107
    L78:
        if (r310 != 7) goto L80;
        r106 = p3b.a.b(false);
        r105 = UIUtils.getColor(r103, R.color.line_border_card);
        goto L103
    L80:
        if (r310 != 8) goto L82;
        r106 = p3b.a.b(true);
        r105 = UIUtils.getColor(r103, R.color.line_border_card);
        goto L103
    L82:
        if (r310 != 10) goto L84;
        r106 = UIUtils.getColor(r103, R.color.static_white);
        r105 = UIUtils.getColor(r103, R.color.chat_card_static_border);
        goto L103
    L84:
        if (r310 != 12) goto L86;
        r106 = UIUtils.getColor(r103, R.color.bg_float);
        r105 = UIUtils.getColor(r103, R.color.imtoken_message_card_border);
        goto L103
    L86:
        if (r310 == 15) goto L97;
        switch(r310) {
            case 17: goto L93;
            case 18: goto L92;
            case 19: goto L91;
            default: goto L89;
        };
    L91:
        r106 = UIUtils.getColor(r103, R.color.bg_float);
        r105 = UIUtils.getColor(r103, R.color.line_border_card);
        goto L103
    L92:
        r106 = UIUtils.getColor(r103, R.color.udtoken_message_card_bg_light_neutral);
        r105 = UIUtils.getColor(r103, R.color.line_border_card);
        goto L103
    L93:
        r106 = UIUtils.getColor(r103, R.color.bg_body);
        r105 = UIUtils.getColor(r103, R.color.line_border_card);
        goto L103
    L89:
        switch(r310) {
            case 113: goto L96;
            case 114: goto L95;
            case 115: goto L94;
            default: goto L90;
        };
    L90:
        return null;
    L94:
        r106 = UIUtils.getColor(r103, R.color.bg_float);
        r105 = UIUtils.getColor(r103, R.color.url_preview_border_only_dark_mode);
        goto L103
    L95:
        r106 = UIUtils.getColor(r103, R.color.bg_float);
        r105 = UIUtils.getColor(r103, R.color.url_preview_border_only_light_mode);
        goto L103
    L96:
        r106 = UIUtils.getColor(r103, R.color.bg_float);
        r105 = UIUtils.getColor(r103, R.color.url_preview_border_only_light_mode);
        goto L103
    L97:
        r106 = UIUtils.getColor(r103, R.color.udtoken_message_card_bg_light_neutral);
        r105 = UIUtils.getColor(r103, R.color.imtoken_message_card_border);
        goto L103
    L105:
        r104 = p3b.a.b(true);
        goto L106
    L71:
        r211 = 1;
        goto L72
    L68:
        return new RoundedDrawable(r102[0], r102[1], r102[2], r102[3], 0, 0, r313[0], r313[1], 0);
    L65:
        r102[0] = r111;
        r102[1] = r101;
        r102[2] = r100;
        r102[3] = r110;
        goto L66
    L61:
        r101 = UIHelper.dp2px(10.0f);
        goto L62
    L58:
        r111 = 0;
        goto L59
    L55:
        r110 = UIHelper.dp2px(10.0f);
        goto L56
    L52:
        r100 = 0;
        goto L53
    L8:
        if (r312 == 1) goto L38;
        if (r312 == 2) goto L26;
        if (r312 == 3) goto L14;
        if (r312 == 4) goto L13;
        return null;
    L13:
        r100 = 0;
        r101 = 0;
        r110 = 0;
        r111 = 0;
        goto L62
    L14:
        if (r311 == false) goto L16;
        r100 = UIHelper.dp2px(2.0f);
    L17:
        if (r311 == false) goto L19;
        r110 = 0;
    L20:
        if (r311 == false) goto L22;
        r111 = UIHelper.dp2px(10.0f);
    L23:
        if (r311 == true) goto L60;
        r101 = UIHelper.dp2px(10.0f);
        goto L62
    L22:
        r111 = 0;
        goto L23
    L19:
        r110 = UIHelper.dp2px(10.0f);
        goto L20
    L16:
        r100 = 0;
        goto L17
    L26:
        if (r311 == false) goto L28;
        r100 = UIHelper.dp2px(2.0f);
    L29:
        if (r311 == false) goto L31;
        r110 = 0;
    L32:
        if (r311 == false) goto L34;
        r111 = UIHelper.dp2px(10.0f);
    L35:
        if (r311 == true) goto L60;
        r101 = UIHelper.dp2px(10.0f);
        goto L62
    L34:
        r111 = 0;
        goto L35
    L31:
        r110 = UIHelper.dp2px(2.0f);
        goto L32
    L28:
        r100 = 0;
        goto L29
    L38:
        if (r311 == false) goto L40;
        r100 = UIHelper.dp2px(10.0f);
    L41:
        if (r311 == false) goto L43;
        r110 = 0;
    L44:
        if (r311 == false) goto L46;
        r111 = UIHelper.dp2px(10.0f);
    L47:
        if (r311 == true) goto L60;
        r101 = UIHelper.dp2px(10.0f);
        goto L62
    L46:
        r111 = 0;
        goto L47
    L43:
        r110 = UIHelper.dp2px(2.0f);
        goto L44
    L40:
        r100 = 0;
        goto L41
    }

    @JvmStatic
    public static final void c(View r110, @BubbleStyle.ColorType int r210, View r211, @GroupMode int r212, int[] r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (r210 != 3) goto L5;
        Drawable r111 = a(r110, 8, true, r212, null, r214);
        RoundedDrawable r100 = a(r110, 2, false, r212, null, r214);
    L59:
        r110.setBackground(new com.ss.android.lark.chat.drawable.a(r111, r100, new s0(r211, r110)));
        return;
    L5:
        if (r210 != 4) goto L7;
        r111 = a(r110, 7, true, r212, null, r214);
        r100 = a(r110, 2, false, r212, null, r214);
        goto L59
    L7:
        if (r210 != 6) goto L9;
        r111 = a(r110, r210, true, r212, r213, r214);
        r100 = a(r110, 2, false, r212, null, r214);
        goto L59
    L9:
        if (r210 != 11) goto L11;
        r111 = a(r110, r210, true, r212, r213, r214);
        r100 = a(r110, 10, false, r212, null, r214);
        goto L59
    L11:
        if (r210 != 13) goto L13;
        r111 = a(r110, r210, true, r212, r213, r214);
        r100 = a(r110, 12, false, r212, null, r214);
        goto L59
    L13:
        if (r210 == 14) goto L53;
        switch(r210) {
            case 100: goto L19;
            case 101: goto L19;
            case 102: goto L19;
            case 103: goto L19;
            case 104: goto L19;
            case 105: goto L19;
            case 106: goto L19;
            case 107: goto L19;
            case 108: goto L19;
            case 109: goto L19;
            case 110: goto L19;
            case 111: goto L19;
            case 112: goto L19;
            default: goto L15;
        };
    L15:
        r111 = a(r110, r210, true, r212, null, r214);
        if (r210 != 0) goto L52;
        if (r211 == null) goto L52;
        r100 = a(r110, 2, false, r212, null, r214);
    L52:
        r100 = a(r110, r210, false, r212, null, r214);
        goto L59
    L19:
        Context r101 = r110.getContext();
        hz7.a r102 = new hz7.a();
        switch(r210) {
            case 101: goto L33;
            case 102: goto L32;
            case 103: goto L31;
            case 104: goto L30;
            case 105: goto L29;
            case 106: goto L28;
            case 107: goto L27;
            case 108: goto L26;
            case 109: goto L25;
            case 110: goto L24;
            case 111: goto L23;
            case 112: goto L22;
            default: goto L34;
        };
    L22:
        int r103 = R.color.udtoken_message_card_bg_indigo;
    L35:
        r102.setColor(UDColorUtils.getColor(r101, r103));
        if (r210 != 100) goto L38;
        int r104 = R.color.udtoken_message_card_bg_mask_special;
    L39:
        r102.b(UDColorUtils.getColor(r101, r104));
        r102.f487713f = DeviceUtils.getScreenDensity(r101);
        float r105 = h18.d.a(r101, 10.0f);
        float r106 = h18.d.a(r101, 2.0f);
        if (r212 == 2) goto L43;
        if (r212 == 3) goto L43;
    L44:
        float r112 = r105;
    L46:
        if (r212 == 2) goto L49;
        if (r212 == 3) goto L49;
    L51:
        GradientDrawable r113 = new GradientDrawable();
        r113.setStroke(UIHelper.dp2px(1.0f), UDColorUtils.getColor(r101, R.color.imtoken_message_card_border));
        r113.setCornerRadii(new float[]{r112, r112, r105, r105, 0.0f, 0.0f, 0.0f, 0.0f});
        r111 = new LayerDrawable(new Drawable[]{r102, new InsetDrawable(r113, 0, 0, 0, -2)});
        r100 = a(r110, 12, false, r212, null, r214);
    L49:
        if (r214 == false) goto L51;
        r105 = r106;
    L43:
        if (r214 == true) goto L44;
        r112 = r106;
        goto L46
    L38:
        r104 = R.color.udtoken_message_card_bg_mask_general;
        goto L39
    L23:
        r103 = R.color.udtoken_message_card_bg_purple;
        goto L35
    L24:
        r103 = R.color.udtoken_message_card_bg_violet;
        goto L35
    L25:
        r103 = R.color.udtoken_message_card_bg_carmine;
        goto L35
    L26:
        r103 = R.color.udtoken_message_card_bg_red;
        goto L35
    L27:
        r103 = R.color.udtoken_message_card_bg_orange;
        goto L35
    L28:
        r103 = R.color.udtoken_message_card_bg_yellow;
        goto L35
    L29:
        r103 = R.color.udtoken_message_card_bg_lime;
        goto L35
    L30:
        r103 = R.color.udtoken_message_card_bg_green;
        goto L35
    L31:
        r103 = R.color.udtoken_message_card_bg_turquoise;
        goto L35
    L32:
        r103 = R.color.udtoken_message_card_bg_wathet;
        goto L35
    L33:
        r103 = R.color.udtoken_message_card_bg_blue;
        goto L35
    L34:
        r103 = R.color.udtoken_message_card_bg_neutral;
        goto L35
    L53:
        r111 = a(r110, 15, true, r212, null, r214);
        r100 = a(r110, 12, false, r212, null, r214);
        goto L59
    }
}
