package dgc;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f468561n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Matrix f468562o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f468563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XmlPullParser f468564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f468565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f468566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f468567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f468568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f468569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Deque<Path> f468570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Deque<Matrix> f468571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f468572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f468573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f468574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f468575m;

    static {
        f468561n = f.class.getSimpleName();
        f468562o = new Matrix();
    }

    public final Matrix c() {
        return (Matrix) ((LinkedList) this.f468571i).pop();
    }

    public f(qwc.a r100) {
        this.f468563a = new HashMap();
        this.f468565c = new RectF();
        this.f468566d = 72.0f;
        this.f468567e = false;
        this.f468568f = 0;
        this.f468569g = false;
        this.f468570h = new LinkedList();
        this.f468571i = new LinkedList();
        this.f468575m = null;
        this.f468564b = r100;
    }

    public static d b(InputStream r510) {
        String r100 = f468561n;
        qwc.a r101 = new qwc.a();     // Catch: Exception -> L278
        f r102 = new f(r101);     // Catch: Exception -> L278
        r102.f468566d = 72.0f;     // Catch: Exception -> L278
        r101.setInput(new InputStreamReader(r510));     // Catch: Exception -> L278
        int r103 = r102.f468564b.getEventType();     // Catch: Exception -> L278
        f r104 = r102;
    L4:
        int r105 = 2;
        int r106 = 0;
        boolean r107 = true;
        if (r103 == 2) goto L25;
        if (r103 != 3) goto L27;
        String r108 = r104.f468564b.getName();     // Catch: Exception -> L278
        if (r104.f468569g == false) goto L15;
        if (r108.equals("defs") == false) goto L13;
        r104.f468569g = false;     // Catch: Exception -> L278
    L13:
        f r210 = r102;
    L273:
        r103 = r104.f468564b.next();     // Catch: Exception -> L278
        if (r103 == 1) goto L275;
        r102 = r210;
        goto L4
    L275:
        return r210.f468575m;
    L15:
        if (r108.equals("svg") == false) goto L18;
        Path r109 = (Path) ((LinkedList) r102.f468570h).pop();     // Catch: Exception -> L278
        r102.f468574l = (Path) ((LinkedList) r102.f468570h).peek();     // Catch: Exception -> L278
        r109.transform(r102.c());     // Catch: Exception -> L278
        r104.f468575m = new d(r109, r104.f468572j, r104.f468573k);     // Catch: Exception -> L278
        goto L13
    L18:
        if (r108.equals(ce.f26391f) == false) goto L13;
        if (r104.f468567e == false) goto L24;
        int r110 = r104.f468568f - 1;     // Catch: Exception -> L278
        r104.f468568f = r110;     // Catch: Exception -> L278
        if (r110 != 0) goto L24;
        r104.f468567e = false;     // Catch: Exception -> L278
    L24:
        Path r111 = (Path) ((LinkedList) r102.f468570h).pop();     // Catch: Exception -> L278
        r102.f468574l = (Path) ((LinkedList) r102.f468570h).peek();     // Catch: Exception -> L278
        r111.transform(r102.c());     // Catch: Exception -> L278
        r104.f468574l.addPath(r111);     // Catch: Exception -> L278
    L27:
        String r211 = r100;
        r210 = r102;
    L260:
        r100 = r211;
        goto L273
    L25:
        String r112 = r104.f468564b.getName();     // Catch: Exception -> L278
        if (r104.f468569g == true) goto L27;
        if (r112.equals("svg") == false) goto L45;
        r104.f468572j = Math.round(r104.a("width", r104.f468564b, Float.valueOf(0.0f)).floatValue());     // Catch: Exception -> L278
        r104.f468573k = Math.round(r104.a("height", r104.f468564b, Float.valueOf(0.0f)).floatValue());     // Catch: Exception -> L278
        a r113 = a.a("viewBox", r104.f468564b);     // Catch: Exception -> L278
        Path r114 = new Path();     // Catch: Exception -> L278
        r102.f468574l = r114;     // Catch: Exception -> L278
        ((LinkedList) r102.f468570h).add(r114);     // Catch: Exception -> L278
        Matrix r115 = f468562o;     // Catch: Exception -> L278
        if (r113 == null) goto L43;
        ArrayList<Float> r116 = r113.f468551a;     // Catch: Exception -> L278
        if (r116 == null) goto L43;
        if (r116.size() != 4) goto L43;
        float r117 = r104.f468572j;     // Catch: Exception -> L278
        if (r117 >= 0.1f) goto L39;
    L42:
        r104.f468572j = ((Float) ListProtector.get(r113.f468551a, 2)).floatValue() - ((Float) ListProtector.get(r113.f468551a, 0)).floatValue();     // Catch: Exception -> L278
        r104.f468572j = ((Float) ListProtector.get(r113.f468551a, 3)).floatValue() - ((Float) ListProtector.get(r113.f468551a, 3)).floatValue();     // Catch: Exception -> L278
        goto L43
    L39:
        if (r104.f468573k < (-0.1f)) goto L42;
        r115.setScale(r117 / (((Float) ListProtector.get(r113.f468551a, 2)).floatValue() - ((Float) ListProtector.get(r113.f468551a, 0)).floatValue()), r104.f468573k / (((Float) ListProtector.get(r113.f468551a, 3)).floatValue() - ((Float) ListProtector.get(r113.f468551a, 1)).floatValue()));     // Catch: Exception -> L278
    L43:
        ((LinkedList) r104.f468571i).push(r115);     // Catch: Exception -> L278
        goto L13
    L45:
        if (r112.equals("defs") == false) goto L48;
        r104.f468569g = true;     // Catch: Exception -> L278
        goto L13
    L48:
        if (r112.equals(NameKeys.LoadStrategy_Use) == false) goto L79;
        String r118 = b.b("xlink:href", r104.f468564b);     // Catch: Exception -> L278
        String r119 = b.b("transform", r104.f468564b);     // Catch: Exception -> L278
        String r120 = b.b("x", r104.f468564b);     // Catch: Exception -> L278
        String r121 = b.b("y", r104.f468564b);     // Catch: Exception -> L278
        if (r119 != null) goto L53;
        if (r120 != null) goto L53;
        if (r121 != null) goto L53;
    L62:
        if (r106 >= r104.f468564b.getAttributeCount()) goto L77;
        String r122 = r104.f468564b.getAttributeName(r106);     // Catch: Exception -> L278
        if ("x".equals(r122) == true) goto L76;
        if ("y".equals(r122) == true) goto L76;
        if ("width".equals(r122) == true) goto L76;
        if ("height".equals(r122) == true) goto L76;
        if ("xlink:href".equals(r122) == true) goto L76;
        if ("transform".equals(r122) == true) goto L76;
        b.a(r104.f468564b.getAttributeValue(r106));     // Catch: Exception -> L278
    L76:
        r106 = r106 + 1;     // Catch: Exception -> L278
        goto L62
    L77:
        String r123 = r104.f468563a.get(r118.substring(1));     // Catch: Exception -> L278
    L53:
        if (r119 == null) goto L55;
        b.a(r119);     // Catch: Exception -> L278
    L55:
        if (r120 != null) goto L57;
        if (r121 == null) goto L62;
    L57:
        if (r120 == null) goto L59;
        b.a(r120);     // Catch: Exception -> L278
    L59:
        if (r121 == null) goto L62;
        b.a(r121);     // Catch: Exception -> L278
        goto L62
    L79:
        if (r112.equals(ce.f26391f) == false) goto L90;
        if (r104.f468567e == false) goto L84;
        r104.f468568f++;     // Catch: Exception -> L278
    L84:
        if ("none".equals(b.b("display", r104.f468564b)) == true) goto L86;
    L88:
        r104.d(r104.f468564b);     // Catch: Exception -> L278
        Path r124 = new Path();     // Catch: Exception -> L278
        r102.f468574l = r124;     // Catch: Exception -> L278
        ((LinkedList) r102.f468570h).add(r124);     // Catch: Exception -> L278
        goto L13
    L86:
        if (r104.f468567e == true) goto L88;
        r104.f468567e = true;     // Catch: Exception -> L278
        r104.f468568f = 1;     // Catch: Exception -> L278
        goto L88
    L90:
        if (r104.f468567e == true) goto L101;
        if (r112.equals(SVGRenderEngine.RECT) == false) goto L101;
        Float r125 = r104.a("x", r104.f468564b, Float.valueOf(0.0f));     // Catch: Exception -> L278
        Float r126 = r104.a("y", r104.f468564b, Float.valueOf(0.0f));     // Catch: Exception -> L278
        Float r127 = r104.a("width", r104.f468564b, null);     // Catch: Exception -> L278
        Float r128 = r104.a("height", r104.f468564b, null);     // Catch: Exception -> L278
        Float r129 = r104.a("rx", r104.f468564b, Float.valueOf(0.0f));     // Catch: Exception -> L278
        Float r130 = r104.a("ry", r104.f468564b, Float.valueOf(0.0f));     // Catch: Exception -> L278
        Path r131 = new Path();     // Catch: Exception -> L278
        if (r129.floatValue() <= 0.0f) goto L96;
    L98:
        r104.f468565c.set(r125.floatValue(), r126.floatValue(), r125.floatValue() + r127.floatValue(), r126.floatValue() + r128.floatValue());     // Catch: Exception -> L278
        r131.addRoundRect(r104.f468565c, r129.floatValue(), r130.floatValue(), Path.Direction.CW);     // Catch: Exception -> L278
    L99:
        r104.d(r104.f468564b);     // Catch: Exception -> L278
        r131.transform(r102.c());     // Catch: Exception -> L278
        r104.f468574l.addPath(r131);     // Catch: Exception -> L278
        goto L13
    L96:
        if (r130.floatValue() > 0.0f) goto L98;
        r131.addRect(r125.floatValue(), r126.floatValue(), r125.floatValue() + r127.floatValue(), r126.floatValue() + r128.floatValue(), Path.Direction.CW);     // Catch: Exception -> L278
    L101:
        if (r104.f468567e == true) goto L106;
        if (r112.equals("line") == false) goto L106;
        Float r132 = r104.a("x1", r104.f468564b, null);     // Catch: Exception -> L278
        Float r133 = r104.a("x2", r104.f468564b, null);     // Catch: Exception -> L278
        Float r134 = r104.a("y1", r104.f468564b, null);     // Catch: Exception -> L278
        Float r135 = r104.a("y2", r104.f468564b, null);     // Catch: Exception -> L278
        Path r136 = new Path();     // Catch: Exception -> L278
        r136.moveTo(r132.floatValue(), r134.floatValue());     // Catch: Exception -> L278
        r136.lineTo(r133.floatValue(), r135.floatValue());     // Catch: Exception -> L278
        r104.d(r104.f468564b);     // Catch: Exception -> L278
        r136.transform(r102.c());     // Catch: Exception -> L278
        r104.f468574l.addPath(r136);     // Catch: Exception -> L278
    L106:
        if (r104.f468567e == true) goto L115;
        if (r112.equals(SVGRenderEngine.CIRCLE) == false) goto L115;
        Float r137 = r104.a("cx", r104.f468564b, null);     // Catch: Exception -> L278
        Float r138 = r104.a("cy", r104.f468564b, null);     // Catch: Exception -> L278
        Float r139 = r104.a("r", r104.f468564b, null);     // Catch: Exception -> L278
        if (r137 == null) goto L13;
        if (r138 == null) goto L13;
        if (r139 == null) goto L13;
        Path r140 = new Path();     // Catch: Exception -> L278
        r140.addCircle(r137.floatValue(), r138.floatValue(), r139.floatValue(), Path.Direction.CW);     // Catch: Exception -> L278
        r104.d(r104.f468564b);     // Catch: Exception -> L278
        r140.transform(r102.c());     // Catch: Exception -> L278
        r104.f468574l.addPath(r140);     // Catch: Exception -> L278
    L115:
        if (r104.f468567e == true) goto L125;
        if (r112.equals(SVGRenderEngine.ELLIPSE) == false) goto L125;
        Float r141 = r104.a("cx", r104.f468564b, null);     // Catch: Exception -> L278
        Float r142 = r104.a("cy", r104.f468564b, null);     // Catch: Exception -> L278
        Float r143 = r104.a("rx", r104.f468564b, null);     // Catch: Exception -> L278
        Float r144 = r104.a("ry", r104.f468564b, null);     // Catch: Exception -> L278
        if (r141 == null) goto L13;
        if (r142 == null) goto L13;
        if (r143 == null) goto L13;
        if (r144 == null) goto L13;
        r104.f468565c.set(r141.floatValue() - r143.floatValue(), r142.floatValue() - r144.floatValue(), r141.floatValue() + r143.floatValue(), r142.floatValue() + r144.floatValue());     // Catch: Exception -> L278
        Path r145 = new Path();     // Catch: Exception -> L278
        r145.addOval(r104.f468565c, Path.Direction.CW);     // Catch: Exception -> L278
        r104.d(r104.f468564b);     // Catch: Exception -> L278
        r145.transform(r102.c());     // Catch: Exception -> L278
        r104.f468574l.addPath(r145);     // Catch: Exception -> L278
    L125:
        if (r104.f468567e == true) goto L144;
        if (r112.equals(SVGRenderEngine.POLYGON) == false) goto L129;
    L130:
        a r146 = a.a("points", r104.f468564b);     // Catch: Exception -> L278
        if (r146 == null) goto L13;
        Path r147 = new Path();     // Catch: Exception -> L278
        ArrayList<Float> r148 = r146.f468551a;     // Catch: Exception -> L278
        if (r148.size() <= 1) goto L13;
        r147.moveTo(((Float) ListProtector.get(r148, 0)).floatValue(), ((Float) ListProtector.get(r148, 1)).floatValue());     // Catch: Exception -> L278
    L136:
        if (r105 >= r148.size()) goto L139;
        r147.lineTo(((Float) ListProtector.get(r148, r105)).floatValue(), ((Float) ListProtector.get(r148, r105 + 1)).floatValue());     // Catch: Exception -> L173
        r105 = r105 + 2;     // Catch: Exception -> L173
    L173:
        e = e;
        String r212 = r100;
    L267:
        r100 = r212;
    L279:
        Log.w(r100, "Parse error: " + e);
        throw new RuntimeException(e);
    L139:
        if (r112.equals(SVGRenderEngine.POLYGON) == false) goto L141;
        r147.close();     // Catch: Exception -> L173
    L141:
        r104.d(r104.f468564b);     // Catch: Exception -> L173
        r147.transform(r102.c());     // Catch: Exception -> L173
        r104.f468574l.addPath(r147);     // Catch: Exception -> L173
        goto L13
    L129:
        if (r112.equals(SVGRenderEngine.POLYLINE) == true) goto L130;
    L144:
        if (r104.f468567e == false) goto L146;
    L256:
        r211 = r100;
        r210 = r102;
        if (r104.f468567e == true) goto L262;
        if (r112.equals("metadata") == true) goto L260;
    L262:
        if (r104.f468567e == true) goto L260;
        Object[] r149 = new Object[2];     // Catch: Exception -> L271
        r149[0] = r112;     // Catch: Exception -> L271
        XmlPullParser r150 = r104.f468564b;     // Catch: Exception -> L271
        String r151 = "";
        int r152 = 0;
    L265:
        if (r152 >= r150.getAttributeCount()) goto L268;
        r151 = r151 + " " + r150.getAttributeName(r152) + "='" + r150.getAttributeValue(r152) + "'";     // Catch: Exception -> L271
        r152 = r152 + 1;     // Catch: Exception -> L271
        goto L265
    L268:
        r149[1] = r151;     // Catch: Exception -> L271
        String r153 = String.format("Unrecognized tag: %s (%s)", r149);     // Catch: Exception -> L271
        r100 = r211;
        Log.d(r100, r153);     // Catch: Exception -> L278
        goto L273
    L146:
        if (r112.equals("path") == false) goto L256;
        String r154 = b.b("d", r104.f468564b);     // Catch: Exception -> L278
        String r155 = e.f468560a;     // Catch: Exception -> L278
        int r156 = r154.length();     // Catch: Exception -> L278
        c r157 = new c(r154);     // Catch: Exception -> L278
        r157.d();     // Catch: Exception -> L278
        Path r158 = new Path();     // Catch: Exception -> L278
        RectF r159 = new RectF();     // Catch: Exception -> L278
        char r160 = Permission.EXECUTE;
        float r161 = 0.0f;
        float r162 = 0.0f;
        float r163 = 0.0f;
        float r164 = 0.0f;
        float r213 = 0.0f;
        float r214 = 0.0f;
    L148:
        int r165 = r157.f468555c;     // Catch: Exception -> L278
        if (r165 >= r156) goto L255;
        char r166 = r154.charAt(r165);     // Catch: Exception -> L278
        if (Character.isDigit(r166) == true) goto L159;
        if (r166 == '.') goto L159;
        if (r166 == '-') goto L159;
        r157.f468553a = r157.b();     // Catch: Exception -> L173
        r160 = r166;
    L163:
        r158.computeBounds(r159, r107);     // Catch: Exception -> L173
        switch(r160) {
            case 65: goto L211;
            case 67: goto L205;
            case 72: goto L200;
            case 76: goto L194;
            case 77: goto L189;
            case 81: goto L184;
            case 83: goto L180;
            case 84: goto L176;
            case 86: goto L170;
            case 90: goto L169;
            case 97: goto L211;
            case 99: goto L205;
            case 104: goto L200;
            case 108: goto L194;
            case 109: goto L189;
            case 113: goto L184;
            case 115: goto L180;
            case 116: goto L176;
            case 118: goto L170;
            case 122: goto L169;
            default: goto L166;
        };
    L166:
        r212 = r100;
        c r215 = r157;
        Path r167 = r158;
        char r410 = r160;
        String r168 = e.f468560a;     // Catch: Exception -> L271
        StringBuilder r169 = new StringBuilder("Invalid path command: ");     // Catch: Exception -> L271
        char r170 = r410;
        r169.append(r170);     // Catch: Exception -> L271
        Log.w(r168, r169.toString());     // Catch: Exception -> L271
        c r171 = r215;
        r171.f468553a = r215.b();     // Catch: Exception -> L271
    L251:
        r163 = r163;
        r162 = r162;
        boolean r172 = false;
    L252:
        if (r172 == true) goto L254;
        r163 = r161;
        r162 = r164;
    L254:
        r171.d();     // Catch: Exception -> L271
        r157 = r171;
        r160 = r170;
        r158 = r167;
        r154 = r154;
        r159 = r159;
        r156 = r156;
        r100 = r212;
        r102 = r102;
        r104 = r102;
        r107 = true;
    L271:
        e = e;
        goto L267
    L169:
        r158.close();     // Catch: Exception -> L173
        r212 = r100;
        r171 = r157;
        r167 = r158;
        r170 = r160;
        r164 = r213;
        r161 = r214;
        goto L251
    L170:
        float r173 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'v') goto L175;
        r158.rLineTo(0.0f, r173);     // Catch: Exception -> L173
        r161 = r161 + r173;     // Catch: Exception -> L173
    L204:
        r212 = r100;
        r171 = r157;
        r167 = r158;
        r170 = r160;
        goto L251
    L175:
        r158.lineTo(r164, r173);     // Catch: Exception -> L173
        r161 = r173;
        goto L204
    L176:
        float r174 = r157.a();     // Catch: Exception -> L173
        float r175 = r157.a();     // Catch: Exception -> L173
        if (r160 != 't') goto L179;
        r174 = r174 + r164;     // Catch: Exception -> L173
        r175 = r175 + r161;     // Catch: Exception -> L173
    L179:
        float r176 = (r164 * 2.0f) - r162;     // Catch: Exception -> L173
        float r177 = (2.0f * r161) - r163;     // Catch: Exception -> L173
        r158.cubicTo(r164, r161, r176, r177, r174, r175);     // Catch: Exception -> L173
    L209:
        r163 = r177;
        r162 = r176;
        float r178 = r175;
        float r179 = r174;
    L210:
        r154 = r154;
        r212 = r100;
        r102 = r102;
        r161 = r178;
        r156 = r156;
        r171 = r157;
        r167 = r158;
        r159 = r159;
        r170 = r160;
        r164 = r179;
        r172 = true;
        goto L252
    L180:
        float r180 = r157.a();     // Catch: Exception -> L173
        float r181 = r157.a();     // Catch: Exception -> L173
        r179 = r157.a();     // Catch: Exception -> L173
        float r182 = r157.a();     // Catch: Exception -> L173
        if (r160 != 's') goto L183;
        r180 = r180 + r164;     // Catch: Exception -> L173
        r179 = r179 + r164;     // Catch: Exception -> L173
        r181 = r181 + r161;     // Catch: Exception -> L173
        r182 = r182 + r161;     // Catch: Exception -> L173
    L183:
        r178 = r182;
        float r183 = (r161 * 2.0f) - r163;     // Catch: Exception -> L173
        r158.cubicTo((r164 * 2.0f) - r162, r183, r180, r181, r179, r178);     // Catch: Exception -> L173
    L188:
        r162 = r180;
        r163 = r181;
        goto L210
    L184:
        float r184 = r157.a();     // Catch: Exception -> L173
        float r185 = r157.a();     // Catch: Exception -> L173
        float r186 = r157.a();     // Catch: Exception -> L173
        float r187 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'q') goto L187;
        r186 = r186 + r164;     // Catch: Exception -> L173
        r187 = r187 + r161;     // Catch: Exception -> L173
        r184 = r184 + r164;     // Catch: Exception -> L173
        r185 = r185 + r161;     // Catch: Exception -> L173
    L187:
        r179 = r186;
        r181 = r185;
        r180 = r184;
        r178 = r187;
        r158.cubicTo(r164, r161, r180, r181, r179, r178);     // Catch: Exception -> L173
        goto L188
    L189:
        float r188 = r157.a();     // Catch: Exception -> L173
        float r189 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'm') goto L192;
        r158.rMoveTo(r188, r189);     // Catch: Exception -> L173
        r164 = r164 + r188;     // Catch: Exception -> L173
        r214 = r161 + r189;     // Catch: Exception -> L173
    L193:
        r213 = r164;
        r161 = r214;
        goto L204
    L192:
        r158.moveTo(r188, r189);     // Catch: Exception -> L173
        r164 = r188;
        r214 = r189;
        goto L193
    L194:
        float r190 = r157.a();     // Catch: Exception -> L173
        float r191 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'l') goto L197;
        r158.rLineTo(r190, r191);     // Catch: Exception -> L173
        r190 = r190 + r164;     // Catch: Exception -> L173
        r191 = r191 + r161;     // Catch: Exception -> L173
    L198:
        r164 = r190;
        r161 = r191;
        goto L204
    L197:
        r158.lineTo(r190, r191);     // Catch: Exception -> L173
        goto L198
    L200:
        float r192 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'h') goto L203;
        r158.rLineTo(r192, 0.0f);     // Catch: Exception -> L173
        r164 = r164 + r192;     // Catch: Exception -> L173
        goto L204
    L203:
        r158.lineTo(r192, r161);     // Catch: Exception -> L173
        r164 = r192;
        goto L204
    L205:
        float r193 = r157.a();     // Catch: Exception -> L173
        float r194 = r157.a();     // Catch: Exception -> L173
        float r195 = r157.a();     // Catch: Exception -> L173
        float r196 = r157.a();     // Catch: Exception -> L173
        float r197 = r157.a();     // Catch: Exception -> L173
        float r198 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'c') goto L208;
        r193 = r193 + r164;     // Catch: Exception -> L173
        r195 = r195 + r164;     // Catch: Exception -> L173
        r197 = r197 + r164;     // Catch: Exception -> L173
        r194 = r194 + r161;     // Catch: Exception -> L173
        r196 = r196 + r161;     // Catch: Exception -> L173
        r198 = r198 + r161;     // Catch: Exception -> L173
    L208:
        float r199 = r193;
        r177 = r196;
        r174 = r197;
        r175 = r198;
        float r1100 = r194;
        r176 = r195;
        r158.cubicTo(r199, r1100, r176, r177, r174, r175);     // Catch: Exception -> L173
        goto L209
    L211:
        float r200 = r157.a();     // Catch: Exception -> L173
        float r201 = r157.a();     // Catch: Exception -> L173
        float r202 = r157.a();     // Catch: Exception -> L173
        int r1101 = (int) r157.a();     // Catch: Exception -> L173
        int r203 = (int) r157.a();     // Catch: Exception -> L173
        float r1102 = r157.a();     // Catch: Exception -> L173
        float r1103 = r157.a();     // Catch: Exception -> L173
        if (r160 != 'a') goto L215;
        r1102 = r1102 + r164;
        r1103 = r1103 + r161;
    L215:
        float r204 = r1102;
        float r205 = r1103;
        double r1104 = r164;
        double r1105 = r161;
        r212 = r100;
        double r206 = r204;
        c r216 = r157;
        double r207 = r205;
        Path r217 = r158;
        double r208 = r200;
        double r209 = r201;
        double r218 = r202;
        if (r1101 != 1) goto L218;
        boolean r1106 = true;
    L219:
        if (r203 != 1) goto L221;
        boolean r219 = true;
    L222:
        double r310 = (r1104 - r206) / 2.0d;
        double r311 = (r1105 - r207) / 2.0d;
        double r220 = Math.toRadians(r218 % 360.0d);     // Catch: Exception -> L271
        double r312 = Math.cos(r220);     // Catch: Exception -> L271
        double r221 = Math.sin(r220);     // Catch: Exception -> L271
        double r222 = (r312 * r310) + (r221 * r311);     // Catch: Exception -> L271
        char r223 = r160;
        double r1107 = ((-r221) * r310) + (r311 * r312);     // Catch: Exception -> L271
        double r224 = Math.abs(r208);     // Catch: Exception -> L271
        double r225 = Math.abs(r209);     // Catch: Exception -> L271
        double r313 = r224 * r224;     // Catch: Exception -> L271
        double r314 = r225 * r225;     // Catch: Exception -> L271
        double r411 = r222 * r222;     // Catch: Exception -> L271
        double r412 = r1107 * r1107;     // Catch: Exception -> L271
        double r413 = (r411 / r313) + (r412 / r314);     // Catch: Exception -> L271
        double r511 = 1.0d;
        if (r413 <= 1.0d) goto L227;
        r224 = r224 * Math.sqrt(r413);     // Catch: Exception -> L271
        r225 = r225 * Math.sqrt(r413);     // Catch: Exception -> L271
        r313 = r224 * r224;     // Catch: Exception -> L271
        r314 = r225 * r225;     // Catch: Exception -> L271
    L227:
        if (r1106 != r219) goto L229;
        double r1108 = -1.0d;
    L230:
        double r512 = r313 * r314;     // Catch: Exception -> L271
        double r315 = r313 * r412;     // Catch: Exception -> L271
        double r316 = r314 * r411;     // Catch: Exception -> L271
        double r513 = ((r512 - r315) - r316) / (r315 + r316);     // Catch: Exception -> L271
        if (r513 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L233;
        r513 = 0.0d;
    L233:
        double r1109 = r1108 * Math.sqrt(r513);     // Catch: Exception -> L271
        double r317 = ((r224 * r1107) / r225) * r1109;     // Catch: Exception -> L271
        double r514 = r225;
        double r1110 = r1109 * (-((r225 * r222) / r224));     // Catch: Exception -> L271
        double r1111 = ((r1104 + r206) / 2.0d) + ((r312 * r317) - (r221 * r1110));     // Catch: Exception -> L271
        double r226 = ((r1105 + r207) / 2.0d) + ((r221 * r317) + (r312 * r1110));     // Catch: Exception -> L271
        double r227 = (r222 - r317) / r224;     // Catch: Exception -> L271
        double r228 = (r1107 - r1110) / r514;     // Catch: Exception -> L271
        double r229 = ((-r222) - r317) / r224;     // Catch: Exception -> L271
        double r230 = ((-r1107) - r1110) / r514;     // Catch: Exception -> L271
        double r1112 = (r227 * r227) + (r228 * r228);     // Catch: Exception -> L271
        double r318 = Math.sqrt(r1112);     // Catch: Exception -> L271
        if (r228 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L236;
        double r319 = -1.0d;
    L237:
        double r320 = Math.toDegrees(r319 * Math.acos(r227 / r318));     // Catch: Exception -> L271
        double r1113 = Math.sqrt(r1112 * ((r229 * r229) + (r230 * r230)));     // Catch: Exception -> L271
        double r321 = (r227 * r229) + (r228 * r230);     // Catch: Exception -> L271
        if (((r227 * r230) - (r228 * r229)) >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L240;
        r511 = -1.0d;
    L240:
        double r231 = Math.toDegrees(r511 * Math.acos(r321 / r1113));     // Catch: Exception -> L271
        if (r219 == false) goto L243;
    L245:
        if (r219 == true) goto L247;
    L249:
        r167 = r217;
        r167.addArc(new RectF((float) (r1111 - r224), (float) (r226 - r514), (float) (r1111 + r224), (float) (r226 + r514)), (float) (r320 % 360.0d), (float) (r231 % 360.0d));     // Catch: Exception -> L271
        r171 = r216;
        r164 = r204;
        r161 = r205;
        r170 = r223;
        goto L251
    L247:
        if (r231 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L249;
        r231 = r231 + 360.0d;     // Catch: Exception -> L271
        goto L249
    L243:
        if (r231 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L245;
        r231 = r231 - 360.0d;     // Catch: Exception -> L271
        goto L249
    L236:
        r319 = 1.0d;
        goto L237
    L229:
        r1108 = 1.0d;
        goto L230
    L221:
        r219 = false;
        goto L222
    L218:
        r1106 = false;
    L159:
        if (r160 != 'M') goto L161;
        r160 = org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_RANDOM_LT;
        goto L163
    L161:
        if (r160 != 'm') goto L163;
        r160 = Symlink.UNIX_ID;
        goto L163
    L255:
        r211 = r100;
        r210 = r102;
        Path r232 = r158;
        r104.d(r104.f468564b);     // Catch: Exception -> L271
        r232.transform(r210.c());     // Catch: Exception -> L271
        r104.f468574l.addPath(r232);     // Catch: Exception -> L271
    L278:
        e = e;
        goto L279
    }

    public final void d(XmlPullParser r110) {
        String r111 = b.b("transform", r110);
        if (r111 != null) goto L5;
        Matrix r112 = f468562o;
    L54:
        ((LinkedList) this.f468571i).push(r112);
        return;
    L5:
        String r100 = g.f468576a;
        Matrix r101 = new Matrix();
    L6:
        float r102 = 0.0f;
        if (r111.startsWith("matrix(") == false) goto L12;
        a r103 = a.b(r111.substring(7));
        if (r103.f468551a.size() != 6) goto L48;
        Matrix r104 = new Matrix();
        r104.setValues(new float[]{((Float) ListProtector.get(r103.f468551a, 0)).floatValue(), ((Float) ListProtector.get(r103.f468551a, 2)).floatValue(), ((Float) ListProtector.get(r103.f468551a, 4)).floatValue(), ((Float) ListProtector.get(r103.f468551a, 1)).floatValue(), ((Float) ListProtector.get(r103.f468551a, 3)).floatValue(), ((Float) ListProtector.get(r103.f468551a, 5)).floatValue(), 0.0f, 0.0f, 1.0f});
        r101.preConcat(r104);
    L48:
        int r105 = r111.indexOf(")");
        if (r105 <= 0) goto L53;
        int r106 = r105 + 1;
        if (r111.length() <= r106) goto L53;
        r111 = r111.substring(r106).replaceFirst("[\\s,]*", "");
    L53:
        r112 = r101;
        goto L54
    L12:
        if (r111.startsWith("translate(") == false) goto L20;
        a r107 = a.b(r111.substring(10));
        if (r107.f468551a.size() <= 0) goto L48;
        float r108 = ((Float) ListProtector.get(r107.f468551a, 0)).floatValue();
        if (r107.f468551a.size() <= 1) goto L18;
        r102 = ((Float) ListProtector.get(r107.f468551a, 1)).floatValue();
    L18:
        r101.preTranslate(r108, r102);
        goto L48
    L20:
        if (r111.startsWith("scale(") == false) goto L29;
        a r109 = a.b(r111.substring(6));
        if (r109.f468551a.size() <= 0) goto L48;
        float r113 = ((Float) ListProtector.get(r109.f468551a, 0)).floatValue();
        if (r109.f468551a.size() <= 1) goto L26;
        float r114 = ((Float) ListProtector.get(r109.f468551a, 1)).floatValue();
    L27:
        r101.preScale(r113, r114);
        goto L48
    L26:
        r114 = r113;
        goto L27
    L29:
        if (r111.startsWith("skewX(") == false) goto L34;
        a r115 = a.b(r111.substring(6));
        if (r115.f468551a.size() <= 0) goto L48;
        r101.preSkew((float) Math.tan(((Float) ListProtector.get(r115.f468551a, 0)).floatValue()), 0.0f);
        goto L48
    L34:
        if (r111.startsWith("skewY(") == false) goto L39;
        a r116 = a.b(r111.substring(6));
        if (r116.f468551a.size() <= 0) goto L48;
        r101.preSkew(0.0f, (float) Math.tan(((Float) ListProtector.get(r116.f468551a, 0)).floatValue()));
        goto L48
    L39:
        if (r111.startsWith("rotate(") == false) goto L47;
        a r117 = a.b(r111.substring(7));
        if (r117.f468551a.size() <= 0) goto L48;
        float r118 = ((Float) ListProtector.get(r117.f468551a, 0)).floatValue();
        if (r117.f468551a.size() <= 2) goto L45;
        r102 = ((Float) ListProtector.get(r117.f468551a, 1)).floatValue();
        float r119 = ((Float) ListProtector.get(r117.f468551a, 2)).floatValue();
    L46:
        r101.preTranslate(r102, r119);
        r101.preRotate(r118);
        r101.preTranslate(-r102, -r119);
        goto L48
    L45:
        r119 = 0.0f;
        goto L46
    L47:
        Log.w(g.f468576a, "Invalid transform (" + r111 + ")");
        goto L48
    }

    public final Float a(String r100, XmlPullParser r101, Float r102) {
        float r103 = this.f468566d;
        float r104 = this.f468572j;
        float r105 = this.f468573k;
        String r106 = b.b(r100, r101);
        if (r106 != null) goto L6;
        Float r107 = null;
    L40:
        if (r107 != null) goto L43;
        return r102;
    L43:
        return r107;
    L6:
        if (r106.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L9;
        r107 = Float.valueOf(CastFloatProtector.parseFloat(r106.substring(0, r106.length() - 2)));
        goto L40
    L9:
        if (r106.endsWith(GXTemplateKey.GAIAX_PT) == false) goto L12;
        r107 = Float.valueOf((CastFloatProtector.valueOf(r106.substring(0, r106.length() - 2)).floatValue() * r103) / 72.0f);
        goto L40
    L12:
        if (r106.endsWith(BackupSeiMessage.SOURCE_PC) == false) goto L15;
        r107 = Float.valueOf((CastFloatProtector.valueOf(r106.substring(0, r106.length() - 2)).floatValue() * r103) / 6.0f);
        goto L40
    L15:
        if (r106.endsWith("cm") == false) goto L18;
        r107 = Float.valueOf((CastFloatProtector.valueOf(r106.substring(0, r106.length() - 2)).floatValue() * r103) / 2.54f);
        goto L40
    L18:
        if (r106.endsWith("mm") == false) goto L21;
        r107 = Float.valueOf((CastFloatProtector.valueOf(r106.substring(0, r106.length() - 2)).floatValue() * r103) / 254.0f);
        goto L40
    L21:
        if (r106.endsWith("in") == false) goto L24;
        r107 = Float.valueOf(CastFloatProtector.valueOf(r106.substring(0, r106.length() - 2)).floatValue() * r103);
        goto L40
    L24:
        if (r106.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L39;
        Float r108 = CastFloatProtector.valueOf(r106.substring(0, r106.length() - 1));
        if (r100.contains("x") == false) goto L28;
    L37:
        float r109 = r104 / 100.0f;
    L38:
        r107 = Float.valueOf(r108.floatValue() * r109);
        goto L40
    L28:
        if (r100.equals("width") == true) goto L37;
        if (r100.contains("y") == false) goto L33;
    L36:
        r109 = r105 / 100.0f;
        goto L38
    L33:
        if (r100.equals("height") == true) goto L36;
        r109 = (r105 + r104) / 2.0f;
        goto L38
    L39:
        r107 = CastFloatProtector.valueOf(r106);
        goto L40
    }
}
