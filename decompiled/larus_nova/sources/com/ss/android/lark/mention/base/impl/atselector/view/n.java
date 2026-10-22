package com.ss.android.lark.mention.base.impl.atselector.view;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes36.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f431851f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f431852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f431853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f431854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Channel<String> f431855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f431856e;

    public static final class a {
    }

    static {
    }

    public n(CoroutineScope r100, long r101, m r102) {
        this.f431852a = r100;
        this.f431853b = r101;
        this.f431854c = r102;
        this.f431855d = ChannelKt.Channel$default(-1, null, null, 6, null);
    }
}
