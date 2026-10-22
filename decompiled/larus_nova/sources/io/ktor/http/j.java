package io.ktor.http;

import androidx.camera.video.AudioStats;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k> f491876b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f491875a, r101.f491875a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f491876b, r101.f491876b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f491875a.hashCode() * 31) + this.f491876b.hashCode();
    }

    public final String toString() {
        return "HeaderValue(value=" + this.f491875a + ", params=" + this.f491876b + ')';
    }

    public /* synthetic */ j(String r100) {
        this(r100, CollectionsKt.emptyList());
    }

    public j(String r100, List<k> r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f491875a = r100;
        this.f491876b = r101;
        Iterator<T> r102 = r101.iterator();
    L3:
        Double r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((k) r104).f491883a, "q") == false) goto L3;
    L9:
        k r105 = (k) r104;
        if (r105 == null) goto L28;
        String r106 = r105.f491884b;
        if (r106 == null) goto L29;
        Double r107 = StringsKt.toDoubleOrNull(r106);
        if (r107 == null) goto L30;
        double r108 = r107.doubleValue();
        boolean r109 = false;
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r108) goto L18;
    L20:
        if (r109 == false) goto L22;
        r103 = r107;
    L22:
        if (r103 == null) goto L31;
        r103.doubleValue();
        return;
    L31:
        return;
    L18:
        if (r108 > 1.0d) goto L20;
        r109 = true;
        goto L20
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L8:
        r104 = null;
        goto L9
    }
}
