package yc9;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SuggestQuestion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f567233a = null;

    static {
        f567233a = CollectionsKt.listOf(new Integer[]{70, 72});
    }

    public static final List<String> a(Message r100) {
        if (r100 == null) goto L4;
        List<SuggestQuestion> r101 = r100.getSuggestQuestions();
        if (r101 == null) goto L15;
        List<SuggestQuestion> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L19;
        String r105 = ((SuggestQuestion) r104.next()).content;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103.add(r105);
        goto L9
    L19:
        return r103;
    L15:
        return CollectionsKt.emptyList();
    L4:
        return CollectionsKt.emptyList();
    }
}
