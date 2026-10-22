package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2;

import a2b.j;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;
import q3b.r;
import x4b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f414297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f414298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f414299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BasePageStore.c<MessageInfo> f414300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a f414301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MessageListPinExtraLoader f414302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j.a f414303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f414304h;

    public final m2b.a getContext() {
        return this.f414297a;
    }

    public b(m2b.a r100, v r101, d r102, MessageListViewModelV2.w r103, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r104, MessageListPinExtraLoader r105, r r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "executor");
        Intrinsics.checkNotNullParameter(r103, "onDataChangeListener");
        this.f414297a = r100;
        this.f414298b = r101;
        this.f414299c = r102;
        this.f414300d = r103;
        this.f414301e = r104;
        this.f414302f = r105;
        this.f414303g = r106;
        this.f414304h = r107;
    }
}
