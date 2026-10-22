package com.ss.android.ugc.aweme.search.common.event;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/event/ECSearchSafeEventBusWrapper;", "", "event", "", "onReceiveEvent", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSafeEventBusWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f451590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchSafeEventBusWrapper f451591b = null;

    private ECSearchSafeEventBusWrapper() {
    }

    static {
        f451591b = new ECSearchSafeEventBusWrapper();
        f451590a = LazyKt.lazy(ECSearchSafeEventBusWrapper$mListeners$2.INSTANCE);
    }

    public static void a(IECSearchSafeEventBusWrapper$EventListener r100) {
        Intrinsics.checkNotNullParameter(r100, "eventListener");
        Iterator r101 = ((List) f451590a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r100, (IECSearchSafeEventBusWrapper$EventListener) ((WeakReference) r101.next()).get()) == false) goto L4;
        return;
    L8:
        ((List) f451590a.getValue()).add(new WeakReference(r100));
    }

    @Subscribe
    public final void onReceiveEvent(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator r101 = ((List) f451590a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        WeakReference r102 = (WeakReference) r101.next();
        IECSearchSafeEventBusWrapper$EventListener r103 = (IECSearchSafeEventBusWrapper$EventListener) r102.get();
        if (r103 == null) goto L7;
        if (Intrinsics.areEqual(r103.b(), r100.getClass()) == false) goto L4;
        r103.a(r100);
        goto L4
    L7:
        ((List) f451590a.getValue()).remove(r102);
        goto L4
    }
}
