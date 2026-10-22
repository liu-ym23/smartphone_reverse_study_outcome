package m75;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m75.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<V extends e> implements d<V> {
    public V a;
    public final Context b;
    public final List<b> c;
    public final List<c> d;

    @Override // m75.d
    public void detachView() {
        this.a = null;
        if (((ArrayList) this.c).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.c).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((b) r0.next()).getClass();
        goto L6
    L10:
        return;
    }

    public final boolean i() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // m75.d
    public void onDestroy() {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).onDestroy();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onPause() {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).onPause();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onResume() {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).onResume();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onStart() {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).onStart();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onStop() {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).onStop();
        goto L6
    L10:
        return;
    }

    public Context getContext() {
        return this.b;
    }

    public a(Context r2) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.b = r2;
    }

    @Override // m75.d
    public final void f(V r3) {
        this.a = r3;
        if (((ArrayList) this.c).isEmpty() == true) goto L8;
        Iterator r0 = ((ArrayList) this.c).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((b) r0.next()).a = r3;
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void h(Bundle r2) {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r3 = ((ArrayList) this.d).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((c) r3.next()).a();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public void e(Bundle r1, Bundle r2) {
        if (((ArrayList) this.c).isEmpty() == true) goto L8;
        Iterator r3 = ((ArrayList) this.c).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((b) r3.next()).getClass();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onActivityResult(int r1, int r2, Intent r3) {
        if (((ArrayList) this.d).isEmpty() == true) goto L8;
        Iterator r4 = ((ArrayList) this.d).iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        ((c) r4.next()).onActivityResult();
        goto L6
    L10:
        return;
    }
}
