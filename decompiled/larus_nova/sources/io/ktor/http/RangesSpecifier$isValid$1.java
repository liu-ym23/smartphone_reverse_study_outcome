package io.ktor.http;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RangesSpecifier$isValid$1 extends Lambda implements Function1<String, Boolean> {
    public static final RangesSpecifier$isValid$1 INSTANCE = null;

    static {
        INSTANCE = new RangesSpecifier$isValid$1();
    }

    public RangesSpecifier$isValid$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r100, RangeUnits.Bytes.getUnitToken()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return invoke2(r100);
    }
}
