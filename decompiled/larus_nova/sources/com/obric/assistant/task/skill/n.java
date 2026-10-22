package com.obric.assistant.task.skill;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes33.dex */
public final class n {
    public static final boolean a(ModelItemIdentity r100) {
        AtomicBoolean r101 = m.f393417a;
        String r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.getDeprecatedItemId());
    L7:
        if (m.j(r103) == true) goto L14;
        if (r100 == null) goto L11;
        r102 = r100.getKey();
    L11:
        if (m.k(r102) == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r103 = null;
        goto L7
    }

    public static final boolean b(ReplyOption r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        AtomicBoolean r101 = m.f393417a;
        if (m.k(r100.getModeId()) == false) goto L8;
    L9:
        return true;
    L8:
        if (a(r100.getModel()) == true) goto L9;
        return false;
    }
}
