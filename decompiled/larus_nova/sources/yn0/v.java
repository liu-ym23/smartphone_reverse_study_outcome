package yn0;

import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;

/* JADX INFO: loaded from: classes46.dex */
public final class v implements l81.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f568518a = null;

    public v() {
    }

    static {
        f568518a = new v();
    }

    @Override // l81.v
    public final boolean a(d90.d r100) {
        if ((r100 instanceof d90.a) == true) goto L7;
        return false;
    L7:
        return VSMediaUIConfigHelper.c(r100);
    }
}
