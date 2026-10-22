package io.ktor.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "value", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class StringValuesKt$appendFiltered$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ boolean $keepEmpty;
    final /* synthetic */ Function2<String, String, Boolean> $predicate;
    final /* synthetic */ q $this_appendFiltered;

    /* JADX WARN: Multi-variable type inference failed */
    public StringValuesKt$appendFiltered$1(boolean r100, q r101, Function2<? super String, ? super String, Boolean> r102) {
        this.$keepEmpty = r100;
        this.$this_appendFiltered = r101;
        this.$predicate = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        List<String> r102 = r101;
        ArrayList r103 = new ArrayList(r101.size());
        Function2<String, String, Boolean> r104 = this.$predicate;
        Iterator<T> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        Object r106 = r105.next();
        if (r104.invoke(r100, (String) r106).booleanValue() == false) goto L4;
        r103.add(r106);
        goto L4
    L9:
        if (this.$keepEmpty == false) goto L11;
    L12:
        this.$this_appendFiltered.d(r100, r103);
        return;
    L11:
        if ((!r103.isEmpty()) == true) goto L12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, List<? extends String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
