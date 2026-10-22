package com.bytedance.android.window.shop.home.tabcard;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.window.base.widget.ECWindowRoundedLinearLayout;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.tab.tabplugin.f;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHybridTabCardGroup {
    public static final /* synthetic */ int j = 0;
    public final Lazy a;
    public final f b;
    public final Function1<k, Unit> c;
    public k d;
    public final Lazy e;
    public final Fragment f;
    public final ECHybridListContainer g;
    public final ECWindowHybridTabCardViewModel h;
    public final ECWindowViewModel i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/tabcard/WindowHybridTabCardGroup$WindowLynxHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WindowLynxHolder extends ECLynxCardHolder {
        public WindowLynxHolder(ECWindowRoundedLinearLayout r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "layout");
            Intrinsics.checkNotNullParameter(r15, "sceneId");
            super(r14, r15, null, null, null, null, null, null, false, false, 2044);
        }
    }

    public final class WindowNotifyShakePlugin extends ECWindowJsbPlugin {
        public final /* synthetic */ WindowHybridTabCardGroup b;

        @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
        public final List<c> c() {
            return CollectionsKt.listOf(new c("ecom.window.forward_event", new WindowHybridTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1(this)));
        }

        public WindowNotifyShakePlugin(WindowHybridTabCardGroup r1) {
            this.b = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public WindowHybridTabCardGroup(Fragment r2, ECHybridListContainer r3, ECWindowHybridTabCardViewModel r4, ECWindowViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "tabCardViewModel");
        Intrinsics.checkNotNullParameter(r5, "shopViewModel");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = LazyKt.lazy(WindowHybridTabCardGroup$sceneId$2.INSTANCE);
        this.b = new f();
        this.c = new WindowHybridTabCardGroup$receiver$1(this);
        this.e = LazyKt.lazy(new WindowHybridTabCardGroup$hybridListEngine$2(this));
    }
}
