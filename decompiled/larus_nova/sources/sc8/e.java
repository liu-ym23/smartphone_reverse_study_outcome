package sc8;

import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f541394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f541395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f541396c;

    public /* synthetic */ e(List r100, b r101, a r102) {
        this.f541394a = r100;
        this.f541395b = r101;
        this.f541396c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        List r100 = this.f541394a;
        b r101 = this.f541395b;
        a r102 = this.f541396c;
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        BubbleBannerSourceListener r104 = (BubbleBannerSourceListener) r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        r104.h(r101, r102);     // Catch: Throwable -> L8
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L4;
        FLogger.f375446a.w("BubbleBannerEventDispatcher", "dispatch action result failed, bannerSource=" + r101.f541378a + ", promptId=" + r101.f541379b, r107);
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        return Unit.INSTANCE;
    }
}
