package q5c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class a {
    private Map<String, Object> defaultParamsMap;

    public final Map<String, Object> createParams() {
        return new HashMap();
    }

    public a() {
        this.defaultParamsMap = createParams();
    }

    public final Map<String, Object> getDefaultParamsMap() {
        return this.defaultParamsMap;
    }
}
