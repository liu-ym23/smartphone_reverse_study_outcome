package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MentionSegment extends BaseSegment {

    @SerializedName("block_notify")
    private boolean block_notify;
    private String category;

    @SerializedName("en_name")
    private String en_name;
    private HashMap<String, String> i18n_value;
    private SuiteIcon icon;
    private String iconInfo;

    @SerializedName("is_external")
    private boolean is_external;
    private String link;
    private String mentionId;
    private boolean mentionNotify;
    private int mentionType;
    private String name;

    @SerializedName("not_notify")
    private boolean not_notify;
    private String text;
    private String token;

    public static class SuiteIcon implements NonProguard, Cloneable {

        @SerializedName("fs_unit")
        private String fsUnit;
        private String key;
        private int type;

        public SuiteIcon clone() throws CloneNotSupportedException {
            return (SuiteIcon) super.clone();
        }

        public SuiteIcon() {
        }

        public String getFsUnit() {
            return this.fsUnit;
        }

        public String getKey() {
            return this.key;
        }

        public int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m524clone() throws CloneNotSupportedException {
            return clone();
        }

        public void setFsUnit(String r1) {
            this.fsUnit = r1;
        }

        public void setKey(String r1) {
            this.key = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }

        public SuiteIcon(String r1, int r2, String r3) {
            this.key = r1;
            this.type = r2;
            this.fsUnit = r3;
        }
    }

    public MentionSegment() {
        super(SegmentType.MENTION, null);
    }

    @JSONField(serialize = BaseKeyboardHeightProducer.VISIBLE_FALSE)
    public boolean isMentionDocument() {
        if (this.mentionType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JSONField(serialize = BaseKeyboardHeightProducer.VISIBLE_FALSE)
    public boolean isMentionUser() {
        if (this.mentionType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public MentionSegment clone() throws CloneNotSupportedException {
        MentionSegment r0 = (MentionSegment) super.clone();
        SuiteIcon r1 = this.icon;
        if (r1 == null) goto L6;
        r0.icon = r1.clone();
    L6:
        if (this.i18n_value == null) goto L8;
        r0.i18n_value = new HashMap(this.i18n_value);
    L8:
        return r0;
    }

    public String getCategory() {
        return this.category;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public HashMap<String, String> getI18n_value() {
        return this.i18n_value;
    }

    public SuiteIcon getIcon() {
        return this.icon;
    }

    public String getIconInfo() {
        return this.iconInfo;
    }

    public String getLink() {
        return this.link;
    }

    public String getMentionId() {
        return this.mentionId;
    }

    public int getMentionType() {
        return this.mentionType;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public String getText() {
        return this.text;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isBlock_notify() {
        return this.block_notify;
    }

    public boolean isIs_external() {
        return this.is_external;
    }

    public boolean isMentionNotify() {
        return this.mentionNotify;
    }

    public boolean isNot_notify() {
        return this.not_notify;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public /* bridge */ /* synthetic */ BaseSegment clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setBlock_notify(boolean r1) {
        this.block_notify = r1;
    }

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setEn_name(String r1) {
        this.en_name = r1;
    }

    public void setI18n_value(HashMap<String, String> r1) {
        this.i18n_value = r1;
    }

    public void setIcon(SuiteIcon r1) {
        this.icon = r1;
    }

    public void setIconInfo(String r1) {
        this.iconInfo = r1;
    }

    public void setIs_external(boolean r1) {
        this.is_external = r1;
    }

    public void setLink(String r1) {
        this.link = r1;
    }

    public void setMentionId(String r1) {
        this.mentionId = r1;
    }

    public void setMentionNotify(boolean r1) {
        this.mentionNotify = r1;
    }

    public void setMentionType(int r1) {
        this.mentionType = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNot_notify(boolean r1) {
        this.not_notify = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r1) {
        this.text = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
