package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Xml;
import androidx.core.provider.FontsContractCompat;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeature;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.dora.impl.ota.g2.j0;
import com.lynx.canvas.KryptonCamera;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.tencent.open.SocialConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes22.dex */
public final class SVGParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SVG f272937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SVG.h0 f272938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f272939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f272940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f272941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SVGElem f272942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StringBuilder f272943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f272944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public StringBuilder f272945i;

    public static final enum SVGAttr extends Enum<SVGAttr> {
        public static final SVGAttr CLASS = null;
        public static final SVGAttr UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, SVGAttr> f272946a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ SVGAttr[] f272947b = null;
        public static final SVGAttr clip = null;
        public static final SVGAttr clipPathUnits = null;
        public static final SVGAttr clip_path = null;
        public static final SVGAttr clip_rule = null;
        public static final SVGAttr color = null;

        /* JADX INFO: renamed from: cx, reason: collision with root package name */
        public static final SVGAttr f272948cx = null;

        /* JADX INFO: renamed from: cy, reason: collision with root package name */
        public static final SVGAttr f272949cy = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SVGAttr f272950d = null;
        public static final SVGAttr direction = null;
        public static final SVGAttr display = null;

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        public static final SVGAttr f272951dx = null;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        public static final SVGAttr f272952dy = null;
        public static final SVGAttr fill = null;
        public static final SVGAttr fill_opacity = null;
        public static final SVGAttr fill_rule = null;
        public static final SVGAttr font = null;
        public static final SVGAttr font_family = null;
        public static final SVGAttr font_size = null;
        public static final SVGAttr font_style = null;
        public static final SVGAttr font_weight = null;

        /* JADX INFO: renamed from: fx, reason: collision with root package name */
        public static final SVGAttr f272953fx = null;

        /* JADX INFO: renamed from: fy, reason: collision with root package name */
        public static final SVGAttr f272954fy = null;
        public static final SVGAttr gradientTransform = null;
        public static final SVGAttr gradientUnits = null;
        public static final SVGAttr height = null;
        public static final SVGAttr href = null;
        public static final SVGAttr image_rendering = null;
        public static final SVGAttr marker = null;
        public static final SVGAttr markerHeight = null;
        public static final SVGAttr markerUnits = null;
        public static final SVGAttr markerWidth = null;
        public static final SVGAttr marker_end = null;
        public static final SVGAttr marker_mid = null;
        public static final SVGAttr marker_start = null;
        public static final SVGAttr mask = null;
        public static final SVGAttr maskContentUnits = null;
        public static final SVGAttr maskUnits = null;
        public static final SVGAttr media = null;
        public static final SVGAttr offset = null;
        public static final SVGAttr opacity = null;
        public static final SVGAttr orient = null;
        public static final SVGAttr overflow = null;
        public static final SVGAttr pathLength = null;
        public static final SVGAttr patternContentUnits = null;
        public static final SVGAttr patternTransform = null;
        public static final SVGAttr patternUnits = null;
        public static final SVGAttr points = null;
        public static final SVGAttr preserveAspectRatio = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final SVGAttr f272955r = null;
        public static final SVGAttr refX = null;
        public static final SVGAttr refY = null;
        public static final SVGAttr requiredExtensions = null;
        public static final SVGAttr requiredFeatures = null;
        public static final SVGAttr requiredFonts = null;
        public static final SVGAttr requiredFormats = null;

        /* JADX INFO: renamed from: rx, reason: collision with root package name */
        public static final SVGAttr f272956rx = null;

        /* JADX INFO: renamed from: ry, reason: collision with root package name */
        public static final SVGAttr f272957ry = null;
        public static final SVGAttr solid_color = null;
        public static final SVGAttr solid_opacity = null;
        public static final SVGAttr spreadMethod = null;
        public static final SVGAttr startOffset = null;
        public static final SVGAttr stop_color = null;
        public static final SVGAttr stop_opacity = null;
        public static final SVGAttr stroke = null;
        public static final SVGAttr stroke_dasharray = null;
        public static final SVGAttr stroke_dashoffset = null;
        public static final SVGAttr stroke_linecap = null;
        public static final SVGAttr stroke_linejoin = null;
        public static final SVGAttr stroke_miterlimit = null;
        public static final SVGAttr stroke_opacity = null;
        public static final SVGAttr stroke_width = null;
        public static final SVGAttr style = null;
        public static final SVGAttr systemLanguage = null;
        public static final SVGAttr text_anchor = null;
        public static final SVGAttr text_decoration = null;
        public static final SVGAttr transform = null;
        public static final SVGAttr type = null;
        public static final SVGAttr vector_effect = null;
        public static final SVGAttr version = null;
        public static final SVGAttr viewBox = null;
        public static final SVGAttr viewport_fill = null;
        public static final SVGAttr viewport_fill_opacity = null;
        public static final SVGAttr visibility = null;
        public static final SVGAttr width = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final SVGAttr f272958x = null;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public static final SVGAttr f272959x1 = null;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        public static final SVGAttr f272960x2 = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final SVGAttr f272961y = null;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public static final SVGAttr f272962y1 = null;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        public static final SVGAttr f272963y2 = null;

        static {
            SVGAttr r100 = new SVGAttr("CLASS", 0);
            CLASS = r100;
            SVGAttr r101 = new SVGAttr("clip", 1);
            clip = r101;
            SVGAttr r102 = new SVGAttr("clip_path", 2);
            clip_path = r102;
            SVGAttr r103 = new SVGAttr("clipPathUnits", 3);
            clipPathUnits = r103;
            SVGAttr r104 = new SVGAttr("clip_rule", 4);
            clip_rule = r104;
            SVGAttr r105 = new SVGAttr("color", 5);
            color = r105;
            SVGAttr r110 = new SVGAttr("cx", 6);
            f272948cx = r110;
            SVGAttr r111 = new SVGAttr("cy", 7);
            f272949cy = r111;
            SVGAttr r112 = new SVGAttr("direction", 8);
            direction = r112;
            SVGAttr r113 = new SVGAttr("dx", 9);
            f272951dx = r113;
            SVGAttr r114 = new SVGAttr("dy", 10);
            f272952dy = r114;
            SVGAttr r115 = new SVGAttr("fx", 11);
            f272953fx = r115;
            SVGAttr r106 = new SVGAttr("fy", 12);
            f272954fy = r106;
            SVGAttr r107 = new SVGAttr("d", 13);
            f272950d = r107;
            SVGAttr r108 = new SVGAttr("display", 14);
            display = r108;
            SVGAttr r109 = new SVGAttr(LynxVideoManagerLite.FILL, 15);
            fill = r109;
            SVGAttr r116 = new SVGAttr("fill_rule", 16);
            fill_rule = r116;
            SVGAttr r117 = new SVGAttr("fill_opacity", 17);
            fill_opacity = r117;
            SVGAttr r118 = new SVGAttr(LynxResourceModule.FONT_TYPE, 18);
            font = r118;
            SVGAttr r119 = new SVGAttr("font_family", 19);
            font_family = r119;
            SVGAttr r120 = new SVGAttr("font_size", 20);
            font_size = r120;
            SVGAttr r121 = new SVGAttr(FontsContractCompat.Columns.WEIGHT, 21);
            font_weight = r121;
            SVGAttr r122 = new SVGAttr("font_style", 22);
            font_style = r122;
            SVGAttr r123 = new SVGAttr("gradientTransform", 23);
            gradientTransform = r123;
            SVGAttr r124 = new SVGAttr("gradientUnits", 24);
            gradientUnits = r124;
            SVGAttr r125 = new SVGAttr("height", 25);
            height = r125;
            SVGAttr r126 = new SVGAttr("href", 26);
            href = r126;
            SVGAttr r127 = new SVGAttr("image_rendering", 27);
            image_rendering = r127;
            SVGAttr r128 = new SVGAttr("marker", 28);
            marker = r128;
            SVGAttr r129 = new SVGAttr("marker_start", 29);
            marker_start = r129;
            SVGAttr r130 = new SVGAttr("marker_mid", 30);
            marker_mid = r130;
            SVGAttr r131 = new SVGAttr("marker_end", 31);
            marker_end = r131;
            SVGAttr r132 = new SVGAttr("markerHeight", 32);
            markerHeight = r132;
            SVGAttr r133 = new SVGAttr("markerUnits", 33);
            markerUnits = r133;
            SVGAttr r134 = new SVGAttr("markerWidth", 34);
            markerWidth = r134;
            SVGAttr r135 = new SVGAttr(BuyNowCloseMethod.MASK, 35);
            mask = r135;
            SVGAttr r136 = new SVGAttr("maskContentUnits", 36);
            maskContentUnits = r136;
            SVGAttr r137 = new SVGAttr("maskUnits", 37);
            maskUnits = r137;
            SVGAttr r138 = new SVGAttr("media", 38);
            media = r138;
            SVGAttr r139 = new SVGAttr("offset", 39);
            offset = r139;
            SVGAttr r140 = new SVGAttr(GXTemplateKey.STYLE_OPACITY, 40);
            opacity = r140;
            SVGAttr r141 = new SVGAttr("orient", 41);
            orient = r141;
            SVGAttr r142 = new SVGAttr("overflow", 42);
            overflow = r142;
            SVGAttr r143 = new SVGAttr("pathLength", 43);
            pathLength = r143;
            SVGAttr r144 = new SVGAttr("patternContentUnits", 44);
            patternContentUnits = r144;
            SVGAttr r145 = new SVGAttr("patternTransform", 45);
            patternTransform = r145;
            SVGAttr r146 = new SVGAttr("patternUnits", 46);
            patternUnits = r146;
            SVGAttr r147 = new SVGAttr("points", 47);
            points = r147;
            SVGAttr r148 = new SVGAttr("preserveAspectRatio", 48);
            preserveAspectRatio = r148;
            SVGAttr r149 = new SVGAttr("r", 49);
            f272955r = r149;
            SVGAttr r150 = new SVGAttr("refX", 50);
            refX = r150;
            SVGAttr r151 = new SVGAttr("refY", 51);
            refY = r151;
            SVGAttr r152 = new SVGAttr("requiredFeatures", 52);
            requiredFeatures = r152;
            SVGAttr r153 = new SVGAttr("requiredExtensions", 53);
            requiredExtensions = r153;
            SVGAttr r154 = new SVGAttr("requiredFormats", 54);
            requiredFormats = r154;
            SVGAttr r155 = new SVGAttr("requiredFonts", 55);
            requiredFonts = r155;
            SVGAttr r156 = new SVGAttr("rx", 56);
            f272956rx = r156;
            SVGAttr r157 = new SVGAttr("ry", 57);
            f272957ry = r157;
            SVGAttr r158 = new SVGAttr("solid_color", 58);
            solid_color = r158;
            SVGAttr r159 = new SVGAttr("solid_opacity", 59);
            solid_opacity = r159;
            SVGAttr r160 = new SVGAttr("spreadMethod", 60);
            spreadMethod = r160;
            SVGAttr r161 = new SVGAttr("startOffset", 61);
            startOffset = r161;
            SVGAttr r162 = new SVGAttr("stop_color", 62);
            stop_color = r162;
            SVGAttr r163 = new SVGAttr("stop_opacity", 63);
            stop_opacity = r163;
            SVGAttr r164 = new SVGAttr("stroke", 64);
            stroke = r164;
            SVGAttr r165 = new SVGAttr("stroke_dasharray", 65);
            stroke_dasharray = r165;
            SVGAttr r166 = new SVGAttr("stroke_dashoffset", 66);
            stroke_dashoffset = r166;
            SVGAttr r167 = new SVGAttr("stroke_linecap", 67);
            stroke_linecap = r167;
            SVGAttr r168 = new SVGAttr("stroke_linejoin", 68);
            stroke_linejoin = r168;
            SVGAttr r169 = new SVGAttr("stroke_miterlimit", 69);
            stroke_miterlimit = r169;
            SVGAttr r170 = new SVGAttr("stroke_opacity", 70);
            stroke_opacity = r170;
            SVGAttr r171 = new SVGAttr(KFFeature.STROKE_WIDTH_JSON_FIELD, 71);
            stroke_width = r171;
            SVGAttr r172 = new SVGAttr("style", 72);
            style = r172;
            SVGAttr r173 = new SVGAttr("systemLanguage", 73);
            systemLanguage = r173;
            SVGAttr r174 = new SVGAttr("text_anchor", 74);
            text_anchor = r174;
            SVGAttr r175 = new SVGAttr("text_decoration", 75);
            text_decoration = r175;
            SVGAttr r176 = new SVGAttr("transform", 76);
            transform = r176;
            SVGAttr r177 = new SVGAttr("type", 77);
            type = r177;
            SVGAttr r178 = new SVGAttr("vector_effect", 78);
            vector_effect = r178;
            SVGAttr r179 = new SVGAttr("version", 79);
            version = r179;
            SVGAttr r180 = new SVGAttr("viewBox", 80);
            viewBox = r180;
            SVGAttr r181 = new SVGAttr("width", 81);
            width = r181;
            SVGAttr r182 = new SVGAttr("x", 82);
            f272958x = r182;
            SVGAttr r183 = new SVGAttr("y", 83);
            f272961y = r183;
            SVGAttr r184 = new SVGAttr("x1", 84);
            f272959x1 = r184;
            SVGAttr r185 = new SVGAttr("y1", 85);
            f272962y1 = r185;
            SVGAttr r186 = new SVGAttr("x2", 86);
            f272960x2 = r186;
            SVGAttr r187 = new SVGAttr("y2", 87);
            f272963y2 = r187;
            SVGAttr r188 = new SVGAttr("viewport_fill", 88);
            viewport_fill = r188;
            SVGAttr r189 = new SVGAttr("viewport_fill_opacity", 89);
            viewport_fill_opacity = r189;
            SVGAttr r190 = new SVGAttr(RemoteMessageConst.Notification.VISIBILITY, 90);
            visibility = r190;
            SVGAttr r191 = new SVGAttr("UNSUPPORTED", 91);
            UNSUPPORTED = r191;
            f272947b = new SVGAttr[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191};
            f272946a = new HashMap();
            SVGAttr[] r192 = values();
            int r193 = r192.length;
            int r194 = 0;
        L3:
            if (r194 >= r193) goto L12;
            SVGAttr r195 = r192[r194];
            if (r195 != CLASS) goto L8;
            f272946a.put("class", r195);
        L11:
            r194 = r194 + 1;
            goto L3
        L8:
            if (r195 == UNSUPPORTED) goto L11;
            f272946a.put(r195.name().replace('_', '-'), r195);
            goto L11
        }

        public static SVGAttr[] values() {
            return (SVGAttr[]) f272947b.clone();
        }

        public static SVGAttr fromString(String r100) {
            SVGAttr r101 = (SVGAttr) ((HashMap) f272946a).get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return UNSUPPORTED;
        }

        public static SVGAttr valueOf(String r100) {
            return (SVGAttr) r27.a.a(SVGAttr.class, r100);
        }

        public SVGAttr(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SVGElem extends Enum<SVGElem> {
        public static final SVGElem SWITCH = null;
        public static final SVGElem UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SVGElem f272964a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, SVGElem> f272965b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ SVGElem[] f272966c = null;
        public static final SVGElem circle = null;
        public static final SVGElem clipPath = null;
        public static final SVGElem defs = null;
        public static final SVGElem desc = null;
        public static final SVGElem ellipse = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final SVGElem f272967g = null;
        public static final SVGElem image = null;
        public static final SVGElem line = null;
        public static final SVGElem linearGradient = null;
        public static final SVGElem marker = null;
        public static final SVGElem mask = null;
        public static final SVGElem path = null;
        public static final SVGElem pattern = null;
        public static final SVGElem polygon = null;
        public static final SVGElem polyline = null;
        public static final SVGElem radialGradient = null;
        public static final SVGElem rect = null;
        public static final SVGElem solidColor = null;
        public static final SVGElem stop = null;
        public static final SVGElem style = null;
        public static final SVGElem svg = null;
        public static final SVGElem symbol = null;
        public static final SVGElem text = null;
        public static final SVGElem textPath = null;
        public static final SVGElem title = null;
        public static final SVGElem tref = null;
        public static final SVGElem tspan = null;
        public static final SVGElem use = null;
        public static final SVGElem view = null;

        static {
            SVGElem r100 = new SVGElem("svg", 0);
            svg = r100;
            SVGElem r101 = new SVGElem(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, 1);
            f272964a = r101;
            SVGElem r102 = new SVGElem(SVGRenderEngine.CIRCLE, 2);
            circle = r102;
            SVGElem r103 = new SVGElem(SVGRenderEngine.CLIP_PATH, 3);
            clipPath = r103;
            SVGElem r104 = new SVGElem("defs", 4);
            defs = r104;
            SVGElem r105 = new SVGElem(SocialConstants.PARAM_APP_DESC, 5);
            desc = r105;
            SVGElem r110 = new SVGElem(SVGRenderEngine.ELLIPSE, 6);
            ellipse = r110;
            SVGElem r111 = new SVGElem(ce.f26391f, 7);
            f272967g = r111;
            SVGElem r112 = new SVGElem("image", 8);
            image = r112;
            SVGElem r113 = new SVGElem("line", 9);
            line = r113;
            SVGElem r114 = new SVGElem(SVGRenderEngine.LINEAR_GRADIENT, 10);
            linearGradient = r114;
            SVGElem r115 = new SVGElem("marker", 11);
            marker = r115;
            SVGElem r106 = new SVGElem(BuyNowCloseMethod.MASK, 12);
            mask = r106;
            SVGElem r107 = new SVGElem("path", 13);
            path = r107;
            SVGElem r108 = new SVGElem("pattern", 14);
            pattern = r108;
            SVGElem r109 = new SVGElem(SVGRenderEngine.POLYGON, 15);
            polygon = r109;
            SVGElem r116 = new SVGElem(SVGRenderEngine.POLYLINE, 16);
            polyline = r116;
            SVGElem r117 = new SVGElem(SVGRenderEngine.RADIAL_GRADIENT, 17);
            radialGradient = r117;
            SVGElem r118 = new SVGElem(SVGRenderEngine.RECT, 18);
            rect = r118;
            SVGElem r119 = new SVGElem("solidColor", 19);
            solidColor = r119;
            SVGElem r120 = new SVGElem("stop", 20);
            stop = r120;
            SVGElem r121 = new SVGElem("style", 21);
            style = r121;
            SVGElem r122 = new SVGElem("SWITCH", 22);
            SWITCH = r122;
            SVGElem r123 = new SVGElem("symbol", 23);
            symbol = r123;
            SVGElem r124 = new SVGElem("text", 24);
            text = r124;
            SVGElem r125 = new SVGElem("textPath", 25);
            textPath = r125;
            SVGElem r126 = new SVGElem("title", 26);
            title = r126;
            SVGElem r127 = new SVGElem("tref", 27);
            tref = r127;
            SVGElem r128 = new SVGElem("tspan", 28);
            tspan = r128;
            SVGElem r129 = new SVGElem(NameKeys.LoadStrategy_Use, 29);
            use = r129;
            SVGElem r130 = new SVGElem("view", 30);
            view = r130;
            SVGElem r131 = new SVGElem("UNSUPPORTED", 31);
            UNSUPPORTED = r131;
            f272966c = new SVGElem[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
            f272965b = new HashMap();
            SVGElem[] r132 = values();
            int r133 = r132.length;
            int r134 = 0;
        L3:
            if (r134 >= r133) goto L11;
            SVGElem r135 = r132[r134];
            if (r135 != SWITCH) goto L8;
            f272965b.put("switch", r135);
        L10:
            r134 = r134 + 1;
            goto L3
        L8:
            if (r135 == UNSUPPORTED) goto L10;
            f272965b.put(r135.name(), r135);
            goto L10
        }

        public static SVGElem[] values() {
            return (SVGElem[]) f272966c.clone();
        }

        public static SVGElem fromString(String r100) {
            SVGElem r101 = (SVGElem) ((HashMap) f272965b).get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return UNSUPPORTED;
        }

        public static SVGElem valueOf(String r100) {
            return (SVGElem) r27.a.a(SVGElem.class, r100);
        }

        public SVGElem(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272968a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f272969b = null;

        static {
            int[] r100 = new int[SVGAttr.values().length];
            f272969b = r100;
            r100[SVGAttr.f272958x.ordinal()] = 1;     // Catch: NoSuchFieldError -> L146
        L286:
            f272969b[SVGAttr.f272961y.ordinal()] = 2;     // Catch: NoSuchFieldError -> L147
        L302:
            f272969b[SVGAttr.width.ordinal()] = 3;     // Catch: NoSuchFieldError -> L148
        L312:
            f272969b[SVGAttr.height.ordinal()] = 4;     // Catch: NoSuchFieldError -> L149
        L318:
            f272969b[SVGAttr.version.ordinal()] = 5;     // Catch: NoSuchFieldError -> L150
        L336:
            f272969b[SVGAttr.href.ordinal()] = 6;     // Catch: NoSuchFieldError -> L151
        L340:
            f272969b[SVGAttr.preserveAspectRatio.ordinal()] = 7;     // Catch: NoSuchFieldError -> L152
        L362:
            f272969b[SVGAttr.f272950d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L153
        L366:
            f272969b[SVGAttr.pathLength.ordinal()] = 9;     // Catch: NoSuchFieldError -> L154
        L384:
            f272969b[SVGAttr.f272956rx.ordinal()] = 10;     // Catch: NoSuchFieldError -> L155
        L390:
            f272969b[SVGAttr.f272957ry.ordinal()] = 11;     // Catch: NoSuchFieldError -> L156
        L408:
            f272969b[SVGAttr.f272948cx.ordinal()] = 12;     // Catch: NoSuchFieldError -> L157
        L412:
            f272969b[SVGAttr.f272949cy.ordinal()] = 13;     // Catch: NoSuchFieldError -> L158
        L426:
            f272969b[SVGAttr.f272955r.ordinal()] = 14;     // Catch: NoSuchFieldError -> L159
        L432:
            f272969b[SVGAttr.f272959x1.ordinal()] = 15;     // Catch: NoSuchFieldError -> L160
        L448:
            f272969b[SVGAttr.f272962y1.ordinal()] = 16;     // Catch: NoSuchFieldError -> L161
        L452:
            f272969b[SVGAttr.f272960x2.ordinal()] = 17;     // Catch: NoSuchFieldError -> L162
        L470:
            f272969b[SVGAttr.f272963y2.ordinal()] = 18;     // Catch: NoSuchFieldError -> L163
        L474:
            f272969b[SVGAttr.f272951dx.ordinal()] = 19;     // Catch: NoSuchFieldError -> L164
        L488:
            f272969b[SVGAttr.f272952dy.ordinal()] = 20;     // Catch: NoSuchFieldError -> L165
        L494:
            f272969b[SVGAttr.requiredFeatures.ordinal()] = 21;     // Catch: NoSuchFieldError -> L166
        L270:
            f272969b[SVGAttr.requiredExtensions.ordinal()] = 22;     // Catch: NoSuchFieldError -> L167
        L274:
            f272969b[SVGAttr.systemLanguage.ordinal()] = 23;     // Catch: NoSuchFieldError -> L168
        L294:
            f272969b[SVGAttr.requiredFormats.ordinal()] = 24;     // Catch: NoSuchFieldError -> L169
        L298:
            f272969b[SVGAttr.requiredFonts.ordinal()] = 25;     // Catch: NoSuchFieldError -> L170
        L320:
            f272969b[SVGAttr.refX.ordinal()] = 26;     // Catch: NoSuchFieldError -> L171
        L322:
            f272969b[SVGAttr.refY.ordinal()] = 27;     // Catch: NoSuchFieldError -> L172
        L342:
            f272969b[SVGAttr.markerWidth.ordinal()] = 28;     // Catch: NoSuchFieldError -> L173
        L346:
            f272969b[SVGAttr.markerHeight.ordinal()] = 29;     // Catch: NoSuchFieldError -> L174
        L370:
            f272969b[SVGAttr.markerUnits.ordinal()] = 30;     // Catch: NoSuchFieldError -> L175
        L372:
            f272969b[SVGAttr.orient.ordinal()] = 31;     // Catch: NoSuchFieldError -> L176
        L392:
            f272969b[SVGAttr.gradientUnits.ordinal()] = 32;     // Catch: NoSuchFieldError -> L177
        L396:
            f272969b[SVGAttr.gradientTransform.ordinal()] = 33;     // Catch: NoSuchFieldError -> L178
        L414:
            f272969b[SVGAttr.spreadMethod.ordinal()] = 34;     // Catch: NoSuchFieldError -> L179
        L416:
            f272969b[SVGAttr.f272953fx.ordinal()] = 35;     // Catch: NoSuchFieldError -> L180
        L436:
            f272969b[SVGAttr.f272954fy.ordinal()] = 36;     // Catch: NoSuchFieldError -> L181
        L438:
            f272969b[SVGAttr.offset.ordinal()] = 37;     // Catch: NoSuchFieldError -> L182
        L454:
            f272969b[SVGAttr.clipPathUnits.ordinal()] = 38;     // Catch: NoSuchFieldError -> L183
        L458:
            f272969b[SVGAttr.startOffset.ordinal()] = 39;     // Catch: NoSuchFieldError -> L184
        L476:
            f272969b[SVGAttr.patternUnits.ordinal()] = 40;     // Catch: NoSuchFieldError -> L185
        L478:
            f272969b[SVGAttr.patternContentUnits.ordinal()] = 41;     // Catch: NoSuchFieldError -> L186
        L498:
            f272969b[SVGAttr.patternTransform.ordinal()] = 42;     // Catch: NoSuchFieldError -> L187
        L500:
            f272969b[SVGAttr.maskUnits.ordinal()] = 43;     // Catch: NoSuchFieldError -> L188
        L276:
            f272969b[SVGAttr.maskContentUnits.ordinal()] = 44;     // Catch: NoSuchFieldError -> L189
        L282:
            f272969b[SVGAttr.style.ordinal()] = 45;     // Catch: NoSuchFieldError -> L190
        L300:
            f272969b[SVGAttr.CLASS.ordinal()] = 46;     // Catch: NoSuchFieldError -> L191
        L306:
            f272969b[SVGAttr.fill.ordinal()] = 47;     // Catch: NoSuchFieldError -> L192
        L326:
            f272969b[SVGAttr.fill_rule.ordinal()] = 48;     // Catch: NoSuchFieldError -> L193
        L330:
            f272969b[SVGAttr.fill_opacity.ordinal()] = 49;     // Catch: NoSuchFieldError -> L194
        L348:
            f272969b[SVGAttr.stroke.ordinal()] = 50;     // Catch: NoSuchFieldError -> L195
        L354:
            f272969b[SVGAttr.stroke_opacity.ordinal()] = 51;     // Catch: NoSuchFieldError -> L196
        L374:
            f272969b[SVGAttr.stroke_width.ordinal()] = 52;     // Catch: NoSuchFieldError -> L197
        L378:
            f272969b[SVGAttr.stroke_linecap.ordinal()] = 53;     // Catch: NoSuchFieldError -> L198
        L400:
            f272969b[SVGAttr.stroke_linejoin.ordinal()] = 54;     // Catch: NoSuchFieldError -> L199
        L402:
            f272969b[SVGAttr.stroke_miterlimit.ordinal()] = 55;     // Catch: NoSuchFieldError -> L200
        L418:
            f272969b[SVGAttr.stroke_dasharray.ordinal()] = 56;     // Catch: NoSuchFieldError -> L201
        L422:
            f272969b[SVGAttr.stroke_dashoffset.ordinal()] = 57;     // Catch: NoSuchFieldError -> L202
        L442:
            f272969b[SVGAttr.opacity.ordinal()] = 58;     // Catch: NoSuchFieldError -> L203
        L444:
            f272969b[SVGAttr.color.ordinal()] = 59;     // Catch: NoSuchFieldError -> L204
        L462:
            f272969b[SVGAttr.font.ordinal()] = 60;     // Catch: NoSuchFieldError -> L205
        L464:
            f272969b[SVGAttr.font_family.ordinal()] = 61;     // Catch: NoSuchFieldError -> L206
        L480:
            f272969b[SVGAttr.font_size.ordinal()] = 62;     // Catch: NoSuchFieldError -> L207
        L484:
            f272969b[SVGAttr.font_weight.ordinal()] = 63;     // Catch: NoSuchFieldError -> L208
        L504:
            f272969b[SVGAttr.font_style.ordinal()] = 64;     // Catch: NoSuchFieldError -> L209
        L266:
            f272969b[SVGAttr.text_decoration.ordinal()] = 65;     // Catch: NoSuchFieldError -> L210
        L288:
            f272969b[SVGAttr.direction.ordinal()] = 66;     // Catch: NoSuchFieldError -> L211
        L290:
            f272969b[SVGAttr.text_anchor.ordinal()] = 67;     // Catch: NoSuchFieldError -> L212
        L310:
            f272969b[SVGAttr.overflow.ordinal()] = 68;     // Catch: NoSuchFieldError -> L213
        L314:
            f272969b[SVGAttr.marker.ordinal()] = 69;     // Catch: NoSuchFieldError -> L214
        L334:
            f272969b[SVGAttr.marker_start.ordinal()] = 70;     // Catch: NoSuchFieldError -> L215
        L338:
            f272969b[SVGAttr.marker_mid.ordinal()] = 71;     // Catch: NoSuchFieldError -> L216
        L360:
            f272969b[SVGAttr.marker_end.ordinal()] = 72;     // Catch: NoSuchFieldError -> L217
        L364:
            f272969b[SVGAttr.display.ordinal()] = 73;     // Catch: NoSuchFieldError -> L218
        L382:
            f272969b[SVGAttr.visibility.ordinal()] = 74;     // Catch: NoSuchFieldError -> L219
        L388:
            f272969b[SVGAttr.stop_color.ordinal()] = 75;     // Catch: NoSuchFieldError -> L220
        L406:
            f272969b[SVGAttr.stop_opacity.ordinal()] = 76;     // Catch: NoSuchFieldError -> L221
        L410:
            f272969b[SVGAttr.clip.ordinal()] = 77;     // Catch: NoSuchFieldError -> L222
        L424:
            f272969b[SVGAttr.clip_path.ordinal()] = 78;     // Catch: NoSuchFieldError -> L223
        L430:
            f272969b[SVGAttr.clip_rule.ordinal()] = 79;     // Catch: NoSuchFieldError -> L224
        L446:
            f272969b[SVGAttr.mask.ordinal()] = 80;     // Catch: NoSuchFieldError -> L225
        L450:
            f272969b[SVGAttr.solid_color.ordinal()] = 81;     // Catch: NoSuchFieldError -> L226
        L468:
            f272969b[SVGAttr.solid_opacity.ordinal()] = 82;     // Catch: NoSuchFieldError -> L227
        L472:
            f272969b[SVGAttr.viewport_fill.ordinal()] = 83;     // Catch: NoSuchFieldError -> L228
        L486:
            f272969b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;     // Catch: NoSuchFieldError -> L229
        L492:
            f272969b[SVGAttr.vector_effect.ordinal()] = 85;     // Catch: NoSuchFieldError -> L230
        L268:
            f272969b[SVGAttr.image_rendering.ordinal()] = 86;     // Catch: NoSuchFieldError -> L231
        L272:
            f272969b[SVGAttr.viewBox.ordinal()] = 87;     // Catch: NoSuchFieldError -> L232
        L292:
            f272969b[SVGAttr.type.ordinal()] = 88;     // Catch: NoSuchFieldError -> L233
        L296:
            f272969b[SVGAttr.media.ordinal()] = 89;     // Catch: NoSuchFieldError -> L234
        L113:
            int[] r110 = new int[SVGElem.values().length];
            f272968a = r110;
            r110[SVGElem.svg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L235
        L324:
            f272968a[SVGElem.f272967g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L236
        L344:
            f272968a[SVGElem.f272964a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L237
        L352:
            f272968a[SVGElem.defs.ordinal()] = 4;     // Catch: NoSuchFieldError -> L238
        L358:
            f272968a[SVGElem.use.ordinal()] = 5;     // Catch: NoSuchFieldError -> L239
        L368:
            f272968a[SVGElem.path.ordinal()] = 6;     // Catch: NoSuchFieldError -> L240
        L386:
            f272968a[SVGElem.rect.ordinal()] = 7;     // Catch: NoSuchFieldError -> L241
        L394:
            f272968a[SVGElem.circle.ordinal()] = 8;     // Catch: NoSuchFieldError -> L242
        L398:
            f272968a[SVGElem.ellipse.ordinal()] = 9;     // Catch: NoSuchFieldError -> L243
        L404:
            f272968a[SVGElem.line.ordinal()] = 10;     // Catch: NoSuchFieldError -> L244
        L420:
            f272968a[SVGElem.polyline.ordinal()] = 11;     // Catch: NoSuchFieldError -> L245
        L428:
            f272968a[SVGElem.polygon.ordinal()] = 12;     // Catch: NoSuchFieldError -> L246
        L434:
            f272968a[SVGElem.text.ordinal()] = 13;     // Catch: NoSuchFieldError -> L247
        L440:
            f272968a[SVGElem.tspan.ordinal()] = 14;     // Catch: NoSuchFieldError -> L248
        L456:
            f272968a[SVGElem.tref.ordinal()] = 15;     // Catch: NoSuchFieldError -> L249
        L460:
            f272968a[SVGElem.SWITCH.ordinal()] = 16;     // Catch: NoSuchFieldError -> L250
        L466:
            f272968a[SVGElem.symbol.ordinal()] = 17;     // Catch: NoSuchFieldError -> L251
        L482:
            f272968a[SVGElem.marker.ordinal()] = 18;     // Catch: NoSuchFieldError -> L252
        L490:
            f272968a[SVGElem.linearGradient.ordinal()] = 19;     // Catch: NoSuchFieldError -> L253
        L496:
            f272968a[SVGElem.radialGradient.ordinal()] = 20;     // Catch: NoSuchFieldError -> L254
        L502:
            f272968a[SVGElem.stop.ordinal()] = 21;     // Catch: NoSuchFieldError -> L255
        L278:
            f272968a[SVGElem.title.ordinal()] = 22;     // Catch: NoSuchFieldError -> L256
        L284:
            f272968a[SVGElem.desc.ordinal()] = 23;     // Catch: NoSuchFieldError -> L257
        L304:
            f272968a[SVGElem.clipPath.ordinal()] = 24;     // Catch: NoSuchFieldError -> L258
        L308:
            f272968a[SVGElem.textPath.ordinal()] = 25;     // Catch: NoSuchFieldError -> L259
        L328:
            f272968a[SVGElem.pattern.ordinal()] = 26;     // Catch: NoSuchFieldError -> L260
        L332:
            f272968a[SVGElem.image.ordinal()] = 27;     // Catch: NoSuchFieldError -> L261
        L350:
            f272968a[SVGElem.view.ordinal()] = 28;     // Catch: NoSuchFieldError -> L262
        L356:
            f272968a[SVGElem.mask.ordinal()] = 29;     // Catch: NoSuchFieldError -> L263
        L376:
            f272968a[SVGElem.style.ordinal()] = 30;     // Catch: NoSuchFieldError -> L264
        L380:
            f272968a[SVGElem.solidColor.ordinal()] = 31;     // Catch: NoSuchFieldError -> L265
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, PreserveAspectRatio.Alignment> f272970a = null;

        static {
            HashMap r100 = new HashMap(10);
            f272970a = r100;
            r100.put("none", PreserveAspectRatio.Alignment.none);
            r100.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            r100.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            r100.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            r100.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            r100.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            r100.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            r100.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            r100.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            r100.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, Integer> f272971a = null;

        static {
            HashMap r100 = new HashMap(47);
            f272971a = r100;
            r100.put("aliceblue", -984833);
            r100.put("antiquewhite", -332841);
            Integer r101 = Integer.valueOf(FakePickerAvatarCreator.CYAN);
            r100.put("aqua", r101);
            r100.put("aquamarine", -8388652);
            r100.put("azure", -983041);
            r100.put("beige", -657956);
            r100.put("bisque", -6972);
            r100.put("black", -16777216);
            r100.put("blanchedalmond", -5171);
            r100.put("blue", Integer.valueOf(FakePickerAvatarCreator.BLUE));
            r100.put("blueviolet", -7722014);
            r100.put("brown", -5952982);
            r100.put("burlywood", -2180985);
            r100.put("cadetblue", -10510688);
            r100.put("chartreuse", -8388864);
            r100.put("chocolate", -2987746);
            r100.put("coral", -32944);
            r100.put("cornflowerblue", -10185235);
            r100.put("cornsilk", -1828);
            r100.put("crimson", -2354116);
            r100.put("cyan", r101);
            r100.put("darkblue", -16777077);
            r100.put("darkcyan", -16741493);
            r100.put("darkgoldenrod", -4684277);
            r100.put("darkgray", -5658199);
            r100.put("darkgreen", -16751616);
            r100.put("darkgrey", -5658199);
            r100.put("darkkhaki", -4343957);
            r100.put("darkmagenta", -7667573);
            r100.put("darkolivegreen", -11179217);
            r100.put("darkorange", -29696);
            r100.put("darkorchid", -6737204);
            r100.put("darkred", -7667712);
            r100.put("darksalmon", -1468806);
            r100.put("darkseagreen", -7357297);
            r100.put("darkslateblue", -12042869);
            r100.put("darkslategray", -13676721);
            r100.put("darkslategrey", -13676721);
            r100.put("darkturquoise", -16724271);
            r100.put("darkviolet", -7077677);
            r100.put("deeppink", -60269);
            r100.put("deepskyblue", -16728065);
            r100.put("dimgray", -9868951);
            r100.put("dimgrey", -9868951);
            r100.put("dodgerblue", -14774017);
            r100.put("firebrick", -5103070);
            r100.put("floralwhite", -1296);
            r100.put("forestgreen", -14513374);
            Integer r102 = Integer.valueOf(FakePickerAvatarCreator.MAGENTA);
            r100.put("fuchsia", r102);
            r100.put("gainsboro", -2302756);
            r100.put("ghostwhite", -460545);
            r100.put("gold", -10496);
            r100.put("goldenrod", -2448096);
            r100.put("gray", -8355712);
            r100.put("green", -16744448);
            r100.put("greenyellow", -5374161);
            r100.put("grey", -8355712);
            r100.put("honeydew", -983056);
            r100.put("hotpink", -38476);
            r100.put("indianred", -3318692);
            r100.put("indigo", -11861886);
            r100.put("ivory", -16);
            r100.put("khaki", -989556);
            r100.put("lavender", -1644806);
            r100.put("lavenderblush", -3851);
            r100.put("lawngreen", -8586240);
            r100.put("lemonchiffon", -1331);
            r100.put("lightblue", -5383962);
            r100.put("lightcoral", -1015680);
            r100.put("lightcyan", -2031617);
            r100.put("lightgoldenrodyellow", -329006);
            r100.put("lightgray", -2894893);
            r100.put("lightgreen", -7278960);
            r100.put("lightgrey", -2894893);
            r100.put("lightpink", -18751);
            r100.put("lightsalmon", -24454);
            r100.put("lightseagreen", -14634326);
            r100.put("lightskyblue", -7876870);
            r100.put("lightslategray", -8943463);
            r100.put("lightslategrey", -8943463);
            r100.put("lightsteelblue", -5192482);
            r100.put("lightyellow", -32);
            r100.put("lime", Integer.valueOf(FakePickerAvatarCreator.GREEN));
            r100.put("limegreen", -13447886);
            r100.put("linen", -331546);
            r100.put("magenta", r102);
            r100.put("maroon", -8388608);
            r100.put("mediumaquamarine", -10039894);
            r100.put("mediumblue", -16777011);
            r100.put("mediumorchid", -4565549);
            r100.put("mediumpurple", -7114533);
            r100.put("mediumseagreen", -12799119);
            r100.put("mediumslateblue", -8689426);
            r100.put("mediumspringgreen", -16713062);
            r100.put("mediumturquoise", -12004916);
            r100.put("mediumvioletred", -3730043);
            r100.put("midnightblue", -15132304);
            r100.put("mintcream", -655366);
            r100.put("mistyrose", -6943);
            r100.put("moccasin", -6987);
            r100.put("navajowhite", -8531);
            r100.put("navy", -16777088);
            r100.put("oldlace", -133658);
            r100.put("olive", -8355840);
            r100.put("olivedrab", -9728477);
            r100.put("orange", -23296);
            r100.put("orangered", -47872);
            r100.put("orchid", -2461482);
            r100.put("palegoldenrod", -1120086);
            r100.put("palegreen", -6751336);
            r100.put("paleturquoise", -5247250);
            r100.put("palevioletred", -2396013);
            r100.put("papayawhip", -4139);
            r100.put("peachpuff", -9543);
            r100.put("peru", -3308225);
            r100.put("pink", -16181);
            r100.put("plum", -2252579);
            r100.put("powderblue", -5185306);
            r100.put("purple", -8388480);
            r100.put("rebeccapurple", -10079335);
            r100.put("red", -65536);
            r100.put("rosybrown", -4419697);
            r100.put("royalblue", -12490271);
            r100.put("saddlebrown", -7650029);
            r100.put("salmon", -360334);
            r100.put("sandybrown", -744352);
            r100.put("seagreen", -13726889);
            r100.put("seashell", -2578);
            r100.put("sienna", -6270419);
            r100.put("silver", -4144960);
            r100.put("skyblue", -7876885);
            r100.put("slateblue", -9807155);
            r100.put("slategray", -9404272);
            r100.put("slategrey", -9404272);
            r100.put("snow", -1286);
            r100.put("springgreen", -16711809);
            r100.put("steelblue", -12156236);
            r100.put("tan", -2968436);
            r100.put("teal", -16744320);
            r100.put("thistle", -2572328);
            r100.put("tomato", -40121);
            r100.put("turquoise", -12525360);
            r100.put("violet", -1146130);
            r100.put("wheat", -663885);
            r100.put("white", -1);
            r100.put("whitesmoke", -657931);
            r100.put("yellow", -256);
            r100.put("yellowgreen", -6632142);
            r100.put(ECPromotion.TRANSPARENT_BOTTON_ICON, 0);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, SVG.o> f272972a = null;

        static {
            HashMap r100 = new HashMap(9);
            f272972a = r100;
            SVG.Unit r101 = SVG.Unit.f272804pt;
            r100.put("xx-small", new SVG.o(0.694f, r101));
            r100.put("x-small", new SVG.o(0.833f, r101));
            r100.put("small", new SVG.o(10.0f, r101));
            r100.put(KryptonCamera.Config.RESOLUTION_MEDIUM, new SVG.o(12.0f, r101));
            r100.put("large", new SVG.o(14.4f, r101));
            r100.put("x-large", new SVG.o(17.3f, r101));
            r100.put("xx-large", new SVG.o(20.7f, r101));
            SVG.Unit r102 = SVG.Unit.percent;
            r100.put("smaller", new SVG.o(83.33f, r102));
            r100.put("larger", new SVG.o(120.0f, r102));
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, Integer> f272973a = null;

        static {
            HashMap r100 = new HashMap(13);
            f272973a = r100;
            r100.put("normal", 400);
            r100.put(CommodityText.BOLD, 700);
            r100.put("bolder", 1);
            r100.put("lighter", -1);
            r100.put("100", 100);
            r100.put("200", 200);
            r100.put("300", 300);
            r100.put("400", 400);
            r100.put("500", 500);
            r100.put("600", 600);
            r100.put("700", 700);
            r100.put("800", 800);
            r100.put("900", 900);
        }
    }

    public class f extends DefaultHandler2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SVGParser f272974a;

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endDocument() throws SAXException {
            this.f272974a.getClass();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startDocument() throws SAXException {
            SVGParser r100 = this.f272974a;
            r100.getClass();
            r100.f272937a = new SVG();
        }

        public f(SVGParser r100) {
            this.f272974a = r100;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void processingInstruction(String r100, String r101) throws SAXException {
            g r102 = new g(r101);
            this.f272974a.getClass();
            SVGParser.C(r102);
            this.f272974a.getClass();
            r100.equals("xml-stylesheet");
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void characters(char[] r100, int r101, int r102) throws SAXException {
            this.f272974a.L(new String(r100, r101, r102));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endElement(String r100, String r101, String r102) throws SAXException {
            this.f272974a.c(r100, r101, r102);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startElement(String r100, String r101, String r102, Attributes r103) throws SAXException {
            this.f272974a.J(r100, r101, r102, r103);
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f272975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f272976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f272977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.caverock.androidsvg.b f272978d;

        public static boolean g(int r100) {
            if (r100 != 32) goto L5;
        L12:
            return true;
        L5:
            if (r100 == 10) goto L12;
            if (r100 == 13) goto L12;
            if (r100 == 9) goto L12;
            return false;
        }

        public final int a() {
            int r100 = this.f272976b;
            int r101 = this.f272977c;
            if (r100 != r101) goto L5;
            return -1;
        L5:
            int r102 = r100 + 1;
            this.f272976b = r102;
            if (r102 < r101) goto L8;
            return -1;
        L8:
            return this.f272975a.charAt(r102);
        }

        public final boolean f() {
            if (this.f272976b != this.f272977c) goto L5;
            return true;
        L5:
            return false;
        }

        public final Integer h() {
            int r100 = this.f272976b;
            if (r100 != this.f272977c) goto L6;
            return null;
        L6:
            String r101 = this.f272975a;
            this.f272976b = r100 + 1;
            return Integer.valueOf(r101.charAt(r100));
        }

        public final float i() {
            float r100 = this.f272978d.a(this.f272975a, this.f272976b, this.f272977c);
            if (Float.isNaN(r100) == true) goto L5;
            this.f272976b = this.f272978d.f272984a;
        L5:
            return r100;
        }

        public final String l() {
            return m(' ', false);
        }

        public final void q() {
        L2:
            int r100 = this.f272976b;
            if (r100 >= this.f272977c) goto L8;
            if (g(this.f272975a.charAt(r100)) == false) goto L11;
            this.f272976b++;
            goto L2
        L11:
            return;
        }

        public final SVG.o j() {
            float r100 = i();
            if (Float.isNaN(r100) == false) goto L6;
            return null;
        L6:
            SVG.Unit r101 = n();
            if (r101 != null) goto L11;
            return new SVG.o(r100, SVG.Unit.f272805px);
        L11:
            return new SVG.o(r100, r101);
        }

        public final String k() {
            if (f() == false) goto L5;
            return null;
        L5:
            int r100 = this.f272976b;
            char r101 = this.f272975a.charAt(r100);
            if (r101 != '\'') goto L8;
        L10:
            int r102 = a();
        L12:
            if (r102 == (-1)) goto L15;
            if (r102 == r101) goto L15;
            r102 = a();
        L15:
            if (r102 != (-1)) goto L18;
            this.f272976b = r100;
            return null;
        L18:
            int r103 = this.f272976b + 1;
            this.f272976b = r103;
            return this.f272975a.substring(r100 + 1, r103 - 1);
        L8:
            if (r101 == '\"') goto L10;
            return null;
        }

        public final SVG.Unit n() {
            if (f() == false) goto L6;
            return null;
        L6:
            if (this.f272975a.charAt(this.f272976b) != '%') goto L9;
            this.f272976b++;
            return SVG.Unit.percent;
        L9:
            int r100 = this.f272976b;
            if (r100 <= (this.f272977c - 2)) goto L15;
            return null;
        L15:
            SVG.Unit r101 = SVG.Unit.valueOf(this.f272975a.substring(r100, r100 + 2).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L14
            this.f272976b += 2;     // Catch: IllegalArgumentException -> L14
            return r101;
        L14:
            return null;
        }

        public final float o() {
            p();
            float r100 = this.f272978d.a(this.f272975a, this.f272976b, this.f272977c);
            if (Float.isNaN(r100) == true) goto L5;
            this.f272976b = this.f272978d.f272984a;
        L5:
            return r100;
        }

        public final boolean p() {
            q();
            int r100 = this.f272976b;
            if (r100 != this.f272977c) goto L6;
            return false;
        L6:
            if (this.f272975a.charAt(r100) == ',') goto L8;
            return false;
        L8:
            this.f272976b++;
            q();
            return true;
        }

        public g(String r100) {
            this.f272976b = 0;
            this.f272977c = 0;
            this.f272978d = new com.caverock.androidsvg.b();
            String r101 = r100.trim();
            this.f272975a = r101;
            this.f272977c = r101.length();
        }

        public final Boolean b(Object r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            p();
            int r101 = this.f272976b;
            if (r101 == this.f272977c) goto L18;
            char r102 = this.f272975a.charAt(r101);
            if (r102 == '0') goto L11;
            if (r102 == '1') goto L11;
            return null;
        L11:
            boolean r103 = true;
            this.f272976b++;
            if (r102 == '1') goto L16;
            r103 = false;
        L16:
            return Boolean.valueOf(r103);
        L18:
            return null;
        }

        public final float c(float r100) {
            if (Float.isNaN(r100) == false) goto L6;
            return Float.NaN;
        L6:
            p();
            return i();
        }

        public final boolean d(char r100) {
            int r101 = this.f272976b;
            if (r101 < this.f272977c) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            this.f272976b++;
        L10:
            return r102;
        L5:
            if (this.f272975a.charAt(r101) != r100) goto L7;
            r102 = true;
            goto L8
        }

        public final boolean e(String r100) {
            int r101 = r100.length();
            int r102 = this.f272976b;
            if (r102 <= (this.f272977c - r101)) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == false) goto L10;
            this.f272976b += r101;
        L10:
            return r103;
        L5:
            if (this.f272975a.substring(r102, r102 + r101).equals(r100) == false) goto L7;
            r103 = true;
            goto L8
        }

        public final String m(char r100, boolean r101) {
            if (f() == false) goto L5;
            return null;
        L5:
            char r102 = this.f272975a.charAt(this.f272976b);
            if (r101 == false) goto L8;
        L9:
            if (r102 != r100) goto L11;
        L10:
            return null;
        L11:
            int r103 = this.f272976b;
            int r104 = a();
        L13:
            if (r104 == (-1)) goto L22;
            if (r104 == r100) goto L22;
            if (r101 == true) goto L20;
            if (g(r104) == true) goto L22;
        L20:
            r104 = a();
        L22:
            return this.f272975a.substring(r103, this.f272976b);
        L8:
            if (g(r102) == true) goto L10;
            goto L9
        }
    }

    public class h implements Attributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final XmlPullParser f272979a;

        @Override // org.xml.sax.Attributes
        public final int getIndex(String r100) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public final int getIndex(String r100, String r101) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int r100) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String r100) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String r100, String r101) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String r100) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String r100, String r101) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final int getLength() {
            return this.f272979a.getAttributeCount();
        }

        public h(XmlPullParser r100) {
            this.f272979a = r100;
        }

        @Override // org.xml.sax.Attributes
        public final String getLocalName(int r100) {
            return this.f272979a.getAttributeName(r100);
        }

        @Override // org.xml.sax.Attributes
        public final String getQName(int r100) {
            String r101 = this.f272979a.getAttributeName(r100);
            if (this.f272979a.getAttributePrefix(r100) != null) goto L5;
            return r101;
        L5:
            return this.f272979a.getAttributePrefix(r100) + ':' + r101;
        }

        @Override // org.xml.sax.Attributes
        public final String getURI(int r100) {
            return this.f272979a.getAttributeNamespace(r100);
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(int r100) {
            return this.f272979a.getAttributeValue(r100);
        }
    }

    public static float e(float r100, float r101, float r102) {
        if (r102 >= 0.0f) goto L6;
        r102 = r102 + 6.0f;
    L6:
        if (r102 < 6.0f) goto L9;
        r102 = r102 - 6.0f;
    L9:
        if (r102 >= 1.0f) goto L14;
        float r103 = (r101 - r100) * r102;
    L12:
        return r103 + r100;
    L14:
        if (r102 >= 3.0f) goto L17;
        return r101;
    L17:
        if (r102 >= 4.0f) goto L19;
        r103 = (r101 - r100) * (4.0f - r102);
        goto L12
    L19:
        return r100;
    }

    public SVGParser() {
        this.f272937a = null;
        this.f272938b = null;
        this.f272939c = false;
        this.f272941e = false;
        this.f272942f = null;
        this.f272943g = null;
        this.f272944h = false;
        this.f272945i = null;
    }

    public static SVG.m0 A(String r100) {
        if (r100.startsWith("url(") == false) goto L14;
        int r101 = r100.indexOf(")");
        SVG.m0 r102 = null;
        if (r101 == (-1)) goto L12;
        String r103 = r100.substring(4, r101).trim();
        String r104 = r100.substring(r101 + 1).trim();
        if (r104.length() <= 0) goto L10;
        r102 = q(r104);
    L10:
        return new SVG.t(r103, r102);
    L12:
        return new SVG.t(r100.substring(4).trim(), null);
    L14:
        return q(r100);
    }

    public static Map C(g r100) {
        HashMap r101 = new HashMap();
        r100.q();
        String r102 = r100.m(com.alipay.sdk.m.n.a.f25612h, false);
    L3:
        if (r102 == null) goto L5;
        r100.d(com.alipay.sdk.m.n.a.f25612h);
        r101.put(r102, r100.k());
        r100.q();
        r102 = r100.m(com.alipay.sdk.m.n.a.f25612h, false);
        goto L3
    L5:
        return r101;
    }

    public static Matrix D(String r110) throws SVGParseException {
        Matrix r100 = new Matrix();
        g r101 = new g(r110);
        r101.q();
    L4:
        if (r101.f() == true) goto L126;
        if (r101.f() == true) goto L26;
        int r102 = r101.f272976b;
        int r103 = r101.f272975a.charAt(r102);
    L10:
        if (r103 < 97) goto L14;
        if (r103 > 122) goto L14;
    L17:
        r103 = r101.a();
    L14:
        if (r103 < 65) goto L18;
        if (r103 <= 90) goto L17;
    L18:
        int r104 = r101.f272976b;
    L20:
        if (g.g(r103) == false) goto L23;
        r103 = r101.a();
        goto L20
    L23:
        if (r103 != 40) goto L25;
        r101.f272976b++;
        String r105 = r101.f272975a.substring(r102, r104);
    L27:
        if (r105 == null) goto L125;
        switch(r105.hashCode()) {
            case -1081239615: goto L52;
            case -925180581: goto L48;
            case 109250890: goto L44;
            case 109493390: goto L40;
            case 109493391: goto L36;
            case 1052832078: goto L32;
            default: goto L55;
        };
    L55:
        byte r106 = -1;
    L57:
        if (r106 == 0) goto L113;
        if (r106 == 1) goto L99;
        if (r106 == 2) goto L89;
        if (r106 == 3) goto L82;
        if (r106 == 4) goto L75;
        if (r106 != 5) goto L74;
        r101.q();
        float r107 = r101.i();
        float r108 = r101.o();
        r101.q();
        if (Float.isNaN(r107) == true) goto L72;
        if (r101.d(')') == false) goto L72;
        if (Float.isNaN(r108) == false) goto L70;
        r100.preTranslate(r107, 0.0f);
    L119:
        if (r101.f() == true) goto L126;
        r101.p();
        goto L4
    L70:
        r100.preTranslate(r107, r108);
    L72:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L74:
        throw new SVGParseException("Invalid transform list fn: " + r105 + ")");
    L75:
        r101.q();
        float r109 = r101.i();
        r101.q();
        if (Float.isNaN(r109) == true) goto L81;
        if (r101.d(')') == false) goto L81;
        r100.preSkew(0.0f, (float) Math.tan(Math.toRadians(r109)));
    L81:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L82:
        r101.q();
        float r111 = r101.i();
        r101.q();
        if (Float.isNaN(r111) == true) goto L88;
        if (r101.d(')') == false) goto L88;
        r100.preSkew((float) Math.tan(Math.toRadians(r111)), 0.0f);
    L88:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L89:
        r101.q();
        float r112 = r101.i();
        float r113 = r101.o();
        r101.q();
        if (Float.isNaN(r112) == true) goto L98;
        if (r101.d(')') == false) goto L98;
        if (Float.isNaN(r113) == false) goto L96;
        r100.preScale(r112, r112);
        goto L119
    L96:
        r100.preScale(r112, r113);
    L98:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L99:
        r101.q();
        float r114 = r101.i();
        float r115 = r101.o();
        float r116 = r101.o();
        r101.q();
        if (Float.isNaN(r114) == true) goto L112;
        if (r101.d(')') == false) goto L112;
        if (Float.isNaN(r115) == false) goto L107;
        r100.preRotate(r114);
        goto L119
    L107:
        if (Float.isNaN(r116) == true) goto L110;
        r100.preRotate(r114, r115, r116);
        goto L119
    L110:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L112:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L113:
        r101.q();
        float r117 = r101.i();
        r101.p();
        float r118 = r101.i();
        r101.p();
        float r119 = r101.i();
        r101.p();
        float r120 = r101.i();
        r101.p();
        float r121 = r101.i();
        r101.p();
        float r122 = r101.i();
        r101.q();
        if (Float.isNaN(r122) == true) goto L123;
        if (r101.d(')') == false) goto L123;
        Matrix r123 = new Matrix();
        r123.setValues(new float[]{r117, r119, r121, r118, r120, r122, 0.0f, 0.0f, 1.0f});
        r100.preConcat(r123);
    L123:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L32:
        if (r105.equals("translate") == false) goto L55;
        r106 = 5;
        goto L57
    L36:
        if (r105.equals("skewY") == false) goto L55;
        r106 = 4;
        goto L57
    L40:
        if (r105.equals("skewX") == false) goto L55;
        r106 = 3;
        goto L57
    L44:
        if (r105.equals("scale") == false) goto L55;
        r106 = 2;
        goto L57
    L48:
        if (r105.equals("rotate") == false) goto L55;
        r106 = 1;
        goto L57
    L52:
        if (r105.equals("matrix") == false) goto L55;
        r106 = 0;
        goto L57
    L125:
        throw new SVGParseException("Bad transform function encountered in transform list: ".concat(r110));
    L25:
        r101.f272976b = r102;
    L26:
        r105 = null;
    L126:
        return r100;
    }

    public static int b(float r100) {
        if (r100 >= 0.0f) goto L6;
        return 0;
    L6:
        if (r100 <= 255.0f) goto L9;
        return 255;
    L9:
        return Math.round(r100);
    }

    public static SVG.f p(String r110) throws SVGParseException {
        int r100 = 5;
        if (r110.charAt(0) != '#') goto L54;
        int r101 = r110.length();
        com.caverock.androidsvg.a r102 = null;
        if (1 >= r101) goto L34;
        long r103 = 0;
        int r104 = 1;
    L8:
        if (r104 >= r101) goto L30;
        char r105 = r110.charAt(r104);
        if (r105 < '0') goto L16;
        if (r105 > '9') goto L16;
        long r106 = r103 * 16;
        long r107 = r105 - '0';
    L14:
        r103 = r106 + r107;
        if (r103 > BodyPartID.bodyIdMax) goto L34;
        r104 = r104 + 1;
    L16:
        if (r105 < 'A') goto L21;
        if (r105 > 'F') goto L21;
        long r108 = r103 * 16;
        int r109 = r105 - 'A';
    L25:
        r106 = r108 + ((long) r109);
        r107 = 10;
    L21:
        if (r105 < 'a') goto L30;
        if (r105 > 'f') goto L30;
        r108 = r103 * 16;
        r109 = r105 - 'a';
    L30:
        if (r104 == 1) goto L34;
        r102 = new com.caverock.androidsvg.a(r103, r104);
    L34:
        if (r102 == null) goto L53;
        int r111 = r102.f272980a;
        if (r111 == 4) goto L50;
        if (r111 != 5) goto L39;
        int r112 = (int) r102.f272981b;
        int r113 = 61440 & r112;
        int r114 = r112 & 3840;
        int r115 = r112 & 240;
        int r116 = r112 & 15;
        return new SVG.f((((((((r116 << 24) | (r116 << 28)) | (r113 << 8)) | (r113 << 4)) | (r114 << 4)) | r114) | r115) | (r115 >> 4));
    L39:
        if (r111 == 7) goto L47;
        if (r111 != 9) goto L45;
        long r117 = r102.f272981b;
        return new SVG.f((((int) r117) >>> 8) | (((int) r117) << 24));
    L45:
        throw new SVGParseException("Bad hex colour value: ".concat(r110));
    L47:
        return new SVG.f(((int) r102.f272981b) | (-16777216));
    L50:
        int r118 = (int) r102.f272981b;
        int r119 = r118 & 3840;
        int r120 = r118 & 240;
        int r121 = r118 & 15;
        return new SVG.f(r121 | (((((r119 << 8) | ((-16777216) | (r119 << 12))) | (r120 << 8)) | (r120 << 4)) | (r121 << 4)));
    L53:
        throw new SVGParseException("Bad hex colour value: ".concat(r110));
    L54:
        String r122 = r110.toLowerCase(Locale.US);
        boolean r123 = r122.startsWith("rgba(");
        if (r123 == true) goto L98;
        if (r122.startsWith("rgb(") == true) goto L98;
        boolean r124 = r122.startsWith("hsla(");
        if (r124 == true) goto L71;
        if (r122.startsWith("hsl(") == true) goto L71;
        Integer r125 = (Integer) ((HashMap) c.f272971a).get(r122);
        if (r125 == null) goto L69;
        return new SVG.f(r125.intValue());
    L69:
        throw new SVGParseException("Invalid colour keyword: ".concat(r122));
    L71:
        if (r124 == true) goto L74;
        r100 = 4;
    L74:
        g r126 = new g(r110.substring(r100));
        r126.q();
        float r127 = r126.i();
        float r128 = r126.c(r127);
        if (Float.isNaN(r128) == true) goto L77;
        r126.d('%');
    L77:
        float r129 = r126.c(r128);
        if (Float.isNaN(r129) == true) goto L80;
        r126.d('%');
    L80:
        if (r124 == false) goto L89;
        float r130 = r126.c(r129);
        r126.q();
        if (Float.isNaN(r130) == true) goto L88;
        if (r126.d(')') == false) goto L88;
        return new SVG.f((b(r130 * 256.0f) << 24) | d(r127, r128, r129));
    L88:
        throw new SVGParseException("Bad hsla() colour value: ".concat(r110));
    L89:
        r126.q();
        if (Float.isNaN(r129) == true) goto L96;
        if (r126.d(')') == false) goto L96;
        return new SVG.f(d(r127, r128, r129) | (-16777216));
    L96:
        throw new SVGParseException("Bad hsl() colour value: ".concat(r110));
    L98:
        if (r123 == true) goto L101;
        r100 = 4;
    L101:
        g r131 = new g(r110.substring(r100));
        r131.q();
        float r132 = r131.i();
        if (Float.isNaN(r132) == false) goto L104;
    L106:
        float r133 = r131.c(r132);
        if (Float.isNaN(r133) == false) goto L109;
    L111:
        float r134 = r131.c(r133);
        if (Float.isNaN(r134) == false) goto L114;
    L116:
        if (r123 == false) goto L125;
        float r135 = r131.c(r134);
        r131.q();
        if (Float.isNaN(r135) == true) goto L124;
        if (r131.d(')') == false) goto L124;
        return new SVG.f((((b(r135 * 256.0f) << 24) | (b(r132) << 16)) | (b(r133) << 8)) | b(r134));
    L124:
        throw new SVGParseException("Bad rgba() colour value: ".concat(r110));
    L125:
        r131.q();
        if (Float.isNaN(r134) == true) goto L132;
        if (r131.d(')') == false) goto L132;
        return new SVG.f((((b(r132) << 16) | (-16777216)) | (b(r133) << 8)) | b(r134));
    L132:
        throw new SVGParseException("Bad rgb() colour value: ".concat(r110));
    L114:
        if (r131.d('%') == false) goto L116;
        r134 = (r134 * 256.0f) / 100.0f;
        goto L116
    L109:
        if (r131.d('%') == false) goto L111;
        r133 = (r133 * 256.0f) / 100.0f;
        goto L111
    L104:
        if (r131.d('%') == false) goto L106;
        r132 = (r132 * 256.0f) / 100.0f;
        goto L106
    }

    public static SVG.m0 q(String r100) {
        r100.getClass();
        if (r100.equals("none") == true) goto L13;
        if (r100.equals("currentColor") == true) goto L11;
        return p(r100);
    L8:
        return null;
    L11:
        return SVG.g.f272845a;
    L13:
        return SVG.f.f272837c;
    }

    public static float r(String r100) throws SVGParseException {
        int r101 = r100.length();
        if (r101 == 0) goto L7;
        return s(r100, r101);
    L7:
        throw new SVGParseException("Invalid float value (empty string)");
    }

    public static List<String> t(String r100) {
        g r101 = new g(r100);
        ArrayList r102 = null;
    L3:
        String r103 = r101.k();
        if (r103 != null) goto L6;
        r103 = r101.m(',', true);
    L6:
        if (r103 == null) goto L12;
        if (r102 != null) goto L10;
        r102 = new ArrayList();
    L10:
        r102.add(r103);
        r101.p();
        if (r101.f() == false) goto L3;
    L12:
        return r102;
    }

    public static SVG.Style.FontStyle u(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1657669071: goto L14;
            case -1178781136: goto L10;
            case -1039745817: goto L6;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L18;
        };
    L18:
        return null;
    L21:
        return SVG.Style.FontStyle.Normal;
    L23:
        return SVG.Style.FontStyle.Italic;
    L25:
        return SVG.Style.FontStyle.Oblique;
    L6:
        if (r100.equals("normal") == false) goto L17;
        r101 = 2;
        goto L17
    L10:
        if (r100.equals("italic") == false) goto L17;
        r101 = 1;
        goto L17
    L14:
        if (r100.equals("oblique") == false) goto L17;
        r101 = 0;
        goto L17
    }

    public static String v(String r100) {
        if (r100.equals("none") == false) goto L6;
        return null;
    L6:
        if (r100.startsWith("url(") == true) goto L9;
        return null;
    L9:
        if (r100.endsWith(")") == false) goto L13;
        return r100.substring(4, r100.length() - 1).trim();
    L13:
        return r100.substring(4).trim();
    }

    public static SVG.o w(String r100) throws SVGParseException {
        if (r100.length() == 0) goto L25;
        int r101 = r100.length();
        SVG.Unit r102 = SVG.Unit.f272805px;
        int r103 = r101 - 1;
        char r104 = r100.charAt(r103);
        if (r104 != '%') goto L9;
        r102 = SVG.Unit.percent;
    L7:
        r101 = r103;
    L26:
        return new SVG.o(s(r100, r101), r102);
    L21:
        e = move-exception;
        throw new SVGParseException("Invalid length value: ".concat(r100), e);
    L9:
        if (r101 <= 2) goto L26;
        if (Character.isLetter(r104) == false) goto L26;
        r103 = r101 - 2;
        if (Character.isLetter(r100.charAt(r103)) == false) goto L26;
        r102 = SVG.Unit.valueOf(r100.substring(r103).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L17
    L18:
        throw new SVGParseException("Invalid length unit specifier: ".concat(r100));
    L25:
        throw new SVGParseException("Invalid length value (empty string)");
    }

    public static List<SVG.o> x(String r100) throws SVGParseException {
        if (r100.length() == 0) goto L23;
        ArrayList r101 = new ArrayList(1);
        g r102 = new g(r100);
        r102.q();
    L6:
        if (r102.f() == true) goto L21;
        float r103 = r102.i();
        if (Float.isNaN(r103) == true) goto L9;
        SVG.Unit r104 = r102.n();
        if (r104 != null) goto L20;
        r104 = SVG.Unit.f272805px;
    L20:
        r101.add(new SVG.o(r103, r104));
        r102.p();
        goto L6
    L9:
        StringBuilder r105 = new StringBuilder("Invalid length list value: ");
        int r106 = r102.f272976b;
    L11:
        if (r102.f() == true) goto L15;
        if (g.g(r102.f272975a.charAt(r102.f272976b)) == true) goto L15;
        r102.f272976b++;
    L15:
        String r107 = r102.f272975a.substring(r106, r102.f272976b);
        r102.f272976b = r106;
        r105.append(r107);
        throw new SVGParseException(r105.toString());
    L21:
        return r101;
    L23:
        throw new SVGParseException("Invalid length list (empty string)");
    }

    public static SVG.o y(g r100) {
        if (r100.e("auto") == false) goto L7;
        return new SVG.o(0.0f);
    L7:
        return r100.j();
    }

    public static Float z(String r100) {
        float r101 = r(r100);     // Catch: SVGParseException -> L10
        if (r101 >= 0.0f) goto L6;
        r101 = 0.0f;
    L8:
        return Float.valueOf(r101);
    L6:
        if (r101 <= 1.0f) goto L8;
        r101 = 1.0f;
    L10:
        return null;
    }

    public final void E(InputStream r100) throws SVGParseException {
        SAXParserFactory r101 = SAXParserFactory.newInstance();     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        r101.setFeature("http://xml.org/sax/features/external-general-entities", false);     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        r101.setFeature("http://xml.org/sax/features/external-parameter-entities", false);     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        XMLReader r102 = r101.newSAXParser().getXMLReader();     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        f r103 = new f(this);     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        r102.setContentHandler(r103);     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        r102.setProperty("http://xml.org/sax/properties/lexical-handler", r103);     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        r102.parse(new InputSource(r100));     // Catch: IOException -> L4 SAXException -> L7 ParserConfigurationException -> L10
        return;
    L4:
        e = move-exception;
        throw new SVGParseException("Stream error", e);
    L10:
        e = move-exception;
        throw new SVGParseException("XML parser problem", e);
    L7:
        e = move-exception;
        throw new SVGParseException("SVG parse error", e);
    }

    public final void F(InputStream r100) throws SVGParseException {
        XmlPullParser r101 = Xml.newPullParser();     // Catch: IOException -> L39 XmlPullParserException -> L42
        h r102 = new h(r101);     // Catch: IOException -> L39 XmlPullParserException -> L42
        r101.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);     // Catch: IOException -> L39 XmlPullParserException -> L42
        r101.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: IOException -> L39 XmlPullParserException -> L42
        r101.setInput(r100, null);     // Catch: IOException -> L39 XmlPullParserException -> L42
        int r103 = r101.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L42
    L3:
        if (r103 == 1) goto L38;
        if (r103 != 0) goto L6;
        this.f272937a = new SVG();     // Catch: IOException -> L39 XmlPullParserException -> L42
    L36:
        r103 = r101.nextToken();     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L3
    L6:
        if (r103 != 8) goto L8;
        r101.getText();     // Catch: IOException -> L39 XmlPullParserException -> L42
        g r104 = new g(r101.getText());     // Catch: IOException -> L39 XmlPullParserException -> L42
        String r105 = r104.l();     // Catch: IOException -> L39 XmlPullParserException -> L42
        C(r104);     // Catch: IOException -> L39 XmlPullParserException -> L42
        r105.equals("xml-stylesheet");     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L36
    L8:
        if (r103 == 10) goto L29;
        if (r103 != 2) goto L12;
        String r106 = r101.getName();     // Catch: IOException -> L39 XmlPullParserException -> L42
        if (r101.getPrefix() == null) goto L27;
        r106 = r101.getPrefix() + ':' + r106;     // Catch: IOException -> L39 XmlPullParserException -> L42
    L27:
        J(r101.getNamespace(), r101.getName(), r106, r102);     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L36
    L12:
        if (r103 != 3) goto L14;
        String r107 = r101.getName();     // Catch: IOException -> L39 XmlPullParserException -> L42
        if (r101.getPrefix() == null) goto L23;
        r107 = r101.getPrefix() + ':' + r107;     // Catch: IOException -> L39 XmlPullParserException -> L42
    L23:
        c(r101.getNamespace(), r101.getName(), r107);     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L36
    L14:
        if (r103 != 4) goto L16;
        int[] r108 = new int[2];     // Catch: IOException -> L39 XmlPullParserException -> L42
        M(r101.getTextCharacters(r108), r108[0], r108[1]);     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L36
    L16:
        if (r103 != 5) goto L36;
        L(r101.getText());     // Catch: IOException -> L39 XmlPullParserException -> L42
        goto L36
    L29:
        if (this.f272937a.f272756a != null) goto L36;
        if (r101.getText().contains("<!ENTITY ") == false) goto L36;
        r100.reset();     // Catch: IOException -> L45 XmlPullParserException -> L42
        E(r100);     // Catch: IOException -> L45 XmlPullParserException -> L42
        return;
    L61:
        return;
    L38:
        return;
    L42:
        e = move-exception;
        throw new SVGParseException("XML parser problem", e);
    L39:
        e = move-exception;
        throw new SVGParseException("Stream error", e);
    }

    public final void G(Attributes r100) throws SVGParseException {
        if (this.f272938b == null) goto L58;
        SVG.x r101 = new SVG.x();
        r101.f272872a = this.f272937a;
        r101.f272873b = this.f272938b;
        i(r101, r100);
        l(r101, r100);
        h(r101, r100);
        o(r101, r100);
        int r102 = 0;
    L6:
        if (r102 >= r100.getLength()) goto L55;
        String r103 = r100.getValue(r102).trim();
        int r104 = a.f272969b[SVGAttr.fromString(r100.getLocalName(r102)).ordinal()];
        if (r104 != 1) goto L10;
        r101.f272917t = w(r103);
    L54:
        r102 = r102 + 1;
        goto L6
    L10:
        if (r104 != 2) goto L12;
        r101.f272918u = w(r103);
        goto L54
    L12:
        if (r104 != 3) goto L14;
        SVG.o r105 = w(r103);
        r101.f272919v = r105;
        if (r105.f() == false) goto L54;
        throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
    L14:
        if (r104 != 4) goto L16;
        SVG.o r106 = w(r103);
        r101.f272920w = r106;
        if (r106.f() == false) goto L54;
        throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
    L16:
        if (r104 == 6) goto L38;
        switch(r104) {
            case 40: goto L30;
            case 41: goto L22;
            case 42: goto L20;
            default: goto L54;
        };
    L20:
        r101.f272916s = D(r103);
        goto L54
    L22:
        if ("objectBoundingBox".equals(r103) == false) goto L25;
        r101.f272915r = Boolean.FALSE;
        goto L54
    L25:
        if ("userSpaceOnUse".equals(r103) == false) goto L28;
        r101.f272915r = Boolean.TRUE;
        goto L54
    L28:
        throw new SVGParseException("Invalid value for attribute patternContentUnits");
    L30:
        if ("objectBoundingBox".equals(r103) == false) goto L33;
        r101.f272914q = Boolean.FALSE;
        goto L54
    L33:
        if ("userSpaceOnUse".equals(r103) == false) goto L36;
        r101.f272914q = Boolean.TRUE;
        goto L54
    L36:
        throw new SVGParseException("Invalid value for attribute patternUnits");
    L38:
        if ("".equals(r100.getURI(r102)) == false) goto L40;
    L41:
        r101.f272921x = r103;
        goto L54
    L40:
        if ("http://www.w3.org/1999/xlink".equals(r100.getURI(r102)) == false) goto L54;
    L55:
        this.f272938b.f(r101);
        this.f272938b = r101;
        return;
    L58:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final void I(Attributes r100) throws SVGParseException {
        if (this.f272938b == null) goto L7;
        SVG.b0 r101 = new SVG.b0();
        r101.f272872a = this.f272937a;
        r101.f272873b = this.f272938b;
        i(r101, r100);
        l(r101, r100);
        this.f272938b.f(r101);
        this.f272938b = r101;
        return;
    L7:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final void K(Attributes r100) throws SVGParseException {
        if (this.f272938b == null) goto L28;
        boolean r101 = false;
        String r102 = "all";
        int r103 = 0;
        boolean r104 = true;
    L6:
        if (r103 >= r100.getLength()) goto L15;
        String r105 = r100.getValue(r103).trim();
        int r106 = a.f272969b[SVGAttr.fromString(r100.getLocalName(r103)).ordinal()];
        if (r106 != 88) goto L10;
        r104 = r105.equals("text/css");
    L14:
        r103 = r103 + 1;
        goto L6
    L10:
        if (r106 != 89) goto L14;
        r102 = r105;
        goto L14
    L15:
        if (r104 == false) goto L25;
        CSSParser.MediaType r107 = CSSParser.MediaType.screen;
        CSSParser.c r108 = new CSSParser.c(r102);
        r108.q();
        Iterator r109 = ((ArrayList) CSSParser.c(r108)).iterator();
    L18:
        if (r109.hasNext() == false) goto L23;
        CSSParser.MediaType r110 = (CSSParser.MediaType) r109.next();
        if (r110 == CSSParser.MediaType.all) goto L22;
        if (r110 != r107) goto L18;
    L22:
        r101 = true;
    L23:
        if (r101 == false) goto L25;
        this.f272944h = true;
        return;
    L25:
        this.f272939c = true;
        this.f272940d = 1;
        return;
    L28:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final void L(String r100) throws SVGParseException {
        if (this.f272939c == false) goto L6;
        return;
    L6:
        if (this.f272941e == false) goto L12;
        if (this.f272943g != null) goto L10;
        this.f272943g = new StringBuilder(r100.length());
    L10:
        this.f272943g.append(r100);
        return;
    L12:
        if (this.f272944h == false) goto L18;
        if (this.f272945i != null) goto L16;
        this.f272945i = new StringBuilder(r100.length());
    L16:
        this.f272945i.append(r100);
        return;
    L18:
        if ((this.f272938b instanceof SVG.w0) == false) goto L23;
        a(r100);
        return;
    }

    public final void N(Attributes r100) throws SVGParseException {
        if (this.f272938b == null) goto L7;
        SVG.c1 r101 = new SVG.c1();
        r101.f272872a = this.f272937a;
        r101.f272873b = this.f272938b;
        i(r101, r100);
        h(r101, r100);
        o(r101, r100);
        this.f272938b.f(r101);
        this.f272938b = r101;
        return;
    L7:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final void a(String r100) throws SVGParseException {
        SVG.f0 r101 = (SVG.f0) this.f272938b;
        int r102 = r101.f272839i.size();
        if (r102 != 0) goto L5;
        SVG.l0 r103 = null;
    L7:
        if ((r103 instanceof SVG.a1) == false) goto L9;
        StringBuilder r104 = new StringBuilder();
        SVG.a1 r105 = (SVG.a1) r103;
        r104.append(r105.f272813c);
        r104.append(r100);
        r105.f272813c = r104.toString();
        return;
    L9:
        this.f272938b.f(new SVG.a1(r100));
        return;
    L5:
        r103 = (SVG.l0) ListProtector.get(r101.f272839i, r102 - 1);
        goto L7
    }

    public final void f(Attributes r100) throws SVGParseException {
        if (this.f272938b == null) goto L52;
        SVG.r r101 = new SVG.r();
        r101.f272872a = this.f272937a;
        r101.f272873b = this.f272938b;
        i(r101, r100);
        l(r101, r100);
        h(r101, r100);
        int r102 = 0;
    L6:
        if (r102 >= r100.getLength()) goto L49;
        String r103 = r100.getValue(r102).trim();
        int r104 = a.f272969b[SVGAttr.fromString(r100.getLocalName(r102)).ordinal()];
        if (r104 != 1) goto L10;
        w(r103);
    L48:
        r102 = r102 + 1;
        goto L6
    L10:
        if (r104 != 2) goto L12;
        w(r103);
        goto L48
    L12:
        if (r104 != 3) goto L14;
        SVG.o r105 = w(r103);
        r101.f272901q = r105;
        if (r105.f() == false) goto L48;
        throw new SVGParseException("Invalid <mask> element. width cannot be negative");
    L14:
        if (r104 != 4) goto L16;
        SVG.o r106 = w(r103);
        r101.f272902r = r106;
        if (r106.f() == false) goto L48;
        throw new SVGParseException("Invalid <mask> element. height cannot be negative");
    L16:
        if (r104 == 43) goto L29;
        if (r104 != 44) goto L48;
        if ("objectBoundingBox".equals(r103) == false) goto L24;
        r101.f272900p = Boolean.FALSE;
        goto L48
    L24:
        if ("userSpaceOnUse".equals(r103) == false) goto L27;
        r101.f272900p = Boolean.TRUE;
        goto L48
    L27:
        throw new SVGParseException("Invalid value for attribute maskContentUnits");
    L29:
        if ("objectBoundingBox".equals(r103) == false) goto L32;
        r101.f272899o = Boolean.FALSE;
        goto L48
    L32:
        if ("userSpaceOnUse".equals(r103) == false) goto L35;
        r101.f272899o = Boolean.TRUE;
        goto L48
    L35:
        throw new SVGParseException("Invalid value for attribute maskUnits");
    L49:
        this.f272938b.f(r101);
        this.f272938b = r101;
        return;
    L52:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final SVG g(InputStream r100) throws SVGParseException {
        if (r100.markSupported() == true) goto L27;
        r100 = new BufferedInputStream(r100);
    L27:
        r100.mark(3);     // Catch: IOException -> L18
        int r101 = r100.read() + (r100.read() << 8);     // Catch: IOException -> L18
        r100.reset();     // Catch: IOException -> L18
        if (r101 != 35615) goto L25;
        r100 = new BufferedInputStream(new GZIPInputStream(r100));     // Catch: IOException -> L18
    L25:
        r100.mark(4096);     // Catch: Throwable -> L15
        F(r100);     // Catch: Throwable -> L15
        r100.close();     // Catch: IOException -> L19
    L14:
        return this.f272937a;
    L15:
        th = move-exception;
        r100.close();     // Catch: IOException -> L20
    L17:
        throw th;
    }

    public static void B(SVG.n0 r100, String r101) throws SVGParseException {
        g r102 = new g(r101);
        r102.q();
        String r103 = r102.l();
        if ("defer".equals(r103) == false) goto L5;
        r102.q();
        r103 = r102.l();
    L5:
        PreserveAspectRatio.Alignment r104 = (PreserveAspectRatio.Alignment) ((HashMap) b.f272970a).get(r103);
        r102.q();
        if (r102.f() == true) goto L15;
        String r105 = r102.l();
        r105.getClass();
        if (r105.equals("meet") == false) goto L10;
        PreserveAspectRatio.Scale r106 = PreserveAspectRatio.Scale.meet;
    L16:
        r100.f272880o = new PreserveAspectRatio(r104, r106);
        return;
    L10:
        if (r105.equals("slice") == false) goto L13;
        r106 = PreserveAspectRatio.Scale.slice;
        goto L16
    L13:
        throw new SVGParseException("Invalid preserveAspectRatio definition: ".concat(r101));
    L15:
        r106 = null;
        goto L16
    }

    public static void h(SVG.e0 r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L37;
        String r103 = r101.getValue(r102).trim();
        switch(a.f272969b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()]) {
            case 21: goto L27;
            case 22: goto L26;
            case 23: goto L18;
            case 24: goto L13;
            case 25: goto L8;
            default: goto L36;
        };
    L8:
        List<String> r104 = t(r103);
        if (r104 == null) goto L11;
        HashSet r105 = new HashSet(r104);
    L12:
        r100.l(r105);
        goto L36
    L11:
        r105 = new HashSet(0);
        goto L12
    L13:
        g r106 = new g(r103);
        HashSet r107 = new HashSet();
    L15:
        if (r106.f() == true) goto L17;
        r107.add(r106.l());
        r106.q();
        goto L15
    L17:
        r100.k(r107);
        goto L36
    L18:
        g r108 = new g(r103);
        HashSet r109 = new HashSet();
    L20:
        if (r108.f() == true) goto L25;
        String r110 = r108.l();
        int r111 = r110.indexOf(45);
        if (r111 == (-1)) goto L24;
        r110 = r110.substring(0, r111);
    L24:
        r109.add(new Locale(r110, "", "").getLanguage());
        r108.q();
        goto L20
    L25:
        r100.i(r109);
        goto L36
    L26:
        r100.b(r103);
        goto L36
    L27:
        g r112 = new g(r103);
        HashSet r113 = new HashSet();
    L29:
        if (r112.f() == true) goto L35;
        String r114 = r112.l();
        if (r114.startsWith("http://www.w3.org/TR/SVG11/feature#") == false) goto L33;
        r113.add(r114.substring(35));
    L34:
        r112.q();
        goto L29
    L33:
        r113.add("UNSUPPORTED");
        goto L34
    L35:
        r100.m(r113);
    L36:
        r102 = r102 + 1;
        goto L4
    }

    public static void i(SVG.j0 r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L29;
        String r103 = r101.getQName(r102);
        if (r103.equals("id") == true) goto L21;
        if (r103.equals("xml:id") == true) goto L21;
        if (r103.equals("xml:space") == true) goto L12;
        r102 = r102 + 1;
        goto L4
    L12:
        String r104 = r101.getValue(r102).trim();
        if ("default".equals(r104) == false) goto L16;
        r100.f272862d = Boolean.FALSE;
        return;
    L16:
        if ("preserve".equals(r104) == false) goto L19;
        r100.f272862d = Boolean.TRUE;
        return;
    L19:
        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + r104);
    L21:
        r100.f272861c = r101.getValue(r102).trim();
        return;
    }

    public static void j(SVG.j r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L28;
        String r103 = r101.getValue(r102).trim();
        int r104 = a.f272969b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 == 6) goto L23;
        switch(r104) {
            case 32: goto L15;
            case 33: goto L13;
            case 34: goto L29;
            default: goto L27;
        };
    L13:
        r100.f272858j = D(r103);
        goto L27
    L29:
        r100.f272859k = SVG.GradientSpread.valueOf(r103);     // Catch: IllegalArgumentException -> L11
    L12:
        throw new SVGParseException("Invalid spreadMethod attribute. \"" + r103 + "\" is not a valid value.");
    L15:
        if ("objectBoundingBox".equals(r103) == false) goto L18;
        r100.f272857i = Boolean.FALSE;
        goto L27
    L18:
        if ("userSpaceOnUse".equals(r103) == false) goto L21;
        r100.f272857i = Boolean.TRUE;
        goto L27
    L21:
        throw new SVGParseException("Invalid value for attribute gradientUnits");
    L27:
        r102 = r102 + 1;
        goto L4
    L23:
        if ("".equals(r101.getURI(r102)) == false) goto L25;
    L26:
        r100.f272860l = r103;
        goto L27
    L25:
        if ("http://www.w3.org/1999/xlink".equals(r101.getURI(r102)) == false) goto L27;
    }

    public static void l(SVG.j0 r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L41;
        String r103 = r101.getValue(r102).trim();
        if (r103.length() == 0) goto L32;
        int r104 = a.f272969b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 != 45) goto L11;
        g r105 = new g(r103.replaceAll("/\\*.*?\\*/", ""));
    L27:
        String r106 = r105.m(':', false);
        r105.q();
        if (r105.d(':') == false) goto L32;
        r105.q();
        String r107 = r105.m(';', true);
        if (r107 == null) goto L32;
        r105.q();
        if (r105.f() == true) goto L38;
        if (r105.d(';') == false) goto L27;
    L38:
        if (r100.f272864f != null) goto L40;
        r100.f272864f = new SVG.Style();
    L40:
        H(r100.f272864f, r106, r107);
        r105.q();
        goto L27
    L11:
        if (r104 != 46) goto L13;
        CSSParser.c r108 = new CSSParser.c(r103);
        ArrayList r109 = null;
    L18:
        if (r108.f() == true) goto L25;
        String r110 = r108.l();
        if (r110 == null) goto L18;
        if (r109 != null) goto L24;
        r109 = new ArrayList();
    L24:
        r109.add(r110);
        r108.q();
        goto L18
    L25:
        r100.f272865g = r109;
        goto L32
    L13:
        if (r100.f272863e != null) goto L15;
        r100.f272863e = new SVG.Style();
    L15:
        H(r100.f272863e, r101.getLocalName(r102), r101.getValue(r102).trim());
    L32:
        r102 = r102 + 1;
        goto L4
    }

    public static void m(SVG.y0 r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L19;
        String r103 = r101.getValue(r102).trim();
        int r104 = a.f272969b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 != 1) goto L8;
        r100.f272926o = x(r103);
    L18:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r104 != 2) goto L10;
        r100.f272927p = x(r103);
        goto L18
    L10:
        if (r104 != 19) goto L12;
        r100.f272928q = x(r103);
        goto L18
    L12:
        if (r104 != 20) goto L18;
        r100.f272929r = x(r103);
        goto L18
    }

    public static void n(SVG.m r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L9;
        if (SVGAttr.fromString(r101.getLocalName(r102)) != SVGAttr.transform) goto L8;
        r100.a(D(r101.getValue(r102)));
    L8:
        r102 = r102 + 1;
        goto L4
    }

    public static void o(SVG.p0 r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L31;
        String r103 = r101.getValue(r102).trim();
        int r104 = a.f272969b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 != 7) goto L8;
        B(r100, r103);
    L30:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r104 != 87) goto L30;
        g r105 = new g(r103);
        r105.q();
        float r106 = r105.i();
        r105.p();
        float r107 = r105.i();
        r105.p();
        float r108 = r105.i();
        r105.p();
        float r109 = r105.i();
        if (Float.isNaN(r106) == true) goto L28;
        if (Float.isNaN(r107) == true) goto L28;
        if (Float.isNaN(r108) == true) goto L28;
        if (Float.isNaN(r109) == true) goto L28;
        if (r108 < 0.0f) goto L26;
        if (r109 < 0.0f) goto L24;
        r100.f272892p = new SVG.b(r106, r107, r108, r109);
        goto L30
    L24:
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    L26:
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    L28:
        throw new SVGParseException("Invalid viewBox definition - should have four numbers");
    }

    public static float s(String r100, int r101) throws SVGParseException {
        float r102 = new com.caverock.androidsvg.b().a(r100, 0, r101);
        if (Float.isNaN(r102) == true) goto L6;
        return r102;
    L6:
        throw new SVGParseException("Invalid float value: " + r100);
    }

    public static void H(SVG.Style r110, String r111, String r112) {
        if (r112.length() != 0) goto L6;
        return;
    L6:
        if (r112.equals("inherit") == false) goto L8;
        return;
    L8:
        byte r100 = 3;
        switch(a.f272969b[SVGAttr.fromString(r111).ordinal()]) {
            case 47: goto L366;
            case 48: goto L357;
            case 49: goto L353;
            case 50: goto L350;
            case 51: goto L347;
            case 52: goto L345;
            case 53: goto L333;
            case 54: goto L320;
            case 55: goto L317;
            case 56: goto L289;
            case 57: goto L286;
            case 58: goto L285;
            case 59: goto L283;
            case 60: goto L236;
            case 61: goto L232;
            case 62: goto L380;
            case 63: goto L220;
            case 64: goto L217;
            case 65: goto L180;
            case 66: goto L170;
            case 67: goto L140;
            case 68: goto L116;
            case 69: goto L114;
            case 70: goto L113;
            case 71: goto L112;
            case 72: goto L111;
            case 73: goto L106;
            case 74: goto L100;
            case 75: goto L93;
            case 76: goto L91;
            case 77: goto L77;
            case 78: goto L75;
            case 79: goto L68;
            case 80: goto L66;
            case 81: goto L60;
            case 82: goto L58;
            case 83: goto L52;
            case 84: goto L50;
            case 85: goto L41;
            case 86: goto L11;
            default: goto L456;
        };
    L11:
        int r101 = r112.hashCode();
        if (r101 == (-933002398)) goto L27;
        if (r101 == 3005871) goto L23;
        if (r101 == 362741610) goto L19;
    L28:
        byte r102 = -1;
    L30:
        if (r102 == 0) goto L36;
        if (r102 == 1) goto L35;
        if (r102 == 2) goto L34;
        SVG.Style.RenderQuality r103 = null;
    L37:
        r110.M = r103;
        if (r103 == null) goto L396;
        r110.f272762a |= 137438953472L;
        return;
    L396:
        return;
    L34:
        r103 = SVG.Style.RenderQuality.optimizeSpeed;
        goto L37
    L35:
        r103 = SVG.Style.RenderQuality.auto;
        goto L37
    L36:
        r103 = SVG.Style.RenderQuality.optimizeQuality;
        goto L37
    L19:
        if (r112.equals("optimizeSpeed") == false) goto L28;
        r102 = 2;
        goto L30
    L23:
        if (r112.equals("auto") == false) goto L28;
        r102 = 1;
        goto L30
    L27:
        if (r112.equals("optimizeQuality") == false) goto L28;
        r102 = 0;
        goto L30
    L50:
        r110.K = z(r112);
        r110.f272762a |= 17179869184L;
        return;
    L58:
        r110.I = z(r112);
        r110.f272762a |= 4294967296L;
        return;
    L66:
        r110.G = v(r112);
        r110.f272762a |= 1073741824;
        return;
    L75:
        r110.E = v(r112);
        r110.f272762a |= 268435456;
        return;
    L91:
        r110.D = z(r112);
        r110.f272762a |= 134217728;
        return;
    L111:
        r110.f272787z = v(r112);
        r110.f272762a |= 8388608;
        return;
    L112:
        r110.f272786y = v(r112);
        r110.f272762a |= 4194304;
        return;
    L113:
        r110.f272785x = v(r112);
        r110.f272762a |= 2097152;
        return;
    L114:
        String r104 = v(r112);
        r110.f272785x = r104;
        r110.f272786y = r104;
        r110.f272787z = r104;
        r110.f272762a |= 14680064;
        return;
    L140:
        int r105 = r112.hashCode();
        if (r105 == (-1074341483)) goto L156;
        if (r105 == 100571) goto L152;
        if (r105 == 109757538) goto L148;
    L157:
        byte r106 = -1;
    L159:
        if (r106 == 0) goto L165;
        if (r106 == 1) goto L164;
        if (r106 == 2) goto L163;
        SVG.Style.TextAnchor r107 = null;
    L166:
        r110.f272782u = r107;
        if (r107 == null) goto L424;
        r110.f272762a |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        return;
    L424:
        return;
    L163:
        r107 = SVG.Style.TextAnchor.Start;
        goto L166
    L164:
        r107 = SVG.Style.TextAnchor.End;
        goto L166
    L165:
        r107 = SVG.Style.TextAnchor.Middle;
        goto L166
    L148:
        if (r112.equals("start") == false) goto L157;
        r106 = 2;
        goto L159
    L152:
        if (r112.equals("end") == false) goto L157;
        r106 = 1;
        goto L159
    L156:
        if (r112.equals("middle") == false) goto L157;
        r106 = 0;
        goto L159
    L217:
        SVG.Style.FontStyle r108 = u(r112);
        r110.f272779r = r108;
        if (r108 == null) goto L430;
        r110.f272762a |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        return;
    L430:
        return;
    L220:
        Integer r109 = (Integer) ((HashMap) e.f272973a).get(r112);
        r110.f272778q = r109;
        if (r109 == null) goto L432;
        r110.f272762a |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        return;
    L432:
        return;
    L232:
        List<String> r113 = t(r112);
        r110.f272776o = r113;
        if (r113 == null) goto L436;
        r110.f272762a |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        return;
    L436:
        return;
    L283:
        r110.f272775n = p(r112);     // Catch: SVGParseException -> L370
        r110.f272762a |= 4096;     // Catch: SVGParseException -> L370
        return;
    L285:
        r110.f272774m = z(r112);
        r110.f272762a |= 2048;
        return;
    L286:
        r110.f272773l = w(r112);     // Catch: SVGParseException -> L370
        r110.f272762a |= 1024;     // Catch: SVGParseException -> L370
        return;
    L317:
        r110.f272771j = Float.valueOf(r(r112));     // Catch: SVGParseException -> L370
        r110.f272762a |= 256;     // Catch: SVGParseException -> L370
        return;
    L345:
        r110.f272768g = w(r112);     // Catch: SVGParseException -> L370
        r110.f272762a |= 32;     // Catch: SVGParseException -> L370
        return;
    L347:
        Float r114 = z(r112);
        r110.f272767f = r114;
        if (r114 == null) goto L447;
        r110.f272762a |= 16;
        return;
    L447:
        return;
    L350:
        SVG.m0 r115 = A(r112);
        r110.f272766e = r115;
        if (r115 == null) goto L449;
        r110.f272762a |= 8;
        return;
    L449:
        return;
    L353:
        Float r116 = z(r112);
        r110.f272765d = r116;
        if (r116 == null) goto L451;
        r110.f272762a |= 4;
        return;
    L451:
        return;
    L366:
        SVG.m0 r117 = A(r112);
        r110.f272763b = r117;
        if (r117 == null) goto L455;
        r110.f272762a |= 1;
        return;
    L455:
        return;
    L380:
        SVG.o r118 = (SVG.o) ((HashMap) d.f272972a).get(r112);     // Catch: SVGParseException -> L228
        if (r118 != null) goto L227;
        SVG.o r119 = w(r112);     // Catch: SVGParseException -> L228
    L229:
        r110.f272777p = r119;
        if (r119 == null) goto L434;
        r110.f272762a |= 16384;
        return;
    L434:
        return;
    L227:
        r119 = r118;
    L228:
        r119 = null;
        goto L229
    L456:
        return;
    L41:
        if (r112.equals("none") == false) goto L43;
        SVG.Style.VectorEffect r120 = SVG.Style.VectorEffect.None;
    L47:
        r110.L = r120;
        if (r120 == null) goto L398;
        r110.f272762a |= 34359738368L;
        return;
    L398:
        return;
    L43:
        if (r112.equals("non-scaling-stroke") == true) goto L45;
        r120 = null;
        goto L47
    L45:
        r120 = SVG.Style.VectorEffect.NonScalingStroke;
        goto L47
    L52:
        if (r112.equals("currentColor") == false) goto L374;
        r110.f272761J = SVG.g.f272845a;
    L55:
        r110.f272762a |= 8589934592L;
        return;
    L374:
        r110.f272761J = p(r112);     // Catch: SVGParseException -> L56
    L56:
        e = move-exception;
        e.getMessage();
        return;
    L60:
        if (r112.equals("currentColor") == false) goto L378;
        r110.H = SVG.g.f272845a;
    L63:
        r110.f272762a |= j0.G2_OTA_SPACE_RESERVE_BYTES;
        return;
    L378:
        r110.H = p(r112);     // Catch: SVGParseException -> L64
    L64:
        e = move-exception;
        e.getMessage();
        return;
    L68:
        if ("nonzero".equals(r112) == false) goto L71;
        SVG.Style.FillRule r121 = SVG.Style.FillRule.NonZero;
    L74:
        r110.F = r121;
        r110.f272762a |= 536870912;
        return;
    L71:
        if ("evenodd".equals(r112) == false) goto L73;
        r121 = SVG.Style.FillRule.EvenOdd;
        goto L74
    L73:
        r121 = null;
        goto L74
    L77:
        if ("auto".equals(r112) == false) goto L80;
    L86:
        SVG.c r122 = null;
    L88:
        r110.f272784w = r122;
        if (r122 == null) goto L409;
        r110.f272762a |= 1048576;
        return;
    L409:
        return;
    L80:
        if (r112.startsWith("rect(") == false) goto L86;
        g r123 = new g(r112.substring(5));
        r123.q();
        SVG.o r124 = y(r123);
        r123.p();
        SVG.o r125 = y(r123);
        r123.p();
        SVG.o r126 = y(r123);
        r123.p();
        SVG.o r127 = y(r123);
        r123.q();
        if (r123.d(')') == false) goto L85;
    L87:
        r122 = new SVG.c(r124, r125, r126, r127);
        goto L88
    L85:
        if (r123.f() == true) goto L87;
    L93:
        if (r112.equals("currentColor") == false) goto L372;
        r110.C = SVG.g.f272845a;
    L96:
        r110.f272762a |= 67108864;
        return;
    L372:
        r110.C = p(r112);     // Catch: SVGParseException -> L97
    L97:
        e = move-exception;
        e.getMessage();
        return;
    L100:
        if (r112.indexOf(124) < 0) goto L102;
        return;
    L102:
        if ("|visible|hidden|collapse|".contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112 + '|') == false) goto L457;
        r110.B = Boolean.valueOf(r112.equals("visible"));
        r110.f272762a |= 33554432;
        return;
    L457:
        return;
    L106:
        if (r112.indexOf(124) < 0) goto L108;
        return;
    L108:
        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112 + '|') == false) goto L458;
        r110.A = Boolean.valueOf(!r112.equals("none"));
        r110.f272762a |= 16777216;
        return;
    L458:
        return;
    L116:
        switch(r112.hashCode()) {
            case -1217487446: goto L130;
            case -907680051: goto L126;
            case 3005871: goto L122;
            case 466743410: goto L119;
            default: goto L117;
        };
    L117:
        r100 = -1;
    L133:
        switch(r100) {
            case 0: goto L136;
            case 1: goto L136;
            case 2: goto L135;
            case 3: goto L135;
            default: goto L134;
        };
    L134:
        Boolean r128 = null;
    L137:
        r110.f272783v = r128;
        if (r128 == null) goto L422;
        r110.f272762a |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        return;
    L422:
        return;
    L135:
        r128 = Boolean.TRUE;
        goto L137
    L136:
        r128 = Boolean.FALSE;
        goto L137
    L119:
        if (r112.equals("visible") == true) goto L133;
    L122:
        if (r112.equals("auto") == false) goto L117;
        r100 = 2;
        goto L133
    L126:
        if (r112.equals(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L117;
        r100 = 1;
        goto L133
    L130:
        if (r112.equals("hidden") == false) goto L117;
        r100 = 0;
        goto L133
    L170:
        if (r112.equals("ltr") == false) goto L172;
        SVG.Style.TextDirection r129 = SVG.Style.TextDirection.LTR;
    L176:
        r110.f272781t = r129;
        if (r129 == null) goto L426;
        r110.f272762a |= 68719476736L;
        return;
    L426:
        return;
    L172:
        if (r112.equals("rtl") == true) goto L174;
        r129 = null;
        goto L176
    L174:
        r129 = SVG.Style.TextDirection.RTL;
        goto L176
    L180:
        switch(r112.hashCode()) {
            case -1171789332: goto L199;
            case -1026963764: goto L195;
            case 3387192: goto L191;
            case 93826908: goto L187;
            case 529818312: goto L183;
            default: goto L202;
        };
    L202:
        byte r130 = -1;
    L203:
        if (r130 == 0) goto L213;
        if (r130 == 1) goto L212;
        if (r130 == 2) goto L211;
        if (r130 == 3) goto L210;
        if (r130 == 4) goto L209;
        SVG.Style.TextDecoration r131 = null;
    L214:
        r110.f272780s = r131;
        if (r131 == null) goto L428;
        r110.f272762a |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        return;
    L428:
        return;
    L209:
        r131 = SVG.Style.TextDecoration.Overline;
        goto L214
    L210:
        r131 = SVG.Style.TextDecoration.Blink;
        goto L214
    L211:
        r131 = SVG.Style.TextDecoration.None;
        goto L214
    L212:
        r131 = SVG.Style.TextDecoration.Underline;
        goto L214
    L213:
        r131 = SVG.Style.TextDecoration.LineThrough;
        goto L214
    L183:
        if (r112.equals("overline") == false) goto L202;
        r130 = 4;
        goto L203
    L187:
        if (r112.equals(IPerformanceManager.MODULE_BLINK) == false) goto L202;
        r130 = 3;
        goto L203
    L191:
        if (r112.equals("none") == false) goto L202;
        r130 = 2;
        goto L203
    L195:
        if (r112.equals(SegmentStyle.UNDERLINE) == false) goto L202;
        r130 = 1;
        goto L203
    L199:
        if (r112.equals(SegmentStyle.LINE_THROUGH) == false) goto L202;
        r130 = 0;
        goto L203
    L236:
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112 + '|') == false) goto L459;
        g r132 = new g(r112);
        Integer r133 = null;
        SVG.Style.FontStyle r134 = null;
        String r135 = null;
    L239:
        String r136 = r132.m('/', false);
        r132.q();
        if (r136 == null) goto L465;
        if (r133 == null) goto L246;
        if (r134 == null) goto L246;
    L376:
        SVG.o r137 = (SVG.o) ((HashMap) d.f272972a).get(r136);     // Catch: SVGParseException -> L264
        if (r137 != null) goto L266;
        r137 = w(r136);     // Catch: SVGParseException -> L264
    L266:
        if (r132.d('/') == false) goto L272;
        r132.q();
        String r138 = r132.l();
        if (r138 == null) goto L270;
        w(r138);     // Catch: SVGParseException -> L370
    L270:
        r132.q();
    L272:
        if (r132.f() == false) goto L274;
        String r139 = null;
    L275:
        r110.f272776o = t(r139);
        r110.f272777p = r137;
        if (r133 != null) goto L278;
        int r140 = 400;
    L279:
        r110.f272778q = Integer.valueOf(r140);
        if (r134 != null) goto L282;
        r134 = SVG.Style.FontStyle.Normal;
    L282:
        r110.f272779r = r134;
        r110.f272762a |= 122880;
        return;
    L278:
        r140 = r133.intValue();
        goto L279
    L274:
        int r141 = r132.f272976b;
        r132.f272976b = r132.f272977c;
        r139 = r132.f272975a.substring(r141);
    L264:
        r137 = null;
    L246:
        if (r136.equals("normal") == true) goto L239;
        if (r133 != null) goto L252;
        r133 = (Integer) ((HashMap) e.f272973a).get(r136);
        if (r133 != null) goto L239;
    L252:
        if (r134 != null) goto L256;
        r134 = u(r136);
        if (r134 != null) goto L239;
    L256:
        if (r135 != null) goto L376;
        if (r136.equals("small-caps") == false) goto L376;
        r135 = r136;
        goto L239
    L465:
        return;
    L459:
        return;
    L289:
        if ("none".equals(r112) == false) goto L291;
        r110.f272772k = null;
        r110.f272762a |= 512;
        return;
    L291:
        g r142 = new g(r112);
        r142.q();
        if (r142.f() == true) goto L312;
        SVG.o r143 = r142.j();
        if (r143 == null) goto L312;
        if (r143.f() == true) goto L312;
        float r144 = r143.f272881a;
        ArrayList r145 = new ArrayList();
        r145.add(r143);
    L302:
        if (r142.f() == true) goto L311;
        r142.p();
        SVG.o r146 = r142.j();
        if (r146 == null) goto L312;
        if (r146.f() == true) goto L312;
        r145.add(r146);
        r144 = r144 + r146.f272881a;
        goto L302
    L311:
        if (r144 == 0.0f) goto L312;
        SVG.o[] r147 = (SVG.o[]) r145.toArray(new SVG.o[r145.size()]);
    L314:
        r110.f272772k = r147;
        if (r147 == null) goto L441;
        r110.f272762a |= 512;
        return;
    L441:
        return;
    L312:
        r147 = null;
        goto L314
    L320:
        if ("miter".equals(r112) == false) goto L323;
        SVG.Style.LineJoin r148 = SVG.Style.LineJoin.Miter;
    L329:
        r110.f272770i = r148;
        if (r148 == null) goto L443;
        r110.f272762a |= 128;
        return;
    L443:
        return;
    L323:
        if ("round".equals(r112) == false) goto L326;
        r148 = SVG.Style.LineJoin.Round;
        goto L329
    L326:
        if ("bevel".equals(r112) == false) goto L328;
        r148 = SVG.Style.LineJoin.Bevel;
        goto L329
    L328:
        r148 = null;
        goto L329
    L333:
        if ("butt".equals(r112) == false) goto L336;
        SVG.Style.LineCap r149 = SVG.Style.LineCap.Butt;
    L342:
        r110.f272769h = r149;
        if (r149 == null) goto L445;
        r110.f272762a |= 64;
        return;
    L445:
        return;
    L336:
        if ("round".equals(r112) == false) goto L339;
        r149 = SVG.Style.LineCap.Round;
        goto L342
    L339:
        if ("square".equals(r112) == false) goto L341;
        r149 = SVG.Style.LineCap.Square;
        goto L342
    L341:
        r149 = null;
        goto L342
    L357:
        if ("nonzero".equals(r112) == false) goto L360;
        SVG.Style.FillRule r150 = SVG.Style.FillRule.NonZero;
    L363:
        r110.f272764c = r150;
        if (r150 == null) goto L453;
        r110.f272762a |= 2;
        return;
    L453:
        return;
    L360:
        if ("evenodd".equals(r112) == false) goto L362;
        r150 = SVG.Style.FillRule.EvenOdd;
        goto L363
    L362:
        r150 = null;
        goto L363
    }

    public static int d(float r100, float r101, float r102) {
        float r103 = 0.0f;
        float r104 = r100 % 360.0f;
        if (r100 >= 0.0f) goto L6;
        r104 = r104 + 360.0f;
    L6:
        float r105 = r104 / 60.0f;
        float r106 = r101 / 100.0f;
        float r107 = r102 / 100.0f;
        if (r106 >= 0.0f) goto L10;
        r106 = 0.0f;
    L13:
        if (r107 < 0.0f) goto L20;
        if (r107 <= 1.0f) goto L18;
        r103 = 1.0f;
        goto L20
    L18:
        r103 = r107;
    L20:
        if (r103 > 0.5f) goto L22;
        float r108 = (r106 + 1.0f) * r103;
    L23:
        float r109 = (r103 * 2.0f) - r108;
        float r110 = e(r109, r108, r105 + 2.0f);
        float r111 = e(r109, r108, r105);
        float r112 = e(r109, r108, r105 - 2.0f);
        int r113 = (b(r110 * 256.0f) << 16) | (b(r111 * 256.0f) << 8);
        return b(r112 * 256.0f) | r113;
    L22:
        r108 = (r103 + r106) - (r106 * r103);
        goto L23
    L10:
        if (r106 <= 1.0f) goto L13;
        r106 = 1.0f;
        goto L13
    }

    public static void k(SVG.y r100, Attributes r101, String r110) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L24;
        if (SVGAttr.fromString(r101.getLocalName(r102)) != SVGAttr.points) goto L23;
        g r103 = new g(r101.getValue(r102));
        ArrayList r104 = new ArrayList();
        r103.q();
    L9:
        if (r103.f() == true) goto L19;
        float r105 = r103.i();
        if (Float.isNaN(r105) == true) goto L18;
        r103.p();
        float r106 = r103.i();
        if (Float.isNaN(r106) == true) goto L16;
        r103.p();
        r104.add(Float.valueOf(r105));
        r104.add(Float.valueOf(r106));
        goto L9
    L16:
        throw new SVGParseException("Invalid <" + r110 + "> points attribute. There should be an even number of coordinates.");
    L18:
        throw new SVGParseException("Invalid <" + r110 + "> points attribute. Non-coordinate content found in list.");
    L19:
        r100.f272925o = new float[r104.size()];
        Iterator r107 = r104.iterator();
        int r108 = 0;
    L21:
        if (r107.hasNext() == false) goto L23;
        r100.f272925o[r108] = ((Float) r107.next()).floatValue();
        r108 = r108 + 1;
    L23:
        r102 = r102 + 1;
        goto L4
    }

    public final void M(char[] r100, int r101, int r102) throws SVGParseException {
        if (this.f272939c == false) goto L6;
        return;
    L6:
        if (this.f272941e == false) goto L12;
        if (this.f272943g != null) goto L10;
        this.f272943g = new StringBuilder(r102);
    L10:
        this.f272943g.append(r100, r101, r102);
        return;
    L12:
        if (this.f272944h == false) goto L18;
        if (this.f272945i != null) goto L16;
        this.f272945i = new StringBuilder(r102);
    L16:
        this.f272945i.append(r100, r101, r102);
        return;
    L18:
        if ((this.f272938b instanceof SVG.w0) == false) goto L23;
        a(new String(r100, r101, r102));
        return;
    }

    public final void c(String r100, String r101, String r102) throws SVGParseException {
        if (this.f272939c == false) goto L9;
        int r103 = this.f272940d - 1;
        this.f272940d = r103;
        if (r103 != 0) goto L9;
        this.f272939c = false;
        return;
    L9:
        if ("http://www.w3.org/2000/svg".equals(r100) == true) goto L14;
        if ("".equals(r100) == true) goto L14;
        return;
    L14:
        if (r101.length() > 0) goto L17;
        r101 = r102;
    L17:
        int r104 = a.f272968a[SVGElem.fromString(r101).ordinal()];
        if (r104 != 1) goto L20;
    L45:
        this.f272938b = ((SVG.l0) this.f272938b).f272873b;
        return;
    L20:
        if (r104 == 2) goto L45;
        if (r104 == 4) goto L45;
        if (r104 == 5) goto L45;
        if (r104 == 13) goto L45;
        if (r104 == 14) goto L45;
        switch(r104) {
            case 16: goto L45;
            case 17: goto L45;
            case 18: goto L45;
            case 19: goto L45;
            case 20: goto L45;
            case 21: goto L45;
            case 22: goto L35;
            case 23: goto L35;
            case 24: goto L45;
            case 25: goto L45;
            case 26: goto L45;
            case 27: goto L45;
            case 28: goto L45;
            case 29: goto L45;
            case 30: goto L31;
            case 31: goto L45;
            default: goto L49;
        };
    L31:
        StringBuilder r105 = this.f272945i;
        if (r105 == null) goto L48;
        this.f272944h = false;
        String r106 = r105.toString();
        CSSParser r107 = new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document);
        SVG r108 = this.f272937a;
        CSSParser.c r109 = new CSSParser.c(r106);
        r109.q();
        CSSParser.m r110 = r107.e(r109);
        r108.f272758c.b(r110);
        this.f272945i.setLength(0);
        return;
    L48:
        return;
    L35:
        this.f272941e = false;
        if (this.f272943g == null) goto L47;
        SVGElem r111 = this.f272942f;
        if (r111 != SVGElem.title) goto L41;
        this.f272937a.getClass();
    L43:
        this.f272943g.setLength(0);
        return;
    L41:
        if (r111 != SVGElem.desc) goto L43;
        this.f272937a.getClass();
        goto L43
    L47:
        return;
    }

    public final void J(String r210, String r211, String r212, Attributes r213) throws SVGParseException {
        if (this.f272939c == false) goto L7;
        this.f272940d++;
        return;
    L7:
        if ("http://www.w3.org/2000/svg".equals(r210) == true) goto L12;
        if ("".equals(r210) == true) goto L12;
        return;
    L12:
        if (r211.length() <= 0) goto L14;
        String r100 = r211;
    L15:
        SVGElem r101 = SVGElem.fromString(r100);
        float r102 = 0.0f;
        switch(a.f272968a[r101.ordinal()]) {
            case 1: goto L557;
            case 2: goto L553;
            case 3: goto L553;
            case 4: goto L548;
            case 5: goto L514;
            case 6: goto L381;
            case 7: goto L339;
            case 8: goto L321;
            case 9: goto L297;
            case 10: goto L281;
            case 11: goto L276;
            case 12: goto L271;
            case 13: goto L266;
            case 14: goto L253;
            case 15: goto L229;
            case 16: goto L225;
            case 17: goto L220;
            case 18: goto L183;
            case 19: goto L167;
            case 20: goto L143;
            case 21: goto L103;
            case 22: goto L102;
            case 23: goto L102;
            case 24: goto L83;
            case 25: goto L60;
            case 26: goto L58;
            case 27: goto L23;
            case 28: goto L21;
            case 29: goto L20;
            case 30: goto L19;
            case 31: goto L18;
            default: goto L17;
        };
    L17:
        this.f272939c = true;
        this.f272940d = 1;
        return;
    L18:
        I(r213);
        return;
    L19:
        K(r213);
        return;
    L20:
        f(r213);
        return;
    L21:
        N(r213);
        return;
    L58:
        G(r213);
        return;
    L102:
        this.f272941e = true;
        this.f272942f = r101;
        return;
    L103:
        SVG.h0 r103 = this.f272938b;
        if (r103 == null) goto L141;
        if ((r103 instanceof SVG.j) == false) goto L139;
        SVG.c0 r104 = new SVG.c0();
        r104.f272872a = this.f272937a;
        r104.f272873b = this.f272938b;
        i(r104, r213);
        l(r104, r213);
        int r105 = 0;
    L109:
        if (r105 >= r213.getLength()) goto L137;
        String r106 = r213.getValue(r105).trim();
        if (a.f272969b[SVGAttr.fromString(r213.getLocalName(r105)).ordinal()] != 37) goto L131;
        if (r106.length() == 0) goto L136;
        int r107 = r106.length();
        if (r106.charAt(r106.length() - 1) != '%') goto L118;
        r107 = r107 - 1;
        boolean r108 = true;
    L585:
        float r109 = s(r106, r107);     // Catch: NumberFormatException -> L132
        float r110 = 100.0f;
        if (r108 == false) goto L123;
        r109 = r109 / 100.0f;     // Catch: NumberFormatException -> L132
    L123:
        if (r109 >= 0.0f) goto L126;
        r110 = 0.0f;
    L130:
        r104.f272827h = Float.valueOf(r110);
        goto L131
    L126:
        if (r109 > 100.0f) goto L130;
        r110 = r109;
    L132:
        e = move-exception;
        throw new SVGParseException("Invalid offset value in <stop>: ".concat(r106), e);
    L118:
        r108 = false;
        goto L585
    L136:
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    L131:
        r105 = r105 + 1;
        goto L109
    L137:
        this.f272938b.f(r104);
        this.f272938b = r104;
        return;
    L139:
        throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
    L141:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L229:
        SVG.h0 r111 = this.f272938b;
        if (r111 == null) goto L252;
        if ((r111 instanceof SVG.w0) == false) goto L250;
        SVG.s0 r112 = new SVG.s0();
        r112.f272872a = this.f272937a;
        r112.f272873b = this.f272938b;
        i(r112, r213);
        l(r112, r213);
        h(r112, r213);
        int r113 = 0;
    L235:
        if (r113 >= r213.getLength()) goto L245;
        String r114 = r213.getValue(r113).trim();
        if (a.f272969b[SVGAttr.fromString(r213.getLocalName(r113)).ordinal()] != 6) goto L244;
        if ("".equals(r213.getURI(r113)) == false) goto L242;
    L243:
        r112.f272903o = r114;
        goto L244
    L242:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r113)) == true) goto L243;
    L244:
        r113 = r113 + 1;
        goto L235
    L245:
        this.f272938b.f(r112);
        SVG.h0 r115 = r112.f272873b;
        if ((r115 instanceof SVG.z0) == false) goto L248;
        r112.f272904p = (SVG.z0) r115;
        return;
    L248:
        r112.f272904p = ((SVG.v0) r115).h();
        return;
    L250:
        throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
    L252:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L253:
        SVG.h0 r116 = this.f272938b;
        if (r116 == null) goto L264;
        if ((r116 instanceof SVG.w0) == false) goto L262;
        SVG.t0 r117 = new SVG.t0();
        r117.f272872a = this.f272937a;
        r117.f272873b = this.f272938b;
        i(r117, r213);
        l(r117, r213);
        h(r117, r213);
        m(r117, r213);
        this.f272938b.f(r117);
        this.f272938b = r117;
        SVG.h0 r118 = r117.f272873b;
        if ((r118 instanceof SVG.z0) == false) goto L260;
        r117.f272907s = (SVG.z0) r118;
        return;
    L260:
        r117.f272907s = ((SVG.v0) r118).h();
        return;
    L262:
        throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
    L264:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L339:
        int r119 = 0;
        if (this.f272938b == null) goto L379;
        SVG.a0 r120 = new SVG.a0();
        r120.f272872a = this.f272937a;
        r120.f272873b = this.f272938b;
        i(r120, r213);
        l(r120, r213);
        n(r120, r213);
        h(r120, r213);
    L343:
        if (r119 >= r213.getLength()) goto L377;
        String r121 = r213.getValue(r119).trim();
        int r122 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r119)).ordinal()];
        if (r122 == 1) goto L375;
        if (r122 == 2) goto L374;
        if (r122 == 3) goto L369;
        if (r122 != 4) goto L350;
        SVG.o r123 = w(r121);
        r120.f272810r = r123;
        if (r123.f() == false) goto L376;
        throw new SVGParseException("Invalid <rect> element. height cannot be negative");
    L376:
        r119 = r119 + 1;
        goto L343
    L350:
        if (r122 != 10) goto L352;
        SVG.o r124 = w(r121);
        r120.f272811s = r124;
        if (r124.f() == false) goto L376;
        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
    L352:
        if (r122 != 11) goto L376;
        SVG.o r125 = w(r121);
        r120.f272812t = r125;
        if (r125.f() == false) goto L376;
        throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
    L369:
        SVG.o r126 = w(r121);
        r120.f272809q = r126;
        if (r126.f() == false) goto L376;
        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
    L374:
        r120.f272808p = w(r121);
        goto L376
    L375:
        r120.f272807o = w(r121);
        goto L376
    L377:
        this.f272938b.f(r120);
        return;
    L379:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L514:
        int r127 = 0;
        if (this.f272938b == null) goto L546;
        SVG.b1 r128 = new SVG.b1();
        r128.f272872a = this.f272937a;
        r128.f272873b = this.f272938b;
        i(r128, r213);
        l(r128, r213);
        n(r128, r213);
        h(r128, r213);
    L518:
        if (r127 >= r213.getLength()) goto L544;
        String r129 = r213.getValue(r127).trim();
        int r130 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r127)).ordinal()];
        if (r130 == 1) goto L542;
        if (r130 == 2) goto L541;
        if (r130 == 3) goto L536;
        if (r130 == 4) goto L531;
        if (r130 != 6) goto L543;
        if ("".equals(r213.getURI(r127)) == false) goto L529;
    L530:
        r128.f272818p = r129;
        goto L543
    L529:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r127)) == true) goto L530;
    L543:
        r127 = r127 + 1;
        goto L518
    L531:
        SVG.o r131 = w(r129);
        r128.f272822t = r131;
        if (r131.f() == false) goto L543;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L536:
        SVG.o r132 = w(r129);
        r128.f272821s = r132;
        if (r132.f() == false) goto L543;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L541:
        r128.f272820r = w(r129);
        goto L543
    L542:
        r128.f272819q = w(r129);
        goto L543
    L544:
        this.f272938b.f(r128);
        this.f272938b = r128;
        return;
    L546:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L557:
        int r133 = 0;
        SVG.d0 r134 = new SVG.d0();
        r134.f272872a = this.f272937a;
        r134.f272873b = this.f272938b;
        i(r134, r213);
        l(r134, r213);
        h(r134, r213);
        o(r134, r213);
    L559:
        if (r133 >= r213.getLength()) goto L579;
        String r135 = r213.getValue(r133).trim();
        int r136 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r133)).ordinal()];
        if (r136 == 1) goto L577;
        if (r136 == 2) goto L576;
        if (r136 == 3) goto L571;
        if (r136 != 4) goto L578;
        SVG.o r137 = w(r135);
        r134.f272834t = r137;
        if (r137.f() == false) goto L578;
        throw new SVGParseException("Invalid <svg> element. height cannot be negative");
    L578:
        r133 = r133 + 1;
        goto L559
    L571:
        SVG.o r138 = w(r135);
        r134.f272833s = r138;
        if (r138.f() == false) goto L578;
        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
    L576:
        r134.f272832r = w(r135);
        goto L578
    L577:
        r134.f272831q = w(r135);
        goto L578
    L579:
        SVG.h0 r139 = this.f272938b;
        if (r139 != null) goto L582;
        this.f272937a.f272756a = r134;
    L583:
        this.f272938b = r134;
        return;
    L582:
        r139.f(r134);
        goto L583
    L23:
        if (this.f272938b == null) goto L57;
        SVG.n r140 = new SVG.n();
        r140.f272872a = this.f272937a;
        r140.f272873b = this.f272938b;
        i(r140, r213);
        l(r140, r213);
        n(r140, r213);
        h(r140, r213);
        int r141 = 0;
    L26:
        if (r141 >= r213.getLength()) goto L55;
        String r142 = r213.getValue(r141).trim();
        int r143 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r141)).ordinal()];
        if (r143 == 1) goto L53;
        if (r143 == 2) goto L52;
        if (r143 == 3) goto L47;
        if (r143 == 4) goto L42;
        if (r143 == 6) goto L38;
        if (r143 != 7) goto L54;
        B(r140, r142);
    L54:
        r141 = r141 + 1;
        goto L26
    L38:
        if ("".equals(r213.getURI(r141)) == false) goto L40;
    L41:
        r140.f272874p = r142;
        goto L54
    L40:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r141)) == false) goto L54;
    L42:
        SVG.o r144 = w(r142);
        r140.f272878t = r144;
        if (r144.f() == false) goto L54;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L47:
        SVG.o r145 = w(r142);
        r140.f272877s = r145;
        if (r145.f() == false) goto L54;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L52:
        r140.f272876r = w(r142);
        goto L54
    L53:
        r140.f272875q = w(r142);
        goto L54
    L55:
        this.f272938b.f(r140);
        this.f272938b = r140;
        return;
    L57:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L60:
        if (this.f272938b == null) goto L81;
        SVG.x0 r146 = new SVG.x0();
        r146.f272872a = this.f272937a;
        r146.f272873b = this.f272938b;
        i(r146, r213);
        l(r146, r213);
        h(r146, r213);
        int r147 = 0;
    L63:
        if (r147 >= r213.getLength()) goto L76;
        String r148 = r213.getValue(r147).trim();
        int r149 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r147)).ordinal()];
        if (r149 == 6) goto L71;
        if (r149 != 39) goto L75;
        r146.f272923p = w(r148);
    L75:
        r147 = r147 + 1;
        goto L63
    L71:
        if ("".equals(r213.getURI(r147)) == false) goto L73;
    L74:
        r146.f272922o = r148;
        goto L75
    L73:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r147)) == false) goto L75;
    L76:
        this.f272938b.f(r146);
        this.f272938b = r146;
        SVG.h0 r150 = r146.f272873b;
        if ((r150 instanceof SVG.z0) == false) goto L79;
        r146.f272924q = (SVG.z0) r150;
        return;
    L79:
        r146.f272924q = ((SVG.v0) r150).h();
        return;
    L81:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L83:
        if (this.f272938b == null) goto L101;
        SVG.e r151 = new SVG.e();
        r151.f272872a = this.f272937a;
        r151.f272873b = this.f272938b;
        i(r151, r213);
        l(r151, r213);
        n(r151, r213);
        h(r151, r213);
        int r152 = 0;
    L86:
        if (r152 >= r213.getLength()) goto L99;
        String r153 = r213.getValue(r152).trim();
        if (a.f272969b[SVGAttr.fromString(r213.getLocalName(r152)).ordinal()] != 38) goto L96;
        if ("objectBoundingBox".equals(r153) == false) goto L94;
        r151.f272835p = Boolean.FALSE;
        goto L96
    L94:
        if ("userSpaceOnUse".equals(r153) == false) goto L98;
        r151.f272835p = Boolean.TRUE;
        goto L96
    L98:
        throw new SVGParseException("Invalid value for attribute clipPathUnits");
    L96:
        r152 = r152 + 1;
        goto L86
    L99:
        this.f272938b.f(r151);
        this.f272938b = r151;
        return;
    L101:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L143:
        if (this.f272938b == null) goto L165;
        SVG.o0 r154 = new SVG.o0();
        r154.f272872a = this.f272937a;
        r154.f272873b = this.f272938b;
        i(r154, r213);
        l(r154, r213);
        j(r154, r213);
        int r155 = 0;
    L146:
        if (r155 >= r213.getLength()) goto L163;
        String r156 = r213.getValue(r155).trim();
        int r157 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r155)).ordinal()];
        if (r157 != 35) goto L150;
        r154.f272886p = w(r156);
    L162:
        r155 = r155 + 1;
        goto L146
    L150:
        if (r157 == 36) goto L160;
        switch(r157) {
            case 12: goto L159;
            case 13: goto L158;
            case 14: goto L153;
            default: goto L162;
        };
    L153:
        SVG.o r158 = w(r156);
        r154.f272885o = r158;
        if (r158.f() == false) goto L162;
        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
    L158:
        r154.f272884n = w(r156);
        goto L162
    L159:
        r154.f272883m = w(r156);
        goto L162
    L160:
        r154.f272887q = w(r156);
        goto L162
    L163:
        this.f272938b.f(r154);
        this.f272938b = r154;
        return;
    L165:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L167:
        if (this.f272938b == null) goto L181;
        SVG.k0 r159 = new SVG.k0();
        r159.f272872a = this.f272937a;
        r159.f272873b = this.f272938b;
        i(r159, r213);
        l(r159, r213);
        j(r159, r213);
        int r160 = 0;
    L170:
        if (r160 >= r213.getLength()) goto L179;
        String r161 = r213.getValue(r160).trim();
        switch(a.f272969b[SVGAttr.fromString(r213.getLocalName(r160)).ordinal()]) {
            case 15: goto L177;
            case 16: goto L176;
            case 17: goto L175;
            case 18: goto L174;
            default: goto L178;
        };
    L174:
        r159.f272870p = w(r161);
        goto L178
    L175:
        r159.f272869o = w(r161);
        goto L178
    L176:
        r159.f272868n = w(r161);
        goto L178
    L177:
        r159.f272867m = w(r161);
    L178:
        r160 = r160 + 1;
        goto L170
    L179:
        this.f272938b.f(r159);
        this.f272938b = r159;
        return;
    L181:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L183:
        if (this.f272938b == null) goto L218;
        SVG.q r162 = new SVG.q();
        r162.f272872a = this.f272937a;
        r162.f272873b = this.f272938b;
        i(r162, r213);
        l(r162, r213);
        h(r162, r213);
        o(r162, r213);
        int r163 = 0;
    L186:
        if (r163 >= r213.getLength()) goto L216;
        String r164 = r213.getValue(r163).trim();
        switch(a.f272969b[SVGAttr.fromString(r213.getLocalName(r163)).ordinal()]) {
            case 26: goto L214;
            case 27: goto L213;
            case 28: goto L208;
            case 29: goto L203;
            case 30: goto L196;
            case 31: goto L192;
            default: goto L215;
        };
    L203:
        SVG.o r165 = w(r164);
        r162.f272897u = r165;
        if (r165.f() == false) goto L215;
        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
    L208:
        SVG.o r166 = w(r164);
        r162.f272896t = r166;
        if (r166.f() == false) goto L215;
        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
    L213:
        r162.f272895s = w(r164);
        goto L215
    L214:
        r162.f272894r = w(r164);
    L215:
        r163 = r163 + 1;
        goto L186
    L192:
        if ("auto".equals(r164) == false) goto L194;
        r162.f272898v = Float.valueOf(Float.NaN);
        goto L215
    L194:
        r162.f272898v = Float.valueOf(r(r164));
        goto L215
    L196:
        if ("strokeWidth".equals(r164) == false) goto L199;
        r162.f272893q = false;
        goto L215
    L199:
        if ("userSpaceOnUse".equals(r164) == false) goto L202;
        r162.f272893q = true;
        goto L215
    L202:
        throw new SVGParseException("Invalid value for attribute markerUnits");
    L216:
        this.f272938b.f(r162);
        this.f272938b = r162;
        return;
    L218:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L220:
        if (this.f272938b == null) goto L223;
        SVG.r0 r167 = new SVG.r0();
        r167.f272872a = this.f272937a;
        r167.f272873b = this.f272938b;
        i(r167, r213);
        l(r167, r213);
        h(r167, r213);
        o(r167, r213);
        this.f272938b.f(r167);
        this.f272938b = r167;
        return;
    L223:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L225:
        if (this.f272938b == null) goto L228;
        SVG.q0 r168 = new SVG.q0();
        r168.f272872a = this.f272937a;
        r168.f272873b = this.f272938b;
        i(r168, r213);
        l(r168, r213);
        n(r168, r213);
        h(r168, r213);
        this.f272938b.f(r168);
        this.f272938b = r168;
        return;
    L228:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L266:
        if (this.f272938b == null) goto L269;
        SVG.u0 r169 = new SVG.u0();
        r169.f272872a = this.f272937a;
        r169.f272873b = this.f272938b;
        i(r169, r213);
        l(r169, r213);
        n(r169, r213);
        h(r169, r213);
        m(r169, r213);
        this.f272938b.f(r169);
        this.f272938b = r169;
        return;
    L269:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L271:
        if (this.f272938b == null) goto L274;
        SVG.z r170 = new SVG.z();
        r170.f272872a = this.f272937a;
        r170.f272873b = this.f272938b;
        i(r170, r213);
        l(r170, r213);
        n(r170, r213);
        h(r170, r213);
        k(r170, r213, SVGRenderEngine.POLYGON);
        this.f272938b.f(r170);
        return;
    L274:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L276:
        if (this.f272938b == null) goto L279;
        SVG.y r171 = new SVG.y();
        r171.f272872a = this.f272937a;
        r171.f272873b = this.f272938b;
        i(r171, r213);
        l(r171, r213);
        n(r171, r213);
        h(r171, r213);
        k(r171, r213, SVGRenderEngine.POLYLINE);
        this.f272938b.f(r171);
        return;
    L279:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L281:
        if (this.f272938b == null) goto L295;
        SVG.p r172 = new SVG.p();
        r172.f272872a = this.f272937a;
        r172.f272873b = this.f272938b;
        i(r172, r213);
        l(r172, r213);
        n(r172, r213);
        h(r172, r213);
        int r173 = 0;
    L284:
        if (r173 >= r213.getLength()) goto L293;
        String r174 = r213.getValue(r173).trim();
        switch(a.f272969b[SVGAttr.fromString(r213.getLocalName(r173)).ordinal()]) {
            case 15: goto L291;
            case 16: goto L290;
            case 17: goto L289;
            case 18: goto L288;
            default: goto L292;
        };
    L288:
        r172.f272891r = w(r174);
        goto L292
    L289:
        r172.f272890q = w(r174);
        goto L292
    L290:
        r172.f272889p = w(r174);
        goto L292
    L291:
        r172.f272888o = w(r174);
    L292:
        r173 = r173 + 1;
        goto L284
    L293:
        this.f272938b.f(r172);
        return;
    L295:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L297:
        if (this.f272938b == null) goto L319;
        SVG.i r175 = new SVG.i();
        r175.f272872a = this.f272937a;
        r175.f272873b = this.f272938b;
        i(r175, r213);
        l(r175, r213);
        n(r175, r213);
        h(r175, r213);
        int r176 = 0;
    L300:
        if (r176 >= r213.getLength()) goto L317;
        String r177 = r213.getValue(r176).trim();
        switch(a.f272969b[SVGAttr.fromString(r213.getLocalName(r176)).ordinal()]) {
            case 10: goto L311;
            case 11: goto L306;
            case 12: goto L305;
            case 13: goto L304;
            default: goto L316;
        };
    L304:
        r175.f272852p = w(r177);
        goto L316
    L305:
        r175.f272851o = w(r177);
        goto L316
    L306:
        SVG.o r178 = w(r177);
        r175.f272854r = r178;
        if (r178.f() == false) goto L316;
        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
    L311:
        SVG.o r179 = w(r177);
        r175.f272853q = r179;
        if (r179.f() == false) goto L316;
        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
    L316:
        r176 = r176 + 1;
        goto L300
    L317:
        this.f272938b.f(r175);
        return;
    L319:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L321:
        if (this.f272938b == null) goto L338;
        SVG.d r180 = new SVG.d();
        r180.f272872a = this.f272937a;
        r180.f272873b = this.f272938b;
        i(r180, r213);
        l(r180, r213);
        n(r180, r213);
        h(r180, r213);
        int r181 = 0;
    L324:
        if (r181 >= r213.getLength()) goto L336;
        String r182 = r213.getValue(r181).trim();
        switch(a.f272969b[SVGAttr.fromString(r213.getLocalName(r181)).ordinal()]) {
            case 12: goto L334;
            case 13: goto L333;
            case 14: goto L328;
            default: goto L335;
        };
    L328:
        SVG.o r183 = w(r182);
        r180.f272830q = r183;
        if (r183.f() == false) goto L335;
        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
    L333:
        r180.f272829p = w(r182);
        goto L335
    L334:
        r180.f272828o = w(r182);
    L335:
        r181 = r181 + 1;
        goto L324
    L336:
        this.f272938b.f(r180);
        return;
    L338:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L381:
        if (this.f272938b == null) goto L513;
        SVG.u r184 = new SVG.u();
        r184.f272872a = this.f272937a;
        r184.f272873b = this.f272938b;
        i(r184, r213);
        l(r184, r213);
        n(r184, r213);
        h(r184, r213);
        int r185 = 0;
    L384:
        if (r185 >= r213.getLength()) goto L511;
        String r186 = r213.getValue(r185).trim();
        int r187 = a.f272969b[SVGAttr.fromString(r213.getLocalName(r185)).ordinal()];
        if (r187 != 8) goto L388;
        g r188 = new g(r186);
        SVG.v r189 = new SVG.v();
        if (r188.f() == true) goto L509;
        int r190 = r188.h().intValue();
        if (r190 == 77) goto L402;
        if (r190 != 109) goto L509;
    L402:
        float r191 = 0.0f;
        float r192 = 0.0f;
        float r193 = 0.0f;
        float r194 = 0.0f;
        float r195 = 0.0f;
        float r214 = 0.0f;
    L403:
        r188.q();
        switch(r190) {
            case 65: goto L472;
            case 67: goto L464;
            case 72: goto L457;
            case 76: goto L451;
            case 77: goto L436;
            case 81: goto L429;
            case 83: goto L422;
            case 84: goto L415;
            case 86: goto L407;
            case 90: goto L406;
            case 97: goto L472;
            case 99: goto L464;
            case 104: goto L457;
            case 108: goto L451;
            case 109: goto L436;
            case 113: goto L429;
            case 115: goto L422;
            case 116: goto L415;
            case 118: goto L407;
            case 122: goto L406;
            default: goto L509;
        };
    L406:
        r189.close();
        r191 = r195;
        r192 = r191;
        float r196 = r214;
    L488:
        r193 = r196;
        r194 = r193;
    L489:
        r188.p();
        if (r188.f() == true) goto L509;
        int r197 = r188.f272976b;
        if (r197 == r188.f272977c) goto L504;
        char r198 = r188.f272975a.charAt(r197);
        if (r198 < 'a') goto L500;
        if (r198 > 'z') goto L500;
    L503:
        boolean r199 = true;
    L505:
        if (r199 == false) goto L507;
        r190 = r188.h().intValue();
    L507:
        r102 = 0.0f;
    L500:
        if (r198 < 'A') goto L504;
        if (r198 <= 'Z') goto L503;
    L504:
        r199 = false;
        goto L505
    L407:
        r196 = r188.i();
        if (Float.isNaN(r196) == true) goto L509;
        if (r190 != 118) goto L413;
        r196 = r196 + r193;
    L413:
        r189.lineTo(r191, r196);
        goto L488
    L415:
        float r200 = (r191 * 2.0f) - r192;
        float r1100 = (2.0f * r193) - r194;
        float r1101 = r188.i();
        float r1102 = r188.c(r1101);
        if (Float.isNaN(r1102) == true) goto L509;
        if (r190 != 116) goto L421;
        r1101 = r1101 + r191;
        r1102 = r1102 + r193;
    L421:
        float r1103 = r1102;
        r189.b(r200, r1100, r1101, r1103);
        float r201 = r200;
        r193 = r1103;
    L471:
        r191 = r1101;
        r194 = r1100;
        r192 = r201;
        goto L489
    L422:
        float r1104 = (r191 * 2.0f) - r192;
        float r202 = (2.0f * r193) - r194;
        float r1105 = r188.i();
        float r1106 = r188.c(r1105);
        float r203 = r188.c(r1106);
        float r1107 = r188.c(r203);
        if (Float.isNaN(r1107) == true) goto L509;
        if (r190 != 115) goto L428;
        r203 = r203 + r191;
        r1107 = r1107 + r193;
        r1105 = r1105 + r191;
        r1106 = r1106 + r193;
    L428:
        float r1108 = r203;
        r201 = r1105;
        float r1109 = r1106;
        float r215 = r1107;
        r189.cubicTo(r1104, r202, r201, r1109, r1108, r215);
        r1101 = r1108;
        r1100 = r1109;
        r193 = r215;
        goto L471
    L429:
        r201 = r188.i();
        float r1110 = r188.c(r201);
        float r1111 = r188.c(r1110);
        float r1112 = r188.c(r1111);
        if (Float.isNaN(r1112) == true) goto L509;
        if (r190 != 113) goto L435;
        r1111 = r1111 + r191;
        r1112 = r1112 + r193;
        r201 = r201 + r191;
        r1110 = r1110 + r193;
    L435:
        r189.b(r201, r1110, r1111, r1112);
        r193 = r1112;
        r1101 = r1111;
        r1100 = r1110;
        goto L471
    L436:
        float r1113 = r188.i();
        float r1114 = r188.c(r1113);
        if (Float.isNaN(r1114) == true) goto L509;
        if (r190 == 109) goto L441;
    L446:
        r193 = r1114;
        r189.moveTo(r1113, r193);
        if (r190 != 109) goto L449;
        r190 = 108;
    L450:
        r201 = r1113;
        r1101 = r201;
        r195 = r1101;
        r1100 = r193;
        r214 = r1100;
        goto L471
    L449:
        r190 = 76;
        goto L450
    L441:
        if (r189.f272911b != 0) goto L443;
        boolean r1115 = true;
    L444:
        if (r1115 == true) goto L446;
        r1113 = r1113 + r191;
        r1114 = r1114 + r193;
        goto L446
    L443:
        r1115 = false;
        goto L444
    L451:
        float r1116 = r188.i();
        float r1117 = r188.c(r1116);
        if (Float.isNaN(r1117) == true) goto L509;
        if (r190 != 108) goto L456;
        r1116 = r1116 + r191;
        r1117 = r1117 + r193;
    L456:
        r191 = r1116;
        r196 = r1117;
        r189.lineTo(r191, r196);
    L487:
        r192 = r191;
        goto L488
    L457:
        float r204 = r188.i();
        if (Float.isNaN(r204) == true) goto L509;
        if (r190 != 104) goto L463;
        r204 = r204 + r191;
    L463:
        r189.lineTo(r204, r193);
        r201 = r204;
        r1100 = r194;
        r1101 = r201;
        goto L471
    L464:
        float r205 = r188.i();
        float r1118 = r188.c(r205);
        float r1119 = r188.c(r1118);
        float r1120 = r188.c(r1119);
        float r1121 = r188.c(r1120);
        float r1122 = r188.c(r1121);
        if (Float.isNaN(r1122) == true) goto L509;
        if (r190 != 99) goto L470;
        r1121 = r1121 + r191;
        r1122 = r1122 + r193;
        r205 = r205 + r191;
        r1118 = r1118 + r193;
        r1119 = r1119 + r191;
        r1120 = r1120 + r193;
    L470:
        float r1123 = r1118;
        r201 = r1119;
        float r1124 = r1120;
        float r1125 = r1121;
        float r1126 = r205;
        float r206 = r1122;
        r189.cubicTo(r1126, r1123, r201, r1124, r1125, r206);
        r193 = r206;
        r1100 = r1124;
        r1101 = r1125;
        goto L471
    L472:
        float r1127 = r188.i();
        float r207 = r188.c(r1127);
        float r1128 = r188.c(r207);
        Boolean r208 = r188.b(Float.valueOf(r1128));
        Boolean r1129 = r188.b(r208);
        if (r1129 != null) goto L475;
        float r1130 = Float.NaN;
    L476:
        float r1131 = r188.c(r1130);
        if (Float.isNaN(r1131) == true) goto L509;
        if (r1127 < r102) goto L509;
        if (r207 < r102) goto L509;
        if (r190 != 97) goto L486;
        r1130 = r1130 + r191;
        r1131 = r1131 + r193;
    L486:
        float r216 = r1130;
        float r209 = r1131;
        r189.a(r1127, r207, r1128, r208.booleanValue(), r1129.booleanValue(), r216, r209);
        r196 = r209;
        r191 = r216;
        goto L487
    L475:
        r188.p();
        r1130 = r188.i();
    L509:
        r184.f272908o = r189;
    L510:
        r185 = r185 + 1;
        r102 = 0.0f;
        goto L384
    L388:
        if (r187 != 9) goto L510;
        if (Float.valueOf(r(r186)).floatValue() >= r102) goto L510;
        throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
    L511:
        this.f272938b.f(r184);
        return;
    L513:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L548:
        if (this.f272938b == null) goto L551;
        SVG.h r217 = new SVG.h();
        r217.f272872a = this.f272937a;
        r217.f272873b = this.f272938b;
        i(r217, r213);
        l(r217, r213);
        n(r217, r213);
        this.f272938b.f(r217);
        this.f272938b = r217;
        return;
    L551:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L553:
        if (this.f272938b == null) goto L556;
        SVG.l r218 = new SVG.l();
        r218.f272872a = this.f272937a;
        r218.f272873b = this.f272938b;
        i(r218, r213);
        l(r218, r213);
        n(r218, r213);
        h(r218, r213);
        this.f272938b.f(r218);
        this.f272938b = r218;
        return;
    L556:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L14:
        r100 = r212;
        goto L15
    }
}
