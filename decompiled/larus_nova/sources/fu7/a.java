package fu7;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f478905a;

    public /* synthetic */ a(String r100) {
        this.f478905a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f478905a;
        i r102 = (i) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        r102.e(r101);
        return r102;
    }
}
