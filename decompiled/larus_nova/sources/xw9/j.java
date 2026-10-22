package xw9;

import android.app.Activity;
import android.view.OrientationEventListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f565282d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Boolean> f565283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f565284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f565285c;

    public static final class a {
    }

    public static final class b extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f565286a;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r100) {
            if (r100 != (-1)) goto L5;
            return;
        L5:
            this.f565286a.getClass();
            int r101 = 0;
            if (r100 > 60) goto L8;
        L24:
            j r102 = this.f565286a;
            if (r102.f565284b != r101) goto L27;
            return;
        L27:
            r102.f565284b = r101;
            if (r102.f565283a.invoke(Integer.valueOf(r101)).booleanValue() == true) goto L31;
            disable();
            return;
        L31:
            return;
        L8:
            if (r100 > 300) goto L24;
            if (61 > r100) goto L14;
            if (r100 >= 136) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L17;
            r101 = 90;
            goto L24
        L17:
            if (136 <= r100) goto L19;
        L21:
            if (r101 == 0) goto L23;
            r101 = 180;
            goto L24
        L23:
            r101 = 270;
            goto L24
        L19:
            if (r100 >= 226) goto L21;
            r101 = 1;
        L14:
            r103 = false;
            goto L15
        }

        public b(Activity r100, j r101) {
            this.f565286a = r101;
            super(r100);
        }
    }

    static {
    }

    public j(Activity r100, Function1<? super Integer, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "onChange");
        this.f565283a = r101;
        this.f565284b = -1;
        b r102 = new b(r100, this);
        this.f565285c = r102;
        r102.enable();
    }
}
