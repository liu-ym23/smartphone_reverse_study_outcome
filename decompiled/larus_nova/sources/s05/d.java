package s05;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, qz4.a> f540018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, qz4.b> f540019b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f540018a = new ConcurrentHashMap();
        this.f540019b = new ConcurrentHashMap();
    }

    public final qz4.b a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        tt5.a.h("DComponent_CallbackMapper", "getEventHandler() called with: command = " + r100 + ", module = " + r101);
        return this.f540019b.get(r100 + '_' + r101);
    }
}
