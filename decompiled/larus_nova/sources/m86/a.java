package m86;

import com.bytedance.ies.xelement.pickview.LynxPickerViewColumn;
import com.bytedance.ies.xelement.pickview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import i86.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f512468a;

    public final void a() {
        int r100 = this.f512468a.getCurrentItem();
        LynxPickerViewColumn r101 = ((b) this.f512468a.f250315e).f488654a;
        int r102 = LynxPickerViewColumn.f250298e;
        Intrinsics.checkNotNullParameter(r101, "this$0");
        if (r101.f250301c == false) goto L6;
        m7a.a r103 = new m7a.a(r101.getSign(), "change");
        r103.a("value", Integer.valueOf(r100));
        r101.getLynxContext().getEventEmitter().sendCustomEvent(r103);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(WheelView r100) {
        this.f512468a = r100;
    }
}
