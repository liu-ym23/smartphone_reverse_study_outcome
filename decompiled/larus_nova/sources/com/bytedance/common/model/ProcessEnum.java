package com.bytedance.common.model;

import android.text.TextUtils;
import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.ttnet.org.chromium.base.TTProcessUtils;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProcessEnum extends Enum<ProcessEnum> {
    private static final /* synthetic */ ProcessEnum[] $VALUES = null;
    public static final ProcessEnum MAIN = null;
    public static final ProcessEnum PUSH = null;
    public static final ProcessEnum PUSH_SERVICE = null;
    public static final ProcessEnum SMP = null;
    public static final ProcessEnum UNKNOWN = null;
    public String processSuffix;

    static {
        ProcessEnum r100 = new ProcessEnum(AccountType.MAIN, 0, ":main");
        MAIN = r100;
        ProcessEnum r101 = new ProcessEnum(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 1, TTProcessUtils.MESSAGE_PROCESS_SUFFIX);
        PUSH = r101;
        ProcessEnum r102 = new ProcessEnum("PUSH_SERVICE", 2, TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX);
        PUSH_SERVICE = r102;
        ProcessEnum r103 = new ProcessEnum("SMP", 3, ":smp");
        SMP = r103;
        ProcessEnum r104 = new ProcessEnum("UNKNOWN", 4, ":unknown");
        UNKNOWN = r104;
        $VALUES = new ProcessEnum[]{r100, r101, r102, r103, r104};
    }

    public static ProcessEnum[] values() {
        return (ProcessEnum[]) $VALUES.clone();
    }

    public static ProcessEnum parseProcess(String r100) {
        ProcessEnum r101 = MAIN;
        if (TextUtils.equals(r100, r101.processSuffix) == false) goto L5;
        return r101;
    L5:
        ProcessEnum r102 = PUSH;
        if (TextUtils.equals(r100, r102.processSuffix) == false) goto L8;
        return r102;
    L8:
        ProcessEnum r103 = PUSH_SERVICE;
        if (TextUtils.equals(r100, r103.processSuffix) == false) goto L11;
        return r103;
    L11:
        ProcessEnum r104 = SMP;
        if (TextUtils.equals(r100, r104.processSuffix) == false) goto L15;
        return r104;
    L15:
        return UNKNOWN;
    }

    public static ProcessEnum valueOf(String r100) {
        return (ProcessEnum) a.a(ProcessEnum.class, r100);
    }

    public static ProcessEnum parseProcess(String r100, String r101) {
        if (TextUtils.equals(r101, r100) == true) goto L5;
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        ProcessEnum r103 = PUSH;
        r102.append(r103.processSuffix);
        if (r100.equals(r102.toString()) == false) goto L9;
        return r103;
    L9:
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        ProcessEnum r105 = PUSH_SERVICE;
        r104.append(r105.processSuffix);
        if (r100.equals(r104.toString()) == false) goto L12;
        return r105;
    L12:
        StringBuilder r106 = new StringBuilder();
        r106.append(r101);
        ProcessEnum r107 = SMP;
        r106.append(r107.processSuffix);
        if (r100.equals(r106.toString()) == false) goto L16;
        return r107;
    L16:
        return UNKNOWN;
    L5:
        return MAIN;
    }

    private ProcessEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.processSuffix = r102;
    }
}
