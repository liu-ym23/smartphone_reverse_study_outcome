package com.bytedance.ee.bear.bitable.superagent.at;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ BitableSuperAgentAtViewModel a;

    public e(BitableSuperAgentAtViewModel r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        AtFinderResult r10 = (AtFinderResult) r9;
        if (r10 == null) goto L5;
        List r11 = r10.list;
    L6:
        if (r11 != null) goto L8;
        r11 = CollectionsKt.emptyList();
    L8:
        tt5.a.h("BitableSuperAgentAtVM", "delegate onChanged: size=" + r11.size() + ", active=" + this.a.r);
        if (this.a.r == false) goto L43;
        List r12 = r11;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r12.iterator();
    L12:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L19;
        T r2 = r1.next();
        if (((AtObject) r2).getType() != 0) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L12;
        r0.add(r2);
        goto L12
    L19:
        ArrayList r4 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L21:
        if (r13.hasNext() == false) goto L31;
        T r5 = r13.next();
        AtObject r6 = (AtObject) r5;
        if (r6.getType() != 5) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L21;
        r4.add(r5);
        goto L21
    L25:
        if (r6.getType() == 6) goto L28;
        r7 = false;
        goto L29
    L31:
        this.a.g.setValue(CollectionsKt.plus(r0, r4));
        this.a.k.setValue(Boolean.FALSE);
        return;
    L43:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
