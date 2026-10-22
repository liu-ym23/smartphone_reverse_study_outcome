package de5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Serializable> f468063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Serializable> f468064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f468065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Class<? extends XBridgeMethod>> f468066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f468067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f468068g;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 30);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468062a, r101.f468062a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468063b, r101.f468063b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468064c, r101.f468064c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468065d, r101.f468065d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f468066e, r101.f468066e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468067f, r101.f468067f) == true) goto L27;
        return false;
    L27:
        if (this.f468068g == r101.f468068g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f468062a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, Serializable> r104 = this.f468063b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, Serializable> r107 = this.f468064c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Bundle r110 = this.f468065d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ArrayList<Class<? extends XBridgeMethod>> r113 = this.f468066e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Fragment r116 = this.f468067f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.f468068g == false) goto L29;
        int r118 = 1231;
    L31:
        return r117 + r118;
    L29:
        r118 = 1237;
        goto L31
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenParams(shareContextID=" + this.f468062a + ", templateData=" + this.f468063b + ", panelParam=" + this.f468064c + ", oriBundle=" + this.f468065d + ", bizMethods=" + this.f468066e + ", sourceFragment=" + this.f468067f + ", replaceSource=" + this.f468068g + ')';
    }

    public /* synthetic */ a(String r100, HashMap r110, Bundle r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        HashMap r102 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        Bundle r103 = null;
    L14:
        this(r101, r102, null, r103, null);
        return;
    L13:
        r103 = r111;
        goto L14
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public a(String r110, HashMap<String, Serializable> r111, HashMap<String, Serializable> r112, Bundle r113, ArrayList<Class<? extends XBridgeMethod>> r114) {
        this(r110, r111, r112, r113, r114, null, false, 64);
    }

    public a(String r100, HashMap<String, Serializable> r101, HashMap<String, Serializable> r102, Bundle r103, ArrayList<Class<? extends XBridgeMethod>> r104, Fragment r105, boolean r106) {
        this.f468062a = r100;
        this.f468063b = r101;
        this.f468064c = r102;
        this.f468065d = r103;
        this.f468066e = r104;
        this.f468067f = r105;
        this.f468068g = r106;
    }

    public /* synthetic */ a(String r100, HashMap r101, HashMap r102, Bundle r110, ArrayList r111, Fragment r112, boolean r113, int r114) {
        Fragment r103 = null;
        if ((r114 & 1) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        HashMap r105 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        HashMap r106 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Bundle r107 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        ArrayList r108 = null;
    L23:
        if ((r114 & 32) != 0) goto L27;
        r103 = r112;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r115 = false;
    L30:
        this(r104, r105, r106, r107, r108, r103, r115);
        return;
    L29:
        r115 = r113;
        goto L30
    L21:
        r108 = r111;
        goto L23
    L17:
        r107 = r110;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
