package com.ss.android.lark.keyboard.biz.plus;

import com.ss.android.lark.keyboard.keyboard2.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MorePlugin implements com.ss.android.lark.biz.im.api.extension.chat_window.d<m>, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f428483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlusKBPlugin f428485c;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "plus";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    public final m c() {
        if (this.f428485c != null) goto L6;
        PlusKBPlugin r100 = new PlusKBPlugin(this.f428483a, this.f428484b);
        Function0<Unit> r101 = new MorePlugin$getPlugin$1$1(this);
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.f428493k = r101;
        this.f428485c = r100;
    L6:
        return this.f428485c;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final /* bridge */ /* synthetic */ m getPlugin() {
        return c();
    }

    public MorePlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f428483a = false;
        this.f428484b = r100;
    }

    @Override // com.ss.android.lark.keyboard.biz.plus.a
    public final void a(Collection<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        m r101 = c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin");
        PlusKBPlugin r102 = (PlusKBPlugin) r101;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        r102.f428497o.addAll(r100);
    }

    @Override // com.ss.android.lark.keyboard.biz.plus.a
    public final void b(List<? extends d5b.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        m r101 = c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin");
        PlusKBPlugin r102 = (PlusKBPlugin) r101;
        List r103 = CollectionsKt.filterNotNull(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "plusItemList");
        ArrayList r104 = new ArrayList();
        CollectionsKt.filterNotNullTo(r103, r104);
        r102.f428492j.addAll(r104);
        Iterator r105 = r104.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        ((d5b.a) r105.next()).d(r102);
        goto L4
    }
}
