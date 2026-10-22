package com.bytedance.ee.bear.atfinder;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class AtFinderJsCallbackData implements NonProguard {
    public static final String FROM_SYNCED_BLOCK = "syncedBlock";
    protected Map<String, String> bizCommonParams;
    private CheckboxData checkboxData;
    protected String content;
    private String from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    protected String f206341id;
    protected Mention mention;
    protected String mentionPanel;
    protected int show;
    protected int source;
    protected String token;
    protected String type;

    public static class CheckboxData implements NonProguard {
        private int checkBoxType;

        @JSONField(name = "isSelected")
        private boolean isSelected;
        private String text;

        public CheckboxData() {
        }

        public String toString() {
            return "CheckboxData{checkBoxType=" + this.checkBoxType + ", text='" + this.text + "', isSelected=" + this.isSelected + '}';
        }

        public int getCheckBoxType() {
            return this.checkBoxType;
        }

        public String getText() {
            return this.text;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setCheckBoxType(int r100) {
            this.checkBoxType = r100;
        }

        public void setSelected(boolean r100) {
            this.isSelected = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }
    }

    public static class Mention implements NonProguard {
        public int file_type;
        public String source;
        public String zone;

        public Mention() {
        }

        public int getFileType() {
            return this.file_type;
        }

        public String getSource() {
            return this.source;
        }

        public String getZone() {
            return this.zone;
        }

        public void setFileType(int r100) {
            this.file_type = r100;
        }

        public void setSource(String r100) {
            this.source = r100;
        }

        public void setZone(String r100) {
            this.zone = r100;
        }

        public Mention(String r100, String r101, int r102) {
            this.zone = r100;
            this.source = r101;
            this.file_type = r102;
        }
    }

    public String toString() {
        return "AtFinderJsCallbackData{source=" + this.source + ", id='" + this.f206341id + "', show=" + this.show + ", from=" + this.from + ", type='" + this.type + "', mentionPanel='" + this.mentionPanel + "', checkboxData='" + this.checkboxData + "', token='" + du5.b.g(this.token) + "'}";
    }

    public AtFinderJsCallbackData() {
    }

    public Map<String, String> getBizCommonParams() {
        return this.bizCommonParams;
    }

    public CheckboxData getCheckboxData() {
        return this.checkboxData;
    }

    public String getContent() {
        return this.content;
    }

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.f206341id;
    }

    public Mention getMention() {
        return this.mention;
    }

    public String getMentionPanel() {
        return this.mentionPanel;
    }

    public int getShow() {
        return this.show;
    }

    public int getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public void setBizCommonParams(Map<String, String> r100) {
        this.bizCommonParams = r100;
    }

    public void setCheckboxData(CheckboxData r100) {
        this.checkboxData = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setFrom(String r100) {
        this.from = r100;
    }

    public void setId(String r100) {
        this.f206341id = r100;
    }

    public void setMention(Mention r100) {
        this.mention = r100;
    }

    public void setMentionPanel(String r100) {
        this.mentionPanel = r100;
    }

    public void setShow(int r100) {
        this.show = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public AtFinderJsCallbackData(String r100, int r101, int r102, String r103, String r104, String r105, Mention r106) {
        this.f206341id = r100;
        this.source = r101;
        this.show = r102;
        this.content = r103;
        this.type = r104;
        this.token = r105;
        this.mention = r106;
    }
}
