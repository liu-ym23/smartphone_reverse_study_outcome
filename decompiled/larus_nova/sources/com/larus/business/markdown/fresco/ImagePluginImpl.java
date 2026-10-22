package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J]\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/fresco/ImagePluginImpl;", "Lcom/larus/business/markdown/api/extplugin/image/e;", "", "imgBgColor", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "Landroid/graphics/Rect;", "defaultPlaceImageSize", "Lcom/larus/business/markdown/api/extplugin/image/a;", "customImgHandler", "", "", "", WsConstants.KEY_PAYLOAD, "Llsc/a;", "getPlugin", "(Ljava/lang/Integer;ILjava/lang/Integer;ILandroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/a;Ljava/util/Map;)Llsc/a;", "<init>", "()V", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1})
public final class ImagePluginImpl implements com.larus.business.markdown.api.extplugin.image.e {
    public ImagePluginImpl() {
    }

    @Override // com.larus.business.markdown.api.extplugin.image.e
    public lsc.a getPlugin(Integer r110, int r111, Integer r112, int r113, Rect r114, com.larus.business.markdown.api.extplugin.image.a r115, Map<String, ? extends Object> r116) {
        return new e(r110, r111, r112, r113, r114, r115, r116);
    }
}
