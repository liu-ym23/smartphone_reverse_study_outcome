package sf8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f541740a;

    public /* synthetic */ j(String r100) {
        this.f541740a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f541740a;
        JSONObject r102 = (JSONObject) r100;
        Intrinsics.checkNotNullParameter(r102, "$this$mobDeepSearchEvent");
        r102.put("enter_method", r101);
        return Unit.INSTANCE;
    }
}
