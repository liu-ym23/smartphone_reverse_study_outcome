package com.bytedance.awemeopen.apps.framework.launchconfig;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class LaunchConfigManager$doOnFailed$1 extends Lambda implements Function0<Unit> {
    public static final LaunchConfigManager$doOnFailed$1 INSTANCE = null;

    static {
        INSTANCE = new LaunchConfigManager$doOnFailed$1();
    }

    public LaunchConfigManager$doOnFailed$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1545invoke() {
        a.b = 3;
        Iterator<T> r0 = a.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a.InterfaceC0100a) r0.next()).a();
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1545invoke();
        return Unit.INSTANCE;
    }
}
