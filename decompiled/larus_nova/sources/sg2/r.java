package sg2;

import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class r implements Function1<Fragment, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment[] f541812a;

    public r(Fragment[] r100) {
        this.f541812a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Fragment r100) {
        Fragment[] r101 = this.f541812a;
        r101[0] = r100;
        return null;
    }
}
