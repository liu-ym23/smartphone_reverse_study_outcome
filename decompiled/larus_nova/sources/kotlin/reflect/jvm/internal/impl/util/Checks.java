package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes42.dex */
public final class Checks {
    private final Function1<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final Regex regex;

    public final CheckResult checkAll(FunctionDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
        Check[] r101 = this.checks;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = r101[r103].invoke(r100);
        if (r104 != null) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return new CheckResult.IllegalSignature(r104);
    L9:
        String r105 = this.additionalCheck.invoke(r100);
        if (r105 == null) goto L14;
        return new CheckResult.IllegalSignature(r105);
    L14:
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public final boolean isApplicable(FunctionDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
        if (this.name == null) goto L8;
        if (Intrinsics.areEqual(r100.getName(), this.name) == true) goto L8;
        return false;
    L8:
        if (this.regex == null) goto L12;
        String r101 = r100.getName().asString();
        if (this.regex.matches(r101) == true) goto L12;
        return false;
    L12:
        Collection<Name> r102 = this.nameList;
        if (r102 != null) goto L15;
        return true;
    L15:
        if (r102.contains(r100.getName()) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public Checks(Collection<Name> r100, Check[] r101, Function1<? super FunctionDescriptor, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "nameList");
        Intrinsics.checkNotNullParameter(r101, "checks");
        Intrinsics.checkNotNullParameter(r110, "additionalChecks");
        this(null, null, r100, r110, (Check[]) Arrays.copyOf(r101, r101.length));
    }

    public Checks(Name r100, Check[] r101, Function1<? super FunctionDescriptor, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "checks");
        Intrinsics.checkNotNullParameter(r110, "additionalChecks");
        this(r100, null, null, r110, (Check[]) Arrays.copyOf(r101, r101.length));
    }

    public Checks(Regex r100, Check[] r101, Function1<? super FunctionDescriptor, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "regex");
        Intrinsics.checkNotNullParameter(r101, "checks");
        Intrinsics.checkNotNullParameter(r110, "additionalChecks");
        this(null, r100, null, r110, (Check[]) Arrays.copyOf(r101, r101.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name r100, Regex r101, Collection<Name> r102, Function1<? super FunctionDescriptor, String> r103, Check... r104) {
        this.name = r100;
        this.regex = r101;
        this.nameList = r102;
        this.additionalCheck = r103;
        this.checks = r104;
    }

    public /* synthetic */ Checks(Collection r100, Check[] r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = AnonymousClass4.INSTANCE;
    L5:
        this(r100, r101, r102);
    }

    public /* synthetic */ Checks(Name r100, Check[] r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = AnonymousClass2.INSTANCE;
    L5:
        this(r100, r101, r102);
    }

    public /* synthetic */ Checks(Regex r100, Check[] r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = AnonymousClass3.INSTANCE;
    L5:
        this(r100, r101, r102);
    }
}
