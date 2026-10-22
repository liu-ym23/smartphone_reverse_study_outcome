package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f287740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f287741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f287742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f287743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f287744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f287745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f287746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Boolean> f287747h;

    public j0(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f287740a = r100;
        this.f287741b = r101;
        this.f287742c = r102;
        this.f287747h = new i0();
    }
}
