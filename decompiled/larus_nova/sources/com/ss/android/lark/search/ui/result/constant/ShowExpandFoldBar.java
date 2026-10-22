package com.ss.android.lark.search.ui.result.constant;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/search/ui/result/constant/ShowExpandFoldBar;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_EXPAND_FOLD_BAR", "HIDE_EXPAND_FOLD_BAR", AccountType.OTHERS, "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShowExpandFoldBar extends Enum<ShowExpandFoldBar> {
    public static final ShowExpandFoldBar HIDE_EXPAND_FOLD_BAR = null;
    public static final ShowExpandFoldBar OTHERS = null;
    public static final ShowExpandFoldBar SHOW_EXPAND_FOLD_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowExpandFoldBar[] f440304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440305b = null;

    public static EnumEntries<ShowExpandFoldBar> getEntries() {
        return f440305b;
    }

    static {
        ShowExpandFoldBar r100 = new ShowExpandFoldBar("SHOW_EXPAND_FOLD_BAR", 0);
        SHOW_EXPAND_FOLD_BAR = r100;
        ShowExpandFoldBar r101 = new ShowExpandFoldBar("HIDE_EXPAND_FOLD_BAR", 1);
        HIDE_EXPAND_FOLD_BAR = r101;
        ShowExpandFoldBar r102 = new ShowExpandFoldBar(AccountType.OTHERS, 2);
        OTHERS = r102;
        ShowExpandFoldBar[] r103 = {r100, r101, r102};
        f440304a = r103;
        f440305b = EnumEntriesKt.enumEntries(r103);
    }

    public static ShowExpandFoldBar[] values() {
        return (ShowExpandFoldBar[]) f440304a.clone();
    }

    public static ShowExpandFoldBar valueOf(String r100) {
        return (ShowExpandFoldBar) a.a(ShowExpandFoldBar.class, r100);
    }

    public ShowExpandFoldBar(String r100, int r101) {
        super(r100, r101);
    }
}
