package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f412324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f412325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f412326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<d> f412327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i7b.a f412328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f412329f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100 = this.f412329f;
        if (r100 != null) goto L5;
        return;
    L5:
        i7b.a r101 = this.f412328e;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f412326c == false) goto L11;
        return;
    L11:
        Iterator<d> r102 = this.f412327d.iterator();
    L13:
        if (r102.hasNext() == false) goto L15;
        r102.next().c(r100, r101);
        goto L13
    L15:
        this.f412326c = true;
    }

    public b(ChatPluginFactoryAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "factoryProvider");
        this.f412324a = r100;
        this.f412327d = new ArrayList(20);
    }
}
