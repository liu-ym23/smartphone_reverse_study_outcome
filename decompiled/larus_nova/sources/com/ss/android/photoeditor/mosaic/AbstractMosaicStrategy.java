package com.ss.android.photoeditor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbstractMosaicStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f449245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f449246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Canvas f449247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.photoeditor.mosaic.v2.a f449248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f449249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f449250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f449251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SelectionMode f449252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<ufc.b> f449253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OrcState f449254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f449255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f449256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f449257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f449258n;

    public static final enum Effect extends Enum<Effect> {
        public static final Effect GAUSSIAN_BLUR = null;
        public static final Effect NORMAL_MOSAIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Effect[] f449259a = null;

        static {
            Effect r100 = new Effect("NORMAL_MOSAIC", 0);
            NORMAL_MOSAIC = r100;
            Effect r101 = new Effect("GAUSSIAN_BLUR", 1);
            GAUSSIAN_BLUR = r101;
            f449259a = new Effect[]{r100, r101};
        }

        public static Effect[] values() {
            return (Effect[]) f449259a.clone();
        }

        public static Effect valueOf(String r100) {
            return (Effect) r27.a.a(Effect.class, r100);
        }

        public Effect(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum OrcState extends Enum<OrcState> {
        public static final OrcState INITIALIZED = null;
        public static final OrcState UNINITIALIZED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OrcState[] f449260a = null;

        static {
            OrcState r100 = new OrcState("UNINITIALIZED", 0);
            UNINITIALIZED = r100;
            OrcState r101 = new OrcState("INITIALIZED", 1);
            INITIALIZED = r101;
            f449260a = new OrcState[]{r100, r101};
        }

        public static OrcState[] values() {
            return (OrcState[]) f449260a.clone();
        }

        public static OrcState valueOf(String r100) {
            return (OrcState) r27.a.a(OrcState.class, r100);
        }

        public OrcState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SelectionMode extends Enum<SelectionMode> {
        public static final SelectionMode PATH = null;
        public static final SelectionMode RECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SelectionMode[] f449261a = null;

        static {
            SelectionMode r100 = new SelectionMode("PATH", 0);
            PATH = r100;
            SelectionMode r101 = new SelectionMode("RECT", 1);
            RECT = r101;
            f449261a = new SelectionMode[]{r100, r101};
        }

        public static SelectionMode[] values() {
            return (SelectionMode[]) f449261a.clone();
        }

        public static SelectionMode valueOf(String r100) {
            return (SelectionMode) r27.a.a(SelectionMode.class, r100);
        }

        public SelectionMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(Bitmap r100, boolean r101);
    }

    public abstract void b(MotionEvent r100);

    public abstract void c();

    public abstract void d(int r100);

    public void a() {
        com.ss.android.photoeditor.util.b.e(this.f449246b);
        com.ss.android.photoeditor.util.b.e(this.f449245a);
    }

    public AbstractMosaicStrategy(Context r100) {
        this.f449253i = new ArrayList();
        this.f449254j = OrcState.UNINITIALIZED;
        this.f449255k = new Matrix();
        this.f449258n = false;
        this.f449257m = r100;
    }

    public void e(Bitmap r100) {
        this.f449245a = r100;
    }

    public void f(List<ufc.b> r100) {
        this.f449253i = r100;
        this.f449254j = OrcState.INITIALIZED;
    }
}
