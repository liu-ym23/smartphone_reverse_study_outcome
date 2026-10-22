package com.bytedance.awemeopen.infra.base.anim.lottie;

import com.bytedance.awemeopen.servicesapi.ui.AoAnimationService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AoAnim$aoAnimService$2 extends Lambda implements Function0<AoAnimationService> {
    public static final AoAnim$aoAnimService$2 INSTANCE = null;

    static {
        INSTANCE = new AoAnim$aoAnimService$2();
    }

    public AoAnim$aoAnimService$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AoAnimationService invoke() {
        int r100 = j64.b.f497514a;
        return (AoAnimationService) j64.b.a(AoAnimationService.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AoAnimationService invoke() {
        return invoke();
    }
}
