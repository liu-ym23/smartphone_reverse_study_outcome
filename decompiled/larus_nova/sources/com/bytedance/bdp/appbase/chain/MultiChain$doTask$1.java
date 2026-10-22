package com.bytedance.bdp.appbase.chain;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0000 \u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/bdp/appbase/chain/d0;", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Throwable;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class MultiChain$doTask$1 extends Lambda implements Function2 {
    public static final MultiChain$doTask$1 INSTANCE = null;

    static {
        INSTANCE = new MultiChain$doTask$1();
    }

    public MultiChain$doTask$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((f) r100, (Throwable) r101);
    }

    public final Void invoke(f r100, Throwable r101) {
        throw r101;
    }
}
