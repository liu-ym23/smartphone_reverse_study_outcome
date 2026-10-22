package nd1;

import io.reactivex.subjects.CompletableSubject;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f518751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CompletableSubject f518752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f518753c;

    @JvmStatic
    public static final void a() {
        if (f518751a == true) goto L5;
        return;
    L5:
        if (f518753c == true) goto L11;
        f518753c = true;
        CompletableSubject r100 = f518752b;
        if (r100 == null) goto L12;
        r100.onComplete();
        return;
    L12:
        return;
    }

    static {
    }
}
