package com.ss.android.lark.contact.customized.externalcontact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/OfficeExternalContactMode;", "", "<init>", "(Ljava/lang/String;I)V", "PERSONAL_CONTACTS", "ENTERPRISE_CONTACTS", "EXTERNAL_CONTACTS", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeExternalContactMode extends Enum<OfficeExternalContactMode> {
    public static final OfficeExternalContactMode ENTERPRISE_CONTACTS = null;
    public static final OfficeExternalContactMode EXTERNAL_CONTACTS = null;
    public static final OfficeExternalContactMode PERSONAL_CONTACTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeExternalContactMode[] f419103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f419104b = null;

    public static EnumEntries<OfficeExternalContactMode> getEntries() {
        return f419104b;
    }

    static {
        OfficeExternalContactMode r100 = new OfficeExternalContactMode("PERSONAL_CONTACTS", 0);
        PERSONAL_CONTACTS = r100;
        OfficeExternalContactMode r101 = new OfficeExternalContactMode("ENTERPRISE_CONTACTS", 1);
        ENTERPRISE_CONTACTS = r101;
        OfficeExternalContactMode r102 = new OfficeExternalContactMode("EXTERNAL_CONTACTS", 2);
        EXTERNAL_CONTACTS = r102;
        OfficeExternalContactMode[] r103 = {r100, r101, r102};
        f419103a = r103;
        f419104b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeExternalContactMode[] values() {
        return (OfficeExternalContactMode[]) f419103a.clone();
    }

    public static OfficeExternalContactMode valueOf(String r100) {
        return (OfficeExternalContactMode) a.a(OfficeExternalContactMode.class, r100);
    }

    public OfficeExternalContactMode(String r100, int r101) {
        super(r100, r101);
    }
}
