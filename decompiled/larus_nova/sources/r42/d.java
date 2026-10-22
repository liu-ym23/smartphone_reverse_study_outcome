package r42;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.m f536036a;

    public d(com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.g r100) {
        this.f536036a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.ss.ugc.live.sdk.msg.utils.g r101 = (com.ss.ugc.live.sdk.msg.utils.g) r100;
        if ((r101 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L6;
        List<? extends tlc.d> r102 = (List) ((com.ss.ugc.live.sdk.msg.utils.g.c) r101).f458479b;
        this.f536036a.a(r102);
        return;
    L6:
        if ((r101 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L10;
        Throwable r103 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r101).f458478b;
        this.f536036a.b(r103);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
