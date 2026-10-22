package com.ss.android.lark.chat.chatwindow.chat.model.push;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements AndroidThrottle.d<Chat> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Chat f413427a;

    public a() {
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void clear() {
        this.f413427a = null;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final Collection<Chat> a() {
        ArrayList r100 = new ArrayList();
        Chat r101 = this.f413427a;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        return r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final int size() {
        if (this.f413427a == null) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void put(Chat r100) {
        Chat r101 = r100;
        if (r101 == null) goto L7;
        this.f413427a = r101;
        return;
    }
}
