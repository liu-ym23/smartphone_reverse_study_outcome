package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f287678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f287679b;

    public a(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f287678a = r100;
        this.f287679b = r101;
    }
}
