package qz1;

import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftLabelTextView f535219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f535220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f535221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f535222d;

    public b(GiftLabelTextView r100, Ref.LongRef r101, String r102, String r103) {
        this.f535219a = r100;
        this.f535220b = r101;
        this.f535221c = r102;
        this.f535222d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.LongRef r102 = this.f535220b;
        long r103 = r102.element;
        if (r103 > 0) goto L7;
        GiftLabelTextView r104 = this.f535219a;
        String r105 = this.f535221c;
        String r106 = this.f535222d;
        int r107 = GiftLabelTextView.f126642c;
        r104.y(r103, r105, r106);
        Disposable r108 = this.f535219a.f126643a;
        if (r108 == null) goto L9;
        r108.dispose();
        return;
    L9:
        return;
    L7:
        long r109 = r103 - u0.f91000g.f91006a;
        r102.element = r109;
        GiftLabelTextView r110 = this.f535219a;
        String r111 = this.f535221c;
        String r112 = this.f535222d;
        int r113 = GiftLabelTextView.f126642c;
        r110.y(r109, r111, r112);
    }
}
