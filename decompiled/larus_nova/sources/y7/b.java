package y7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.annie.debug.ui.DialogItem;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f566562a;

    @Override // y7.d
    public final String getTitle() {
        return "appInfo";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r100 = new LinkedList();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        o8.a r102 = com.bytedance.android.annie.ng.e.f39661a;     // Catch: Throwable -> L5
        r100.add(new DialogItem("appName", r102.f522306b, null, 4));     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        r100.add(new DialogItem("appId", String.valueOf(r102.f522305a), null, 4));     // Catch: Throwable -> L5
        r100.add(new DialogItem("deviceID", com.bytedance.android.annie.ng.g.b().f39658b.f522317b, null, 4));     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r100.add(new DialogItem("appVersion", r102.f522308d, null, 4))));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        r104.printStackTrace();
    L10:
        StringBuilder r105 = new StringBuilder();
        p r106 = p.f40070a;
        r105.append((int) r106.h(r106.e()));
        r105.append('*');
        Context r107 = this.f566562a;
        if ((r107 instanceof Activity) == false) goto L13;
        Activity r108 = (Activity) r107;
    L14:
        r105.append((int) r106.h(p.c(r108).heightPixels));
        r100.add(new DialogItem("屏幕尺寸(单位:dp)", r105.toString(), null, 4));
        Context r109 = this.f566562a;
        if ((r109 instanceof Activity) == false) goto L17;
        Activity r110 = (Activity) r109;
    L19:
        if (m.a(r110) == false) goto L21;
        String r111 = "横屏";
    L22:
        r100.add(new DialogItem("横竖屏状态", r111, null, 4));
        return r100;
    L21:
        r111 = "竖屏";
        goto L22
    L17:
        r110 = null;
        goto L19
    L13:
        r108 = null;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f566562a = r100;
    }
}
