package vd6;

import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class c extends o {
    public c() {
        super(HTTP.URL_DEFAULT, 700, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r110) {
        c(r110, true);
        Intrinsics.checkNotNull(r110);
        if ((ListProtector.get(r110, 0) instanceof sd6.e) == true) goto L29;
        if ((ListProtector.get(r110, 1) instanceof sd6.e) == true) goto L29;
        String r100 = b(r110);
        if (Intrinsics.areEqual(r100, "param_type_double") == false) goto L19;
        Object r101 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Number");
        if (((Number) r101).doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L17;
        Object r103 = ListProtector.get(r110, 0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Number");
        double r104 = ((Number) r103).doubleValue();
        Object r111 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Number");
        return Double.valueOf(r104 / ((Number) r111).doubleValue());
    L17:
        throw new ExprException(101, "divisor shouldn't be zero");
    L12:
        r102 = false;
        goto L13
    L19:
        if (Intrinsics.areEqual(r100, "param_type_number") == false) goto L27;
        Object r105 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Number");
        if (((Number) r105).longValue() == 0) goto L25;
        Object r106 = ListProtector.get(r110, 0);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Number");
        long r107 = ((Number) r106).longValue();
        Object r112 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Number");
        return Long.valueOf(r107 / ((Number) r112).longValue());
    L25:
        throw new ExprException(101, "divisor shouldn't be zero");
    L27:
        throw new ExprException(101, "not support");
    L29:
        return new sd6.e(0);
    }
}
