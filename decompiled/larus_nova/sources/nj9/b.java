package nj9;

import com.larus.livetutor.impl.repository.viewmodel.PageStateViewModel;
import com.larus.livetutor.impl.repository.viewmodel.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final String a(l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f356220a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return String.valueOf(r100.a());
    L12:
        return r100.a() + " - " + r100.f356220a;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean b(l0 r100) {
        if (r100 != null) goto L4;
    L18:
        return false;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        int r101 = ((a) r100).f519466c;
        if (r101 != 1070002) goto L8;
    L17:
        return true;
    L8:
        if (r101 == 1070006) goto L17;
        if (r101 == 1070007) goto L17;
        if (r101 == 1070008) goto L17;
        if (r101 == 1070005) goto L17;
        if (r101 != 1070009) goto L18;
        goto L17
    }

    public static final boolean c(l0 r100) {
        return Intrinsics.areEqual(r100, PageStateViewModel.RefreshStatus.SUCCESS.getPageChildState());
    }
}
