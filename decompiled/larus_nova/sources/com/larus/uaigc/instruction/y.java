package com.larus.uaigc.instruction;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.model.creation.ResourceExt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class y extends up8.b implements com.larus.bmhome.instruction.k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.v f373469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MultiAttachmentSelectorWidget f373470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f373471n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<ResourceExt> f373472o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<String, String> f373473p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<String> f373474q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<Integer> f373475r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<Uri> f373476s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f373477t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.larus.bmhome.instruction.d f373478u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f373479v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f373480w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f373481x;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 15;
    }

    @Override // com.larus.bmhome.instruction.k
    public final void na() {
        this.f373479v = true;
    }

    @Override // com.larus.bmhome.instruction.k
    public final void oa() {
        this.f373480w = true;
    }

    @Override // com.larus.bmhome.instruction.k
    public final NestedFileContent T() {
        MultiAttachmentSelectorWidget r100 = this.f373470m;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r100 = null;
    L6:
        return r100.getCurrentNestedFileContent();
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f373469l != null) goto L5;
        return null;
    L5:
        MultiAttachmentSelectorWidget r101 = this.f373470m;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r101 = null;
    L8:
        r101.l7();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.v.Companion.serializer()), this.f373469l));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r103) == true) goto L18;
        r100 = r103;
    L18:
        return (String) r100;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.larus.bmhome.instruction.k
    public final LiveData<Map<String, Object>> ja() {
        MultiAttachmentSelectorWidget r100 = this.f373470m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r100 = null;
    L5:
        LiveData<Map<String, ry9.k>> r101 = r100.getAllAttachmentLiveDataStatus();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        return r101;
    }

    public y() {
        this.f373472o = new ArrayList();
        this.f373473p = new HashMap();
        this.f373474q = new ArrayList();
        this.f373475r = new ArrayList();
        this.f373476s = new ArrayList();
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        MultiAttachmentSelectorWidget r101 = new MultiAttachmentSelectorWidget(r100);
        this.f373470m = r101;
        return r101;
    }

    @Override // com.larus.bmhome.instruction.k
    public final void ka(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urlToUriRecord");
        this.f373473p.clear();
        this.f373473p.putAll(r100);
    }

    @Override // com.larus.bmhome.instruction.k
    public final void la(ArrayList<ResourceExt> r100) {
        Intrinsics.checkNotNullParameter(r100, "imageUrlList");
        this.f373472o.clear();
        this.f373472o.addAll(r100);
    }

    @Override // com.larus.bmhome.instruction.k
    public final void ma(int r100) {
        this.f373471n = r100;
    }

    @Override // up8.b
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.v) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f373469l = (com.larus.bmhome.actionbar.model.v) r103;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.k
    public final void pa(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f373481x = r100;
    }

    @Override // com.larus.bmhome.instruction.k
    public final void qa(com.larus.bmhome.instruction.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f373478u = r100;
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.v) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.v r104 = (com.larus.bmhome.actionbar.model.v) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.v r105 = this.f373469l;
        if (r105 == null) goto L19;
        r105.f295497c = r104.f295497c;
        return;
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
