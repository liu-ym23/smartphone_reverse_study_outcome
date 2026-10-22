package com.larus.bmhome.chat.standarduikit.floatingthink.utils;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import yc9.n1;

/* JADX INFO: loaded from: classes26.dex */
public final class ClarificationAnswerAttachmentPreviewer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClarificationAnswerAttachmentPreviewer f309161a = null;

    static {
        f309161a = new ClarificationAnswerAttachmentPreviewer();
    }

    public ClarificationAnswerAttachmentPreviewer() {
    }

    public static String b(UplinkFileEntity r100) {
        if (n1.d(r100) == true) goto L5;
        return null;
    L5:
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L22;
        Image r102 = r101.getUplinkImageInfo();
        if (r102 != null) goto L11;
        return null;
    L11:
        if (c(r102) == false) goto L13;
        return null;
    L13:
        String r103 = r102.key;
        if (r103 != null) goto L16;
        return null;
    L16:
        if (r103.length() <= 0) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L21;
        return null;
    L21:
        return r103;
    L18:
        r104 = false;
        goto L19
    L22:
        return null;
    }

    public static boolean c(Image r100) {
        ImageObj r101 = r100.imageThumb;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.url;
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L38;
        ImageObj r105 = r100.imageOri;
        if (r105 == null) goto L17;
        String r106 = r105.url;
    L18:
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L39;
        ImageObj r108 = r100.previewImage;
        if (r108 == null) goto L28;
        r102 = r108.url;
    L28:
        if (r102 != null) goto L30;
    L33:
        boolean r109 = true;
    L34:
        if (r109 == false) goto L40;
        return false;
    L40:
        return true;
    L30:
        if (r102.length() == 0) goto L33;
        r109 = false;
        goto L34
    L39:
        return true;
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L24
    L17:
        r106 = null;
        goto L18
    L38:
        return true;
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public static ImageObj a(ImageObj r100, String r101) {
        if (r100 == null) goto L6;
        ImageObj r102 = ImageObj.copy$default(r100, r101, 0, 0, null, null, 30, null);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return new ImageObj(r101, 0, 0, null, null, 30, null);
    }

    public final Object d(List<UplinkFileEntity> r410, Continuation<? super List<UplinkFileEntity>> r411) {
        List<UplinkFileEntity> r100 = r410;
        if ((r411 instanceof ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1) == false) goto L7;
        ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1 r101 = (ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1) r411;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L26:
        Map r106 = (Map) r103;
        if (r106.isEmpty() == false) goto L29;
        return r100;
    L29:
        List<UplinkFileEntity> r107 = r100;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L31:
        if (r109.hasNext() == false) goto L57;
        UplinkFileEntity r110 = (UplinkFileEntity) r109.next();
        String r111 = b(r110);
        if (r111 == null) goto L56;
        String r112 = (String) r106.get(r111);
        if (r112 == null) goto L56;
        if (r112.length() <= 0) goto L40;
        boolean r113 = true;
    L41:
        if (r113 == true) goto L44;
        r112 = null;
    L44:
        if (r112 == null) goto L56;
        UplinkEntityContent r114 = r110.getUplinkEntityContent();
        if (r114 == null) goto L56;
        Image r115 = r114.getUplinkImageInfo();
        if (r115 == null) goto L56;
        if (c(r115) == true) goto L56;
        r110 = UplinkFileEntity.copy$default(r110, null, UplinkEntityContent.copy$default(r114, null, Image.copy$default(r115, null, null, a(r115.imageThumb, r112), a(r115.imageOri, r112), null, null, null, null, null, null, null, null, null, null, 16371, null), 1, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L56
    L40:
        r113 = false;
    L56:
        r108.add(r110);
        goto L31
    L57:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r100.iterator();
    L16:
        if (r117.hasNext() == false) goto L20;
        String r118 = b((UplinkFileEntity) r117.next());
        if (r118 == null) goto L16;
        r116.add(r118);
        goto L16
    L20:
        List r119 = CollectionsKt.distinct(r116);
        if (r119.isEmpty() == false) goto L23;
        return r100;
    L23:
        r101.L$0 = r100;
        r101.label = 1;
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2(r119, null), r101);
        if (r103 != r104) goto L26;
        return r104;
    L7:
        r101 = new ClarificationAnswerAttachmentPreviewer$hydrateMissingImageUrls$1(this, r411);
        goto L8
    }
}
