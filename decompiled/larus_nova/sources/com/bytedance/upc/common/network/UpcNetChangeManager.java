package com.bytedance.upc.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/upc/common/network/UpcNetChangeManager;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public final class UpcNetChangeManager extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f272465b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f272466c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.upc.common.network.a> f272467a;

    public static final class a {
        public a() {
        }
    }

    static {
        f272466c = new a();
        f272465b = LazyKt.lazy(UpcNetChangeManager$Companion$mUpcNetChangeManager$2.INSTANCE);
    }

    public UpcNetChangeManager() {
        this.f272467a = new ArrayList();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L14;
        String r102 = null;
    L6:
        if (Intrinsics.areEqual(r102, "android.net.conn.CONNECTIVITY_CHANGE") == false) goto L12;
        Iterator<T> r103 = this.f272467a.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L18;
        ((com.bytedance.upc.common.network.a) r103.next()).a();     // Catch: Throwable -> L13
        goto L8
    L18:
        return;
    L17:
        return;
    L12:
        return;
    L14:
        r102 = r101.getAction();     // Catch: Throwable -> L13
        goto L6
    }
}
