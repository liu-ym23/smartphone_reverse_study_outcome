package com.larus.platform.kmp.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateOPScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FILL_MESSAGE_TEXT", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TemplateInfo$TemplateOPScene extends Enum<TemplateInfo$TemplateOPScene> {
    public static final TemplateInfo$TemplateOPScene DEFAULT = null;
    public static final TemplateInfo$TemplateOPScene FILL_MESSAGE_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateInfo$TemplateOPScene[] f365428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365429b = null;

    public static EnumEntries<TemplateInfo$TemplateOPScene> getEntries() {
        return f365429b;
    }

    static {
        TemplateInfo$TemplateOPScene r100 = new TemplateInfo$TemplateOPScene("DEFAULT", 0);
        DEFAULT = r100;
        TemplateInfo$TemplateOPScene r101 = new TemplateInfo$TemplateOPScene("FILL_MESSAGE_TEXT", 1);
        FILL_MESSAGE_TEXT = r101;
        TemplateInfo$TemplateOPScene[] r102 = {r100, r101};
        f365428a = r102;
        f365429b = EnumEntriesKt.enumEntries(r102);
    }

    public static TemplateInfo$TemplateOPScene[] values() {
        return (TemplateInfo$TemplateOPScene[]) f365428a.clone();
    }

    public static TemplateInfo$TemplateOPScene valueOf(String r100) {
        return (TemplateInfo$TemplateOPScene) a.a(TemplateInfo$TemplateOPScene.class, r100);
    }

    public TemplateInfo$TemplateOPScene(String r100, int r101) {
        super(r100, r101);
    }
}
