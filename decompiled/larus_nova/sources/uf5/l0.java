package uf5;

import android.app.Application;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.ObjMetaBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.ShareBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UnknownBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UserEntity;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile l0 f549912d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f549913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> f549914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.feed.export.bean.k f549915c;

    public static l0 b() {
        if (f549912d != null) goto L15;
        monitor-enter(l0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f549912d != null) goto L9;
        f549912d = new l0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l0.class);     // Catch: Throwable -> L11
    L15:
        return f549912d;
    }

    public l0() {
        this.f549913a = "";
        this.f549914b = new MutableLiveData();
    }

    public final MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> a(String r100, int r101, final Long r102) {
        if (TextUtils.isEmpty(this.f549913a) == true) goto L7;
        if (r100 == null) goto L9;
        if (r100.equals(this.f549913a) == false) goto L7;
    L9:
        return this.f549914b;
    L7:
        this.f549914b = new MutableLiveData();
        final OfflineDoc r103 = new OfflineDoc();
        r103.setObj_token(r100);
        r103.setToken(r100);
        r103.setType(r101);
        r103.setFrom_source("docs_feed");
        this.f549913a = r103.getObj_token();
        Flowable.just(r103).filter(new s(this, r103)).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).flatMap(new c0(this, r103, r102)).filter(new d0()).flatMap(new e0(this, r103)).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).flatMap(new f0(this, r103, r102)).subscribe(new g0(), new h0(this, r103), new i0());
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.functions.Function0, mwc.c] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final MessageResultBean c(p r110, String r111, int r210, boolean r211, Long r212) throws JSONException {
        if ("network".equals(r110.f549922a) == false) goto L5;
        MessageResultBean r100 = (MessageResultBean) JSON.parseObject(r110.f549923b, MessageResultBean.class);
    L6:
        MessageResultBean r101 = r100;
        int r102 = n0.f549918a;
        ?? r103 = 0;
        if (r101 == null) goto L9;
        MessageResultBean.Data r104 = r101.getData();
    L10:
        if (r104 == null) goto L12;
        List<MessageBean> r105 = r104.getMessage();
    L14:
        if (com.larksuite.framework.utils.q.a(r105) == true) goto L117;
        if (r104 == null) goto L19;
        MessageResultBean.Data.Entities r106 = r104.getEntities();
        if (r106 == null) goto L19;
        Map<String, UserEntity> r107 = r106.getUsers();
    L20:
        if (r104 == null) goto L24;
        MessageResultBean.Data.Entities r108 = r104.getEntities();
        if (r108 == null) goto L24;
        Map<String, ObjMetaBean> r109 = r108.getObjMeta();
    L25:
        if (r107 != null) goto L28;
        if (r109 == null) goto L117;
    L28:
        List<MessageBean> r112 = r104.getMessage();
        if (r112 == null) goto L117;
        Iterator<MessageBean> r113 = r112.iterator();
    L32:
        if (r113.hasNext() == false) goto L117;
        MessageBean r114 = r113.next();
        String r115 = r114.getContent();
        if (TextUtils.isEmpty(r115) == true) goto L32;
        Matcher r116 = PatternProtector.compile("<at(\n|.)*?>(\n|.)*?</at>").matcher(r115);
        StringBuffer r117 = new StringBuffer();
        String r118 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, r103, r103, 6)).a();
        ?? r119 = r103;
    L38:
        if (r116.find() == false) goto L107;
        Intrinsics.checkNotNull(r115);
        String r120 = r115.substring(r116.start(), r116.end());
        bo4.a r121 = db5.d.e(r120, 0, r120.length());     // Catch: Exception -> L42
    L45:
        if (r121 != null) goto L47;
    L49:
        boolean r122 = false;
    L50:
        if (r122 == false) goto L82;
        if (r107 != null) goto L53;
    L55:
        boolean r123 = false;
    L56:
        if (r123 == false) goto L82;
        UserEntity r124 = r107.get(r121.f19815e);
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), r118) == false) goto L71;
        if (r124 == null) goto L61;
        HashMap<String, String> r125 = r124.getI18nName();
    L62:
        String r126 = ou5.c.a(r125);
        if (TextUtils.isEmpty(r126) == true) goto L65;
        r121.f19817g = "@".concat(r126);
    L77:
        if (r124 == null) goto L79;
        HashMap<String, String> r127 = r124.getI18nName();
    L80:
        r121.f19822l = r127;
        StringBuilder r128 = new StringBuilder(r120);
        db5.f.c(r128, r121);
        r120 = r128.toString();
    L81:
        Object r129 = null;
        String r130 = r120;
    L106:
        r116.appendReplacement(r117, r130);
        r119 = r129;
        goto L38
    L79:
        r127 = null;
        goto L80
    L65:
        if (r124 == null) goto L67;
        String r131 = r124.getCnName();
    L69:
        if (TextUtils.isEmpty(r131) == true) goto L77;
        StringBuilder r132 = new StringBuilder("@");
        Intrinsics.checkNotNull(r124);
        r132.append(r124.getCnName());
        r121.f19817g = r132.toString();
        goto L77
    L67:
        r131 = null;
        goto L69
    L61:
        r125 = null;
        goto L62
    L71:
        if (r124 == null) goto L73;
        String r133 = r124.getEnName();
    L75:
        if (TextUtils.isEmpty(r133) == true) goto L77;
        StringBuilder r134 = new StringBuilder("@");
        Intrinsics.checkNotNull(r124);
        r134.append(r124.getEnName());
        r121.f19817g = r134.toString();
        goto L77
    L73:
        r133 = null;
        goto L75
    L53:
        if (r107.containsKey(r121.f19815e) != true) goto L55;
        r123 = true;
    L82:
        if (r121 == null) goto L84;
        Integer r135 = Integer.valueOf(r121.f19813c);
    L85:
        if (r135 == null) goto L81;
        int r136 = r121.f19813c;
        if (AtUtils.c().contains(r136 + "") == false) goto L81;
        if (r109 != null) goto L90;
    L92:
        boolean r137 = false;
    L93:
        if (r137 == false) goto L81;
        ObjMetaBean r138 = r109.get(r121.f19815e);
        if (r138 == null) goto L81;
        String r139 = r138.getTitle();
        if (r139 != null) goto L99;
    L102:
        boolean r140 = true;
    L103:
        if (r140 == false) goto L81;
        r129 = null;
        r121.f19817g = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(eu5.b.f474075a, r138.getDocType());
        StringBuilder r141 = new StringBuilder(r120);
        db5.f.c(r141, r121);
        r130 = r141.toString();
        goto L106
    L99:
        if (r139.length() == 0) goto L102;
        r140 = false;
        goto L103
    L90:
        if (r109.containsKey(r121.f19815e) != true) goto L92;
        r137 = true;
        goto L93
    L84:
        r135 = null;
        goto L85
    L47:
        if (r121.f19813c != 0) goto L49;
        r122 = true;
    L42:
        e = move-exception;
        tt5.a.e("MessageDataUtilsKt", "parse at error", e, false);
        r121 = null;
        goto L45
    L107:
        ?? r142 = r119;
        r116.appendTail(r117);
        r114.setContent(r117.toString());
        if (ou5.a.e() == true) goto L110;
    L116:
        r103 = r142;
        goto L32
    L110:
        if (r114.getDisplay_name() != null) goto L116;
        if (r107 == null) goto L116;
        UserEntity r143 = r107.get(r114.getUser_id());
        if (r143 == null) goto L116;
        DisplayName r144 = new DisplayName();
        r144.setI18n_value(r143.getI18nName());
        r114.setDisplay_name(r144);
    L24:
        r109 = null;
    L19:
        r107 = null;
    L117:
        d(r110.f549922a, r101, r111, r210, r211, r212);
        return r101;
    L12:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r100 = m0.c(r110.f549923b);
        goto L6
    }

    public final void d(String r210, MessageResultBean r211, String r212, int r213, boolean r214, Long r215) {
        tt5.a.h("FeedMessageManager", "parseData()... source = " + r210 + ", token = " + du5.b.g(r212) + ", currentToken = " + du5.b.g(this.f549913a) + ", typeValue = " + r213 + ", feedPanel = " + r214);
        if (r211.getData().getMessage() != null) goto L5;
        tt5.a.k("FeedMessageManager", "message is empty");
        r211.getData().setMessage(Collections.emptyList());
    L5:
        m0.d("feed manager parse data", r211, new int[2]);
        AccountService$Account r100 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).U5();
        if (r212.equals(this.f549913a) == false) goto L141;
        if (r214 == true) goto L9;
        return;
    L9:
        if (r211.getData().getDataType() != 1) goto L143;
        m0.a(r211, r100.uid, new o());
        Application r101 = eu5.b.f474075a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "data");
        long r102 = System.currentTimeMillis();
        ArrayList r103 = new ArrayList();
        List<MessageBean> r104 = r211.getData().getMessage();
        if (r104 != null) goto L13;
        r104 = new ArrayList();
    L13:
        List<MessageBean> r110 = r104;
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        if (r215 == null) goto L16;
        Long r105 = Long.valueOf(r215.longValue() / ((long) 1000));
    L17:
        Long r106 = r105;
        Iterator r107 = r110.iterator();
        int r108 = 0;
    L19:
        if (r107.hasNext() == false) goto L131;
        Object r113 = r107.next();
        int r114 = r108 + 1;
        if (r108 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        MessageBean r115 = (MessageBean) r113;
        Iterator r216 = r107;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("base.message_center.suite") == false) goto L30;
        if (r106 == null) goto L30;
        if (r115.getCreateTime() <= r106.longValue()) goto L30;
        r106 = r106;
    L130:
        r107 = r216;
        r108 = r114;
        r112 = r112;
        r106 = r106;
    L30:
        if (Intrinsics.areEqual(r115.getType(), MessageBean.MESSAGE_DOC_COMMENT) == false) goto L115;
        r111.add(Integer.valueOf(r115.getDelete()));
        r112.add(Integer.valueOf(r115.getFinish()));
        if (r115.getDelete() != 1) goto L34;
    L98:
        r106 = r106;
        r112 = r112;
        Intrinsics.checkNotNull(r115);
        if (r108 != CollectionsKt.getLastIndex(r110)) goto L101;
        boolean r109 = true;
    L102:
        DeleteBean r116 = new DeleteBean();
        r116.setMessageId(r115.getMessageId());
        r116.setCreateTime(r115.getCreateTime());
        r116.setReadStatus(r115.getReadStatus());
        if (r115.isHasCommentPermission() == true) goto L106;
        Pair r117 = TuplesKt.to(3, xo5.a.c(r101, R.string.LarkCCM_Docs_CommentPerm_NotifNoPerm_Text, HintConstants.AUTOFILL_HINT_USERNAME, q.a(r115.getDisplay_name(), r115.getName())));
    L108:
        Pair r118 = r117;
    L110:
        int r119 = ((Number) r118.component1()).intValue();
        String r120 = (String) r118.component2();
        r116.setType(r119);
        r116.setTitleStr(r120);
        r116.setLastItem(r109);
        r116.setUserId(r115.getUser_id());
        r116.setAvatarUrl(r115.getAvatar_url());
        r116.setCommentId(r115.getComment_id());
        r116.setReplyId(r115.getReply_id());
        if (r115.getIs_whole() != 1) goto L113;
        boolean r121 = true;
    L114:
        r116.setWhole(r121);
        r103.add(r116);
        goto L130
    L113:
        r121 = false;
        goto L114
    L106:
        if (r115.getDelete() != 1) goto L109;
        r117 = TuplesKt.to(1, xo5.a.c(r101, R.string.CreationMobile_Docs_Notification_CommentDeleted, ITwitterService.ResponseConstants.USER_NAME, q.a(r115.getDisplay_name(), r115.getName())));
        goto L108
    L109:
        r118 = TuplesKt.to(2, r101.getString(R.string.Doc_Feed_Comment_Resolve));
        goto L110
    L101:
        r109 = false;
        goto L102
    L34:
        if (r115.isHasCommentPermission() == false) goto L98;
        Intrinsics.checkNotNull(r115);
        if (r108 != CollectionsKt.getLastIndex(r110)) goto L39;
        boolean r122 = true;
    L40:
        FeedCommentDetailBean r123 = new FeedCommentDetailBean();
        r123.setMessageId(r115.getMessageId());
        r123.setReadStatus(r115.getReadStatus());
        r123.setCreateTime(r115.getCreateTime());
        String r124 = q.a(r115.getDisplay_name(), r115.getName());
        int r125 = JSONObjectProtectorUtils.getInt(new JSONObject(r115.getCommentExtra()), RemoteMessageConst.Notification.VISIBILITY);     // Catch: Exception -> L43
    L46:
        if (r115.getFinish() != 1) goto L52;
        if (r115.getIs_whole() != 1) goto L50;
        Pair r126 = TuplesKt.to(0, xo5.a.c(r101, R.string.CreationMobile_Common_Notifications_DocCommentResolved, ITwitterService.ResponseConstants.USER_NAME, r124));
    L89:
        int r127 = ((Number) r126.component1()).intValue();
        String r128 = (String) r126.component2();
        r123.setType(r127);
        String r129 = "";
        if (TextUtils.isEmpty("") == true) goto L93;
        r128 = "";
    L93:
        r123.setTitleStr(r128);
        r123.setLastItem(r122);
        r123.setComment_id(r115.getComment_id());
        r123.setIs_whole(r115.getIs_whole());
        r123.setReply_id(r115.getReply_id());
        r123.setUser_id(r115.getUser_id());
        r123.setAvatar_url(r115.getAvatar_url());
        r123.setName(r124);
        r123.setQuote(r115.getQuote());
        r123.setCreate_timestamp(r115.getCreate_timestamp());
        r123.setUpdate_timestamp(r115.getUpdate_timestamp());
        if (TextUtils.isEmpty("") == false) goto L96;
        r129 = r115.getContent();
    L96:
        r123.setContent(r129);
        r123.setTranslate_content(r115.getTranslate_content());
        r123.setTranslate_status(r115.getTranslate_status());
        r123.setExtra(r115.getExtra());
        r123.setCommentType(r115.getCommentType());
        r103.add(r123);
        goto L130
    L50:
        r126 = TuplesKt.to(0, xo5.a.c(r101, R.string.CreationMobile_Docs_Notification_ResolveComment, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L52:
        if (r115.getIs_whole() != 1) goto L61;
        if (r125 != 1) goto L56;
    L58:
        int r130 = R.string.LarkCCM_Docs_PrivateComment_Added_Descrip;
    L59:
        r126 = TuplesKt.to(0, xo5.a.c(r101, r130, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L56:
        if (r125 == 2) goto L58;
        r130 = R.string.CreationMobile_Common_Notifications_DocCommentAdded_Desc;
        goto L59
    L61:
        if (r115.getReplyIndex() > 0) goto L70;
        if (r125 != 1) goto L65;
    L67:
        int r131 = R.string.LarkCCM_Docs_PrivateComment_Added_Descrip;
    L68:
        r126 = TuplesKt.to(0, xo5.a.c(r101, r131, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L65:
        if (r125 == 2) goto L67;
        r131 = R.string.CreationMobile_Docs_Notification_Comment;
        goto L68
    L70:
        if (r115.getCommentMention() != 1) goto L80;
        if (r125 != 1) goto L74;
    L76:
        int r132 = R.string.LarkCCM_Docs_PrivateComment_Replied_Descrip;
    L77:
        r126 = TuplesKt.to(0, xo5.a.c(r101, r132, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L74:
        if (r125 == 2) goto L76;
        r132 = R.string.Doc_Feed_At;
        goto L77
    L80:
        if (r115.getReplyIndex() > 0) goto L82;
        r126 = TuplesKt.to(0, xo5.a.c(r101, R.string.CreationMobile_Docs_Notification_Comment, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L82:
        if (r125 != 1) goto L84;
    L86:
        int r133 = R.string.LarkCCM_Docs_PrivateComment_Replied_Descrip;
    L87:
        r126 = TuplesKt.to(0, xo5.a.c(r101, r133, ITwitterService.ResponseConstants.USER_NAME, r124));
        goto L89
    L84:
        if (r125 == 2) goto L86;
        r133 = R.string.CreationMobile_Docs_Notification_ReplyComment;
    L43:
        e = move-exception;
        tt5.a.d("FeedDataFilter", "getVisibility " + e.getMessage());
        r125 = 0;
        goto L46
    L39:
        r122 = false;
        goto L40
    L115:
        r106 = r106;
        r112 = r112;
        if (Intrinsics.areEqual(r115.getType(), MessageBean.MESSAGE_DOC_MENTION) == false) goto L123;
        Intrinsics.checkNotNull(r115);
        if (r108 != CollectionsKt.getLastIndex(r110)) goto L120;
        boolean r134 = true;
    L121:
        AtBean r135 = new AtBean();
        r135.setMessageId(r115.getMessageId());
        r135.setCreateTime(r115.getCreateTime());
        r135.setReadStatus(r115.getReadStatus());
        r135.setContent(xo5.a.c(r101, R.string.CreationMobile_Docs_Notification_CommentMentioned, ITwitterService.ResponseConstants.USER_NAME, q.a(r115.getDisplay_name(), r115.getName())));
        r135.setLastItem(r134);
        r135.setAtId(r115.getMentionId());
        r135.setAvatarUrl(r115.getAvatar_url());
        r135.setUserId(r115.getUser_id());
        r103.add(r135);
        goto L130
    L120:
        r134 = false;
        goto L121
    L123:
        if (Intrinsics.areEqual(r115.getType(), MessageBean.MESSAGE_DOC_SHARE) == false) goto L129;
        Intrinsics.checkNotNull(r115);
        if (r108 != CollectionsKt.getLastIndex(r110)) goto L127;
        boolean r136 = true;
    L128:
        ShareBean r137 = new ShareBean();
        r137.setMessageId(r115.getMessageId());
        r137.setCreateTime(r115.getCreateTime());
        r137.setReadStatus(r115.getReadStatus());
        r137.setContent(xo5.a.c(r101, R.string.LarkCCM_Feed_SharedDocWithYou, ITwitterService.ResponseConstants.USER_NAME, q.a(r115.getDisplay_name(), r115.getName())));
        r137.setLastItem(r136);
        r137.setAvatarUrl(r115.getAvatar_url());
        r137.setUserId(r115.getUser_id());
        r103.add(r137);
        goto L130
    L127:
        r136 = false;
        goto L128
    L129:
        tt5.a.h("FeedDataFilter", "unknown message type: " + r115.getType() + ", message id: " + r115.getMessageId() + ", read status: " + r115.getReadStatus());
        Intrinsics.checkNotNull(r115);
        UnknownBean r138 = new UnknownBean();
        r138.setMessageId(r115.getMessageId());
        r138.setReadStatus(r115.getReadStatus());
        r138.setAvatarUrl(r115.getAvatar_url());
        r138.setContent(r115.getContent());
        r138.setAtId(r115.getMentionId());
        r138.setCreateTime(r115.getCreateTime());
        r103.add(r138);
        goto L130
    L131:
        tt5.a.h("FeedDataFilter", "parse data cost: " + (System.currentTimeMillis() - r102) + " result size:" + r103.size() + " delete status:" + r111 + " finish status:" + r112);
        this.f549914b.postValue(new Triple(r210, r103, r211));
        return;
    L16:
        r105 = null;
        goto L17
    L143:
        return;
    }
}
