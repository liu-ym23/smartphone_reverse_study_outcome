package com.ss.android.ugc.aweme.framework.services.dyext;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.framework.services.dyext.config.FlavorConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0004\u001a1\u0010\u0005\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"onDouyin", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "onDyLite", "dy-ext-spi_release"}, k = 2, mv = {1, 1, 15})
public final class FlavorUtils {
    public static final <T> T onDouyin(Function0<? extends T> r100) {
        FlavorConfig r101 = FlavorConfig.INSTANCE;
        r101.ensureFlavorSet();
        if (r101.getFlavor() == 0) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    public static final <T> T onDyLite(Function0<? extends T> r100) {
        FlavorConfig r101 = FlavorConfig.INSTANCE;
        r101.ensureFlavorSet();
        if (r101.getFlavor() == 1) goto L7;
        return null;
    L7:
        return r100.invoke();
    }
}
