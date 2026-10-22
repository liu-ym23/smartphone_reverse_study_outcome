package com.bytedance.lottie.model.content;

import android.graphics.PointF;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.lottie.LottieDrawable;
import rz6.m;
import sz6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class PolystarShape implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f264462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f264463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rz6.b f264464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m<PointF, PointF> f264465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rz6.b f264466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rz6.b f264467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rz6.b f264468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rz6.b f264469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final rz6.b f264470i;

    public static final enum Type extends Enum<Type> {
        public static final Type Polygon = null;
        public static final Type Star = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f264471a = null;
        private final int value;

        static {
            Type r100 = new Type(WikiFolderPushPlugin.STAR, 0, 1);
            Star = r100;
            Type r101 = new Type("Polygon", 1, 2);
            Polygon = r101;
            f264471a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f264471a.clone();
        }

        public static Type forValue(int r100) {
            Type[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            Type r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public Type getType() {
        return this.f264463b;
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new nz6.m(r100, r101, this);
    }

    public PolystarShape(String r100, Type r101, rz6.b r102, m<PointF, PointF> r103, rz6.b r104, rz6.b r105, rz6.b r106, rz6.b r107, rz6.b r108) {
        this.f264462a = r100;
        this.f264463b = r101;
        this.f264464c = r102;
        this.f264465d = r103;
        this.f264466e = r104;
        this.f264467f = r105;
        this.f264468g = r106;
        this.f264469h = r107;
        this.f264470i = r108;
    }
}
