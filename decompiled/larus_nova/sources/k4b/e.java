package k4b;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Function1<f5b.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501773a;

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        this.f501773a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(f5b.b r100) {
        f5b.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "chatMessage");
        List<ReactionInfo> r102 = r101.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r102) == false) goto L13;
        Iterator<ReactionInfo> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Map<String, ChatChatter> r104 = r103.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r104) == false) goto L6;
        if (r104.get(this.f501773a) == null) goto L6;
        return Boolean.TRUE;
    L13:
        return Boolean.FALSE;
    }
}
