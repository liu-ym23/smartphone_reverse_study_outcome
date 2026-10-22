package com.ss.android.lark.coremdbiz.facade.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.ImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.widget.light.image.LKUILightTextImageLoader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public class r implements com.ss.android.lark.coremd.base.parse.g {
    public r() {
    }

    public static com.ss.android.lark.widget.span.v e(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LarkImageThemeData r101 = (LarkImageThemeData) LarkThemeExtend.f419998m.b(new LarkImagePlugin$prepareImageSpan$imageThemeData$1(r100));
        LarkImageExtend.a r102 = LarkImageExtend.f420017g;
        int r103 = ((Number) r102.b(new LarkImagePlugin$prepareImageSpan$nodeWidth$1(r100))).intValue();
        int r104 = ((Number) r102.b(new LarkImagePlugin$prepareImageSpan$nodeHeight$1(r100))).intValue();
        String r105 = (String) r102.b(new LarkImagePlugin$prepareImageSpan$fsUnit$1(r100));
        ByteString r106 = (ByteString) r102.b(new LarkImagePlugin$prepareImageSpan$crypto$1(r100));
        int r107 = ((Number) LarkContextExtend.f419979s.b(new LarkImagePlugin$prepareImageSpan$draftResourceSource$1(r100))).intValue();
        com.ss.android.lark.coremd.base.parse.a.b r108 = ((com.ss.android.lark.coremd.base.parse.a) r101.f419568e.getValue(r101, ImageThemeData.f419566f[1])).a(r100, r103, r104);
        com.ss.android.lark.widget.span.v.c r109 = new com.ss.android.lark.widget.span.v.c();
        Map<String, Object> r110 = LKUILightTextImageLoader.f446066a;
        com.ss.android.lark.widget.span.v.a r111 = LKUILightTextImageLoader.b();
        if (r111 == null) goto L5;
        r109.f448813j = r111;
    L5:
        r109.f448804a = r108.f419534a;
        r109.f448805b = r108.f419535b;
        r109.f448818o = r105;
        r109.f448817n = r106;
        r109.f448819p = r107;
        com.ss.android.lark.coremd.ext.c r112 = r101.f420054k;
        KProperty<Object>[] r113 = LarkImageThemeData.f420049l;
        ((Number) r112.getValue(r101, r113[4])).intValue();
        com.ss.android.lark.widget.span.v r114 = r109.a(r100.getContext(), ((v7b.l) r100.f419898d).f553559j);
        r114.f448708a = UIUtils.dp2px(r100.getContext(), r101.i());
        r114.f448710c = UIUtils.dp2px(r100.getContext(), r101.j());
        r114.f448711d = UIUtils.dp2px(r100.getContext(), r101.h());
        r114.f448709b = UIUtils.dp2px(r100.getContext(), ((Number) r101.f420052i.getValue(r101, r113[2])).floatValue());
        r114.f448797u = new q(r100, r114);
        Intrinsics.checkNotNull(r114);
        return r114;
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.l.class, new p());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.l.class, new o(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }
}
