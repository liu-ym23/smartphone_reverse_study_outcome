package com.ss.android.lark.search.dto.info;

import com.alipay.sdk.m.x.d;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.bytedance.lark.pb.basic.v1.Message;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0005R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u0005R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u00020?8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u00020?8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001a\u0010G\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010A\"\u0004\bI\u0010C¨\u0006J"}, d2 = {"Lcom/ss/android/lark/search/dto/info/MessageAttachment;", "Ljava/io/Serializable;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "attachmentType", "Lcom/bytedance/lark/pb/basic/v1/Message$MessageAttachmentType;", "getAttachmentType", "()Lcom/bytedance/lark/pb/basic/v1/Message$MessageAttachmentType;", "setAttachmentType", "(Lcom/bytedance/lark/pb/basic/v1/Message$MessageAttachmentType;)V", "attachmentRenderType", "Lcom/bytedance/lark/pb/search/v2/MessageAttachment$AttachmentRenderType;", "getAttachmentRenderType", "()Lcom/bytedance/lark/pb/search/v2/MessageAttachment$AttachmentRenderType;", "setAttachmentRenderType", "(Lcom/bytedance/lark/pb/search/v2/MessageAttachment$AttachmentRenderType;)V", "title", "getTitle", d.f25925o, "titleTagList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/TagContent;", "Lkotlin/collections/ArrayList;", "getTitleTagList", "()Ljava/util/ArrayList;", "setTitleTagList", "(Ljava/util/ArrayList;)V", "summary", "getSummary", "setSummary", "summaryTagList", "getSummaryTagList", "setSummaryTagList", "image", "Lcom/bytedance/lark/pb/basic/v1/ImageSet;", "getImage", "()Lcom/bytedance/lark/pb/basic/v1/ImageSet;", "setImage", "(Lcom/bytedance/lark/pb/basic/v1/ImageSet;)V", "mediaContent", "Lcom/bytedance/lark/pb/basic/v1/MediaContent;", "getMediaContent", "()Lcom/bytedance/lark/pb/basic/v1/MediaContent;", "setMediaContent", "(Lcom/bytedance/lark/pb/basic/v1/MediaContent;)V", "fileMeta", "Lcom/bytedance/lark/pb/basic/v1/File;", "getFileMeta", "()Lcom/bytedance/lark/pb/basic/v1/File;", "setFileMeta", "(Lcom/bytedance/lark/pb/basic/v1/File;)V", "searchLinkInfo", "Lcom/ss/android/lark/search/dto/info/SearchLinkInfo;", "getSearchLinkInfo", "()Lcom/ss/android/lark/search/dto/info/SearchLinkInfo;", "setSearchLinkInfo", "(Lcom/ss/android/lark/search/dto/info/SearchLinkInfo;)V", "linkClickedForReport", "", "getLinkClickedForReport", "()Z", "setLinkClickedForReport", "(Z)V", "linkClicked", "getLinkClicked", "setLinkClicked", "hasResourceAccessAuth", "getHasResourceAccessAuth", "setHasResourceAccessAuth", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageAttachment implements Serializable {
    private com.bytedance.lark.pb.search.v2.MessageAttachment.AttachmentRenderType attachmentRenderType;
    private Message.MessageAttachmentType attachmentType;
    private File fileMeta;
    private boolean hasResourceAccessAuth;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f440160id;
    private ImageSet image;
    private boolean linkClicked;
    private boolean linkClickedForReport;
    private MediaContent mediaContent;
    private SearchLinkInfo searchLinkInfo;
    private String summary;
    private ArrayList<TagContent> summaryTagList;
    private String title;
    private ArrayList<TagContent> titleTagList;

    public final boolean getLinkClicked() {
        boolean r100 = this.linkClicked;
        if (r100 == false) goto L5;
        this.linkClicked = false;
    L5:
        return r100;
    }

    public final boolean getLinkClickedForReport() {
        boolean r100 = this.linkClickedForReport;
        if (r100 == false) goto L5;
        this.linkClickedForReport = false;
    L5:
        return r100;
    }

    public final com.bytedance.lark.pb.search.v2.MessageAttachment.AttachmentRenderType getAttachmentRenderType() {
        return this.attachmentRenderType;
    }

    public final Message.MessageAttachmentType getAttachmentType() {
        return this.attachmentType;
    }

    public final File getFileMeta() {
        return this.fileMeta;
    }

    public final boolean getHasResourceAccessAuth() {
        return this.hasResourceAccessAuth;
    }

    public final String getId() {
        return this.f440160id;
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final MediaContent getMediaContent() {
        return this.mediaContent;
    }

    public final SearchLinkInfo getSearchLinkInfo() {
        return this.searchLinkInfo;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final ArrayList<TagContent> getSummaryTagList() {
        return this.summaryTagList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ArrayList<TagContent> getTitleTagList() {
        return this.titleTagList;
    }

    public MessageAttachment(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f440160id = r100;
        this.attachmentType = Message.MessageAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
        this.attachmentRenderType = com.bytedance.lark.pb.search.v2.MessageAttachment.AttachmentRenderType.UNKNOWN;
        this.title = "";
        this.summary = "";
    }

    public final void setAttachmentRenderType(com.bytedance.lark.pb.search.v2.MessageAttachment.AttachmentRenderType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attachmentRenderType = r100;
    }

    public final void setAttachmentType(Message.MessageAttachmentType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attachmentType = r100;
    }

    public final void setFileMeta(File r100) {
        this.fileMeta = r100;
    }

    public final void setHasResourceAccessAuth(boolean r100) {
        this.hasResourceAccessAuth = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440160id = r100;
    }

    public final void setImage(ImageSet r100) {
        this.image = r100;
    }

    public final void setLinkClicked(boolean r100) {
        this.linkClicked = r100;
    }

    public final void setLinkClickedForReport(boolean r100) {
        this.linkClickedForReport = r100;
    }

    public final void setMediaContent(MediaContent r100) {
        this.mediaContent = r100;
    }

    public final void setSearchLinkInfo(SearchLinkInfo r100) {
        this.searchLinkInfo = r100;
    }

    public final void setSummary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.summary = r100;
    }

    public final void setSummaryTagList(ArrayList<TagContent> r100) {
        this.summaryTagList = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setTitleTagList(ArrayList<TagContent> r100) {
        this.titleTagList = r100;
    }
}
