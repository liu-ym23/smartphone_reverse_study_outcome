package m75;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m75.e;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a<V extends e> implements d<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f512352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f512353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f512354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f512355d;

    @Override // m75.d
    public void detachView() {
        this.f512352a = null;
        if (((ArrayList) this.f512354c).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512354c).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((b) r100.next()).getClass();
        goto L6
    L10:
        return;
    }

    public final boolean i() {
        if (this.f512352a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // m75.d
    public void onDestroy() {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).onDestroy();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onPause() {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).onPause();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onResume() {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).onResume();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onStart() {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).onStart();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onStop() {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r100 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((c) r100.next()).onStop();
        goto L6
    L10:
        return;
    }

    public Context getContext() {
        return this.f512353b;
    }

    public a(Context r100) {
        this.f512354c = new ArrayList();
        this.f512355d = new ArrayList();
        this.f512353b = r100;
    }

    @Override // m75.d
    public final void f(V r100) {
        this.f512352a = r100;
        if (((ArrayList) this.f512354c).isEmpty() == true) goto L8;
        Iterator r101 = ((ArrayList) this.f512354c).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((b) r101.next()).f512356a = r100;
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void h(Bundle r100) {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r101 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((c) r101.next()).a();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public void e(Bundle r100, Bundle r101) {
        if (((ArrayList) this.f512354c).isEmpty() == true) goto L8;
        Iterator r102 = ((ArrayList) this.f512354c).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((b) r102.next()).getClass();
        goto L6
    L10:
        return;
    }

    @Override // m75.d
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (((ArrayList) this.f512355d).isEmpty() == true) goto L8;
        Iterator r103 = ((ArrayList) this.f512355d).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((c) r103.next()).onActivityResult();
        goto L6
    L10:
        return;
    }
}
