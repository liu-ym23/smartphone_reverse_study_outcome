package com.bytedance.ee.bear.lark.notification.docfeed.offline;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.j0;
import dtb.b;
import dtb.c;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes16.dex */
@ClaymoreImpl(IOfflineExtraParser.class)
class DocOfflineExtraParser implements IOfflineExtraParser {
    private static final String KEY_DATA = "data";
    private static final String KEY_DIRECT = "direct";
    private static final String KEY_EXTRA_STR = "extra_str";
    private static final String KEY_FEED_ID = "feed_id";
    private static final String KEY_MSG_ID = "msg_id";
    private static final String KEY_TYPE = "type";
    private static final String KEY_USER_ID = "user_id";
    private static final String PUSH_DOC_FEED = "PUSH_DOC_FEED";
    private static final String TAG = "DocOfflineExtraParser";
    private JSONObject mBusinessInfo;
    private int mDirect;
    private final String mSid;
    private String mUserId;

    public String getChannelId() {
        return AbstractNotification.CHANNEL_TYPE.DOC_FEED;
    }

    public String getParserType() {
        return "doc";
    }

    private Intent getImageRelayIntent() {
        JSONObject r100 = this.mBusinessInfo;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getString(KEY_EXTRA_STR);
        if (TextUtils.isEmpty(r101) == false) goto L9;
        Log.e(TAG, "notification doc pass through data is null");
        return null;
    L9:
        Intent r102 = getLaunchDocTransPageIntent(r101);
        if (r102 == null) goto L12;
        r102.putExtra("user_id", this.mUserId);
    L12:
        return r102;
    }

    private Intent getOpenDocDetailIntent() {
        Intent r100 = null;
        JSONObject r101 = JSON.parseObject(this.mBusinessInfo.getString(KEY_EXTRA_STR));     // Catch: Exception -> L14
        if (PUSH_DOC_FEED.equals(r101.getString("type")) == true) goto L6;
        return null;
    L6:
        JSONObject r102 = r101.getJSONObject("data");     // Catch: Exception -> L14
        String r103 = r102.getString("msg_id");     // Catch: Exception -> L14
        String r104 = r102.getString(KEY_FEED_ID);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == false) goto L9;
    L13:
        return null;
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        r100 = getLaunchDocDetailPageIntent(r104, r103);     // Catch: Exception -> L14
        Log.i(TAG, "send To Doc success!");     // Catch: Exception -> L14
        return r100;
    L14:
        e = move-exception;
        Log.e(TAG, "getOpenDocDetailIntent: mBusinessInfo = " + this.mBusinessInfo + " exception = " + e);
        return r100;
    }

    public int getNotificationId() {
        return c.a(this.mSid, TAG);
    }

    public Intent getTargetIntent() {
        if (this.mDirect != 4) goto L7;
        return getImageRelayIntent();
    L7:
        return getOpenDocDetailIntent();
    }

    public DocOfflineExtraParser(b r100) {
        this.mUserId = "";
        throw null;
    }

    @Nullable
    private Intent getLaunchDocTransPageIntent(String r100) {
        Bundle r101 = new Bundle();
        r101.putString("key_doc_image_extra", r100);
        Log.i(TAG, "send To Doc success!");
        return j0.a(LarkContext.getApplication(), r101);
    }

    private Intent getLaunchDocDetailPageIntent(String r100, String r101) {
        Bundle r102 = new Bundle();
        r102.putString("key_doc_feed_id", r100);
        r102.putBoolean("key_doc_jump_detail", true);
        r102.putBoolean("key_doc_open_from_notice", true);
        r102.putString("key_doc_message_id", r101);
        return j0.a(LarkContext.getApplication(), r102);
    }
}
