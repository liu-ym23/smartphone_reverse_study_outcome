package com.larus.office.base.preview;

import android.content.Context;
import android.os.Bundle;
import com.larus.network.HttpConst;
import com.larus.office.base.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361034a = 0;

    static {
        HttpConst.f359979a.getClass();
    }

    public static boolean a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        e r101 = c.f361026a.k(r100.f361024i, Integer.valueOf(r100.f361017b), r100.f361018c);
        if (r101 != null) goto L7;
        return false;
    L7:
        return b(r101, r100);
    }

    public static boolean b(e r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "request");
        if (StringsKt.isBlank(r110.f361037c) == false) goto L5;
        return false;
    L5:
        int r100 = r110.f361036b;
        String r101 = r110.f361037c;
        String r102 = r111.f361024i;
        if (r102 != null) goto L12;
        r102 = r110.f361040f;
        if (r102 != null) goto L12;
        r102 = r110.f361038d;
        if (r102 != null) goto L12;
        r102 = r110.f361039e;
    L12:
        Context r103 = r111.f361016a;
        String r104 = r111.f361019d;
        String r105 = r111.f361020e;
        ArrayList<DocMeta> r106 = r111.f361021f;
        String r107 = r111.f361022g;
        String r112 = r111.f361023h;
        Bundle r113 = r111.f361025j;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r106, "restDocs");
        Intrinsics.checkNotNullParameter(r113, "extras");
        b r114 = new b(r103, r100, r101, r104, r105, r106, r107, r112, r102, r113);
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("tryOpenPreview: previewType=");
        r109.append(r110.f361035a);
        r109.append(", previewTypeValue=");
        r109.append(r110.f361036b);
        r109.append(", token=");
        int r115 = f.f361173a;
        r109.append(f.b(r110.f361037c));
        r109.append(", enterMethod=");
        r109.append(r114.f361019d);
        r109.append(", page=");
        r109.append(r114.f361020e);
        r109.append(", resolvedBy=");
        r109.append(r110.f361041g);
        r109.append(", restDocsSize=");
        r109.append(r114.f361021f.size());
        r109.append(", messageId=");
        r109.append(f.a(r114.f361022g));
        r109.append(", conversationId=");
        r109.append(f.a(r114.f361023h));
        r108.i("OfficePreviewRouter", r109.toString());
        if (r110.f361035a != OfficePreviewType.UNKNOWN) goto L15;
        return false;
    L15:
        int r116 = r110.f361036b;
        Iterator r117 = ServiceManager.get().getServices(IOfficePreviewOpener.class).iterator();
    L17:
        if (r117.hasNext() == false) goto L21;
        Object r118 = r117.next();
        if (((IOfficePreviewOpener) r118).b().contains(Integer.valueOf(r116)) == false) goto L17;
    L22:
        IOfficePreviewOpener r119 = (IOfficePreviewOpener) r118;
        if (r119 != null) goto L26;
        FLogger.f375446a.w("OfficePreviewRouter", "tryOpenPreview: no opener for previewTypeValue=" + r110.f361036b);
        return false;
    L26:
        boolean r120 = r119.a(r114);
        FLogger.f375446a.i("OfficePreviewRouter", "tryOpenPreview: opened=" + r120 + ", opener=" + r119.getClass().getName());
        return r120;
    L21:
        r118 = null;
        goto L22
    }

    public static boolean c(Context r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "url");
        e r100 = c.f361026a.k(r111, null, null);
        if (r100 != null) goto L6;
        return false;
    L6:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("tryOpenPreviewUrl: previewType=");
        r102.append(r100.f361035a);
        r102.append(", token=");
        int r103 = f.f361173a;
        r102.append(f.b(r100.f361037c));
        r102.append(", enterMethod=");
        r102.append(r112);
        r102.append(", resolvedBy=");
        r102.append(r100.f361041g);
        r101.i("OfficePreviewRouter", r102.toString());
        int r104 = r100.f361036b;
        String r105 = r100.f361037c;
        String r106 = r100.f361040f;
        if (r106 != null) goto L9;
        String r113 = r111;
    L11:
        return b(r100, new b(r110, r104, r105, r112, null, null, null, null, r113, null, 752));
    L9:
        r113 = r106;
        goto L11
    }
}
