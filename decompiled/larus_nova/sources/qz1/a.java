package qz1;

import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftLabelTextView f535217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f535218b;

    public a(GiftLabelTextView r100, Ref.LongRef r101) {
        this.f535217a = r100;
        this.f535218b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.LongRef r102 = this.f535218b;
        long r103 = r102.element;
        if (r103 > 0) goto L10;
        GiftLabelTextView r104 = this.f535217a;
        int r105 = GiftLabelTextView.f126642c;
        r104.x(r103);
        Function0<Unit> r106 = this.f535217a.f126644b;
        if (r106 == null) goto L7;
        Unit r107 = r106.invoke();
    L7:
        Disposable r108 = this.f535217a.f126643a;
        if (r108 == null) goto L12;
        r108.dispose();
        return;
    L12:
        return;
    L10:
        long r109 = r103 - u0.f91000g.f91006a;
        r102.element = r109;
        GiftLabelTextView r110 = this.f535217a;
        int r111 = GiftLabelTextView.f126642c;
        r110.x(r109);
    }
}
