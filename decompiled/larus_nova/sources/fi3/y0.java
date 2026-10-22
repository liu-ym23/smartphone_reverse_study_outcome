package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f477352d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f477354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477355c;

    public static final class a {
        public static y0 a(Map r100) {
            Object r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.get("post_action");
        L6:
            String r103 = String.valueOf(r102);
            if (r100 == null) goto L9;
            Object r104 = r100.get("type");
        L11:
            if ((r104 instanceof Number) == true) goto L13;
            r104 = null;
        L13:
            Number r105 = (Number) r104;
            if (r105 == null) goto L16;
            Integer r106 = Integer.valueOf(r105.intValue());
        L17:
            if (r100 == null) goto L20;
            r101 = r100.get("page");
        L20:
            return new y0(r103, r106, String.valueOf(r101));
        L16:
            r106 = null;
            goto L17
        L9:
            r104 = null;
            goto L11
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public y0() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y0) == false) goto L12;
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f477353a, r101.f477353a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477354b, r101.f477354b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477355c, r101.f477355c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f477353a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f477354b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f477355c;
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
        return "TriggerMarketingServiceActionHandlerParam(action=" + this.f477353a + ", type=" + this.f477354b + ", pageId=" + this.f477355c + ")";
    }

    public final Integer getType() {
        return this.f477354b;
    }

    public y0(String r100, Integer r101, String r102) {
        this.f477353a = r100;
        this.f477354b = r101;
        this.f477355c = r102;
    }
}
