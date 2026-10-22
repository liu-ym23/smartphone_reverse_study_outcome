package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.larus.im.service.d0;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.input.cache.OfficeConversationCachePromotionTracker;
import com.larus.office.plugins.input.cache.OfficeDocumentConversationCache;
import com.larus.office.plugins.inputv2.j1;
import com.larus.office.plugins.inputv2.k1;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeChatConversationCachePromotionStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<CoroutineScope> f362806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<wc9.e, Unit> f362807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f362808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f362809e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0<wc9.e> f362811b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f362810a, r101.f362810a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362811b, r101.f362811b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f362810a.hashCode() * 31) + this.f362811b.hashCode();
        }

        public final String toString() {
            return "LocalConversationListenerRegistration(localConversationId=" + this.f362810a + ", listener=" + this.f362811b + ')';
        }

        public b(String r100, com.larus.office.plugins.inputv2.coordinator.runtime.conversation.a r101) {
            Intrinsics.checkNotNullParameter(r100, "localConversationId");
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f362810a = r100;
            this.f362811b = r101;
        }
    }

    static {
    }

    public final void d() {
        b r100 = this.f362809e;
        if (r100 == null) goto L5;
        com.larus.im.d.c().unRegisterConversationChangeListener(r100.f362810a, r100.f362811b);
    L5:
        this.f362809e = null;
    }

    public static final String a(OfficeChatConversationCachePromotionStore r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        if (r101 != null) goto L12;
        return "null";
    L12:
        return "empty";
    L14:
        return "len=" + r101.length() + ",hash=" + r101.hashCode();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public OfficeChatConversationCachePromotionStore(k1 r100, j1 r101, com.larus.office.plugins.inputv2.coordinator.runtime.conversation.b r102) {
        Intrinsics.checkNotNullParameter(r100, "inputParamsProvider");
        Intrinsics.checkNotNullParameter(r101, "scopeProvider");
        Intrinsics.checkNotNullParameter(r102, "onLocalConversationPromoted");
        this.f362805a = r100;
        this.f362806b = r101;
        this.f362807c = r102;
    }

    public final Object b(String r100, String r101, Continuation<? super String> r102) {
        if ((r102 instanceof OfficeChatConversationCachePromotionStore$readCachedConversationId$1) == false) goto L7;
        OfficeChatConversationCachePromotionStore$readCachedConversationId$1 r103 = (OfficeChatConversationCachePromotionStore$readCachedConversationId$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        OfficeDocumentConversationCache.c r109 = (OfficeDocumentConversationCache.c) r105;
        String r110 = r109.f362479b;
        if (r110 != null) goto L20;
    L25:
        r110 = null;
    L26:
        if (r110 != null) goto L28;
    L31:
        if (r108 == false) goto L33;
        FLogger.f375446a.i("OfficeChatConversation", "会话缓存 " + r109.f362478a + ", 创建新本地会话");
    L33:
        return r110;
    L28:
        if (StringsKt.isBlank(r110) == true) goto L31;
        r108 = false;
        goto L31
    L20:
        if (r109.f362478a != OfficeDocumentConversationCache.ReadStatus.HIT) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L25;
    L22:
        r111 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        OfficeDocumentConversationCache r112 = OfficeDocumentConversationCache.f362464a;
        int r113 = va9.a.f553982a;
        int r114 = ga9.a.d("office_doc_conversation_cache_expiration_seconds", AnnouncementViewModel.HOUR_DURATION);
        r103.label = 1;
        r105 = r112.i(r100, r101, r114, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeChatConversationCachePromotionStore$readCachedConversationId$1(this, r102);
        goto L8
    }

    public final void c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "localConversationId");
        Intrinsics.checkNotNullParameter(r101, "resourceId");
        AccountService r103 = AccountService.f365697a;
        String r104 = r103.getUserId();
        String r105 = r103.getSecUserId();
        if (StringsKt.isBlank(r104) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r105) == false) goto L7;
        return;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L14;
        if (r102 == true) goto L15;
        Object r106 = OfficeConversationCachePromotionTracker.f362454a;
        OfficeConversationCachePromotionTracker.c(r100, r104, r105, r101);
        d();
        com.larus.office.plugins.inputv2.coordinator.runtime.conversation.a r107 = new com.larus.office.plugins.inputv2.coordinator.runtime.conversation.a(this, r100, r101);
        this.f362809e = new b(r100, r107);
        com.larus.im.d.c().registerConversationChangeListener(r100, r107);
        return;
    L15:
        return;
    }
}
