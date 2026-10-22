package com.ss.android.lark.passportc.convention;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import e0c.l;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", MonitorConstants.CONNECT_TYPE_GET, "()Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class MutableProxyKt$createProxy$2<T> implements Provider {
    final /* synthetic */ v $accessor;
    final /* synthetic */ Function1<l, T> $finder;
    final /* synthetic */ UserSession $session;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableProxyKt$createProxy$2(Function1<? super l, ? extends T> r100, v r101, UserSession r102) {
        this.$finder = r100;
        this.$accessor = r101;
        this.$session = r102;
    }

    @Override // javax.inject.Provider
    public final T get() {
        Function1<l, T> r100 = this.$finder;
        v r101 = this.$accessor;
        UserSession r102 = this.$session;
        if (r102 != null) goto L6;
        r102 = ContainerConstsKt.a();
    L6:
        return r100.invoke(r101.c(r102));
    }
}
