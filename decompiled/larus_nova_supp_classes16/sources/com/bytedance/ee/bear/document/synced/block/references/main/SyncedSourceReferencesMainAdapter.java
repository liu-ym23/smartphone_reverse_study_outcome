package com.bytedance.ee.bear.document.synced.block.references.main;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceDocReferencesFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceReferencesMainAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "userSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "args", "Landroid/os/Bundle;", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/ss/android/lark/passportc/entity/UserSession;Landroid/os/Bundle;)V", "list", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceReferencesMainAdapter extends FragmentStatePagerAdapter {
    public final ArrayList<Fragment> a;

    public final int getCount() {
        return this.a.size();
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.a, r2);
    }

    public SyncedSourceReferencesMainAdapter(FragmentManager r5, UserSession r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "fm");
        Intrinsics.checkNotNullParameter(r6, "userSession");
        super(r5);
        ArrayList<Fragment> r8 = new ArrayList();
        this.a = r8;
        SyncedSourceDocReferencesFragment r0 = new SyncedSourceDocReferencesFragment();
        Bundle r1 = new Bundle();
        PassportcConvention.h(r1, r6);
        Parcelable r9 = null;
        if (r7 == null) goto L5;
        Parcelable r3 = r7.getParcelable("key_references_param");
    L6:
        r1.putParcelable("key_references_param", r3);
        if (r7 == null) goto L9;
        r9 = r7.getParcelable("bear_url");
    L9:
        r1.putParcelable("bear_url", r9);
        if (r7 == null) goto L14;
        boolean r2 = true;
        if (r7.getBoolean("key_is_sync_link") != true) goto L14;
    L15:
        r1.putBoolean("key_is_sync_link", r2);
        r0.setArguments(r1);
        r8.add(r0);
        return;
    L14:
        r2 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }
}
