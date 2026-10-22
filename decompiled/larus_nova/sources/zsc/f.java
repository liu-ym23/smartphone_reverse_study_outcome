package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573516e = null;

    @Override // zsc.i
    public final char d() {
        return Typography.amp;
    }

    static {
        f573516e = PatternProtector.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r100 = a(f573516e);
        if (r100 != null) goto L5;
        return null;
    L5:
        return f(tvc.b.a(r100));
    }

    public f() {
    }
}
