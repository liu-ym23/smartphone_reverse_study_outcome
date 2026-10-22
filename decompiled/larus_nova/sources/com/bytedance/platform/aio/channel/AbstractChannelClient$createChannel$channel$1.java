package com.bytedance.platform.aio.channel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0016\u0010\u0004\u001a\u00120\u0002R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lcom/bytedance/platform/aio/channel/AbstractChannelClient$a;", "Lcom/bytedance/platform/aio/channel/AbstractChannelClient;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/platform/aio/channel/AbstractChannelClient$a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class AbstractChannelClient$createChannel$channel$1 extends FunctionReferenceImpl implements Function1<AbstractChannelClient<T, R>.a, Unit> {
    public AbstractChannelClient$createChannel$channel$1(AbstractChannelClient r100) {
        super(1, r100, AbstractChannelClient.class, "onChannelClosed", "onChannelClosed(Lcom/bytedance/platform/aio/channel/AbstractChannelClient$AbstractChannelImpl;)V", 0);
    }

    public final void invoke(AbstractChannelClient<T, R>.a r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        AbstractChannelClient r101 = (AbstractChannelClient) this.receiver;
        r101.f266556b.remove(r100.f266568h);
        r101.a(r100.f266568h);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke((AbstractChannelClient.a) r100);
        return Unit.INSTANCE;
    }
}
