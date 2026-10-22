package yc8;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import dp8.e;
import ei9.f;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<MessageStatus> f567231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f567232b;

    public b() {
        this.f567231a = SetsKt.setOf(new MessageStatus[]{MessageStatus.MessageStatus_DELETED, MessageStatus.MessageStatus_NOT_EXIST, MessageStatus.MessageStatus_INVISIBLE});
        this.f567232b = 1;
    }

    @Override // xc8.g
    public final int c() {
        return this.f567232b;
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (CollectionsKt.contains(this.f567231a, r101.getMessageStatus()) == false) goto L5;
    L16:
        return true;
    L5:
        if (r101.getMessageStatusLocal() != 0) goto L11;
        if (r101.getSourceFromAsr() == false) goto L11;
        if (r101.getContentType() == 0) goto L16;
    L11:
        if (d.a0(r101) == true) goto L13;
    L15:
        return false;
    L13:
        if (e.c(r101) != null) goto L15;
        goto L15
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new a(r101);
    }
}
