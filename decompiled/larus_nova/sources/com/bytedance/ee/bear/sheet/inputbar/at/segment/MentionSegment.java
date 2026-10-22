package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
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
        public /* bridge */ /* synthetic */ Object m8330clone() throws CloneNotSupportedException {
            return clone();
        }

        public void setFsUnit(String r100) {
            this.fsUnit = r100;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }

        public SuiteIcon(String r100, int r101, String r102) {
            this.key = r100;
            this.type = r101;
            this.fsUnit = r102;
        }
    }

    public MentionSegment() {
        super(SegmentType.MENTION, null);
    }

    @JSONField(serialize = false)
    public boolean isMentionDocument() {
        if (this.mentionType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JSONField(serialize = false)
    public boolean isMentionUser() {
        if (this.mentionType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public MentionSegment clone() throws CloneNotSupportedException {
        MentionSegment r100 = (MentionSegment) super.clone();
        SuiteIcon r101 = this.icon;
        if (r101 == null) goto L6;
        r100.icon = r101.clone();
    L6:
        if (this.i18n_value == null) goto L8;
        r100.i18n_value = new HashMap(this.i18n_value);
    L8:
        return r100;
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
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setBlock_notify(boolean r100) {
        this.block_notify = r100;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    public void setI18n_value(HashMap<String, String> r100) {
        this.i18n_value = r100;
    }

    public void setIcon(SuiteIcon r100) {
        this.icon = r100;
    }

    public void setIconInfo(String r100) {
        this.iconInfo = r100;
    }

    public void setIs_external(boolean r100) {
        this.is_external = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    public void setMentionId(String r100) {
        this.mentionId = r100;
    }

    public void setMentionNotify(boolean r100) {
        this.mentionNotify = r100;
    }

    public void setMentionType(int r100) {
        this.mentionType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNot_notify(boolean r100) {
        this.not_notify = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
