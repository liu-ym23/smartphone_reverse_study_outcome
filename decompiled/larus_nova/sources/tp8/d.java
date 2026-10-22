package tp8;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.inputarea.InputAreaBlockComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class d implements ss8.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputAreaBlockComponent f547055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hk9.a f547056b;

    public /* synthetic */ d(InputAreaBlockComponent r100, hk9.a r101) {
        this.f547055a = r100;
        this.f547056b = r101;
    }

    public final hk9.a a(ViewGroup r100) {
        InputAreaBlockComponent r101 = this.f547055a;
        hk9.a r102 = this.f547056b;
        int r103 = InputAreaBlockComponent.f311792u;
        Intrinsics.checkNotNullParameter(r100, "parent");
        r101.getClass();
        ViewParent r104 = r102.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L5;
        ViewGroup r105 = (ViewGroup) r104;
    L6:
        if (r105 == null) goto L8;
        r105.removeView(r102);
    L8:
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r102;
    L5:
        r105 = null;
        goto L6
    }
}
