package com.bytedance.ee.bear.rn.middleground.business.reaction;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007\u0006\u0007\b\t\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "<init>", "()V", "BeginSync", "EndSync", "AddReaction", "RemoveReaction", "ReactionDetail", "DetailPanelStatus", SOAP.BODY, "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ReactionProtocol<T extends Protocol.Body> extends Protocol<T> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$AddReaction;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$AddReaction;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddReaction extends Protocol<Body.AddReaction> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Header r100 = getMHeader();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            int r110 = r101.getType();
            Protocol.Entity.Identifier r102 = getMIdentifier();
            Intrinsics.checkNotNull(r102);
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("addReaction", r100, new Protocol.Entity.Identifier(r110, r102.getToken(), false, null, 12, null), getMBody(), null, 16, null)), true);
        }

        public AddReaction() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$BeginSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BeginSync extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Identifier r100 = getMIdentifier();
            Intrinsics.checkNotNull(r100);
            int r110 = r100.getType();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            return JSON.toJSONString(new Protocol.Entity.Base("common", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_BEGIN_SNYC, null, new Protocol.Entity.Identifier(r110, r101.getToken(), false, null, 12, null), null, null, 26, null)), true);
        }

        public BeginSync() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "AddReaction", "RemoveReaction", "GetReactionDetail", "DetailPanelStatus", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Body extends Protocol.Body {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$AddReaction;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body;", "replyId", "", "reactionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getReplyId", "()Ljava/lang/String;", "getReactionKey", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AddReaction implements Body {
            private final String reactionKey;
            private final String replyId;

            public final String getReactionKey() {
                return this.reactionKey;
            }

            public final String getReplyId() {
                return this.replyId;
            }

            public AddReaction(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "replyId");
                Intrinsics.checkNotNullParameter(r101, "reactionKey");
                this.replyId = r100;
                this.reactionKey = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$DetailPanelStatus;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "referType", "", "referKey", "status", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getReferType", "()Ljava/lang/String;", "getReferKey", "getStatus", "()I", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DetailPanelStatus implements Protocol.Body {
            private final String referKey;
            private final String referType;
            private final int status;

            public final String getReferKey() {
                return this.referKey;
            }

            public final String getReferType() {
                return this.referType;
            }

            public final int getStatus() {
                return this.status;
            }

            public DetailPanelStatus(String r100, String r101, int r102) {
                Intrinsics.checkNotNullParameter(r100, "referType");
                Intrinsics.checkNotNullParameter(r101, "referKey");
                this.referType = r100;
                this.referKey = r101;
                this.status = r102;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$GetReactionDetail;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body;", "referType", "", "referKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getReferType", "()Ljava/lang/String;", "getReferKey", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class GetReactionDetail implements Body {
            private final String referKey;
            private final String referType;

            public final String getReferKey() {
                return this.referKey;
            }

            public final String getReferType() {
                return this.referType;
            }

            public GetReactionDetail(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "referType");
                Intrinsics.checkNotNullParameter(r101, "referKey");
                this.referType = r100;
                this.referKey = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$RemoveReaction;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body;", "replyId", "", "reactionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getReplyId", "()Ljava/lang/String;", "getReactionKey", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class RemoveReaction implements Body {
            private final String reactionKey;
            private final String replyId;

            public final String getReactionKey() {
                return this.reactionKey;
            }

            public final String getReplyId() {
                return this.replyId;
            }

            public RemoveReaction(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "replyId");
                Intrinsics.checkNotNullParameter(r101, "reactionKey");
                this.replyId = r100;
                this.reactionKey = r101;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$DetailPanelStatus;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$DetailPanelStatus;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DetailPanelStatus extends Protocol<Body.DetailPanelStatus> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Header r100 = getMHeader();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            int r110 = r101.getType();
            Protocol.Entity.Identifier r102 = getMIdentifier();
            Intrinsics.checkNotNull(r102);
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("setReactionDetailPanelStatus", r100, new Protocol.Entity.Identifier(r110, r102.getToken(), false, null, 12, null), getMBody(), null, 16, null)), true);
        }

        public DetailPanelStatus() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$EndSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EndSync extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Identifier r100 = getMIdentifier();
            Intrinsics.checkNotNull(r100);
            int r110 = r100.getType();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            return JSON.toJSONString(new Protocol.Entity.Base("common", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_END_SYNC, null, new Protocol.Entity.Identifier(r110, r101.getToken(), false, null, 12, null), null, null, 26, null)), true);
        }

        public EndSync() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$ReactionDetail;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$GetReactionDetail;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReactionDetail extends Protocol<Body.GetReactionDetail> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Header r100 = getMHeader();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            int r110 = r101.getType();
            Protocol.Entity.Identifier r102 = getMIdentifier();
            Intrinsics.checkNotNull(r102);
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("getReactionDetail", r100, new Protocol.Entity.Identifier(r110, r102.getToken(), false, null, 12, null), getMBody(), null, 16, null)), true);
        }

        public ReactionDetail() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$RemoveReaction;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/reaction/ReactionProtocol$Body$RemoveReaction;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoveReaction extends Protocol<Body.RemoveReaction> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Header r100 = getMHeader();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            int r110 = r101.getType();
            Protocol.Entity.Identifier r102 = getMIdentifier();
            Intrinsics.checkNotNull(r102);
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("removeReaction", r100, new Protocol.Entity.Identifier(r110, r102.getToken(), false, null, 12, null), getMBody(), null, 16, null)), true);
        }

        public RemoveReaction() {
        }
    }

    public ReactionProtocol() {
    }
}
