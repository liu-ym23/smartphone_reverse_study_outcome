package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.view.View;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends com.ss.android.lark.movable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3<View, String, Map<String, ImageSetV2>, Boolean> f420150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, ImageSetV2> f420151b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function3<? super View, ? super String, ? super Map<String, ImageSetV2>, Boolean> r100, Map<String, ImageSetV2> r101) {
        this.f420150a = r100;
        this.f420151b = r101;
    }

    @Override // com.ss.android.lark.movable.a, com.ss.android.lark.movable.b
    public final boolean c(View r100, String r101, com.ss.android.lark.movable.attatchment.b r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "imageKey");
        Intrinsics.checkNotNullParameter(r102, "attachmentInfo");
        Function3<View, String, Map<String, ImageSetV2>, Boolean> r103 = this.f420150a;
        if (r103 != null) goto L5;
        return false;
    L5:
        if (r103.invoke(r100, r101, this.f420151b).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
