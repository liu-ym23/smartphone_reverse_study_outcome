package com.bytedance.ee.bear.bitable.homepage.badge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/bitable/homepage/badge/IFeedInboxBadgeManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BitableTabBadgeHandler$badgeManager$2 extends Lambda implements Function0<d> {
    public static final BitableTabBadgeHandler$badgeManager$2 INSTANCE = null;

    static {
        INSTANCE = new BitableTabBadgeHandler$badgeManager$2();
    }

    public BitableTabBadgeHandler$badgeManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d invoke() {
        int r100 = com.bytedance.ee.bear.bitable.core.usercomponent.b.f210588a;
        if (com.bytedance.ee.bear.bitable.c.v() == false) goto L6;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.a().Y1();
    L6:
        return new a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d invoke() {
        return invoke();
    }
}
