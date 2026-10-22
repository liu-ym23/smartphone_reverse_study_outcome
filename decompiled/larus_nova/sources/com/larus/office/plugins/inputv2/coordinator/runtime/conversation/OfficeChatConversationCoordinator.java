package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import android.content.Context;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.business.floatchat.api.IAIFloatChatService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.j;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.input.cache.OfficeDocumentConversationCache;
import com.larus.office.plugins.inputv2.i1;
import com.larus.office.plugins.inputv2.j1;
import com.larus.office.plugins.inputv2.k1;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import dw8.i;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeChatConversationCoordinator {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f362812m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Context> f362813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<CoroutineScope> f362814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f362816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.office.plugins.inputv2.adapter.g f362817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public wc9.e f362818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BotModel f362819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f362820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f362821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeChatConversationCachePromotionStore f362822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f362823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f362824l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f362826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f362827c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f362825a, r101.f362825a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362826b, r101.f362826b) == true) goto L15;
            return false;
        L15:
            if (this.f362827c == r101.f362827c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f362825a.hashCode() * 31;
            Long r101 = this.f362826b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f362827c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PreparedConversation(conversationId=" + this.f362825a + ", unreadReadMessageIndex=" + this.f362826b + ", generation=" + this.f362827c + ')';
        }

        public b(String r100, Long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f362825a = r100;
            this.f362826b = r101;
            this.f362827c = r102;
        }
    }

    static {
    }

    public final void k() {
        com.larus.office.plugins.inputv2.adapter.g r100 = this.f362817e;
        if (r100 == null) goto L8;
        jo9.g r101 = (jo9.g) r100.g(jo9.g.class);
        if (r101 == null) goto L9;
        r101.P1(this.f362818f);
        r101.e1(this.f362819g);
        r101.a5(this.f362820h);
        return;
    L9:
        return;
    }

    public final void n() {
        com.larus.office.plugins.inputv2.adapter.g r100 = this.f362817e;
        if (r100 == null) goto L5;
        r100.t(this.f362824l);
    L5:
        this.f362817e = null;
        g r101 = this.f362823k;
        Job r102 = r101.f362845j;
        if (r102 == null) goto L8;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L8:
        r101.f362845j = null;
        Job r103 = r101.f362846k;
        if (r103 == null) goto L11;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L11:
        r101.f362846k = null;
    }

    public final void j() {
        n();
        this.f362816d++;
        OfficeChatConversationCachePromotionStore r100 = this.f362822j;
        r100.d();
        r100.f362808d = null;
        g r101 = this.f362823k;
        Job r102 = r101.f362845j;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        r101.f362845j = null;
        Job r103 = r101.f362846k;
        if (r103 == null) goto L8;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L8:
        r101.f362846k = null;
        r101.f362842g = null;
        r101.f362843h = null;
        r101.f362844i = false;
        this.f362818f = null;
        this.f362819g = null;
        this.f362820h = null;
        this.f362821i = null;
    }

    public static String l(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void i(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        OfficeChatConversationCachePromotionStore r100 = this.f362822j;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "from");
        OfficeInputParam r101 = r100.f362805a.invoke();
        if (r101 == null) goto L25;
        String r102 = AccountService.f365697a.getUserId();
        String r103 = r101.getResourceId();
        String r104 = r101.getConversationId();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        String r105 = r104;
        if (StringsKt.isBlank(r102) == false) goto L11;
        return;
    L11:
        if (StringsKt.isBlank(r103) == false) goto L13;
        return;
    L13:
        if (StringsKt.isBlank(r105) == false) goto L15;
        return;
    L15:
        if (j.f(r105) == true) goto L26;
        CoroutineScope r106 = r100.f362806b.invoke();
        if (r106 == null) goto L24;
        BuildersKt.launch$default(r106, null, null, new OfficeChatConversationCachePromotionStore$promoteCacheLruAfterExpand$1(r102, r103, r105, r110, r100, null), 3, null);
        return;
    L24:
        return;
    L26:
        return;
    }

    public final boolean m(String r100) {
        String r101 = this.f362821i;
        if (r101 != null) goto L5;
        return false;
    L5:
        OfficeInputParam r102 = this.f362815c.invoke();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r102.getResourceId(), r101) == true) goto L11;
    L27:
        return false;
    L11:
        if (r102.isFakeOfflineDoc() == true) goto L27;
        if (r100 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L27;
        if (j.f(r100) == true) goto L25;
        this.f362821i = null;
        return false;
    L25:
        this.f362822j.c(r100, r101, false);
        this.f362821i = null;
        return true;
    L15:
        if (StringsKt.isBlank(r100) == true) goto L18;
        r103 = false;
        goto L19
    }

    public final void a(wc9.e r100, BotModel r101) {
        this.f362818f = r100;
        this.f362819g = r101;
        if (r100 == null) goto L9;
        String r102 = r100.f559198a;
        if (r102 == null) goto L9;
        OfficeInputParam r103 = this.f362815c.invoke();
        if (r103 == null) goto L9;
        r103.setConversationId(r102);
    L9:
        k();
    }

    public final void b(com.larus.office.plugins.inputv2.adapter.g r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "adapter");
        n();
        if (r111 == this.f362816d) goto L5;
        return;
    L5:
        this.f362817e = r110;
        r110.l(this.f362824l);
        k();
        g r112 = this.f362823k;
        r112.c();
        g.a r113 = r112.f362842g;
        if (r113 == null) goto L16;
        r112.f362842g = null;
        CoroutineScope r100 = r112.f362836a.invoke();
        if (r100 == null) goto L16;
        Job r101 = r112.f362845j;
        if (r101 == null) goto L14;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L14:
        r112.f362845j = BuildersKt.launch$default(r100, null, null, new OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1(r112, r113, null), 3, null);
    L16:
        if (r112.f362844i == false) goto L32;
        r112.f362844i = false;
        OfficeInputParam r102 = r112.f362837b.invoke();
        if (r102 == null) goto L33;
        String r103 = r102.getResourceId();
        if (StringsKt.isBlank(r103) == true) goto L34;
        long r104 = r112.f362839d.invoke().longValue();
        CoroutineScope r114 = r112.f362836a.invoke();
        if (r114 == null) goto L35;
        Job r105 = r112.f362846k;
        if (r105 == null) goto L30;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L30:
        r112.f362846k = BuildersKt.launch$default(r114, null, null, new OfficeChatConversationMetadataSynchronizer$requestLegacyRemoteConversation$1(r112, r103, r102, r104, null), 3, null);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    public final Object c(String r100, Continuation<? super wc9.e> r110) {
        if ((r110 instanceof OfficeChatConversationCoordinator$findAvailableRemoteConversation$1) == false) goto L7;
        OfficeChatConversationCoordinator$findAvailableRemoteConversation$1 r101 = (OfficeChatConversationCoordinator$findAvailableRemoteConversation$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        OfficeChatConversationCoordinator$findAvailableRemoteConversation$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        wc9.e r112 = (wc9.e) r111;
        if (r112 == null) goto L28;
        Integer r107 = r112.f559217t;
        if (r107 != null) goto L23;
    L25:
        r106 = false;
    L26:
        if (r106 == true) goto L28;
        return r112;
    L23:
        if (r107.intValue() != 2) goto L25;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        IConversationRepoService r108 = RepoDispatcherDelegate.f307737b.f();
        r103.label = 1;
        r111 = IConversationRepoService.a.c(r108, r100, false, null, r103, 6);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r101 = new OfficeChatConversationCoordinator$findAvailableRemoteConversation$1(this, r110);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.office.plugins.inputv2.coordinator.runtime.conversation.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.coordinator.runtime.conversation.c] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.office.plugins.inputv2.coordinator.runtime.conversation.d] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.office.plugins.inputv2.coordinator.runtime.conversation.e] */
    public OfficeChatConversationCoordinator(i1 r100, j1 r110, k1 r111) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        Intrinsics.checkNotNullParameter(r110, "scopeProvider");
        Intrinsics.checkNotNullParameter(r111, "inputParamsProvider");
        this.f362813a = r100;
        this.f362814b = r110;
        this.f362815c = r111;
        this.f362822j = new OfficeChatConversationCachePromotionStore(r111, r110, new com.larus.office.plugins.inputv2.coordinator.runtime.conversation.b(this));
        this.f362823k = new g(r110, r111, new c(this), new d(this), new OfficeChatConversationCoordinator$metadataSynchronizer$3(this), new e(this));
        this.f362824l = new f(this);
    }

    public final void d(String r110, long r111, com.larus.office.plugins.inputv2.coordinator.runtime.integration.a r210) {
        Intrinsics.checkNotNullParameter(r110, "deletedConversationId");
        Intrinsics.checkNotNullParameter(r210, "onCacheRemoved");
        OfficeInputParam r100 = this.f362815c.invoke();
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = AccountService.f365697a.getUserId();
        String r102 = r100.getResourceId();
        com.larus.office.plugins.inputv2.adapter.g r103 = this.f362817e;
        if (r103 == null) goto L8;
        jo9.g r104 = (jo9.g) r103.g(jo9.g.class);
    L9:
        n();
        this.f362816d = r111;
        OfficeChatConversationCachePromotionStore r105 = this.f362822j;
        r105.d();
        r105.f362808d = null;
        g r106 = this.f362823k;
        Job r107 = r106.f362845j;
        if (r107 == null) goto L12;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L12:
        r106.f362845j = null;
        Job r108 = r106.f362846k;
        if (r108 == null) goto L15;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L15:
        r106.f362846k = null;
        r106.f362842g = null;
        r106.f362843h = null;
        r106.f362844i = false;
        this.f362818f = null;
        this.f362819g = null;
        r100.setConversationId(null);
        this.f362818f = null;
        this.f362819g = null;
        if (r104 == null) goto L18;
        r104.P1(null);
        r104.e1(null);
    L18:
        CoroutineScope r112 = this.f362814b.invoke();
        if (r112 != null) goto L22;
        FLogger.f375446a.i("OfficeChatConversation", "会话删除已消费但 View 不可用, conversation=" + l(r110));
        return;
    L22:
        BuildersKt.launch$default(r112, null, null, new OfficeChatConversationCoordinator$handleCurrentConversationDeleted$2(this, r101, r102, r110, r111, r210, null), 3, null);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final Object e(IAIFloatChatService r210, long r211, Continuation<? super b> r212) {
        IAIFloatChatService r100 = r210;
        if ((r212 instanceof OfficeChatConversationCoordinator$prepare$1) == false) goto L7;
        OfficeChatConversationCoordinator$prepare$1 r101 = (OfficeChatConversationCoordinator$prepare$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        OfficeChatConversationCoordinator$prepare$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Long r106 = null;
        boolean r107 = true;
        switch(r103.label) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r104);
    L103:
        return r104;
    L13:
        long r108 = r103.J$0;
        String r109 = (String) r103.L$2;
        OfficeInputParam r110 = (OfficeInputParam) r103.L$1;
        IAIFloatChatService r111 = (IAIFloatChatService) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r112 = r109;
        long r113 = r108;
        IAIFloatChatService r114 = r111;
        OfficeInputParam r115 = r110;
    L100:
        boolean r116 = ((Boolean) r104).booleanValue();
        FLogger.f375446a.i("OfficeChatConversation", "无效缓存已清理, removed=" + r116 + ", conversation=" + l(r112));
        r115.setConversationId(null);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 10;
        r104 = g(r114, r113, true, r103);
        if (r104 != r105) goto L103;
        return r105;
    L14:
        long r117 = r103.J$0;
        String r118 = (String) r103.L$4;
        String r119 = (String) r103.L$3;
        String r120 = (String) r103.L$2;
        OfficeInputParam r121 = (OfficeInputParam) r103.L$1;
        IAIFloatChatService r122 = (IAIFloatChatService) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r123 = r119;
        OfficeInputParam r124 = r121;
    L94:
        wc9.e r125 = (wc9.e) r104;
        if (r125 != null) goto L104;
        OfficeChatConversationCachePromotionStore r126 = this.f362822j;
        r103.L$0 = r122;
        r103.L$1 = r124;
        r103.L$2 = r118;
        r103.L$3 = null;
        r103.L$4 = null;
        r103.J$0 = r117;
        r103.label = 9;
        r126.getClass();
        r104 = OfficeDocumentConversationCache.f362464a.j(r120, r123, r118, r103);
        if (r104 != r105) goto L99;
        return r105;
    L99:
        r115 = r124;
        r112 = r118;
        r113 = r117;
        r114 = r122;
        goto L100
    L104:
        Integer r127 = r125.f559209l;
        if (r127 == null) goto L107;
        int r128 = r127.intValue();
    L108:
        Integer r129 = r125.f559210m;
        if (r129 == null) goto L111;
        int r130 = r129.intValue();
    L112:
        int r131 = RangesKt.coerceAtLeast(r128 - r130, 0);
        Long r132 = r125.f559212o;
        if (r132 == null) goto L115;
        long r133 = r132.longValue();
    L116:
        long r213 = r133;
        OfficeChatConversationCachePromotionStore r134 = this.f362822j;
        r134.getClass();
        Intrinsics.checkNotNullParameter(r118, "conversationId");
        if (r131 <= 0) goto L119;
        boolean r135 = true;
    L120:
        if (r135 == false) goto L122;
        String r136 = r118;
    L123:
        r134.f362808d = r136;
        g r137 = this.f362823k;
        int r138 = r124.getResourceType();
        String r139 = r124.getPreviousPage();
        r137.getClass();
        Intrinsics.checkNotNullParameter(r118, "conversationId");
        Intrinsics.checkNotNullParameter(r123, "resourceId");
        r137.f362842g = new g.a(r118, r123, r138, r139, r117);
        a(r125, null);
        FLogger r140 = FLogger.f375446a;
        StringBuilder r141 = new StringBuilder("命中远端会话缓存, hasUnread=");
        if (r131 <= 0) goto L126;
        boolean r142 = true;
    L127:
        r141.append(r142);
        r141.append(", conversation=");
        r141.append(l(r118));
        r140.i("OfficeChatConversation", r141.toString());
        Long r143 = Boxing.boxLong(r213);
        r143.longValue();
        if (r131 > 0) goto L131;
        r107 = false;
    L131:
        if (r107 == false) goto L134;
        r106 = r143;
    L134:
        return new b(r118, r106, r117);
    L126:
        r142 = false;
        goto L127
    L122:
        r136 = null;
        goto L123
    L119:
        r135 = false;
        goto L120
    L115:
        r133 = 0;
        goto L116
    L111:
        r130 = 0;
        goto L112
    L107:
        r128 = 0;
        goto L108
    L15:
        ResultKt.throwOnFailure(r104);
    L89:
        return r104;
    L16:
        long r144 = r103.J$0;
        String r145 = (String) r103.L$3;
        String r146 = (String) r103.L$2;
        OfficeInputParam r147 = (OfficeInputParam) r103.L$1;
        IAIFloatChatService r148 = (IAIFloatChatService) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r149 = r145;
        long r150 = r144;
        r100 = r148;
        String r151 = r146;
    L78:
        String r152 = (String) r104;
        if (r152 != null) goto L81;
    L84:
        boolean r153 = true;
    L85:
        if (r153 == false) goto L90;
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.label = 7;
        r104 = g(r100, r150, true, r103);
        if (r104 != r105) goto L89;
        return r105;
    L90:
        r103.L$0 = r100;
        r103.L$1 = r147;
        r103.L$2 = r151;
        r103.L$3 = r149;
        r103.L$4 = r152;
        r103.J$0 = r150;
        r103.label = 8;
        Object r154 = c(r152, r103);
        if (r154 != r105) goto L93;
        return r105;
    L93:
        r118 = r152;
        r104 = r154;
        r122 = r100;
        r117 = r150;
        String r214 = r151;
        r123 = r149;
        r124 = r147;
        r120 = r214;
        goto L94
    L81:
        if (StringsKt.isBlank(r152) == true) goto L84;
        r153 = false;
        goto L85
    L17:
        ResultKt.throwOnFailure(r104);
    L73:
        return r104;
    L18:
        ResultKt.throwOnFailure(r104);
    L60:
        return r104;
    L19:
        ResultKt.throwOnFailure(r104);
    L54:
        return r104;
    L20:
        long r155 = r103.J$0;
        OfficeInputParam r156 = (OfficeInputParam) r103.L$1;
        IAIFloatChatService r157 = (IAIFloatChatService) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r147 = r156;
        long r158 = r155;
        r100 = r157;
    L48:
        b r159 = (b) r104;
        if (r159 == null) goto L51;
        return r159;
    L51:
        r147.setConversationId(null);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 3;
        r104 = g(r100, r158, false, r103);
        if (r104 != r105) goto L54;
        return r105;
    L21:
        ResultKt.throwOnFailure(r104);
    L43:
        return r104;
    L22:
        ResultKt.throwOnFailure(r104);
        n();
        this.f362816d = r211;
        OfficeChatConversationCachePromotionStore r160 = this.f362822j;
        r160.d();
        r160.f362808d = null;
        g r161 = this.f362823k;
        Job r162 = r161.f362845j;
        if (r162 == null) goto L25;
        Job.DefaultImpls.cancel$default(r162, null, 1, null);
    L25:
        r161.f362845j = null;
        Job r163 = r161.f362846k;
        if (r163 == null) goto L28;
        Job.DefaultImpls.cancel$default(r163, null, 1, null);
    L28:
        r161.f362846k = null;
        r161.f362842g = null;
        r161.f362843h = null;
        r161.f362844i = false;
        this.f362818f = null;
        this.f362819g = null;
        r147 = this.f362815c.invoke();
        if (r147 != null) goto L31;
        return null;
    L31:
        String r164 = r147.getConversationId();
        if (r164 != null) goto L34;
    L36:
        String r165 = null;
    L37:
        if (r165 == null) goto L56;
        if (j.f(r165) == false) goto L44;
        r103.label = 1;
        r104 = f(r210, r165, r211, r103);
        if (r104 != r105) goto L43;
        return r105;
    L44:
        r103.L$0 = r100;
        r103.L$1 = r147;
        r103.J$0 = r211;
        r103.label = 2;
        r104 = h(r165, r211, r103);
        if (r104 != r105) goto L47;
        return r105;
    L47:
        r158 = r211;
        goto L48
    L56:
        if (z2.f365865a.isOfficeDocNewConversationEnable() == true) goto L61;
        this.f362823k.f362844i = true;
        r103.label = 4;
        r104 = g(r210, r211, false, r103);
        if (r104 != r105) goto L60;
        return r105;
    L61:
        String r166 = AccountService.f365697a.getUserId();
        String r167 = r147.getResourceId();
        if ((!StringsKt.isBlank(r166)) == true) goto L64;
    L68:
        boolean r168 = false;
    L69:
        if (r168 == true) goto L74;
        FLogger.f375446a.i("OfficeChatConversation", "会话缓存已跳过, cacheable=false");
        r103.label = 5;
        r104 = g(r210, r211, false, r103);
        if (r104 != r105) goto L73;
        return r105;
    L74:
        OfficeChatConversationCachePromotionStore r169 = this.f362822j;
        r103.L$0 = r100;
        r103.L$1 = r147;
        r103.L$2 = r166;
        r103.L$3 = r167;
        r103.J$0 = r211;
        r103.label = 6;
        Object r170 = r169.b(r166, r167, r103);
        if (r170 != r105) goto L77;
        return r105;
    L77:
        r151 = r166;
        r104 = r170;
        r149 = r167;
        r150 = r211;
        goto L78
    L64:
        if ((!StringsKt.isBlank(r167)) == false) goto L68;
        if (r147.isFakeOfflineDoc() == true) goto L68;
        r168 = true;
        goto L69
    L34:
        if ((!StringsKt.isBlank(r164)) == false) goto L36;
        r165 = r164;
        goto L37
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new OfficeChatConversationCoordinator$prepare$1(this, r212);
        goto L8
    }

    public final Object h(String r100, long r101, Continuation<? super b> r102) {
        if ((r102 instanceof OfficeChatConversationCoordinator$prepareRemoteConversation$1) == false) goto L7;
        OfficeChatConversationCoordinator$prepareRemoteConversation$1 r103 = (OfficeChatConversationCoordinator$prepareRemoteConversation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.J$0;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        wc9.e r108 = (wc9.e) r105;
        if (r108 != null) goto L20;
        return null;
    L20:
        a(r108, null);
        return new b(r100, null, r101);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.J$0 = r101;
        r103.label = 1;
        r105 = c(r100, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeChatConversationCoordinator$prepareRemoteConversation$1(this, r102);
        goto L8
    }

    public final Object f(IAIFloatChatService r110, String r111, long r112, Continuation<? super b> r113) {
        if ((r113 instanceof OfficeChatConversationCoordinator$prepareExistingLocalConversation$1) == false) goto L7;
        OfficeChatConversationCoordinator$prepareExistingLocalConversation$1 r100 = (OfficeChatConversationCoordinator$prepareExistingLocalConversation$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r114);
    L27:
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = r100.J$0;
        r111 = (String) r100.L$1;
        r110 = (IAIFloatChatService) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L19:
        IAIFloatChatService r104 = r110;
        long r105 = r112;
        wc9.e r115 = (wc9.e) r114;
        if (r115 != null) goto L28;
        OfficeInputParam r116 = this.f362815c.invoke();
        if (r116 == null) goto L24;
        r116.setConversationId(null);
    L24:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        r114 = g(r104, r105, false, r100);
        if (r114 != r102) goto L27;
        return r102;
    L28:
        OfficeInputParam r117 = this.f362815c.invoke();
        if (r117 != null) goto L31;
        return null;
    L31:
        a(r115, (BotModel) BotInfoCache.INSTANCE.get(r111));
        OfficeChatConversationCachePromotionStore r118 = this.f362822j;
        String r119 = r117.getResourceId();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r111, "localConversationId");
        Intrinsics.checkNotNullParameter(r119, "resourceId");
        r118.d();
        com.larus.office.plugins.inputv2.coordinator.runtime.conversation.a r120 = new com.larus.office.plugins.inputv2.coordinator.runtime.conversation.a(r118, r111, r119);
        r118.f362809e = new OfficeChatConversationCachePromotionStore.b(r111, r120);
        com.larus.im.d.c().registerConversationChangeListener(r111, r120);
        m(r111);
        return new b(r111, null, r105);
    L16:
        ResultKt.throwOnFailure(r114);
        IConversationRepoService r106 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.J$0 = r112;
        r100.label = 1;
        r114 = IConversationRepoService.a.c(r106, r111, false, null, r100, 6);
        if (r114 != r102) goto L19;
        return r102;
    L7:
        r100 = new OfficeChatConversationCoordinator$prepareExistingLocalConversation$1(this, r113);
        goto L8
    }

    public final Object g(IAIFloatChatService r110, long r111, boolean r112, Continuation<? super b> r113) {
        if ((r113 instanceof OfficeChatConversationCoordinator$prepareNewLocalConversation$1) == false) goto L7;
        OfficeChatConversationCoordinator$prepareNewLocalConversation$1 r100 = (OfficeChatConversationCoordinator$prepareNewLocalConversation$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OfficeChatConversationCoordinator$prepareNewLocalConversation$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        boolean r115 = r102.Z$0;
        r111 = r102.J$0;
        OfficeInputParam r116 = (OfficeInputParam) r102.L$1;
        i r105 = (i) r102.L$0;
        ResultKt.throwOnFailure(r114);
    L34:
        a((wc9.e) r114, (BotModel) BotInfoCache.INSTANCE.get(r105.f470346a));
        boolean r117 = m(r105.f470346a);
        if (r115 == false) goto L38;
        if (r117 == true) goto L38;
        this.f362822j.c(r105.f470346a, r116.getResourceId(), r116.isFakeOfflineDoc());
    L38:
        FLogger.f375446a.i("OfficeChatConversation", "本地会话已创建, trackPromotion=" + r115 + ", conversation=" + l(r105.f470346a));
        return new b(r105.f470346a, null, r111);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = r102.Z$0;
        r111 = r102.J$0;
        ResultKt.throwOnFailure(r114);
    L19:
        i r118 = (i) r114;
        if (r118 != null) goto L24;
        FLogger.f375446a.e("OfficeChatConversation", "创建本地会话失败");
        return null;
    L24:
        if (r111 == this.f362816d) goto L27;
        FLogger.f375446a.i("OfficeChatConversation", "丢弃迟到的本地会话, generation=" + r111);
        return null;
    L27:
        OfficeInputParam r119 = this.f362815c.invoke();
        if (r119 != null) goto L30;
        return null;
    L30:
        r119.setConversationId(r118.f470346a);
        r119.setBotId(r118.f470347b);
        IConversationRepoService r106 = RepoDispatcherDelegate.f307737b.f();
        String r107 = r118.f470346a;
        r102.L$0 = r118;
        r102.L$1 = r119;
        r102.J$0 = r111;
        r102.Z$0 = r112;
        r102.label = 2;
        Object r108 = IConversationRepoService.a.c(r106, r107, false, null, r102, 6);
        if (r108 != r103) goto L33;
        return r103;
    L33:
        r105 = r118;
        r115 = r112;
        r116 = r119;
        r114 = r108;
        goto L34
    L16:
        ResultKt.throwOnFailure(r114);
        Context r120 = this.f362813a.invoke();
        r102.J$0 = r111;
        r102.Z$0 = r112;
        r102.label = 1;
        r114 = r110.b(r120, r102);
        if (r114 != r103) goto L19;
        return r103;
    L7:
        r100 = new OfficeChatConversationCoordinator$prepareNewLocalConversation$1(this, r113);
        goto L8
    }
}
