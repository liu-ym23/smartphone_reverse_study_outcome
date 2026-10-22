package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.aweme.base.openentity.HashtagTitleMarker;
import com.bytedance.sdk.open.aweme.base.openentity.MentionTitleMarker;
import com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class TitleObject {
    private static final String TAG = "TitleObject";
    private ArrayList<HashtagTitleMarker> hashtagTitleMarkers;
    private ArrayList<MentionTitleMarker> mentionTitleMarkers;
    public String title;

    public static class a extends TypeToken<List<MentionTitleMarker>> {
        public a() {
        }
    }

    public static class b extends TypeToken<List<HashtagTitleMarker>> {
        public b() {
        }
    }

    public TitleObject() {
    }

    public static TitleObject unSerialize(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TitleObject r101 = new TitleObject();
        r101.title = r100.getString(ParamKeyConstants.ShareParams.SHARE_TITLE);
        Gson r102 = new Gson();
        String r103 = r100.getString(ParamKeyConstants.ShareParams.SHARE_TITLE_MENTION_LIST);
        if (TextUtils.isEmpty(r103) == false) goto L20;
    L11:
        String r104 = r100.getString(ParamKeyConstants.ShareParams.SHARE_TITLE_HASHTAG_LIST);
        if (TextUtils.isEmpty(r104) == false) goto L18;
    L17:
        return r101;
    L18:
        r101.hashtagTitleMarkers = (ArrayList) GsonProtectorUtils.fromJson(r102, r104, new b().getType());     // Catch: JsonSyntaxException -> L15
    L15:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{e.getMessage()});
        goto L17
    L20:
        r101.mentionTitleMarkers = (ArrayList) GsonProtectorUtils.fromJson(r102, r103, new a().getType());     // Catch: JsonSyntaxException -> L9
    L9:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{e.getMessage()});
        goto L11
    }

    public boolean addMarker(PublishTitleMarker r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.checkArgs() == true) goto L9;
        return false;
    L9:
        if ((r100 instanceof HashtagTitleMarker) == false) goto L17;
        if (this.hashtagTitleMarkers != null) goto L13;
        this.hashtagTitleMarkers = new ArrayList();
    L13:
        ArrayList r101 = this.hashtagTitleMarkers;
        PublishTitleMarker r102 = (HashtagTitleMarker) r100;
    L15:
        return r101.add(r102);
    L17:
        if ((r100 instanceof MentionTitleMarker) == true) goto L19;
        return false;
    L19:
        if (this.mentionTitleMarkers != null) goto L21;
        this.mentionTitleMarkers = new ArrayList();
    L21:
        r101 = this.mentionTitleMarkers;
        r102 = (MentionTitleMarker) r100;
        goto L15
    }

    public void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putString(ParamKeyConstants.ShareParams.SHARE_TITLE, this.title);
        Gson r101 = new Gson();
        ArrayList<HashtagTitleMarker> r102 = this.hashtagTitleMarkers;
        if (r102 != null) goto L7;
    L9:
        ArrayList<MentionTitleMarker> r103 = this.mentionTitleMarkers;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.isEmpty() == true) goto L16;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_TITLE_MENTION_LIST, GsonProtectorUtils.toJson(r101, this.mentionTitleMarkers));
        return;
    L16:
        return;
    L7:
        if (r102.isEmpty() == true) goto L9;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_TITLE_HASHTAG_LIST, GsonProtectorUtils.toJson(r101, this.hashtagTitleMarkers));
        goto L9
    }
}
