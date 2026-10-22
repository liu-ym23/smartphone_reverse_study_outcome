package io.ktor.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "values", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class StringValuesBuilderImpl$appendMissing$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ StringValuesBuilderImpl this$0;

    public StringValuesBuilderImpl$appendMissing$1(StringValuesBuilderImpl r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "values");
        StringValuesBuilderImpl r102 = this.this$0;
        List<String> r103 = r101;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r103, "values");
        List<String> r104 = r102.f491945b.get(r100);
        if (r104 == null) goto L6;
        Set r105 = CollectionsKt.toSet(r104);
        if (r105 == null) goto L6;
    L7:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r103.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Object r108 = r107.next();
        if ((!r105.contains((String) r108)) == false) goto L9;
        r106.add(r108);
        goto L9
    L13:
        r102.d(r100, r106);
        return;
    L6:
        r105 = SetsKt.emptySet();
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, List<? extends String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
