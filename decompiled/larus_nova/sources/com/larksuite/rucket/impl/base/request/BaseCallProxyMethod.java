package com.larksuite.rucket.impl.base.request;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.h;
import g38.c;
import g38.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class BaseCallProxyMethod<T extends Annotation> extends BaseProxyMethod<T> {

    public static final class a {
    }

    static {
    }

    public abstract void f(Message r100, IGetDataCallback r101, String r102, c r103, StreamDataSource r104, h r105);

    public BaseCallProxyMethod(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        super(r100);
    }

    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r100, Object... r110) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r110, "args");
        ArrayList r101 = new ArrayList();
        int r102 = r110.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Object r105 = r110[r104];
        if (TypeIntrinsics.isFunctionOfArity(r105, 1) == false) goto L7;
        r101.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        Function1 r106 = (Function1) CollectionsKt.firstOrNull(r101);
        if (r106 != null) goto L11;
        r106 = BaseCallProxyMethod$invokeWithCallback$configHandler$1.INSTANCE;
    L11:
        ArrayList r107 = new ArrayList();
        int r108 = r110.length;
    L12:
        if (r103 >= r108) goto L17;
        Object r109 = r110[r103];
        if ((r109 instanceof Message) == false) goto L16;
        r107.add(r109);
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        Message r111 = (Message) CollectionsKt.first(r107);
        b r112 = new b();
        r106.invoke(r112);
        String r113 = r112.f286069b;
        h r114 = r112.f286070c;
        StreamDataSource r115 = r112.f286068a.toSource();
        int r116 = d.f479871a;
        Class<U> r117 = e();
        Intrinsics.checkNotNullParameter(r117, "clazz");
        f(r111, r100, r113, new c(r117), r115, r114);
    }
}
