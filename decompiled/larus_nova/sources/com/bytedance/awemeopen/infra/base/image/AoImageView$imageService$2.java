package com.bytedance.awemeopen.infra.base.image;

import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/awemeopen/servicesapi/image/AoImageService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AoImageView$imageService$2 extends Lambda implements Function0<AoImageService> {
    public static final AoImageView$imageService$2 INSTANCE = null;

    static {
        INSTANCE = new AoImageView$imageService$2();
    }

    public AoImageView$imageService$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AoImageService invoke() {
        int r100 = j64.b.f497514a;
        IBdpService r101 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r101);
        return (AoImageService) r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AoImageService invoke() {
        return invoke();
    }
}
