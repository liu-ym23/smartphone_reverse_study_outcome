package com.larus.bmhome.social.userchat.model;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Message> f314177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f314178b;

    public x(String r100, List<Message> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        Intrinsics.checkNotNullParameter(r101, "msgList");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.f314177a = r101;
        this.f314178b = r102;
    }
}
