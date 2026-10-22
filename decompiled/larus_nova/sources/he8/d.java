package he8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends ie8.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f484891d;

    @Override // ie8.a
    public final int a() {
        return this.f484891d;
    }

    public d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.f484891d = 1;
    }
}
