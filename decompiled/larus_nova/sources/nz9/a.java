package nz9;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.bmhome.view.ChatConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f521554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f521555b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f521554a.getViewTreeObserver().removeOnPreDrawListener(this);
        Map<String, Boolean> r100 = b.f521559d;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        if (Intrinsics.areEqual(r101.get(this.f521555b), Boolean.FALSE) == false) goto L14;
        r100.put(this.f521555b, Boolean.TRUE);
        b r102 = b.f521556a;
        String r103 = this.f521555b;
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L14;
        b.e(r103, "0", null);
        goto L14
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
    L14:
        return true;
    }

    public a(ChatConstraintLayout r100) {
        this.f521554a = r100;
        this.f521555b = "creation_page/first_frame";
    }
}
