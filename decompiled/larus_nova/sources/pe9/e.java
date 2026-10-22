package pe9;

import com.larus.im.internal.audio.ability.DoraCustomSignalType;
import com.larus.im.internal.network.link.impl.sami.w;
import com.mammon.audiosdk.SAMICore;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SAMICore f528727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f528728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<qe9.b, Unit> f528729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<DoraCustomSignalType, JSONObject, Unit> f528730d;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f528727a, r101.f528727a) == true) goto L12;
        return false;
    L12:
        if (this.f528728b == r101.f528728b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528729c, r101.f528729c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528730d, r101.f528730d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528727a.hashCode() * 31;
        if (this.f528728b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f528729c.hashCode()) * 31) + this.f528730d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SamiLinkContext(samiHandle=" + this.f528727a + ", textReplyBegin=" + this.f528728b + ", addInterceptor=" + this.f528729c + ", sendCustomEvent=" + this.f528730d + ')';
    }

    public e(SAMICore r100, w r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "samiHandle");
        Intrinsics.checkNotNullParameter(r101, "addInterceptor");
        Intrinsics.checkNotNullParameter(r102, "sendCustomEvent");
        this.f528727a = r100;
        this.f528728b = true;
        this.f528729c = r101;
        this.f528730d = r102;
    }
}
