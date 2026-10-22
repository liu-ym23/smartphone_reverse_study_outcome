package mv0;

import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements l71.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f515822a = null;

    public f() {
    }

    static {
        f515822a = new f();
    }

    @Override // l71.c
    public final void enqueueEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        IExternalBrowserService r102 = (IExternalBrowserService) jc1.k.f(IExternalBrowserService.class);
        if (r102 == null) goto L6;
        r102.enqueueEvent(r100, r101);
        return;
    }
}
