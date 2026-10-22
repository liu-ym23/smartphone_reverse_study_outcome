package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceBaseProductCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a<DTO, VO extends com.bytedance.android.shopping.store.hybridproduct.extension.d> {
        public final int a;
        public final Class<DTO> b;
        public final Function2<DTO, String, VO> c;
        public final Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder> d;

        public final int getType() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(int r2, Class<DTO> r3, Function2<? super DTO, ? super String, ? extends VO> r4, Function4<? super Fragment, ? super ViewGroup, ? super km.b, ? super HybridPageViewModel, ? extends HybridPageSliceBaseProductCardHolder> r5) {
            Intrinsics.checkNotNullParameter(r3, "dtoClazz");
            Intrinsics.checkNotNullParameter(r4, "transformer");
            Intrinsics.checkNotNullParameter(r5, "creator");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }
}
