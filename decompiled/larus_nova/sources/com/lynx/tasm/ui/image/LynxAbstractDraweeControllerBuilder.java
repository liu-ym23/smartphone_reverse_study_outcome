package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.lynx.tasm.ui.image.LynxAbstractDraweeControllerBuilder;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LynxAbstractDraweeControllerBuilder<BUILDER extends LynxAbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f383840j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final NullPointerException f383841k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLong f383842l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f383843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f383844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f383845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public REQUEST f383846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public REQUEST f383847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ControllerListener<? super INFO> f383848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f383849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f383850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f383851i;

    public static final enum CacheLevel extends Enum<CacheLevel> {
        public static final CacheLevel BITMAP_MEMORY_CACHE = null;
        public static final CacheLevel DISK_CACHE = null;
        public static final CacheLevel FULL_FETCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheLevel[] f383852a = null;

        static {
            CacheLevel r100 = new CacheLevel("FULL_FETCH", 0);
            FULL_FETCH = r100;
            CacheLevel r101 = new CacheLevel("DISK_CACHE", 1);
            DISK_CACHE = r101;
            CacheLevel r102 = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
            BITMAP_MEMORY_CACHE = r102;
            f383852a = new CacheLevel[]{r100, r101, r102};
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) f383852a.clone();
        }

        public static CacheLevel valueOf(String r100) {
            return (CacheLevel) r27.a.a(CacheLevel.class, r100);
        }

        public CacheLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a extends BaseControllerListener<Object> {
        public a() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            if (r102 == null) goto L5;
            r102.start();
            return;
        }
    }

    public abstract DataSource a(q r100, Object r101, Object r102, CacheLevel r103);

    static {
        f383840j = new a();
        f383841k = new NullPointerException("No image request was specified!");
        f383842l = new AtomicLong();
    }

    public Context getContext() {
        return this.f383843a;
    }

    public LynxAbstractDraweeControllerBuilder(Context r100) {
        this.f383843a = r100;
        this.f383845c = null;
        this.f383846d = null;
        this.f383847e = null;
        this.f383848f = null;
        this.f383849g = false;
        this.f383851i = null;
    }
}
