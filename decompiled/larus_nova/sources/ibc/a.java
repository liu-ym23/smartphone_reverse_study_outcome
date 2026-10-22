package ibc;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.voiceinput.impl.service.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f489144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f489145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xac.a f489146c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f489144a, r101.f489144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489145b, r101.f489145b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489146c, r101.f489146c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f489144a.hashCode() * 31) + this.f489145b.hashCode()) * 31) + this.f489146c.hashCode();
    }

    public final String toString() {
        return "VoiceDependency(voiceServiceFactory=" + this.f489144a + ", fragment=" + this.f489145b + ", voiceContext=" + this.f489146c + ')';
    }

    public a(j r100, Fragment r101, xac.a r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceServiceFactory");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "voiceContext");
        this.f489144a = r100;
        this.f489145b = r101;
        this.f489146c = r102;
    }
}
