package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class i<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatRecentFileSelectAdapter f342175a;

    public i(ChatRecentFileSelectAdapter r100) {
        this.f342175a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ChatRecentFileSelectAdapter r102 = this.f342175a;
        String r103 = ((x79.a) r101).f562830a;
        int r104 = ChatRecentFileSelectAdapter.f342147p;
        r102.getClass();
        String r105 = ChatRecentFileSelectAdapter.E2(r103);
        long r106 = 0;
        if (r105 == null) goto L7;
        Long r107 = this.f342175a.f342159m.get(r105);
        if (r107 == null) goto L7;
        long r108 = r107.longValue();
    L8:
        Long r109 = Long.valueOf(r108);
        ChatRecentFileSelectAdapter r110 = this.f342175a;
        String r111 = ((x79.a) r100).f562830a;
        r110.getClass();
        String r112 = ChatRecentFileSelectAdapter.E2(r111);
        if (r112 == null) goto L14;
        Long r113 = this.f342175a.f342159m.get(r112);
        if (r113 == null) goto L14;
        r106 = r113.longValue();
    L14:
        return ComparisonsKt.compareValues(r109, Long.valueOf(r106));
    L7:
        r108 = 0;
        goto L8
    }
}
