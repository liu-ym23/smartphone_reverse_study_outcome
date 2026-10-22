package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SmartReplyData implements BaseJSModel {
    public static final int STATUS_EXPOSED = 1;
    public static final int STATUS_NOT_EXPOSED = 0;
    private String aiReplyId;
    private String commentId;
    private int exposedState;
    private boolean isAccepted;
    private boolean isReplyOwner;
    private String plainText;
    private String plainTextPreview;
    private String replyId;

    public static final enum AiReplyUserType extends Enum<AiReplyUserType> {
        public static final AiReplyUserType ADOPT_ACTION_USER = null;
        public static final AiReplyUserType ADOPT_RECEIVE_USER = null;
        public static final /* synthetic */ AiReplyUserType[] a = null;
        private final String value;

        static {
            AiReplyUserType r0 = new AiReplyUserType("ADOPT_ACTION_USER", 0, "adopt_action_user");
            ADOPT_ACTION_USER = r0;
            AiReplyUserType r1 = new AiReplyUserType("ADOPT_RECEIVE_USER", 1, "adopt_receive_user");
            ADOPT_RECEIVE_USER = r1;
            a = new AiReplyUserType[]{r0, r1};
        }

        public static AiReplyUserType[] values() {
            return (AiReplyUserType[]) a.clone();
        }

        public String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public static AiReplyUserType valueOf(String r1) {
            return (AiReplyUserType) r27.a.a(AiReplyUserType.class, r1);
        }

        public AiReplyUserType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SmartReplyViewSource extends Enum<SmartReplyViewSource> {
        public static final SmartReplyViewSource ADOPT_ANSWER_SHARE = null;
        public static final SmartReplyViewSource RECEIVER_AUTO_SHOW = null;
        public static final SmartReplyViewSource SENDER_SELF_ANSWER = null;
        public static final /* synthetic */ SmartReplyViewSource[] a = null;
        private final String value;

        static {
            SmartReplyViewSource r0 = new SmartReplyViewSource("SENDER_SELF_ANSWER", 0, "sender_self_answer");
            SENDER_SELF_ANSWER = r0;
            SmartReplyViewSource r1 = new SmartReplyViewSource("ADOPT_ANSWER_SHARE", 1, "adopt_answer_share");
            ADOPT_ANSWER_SHARE = r1;
            SmartReplyViewSource r2 = new SmartReplyViewSource("RECEIVER_AUTO_SHOW", 2, "receiver_auto_show");
            RECEIVER_AUTO_SHOW = r2;
            a = new SmartReplyViewSource[]{r0, r1, r2};
        }

        public static SmartReplyViewSource[] values() {
            return (SmartReplyViewSource[]) a.clone();
        }

        public String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public static SmartReplyViewSource valueOf(String r1) {
            return (SmartReplyViewSource) r27.a.a(SmartReplyViewSource.class, r1);
        }

        public SmartReplyViewSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.commentId, this.replyId, this.plainTextPreview, this.plainText, this.aiReplyId});
    }

    public AiReplyUserType getAiReplyUserType() {
        if (this.isAccepted == false) goto L9;
        if (this.isReplyOwner == true) goto L9;
        return AiReplyUserType.ADOPT_RECEIVE_USER;
    L9:
        return AiReplyUserType.ADOPT_ACTION_USER;
    }

    public SmartReplyViewSource getSmartReplyViewSource() {
        if (this.isReplyOwner == false) goto L7;
        return SmartReplyViewSource.SENDER_SELF_ANSWER;
    L7:
        if (this.isAccepted == false) goto L11;
        return SmartReplyViewSource.ADOPT_ANSWER_SHARE;
    L11:
        return SmartReplyViewSource.RECEIVER_AUTO_SHOW;
    }

    public String toString() {
        return "CommentSmartReplay{commentId='" + this.commentId + "', replyId='" + this.replyId + "', plainTextPreview='" + this.plainTextPreview + "', plainText='" + this.plainText + "', aiReplyId='" + this.aiReplyId + "', isAccepted=" + this.isAccepted + ", isReplyOwner=" + this.isReplyOwner + '}';
    }

    public SmartReplyData() {
        this.exposedState = 0;
        this.isAccepted = false;
        this.isReplyOwner = false;
    }

    public String getAiReplyId() {
        return this.aiReplyId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getExposedState() {
        return this.exposedState;
    }

    public String getPlainText() {
        return this.plainText;
    }

    public String getPlainTextPreview() {
        return this.plainTextPreview;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public boolean isAccepted() {
        return this.isAccepted;
    }

    public boolean isReplyOwner() {
        return this.isReplyOwner;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (getClass() != r4.getClass()) goto L25;
        SmartReplyData r5 = (SmartReplyData) r4;
        if (Objects.equals(this.commentId, r5.commentId) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.replyId, r5.replyId) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.plainTextPreview, r5.plainTextPreview) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.plainText, r5.plainText) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(this.aiReplyId, r5.aiReplyId) == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public void setAccepted(boolean r1) {
        this.isAccepted = r1;
    }

    public void setAiReplyId(String r1) {
        this.aiReplyId = r1;
    }

    public void setCommentId(String r1) {
        this.commentId = r1;
    }

    public void setExposedState(int r1) {
        this.exposedState = r1;
    }

    public void setPlainText(String r1) {
        this.plainText = r1;
    }

    public void setPlainTextPreview(String r1) {
        this.plainTextPreview = r1;
    }

    public void setReplyId(String r1) {
        this.replyId = r1;
    }

    public void setReplyOwner(boolean r1) {
        this.isReplyOwner = r1;
    }
}
