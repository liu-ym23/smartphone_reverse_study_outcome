package r80;

import android.os.Build;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f536501a = null;

    static {
        f536501a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return Build.MODEL + " is fold screen!";
    }
}
