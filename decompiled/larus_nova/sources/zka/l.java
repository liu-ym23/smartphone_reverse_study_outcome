package zka;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Messenger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f572724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f572725b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        m r102 = this.f572724a;
        CopyOnWriteArraySet<Messenger> r103 = r102.f572727b;
        Context r104 = this.f572725b;
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Messenger r106 = (Messenger) r105.next();
        Context r107 = r104.getApplicationContext();
        Intrinsics.checkNotNull(r106);
        r102.a(r107, r106);
        goto L4
    }

    public l(m r100, Context r101, Handler r102) {
        this.f572724a = r100;
        this.f572725b = r101;
        super(r102);
    }
}
