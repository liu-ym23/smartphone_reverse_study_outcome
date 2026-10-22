package com.ss.android.lark.search.dto.info;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.search.v1.WikiInfo;

/* JADX INFO: loaded from: classes38.dex */
public class SearchSpaceInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 5052389139562361195L;
    private Integer bitableBizType;
    private String chatId;
    private long createTime;
    private Doc.Type docType;
    private String docUrl;
    private long editTime;
    private String editUserId;
    private String editUserName;
    private String fileType;
    private boolean hadShowThumbnail;
    private String iconInfo;
    private Boolean isShareFolder;
    private long lastOpenTime;
    private String messageId;
    private Doc.Type oriType;
    private String ownerId;
    private String ownerName;
    private int position;
    private Long spaceId;
    private String spaceName;
    private String threadId;
    private int threadPosition;
    private String token;
    private long updateTime;
    private WikiInfo wikiInfo;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440166a = null;

        static {
            int[] r100 = new int[Doc.Type.values().length];
            f440166a = r100;
            r100[Doc.Type.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f440166a[Doc.Type.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f440166a[Doc.Type.BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f440166a[Doc.Type.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f440166a[Doc.Type.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f440166a[Doc.Type.SLIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f440166a[Doc.Type.WIKI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f440166a[Doc.Type.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f440166a[Doc.Type.FOLDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f440166a[Doc.Type.SHORTCUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public Doc.Type getDocType() {
        Doc.Type r100 = this.docType;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Doc.Type.UNKNOWN;
    }

    public Doc.Type getOriType() {
        Doc.Type r100 = this.oriType;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Doc.Type.UNKNOWN;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        switch(a.f440166a[this.docType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        return "docs_unknown";
    L5:
        return "shortcut";
    L6:
        return DocumentType.FOLDER_NAME;
    L7:
        return DocumentType.DOCX_NAME;
    L8:
        return "wiki";
    L9:
        return "slide";
    L10:
        return "file";
    L11:
        return DocumentType.MINDNOTE_NAME;
    L12:
        return DocumentType.BITABLE_NAME;
    L13:
        return DocumentType.SHEET_NAME;
    L14:
        return "doc";
    }

    public SearchSpaceInfo() {
        this.type = 6;
    }

    public Integer getBitableBizType() {
        return this.bitableBizType;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDocUrl() {
        return this.docUrl;
    }

    public long getEditTime() {
        return this.editTime;
    }

    public String getEditUserId() {
        return this.editUserId;
    }

    public String getEditUserName() {
        return this.editUserName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getIconInfo() {
        return this.iconInfo;
    }

    public Boolean getIsShareFolder() {
        return this.isShareFolder;
    }

    public long getLastOpenTime() {
        return this.lastOpenTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public int getPosition() {
        return this.position;
    }

    public Long getSpaceId() {
        return this.spaceId;
    }

    public String getSpaceName() {
        return this.spaceName;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    public String getToken() {
        return this.token;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public WikiInfo getWikiInfo() {
        return this.wikiInfo;
    }

    public boolean isHadShowThumbnail() {
        return this.hadShowThumbnail;
    }

    public void setBitableBizType(Integer r100) {
        this.bitableBizType = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setDocType(Doc.Type r100) {
        this.docType = r100;
    }

    public void setDocUrl(String r100) {
        this.docUrl = r100;
    }

    public void setEditTime(long r100) {
        this.editTime = r100;
    }

    public void setEditUserId(String r100) {
        this.editUserId = r100;
    }

    public void setEditUserName(String r100) {
        this.editUserName = r100;
    }

    public void setFileType(String r100) {
        this.fileType = r100;
    }

    public void setHadShowThumbnail(boolean r100) {
        this.hadShowThumbnail = r100;
    }

    public void setIconInfo(String r100) {
        this.iconInfo = r100;
    }

    public void setIsShareFolder(Boolean r100) {
        this.isShareFolder = r100;
    }

    public void setLastOpenTime(long r100) {
        this.lastOpenTime = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setOriType(Doc.Type r100) {
        this.oriType = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setOwnerName(String r100) {
        this.ownerName = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setSpaceId(Long r100) {
        this.spaceId = r100;
    }

    public void setSpaceName(String r100) {
        this.spaceName = r100;
    }

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadPosition(int r100) {
        this.threadPosition = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setWikiInfo(WikiInfo r100) {
        this.wikiInfo = r100;
    }
}
