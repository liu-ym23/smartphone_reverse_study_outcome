package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class b<T> extends a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f417108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f417109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f417111i;

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean f() {
        return false;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int b() {
        return this.f417103b.G7();
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int c() {
        int r100 = this.f417103b.i() - this.f417110h;
        int r101 = this.f417103b.h();
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        return Math.min(r101, r100);
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean g() {
        if (this.f417103b.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f417105d == true) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean h() {
        if ((!this.f417105d) == true) goto L5;
    L7:
        return false;
    L5:
        if (c() <= 0) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final boolean i() {
        if (g() == false) goto L6;
        return true;
    L6:
        if (this.f417103b.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L15;
        if (this.f417109g == true) goto L10;
    L12:
        return false;
    L10:
        if (c() <= 0) goto L12;
        return true;
    L15:
        if (c() > 0) goto L20;
        return false;
    L20:
        return true;
    }

    public b(Context r100, r7b.c r101) {
        super(r100, r101);
        this.f417111i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final void j(List<T> r100, a.b<T> r101) {
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        this.f417110h = Math.max(this.f417110h, r101.b(r103));
        goto L4
    L6:
        super.j(r100, r101);
    }
}
