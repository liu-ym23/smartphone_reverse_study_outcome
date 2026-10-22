package prc;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.text.font.FontFamily;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import dsc.s;
import io.github.alexzhirkevich.compottie.LottieComposition;
import io.github.alexzhirkevich.compottie.internal.Animation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieComposition f530391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, io.github.alexzhirkevich.compottie.internal.assets.d> f530392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, FontFamily> f530393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f530394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f530395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableState f530396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableState f530397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableState f530398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableState f530399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableState f530400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableState f530401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableState f530402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s f530403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public io.github.alexzhirkevich.compottie.internal.animation.expressions.g f530404n;

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        return ((Boolean) this.f530397g.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b() {
        return ((Boolean) this.f530396f.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        return ((Boolean) this.f530400j.getValue()).booleanValue();
    }

    public final long d() {
        LottieComposition r100 = this.f530391a;
        long r101 = r100.f490695b;
        float r102 = this.f530394d;
        Animation r103 = r100.f490694a;
        float r104 = r103.f490754d;
        return Duration.m10830timesUwyO8pc(r101, RangesKt.coerceIn((r102 - r104) / (r103.f490755e - r104), 0.0f, 1.0f));
    }

    public final int hashCode() {
        int r100 = ((((((this.f530391a.hashCode() * 31) + this.f530392b.hashCode()) * 31) + this.f530393c.hashCode()) * 31) + Float.floatToIntBits(this.f530394d)) * 31;
        int r101 = 1237;
        if (b() == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (a() == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + ((FontFamily.Resolver) this.f530398h.getValue()).hashCode()) * 31;
        if (c() == false) goto L14;
        r101 = 1231;
    L14:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L38:
        return false;
    L8:
        if (f.class != r100.getClass()) goto L38;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f530391a, r101.f530391a) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f530392b, r101.f530392b) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.f530393c, r101.f530393c) == true) goto L20;
        return false;
    L20:
        if (this.f530394d != r101.f530394d) goto L22;
        boolean r102 = true;
    L23:
        if (r102 == true) goto L26;
        return false;
    L26:
        if (b() == r101.b()) goto L29;
        return false;
    L29:
        if (a() == r101.a()) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual((FontFamily.Resolver) this.f530398h.getValue(), (FontFamily.Resolver) r101.f530398h.getValue()) == true) goto L35;
        return false;
    L35:
        if (c() == r101.c()) goto L37;
        return false;
    L37:
        return true;
    L22:
        r102 = false;
        goto L23
    }

    public final <R> R e(float r100, Function1<? super f, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Float.valueOf(this.f530404n.getStartTime()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L11;
        Animation r104 = this.f530391a.f490694a;
        r103 = Float.valueOf(r104.f490754d / r104.f490751a);
    L11:
        float r105 = (r100 - ((Number) r103).floatValue()) * this.f530391a.f490694a.f490751a;
        float r106 = this.f530394d;
        this.f530394d = r105;     // Catch: Throwable -> L15
        R r107 = r101.invoke(this);     // Catch: Throwable -> L15
        this.f530394d = r106;
        return r107;
    L15:
        th = move-exception;
        this.f530394d = r106;
        throw th;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(LottieComposition r100, Map<String, ? extends io.github.alexzhirkevich.compottie.internal.assets.d> r101, Map<String, ? extends FontFamily> r102, float r103, FontFamily.Resolver r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, s r114) {
        Intrinsics.checkNotNullParameter(r100, "composition");
        Intrinsics.checkNotNullParameter(r101, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r102, "fonts");
        Intrinsics.checkNotNullParameter(r104, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(r114, GXTemplateKey.GAIAX_LAYER);
        this.f530391a = r100;
        this.f530392b = r101;
        this.f530393c = r102;
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r108.hasNext() == false) goto L13;
        Map.Entry r109 = (Map.Entry) r108.next();
        io.github.alexzhirkevich.compottie.internal.assets.d r115 = (io.github.alexzhirkevich.compottie.internal.assets.d) r109.getValue();
        if ((r115 instanceof io.github.alexzhirkevich.compottie.internal.assets.c) == true) goto L8;
    L10:
        boolean r116 = false;
    L11:
        if (r116 == false) goto L4;
        r107.put(r109.getKey(), r109.getValue());
        goto L4
    L8:
        if (((io.github.alexzhirkevich.compottie.internal.assets.c) r115).f491245i == null) goto L10;
        r116 = true;
        goto L11
    L13:
        LinkedHashMap r117 = new LinkedHashMap(MapsKt.mapCapacity(r107.size()));
        Iterator r118 = r107.entrySet().iterator();
    L15:
        if (r118.hasNext() == false) goto L17;
        Map.Entry r119 = (Map.Entry) r118.next();
        Object r120 = r119.getKey();
        Object r121 = r119.getValue();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.assets.ImageAsset");
        ImageBitmap r122 = ((io.github.alexzhirkevich.compottie.internal.assets.c) r121).f491245i;
        Intrinsics.checkNotNull(r122);
        r117.put(r120, r122);
        goto L15
    L17:
        this.f530394d = r103;
        this.f530395e = r103;
        this.f530396f = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r106), null, 2, null);
        this.f530397g = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r110), null, 2, null);
        this.f530398h = SnapshotStateKt.mutableStateOf$default(r104, null, 2, null);
        this.f530399i = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r105), null, 2, null);
        this.f530400j = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r112), null, 2, null);
        this.f530401k = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r113), null, 2, null);
        this.f530402l = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r111), null, 2, null);
        this.f530403m = r114;
        this.f530404n = this.f530391a.f490698e;
    }
}
