package com.ss.android.lark.widget.photo.preview.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447154a = 0;

    static {
    }

    public static PhotoItem.PicInfo d(Image r100) {
        if (r100 != null) goto L5;
        return new PhotoItem.PicInfo("", new ArrayList(), 0, 0);
    L5:
        return new PhotoItem.PicInfo(r100.getKey(), r100.getUrls(), r100.getWidth(), r100.getHeight(), new EncryptImage(r100.getKey(), r100.getFsUnit(), r100.getCrypto()));
    }

    public static PhotoItem a(ImageSet r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "imageSet");
        List r102 = b(CollectionsKt.listOf(r100), r101);
        if ((!((ArrayList) r102).isEmpty()) == true) goto L5;
        return null;
    L5:
        return (PhotoItem) ListProtector.get(r102, 0);
    }

    public static List b(List r100, String r110) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L39:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L39;
        Iterator r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L39;
        ImageSet r103 = (ImageSet) r102.next();
        if (r103 == null) goto L9;
        Image r104 = r103.getOrigin();
        if (r104 == null) goto L15;
        MediaExtra r105 = null;
        if (TextUtils.isEmpty(r104.getKey()) == false) goto L29;
        if (TextUtils.isEmpty(r104.getToken()) == false) goto L20;
        if ((r103 instanceof MediaImageSet) == true) goto L26;
        Log.e("PhotoItemGenerator", "PhotoItem key and token is empty, filter");
        goto L9
    L26:
        Log.e("PhotoItemGenerator", "Media PhotoItem set imageSet null ");
    L27:
        Object r106 = null;
    L30:
        String r107 = r104.getKey();
        String r108 = r104.getToken();
        MessageIdentity r109 = r103.getMessageIdentity();
        if (r109 != null) goto L33;
    L34:
        r109 = new MessageIdentity(r110, "");
    L35:
        r109.setSenderTenantId(r103.getSenderTenantId());
        PhotoItem r111 = new PhotoItem().setPaths(r104.getUrls()).setImageKey(r107).setLoadModel(r106).setIntactPicInfo(d(r103.getIntact())).setOriginPicInfo(d(r103.getOrigin())).setMiddlePicInfo(d(r103.getMiddle())).setThumbnailPicInfo(d(r103.getThumbnail())).setInlinePreview(r103.getInlinePreview()).setMessageIdentity(r109).setType(2).setToken(r108);
        Intrinsics.checkNotNullParameter(r103, "imageSet");
        if ((r103 instanceof MediaImageSet) == false) goto L38;
        r105 = ((MediaImageSet) r103).getMediaExtra();
    L38:
        PhotoItem r112 = r111.setMediaExtra(r105).setOriginSource(r103.isOriginSource()).setHasPreviewPermission(r103.isHasPreviewPermission()).setOriginSize(r103.getOriginSize()).setEntityId(r109.getSourceId()).setReceiveAuthorizationStateValue(r103.getReceiveAuthorizationStateValue()).setValidateIMFileResult(r103.getValidateIMFileResult()).setResourceIsCleaned(com.ss.android.lark.chat.entity.image.a.a(r103)).setResourceCleanScene(r103.getResourceCleanScene());
        r112.getTranslateProperty().setTranslated(r103.isTranslated());
        r112.getPhotoState().setFromMe(r103.isFromMe());
        r101.add(r112);
        goto L9
    L33:
        if (TextUtils.isEmpty(r109.getMessageId()) == false) goto L35;
    L20:
        Log.e("PhotoItemGenerator", "PhotoItem secure key is empty, use token directly.");
        r104.setKey(r104.getToken());
        if (CollectionUtils.isEmpty(r104.getUrls()) == true) goto L27;
        r106 = ListProtector.get(r104.getUrls(), 0);
        goto L30
    L29:
        r106 = new EncryptImage(r104.getKey(), r104.getFsUnit(), r104.getCrypto());
        goto L30
    L15:
        Log.e("PhotoItemGenerator", "PhotoItem getOrigin image is empty");
        goto L9
    }

    public static List c(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "images");
        ArrayList r102 = new ArrayList();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r102;
    L5:
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        Image r104 = (Image) r103.next();
        if (r104 == null) goto L10;
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L13;
        String r105 = r104.getKey();
        String r106 = r104.getToken();
        PhotoItem r107 = new PhotoItem().setPaths(r104.getUrls()).setImageKey(r105).setLoadModel(new EncryptImage(r105, r104.getFsUnit(), r104.getCrypto())).setType(2).setToken(r106).setMessageId(r101);
        r107.getTranslateProperty().setTranslated(false);
        r107.setResourceCleanScene(r104.getResourceCleanScene());
        r107.setResourceIsCleaned(r104.isResourceIsCleaned());
        r102.add(r107);
        goto L7
    L13:
        Log.e("PhotoItemGenerator", "PhotoItem secure key is empty");
        goto L7
    L10:
        Log.e("PhotoItemGenerator", "PhotoItem image is empty");
        goto L7
    L15:
        return r102;
    }
}
