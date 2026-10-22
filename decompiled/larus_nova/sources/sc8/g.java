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
public final /* synthetic */ class g implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f541400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f541401b;

    public /* synthetic */ g(List r100, b r101) {
        this.f541400a = r100;
        this.f541401b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        List r100 = this.f541400a;
        b r101 = this.f541401b;
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        BubbleBannerSourceListener r103 = (BubbleBannerSourceListener) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.e(r101);     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L4;
        FLogger.f375446a.w("BubbleBannerEventDispatcher", "dispatch show failed, bannerSource=" + r101.f541378a + ", promptId=" + r101.f541379b, r106);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        return Unit.INSTANCE;
    }
}
