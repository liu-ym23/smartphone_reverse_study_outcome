package r42;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.e f536033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f536034b;

    public static final class a implements vlc.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f536035a;

        public a(SingleEmitter r100) {
            this.f536035a = r100;
        }

        @Override // vlc.m
        public final void a(List<? extends tlc.d> r100) {
            Intrinsics.checkNotNullParameter(r100, "messages");
            SingleEmitter r101 = this.f536035a;
            int r102 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
            r101.onSuccess(new com.ss.ugc.live.sdk.msg.utils.g.c(r100));
        }

        @Override // vlc.m
        public final void b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f536035a.onError(r100);
        }
    }

    public c(vlc.e r100, String r101) {
        this.f536033a = r100;
        this.f536034b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<com.ss.ugc.live.sdk.msg.utils.g<List<tlc.d>, Throwable>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f536033a.G(new tlc.e(this.f536034b), new a(r100));
    }
}
