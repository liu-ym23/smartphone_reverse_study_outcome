package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements com.ss.android.lark.chat.utils.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageContentBlock f413185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageContentBlock.b f413186b;

    @Override // com.ss.android.lark.chat.utils.v
    public final void onFinish() {
        ImageContentBlock r100 = this.f413185a;
        ImageContentBlock.b r101 = this.f413186b;
        r100.getClass();
        ImageContentBlock.i(false, r101);
    }

    @Override // com.ss.android.lark.chat.utils.v
    public final void onStart() {
        ImageContentBlock r100 = this.f413185a;
        ImageContentBlock.b r101 = this.f413186b;
        r100.getClass();
        ImageContentBlock.i(true, r101);
    }

    public m(ImageContentBlock r100, ImageContentBlock.b r101) {
        this.f413185a = r100;
        this.f413186b = r101;
    }
}
