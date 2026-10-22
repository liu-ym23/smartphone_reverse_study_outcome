package o14;

import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.awemeopen.bizmodels.comment.CommentImageStruct;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\bd\u0010eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\"\u0010(\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u00104R*\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00104\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR\"\u0010?\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0016\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR$\u0010B\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bH\u0010\u000fR$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR\"\u0010S\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR$\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0007\"\u0004\b_\u0010\tR*\u0010a\u001a\n\u0012\u0004\u0012\u00020`\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u00104\u001a\u0004\bb\u00109\"\u0004\bc\u0010;¨\u0006f"}, d2 = {"Lo14/a;", "", "", "cid", "Ljava/lang/String;", "text", "l", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "awemeId", "b", "setAwemeId", "", "createTime", "J", "c", "()J", "setCreateTime", "(J)V", "", "diggCount", "I", "d", "()I", "s", "(I)V", "status", "getStatus", BaseSwitches.V, "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "user", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "o", "()Lcom/bytedance/awemeopen/bizmodels/profile/User;", "x", "(Lcom/bytedance/awemeopen/bizmodels/profile/User;)V", "replyId", RXScreenCaptureService.KEY_INDEX, "setReplyId", "userDigged", "q", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "", "userBuried", "Z", "p", "()Z", "y", "(Z)V", "", "replyComments", "Ljava/util/List;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/video/TextExtraStruct;", "textExtra", "m", "()Ljava/util/List;", "setTextExtra", "(Ljava/util/List;)V", "labelText", ce.f26391f, "t", "labelType", "h", "setLabelType", "topCount", "Ljava/lang/Integer;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/Integer;", "setTopCount", "(Ljava/lang/Integer;)V", "replyCommentTotal", "Lq14/a;", "emoji", "Lq14/a;", "e", "()Lq14/a;", "setEmoji", "(Lq14/a;)V", "forwardId", "getForwardId", "setForwardId", "replyToUserName", ce.f26396k, "u", "Lr14/c;", "aliasAweme", "Lr14/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lr14/c;", "setAliasAweme", "(Lr14/c;)V", "replyToReplyId", ce.f26395j, "setReplyToReplyId", "Lcom/bytedance/awemeopen/bizmodels/comment/CommentImageStruct;", "imageList", "f", "setImageList", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f521699c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f521700a;

    @SerializedName("alias_aweme")
    private r14.c aliasAweme;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String awemeId;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient g f521701b;

    @SerializedName("cid")
    public String cid;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("digg_count")
    private int diggCount;

    @SerializedName("sticker")
    private q14.a emoji;

    @SerializedName("forward_id")
    private String forwardId;

    @SerializedName("image_list")
    private List<CommentImageStruct> imageList;

    @SerializedName("label_text")
    private String labelText;

    @SerializedName("label_type")
    private int labelType;

    @SerializedName("reply_comment_total")
    public long replyCommentTotal;

    @SerializedName("reply_comment")
    public List<a> replyComments;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private String replyId;

    @SerializedName("reply_to_reply_id")
    private String replyToReplyId;

    @SerializedName("reply_to_username")
    private String replyToUserName;

    @SerializedName("status")
    private int status;

    @SerializedName("text")
    private String text;

    @SerializedName("text_extra")
    private List<TextExtraStruct> textExtra;

    @SerializedName("reply_collapse_count")
    private Integer topCount;

    @SerializedName("user")
    private User user;

    @SerializedName("user_buried")
    private boolean userBuried;

    @SerializedName("user_digged")
    private int userDigged;

    /* JADX INFO: renamed from: o14.a$a, reason: collision with other inner class name */
    public static final class C7002a {
        public static String a(a r100) {
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.j();
        L6:
            boolean r103 = false;
            if (r102 != null) goto L9;
        L12:
            boolean r104 = true;
        L14:
            if (r104 == false) goto L16;
        L18:
            boolean r105 = false;
        L19:
            if (r105 == false) goto L21;
            return "reply_to_reply";
        L21:
            if (r100 == null) goto L23;
            r101 = r100.i();
        L23:
            if (r101 != null) goto L25;
        L28:
            boolean r106 = true;
        L29:
            if (r106 == false) goto L31;
        L33:
            if (r103 == false) goto L35;
            return "reply";
        L35:
            return "original";
        L31:
            if (Intrinsics.areEqual(r101, "0") == true) goto L33;
            r103 = true;
            goto L33
        L25:
            if (r101.length() == 0) goto L28;
            r106 = false;
            goto L29
        L16:
            if (Intrinsics.areEqual(r102, "0") == true) goto L18;
            r105 = true;
            goto L19
        L9:
            if (r102.length() == 0) goto L12;
            r104 = false;
            goto L14
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public final int hashCode() {
        String r100 = this.cid;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final boolean r() {
        if (this.userDigged == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void t() {
        Intrinsics.checkNotNullParameter("我", "<set-?>");
        this.labelText = "我";
    }

    public a() {
        this.cid = "";
        this.text = "";
        this.awemeId = "";
        this.replyId = "";
        this.labelText = "";
        this.forwardId = "";
        this.replyToUserName = "";
        this.replyToReplyId = "";
        this.f521701b = new g(0);
    }

    public final r14.c a() {
        return this.aliasAweme;
    }

    public final String b() {
        return this.awemeId;
    }

    public final long c() {
        return this.createTime;
    }

    public final int d() {
        return this.diggCount;
    }

    public final q14.a e() {
        return this.emoji;
    }

    public final List<CommentImageStruct> f() {
        return this.imageList;
    }

    public final String g() {
        return this.labelText;
    }

    public final int h() {
        return this.labelType;
    }

    public final String i() {
        return this.replyId;
    }

    public final String j() {
        return this.replyToReplyId;
    }

    public final String k() {
        return this.replyToUserName;
    }

    public final String l() {
        return this.text;
    }

    public final List<TextExtraStruct> m() {
        return this.textExtra;
    }

    public final Integer n() {
        return this.topCount;
    }

    public final User o() {
        return this.user;
    }

    public final boolean p() {
        return this.userBuried;
    }

    public final int q() {
        return this.userDigged;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.cid, ((a) r100).cid);
    }

    public final void s(int r100) {
        this.diggCount = r100;
    }

    public final void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.replyToUserName = r100;
    }

    public final void v(int r100) {
        this.status = r100;
    }

    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void x(User r100) {
        this.user = r100;
    }

    public final void y(boolean r100) {
        this.userBuried = r100;
    }

    public final void z(int r100) {
        this.userDigged = r100;
    }
}
