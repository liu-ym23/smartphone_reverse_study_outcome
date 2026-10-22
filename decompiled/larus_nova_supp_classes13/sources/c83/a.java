package c83;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip.AnchorV4DeletedProductTipDisplay;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends VOIdentifier {
    public static final /* synthetic */ int d = 0;
    public AnchorV4DeletedProductTipDisplay b;
    public ComponentDTO c;

    /* JADX INFO: renamed from: c83.a$a, reason: collision with other inner class name */
    public static final class C0004a {
        public static a a(ComponentDTO r4) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            a r2 = new a(0);     // Catch: Throwable -> L9
            VO r3 = r4.getVo();     // Catch: Throwable -> L9
            if (r3 == null) goto L6;
            JsonObject r5 = r3.getDisplay();     // Catch: Throwable -> L9
        L7:
            r2.b = (AnchorV4DeletedProductTipDisplay) u0.a(r5, AnchorV4DeletedProductTipDisplay.class);     // Catch: Throwable -> L9
            r2.c = r4;     // Catch: Throwable -> L9
            Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
        L12:
            if (Result.isFailure-impl(r6) == true) goto L16;
            r0 = r6;
        L16:
            return (a) r0;
        L6:
            r5 = null;
        L9:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        AnchorV4DeletedProductTipDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ComponentDTO r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4DeletedProductTipVO(display=" + this.b + ", component=" + this.c + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.c;
        if (r0 == null) goto L5;
        String r1 = r0.getComponentId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public a(int r1) {
        this.b = null;
        this.c = null;
    }
}
