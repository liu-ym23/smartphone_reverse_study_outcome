package osb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526598b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f526599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f526600b;

        public a() {
        }
    }

    public final String toString() {
        return "ChatModeInitParam(appScene='" + this.f526597a + "', link=" + this.f526598b + ", appData=null, sceneId=null, belongToBot=null)";
    }

    public b(a r100) {
        String r101 = r100.f526599a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appScene");
        r101 = null;
    L6:
        this.f526597a = r101;
        this.f526598b = r100.f526600b;
    }
}
