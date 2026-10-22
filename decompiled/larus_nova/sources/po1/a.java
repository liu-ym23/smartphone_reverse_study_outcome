package po1;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f530026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f530027b = null;

    static {
        f530026a = new byte[4096];
        f530027b = PatternProtector.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");
    }
}
