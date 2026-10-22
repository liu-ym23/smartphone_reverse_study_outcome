package com.ss.android.lark.officesdk.contact.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactSettingsItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE", "contact-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeContactSettingsItemAction extends Enum<OfficeContactSettingsItemAction> {
    public static final OfficeContactSettingsItemAction TOGGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeContactSettingsItemAction[] f433138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433139b = null;

    public static EnumEntries<OfficeContactSettingsItemAction> getEntries() {
        return f433139b;
    }

    static {
        OfficeContactSettingsItemAction r100 = new OfficeContactSettingsItemAction();
        TOGGLE = r100;
        OfficeContactSettingsItemAction[] r101 = {r100};
        f433138a = r101;
        f433139b = EnumEntriesKt.enumEntries(r101);
    }

    public OfficeContactSettingsItemAction() {
        super("TOGGLE", 0);
    }

    public static OfficeContactSettingsItemAction[] values() {
        return (OfficeContactSettingsItemAction[]) f433138a.clone();
    }

    public static OfficeContactSettingsItemAction valueOf(String r100) {
        return (OfficeContactSettingsItemAction) a.a(OfficeContactSettingsItemAction.class, r100);
    }
}
