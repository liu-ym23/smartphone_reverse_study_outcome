package dnb;

import a2b.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class b implements l {
    @Inject
    public b() {
    }

    @Override // a2b.l
    public final void a(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
    }

    @Override // a2b.l
    public final void reset(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
    }
}
