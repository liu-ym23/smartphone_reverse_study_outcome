package jh3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.l;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements s83.f {
    public i() {
    }

    @Override // s83.f
    public final void a(Context r2, String r3, String r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "videoId");
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
    }

    @Override // s83.f
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "awemeId");
    }

    @Override // s83.f
    public final void c(Context r2, List r3, String r4, String r5, ViewGroup r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "awemeIds");
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "searchParams");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "exitCallback");
    }

    @Override // s83.f
    public final void d(l r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    @Override // s83.f
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
    }

    @Override // s83.f
    public final void f(ECVideoPlayerView r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
    }

    @Override // s83.f
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
    }

    @Override // s83.f
    public final void getDuration(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoId");
    }

    @Override // s83.f
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionsId");
    }

    @Override // s83.f
    public final void i() {
    }

    @Override // s83.f
    public final void j() {
    }

    @Override // s83.f
    public final void k() {
    }

    @Override // s83.f
    public final void m(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "awemeId");
    }

    @Override // s83.f
    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
    }

    @Override // s83.f
    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "awemeId");
    }

    @Override // s83.f
    public final void p(String r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
    }

    @Override // s83.f
    public final void q(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }

    @Override // s83.f
    public final void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "awemeId");
    }

    @Override // s83.f
    public final Observable<Boolean> l(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "idList");
        return Observable.just(Boolean.FALSE);
    }
}
