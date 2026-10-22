package t70;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Widget f544871e;

    public static final class a implements w70.a<h70.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f544872a;

        public a(j r100) {
            this.f544872a = r100;
        }

        @Override // w70.a
        public final Widget a(h70.b r100) {
            Intrinsics.checkNotNullParameter(r100, "layerContext");
            return this.f544872a.f544871e;
        }
    }

    @Override // t70.i, j70.o
    public final w70.a<? extends h70.b> j() {
        return new a(this);
    }

    public j(boolean r100, boolean r101, Widget r102) {
        Intrinsics.checkNotNullParameter(r102, "widget");
        super(r100, r101, r102.getClass());
        this.f544871e = r102;
    }
}
