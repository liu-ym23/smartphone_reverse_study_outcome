package com.bytedance.ee.bear.sheet.attachment;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AttachmentModelList implements NonProguard {
    private boolean copyable;
    private boolean hideFab;
    private List<AttachmentModel> list;

    public static class AttachmentModel implements NonProguard {
        private String link;
        private int mentionType;
        private String mimeType;
        private String name;
        private String rangeId;
        private String sheetId;
        private long size;
        private String token;
        private String type;

        public AttachmentModel() {
        }

        public String getLink() {
            return this.link;
        }

        public int getMentionType() {
            return this.mentionType;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public String getName() {
            return this.name;
        }

        public String getRangeId() {
            return this.rangeId;
        }

        public String getSheetId() {
            return this.sheetId;
        }

        public long getSize() {
            return this.size;
        }

        public String getToken() {
            return this.token;
        }

        public String getType() {
            return this.type;
        }

        public void setLink(String r1) {
            this.link = r1;
        }

        public void setMentionType(int r1) {
            this.mentionType = r1;
        }

        public void setMimeType(String r1) {
            this.mimeType = r1;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public void setRangeId(String r1) {
            this.rangeId = r1;
        }

        public void setSheetId(String r1) {
            this.sheetId = r1;
        }

        public void setSize(long r1) {
            this.size = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(String r1) {
            this.type = r1;
        }
    }

    public static final enum AttachmentType extends Enum<AttachmentType> {
        public static final AttachmentType ATTACHMENT = null;
        public static final AttachmentType CELL_POSITION = null;
        public static final AttachmentType MENTION = null;
        public static final AttachmentType URL = null;
        public static final /* synthetic */ AttachmentType[] a = null;

        static {
            AttachmentType r0 = new AttachmentType("URL", 0);
            URL = r0;
            AttachmentType r1 = new AttachmentType("MENTION", 1);
            MENTION = r1;
            AttachmentType r3 = new AttachmentType("ATTACHMENT", 2);
            ATTACHMENT = r3;
            AttachmentType r5 = new AttachmentType("CELL_POSITION", 3);
            CELL_POSITION = r5;
            a = new AttachmentType[]{r0, r1, r3, r5};
        }

        public static AttachmentType[] values() {
            return (AttachmentType[]) a.clone();
        }

        public String getType() {
            return cu5.a.a(name());
        }

        public static AttachmentType valueOf(String r1) {
            return (AttachmentType) r27.a.a(AttachmentType.class, r1);
        }

        public AttachmentType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public AttachmentModelList() {
        this.hideFab = true;
    }

    public List<AttachmentModel> getList() {
        return this.list;
    }

    public boolean isCopyable() {
        return this.copyable;
    }

    public boolean isHideFab() {
        return this.hideFab;
    }

    public void setCopyable(boolean r1) {
        this.copyable = r1;
    }

    public void setHideFab(boolean r1) {
        this.hideFab = r1;
    }

    public void setList(List<AttachmentModel> r1) {
        this.list = r1;
    }
}
