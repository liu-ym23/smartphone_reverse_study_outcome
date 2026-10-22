package com.obric.assistant.common.spi.settings;

import h37.c;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/assistant/common/spi/settings/IObricSettingRequestService;", "", "overrideSettingResponse", "", "response", "overrideByObricSettings", "Lorg/json/JSONObject;", "appSettings", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricSettingRequestService {
    void a(c r100);

    JSONObject b(JSONObject r100);
}
