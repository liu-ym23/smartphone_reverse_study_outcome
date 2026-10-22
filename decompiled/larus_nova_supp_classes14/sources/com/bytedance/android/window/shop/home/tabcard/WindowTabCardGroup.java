package com.bytedance.android.window.shop.home.tabcard;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.bytedance.android.window.shop.home.tab.tabplugin.f;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowTabCardGroup {
    public static final /* synthetic */ int h = 0;
    public final f a;
    public final Function1<Map<Integer, ? extends com.bytedance.android.window.shop.repository.tab.entity.f>, Unit> b;
    public final LinkedHashMap<Integer, Pair<com.bytedance.android.window.shop.repository.tab.entity.f, WindowLynxHolder>> c;
    public final Fragment d;
    public final LinearLayout e;
    public final ECWindowTabCardViewModel f;
    public final ECWindowViewModel g;

    public final class WindowNotifyShakePlugin extends ECWindowJsbPlugin {
        public final /* synthetic */ WindowTabCardGroup b;

        @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
        public final List<c> c() {
            return CollectionsKt.listOf(new c("ecom.window.forward_event", new WindowTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1(this)));
        }

        public WindowNotifyShakePlugin(WindowTabCardGroup r1) {
            this.b = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public WindowTabCardGroup(Fragment r2, LinearLayout r3, ECWindowTabCardViewModel r4, ECWindowViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "tabCardViewModel");
        Intrinsics.checkNotNullParameter(r5, "shopViewModel");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new f();
        this.b = new WindowTabCardGroup$receiver$1(this);
        this.c = new LinkedHashMap();
    }
}
