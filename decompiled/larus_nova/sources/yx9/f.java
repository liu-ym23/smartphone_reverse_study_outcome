package yx9;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f569442c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f569443b;

    static {
        f569442c = new f();
    }

    @Override // yx9.d
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f569443b.a(r100, r101);
    }

    public f() {
        vx9.b.f557496a.getClass();
        this.f569443b = vx9.b.f557500e;
    }
}
