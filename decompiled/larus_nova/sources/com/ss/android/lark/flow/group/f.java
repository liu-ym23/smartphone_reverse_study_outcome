package com.ss.android.lark.flow.group;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f423665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f423666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<String> f423667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f423668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f423669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap f423670f;

    public f(Context r100, String r101, List<String> r102, String r103, String r104, FlowJoinGroupChatUtil.CallbackWrap r105) {
        this.f423665a = r100;
        this.f423666b = r101;
        this.f423667c = r102;
        this.f423668d = r103;
        this.f423669e = r104;
        this.f423670f = r105;
    }

    public final void a() {
        int r100 = FlowJoinGroupChatUtil.f423638a;
        Context r101 = this.f423665a;
        final String r102 = this.f423666b;
        final List<String> r103 = this.f423667c;
        final String r104 = this.f423668d;
        final String r105 = this.f423669e;
        final FlowJoinGroupChatUtil.CallbackWrap r106 = this.f423670f;
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        com.larksuite.component.ui.dialog.d r108 = new com.larksuite.component.ui.dialog.d(r101);
        r108.f284132c.contentLayoutRes(R.layout.flow_join_group_applicant_dialog);
        r108.f284132c.style(R.style.UtilsPopDialog);
        r108.f284131b = R.style.UtilsPopDialog;
        g r109 = new g(r106);
        r108.f284132c.onCancelListener(r109);
        r108.g(new h(r107, r101));
        r108.a(R.id.lkui_dialog_btn_left, R.string.Lark_Legacy_Cancel, new i(r106));
        r108.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_Confirm, new FlowJoinGroupChatUtil$showChatChatterApplyDialog$4(r102, r103, r107, r104, r105, r106));
        r108.i();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
