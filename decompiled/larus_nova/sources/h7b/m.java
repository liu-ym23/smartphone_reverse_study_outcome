package h7b;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class m {
    public static boolean a(List<ReactionInfo> r100, String r101, String r102) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Iterator<ReactionInfo> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L26;
        Reaction r104 = r103.next().getReaction();
        if (Objects.equals(r101, r104.getType()) == false) goto L7;
        if (r104.getChatterIds() == null) goto L25;
        Iterator r105 = new ArrayList(r104.getChatterIds()).iterator();
    L14:
        if (r105.hasNext() == false) goto L27;
        if (((String) r105.next()).equals(r102) == false) goto L14;
        return true;
    L27:
        return false;
    L25:
        return false;
    L26:
        return false;
    }
}
