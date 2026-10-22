package com.larus.bmhome.block.holder.content.lynx;

import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.platform.api.e4;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/IvyPluginViewPool;", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "maxKeyCount", "", "maxPerKey", "asViewGroupChild", "Lkotlin/Function1;", "Lcom/larus/platform/api/IvyPluginView;", "Landroid/view/View;", "<init>", "(Landroidx/lifecycle/Lifecycle;IILkotlin/jvm/functions/Function1;)V", "buckets", "Landroid/util/LruCache;", "", "Lkotlin/collections/ArrayDeque;", "acquire", "key", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", BaseSwitches.V, "clearAll", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "Landroidx/lifecycle/LifecycleOwner;", "detachFromParent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IvyPluginViewPool extends SafeLifecycleObserver implements eh8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f296163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<e4, View> f296164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, ArrayDeque<e4>> f296165c;

    public static final class a {
    }

    static {
    }

    public final void c(e4 r100) {
        View r101 = this.f296164b.invoke(r100);
        ViewGroup r102 = null;
        if (r101 == null) goto L5;
        ViewParent r103 = r101.getParent();
    L7:
        if ((r103 instanceof ViewGroup) == false) goto L9;
        r102 = (ViewGroup) r103;
    L9:
        if (r102 == null) goto L12;
        r102.removeView(r101);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.larus.utils.lifecycle.SafeLifecycleObserver, androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Iterator<T> r101 = this.f296165c.snapshot().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ArrayDeque r102 = (ArrayDeque) r101.next();
        Intrinsics.checkNotNull(r102);
        Iterator<E> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        c((e4) r103.next());
        goto L7
    L9:
        this.f296165c.evictAll();
        FLogger.f375446a.i("IvyViewPool", "clearAll");
    }

    @Override // eh8.b
    public final void a(String r100, e4 r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        FLogger.f375446a.i("IvyViewPool", "release to pool ".concat(r100));
        c(r101);
        ArrayDeque<e4> r102 = this.f296165c.get(r100);
        if (r102 != null) goto L6;
        r102 = new ArrayDeque();
        this.f296165c.put(r100, r102);
    L6:
        if (r102.size() < this.f296163a) goto L8;
        return;
    L8:
        r102.addLast(r101);
    }

    @Override // eh8.b
    public final e4 b(String r100, String r101) {
        ArrayDeque<e4> r102 = this.f296165c.get(r100);
        if (r102 != null) goto L5;
    L7:
        e4 r103 = null;
    L8:
        if (r103 != null) goto L10;
        return null;
    L10:
        c(r103);
        return r103;
    L5:
        if ((!r102.isEmpty()) == false) goto L7;
        FLogger.f375446a.i("IvyViewPool", "acquire from pool: size=" + r102.size() + " key=" + r100);
        r103 = r102.removeFirst();
        r103.updateData(r101);
        goto L8
    }

    public IvyPluginViewPool(LifecycleRegistry r100, int r101, int r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r103, "asViewGroupChild");
        this.f296163a = r102;
        this.f296164b = r103;
        this.f296165c = new LruCache(r101);
        r100.addObserver(this);
    }
}
