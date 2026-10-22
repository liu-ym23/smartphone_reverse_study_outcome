package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractModifierChecks {
    public AbstractModifierChecks() {
    }

    public abstract List<Checks> getChecks$descriptors();

    public final CheckResult check(FunctionDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
        Iterator<Checks> r101 = getChecks$descriptors().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Checks r102 = r101.next();
        if (r102.isApplicable(r100) == false) goto L4;
        return r102.checkAll(r100);
    L10:
        return CheckResult.IllegalFunctionName.INSTANCE;
    }
}
