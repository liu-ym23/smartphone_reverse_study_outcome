package com.larus.ugc.feed.impl.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CommunityCreateEventFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateEventAbility;", "<init>", "()V", "mainAbility", "Lcom/larus/ugc/feed/api/ability/IKMPCommunityCreateAbility;", "bindMainAbility", "", "ability", "onTabEnter", "previousPage", "", "enterMethod", "onTabLeave", "leaveMethod", "onCreationPublished", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "onNewIntent", "data", "Lcom/larus/ugc/feed/api/ability/BundleDataKmp;", "onFabDowngradeChanged", GearStrategyConsts.EV_DOWNGRADE_TYPE, "", "onCrossPageEvent", "event", "Lcom/larus/ugc/feed/api/ability/CrossPageEventKmp;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityCreateEventFeature extends ComponentFeature implements g0a.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile g0a.f f374561h;

    public static final class a {
    }

    static {
    }

    public CommunityCreateEventFeature() {
    }

    @Override // g0a.b
    public final void Sd(boolean r100) {
        c0.f348199b.d("CommunityCreateEventFeature", "onFabDowngradeChanged: " + r100);
        g0a.f r101 = this.f374561h;
        if (r101 == null) goto L6;
        r101.vi(r100);
        return;
    }

    @Override // g0a.b
    public final void da(String r100) {
        Intrinsics.checkNotNullParameter(r100, "leaveMethod");
        c0.f348199b.d("CommunityCreateEventFeature", "onTabLeave: method=".concat(r100));
        g0a.f r101 = this.f374561h;
        if (r101 == null) goto L6;
        r101.da(r100);
        return;
    }

    @Override // g0a.b
    public final void mk(UserCreationKmp r100) {
        Intrinsics.checkNotNullParameter(r100, "creation");
        c0.f348199b.d("CommunityCreateEventFeature", "onCreationPublished: id=" + r100.getCreationId());
        g0a.f r101 = this.f374561h;
        if (r101 == null) goto L6;
        r101.gk(r100);
        return;
    }

    @Override // g0a.b
    public final void wK(g0a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c0 r101 = c0.f348199b;
        StringBuilder r102 = new StringBuilder("onNewIntent: hasUserCreation=");
        if (r100.f479505d == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r101.d("CommunityCreateEventFeature", r102.toString());
        UserCreationKmp r104 = r100.f479505d;
        if (r104 == null) goto L12;
        g0a.f r105 = this.f374561h;
        if (r105 == null) goto L13;
        r105.gk(r104);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // g0a.b
    public final void nI(String r100, String r101) {
        c0.f348199b.d("CommunityCreateEventFeature", "onTabEnter: prev=" + r100 + " method=" + r101);
        g0a.f r102 = this.f374561h;
        if (r102 == null) goto L6;
        r102.ev();
        return;
    }
}
