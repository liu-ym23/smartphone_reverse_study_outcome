package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.w;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class b implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f490970c;

    public /* synthetic */ b(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, boolean r102) {
        this.f490968a = r100;
        this.f490969b = r101;
        this.f490970c = r102;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r110, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r111, prc.f r112) {
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100 = this.f490968a;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101 = this.f490969b;
        boolean r102 = this.f490970c;
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "state");
        w r103 = r111.a();
        if (r100 != null) goto L10;
        if (r101 != null) goto L10;
        if (r102 == false) goto L7;
        float r104 = r103.a();
    L85:
        return Float.valueOf(r104);
    L7:
        r104 = r103.f490997a.nextFloat();
    L10:
        if (r101 != null) goto L40;
        if (r100 == null) goto L40;
        if (r102 == false) goto L29;
        Object r105 = r100.a(r110, r111, r112);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r105, "maxValOrArray");
        if ((r105 instanceof Number) == false) goto L18;
        return Float.valueOf(r103.a() * ((Number) r105).floatValue());
    L18:
        if ((r105 instanceof List) == false) goto L28;
        List r106 = (List) r105;
        List r107 = CollectionsKt.createListBuilder(r106.size());
    L21:
        if (r107.size() >= r106.size()) goto L24;
        float r108 = (float) Math.sqrt((-2) * ((float) Math.log(r103.f490997a.nextFloat())));
        double r109 = ((double) r103.f490997a.nextFloat()) * 6.283185307179586d;
        float r113 = 1;
        r107.add(Float.valueOf(((((float) Math.cos(r109)) * r108) + r113) * ((Number) ListProtector.get(r106, r107.size())).floatValue()));
        r107.add(Float.valueOf((r108 * ((float) Math.sin(r109))) + (r113 * ((Number) ListProtector.get(r106, r107.size())).floatValue())));
        goto L21
    L24:
        if (r107.size() <= r106.size()) goto L87;
        CollectionsKt.removeLast(r107);
    L87:
        return CollectionsKt.build(r107);
    L28:
        throw new IllegalStateException(("Can't use " + r105 + " as a random() parameter").toString());
    L29:
        Object r114 = r100.a(r110, r111, r112);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r114, "maxValOrArray");
        if ((r114 instanceof Number) == false) goto L33;
        return Float.valueOf(r103.f490997a.nextFloat() * ((Number) r114).floatValue());
    L33:
        if ((r114 instanceof List) == false) goto L39;
        List r115 = (List) r114;
        ArrayList r116 = new ArrayList(r115.size());
        int r117 = r115.size();
        int r118 = 0;
    L35:
        if (r118 >= r117) goto L89;
        Object r119 = ListProtector.get(r115, r118);
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.Number");
        r116.add(Float.valueOf(((Number) r119).floatValue() * r103.f490997a.nextFloat()));
        r118 = r118 + 1;
        goto L35
    L89:
        return r116;
    L39:
        throw new IllegalStateException(("Can't use " + r114 + " as a random() parameter").toString());
    L40:
        if (r101 == null) goto L80;
        if (r100 == null) goto L80;
        if (r102 == false) goto L63;
        Object r120 = r100.a(r110, r111, r112);
        Object r121 = r101.a(r110, r111, r112);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r120, "maxValOrArray1");
        Intrinsics.checkNotNullParameter(r121, "maxValOrArray2");
        if ((r120 instanceof Number) == false) goto L50;
        if ((r121 instanceof Number) == false) goto L50;
        return Float.valueOf((r103.a() * ((Number) r121).floatValue()) + ((Number) r120).floatValue());
    L50:
        if ((r120 instanceof List) == false) goto L62;
        if ((r121 instanceof List) == false) goto L62;
        List r122 = (List) r120;
        List r123 = (List) r121;
        int r124 = Math.min(r122.size(), r123.size());
        List r125 = CollectionsKt.createListBuilder(r124);
    L55:
        if (r125.size() >= r124) goto L58;
        float r126 = (float) Math.sqrt((-2) * ((float) Math.log(r103.f490997a.nextFloat())));
        double r127 = ((double) r103.f490997a.nextFloat()) * 6.283185307179586d;
        float r128 = 1;
        r125.add(Float.valueOf((((((float) Math.cos(r127)) * r126) + r128) * ((Number) ListProtector.get(r122, r125.size())).floatValue()) + ((Number) ListProtector.get(r123, r125.size())).floatValue()));
        r125.add(Float.valueOf((((r126 * ((float) Math.sin(r127))) + r128) * ((Number) ListProtector.get(r122, r125.size())).floatValue()) + ((Number) ListProtector.get(r123, r125.size())).floatValue()));
        goto L55
    L58:
        if (r125.size() <= r124) goto L91;
        CollectionsKt.removeLast(r125);
    L91:
        return CollectionsKt.build(r125);
    L62:
        throw new IllegalStateException(("Can't use " + r120 + " and " + r121 + " as a random() parameter").toString());
    L63:
        Object r129 = r100.a(r110, r111, r112);
        Object r130 = r101.a(r110, r111, r112);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r129, "maxValOrArray1");
        Intrinsics.checkNotNullParameter(r130, "maxValOrArray2");
        if ((r129 instanceof Number) == false) goto L69;
        if ((r130 instanceof Number) == false) goto L69;
        return Float.valueOf((r103.f490997a.nextFloat() * ((Number) r130).floatValue()) + ((Number) r129).floatValue());
    L69:
        if ((r129 instanceof List) == false) goto L78;
        if ((r130 instanceof List) == false) goto L78;
        List r131 = (List) r129;
        List r132 = (List) r130;
        int r133 = Math.min(r131.size(), r132.size());
        ArrayList r134 = new ArrayList(r133);
        int r135 = 0;
    L73:
        if (r135 >= r133) goto L76;
        float r136 = r103.f490997a.nextFloat();
        Object r137 = ListProtector.get(r131, r135);
        Intrinsics.checkNotNull(r137, "null cannot be cast to non-null type kotlin.Number");
        float r138 = r136 * ((Number) r137).floatValue();
        Object r139 = ListProtector.get(r132, r135);
        Intrinsics.checkNotNull(r139, "null cannot be cast to non-null type kotlin.Number");
        r134.add(Float.valueOf(r138 + ((Number) r139).floatValue()));
        r135 = r135 + 1;
        goto L73
    L76:
        return r134;
    L78:
        throw new IllegalStateException(("Can't use " + r129 + " and " + r130 + " as a random() parameter").toString());
    L80:
        throw new IllegalStateException("Invalid parameters for random()".toString());
    }
}
