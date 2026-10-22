package org.jsoup.parser;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.platform.api.creation.TplType;
import com.larus.trace.CopyContentTypeString;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public final class f implements Cloneable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, f> f526027j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f526028k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f526029l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f526030m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f526031n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f526032o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f526033p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f526034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f526036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f526037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f526038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f526039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f526040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f526041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f526042i;

    static {
        f526027j = new HashMap();
        String[] r100 = {"html", "head", ContainerPosition.BODY, "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", ContainerPosition.FOOTER, "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", TeaEventTrack.ACTION_DRAMA_PRE, "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, "dd", "li", CopyContentTypeString.TABLE, "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", TplType.MENU, "plaintext", ThumbGlideUrl.SOURCE_TEMPLATE, "article", PullConfiguration.PROCESS_NAME_MAIN, "svg", "math", "center", ThumbGlideUrl.SOURCE_TEMPLATE, MapBundleKey.MapObjKey.OBJ_DIR, "applet", "marquee", "listing"};
        f526028k = new String[]{"object", "base", LynxResourceModule.FONT_TYPE, "tt", RXScreenCaptureService.KEY_INDEX, "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "img", SRStrategy.MEDIAINFO_KEY_BITRATE, "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", BdpAppEventConstant.PARAMS_OUTPUT, "progress", "meter", "area", "param", "source", GXTemplateKey.GAIAX_TRACK, "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", GXTemplateKey.GAIAX_TRACK, "data", "bdi", "s", "strike", "nobr"};
        f526029l = new String[]{"meta", "link", "base", "frame", "img", SRStrategy.MEDIAINFO_KEY_BITRATE, "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", GXTemplateKey.GAIAX_TRACK};
        f526030m = new String[]{"title", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "p", "h1", "h2", "h3", "h4", "h5", "h6", TeaEventTrack.ACTION_DRAMA_PRE, "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        f526031n = new String[]{TeaEventTrack.ACTION_DRAMA_PRE, "plaintext", "title", "textarea"};
        f526032o = new String[]{"button", "fieldset", "input", "keygen", "object", BdpAppEventConstant.PARAMS_OUTPUT, "select", "textarea"};
        f526033p = new String[]{"input", "keygen", "object", "select", "textarea"};
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        f r104 = new f(r100[r103]);
        Map<String, f> r105 = f526027j;
        HashMap r106 = (HashMap) r105;
        r106.put(r104.f526034a, r104);
        r103 = r103 + 1;
        goto L3
    L5:
        String[] r107 = f526028k;
        int r108 = r107.length;
        int r109 = 0;
    L6:
        if (r109 >= r108) goto L8;
        f r110 = new f(r107[r109]);
        r110.f526036c = false;
        r110.f526037d = false;
        Map<String, f> r111 = f526027j;
        HashMap r112 = (HashMap) r111;
        r112.put(r110.f526034a, r110);
        r109 = r109 + 1;
        goto L6
    L8:
        String[] r113 = f526029l;
        int r114 = r113.length;
        int r115 = 0;
    L10:
        if (r115 >= r114) goto L12;
        String r116 = r113[r115];
        f r117 = (f) ((HashMap) f526027j).get(r116);
        ewc.b.d(r117);
        r117.f526038e = true;
        r115 = r115 + 1;
        goto L10
    L12:
        String[] r118 = f526030m;
        int r119 = r118.length;
        int r120 = 0;
    L13:
        if (r120 >= r119) goto L15;
        String r121 = r118[r120];
        f r122 = (f) ((HashMap) f526027j).get(r121);
        ewc.b.d(r122);
        r122.f526037d = false;
        r120 = r120 + 1;
        goto L13
    L15:
        String[] r123 = f526031n;
        int r124 = r123.length;
        int r125 = 0;
    L16:
        if (r125 >= r124) goto L18;
        String r126 = r123[r125];
        f r127 = (f) ((HashMap) f526027j).get(r126);
        ewc.b.d(r127);
        r127.f526040g = true;
        r125 = r125 + 1;
        goto L16
    L18:
        String[] r128 = f526032o;
        int r129 = r128.length;
        int r130 = 0;
    L19:
        if (r130 >= r129) goto L21;
        String r131 = r128[r130];
        f r132 = (f) ((HashMap) f526027j).get(r131);
        ewc.b.d(r132);
        r132.f526041h = true;
        r130 = r130 + 1;
        goto L19
    L21:
        String[] r133 = f526033p;
        int r134 = r133.length;
    L22:
        if (r102 >= r134) goto L24;
        String r135 = r133[r102];
        f r136 = (f) ((HashMap) f526027j).get(r135);
        ewc.b.d(r136);
        r136.f526042i = true;
        r102 = r102 + 1;
        goto L22
    }

    public final int hashCode() {
        return (((((((((((((this.f526034a.hashCode() * 31) + (this.f526036c ? 1 : 0)) * 31) + (this.f526037d ? 1 : 0)) * 31) + (this.f526038e ? 1 : 0)) * 31) + (this.f526039f ? 1 : 0)) * 31) + (this.f526040g ? 1 : 0)) * 31) + (this.f526041h ? 1 : 0)) * 31) + (this.f526042i ? 1 : 0);
    }

    public final Object clone() throws CloneNotSupportedException {
        return (f) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final String toString() {
        return this.f526034a;
    }

    public f(String r100) {
        this.f526036c = true;
        this.f526037d = true;
        this.f526038e = false;
        this.f526039f = false;
        this.f526040g = false;
        this.f526041h = false;
        this.f526042i = false;
        this.f526034a = r100;
        this.f526035b = fwc.a.a(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f526034a.equals(r101.f526034a) == true) goto L12;
        return false;
    L12:
        if (this.f526038e == r101.f526038e) goto L15;
        return false;
    L15:
        if (this.f526037d == r101.f526037d) goto L18;
        return false;
    L18:
        if (this.f526036c == r101.f526036c) goto L21;
        return false;
    L21:
        if (this.f526040g == r101.f526040g) goto L24;
        return false;
    L24:
        if (this.f526039f == r101.f526039f) goto L27;
        return false;
    L27:
        if (this.f526041h == r101.f526041h) goto L30;
        return false;
    L30:
        if (this.f526042i == r101.f526042i) goto L34;
        return false;
    L34:
        return true;
    }

    public static f a(String r100, d r101) {
        ewc.b.d(r100);
        HashMap r102 = (HashMap) f526027j;
        f r103 = (f) r102.get(r100);
        if (r103 != null) goto L23;
        r101.getClass();
        String r104 = r100.trim();
        if (r101.f526022a == true) goto L7;
        r104 = fwc.a.a(r104);
    L7:
        ewc.b.b(r104);
        String r105 = fwc.a.a(r104);
        f r106 = (f) r102.get(r105);
        if (r106 != null) goto L11;
        f r107 = new f(r104);
        r107.f526036c = false;
        return r107;
    L11:
        if (r101.f526022a == false) goto L20;
        if (r104.equals(r105) == true) goto L20;
        f r108 = (f) super.clone();     // Catch: CloneNotSupportedException -> L16
        r108.f526034a = r104;
        return r108;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L20:
        return r106;
    L23:
        return r103;
    }
}
