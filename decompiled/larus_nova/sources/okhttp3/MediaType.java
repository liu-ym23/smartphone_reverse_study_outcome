package okhttp3;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class MediaType {
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;

    @Nullable
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    @Nullable
    public Charset charset() {
        return charset(null);
    }

    static {
        TYPE_SUBTYPE = PatternProtector.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = PatternProtector.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public String type() {
        return this.type;
    }

    public static MediaType get(String r110) {
        Matcher r100 = TYPE_SUBTYPE.matcher(r110);
        if (r100.lookingAt() == false) goto L37;
        String r101 = r100.group(1);
        Locale r102 = Locale.US;
        String r103 = r101.toLowerCase(r102);
        String r104 = r100.group(2).toLowerCase(r102);
        Matcher r105 = PARAMETER.matcher(r110);
        int r106 = r100.end();
        String r107 = null;
    L6:
        if (r106 >= r110.length()) goto L35;
        r105.region(r106, r110.length());
        if (r105.lookingAt() == false) goto L33;
        String r108 = r105.group(1);
        if (r108 == null) goto L31;
        if (r108.equalsIgnoreCase("charset") == false) goto L31;
        String r109 = r105.group(2);
        if (r109 != null) goto L17;
        r109 = r105.group(3);
    L24:
        if (r107 != null) goto L26;
    L30:
        r107 = r109;
        goto L31
    L26:
        if (r109.equalsIgnoreCase(r107) == true) goto L30;
        throw new IllegalArgumentException("Multiple charsets defined: \"" + r107 + "\" and: \"" + r109 + "\" for: \"" + r110 + Typography.quote);
    L17:
        if (r109.startsWith("'") == false) goto L24;
        if (r109.endsWith("'") == false) goto L24;
        if (r109.length() <= 2) goto L24;
        r109 = r109.substring(1, r109.length() - 1);
    L31:
        r106 = r105.end();
        goto L6
    L33:
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + r110.substring(r106) + "\" for: \"" + r110 + Typography.quote);
    L35:
        return new MediaType(r110, r103, r104, r107);
    L37:
        throw new IllegalArgumentException("No subtype found for: \"" + r110 + Typography.quote);
    }

    @Nullable
    public static MediaType parse(String r100) {
        return get(r100);
    L4:
        return null;
    }

    @Nullable
    public Charset charset(@Nullable Charset r100) {
        String r101 = this.charset;     // Catch: IllegalArgumentException -> L6
        if (r101 == null) goto L9;
        return Charset.forName(r101);
    L9:
        return r100;
    L10:
        return r100;
    }

    public boolean equals(@Nullable Object r100) {
        if ((r100 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((MediaType) r100).mediaType.equals(this.mediaType) == false) goto L7;
        return true;
    }

    private MediaType(String r100, String r101, String r102, @Nullable String r103) {
        this.mediaType = r100;
        this.type = r101;
        this.subtype = r102;
        this.charset = r103;
    }
}
