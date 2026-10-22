package h22;

import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class a implements ILivePreInflateService {
    private Map<String, Integer> themeMap;

    public a() {
        this.themeMap = new HashMap();
    }

    @Override // com.bytedance.android.livesdkapi.util.ILivePreInflateService
    public int getHostActivityTheme(String r100) {
        Integer r101 = this.themeMap.get(r100);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.intValue();
    }

    @Override // com.bytedance.android.livesdkapi.util.ILivePreInflateService
    public void initHostActivityTheme(Map<String, Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        this.themeMap.putAll(r100);
        return;
    }
}
