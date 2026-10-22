package ti1;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;

/* JADX INFO: loaded from: classes7.dex */
public interface b extends IAbility {
    boolean am(String r100);

    boolean cm(EXTERNAL_CONFIG_TYPE r100, String r101);

    boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101);

    void e8(LiveExternalConfig r100, String r101);

    IExternalConfigJudger getExternalConfigJudger();
}
