package com.ss.android.lark.widget.photopickerimpl.model;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class c<T extends Photo> implements com.ss.android.lark.widget.photopickerimpl.model.b<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ScheduledExecutorService f447781m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f447782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f447783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.widget.photopickerimpl.model.a<T> f447784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ldc.d<T> f447785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ldc.c f447786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f447787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Cursor f447788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f447789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f447790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f447791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<T> f447792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<WeakReference<ldc.g<b<T>>>> f447793l;

    public static final class a {
    }

    public static final class b<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<DATA> f447794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f447795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f447796c;

        public b(List<DATA> r100, boolean r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f447794a = r100;
            this.f447795b = r101;
            this.f447796c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopickerimpl.model.c$c, reason: collision with other inner class name */
    public static final class C5422c implements PhotoDataLoaderCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c<T> f447797a;

        public C5422c(c<T> r100) {
            this.f447797a = r100;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.PhotoDataLoaderCallback.a
        public final void a(Cursor r100) {
            c<T> r101 = this.f447797a;
            r101.f447788g = r100;
            r101.a();
        }
    }

    public static final class d extends ldc.g<b<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c<T> f447798b;

        public d(c<T> r100) {
            this.f447798b = r100;
        }

        @Override // ldc.g
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            c<T> r101 = this.f447798b;
            ldc.d<T> r102 = r101.f447785d;
            if (r102 == null) goto L5;
            r102.a(r101.f447792k, 0);
        L5:
            int r103 = ldc.h.f508886a;
            ldc.h.b.a("PP_PhotoModel", "load data error : " + r100);
        }

        @Override // ldc.g
        public final void b(Object r100) {
            b r101 = (b) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            ldc.d<T> r102 = this.f447798b.f447785d;
            if (r102 == null) goto L5;
            r102.a(r101.f447794a, r101.f447796c);
        L5:
            c<T> r103 = this.f447798b;
            r103.f447791j = r101.f447795b;
        }
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void b() {
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void create() {
        this.f447787f = false;
        g(this.f447789h, this.f447790i);
        FragmentActivity r100 = this.f447782a;
        new HashMap();
        int r101 = StoragePermissionUtils.a(r100, StoragePermissionUtils.d(r100, 2));
        StoragePermissionUtils.a(r100, StoragePermissionUtils.d(r100, 4));
        StoragePermissionUtils.d(r100, 8);
        StoragePermissionUtils.e(r100);
        if (r101 != 2) goto L5;
        Log.w("PP_PhotoModel", "load bucket info but does not have storage permission");
        return;
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new e(this));
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void d(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void onDestroy() {
        boolean r100 = true;
        this.f447787f = true;
        Cursor r101 = this.f447788g;
        if (r101 != null) goto L5;
    L7:
        r100 = false;
    L8:
        if (r100 == false) goto L14;
        Cursor r102 = this.f447788g;
        if (r102 == null) goto L12;
        r102.close();
    L12:
        this.f447788g = null;
        return;
    L14:
        return;
    L5:
        if (r101.isClosed() == true) goto L7;
        goto L7
    }

    static {
        f447781m = CoreThreadPool.getDefault().getSingleScheduledThreadPool("photo-picker-model-thread");
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void a() {
        if (this.f447791j == true) goto L5;
        return;
    L5:
        this.f447791j = false;
        d r100 = new d(this);
        this.f447793l.add(new WeakReference(r100));
        Cursor r101 = this.f447788g;
        if (r101 != null) goto L10;
        Throwable r102 = new Throwable("cursor is NULL");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        if (r100.f508885a == true) goto L14;
        r100.a(r102);
        return;
    L14:
        return;
    L10:
        Log.i("PP_PhotoModel", "loadMoreImpl");
        f r103 = new f(this, r101);
        g r104 = new g(r100);
        h r105 = new h(r100);
        ScheduledExecutorService r106 = f447781m;
        if (r106 == null) goto L16;
        r106.execute(new com.ss.android.lark.widget.photopickerimpl.model.d(r103, this, r104, r105));
        return;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void c(mdc.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f447785d = r100;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.model.b
    public final void e(mdc.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f447786e = r100;
    }

    public static Integer f(Cursor r100, String r101) {
        int r102 = r100.getColumnIndex(r101);
        if (r102 != (-1)) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getInt(r102));
    }

    public final void g(String r110, int r111) {
        Iterator<WeakReference<ldc.g<b<T>>>> r100 = this.f447793l.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        ldc.g<b<T>> r101 = r100.next().get();
        if (r101 == null) goto L4;
        r101.f508885a = true;
        goto L4
    L8:
        this.f447791j = true;
        this.f447792k.clear();
        if (this.f447783b.f447556a < 1) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        ArrayList<T> r103 = this.f447792k;
        ((rdc.h) this.f447784c).getClass();
        ListProtector.add(r103, 0, new t());
    L14:
        this.f447789h = r110;
        this.f447790i = r111;
        this.f447788g = null;
        LoaderManager r112 = this.f447782a.getSupportLoaderManager();
        Bundle r113 = new Bundle();
        FragmentActivity r104 = this.f447782a;
        int r105 = this.f447790i;
        s r106 = this.f447783b;
        PhotoDataLoaderCallback r107 = new PhotoDataLoaderCallback(r104, r105, r106.f447557b, !r106.f447567l, new C5422c(this));
        FragmentActivity r108 = this.f447782a;
        new HashMap();
        int r109 = StoragePermissionUtils.a(r108, StoragePermissionUtils.d(r108, 2));
        StoragePermissionUtils.a(r108, StoragePermissionUtils.d(r108, 4));
        StoragePermissionUtils.d(r108, 8);
        StoragePermissionUtils.e(r108);
        if (r109 != 2) goto L19;
        Log.w("PP_PhotoModel", "init data but does not have storage permission");
        return;
    L19:
        if (r112.getLoader(R.id.photo_picker_photo_loader) != null) goto L21;
        r112.initLoader(R.id.photo_picker_photo_loader, r113, r107);
        return;
    L21:
        r112.restartLoader(R.id.photo_picker_photo_loader, r113, r107);
        return;
    L11:
        r102 = false;
        goto L12
    }

    public c(FragmentActivity r100, s r101, rdc.h r102) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        Intrinsics.checkNotNullParameter(r101, "pickerParams");
        Intrinsics.checkNotNullParameter(r102, "mPhotoDataFactory");
        this.f447782a = r100;
        this.f447783b = r101;
        this.f447784c = r102;
        this.f447790i = 4096;
        this.f447791j = true;
        this.f447792k = new ArrayList();
        this.f447793l = new ArrayList();
    }
}
