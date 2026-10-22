package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class b<VALUE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, j8> f267971a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f267972a = null;

        static {
            int[] r100 = new int[ValidationAction.values().length];
            r100[ValidationAction.Exception.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ValidationAction.Discard.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ValidationAction.CutOff.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ValidationAction.None.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f267972a = r100;
        }
    }

    public o4<VALUE> b(VALUE r100, j8 r101) {
        throw null;
    }

    public void d(Map<String, j8> r100) {
        throw null;
    }

    public b() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.f267971a = r100;
        d(r100);
    }

    public final i8<VALUE> a(String r110, VALUE r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        if (com.bytedance.rts.foundation.m.b(this.f267971a, r110) == false) goto L42;
        j8 r112 = (j8) ((LinkedHashMap) this.f267971a).get(r110);
        if (r112 == null) goto L42;
        if (r111 == null) goto L42;
        o4<VALUE> r113 = b(r111, r112);
        ValidationAction r100 = r112.f268167b;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("action");
        r100 = null;
    L11:
        int r101 = a.f267972a[r100.ordinal()];
        if (r101 != 1) goto L14;
        int r102 = r113.f268268a;
        int r103 = r112.f268166a;
        if (r102 > r103) goto L40;
        return new i8("validate success", ValidateResultCode.Success, r113.f268269b);
    L40:
        return new i8(false, "validate failed and throw exception", ValidateResultCode.Invalid_input, r103, r113.f268269b);
    L14:
        if (r101 != 2) goto L16;
        int r104 = r113.f268268a;
        int r114 = r112.f268166a;
        if (r104 > r114) goto L34;
        return new i8("validate success", ValidateResultCode.Success, r113.f268269b);
    L34:
        return new i8(ValidateResultCode.Fail, r114);
    L16:
        if (r101 != 3) goto L18;
        int r105 = r113.f268268a;
        int r106 = r112.f268166a;
        if (r105 > r106) goto L28;
        return new i8("validate success", ValidateResultCode.Success, r113.f268269b);
    L28:
        return new i8(true, "validate success and the field is truncated", ValidateResultCode.Invalid_input, r106, r113.f268269b);
    L18:
        if (r101 != 4) goto L22;
        return new i8("validate success with none action", ValidateResultCode.Success, r113.f268269b);
    L22:
        throw new NoWhenBranchMatchedException();
    L42:
        return new i8("don't need to validate", ValidateResultCode.Success, r111);
    }

    public final VALUE c(String r100, VALUE r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return a(r100, r101).b();
    }
}
