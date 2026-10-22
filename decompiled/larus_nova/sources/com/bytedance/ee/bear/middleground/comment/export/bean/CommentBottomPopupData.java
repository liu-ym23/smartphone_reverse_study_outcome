package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBottomPopupData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "des", "getDes", "setDes", "confirmBtnText", "getConfirmBtnText", "setConfirmBtnText", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "sendLarkText", "getSendLarkText", "setSendLarkText", "userId", "getUserId", "setUserId", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentBottomPopupData implements NonProguard {
    public static final a Companion = null;
    public static final int HAS_COMMENT_PERMISSION = 2;
    public static final int HAS_DOC_PERMISSION = 1;
    public static final int NONE_PERMISSION = 3;
    private String cancelBtnText;
    private String confirmBtnText;
    private String des;
    private String sendLarkText;
    private String title;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommentBottomPopupData() {
        this.userId = "";
    }

    public final String getCancelBtnText() {
        return this.cancelBtnText;
    }

    public final String getConfirmBtnText() {
        return this.confirmBtnText;
    }

    public final String getDes() {
        return this.des;
    }

    public final String getSendLarkText() {
        return this.sendLarkText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setCancelBtnText(String r100) {
        this.cancelBtnText = r100;
    }

    public final void setConfirmBtnText(String r100) {
        this.confirmBtnText = r100;
    }

    public final void setDes(String r100) {
        this.des = r100;
    }

    public final void setSendLarkText(String r100) {
        this.sendLarkText = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
