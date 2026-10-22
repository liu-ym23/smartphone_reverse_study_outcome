package com.prolificinteractive.materialcalendarview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialCalendarViewInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r100 = getContext();
        if (fy7.a.f479289a.getAndSet(true) == true) goto L19;
        fy7.b r101 = new fy7.b(r100);
        if (org.threeten.bp.zone.b.f526484a.get() == true) goto L18;
        AtomicReference<org.threeten.bp.zone.b> r102 = org.threeten.bp.zone.b.f526485b;
    L8:
        if (r102.compareAndSet(null, r101) == true) goto L9;
        if (r102.get() == null) goto L8;
        boolean r103 = false;
    L13:
        if (r103 == true) goto L19;
        throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
    L9:
        r103 = true;
        goto L13
    L18:
        throw new IllegalStateException("Already initialized");
    L19:
        return true;
    }

    public MaterialCalendarViewInitProvider() {
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L10;
        if ("com.prolificinteractive.materialcalendarview.materialcalendarviewinitprovider".equals(r101.authority) == true) goto L8;
        super.attachInfo(r100, r101);
        return;
    L8:
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    L10:
        throw new NullPointerException("MaterialCalendarViewInitProvider ProviderInfo cannot be null.");
    }
}
