package com.larus.bmhome.chat.doclink;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f302933a = 0;

    static {
    }

    public static IMessageDocPreviewService a() {
        return (IMessageDocPreviewService) ServiceManager.get().getService(IMessageDocPreviewService.class);
    }
}
