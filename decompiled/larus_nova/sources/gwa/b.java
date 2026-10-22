package gwa;

import com.ss.android.lark.pb.security_event.Event;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements iwa.c<Event> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // iwa.c
    public final Event a(String r100) {
        return c.a(r100);
    }

    @Override // iwa.c
    public final String serialize(Event r100) {
        Event r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return c.b(r101);
    }
}
