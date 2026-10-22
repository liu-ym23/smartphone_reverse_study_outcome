package com.larus.office.plugins.preview;

import android.content.Context;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.google.gson.Gson;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.nova.R;
import com.larus.office.plugins.input.cache.OfficeConversationCachePromotionTracker;
import com.larus.office.plugins.input.cache.OfficeDocumentConversationCache;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeDrivePreviewChatSessionAbility implements com.bytedance.ee.bear.browser.plugin.i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f363146g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f363147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f363148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f363149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f363150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f363151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f363152f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f363153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.im.service.d0<wc9.e> f363154b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f363153a, r101.f363153a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363154b, r101.f363154b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f363153a.hashCode() * 31) + this.f363154b.hashCode();
        }

        public final String toString() {
            return "ActiveConversationPromotionListenerRegistration(localConversationId=" + this.f363153a + ", listener=" + this.f363154b + ')';
        }

        public a(String r100, k r101) {
            Intrinsics.checkNotNullParameter(r100, "localConversationId");
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f363153a = r100;
            this.f363154b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final String c() {
        l r100 = this.f363151e;
        if (r100 == null) goto L6;
        String r101 = r100.f363213c;
        if (r101 == null) goto L6;
        return r101;
    L6:
        com.larus.bmhome.chat.api.e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        if (r102 == null) goto L16;
        LaunchInfo r103 = r102.f297186a;
        if (r103 == null) goto L16;
        String r104 = r103.W();
        if (r104 == null) goto L16;
        if ((!StringsKt.isBlank(r104)) == false) goto L16;
        return r104;
    L16:
        return null;
    }

    public final String g() {
        m r100 = this.f363150d;
        if (r100 == null) goto L10;
        String r101 = r100.f363217a;
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        return null;
    L9:
        return r101;
    L10:
        return null;
    }

    public final void k() {
        a r100 = this.f363152f;
        if (r100 == null) goto L5;
        com.larus.im.d.c().unRegisterConversationChangeListener(r100.f363153a, r100.f363154b);
    L5:
        this.f363152f = null;
    }

    public final Object h(Continuation<? super String> r100) {
        if ((r100 instanceof OfficeDrivePreviewChatSessionAbility$resolveMainBotId$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$resolveMainBotId$1 r101 = (OfficeDrivePreviewChatSessionAbility$resolveMainBotId$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L23:
        List r106 = (List) r103;
        if (r106 == null) goto L33;
        String r107 = (String) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L33;
        if ((!StringsKt.isBlank(r107)) == true) goto L31;
        r107 = null;
    L31:
        if (r107 == null) goto L33;
    L42:
        return r107;
    L33:
        com.larus.bmhome.chat.api.e0 r108 = AuthModelDelegate.f297134b.e().getValue();
        if (r108 == null) goto L43;
        LaunchInfo r109 = r108.f297186a;
        if (r109 == null) goto L44;
        r107 = r109.W();
        if (r107 != null) goto L40;
        return null;
    L40:
        if ((!StringsKt.isBlank(r107)) == true) goto L42;
        return null;
    L44:
        return null;
    L43:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AuthModelDelegate r110 = AuthModelDelegate.f297134b;
        wc9.e r111 = r110.y().getValue();
        if (r111 != null) goto L17;
        r111 = r110.u().getValue();
    L17:
        if (r111 == null) goto L33;
        String r112 = r111.f559198a;
        if (r112 == null) goto L33;
        r101.label = 1;
        r103 = ic8.n.b(r112, r101);
        if (r103 != r104) goto L23;
        return r104;
    L7:
        r101 = new OfficeDrivePreviewChatSessionAbility$resolveMainBotId$1(this, r100);
        goto L8
    }

    public final Integer j(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r100.hashCode());
    L7:
        r101 = false;
        goto L8
    }

    public final void l(m r100) {
        m r101 = this.f363150d;
        if (r101 == null) goto L5;
        String r102 = r101.f363217a;
    L7:
        if (Intrinsics.areEqual(r102, r100.f363217a) == true) goto L9;
        k();
        this.f363151e = null;
    L9:
        this.f363150d = r100;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[updateCurrentFile] hasFile=true, tokenHash=" + j(r100.f363217a));
        return;
    L5:
        r102 = null;
        goto L7
    }

    public OfficeDrivePreviewChatSessionAbility(String r100, String r101) {
        this.f363147a = r100;
        this.f363148b = r101;
        new Gson();
        this.f363149c = kotlinx.coroutines.sync.b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility] */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v10, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final Object b(Context r110, Continuation<? super l> r111) {
        if ((r111 instanceof OfficeDrivePreviewChatSessionAbility$ensureConversation$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$ensureConversation$1 r100 = (OfficeDrivePreviewChatSessionAbility$ensureConversation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L26;
        if (r103 == 1) goto L25;
        if (r103 == 2) goto L22;
        if (r103 == 3) goto L21;
        if (r103 != 4) goto L20;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L17
        r110 = r113;
    L105:
        l r114 = (l) r112;     // Catch: Throwable -> L17
        if (r114 != null) goto L108;
    L114:
        l r106 = null;
        ?? r115 = r110;
    L115:
        r115.unlock(null);
        return r106;
    L108:
        if (Intrinsics.areEqual(g(), r105) == true) goto L111;
        r114 = null;
    L111:
        if (r114 == null) goto L114;
        this.f363151e = r114;     // Catch: Throwable -> L17
        r106 = r114;
        r115 = r110;
        goto L115
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        kotlinx.coroutines.sync.a r116 = (kotlinx.coroutines.sync.a) r100.L$2;
        String r107 = (String) r100.L$1;
        Context r108 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r112);
        String r117 = r107;
        ?? r109 = r108;
        kotlinx.coroutines.sync.a r118 = r116;
    L89:
        r106 = this.f363151e;     // Catch: Throwable -> L17
        if (r106 != null) goto L92;
    L101:
        r100.L$0 = r117;     // Catch: Throwable -> L17
        r100.L$1 = r118;     // Catch: Throwable -> L17
        r100.L$2 = null;     // Catch: Throwable -> L17
        r100.label = 4;     // Catch: Throwable -> L17
        Object r119 = f(r109, r117, r100);     // Catch: Throwable -> L17
        if (r119 != r102) goto L104;
        return r102;
    L104:
        r105 = r117;
        r112 = r119;
        r110 = r118;
        goto L105
    L92:
        if (r106.f363215e == null) goto L94;
    L96:
        if (r104 == true) goto L99;
        r106 = null;
    L99:
        if (r106 == null) goto L101;
        r115 = r118;
        goto L115
    L94:
        if (Intrinsics.areEqual(r106.f363214d, r117) == false) goto L96;
        r104 = true;
        goto L96
    L22:
        kotlinx.coroutines.sync.a r120 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L61
        r110 = r120;
    L55:
        l r121 = (l) r112;     // Catch: Throwable -> L61
        if (r121 == null) goto L63;
        this.f363151e = r121;     // Catch: Throwable -> L61
        Lazy r122 = com.larus.im.j.f350569a;     // Catch: Throwable -> L61
        ?? r123 = r110;
        if (com.larus.im.j.f(r121.f363211a.f559198a) == false) goto L64;
        String r124 = r121.f363211a.f559198a;     // Catch: Throwable -> L61
        k();     // Catch: Throwable -> L61
        k r125 = new k(this, r124, null);     // Catch: Throwable -> L61
        this.f363152f = new a(r124, r125);     // Catch: Throwable -> L61
        com.larus.im.d.c().registerConversationChangeListener(r124, r125);     // Catch: Throwable -> L61
        r123 = r110;
    L64:
        r123.unlock(null);
        return r121;
    L63:
        r121 = null;
        r123 = r110;
        goto L64
    L25:
        kotlinx.coroutines.sync.a r126 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r127 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r128 = r126;
    L44:
        r121 = this.f363151e;     // Catch: Throwable -> L61
        if (r121 != null) goto L47;
    L52:
        r100.L$0 = r128;     // Catch: Throwable -> L61
        r100.L$1 = null;     // Catch: Throwable -> L61
        r100.label = 2;     // Catch: Throwable -> L61
        r112 = i(r127, r100);     // Catch: Throwable -> L61
        r110 = r128;
        if (r112 != r102) goto L55;
        return r102;
    L47:
        if (Intrinsics.areEqual(r121.f363215e, r127) == true) goto L50;
        r121 = null;
    L50:
        if (r121 == null) goto L52;
        r123 = r128;
        goto L64
    L26:
        ResultKt.throwOnFailure(r112);
        String r129 = this.f363147a;
        if (r129 != null) goto L29;
    L31:
        r127 = null;
    L32:
        if (r127 == null) goto L68;
        l r130 = this.f363151e;
        if (r130 != null) goto L36;
    L41:
        MutexImpl r131 = this.f363149c;
        r100.L$0 = r127;
        r100.L$1 = r131;
        r100.label = 1;
        Object r132 = r131.a(null, r100);
        r128 = r131;
        if (r132 != r102) goto L44;
        return r102;
    L36:
        if (Intrinsics.areEqual(r130.f363215e, r127) == true) goto L39;
        r130 = null;
    L39:
        if (r130 == null) goto L41;
        return r130;
    L68:
        r117 = g();
        if (r117 != null) goto L72;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[ensureConversation] skipped, file token is empty");
        return null;
    L72:
        l r133 = this.f363151e;
        if (r133 != null) goto L75;
    L85:
        MutexImpl r134 = this.f363149c;
        r100.L$0 = r110;
        r100.L$1 = r117;
        r100.L$2 = r134;
        r100.label = 3;
        if (r134.a(null, r100) != r102) goto L88;
        return r102;
    L88:
        r109 = r110;
        r118 = r134;
        goto L89
    L75:
        if (r133.f363215e == null) goto L77;
    L79:
        boolean r135 = false;
    L80:
        if (r135 == true) goto L83;
        r133 = null;
    L83:
        if (r133 == null) goto L85;
        return r133;
    L77:
        if (Intrinsics.areEqual(r133.f363214d, r117) == false) goto L79;
        r135 = true;
        goto L80
    L29:
        if ((!StringsKt.isBlank(r129)) == false) goto L31;
        r127 = r129;
    L61:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L17:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r100 = new OfficeDrivePreviewChatSessionAbility$ensureConversation$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    public final Object i(String r210, Continuation<? super l> r211) {
        if ((r211 instanceof OfficeDrivePreviewChatSessionAbility$resolveSourceConversation$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$resolveSourceConversation$1 r100 = (OfficeDrivePreviewChatSessionAbility$resolveSourceConversation$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r110 = true;
        wc9.e r105 = null;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        BotModel r106 = (BotModel) r100.L$2;
        wc9.e r107 = (wc9.e) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r105 = null;
    L79:
        ?? r111 = (String) r102;
        String r212 = r108;
        BotModel r112 = r106;
    L81:
        if (r111 != 0) goto L83;
    L86:
        if (r110 == false) goto L89;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[resolveSourceConversation] unavailable, reason=bot_empty");
        return r105;
    L89:
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[resolveSourceConversation] success, conversationHash=" + j(r107.f559198a));
        return new l(r107, r112, r111, null, r212, null);
    L83:
        if (StringsKt.isBlank(r111) == true) goto L86;
        r110 = false;
        goto L86
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r106 = (BotModel) r100.L$2;
        r107 = (wc9.e) r100.L$1;
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r105 = null;
    L56:
        String r113 = (String) CollectionsKt.firstOrNull((List) r102);
        if (r113 == null) goto L61;
        boolean r114 = !StringsKt.isBlank(r113);
        ?? r115 = r113;
        if (r114 == false) goto L61;
    L62:
        if (r115 != 0) goto L80;
        r115 = this.f363148b;
        if (r115 != 0) goto L66;
    L73:
        r115 = r105;
    L74:
        if (r115 != 0) goto L80;
        r100.L$0 = r109;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.label = 4;
        r102 = h(r100);
        if (r102 != r103) goto L78;
        return r103;
    L78:
        r108 = r109;
        goto L79
    L66:
        if ((!StringsKt.isBlank(r115)) == true) goto L68;
    L70:
        boolean r116 = false;
    L71:
        if (r116 == false) goto L73;
    L68:
        if (Intrinsics.areEqual(r115, "unknown") == true) goto L70;
        r116 = true;
    L80:
        r112 = r106;
        r212 = r109;
        r111 = r115;
    L61:
        r115 = r105;
        goto L62
    L18:
        String r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r105 = null;
    L33:
        wc9.e r118 = (wc9.e) r102;
        String r119 = r117;
    L34:
        if (r118 == null) goto L91;
        Integer r120 = r118.f559217t;
        if (r120 != null) goto L39;
    L41:
        r106 = (BotModel) BotInfoCache.INSTANCE.get(r119);
        if (r106 == null) goto L52;
        String r121 = r106.getBotId();
        if (r121 == null) goto L52;
        boolean r122 = !StringsKt.isBlank(r121);
        Object r123 = r121;
        if (r122 == true) goto L49;
        r123 = r105;
    L49:
        if (r123 == null) goto L52;
        r212 = r119;
        r112 = r106;
        r111 = r123;
        r107 = r118;
    L52:
        r100.L$0 = r119;
        r100.L$1 = r118;
        r100.L$2 = r106;
        r100.label = 3;
        Object r124 = ic8.n.b(r119, r100);
        if (r124 != r103) goto L55;
        return r103;
    L55:
        r109 = r119;
        r102 = r124;
        r107 = r118;
        goto L56
    L39:
        if (r120.intValue() != 2) goto L41;
    L91:
        FLogger r125 = FLogger.f375446a;
        if (r118 != null) goto L94;
        String r126 = "missing";
    L95:
        r125.i("OfficeDrivePreviewSession", "[resolveSourceConversation] unavailable, reason=".concat(r126));
        return r105;
    L94:
        r126 = "deleted";
        goto L95
    L19:
        IConversationRepoService r127 = (IConversationRepoService) r100.L$1;
        String r128 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r129 = r102;
        r119 = r128;
        IConversationRepoService r130 = r127;
    L24:
        r118 = (wc9.e) r129;
        if (r118 != null) goto L34;
        if (com.larus.im.j.f(r119) == false) goto L29;
        r118 = r105;
        goto L34
    L29:
        r100.L$0 = r119;
        r100.L$1 = r105;
        r100.label = 2;
        Object r131 = IConversationRepoService.a.c(r130, r119, false, null, r100, 4);
        if (r131 != r103) goto L32;
        return r103;
    L32:
        r117 = r119;
        r102 = r131;
        goto L33
    L20:
        ResultKt.throwOnFailure(r102);
        IConversationRepoService r132 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r210;
        r100.L$1 = r132;
        r100.label = 1;
        r129 = IConversationRepoService.a.c(r132, r210, false, null, r100, 6);
        if (r129 != r103) goto L23;
        return r103;
    L23:
        r130 = r132;
        r119 = r210;
    L7:
        r100 = new OfficeDrivePreviewChatSessionAbility$resolveSourceConversation$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(String r210, String r211, Continuation<? super l> r310) {
        String r100 = r210;
        String r101 = r211;
        if ((r310 instanceof OfficeDrivePreviewChatSessionAbility$readCachedConversation$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$readCachedConversation$1 r102 = (OfficeDrivePreviewChatSessionAbility$readCachedConversation$1) r310;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        OfficeDrivePreviewChatSessionAbility$readCachedConversation$1 r104 = r102;
        Object r105 = r104.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        String r107 = "OfficeDrivePreviewSession";
        m0 r108 = null;
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L19;
        if (r106 == 4) goto L18;
        if (r106 != 5) goto L17;
        ResultKt.throwOnFailure(r105);
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        wc9.e r109 = (wc9.e) r104.L$3;
        String r111 = (String) r104.L$2;
        String r112 = (String) r104.L$1;
        String r113 = (String) r104.L$0;
        ResultKt.throwOnFailure(r105);
        String r212 = r112;
        r108 = null;
        r107 = "OfficeDrivePreviewSession";
        String r114 = r111;
        String r115 = r113;
    L63:
        String r116 = (String) CollectionsKt.firstOrNull((List) r105);
        if (r116 != null) goto L66;
    L68:
        String r213 = r108;
    L69:
        if (r213 != 0) goto L71;
    L74:
        boolean r117 = true;
    L75:
        if (r117 == false) goto L80;
        r104.L$0 = r108;
        r104.L$1 = r108;
        r104.L$2 = r108;
        r104.L$3 = r108;
        r104.label = 5;
        if (e(r115, r212, r114, "bot_empty", r104) != r110) goto L112;
        return r110;
    L112:
        return r108;
    L80:
        Integer r118 = r109.f559209l;
        if (r118 == null) goto L83;
        int r119 = r118.intValue();
    L84:
        Integer r120 = r109.f559210m;
        if (r120 == null) goto L87;
        int r121 = r120.intValue();
    L88:
        int r122 = RangesKt.coerceAtLeast(r119 - r121, 0);
        if (r122 <= 0) goto L95;
        Long r123 = r109.f559212o;
        if (r123 == null) goto L93;
        long r124 = r123.longValue();
    L94:
        r108 = new m0(r122, r124);
        goto L95
    L93:
        r124 = 0;
    L95:
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("[readCachedConversation] conversation cache HIT hasUnread=");
        if (r108 == null) goto L98;
        boolean r127 = true;
    L99:
        r126.append(r127);
        r126.append(", unreadCount=");
        r126.append(r122);
        r126.append(", readMessageIndex=");
        if (r108 == null) goto L102;
        long r128 = r108.f363220b;
    L103:
        r126.append(r128);
        r126.append(", conversationHash=");
        r126.append(j(r114));
        r125.i(r107, r126.toString());
        return new l(r109, (BotModel) BotInfoCache.INSTANCE.get(r114), r213, r212, null, r108);
    L102:
        r128 = -1;
        goto L103
    L98:
        r127 = false;
        goto L99
    L87:
        r121 = 0;
        goto L88
    L83:
        r119 = 0;
        goto L84
    L71:
        if (StringsKt.isBlank(r213) == true) goto L74;
        r117 = false;
        goto L75
    L66:
        if ((!StringsKt.isBlank(r116)) == false) goto L68;
        r213 = r116;
        goto L69
    L19:
        ResultKt.throwOnFailure(r105);
        return null;
    L20:
        String r129 = (String) r104.L$2;
        String r130 = (String) r104.L$1;
        String r131 = (String) r104.L$0;
        ResultKt.throwOnFailure(r105);
        Object r132 = r105;
        int r133 = 4;
        String r134 = r129;
        String r135 = r130;
        r115 = r131;
    L51:
        r109 = (wc9.e) r132;
        if (r109 == null) goto L105;
        Integer r136 = r109.f559217t;
        if (r136 != null) goto L57;
    L59:
        r104.L$0 = r115;
        r104.L$1 = r135;
        r104.L$2 = r134;
        r104.L$3 = r109;
        r104.label = r133;
        r105 = ic8.n.b(r134, r104);
        if (r105 != r110) goto L62;
        return r110;
    L62:
        r212 = r135;
        r114 = r134;
        goto L63
    L57:
        if (r136.intValue() != 2) goto L59;
    L105:
        if (r109 != null) goto L107;
        String r137 = "missing";
    L108:
        r104.L$0 = r108;
        r104.L$1 = r108;
        r104.L$2 = r108;
        r104.label = 3;
        if (e(r115, r135, r134, r137, r104) != r110) goto L113;
        return r110;
    L113:
        return r108;
    L107:
        r137 = "deleted";
        goto L108
    L21:
        String r138 = (String) r104.L$1;
        String r139 = (String) r104.L$0;
        ResultKt.throwOnFailure(r105);
        r101 = r138;
        r100 = r139;
    L29:
        OfficeDocumentConversationCache.c r140 = (OfficeDocumentConversationCache.c) r105;
        String r141 = r140.f362479b;
        if (r141 != null) goto L32;
    L37:
        r141 = null;
    L38:
        if (r141 != null) goto L40;
    L43:
        boolean r142 = true;
    L44:
        if (r142 == false) goto L47;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[readCachedConversation] conversation cache " + r140.f362478a + ", create local fallback");
        return null;
    L47:
        IConversationRepoService r143 = RepoDispatcherDelegate.f307737b.f();
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r141;
        r104.label = 2;
        r133 = 4;
        r132 = IConversationRepoService.a.c(r143, r141, false, null, r104, 6);
        if (r132 != r110) goto L50;
        return r110;
    L50:
        r134 = r141;
        r135 = r101;
        r115 = r100;
        goto L51
    L40:
        if (StringsKt.isBlank(r141) == true) goto L43;
        r142 = false;
        goto L44
    L32:
        if (r140.f362478a != OfficeDocumentConversationCache.ReadStatus.HIT) goto L34;
        boolean r144 = true;
    L35:
        if (r144 == false) goto L37;
    L34:
        r144 = false;
        goto L35
    L22:
        ResultKt.throwOnFailure(r105);
        if (StringsKt.isBlank(r210) == false) goto L26;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[readCachedConversation] skipped, userId is empty");
        return null;
    L26:
        OfficeDocumentConversationCache r145 = OfficeDocumentConversationCache.f362464a;
        int r146 = va9.a.f553982a;
        int r147 = ga9.a.d("office_doc_conversation_cache_expiration_seconds", AnnouncementViewModel.HOUR_DURATION);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.label = 1;
        r105 = r145.i(r100, r101, r147, r104);
        if (r105 != r110) goto L29;
        return r110;
    L7:
        r102 = new OfficeDrivePreviewChatSessionAbility$readCachedConversation$1(this, r310);
        goto L8
    }

    public final Object f(Context r100, String r101, Continuation<? super l> r102) {
        if ((r102 instanceof OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1 r103 = (OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L34:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r109 = (String) r103.L$2;
        r101 = (String) r103.L$1;
        Context r110 = (Context) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        l r111 = (l) r105;
        if (r111 == null) goto L24;
        return r111;
    L24:
        if ((!StringsKt.isBlank(r109)) == true) goto L26;
    L30:
        r108 = false;
    L31:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 2;
        r105 = a(r110, r101, r108, r103);
        if (r105 != r106) goto L34;
        return r106;
    L26:
        if ((!StringsKt.isBlank(AccountService.f365697a.getSecUserId())) == false) goto L30;
        if ((!StringsKt.isBlank(r101)) == false) goto L30;
    L16:
        ResultKt.throwOnFailure(r105);
        String r112 = AccountService.f365697a.getUserId();
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.L$2 = r112;
        r103.label = 1;
        Object r113 = d(r112, r101, r103);
        if (r113 != r106) goto L19;
        return r106;
    L19:
        r110 = r100;
        r109 = r112;
        r105 = r113;
    L7:
        r103 = new OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1(this, r102);
        goto L8
    }

    public final Object a(Context r210, String r211, boolean r212, Continuation<? super l> r213) {
        if ((r213 instanceof OfficeDrivePreviewChatSessionAbility$createLocalConversation$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$createLocalConversation$1 r100 = (OfficeDrivePreviewChatSessionAbility$createLocalConversation$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        boolean r105 = r100.Z$0;
        BotModel r106 = (BotModel) r100.L$2;
        String r107 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r109 = r108;
    L57:
        wc9.e r110 = (wc9.e) r102;
        if (r110 != null) goto L61;
        return null;
    L61:
        String r111 = r110.f559198a;
        if (StringsKt.isBlank(r111) == false) goto L64;
        return null;
    L64:
        BotInfoCache.INSTANCE.put(r111, r106);
        LocalSubConvHelper r112 = LocalSubConvHelper.f314106a;
        BotOnBoarding r113 = r106.getOnBoarding();
        if (r113 == null) goto L68;
        List<Message> r114 = r113.getMessageList();
        if (r114 == null) goto L68;
    L69:
        LocalSubConvHelper.j(r111, r114, true);
        FLogger r115 = FLogger.f375446a;
        r115.i("OfficeDrivePreviewSession", "[createLocalConversation] success, conversationHash=" + j(r111));
        if (r105 == false) goto L85;
        if (com.larus.im.j.f(r111) == false) goto L85;
        if (Intrinsics.areEqual(g(), r109) == false) goto L85;
        AccountService r116 = AccountService.f365697a;
        String r117 = r116.getUserId();
        String r118 = r116.getSecUserId();
        if (StringsKt.isBlank(r117) == true) goto L85;
        if (StringsKt.isBlank(r118) == true) goto L85;
        if (StringsKt.isBlank(r109) == true) goto L85;
        Object r119 = OfficeConversationCachePromotionTracker.f362454a;
        OfficeConversationCachePromotionTracker.c(r111, r117, r118, r109);
        k();
        k r120 = new k(this, r111, r109);
        this.f363152f = new a(r111, r120);
        com.larus.im.d.c().registerConversationChangeListener(r111, r120);
        r115.i("OfficeDrivePreviewSession", "[trackLocalConversationPromotion] local conversation promoted tracker registered conversationHash=" + j(r111));
    L85:
        return new l(r110, r106, r107, r109, null, null);
    L68:
        r114 = CollectionsKt.emptyList();
        goto L69
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r121 = r100.Z$0;
        String r122 = (String) r100.L$2;
        String r123 = (String) r100.L$1;
        Context r124 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r125 = r122;
        String r126 = r123;
    L38:
        BotModel r127 = (BotModel) r102;
        if (r127 != null) goto L41;
        return null;
    L41:
        String r128 = UUID.randomUUID() + "_drive_preview";
        r100.L$0 = r126;
        r100.L$1 = r125;
        r100.L$2 = r127;
        r100.Z$0 = r121;
        r100.label = 3;
        kotlinx.coroutines.j r129 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r129.C();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L44;
        int r130 = R.string.larus_new_task_cn;
    L45:
        NativeConversationServiceImpl r131 = com.larus.im.d.d();
        Pair[] r132 = new Pair[4];
        r132[0] = TuplesKt.to("attach_local_msg", "true");
        if (r124 == null) goto L48;
        String r133 = r124.getString(r130);
    L49:
        if (r133 != null) goto L51;
        r133 = "";
    L51:
        r132[1] = TuplesKt.to("conv_name", r133);
        r132[2] = TuplesKt.to("reuse_local_conversation", "true");
        r132[3] = TuplesKt.to("custom_suffix", r128);
        com.larus.im.service.r.a.a(r131, r127, 3, Boxing.boxInt(1), MapsKt.mapOf(r132), null, new i(r129), 16);
        Object r134 = r129.B();
        if (r134 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L54:
        if (r134 != r103) goto L56;
        return r103;
    L56:
        r105 = r121;
        r109 = r126;
        r106 = r127;
        r102 = r134;
        r107 = r125;
        goto L57
    L48:
        r133 = null;
        goto L49
    L44:
        r130 = R.string.larus_new_chat_default;
        goto L45
    L17:
        r121 = r100.Z$0;
        r126 = (String) r100.L$1;
        Context r135 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L22:
        String r136 = (String) r102;
        if (r136 != null) goto L25;
    L28:
        boolean r137 = true;
    L29:
        if (r137 == false) goto L32;
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[createLocalConversation] skipped, botId is empty");
        return null;
    L32:
        r100.L$0 = r135;
        r100.L$1 = r126;
        r100.L$2 = r136;
        r100.Z$0 = r121;
        r100.label = 2;
        kotlinx.coroutines.j r138 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r138.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r136, false, "sub", new j(r138), 8);
        Object r139 = r138.B();
        if (r139 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L35:
        if (r139 != r103) goto L37;
        return r103;
    L37:
        Context r214 = r135;
        r125 = r136;
        r102 = r139;
        r124 = r214;
        goto L38
    L25:
        if (StringsKt.isBlank(r136) == true) goto L28;
        r137 = false;
        goto L29
    L18:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r210;
        r100.L$1 = r211;
        r100.Z$0 = r212;
        r100.label = 1;
        Object r140 = h(r100);
        if (r140 != r103) goto L21;
        return r103;
    L21:
        r135 = r210;
        r102 = r140;
        r126 = r211;
        r121 = r212;
    L7:
        r100 = new OfficeDrivePreviewChatSessionAbility$createLocalConversation$1(this, r213);
        goto L8
    }

    public final Object e(String r100, String r101, String r102, String r103, Continuation<? super Unit> r104) {
        if ((r104 instanceof OfficeDrivePreviewChatSessionAbility$removeInvalidCache$1) == false) goto L7;
        OfficeDrivePreviewChatSessionAbility$removeInvalidCache$1 r105 = (OfficeDrivePreviewChatSessionAbility$removeInvalidCache$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (String) r105.L$1;
        r102 = (String) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L17:
        boolean r110 = ((Boolean) r107).booleanValue();
        FLogger.f375446a.i("OfficeDrivePreviewSession", "[removeInvalidCache] invalid cache conversation removed=" + r110 + " reason=" + r103 + " conversationHash=" + j(r102));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        OfficeDocumentConversationCache r111 = OfficeDocumentConversationCache.f362464a;
        r105.L$0 = r102;
        r105.L$1 = r103;
        r105.label = 1;
        r107 = r111.j(r100, r101, r102, r105);
        if (r107 != r108) goto L17;
        return r108;
    L7:
        r105 = new OfficeDrivePreviewChatSessionAbility$removeInvalidCache$1(this, r104);
        goto L8
    }
}
