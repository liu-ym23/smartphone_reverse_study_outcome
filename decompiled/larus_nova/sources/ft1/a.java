package ft1;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ICrashCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478749a = 0;

    @Override // com.bytedance.crash.ICrashCallback
    public final void onCrash(CrashType r100, String r101, Thread r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    static {
    }
}
