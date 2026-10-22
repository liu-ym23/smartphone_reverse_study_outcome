package un8;

import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardView;
import com.larus.im.bean.message.block.Status;
import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCardView f550862a;

    public /* synthetic */ e(TaskCardView r100) {
        this.f550862a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskCardView r100 = this.f550862a;
        int r101 = TaskCardView.f309817d;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        a r103 = r100.f309819b;     // Catch: Throwable -> L27
        TaskCardBlock r104 = r103.f550855b;     // Catch: Throwable -> L27
        Long r105 = null;
        if (r104 == null) goto L6;
        Long r106 = r104.startTimestamp;     // Catch: Throwable -> L27
    L7:
        if (r104 == null) goto L10;
        r105 = r104.estimatedDuration;     // Catch: Throwable -> L27
    L10:
        if (r103.f550854a == true) goto L12;
    L24:
        r100.f309819b.f550856c = false;     // Catch: Throwable -> L27
    L25:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L35;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r108);
        return;
    L35:
        return;
    L12:
        if (r104 == null) goto L19;
        Integer r109 = r104.status;     // Catch: Throwable -> L27
        int r110 = Status.STATUS_PROCESSING.getValue();     // Catch: Throwable -> L27
        if (r109 == null) goto L19;
        if (r109.intValue() != r110) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L24;
        if (r106 == null) goto L24;
        if (r105 == null) goto L24;
        r100.e(r100.f309819b.f550855b);     // Catch: Throwable -> L27
        r100.f309819b.f550856c = true;     // Catch: Throwable -> L27
        r100.postDelayed(new e(r100), 20000);     // Catch: Throwable -> L27
    L19:
        r111 = false;
        goto L20
    L6:
        r106 = null;
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
