package org.jsoup.parser;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f526020c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f526021d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f526022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526023b;

    static {
        f526020c = new d(false, false);
        f526021d = new d(true, true);
    }

    @Nullable
    public final void a(@Nullable org.jsoup.nodes.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f526023b == true) goto L11;
        int r101 = 0;
    L7:
        if (r101 >= r100.f525924a) goto L12;
        String[] r102 = r100.f525925b;
        r102[r101] = fwc.a.a(r102[r101]);
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    }

    public d(boolean r100, boolean r101) {
        this.f526022a = r100;
        this.f526023b = r101;
    }
}
