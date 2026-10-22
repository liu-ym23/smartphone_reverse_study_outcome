package com.ss.android.lark.chat.export.entity.chatter;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements IChatterDesc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f415390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IChatterDesc.Type f415391b;

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public final String getContent() {
        return this.f415390a;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public IChatterDesc.Type getType() {
        return this.f415391b;
    }

    public a(IChatterDesc.Type r100) {
        this.f415390a = "";
        this.f415391b = r100;
    }
}
