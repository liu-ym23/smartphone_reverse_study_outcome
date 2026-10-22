package com.bytedance.ee.bear.office.space;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeListHostFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpacePagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "tabs", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "config", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "runtimeId", "", "enterContext", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;)V", "getTabs", "()Ljava/util/List;", "getItemCount", "", "createFragment", "position", "getItemId", "", "containsItem", "", "itemId", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpacePagerAdapter extends FragmentStateAdapter {
    public final List<OfficeSpaceTab> a;
    public final OfficeSpaceConfig b;
    public final String c;
    public final OfficeSpaceEnterContext d;

    public final int getItemCount() {
        return this.a.size();
    }

    public final boolean containsItem(long r7) {
        List<OfficeSpaceTab> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        if (((OfficeSpaceTab) r1.next()).ordinal() != r7) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
        return true;
    L13:
        r3 = false;
        goto L14
    L23:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final Fragment createFragment(int r7) {
        List<OfficeSpaceTab> r0 = this.a;
        boolean r1 = false;
        if (r7 >= 0) goto L5;
    L7:
        if (r1 == false) goto L9;
        Object r8 = ListProtector.get(r0, r7);
    L10:
        OfficeSpaceTab r9 = (OfficeSpaceTab) r8;
        int r2 = OfficeListHostFragment.r;
        OfficeListConfig r3 = this.b.getListConfig();
        String r4 = this.c;
        OfficeSpaceEnterContext r5 = this.d;
        Intrinsics.checkNotNullParameter(r9, "tab");
        Intrinsics.checkNotNullParameter(r3, "listConfig");
        Intrinsics.checkNotNullParameter(r5, "enterContext");
        OfficeListHostFragment r6 = new OfficeListHostFragment();
        Bundle r10 = new Bundle();
        r10.putSerializable("office_space_tab", r9);
        r10.putSerializable("office_list_config", r3);
        r10.putString("office_space_runtime_id", r4);
        r10.putSerializable("office_space_enter_context", r5);
        r6.setArguments(r10);
        return r6;
    L9:
        r8 = OfficeSpaceTab.RECENT;
        goto L10
    L5:
        if (r7 >= r0.size()) goto L7;
        r1 = true;
        goto L7
    }

    public final long getItemId(int r3) {
        return ((OfficeSpaceTab) ListProtector.get(this.a, r3)).ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpacePagerAdapter(Fragment r2, List<? extends OfficeSpaceTab> r3, OfficeSpaceConfig r4, String r5, OfficeSpaceEnterContext r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "tabs");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r6, "enterContext");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
