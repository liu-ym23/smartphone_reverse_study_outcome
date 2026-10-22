package com.bytedance.ee.bear.middleground.comment.share;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f232182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Map<String, SharePermissionViewModel.b>, Unit> f232183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, SharePermissionViewModel.b> f232184c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(SharePermissionViewModel r100, Function1<? super Map<String, SharePermissionViewModel.b>, Unit> r101, Map<String, SharePermissionViewModel.b> r102) {
        this.f232182a = r100;
        this.f232183b = r101;
        this.f232184c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.e(this.f232182a.f232154d, "fetchUserPermissions: ", r101, false);
        this.f232183b.invoke(this.f232184c);
    }
}
