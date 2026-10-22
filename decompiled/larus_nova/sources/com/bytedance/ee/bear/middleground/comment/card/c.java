package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements sa5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f230957a;

    public c(b r100) {
        this.f230957a = r100;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        if (this.f230957a.a() == false) goto L5;
        return true;
    L5:
        b r100 = this.f230957a;
        if (r100.f230951a.f232238n != CommentStyle.ASIDE) goto L9;
        return false;
    L9:
        r100.Ni(true);
        return true;
    }
}
