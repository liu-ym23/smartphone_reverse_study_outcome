package zb9;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571198a = null;

    static {
        int[] r100 = new int[GroupSortPolicy.values().length];
        r100[GroupSortPolicy.UpdateTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[GroupSortPolicy.CreateTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[GroupSortPolicy.PinTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f571198a = r100;
    }
}
