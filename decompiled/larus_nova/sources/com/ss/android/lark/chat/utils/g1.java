package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class g1 implements h7b.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SystemContentUtil.a f416674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chat f416675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f416676c;

    @Override // h7b.i.b
    public final void onCancel() {
    }

    @Override // h7b.i.b
    public final void onConfirm() {
        SystemContentUtil.a r100 = this.f416674a;
        if (r100 == null) goto L6;
        r100.B(this.f416675b.getId(), this.f416676c);
        return;
    }

    public g1(SystemContentUtil.a r100, Chat r101, List r102) {
        this.f416674a = r100;
        this.f416675b = r101;
        this.f416676c = r102;
    }
}
