package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "Handled", "NotHandled", "Rejected", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeFolderActionResult extends Enum<OfficeFolderActionResult> implements Serializable {
    public static final OfficeFolderActionResult Handled = null;
    public static final OfficeFolderActionResult NotHandled = null;
    public static final OfficeFolderActionResult Rejected = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeFolderActionResult[] f235446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235447b = null;

    public static EnumEntries<OfficeFolderActionResult> getEntries() {
        return f235447b;
    }

    static {
        OfficeFolderActionResult r100 = new OfficeFolderActionResult("Handled", 0);
        Handled = r100;
        OfficeFolderActionResult r101 = new OfficeFolderActionResult("NotHandled", 1);
        NotHandled = r101;
        OfficeFolderActionResult r102 = new OfficeFolderActionResult("Rejected", 2);
        Rejected = r102;
        OfficeFolderActionResult[] r103 = {r100, r101, r102};
        f235446a = r103;
        f235447b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeFolderActionResult[] values() {
        return (OfficeFolderActionResult[]) f235446a.clone();
    }

    public static OfficeFolderActionResult valueOf(String r100) {
        return (OfficeFolderActionResult) r27.a.a(OfficeFolderActionResult.class, r100);
    }

    public OfficeFolderActionResult(String r100, int r101) {
        super(r100, r101);
    }
}
