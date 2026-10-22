package com.bytedance.lark.pb.basic.v1;

import androidx.core.provider.FontsContractCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.texturerender.TextureRenderKeys;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ComponentAttribute extends Enum<ComponentAttribute> implements WireEnum {
    private static final /* synthetic */ ComponentAttribute[] $VALUES = null;
    public static final ProtoAdapter<ComponentAttribute> ADAPTER = null;
    public static final ComponentAttribute action_id = null;
    public static final ComponentAttribute align_self = null;
    public static final ComponentAttribute alt = null;
    public static final ComponentAttribute aspect_ratio = null;
    public static final ComponentAttribute avatar_chatter_info = null;
    public static final ComponentAttribute background_linear_deg = null;
    public static final ComponentAttribute background_linear_theme_colors = null;
    public static final ComponentAttribute background_type = null;
    public static final ComponentAttribute border_corner_radius = null;
    public static final ComponentAttribute border_theme_color = null;
    public static final ComponentAttribute border_width = null;
    public static final ComponentAttribute chatters_count = null;
    public static final ComponentAttribute chatters_infos = null;
    public static final ComponentAttribute chatters_mode = null;
    public static final ComponentAttribute child_component_id = null;
    public static final ComponentAttribute cover_image = null;
    public static final ComponentAttribute cover_image_url = null;
    public static final ComponentAttribute cross_axis_align = null;
    public static final ComponentAttribute cross_axis_spacing = null;
    public static final ComponentAttribute date_precision_type = null;
    public static final ComponentAttribute date_status_type = null;
    public static final ComponentAttribute direction = null;
    public static final ComponentAttribute doc_type = null;
    public static final ComponentAttribute duration = null;
    public static final ComponentAttribute enable_gmt = null;
    public static final ComponentAttribute end_time_stamp = null;
    public static final ComponentAttribute favicon_url = null;
    public static final ComponentAttribute flex_wrap = null;
    public static final ComponentAttribute font_level = null;
    public static final ComponentAttribute font_size = null;
    public static final ComponentAttribute font_weight = null;
    public static final ComponentAttribute force_use_compact_mode = null;
    public static final ComponentAttribute format_type = null;
    public static final ComponentAttribute grow_weight = null;
    public static final ComponentAttribute header_tag = null;
    public static final ComponentAttribute height = null;
    public static final ComponentAttribute icon = null;
    public static final ComponentAttribute icon_color = null;
    public static final ComponentAttribute iframe_url = null;
    public static final ComponentAttribute image = null;
    public static final ComponentAttribute image_url = null;
    public static final ComponentAttribute is_countdown = null;
    public static final ComponentAttribute is_disable = null;
    public static final ComponentAttribute is_end = null;
    public static final ComponentAttribute items = null;
    public static final ComponentAttribute lark_tag = null;
    public static final ComponentAttribute main_axis_justify = null;
    public static final ComponentAttribute main_axis_spacing = null;
    public static final ComponentAttribute max_height = null;
    public static final ComponentAttribute max_show_count = null;
    public static final ComponentAttribute max_width = null;
    public static final ComponentAttribute min_height = null;
    public static final ComponentAttribute min_width = null;
    public static final ComponentAttribute mixed_tags = null;
    public static final ComponentAttribute ntp_action_id = null;
    public static final ComponentAttribute number_of_lines = null;
    public static final ComponentAttribute orientation = null;
    public static final ComponentAttribute padding = null;
    public static final ComponentAttribute secret_key = null;
    public static final ComponentAttribute secret_nonce = null;
    public static final ComponentAttribute secret_type = null;
    public static final ComponentAttribute secret_url = null;
    public static final ComponentAttribute selected_index = null;
    public static final ComponentAttribute show_close_Btn = null;
    public static final ComponentAttribute show_copy_Link_Btn = null;
    public static final ComponentAttribute shrink_weight = null;
    public static final ComponentAttribute side_padding = null;
    public static final ComponentAttribute site = null;
    public static final ComponentAttribute size_level = null;
    public static final ComponentAttribute spacing = null;
    public static final ComponentAttribute src_url = null;
    public static final ComponentAttribute start_time_stamp = null;
    public static final ComponentAttribute tagColor = null;
    public static final ComponentAttribute tagTextColor = null;
    public static final ComponentAttribute tags = null;
    public static final ComponentAttribute text = null;
    public static final ComponentAttribute theme = null;
    public static final ComponentAttribute theme_color = null;
    public static final ComponentAttribute thumbnail_url = null;
    public static final ComponentAttribute time_precision_type = null;
    public static final ComponentAttribute time_style = null;
    public static final ComponentAttribute time_zone_type = null;
    public static final ComponentAttribute title = null;
    public static final ComponentAttribute type = null;
    public static final ComponentAttribute ud_icon_key = null;
    public static final ComponentAttribute ud_icon_theme_color = null;
    public static final ComponentAttribute unicode = null;
    public static final ComponentAttribute vid = null;
    public static final ComponentAttribute width = null;
    public static final ComponentAttribute wrap_width = null;
    private final int value;

    static {
        ComponentAttribute r100 = new ComponentAttribute("orientation", 0, 1);
        orientation = r100;
        ComponentAttribute r101 = new ComponentAttribute("spacing", 1, 2);
        spacing = r101;
        ComponentAttribute r102 = new ComponentAttribute("wrap_width", 2, 3);
        wrap_width = r102;
        ComponentAttribute r103 = new ComponentAttribute(GXTemplateKey.FLEXBOX_PADDING, 3, 4);
        padding = r103;
        ComponentAttribute r104 = new ComponentAttribute("main_axis_justify", 4, 5);
        main_axis_justify = r104;
        ComponentAttribute r105 = new ComponentAttribute("cross_axis_align", 5, 6);
        cross_axis_align = r105;
        ComponentAttribute r110 = new ComponentAttribute("side_padding", 6, 7);
        side_padding = r110;
        ComponentAttribute r111 = new ComponentAttribute("icon", 7, 8);
        icon = r111;
        ComponentAttribute r112 = new ComponentAttribute("title", 8, 9);
        title = r112;
        ComponentAttribute r113 = new ComponentAttribute("lark_tag", 9, 10);
        lark_tag = r113;
        ComponentAttribute r114 = new ComponentAttribute("child_component_id", 10, 11);
        child_component_id = r114;
        ComponentAttribute r115 = new ComponentAttribute("show_copy_Link_Btn", 11, 12);
        show_copy_Link_Btn = r115;
        ComponentAttribute r106 = new ComponentAttribute("show_close_Btn", 12, 13);
        show_close_Btn = r106;
        ComponentAttribute r107 = new ComponentAttribute("theme", 13, 14);
        theme = r107;
        ComponentAttribute r108 = new ComponentAttribute("type", 14, 15);
        type = r108;
        ComponentAttribute r109 = new ComponentAttribute("theme_color", 15, 16);
        theme_color = r109;
        ComponentAttribute r116 = new ComponentAttribute("header_tag", 16, 17);
        header_tag = r116;
        ComponentAttribute r117 = new ComponentAttribute("favicon_url", 17, 18);
        favicon_url = r117;
        ComponentAttribute r118 = new ComponentAttribute("ud_icon_key", 18, 19);
        ud_icon_key = r118;
        ComponentAttribute r119 = new ComponentAttribute("ud_icon_theme_color", 19, 20);
        ud_icon_theme_color = r119;
        ComponentAttribute r120 = new ComponentAttribute("image", 20, 21);
        image = r120;
        ComponentAttribute r121 = new ComponentAttribute("alt", 21, 22);
        alt = r121;
        ComponentAttribute r122 = new ComponentAttribute("chatters_count", 22, 23);
        chatters_count = r122;
        ComponentAttribute r123 = new ComponentAttribute("chatters_infos", 23, 24);
        chatters_infos = r123;
        ComponentAttribute r124 = new ComponentAttribute("max_show_count", 24, 25);
        max_show_count = r124;
        ComponentAttribute r125 = new ComponentAttribute("text", 25, 26);
        text = r125;
        ComponentAttribute r126 = new ComponentAttribute("direction", 26, 27);
        direction = r126;
        ComponentAttribute r127 = new ComponentAttribute("action_id", 27, 28);
        action_id = r127;
        ComponentAttribute r128 = new ComponentAttribute("is_disable", 28, 29);
        is_disable = r128;
        ComponentAttribute r129 = new ComponentAttribute("start_time_stamp", 29, 30);
        start_time_stamp = r129;
        ComponentAttribute r130 = new ComponentAttribute("is_countdown", 30, 31);
        is_countdown = r130;
        ComponentAttribute r131 = new ComponentAttribute("ntp_action_id", 31, 32);
        ntp_action_id = r131;
        ComponentAttribute r132 = new ComponentAttribute("is_end", 32, 33);
        is_end = r132;
        ComponentAttribute r133 = new ComponentAttribute("end_time_stamp", 33, 34);
        end_time_stamp = r133;
        ComponentAttribute r134 = new ComponentAttribute("number_of_lines", 34, 35);
        number_of_lines = r134;
        ComponentAttribute r135 = new ComponentAttribute(PromotionProductPrivilegesStruct.TAGS, 35, 36);
        tags = r135;
        ComponentAttribute r136 = new ComponentAttribute("items", 36, 37);
        items = r136;
        ComponentAttribute r137 = new ComponentAttribute("selected_index", 37, 38);
        selected_index = r137;
        ComponentAttribute r138 = new ComponentAttribute("avatar_chatter_info", 38, 39);
        avatar_chatter_info = r138;
        ComponentAttribute r139 = new ComponentAttribute("site", 39, 40);
        site = r139;
        ComponentAttribute r140 = new ComponentAttribute("cover_image", 40, 41);
        cover_image = r140;
        ComponentAttribute r141 = new ComponentAttribute("duration", 41, 42);
        duration = r141;
        ComponentAttribute r142 = new ComponentAttribute("src_url", 42, 43);
        src_url = r142;
        ComponentAttribute r143 = new ComponentAttribute("vid", 43, 44);
        vid = r143;
        ComponentAttribute r144 = new ComponentAttribute("iframe_url", 44, 45);
        iframe_url = r144;
        ComponentAttribute r145 = new ComponentAttribute("doc_type", 45, 46);
        doc_type = r145;
        ComponentAttribute r146 = new ComponentAttribute("thumbnail_url", 46, 47);
        thumbnail_url = r146;
        ComponentAttribute r147 = new ComponentAttribute("secret_url", 47, 48);
        secret_url = r147;
        ComponentAttribute r148 = new ComponentAttribute("secret_type", 48, 49);
        secret_type = r148;
        ComponentAttribute r149 = new ComponentAttribute("secret_key", 49, 50);
        secret_key = r149;
        ComponentAttribute r150 = new ComponentAttribute("secret_nonce", 50, 51);
        secret_nonce = r150;
        ComponentAttribute r151 = new ComponentAttribute("tagColor", 51, 52);
        tagColor = r151;
        ComponentAttribute r152 = new ComponentAttribute("tagTextColor", 52, 53);
        tagTextColor = r152;
        ComponentAttribute r153 = new ComponentAttribute("icon_color", 53, 54);
        icon_color = r153;
        ComponentAttribute r154 = new ComponentAttribute("chatters_mode", 54, 55);
        chatters_mode = r154;
        ComponentAttribute r155 = new ComponentAttribute("cover_image_url", 55, 56);
        cover_image_url = r155;
        ComponentAttribute r156 = new ComponentAttribute("time_zone_type", 56, 57);
        time_zone_type = r156;
        ComponentAttribute r157 = new ComponentAttribute("format_type", 57, 58);
        format_type = r157;
        ComponentAttribute r158 = new ComponentAttribute("time_precision_type", 58, 59);
        time_precision_type = r158;
        ComponentAttribute r159 = new ComponentAttribute("time_style", 59, 60);
        time_style = r159;
        ComponentAttribute r160 = new ComponentAttribute("date_precision_type", 60, 61);
        date_precision_type = r160;
        ComponentAttribute r161 = new ComponentAttribute("date_status_type", 61, 62);
        date_status_type = r161;
        ComponentAttribute r162 = new ComponentAttribute("enable_gmt", 62, 63);
        enable_gmt = r162;
        ComponentAttribute r163 = new ComponentAttribute("image_url", 63, 64);
        image_url = r163;
        ComponentAttribute r164 = new ComponentAttribute("mixed_tags", 64, 65);
        mixed_tags = r164;
        ComponentAttribute r165 = new ComponentAttribute("font_size", 65, 66);
        font_size = r165;
        ComponentAttribute r166 = new ComponentAttribute(FontsContractCompat.Columns.WEIGHT, 66, 67);
        font_weight = r166;
        ComponentAttribute r167 = new ComponentAttribute("flex_wrap", 67, 68);
        flex_wrap = r167;
        ComponentAttribute r168 = new ComponentAttribute("main_axis_spacing", 68, 69);
        main_axis_spacing = r168;
        ComponentAttribute r169 = new ComponentAttribute("cross_axis_spacing", 69, 70);
        cross_axis_spacing = r169;
        ComponentAttribute r170 = new ComponentAttribute("force_use_compact_mode", 70, 71);
        force_use_compact_mode = r170;
        ComponentAttribute r171 = new ComponentAttribute("unicode", 71, 72);
        unicode = r171;
        ComponentAttribute r172 = new ComponentAttribute("size_level", 72, 200);
        size_level = r172;
        ComponentAttribute r173 = new ComponentAttribute("background_type", 73, 201);
        background_type = r173;
        ComponentAttribute r174 = new ComponentAttribute("background_linear_deg", 74, 202);
        background_linear_deg = r174;
        ComponentAttribute r175 = new ComponentAttribute("background_linear_theme_colors", 75, 203);
        background_linear_theme_colors = r175;
        ComponentAttribute r176 = new ComponentAttribute("width", 76, 204);
        width = r176;
        ComponentAttribute r177 = new ComponentAttribute("height", 77, 205);
        height = r177;
        ComponentAttribute r178 = new ComponentAttribute(TextureRenderKeys.KEY_IS_MAX_WIDTH, 78, 206);
        max_width = r178;
        ComponentAttribute r179 = new ComponentAttribute(TextureRenderKeys.KEY_IS_MAX_HEIGHT, 79, 207);
        max_height = r179;
        ComponentAttribute r180 = new ComponentAttribute("min_width", 80, 208);
        min_width = r180;
        ComponentAttribute r181 = new ComponentAttribute("min_height", 81, 209);
        min_height = r181;
        ComponentAttribute r182 = new ComponentAttribute("grow_weight", 82, 210);
        grow_weight = r182;
        ComponentAttribute r183 = new ComponentAttribute("shrink_weight", 83, 211);
        shrink_weight = r183;
        ComponentAttribute r184 = new ComponentAttribute("font_level", 84, 213);
        font_level = r184;
        ComponentAttribute r185 = new ComponentAttribute("border_width", 85, 214);
        border_width = r185;
        ComponentAttribute r186 = new ComponentAttribute("border_corner_radius", 86, 215);
        border_corner_radius = r186;
        ComponentAttribute r187 = new ComponentAttribute("border_theme_color", 87, 216);
        border_theme_color = r187;
        ComponentAttribute r188 = new ComponentAttribute(TextureRenderKeys.KEY_IS_ASPECT_RATIO, 88, 217);
        aspect_ratio = r188;
        ComponentAttribute r189 = new ComponentAttribute("align_self", 89, 218);
        align_self = r189;
        $VALUES = new ComponentAttribute[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189};
        ADAPTER = ProtoAdapter.newEnumAdapter(ComponentAttribute.class);
    }

    public static ComponentAttribute[] values() {
        return (ComponentAttribute[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ComponentAttribute fromValue(int r100) {
        switch(r100) {
            case 1: goto L186;
            case 2: goto L184;
            case 3: goto L182;
            case 4: goto L180;
            case 5: goto L178;
            case 6: goto L176;
            case 7: goto L174;
            case 8: goto L172;
            case 9: goto L170;
            case 10: goto L168;
            case 11: goto L166;
            case 12: goto L164;
            case 13: goto L162;
            case 14: goto L160;
            case 15: goto L158;
            case 16: goto L156;
            case 17: goto L154;
            case 18: goto L152;
            case 19: goto L150;
            case 20: goto L148;
            case 21: goto L146;
            case 22: goto L144;
            case 23: goto L142;
            case 24: goto L140;
            case 25: goto L138;
            case 26: goto L136;
            case 27: goto L134;
            case 28: goto L132;
            case 29: goto L130;
            case 30: goto L128;
            case 31: goto L126;
            case 32: goto L124;
            case 33: goto L122;
            case 34: goto L120;
            case 35: goto L118;
            case 36: goto L116;
            case 37: goto L114;
            case 38: goto L112;
            case 39: goto L110;
            case 40: goto L108;
            case 41: goto L106;
            case 42: goto L104;
            case 43: goto L102;
            case 44: goto L100;
            case 45: goto L98;
            case 46: goto L96;
            case 47: goto L94;
            case 48: goto L92;
            case 49: goto L90;
            case 50: goto L88;
            case 51: goto L86;
            case 52: goto L84;
            case 53: goto L82;
            case 54: goto L80;
            case 55: goto L78;
            case 56: goto L76;
            case 57: goto L74;
            case 58: goto L72;
            case 59: goto L70;
            case 60: goto L68;
            case 61: goto L66;
            case 62: goto L64;
            case 63: goto L62;
            case 64: goto L60;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L54;
            case 68: goto L52;
            case 69: goto L50;
            case 70: goto L48;
            case 71: goto L46;
            case 72: goto L44;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 200: goto L42;
            case 201: goto L40;
            case 202: goto L38;
            case 203: goto L36;
            case 204: goto L34;
            case 205: goto L32;
            case 206: goto L30;
            case 207: goto L28;
            case 208: goto L26;
            case 209: goto L24;
            case 210: goto L22;
            case 211: goto L20;
            default: goto L4;
        };
    L4:
        switch(r100) {
            case 213: goto L18;
            case 214: goto L16;
            case 215: goto L14;
            case 216: goto L12;
            case 217: goto L10;
            case 218: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return align_self;
    L10:
        return aspect_ratio;
    L12:
        return border_theme_color;
    L14:
        return border_corner_radius;
    L16:
        return border_width;
    L18:
        return font_level;
    L20:
        return shrink_weight;
    L22:
        return grow_weight;
    L24:
        return min_height;
    L26:
        return min_width;
    L28:
        return max_height;
    L30:
        return max_width;
    L32:
        return height;
    L34:
        return width;
    L36:
        return background_linear_theme_colors;
    L38:
        return background_linear_deg;
    L40:
        return background_type;
    L42:
        return size_level;
    L44:
        return unicode;
    L46:
        return force_use_compact_mode;
    L48:
        return cross_axis_spacing;
    L50:
        return main_axis_spacing;
    L52:
        return flex_wrap;
    L54:
        return font_weight;
    L56:
        return font_size;
    L58:
        return mixed_tags;
    L60:
        return image_url;
    L62:
        return enable_gmt;
    L64:
        return date_status_type;
    L66:
        return date_precision_type;
    L68:
        return time_style;
    L70:
        return time_precision_type;
    L72:
        return format_type;
    L74:
        return time_zone_type;
    L76:
        return cover_image_url;
    L78:
        return chatters_mode;
    L80:
        return icon_color;
    L82:
        return tagTextColor;
    L84:
        return tagColor;
    L86:
        return secret_nonce;
    L88:
        return secret_key;
    L90:
        return secret_type;
    L92:
        return secret_url;
    L94:
        return thumbnail_url;
    L96:
        return doc_type;
    L98:
        return iframe_url;
    L100:
        return vid;
    L102:
        return src_url;
    L104:
        return duration;
    L106:
        return cover_image;
    L108:
        return site;
    L110:
        return avatar_chatter_info;
    L112:
        return selected_index;
    L114:
        return items;
    L116:
        return tags;
    L118:
        return number_of_lines;
    L120:
        return end_time_stamp;
    L122:
        return is_end;
    L124:
        return ntp_action_id;
    L126:
        return is_countdown;
    L128:
        return start_time_stamp;
    L130:
        return is_disable;
    L132:
        return action_id;
    L134:
        return direction;
    L136:
        return text;
    L138:
        return max_show_count;
    L140:
        return chatters_infos;
    L142:
        return chatters_count;
    L144:
        return alt;
    L146:
        return image;
    L148:
        return ud_icon_theme_color;
    L150:
        return ud_icon_key;
    L152:
        return favicon_url;
    L154:
        return header_tag;
    L156:
        return theme_color;
    L158:
        return type;
    L160:
        return theme;
    L162:
        return show_close_Btn;
    L164:
        return show_copy_Link_Btn;
    L166:
        return child_component_id;
    L168:
        return lark_tag;
    L170:
        return title;
    L172:
        return icon;
    L174:
        return side_padding;
    L176:
        return cross_axis_align;
    L178:
        return main_axis_justify;
    L180:
        return padding;
    L182:
        return wrap_width;
    L184:
        return spacing;
    L186:
        return orientation;
    }

    public static ComponentAttribute valueOf(String r100) {
        return (ComponentAttribute) a.a(ComponentAttribute.class, r100);
    }

    private ComponentAttribute(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
