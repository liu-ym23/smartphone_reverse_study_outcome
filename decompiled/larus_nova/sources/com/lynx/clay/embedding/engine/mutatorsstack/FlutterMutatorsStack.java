package com.lynx.clay.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterMutatorsStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f380750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Path> f380751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f380752c;

    public static final enum FlutterMutatorType extends Enum<FlutterMutatorType> {
        public static final FlutterMutatorType CLIP_PATH = null;
        public static final FlutterMutatorType CLIP_RECT = null;
        public static final FlutterMutatorType CLIP_RRECT = null;
        public static final FlutterMutatorType OPACITY = null;
        public static final FlutterMutatorType TRANSFORM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FlutterMutatorType[] f380753a = null;

        static {
            FlutterMutatorType r100 = new FlutterMutatorType("CLIP_RECT", 0);
            CLIP_RECT = r100;
            FlutterMutatorType r101 = new FlutterMutatorType("CLIP_RRECT", 1);
            CLIP_RRECT = r101;
            FlutterMutatorType r102 = new FlutterMutatorType("CLIP_PATH", 2);
            CLIP_PATH = r102;
            FlutterMutatorType r103 = new FlutterMutatorType("TRANSFORM", 3);
            TRANSFORM = r103;
            FlutterMutatorType r104 = new FlutterMutatorType("OPACITY", 4);
            OPACITY = r104;
            f380753a = new FlutterMutatorType[]{r100, r101, r102, r103, r104};
        }

        public static FlutterMutatorType[] values() {
            return (FlutterMutatorType[]) f380753a.clone();
        }

        public static FlutterMutatorType valueOf(String r100) {
            return (FlutterMutatorType) r27.a.a(FlutterMutatorType.class, r100);
        }

        public FlutterMutatorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f380754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlutterMutatorType f380755b;

        public a() {
            this.f380755b = FlutterMutatorType.CLIP_RECT;
        }

        public FlutterMutatorType getType() {
            return this.f380755b;
        }

        public a(Matrix r100) {
            this.f380755b = FlutterMutatorType.TRANSFORM;
            this.f380754a = r100;
        }

        public a(int r100) {
            this.f380755b = FlutterMutatorType.CLIP_RRECT;
        }
    }

    public static FlutterMutatorsStack create() {
        return new FlutterMutatorsStack();
    }

    public FlutterMutatorsStack() {
        this.f380750a = new ArrayList();
        this.f380752c = new Matrix();
        this.f380751b = new ArrayList();
    }

    public void pushTransform(float[] r100) {
        Matrix r101 = new Matrix();
        r101.setValues(r100);
        a r102 = new a(r101);
        ((ArrayList) this.f380750a).add(r102);
        this.f380752c.preConcat(r102.f380754a);
    }

    public void pushClipRect(int r100, int r101, int r102, int r103) {
        Rect r104 = new Rect(r100, r101, r102, r103);
        a r105 = new a();
        ((ArrayList) this.f380750a).add(r105);
        Path r106 = new Path();
        r106.addRect(new RectF(r104), Path.Direction.CCW);
        r106.transform(this.f380752c);
        ((ArrayList) this.f380751b).add(r106);
    }

    public void pushClipRRect(int r100, int r101, int r102, int r103, float[] r104) {
        Rect r105 = new Rect(r100, r101, r102, r103);
        a r106 = new a(0);
        ((ArrayList) this.f380750a).add(r106);
        Path r107 = new Path();
        r107.addRoundRect(new RectF(r105), r104, Path.Direction.CCW);
        r107.transform(this.f380752c);
        ((ArrayList) this.f380751b).add(r107);
    }
}
