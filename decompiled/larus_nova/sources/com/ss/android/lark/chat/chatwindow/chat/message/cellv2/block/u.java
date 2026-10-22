package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

/* JADX INFO: loaded from: classes35.dex */
public final class u implements com.ss.android.lark.chat.utils.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaContentBlock f413277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaContentBlock.b f413278b;

    @Override // com.ss.android.lark.chat.utils.v
    public final void onFinish() {
        MediaContentBlock r100 = this.f413277a;
        MediaContentBlock.b r101 = this.f413278b;
        r100.getClass();
        MediaContentBlock.j(false, r101);
    }

    @Override // com.ss.android.lark.chat.utils.v
    public final void onStart() {
        MediaContentBlock r100 = this.f413277a;
        MediaContentBlock.b r101 = this.f413278b;
        r100.getClass();
        MediaContentBlock.j(true, r101);
    }

    public u(MediaContentBlock r100, MediaContentBlock.b r101) {
        this.f413277a = r100;
        this.f413278b = r101;
    }
}
