package jg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r101.getMessageStatusLocal() != 21) goto L7;
        if (com.larus.bmhome.chat.bean.d.Q0(r101) == false) goto L7;
    L32:
        return false;
    L7:
        if (r101.getMessageStatusLocal() == 20) goto L32;
        if (r101.getMessageStatusLocal() == 23) goto L32;
        List<TextTagInfo> r103 = com.larus.bmhome.chat.bean.d.O(r101);
        if (r103 != null) goto L13;
        r103 = CollectionsKt.emptyList();
    L13:
        List<TextTagInfo> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L20:
        if (r105.hasNext() == false) goto L29;
        if (((TextTagInfo) r105.next()).type != TagEnum.TagEnum_Insertable.value) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L20;
        r106 = r106 + 1;
        if (r106 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r107 = false;
    L29:
        if (r106 == 0) goto L32;
        return true;
    L16:
        if (r104.isEmpty() == false) goto L18;
        r106 = 0;
        goto L29
    }
}
