package com.larus.platform.kmp.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateVersion;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MASONRY_LAYOUT", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TemplateInfo$TemplateVersion extends Enum<TemplateInfo$TemplateVersion> {
    public static final TemplateInfo$TemplateVersion DEFAULT = null;
    public static final TemplateInfo$TemplateVersion MASONRY_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateInfo$TemplateVersion[] f365444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365445b = null;

    public static EnumEntries<TemplateInfo$TemplateVersion> getEntries() {
        return f365445b;
    }

    static {
        TemplateInfo$TemplateVersion r100 = new TemplateInfo$TemplateVersion("DEFAULT", 0);
        DEFAULT = r100;
        TemplateInfo$TemplateVersion r101 = new TemplateInfo$TemplateVersion("MASONRY_LAYOUT", 1);
        MASONRY_LAYOUT = r101;
        TemplateInfo$TemplateVersion[] r102 = {r100, r101};
        f365444a = r102;
        f365445b = EnumEntriesKt.enumEntries(r102);
    }

    public static TemplateInfo$TemplateVersion[] values() {
        return (TemplateInfo$TemplateVersion[]) f365444a.clone();
    }

    public static TemplateInfo$TemplateVersion valueOf(String r100) {
        return (TemplateInfo$TemplateVersion) a.a(TemplateInfo$TemplateVersion.class, r100);
    }

    public TemplateInfo$TemplateVersion(String r100, int r101) {
        super(r100, r101);
    }
}
