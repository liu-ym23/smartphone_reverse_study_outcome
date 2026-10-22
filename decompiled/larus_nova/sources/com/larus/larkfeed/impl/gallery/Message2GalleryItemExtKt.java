package com.larus.larkfeed.impl.gallery;

import androidx.camera.video.AudioStats;
import com.larus.bmhome.chat.service.IMainBotCommonService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.VideoData;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class Message2GalleryItemExtKt {
    public static final Object b(kza.p r110, Continuation<? super nr9.g> r111) {
        kza.p r100 = r110;
        if ((r111 instanceof Message2GalleryItemExtKt$toVideoPlayData$1) == false) goto L7;
        Message2GalleryItemExtKt$toVideoPlayData$1 r101 = (Message2GalleryItemExtKt$toVideoPlayData$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (kza.p) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        Pair r106 = (Pair) r103;
        String r107 = (String) r106.component1();
        String r108 = (String) r106.component2();
        String r109 = r100.f506797a;
        String r112 = r100.f506798b;
        Double r113 = r100.f506800d;
        String r114 = r100.f506804h;
        Integer r115 = r100.f506802f;
        return new nr9.g(r109, r112, r107, null, r113, null, new nr9.f(null, r108, null, r100.f506801e, r115, null, 37), r114, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r116 = Dispatchers.getIO();
        Message2GalleryItemExtKt$toVideoPlayData$2 r117 = new Message2GalleryItemExtKt$toVideoPlayData$2(r100, null);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = BuildersKt.withContext(r116, r117, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new Message2GalleryItemExtKt$toVideoPlayData$1(r111);
        goto L8
    }

    public static final n a(String r310, Message r311, int r312) {
        Intrinsics.checkNotNullParameter(r310, "larkMessageId");
        int r110 = 0;
        int r111 = 1;
        if (r311 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        String r112 = "Message2GalleryItemExt";
        String r101 = "message#";
        int r102 = -1;
        if (r100 == false) goto L96;
        ArrayList r103 = new ArrayList();
        if (r311 == null) goto L134;
        Iterator r113 = ((ArrayList) com.larus.im.bean.message.a.l(r311)).iterator();
        int r104 = 0;
        int r114 = 0;
    L14:
        if (r113.hasNext() == false) goto L134;
        Object r105 = r113.next();
        int r115 = r104 + 1;
        if (r104 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        CreationItem r106 = (CreationItem) r105;
        if (r104 != r312) goto L21;
        int r210 = r114;
    L22:
        Integer r107 = r106.type;
        if (r107 != null) goto L26;
    L52:
        ArrayList r116 = r103;
        String r117 = r101;
        Integer r108 = r106.type;
        if (r108 != null) goto L56;
    L93:
        String r118 = r112;
        ArrayList r109 = r116;
        FLogger.f375446a.e(r118, "unknown type: " + r106.type);
    L94:
        r103 = r109;
        r112 = r118;
        r101 = r117;
        r104 = r115;
        r102 = r210;
        r111 = 1;
        goto L14
    L56:
        if (r108.intValue() != 2) goto L93;
        VideoData r119 = r106.video;
        if (r119 == null) goto L60;
        String r120 = r119.downloadUrl;
    L61:
        if (r120 == null) goto L88;
        GalleryType r211 = GalleryType.Video;
        if (r119 == null) goto L65;
        String r121 = r119.vid;
    L66:
        if (r119 == null) goto L68;
        String r122 = r119.downloadUrl;
    L69:
        Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1 r123 = new Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$1(r106, null);
        VideoData r124 = r106.video;
        if (r124 == null) goto L74;
        Double r125 = r124.duration;
        if (r125 == null) goto L74;
        double r126 = r125.doubleValue();
    L75:
        Double r127 = Double.valueOf(r126);
        VideoData r128 = r106.video;
        if (r128 == null) goto L80;
        Long r129 = r128.height;
        if (r129 == null) goto L80;
        int r130 = (int) r129.longValue();
    L81:
        Integer r131 = Integer.valueOf(r130);
        VideoData r132 = r106.video;
        if (r132 == null) goto L86;
        Long r133 = r132.width;
        if (r133 == null) goto L86;
        int r134 = (int) r133.longValue();
    L87:
        r118 = r112;
        kza.m r135 = new kza.m(r211, null, new kza.p(r121, r122, r123, r127, r131, Integer.valueOf(r134), null, null, new Message2GalleryItemExtKt$createCreationGalleryPreviewItems$1$item$2(r106, null), null, r311, 1472), r310, GalleryItemType.Doubao, r114, null, 66);
        r109 = r116;
        r109.add(r135);
        r114 = r114 + 1;
    L86:
        r134 = 0;
    L80:
        r130 = 0;
    L74:
        r126 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L75
    L68:
        r122 = null;
        goto L69
    L65:
        r121 = null;
        goto L66
    L88:
        r118 = r112;
        r109 = r116;
        FLogger r136 = FLogger.f375446a;
        StringBuilder r137 = new StringBuilder(r117);
        r137.append(r311.getMessageId());
        r137.append(" video index ");
        r137.append(r104);
        r137.append(" preview url is null, video status: ");
        VideoData r138 = r106.video;
        if (r138 == null) goto L91;
        Integer r139 = r138.status;
    L92:
        r137.append(r139);
        r136.i(r118, r137.toString());
        goto L94
    L91:
        r139 = null;
        goto L92
    L60:
        r120 = null;
        goto L61
    L26:
        if (r107.intValue() != r111) goto L52;
        ImageData r140 = r106.image;
        if (r140 == null) goto L33;
        ImageObj r141 = r140.imagePreview;
        if (r141 == null) goto L33;
        String r142 = r141.url;
        if (r142 == null) goto L33;
    L38:
        if (r142 == null) goto L47;
        GalleryType r212 = GalleryType.Image;
        if (r140 == null) goto L44;
        ImageObj r143 = r140.imageThumb;
        if (r143 == null) goto L44;
        String r144 = r143.url;
    L45:
        ArrayList r145 = r103;
        r117 = r101;
        r145.add(new kza.m(r212, new kza.l(r142, r144, null, null, false, r311, 115), null, r310, GalleryItemType.Doubao, r114, null, 68));
        r114 = r114 + 1;
    L46:
        r118 = r112;
        r109 = r145;
    L44:
        r144 = null;
        goto L45
    L47:
        r145 = r103;
        r117 = r101;
        FLogger r146 = FLogger.f375446a;
        StringBuilder r147 = new StringBuilder(r117);
        r147.append(r311.getMessageId());
        r147.append(" image index ");
        r147.append(r104);
        r147.append(" preview url is null, image status: ");
        ImageData r148 = r106.image;
        if (r148 == null) goto L50;
        Integer r149 = r148.status;
    L51:
        r147.append(r149);
        r146.i(r112, r147.toString());
        goto L46
    L50:
        r149 = null;
    L33:
        if (r140 == null) goto L37;
        ImageObj r150 = r140.imageOrigin;
        if (r150 == null) goto L37;
        r142 = r150.url;
    L37:
        r142 = null;
        goto L38
    L21:
        r210 = r102;
    L134:
        return new n(r103, r102);
    L96:
        String r151 = "Message2GalleryItemExt";
        ArrayList r152 = new ArrayList();
        Iterator<T> r153 = IMainBotCommonService.f308723a.a(r311).iterator();
        int r154 = 0;
    L98:
        if (r153.hasNext() == false) goto L125;
        Object r155 = r153.next();
        int r156 = r154 + 1;
        if (r154 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        SearchImageInfo r157 = (SearchImageInfo) r155;
        String r158 = r151;
        if (r154 != r312) goto L105;
        int r159 = r110;
    L106:
        String r160 = r157.getOriginThumbUrl();
        if (r160 != null) goto L109;
        r160 = r157.getThumbUrl();
    L109:
        String r161 = r160;
        List<String> r162 = r157.getFullSizeUrl();
        if (r162 == null) goto L115;
        String r163 = (String) CollectionsKt.firstOrNull(r162);
        if (r163 == null) goto L115;
        String r164 = r163;
    L116:
        if (r164 == null) goto L118;
        String r165 = r158;
        r152.add(new kza.m(GalleryType.Image, new kza.l(r164, r161, null, null, false, r311, 115), null, r310, GalleryItemType.Doubao, r110, null, 68));
        r110 = r110 + 1;
    L123:
        r151 = r165;
        r154 = r156;
        r102 = r159;
        goto L98
    L118:
        r165 = r158;
        FLogger r166 = FLogger.f375446a;
        StringBuilder r167 = new StringBuilder("message#");
        if (r311 == null) goto L121;
        String r168 = r311.getMessageId();
    L122:
        r167.append(r168);
        r167.append(" search image preview url is null, itemId: ");
        r167.append(r157.getItemId());
        r166.i(r165, r167.toString());
        goto L123
    L121:
        r168 = null;
    L115:
        r164 = r161;
        goto L116
    L105:
        r159 = r102;
        goto L106
    L125:
        return new n(r152, r102);
    L5:
        if ((!((ArrayList) com.larus.im.bean.message.a.l(r311)).isEmpty()) != true) goto L7;
        r100 = true;
        goto L8
    }
}
