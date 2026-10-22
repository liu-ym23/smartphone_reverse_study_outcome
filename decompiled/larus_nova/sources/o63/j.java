package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f522195e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522196d;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522196d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam("toast_content", r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        super.buildParams();
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
