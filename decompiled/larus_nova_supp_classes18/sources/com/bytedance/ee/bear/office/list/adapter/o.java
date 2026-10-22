package com.bytedance.ee.bear.office.list.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final Function0<Fragment> a;
    public final ce5.a b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeListSortFilterScene.Kind.values().length];
            r0[OfficeListSortFilterScene.Kind.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OfficeListSortFilterScene.Kind.SHARED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OfficeListSortFilterScene.Kind.MY_ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OfficeListSortFilterScene.Kind.SUB_FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficeListSortFilterScene.Kind.SHARED_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OfficeListSortFilterScene.Kind.FAVORITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public final FolderSortStrategy c(OfficeListSortFilterScene r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Fragment r0 = (Fragment) this.a.invoke();
        Pair r1 = null;
        if (r0 == null) goto L5;
        FragmentActivity r2 = r0.getActivity();
    L6:
        if (r2 == null) goto L8;
        FolderSortStrategy r3 = (FolderSortStrategy) ((SortAndFilterViewModel) new ViewModelProvider(r2).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().getValue();
    L9:
        if (r3 == null) goto L11;
        String r4 = r3.a;
    L13:
        if (Intrinsics.areEqual(r4, r10.b) == false) goto L41;
        return r3;
    L41:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        Object r6 = Result.constructor-impl(((mc5.j) this.b.a(mc5.j.class)).m1(r10.b));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = null;
    L22:
        FolderSortStrategy r7 = (FolderSortStrategy) r6;
        if (r7 == null) goto L25;
    L40:
        return r7;
    L25:
        switch(b.a[r10.a.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L32;
            default: goto L27;
        };
    L28:
        FolderSort r8 = FolderSort.SHARED_TIME;
        r1 = TuplesKt.to(Integer.valueOf(r8.getRank()), Boolean.valueOf(r8.getAsc()));
        goto L32
    L29:
        FolderSort r9 = FolderSort.MODIFIED_TIME;
        r1 = TuplesKt.to(Integer.valueOf(r9.getRank()), Boolean.valueOf(r9.getAsc()));
        goto L32
    L30:
        ShareFileSort r11 = ShareFileSort.SHARE_TIME;
        r1 = TuplesKt.to(Integer.valueOf(r11.getRank()), Boolean.valueOf(r11.getAsc()));
        goto L32
    L31:
        RecentSort r12 = RecentSort.OPENED;
        r1 = TuplesKt.to(Integer.valueOf(r12.getRank()), Boolean.valueOf(r12.getAsc()));
    L32:
        String r13 = r10.b;
        FilterType r14 = FilterType.ALL;
        int r15 = r14.getType();
        String r16 = r14.getFileType();
        String r17 = r14.getForbiddenFileType();
        if (r1 == null) goto L35;
        int r18 = ((Number) r1.getFirst()).intValue();
    L36:
        if (r1 == null) goto L38;
        boolean r19 = ((Boolean) r1.getSecond()).booleanValue();
    L39:
        r7 = new FolderSortStrategy(r13, r15, r16, r17, r18, r19);
        goto L40
    L38:
        r19 = false;
        goto L39
    L35:
        r18 = 0;
        goto L36
    L27:
        throw new NoWhenBranchMatchedException();
    L17:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L11:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public o(Function0<? extends Fragment> r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentProvider");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        this.a = r2;
        this.b = r3;
    }

    public final void a(OfficeListSortFilterScene r10, OfficeListSortFilterScene.b r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "option");
        FolderSortStrategy r0 = c(r10);
        d(r10, new FolderSortStrategy(r10.b, r11.getType(), r11.c, r11.d, r0.e, r0.f));
    }

    public final void b(OfficeListSortFilterScene r10, OfficeListSortFilterScene.c r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "option");
        FolderSortStrategy r0 = c(r10);
        d(r10, new FolderSortStrategy(r10.b, r0.getType(), r0.c, r0.d, r11.b, r11.c));
    }

    public final void d(OfficeListSortFilterScene r6, FolderSortStrategy r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ((mc5.j) this.b.a(mc5.j.class)).D3(r7);     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L9;
        tt5.a.e("OfficeSortFilterAction", "save strategy failed. scene=" + r6.a + ", token=" + du5.b.k(r6.b), r2, false);
    L9:
        Fragment r3 = (Fragment) this.a.invoke();
        if (r3 == null) goto L12;
        FragmentActivity r4 = r3.getActivity();
    L13:
        if (r4 != null) goto L15;
        tt5.a.k("OfficeSortFilterAction", "skip post strategy because activity is null. scene=" + r6.a + ", token=" + du5.b.k(r6.b));
        return;
    L15:
        ((SortAndFilterViewModel) new ViewModelProvider(r4).get(SortAndFilterViewModel.class)).postSortStrategy(r7);
        tt5.a.h("OfficeSortFilterAction", "post strategy. scene=" + r6.a + ", token=" + du5.b.k(r6.b) + ", strategy=" + r7.e + ", type=" + r7.getType());
        return;
    L12:
        r4 = null;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
