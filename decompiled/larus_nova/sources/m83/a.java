package m83;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4ProcessFlowDisplay;
import com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4ProcessFlowMeta;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends VOIdentifier {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f512463e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4ProcessFlowDisplay f512464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4ProcessFlowMeta f512465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentDTO f512466d;

    /* JADX INFO: renamed from: m83.a$a, reason: collision with other inner class name */
    public static final class C6782a {
        public static a a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            a r103 = new a(0);     // Catch: Throwable -> L13
            VO r104 = r100.getVo();     // Catch: Throwable -> L13
            if (r104 == null) goto L6;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L13
        L7:
            r103.f512464b = (AnchorV4ProcessFlowDisplay) u0.a(r105, AnchorV4ProcessFlowDisplay.class);     // Catch: Throwable -> L13
            VO r106 = r100.getVo();     // Catch: Throwable -> L13
            if (r106 == null) goto L10;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L13
        L11:
            r103.f512465c = (AnchorV4ProcessFlowMeta) u0.a(r107, AnchorV4ProcessFlowMeta.class);     // Catch: Throwable -> L13
            r103.f512466d = r100;     // Catch: Throwable -> L13
            Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L13
        L16:
            if (Result.m9455isFailureimpl(r108) == true) goto L20;
            r101 = r108;
        L20:
            return (a) r101;
        L10:
            r107 = null;
            goto L11
        L6:
            r105 = null;
        L13:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f512464b, r101.f512464b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512465c, r101.f512465c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512466d, r101.f512466d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AnchorV4ProcessFlowDisplay r100 = this.f512464b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4ProcessFlowMeta r104 = this.f512465c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f512466d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4ProcessFlowVO(display=" + this.f512464b + ", meta=" + this.f512465c + ", component=" + this.f512466d + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f512466d;
        if (r100 == null) goto L5;
        String r101 = r100.getComponentId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public a(int r100) {
        this.f512464b = null;
        this.f512465c = null;
        this.f512466d = null;
    }
}
