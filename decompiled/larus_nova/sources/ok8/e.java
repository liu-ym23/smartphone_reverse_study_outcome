package ok8;

import com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.view.DeepResearchProgressCard;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import com.larus.im.bean.message.block.Status;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepResearchProgressCard f523705a;

    public /* synthetic */ e(DeepResearchProgressCard r100) {
        this.f523705a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepResearchProgressCard r100 = this.f523705a;
        int r101 = DeepResearchProgressCard.f309044c;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L28
        ResearchProcessBlock r103 = r100.f309045a.f523698b;     // Catch: Throwable -> L28
        Integer r104 = null;
        if (r103 == null) goto L6;
        Integer r105 = r103.getStartTimestamp();     // Catch: Throwable -> L28
    L7:
        ResearchProcessBlock r106 = r100.f309045a.f523698b;     // Catch: Throwable -> L28
        if (r106 == null) goto L10;
        r104 = r106.getEstimatedDuration();     // Catch: Throwable -> L28
    L10:
        a r107 = r100.f309045a;     // Catch: Throwable -> L28
        if (r107.f523697a == false) goto L25;
        ResearchProcessBlock r108 = r107.f523698b;     // Catch: Throwable -> L28
        if (r108 == null) goto L20;
        Integer r109 = r108.getStatus();     // Catch: Throwable -> L28
        int r110 = Status.STATUS_PROCESSING.getValue();     // Catch: Throwable -> L28
        if (r109 == null) goto L20;
        if (r109.intValue() != r110) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L25;
        if (r105 == null) goto L25;
        if (r104 == null) goto L25;
        r100.T5(r100.f309045a.f523698b);     // Catch: Throwable -> L28
        r100.f309045a.f523699c = true;     // Catch: Throwable -> L28
        r100.postDelayed(new e(r100), 20000);     // Catch: Throwable -> L28
    L26:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L36;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r113);
        return;
    L36:
        return;
    L20:
        r111 = false;
    L25:
        r100.f309045a.f523699c = false;     // Catch: Throwable -> L28
        goto L26
    L6:
        r105 = null;
    L28:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }
}
