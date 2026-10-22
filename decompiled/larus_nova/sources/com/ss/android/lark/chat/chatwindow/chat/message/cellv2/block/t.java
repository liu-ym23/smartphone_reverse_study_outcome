package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class t implements ListenerParams.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.chat.utils.v f413255a;

    public t(u r100) {
        this.f413255a = r100;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void a(Exception r100) {
        com.ss.android.lark.chat.utils.v r101 = this.f413255a;
        if (r101 == null) goto L6;
        r101.onFinish();
        return;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void b(Object r100, Object r101, DataSource r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "dataSource");
        com.ss.android.lark.chat.utils.v r104 = this.f413255a;
        if (r104 == null) goto L6;
        r104.onFinish();
        return;
    }
}
