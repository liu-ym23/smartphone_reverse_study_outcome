package com.bytedance.helios.sdk;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityStack extends CopyOnWriteArrayList<c> {
    public c last() {
        if (isEmpty() == false) goto L5;
        return null;
    L5:
        return get(size() - 1);
    }

    public ActivityStack() {
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof c) == false) goto L10;
        return super.contains(r100);
    L10:
        if ((r100 instanceof String) == false) goto L19;
        String r101 = (String) r100;
        Iterator<c> r102 = iterator();
    L13:
        if (r102.hasNext() == false) goto L33;
        if (TextUtils.equals(r101, r102.next().f245498a) == false) goto L13;
        return true;
    L33:
        return false;
    L19:
        if ((r100 instanceof Activity) == false) goto L34;
        String r103 = ((Activity) r100).toString();
        Iterator<c> r104 = iterator();
    L22:
        if (r104.hasNext() == false) goto L35;
        if (TextUtils.equals(r103, r104.next().f245498a) == false) goto L22;
        return true;
    L35:
        return false;
    L34:
        return false;
    }

    public void remove(Activity r100) {
        int r101 = size() - 1;
    L3:
        if (r101 < 0) goto L11;
        if (TextUtils.equals(r100.toString(), get(r101).f245498a) == true) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        remove(r101);
        return;
    }

    public void add(Activity r100, Lifecycle.Event r101) {
        String r102 = r100.toString();
        Iterator r103 = iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        c r104 = (c) r103.next();
        if (TextUtils.equals(r102, r104.f245498a) == false) goto L4;
    L9:
        if (r104 != null) goto L11;
        add(new c(r100, r101));
        if (size() <= 10) goto L28;
        remove(0);
        return;
    L28:
        return;
    L11:
        if (r101 != Lifecycle.Event.ON_CREATE) goto L13;
    L18:
        remove(r104);
        r104.f245499b = r101;
        add(r104);
        return;
    L13:
        if (r101 == Lifecycle.Event.ON_START) goto L18;
        if (r101 == Lifecycle.Event.ON_RESUME) goto L18;
        r104.f245499b = r101;
        return;
    L8:
        r104 = null;
        goto L9
    }
}
