package com.ss.android.lark.conditional.access.nopermission.ui;

import android.app.Activity;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class q extends UDBaseDialogBuilder<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f418405a;

    public abstract q a(com.ss.android.lark.conditional.access.nopermission.manager.v r100);

    public abstract CustomDisplayTemplate b();

    public abstract InternalSecurityAction c();

    public abstract void d(CustomDisplayTemplate r100, InternalSecurityAction r101);

    public final Activity getActivity() {
        return this.f418405a;
    }

    public q(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
        this.f418405a = r100;
    }
}
