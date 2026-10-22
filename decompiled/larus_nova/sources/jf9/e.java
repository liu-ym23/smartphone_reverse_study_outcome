package jf9;

import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final void a(d r100, oe9.b<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "result");
        r100.f498923q = r101.c();
        r100.f498918l = r101.f523023a;
        if ((r101 instanceof oe9.b.c) == false) goto L6;
        AVCommonError r102 = AVCommonError.Network_UNAVAILABLE;
        r100.f489629d = r102.getCode();
        r100.f489630e = r102.getMsg();
        return;
    L6:
        boolean r103 = r101 instanceof oe9.b.f;
        if (r103 == true) goto L15;
        AVCommonError r104 = AVCommonError.Get_TokenFailed;
        r100.f489629d = r104.getCode();
        r100.f489630e = r104.getMsg();
        oe9.c r105 = r101.b();
        if (r105 == null) goto L11;
        String r106 = r105.getMsg();
    L12:
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        r100.f489632g = r106;
        goto L15
    L11:
        r106 = null;
    L15:
        int r107 = 0;
        if (r103 == false) goto L19;
        r100.f498917k = 200;
        r100.f498919m = 0;
        return;
    L19:
        if ((r101 instanceof oe9.b.a) == false) goto L26;
        Integer r108 = AVCommonError.Get_TokenFailed_Net_Cancel.getSubCode();
        if (r108 == null) goto L23;
        int r109 = r108.intValue();
    L24:
        r100.f489631f = Integer.valueOf(r109 + 0);
        return;
    L23:
        r109 = 0;
        goto L24
    L26:
        if ((r101 instanceof oe9.b.C7042b) == false) goto L32;
        Integer r110 = AVCommonError.Get_TokenFailed_Http_Error.getSubCode();
        if (r110 == null) goto L30;
        r107 = r110.intValue();
    L30:
        r100.f489631f = Integer.valueOf(r107 + ((oe9.b.C7042b) r101).f523027b);
        return;
    L32:
        if ((r101 instanceof oe9.b.e) == false) goto L38;
        Integer r111 = AVCommonError.Get_TokenFailed_Server_Error.getSubCode();
        if (r111 == null) goto L36;
        r107 = r111.intValue();
    L36:
        r100.f489631f = Integer.valueOf(r107 + ((oe9.b.e) r101).f523038b);
        return;
    L38:
        if ((r101 instanceof oe9.b.d) == false) goto L49;
        Integer r112 = AVCommonError.Get_TokenFailed_Resolve_Error.getSubCode();
        if (r112 == null) goto L42;
        int r113 = r112.intValue();
    L43:
        r100.f489631f = Integer.valueOf(r113 + 0);
        r100.f498924r = ((oe9.b.d) r101).f523035c;
        return;
    L42:
        r113 = 0;
        goto L43
    }
}
