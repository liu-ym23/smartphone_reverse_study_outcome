package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.larus.im.j;
import com.larus.im.service.d0;
import com.larus.office.OfficeInputParam;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements d0<wc9.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeChatConversationCachePromotionStore f362828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f362829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f362830c;

    @Override // com.larus.im.service.z
    public final void c(Object r100) {
        Intrinsics.checkNotNullParameter((wc9.e) r100, "conversation");
    }

    @Override // com.larus.im.service.d0
    public final void a(wc9.e r100, wc9.e r101) {
        Intrinsics.checkNotNullParameter(r101, "new");
        OfficeChatConversationCachePromotionStore.b r102 = this.f362828a.f362809e;
        String r103 = null;
        if (r102 == null) goto L5;
        d0<wc9.e> r104 = r102.f362811b;
    L6:
        if (r104 != this) goto L22;
        if (r100 == null) goto L10;
        r103 = r100.f559198a;
    L10:
        if (Intrinsics.areEqual(r103, this.f362829b) == false) goto L23;
        Lazy r105 = j.f350569a;
        if (j.f(r101.f559198a) == true) goto L25;
        this.f362828a.d();
        OfficeInputParam r106 = this.f362828a.f362805a.invoke();
        if (r106 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r106.getResourceId(), this.f362830c) == true) goto L20;
        FLogger.f375446a.i("OfficeChatConversation", "资源已变化, 丢弃迟到的会话 promotion");
        return;
    L20:
        this.f362828a.f362807c.invoke(r101);
        FLogger.f375446a.i("OfficeChatConversation", "本地会话 promotion 已同步, local=" + OfficeChatConversationCachePromotionStore.a(this.f362828a, this.f362829b) + ", remote=" + OfficeChatConversationCachePromotionStore.a(this.f362828a, r101.f559198a));
        return;
    L25:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public a(OfficeChatConversationCachePromotionStore r100, String r101, String r102) {
        this.f362828a = r100;
        this.f362829b = r101;
        this.f362830c = r102;
    }
}
