package com.ss.android.lark.im.sdk.service;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageFetchScene f426061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f426062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f426063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f426064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f426065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f426066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ChannelDataFetcherStrategy f426067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f426068i;

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.service.a$a, reason: collision with other inner class name */
    public static final class C5036a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f426069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MessageFetchScene f426070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f426071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426072d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f426073e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f426074f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f426075g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ChannelDataFetcherStrategy f426076h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f426077i;

        public C5036a() {
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f426069a = r100;
        }

        public final void b(MessageFetchScene r100) {
            Intrinsics.checkNotNullParameter(r100, "messageFetchScene");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f426070b = r100;
        }

        public final void c(ChannelDataFetcherStrategy r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f426076h = r100;
        }
    }

    public a(C5036a r100) {
        String r101 = r100.f426069a;
        ChannelDataFetcherStrategy r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatId");
        r101 = null;
    L6:
        this.f426060a = r101;
        MessageFetchScene r103 = r100.f426070b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("messageFetchScene");
        r103 = null;
    L10:
        this.f426061b = r103;
        this.f426062c = r100.f426071c;
        this.f426063d = r100.f426072d;
        this.f426064e = r100.f426073e;
        this.f426065f = r100.f426074f;
        this.f426066g = r100.f426075g;
        ChannelDataFetcherStrategy r104 = r100.f426076h;
        if (r104 == null) goto L13;
        r102 = r104;
    L14:
        this.f426067h = r102;
        this.f426068i = r100.f426077i;
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        goto L14
    }
}
