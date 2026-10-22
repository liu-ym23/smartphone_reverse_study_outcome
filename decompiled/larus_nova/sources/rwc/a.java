package rwc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ttnetuploader.uploader.api.Parameters;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f539731d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f539732e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f539733f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f539736c;

    static {
        f539731d = PatternProtector.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        f539732e = PatternProtector.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        f539733f = PatternProtector.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    }

    public a(String r100) {
        this.f539734a = r100;
        String r101 = "";
        if (r100 == null) goto L12;
        Matcher r102 = f539731d.matcher(r100);
        if (r102.find() == false) goto L7;
        r101 = r102.group(1);
    L7:
        this.f539735b = r101;
        Matcher r103 = f539732e.matcher(r100);
        if (r103.find() == false) goto L10;
        String r104 = r103.group(2);
    L11:
        this.f539736c = r104;
    L14:
        if (Parameters.CONTENT_TYPE_MULTIPART_FORM.equalsIgnoreCase(this.f539735b) == false) goto L19;
        Matcher r105 = f539733f.matcher(r100);
        if (r105.find() == false) goto L20;
        r105.group(2);
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r104 = null;
        goto L11
    L12:
        this.f539735b = "";
        this.f539736c = "UTF-8";
        goto L14
    }
}
