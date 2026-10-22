package com.obric.matrix.platform.sdk.ones.internal.config;

import android.app.KeyguardManager;
import bka.a;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SdkConfigManager$keyguardManager$2 extends Lambda implements Function0<KeyguardManager> {
    public static final SdkConfigManager$keyguardManager$2 INSTANCE = null;

    static {
        INSTANCE = new SdkConfigManager$keyguardManager$2();
    }

    public SdkConfigManager$keyguardManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KeyguardManager invoke() {
        a r100 = a.f19387a;
        Object r101 = null;
        if ((r101 instanceof KeyguardManager) == false) goto L5;
        KeyguardManager r102 = (KeyguardManager) null;
    L5:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KeyguardManager invoke() {
        return invoke();
    }
}
