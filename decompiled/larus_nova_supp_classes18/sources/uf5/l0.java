package uf5;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.ObjMetaBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.ShareBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UnknownBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UserEntity;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 {
    public static volatile l0 d;
    public volatile String a;
    public MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> b;
    public com.bytedance.ee.bear.middleground.feed.export.bean.k c;

    public static l0 b() {
        if (d != null) goto L15;
        monitor-enter(l0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new l0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l0.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public l0() {
        this.a = "";
        this.b = new MutableLiveData();
    }

    public final MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> a(String r2, int r3, final Long r4) {
        if (TextUtils.isEmpty(this.a) == true) goto L7;
        if (r2 == null) goto L9;
        if (r2.equals(this.a) == false) goto L7;
    L9:
        return this.b;
    L7:
        this.b = new MutableLiveData();
        final OfflineDoc r0 = new OfflineDoc();
        r0.setObj_token(r2);
        r0.setToken(r2);
        r0.setType(r3);
        r0.setFrom_source("docs_feed");
        this.a = r0.getObj_token();
        Flowable.just(r0).filter(new s(this, r0)).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).flatMap(new c0(this, r0, r4)).filter(new d0()).flatMap(new e0(this, r0)).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).flatMap(new f0(this, r0, r4)).subscribe(new g0(), new h0(this, r0), new i0());
        goto L9
    }

    public final MessageResultBean c(p r18, String r19, int r20, boolean r21, Long r22) throws JSONException {
        if (DocFeed$Value$DataSource.NETWORK.equals(r18.a) == false) goto L5;
        MessageResultBean r0 = (MessageResultBean) JSON.parseObject(r18.b, MessageResultBean.class);
    L6:
        MessageResultBean r8 = r0;
        int r1 = n0.a;
        mwc.c r2 = null;
        if (r8 == null) goto L9;
        MessageResultBean.Data r3 = r8.getData();
    L10:
        if (r3 == null) goto L12;
        List<MessageBean> r4 = r3.getMessage();
    L14:
        if (com.larksuite.framework.utils.q.a(r4) == true) goto L117;
        if (r3 == null) goto L19;
        MessageResultBean.Data.Entities r5 = r3.getEntities();
        if (r5 == null) goto L19;
        Map<String, UserEntity> r6 = r5.getUsers();
    L20:
        if (r3 == null) goto L24;
        MessageResultBean.Data.Entities r7 = r3.getEntities();
        if (r7 == null) goto L24;
        Map<String, ObjMetaBean> r9 = r7.getObjMeta();
    L25:
        if (r6 != null) goto L28;
        if (r9 == null) goto L117;
    L28:
        List<MessageBean> r10 = r3.getMessage();
        if (r10 == null) goto L117;
        Iterator<MessageBean> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L117;
        MessageBean r12 = r11.next();
        String r13 = r12.getContent();
        if (TextUtils.isEmpty(r13) == true) goto L32;
        Matcher r14 = PatternProtector.compile("<at(\n|.)*?>(\n|.)*?</at>").matcher(r13);
        StringBuffer r15 = new StringBuffer();
        String r16 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, r2, r2, 6)).a();
    L38:
        if (r14.find() == false) goto L107;
        Intrinsics.checkNotNull(r13);
        String r17 = r13.substring(r14.start(), r14.end());
        bo4.a r23 = db5.d.e(r17, 0, r17.length());     // Catch: Exception -> L42
    L45:
        if (r23 != null) goto L47;
    L49:
        boolean r110 = false;
    L50:
        if (r110 == false) goto L82;
        if (r6 != null) goto L53;
    L55:
        boolean r111 = false;
    L56:
        if (r111 == false) goto L82;
        UserEntity r24 = r6.get(r23.e);
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), r16) == false) goto L71;
        if (r24 == null) goto L61;
        HashMap<String, String> r112 = r24.getI18nName();
    L62:
        String r113 = ou5.c.a(r112);
        if (TextUtils.isEmpty(r113) == true) goto L65;
        r23.g = "@".concat(r113);
    L77:
        if (r24 == null) goto L79;
        HashMap<String, String> r25 = r24.getI18nName();
    L80:
        r23.l = r25;
        StringBuilder r26 = new StringBuilder(r17);
        db5.f.c(r26, r23);
        r17 = r26.toString();
    L81:
        mwc.c r114 = null;
        String r27 = r17;
    L106:
        r14.appendReplacement(r15, r27);
        r2 = r114;
        goto L38
    L79:
        r25 = null;
        goto L80
    L65:
        if (r24 == null) goto L67;
        String r115 = r24.getCnName();
    L69:
        if (TextUtils.isEmpty(r115) == true) goto L77;
        StringBuilder r116 = new StringBuilder("@");
        Intrinsics.checkNotNull(r24);
        r116.append(r24.getCnName());
        r23.g = r116.toString();
        goto L77
    L67:
        r115 = null;
        goto L69
    L61:
        r112 = null;
        goto L62
    L71:
        if (r24 == null) goto L73;
        String r117 = r24.getEnName();
    L75:
        if (TextUtils.isEmpty(r117) == true) goto L77;
        StringBuilder r118 = new StringBuilder("@");
        Intrinsics.checkNotNull(r24);
        r118.append(r24.getEnName());
        r23.g = r118.toString();
        goto L77
    L73:
        r117 = null;
        goto L75
    L53:
        if (r6.containsKey(r23.e) != true) goto L55;
        r111 = true;
    L82:
        if (r23 == null) goto L84;
        Integer r119 = Integer.valueOf(r23.c);
    L85:
        if (r119 == null) goto L81;
        int r120 = r23.c;
        if (AtUtils.c().contains(r120 + "") == false) goto L81;
        if (r9 != null) goto L90;
    L92:
        boolean r121 = false;
    L93:
        if (r121 == false) goto L81;
        ObjMetaBean r122 = r9.get(r23.e);
        if (r122 == null) goto L81;
        String r123 = r122.getTitle();
        if (r123 != null) goto L99;
    L102:
        boolean r124 = true;
    L103:
        if (r124 == false) goto L81;
        r114 = null;
        r23.g = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(eu5.b.a, r122.getDocType());
        StringBuilder r28 = new StringBuilder(r17);
        db5.f.c(r28, r23);
        r27 = r28.toString();
        goto L106
    L99:
        if (r123.length() == 0) goto L102;
        r124 = false;
        goto L103
    L90:
        if (r9.containsKey(r23.e) != true) goto L92;
        r121 = true;
        goto L93
    L84:
        r119 = null;
        goto L85
    L47:
        if (r23.c != 0) goto L49;
        r110 = true;
    L42:
        e = move-exception;
        tt5.a.e("MessageDataUtilsKt", "parse at error", e, false);
        r23 = null;
        goto L45
    L107:
        mwc.c r125 = r2;
        r14.appendTail(r15);
        r12.setContent(r15.toString());
        if (ou5.a.e() == true) goto L110;
    L116:
        r2 = r125;
        goto L32
    L110:
        if (r12.getDisplay_name() != null) goto L116;
        if (r6 == null) goto L116;
        UserEntity r29 = r6.get(r12.getUser_id());
        if (r29 == null) goto L116;
        DisplayName r30 = new DisplayName();
        r30.setI18n_value(r29.getI18nName());
        r12.setDisplay_name(r30);
    L24:
        r9 = null;
    L19:
        r6 = null;
    L117:
        d(r18.a, r8, r19, r20, r21, r22);
        return r8;
    L12:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = m0.c(r18.b);
        goto L6
    }

    public final void d(String r20, MessageResultBean r21, String r22, int r23, boolean r24, Long r25) {
        tt5.a.h("FeedMessageManager", "parseData()... source = " + r20 + ", token = " + du5.b.g(r22) + ", currentToken = " + du5.b.g(this.a) + ", typeValue = " + r23 + ", feedPanel = " + r24);
        if (r21.getData().getMessage() != null) goto L5;
        tt5.a.k("FeedMessageManager", "message is empty");
        r21.getData().setMessage(Collections.emptyList());
    L5:
        m0.d("feed manager parse data", r21, new int[2]);
        AccountService.Account r4 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).U5();
        if (r22.equals(this.a) == false) goto L141;
        if (r24 == true) goto L9;
        return;
    L9:
        if (r21.getData().getDataType() != 1) goto L143;
        m0.a(r21, r4.uid, new o());
        Application r5 = eu5.b.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r21, WikiFolderPushPlugin.DATA);
        long r7 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        List<MessageBean> r0 = r21.getData().getMessage();
        if (r0 != null) goto L13;
        r0 = new ArrayList();
    L13:
        List<MessageBean> r10 = r0;
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        if (r25 == null) goto L16;
        Long r1 = Long.valueOf(r25.longValue() / ((long) CCMLynxCardView.ViewType.BANNER));
    L17:
        Long r6 = r1;
        Iterator r8 = r10.iterator();
        int r2 = 0;
    L19:
        if (r8.hasNext() == false) goto L131;
        Object r14 = r8.next();
        int r16 = r2 + 1;
        if (r2 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        MessageBean r15 = (MessageBean) r14;
        Iterator r26 = r8;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("base.message_center.suite") == false) goto L30;
        if (r6 == null) goto L30;
        if (r15.getCreateTime() <= r6.longValue()) goto L30;
        r6 = r6;
    L130:
        r8 = r26;
        r2 = r16;
        r12 = r12;
        r6 = r6;
    L30:
        if (Intrinsics.areEqual(r15.getType(), MessageBean.MESSAGE_DOC_COMMENT) == false) goto L115;
        r11.add(Integer.valueOf(r15.getDelete()));
        r12.add(Integer.valueOf(r15.getFinish()));
        if (r15.getDelete() != 1) goto L34;
    L98:
        r6 = r6;
        r12 = r12;
        Intrinsics.checkNotNull(r15);
        if (r2 != CollectionsKt.getLastIndex(r10)) goto L101;
        boolean r13 = true;
    L102:
        DeleteBean r3 = new DeleteBean();
        r3.setMessageId(r15.getMessageId());
        r3.setCreateTime(r15.getCreateTime());
        r3.setReadStatus(r15.getReadStatus());
        if (r15.isHasCommentPermission() == true) goto L106;
        Pair r17 = TuplesKt.to(3, xo5.a.c(r5, 2131888986, "username", q.a(r15.getDisplay_name(), r15.getName())));
    L108:
        Pair r18 = r17;
    L110:
        int r19 = ((Number) r18.component1()).intValue();
        String r27 = (String) r18.component2();
        r3.setType(r19);
        r3.setTitleStr(r27);
        r3.setLastItem(r13);
        r3.setUserId(r15.getUser_id());
        r3.setAvatarUrl(r15.getAvatar_url());
        r3.setCommentId(r15.getComment_id());
        r3.setReplyId(r15.getReply_id());
        if (r15.getIs_whole() != 1) goto L113;
        boolean r28 = true;
    L114:
        r3.setWhole(r28);
        r9.add(r3);
        goto L130
    L113:
        r28 = false;
        goto L114
    L106:
        if (r15.getDelete() != 1) goto L109;
        r17 = TuplesKt.to(1, xo5.a.c(r5, 2131887211, "user_name", q.a(r15.getDisplay_name(), r15.getName())));
        goto L108
    L109:
        r18 = TuplesKt.to(2, r5.getString(2131887855));
        goto L110
    L101:
        r13 = false;
        goto L102
    L34:
        if (r15.isHasCommentPermission() == false) goto L98;
        Intrinsics.checkNotNull(r15);
        if (r2 != CollectionsKt.getLastIndex(r10)) goto L39;
        boolean r29 = true;
    L40:
        FeedCommentDetailBean r30 = new FeedCommentDetailBean();
        r30.setMessageId(r15.getMessageId());
        r30.setReadStatus(r15.getReadStatus());
        r30.setCreateTime(r15.getCreateTime());
        String r110 = q.a(r15.getDisplay_name(), r15.getName());
        int r31 = JSONObjectProtectorUtils.getInt(new JSONObject(r15.getCommentExtra()), "visibility");     // Catch: Exception -> L43
    L46:
        if (r15.getFinish() != 1) goto L52;
        if (r15.getIs_whole() != 1) goto L50;
        Pair r32 = TuplesKt.to(0, xo5.a.c(r5, 2131887132, "user_name", r110));
    L89:
        int r33 = ((Number) r32.component1()).intValue();
        String r34 = (String) r32.component2();
        r30.setType(r33);
        String r35 = "";
        if (TextUtils.isEmpty("") == true) goto L93;
        r34 = "";
    L93:
        r30.setTitleStr(r34);
        r30.setLastItem(r29);
        r30.setComment_id(r15.getComment_id());
        r30.setIs_whole(r15.getIs_whole());
        r30.setReply_id(r15.getReply_id());
        r30.setUser_id(r15.getUser_id());
        r30.setAvatar_url(r15.getAvatar_url());
        r30.setName(r110);
        r30.setQuote(r15.getQuote());
        r30.setCreate_timestamp(r15.getCreate_timestamp());
        r30.setUpdate_timestamp(r15.getUpdate_timestamp());
        if (TextUtils.isEmpty("") == false) goto L96;
        r35 = r15.getContent();
    L96:
        r30.setContent(r35);
        r30.setTranslate_content(r15.getTranslate_content());
        r30.setTranslate_status(r15.getTranslate_status());
        r30.setExtra(r15.getExtra());
        r30.setCommentType(r15.getCommentType());
        r9.add(r30);
        goto L130
    L50:
        r32 = TuplesKt.to(0, xo5.a.c(r5, 2131887214, "user_name", r110));
        goto L89
    L52:
        if (r15.getIs_whole() != 1) goto L61;
        if (r31 != 1) goto L56;
    L58:
        int r111 = 2131889229;
    L59:
        r32 = TuplesKt.to(0, xo5.a.c(r5, r111, "user_name", r110));
        goto L89
    L56:
        if (r31 == 2) goto L58;
        r111 = 2131887131;
        goto L59
    L61:
        if (r15.getReplyIndex() > 0) goto L70;
        if (r31 != 1) goto L65;
    L67:
        int r36 = 2131889229;
    L68:
        r32 = TuplesKt.to(0, xo5.a.c(r5, r36, "user_name", r110));
        goto L89
    L65:
        if (r31 == 2) goto L67;
        r36 = 2131887210;
        goto L68
    L70:
        if (r15.getCommentMention() != 1) goto L80;
        if (r31 != 1) goto L74;
    L76:
        int r37 = 2131889231;
    L77:
        r32 = TuplesKt.to(0, xo5.a.c(r5, r37, "user_name", r110));
        goto L89
    L74:
        if (r31 == 2) goto L76;
        r37 = 2131887851;
        goto L77
    L80:
        if (r15.getReplyIndex() > 0) goto L82;
        r32 = TuplesKt.to(0, xo5.a.c(r5, 2131887210, "user_name", r110));
        goto L89
    L82:
        if (r31 != 1) goto L84;
    L86:
        int r112 = 2131889231;
    L87:
        r32 = TuplesKt.to(0, xo5.a.c(r5, r112, "user_name", r110));
        goto L89
    L84:
        if (r31 == 2) goto L86;
        r112 = 2131887213;
    L43:
        e = move-exception;
        tt5.a.d("FeedDataFilter", "getVisibility " + e.getMessage());
        r31 = 0;
        goto L46
    L39:
        r29 = false;
        goto L40
    L115:
        r6 = r6;
        r12 = r12;
        if (Intrinsics.areEqual(r15.getType(), MessageBean.MESSAGE_DOC_MENTION) == false) goto L123;
        Intrinsics.checkNotNull(r15);
        if (r2 != CollectionsKt.getLastIndex(r10)) goto L120;
        boolean r38 = true;
    L121:
        AtBean r113 = new AtBean();
        r113.setMessageId(r15.getMessageId());
        r113.setCreateTime(r15.getCreateTime());
        r113.setReadStatus(r15.getReadStatus());
        r113.setContent(xo5.a.c(r5, 2131887212, "user_name", q.a(r15.getDisplay_name(), r15.getName())));
        r113.setLastItem(r38);
        r113.setAtId(r15.getMentionId());
        r113.setAvatarUrl(r15.getAvatar_url());
        r113.setUserId(r15.getUser_id());
        r9.add(r113);
        goto L130
    L120:
        r38 = false;
        goto L121
    L123:
        if (Intrinsics.areEqual(r15.getType(), MessageBean.MESSAGE_DOC_SHARE) == false) goto L129;
        Intrinsics.checkNotNull(r15);
        if (r2 != CollectionsKt.getLastIndex(r10)) goto L127;
        boolean r39 = true;
    L128:
        ShareBean r40 = new ShareBean();
        r40.setMessageId(r15.getMessageId());
        r40.setCreateTime(r15.getCreateTime());
        r40.setReadStatus(r15.getReadStatus());
        r40.setContent(xo5.a.c(r5, 2131889480, "user_name", q.a(r15.getDisplay_name(), r15.getName())));
        r40.setLastItem(r39);
        r40.setAvatarUrl(r15.getAvatar_url());
        r40.setUserId(r15.getUser_id());
        r9.add(r40);
        goto L130
    L127:
        r39 = false;
        goto L128
    L129:
        tt5.a.h("FeedDataFilter", "unknown message type: " + r15.getType() + ", message id: " + r15.getMessageId() + ", read status: " + r15.getReadStatus());
        Intrinsics.checkNotNull(r15);
        UnknownBean r41 = new UnknownBean();
        r41.setMessageId(r15.getMessageId());
        r41.setReadStatus(r15.getReadStatus());
        r41.setAvatarUrl(r15.getAvatar_url());
        r41.setContent(r15.getContent());
        r41.setAtId(r15.getMentionId());
        r41.setCreateTime(r15.getCreateTime());
        r9.add(r41);
        goto L130
    L131:
        tt5.a.h("FeedDataFilter", "parse data cost: " + (System.currentTimeMillis() - r7) + " result size:" + r9.size() + " delete status:" + r11 + " finish status:" + r12);
        this.b.postValue(new Triple(r20, r9, r21));
        return;
    L16:
        r1 = null;
        goto L17
    L143:
        return;
    }
}
