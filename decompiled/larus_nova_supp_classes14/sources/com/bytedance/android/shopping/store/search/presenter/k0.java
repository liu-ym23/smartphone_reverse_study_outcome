package com.bytedance.android.shopping.store.search.presenter;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.search.recyclerview.searchsug.adapter.SearchSugListAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0<T> implements Observer {
    public final /* synthetic */ StoreSearchSugListPresenter a;

    public k0(StoreSearchSugListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        String r11 = (String) r10;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L16;
        dn.a r13 = this.a.E().getSugRequestParam();
        r13.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r13.d = "";
        SearchSugListAdapter r14 = this.a.g;
        if (r14 == null) goto L13;
        ((ArrayList) r14.a).clear();
        r14.notifyDataSetChanged();
    L13:
        RecyclerView r15 = this.a.f;
        if (r15 == null) goto L23;
        r15.setVisibility(8);
        return;
    L23:
        return;
    L16:
        long r0 = SystemClock.elapsedRealtime();
        StoreSearchSugListPresenter r16 = this.a;
        if ((r0 - r16.h) <= 500) goto L25;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new StoreSearchSugListPresenter$updateSugList$1(r16, null), 3, null);
        RecyclerView r17 = this.a.f;
        if (r17 == null) goto L21;
        ExtensionsKt.visible(r17);
    L21:
        this.a.h = r0;
        return;
    L25:
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
