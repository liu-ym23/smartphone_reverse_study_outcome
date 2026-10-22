package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f505410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f505411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f505412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f505413d;

    public final ouc.i b() {
        byte r100 = this.f505410a.r();
        if (r100 != 1) goto L6;
        return d(true);
    L6:
        if (r100 != 0) goto L9;
        return d(false);
    L9:
        if (r100 != 6) goto L41;
        int r101 = this.f505413d + 1;
        this.f505413d = r101;
        if (r101 != 200) goto L13;
        ouc.i r102 = (ouc.i) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    L37:
        this.f505413d--;
        return r102;
    L13:
        byte r103 = this.f505410a.f((byte) 6);
        if (this.f505410a.r() == 4) goto L38;
        LinkedHashMap r104 = new LinkedHashMap();
    L17:
        if (this.f505410a.b() == false) goto L28;
        if (this.f505411b == false) goto L21;
        String r105 = this.f505410a.j();
    L22:
        this.f505410a.f((byte) 5);
        r104.put(r105, b());
        r103 = this.f505410a.e();
        if (r103 == 4) goto L17;
        if (r103 == 7) goto L28;
        a.m(this.f505410a, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L21:
        r105 = this.f505410a.i();
    L28:
        if (r103 != 6) goto L30;
        this.f505410a.f((byte) 7);
    L36:
        r102 = new ouc.d0(r104);
        goto L37
    L30:
        if (r103 != 4) goto L36;
        if (this.f505412c == false) goto L34;
        this.f505410a.f((byte) 7);
        goto L36
    L34:
        s.e(this.f505410a, "object");
        throw null;
    L38:
        a.m(this.f505410a, "Unexpected leading comma", 0, null, 6);
        throw null;
    L41:
        if (r100 == 8) goto L43;
        a.m(this.f505410a, "Cannot read Json element because of unexpected ".concat(b.b(r100)), 0, null, 6);
        throw null;
    L43:
        return c();
    }

    public final ouc.b c() {
        byte r100 = this.f505410a.e();
        if (this.f505410a.r() == 4) goto L29;
        ArrayList r101 = new ArrayList();
    L6:
        if (this.f505410a.b() == false) goto L19;
        r101.add(b());
        r100 = this.f505410a.e();
        if (r100 == 4) goto L6;
        a r102 = this.f505410a;
        if (r100 != 9) goto L12;
        boolean r103 = true;
    L13:
        int r104 = r102.f505376a;
        if (r103 == true) goto L6;
        a.m(r102, "Expected end of the array or comma", r104, null, 4);
        throw null;
    L12:
        r103 = false;
        goto L13
    L19:
        if (r100 != 8) goto L21;
        this.f505410a.f((byte) 9);
    L28:
        return new ouc.b(r101);
    L21:
        if (r100 != 4) goto L28;
        if (this.f505412c == false) goto L25;
        this.f505410a.f((byte) 9);
        goto L28
    L25:
        s.e(this.f505410a, "array");
        throw null;
    L29:
        a.m(this.f505410a, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    public final ouc.g0 d(boolean r100) {
        if (this.f505411b == true) goto L7;
        if (r100 == false) goto L7;
        String r101 = this.f505410a.i();
    L8:
        if (r100 == true) goto L14;
        if (Intrinsics.areEqual(r101, "null") == false) goto L14;
        return ouc.a0.INSTANCE;
    L14:
        return new ouc.x(r101, r100, null);
    L7:
        r101 = this.f505410a.j();
        goto L8
    }

    public g0(ouc.f r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, "lexer");
        this.f505410a = r101;
        this.f505411b = r100.f526834c;
        this.f505412c = r100.f526845n;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0094 -> B:27:0x0099). Please report as a decompilation issue!!! */
    public static final Object a(g0 r110, DeepRecursiveScope r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof JsonTreeReader$readObject$2) == false) goto L7;
        JsonTreeReader$readObject$2 r100 = (JsonTreeReader$readObject$2) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r114 = (String) r100.L$3;
        LinkedHashMap r115 = (LinkedHashMap) r100.L$2;
        g0 r104 = (g0) r100.L$1;
        DeepRecursiveScope r105 = (DeepRecursiveScope) r100.L$0;
        ResultKt.throwOnFailure(r113);
        LinkedHashMap r106 = r115;
        r111 = r105;
    L27:
        r106.put(r114, (ouc.i) r113);
        byte r116 = r104.f505410a.e();
        if (r116 == 4) goto L33;
        if (r116 != 7) goto L31;
        r110 = r104;
        LinkedHashMap r107 = r106;
    L34:
        if (r116 != 6) goto L36;
        r110.f505410a.f((byte) 7);
    L43:
        return new ouc.d0(r107);
    L36:
        if (r116 != 4) goto L43;
        if (r110.f505412c == false) goto L40;
        r110.f505410a.f((byte) 7);
        goto L43
    L40:
        s.e(r110.f505410a, "object");
        throw null;
    L31:
        a.m(r104.f505410a, "Expected end of the object or comma", 0, null, 6);
        throw null;
    L33:
        r110 = r104;
        r107 = r106;
    L18:
        if (r110.f505410a.b() == false) goto L34;
        if (r110.f505411b == false) goto L22;
        String r117 = r110.f505410a.j();
    L23:
        r110.f505410a.f((byte) 5);
        Unit r108 = Unit.INSTANCE;
        r100.L$0 = r111;
        r100.L$1 = r110;
        r100.L$2 = r107;
        r100.L$3 = r117;
        r100.label = 1;
        Object r109 = r111.callRecursive(r108, r100);
        if (r109 == r102) goto L46;
        LinkedHashMap r118 = r107;
        r104 = r110;
        r114 = r117;
        r113 = r109;
        r106 = r118;
        goto L27
    L46:
        return r102;
    L22:
        r117 = r110.f505410a.i();
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r116 = r110.f505410a.f((byte) 6);
        if (r110.f505410a.r() == 4) goto L44;
        r107 = new LinkedHashMap();
        goto L18
    L44:
        a.m(r110.f505410a, "Unexpected leading comma", 0, null, 6);
        throw null;
    L7:
        r100 = new JsonTreeReader$readObject$2(r110, r112);
        goto L8
    }
}
