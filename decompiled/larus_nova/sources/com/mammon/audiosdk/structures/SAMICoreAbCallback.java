package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreAbConfigType;

/* JADX INFO: loaded from: classes4.dex */
public interface SAMICoreAbCallback {
    Boolean getSAMICoreAbBoolConfig(String r100);

    Object getSAMICoreAbConfig(String r100, SAMICoreAbConfigType r101);

    Float getSAMICoreAbFloatConfig(String r100);

    Integer getSAMICoreAbIntConfig(String r100);

    String getSAMICoreAbStringConfig(String r100);
}
