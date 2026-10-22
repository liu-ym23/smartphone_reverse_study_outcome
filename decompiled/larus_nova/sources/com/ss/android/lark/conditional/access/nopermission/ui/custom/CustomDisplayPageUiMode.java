package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LARK, "DOUBAO", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomDisplayPageUiMode extends Enum<CustomDisplayPageUiMode> {
    public static final CustomDisplayPageUiMode DOUBAO = null;
    public static final CustomDisplayPageUiMode LARK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomDisplayPageUiMode[] f418299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f418300b = null;

    public static EnumEntries<CustomDisplayPageUiMode> getEntries() {
        return f418300b;
    }

    static {
        CustomDisplayPageUiMode r100 = new CustomDisplayPageUiMode(AccountType.LARK, 0);
        LARK = r100;
        CustomDisplayPageUiMode r101 = new CustomDisplayPageUiMode("DOUBAO", 1);
        DOUBAO = r101;
        CustomDisplayPageUiMode[] r102 = {r100, r101};
        f418299a = r102;
        f418300b = EnumEntriesKt.enumEntries(r102);
    }

    public static CustomDisplayPageUiMode[] values() {
        return (CustomDisplayPageUiMode[]) f418299a.clone();
    }

    public static CustomDisplayPageUiMode valueOf(String r100) {
        return (CustomDisplayPageUiMode) r27.a.a(CustomDisplayPageUiMode.class, r100);
    }

    public CustomDisplayPageUiMode(String r100, int r101) {
        super(r100, r101);
    }
}
