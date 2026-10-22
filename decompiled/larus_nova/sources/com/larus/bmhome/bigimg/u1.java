package com.larus.bmhome.bigimg;

import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class u1 {
    public u1() {
    }

    public static void a(PublisherCreation r100, PublisherTrackParams r101) {
        if (r100 != null) goto L6;
        FLogger.f375446a.e("PublishHelper", "publisherCreation is null");
        return;
    L6:
        FLogger.f375446a.i("PublishHelper", "gotoPublisher: type:" + r100.getCreationType());
        com.larus.platform.service.e0.f365731a.a1(r100, r101);
    }
}
