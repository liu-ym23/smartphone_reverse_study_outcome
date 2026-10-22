package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.recent.e1;
import com.bytedance.ee.bear.list.recent.g1;
import com.bytedance.ee.bear.list.share.l1;
import com.bytedance.ee.bear.list.share.p4;
import com.bytedance.ee.bear.list.share.r;
import com.bytedance.ee.bear.list.share.r3;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import id5.x;
import jd5.v;
import kotlin.jvm.internal.Intrinsics;
import uc5.i1;
import uc5.x4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SortFragment extends zd5.e implements com.bytedance.ee.bear.content.common.morepanel.a, d0c.c {
    public String g;
    public int h;
    public FolderSortStrategy i;
    public boolean j;
    public com.bytedance.ee.bear.content.common.morepanel.a.a k;
    public View l;
    public i m;

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

    public final void tk() {
    }

    public SortFragment() {
        this.h = 0;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return new ce5.a().b;
    }

    @Override // zd5.e
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.m.destroy();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m52provideComponent() {
        return provideComponent();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.g = r4.getString("key_token");
        this.h = r4.getInt("key_default_sort_pos", this.h);
        this.i = (FolderSortStrategy) r4.getParcelable("key_sort_strategy");
        this.j = r4.getBoolean("key_sort_asc_enable", true);
        return;
    }

    public final void uC(hw4.a r1) {
        this.k = r1;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        super.onViewCreated(r8, r9);
        View r1 = this.l;
        Context r2 = getContext();
        int r3 = this.h;
        String r10 = this.g;
        m r11 = new m(r1, r2, r3, r10, this.j);
        if (TextUtils.equals(r10, "root") == false) goto L5;
    L41:
        zd5.b r12 = new i1();
    L42:
        i r13 = new i(this, r11, r12, this.k, this.i, new ce5.a(this));
        this.m = r13;
        r13.create();
        return;
    L5:
        if (TextUtils.equals(r10, "shared_folder") == true) goto L41;
        if (TextUtils.equals(r10, "my_root") == true) goto L41;
        if (TextUtils.equals(r10, "sidebar_personal_doc") == true) goto L41;
        if (TextUtils.equals(r10, "sidebar_personal_folder") == true) goto L41;
        if (TextUtils.equals(r10, "shared_folder") == false) goto L17;
        r12 = new r();
        goto L42
    L17:
        if (TextUtils.equals(r10, "shared") == false) goto L20;
        r12 = new p4();
        goto L42
    L20:
        if (TextUtils.equals(r10, "shared_folder_v2") == false) goto L22;
    L40:
        r12 = new l1();
        goto L42
    L22:
        if (TextUtils.equals(r10, "hidden_shared_folder") == true) goto L40;
        if (TextUtils.equals(r10, "manual_offline") == false) goto L28;
        r12 = new x();
        goto L42
    L28:
        if (TextUtils.equals(r10, "mine") == false) goto L31;
        r12 = new v();
        goto L42
    L31:
        if (TextUtils.equals(r10, "shared_file") == false) goto L34;
        r12 = new r3();
        goto L42
    L34:
        if (TextUtils.equals(r10, "recent") == false) goto L37;
        r12 = new e1();
        goto L42
    L37:
        if (TextUtils.equals(r10, "subordinate_recent") == false) goto L39;
        r12 = new g1();
        goto L42
    L39:
        r12 = new x4();
        goto L42
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563484, r3, false);
        this.l = r5;
        return r5;
    }
}
