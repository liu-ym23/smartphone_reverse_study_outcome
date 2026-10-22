package io.ktor.http;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public final class CookieKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f491808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f491809b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Character> f491810c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f491811a = null;

        static {
            int[] r100 = new int[CookieEncoding.values().length];
            r100[CookieEncoding.RAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CookieEncoding.DQUOTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CookieEncoding.BASE64_ENCODING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CookieEncoding.URI_ENCODING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f491811a = r100;
        }
    }

    static {
        f491808a = SetsKt.setOf(new String[]{HTTP.MAX_AGE, "expires", "domain", "path", "secure", "httponly", "$x-enc"});
        f491809b = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
        f491810c = SetsKt.setOf(new Character[]{';', ',', Character.valueOf(Typography.quote)});
    }

    public static final boolean b(char r100) {
        if (CharsKt.isWhitespace(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.compare(r100, 32) < 0) goto L10;
        if (f491810c.contains(Character.valueOf(r100)) == true) goto L10;
        return false;
    }

    public static final Map<String, String> a(String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "cookiesHeader");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.filter(SequencesKt.map(Regex.findAll$default(f491809b, r100, 0, 2, null), CookieKt$parseClientCookiesHeader$1.INSTANCE), new CookieKt$parseClientCookiesHeader$2(r101)), CookieKt$parseClientCookiesHeader$3.INSTANCE));
    }
}
