package com.ss.android.lark.message.universalcard.datachannel;

import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f432268a = null;

    static {
        f432268a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        Iterator r101 = ((ArrayList) MessageCardDataService.f432236d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g.b) r101.next()).a(r100);
        goto L4
    }
}
