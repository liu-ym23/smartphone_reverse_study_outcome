package com.bytedance.android.shopping.anchorv4.voavhs.lynx.air;

import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends VOIdentifier {
    public static final /* synthetic */ int g = 0;
    public final String b;
    public final String c;
    public final JSONObject d;
    public final JSONObject e;
    public final ComponentDTO f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a$a, reason: collision with other inner class name */
    public static final class C0017a {
        public static a a(ComponentDTO r8) {
            Intrinsics.checkNotNullParameter(r8, "componentDTO");
            r8.getComponentId();
            Objects.toString(r8.getTrack());
            UI r0 = r8.getUi();
            if (r0 == null) goto L5;
            r0.getResourceAddress();
        L5:
            VO r1 = r8.getVo();
            String r2 = null;
            if (r1 == null) goto L8;
            JsonObject r3 = r1.getMeta();
        L9:
            Objects.toString(r3);
            UI r4 = r8.getUi();
            if (r4 == null) goto L12;
            String r5 = r4.getResourceAddress();
        L13:
            VO r6 = r8.getVo();
            if (r6 == null) goto L18;
            JsonObject r7 = r6.getMeta();
            if (r7 == null) goto L18;
            r2 = r7.toString();
        L18:
            String r9 = r2;
            JsonObject r10 = r8.getTrack();
            if (r10 == null) goto L21;
            JSONObject r11 = tv5.a.c(r10);
        L23:
            return new a(r5, r9, r11, r8, 8);
        L21:
            r11 = new JSONObject("{}");
            goto L23
        L12:
            r5 = null;
            goto L13
        L8:
            r3 = null;
            goto L9
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        JSONObject r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        JSONObject r10 = this.e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ComponentDTO r13 = this.f;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4LynxAirNodeVO(lynxAddress=" + this.b + ", meta=" + this.c + ", logParams=" + this.d + ", originMetaParams=" + this.e + ", component=" + this.f + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.f;
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

    public a(String r3, String r4, JSONObject r5, ComponentDTO r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 16) == 0) goto L14;
        r6 = null;
    L14:
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = r6;
    }
}
