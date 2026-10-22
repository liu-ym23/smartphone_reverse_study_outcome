package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.pb.basic.v1.ImageBaseAttribute;
import com.bytedance.lark.pb.basic.v1.ImageCropType;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.movable.attatchment.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Function2<String, Float, m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f420147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Map<String, ImageSetV2>> f420148b = null;

    public d() {
    }

    static {
        f420147a = new d();
        f420148b = new ArrayList();
    }

    public final m a(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        Iterator<T> r102 = f420148b.iterator();
    L4:
        if (r102.hasNext() == false) goto L51;
        Map r103 = (Map) r102.next();
        if (r103.containsKey(r100) == false) goto L4;
        ImageSetV2 r104 = (ImageSetV2) r103.get(r100);
        ImageBaseAttribute r105 = null;
        if (r104 == null) goto L10;
        List<ImageSetV2.ImageAttribute> r106 = r104.images;
    L11:
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (((ImageSetV2.ImageAttribute) r108).type != ImageCropType.ORIGIN) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L14;
    L22:
        ImageSetV2.ImageAttribute r110 = (ImageSetV2.ImageAttribute) r108;
        if (r110 == null) goto L26;
        ImageBaseAttribute r111 = r110.attribute;
        if (r111 == null) goto L26;
    L33:
        Integer r112 = r111.width;
        if (r112 == null) goto L4;
        int r113 = r112.intValue();
        Integer r114 = r111.height;
        if (r114 == null) goto L4;
        int r115 = r114.intValue();
        if (r113 <= 0) goto L4;
        if (r115 <= 0) goto L4;
        if (r101 <= 0.0f) goto L49;
        float r116 = r113;
        if (r116 <= r101) goto L49;
        return new m(r101, r115 * (r101 / r116));
    L49:
        return new m(r113, r115);
    L18:
        r109 = false;
        goto L19
    L21:
        r108 = null;
    L26:
        if (r106 == null) goto L30;
        ImageSetV2.ImageAttribute r117 = (ImageSetV2.ImageAttribute) CollectionsKt.firstOrNull(r106);
        if (r117 == null) goto L30;
        r105 = r117.attribute;
    L30:
        if (r105 == null) goto L4;
        r111 = r105;
        goto L33
    L10:
        r106 = null;
        goto L11
    L51:
        return new m(70.0f, 40.0f);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ m invoke(String r100, Float r101) {
        return a(r100, r101.floatValue());
    }
}
