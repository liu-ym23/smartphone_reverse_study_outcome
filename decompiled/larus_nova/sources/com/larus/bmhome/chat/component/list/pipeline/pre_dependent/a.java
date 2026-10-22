package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f301200a;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.pipeline.pre_dependent.a$a, reason: collision with other inner class name */
    public static final class C4048a {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    static {
    }

    public a(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f301200a = r100;
    }

    public final Message c(List<? extends xc8.b> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L38;
        Object r102 = r101.next();
        xc8.b r103 = (xc8.b) r102;
        Message r104 = r103.getMessage();
        boolean r105 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r104) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r104) == true) goto L11;
    L30:
        boolean r106 = false;
    L31:
        if (r106 == true) goto L33;
    L35:
        r105 = false;
    L36:
        if (r105 == false) goto L4;
    L39:
        xc8.b r107 = (xc8.b) r102;
        if (r107 != null) goto L42;
        return null;
    L42:
        return r107.getMessage();
    L33:
        if (b0.f(r103.getMessage()) == true) goto L35;
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r104) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r104) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r104) == true) goto L18;
    L20:
        MessageStatus r108 = r104.getMessageStatus();
        if (r108 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        if (r109 == false) goto L28;
    L29:
        r106 = true;
        goto L31
    L28:
        if (b0.f(r104) == false) goto L30;
    L23:
        if (r108.isVisible() != true) goto L25;
        r109 = true;
        goto L26
    L18:
        if (r104.getRegenVisible() == true) goto L20;
    L38:
        r102 = null;
        goto L39
    }

    @Override // td8.c
    public final boolean a(int r110, xc8.b r111, xc8.b r112, List<? extends xc8.b> r113) {
        Intrinsics.checkNotNullParameter(r112, "current");
        Intrinsics.checkNotNullParameter(r113, "input");
        if (com.larus.bmhome.utils.i.f(this.f301200a.g()) == false) goto L5;
        boolean r114 = z2.f365865a.getEduIntentionCameraConfig().b();
    L7:
        if (r114 == true) goto L11;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of not hit the ab test");
        return false;
    L11:
        if ((this.f301200a.l() instanceof z) == false) goto L15;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of collect page no suggest");
        return false;
    L15:
        if ((this.f301200a.l() instanceof com.larus.bmhome.social.userchat.model.b) == false) goto L18;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of collect page no suggest");
        return false;
    L18:
        Message r115 = c(r113);
        if (r115 != null) goto L22;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of latestVisibleMessage is null");
        return false;
    L22:
        FLogger r116 = FLogger.f375446a;
        r116.i("Pipeline_List_EduContinueShot", "latestVisibleMessage is >>> messageId is " + r115.getMessageId() + ", localId is " + r115.getLocalMessageId() + ", contentType is " + r115.getContentType());
        if (r115.getMessageStatusLocal() == 21) goto L25;
    L126:
        r116.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of default");
        return false;
    L25:
        if (r115.getContentType() == 2) goto L126;
        if (com.larus.bmhome.chat.bean.d.z0(r115) == false) goto L31;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r115).isNoDisappear() == false) goto L31;
    L34:
        r116.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of latestVisibleMessage is no disappear");
        return false;
    L31:
        if (com.larus.bmhome.chat.bean.d.b0(r115) == false) goto L37;
        if (com.larus.bmhome.chat.bean.d.R0(r115) == true) goto L34;
    L37:
        if (com.larus.bmhome.chat.bean.d.k0(r115) == false) goto L56;
        z2 r100 = z2.f365865a;
        if (r100.getSubConversationNewShowSuggest() == true) goto L56;
        wc9.e r101 = this.f301200a.g();
        if (r101 == null) goto L48;
        Integer r102 = r101.f559219v;
        if (r102 == null) goto L48;
        if (r102.intValue() != 3) goto L48;
        boolean r103 = true;
    L49:
        if (r103 == false) goto L56;
        if (r100.getSubConversationNewOnboardingStyle() == false) goto L56;
        if (com.larus.bmhome.chat.bean.d.x(r115).getSkillCardCnt() > 0) goto L56;
        r116.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of new conversation onboarding");
        return false;
    L48:
        r103 = false;
    L56:
        String r104 = null;
        if (com.larus.bmhome.chat.bean.d.z0(r115) == true) goto L130;
        wc9.e r105 = this.f301200a.g();
        if (r105 == null) goto L61;
        String r106 = r105.B;
    L63:
        if (o0.d(r106) == false) goto L130;
        wc9.e r107 = this.f301200a.g();
        if (r107 == null) goto L67;
        String r108 = r107.B;
    L69:
        if (Intrinsics.areEqual(r108, r115.getSectionId()) == true) goto L130;
        r116.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of clear context");
        return false;
    L67:
        r108 = null;
        goto L69
    L61:
        r106 = null;
    L130:
        Map<String, String> r117 = r115.getExt();     // Catch: Exception -> L123
        if (r117 == null) goto L75;
        String r118 = r117.get("intention");     // Catch: Exception -> L123
    L77:
        if (Intrinsics.areEqual(r118, "intention_edu") == false) goto L125;
        Map<String, String> r119 = r115.getExt();     // Catch: Exception -> L123
        if (r119 == null) goto L81;
        String r120 = r119.get("sub_message_ext");     // Catch: Exception -> L123
    L82:
        zd9.h r109 = zd9.h.f571481a;     // Catch: Exception -> L123
        if (r120 != null) goto L85;
    L88:
        boolean r121 = true;
    L89:
        if (r121 == false) goto L128;
    L100:
        Object r122 = null;
    L101:
        Map r123 = (Map) r122;     // Catch: Exception -> L123
        if (r123 != null) goto L104;
        r123 = MapsKt.emptyMap();     // Catch: Exception -> L123
    L104:
        Map r124 = MapsKt.toMutableMap(r123);     // Catch: Exception -> L123
        int r125 = p0.f375454a;     // Catch: Exception -> L123
        JSONObject r126 = p0.b(p0.b((String) r124.get("Copilot:hippo:hippo_ext")).optString("data"));     // Catch: Exception -> L123
        if (r126.optInt("picture_source") == 0) goto L125;
        Map<String, String> r127 = r115.getExt();     // Catch: Exception -> L123
        if (r127 == null) goto L110;
        r104 = r127.get("need_auth_identity");     // Catch: Exception -> L123
    L110:
        if (Intrinsics.areEqual(r104, "1") == false) goto L113;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of plugin auth");     // Catch: Exception -> L123
        return false;
    L113:
        FLogger r128 = FLogger.f375446a;     // Catch: Exception -> L123
        StringBuilder r129 = new StringBuilder("isMultiQuestion: ");     // Catch: Exception -> L123
        if (r126.optInt(EventConstant.Key.DETECTION_TYPE) != 2) goto L116;
        boolean r130 = true;
    L117:
        r129.append(r130);     // Catch: Exception -> L123
        r129.append(", isReceived: ");     // Catch: Exception -> L123
        n0.f303117a.getClass();     // Catch: Exception -> L123
        r129.append(n0.d(r115));     // Catch: Exception -> L123
        r128.e("Pipeline_List_EduContinueShot", r129.toString());     // Catch: Exception -> L123
        if (r126.optInt(EventConstant.Key.DETECTION_TYPE) == 2) goto L120;
        r128.i("Pipeline_List_EduContinueShot", "Add one more shot card, it is not multi questions");     // Catch: Exception -> L123
        return true;
    L120:
        return n0.d(r115);
    L116:
        r130 = false;
        goto L117
    L128:
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L93
        r109.getClass();     // Catch: Throwable -> L93
        r122 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r120, new b().getType()));     // Catch: Throwable -> L93
    L95:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r122);     // Catch: Exception -> L123
        if (r132 == null) goto L99;
        c0 r133 = c0.f348199b;     // Catch: Exception -> L123
        StringBuilder r134 = new StringBuilder("fromJson failed, stack: ");     // Catch: Exception -> L123
        Intrinsics.checkNotNullParameter(r132, "<this>");     // Catch: Exception -> L123
        r134.append(ExceptionsKt.stackTraceToString(r132));     // Catch: Exception -> L123
        r133.e("GsonHolder", r134.toString());     // Catch: Exception -> L123
    L99:
        if (Result.m9455isFailureimpl(r122) == false) goto L101;
    L93:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Exception -> L123
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L123
        goto L95
    L85:
        if (StringsKt.isBlank(r120) == true) goto L88;
        r121 = false;
        goto L89
    L81:
        r120 = null;
    L125:
        return false;
    L75:
        r118 = null;
    L123:
        e = move-exception;
        FLogger.f375446a.e("Pipeline_List_EduContinueShot", "error when parse json", e);
        goto L125
    L5:
        r114 = z2.f365865a.getEduIntentionCameraConfig().d();
        goto L7
    }

    @Override // td8.c
    public final List<xc8.b> b(int r510, xc8.b r511, xc8.b r512, List<xc8.b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        FLogger r100 = FLogger.f375446a;
        r100.i("Pipeline_List_EduContinueShot", "start suggest task, current input size is " + r513.size());
        Message r101 = c(r513);
        if (r101 == null) goto L59;
        this.f301200a.g();
        int r102 = wf9.b.f559489a;
        Intrinsics.checkNotNullParameter(r101, "message");
        com.larus.bmhome.chat.list.cell.edu_continue_shot.e r103 = null;
        if (com.larus.im.bean.message.a.w0(r101) == false) goto L7;
        r100.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of isStreaming");
    L55:
        int r104 = 0;
    L57:
        if (r103 == null) goto L59;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "suggest added");
        ListProtector.add(r513, r104, r103);
        goto L59
    L7:
        Map<String, String> r105 = r101.getExt();
        if (r105 == null) goto L10;
        String r106 = r105.get("intention");
    L12:
        if (Intrinsics.areEqual(r106, "intention_edu") == true) goto L14;
        r100.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of not edu intention message");
        goto L55
    L14:
        Map<String, String> r107 = r101.getExt();
        if (r107 == null) goto L22;
        String r108 = r107.get("edu_params");
        if (r108 == null) goto L22;
        Boolean r109 = Boolean.valueOf(new JSONObject(r108).optBoolean("edu_continue_shot", false));     // Catch: JSONException -> L20
    L24:
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == true) goto L26;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of edu continue shot not required");
        goto L55
    L26:
        Map<String, String> r110 = r101.getExt();
        if (r110 == null) goto L29;
        String r111 = r110.get("sub_message_ext");
    L30:
        zd9.h r112 = zd9.h.f571481a;
        if (r111 != null) goto L33;
    L36:
        boolean r113 = true;
    L37:
        if (r113 == false) goto L63;
    L48:
        Object r114 = null;
    L49:
        Map r115 = (Map) r114;
        if (r115 != null) goto L52;
        r115 = MapsKt.emptyMap();
    L52:
        Map r116 = MapsKt.toMutableMap(r115);
        int r117 = p0.f375454a;
        if (p0.b(p0.b((String) r116.get("Copilot:hippo:hippo_ext")).optString("data")).optInt("picture_source") != 0) goto L56;
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of picture_source is 0");
        goto L55
    L56:
        r104 = 0;
        r103 = new com.larus.bmhome.chat.list.cell.edu_continue_shot.e(b0.j(Message.copy$default(r101, null, null, null, 0, 21, MessageStatus.MessageStatus_AVAILABLE, 800, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, "edu_continue_shot", null, 0, null, null, null, 2147483535, 31, null), 10));
        goto L57
    L63:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L41
        r112.getClass();     // Catch: Throwable -> L41
        r114 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r111, new com.larus.bmhome.chat.component.list.pipeline.pre_dependent.b().getType()));     // Catch: Throwable -> L41
    L43:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r114);
        if (r119 == null) goto L47;
        c0 r120 = c0.f348199b;
        StringBuilder r121 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r119, "<this>");
        r121.append(ExceptionsKt.stackTraceToString(r119));
        r120.e("GsonHolder", r121.toString());
    L47:
        if (Result.m9455isFailureimpl(r114) == false) goto L49;
    L41:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L33:
        if (StringsKt.isBlank(r111) == true) goto L36;
        r113 = false;
        goto L37
    L29:
        r111 = null;
    L20:
        e = move-exception;
        FLogger.f375446a.e("Pipeline_List_EduContinueShot", "edu continue shot message no show because of invalid edu params", e);
    L22:
        r109 = null;
        goto L24
    L10:
        r106 = null;
    L59:
        FLogger.f375446a.i("Pipeline_List_EduContinueShot", "end suggest task, current input size is " + r513.size());
        return r513;
    }
}
