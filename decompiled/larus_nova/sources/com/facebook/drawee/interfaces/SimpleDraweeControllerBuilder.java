package com.facebook.drawee.interfaces;

import android.net.Uri;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface SimpleDraweeControllerBuilder {
    DraweeController build();

    SimpleDraweeControllerBuilder setCallerContext(Object r100);

    SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController r100);

    SimpleDraweeControllerBuilder setUri(Uri r100);

    SimpleDraweeControllerBuilder setUri(Uri r100, String r101, String r102);

    SimpleDraweeControllerBuilder setUri(@Nullable String r100);

    SimpleDraweeControllerBuilder setUris(List<Uri> r100);
}
