package com.bytedance.ee.bear.list.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NewShareHiddenFolderFragment extends j implements d0c.c {
    public View g;
    public k1 h;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("NewShareHiddenFolderFragment", "onDestroy()...");
        k1 r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        k1 r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m41provideComponent() {
        return provideComponent();
    }

    public NewShareHiddenFolderFragment() {
    }

    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        tt5.a.h("NewShareHiddenFolderFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        k1 r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r3);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        tt5.a.h("NewShareHiddenFolderFragment", "initMVP()...");
        ce5.a r5 = new ce5.a(this);
        k1 r9 = new k1(new p1(getContext(), this.g, this, r5), new f1(this, getContext(), true, r5), getContext(), this, r5);
        this.h = r9;
        r9.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563486, r3, false);
        this.g = r5;
        return r5;
    }
}
