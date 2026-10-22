package uza;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKSharePanelType;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKShareScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IOfficeSDKShareScene f552227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f552229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Function0<Bitmap>> f552230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<IOfficeSDKSharePanelType, Boolean> f552231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<IOfficeSDKSharePanelType, Unit> f552232g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f552226a, r101.f552226a) == true) goto L12;
        return false;
    L12:
        if (this.f552227b == r101.f552227b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552228c, r101.f552228c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f552229d, r101.f552229d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f552230e, r101.f552230e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f552231f, r101.f552231f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f552232g, r101.f552232g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f552226a.hashCode() * 31) + this.f552227b.hashCode()) * 31;
        String r101 = this.f552228c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f552229d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<Function0<Bitmap>> r108 = this.f552230e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function1<IOfficeSDKSharePanelType, Boolean> r111 = this.f552231f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((r110 + r102) * 31) + this.f552232g.hashCode();
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeSDKSharePanelRequest(context=" + this.f552226a + ", scene=" + this.f552227b + ", title=" + this.f552228c + ", desc=" + this.f552229d + ", bitmaps=" + this.f552230e + ", needHandleAction=" + this.f552231f + ", handleAction=" + this.f552232g + ')';
    }

    public final Context getContext() {
        return this.f552226a;
    }

    public /* synthetic */ b(Context r100, IOfficeSDKShareScene r110, List r111, Function1 r112, Function1 r113, int r114) {
        if ((r114 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r110, null, null, r111, r112, r113);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r100, IOfficeSDKShareScene r101, String r102, String r103, List<? extends Function0<Bitmap>> r104, Function1<? super IOfficeSDKSharePanelType, Boolean> r105, Function1<? super IOfficeSDKSharePanelType, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r106, "handleAction");
        this.f552226a = r100;
        this.f552227b = r101;
        this.f552228c = r102;
        this.f552229d = r103;
        this.f552230e = r104;
        this.f552231f = r105;
        this.f552232g = r106;
    }
}
