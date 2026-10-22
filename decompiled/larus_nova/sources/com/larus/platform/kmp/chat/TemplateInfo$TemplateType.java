package com.larus.platform.kmp.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", "", "<init>", "(Ljava/lang/String;I)V", "AI_ARTIST", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TemplateInfo$TemplateType extends Enum<TemplateInfo$TemplateType> {
    public static final TemplateInfo$TemplateType AI_ARTIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateInfo$TemplateType[] f365442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365443b = null;

    public static EnumEntries<TemplateInfo$TemplateType> getEntries() {
        return f365443b;
    }

    static {
        TemplateInfo$TemplateType r100 = new TemplateInfo$TemplateType();
        AI_ARTIST = r100;
        TemplateInfo$TemplateType[] r101 = {r100};
        f365442a = r101;
        f365443b = EnumEntriesKt.enumEntries(r101);
    }

    public TemplateInfo$TemplateType() {
        super("AI_ARTIST", 0);
    }

    public static TemplateInfo$TemplateType[] values() {
        return (TemplateInfo$TemplateType[]) f365442a.clone();
    }

    public static TemplateInfo$TemplateType valueOf(String r100) {
        return (TemplateInfo$TemplateType) a.a(TemplateInfo$TemplateType.class, r100);
    }
}
