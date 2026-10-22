package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/lark/HumanFeedScope;", "", "<init>", "(Ljava/lang/String;I)V", CancelRetainContactInfoFunctions.All, "Pinned", "Unpinned", "matches", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/home/impl/main/side_bar/view/group/datasource/lark/HumanFeedItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HumanFeedScope extends Enum<HumanFeedScope> {
    public static final HumanFeedScope All = null;
    public static final HumanFeedScope Pinned = null;
    public static final HumanFeedScope Unpinned = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HumanFeedScope[] f345401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345402b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345403a = null;

        static {
            int[] r100 = new int[HumanFeedScope.values().length];
            r100[HumanFeedScope.All.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[HumanFeedScope.Pinned.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[HumanFeedScope.Unpinned.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f345403a = r100;
        }
    }

    public static EnumEntries<HumanFeedScope> getEntries() {
        return f345402b;
    }

    static {
        HumanFeedScope r100 = new HumanFeedScope(CancelRetainContactInfoFunctions.All, 0);
        All = r100;
        HumanFeedScope r101 = new HumanFeedScope("Pinned", 1);
        Pinned = r101;
        HumanFeedScope r102 = new HumanFeedScope("Unpinned", 2);
        Unpinned = r102;
        HumanFeedScope[] r103 = {r100, r101, r102};
        f345401a = r103;
        f345402b = EnumEntriesKt.enumEntries(r103);
    }

    public static HumanFeedScope[] values() {
        return (HumanFeedScope[]) f345401a.clone();
    }

    public static HumanFeedScope valueOf(String r100) {
        return (HumanFeedScope) r27.a.a(HumanFeedScope.class, r100);
    }

    public final boolean matches(d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = a.f345403a[ordinal()];
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L13;
        if (r100.b() == false) goto L18;
        return false;
    L18:
        return true;
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        return r100.b();
    }

    public HumanFeedScope(String r100, int r101) {
        super(r100, r101);
    }
}
