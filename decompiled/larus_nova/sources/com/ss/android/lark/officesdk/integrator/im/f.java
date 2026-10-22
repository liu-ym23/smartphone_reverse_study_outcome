package com.ss.android.lark.officesdk.integrator.im;

import android.view.View;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {
    public f() {
    }

    public final com.ss.android.lark.export.d<? extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> a(EngineProperty.EngineType r100) {
        Intrinsics.checkNotNullParameter(r100, "engineType");
        UrlPreviewApi r101 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getEngineComponentFactory(r100);
    }

    public final com.ss.android.lark.export.c<? extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> b(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        UrlPreviewApi r101 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getUrlComponentFactory(r100);
    }
}
