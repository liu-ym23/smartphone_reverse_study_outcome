package he8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends ie8.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f484890d;

    @Override // ie8.a
    public final int a() {
        return this.f484890d;
    }

    public b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.f484890d = 100;
    }
}
