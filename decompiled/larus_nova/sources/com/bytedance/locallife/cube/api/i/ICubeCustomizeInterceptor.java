package com.bytedance.locallife.cube.api.i;

import android.net.Uri;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/cube/api/i/ICubeCustomizeInterceptor;", "", "appendCacheUniqueKey", "", "schemaModel", "Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "schemaUri", "Landroid/net/Uri;", "getFontScale", "", "cubeConfig", "Lcom/bytedance/locallife/cube/api/config/CubeConfig;", "(Lcom/bytedance/locallife/cube/api/config/CubeConfig;)Ljava/lang/Float;", "interceptSchema", "originSchemaUri", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ICubeCustomizeInterceptor {
    String appendCacheUniqueKey(CubeInternalSchemaModel r100, Uri r101);

    Float getFontScale(CubeConfig r100);

    Uri interceptSchema(Uri r100);
}
