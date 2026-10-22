package nma;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.oui.stepper.OSteppers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC6940a f519610c;

    /* JADX INFO: renamed from: nma.a$a, reason: collision with other inner class name */
    public interface InterfaceC6940a {
    }

    public a(int r100, int r101, f r102) {
        this.f519608a = r100;
        this.f519609b = r101;
        this.f519610c = r102;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        int r106 = CastIntegerProtector.parseInt(r103.toString() + r100.toString());     // Catch: NumberFormatException -> L19
        int r107 = this.f519608a;     // Catch: NumberFormatException -> L19
        int r108 = this.f519609b;     // Catch: NumberFormatException -> L19
        if (r108 <= r107) goto L7;
        if (r106 < r107) goto L10;
        if (r106 > r108) goto L10;
    L9:
        boolean r109 = true;
    L11:
        if (r109 == false) goto L14;
        return null;
    L14:
        InterfaceC6940a r110 = this.f519610c;     // Catch: NumberFormatException -> L19
        if (r110 == null) goto L22;
        OSteppers r111 = ((f) r110).f519615a;     // Catch: NumberFormatException -> L19
        int r112 = OSteppers.f403043q;     // Catch: NumberFormatException -> L19
        Intrinsics.checkNotNullParameter(r111, "this$0");     // Catch: NumberFormatException -> L19
        r111.getClass();     // Catch: NumberFormatException -> L19
        return "";
    L22:
        return "";
    L10:
        r109 = false;
        goto L11
    L7:
        if (r106 < r108) goto L10;
        if (r106 > r107) goto L10;
    L23:
        return "";
    }
}
