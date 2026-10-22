package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends VOIdentifier {
    public static final /* synthetic */ int h = 0;
    public final String b;
    public String c;
    public final JSONObject d;
    public JSONObject e;
    public final ComponentDTO f;
    public final com.bytedance.android.shopping.anchorv4.dto.business.a g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.lynx.a$a, reason: collision with other inner class name */
    public static final class C0016a {
        public static a a(ComponentDTO r8) {
            Intrinsics.checkNotNullParameter(r8, "componentDTO");
            UI r1 = r8.getUi();
            if (r1 == null) goto L5;
            String r3 = r1.getResourceAddress();
        L6:
            VO r2 = r8.getVo();
            if (r2 == null) goto L9;
            JsonObject r4 = r2.getMeta();
        L10:
            String r5 = String.valueOf(r4);
            JSONObject r6 = tv5.a.c(r8.getTrack());
            UI r7 = r8.getUi();
            if (r7 == null) goto L13;
            com.bytedance.android.shopping.anchorv4.dto.business.a r9 = r7.getStyle();
        L15:
            return new a(r3, r5, r6, r8, r9, 8);
        L13:
            r9 = null;
            goto L15
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.a r16 = this.g;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
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
        return "AnchorV4LynxNodeVO(lynxAddress=" + this.b + ", meta=" + this.c + ", logParams=" + this.d + ", originMetaParams=" + this.e + ", component=" + this.f + ", style=" + this.g + ")";
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

    public static a a(a r7, ComponentDTO r8) {
        String r1 = r7.b;
        String r2 = r7.c;
        JSONObject r3 = r7.d;
        JSONObject r4 = r7.e;
        com.bytedance.android.shopping.anchorv4.dto.business.a r6 = r7.g;
        r7.getClass();
        return new a(r1, r2, r3, r4, r8, r6);
    }

    public /* synthetic */ a(String r10, String r11, JSONObject r12, ComponentDTO r13, com.bytedance.android.shopping.anchorv4.dto.business.a r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        JSONObject r5 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        ComponentDTO r7 = null;
    L19:
        if ((r15 & 32) == 0) goto L21;
        com.bytedance.android.shopping.anchorv4.dto.business.a r8 = null;
    L22:
        this(r3, r4, r5, null, r7, r8);
        return;
    L21:
        r8 = r14;
        goto L22
    L17:
        r7 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public a(String r1, String r2, JSONObject r3, JSONObject r4, ComponentDTO r5, com.bytedance.android.shopping.anchorv4.dto.business.a r6) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}
