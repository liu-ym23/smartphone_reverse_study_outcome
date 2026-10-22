package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/utils/ExternalRedirectPromptFrequencyConfig;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "FIRST_USE_ONLY", "EACH_DOMAIN", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalRedirectPromptFrequencyConfig extends Enum<ExternalRedirectPromptFrequencyConfig> {
    public static final ExternalRedirectPromptFrequencyConfig EACH_DOMAIN = null;
    public static final ExternalRedirectPromptFrequencyConfig FIRST_USE_ONLY = null;
    public static final ExternalRedirectPromptFrequencyConfig NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalRedirectPromptFrequencyConfig[] f314882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314883b = null;

    public static EnumEntries<ExternalRedirectPromptFrequencyConfig> getEntries() {
        return f314883b;
    }

    static {
        ExternalRedirectPromptFrequencyConfig r100 = new ExternalRedirectPromptFrequencyConfig("NEVER", 0);
        NEVER = r100;
        ExternalRedirectPromptFrequencyConfig r101 = new ExternalRedirectPromptFrequencyConfig("FIRST_USE_ONLY", 1);
        FIRST_USE_ONLY = r101;
        ExternalRedirectPromptFrequencyConfig r102 = new ExternalRedirectPromptFrequencyConfig("EACH_DOMAIN", 2);
        EACH_DOMAIN = r102;
        ExternalRedirectPromptFrequencyConfig[] r103 = {r100, r101, r102};
        f314882a = r103;
        f314883b = EnumEntriesKt.enumEntries(r103);
    }

    public static ExternalRedirectPromptFrequencyConfig[] values() {
        return (ExternalRedirectPromptFrequencyConfig[]) f314882a.clone();
    }

    public static ExternalRedirectPromptFrequencyConfig valueOf(String r100) {
        return (ExternalRedirectPromptFrequencyConfig) r27.a.a(ExternalRedirectPromptFrequencyConfig.class, r100);
    }

    public ExternalRedirectPromptFrequencyConfig(String r100, int r101) {
        super(r100, r101);
    }
}
