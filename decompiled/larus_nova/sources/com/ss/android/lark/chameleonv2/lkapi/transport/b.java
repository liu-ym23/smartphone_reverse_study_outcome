package com.ss.android.lark.chameleonv2.lkapi.transport;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends AbsChameleonHandler<ITransport$Internal$SubscribeRustPushRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<c> f411454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f411455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Integer> f411456c;

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f411455b;
    }

    public b(WeakReference<c> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_TRANSPORT);
        this.f411454a = r100;
        this.f411455b = LKAPIModules.Internal.Transport.SubscribeRustPush.getValue();
        this.f411456c = new LinkedHashSet();
    }

    public final <T> void a(int r100, T r101) {
        IChameleonHandlerContext r102 = getContext();
        if (r102 == null) goto L6;
        r102.sendEvent(ITransport$Ipc$EventType.SDK_PUSH.getValue(), new ITransport$Ipc$TransportPushDetail(r100, r101, new ITransport$Ipc$RustSdkPacketDetail("")));
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(ITransport$Internal$SubscribeRustPushRequest r100, Callback r101) {
        ITransport$Internal$SubscribeRustPushRequest r102 = r100;
        Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (getContext() != null) goto L5;
        r101.error(new LKAPIError(-1, "context is null"));
        return;
    L5:
        IChameleonHandlerContext r103 = getContext();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.chameleon.IChameleonHandlerContext");
        String r104 = r103.getBizName();
        Iterator<ITransport$Internal$SubscribePushInfo> r105 = r102.getCommands().iterator();
    L7:
        if (r105.hasNext() == false) goto L34;
        ITransport$Internal$SubscribePushInfo r106 = r105.next();
        int r107 = WhiteMap.f411452a;
        if (WhiteMap.a(r104, r106.getCommand()) == false) goto L7;
        if (this.f411456c.contains(Integer.valueOf(r106.getCommand())) == true) goto L7;
        Command r108 = Command.fromValue(r106.getCommand());
        if (r108 == null) goto L25;
        this.f411456c.add(Integer.valueOf(r106.getCommand()));
        c r109 = this.f411454a.get();
        if (r109 == null) goto L25;
        Intrinsics.checkNotNullParameter(r108, "cmd");
        Application r110 = LarkContext.getApplication();
        if (r110 == null) goto L25;
        q1b.a r111 = (q1b.a) k.a(r110, q1b.a.class);
        if (r111 == null) goto L25;
        l r112 = r111.g();
        if (r112 == null) goto L25;
        Disposable r113 = r112.a(r108).subscribe(new d(r109));
        Set<Disposable> r114 = r109.f411459b;
        Intrinsics.checkNotNull(r113);
        r114.add(r113);
    L25:
        r101.success(null);
        goto L7
    }
}
