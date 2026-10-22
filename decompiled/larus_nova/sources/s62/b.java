package s62;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540790a;

    public b(a r100) {
        this.f540790a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f540790a;
        boolean r102 = ((Boolean) r100).booleanValue();
        r101.f540781c = r102;
        if (r102 == false) goto L9;
        yo2.e r103 = r101.f540782d;
        if (r103 == null) goto L15;
        View r104 = r103.e();
        if (r104 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        yo2.e r105 = r101.f540782d;
        if (r105 == null) goto L18;
        View r106 = r105.e();
        if (r106 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r106);
        return;
    L19:
        return;
    }
}
