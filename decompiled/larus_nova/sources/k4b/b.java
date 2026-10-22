package k4b;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Function1<f5b.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f501770b;

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(f5b.b r100) {
        f5b.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "chatMessage");
        if (this.f501770b == true) goto L5;
    L21:
        ChatChatter r102 = r101.getMessageSender();
        if (r102 != null) goto L25;
        return Boolean.FALSE;
    L25:
        return Boolean.valueOf(Intrinsics.areEqual(r102.getId(), this.f501769a));
    L5:
        if ((r101 instanceof MessageInfo) == false) goto L7;
        MessageInfo r103 = (MessageInfo) r101;
    L8:
        if (r103 == null) goto L21;
        List<MessageInfo> r104 = r103.getLatestRepliesInThread();
        if (r104 == null) goto L21;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L21;
        ChatChatter r106 = ((MessageInfo) r105.next()).getMessageSender();
        if (r106 == null) goto L17;
        String r107 = r106.getId();
    L19:
        if (Intrinsics.areEqual(r107, this.f501769a) == false) goto L13;
        return Boolean.TRUE;
    L17:
        r107 = null;
        goto L19
    L7:
        r103 = null;
        goto L8
    }

    public b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        this.f501769a = r100;
        this.f501770b = r101;
    }
}
