package com.bytedance.ee.bear.middleground.comment.export.draft;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0016\u0010\"\u001a\u00020 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0003H\u0016R*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R6\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/draft/DraftEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "content", "", "imgList", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "smartReplyDataForInsert", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;)V", "value", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getImgList", "()Ljava/util/List;", "setImgList", "(Ljava/util/List;)V", "lastAccess", "", "getLastAccess", "()J", "setLastAccess", "(J)V", "getSmartReplyDataForInsert", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;", "setSmartReplyDataForInsert", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;)V", "removeImage", "", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, "addImages", "images", "", "isDraftEmpty", "", "toString", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DraftEntity implements NonProguard {
    private String content;
    private List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> imgList;
    private long lastAccess;
    private SmartReplyDataForInsert smartReplyDataForInsert;

    public String toString() {
        StringBuilder r0 = new StringBuilder("DraftEntity(content length=");
        String r1 = getContent();
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.length();
    L6:
        r0.append(r3);
        r0.append(", image count=");
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4 = getImgList();
        if (r4 == null) goto L9;
        r2 = r4.size();
    L9:
        r0.append(r2);
        r0.append(", lastAccess=");
        r0.append(this.lastAccess);
        r0.append(')');
        return r0.toString();
    L5:
        r3 = 0;
        goto L6
    }

    public final String getContent() {
        this.lastAccess = System.currentTimeMillis();
        return this.content;
    }

    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> getImgList() {
        this.lastAccess = System.currentTimeMillis();
        return this.imgList;
    }

    public final SmartReplyDataForInsert getSmartReplyDataForInsert() {
        this.lastAccess = System.currentTimeMillis();
        return this.smartReplyDataForInsert;
    }

    public final boolean isDraftEmpty() {
        String r0 = getContent();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2 = getImgList();
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final long getLastAccess() {
        return this.lastAccess;
    }

    public final void addImages(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3) {
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        if (getImgList() != null) goto L14;
        setImgList(new ArrayList());
    L14:
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = getImgList();
        Intrinsics.checkNotNull(r1);
        r1.addAll(r4);
        this.lastAccess = System.currentTimeMillis();
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void removeImage(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r3) {
        Intrinsics.checkNotNullParameter(r3, ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r0 = getImgList();
        if (r0 == null) goto L5;
        r0.remove(r3);
    L5:
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setContent(String r3) {
        this.content = r3;
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setImgList(List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3) {
        this.imgList = r3;
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setLastAccess(long r1) {
        this.lastAccess = r1;
    }

    public final void setSmartReplyDataForInsert(SmartReplyDataForInsert r3) {
        this.smartReplyDataForInsert = r3;
        this.lastAccess = System.currentTimeMillis();
    }

    public DraftEntity(String r1, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2) {
        setContent(r1);
        setImgList(r2);
        this.lastAccess = System.currentTimeMillis();
    }

    public DraftEntity(String r1, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, SmartReplyDataForInsert r3) {
        setContent(r1);
        setImgList(r2);
        setSmartReplyDataForInsert(r3);
        this.lastAccess = System.currentTimeMillis();
    }

    public /* synthetic */ DraftEntity(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public /* synthetic */ DraftEntity(String r1, List r2, SmartReplyDataForInsert r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
