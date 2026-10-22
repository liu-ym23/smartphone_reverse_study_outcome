package com.larksuite.component.card.utils;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class CardImageRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283940a = 0;

    public static final class a implements IMBizImageRenderInterceptor.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f283941a;

        @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor.a
        public final ImageView a() {
            return this.f283941a;
        }

        public a(ImageView r100) {
            this.f283941a = r100;
        }
    }

    static {
    }

    public static void a(com.suite.lark.platform.component.widgetrenderinterceptor.a r100, final Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clickBlock");
        r100.b(new CardImageRender$clickCardImage$1(r101));
        r100.a();
    }

    public static com.suite.lark.platform.component.widgetrenderinterceptor.a b(Context r100, ImageView r101, final ResourceCleanScene r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        a r103 = new a(r101);
        Intrinsics.checkNotNullParameter(r103, "func");
        Function0<kpc.a> r104 = new CardImageRender$createImageRender$2(r102);
        Intrinsics.checkNotNullParameter(r104, "data");
        kpc.a r105 = r104.invoke();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.suite.lark.platform.component.widgetrenderinterceptor.a r106 = new com.suite.lark.platform.component.widgetrenderinterceptor.a(r100);
        r106.f461190c = r105;
        r106.f461189b = r103;
        return r106;
    }

    public static void c(com.suite.lark.platform.component.widgetrenderinterceptor.a r100, final int r101, final int r102, final Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "renderBlock");
        r100.c(new CardImageRender$renderCardImage$1(r103, r101, r102));
        r100.d();
    }
}
