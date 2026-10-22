package com.larus.office.plugins.inputv2.coordinator.runtime.interaction;

import android.os.Bundle;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.i0;
import com.larus.office.plugins.inputv2.j0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<com.larus.office.plugins.inputv2.adapter.g> f362970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.coordinator.document.c f362971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f362972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f362973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f362974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f362975g;

    public static final class a {
    }

    static {
    }

    public final Bundle a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        OfficeInputParam r101 = this.f362969a.invoke();
        Bundle r102 = new Bundle();
        String r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.getResourceId();
    L6:
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102.putString("file_id", r104);
        if (r101 == null) goto L12;
        String r106 = r101.getType();
    L13:
        if (r106 == null) goto L16;
        r105 = r106;
    L16:
        r102.putString("file_type", r105);
        r102.putString("current_module", b(r100));
        if (r101 == null) goto L20;
        r103 = r101.getType();
    L20:
        if (Intrinsics.areEqual(r103, DocumentType.DOCX_NAME) == false) goto L22;
        r102.putString("doc_view_type", this.f362975g);
    L22:
        return r102;
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        OfficeInputParam r101 = this.f362969a.invoke();
        if (r101 == null) goto L12;
        String r102 = r101.getEnterMethod();
        if (r102 == null) goto L12;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        return r102;
    L12:
        if ((!StringsKt.isBlank(r100)) == true) goto L15;
        r100 = null;
    L15:
        if (r100 != null) goto L18;
        return "open_doubao";
    L18:
        return r100;
    }

    public final void c(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.larus.office.plugins.inputv2.adapter.g r101 = this.f362970b.invoke();
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter("x-flow-function-scene", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        ew8.b r102 = (ew8.b) r101.e(ew8.b.class);
        if (r102 == null) goto L9;
        r102.nG(r100);
    L9:
        FLogger.f375446a.i("OfficeChatTrack", "更新 functionScene=".concat(r100));
    }

    public h(i0 r100, j0 r101, com.larus.office.plugins.inputv2.coordinator.document.c r102) {
        Intrinsics.checkNotNullParameter(r100, "paramsProvider");
        Intrinsics.checkNotNullParameter(r101, "adapterProvider");
        Intrinsics.checkNotNullParameter(r102, "answerStateCoordinator");
        this.f362969a = r100;
        this.f362970b = r101;
        this.f362971c = r102;
        this.f362973e = 1;
        this.f362975g = "read";
    }
}
