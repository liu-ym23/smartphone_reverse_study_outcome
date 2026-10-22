package com.lynx.component.svg.parser;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Xml;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.facebook.keyframes.model.KFFeature;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.dora.impl.ota.g2.j0;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes32.dex */
public final class SVGParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SVG f381162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SVG.c0 f381163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f381164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f381165d;

    public static final enum SVGAttr extends Enum<SVGAttr> {
        public static final SVGAttr UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, SVGAttr> f381166a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ SVGAttr[] f381167b = null;
        public static final SVGAttr clip = null;
        public static final SVGAttr clipPathUnits = null;
        public static final SVGAttr clip_path = null;
        public static final SVGAttr clip_rule = null;
        public static final SVGAttr color = null;

        /* JADX INFO: renamed from: cx, reason: collision with root package name */
        public static final SVGAttr f381168cx = null;

        /* JADX INFO: renamed from: cy, reason: collision with root package name */
        public static final SVGAttr f381169cy = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SVGAttr f381170d = null;
        public static final SVGAttr direction = null;
        public static final SVGAttr display = null;

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        public static final SVGAttr f381171dx = null;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        public static final SVGAttr f381172dy = null;
        public static final SVGAttr fill = null;
        public static final SVGAttr fill_opacity = null;
        public static final SVGAttr fill_rule = null;

        /* JADX INFO: renamed from: fx, reason: collision with root package name */
        public static final SVGAttr f381173fx = null;

        /* JADX INFO: renamed from: fy, reason: collision with root package name */
        public static final SVGAttr f381174fy = null;
        public static final SVGAttr gradientTransform = null;
        public static final SVGAttr gradientUnits = null;
        public static final SVGAttr height = null;
        public static final SVGAttr href = null;
        public static final SVGAttr image_rendering = null;
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
        public static final SVGAttr f381175r = null;
        public static final SVGAttr refX = null;
        public static final SVGAttr refY = null;

        /* JADX INFO: renamed from: rx, reason: collision with root package name */
        public static final SVGAttr f381176rx = null;

        /* JADX INFO: renamed from: ry, reason: collision with root package name */
        public static final SVGAttr f381177ry = null;
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
        public static final SVGAttr f381178x = null;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public static final SVGAttr f381179x1 = null;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        public static final SVGAttr f381180x2 = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final SVGAttr f381181y = null;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public static final SVGAttr f381182y1 = null;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        public static final SVGAttr f381183y2 = null;

        static {
            SVGAttr r100 = new SVGAttr("clip", 0);
            clip = r100;
            SVGAttr r101 = new SVGAttr("clip_path", 1);
            clip_path = r101;
            SVGAttr r102 = new SVGAttr("clipPathUnits", 2);
            clipPathUnits = r102;
            SVGAttr r103 = new SVGAttr("clip_rule", 3);
            clip_rule = r103;
            SVGAttr r104 = new SVGAttr("color", 4);
            color = r104;
            SVGAttr r105 = new SVGAttr("cx", 5);
            f381168cx = r105;
            SVGAttr r110 = new SVGAttr("cy", 6);
            f381169cy = r110;
            SVGAttr r111 = new SVGAttr("direction", 7);
            direction = r111;
            SVGAttr r112 = new SVGAttr("dx", 8);
            f381171dx = r112;
            SVGAttr r113 = new SVGAttr("dy", 9);
            f381172dy = r113;
            SVGAttr r114 = new SVGAttr("fx", 10);
            f381173fx = r114;
            SVGAttr r115 = new SVGAttr("fy", 11);
            f381174fy = r115;
            SVGAttr r106 = new SVGAttr("d", 12);
            f381170d = r106;
            SVGAttr r107 = new SVGAttr("display", 13);
            display = r107;
            SVGAttr r108 = new SVGAttr(LynxVideoManagerLite.FILL, 14);
            fill = r108;
            SVGAttr r109 = new SVGAttr("fill_rule", 15);
            fill_rule = r109;
            SVGAttr r116 = new SVGAttr("fill_opacity", 16);
            fill_opacity = r116;
            SVGAttr r117 = new SVGAttr("gradientTransform", 17);
            gradientTransform = r117;
            SVGAttr r118 = new SVGAttr("gradientUnits", 18);
            gradientUnits = r118;
            SVGAttr r119 = new SVGAttr("height", 19);
            height = r119;
            SVGAttr r120 = new SVGAttr("href", 20);
            href = r120;
            SVGAttr r121 = new SVGAttr("image_rendering", 21);
            image_rendering = r121;
            SVGAttr r122 = new SVGAttr("offset", 22);
            offset = r122;
            SVGAttr r123 = new SVGAttr(GXTemplateKey.STYLE_OPACITY, 23);
            opacity = r123;
            SVGAttr r124 = new SVGAttr("orient", 24);
            orient = r124;
            SVGAttr r125 = new SVGAttr("overflow", 25);
            overflow = r125;
            SVGAttr r126 = new SVGAttr("pathLength", 26);
            pathLength = r126;
            SVGAttr r127 = new SVGAttr("patternContentUnits", 27);
            patternContentUnits = r127;
            SVGAttr r128 = new SVGAttr("patternTransform", 28);
            patternTransform = r128;
            SVGAttr r129 = new SVGAttr("patternUnits", 29);
            patternUnits = r129;
            SVGAttr r130 = new SVGAttr("points", 30);
            points = r130;
            SVGAttr r131 = new SVGAttr("preserveAspectRatio", 31);
            preserveAspectRatio = r131;
            SVGAttr r132 = new SVGAttr("r", 32);
            f381175r = r132;
            SVGAttr r133 = new SVGAttr("refX", 33);
            refX = r133;
            SVGAttr r134 = new SVGAttr("refY", 34);
            refY = r134;
            SVGAttr r135 = new SVGAttr("rx", 35);
            f381176rx = r135;
            SVGAttr r136 = new SVGAttr("ry", 36);
            f381177ry = r136;
            SVGAttr r137 = new SVGAttr("solid_color", 37);
            solid_color = r137;
            SVGAttr r138 = new SVGAttr("solid_opacity", 38);
            solid_opacity = r138;
            SVGAttr r139 = new SVGAttr("spreadMethod", 39);
            spreadMethod = r139;
            SVGAttr r140 = new SVGAttr("startOffset", 40);
            startOffset = r140;
            SVGAttr r141 = new SVGAttr("stop_color", 41);
            stop_color = r141;
            SVGAttr r142 = new SVGAttr("stop_opacity", 42);
            stop_opacity = r142;
            SVGAttr r143 = new SVGAttr("stroke", 43);
            stroke = r143;
            SVGAttr r144 = new SVGAttr("stroke_dasharray", 44);
            stroke_dasharray = r144;
            SVGAttr r145 = new SVGAttr("stroke_dashoffset", 45);
            stroke_dashoffset = r145;
            SVGAttr r146 = new SVGAttr("stroke_linecap", 46);
            stroke_linecap = r146;
            SVGAttr r147 = new SVGAttr("stroke_linejoin", 47);
            stroke_linejoin = r147;
            SVGAttr r148 = new SVGAttr("stroke_miterlimit", 48);
            stroke_miterlimit = r148;
            SVGAttr r149 = new SVGAttr("stroke_opacity", 49);
            stroke_opacity = r149;
            SVGAttr r150 = new SVGAttr(KFFeature.STROKE_WIDTH_JSON_FIELD, 50);
            stroke_width = r150;
            SVGAttr r151 = new SVGAttr("style", 51);
            style = r151;
            SVGAttr r152 = new SVGAttr("transform", 52);
            transform = r152;
            SVGAttr r153 = new SVGAttr("type", 53);
            type = r153;
            SVGAttr r154 = new SVGAttr("vector_effect", 54);
            vector_effect = r154;
            SVGAttr r155 = new SVGAttr("version", 55);
            version = r155;
            SVGAttr r156 = new SVGAttr("viewBox", 56);
            viewBox = r156;
            SVGAttr r157 = new SVGAttr("width", 57);
            width = r157;
            SVGAttr r158 = new SVGAttr("x", 58);
            f381178x = r158;
            SVGAttr r159 = new SVGAttr("y", 59);
            f381181y = r159;
            SVGAttr r160 = new SVGAttr("x1", 60);
            f381179x1 = r160;
            SVGAttr r161 = new SVGAttr("y1", 61);
            f381182y1 = r161;
            SVGAttr r162 = new SVGAttr("x2", 62);
            f381180x2 = r162;
            SVGAttr r163 = new SVGAttr("y2", 63);
            f381183y2 = r163;
            SVGAttr r164 = new SVGAttr("viewport_fill", 64);
            viewport_fill = r164;
            SVGAttr r165 = new SVGAttr("viewport_fill_opacity", 65);
            viewport_fill_opacity = r165;
            SVGAttr r166 = new SVGAttr(RemoteMessageConst.Notification.VISIBILITY, 66);
            visibility = r166;
            SVGAttr r167 = new SVGAttr("UNSUPPORTED", 67);
            UNSUPPORTED = r167;
            f381167b = new SVGAttr[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167};
            f381166a = new HashMap();
            SVGAttr[] r168 = values();
            int r169 = r168.length;
            int r170 = 0;
        L3:
            if (r170 >= r169) goto L9;
            SVGAttr r171 = r168[r170];
            if (r171 == UNSUPPORTED) goto L8;
            f381166a.put(r171.name().replace('_', '-'), r171);
        L8:
            r170 = r170 + 1;
            goto L3
        }

        public static SVGAttr[] values() {
            return (SVGAttr[]) f381167b.clone();
        }

        public static SVGAttr fromString(String r100) {
            SVGAttr r101 = (SVGAttr) ((HashMap) f381166a).get(r100);
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
        public static final SVGElem UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, SVGElem> f381184a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ SVGElem[] f381185b = null;
        public static final SVGElem circle = null;
        public static final SVGElem clipPath = null;
        public static final SVGElem defs = null;
        public static final SVGElem ellipse = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final SVGElem f381186g = null;
        public static final SVGElem image = null;
        public static final SVGElem line = null;
        public static final SVGElem linearGradient = null;
        public static final SVGElem path = null;
        public static final SVGElem pattern = null;
        public static final SVGElem polygon = null;
        public static final SVGElem polyline = null;
        public static final SVGElem radialGradient = null;
        public static final SVGElem rect = null;
        public static final SVGElem solidColor = null;
        public static final SVGElem stop = null;
        public static final SVGElem svg = null;
        public static final SVGElem use = null;

        static {
            SVGElem r100 = new SVGElem("svg", 0);
            svg = r100;
            SVGElem r101 = new SVGElem(SVGRenderEngine.CIRCLE, 1);
            circle = r101;
            SVGElem r102 = new SVGElem(SVGRenderEngine.CLIP_PATH, 2);
            clipPath = r102;
            SVGElem r103 = new SVGElem("defs", 3);
            defs = r103;
            SVGElem r104 = new SVGElem(SVGRenderEngine.ELLIPSE, 4);
            ellipse = r104;
            SVGElem r105 = new SVGElem(ce.f26391f, 5);
            f381186g = r105;
            SVGElem r110 = new SVGElem("image", 6);
            image = r110;
            SVGElem r111 = new SVGElem("line", 7);
            line = r111;
            SVGElem r112 = new SVGElem(SVGRenderEngine.LINEAR_GRADIENT, 8);
            linearGradient = r112;
            SVGElem r113 = new SVGElem("path", 9);
            path = r113;
            SVGElem r114 = new SVGElem("pattern", 10);
            pattern = r114;
            SVGElem r115 = new SVGElem(SVGRenderEngine.POLYGON, 11);
            polygon = r115;
            SVGElem r106 = new SVGElem(SVGRenderEngine.POLYLINE, 12);
            polyline = r106;
            SVGElem r107 = new SVGElem(SVGRenderEngine.RADIAL_GRADIENT, 13);
            radialGradient = r107;
            SVGElem r108 = new SVGElem(SVGRenderEngine.RECT, 14);
            rect = r108;
            SVGElem r109 = new SVGElem("solidColor", 15);
            solidColor = r109;
            SVGElem r116 = new SVGElem("stop", 16);
            stop = r116;
            SVGElem r117 = new SVGElem(NameKeys.LoadStrategy_Use, 17);
            use = r117;
            SVGElem r118 = new SVGElem("UNSUPPORTED", 18);
            UNSUPPORTED = r118;
            f381185b = new SVGElem[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
            f381184a = new HashMap();
            SVGElem[] r119 = values();
            int r120 = r119.length;
            int r121 = 0;
        L3:
            if (r121 >= r120) goto L8;
            SVGElem r122 = r119[r121];
            if (r122 == UNSUPPORTED) goto L7;
            f381184a.put(r122.name(), r122);
        L7:
            r121 = r121 + 1;
            goto L3
        }

        public static SVGElem[] values() {
            return (SVGElem[]) f381185b.clone();
        }

        public static SVGElem fromString(String r100) {
            SVGElem r101 = (SVGElem) ((HashMap) f381184a).get(r100);
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
        public static final /* synthetic */ int[] f381187a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f381188b = null;

        static {
            int[] r100 = new int[SVGAttr.values().length];
            f381188b = r100;
            r100[SVGAttr.f381178x.ordinal()] = 1;     // Catch: NoSuchFieldError -> L97
        L196:
            f381188b[SVGAttr.f381181y.ordinal()] = 2;     // Catch: NoSuchFieldError -> L98
        L216:
            f381188b[SVGAttr.width.ordinal()] = 3;     // Catch: NoSuchFieldError -> L99
        L228:
            f381188b[SVGAttr.height.ordinal()] = 4;     // Catch: NoSuchFieldError -> L100
        L234:
            f381188b[SVGAttr.version.ordinal()] = 5;     // Catch: NoSuchFieldError -> L101
        L256:
            f381188b[SVGAttr.href.ordinal()] = 6;     // Catch: NoSuchFieldError -> L102
        L260:
            f381188b[SVGAttr.preserveAspectRatio.ordinal()] = 7;     // Catch: NoSuchFieldError -> L103
        L286:
            f381188b[SVGAttr.f381170d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L104
        L290:
            f381188b[SVGAttr.pathLength.ordinal()] = 9;     // Catch: NoSuchFieldError -> L105
        L310:
            f381188b[SVGAttr.f381176rx.ordinal()] = 10;     // Catch: NoSuchFieldError -> L106
        L316:
            f381188b[SVGAttr.f381177ry.ordinal()] = 11;     // Catch: NoSuchFieldError -> L107
        L188:
            f381188b[SVGAttr.f381168cx.ordinal()] = 12;     // Catch: NoSuchFieldError -> L108
        L194:
            f381188b[SVGAttr.f381169cy.ordinal()] = 13;     // Catch: NoSuchFieldError -> L109
        L214:
            f381188b[SVGAttr.f381175r.ordinal()] = 14;     // Catch: NoSuchFieldError -> L110
        L222:
            f381188b[SVGAttr.f381179x1.ordinal()] = 15;     // Catch: NoSuchFieldError -> L111
        L246:
            f381188b[SVGAttr.f381182y1.ordinal()] = 16;     // Catch: NoSuchFieldError -> L112
        L250:
            f381188b[SVGAttr.f381180x2.ordinal()] = 17;     // Catch: NoSuchFieldError -> L113
        L274:
            f381188b[SVGAttr.f381183y2.ordinal()] = 18;     // Catch: NoSuchFieldError -> L114
        L280:
            f381188b[SVGAttr.gradientUnits.ordinal()] = 19;     // Catch: NoSuchFieldError -> L115
        L302:
            f381188b[SVGAttr.gradientTransform.ordinal()] = 20;     // Catch: NoSuchFieldError -> L116
        L306:
            f381188b[SVGAttr.spreadMethod.ordinal()] = 21;     // Catch: NoSuchFieldError -> L117
        L178:
            f381188b[SVGAttr.f381173fx.ordinal()] = 22;     // Catch: NoSuchFieldError -> L118
        L182:
            f381188b[SVGAttr.f381174fy.ordinal()] = 23;     // Catch: NoSuchFieldError -> L119
        L204:
            f381188b[SVGAttr.offset.ordinal()] = 24;     // Catch: NoSuchFieldError -> L120
        L210:
            f381188b[SVGAttr.clipPathUnits.ordinal()] = 25;     // Catch: NoSuchFieldError -> L121
        L238:
            f381188b[SVGAttr.patternUnits.ordinal()] = 26;     // Catch: NoSuchFieldError -> L122
        L240:
            f381188b[SVGAttr.patternContentUnits.ordinal()] = 27;     // Catch: NoSuchFieldError -> L123
        L264:
            f381188b[SVGAttr.patternTransform.ordinal()] = 28;     // Catch: NoSuchFieldError -> L124
        L268:
            f381188b[SVGAttr.style.ordinal()] = 29;     // Catch: NoSuchFieldError -> L125
        L294:
            f381188b[SVGAttr.fill.ordinal()] = 30;     // Catch: NoSuchFieldError -> L126
        L298:
            f381188b[SVGAttr.fill_rule.ordinal()] = 31;     // Catch: NoSuchFieldError -> L127
        L318:
            f381188b[SVGAttr.fill_opacity.ordinal()] = 32;     // Catch: NoSuchFieldError -> L128
        L172:
            f381188b[SVGAttr.stroke.ordinal()] = 33;     // Catch: NoSuchFieldError -> L129
        L198:
            f381188b[SVGAttr.stroke_opacity.ordinal()] = 34;     // Catch: NoSuchFieldError -> L130
        L200:
            f381188b[SVGAttr.stroke_width.ordinal()] = 35;     // Catch: NoSuchFieldError -> L131
        L226:
            f381188b[SVGAttr.stroke_linecap.ordinal()] = 36;     // Catch: NoSuchFieldError -> L132
        L230:
            f381188b[SVGAttr.stroke_linejoin.ordinal()] = 37;     // Catch: NoSuchFieldError -> L133
        L252:
            f381188b[SVGAttr.stroke_miterlimit.ordinal()] = 38;     // Catch: NoSuchFieldError -> L134
        L258:
            f381188b[SVGAttr.stroke_dasharray.ordinal()] = 39;     // Catch: NoSuchFieldError -> L135
        L284:
            f381188b[SVGAttr.stroke_dashoffset.ordinal()] = 40;     // Catch: NoSuchFieldError -> L136
        L288:
            f381188b[SVGAttr.opacity.ordinal()] = 41;     // Catch: NoSuchFieldError -> L137
        L308:
            f381188b[SVGAttr.color.ordinal()] = 42;     // Catch: NoSuchFieldError -> L138
        L314:
            f381188b[SVGAttr.overflow.ordinal()] = 43;     // Catch: NoSuchFieldError -> L139
        L186:
            f381188b[SVGAttr.display.ordinal()] = 44;     // Catch: NoSuchFieldError -> L140
        L192:
            f381188b[SVGAttr.visibility.ordinal()] = 45;     // Catch: NoSuchFieldError -> L141
        L212:
            f381188b[SVGAttr.stop_color.ordinal()] = 46;     // Catch: NoSuchFieldError -> L142
        L220:
            f381188b[SVGAttr.stop_opacity.ordinal()] = 47;     // Catch: NoSuchFieldError -> L143
        L244:
            f381188b[SVGAttr.clip.ordinal()] = 48;     // Catch: NoSuchFieldError -> L144
        L248:
            f381188b[SVGAttr.clip_path.ordinal()] = 49;     // Catch: NoSuchFieldError -> L145
        L272:
            f381188b[SVGAttr.clip_rule.ordinal()] = 50;     // Catch: NoSuchFieldError -> L146
        L278:
            f381188b[SVGAttr.solid_color.ordinal()] = 51;     // Catch: NoSuchFieldError -> L147
        L300:
            f381188b[SVGAttr.solid_opacity.ordinal()] = 52;     // Catch: NoSuchFieldError -> L148
        L304:
            f381188b[SVGAttr.viewport_fill.ordinal()] = 53;     // Catch: NoSuchFieldError -> L149
        L176:
            f381188b[SVGAttr.viewport_fill_opacity.ordinal()] = 54;     // Catch: NoSuchFieldError -> L150
        L180:
            f381188b[SVGAttr.vector_effect.ordinal()] = 55;     // Catch: NoSuchFieldError -> L151
        L202:
            f381188b[SVGAttr.image_rendering.ordinal()] = 56;     // Catch: NoSuchFieldError -> L152
        L208:
            f381188b[SVGAttr.viewBox.ordinal()] = 57;     // Catch: NoSuchFieldError -> L153
        L77:
            int[] r110 = new int[SVGElem.values().length];
            f381187a = r110;
            r110[SVGElem.svg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L154
        L242:
            f381187a[SVGElem.f381186g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L155
        L266:
            f381187a[SVGElem.defs.ordinal()] = 3;     // Catch: NoSuchFieldError -> L156
        L276:
            f381187a[SVGElem.use.ordinal()] = 4;     // Catch: NoSuchFieldError -> L157
        L282:
            f381187a[SVGElem.path.ordinal()] = 5;     // Catch: NoSuchFieldError -> L158
        L292:
            f381187a[SVGElem.rect.ordinal()] = 6;     // Catch: NoSuchFieldError -> L159
        L312:
            f381187a[SVGElem.circle.ordinal()] = 7;     // Catch: NoSuchFieldError -> L160
        L320:
            f381187a[SVGElem.ellipse.ordinal()] = 8;     // Catch: NoSuchFieldError -> L161
        L174:
            f381187a[SVGElem.line.ordinal()] = 9;     // Catch: NoSuchFieldError -> L162
        L184:
            f381187a[SVGElem.polyline.ordinal()] = 10;     // Catch: NoSuchFieldError -> L163
        L206:
            f381187a[SVGElem.polygon.ordinal()] = 11;     // Catch: NoSuchFieldError -> L164
        L218:
            f381187a[SVGElem.linearGradient.ordinal()] = 12;     // Catch: NoSuchFieldError -> L165
        L224:
            f381187a[SVGElem.radialGradient.ordinal()] = 13;     // Catch: NoSuchFieldError -> L166
        L236:
            f381187a[SVGElem.stop.ordinal()] = 14;     // Catch: NoSuchFieldError -> L167
        L254:
            f381187a[SVGElem.clipPath.ordinal()] = 15;     // Catch: NoSuchFieldError -> L168
        L262:
            f381187a[SVGElem.pattern.ordinal()] = 16;     // Catch: NoSuchFieldError -> L169
        L270:
            f381187a[SVGElem.image.ordinal()] = 17;     // Catch: NoSuchFieldError -> L170
        L296:
            f381187a[SVGElem.solidColor.ordinal()] = 18;     // Catch: NoSuchFieldError -> L171
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, PreserveAspectRatio.Alignment> f381189a = null;

        static {
            HashMap r100 = new HashMap(10);
            f381189a = r100;
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
        public final String f381190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f381191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f381192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.lynx.component.svg.parser.b f381193d;

        public static boolean f(int r100) {
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
            int r100 = this.f381191b;
            int r101 = this.f381192c;
            if (r100 != r101) goto L5;
            return -1;
        L5:
            int r102 = r100 + 1;
            this.f381191b = r102;
            if (r102 < r101) goto L8;
            return -1;
        L8:
            return this.f381190a.charAt(r102);
        }

        public final boolean e() {
            if (this.f381191b != this.f381192c) goto L5;
            return true;
        L5:
            return false;
        }

        public final float g() {
            float r100 = this.f381193d.a(this.f381190a, this.f381191b, this.f381192c);
            if (Float.isNaN(r100) == true) goto L5;
            this.f381191b = this.f381193d.f381197a;
        L5:
            return r100;
        }

        public final void l() {
        L2:
            int r100 = this.f381191b;
            if (r100 >= this.f381192c) goto L8;
            if (f(this.f381190a.charAt(r100)) == false) goto L11;
            this.f381191b++;
            goto L2
        L11:
            return;
        }

        public final SVG.o h() {
            float r100 = g();
            SVG.Unit r101 = null;
            if (Float.isNaN(r100) == false) goto L6;
            return null;
        L6:
            if (e() == false) goto L9;
        L24:
            if (r101 != null) goto L28;
            return new SVG.o(r100, SVG.Unit.f381070px);
        L28:
            return new SVG.o(r100, r101);
        L9:
            if (this.f381190a.charAt(this.f381191b) != '%') goto L11;
            this.f381191b++;
            r101 = SVG.Unit.percent;
            goto L24
        L11:
            int r102 = this.f381191b;
            int r103 = this.f381192c;
            if (r102 > (r103 - 2)) goto L24;
            if (r102 <= (r103 - 3)) goto L31;
        L22:
            String r104 = this.f381190a;     // Catch: IllegalArgumentException -> L29
            int r105 = this.f381191b;     // Catch: IllegalArgumentException -> L29
            SVG.Unit r106 = SVG.Unit.valueOf(r104.substring(r105, r105 + 2).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L29
            this.f381191b += 2;     // Catch: IllegalArgumentException -> L29
            r101 = r106;
        L30:
            goto L24
        L31:
            String r107 = this.f381190a.substring(r102, r102 + 3);     // Catch: IllegalArgumentException -> L29
            if ("rem".equals(r107) == false) goto L20;
            this.f381191b += 3;     // Catch: IllegalArgumentException -> L29
            r101 = SVG.Unit.rem;     // Catch: IllegalArgumentException -> L29
            goto L30
        L20:
            if ("rpx".equals(r107) == false) goto L22;
            this.f381191b += 3;     // Catch: IllegalArgumentException -> L29
            r101 = SVG.Unit.rpx;     // Catch: IllegalArgumentException -> L29
            goto L30
        }

        public final String i() {
            if (e() == true) goto L20;
            char r100 = this.f381190a.charAt(this.f381191b);
            if (f(r100) == true) goto L20;
            if (r100 == ' ') goto L20;
            int r101 = this.f381191b;
            int r102 = a();
        L12:
            if (r102 == (-1)) goto L25;
            if (r102 == 32) goto L25;
            if (f(r102) == true) goto L25;
            r102 = a();
        L25:
            return this.f381190a.substring(r101, this.f381191b);
        L20:
            return null;
        }

        public final float j() {
            k();
            float r100 = this.f381193d.a(this.f381190a, this.f381191b, this.f381192c);
            if (Float.isNaN(r100) == true) goto L5;
            this.f381191b = this.f381193d.f381197a;
        L5:
            return r100;
        }

        public final void k() {
            l();
            int r100 = this.f381191b;
            if (r100 != this.f381192c) goto L6;
            return;
        L6:
            if (this.f381190a.charAt(r100) == ',') goto L8;
            return;
        L8:
            this.f381191b++;
            l();
        }

        public c(String r100) {
            this.f381191b = 0;
            this.f381192c = 0;
            this.f381193d = new com.lynx.component.svg.parser.b();
            String r101 = r100.trim();
            this.f381190a = r101;
            this.f381192c = r101.length();
        }

        public final Boolean b(Object r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            k();
            int r101 = this.f381191b;
            if (r101 == this.f381192c) goto L18;
            char r102 = this.f381190a.charAt(r101);
            if (r102 == '0') goto L11;
            if (r102 == '1') goto L11;
            return null;
        L11:
            boolean r103 = true;
            this.f381191b++;
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
            k();
            return g();
        }

        public final boolean d(char r100) {
            int r101 = this.f381191b;
            if (r101 < this.f381192c) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            this.f381191b++;
        L10:
            return r102;
        L5:
            if (this.f381190a.charAt(r101) != r100) goto L7;
            r102 = true;
            goto L8
        }
    }

    public class d implements Attributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final XmlPullParser f381194a;

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
            return this.f381194a.getAttributeCount();
        }

        public d(XmlPullParser r100) {
            this.f381194a = r100;
        }

        @Override // org.xml.sax.Attributes
        public final String getLocalName(int r100) {
            return this.f381194a.getAttributeName(r100);
        }

        @Override // org.xml.sax.Attributes
        public final String getQName(int r100) {
            String r101 = this.f381194a.getAttributeName(r100);
            if (this.f381194a.getAttributePrefix(r100) != null) goto L5;
            return r101;
        L5:
            return this.f381194a.getAttributePrefix(r100) + ':' + r101;
        }

        @Override // org.xml.sax.Attributes
        public final String getURI(int r100) {
            return this.f381194a.getAttributeNamespace(r100);
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(int r100) {
            return this.f381194a.getAttributeValue(r100);
        }
    }

    public SVGParser() {
        this.f381162a = null;
        this.f381163b = null;
        this.f381164c = false;
    }

    public static SVG.f i(String r100) throws SVGParseException {
        return new SVG.f(ColorUtils.b(r100));
    L4:
        e = move-exception;
        throw new SVGParseException(e.toString());
    }

    public static SVG.h0 j(String r100) {
        r100.getClass();
        if (r100.equals("none") == true) goto L13;
        if (r100.equals("currentColor") == true) goto L11;
        return i(r100);
    L8:
        return null;
    L11:
        return SVG.g.f381101a;
    L13:
        return SVG.f.f381095c;
    }

    public static float k(String r100) throws SVGParseException {
        int r101 = r100.length();
        if (r101 == 0) goto L7;
        return l(r100, r101);
    L7:
        throw new SVGParseException("Invalid float value (empty string)");
    }

    public static SVG.o m(String r100) throws SVGParseException {
        if (r100.length() == 0) goto L35;
        int r101 = r100.length();
        SVG.Unit r102 = SVG.Unit.f381070px;
        int r103 = r101 - 1;
        char r104 = r100.charAt(r103);
        if (r104 != '%') goto L9;
        r102 = SVG.Unit.percent;
    L7:
        r101 = r103;
    L38:
        return new SVG.o(l(r100, r101), r102);
    L31:
        e = move-exception;
        throw new SVGParseException("Invalid length value: ".concat(r100), e);
    L9:
        if (r100.endsWith("rpx") == false) goto L12;
        r102 = SVG.Unit.rpx;
    L14:
        r101 = r101 - 3;
        goto L38
    L12:
        if (r100.endsWith("rem") == false) goto L16;
        r102 = SVG.Unit.rem;
        goto L14
    L16:
        if (r100.endsWith("em") == false) goto L19;
        r102 = SVG.Unit.f381064em;
        r101 = r101 - 2;
        goto L38
    L19:
        if (r101 <= 2) goto L38;
        if (Character.isLetter(r104) == false) goto L38;
        r103 = r101 - 2;
        if (Character.isLetter(r100.charAt(r103)) == false) goto L38;
        r102 = SVG.Unit.valueOf(r100.substring(r103).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L27
    L28:
        throw new SVGParseException("Invalid length unit specifier: ".concat(r100));
    L35:
        throw new SVGParseException("Invalid length value (empty string)");
    }

    public static SVG.o n(c r100) {
        int r101 = r100.f381191b;
        if (r101 <= (r100.f381192c - 4)) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        r100.f381191b += 4;
    L10:
        if (r102 == false) goto L14;
        return new SVG.o();
    L14:
        return r100.h();
    L5:
        if (r100.f381190a.substring(r101, r101 + 4).equals("auto") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static Float o(String r100) {
        float r101 = k(r100);     // Catch: SVGParseException -> L10
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

    public static SVG.h0 p(String r100) {
        if (r100.startsWith("url(") == false) goto L14;
        int r101 = r100.indexOf(")");
        SVG.h0 r102 = null;
        if (r101 == (-1)) goto L12;
        String r103 = r100.substring(4, r101).trim();
        String r104 = r100.substring(r101 + 1).trim();
        if (r104.length() <= 0) goto L10;
        r102 = j(r104);
    L10:
        return new SVG.r(r103, r102);
    L12:
        return new SVG.r(r100.substring(4).trim(), null);
    L14:
        return j(r100);
    }

    public static Matrix r(String r110) throws SVGParseException {
        Matrix r100 = new Matrix();
        c r101 = new c(r110);
        r101.l();
    L4:
        if (r101.e() == true) goto L126;
        if (r101.e() == true) goto L26;
        int r102 = r101.f381191b;
        int r103 = r101.f381190a.charAt(r102);
    L10:
        if (r103 < 97) goto L14;
        if (r103 > 122) goto L14;
    L17:
        r103 = r101.a();
    L14:
        if (r103 < 65) goto L18;
        if (r103 <= 90) goto L17;
    L18:
        int r104 = r101.f381191b;
    L20:
        if (c.f(r103) == false) goto L23;
        r103 = r101.a();
        goto L20
    L23:
        if (r103 != 40) goto L25;
        r101.f381191b++;
        String r105 = r101.f381190a.substring(r102, r104);
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
        r101.l();
        float r107 = r101.g();
        float r108 = r101.j();
        r101.l();
        if (Float.isNaN(r107) == true) goto L72;
        if (r101.d(')') == false) goto L72;
        if (Float.isNaN(r108) == false) goto L70;
        r100.preTranslate(r107, 0.0f);
    L119:
        if (r101.e() == true) goto L126;
        r101.k();
        goto L4
    L70:
        r100.preTranslate(r107, r108);
    L72:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L74:
        throw new SVGParseException("Invalid transform list fn: " + r105 + ")");
    L75:
        r101.l();
        float r109 = r101.g();
        r101.l();
        if (Float.isNaN(r109) == true) goto L81;
        if (r101.d(')') == false) goto L81;
        r100.preSkew(0.0f, (float) Math.tan(Math.toRadians(r109)));
    L81:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L82:
        r101.l();
        float r111 = r101.g();
        r101.l();
        if (Float.isNaN(r111) == true) goto L88;
        if (r101.d(')') == false) goto L88;
        r100.preSkew((float) Math.tan(Math.toRadians(r111)), 0.0f);
    L88:
        throw new SVGParseException("Invalid transform list: ".concat(r110));
    L89:
        r101.l();
        float r112 = r101.g();
        float r113 = r101.j();
        r101.l();
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
        r101.l();
        float r114 = r101.g();
        float r115 = r101.j();
        float r116 = r101.j();
        r101.l();
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
        r101.l();
        float r117 = r101.g();
        r101.k();
        float r118 = r101.g();
        r101.k();
        float r119 = r101.g();
        r101.k();
        float r120 = r101.g();
        r101.k();
        float r121 = r101.g();
        r101.k();
        float r122 = r101.g();
        r101.l();
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
        r101.f381191b = r102;
    L26:
        r105 = null;
    L126:
        return r100;
    }

    public final void s(InputStream r100) throws SVGParseException {
        XmlPullParser r101 = Xml.newPullParser();     // Catch: Exception -> L22 XmlPullParserException -> L25
        d r102 = new d(r101);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r101.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, true);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r101.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r101.setInput(r100, XML.CHARSET_UTF8);     // Catch: Exception -> L22 XmlPullParserException -> L25
        int r103 = r101.getEventType();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L3:
        if (r103 == 1) goto L21;
        if (r103 != 0) goto L6;
        this.f381162a = new SVG();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L19:
        r103 = r101.nextToken();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L6:
        if (r103 != 2) goto L8;
        String r104 = r101.getName();     // Catch: Exception -> L22 XmlPullParserException -> L25
        if (r101.getPrefix() == null) goto L17;
        r104 = r101.getPrefix() + ':' + r104;     // Catch: Exception -> L22 XmlPullParserException -> L25
    L17:
        u(r101.getNamespace(), r101.getName(), r104, r102);     // Catch: Exception -> L22 XmlPullParserException -> L25
        goto L19
    L8:
        if (r103 != 3) goto L19;
        String r105 = r101.getName();     // Catch: Exception -> L22 XmlPullParserException -> L25
        if (r101.getPrefix() == null) goto L13;
        r105 = r101.getPrefix() + ':' + r105;     // Catch: Exception -> L22 XmlPullParserException -> L25
    L13:
        b(r101.getNamespace(), r101.getName(), r105);     // Catch: Exception -> L22 XmlPullParserException -> L25
        goto L19
    L21:
        return;
    L25:
        e = move-exception;
        throw new SVGParseException("XML parser problem", e);
    L22:
        e = move-exception;
        throw new SVGParseException("unexpected error", e);
    }

    public static void a(String r100, Object... r101) {
        LLog.d("SVGParser", String.format(r100, r101));
    }

    public static void c(SVG.e0 r100, Attributes r101) throws SVGParseException {
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
        r100.f381091d = Boolean.FALSE;
        return;
    L16:
        if ("preserve".equals(r104) == false) goto L19;
        r100.f381091d = Boolean.TRUE;
        return;
    L19:
        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + r104);
    L21:
        r100.f381090c = r101.getValue(r102).trim();
        return;
    }

    public static void d(SVG.j r100, d r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L28;
        String r103 = r101.getValue(r102).trim();
        int r104 = a.f381188b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 == 6) goto L23;
        switch(r104) {
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L29;
            default: goto L27;
        };
    L13:
        r100.f381111i = r(r103);
        goto L27
    L29:
        r100.f381112j = SVG.GradientSpread.valueOf(r103);     // Catch: IllegalArgumentException -> L11
    L12:
        throw new SVGParseException("Invalid spreadMethod attribute. \"" + r103 + "\" is not a valid value.");
    L15:
        if ("objectBoundingBox".equals(r103) == false) goto L18;
        r100.f381110h = Boolean.FALSE;
        goto L27
    L18:
        if ("userSpaceOnUse".equals(r103) == false) goto L21;
        r100.f381110h = Boolean.TRUE;
        goto L27
    L21:
        throw new SVGParseException("Invalid value for attribute gradientUnits");
    L27:
        r102 = r102 + 1;
        goto L4
    L23:
        if ("".equals(r101.getURI(r102)) == false) goto L25;
    L26:
        r100.f381113k = r103;
        goto L27
    L25:
        if ("http://www.w3.org/1999/xlink".equals(r101.getURI(r102)) == false) goto L27;
    }

    public static void f(SVG.e0 r110, Attributes r111) throws SVGParseException {
        int r100 = 0;
    L4:
        if (r100 >= r111.getLength()) goto L93;
        String r101 = r111.getValue(r100).trim();
        if (r101.length() == 0) goto L92;
        if (a.f381188b[SVGAttr.fromString(r111.getLocalName(r100)).ordinal()] != 29) goto L11;
        com.lynx.component.svg.parser.a r102 = new com.lynx.component.svg.parser.a(r101.replaceAll("/\\*.*?\\*/", ""));
    L16:
        if (r102.e() == true) goto L92;
        r102.l();
        if (r102.e() == false) goto L20;
        int r103 = r102.f381191b;
    L45:
        int r104 = r102.f381191b;
        String r105 = null;
        if (r103 != r104) goto L48;
        String r106 = null;
    L49:
        r102.l();
        if (r102.d(';') == true) goto L16;
        if (r102.d(':') == false) goto L92;
        r102.l();
        if (r102.e() == true) goto L82;
        int r107 = r102.f381191b;
        int r108 = r102.f381190a.charAt(r107);
        int r109 = r107;
    L60:
        if (r108 == (-1)) goto L79;
        if (r108 == 59) goto L79;
        if (r108 == 125) goto L79;
        if (r108 == 33) goto L79;
        if (r108 != 10) goto L69;
    L72:
        boolean r112 = true;
    L73:
        if (r112 == true) goto L79;
        if (c.f(r108) == true) goto L77;
        r109 = r102.f381191b + 1;
    L77:
        r108 = r102.a();
        goto L60
    L69:
        if (r108 == 13) goto L72;
        r112 = false;
    L79:
        if (r102.f381191b <= r107) goto L81;
        r105 = r102.f381190a.substring(r107, r109);
        goto L82
    L81:
        r102.f381191b = r107;
    L82:
        if (r105 == null) goto L16;
        r102.l();
        if (r102.e() == true) goto L89;
        if (r102.d(';') == false) goto L16;
    L89:
        if (r110.f381093f != null) goto L91;
        r110.f381093f = new SVG.Style();
    L91:
        t(r110.f381093f, r106, r105);
        r102.l();
        goto L16
    L48:
        r106 = r102.f381190a.substring(r104, r103);
        r102.f381191b = r103;
        goto L49
    L20:
        int r113 = r102.f381191b;
        int r114 = r102.f381190a.charAt(r113);
        if (r114 != 45) goto L24;
        r114 = r102.a();
    L24:
        if (r114 < 65) goto L26;
        if (r114 > 90) goto L26;
    L29:
        int r115 = r102.a();
    L30:
        if (r115 < 65) goto L32;
        if (r115 > 90) goto L32;
    L42:
        r115 = r102.a();
    L32:
        if (r115 < 97) goto L35;
        if (r115 <= 122) goto L42;
    L35:
        if (r115 >= 48) goto L37;
    L38:
        if (r115 == 45) goto L42;
        if (r115 == 95) goto L42;
        int r116 = r102.f381191b;
    L44:
        r102.f381191b = r113;
        r103 = r116;
        goto L45
    L37:
        if (r115 <= 57) goto L42;
    L26:
        if (r114 < 97) goto L28;
        if (r114 <= 122) goto L29;
    L28:
        if (r114 == 95) goto L29;
        r116 = r113;
        goto L44
    L11:
        if (r110.f381092e != null) goto L13;
        r110.f381092e = new SVG.Style();
    L13:
        t(r110.f381092e, r111.getLocalName(r100), r111.getValue(r100).trim());
    L92:
        r100 = r100 + 1;
        goto L4
    }

    public static void g(SVG.m r100, Attributes r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L9;
        if (SVGAttr.fromString(r101.getLocalName(r102)) != SVGAttr.transform) goto L8;
        r100.a(r(r101.getValue(r102)));
    L8:
        r102 = r102 + 1;
        goto L4
    }

    public static void h(SVG.k0 r100, d r101) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L31;
        String r103 = r101.getValue(r102).trim();
        int r104 = a.f381188b[SVGAttr.fromString(r101.getLocalName(r102)).ordinal()];
        if (r104 != 7) goto L8;
        q(r100, r103);
    L30:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r104 != 57) goto L30;
        c r105 = new c(r103);
        r105.l();
        float r106 = n.a(r105.i(), 0.0f);
        r105.k();
        float r107 = n.a(r105.i(), 0.0f);
        r105.k();
        float r108 = n.a(r105.i(), 0.0f);
        r105.k();
        float r109 = n.a(r105.i(), 0.0f);
        if (Float.isNaN(r106) == true) goto L28;
        if (Float.isNaN(r107) == true) goto L28;
        if (Float.isNaN(r108) == true) goto L28;
        if (Float.isNaN(r109) == true) goto L28;
        if (r108 < 0.0f) goto L26;
        if (r109 < 0.0f) goto L24;
        r100.f381120j = new SVG.b(r106, r107, r108, r109);
        goto L30
    L24:
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    L26:
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    L28:
        throw new SVGParseException("Invalid viewBox definition - should have four numbers");
    }

    public static float l(String r100, int r101) throws SVGParseException {
        float r102 = new com.lynx.component.svg.parser.b().a(r100, 0, r101);
        if (Float.isNaN(r102) == true) goto L6;
        return r102;
    L6:
        throw new SVGParseException("Invalid float value: " + r100);
    }

    public static void q(SVG.i0 r100, String r101) throws SVGParseException {
        c r102 = new c(r101);
        r102.l();
        String r103 = r102.i();
        if ("defer".equals(r103) == false) goto L5;
        r102.l();
        r103 = r102.i();
    L5:
        PreserveAspectRatio.Alignment r104 = (PreserveAspectRatio.Alignment) ((HashMap) b.f381189a).get(r103);
        r102.l();
        if (r102.e() == true) goto L15;
        String r105 = r102.i();
        r105.getClass();
        if (r105.equals("meet") == false) goto L10;
        PreserveAspectRatio.Scale r106 = PreserveAspectRatio.Scale.meet;
    L16:
        r100.f381108i = new PreserveAspectRatio(r104, r106);
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

    public static void e(SVG.v r100, d r101, String r110) throws SVGParseException {
        int r102 = 0;
    L4:
        if (r102 >= r101.getLength()) goto L24;
        if (SVGAttr.fromString(r101.getLocalName(r102)) != SVGAttr.points) goto L23;
        c r103 = new c(r101.getValue(r102));
        ArrayList r104 = new ArrayList();
        r103.l();
    L9:
        if (r103.e() == true) goto L19;
        float r105 = r103.g();
        if (Float.isNaN(r105) == true) goto L18;
        r103.k();
        float r106 = r103.g();
        if (Float.isNaN(r106) == true) goto L16;
        r103.k();
        r104.add(Float.valueOf(r105));
        r104.add(Float.valueOf(r106));
        goto L9
    L16:
        throw new SVGParseException("Invalid <" + r110 + "> points attribute. There should be an even number of coordinates.");
    L18:
        throw new SVGParseException("Invalid <" + r110 + "> points attribute. Non-coordinate content found in list.");
    L19:
        r100.f381154i = new float[r104.size()];
        Iterator r107 = r104.iterator();
        int r108 = 0;
    L21:
        if (r107.hasNext() == false) goto L23;
        r100.f381154i[r108] = ((Float) r107.next()).floatValue();
        r108 = r108 + 1;
    L23:
        r102 = r102 + 1;
        goto L4
    }

    public static void t(SVG.Style r110, String r111, String r112) {
        if (r112.length() != 0) goto L6;
        return;
    L6:
        if (r112.equals("inherit") == false) goto L8;
        return;
    L8:
        SVG.Style.FillRule r100 = null;
        SVG.Style.RenderQuality r101 = null;
        SVG.Style.VectorEffect r102 = null;
        SVG.Style.FillRule r103 = null;
        String r104 = null;
        r104 = null;
        SVG.c r105 = null;
        r105 = null;
        r105 = null;
        Boolean r106 = null;
        SVG.o[] r107 = null;
        r107 = null;
        r107 = null;
        r107 = null;
        r107 = null;
        r107 = null;
        SVG.Style.LineJoin r108 = null;
        SVG.Style.LineCap r109 = null;
        byte r113 = -1;
        switch(a.f381188b[SVGAttr.fromString(r111).ordinal()]) {
            case 30: goto L228;
            case 31: goto L220;
            case 32: goto L216;
            case 33: goto L213;
            case 34: goto L210;
            case 35: goto L208;
            case 36: goto L197;
            case 37: goto L185;
            case 38: goto L182;
            case 39: goto L154;
            case 40: goto L151;
            case 41: goto L150;
            case 42: goto L148;
            case 43: goto L120;
            case 44: goto L114;
            case 45: goto L108;
            case 46: goto L101;
            case 47: goto L99;
            case 48: goto L85;
            case 49: goto L74;
            case 50: goto L67;
            case 51: goto L60;
            case 52: goto L58;
            case 53: goto L52;
            case 54: goto L50;
            case 55: goto L41;
            case 56: goto L11;
            default: goto L286;
        };
    L11:
        int r114 = r112.hashCode();
        if (r114 == (-933002398)) goto L27;
        if (r114 == 3005871) goto L23;
        if (r114 == 362741610) goto L19;
    L28:
        byte r115 = -1;
    L30:
        if (r115 == 0) goto L36;
        if (r115 == 1) goto L35;
        if (r115 != 2) goto L37;
        r101 = SVG.Style.RenderQuality.optimizeSpeed;
    L37:
        r110.B = r101;
        if (r101 == null) goto L246;
        r110.f381031a |= 137438953472L;
        return;
    L246:
        return;
    L35:
        r101 = SVG.Style.RenderQuality.auto;
        goto L37
    L36:
        r101 = SVG.Style.RenderQuality.optimizeQuality;
        goto L37
    L19:
        if (r112.equals("optimizeSpeed") == false) goto L28;
        r115 = 2;
        goto L30
    L23:
        if (r112.equals("auto") == false) goto L28;
        r115 = 1;
        goto L30
    L27:
        if (r112.equals("optimizeQuality") == false) goto L28;
        r115 = 0;
        goto L30
    L50:
        r110.f381056z = o(r112);
        r110.f381031a |= 17179869184L;
        return;
    L58:
        r110.f381054x = o(r112);
        r110.f381031a |= 4294967296L;
        return;
    L99:
        r110.f381050t = o(r112);
        r110.f381031a |= 134217728;
        return;
    L148:
        r110.f381044n = i(r112);     // Catch: SVGParseException -> L232
        r110.f381031a |= 4096;     // Catch: SVGParseException -> L232
    L235:
        return;
    L150:
        r110.f381043m = o(r112);
        r110.f381031a |= 2048;
        return;
    L151:
        r110.f381042l = m(r112);     // Catch: SVGParseException -> L232
        r110.f381031a |= 1024;     // Catch: SVGParseException -> L232
        goto L235
    L182:
        r110.f381040j = Float.valueOf(k(r112));     // Catch: SVGParseException -> L232
        r110.f381031a |= 256;     // Catch: SVGParseException -> L232
        goto L235
    L208:
        r110.f381037g = m(r112);     // Catch: SVGParseException -> L232
        r110.f381031a |= 32;     // Catch: SVGParseException -> L232
        goto L235
    L210:
        Float r116 = o(r112);
        r110.f381036f = r116;
        if (r116 == null) goto L277;
        r110.f381031a |= 16;
        return;
    L277:
        return;
    L213:
        SVG.h0 r117 = p(r112);
        r110.f381035e = r117;
        if (r117 == null) goto L279;
        r110.f381031a |= 8;
        return;
    L279:
        return;
    L216:
        Float r118 = o(r112);
        r110.f381034d = r118;
        if (r118 == null) goto L281;
        r110.f381031a |= 4;
        return;
    L281:
        return;
    L228:
        SVG.h0 r119 = p(r112);
        r110.f381032b = r119;
        if (r119 == null) goto L285;
        r110.f381031a |= 1;
        return;
    L285:
        return;
    L286:
        return;
    L41:
        if (r112.equals("none") == false) goto L43;
        r102 = SVG.Style.VectorEffect.None;
    L47:
        r110.A = r102;
        if (r102 == null) goto L248;
        r110.f381031a |= 34359738368L;
        return;
    L248:
        return;
    L43:
        if (r112.equals("non-scaling-stroke") == false) goto L47;
        r102 = SVG.Style.VectorEffect.NonScalingStroke;
        goto L47
    L52:
        if (r112.equals("currentColor") == false) goto L233;
        r110.f381055y = SVG.g.f381101a;
    L55:
        r110.f381031a |= 8589934592L;
        return;
    L233:
        r110.f381055y = i(r112);     // Catch: SVGParseException -> L56
    L56:
        e = move-exception;
        e.getMessage();
        return;
    L60:
        if (r112.equals("currentColor") == false) goto L240;
        r110.f381053w = SVG.g.f381101a;
    L63:
        r110.f381031a |= j0.G2_OTA_SPACE_RESERVE_BYTES;
        return;
    L240:
        r110.f381053w = i(r112);     // Catch: SVGParseException -> L64
    L64:
        e = move-exception;
        e.getMessage();
        return;
    L67:
        if ("nonzero".equals(r112) == false) goto L70;
        r103 = SVG.Style.FillRule.NonZero;
    L72:
        r110.f381052v = r103;
        r110.f381031a |= 536870912;
        return;
    L70:
        if ("evenodd".equals(r112) == false) goto L72;
        r103 = SVG.Style.FillRule.EvenOdd;
        goto L72
    L74:
        if (r112.equals("none") == false) goto L77;
    L83:
        r110.f381051u = r104;
        r110.f381031a |= 268435456;
        return;
    L77:
        if (r112.startsWith("url(") == false) goto L83;
        if (r112.endsWith(")") == false) goto L82;
        r104 = r112.substring(4, r112.length() - 1).trim();
        goto L83
    L82:
        r104 = r112.substring(4).trim();
        goto L83
    L85:
        if ("auto".equals(r112) == false) goto L88;
    L96:
        r110.f381046p = r105;
        if (r105 == null) goto L258;
        r110.f381031a |= 1048576;
        return;
    L258:
        return;
    L88:
        if (r112.startsWith("rect(") == false) goto L96;
        c r120 = new c(r112.substring(5));
        r120.l();
        SVG.o r121 = n(r120);
        r120.k();
        SVG.o r122 = n(r120);
        r120.k();
        SVG.o r123 = n(r120);
        r120.k();
        SVG.o r124 = n(r120);
        r120.l();
        if (r120.d(')') == false) goto L93;
    L95:
        r105 = new SVG.c(r121, r122, r123, r124);
        goto L96
    L93:
        if (r120.e() == true) goto L95;
    L101:
        if (r112.equals("currentColor") == false) goto L238;
        r110.f381049s = SVG.g.f381101a;
    L104:
        r110.f381031a |= 67108864;
        return;
    L238:
        r110.f381049s = i(r112);     // Catch: SVGParseException -> L105
    L105:
        e = move-exception;
        e.getMessage();
        return;
    L108:
        if (r112.indexOf(124) < 0) goto L110;
        return;
    L110:
        if ("|visible|hidden|collapse|".contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112 + '|') == false) goto L287;
        r110.f381048r = Boolean.valueOf(r112.equals("visible"));
        r110.f381031a |= 33554432;
        return;
    L287:
        return;
    L114:
        if (r112.indexOf(124) < 0) goto L116;
        return;
    L116:
        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112 + '|') == false) goto L288;
        r110.f381047q = Boolean.valueOf(!r112.equals("none"));
        r110.f381031a |= 16777216;
        return;
    L288:
        return;
    L120:
        switch(r112.hashCode()) {
            case -1217487446: goto L135;
            case -907680051: goto L131;
            case 3005871: goto L127;
            case 466743410: goto L123;
            default: goto L138;
        };
    L138:
        if (r113 == 0) goto L144;
        if (r113 == 1) goto L144;
        if (r113 == 2) goto L143;
        if (r113 == 3) goto L143;
    L145:
        r110.f381045o = r106;
        if (r106 == null) goto L267;
        r110.f381031a |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        return;
    L267:
        return;
    L143:
        r106 = Boolean.TRUE;
    L144:
        r106 = Boolean.FALSE;
        goto L145
    L123:
        if (r112.equals("visible") == false) goto L138;
        r113 = 3;
        goto L138
    L127:
        if (r112.equals("auto") == false) goto L138;
        r113 = 2;
        goto L138
    L131:
        if (r112.equals(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L138;
        r113 = 1;
        goto L138
    L135:
        if (r112.equals("hidden") == false) goto L138;
        r113 = 0;
        goto L138
    L154:
        if ("none".equals(r112) == false) goto L156;
        r110.f381041k = null;
        r110.f381031a |= 512;
        return;
    L156:
        c r125 = new c(r112);
        r125.l();
        if (r125.e() == true) goto L179;
        SVG.o r126 = r125.h();
        if (r126 == null) goto L179;
        if (r126.f() == true) goto L179;
        float r127 = r126.f381133a;
        ArrayList r128 = new ArrayList();
        r128.add(r126);
    L167:
        if (r125.e() == true) goto L176;
        r125.k();
        SVG.o r129 = r125.h();
        if (r129 == null) goto L179;
        if (r129.f() == true) goto L179;
        r128.add(r129);
        r127 = r127 + r129.f381133a;
        goto L167
    L176:
        if (r127 == 0.0f) goto L179;
        r107 = (SVG.o[]) r128.toArray(new SVG.o[r128.size()]);
    L179:
        r110.f381041k = r107;
        if (r107 == null) goto L271;
        r110.f381031a |= 512;
        return;
    L271:
        return;
    L185:
        if ("miter".equals(r112) == false) goto L188;
        r108 = SVG.Style.LineJoin.Miter;
    L193:
        r110.f381039i = r108;
        if (r108 == null) goto L273;
        r110.f381031a |= 128;
        return;
    L273:
        return;
    L188:
        if ("round".equals(r112) == false) goto L191;
        r108 = SVG.Style.LineJoin.Round;
        goto L193
    L191:
        if ("bevel".equals(r112) == false) goto L193;
        r108 = SVG.Style.LineJoin.Bevel;
        goto L193
    L197:
        if ("butt".equals(r112) == false) goto L200;
        r109 = SVG.Style.LineCap.Butt;
    L205:
        r110.f381038h = r109;
        if (r109 == null) goto L275;
        r110.f381031a |= 64;
        return;
    L275:
        return;
    L200:
        if ("round".equals(r112) == false) goto L203;
        r109 = SVG.Style.LineCap.Round;
        goto L205
    L203:
        if ("square".equals(r112) == false) goto L205;
        r109 = SVG.Style.LineCap.Square;
        goto L205
    L220:
        if ("nonzero".equals(r112) == false) goto L223;
        r100 = SVG.Style.FillRule.NonZero;
    L225:
        r110.f381033c = r100;
        if (r100 == null) goto L283;
        r110.f381031a |= 2;
        return;
    L283:
        return;
    L223:
        if ("evenodd".equals(r112) == false) goto L225;
        r100 = SVG.Style.FillRule.EvenOdd;
    }

    public final void b(String r100, String r101, String r102) throws SVGParseException {
        if (this.f381164c == false) goto L9;
        int r103 = this.f381165d - 1;
        this.f381165d = r103;
        if (r103 != 0) goto L33;
        this.f381164c = false;
        return;
    L33:
        return;
    L9:
        if ("http://www.w3.org/2000/svg".equals(r100) == true) goto L14;
        if ("".equals(r100) == true) goto L14;
        return;
    L14:
        if (r101.length() > 0) goto L17;
        r101 = r102;
    L17:
        int r104 = a.f381187a[SVGElem.fromString(r101).ordinal()];
        if (r104 != 1) goto L20;
    L27:
        Object r105 = this.f381163b;
        if (r105 == null) goto L32;
        this.f381163b = ((SVG.g0) r105).f381103b;
        return;
    L32:
        throw new SVGParseException(String.format("Unbalanced end element </%s> found", new Object[]{r101}));
    L20:
        if (r104 == 2) goto L27;
        if (r104 == 3) goto L27;
        if (r104 == 4) goto L27;
        switch(r104) {
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L27;
            default: goto L34;
        };
    }

    public final void u(String r210, String r211, String r212, d r213) throws SVGParseException {
        if (this.f381164c == false) goto L7;
        this.f381165d++;
        return;
    L7:
        if ("http://www.w3.org/2000/svg".equals(r210) == true) goto L12;
        if ("".equals(r210) == true) goto L12;
        return;
    L12:
        if (r211.length() <= 0) goto L14;
        String r100 = r211;
    L15:
        byte r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
        int r110 = 0;
        switch(a.f381187a[SVGElem.fromString(r100).ordinal()]) {
            case 1: goto L506;
            case 2: goto L501;
            case 3: goto L496;
            case 4: goto L461;
            case 5: goto L314;
            case 6: goto L273;
            case 7: goto L254;
            case 8: goto L230;
            case 9: goto L214;
            case 10: goto L209;
            case 11: goto L204;
            case 12: goto L188;
            case 13: goto L164;
            case 14: goto L126;
            case 15: goto L106;
            case 16: goto L59;
            case 17: goto L23;
            case 18: goto L18;
            default: goto L17;
        };
    L17:
        this.f381164c = true;
        this.f381165d = 1;
        return;
    L18:
        a("<solidColor>", new Object[0]);
        if (this.f381163b == null) goto L22;
        SVG.y r111 = new SVG.y();
        r111.f381102a = this.f381162a;
        r111.f381103b = this.f381163b;
        c(r111, r213);
        f(r111, r213);
        this.f381163b.b(r111);
        this.f381163b = r111;
        return;
    L22:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L23:
        a("<image>", new Object[0]);
        if (this.f381163b == null) goto L58;
        SVG.n r112 = new SVG.n();
        r112.f381102a = this.f381162a;
        r112.f381103b = this.f381163b;
        c(r112, r213);
        f(r112, r213);
        g(r112, r213);
    L27:
        if (r102 >= r213.getLength()) goto L56;
        String r113 = r213.getValue(r102).trim();
        int r114 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r102)).ordinal()];
        if (r114 == 1) goto L54;
        if (r114 == 2) goto L53;
        if (r114 == 3) goto L48;
        if (r114 == 4) goto L43;
        if (r114 == 6) goto L39;
        if (r114 != 7) goto L55;
        q(r112, r113);
    L55:
        r102 = r102 + 1;
        goto L27
    L39:
        if ("".equals(r213.getURI(r102)) == false) goto L41;
    L42:
        r112.f381127j = r113;
        goto L55
    L41:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r102)) == false) goto L55;
    L43:
        SVG.o r115 = m(r113);
        r112.f381131n = r115;
        if (r115.f() == false) goto L55;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L48:
        SVG.o r116 = m(r113);
        r112.f381130m = r116;
        if (r116.f() == false) goto L55;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L53:
        r112.f381129l = m(r113);
        goto L55
    L54:
        r112.f381128k = m(r113);
        goto L55
    L56:
        this.f381163b.b(r112);
        this.f381163b = r112;
        return;
    L58:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L59:
        a("<pattern>", new Object[0]);
        if (this.f381163b == null) goto L105;
        SVG.u r117 = new SVG.u();
        r117.f381102a = this.f381162a;
        r117.f381103b = this.f381163b;
        c(r117, r213);
        f(r117, r213);
        h(r117, r213);
    L63:
        if (r103 >= r213.getLength()) goto L103;
        String r118 = r213.getValue(r103).trim();
        int r119 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r103)).ordinal()];
        if (r119 == 1) goto L101;
        if (r119 == 2) goto L100;
        if (r119 == 3) goto L95;
        if (r119 == 4) goto L90;
        if (r119 == 6) goto L86;
        switch(r119) {
            case 26: goto L80;
            case 27: goto L74;
            case 28: goto L72;
            default: goto L102;
        };
    L72:
        r117.f381148m = r(r118);
        goto L102
    L74:
        if ("objectBoundingBox".equals(r118) == false) goto L77;
        r117.f381147l = Boolean.FALSE;
        goto L102
    L77:
        if ("userSpaceOnUse".equals(r118) == false) goto L102;
        r117.f381147l = Boolean.TRUE;
        goto L102
    L80:
        if ("objectBoundingBox".equals(r118) == false) goto L83;
        r117.f381146k = Boolean.FALSE;
        goto L102
    L83:
        if ("userSpaceOnUse".equals(r118) == false) goto L102;
        r117.f381146k = Boolean.TRUE;
    L102:
        r103 = r103 + 1;
        goto L63
    L86:
        if ("".equals(r213.getURI(r103)) == false) goto L88;
    L89:
        r117.f381153r = r118;
        goto L102
    L88:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r103)) == false) goto L102;
    L90:
        SVG.o r120 = m(r118);
        r117.f381152q = r120;
        if (r120.f() == false) goto L102;
        throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
    L95:
        SVG.o r121 = m(r118);
        r117.f381151p = r121;
        if (r121.f() == false) goto L102;
        throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
    L100:
        r117.f381150o = m(r118);
        goto L102
    L101:
        r117.f381149n = m(r118);
        goto L102
    L103:
        this.f381163b.b(r117);
        this.f381163b = r117;
        return;
    L105:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L106:
        a("<clipPath>", new Object[0]);
        if (this.f381163b == null) goto L125;
        SVG.e r122 = new SVG.e();
        r122.f381102a = this.f381162a;
        r122.f381103b = this.f381163b;
        c(r122, r213);
        f(r122, r213);
        g(r122, r213);
    L110:
        if (r104 >= r213.getLength()) goto L123;
        String r123 = r213.getValue(r104).trim();
        if (a.f381188b[SVGAttr.fromString(r213.getLocalName(r104)).ordinal()] != 25) goto L120;
        if ("objectBoundingBox".equals(r123) == false) goto L118;
        r122.f381089j = Boolean.FALSE;
        goto L120
    L118:
        if ("userSpaceOnUse".equals(r123) == false) goto L122;
        r122.f381089j = Boolean.TRUE;
        goto L120
    L122:
        throw new SVGParseException("Invalid value for attribute clipPathUnits");
    L120:
        r104 = r104 + 1;
        goto L110
    L123:
        this.f381163b.b(r122);
        this.f381163b = r122;
        return;
    L125:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L126:
        a("<stop>", new Object[0]);
        SVG.c0 r124 = this.f381163b;
        if (r124 == null) goto L163;
        if ((r124 instanceof SVG.j) == false) goto L161;
        SVG.z r125 = new SVG.z();
        r125.f381102a = this.f381162a;
        r125.f381103b = this.f381163b;
        c(r125, r213);
        f(r125, r213);
        int r126 = 0;
    L132:
        if (r126 >= r213.getLength()) goto L159;
        String r127 = r213.getValue(r126).trim();
        if (a.f381188b[SVGAttr.fromString(r213.getLocalName(r126)).ordinal()] != 24) goto L153;
        if (r127.length() == 0) goto L158;
        int r128 = r127.length();
        if (r127.charAt(r127.length() - 1) != '%') goto L141;
        r128 = r128 - 1;
        boolean r129 = true;
    L536:
        float r130 = l(r127, r128);     // Catch: NumberFormatException -> L154
        if (r129 == false) goto L146;
        r130 = r130 / 100.0f;     // Catch: NumberFormatException -> L154
    L146:
        if (r130 >= 0.0f) goto L149;
        r130 = 0.0f;
    L152:
        r125.f381161g = Float.valueOf(r130);
        goto L153
    L149:
        if (r130 <= 100.0f) goto L152;
        r130 = 100.0f;
    L154:
        e = move-exception;
        throw new SVGParseException("Invalid offset value in <stop>: ".concat(r127), e);
    L141:
        r129 = false;
        goto L536
    L158:
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    L153:
        r126 = r126 + 1;
        goto L132
    L159:
        this.f381163b.b(r125);
        this.f381163b = r125;
        return;
    L161:
        throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
    L163:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L164:
        a("<radialGradient>", new Object[0]);
        if (this.f381163b == null) goto L187;
        SVG.j0 r131 = new SVG.j0();
        r131.f381102a = this.f381162a;
        r131.f381103b = this.f381163b;
        c(r131, r213);
        f(r131, r213);
        d(r131, r213);
    L168:
        if (r105 >= r213.getLength()) goto L185;
        String r132 = r213.getValue(r105).trim();
        int r133 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r105)).ordinal()];
        if (r133 != 22) goto L172;
        r131.f381117o = m(r132);
    L184:
        r105 = r105 + 1;
        goto L168
    L172:
        if (r133 == 23) goto L182;
        switch(r133) {
            case 12: goto L181;
            case 13: goto L180;
            case 14: goto L175;
            default: goto L184;
        };
    L175:
        SVG.o r134 = m(r132);
        r131.f381116n = r134;
        if (r134.f() == false) goto L184;
        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
    L180:
        r131.f381115m = m(r132);
        goto L184
    L181:
        r131.f381114l = m(r132);
        goto L184
    L182:
        r131.f381118p = m(r132);
        goto L184
    L185:
        this.f381163b.b(r131);
        this.f381163b = r131;
        return;
    L187:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L188:
        a("<linearGradient>", new Object[0]);
        if (this.f381163b == null) goto L203;
        SVG.f0 r135 = new SVG.f0();
        r135.f381102a = this.f381162a;
        r135.f381103b = this.f381163b;
        c(r135, r213);
        f(r135, r213);
        d(r135, r213);
    L192:
        if (r106 >= r213.getLength()) goto L201;
        String r136 = r213.getValue(r106).trim();
        switch(a.f381188b[SVGAttr.fromString(r213.getLocalName(r106)).ordinal()]) {
            case 15: goto L199;
            case 16: goto L198;
            case 17: goto L197;
            case 18: goto L196;
            default: goto L200;
        };
    L196:
        r135.f381100o = m(r136);
        goto L200
    L197:
        r135.f381099n = m(r136);
        goto L200
    L198:
        r135.f381098m = m(r136);
        goto L200
    L199:
        r135.f381097l = m(r136);
    L200:
        r106 = r106 + 1;
        goto L192
    L201:
        this.f381163b.b(r135);
        this.f381163b = r135;
        return;
    L203:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L204:
        a("<polygon>", new Object[0]);
        if (this.f381163b == null) goto L208;
        SVG.w r137 = new SVG.w();
        r137.f381102a = this.f381162a;
        r137.f381103b = this.f381163b;
        c(r137, r213);
        f(r137, r213);
        g(r137, r213);
        e(r137, r213, SVGRenderEngine.POLYGON);
        this.f381163b.b(r137);
        return;
    L208:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L209:
        a("<polyline>", new Object[0]);
        if (this.f381163b == null) goto L213;
        SVG.v r138 = new SVG.v();
        r138.f381102a = this.f381162a;
        r138.f381103b = this.f381163b;
        c(r138, r213);
        f(r138, r213);
        g(r138, r213);
        e(r138, r213, SVGRenderEngine.POLYLINE);
        this.f381163b.b(r138);
        return;
    L213:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L214:
        a("<line>", new Object[0]);
        if (this.f381163b == null) goto L229;
        SVG.p r139 = new SVG.p();
        r139.f381102a = this.f381162a;
        r139.f381103b = this.f381163b;
        c(r139, r213);
        f(r139, r213);
        g(r139, r213);
    L218:
        if (r107 >= r213.getLength()) goto L227;
        String r140 = r213.getValue(r107).trim();
        switch(a.f381188b[SVGAttr.fromString(r213.getLocalName(r107)).ordinal()]) {
            case 15: goto L225;
            case 16: goto L224;
            case 17: goto L223;
            case 18: goto L222;
            default: goto L226;
        };
    L222:
        r139.f381138l = m(r140);
        goto L226
    L223:
        r139.f381137k = m(r140);
        goto L226
    L224:
        r139.f381136j = m(r140);
        goto L226
    L225:
        r139.f381135i = m(r140);
    L226:
        r107 = r107 + 1;
        goto L218
    L227:
        this.f381163b.b(r139);
        return;
    L229:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L230:
        a("<ellipse>", new Object[0]);
        if (this.f381163b == null) goto L253;
        SVG.i r141 = new SVG.i();
        r141.f381102a = this.f381162a;
        r141.f381103b = this.f381163b;
        c(r141, r213);
        f(r141, r213);
        g(r141, r213);
    L234:
        if (r108 >= r213.getLength()) goto L251;
        String r142 = r213.getValue(r108).trim();
        switch(a.f381188b[SVGAttr.fromString(r213.getLocalName(r108)).ordinal()]) {
            case 10: goto L245;
            case 11: goto L240;
            case 12: goto L239;
            case 13: goto L238;
            default: goto L250;
        };
    L238:
        r141.f381105j = m(r142);
        goto L250
    L239:
        r141.f381104i = m(r142);
        goto L250
    L240:
        SVG.o r143 = m(r142);
        r141.f381107l = r143;
        if (r143.f() == false) goto L250;
        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
    L245:
        SVG.o r144 = m(r142);
        r141.f381106k = r144;
        if (r144.f() == false) goto L250;
        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
    L250:
        r108 = r108 + 1;
        goto L234
    L251:
        this.f381163b.b(r141);
        return;
    L253:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L254:
        a("<circle>", new Object[0]);
        if (this.f381163b == null) goto L272;
        SVG.d r145 = new SVG.d();
        r145.f381102a = this.f381162a;
        r145.f381103b = this.f381163b;
        c(r145, r213);
        f(r145, r213);
        g(r145, r213);
    L258:
        if (r109 >= r213.getLength()) goto L270;
        String r146 = r213.getValue(r109).trim();
        switch(a.f381188b[SVGAttr.fromString(r213.getLocalName(r109)).ordinal()]) {
            case 12: goto L268;
            case 13: goto L267;
            case 14: goto L262;
            default: goto L269;
        };
    L262:
        SVG.o r147 = m(r146);
        r145.f381087k = r147;
        if (r147.f() == false) goto L269;
        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
    L267:
        r145.f381086j = m(r146);
        goto L269
    L268:
        r145.f381085i = m(r146);
    L269:
        r109 = r109 + 1;
        goto L258
    L270:
        this.f381163b.b(r145);
        return;
    L272:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L273:
        a("<rect>", new Object[0]);
        if (this.f381163b == null) goto L313;
        SVG.x r148 = new SVG.x();
        r148.f381102a = this.f381162a;
        r148.f381103b = this.f381163b;
        c(r148, r213);
        f(r148, r213);
        g(r148, r213);
    L277:
        if (r110 >= r213.getLength()) goto L311;
        String r149 = r213.getValue(r110).trim();
        int r150 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r110)).ordinal()];
        if (r150 == 1) goto L309;
        if (r150 == 2) goto L308;
        if (r150 == 3) goto L303;
        if (r150 != 4) goto L284;
        SVG.o r151 = m(r149);
        r148.f381158l = r151;
        if (r151.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. height cannot be negative");
    L310:
        r110 = r110 + 1;
        goto L277
    L284:
        if (r150 != 10) goto L286;
        SVG.o r152 = m(r149);
        r148.f381159m = r152;
        if (r152.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
    L286:
        if (r150 != 11) goto L310;
        SVG.o r153 = m(r149);
        r148.f381160n = r153;
        if (r153.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
    L303:
        SVG.o r154 = m(r149);
        r148.f381157k = r154;
        if (r154.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
    L308:
        r148.f381156j = m(r149);
        goto L310
    L309:
        r148.f381155i = m(r149);
        goto L310
    L311:
        this.f381163b.b(r148);
        return;
    L313:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L314:
        a("<path>", new Object[0]);
        if (this.f381163b == null) goto L460;
        SVG.s r155 = new SVG.s();
        r155.f381102a = this.f381162a;
        r155.f381103b = this.f381163b;
        c(r155, r213);
        f(r155, r213);
        g(r155, r213);
        int r156 = 0;
    L318:
        if (r156 >= r213.getLength()) goto L458;
        String r157 = r213.getValue(r156).trim();
        int r158 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r156)).ordinal()];
        byte r159 = 8;
        if (r158 != 8) goto L322;
        c r160 = new c(r157);
        SVG.t r161 = new SVG.t();
        if (r160.e() == true) goto L456;
        int r162 = r160.f381191b;
        if (r162 != r160.f381192c) goto L335;
        Integer r163 = null;
    L336:
        int r164 = r163.intValue();
        if (r164 == 77) goto L340;
        if (r164 != 109) goto L456;
    L340:
        int r165 = r164;
        float r166 = 0.0f;
        float r167 = 0.0f;
        float r168 = 0.0f;
        float r169 = 0.0f;
        float r170 = 0.0f;
        float r214 = 0.0f;
    L341:
        r160.l();
        switch(r165) {
            case 65: goto L411;
            case 67: goto L403;
            case 72: goto L395;
            case 76: goto L389;
            case 77: goto L374;
            case 81: goto L367;
            case 83: goto L360;
            case 84: goto L353;
            case 86: goto L345;
            case 90: goto L344;
            case 97: goto L411;
            case 99: goto L403;
            case 104: goto L395;
            case 108: goto L389;
            case 109: goto L374;
            case 113: goto L367;
            case 115: goto L360;
            case 116: goto L353;
            case 118: goto L345;
            case 122: goto L344;
            default: goto L456;
        };
    L344:
        r161.a(r159);
        r166 = r170;
        r167 = r166;
        r169 = r214;
    L430:
        r168 = r169;
    L431:
        r160.k();
        if (r160.e() == true) goto L456;
        int r171 = r160.f381191b;
        if (r171 == r160.f381192c) goto L446;
        char r172 = r160.f381190a.charAt(r171);
        if (r172 < 'a') goto L442;
        if (r172 > 'z') goto L442;
    L445:
        boolean r173 = true;
    L447:
        if (r173 == false) goto L453;
        int r174 = r160.f381191b;
        if (r174 != r160.f381192c) goto L451;
        Integer r175 = null;
    L452:
        r165 = r175.intValue();
        goto L453
    L451:
        String r176 = r160.f381190a;
        r160.f381191b = r174 + 1;
        r175 = Integer.valueOf(r176.charAt(r174));
    L453:
        r101 = 0;
        r159 = 8;
    L442:
        if (r172 < 'A') goto L446;
        if (r172 <= 'Z') goto L445;
    L446:
        r173 = false;
        goto L447
    L345:
        r169 = r160.g();
        if (Float.isNaN(r169) == true) goto L456;
        if (r165 != 118) goto L351;
        r169 = r169 + r168;
    L351:
        r161.d(r166, r169);
        goto L430
    L353:
        float r177 = (r166 * 2.0f) - r167;
        float r178 = (2.0f * r168) - r169;
        float r179 = r160.g();
        float r180 = r160.c(r179);
        if (Float.isNaN(r180) == true) goto L456;
        if (r165 != 116) goto L359;
        r179 = r179 + r166;
        r180 = r180 + r168;
    L359:
        float r181 = r180;
        r161.e(r177, r178, r179, r181);
    L410:
        r168 = r181;
        r166 = r179;
        r169 = r178;
        r167 = r177;
        goto L431
    L360:
        float r182 = (r166 * 2.0f) - r167;
        float r183 = (2.0f * r168) - r169;
        float r184 = r160.g();
        float r185 = r160.c(r184);
        float r186 = r160.c(r185);
        float r187 = r160.c(r186);
        if (Float.isNaN(r187) == true) goto L456;
        if (r165 != 115) goto L366;
        r186 = r186 + r166;
        r187 = r187 + r168;
        r184 = r184 + r166;
        r185 = r185 + r168;
    L366:
        float r188 = r184;
        float r215 = r185;
        float r216 = r187;
        r161.c(r182, r183, r188, r215, r186, r216);
        r179 = r186;
        r177 = r188;
        r178 = r215;
        r181 = r216;
        goto L410
    L367:
        float r189 = r160.g();
        float r190 = r160.c(r189);
        float r191 = r160.c(r190);
        float r192 = r160.c(r191);
        if (Float.isNaN(r192) == true) goto L456;
        if (r165 != 113) goto L373;
        r191 = r191 + r166;
        r192 = r192 + r168;
        r189 = r189 + r166;
        r190 = r190 + r168;
    L373:
        r168 = r192;
        float r193 = r190;
        r161.e(r189, r193, r191, r168);
        r177 = r189;
        float r194 = r193;
        r179 = r191;
    L402:
        r178 = r194;
        r181 = r168;
        goto L410
    L374:
        float r195 = r160.g();
        float r196 = r160.c(r195);
        if (Float.isNaN(r196) == true) goto L456;
        if (r165 == 109) goto L379;
    L384:
        r170 = r195;
        r214 = r196;
        r161.a(r101);
        r161.b(2);
        float[] r197 = r161.f381144c;
        int r198 = r161.f381145d;
        int r199 = r198 + 1;
        r197[r198] = r170;
        r161.f381145d = r199 + 1;
        r197[r199] = r214;
        if (r165 != 109) goto L387;
        r165 = 108;
    L388:
        r179 = r170;
        r177 = r179;
        r181 = r214;
        r178 = r181;
        goto L410
    L387:
        r165 = 76;
        goto L388
    L379:
        if (r161.f381143b != 0) goto L381;
        boolean r1100 = true;
    L382:
        if (r1100 == true) goto L384;
        r195 = r195 + r166;
        r196 = r196 + r168;
        goto L384
    L381:
        r1100 = false;
        goto L382
    L389:
        float r200 = r160.g();
        float r201 = r160.c(r200);
        if (Float.isNaN(r201) == true) goto L456;
        if (r165 != 108) goto L394;
        r200 = r200 + r166;
        r201 = r201 + r168;
    L394:
        r166 = r200;
        r169 = r201;
        r161.d(r166, r169);
        r167 = r166;
        goto L430
    L395:
        float r202 = r160.g();
        if (Float.isNaN(r202) == true) goto L456;
        if (r165 != 104) goto L401;
        r202 = r202 + r166;
    L401:
        r161.d(r202, r168);
        r177 = r202;
        r194 = r169;
        r179 = r177;
        goto L402
    L403:
        float r203 = r160.g();
        float r204 = r160.c(r203);
        float r1101 = r160.c(r204);
        float r1102 = r160.c(r1101);
        float r1103 = r160.c(r1102);
        float r1104 = r160.c(r1103);
        if (Float.isNaN(r1104) == true) goto L456;
        if (r165 != 99) goto L409;
        r1103 = r1103 + r166;
        r1104 = r1104 + r168;
        r203 = r203 + r166;
        r204 = r204 + r168;
        r1101 = r1101 + r166;
        r1102 = r1102 + r168;
    L409:
        float r1105 = r204;
        float r205 = r1102;
        float r1106 = r1103;
        float r217 = r1104;
        float r218 = r1101;
        r161.c(r203, r1105, r218, r205, r1106, r217);
        r177 = r218;
        r178 = r205;
        r179 = r1106;
        r181 = r217;
        goto L410
    L411:
        float r206 = r160.g();
        float r207 = r160.c(r206);
        float r1107 = r160.c(r207);
        Boolean r1108 = r160.b(Float.valueOf(r1107));
        Boolean r1109 = r160.b(r1108);
        if (r1109 != null) goto L414;
        float r1110 = Float.NaN;
    L415:
        float r1111 = r160.c(r1110);
        if (Float.isNaN(r1111) == true) goto L456;
        if (r206 < 0.0f) goto L456;
        if (r207 < 0.0f) goto L456;
        if (r165 != 97) goto L425;
        r1110 = r1110 + r166;
        r1111 = r1111 + r168;
    L425:
        r166 = r1110;
        boolean r208 = r1108.booleanValue();
        boolean r1112 = r1109.booleanValue();
        if (r208 == false) goto L428;
        int r209 = 2;
    L429:
        r161.a(((r209 | 4) | (r1112 ? 1 : 0)) == true ? 1 : 0);
        r161.b(5);
        float[] r219 = r161.f381144c;
        int r1113 = r161.f381145d;
        int r1114 = r1113 + 1;
        r219[r1113] = r206;
        int r220 = r1114 + 1;
        r219[r1114] = r207;
        int r221 = r220 + 1;
        r219[r220] = r1107;
        int r222 = r221 + 1;
        r219[r221] = r166;
        r161.f381145d = r222 + 1;
        r219[r222] = r1111;
        r167 = r166;
        r169 = r1111;
        goto L430
    L428:
        r209 = 0;
        goto L429
    L414:
        r160.k();
        r1110 = r160.g();
        goto L415
    L335:
        String r1115 = r160.f381190a;
        r160.f381191b = r162 + 1;
        r163 = Integer.valueOf(r1115.charAt(r162));
    L456:
        r155.f381141i = r161;
    L457:
        r156 = r156 + 1;
        r101 = 0;
        goto L318
    L322:
        if (r158 != 9) goto L457;
        if (Float.valueOf(k(r157)).floatValue() >= 0.0f) goto L457;
        throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
    L458:
        this.f381163b.b(r155);
        return;
    L460:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L461:
        a("<use>", new Object[0]);
        if (this.f381163b == null) goto L495;
        SVG.l0 r223 = new SVG.l0();
        r223.f381102a = this.f381162a;
        r223.f381103b = this.f381163b;
        c(r223, r213);
        f(r223, r213);
        g(r223, r213);
        int r224 = 0;
    L465:
        if (r224 >= r213.getLength()) goto L493;
        String r225 = r213.getValue(r224).trim();
        int r226 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r224)).ordinal()];
        if (r226 != 1) goto L469;
        r223.f381123k = m(r225);
    L492:
        r224 = r224 + 1;
        goto L465
    L469:
        if (r226 == 2) goto L490;
        if (r226 != 3) goto L472;
        SVG.o r227 = m(r225);
        r223.f381125m = r227;
        if (r227.f() == false) goto L492;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L472:
        if (r226 == 4) goto L480;
        if (r226 != 6) goto L492;
        if ("".equals(r213.getURI(r224)) == false) goto L478;
    L479:
        r223.f381122j = r225;
        goto L492
    L478:
        if ("http://www.w3.org/1999/xlink".equals(r213.getURI(r224)) == false) goto L492;
    L480:
        SVG.o r228 = m(r225);
        r223.f381126n = r228;
        if (r228.f() == false) goto L492;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L490:
        r223.f381124l = m(r225);
        goto L492
    L493:
        this.f381163b.b(r223);
        this.f381163b = r223;
        return;
    L495:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L496:
        a("<defs>", new Object[0]);
        if (this.f381163b == null) goto L500;
        SVG.h r229 = new SVG.h();
        r229.f381102a = this.f381162a;
        r229.f381103b = this.f381163b;
        c(r229, r213);
        f(r229, r213);
        g(r229, r213);
        this.f381163b.b(r229);
        this.f381163b = r229;
        return;
    L500:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L501:
        a("<g>", new Object[0]);
        if (this.f381163b == null) goto L505;
        SVG.l r230 = new SVG.l();
        r230.f381102a = this.f381162a;
        r230.f381103b = this.f381163b;
        c(r230, r213);
        f(r230, r213);
        g(r230, r213);
        this.f381163b.b(r230);
        this.f381163b = r230;
        return;
    L505:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L506:
        a("<svg>", new Object[0]);
        SVG.a0 r231 = new SVG.a0();
        r231.f381102a = this.f381162a;
        r231.f381103b = this.f381163b;
        c(r231, r213);
        f(r231, r213);
        h(r231, r213);
        int r232 = 0;
    L508:
        if (r232 >= r213.getLength()) goto L530;
        String r233 = r213.getValue(r232).trim();
        int r234 = a.f381188b[SVGAttr.fromString(r213.getLocalName(r232)).ordinal()];
        if (r234 != 1) goto L512;
        r231.f381072k = m(r233);
    L529:
        r232 = r232 + 1;
        goto L508
    L512:
        if (r234 == 2) goto L527;
        if (r234 != 3) goto L515;
        SVG.o r235 = m(r233);
        r231.f381074m = r235;
        if (r235.f() == false) goto L529;
        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
    L515:
        if (r234 != 4) goto L529;
        SVG.o r236 = m(r233);
        r231.f381075n = r236;
        if (r236.f() == false) goto L529;
        throw new SVGParseException("Invalid <svg> element. height cannot be negative");
    L527:
        r231.f381073l = m(r233);
        goto L529
    L530:
        SVG.c0 r237 = this.f381163b;
        if (r237 != null) goto L533;
        this.f381162a.f381027a = r231;
    L534:
        this.f381163b = r231;
        return;
    L533:
        r237.b(r231);
        goto L534
    L14:
        r100 = r212;
        goto L15
    }
}
