package de5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final HashMap<String, Serializable> b;
    public final HashMap<String, Serializable> c;
    public final Bundle d;
    public final ArrayList<Class<? extends XBridgeMethod>> e;
    public final Fragment f;
    public final boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 30);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, Serializable> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, Serializable> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Bundle r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ArrayList<Class<? extends XBridgeMethod>> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Fragment r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.g == false) goto L29;
        int r18 = 1231;
    L31:
        return r17 + r18;
    L29:
        r18 = 1237;
        goto L31
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenParams(shareContextID=" + this.a + ", templateData=" + this.b + ", panelParam=" + this.c + ", oriBundle=" + this.d + ", bizMethods=" + this.e + ", sourceFragment=" + this.f + ", replaceSource=" + this.g + ')';
    }

    public /* synthetic */ a(String r9, HashMap r10, Bundle r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        HashMap r4 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        Bundle r6 = null;
    L14:
        this(r3, r4, null, r6, null);
        return;
    L13:
        r6 = r11;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public a(String r10, HashMap<String, Serializable> r11, HashMap<String, Serializable> r12, Bundle r13, ArrayList<Class<? extends XBridgeMethod>> r14) {
        this(r10, r11, r12, r13, r14, null, false, 64);
    }

    public a(String r1, HashMap<String, Serializable> r2, HashMap<String, Serializable> r3, Bundle r4, ArrayList<Class<? extends XBridgeMethod>> r5, Fragment r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ a(String r7, HashMap r8, HashMap r9, Bundle r10, ArrayList r11, Fragment r12, boolean r13, int r14) {
        Fragment r1 = null;
        if ((r14 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        HashMap r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        HashMap r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Bundle r4 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        ArrayList r5 = null;
    L23:
        if ((r14 & 32) != 0) goto L27;
        r1 = r12;
    L27:
        if ((r14 & 64) == 0) goto L29;
        boolean r15 = false;
    L30:
        this(r0, r2, r3, r4, r5, r1, r15);
        return;
    L29:
        r15 = r13;
        goto L30
    L21:
        r5 = r11;
        goto L23
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }
}
