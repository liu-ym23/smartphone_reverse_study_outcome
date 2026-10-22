package com.bytedance.ee.bear.middleground.comment.export.draft;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0016\u0010\"\u001a\u00020 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0003H\u0016R*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R6\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/draft/DraftEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "content", "", "imgList", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "smartReplyDataForInsert", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;)V", "value", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getImgList", "()Ljava/util/List;", "setImgList", "(Ljava/util/List;)V", "lastAccess", "", "getLastAccess", "()J", "setLastAccess", "(J)V", "getSmartReplyDataForInsert", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;", "setSmartReplyDataForInsert", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;)V", "removeImage", "", "image", "addImages", "images", "", "isDraftEmpty", "", "toString", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DraftEntity implements NonProguard {
    private String content;
    private List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> imgList;
    private long lastAccess;
    private SmartReplyDataForInsert smartReplyDataForInsert;

    public String toString() {
        StringBuilder r100 = new StringBuilder("DraftEntity(content length=");
        String r101 = getContent();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.length();
    L6:
        r100.append(r103);
        r100.append(", image count=");
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r104 = getImgList();
        if (r104 == null) goto L9;
        r102 = r104.size();
    L9:
        r100.append(r102);
        r100.append(", lastAccess=");
        r100.append(this.lastAccess);
        r100.append(')');
        return r100.toString();
    L5:
        r103 = 0;
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
        String r100 = getContent();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L20;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r102 = getImgList();
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final long getLastAccess() {
        return this.lastAccess;
    }

    public final void addImages(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r100) {
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        if (getImgList() != null) goto L14;
        setImgList(new ArrayList());
    L14:
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r103 = getImgList();
        Intrinsics.checkNotNull(r103);
        r103.addAll(r101);
        this.lastAccess = System.currentTimeMillis();
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void removeImage(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101 = getImgList();
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setContent(String r100) {
        this.content = r100;
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setImgList(List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r100) {
        this.imgList = r100;
        this.lastAccess = System.currentTimeMillis();
    }

    public final void setLastAccess(long r100) {
        this.lastAccess = r100;
    }

    public final void setSmartReplyDataForInsert(SmartReplyDataForInsert r100) {
        this.smartReplyDataForInsert = r100;
        this.lastAccess = System.currentTimeMillis();
    }

    public DraftEntity(String r100, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101) {
        setContent(r100);
        setImgList(r101);
        this.lastAccess = System.currentTimeMillis();
    }

    public DraftEntity(String r100, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, SmartReplyDataForInsert r102) {
        setContent(r100);
        setImgList(r101);
        setSmartReplyDataForInsert(r102);
        this.lastAccess = System.currentTimeMillis();
    }

    public /* synthetic */ DraftEntity(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }

    public /* synthetic */ DraftEntity(String r100, List r101, SmartReplyDataForInsert r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
