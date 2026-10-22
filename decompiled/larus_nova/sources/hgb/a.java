package hgb;

import com.ss.android.lark.biz.officesdk.im.message.reaction.DoubaoMessageFeedbackOperation;
import com.ss.android.lark.biz.officesdk.im.message.reaction.DoubaoMessageFeedbackSource;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wsb.b;
import y6b.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f485081a = 0;

    /* JADX INFO: renamed from: hgb.a$a, reason: collision with other inner class name */
    public static final class C6143a {
        public C6143a() {
        }

        public final boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            Set<String> r101 = b.f561114a;
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            return b.f561115b.contains(r100);
        }

        public final boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            Set<String> r101 = b.f561114a;
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            return b.f561114a.contains(r100);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [oza.a] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static void a(y6b.a r100, String r110, DoubaoMessageFeedbackSource r111) {
        Intrinsics.checkNotNullParameter(r100, "messageVo");
        Intrinsics.checkNotNullParameter(r110, "reactionKey");
        Intrinsics.checkNotNullParameter(r111, "source");
        if ((r100 instanceof c) == false) goto L5;
        c r101 = (c) r100;
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getType() == Message.Type.DOUBAO) goto L11;
        return;
    L11:
        String r102 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        g5b.a r103 = (g5b.a) r101.n(g5b.a.class);
        if (r103 == null) goto L43;
        String r104 = Long.valueOf(r103.f480106a).toString();
        if (r104 == null) goto L45;
        List<ReactionInfo> r105 = r101.f566509u;
        if (r105 == null) goto L28;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        Object r108 = r107.next();
        if (((ReactionInfo) r108).getReactionChatters().containsKey(r102) == false) goto L20;
        r106.add(r108);
        goto L20
    L24:
        ?? r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r112 = r106.iterator();
    L26:
        if (r112.hasNext() == false) goto L29;
        r109.add(((ReactionInfo) r112.next()).getReaction().getType());
    L29:
        ?? r113 = r109;
        if (r113.contains(r110) == false) goto L32;
        DoubaoMessageFeedbackOperation r114 = DoubaoMessageFeedbackOperation.REMOVE;
    L33:
        DoubaoMessageFeedbackOperation r115 = r114;
        C6143a r116 = new C6143a();
        ?? r117 = (oza.a) OfficeSDKManager.getHostUserService(r102, oza.a.class);
        if (r117 == 0) goto L44;
        r117.i0(r104, r113, r115, r110, r111, r116);
        return;
    L44:
        return;
    L32:
        r114 = DoubaoMessageFeedbackOperation.ADD;
        goto L33
    L28:
        r109 = CollectionsKt.emptyList();
        goto L29
    L45:
        return;
    L43:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
