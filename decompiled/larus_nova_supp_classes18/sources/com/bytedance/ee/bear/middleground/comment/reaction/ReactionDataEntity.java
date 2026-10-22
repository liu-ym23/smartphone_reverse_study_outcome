package com.bytedance.ee.bear.middleground.comment.reaction;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "business", "", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity;", "getData", "()Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity;", "setData", "(Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity;)V", "Entity", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionDataEntity implements NonProguard {
    private String business;
    private Entity data;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.OPT, "", "getOperation", "()Ljava/lang/String;", "setOperation", "(Ljava/lang/String;)V", "header", "Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$HeaderEntity;", "getHeader", "()Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$HeaderEntity;", "setHeader", "(Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$HeaderEntity;)V", "identifier", "Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$IdentifierEntity;", "getIdentifier", "()Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$IdentifierEntity;", "setIdentifier", "(Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$IdentifierEntity;)V", "body", "Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$BodyEntity;", "getBody", "()Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$BodyEntity;", "setBody", "(Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$BodyEntity;)V", "HeaderEntity", "IdentifierEntity", "BodyEntity", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Entity implements NonProguard {
        private BodyEntity body;
        private HeaderEntity header;
        private IdentifierEntity identifier;
        private String operation;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$BodyEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "code", "", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class BodyEntity implements NonProguard {
            private Integer code;
            private String msg;

            public BodyEntity() {
                this.code = 0;
            }

            public final Integer getCode() {
                return this.code;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final void setCode(Integer r1) {
                this.code = r1;
            }

            public final void setMsg(String r1) {
                this.msg = r1;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$HeaderEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class HeaderEntity implements NonProguard {
            private String requestId;

            public HeaderEntity() {
            }

            public final String getRequestId() {
                return this.requestId;
            }

            public final void setRequestId(String r1) {
                this.requestId = r1;
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/reaction/ReactionDataEntity$Entity$IdentifierEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", ResourceData.KEY_TOKEN, "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class IdentifierEntity implements NonProguard {
            private String token;
            private int type;

            public IdentifierEntity() {
            }

            public final String getToken() {
                return this.token;
            }

            public final int getType() {
                return this.type;
            }

            public final void setToken(String r1) {
                this.token = r1;
            }

            public final void setType(int r1) {
                this.type = r1;
            }
        }

        public Entity() {
        }

        public final BodyEntity getBody() {
            return this.body;
        }

        public final HeaderEntity getHeader() {
            return this.header;
        }

        public final IdentifierEntity getIdentifier() {
            return this.identifier;
        }

        public final String getOperation() {
            return this.operation;
        }

        public final void setBody(BodyEntity r1) {
            this.body = r1;
        }

        public final void setHeader(HeaderEntity r1) {
            this.header = r1;
        }

        public final void setIdentifier(IdentifierEntity r1) {
            this.identifier = r1;
        }

        public final void setOperation(String r1) {
            this.operation = r1;
        }
    }

    public ReactionDataEntity() {
    }

    public final String getBusiness() {
        return this.business;
    }

    public final Entity getData() {
        return this.data;
    }

    public final void setBusiness(String r1) {
        this.business = r1;
    }

    public final void setData(Entity r1) {
        this.data = r1;
    }
}
