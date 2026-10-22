package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ AssociatedActionSheetPanel a;
    public final /* synthetic */ NetService b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Context d;

    public b(AssociatedActionSheetPanel r1, NetService r2, String r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r9) {
        SearchSpaceInfo r10 = (SearchBaseInfo) r9;
        if (r10 == null) goto L14;
        AssociatedActionSheetPanel r0 = this.a;
        NetService r1 = this.b;
        String r2 = this.c;
        Context r3 = this.d;
        r0.getClass();
        ArrayList r4 = new ArrayList();
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        String r6 = "";
        r5.element = "";
        if ((r10 instanceof SearchSpaceInfo) == false) goto L8;
        SearchSpaceInfo r11 = r10;
        r6 = r11.getId();
        r5.element = r11.getDocUrl();
    L10:
        r4.add(new Pair(r6, "22"));
        AssociatedDocViewModel r12 = AssociatedActionSheetPanel.a.get(r3);
        if (r12 == null) goto L15;
        r12.associatedExistingDoc(r1, r2, r4, new c(r3, r5, r0, r2));
        return;
    L15:
        return;
    L8:
        if ((r10 instanceof SearchWikiInfo) == false) goto L10;
        SearchWikiInfo r13 = (SearchWikiInfo) r10;
        r6 = r13.getId();
        r5.element = r13.getUrl();
        goto L10
    }
}
