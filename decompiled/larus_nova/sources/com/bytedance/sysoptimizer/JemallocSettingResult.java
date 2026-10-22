package com.bytedance.sysoptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class JemallocSettingResult {
    public int exitCode;
    public String optionName;
    public String rawValue;
    public String settingValue;

    public JemallocSettingResult(String r100, String r101, String r102, int r103) {
        this.optionName = r100;
        this.rawValue = r101;
        this.exitCode = r103;
        this.settingValue = r102;
    }
}
