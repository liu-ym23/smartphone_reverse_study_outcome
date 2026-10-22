package ug8;

import com.larus.bmhome.chat.list.cell.text.components.middle.h0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f550037a = null;

    static {
        f550037a = new a();
    }

    public a() {
    }

    @Override // ug8.b
    public final h0 a(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        return r100;
    }

    @Override // ug8.b
    public final Message b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        return r100;
    }
}
