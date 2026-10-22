package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FeedbackModel {
    public Function1<? super FeedbackData.Item, Unit> a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public Function0<Unit> e;
    public final List<a> f;
    public final List<a> g;
    public final boolean h;
    public final String i;
    public final boolean j;
    public final String k;

    public static final class a {
        public FeedbackData.Item a;
        public final String b;
        public final String c;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "icon");
            Intrinsics.checkNotNullParameter(r3, "title");
            this.b = r2;
            this.c = r3;
        }
    }

    public FeedbackModel(List<a> r2, List<a> r3, boolean r4, String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "pageOneList");
        Intrinsics.checkNotNullParameter(r3, "pageTwoList");
        Intrinsics.checkNotNullParameter(r5, "moreText");
        Intrinsics.checkNotNullParameter(r7, "toastMsg");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.a = FeedbackModel$onClickItem$1.INSTANCE;
        this.b = FeedbackModel$onClickClose$1.INSTANCE;
        this.c = FeedbackModel$onClickFindSimilar$1.INSTANCE;
        this.d = FeedbackModel$onClickBack$1.INSTANCE;
        this.e = FeedbackModel$onClickMore$1.INSTANCE;
    }
}
