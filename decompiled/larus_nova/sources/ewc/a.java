package ewc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f474616a = null;

    static {
        PatternProtector.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
        Charset r100 = Charset.forName("UTF-8");
        f474616a = r100;
        r100.name();
        "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
}
