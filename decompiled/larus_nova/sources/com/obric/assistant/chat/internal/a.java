package com.obric.assistant.chat.internal;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f386936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<wc9.e> f386937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f386938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<BotModel> f386939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f386940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NativeConversationServiceImpl f386941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BotServiceImpl f386942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f386943h;

    /* JADX INFO: renamed from: com.obric.assistant.chat.internal.a$a, reason: collision with other inner class name */
    public static final class C4597a {
    }

    static {
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f386936a = r100;
        MutableLiveData<wc9.e> r101 = new MutableLiveData();
        this.f386937b = r101;
        this.f386938c = r101;
        MutableLiveData<BotModel> r102 = new MutableLiveData();
        this.f386939d = r102;
        this.f386940e = r102;
        this.f386941f = com.larus.im.d.d();
        this.f386942g = com.larus.im.d.a();
        this.f386943h = CoroutineScopeKt.MainScope();
    }
}
