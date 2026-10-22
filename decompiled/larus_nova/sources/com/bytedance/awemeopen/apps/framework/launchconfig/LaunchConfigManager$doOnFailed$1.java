package com.bytedance.awemeopen.apps.framework.launchconfig;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class LaunchConfigManager$doOnFailed$1 extends Lambda implements Function0<Unit> {
    public static final LaunchConfigManager$doOnFailed$1 INSTANCE = null;

    static {
        INSTANCE = new LaunchConfigManager$doOnFailed$1();
    }

    public LaunchConfigManager$doOnFailed$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a.f197225b = 3;
        Iterator<T> r100 = a.f197226c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a.InterfaceC2827a) r100.next()).a();
        goto L4
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
