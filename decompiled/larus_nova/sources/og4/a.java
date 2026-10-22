package og4;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ng4.h;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements h {

    /* JADX INFO: renamed from: og4.a$a, reason: collision with other inner class name */
    public static final class C7049a {
    }

    static {
    }

    public a() {
    }

    @Override // ng4.h
    public final void a(Object... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("AndroidLyricLogger", ArraysKt.joinToString$default(r110, "====", null, null, 0, null, null, 62, null));
    }

    @Override // ng4.h
    public final void b(Object... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.e("AndroidLyricLogger", ArraysKt.joinToString$default(r110, "====", null, null, 0, null, null, 62, null));
    }
}
