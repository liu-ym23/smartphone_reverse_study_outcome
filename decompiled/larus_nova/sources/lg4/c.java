package lg4;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f509136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f509137b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f509138c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f509139d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f509140e = null;

    public static final class a {
    }

    public c() {
    }

    public abstract com.bytedance.component.lyric.model.a a(PolarisFileInputStreamWrapper r100) throws Exception;

    static {
        f509136a = Charset.forName(XML.CHARSET_UTF8);
        f509137b = PatternProtector.compile("\\[\\d+,\\d+\\]");
        f509138c = PatternProtector.compile("\\<\\d+,\\d+,\\d+\\>");
        f509139d = PatternProtector.compile("(\\[\\d+:\\d+.\\d+\\])+");
        f509140e = PatternProtector.compile("\\[\\d+:\\d+.\\d+\\]");
    }
}
