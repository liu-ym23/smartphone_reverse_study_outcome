package com.bytedance.timonkit;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timonbase.ITMLifecycleService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class Timon$delayAsyncInit$1 extends Lambda implements Function0<Unit> {
    public static final Timon$delayAsyncInit$1 INSTANCE = null;

    static {
        INSTANCE = new Timon$delayAsyncInit$1();
    }

    public Timon$delayAsyncInit$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set r100 = ServiceManager.get().getServices(ITMLifecycleService.class);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((ITMLifecycleService) r103).enable() == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((ITMLifecycleService) r104.next()).b();
        goto L10
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
