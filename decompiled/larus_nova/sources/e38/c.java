package e38;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c<T extends Message<?, ?>> extends com.larksuite.rucket.impl.base.push.a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Command f470936d;

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void b() {
        Map<Command, g.b> r100 = a.f470931a;
        Command r101 = this.f470936d;
        if (r101 == null) goto L6;
        ((ConcurrentHashMap) a.f470931a).put(r101, this);
        return;
    }

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void c() {
        Map<Command, g.b> r100 = a.f470931a;
        Command r101 = this.f470936d;
        if (r101 == null) goto L7;
        ((ConcurrentHashMap) a.f470931a).remove(r101);
        return;
    }

    public c(Command r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseClazz");
        super(r101);
        this.f470936d = r100;
    }
}
