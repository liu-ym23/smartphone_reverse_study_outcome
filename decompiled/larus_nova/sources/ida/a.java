package ida;

import android.view.View;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import hda.c1;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements k5<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f489404a = null;

    static {
        f489404a = new a();
    }

    public a() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r100, com.obric.assistant.cocreationreview.a r101) {
        u r102 = (u) r101;
        Intrinsics.checkNotNullParameter(r100, "buildContext");
        Intrinsics.checkNotNullParameter(r102, "record");
        String r103 = c1.c(r102.f489439g);
        if (r103 != null) goto L5;
        View r104 = new View(r100.getContext());
        r104.setVisibility(8);
        return r104;
    L5:
        e1 r105 = e1.a(r102.f489445m, r103, r103, r103, null, 1044455);
        int r106 = hda.c.f484640a;
        int r107 = c.f489407a.f387362e;
        return hda.c.a(r100, r105);
    }
}
