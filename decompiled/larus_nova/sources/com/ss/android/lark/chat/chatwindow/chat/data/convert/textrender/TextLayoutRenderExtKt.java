package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import h7b.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import w4b.d0;

/* JADX INFO: loaded from: classes35.dex */
public final class TextLayoutRenderExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f412455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f412456b = null;

    static {
        f412455a = new f();
        f412456b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final boolean b(RichText r100, final n r110) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        Intrinsics.checkNotNullParameter(r110, "config");
        if (p.a() == false) goto L20;
        List<String> r101 = r100.getMarkdownIds();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L20;
        LarkContextExtend.a r103 = LarkContextExtend.f419979s;
        int r104 = ((Number) r103.b(new TextLayoutRenderExtKt$preloadMovableDocumentV2$maxWidth$1(r110))).intValue();
        if (r104 <= 0) goto L20;
        if (r104 == Integer.MAX_VALUE) goto L20;
        r110.a(r110.f412532f.b(com.ss.android.lark.coremd.base.parse.c.a(r103, TextLayoutRenderExtKt$preloadMovableDocumentV2$1.INSTANCE)));
        BuildersKt.launch$default(f412456b, null, null, new TextLayoutRenderExtKt$preloadMovableDocumentV2$2(r100, r110, null), 3, null);
        return true;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
    L20:
        return false;
    }

    public static final CharSequence a(z2b.b r100, RichText r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "richText");
        Intrinsics.checkNotNullParameter(r102, "config");
        return r100.a(new m(r101, r102));
    }

    public static final Layout f(z2b.b r100, RichText r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "richText");
        Intrinsics.checkNotNullParameter(r102, "config");
        return r100.b(new com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p(a(r100, r101, r102), r102));
    }

    public static final Layout c(z2b.b r110, f5b.b r111, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r112, Context r113) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "message");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "params");
        f412455a.getClass();
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "params");
        Message r100 = r111.getMessage();
        Message.Type r101 = r100.getType();
        Message.Type r102 = Message.Type.TEXT;
        if (r101 == r102) goto L8;
        if (r101 == Message.Type.POST) goto L8;
    L40:
        RichText r103 = null;
    L112:
        if (r103 != null) goto L115;
        return null;
    L115:
        return e(r110, r103, r112, r113);
    L8:
        if (r112.f412418k == false) goto L13;
        TranslateInfo r104 = r111.getTranslateInfo();
        if (r104 == null) goto L12;
        Content r105 = r104.getTranslateContent();
    L15:
        if ((r105 instanceof BaseTextContent) == false) goto L40;
        r103 = ((BaseTextContent) r105).getRichText();
        if ((r105 instanceof PostContent) == false) goto L20;
        PostContent r106 = (PostContent) r105;
    L21:
        if (r106 == null) goto L23;
        String r107 = r106.getTitle();
    L24:
        boolean r108 = true;
        if (r107 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        boolean r114 = !r109;
        if (r111.getMessage().getStreamStatus() != MessageStreamStatus.Transport) goto L34;
        boolean r115 = true;
    L36:
        if (i.l(r103) == false) goto L42;
        if (r114 == true) goto L42;
        if (r115 == true) goto L42;
        Log.e("TextLayoutRender", "rich-text is null , msg id is:" + r100.getId());
    L42:
        if (r112.f412406c == false) goto L44;
    L49:
        boolean r116 = true;
    L50:
        r112.f412406c = r116;
        r112.f412408d = r100.isFromMe();
        List<String> r117 = r100.getReadAtChatterIds();
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r112.f412402a = r117;
        List<String> r118 = r100.getAtBotIds();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r112.f412404b = r118;
        if (r100.getStatus() != Message.Status.DELETED) goto L53;
    L58:
        boolean r119 = true;
    L59:
        r112.f412410e = r119;
        r112.f412412f = r100.isSecret();
        d0 r120 = l.f484046a;
        if (r105 != null) goto L62;
    L65:
        boolean r121 = false;
    L66:
        r112.f412416i = r121;
        MessageEditInfo r122 = r100.getEditInfo();
        if (r122 != null) goto L69;
    L71:
        boolean r123 = false;
    L72:
        r112.f412425r = r123;
        r112.f412414g = r100.isFlag();
        if (r115 == false) goto L85;
        if (r103 == null) goto L76;
        ArrayList<String> r124 = r103.getMyAIRunningToolsIds();
    L77:
        if (r124 != null) goto L79;
    L82:
        boolean r125 = true;
    L83:
        if (r125 == false) goto L85;
        boolean r126 = true;
    L86:
        r112.f412430w = r126;
        r112.P = r115;
        if (r112.f412407c0 == false) goto L89;
    L97:
        boolean r127 = false;
    L98:
        if (r127 == true) goto L100;
    L110:
        r108 = false;
    L111:
        r112.f412403a0 = r108;
        goto L112
    L100:
        if (r100.isFromMe() == false) goto L110;
        if (r100.getDlpState() == MessageDLPState.BLOCK) goto L110;
        if (r100.isCleaned() == true) goto L110;
        if (r100.getType() != r102) goto L111;
        if (r100.isIncludeDocUrl() == false) goto L110;
    L89:
        if (r112.f412405b0 == true) goto L97;
        if (r112.f412409d0 == true) goto L97;
        if (r112.f412411e0 == true) goto L97;
        if (r112.f412413f0 == true) goto L97;
        r127 = true;
        goto L98
    L79:
        if (r124.isEmpty() == true) goto L82;
        r125 = false;
        goto L83
    L76:
        r124 = null;
    L85:
        r126 = false;
        goto L86
    L69:
        if (r122.isEdited() != true) goto L71;
        r123 = true;
        goto L72
    L62:
        if ((r105 instanceof PostContent) == false) goto L65;
        r121 = ((PostContent) r105).isGroupAnnouncement();
        goto L66
    L53:
        if (r100.isSecret() == true) goto L55;
    L57:
        r119 = false;
        goto L59
    L55:
        if (r100.isBurned() == false) goto L57;
    L44:
        if (r111.isPreMessage() == true) goto L49;
        if (r111.getMessage().isSecret() == true) goto L49;
        r116 = false;
        goto L50
    L34:
        r115 = false;
        goto L36
    L27:
        if (r107.length() == 0) goto L30;
        r109 = false;
        goto L31
    L23:
        r107 = null;
        goto L24
    L20:
        r106 = null;
        goto L21
    L12:
        r105 = null;
        goto L15
    L13:
        r105 = r111.getMessage().getContent();
        goto L15
    }

    public static final Layout d(z2b.b r100, y6b.a<?> r110, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r111, Context r112) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "params");
        f412455a.getClass();
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "params");
        if ((r110.b() instanceof BaseTextContentVO) == true) goto L6;
    L35:
        RichText r101 = null;
    L111:
        if (r101 != null) goto L114;
        return null;
    L114:
        return e(r100, r101, r111, r112);
    L6:
        if (r111.f412418k == false) goto L8;
        Object r102 = ((BaseTextContentVO) r110.b()).f411957g;
    L10:
        if ((r102 instanceof BaseTextContentVO) == false) goto L35;
        BaseTextContentVO r103 = (BaseTextContentVO) r102;
        r101 = r103.g();
        Intrinsics.checkNotNull(r101);
        T r104 = r103.f553338a;
        if ((r104 instanceof PostContent) == false) goto L15;
        PostContent r105 = (PostContent) r104;
    L16:
        if (r105 == null) goto L18;
        String r106 = r105.getTitle();
    L19:
        boolean r107 = true;
        if (r106 != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        boolean r109 = !r108;
        if (r110.L() != MessageStreamStatus.Transport) goto L29;
        boolean r113 = true;
    L31:
        if (i.l(r101) == false) goto L36;
        if (r109 == true) goto L36;
        if (r113 == true) goto L36;
        Log.e("TextLayoutRender", "Parsing Layout， richText is null, id:" + r110.getId());
    L36:
        List<String> r114 = ((BaseTextContentVO) r110.b()).f411879o;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r111.f412402a = r114;
        List<String> r115 = ((BaseTextContentVO) r110.b()).f411878n;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r111.f412404b = r115;
        if (r111.f412406c == false) goto L39;
    L44:
        boolean r116 = true;
    L45:
        r111.f412406c = r116;
        r111.f412408d = r110.h();
        if (r110.K() != Message.Status.DELETED) goto L48;
        boolean r117 = true;
    L49:
        r111.f412410e = r117;
        r111.f412412f = r110.U();
        d0 r118 = l.f484046a;
        if (r102 != null) goto L52;
    L55:
        boolean r119 = false;
    L56:
        r111.f412416i = r119;
        ValidateIMFileResult r120 = r110.N();
        if (r120 == null) goto L59;
        IMFileResult r121 = r120.getResultType();
    L60:
        MessagePermissionUtil.ReceiveAuthorizationState r122 = MessagePermissionUtil.h(r121);
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r111.B = r122;
        r111.C = r110.N();
        MessageEditInfo r123 = r110.u();
        if (r123 != null) goto L63;
    L65:
        boolean r124 = false;
    L66:
        r111.f412425r = r124;
        if ((r110 instanceof y6b.c) == false) goto L69;
        y6b.c r125 = (y6b.c) r110;
    L70:
        if (r125 == null) goto L72;
        boolean r126 = r125.V1;
    L73:
        r111.f412414g = r126;
        if (r113 == false) goto L84;
        ArrayList<String> r127 = r101.getMyAIRunningToolsIds();
        if (r127 != null) goto L78;
    L81:
        boolean r128 = true;
    L82:
        if (r128 == false) goto L84;
        boolean r129 = true;
    L85:
        r111.f412430w = r129;
        if (r111.f412407c0 == false) goto L88;
    L96:
        boolean r130 = false;
    L97:
        if (r130 == true) goto L99;
    L109:
        r107 = false;
    L110:
        r111.f412403a0 = r107;
        goto L111
    L99:
        if (r110.h() == false) goto L109;
        if (r110.t() == MessageDLPState.BLOCK) goto L109;
        if (r110.O() == true) goto L109;
        if (r110.getType() != Message.Type.TEXT) goto L110;
        if (r110.e() == false) goto L109;
    L88:
        if (r111.f412405b0 == true) goto L96;
        if (r111.f412409d0 == true) goto L96;
        if (r111.f412411e0 == true) goto L96;
        if (r111.f412413f0 == true) goto L96;
        r130 = true;
        goto L97
    L78:
        if (r127.isEmpty() == true) goto L81;
        r128 = false;
    L84:
        r129 = false;
        goto L85
    L72:
        r126 = false;
        goto L73
    L69:
        r125 = null;
        goto L70
    L63:
        if (r123.isEdited() != true) goto L65;
        r124 = true;
        goto L66
    L59:
        r121 = null;
        goto L60
    L52:
        if ((r102 instanceof PostContentVO) == false) goto L55;
        r119 = ((PostContentVO) r102).i();
        goto L56
    L48:
        r117 = false;
        goto L49
    L39:
        if (r110.isPreMessage() == true) goto L44;
        if (r110.U() == true) goto L44;
        r116 = false;
        goto L45
    L29:
        r113 = false;
        goto L31
    L22:
        if (r106.length() == 0) goto L25;
        r108 = false;
        goto L26
    L18:
        r106 = null;
        goto L19
    L15:
        r105 = null;
        goto L16
    L8:
        r102 = (com.ss.android.lark.chat.base.view.vo.message.f) r110.b();
        goto L10
    }

    public static final Layout e(z2b.b r100, RichText r101, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "richText");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextLayoutRender.d r104 = new TextLayoutRender.d(r103, r101);
        Intrinsics.checkNotNullParameter(r102, "params");
        r104.f412452c = r102;
        CharSequence r105 = r100.a(new TextLayoutRender.e(r104));
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "data");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextLayoutRender.f r106 = new TextLayoutRender.f(r103, r105);
        Intrinsics.checkNotNullParameter(r102, "params");
        r106.f412452c = r102;
        return r100.b(new TextLayoutRender.g(r106));
    }
}
