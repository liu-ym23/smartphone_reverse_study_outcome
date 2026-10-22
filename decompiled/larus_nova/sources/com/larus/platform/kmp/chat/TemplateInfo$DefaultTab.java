package com.larus.platform.kmp.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$DefaultTab;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT", "TEMPLATE", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TemplateInfo$DefaultTab extends Enum<TemplateInfo$DefaultTab> {
    public static final TemplateInfo$DefaultTab CHAT = null;
    public static final TemplateInfo$DefaultTab TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateInfo$DefaultTab[] f365408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365409b = null;

    public static EnumEntries<TemplateInfo$DefaultTab> getEntries() {
        return f365409b;
    }

    static {
        TemplateInfo$DefaultTab r100 = new TemplateInfo$DefaultTab("CHAT", 0);
        CHAT = r100;
        TemplateInfo$DefaultTab r101 = new TemplateInfo$DefaultTab("TEMPLATE", 1);
        TEMPLATE = r101;
        TemplateInfo$DefaultTab[] r102 = {r100, r101};
        f365408a = r102;
        f365409b = EnumEntriesKt.enumEntries(r102);
    }

    public static TemplateInfo$DefaultTab[] values() {
        return (TemplateInfo$DefaultTab[]) f365408a.clone();
    }

    public static TemplateInfo$DefaultTab valueOf(String r100) {
        return (TemplateInfo$DefaultTab) a.a(TemplateInfo$DefaultTab.class, r100);
    }

    public TemplateInfo$DefaultTab(String r100, int r101) {
        super(r100, r101);
    }
}
