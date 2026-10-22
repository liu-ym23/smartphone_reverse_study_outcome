package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MessageInfo> f426078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f426079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f426080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f426081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f426082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Message f426083f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends MessageInfo> f426084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f426086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f426087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f426088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Message f426089f;

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(a r100) {
        List r101 = r100.f426084a;
        List r102 = r101;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messages");
        r102 = null;
    L6:
        this.f426078a = r102;
        this.f426079b = r100.f426085b;
        this.f426080c = r100.f426086c;
        this.f426081d = r100.f426087d;
        this.f426082e = r100.f426088e;
        this.f426083f = r100.f426089f;
    }

    public final int a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = this.f426080c;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100.getBadgeCount();
    L12:
        return r100.getThreadBadgeCount();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final int b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = this.f426080c;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100.getPosition();
    L12:
        return r100.getThreadPosition();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
