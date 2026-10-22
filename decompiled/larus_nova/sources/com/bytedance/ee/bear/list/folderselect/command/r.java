package com.bytedance.ee.bear.list.folderselect.command;

import android.app.Activity;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements UDToast.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Activity> f228205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f228206b;

    @Override // com.larksuite.component.universe_design.toast.UDToast.c
    public final void a() {
        this.f228205a.element = null;
        this.f228206b.f228196i = null;
    }

    public r(Ref.ObjectRef<Activity> r100, n r101) {
        this.f228205a = r100;
        this.f228206b = r101;
    }
}
