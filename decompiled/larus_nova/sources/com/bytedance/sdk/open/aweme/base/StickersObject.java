package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.aweme.base.openentity.CustomSticker;
import com.bytedance.sdk.open.aweme.base.openentity.HashtagSticker;
import com.bytedance.sdk.open.aweme.base.openentity.MentionSticker;
import com.bytedance.sdk.open.aweme.base.openentity.PoiSticker;
import com.bytedance.sdk.open.aweme.base.openentity.QuickFlashSticker;
import com.bytedance.sdk.open.aweme.base.openentity.Sticker;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class StickersObject {
    private static final String TAG = "StickersObject";
    private ArrayList<CustomSticker> customStickers;
    private ArrayList<HashtagSticker> hashtagStickers;
    private ArrayList<MentionSticker> mentionStickers;
    private PoiSticker poiSticker;
    private QuickFlashSticker quickFlashSticker;

    public static class a extends TypeToken<List<MentionSticker>> {
        public a() {
        }
    }

    public static class b extends TypeToken<List<HashtagSticker>> {
        public b() {
        }
    }

    public static class c extends TypeToken<List<CustomSticker>> {
        public c() {
        }
    }

    public StickersObject() {
    }

    public static StickersObject unSerialize(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        StickersObject r101 = new StickersObject();
        Gson r102 = new Gson();
        String r103 = r100.getString(ParamKeyConstants.ShareParams.SHARE_MENTION_STICKER_LIST);
        if (TextUtils.isEmpty(r103) == false) goto L37;
    L11:
        String r104 = r100.getString(ParamKeyConstants.ShareParams.SHARE_HASHTAG_STICKER_LIST);
        if (TextUtils.isEmpty(r104) == false) goto L41;
    L17:
        String r105 = r100.getString(ParamKeyConstants.ShareParams.SHARE_CUSTOM_STICKER_LIST);
        if (TextUtils.isEmpty(r105) == false) goto L33;
    L23:
        String r106 = r100.getString(ParamKeyConstants.ShareParams.SHARE_POI_STICKER);
        if (TextUtils.isEmpty(r106) == false) goto L39;
    L28:
        String r107 = r100.getString(ParamKeyConstants.ShareParams.SHARE_QUICK_FLASH_STICKER);
        if (TextUtils.isEmpty(r107) == false) goto L35;
    L31:
        return r101;
    L35:
        r101.quickFlashSticker = (QuickFlashSticker) r102.fromJson(r107, QuickFlashSticker.class);     // Catch: Exception -> L32
        goto L31
    L39:
        r101.poiSticker = (PoiSticker) r102.fromJson(r106, PoiSticker.class);     // Catch: Exception -> L27
        goto L28
    L33:
        r101.customStickers = (ArrayList) GsonProtectorUtils.fromJson(r102, r105, new c().getType());     // Catch: JsonSyntaxException -> L21
    L21:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{e.getMessage()});
        goto L23
    L41:
        r101.hashtagStickers = (ArrayList) GsonProtectorUtils.fromJson(r102, r104, new b().getType());     // Catch: JsonSyntaxException -> L15
    L15:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{e.getMessage()});
        goto L17
    L37:
        r101.mentionStickers = (ArrayList) GsonProtectorUtils.fromJson(r102, r103, new a().getType());     // Catch: JsonSyntaxException -> L9
    L9:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{e.getMessage()});
        goto L11
    }

    public boolean addSticker(Sticker r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.checkArg() == true) goto L9;
        return false;
    L9:
        if ((r100 instanceof HashtagSticker) == false) goto L17;
        if (this.hashtagStickers != null) goto L13;
        this.hashtagStickers = new ArrayList();
    L13:
        ArrayList r101 = this.hashtagStickers;
        Sticker r102 = (HashtagSticker) r100;
    L15:
        return r101.add(r102);
    L17:
        if ((r100 instanceof MentionSticker) == false) goto L23;
        if (this.mentionStickers != null) goto L21;
        this.mentionStickers = new ArrayList();
    L21:
        r101 = this.mentionStickers;
        r102 = (MentionSticker) r100;
        goto L15
    L23:
        if ((r100 instanceof CustomSticker) == false) goto L29;
        if (this.customStickers != null) goto L27;
        this.customStickers = new ArrayList();
    L27:
        r101 = this.customStickers;
        r102 = (CustomSticker) r100;
        goto L15
    L29:
        if ((r100 instanceof PoiSticker) == false) goto L33;
        this.poiSticker = (PoiSticker) r100;
        return true;
    L33:
        if ((r100 instanceof QuickFlashSticker) == false) goto L36;
        this.quickFlashSticker = (QuickFlashSticker) r100;
        return true;
    L36:
        return false;
    }

    public void serialize(Bundle r100) {
        Gson r101 = new Gson();
        ArrayList<HashtagSticker> r102 = this.hashtagStickers;
        if (r102 != null) goto L5;
    L7:
        ArrayList<MentionSticker> r103 = this.mentionStickers;
        if (r103 != null) goto L10;
    L12:
        ArrayList<CustomSticker> r104 = this.customStickers;
        if (r104 != null) goto L15;
    L17:
        PoiSticker r105 = this.poiSticker;
        if (r105 == null) goto L20;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_POI_STICKER, GsonProtectorUtils.toJson(r101, r105));
    L20:
        QuickFlashSticker r106 = this.quickFlashSticker;
        if (r106 == null) goto L24;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_QUICK_FLASH_STICKER, GsonProtectorUtils.toJson(r101, r106));
        return;
    L24:
        return;
    L15:
        if (r104.isEmpty() == true) goto L17;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_CUSTOM_STICKER_LIST, GsonProtectorUtils.toJson(r101, this.customStickers));
        goto L17
    L10:
        if (r103.isEmpty() == true) goto L12;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_MENTION_STICKER_LIST, GsonProtectorUtils.toJson(r101, this.mentionStickers));
        goto L12
    L5:
        if (r102.isEmpty() == true) goto L7;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_HASHTAG_STICKER_LIST, GsonProtectorUtils.toJson(r101, this.hashtagStickers));
        goto L7
    }
}
