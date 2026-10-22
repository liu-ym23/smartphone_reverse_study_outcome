package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n5 implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ky9.a f301162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f301163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Message f301164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f301165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f301166e;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return false;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f301162a.d(this.f301163b, this.f301164c, r101, this.f301165d, this.f301166e);
    }

    public n5(ky9.a r100, String r101, Message r102, String r103, String r104) {
        this.f301162a = r100;
        this.f301163b = r101;
        this.f301164c = r102;
        this.f301165d = r103;
        this.f301166e = r104;
    }
}
