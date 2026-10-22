package sha;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542084a = 0;

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, sha.a] */
    static {
        ObricListeningMainProcessManager r100 = ObricListeningMainProcessManager.f385330a;
        final ?? r101 = new a();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "handler");
        ObricListeningMainProcessManager.k(new k1(r101));
    }

    public static boolean a() {
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.c r100 = ObricListeningMainProcessManager.f385349t.get();
        if (r100 == null) goto L11;
        if (r100.f385361b == true) goto L8;
        return false;
    L8:
        if (r100.f385362c.isValid() == false) goto L11;
        return true;
    L11:
        return ObricListeningMainProcessManager.f385335f;
    }

    public static boolean b() {
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.c r100 = ObricListeningMainProcessManager.f385349t.get();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L12:
        boolean r102 = ObricListeningMainProcessManager.f385335f;
        ObricListeningVisualMode r103 = ObricListeningMainProcessManager.f385336g.f385267e.f385270a;
        Intrinsics.checkNotNullParameter(r103, "visualMode");
        if (r102 == true) goto L15;
    L17:
        r101 = false;
    L19:
        return r101;
    L15:
        if (r103 == ObricListeningVisualMode.HIDDEN) goto L17;
    L5:
        if (r100.f385361b == true) goto L8;
        return false;
    L8:
        if (r100.f385362c.isValid() == false) goto L12;
        ObricListeningVisualMode r104 = r100.f385362c.f385267e.f385270a;
        Intrinsics.checkNotNullParameter(r104, "visualMode");
        if (r104 == ObricListeningVisualMode.HIDDEN) goto L17;
        goto L17
    }
}
