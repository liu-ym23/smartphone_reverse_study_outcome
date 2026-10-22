package gwa;

import com.ss.android.lark.pb.security_event.Event;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "To be deleted")
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iwa.f<Event> f483078a;

    public d(Executor r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f483078a = new iwa.f(d.class.getSimpleName(), new b(), r100, r101);
    }
}
