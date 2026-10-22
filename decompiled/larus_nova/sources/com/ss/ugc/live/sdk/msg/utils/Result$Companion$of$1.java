package com.ss.ugc.live.sdk.msg.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001\"\n\b\u0002\u0010\u0003 \u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "V", ExifInterface.LONGITUDE_EAST, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 0})
public final class Result$Companion$of$1 extends Lambda implements Function0<Throwable> {
    public static final Result$Companion$of$1 INSTANCE = null;

    static {
        INSTANCE = new Result$Companion$of$1();
    }

    public Result$Companion$of$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Throwable invoke2() {
        return new Throwable();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Throwable invoke() {
        return invoke2();
    }
}
