package f38;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a<T extends Message<?, ?>> extends com.larksuite.rucket.impl.base.push.a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Command f475411d;

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void b() {
        Map<com.bytedance.lark.pb.basic.v1.Command, g.b> r100 = e38.a.f470931a;
        Command r101 = this.f475411d;
        if (r101 == null) goto L6;
        ((ConcurrentHashMap) e38.a.f470932b).put(r101, this);
        return;
    }

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void c() {
        Map<com.bytedance.lark.pb.basic.v1.Command, g.b> r100 = e38.a.f470931a;
        Command r101 = this.f475411d;
        if (r101 == null) goto L7;
        ((ConcurrentHashMap) e38.a.f470932b).remove(r101);
        return;
    }

    public a(Command r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseClazz");
        super(r101);
        this.f475411d = r100;
    }
}
