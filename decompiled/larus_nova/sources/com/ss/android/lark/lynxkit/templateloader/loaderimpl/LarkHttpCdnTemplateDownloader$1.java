package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/larksuite/framework/http/client/IHttpClient;", "kotlin.jvm.PlatformType", "config", "Lcom/ss/android/lark/lynxkit/templateloader/loaderimpl/CdnTemplateLoaderConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class LarkHttpCdnTemplateDownloader$1 extends Lambda implements Function1<f, x18.b> {
    public static final LarkHttpCdnTemplateDownloader$1 INSTANCE = null;

    static {
        INSTANCE = new LarkHttpCdnTemplateDownloader$1();
    }

    public LarkHttpCdnTemplateDownloader$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final x18.b invoke2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        x18.b.a r101 = new x18.b.a();
        long r102 = r100.f431554f;
        TimeUnit r103 = TimeUnit.MILLISECONDS;
        r101.f562137d = r102;
        r101.f562138e = r103;
        int r104 = r100.f431555g;
        r101.f562139f = r104;
        r101.f562140g = r103;
        r101.f562141h = r104;
        r101.f562142i = r103;
        return new x18.d(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ x18.b invoke(f r100) {
        return invoke2(r100);
    }
}
