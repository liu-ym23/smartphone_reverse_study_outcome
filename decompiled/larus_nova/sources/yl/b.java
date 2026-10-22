package yl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lyl/b;", "", "", "Lyl/a;", "rules", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("rules")
    private final List<a> rules;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.rules, ((b) r100).rules) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<a> r100 = this.rules;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MainHandlerOptConfig(rules=" + this.rules + ")";
    }

    public final List<a> a() {
        return this.rules;
    }

    public b(List<a> r100) {
        this.rules = r100;
    }

    public /* synthetic */ b(int r100) {
        this(null);
    }

    public final void b(List<a> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mergeTarget");
        Intrinsics.checkNotNullParameter(r101, "key");
        List<a> r102 = this.rules;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L17;
        Iterator<T> r104 = this.rules.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((a) r104.next()).f568301a = r101;
        goto L12
    L14:
        r100.addAll(this.rules);
        return;
    L17:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
