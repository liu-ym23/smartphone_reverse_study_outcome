package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f221842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f221843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ForwardTarget f221844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f221845d;

    public static final class a implements UDToast.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardTarget f221846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f221847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f221848c;

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            int r101 = this.f221846a.b();
            if (r101 != 0) goto L5;
        L10:
            i r102 = this.f221847b;
            int r103 = i.f221840b;
            r102.getClass();
            i.b().n(this.f221848c, this.f221846a.f424780a);
        L11:
            t35.a r104 = this.f221847b.f221841a;
            if (r104 == null) goto L15;
            HashMap r105 = new HashMap();
            r105.put("click", "jump_to_chat");
            r105.put(PickerReporterConstants.KEY.TARGET, "none");
            r105.put("sub_view", "share_to_chat_success");
            r104.a("ccm_docs_toast_click", r105);
            return;
        L15:
            return;
        L5:
            if (r101 == 1) goto L10;
            if (r101 == 2) goto L9;
            tt5.a.d("ShareWordsForwardComponent", "action clicked with unknown target type: " + this.f221846a.b());
            goto L11
        L9:
            i r106 = this.f221847b;
            int r107 = i.f221840b;
            r106.getClass();
            i.b().m7(this.f221848c, this.f221846a.f424780a);
            goto L11
        }

        public a(ForwardTarget r100, i r101, Context r102) {
            this.f221846a = r100;
            this.f221847b = r101;
            this.f221848c = r102;
        }
    }

    public j(Context r100, int r101, ForwardTarget r102, i r103) {
        this.f221842a = r100;
        this.f221843b = r101;
        this.f221844c = r102;
        this.f221845d = r103;
    }

    public final void a() {
        String r100 = this.f221842a.getString(R.string.LarkCCM_Docs_FwdSection_Forwarded_Toast);
        int r101 = this.f221843b;
        if (r101 > 0) goto L6;
        tt5.a.h("ShareWordsForwardComponent", "send to im onError: sendChatIds size 0");
        return;
    L6:
        if (r101 == 1) goto L8;
    L12:
        UDToast.show(this.f221842a, r100);
        return;
    L8:
        if (this.f221844c == null) goto L12;
        String r102 = this.f221842a.getString(R.string.LarkCCM_Docs_FwdSection_ViewInChats_Link);
        UDToast.a r103 = UDToast.build(this.f221842a);
        r103.g(r100);
        r103.c(r102, new a(this.f221844c, this.f221845d, this.f221842a));
        r103.h();
        t35.a r104 = this.f221845d.f221841a;
        if (r104 == null) goto L15;
        HashMap r105 = new HashMap();
        r105.put("sub_view", "share_to_chat_success");
        r104.a("ccm_docs_toast_view", r105);
        return;
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
