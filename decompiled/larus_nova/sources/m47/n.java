package m47;

import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements l47.a<JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProtocolMessage.c f511882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f511883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f511884c;

    @Override // l47.a
    public final void accept(JsonObject r100) {
        int r101 = this.f511882a.f266230a;
        JsonObject r102 = ProtocolMessage.c(new ProtocolMessage.a(r101, 1, r100, null));
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f511883b.compareAndSet(false, true) == false) goto L9;
        this.f511884c.f511889e.a(r102);
        return;
    }

    public n(o r100, ProtocolMessage.c r101, AtomicBoolean r102) {
        this.f511884c = r100;
        this.f511882a = r101;
        this.f511883b = r102;
    }
}
