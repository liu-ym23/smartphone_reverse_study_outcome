package zr8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f573433e;

    @Override // xc8.b
    public final int d() {
        return -1;
    }

    public b(Message r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "systemMessage");
        super(r100);
        this.f573433e = r101;
    }
}
