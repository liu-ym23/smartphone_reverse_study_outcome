package io.opentelemetry.api.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public abstract class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f492672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f492673b;

    public g() {
        throw null;
    }

    public final int hashCode() {
        int r100 = this.f492673b;
        if (r100 != 0) goto L6;
        int r101 = Arrays.hashCode(this.f492672a) ^ 1000003;
        this.f492673b = r101;
        return r101;
    L6:
        return r100;
    }

    public final boolean isEmpty() {
        if (this.f492672a.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{");
        int r101 = 0;
    L3:
        Object[] r102 = this.f492672a;
        if (r101 >= r102.length) goto L11;
        Object r103 = r102[r101 + 1];
        if ((r103 instanceof String) == false) goto L8;
        String r104 = "\"" + ((String) r103) + Typography.quote;
    L9:
        r100.append(this.f492672a[r101]);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r104);
        r100.append(", ");
        r101 = r101 + 2;
        goto L3
    L8:
        r104 = r103.toString();
        goto L9
    L11:
        if (r100.length() <= 1) goto L13;
        r100.setLength(r100.length() - 2);
    L13:
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    }

    public g(Object[] r100) {
        this.f492672a = r100;
    }

    public final boolean equals(@Nullable Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L10;
        return false;
    L10:
        return Arrays.equals(this.f492672a, ((g) r100).f492672a);
    }

    public final void forEach(BiConsumer<? super K, ? super V> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L5:
        Object[] r102 = this.f492672a;
        if (r101 >= r102.length) goto L8;
        r100.accept(r102[r101], r102[r101 + 1]);
        r101 = r101 + 2;
        goto L5
    }

    public static void a(Object[] r100, int r101, int r102, Object[] r103, Comparator<?> r104) {
        if ((r102 - r101) > 2) goto L5;
        return;
    L5:
        int r105 = ((r102 + r101) / 4) * 2;
        a(r103, r101, r105, r100, r104);
        a(r103, r105, r102, r100, r104);
        int r106 = r101;
        int r107 = r105;
    L6:
        if (r101 >= r102) goto L23;
        if (r106 < (r105 - 1)) goto L10;
    L21:
        r103[r101] = r100[r107];
        r103[r101 + 1] = r100[r107 + 1];
        r107 = r107 + 2;
    L22:
        r101 = r101 + 2;
        goto L6
    L10:
        if (r107 >= (r102 - 1)) goto L20;
        Object r108 = r100[r106];
        Object r109 = r100[r107];
        if (r108 != null) goto L16;
        if (r109 != null) goto L15;
        int r110 = 0;
    L19:
        if (r110 > 0) goto L21;
    L15:
        r110 = -1;
        goto L19
    L16:
        if (r109 != null) goto L18;
        r110 = 1;
        goto L19
    L18:
        r110 = r104.compare(r108, r109);
    L20:
        r103[r101] = r100[r106];
        r103[r101 + 1] = r100[r106 + 1];
        r106 = r106 + 2;
        goto L22
    }
}
