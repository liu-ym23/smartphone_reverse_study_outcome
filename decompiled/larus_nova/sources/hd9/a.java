package hd9;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f484618a = null;

    static {
        f484618a = new a();
    }

    public a() {
    }

    @Override // hd9.j
    public final void updateConversationBadgeCount(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
    }

    @Override // hd9.j
    public final void updateConversationLastMessage(List<MessageEntity> r100, boolean r101) {
    }

    @Override // hd9.j
    public final void verifyConversationConsistency() {
    }
}
