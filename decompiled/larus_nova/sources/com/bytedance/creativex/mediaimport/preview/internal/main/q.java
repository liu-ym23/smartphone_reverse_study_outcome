package com.bytedance.creativex.mediaimport.preview.internal.main;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class q implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0.d f203582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f203583b;

    public /* synthetic */ q(m0.d r100, m0 r101) {
        this.f203582a = r100;
        this.f203583b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        m0.d r101 = this.f203582a;
        m0 r102 = this.f203583b;
        gi4.r.a r103 = (gi4.r.a) r100;
        Intrinsics.checkNotNullParameter(r103, "it");
        boolean r104 = r101.f203557b;
        int r105 = R.drawable.larus_tools_media_import_icon_media_multi_select_red;
        if (r104 == false) goto L5;
        int r106 = R.drawable.larus_tools_media_import_icon_media_multi_select_red;
    L15:
        r103.f481390e = r106;
        boolean r107 = r101.f203557b;
        if (r107 == true) goto L19;
        r105 = R.drawable.larus_tools_media_import_bg_image_select;
    L19:
        r103.f481391f = r105;
        r103.f481389d = r107;
        Function1<? super gi4.r.a, Unit> r108 = r101.f203562g;
        if (r108 == null) goto L23;
        r108.invoke(r103);
    L23:
        return Unit.INSTANCE;
    L5:
        Context r109 = null;
        if (r101.f203556a == false) goto L11;
        View r110 = r102.f203530h;
        if (r110 == null) goto L10;
        r109 = r110.getContext();
    L10:
        r106 = v19.c.b(R.attr.larus_tools_media_import_bg_image_selected, r109, R.drawable.larus_tools_media_import_bg_image_selected);
        goto L15
    L11:
        View r111 = r102.f203530h;
        if (r111 == null) goto L14;
        r109 = r111.getContext();
    L14:
        r106 = v19.c.b(R.attr.larus_flow_media_import_ic_media_selected, r109, R.drawable.larus_flow_media_import_ic_media_selected);
        goto L15
    }
}
