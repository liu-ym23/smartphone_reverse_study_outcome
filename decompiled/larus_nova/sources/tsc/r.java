package tsc;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import io.noties.markwon.html.jsoup.parser.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class r extends q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f547468j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f547469k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f547470l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f547471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a0> f547472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f547473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f547474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f547475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<m.b> f547476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m.a f547477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f547478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f547479i;

    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f547480a = null;

        static {
            int[] r100 = new int[Token.TokenType.values().length];
            f547480a = r100;
            r100[Token.TokenType.StartTag.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f547480a[Token.TokenType.EndTag.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f547480a[Token.TokenType.Character.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f547468j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "abbr", "acronym", "b", "bdo", "big", SRStrategy.MEDIAINFO_KEY_BITRATE, "button", "cite", "code", "dfn", "em", RXScreenCaptureService.KEY_INDEX, "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", "time", "tt", "var"})));
        f547469k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"area", "base", SRStrategy.MEDIAINFO_KEY_BITRATE, "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", GXTemplateKey.GAIAX_TRACK, "wbr"})));
        f547470l = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, "fieldset", "figcaption", "figure", ContainerPosition.FOOTER, "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", PullConfiguration.PROCESS_NAME_MAIN, "nav", "noscript", "ol", BdpAppEventConstant.PARAMS_OUTPUT, "p", TeaEventTrack.ACTION_DRAMA_PRE, "section", CopyContentTypeString.TABLE, "tfoot", "ul", "video"})));
    }

    public static Map<String, String> a(Token.g r100) {
        io.noties.markwon.html.jsoup.nodes.b r101 = r100.f492597j;
        int r102 = r101.f492575a;
        if (r102 <= 0) goto L16;
        HashMap r103 = new HashMap(r102);
        int r104 = 0;
    L6:
        if (r104 >= r101.f492575a) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L20;
        String r106 = r101.f492577c[r104];
        String r107 = r101.f492576b[r104];
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        io.noties.markwon.html.jsoup.nodes.a r108 = new io.noties.markwon.html.jsoup.nodes.a(r107, r106, r101);
        r104 = r104 + 1;
        r103.put(r108.f492571a.toLowerCase(Locale.US), r108.f492572b);
        goto L6
    L20:
        return Collections.unmodifiableMap(r103);
    L8:
        r105 = false;
        goto L9
    L16:
        return Collections.emptyMap();
    }

    public final void b(lsc.y r100, m r101) {
        a0 r102 = this.f547472b.get(r101.f547459a);
        if (r102 == null) goto L10;
        CharSequence r103 = r102.b(r101, this.f547471a);
        if (r103 == null) goto L10;
        if (r103 == r101.f547463e) goto L10;
        r100.e(r101.f547460b);
        r100.b(r103);
    L10:
        if (r101.f547460b != r100.length()) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L23;
        this.f547471a.getClass();
        String r105 = g.a(r101);
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.length() <= 0) goto L27;
        r100.append(r105);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L27:
        return;
    L23:
        return;
    L12:
        r104 = false;
        goto L13
    }

    public r(g r100, Map r101, b0.a r102, Set r103, Set r110) {
        this.f547476f = new ArrayList(0);
        this.f547477g = new m.a("", 0, Collections.emptyMap(), null);
        this.f547471a = r100;
        this.f547472b = r101;
        this.f547473c = r102;
        this.f547474d = r103;
        this.f547475e = r110;
    }
}
