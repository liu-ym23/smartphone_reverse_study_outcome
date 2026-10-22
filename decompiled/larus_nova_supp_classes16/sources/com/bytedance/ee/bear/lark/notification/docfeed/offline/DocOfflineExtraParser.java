package com.bytedance.ee.bear.lark.notification.docfeed.offline;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.j0;
import dtb.b;
import dtb.c;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        return "doc_feed";
    }

    public String getParserType() {
        return "doc";
    }

    private Intent getImageRelayIntent() {
        JSONObject r0 = this.mBusinessInfo;
        if (r0 != null) goto L5;
        return null;
    L5:
        String r1 = r0.getString(KEY_EXTRA_STR);
        if (TextUtils.isEmpty(r1) == false) goto L9;
        Log.e(TAG, "notification doc pass through data is null");
        return null;
    L9:
        Intent r2 = getLaunchDocTransPageIntent(r1);
        if (r2 == null) goto L12;
        r2.putExtra(KEY_USER_ID, this.mUserId);
    L12:
        return r2;
    }

    private Intent getOpenDocDetailIntent() {
        Intent r1 = null;
        JSONObject r2 = JSON.parseObject(this.mBusinessInfo.getString(KEY_EXTRA_STR));     // Catch: Exception -> L14
        if (PUSH_DOC_FEED.equals(r2.getString("type")) == true) goto L6;
        return null;
    L6:
        JSONObject r3 = r2.getJSONObject(KEY_DATA);     // Catch: Exception -> L14
        String r4 = r3.getString(KEY_MSG_ID);     // Catch: Exception -> L14
        String r5 = r3.getString(KEY_FEED_ID);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == false) goto L9;
    L13:
        return null;
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r1 = getLaunchDocDetailPageIntent(r5, r4);     // Catch: Exception -> L14
        Log.i(TAG, "send To Doc success!");     // Catch: Exception -> L14
        return r1;
    L14:
        e = move-exception;
        Log.e(TAG, "getOpenDocDetailIntent: mBusinessInfo = " + this.mBusinessInfo + " exception = " + e);
        return r1;
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

    public DocOfflineExtraParser(b r1) {
        this.mUserId = "";
        throw null;
    }

    @Nullable
    private Intent getLaunchDocTransPageIntent(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("key_doc_image_extra", r3);
        Log.i(TAG, "send To Doc success!");
        return j0.a(LarkContext.getApplication(), r0);
    }

    private Intent getLaunchDocDetailPageIntent(String r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString("key_doc_feed_id", r3);
        r0.putBoolean("key_doc_jump_detail", true);
        r0.putBoolean("key_doc_open_from_notice", true);
        r0.putString("key_doc_message_id", r4);
        return j0.a(LarkContext.getApplication(), r0);
    }
}
