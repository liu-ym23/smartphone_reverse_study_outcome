package com.larksuite.component.universe_design.dialog.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/UDDialogActionRole;", "", "<init>", "(Ljava/lang/String;I)V", "Primary", "Secondary", "Danger", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDDialogActionRole extends Enum<UDDialogActionRole> {
    public static final UDDialogActionRole Danger = null;
    public static final UDDialogActionRole Primary = null;
    public static final UDDialogActionRole Secondary = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDDialogActionRole[] f284895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284896b = null;

    public static EnumEntries<UDDialogActionRole> getEntries() {
        return f284896b;
    }

    static {
        UDDialogActionRole r100 = new UDDialogActionRole("Primary", 0);
        Primary = r100;
        UDDialogActionRole r101 = new UDDialogActionRole("Secondary", 1);
        Secondary = r101;
        UDDialogActionRole r102 = new UDDialogActionRole("Danger", 2);
        Danger = r102;
        UDDialogActionRole[] r103 = {r100, r101, r102};
        f284895a = r103;
        f284896b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDDialogActionRole[] values() {
        return (UDDialogActionRole[]) f284895a.clone();
    }

    public static UDDialogActionRole valueOf(String r100) {
        return (UDDialogActionRole) r27.a.a(UDDialogActionRole.class, r100);
    }

    public UDDialogActionRole(String r100, int r101) {
        super(r100, r101);
    }
}
