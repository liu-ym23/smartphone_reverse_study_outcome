package m3;

import com.bytedance.ai.bridge.method.bottomsheet.ShowBottomSheetMethod;
import com.bytedance.ai.utils.g;
import f3.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f511696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShowBottomSheetMethod f511697b;

    public /* synthetic */ e(h r100, ShowBottomSheetMethod r101) {
        this.f511696a = r100;
        this.f511697b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        h r101 = this.f511696a;
        ShowBottomSheetMethod r102 = this.f511697b;
        com.bytedance.ai.bridge.method.bottomsheet.a r103 = (com.bytedance.ai.bridge.method.bottomsheet.a) r100;
        Regex r104 = ShowBottomSheetMethod.f35362b;
        Intrinsics.checkNotNullParameter(r103, "result");
        g.f37637a.i("AISDK_JSB_ShowBottomSheetMethod", "call success, action=" + r103.f35369a + ", role=" + r103.f35370b + ", source=" + r103.f35371c);
        r102.getClass();
        h.a.b(r101, ShowBottomSheetMethod.e(r103));
        return Unit.INSTANCE;
    }
}
