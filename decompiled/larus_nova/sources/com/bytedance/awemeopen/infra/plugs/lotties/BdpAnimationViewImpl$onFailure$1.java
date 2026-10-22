package com.bytedance.awemeopen.infra.plugs.lotties;

import android.text.TextUtils;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BdpAnimationViewImpl$onFailure$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BdpAnimationViewImpl this$0;

    public BdpAnimationViewImpl$onFailure$1(BdpAnimationViewImpl r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        BdpAnimationViewImpl r101 = this.this$0;
        int r102 = BdpAnimationViewImpl.f198863f;
        Object r103 = r101.f198864a;
        if (r103 != null) goto L5;
    L12:
        this.this$0.getConfig();
        throw null;
    L5:
        if ((r103 instanceof Integer) == false) goto L7;
        r101.setImageResource(((Number) r103).intValue());
        goto L12
    L7:
        if ((r103 instanceof String) == false) goto L12;
        if (TextUtils.isEmpty((CharSequence) r103) == true) goto L12;
        l64.b r104 = new l64.b();
        r104.f507666a = (String) r103;
        r104.f507670e = new e();
        r104.f507669d = r101;
        int r105 = j64.b.f497514a;
        ((AoImageService) j64.b.a(AoImageService.class)).Q0(r101.getContext(), r104);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
