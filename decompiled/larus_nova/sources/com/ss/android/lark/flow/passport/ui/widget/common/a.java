package com.ss.android.lark.flow.passport.ui.widget.common;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f423834c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f423835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseContainerLayout f423836b;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.passport.ui.widget.common.a$a, reason: collision with other inner class name */
    public static final class ViewOnFocusChangeListenerC5007a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f423837a;

        public ViewOnFocusChangeListenerC5007a(a r100) {
            this.f423837a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == true) goto L4;
            return;
        L4:
            if (uzb.f.c(this.f423837a.f423835a) == false) goto L8;
            uzb.f.b(this.f423837a.f423835a);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(FragmentActivity r100, BaseContainerLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "rootLayout");
        this.f423835a = r100;
        this.f423836b = r101;
        r101.setFocusable(true);
        r101.setFocusableInTouchMode(true);
        r101.setClickable(true);
        r101.setOnFocusChangeListener(new ViewOnFocusChangeListenerC5007a(this));
    }
}
