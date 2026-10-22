package jy9;

import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wc9.e f500975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<ICoreInputAbility.OnSendParams, Unit> f500976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function4<Serializable, String, String, zs8.a, Unit> f500977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<DialogFragment, Unit> f500978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f500979g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f500973a, r101.f500973a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500974b, r101.f500974b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500975c, r101.f500975c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500976d, r101.f500976d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500977e, r101.f500977e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f500978f, r101.f500978f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f500979g, r101.f500979g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f500973a.hashCode() * 31;
        String r101 = this.f500974b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        wc9.e r105 = this.f500975c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<ICoreInputAbility.OnSendParams, Unit> r108 = this.f500976d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function4<Serializable, String, String, zs8.a, Unit> r111 = this.f500977e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Function1<DialogFragment, Unit> r114 = this.f500978f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f500979g.hashCode();
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "BeautifyEnv(cvsId=" + this.f500973a + ", botId=" + this.f500974b + ", conversation=" + this.f500975c + ", doSend=" + this.f500976d + ", sendImageRemoveMessage=" + this.f500977e + ", showDialogFragment=" + this.f500978f + ", dismissCreationPage=" + this.f500979g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, String r101, wc9.e r102, Function1<? super ICoreInputAbility.OnSendParams, Unit> r103, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r104, Function1<? super DialogFragment, Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r106, "dismissCreationPage");
        this.f500973a = r100;
        this.f500974b = r101;
        this.f500975c = r102;
        this.f500976d = r103;
        this.f500977e = r104;
        this.f500978f = r105;
        this.f500979g = r106;
    }
}
