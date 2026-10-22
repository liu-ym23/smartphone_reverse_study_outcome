package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.content.DialogInterface;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerFragment f440921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f440922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f440923c;

    public j(OfficeCustomStickerFragment r100, List<String> r101, boolean r102) {
        this.f440921a = r100;
        this.f440922b = r101;
        this.f440923c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        OfficeCustomStickerFragment r102 = this.f440921a;
        List<String> r103 = this.f440922b;
        Intrinsics.checkNotNull(r103);
        OfficeCustomStickerFragment.T90(r102, r103, this.f440923c);
    }
}
