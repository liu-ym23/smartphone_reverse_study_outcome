package com.bytedance.caijing.sdk.infra.base.api.plugin.settings;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.ee.bear.doc.structure.StructurePlugin;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/settings/IPluginSettingsService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "enableDefaultWebGlobalConfig", "", StructurePlugin.ENABLE_FONT_SCALE, "url", "", "enableGeckoCache", "expose", "getRedirectJsWorkerConfig", "Lorg/json/JSONObject;", "getSchemaAppendCommonParams", "", "getUrlAppendCommonParams", "isFontScaleUrl", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPluginSettingsService extends ICJService {
    boolean enableDefaultWebGlobalConfig();

    boolean enableFontScale(String r100);

    boolean enableGeckoCache(boolean r100);

    JSONObject getRedirectJsWorkerConfig();

    Map<String, String> getSchemaAppendCommonParams(String r100);

    Map<String, String> getUrlAppendCommonParams(String r100);

    boolean isFontScaleUrl(String r100);
}
