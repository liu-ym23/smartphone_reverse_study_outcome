package com.bytedance.ee.bear.rn.middleground.business.comment;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseProtocol;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0010\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "<init>", "()V", "BeginSync", "EndSync", "Fetch", "FetchMessage", "FetchNoticeList", "Publish", "Translate", "SetTranslateEnableLang", "AddTranslateComments", UserChangedCallback.CHANGE_TYPE_UPDATE, "Edit", "Delete", "Query", "SetOpenApiSession", "SetJsSdkSession", SOAP.BODY, "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CommentProtocol<T extends Protocol.Body> extends Protocol<T> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$AddTranslateComments;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$AddTranslateComments;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddTranslateComments extends Protocol<Body.AddTranslateComments> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_ADD_TRANSLATE_COMMENTS, getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public AddTranslateComments() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$BeginSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/base/BaseProtocol$Body$BeginSync;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BeginSync extends Protocol<BaseProtocol.Body.BeginSync> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_BEGIN_SNYC, null, getMIdentifier(), getMBody(), null, 18, null)), true);
        }

        public BeginSync() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\r\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "PublishType", "PublishComment", "UpdateComment", "Translate", "SetTranslateEnableLang", "AddTranslateComments", "Solve", "EditComment", "DeleteComment", "QueryComment", "Extra", "SetOpenApiSession", "SetJsSdkSession", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Body extends Protocol.Body {

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$AddTranslateComments;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "comments", "", "Lcom/bytedance/ee/bear/middleground/comment/export/commentsdk/bean/CommentMetadata;", "<init>", "([Lcom/bytedance/ee/bear/middleground/comment/export/commentsdk/bean/CommentMetadata;)V", "getComments", "()[Lcom/bytedance/ee/bear/middleground/comment/export/commentsdk/bean/CommentMetadata;", "[Lcom/bytedance/ee/bear/middleground/comment/export/commentsdk/bean/CommentMetadata;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AddTranslateComments implements Body {
            private final CommentMetadata[] comments;

            public final CommentMetadata[] getComments() {
                return this.comments;
            }

            public AddTranslateComments(CommentMetadata[] r100) {
                Intrinsics.checkNotNullParameter(r100, "comments");
                this.comments = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$DeleteComment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "comment_id", "", NoticeInfo.KEY_REPLY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getComment_id", "()Ljava/lang/String;", "getReply_id", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DeleteComment implements Body {
            private final String comment_id;
            private final String reply_id;

            public final String getComment_id() {
                return this.comment_id;
            }

            public final String getReply_id() {
                return this.reply_id;
            }

            public DeleteComment(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "comment_id");
                Intrinsics.checkNotNullParameter(r101, NoticeInfo.KEY_REPLY_ID);
                this.comment_id = r100;
                this.reply_id = r101;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R#\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00078G@GX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$EditComment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "comment_id", "", NoticeInfo.KEY_REPLY_ID, "content", "shouldAuthorize", "", "extra", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;", "bizParams", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;Ljava/util/Map;)V", "getComment_id", "()Ljava/lang/String;", "getReply_id", "getContent", "getShouldAuthorize", "()Z", "getExtra", "()Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;", "getBizParams", "()Ljava/util/Map;", "value", "is_audio", "()Ljava/lang/Boolean;", "set_audio", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class EditComment implements Body {
            private final Map<Object, Object> bizParams;
            private final String comment_id;
            private final String content;
            private final Extra extra;
            private Boolean is_audio;
            private final String reply_id;
            private final boolean shouldAuthorize;

            public final Map<Object, Object> getBizParams() {
                return this.bizParams;
            }

            public final String getComment_id() {
                return this.comment_id;
            }

            public final String getContent() {
                return this.content;
            }

            public final Extra getExtra() {
                return this.extra;
            }

            public final String getReply_id() {
                return this.reply_id;
            }

            public final boolean getShouldAuthorize() {
                return this.shouldAuthorize;
            }

            @JSONField(name = "is_audio")
            public final Boolean is_audio() {
                return this.is_audio;
            }

            @JSONField(name = "is_audio")
            public final void set_audio(Boolean r100) {
                this.is_audio = r100;
            }

            public EditComment(String r100, String r101, String r102, boolean r103, Extra r104, Map<Object, ? extends Object> r105) {
                Intrinsics.checkNotNullParameter(r100, "comment_id");
                Intrinsics.checkNotNullParameter(r101, NoticeInfo.KEY_REPLY_ID);
                Intrinsics.checkNotNullParameter(r102, "content");
                this.comment_id = r100;
                this.reply_id = r101;
                this.content = r102;
                this.shouldAuthorize = r103;
                this.extra = r104;
                this.bizParams = r105;
                this.is_audio = Boolean.FALSE;
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$Attachment;", "options", "", "image_list", "", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$CommentImageItem;", "<init>", "(Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$Attachment;Ljava/lang/String;Ljava/util/List;)V", "getAttachment", "()Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$Attachment;", "getOptions", "()Ljava/lang/String;", "getImage_list", "()Ljava/util/List;", "Attachment", "CommentImageItem", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Extra implements Body {
            private final Attachment attachment;
            private final List<CommentImageItem> image_list;
            private final String options;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$Attachment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "audio_file_token", "", "audio_duration", "", "options", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAudio_file_token", "()Ljava/lang/String;", "getAudio_duration", "()I", "getOptions", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Attachment implements Body {
                private final int audio_duration;
                private final String audio_file_token;
                private final String options;

                public final int getAudio_duration() {
                    return this.audio_duration;
                }

                public final String getAudio_file_token() {
                    return this.audio_file_token;
                }

                public final String getOptions() {
                    return this.options;
                }

                public Attachment(String r100, int r101, String r102) {
                    Intrinsics.checkNotNullParameter(r100, "audio_file_token");
                    this.audio_file_token = r100;
                    this.audio_duration = r101;
                    this.options = r102;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra$CommentImageItem;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "token", "", ST.UUID_DEVICE, "src", "originalSrc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUuid", "getSrc", "getOriginalSrc", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class CommentImageItem implements Body {
                private final String originalSrc;

                /* JADX INFO: renamed from: src, reason: collision with root package name */
                private final String f236577src;
                private final String token;
                private final String uuid;

                public final String getOriginalSrc() {
                    return this.originalSrc;
                }

                public final String getSrc() {
                    return this.f236577src;
                }

                public final String getToken() {
                    return this.token;
                }

                public final String getUuid() {
                    return this.uuid;
                }

                public CommentImageItem(String r100, String r101, String r102, String r103) {
                    Intrinsics.checkNotNullParameter(r102, "src");
                    this.token = r100;
                    this.uuid = r101;
                    this.f236577src = r102;
                    this.originalSrc = r103;
                }

                public /* synthetic */ CommentImageItem(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
                    if ((r104 & 1) == 0) goto L6;
                    r100 = null;
                L6:
                    if ((r104 & 8) == 0) goto L8;
                    r103 = null;
                L8:
                    this(r100, r101, r102, r103);
                }
            }

            public final Attachment getAttachment() {
                return this.attachment;
            }

            public final List<CommentImageItem> getImage_list() {
                return this.image_list;
            }

            public final String getOptions() {
                return this.options;
            }

            public Extra(Attachment r100, String r101, List<CommentImageItem> r102) {
                this.attachment = r100;
                this.options = r101;
                this.image_list = r102;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b \u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R#\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R,\u0010/\u001a\u0004\u0018\u00010\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00118G@GX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R,\u00104\u001a\u0004\u0018\u00010\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00118G@GX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$PublishComment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "quote", "", "content", "comment_id", "extra", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;", "tmp_comment_id", "parent_type", DocViewModel.EXTRA_PARENT_TOKEN, NoticeInfo.KEY_REPLY_ID, "type", "", "local_comment_id", "position", "shouldAuthorize", "", RemoteMessageConst.Notification.VISIBILITY, "Lcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;", "bizParams", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;Ljava/util/Map;)V", "getQuote", "()Ljava/lang/String;", "getContent", "getComment_id", "getExtra", "()Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Extra;", "getTmp_comment_id", "getParent_type", "getParent_token", "getReply_id", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLocal_comment_id", "getPosition", "getShouldAuthorize", "()Z", "getVisibility", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;", "getBizParams", "()Ljava/util/Map;", "value", "is_whole", "()Ljava/lang/Boolean;", "set_whole", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "is_audio", "set_audio", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class PublishComment implements Body {
            private final Map<Object, Object> bizParams;
            private final String comment_id;
            private final String content;
            private final Extra extra;
            private Boolean is_audio;
            private Boolean is_whole;
            private final String local_comment_id;
            private final String parent_token;
            private final String parent_type;
            private final String position;
            private final String quote;
            private final String reply_id;
            private final boolean shouldAuthorize;
            private final String tmp_comment_id;
            private final Integer type;
            private final VisibilityBean visibility;

            public final Map<Object, Object> getBizParams() {
                return this.bizParams;
            }

            public final String getComment_id() {
                return this.comment_id;
            }

            public final String getContent() {
                return this.content;
            }

            public final Extra getExtra() {
                return this.extra;
            }

            public final String getLocal_comment_id() {
                return this.local_comment_id;
            }

            public final String getParent_token() {
                return this.parent_token;
            }

            public final String getParent_type() {
                return this.parent_type;
            }

            public final String getPosition() {
                return this.position;
            }

            public final String getQuote() {
                return this.quote;
            }

            public final String getReply_id() {
                return this.reply_id;
            }

            public final boolean getShouldAuthorize() {
                return this.shouldAuthorize;
            }

            public final String getTmp_comment_id() {
                return this.tmp_comment_id;
            }

            public final Integer getType() {
                return this.type;
            }

            public final VisibilityBean getVisibility() {
                return this.visibility;
            }

            @JSONField(name = "is_audio")
            public final Boolean is_audio() {
                return this.is_audio;
            }

            @JSONField(name = "is_whole")
            public final Boolean is_whole() {
                return this.is_whole;
            }

            @JSONField(name = "is_audio")
            public final void set_audio(Boolean r100) {
                this.is_audio = r100;
            }

            @JSONField(name = "is_whole")
            public final void set_whole(Boolean r100) {
                this.is_whole = r100;
            }

            public PublishComment(String r100, String r101, String r102, Extra r103, String r104, String r105, String r106, String r107, Integer r110, String r111, String r112, boolean r113, VisibilityBean r114, Map<Object, ? extends Object> r115) {
                Intrinsics.checkNotNullParameter(r101, "content");
                Intrinsics.checkNotNullParameter(r114, RemoteMessageConst.Notification.VISIBILITY);
                this.quote = r100;
                this.content = r101;
                this.comment_id = r102;
                this.extra = r103;
                this.tmp_comment_id = r104;
                this.parent_type = r105;
                this.parent_token = r106;
                this.reply_id = r107;
                this.type = r110;
                this.local_comment_id = r111;
                this.position = r112;
                this.shouldAuthorize = r113;
                this.visibility = r114;
                this.bizParams = r115;
                Boolean r108 = Boolean.FALSE;
                this.is_whole = r108;
                this.is_audio = r108;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$QueryComment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "commentId", "", "<init>", "(Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class QueryComment implements Body {
            private final String commentId;

            public final String getCommentId() {
                return this.commentId;
            }

            public QueryComment(String r100) {
                Intrinsics.checkNotNullParameter(r100, "commentId");
                this.commentId = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetJsSdkSession;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "<init>", "(Ljava/lang/String;)V", "getSession", "()Ljava/lang/String;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SetJsSdkSession implements Body {
            private final String session;

            public final String getSession() {
                return this.session;
            }

            public SetJsSdkSession(String r100) {
                Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
                this.session = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetOpenApiSession;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "<init>", "(Ljava/lang/String;)V", "getSession", "()Ljava/lang/String;", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SetOpenApiSession implements Body {
            private final String session;

            public final String getSession() {
                return this.session;
            }

            public SetOpenApiSession(String r100) {
                Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
                this.session = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetTranslateEnableLang;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "translateLang", "", "<init>", "(Ljava/lang/String;)V", "getTranslateLang", "()Ljava/lang/String;", "value", "", "isEnableTranslate", "()Z", "setEnableTranslate", "(Z)V", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SetTranslateEnableLang implements Body {
            private boolean isEnableTranslate;
            private final String translateLang;

            public final String getTranslateLang() {
                return this.translateLang;
            }

            @JSONField(name = "isEnableTranslate")
            public final boolean isEnableTranslate() {
                return this.isEnableTranslate;
            }

            public SetTranslateEnableLang(String r100) {
                Intrinsics.checkNotNullParameter(r100, "translateLang");
                this.translateLang = r100;
            }

            @JSONField(name = "isEnableTranslate")
            public final void setEnableTranslate(boolean r100) {
                this.isEnableTranslate = r100;
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Solve;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "messageIds", "", "", "solveStatus", "", "options", "<init>", "([Ljava/lang/String;ILjava/lang/String;)V", "getMessageIds", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSolveStatus", "()I", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Solve implements Body {
            private final String[] messageIds;
            private final int solveStatus;

            public final String[] getMessageIds() {
                return this.messageIds;
            }

            public final int getSolveStatus() {
                return this.solveStatus;
            }

            public Solve(String[] r100, int r101, String r102) {
                Intrinsics.checkNotNullParameter(r100, "messageIds");
                this.messageIds = r100;
                this.solveStatus = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Translate;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "comment_id", "", NoticeInfo.KEY_REPLY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getComment_id", "()Ljava/lang/String;", "getReply_id", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Translate implements Body {
            private final String comment_id;
            private final String reply_id;

            public final String getComment_id() {
                return this.comment_id;
            }

            public final String getReply_id() {
                return this.reply_id;
            }

            public Translate(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "comment_id");
                Intrinsics.checkNotNullParameter(r101, NoticeInfo.KEY_REPLY_ID);
                this.comment_id = r100;
                this.reply_id = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$UpdateComment;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body;", "comment_id", "", VideoEventOneOutSync.END_TYPE_FINISH, "", "<init>", "(Ljava/lang/String;I)V", "getComment_id", "()Ljava/lang/String;", "getFinish", "()I", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class UpdateComment implements Body {
            private final String comment_id;
            private final int finish;

            public final String getComment_id() {
                return this.comment_id;
            }

            public final int getFinish() {
                return this.finish;
            }

            public UpdateComment(String r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, "comment_id");
                this.comment_id = r100;
                this.finish = r101;
            }
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f236578a = 0;

            static {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Delete;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$DeleteComment;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Delete extends Protocol<Body.DeleteComment> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("delete", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Delete() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Edit;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$EditComment;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Edit extends Protocol<Body.EditComment> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("edit", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Edit() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$EndSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EndSync extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_END_SYNC, null, getMIdentifier(), getMBody(), null, 18, null)), true);
        }

        public EndSync() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Fetch;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Fetch extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("fetch", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Fetch() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$FetchMessage;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FetchMessage extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("fetchMessage", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public FetchMessage() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$FetchNoticeList;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FetchNoticeList extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("fetchNoticeList", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public FetchNoticeList() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Publish;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$PublishComment;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Publish extends Protocol<Body.PublishComment> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("publish", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Publish() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Query;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$QueryComment;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Query extends Protocol<Body.QueryComment> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("queryComment", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Query() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$SetJsSdkSession;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetJsSdkSession;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetJsSdkSession extends Protocol<Body.SetJsSdkSession> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("setJsSdkSession", null, getMIdentifier(), getMBody(), null, 18, null)), true);
        }

        public SetJsSdkSession() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$SetOpenApiSession;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetOpenApiSession;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetOpenApiSession extends Protocol<Body.SetOpenApiSession> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("setOpenApiSession", null, getMIdentifier(), getMBody(), null, 18, null)), true);
        }

        public SetOpenApiSession() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$SetTranslateEnableLang;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetTranslateEnableLang;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetTranslateEnableLang extends Protocol<Body.SetTranslateEnableLang> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_SET_TRANSLATE_ENABLE_LANG, getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public SetTranslateEnableLang() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Translate;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$Translate;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Translate extends Protocol<Body.Translate> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("translate", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Translate() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Update;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$UpdateComment;", "<init>", "()V", "getJsonString", "", "UPDATE", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Update extends Protocol<Body.UpdateComment> {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Update$UPDATE;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "RESOLVE", "REOPEN", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum UPDATE extends Enum<UPDATE> {
            public static final UPDATE REOPEN = null;
            public static final UPDATE RESOLVE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ UPDATE[] f236579a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f236580b = null;
            private final int type;

            public static EnumEntries<UPDATE> getEntries() {
                return f236580b;
            }

            static {
                UPDATE r100 = new UPDATE("RESOLVE", 0, 1);
                RESOLVE = r100;
                UPDATE r101 = new UPDATE("REOPEN", 1, 0);
                REOPEN = r101;
                UPDATE[] r102 = {r100, r101};
                f236579a = r102;
                f236580b = EnumEntriesKt.enumEntries(r102);
            }

            public static UPDATE[] values() {
                return (UPDATE[]) f236579a.clone();
            }

            public final int type() {
                return this.type;
            }

            public static UPDATE valueOf(String r100) {
                return (UPDATE) r27.a.a(UPDATE.class, r100);
            }

            public UPDATE(String r100, int r101, int r102) {
                super(r100, r101);
                this.type = r102;
            }
        }

        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            return JSON.toJSONString(new Protocol.Entity.Base("comment", new Protocol.Entity.Data("update", getMHeader(), getMIdentifier(), getMBody(), null, 16, null)), true);
        }

        public Update() {
        }
    }

    public CommentProtocol() {
    }
}
