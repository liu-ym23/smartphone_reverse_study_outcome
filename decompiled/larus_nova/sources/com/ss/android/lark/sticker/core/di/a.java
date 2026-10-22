package com.ss.android.lark.sticker.core.di;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.sticker.core.model.StickerFileInfo;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$deleteStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$getCustomStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$uploadStickers$2$1;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends c0c.b implements e6c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e6c.c f440787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f440788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e6c.c> f440789d;

    @Override // e6c.c
    public final void Pa(List r100, boolean r101, OfficeCustomStickerModel$uploadStickers$2$1 r102) {
        this.f440787b.Pa(r100, r101, r102);
    }

    @Override // e6c.c
    public final StickerFileInfo Uc(String r100) {
        return this.f440787b.Uc(r100);
    }

    @Override // e6c.c
    public final void cf(List r100, OfficeCustomStickerModel$deleteStickers$2$1 r101) {
        this.f440787b.cf(r100, r101);
    }

    @Override // e6c.c
    public final void de(boolean r100, OfficeCustomStickerModel$getCustomStickers$2$1 r101) {
        this.f440787b.de(r100, r101);
    }

    @Override // e6c.c
    public final void n0(List<Sticker> r100, IGetDataCallback<Boolean> r101) {
        this.f440787b.n0(r100, r101);
    }

    @Override // e6c.c
    public final void saveImage2Stickers(String r100, String r101, IGetDataCallback<Boolean> r102) {
        this.f440787b.saveImage2Stickers(r100, r101, r102);
    }

    @Override // e6c.c
    public final Sticker y(String r100) {
        return this.f440787b.y(r100);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e6c.c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), e6c.c.class), e6c.c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f440787b = r103.b();
        this.f440788c = r101;
        this.f440789d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f440788c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        e6c.c r105 = (e6c.c) k.b(r102.c(r104), e6c.c.class);
        this.f440789d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
