package com.bytedance.awemeopen.apps.framework.card.video;

import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193860a;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.video.a$a, reason: collision with other inner class name */
    public static final class C2795a {
    }

    static {
    }

    public a() {
    }

    public final boolean a() {
        if (this.f193860a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b() {
        this.f193860a++;
    }

    public final String toString() {
        int r100 = this.f193860a;
        if (r100 != 0) goto L5;
        String r101 = ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE;
    L13:
        return Integer.toString(hashCode(), CharsKt.checkRadix(16)) + '#' + r101;
    L5:
        if (r100 != 1) goto L7;
        r101 = "bind";
        goto L13
    L7:
        if (r100 == 2) goto L9;
        r101 = String.valueOf(r100);
        goto L13
    L9:
        r101 = "select";
        goto L13
    }
}
