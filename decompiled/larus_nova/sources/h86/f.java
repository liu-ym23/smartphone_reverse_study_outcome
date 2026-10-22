package h86;

import com.bytedance.ies.xelement.picker.LynxPickerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.EventEmitter;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements f86.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f484220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xelement.picker.view.e f484221b;

    @Override // f86.d
    public final void onItemSelected(int r100) {
        ListProtector.set(this.f484221b.f250285d, this.f484220a, Integer.valueOf(r100));
        new ArrayList(this.f484221b.f250285d);
        f86.e r101 = this.f484221b.f250286e;
        if (r101 == null) goto L9;
        int r102 = this.f484220a;
        Integer r103 = Integer.valueOf(r100);
        LynxPickerView r104 = ((a86.i) r101).f2149a;
        int r105 = LynxPickerView.f250211u;
        Intrinsics.checkNotNullParameter(r104, "this$0");
        if (r104.f250230s == false) goto L8;
        EventEmitter r106 = r104.getLynxContext().getEventEmitter();
        m7a.a r107 = new m7a.a(r104.getSign(), "columnchange");
        r107.a("column", Integer.valueOf(r102));
        r107.a("value", r103);
        r106.sendCustomEvent(r107);
    L8:
        return;
    }

    public f(com.bytedance.ies.xelement.picker.view.e r100, int r101) {
        this.f484221b = r100;
        this.f484220a = r101;
    }
}
