package org.jetbrains.compose.resources;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@InternalResourceApi
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f525842a;

    public final int hashCode() {
        return this.f525842a.hashCode();
    }

    public final String toString() {
        return "RegionQualifier(region='" + this.f525842a + "')";
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_REGION);
        this.f525842a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (m.class == r100.getClass()) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f525842a, ((m) r100).f525842a);
    }
}
