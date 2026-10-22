package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.window.shop.eventcard.windowability.WindowAnchorAbility;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTabCardListOperationPlugin extends ECWindowJsbPlugin {
    public static final /* synthetic */ int f = 0;
    public final ECWindowViewModel b;
    public final String c;
    public final Function1<WindowAnchorAbility, Unit> d;
    public final Function1<gp3.a, Unit> e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c[]{new c("ecom.window.tab.mix_card_insert", new ECWindowTabCardListOperationPlugin$createJsbActions$1(this)), new c("ecom.window.tab.mix_card_remove", new ECWindowTabCardListOperationPlugin$createJsbActions$2(this))});
    }

    public final boolean h(JSONObject r4) {
        if (ECWindowJsbPlugin.d(r4, "sec_author_id", this.b.getShopParam().getSecAuthorId(), false) == true) goto L5;
        return false;
    L5:
        if (ECWindowJsbPlugin.d(r4, "category_id", this.c, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowTabCardListOperationPlugin(ECWindowViewModel r2, String r3, Function1<? super WindowAnchorAbility, Unit> r4, Function1<? super gp3.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "categoryId");
        Intrinsics.checkNotNullParameter(r4, "insertPerformer");
        Intrinsics.checkNotNullParameter(r5, "removePerformer");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
