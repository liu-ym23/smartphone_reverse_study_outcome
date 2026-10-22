package com.bytedance.ee.bear.bitable.superagent.at;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtViewModel f215855a;

    public e(BitableSuperAgentAtViewModel r100) {
        this.f215855a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AtFinderResult r101 = (AtFinderResult) r100;
        if (r101 == null) goto L5;
        List<AtObject> r102 = r101.list;
    L6:
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        tt5.a.h("BitableSuperAgentAtVM", "delegate onChanged: size=" + r102.size() + ", active=" + this.f215855a.f215838r);
        if (this.f215855a.f215838r == false) goto L43;
        List<AtObject> r103 = r102;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L12:
        boolean r106 = false;
        if (r105.hasNext() == false) goto L19;
        T r107 = r105.next();
        if (((AtObject) r107).getType() != 0) goto L17;
        r106 = true;
    L17:
        if (r106 == false) goto L12;
        r104.add(r107);
        goto L12
    L19:
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r103.iterator();
    L21:
        if (r109.hasNext() == false) goto L31;
        T r110 = r109.next();
        AtObject r111 = (AtObject) r110;
        if (r111.getType() != 5) goto L25;
    L28:
        boolean r112 = true;
    L29:
        if (r112 == false) goto L21;
        r108.add(r110);
        goto L21
    L25:
        if (r111.getType() == 6) goto L28;
        r112 = false;
        goto L29
    L31:
        this.f215855a.f215827g.setValue(CollectionsKt.plus(r104, r108));
        this.f215855a.f215831k.setValue(Boolean.FALSE);
        return;
    L43:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
