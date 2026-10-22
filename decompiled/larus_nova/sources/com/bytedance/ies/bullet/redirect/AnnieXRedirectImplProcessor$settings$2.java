package com.bytedance.ies.bullet.redirect;

import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXRedirectImplProcessor$settings$2 extends Lambda implements Function0<IBulletSettings> {
    public static final AnnieXRedirectImplProcessor$settings$2 INSTANCE = null;

    static {
        INSTANCE = new AnnieXRedirectImplProcessor$settings$2();
    }

    public AnnieXRedirectImplProcessor$settings$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IBulletSettings invoke() {
        return (IBulletSettings) g37.a.c("Bullet").b(IBulletSettings.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IBulletSettings invoke() {
        return invoke();
    }
}
