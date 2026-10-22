package t19;

import android.content.Context;
import com.bytedance.crash.dumper.Scraps;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f544188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f544189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f544190c;

    public /* synthetic */ j(String r100, Context r101, Integer r102) {
        this.f544188a = r100;
        this.f544189b = r101;
        this.f544190c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f544188a;
        Context r101 = this.f544189b;
        Integer r102 = this.f544190c;
        s r103 = s.f544207a;
        r103.a();
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
        TimeUnit r105 = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(r105, Scraps.INNER_UNIT);
        int r106 = (int) r105.toMillis(r104);
    L6:
        Object r107 = ObricToastHelperDelegate.f387851b.createToastHolder(r101);
        if ((r107 instanceof u19.f) == false) goto L9;
        u19.f r108 = (u19.f) r107;
    L10:
        if (r108 != null) goto L12;
        r108 = new u19.i();
    L12:
        r108.setAutoDisappear(true);
        r108.setDuration(r106);
        r108.icon(0);
        r108.text(r100);
        r108.setYOffsetPx(null);
        r103.r(r108);
        FLogger.f375446a.d("ToastLogger", "toast utils show, method name: showWithForceToast");
        r108.show(r101, false);
        return;
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }
}
