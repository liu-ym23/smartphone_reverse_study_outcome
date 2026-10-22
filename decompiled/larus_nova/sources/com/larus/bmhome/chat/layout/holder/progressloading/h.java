package com.larus.bmhome.chat.layout.holder.progressloading;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.layout.holder.image.ImageHolderDispatcher;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ttnet.org.chromium.net.NetError;
import hq9.v3;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f304046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f304047b = null;

    static {
        f304046a = LazyKt.lazy(new f());
        f304047b = LazyKt.lazy(new g());
    }

    public static LoadingType a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (dp8.a.a(r100) == false) goto L7;
        return LoadingType.IMAGE_SCROLL_LOADING;
    L7:
        if (((v3) f304046a.getValue()).f486796a != 0) goto L10;
        return null;
    L10:
        if (d(r100) == true) goto L12;
        return null;
    L12:
        if (((Boolean) f304047b.getValue()).booleanValue() == true) goto L16;
        return LoadingType.TEXT_PROGRESS_LOADING;
    L16:
        if (b0.h(r100) == false) goto L20;
        return LoadingType.COMMON_LOADING;
    L20:
        if (((Boolean) ImageHolderDispatcher.f303725a.getValue()).booleanValue() == true) goto L35;
        ImageContentData r101 = ImageHolderDispatcher.a(e(r100));
        if (r101 == null) goto L29;
        List<ImageItem> r102 = r101.getImageList();
        if (r102 == null) goto L29;
        boolean r103 = true;
        if (r102.size() != 1) goto L29;
    L30:
        if (r103 == false) goto L33;
        return LoadingType.SINGLE_IMAGE_LOADING;
    L33:
        return LoadingType.IMAGE4_LOADING;
    L29:
        r103 = false;
        goto L30
    L35:
        return LoadingType.IMAGE_SCROLL_LOADING;
    }

    public static String b(Message r100) {
        if (com.larus.im.bean.message.a.r0(r100) == false) goto L12;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L7;
        String r102 = r101.get(MusicAppletPage.KEY_MESSAGE_ID);
    L8:
        FLogger.f375446a.i("ProgressLoadingHolderDispatcher", "getResultMessageId result msgId of serverLoading " + r102);
        if (o0.d(r102) == false) goto L12;
        return r102;
    L7:
        r102 = null;
    L12:
        return r100.getMessageId();
    }

    public static boolean c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.larus.bmhome.chat.bean.d.a0(r100) == false) goto L5;
        return false;
    L5:
        LoadingType r101 = a(r100);
        if (r101 != LoadingType.IMAGE_SCROLL_LOADING) goto L8;
    L11:
        return true;
    L8:
        if (r101 == LoadingType.SINGLE_IMAGE_LOADING) goto L11;
        if (r101 == LoadingType.IMAGE4_LOADING) goto L11;
        return false;
    }

    public static boolean d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"image", CreativeScene.AVATAR_IMAGE, CreativeScene.AI_BEAUTIFY_IMAGE}), ap8.a.b(r100)) == false) goto L7;
        if (com.larus.im.bean.message.a.r0(r100) == false) goto L7;
        return true;
    L7:
        if (r100.getContentType() != 6) goto L16;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b0.h(r100) == true) goto L11;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == false) goto L16;
        return true;
    L11:
        if (r100.getContentType() != 6) goto L13;
        r101 = true;
    L16:
        return false;
    }

    public static Message e(Message r410) {
        Intrinsics.checkNotNullParameter(r410, "<this>");
        String r100 = ap8.a.b(r410);
        if (r100 == null) goto L55;
        int r101 = r100.hashCode();
        if (r101 == (-2096799662)) goto L18;
        if (r101 == (-578836747)) goto L15;
        if (r101 != 100313435) goto L55;
        if (r100.equals("image") == false) goto L55;
    L21:
        if (Intrinsics.areEqual(ap8.a.b(r410), "image") == false) goto L23;
    L26:
        JsonObject r102 = new JsonObject();
        JsonArray r103 = new JsonArray();
        Map<String, String> r104 = r410.getExt();
        int r105 = 1;
        if (r104 == null) goto L33;
        String r106 = r104.get("creativity_resp_num");
        if (r106 == null) goto L33;
        Integer r107 = StringsKt.toIntOrNull(r106);
        if (r107 == null) goto L33;
        int r108 = r107.intValue();
    L34:
        Map<String, String> r109 = r410.getExt();
        int r110 = 300;
        if (r109 == null) goto L41;
        String r111 = r109.get("creativity_img_width_scale");
        if (r111 == null) goto L41;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L41;
        int r113 = r112.intValue();
    L42:
        Map<String, String> r114 = r410.getExt();
        if (r114 == null) goto L49;
        String r115 = r114.get("creativity_img_height_scale");
        if (r115 == null) goto L49;
        Integer r116 = StringsKt.toIntOrNull(r115);
        if (r116 == null) goto L49;
        r110 = r116.intValue();
    L49:
        if (1 > r108) goto L53;
    L50:
        JsonObject r117 = new JsonObject();
        r117.addProperty("key", "image_sketch_loading_" + r105);
        r117.addProperty("key", "image_sketch_loading_" + r105);
        JsonObject r118 = new JsonObject();
        r118.addProperty("width", Integer.valueOf(r113));
        r118.addProperty("height", Integer.valueOf(r110));
        r117.add("image_ori", r118);
        r103.add(r117);
        if (r105 == r108) goto L53;
        r105 = r105 + 1;
    L53:
        r102.add("image_list", r103);
        return Message.copy$default(r410, null, null, null, 0, 0, null, 6, false, null, r102.toString(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, NetError.ERR_TTNET_BIS_INVALID_CONNECTION_COMPLETION, 31, null);
    L41:
        r113 = 300;
    L33:
        r108 = 1;
        goto L34
    L23:
        if (Intrinsics.areEqual(ap8.a.b(r410), CreativeScene.AVATAR_IMAGE) == true) goto L26;
        if (Intrinsics.areEqual(ap8.a.b(r410), CreativeScene.AI_BEAUTIFY_IMAGE) == false) goto L55;
    L15:
        if (r100.equals(CreativeScene.AVATAR_IMAGE) == false) goto L55;
    L18:
        if (r100.equals(CreativeScene.AI_BEAUTIFY_IMAGE) == true) goto L21;
    L55:
        return r410;
    }
}
