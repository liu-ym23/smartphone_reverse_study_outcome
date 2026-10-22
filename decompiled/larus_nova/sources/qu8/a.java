package qu8;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f534847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f534848b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f534847a.getViewTreeObserver().removeOnPreDrawListener(this);
        Map<String, Boolean> r100 = b.f534850b;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        if (Intrinsics.areEqual(r101.get(this.f534848b), Boolean.FALSE) == false) goto L14;
        r100.put(this.f534848b, Boolean.TRUE);
        String r102 = b.f534849a;
        String r103 = this.f534848b;
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L14;
        b.d(r103, 0);
        goto L14
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
    L14:
        return true;
    }

    public a(ConstraintLayout r100, String r101) {
        this.f534847a = r100;
        this.f534848b = r101;
    }
}
