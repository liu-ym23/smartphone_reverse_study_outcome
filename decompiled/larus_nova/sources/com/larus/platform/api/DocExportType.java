package com.larus.platform.api;

import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/DocExportType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConfiguration.KEY_SEARCH_WORD, ExportFileExtension.PDF, "txt", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocExportType extends Enum<DocExportType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocExportType[] f364764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364765b = null;
    public static final DocExportType pdf = null;
    public static final DocExportType txt = null;
    public static final DocExportType word = null;

    public static EnumEntries<DocExportType> getEntries() {
        return f364765b;
    }

    static {
        DocExportType r100 = new DocExportType(EffectConfiguration.KEY_SEARCH_WORD, 0);
        word = r100;
        DocExportType r101 = new DocExportType(ExportFileExtension.PDF, 1);
        pdf = r101;
        DocExportType r102 = new DocExportType("txt", 2);
        txt = r102;
        DocExportType[] r103 = {r100, r101, r102};
        f364764a = r103;
        f364765b = EnumEntriesKt.enumEntries(r103);
    }

    public static DocExportType[] values() {
        return (DocExportType[]) f364764a.clone();
    }

    public static DocExportType valueOf(String r100) {
        return (DocExportType) r27.a.a(DocExportType.class, r100);
    }

    public DocExportType(String r100, int r101) {
        super(r100, r101);
    }
}
