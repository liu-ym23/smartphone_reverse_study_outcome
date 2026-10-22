package u07;

import com.bytedance.fresco.sr.SRPostProcessor;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SRPostProcessor f548203a;

    public static SRPostProcessor a() {
        if (f548203a != null) goto L6;
        f548203a = new SRPostProcessor(32768, true);
    L6:
        return f548203a;
    }
}
