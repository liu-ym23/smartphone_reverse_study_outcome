package ki4;

import androidx.collection.ArraySet;
import com.bytedance.creativex.mediaimport.repository.api.Aggregation;
import com.bytedance.creativex.mediaimport.repository.api.BinaryOperator;
import com.bytedance.creativex.mediaimport.repository.api.MimeType;
import com.bytedance.creativex.mediaimport.repository.api.MultivariateOperator;
import com.bytedance.creativex.mediaimport.repository.api.UnaryOperator;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i0 {
    public static final j0 a(ArraySet r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<E> r101 = r100.iterator();
        j0 r102 = null;
    L4:
        if (r101.hasNext() == false) goto L9;
        MimeType r103 = (MimeType) r101.next();
        if (r102 != null) goto L7;
        r102 = b(r103.getMimeType(), UnaryOperator.EQUAL);
        goto L4
    L7:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "other");
        j0 r104 = b(r103.getMimeType(), UnaryOperator.EQUAL);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r104, "another");
        r102 = new Aggregation(r102, Aggregation.Operator.OR, r104);
        goto L4
    L9:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final j0 b(String r110, UnaryOperator r111) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r111, OnekeyLoginConstants.CU_KEY_OPERATOR);
        String[] r100 = {r110};
        Intrinsics.checkNotNullParameter("mime_type", "column");
        Intrinsics.checkNotNullParameter(r111, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r100, "args");
        if ((r111 instanceof UnaryOperator) == false) goto L6;
        return new l0("mime_type", r111, r100[0]);
    L6:
        if ((r111 instanceof BinaryOperator) == true) goto L14;
        if ((r111 instanceof MultivariateOperator) == false) goto L12;
        return new g0("mime_type", (MultivariateOperator) r111, (String[]) ArraysKt.copyInto$default(r100, new String[]{""}, 0, 0, 0, 14, null));
    L12:
        throw new RuntimeException("Selection method parameter error, please check.");
    L14:
        throw new RuntimeException("Binary operators must have two input values.");
    }
}
