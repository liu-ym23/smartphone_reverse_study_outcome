package rg4;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f537692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f537693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f537694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f537695d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f537696e = null;

    static {
        f537692a = StandardCharsets.UTF_8;
        f537693b = PatternProtector.compile("\\[(\\d+),(\\d+)\\]");
        f537694c = PatternProtector.compile("<(\\d+),(\\d+),\\d+>");
        f537695d = PatternProtector.compile("(\\[(\\d{1,2}):(\\d{1,2})(\\.\\d{1,3})?\\])+");
        f537696e = PatternProtector.compile("\\[(\\d{1,2}):(\\d{1,2})(\\.\\d{1,3})?\\]");
    }
}
