package r80;

import android.os.Build;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f536493a = null;

    static {
        f536493a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return Build.MODEL + " is fold screen!";
    }
}
