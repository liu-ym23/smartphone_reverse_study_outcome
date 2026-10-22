package na1;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.entrance.c;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PublishSubject<IRotateEntrance> f518432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PublishSubject f518433b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f518434c = null;

    public a() {
    }

    static {
        f518434c = new a();
        PublishSubject<IRotateEntrance> r100 = PublishSubject.create();
        f518432a = r100;
        f518433b = r100;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.b
    public final void b() {
        c r100 = c.f99124b;
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        SimpleAlogArgsBuilder r101 = new SimpleAlogArgsBuilder();
        r101.d("EntranceVisibleNotify");
        r101.c("notifyVisibilityChange by entrance [" + r100 + ']');
        f81.a.a(r101.b());
        f518432a.onNext(r100);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.b
    public final PublishSubject a() {
        return f518433b;
    }
}
