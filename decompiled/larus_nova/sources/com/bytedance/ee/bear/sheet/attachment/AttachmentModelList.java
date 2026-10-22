package com.bytedance.ee.bear.sheet.attachment;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

        public void setLink(String r100) {
            this.link = r100;
        }

        public void setMentionType(int r100) {
            this.mentionType = r100;
        }

        public void setMimeType(String r100) {
            this.mimeType = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setRangeId(String r100) {
            this.rangeId = r100;
        }

        public void setSheetId(String r100) {
            this.sheetId = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }
    }

    public static final enum AttachmentType extends Enum<AttachmentType> {
        public static final AttachmentType ATTACHMENT = null;
        public static final AttachmentType CELL_POSITION = null;
        public static final AttachmentType MENTION = null;
        public static final AttachmentType URL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AttachmentType[] f237321a = null;

        static {
            AttachmentType r100 = new AttachmentType("URL", 0);
            URL = r100;
            AttachmentType r101 = new AttachmentType("MENTION", 1);
            MENTION = r101;
            AttachmentType r102 = new AttachmentType("ATTACHMENT", 2);
            ATTACHMENT = r102;
            AttachmentType r103 = new AttachmentType("CELL_POSITION", 3);
            CELL_POSITION = r103;
            f237321a = new AttachmentType[]{r100, r101, r102, r103};
        }

        public static AttachmentType[] values() {
            return (AttachmentType[]) f237321a.clone();
        }

        public String getType() {
            return cu5.a.a(name());
        }

        public static AttachmentType valueOf(String r100) {
            return (AttachmentType) r27.a.a(AttachmentType.class, r100);
        }

        public AttachmentType(String r100, int r101) {
            super(r100, r101);
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

    public void setCopyable(boolean r100) {
        this.copyable = r100;
    }

    public void setHideFab(boolean r100) {
        this.hideFab = r100;
    }

    public void setList(List<AttachmentModel> r100) {
        this.list = r100;
    }
}
