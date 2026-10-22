package sh7;

import com.bytedance.timonbase.scene.lifecycle.ForegroundState;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements d<ForegroundState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ForegroundState f541973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f541974b = null;

    public a() {
    }

    static {
        f541974b = new a();
    }

    @Override // sh7.d
    public final void a(Object r100) {
        if ((r100 instanceof ForegroundState) == false) goto L6;
        f541973a = (ForegroundState) r100;
        return;
    }
}
