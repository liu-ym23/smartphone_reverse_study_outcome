package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.View;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "id", "", "ascending", "", "title", "", "invoke", "(JLjava/lang/Boolean;Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
final class ECWindowTabPresenterDeprecated$onSortBarInitialized$1 extends Lambda implements Function3<Long, Boolean, String, Unit> {
    final /* synthetic */ ECWindowTabPresenterDeprecated this$0;

    public ECWindowTabPresenterDeprecated$onSortBarInitialized$1(ECWindowTabPresenterDeprecated r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(long r7, Boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        int r0 = WindowTabEventReporter.a;
        ECWindowTabPresenterDeprecated r1 = this.this$0;
        int r2 = ECWindowTabPresenterDeprecated.x;
        View r3 = r1.a0();
        ECWindowViewModel r4 = this.this$0.j0();
        ECWindowParam r5 = this.this$0.j0().getShopParam();
        this.this$0.getClass();
        if (r9 != null) goto L6;
        String r6 = r10;
    L10:
        WindowTabEventReporter.d(r3, r4, r5, r6);
        dm.a.a("WINDOW").i("[sortBarClickCallback]sortType:" + r10);
        dm.a.a("WINDOW").i("[sortBarClickCallback]secAuthorId:" + this.this$0.j0().getShopParam().getSecAuthorId());
        ECWindowTabPresenterDeprecated r11 = this.this$0;
        Long r8 = Long.valueOf(r7);
        r11.getClass();
        r11.n0(FooterStatus.NOTHING);
        r11.k0().refreshSubTabs(r8, r9, null, r11.i0().g, null);
        if (r7 != 2) goto L14;
        boolean r12 = com.bytedance.android.ec.window.base.shop.j.a;
        com.bytedance.android.ec.window.base.shop.j.b("window_sort_prefer_newer_product", PostActionType.DO);
        return;
    L14:
        return;
    L6:
        if (r9.booleanValue() == false) goto L8;
        String r13 = "升序";
    L9:
        r6 = r10 + r13;
        goto L10
    L8:
        r13 = "降序";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        invoke(((Number) r3).longValue(), (Boolean) r4, (String) r5);
        return Unit.INSTANCE;
    }
}
