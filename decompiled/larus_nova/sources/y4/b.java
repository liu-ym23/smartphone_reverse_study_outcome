package y4;

import android.graphics.Rect;
import com.bytedance.applet.model.floating.i;
import com.bytedance.applet.model.floating.j;
import com.bytedance.applet.model.floating.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Boolean, Boolean, Unit> f565909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Rect> f565910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<byte[], Unit> f565911c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f565909a, r101.f565909a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565910b, r101.f565910b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565911c, r101.f565911c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f565909a.hashCode() * 31) + this.f565910b.hashCode()) * 31) + this.f565911c.hashCode();
    }

    public final String toString() {
        return "ChatSpeakVisualizerAbility(switchStatus=" + this.f565909a + ", globalVisibleRect=" + this.f565910b + ", setAudioData=" + this.f565911c + ')';
    }

    public b(i r100, j r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "switchStatus");
        Intrinsics.checkNotNullParameter(r101, "globalVisibleRect");
        Intrinsics.checkNotNullParameter(r102, "setAudioData");
        this.f565909a = r100;
        this.f565910b = r101;
        this.f565911c = r102;
    }
}
