package com.ss.android.lark.chat.api.service.impl;

import java.util.Comparator;

/* JADX INFO: loaded from: classes35.dex */
public final class o1 implements Comparator<n5b.a> {
    public o1() {
    }

    @Override // java.util.Comparator
    public final int compare(n5b.a r100, n5b.a r101) {
        n5b.a r102 = r100;
        n5b.a r103 = r101;
        if (r102.f518077b.getPosition() != r103.f518077b.getPosition()) goto L11;
        if (r102.isPreMessage() == r103.isPreMessage()) goto L11;
        if (r102.isPreMessage() == false) goto L9;
        return 1;
    L9:
        return -1;
    L11:
        return r102.f518077b.getPosition() - r103.f518077b.getPosition();
    }
}
