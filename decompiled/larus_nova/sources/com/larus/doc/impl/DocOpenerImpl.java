package com.larus.doc.impl;

import android.content.Context;
import android.os.Bundle;
import com.larus.office.base.preview.IOfficePreviewOpener;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/doc/impl/DocOpenerImpl;", "Lcom/larus/office/base/preview/IOfficePreviewOpener;", "<init>", "()V", "supportedPreviewTypes", "", "", "open", "", "request", "Lcom/larus/office/base/preview/OfficePreviewOpenRequest;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocOpenerImpl implements IOfficePreviewOpener {

    public static final class a {
    }

    static {
    }

    public DocOpenerImpl() {
    }

    @Override // com.larus.office.base.preview.IOfficePreviewOpener
    public final Set<Integer> b() {
        return SetsKt.setOf(22);
    }

    @Override // com.larus.office.base.preview.IOfficePreviewOpener
    public final boolean a(com.larus.office.base.preview.b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("open: token=");
        int r103 = com.larus.office.base.utils.f.f361173a;
        r102.append(com.larus.office.base.utils.f.b(r100.f361018c));
        r102.append(", enterMethod=");
        r102.append(r100.f361019d);
        r102.append(", page=");
        r102.append(r100.f361020e);
        r102.append(", restDocsSize=");
        r102.append(r100.f361021f.size());
        r101.i("DocOpenerImpl", r102.toString());
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L5;
        r104.N();
        com.larus.home.impl.sdk.n1 r105 = com.larus.home.impl.sdk.n1.f346205a;
    L7:
        if (r105 != null) goto L10;
        r101.w("DocOpenerImpl", "open: sdkDocService is null");
        return false;
    L10:
        Context r106 = r100.getContext();
        Pair[] r107 = new Pair[7];
        r107[0] = TuplesKt.to("key_doc_id", r100.f361018c);
        String r108 = r100.f361019d;
        if (r108 != null) goto L13;
        r108 = "url_jump";
    L13:
        r107[1] = TuplesKt.to("key_doc_enter_from", r108);
        r107[2] = TuplesKt.to("resource_type", 10);
        r107[3] = TuplesKt.to("key_doc_list_to_apply_permission", r100.f361021f);
        r107[4] = TuplesKt.to("key_apply_permission_message_id", r100.f361022g);
        r107[5] = TuplesKt.to("key_apply_permission_conversation_id", r100.f361023h);
        r107[6] = TuplesKt.to("key_source_url_for_params", r100.f361024i);
        Bundle r109 = com.larus.utils.f.c(r107);
        r109.putAll(r100.f361025j);
        Unit r110 = Unit.INSTANCE;
        String r111 = r100.f361020e;
        if (r111 != null) goto L16;
        r111 = "chat";
    L16:
        r105.x(r106, r109, r111);
        r101.i("DocOpenerImpl", "openDocDetailPage invoked: token=" + com.larus.office.base.utils.f.b(r100.f361018c));
        return true;
    L5:
        r105 = null;
        goto L7
    }
}
