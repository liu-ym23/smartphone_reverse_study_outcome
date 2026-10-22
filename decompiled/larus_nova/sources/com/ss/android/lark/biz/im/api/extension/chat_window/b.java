package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f410096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f410097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Chat f410098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatChatter f410099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f410100e;

    public b(Fragment r100, com.ss.android.lark.keyboard.b r101, Chat r102, ChatChatter r103) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r102, "chat");
        this.f410096a = r100;
        this.f410097b = r101;
        this.f410098c = r102;
        this.f410099d = r103;
    }
}
