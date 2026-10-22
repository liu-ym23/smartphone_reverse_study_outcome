package com.bytedance.ee.bear.document.imageviewer.bean;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0005R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0005R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/bean/EnterAreaCommentParams;", "Lcom/bytedance/ee/util/io/NonProguard;", ST.UUID_DEVICE, "", "<init>", "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "setUuid", "mode", "getMode", "setMode", "commentId", "getCommentId", "setCommentId", "replyId", "getReplyId", "setReplyId", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterAreaCommentParams implements NonProguard {
    private String commentId;
    private String mode;
    private String replyId;
    private String uuid;

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public EnterAreaCommentParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.uuid = r100;
        this.mode = AreaCommentMode.CREATE.getValue();
    }

    public final void setCommentId(String r100) {
        this.commentId = r100;
    }

    public final void setMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }

    public final void setReplyId(String r100) {
        this.replyId = r100;
    }

    public final void setUuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uuid = r100;
    }
}
