package dnb;

import a2b.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class c implements l {
    @Inject
    public c() {
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
