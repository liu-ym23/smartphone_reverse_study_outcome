package pl0;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f529748a = null;

    static {
        f529748a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map<? extends String, ? extends String> getUserData(CrashType r100) {
        HashMap r101 = new HashMap();
        int r102 = b.f529749a;
        r101.put("last_lynx_url", "");
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, "");
        return r101;
    }
}
