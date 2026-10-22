package p81;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleIndicatorTextSwitcher2 f528064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f528065b;

    public b(SimpleIndicatorTextSwitcher2 r100, Function1 r101) {
        this.f528064a = r100;
        this.f528065b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ArrayList<d> r102 = this.f528064a.f99156b;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L18;
        this.f528064a.setCurrentIndex(((int) r101.longValue()) % this.f528064a.f99156b.size());
        SimpleIndicatorTextSwitcher2 r104 = this.f528064a;
        d r105 = (d) ListProtector.get(r104.f99156b, r104.getCurrentIndex());
        if (r105 == null) goto L15;
        String r106 = r105.f528067a;
        if (r106 == null) goto L15;
    L16:
        r104.setText(r106);
        UtilityKotlinExtentionsKt.w(this.f528064a);
        this.f528065b.invoke(Integer.valueOf(this.f528064a.getCurrentIndex()));
        return;
    L15:
        r106 = "";
        goto L16
    L18:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
