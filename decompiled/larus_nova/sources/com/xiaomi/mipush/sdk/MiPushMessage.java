package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class MiPushMessage implements PushMessageHandler.a {
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DESC = "description";
    private static final String KEY_EXTRA = "extra";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_NOTIFIED = "isNotified";
    private static final String KEY_NOTIFY_ID = "notifyId";
    private static final String KEY_NOTIFY_TYPE = "notifyType";
    private static final String KEY_PASS_THROUGH = "passThrough";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TOPIC = "topic";
    private static final String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    private static final long serialVersionUID = 1;
    private String alias;
    private boolean arrived;
    private String category;
    private String content;
    private String description;
    private HashMap<String, String> extra;
    private boolean isNotified;
    private String messageId;
    private int messageType;
    private int notifyId;
    private int notifyType;
    private int passThrough;
    private String title;
    private String topic;
    private String userAccount;

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putString(KEY_MESSAGE_ID, this.messageId);
        r100.putInt(KEY_PASS_THROUGH, this.passThrough);
        r100.putInt(KEY_MESSAGE_TYPE, this.messageType);
        if (TextUtils.isEmpty(this.alias) == true) goto L6;
        r100.putString("alias", this.alias);
    L6:
        if (TextUtils.isEmpty(this.userAccount) == true) goto L9;
        r100.putString(KEY_USER_ACCOUNT, this.userAccount);
    L9:
        if (TextUtils.isEmpty(this.topic) == true) goto L11;
        r100.putString(KEY_TOPIC, this.topic);
    L11:
        r100.putString("content", this.content);
        if (TextUtils.isEmpty(this.description) == true) goto L15;
        r100.putString("description", this.description);
    L15:
        if (TextUtils.isEmpty(this.title) == true) goto L17;
        r100.putString("title", this.title);
    L17:
        r100.putBoolean(KEY_NOTIFIED, this.isNotified);
        r100.putInt("notifyId", this.notifyId);
        r100.putInt(KEY_NOTIFY_TYPE, this.notifyType);
        if (TextUtils.isEmpty(this.category) == true) goto L20;
        r100.putString("category", this.category);
    L20:
        HashMap<String, String> r101 = this.extra;
        if (r101 == null) goto L23;
        r100.putSerializable("extra", r101);
    L23:
        return r100;
    }

    public String toString() {
        return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + com.alipay.sdk.m.u.i.f25855d;
    }

    public MiPushMessage() {
        this.arrived = false;
        this.extra = new HashMap();
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public static MiPushMessage fromBundle(Bundle r100) {
        MiPushMessage r101 = new MiPushMessage();
        r101.messageId = r100.getString(KEY_MESSAGE_ID);
        r101.messageType = r100.getInt(KEY_MESSAGE_TYPE);
        r101.passThrough = r100.getInt(KEY_PASS_THROUGH);
        r101.alias = r100.getString("alias");
        r101.userAccount = r100.getString(KEY_USER_ACCOUNT);
        r101.topic = r100.getString(KEY_TOPIC);
        r101.content = r100.getString("content");
        r101.description = r100.getString("description");
        r101.title = r100.getString("title");
        r101.isNotified = r100.getBoolean(KEY_NOTIFIED);
        r101.notifyId = r100.getInt("notifyId");
        r101.notifyType = r100.getInt(KEY_NOTIFY_TYPE);
        r101.category = r100.getString("category");
        r101.extra = (HashMap) r100.getSerializable("extra");
        return r101;
    }

    public void setAlias(String r100) {
        this.alias = r100;
    }

    public void setArrivedMessage(boolean r100) {
        this.arrived = r100;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setExtra(Map<String, String> r100) {
        this.extra.clear();
        if (r100 == null) goto L6;
        this.extra.putAll(r100);
        return;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setMessageType(int r100) {
        this.messageType = r100;
    }

    public void setNotified(boolean r100) {
        this.isNotified = r100;
    }

    public void setNotifyId(int r100) {
        this.notifyId = r100;
    }

    public void setNotifyType(int r100) {
        this.notifyType = r100;
    }

    public void setPassThrough(int r100) {
        this.passThrough = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTopic(String r100) {
        this.topic = r100;
    }

    public void setUserAccount(String r100) {
        this.userAccount = r100;
    }
}
