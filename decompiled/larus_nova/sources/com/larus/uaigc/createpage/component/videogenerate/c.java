package com.larus.uaigc.createpage.component.videogenerate;

import androidx.camera.video.AudioStats;
import com.larus.bmhome.actionbar.model.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements hy9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<w> f372541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Double, Long> f372542b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f372541a = CollectionsKt.emptyList();
        this.f372542b = new LinkedHashMap();
    }

    @Override // hy9.c
    public final void a(List<w> r110) {
        Intrinsics.checkNotNullParameter(r110, "optionList");
        this.f372541a = r110;
        ((LinkedHashMap) this.f372542b).clear();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L33;
        w r100 = (w) r111.next();
        Map<String, String> r101 = r100.f295526q;
        if (r101 == null) goto L12;
        String r102 = r101.get("aspect_ratio_width");
        if (r102 == null) goto L12;
        Double r103 = StringsKt.toDoubleOrNull(r102);
        if (r103 == null) goto L12;
        double r104 = r103.doubleValue();
    L13:
        Map<String, String> r105 = r100.f295526q;
        if (r105 == null) goto L20;
        String r106 = r105.get("aspect_ratio_height");
        if (r106 == null) goto L20;
        Double r107 = StringsKt.toDoubleOrNull(r106);
        if (r107 == null) goto L20;
        double r108 = r107.doubleValue();
    L21:
        Long r109 = r100.f295510a;
        boolean r112 = true;
        if (r104 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
        boolean r113 = true;
    L25:
        if (r113 == true) goto L4;
        if (r108 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
        r112 = false;
    L30:
        if (r112 == true) goto L4;
        if (r109 == null) goto L4;
        this.f372542b.put(Double.valueOf(r104 / r108), r109);
        goto L4
    L24:
        r113 = false;
    L20:
        r108 = 0.0d;
    L12:
        r104 = 0.0d;
        goto L13
    }

    @Override // hy9.c
    public final Long b(double r110) {
        if (this.f372542b.isEmpty() == false) goto L6;
        return null;
    L6:
        List r100 = CollectionsKt.toList(((LinkedHashMap) this.f372542b).keySet());
        double r101 = ((Number) CollectionsKt.first(r100)).doubleValue();
        double r102 = Math.abs(r110 - ((Number) CollectionsKt.first(r100)).doubleValue());
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        double r104 = ((Number) r103.next()).doubleValue();
        double r105 = Math.abs(r110 - r104);
        if (r105 >= r102) goto L8;
        r101 = r104;
        r102 = r105;
        goto L8
    L12:
        Map<Double, Long> r111 = this.f372542b;
        LinkedHashMap r112 = (LinkedHashMap) r111;
        return (Long) r112.get(Double.valueOf(r101));
    }
}
