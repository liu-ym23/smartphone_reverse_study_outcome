package com.larus.business.multitask_management.impl.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/QuickAccessNodeDefaultFileIcons;", "", "fileType", "", "resId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getFileType", "()Ljava/lang/String;", "getResId", "()I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickAccessNodeDefaultFileIcons extends Enum<QuickAccessNodeDefaultFileIcons> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickAccessNodeDefaultFileIcons[] f321160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321161b = null;
    private final String fileType;
    private final int resId;

    static {
        QuickAccessNodeDefaultFileIcons[] r100 = new QuickAccessNodeDefaultFileIcons[0];
        f321160a = r100;
        f321161b = EnumEntriesKt.enumEntries(r100);
    }

    public static EnumEntries<QuickAccessNodeDefaultFileIcons> getEntries() {
        return f321161b;
    }

    public static QuickAccessNodeDefaultFileIcons[] values() {
        return (QuickAccessNodeDefaultFileIcons[]) f321160a.clone();
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final int getResId() {
        return this.resId;
    }

    public static QuickAccessNodeDefaultFileIcons valueOf(String r100) {
        return (QuickAccessNodeDefaultFileIcons) r27.a.a(QuickAccessNodeDefaultFileIcons.class, r100);
    }
}
