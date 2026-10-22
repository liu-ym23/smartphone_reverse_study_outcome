package com.ss.android.lark.image;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.impl.service.ImageService;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import com.ss.android.lark.utils.p;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements clb.a {
    public f() {
    }

    @Override // clb.a
    public final boolean c() {
        return idb.f.a().isEnable("lark.image.jpeg.tool.safe.read.disable");
    }

    @Override // clb.a
    public final void e(String r100, ProfileCoverUploader$uploadImage$1 r101) {
        ImageService.inst().uploadProfileCoverFile(r100, r101);
    }

    @Override // clb.a
    public final void g(List r100, StickerUploader$batchUploadImage$1 r101) {
        ImageService.inst().uploadSticker(r100, r101);
    }

    @Override // clb.a
    public final void h(String r100, BackgroundUploader$uploadImage$1 r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        int[] r103 = p.g(r100);
        ImageService.inst().uploadEncryptImage(r102, r103[0], r103[1], false, true, r101);
    }

    @Override // clb.a
    public final void i(String r100, AvatarUploader$uploadImage$1 r101) {
        ImageService.inst().uploadAvatar(r100, r101);
    }

    @Override // clb.a
    public final void d(PolarisFileWrapper r100, int r101, int r110, boolean r111, EncryptImageUploader$uploadImage$1 r112) {
        ImageService.inst().uploadEncryptImage(r100, r101, r110, true, r111, r112);
    }

    @Override // clb.a
    public final int[] f(long r100, int r110, int r111, int r112, int r113, int r114) {
        return ImageService.inst().getImageCompressParams(r100, r110, r111, r112, r113, r114);
    }
}
