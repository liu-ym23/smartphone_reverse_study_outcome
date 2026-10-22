package com.ss.android.lark.widget.photo.preview.video.online;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<OnlineVideoGalleryFuncListViewModel.d> f447313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OnlineVideoGalleryFuncListViewModel f447314b;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f447313a.size()) goto L9;
        OnlineVideoGalleryFuncListViewModel.b r101 = ((OnlineVideoGalleryFuncListViewModel.d) ListProtector.get(this.f447313a, r100)).f447293c;
        PhotoItem r102 = this.f447314b.getPhotoItem();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "photoItem");
        r101.f447289b.onOperate(r101.f447288a, r101.b(), r102, true);
        return;
    }

    public d(List<OnlineVideoGalleryFuncListViewModel.d> r100, OnlineVideoGalleryFuncListViewModel r101) {
        this.f447313a = r100;
        this.f447314b = r101;
    }
}
