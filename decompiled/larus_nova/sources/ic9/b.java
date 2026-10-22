package ic9;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.larus.bmhome.chat.screenshot.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements ICrashCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f489258a;

    public b(j r100) {
        this.f489258a = r100;
    }

    @Override // com.bytedance.crash.ICrashCallback
    public final void onCrash(CrashType r100, String r101, Thread r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f489258a.invoke();
    }
}
