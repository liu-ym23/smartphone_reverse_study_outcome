package com.ss.android.lark.image.impl.service;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateCustomizedStickersRequest;
import com.bytedance.lark.pb.media.v1.GetImageCompressParametersRequest;
import com.bytedance.lark.pb.media.v1.GetImageCompressParametersResponse;
import com.bytedance.lark.pb.media.v1.UploadAudioResponse;
import com.bytedance.lark.pb.media.v1.UploadAvatarRequest;
import com.bytedance.lark.pb.media.v1.UploadImageV2Request;
import com.bytedance.lark.pb.media.v1.UploadImageV2Response;
import com.bytedance.lark.pb.media.v1.UploadSecureImageRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.p;
import io.reactivex.Observable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public class ImageService {

    public static final class HOLDER {
        private static final ImageService INSTANCE = null;

        static {
            INSTANCE = new ImageService();
        }

        public static /* synthetic */ ImageService access$000() {
            return INSTANCE;
        }
    }

    public ImageService() {
    }

    public static /* synthetic */ String a(byte[] r100) {
        return lambda$uploadAvatar$3(r100);
    }

    public static /* synthetic */ int[] b(byte[] r100) {
        return lambda$getImageCompressParams$1(r100);
    }

    public static /* synthetic */ String c(byte[] r100) {
        return lambda$uploadProfileCoverFile$2(r100);
    }

    public static /* synthetic */ com.ss.android.lark.image.entity.d d(File r100) {
        return lambda$getImageInfo$0(r100);
    }

    public static ImageService inst() {
        return HOLDER.access$000();
    }

    private static /* synthetic */ int[] lambda$getImageCompressParams$1(byte[] r100) throws IOException {
        GetImageCompressParametersResponse r101 = GetImageCompressParametersResponse.ADAPTER.decode(r100);
        return new int[]{r101.short_side.intValue(), r101.quality.intValue()};
    }

    private static /* synthetic */ com.ss.android.lark.image.entity.d lambda$getImageInfo$0(File r100) throws Exception {
        return new com.ss.android.lark.image.entity.d(r100, p.g(r100.getPath()));
    }

    private static /* synthetic */ String lambda$uploadAvatar$3(byte[] r100) throws IOException {
        return UploadAudioResponse.ADAPTER.decode(r100).local_key;
    }

    private static /* synthetic */ String lambda$uploadProfileCoverFile$2(byte[] r100) throws IOException {
        return UploadImageV2Response.ADAPTER.decode(r100).image_key;
    }

    public Observable<com.ss.android.lark.image.entity.d> getImageInfo(final File r100) {
        return Observable.fromCallable(new d(r100));
    }

    public void uploadAvatar(String r100, IGetDataCallback<String> r101) {
        byte[] r102 = FileUtils.j(r100);
        UploadAvatarRequest.Builder r103 = new UploadAvatarRequest.Builder().image(ByteString.of(r102)).need_mosaic(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_AVATAR, r103, r101, new b());
    }

    public void uploadProfileCoverFile(String r100, IGetDataCallback<String> r101) {
        byte[] r102 = FileUtils.j(r100);
        UploadImageV2Request.Builder r103 = new UploadImageV2Request.Builder().image(ByteString.of(r102)).image_type(UploadImageV2Request.ImageType.ProfileTopImage);
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_IMAGE_V2, r103, r101, new c());
    }

    public void uploadSticker(List<String> r100, IGetDataCallback<List<String>> r101) {
        CreateCustomizedStickersRequest.Builder r102 = new CreateCustomizedStickersRequest.Builder().type(CreateCustomizedStickersRequest.Type.IMAGE_PATH).image_paths(r100);
        SdkSender.asynSendRequestNonWrap(Command.CREATE_CUSTOMIZED_STICKERS, r102, r101, new AnonymousClass5(this));
    }

    public Observable<String> uploadEncryptImage(final File r100, final int r110, final int r111, final boolean r112, final boolean r113) {
        return Observable.create(new AnonymousClass4(this, r100, r110, r111, r112, r113));
    }

    public int[] getImageCompressParams(long r100, int r101, int r102, int r103, int r104, int r105) {
        GetImageCompressParametersRequest.Builder r106 = new GetImageCompressParametersRequest.Builder().short_side(Integer.valueOf(r101)).long_side(Integer.valueOf(r102)).quality(Integer.valueOf(r103)).image_size(Long.valueOf(r100));
        if (r104 <= 0) goto L5;
        r106.target_short_side(Integer.valueOf(r104));
    L5:
        if (r105 <= 0) goto L8;
        r106.target_quality(Integer.valueOf(r105));
    L8:
        return (int[]) SdkSender.syncSend(Command.GET_IMAGE_COMPRESS_PARAMETERS, r106, new a());
    }

    public void uploadEncryptImage(File r100, int r101, int r102, boolean r103, boolean r104, IGetDataCallback<String> r105) {
        byte[] r106 = FileUtils.j(r100.getAbsolutePath());
        if (r103 == false) goto L5;
        UploadSecureImageRequest.Type r107 = UploadSecureImageRequest.Type.POST;
    L6:
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_SECURE_IMAGE, new UploadSecureImageRequest.Builder().width(Integer.valueOf(r101)).height(Integer.valueOf(r102)).image(ByteString.of(r106)).is_secret_chat_image(Boolean.valueOf(!r104)).type(r107), new CapacityCallback(r105), new AnonymousClass2(this));
        return;
    L5:
        r107 = UploadSecureImageRequest.Type.NORMAL;
        goto L6
    }

    public Observable<com.ss.android.lark.image.entity.d> compressImage(final Context r110, final File r111, final boolean r112, final int r113, final int r114, final Biz r115, final Scene r116) {
        return Observable.fromCallable(new AnonymousClass1(this, r110, r113, r114, r112, r111, r115, r116));
    }
}
