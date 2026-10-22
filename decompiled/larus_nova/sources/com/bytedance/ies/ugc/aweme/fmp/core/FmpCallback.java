package com.bytedance.ies.ugc.aweme.fmp.core;

import android.view.View;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface FmpCallback {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/ugc/aweme/fmp/core/FmpCallback$Type;", "", "Normal", "Touch", "Timeout", "fmp-core_saasRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum Type extends Enum<Type> {
        public static final Type Normal = null;
        public static final Type Timeout = null;
        public static final Type Touch = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f248885a = null;

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f248885a.clone();
        }

        static {
            Type r100 = new Type("Normal", 0);
            Normal = r100;
            Type r101 = new Type("Touch", 1);
            Touch = r101;
            Type r102 = new Type("Timeout", 2);
            Timeout = r102;
            f248885a = new Type[]{r100, r101, r102};
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static void a(byte[] r100, byte[] r101) {
            Intrinsics.checkNotNullParameter(r100, "widthResult");
            Intrinsics.checkNotNullParameter(r101, "heightResult");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f248886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f248887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f248888c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f248886a == r101.f248886a) goto L12;
            return false;
        L12:
            if (this.f248887b == r101.f248887b) goto L15;
            return false;
        L15:
            if (this.f248888c == r101.f248888c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f248886a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f248887b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f248888c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        }

        public final String toString() {
            return "Metrics(totalCost=" + this.f248886a + ", totoalCount=" + this.f248887b + ", singleCost=" + this.f248888c + ')';
        }

        public b(long r100, long r101, long r102) {
            this.f248886a = r100;
            this.f248887b = r101;
            this.f248888c = r102;
        }
    }

    void a(View r100, boolean r101, boolean r102, long r103, long r104);

    boolean b(View r100);

    @Deprecated(level = DeprecationLevel.WARNING, message = "not recommend", replaceWith = @ReplaceWith(expression = "View#setTag(R.id.poi_dynamic_fmp_invalid_view_mark,true)", imports = {}))
    boolean c(View r100);

    void d(long r100, long r101, byte[] r102, byte[] r103, int r104, int r105, int r106, int r110, float r111, float r112, boolean r113, y46.b r114);

    String e(View r100);

    void f(long r100, long r101, int r102, int r103, int r104, int r105, float r106, float r110, boolean r111);

    boolean g();

    void h(Type r100, long r101, long r102, b r103);
}
