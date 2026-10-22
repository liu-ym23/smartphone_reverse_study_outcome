package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements itb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerFragment f440924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ itb.g f440925b;

    @Override // itb.f
    public final void onCancel() {
        Log.i("OfficeCustomStickerFragment", "pickFromAlbum cancel");
    }

    @Override // itb.f
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Log.e("OfficeCustomStickerFragment", "pickFromAlbum error: ".concat(r100));
    }

    @Override // itb.f
    public final void onSuccess(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "filePaths");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        OfficeCustomStickerFragment.T90(this.f440924a, r100, this.f440925b.f495761f);
    }

    public k(OfficeCustomStickerFragment r100, itb.g r101) {
        this.f440924a = r100;
        this.f440925b = r101;
    }
}
