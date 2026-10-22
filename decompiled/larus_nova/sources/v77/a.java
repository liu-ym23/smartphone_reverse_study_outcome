package v77;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class a {

    @SerializedName("business_custom_sys_dialog_config_map")
    public Map<String, g> businessCustomSysDialogConfigMap;

    @SerializedName("is_valid_settings")
    public boolean isValidSettings;

    @SerializedName("custom_dialog_rs_config")
    public p67.a mCustomDialogRiskDeviceFilterConfig;

    @SerializedName("support_dark_mode")
    public boolean supportDarkMode;

    @SerializedName("toast_dialog_interval")
    public int toastDialogInterval;

    public a() {
        this.isValidSettings = false;
        this.toastDialogInterval = 30000;
        this.businessCustomSysDialogConfigMap = new HashMap();
    }
}
