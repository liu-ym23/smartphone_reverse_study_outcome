package com.larus.bmhome.music.player;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a1 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<WeakReference<e>> f312936a;

    public a1() {
        this.f312936a = new ArrayList();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r100) {
        List<WeakReference<e>> r101 = this.f312936a;
        ArrayList r102 = new ArrayList();
        Iterator r103 = CollectionsKt.toList(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        WeakReference r104 = (WeakReference) r103.next();
        e r105 = (e) r104.get();
        if (r105 == null) goto L4;
        r105.onCompletion(r100);
        r102.add(r104);
        goto L4
    L8:
        this.f312936a = r102;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r100) {
        List<WeakReference<e>> r101 = this.f312936a;
        ArrayList r102 = new ArrayList();
        Iterator r103 = CollectionsKt.toList(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        WeakReference r104 = (WeakReference) r103.next();
        e r105 = (e) r104.get();
        if (r105 == null) goto L4;
        r105.onPrepared(r100);
        r102.add(r104);
        goto L4
    L8:
        this.f312936a = r102;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r100, int r101, int r102) {
        List<WeakReference<e>> r103 = this.f312936a;
        ArrayList r104 = new ArrayList();
        Iterator r105 = CollectionsKt.toList(r103).iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        WeakReference r106 = (WeakReference) r105.next();
        e r107 = (e) r106.get();
        if (r107 == null) goto L4;
        r107.onError(r100, r101, r102);
        r104.add(r106);
        goto L4
    L8:
        this.f312936a = r104;
        return false;
    }
}
