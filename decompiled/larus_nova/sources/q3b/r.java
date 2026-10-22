package q3b;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements a2b.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f531591a;

    @Override // a2b.j.a
    public final String a() {
        return this.f531591a.getAnonymousId();
    }

    public r(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "currentChat");
        this.f531591a = r100;
    }
}
