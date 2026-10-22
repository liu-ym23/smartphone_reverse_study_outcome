package com.ss.android.lark.chatbase.model;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.ICallback;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.d;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import x4b.a;
import x4b.j;
import x4b.l;

/* JADX INFO: loaded from: classes35.dex */
public abstract class FirstScreenLoader<T extends f5b.b, PageData extends x4b.a<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.core.model.a<T, PageData> f416879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BasePageStore<T, PageData> f416880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f416881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f416882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CallbackManager f416883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f416884f;

    public abstract String a();

    public abstract String b();

    public abstract boolean d();

    public abstract void e(List<Integer> r100, IGetDataCallback<Boolean> r101);

    public abstract void g();

    public final void f(final boolean r100, final IGetDataCallback<d<T>> r101) {
        int r102 = this.f416884f;
        if (r102 > 0) goto L6;
        r102 = 15;
    L6:
        MessageFetchScene r103 = MessageFetchScene.FIRST_SCREEN;
        if (r100 == false) goto L9;
        ChannelDataFetcherStrategy r104 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    L10:
        com.ss.android.lark.chat.core.model.c r105 = new com.ss.android.lark.chat.core.model.c(0, r102, r103, r104);
        ICallback r106 = new AnonymousClass1(this, r100, r101);
        com.ss.android.lark.chat.core.model.a<T, PageData> r107 = this.f416879a;
        com.ss.android.lark.chatbase.a r108 = new com.ss.android.lark.chatbase.a(this.f416880b, (IGetDataCallback) this.f416883e.wrapAndAddCallback(r106));
        r107.getClass();
        r107.a(new l(r107, r105, r108));
        return;
    L9:
        r104 = ChannelDataFetcherStrategy.RETURN_LOCAL_DATA;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(PageData r100, d<T> r101, List<Integer> r102, final IGetDataCallback<d<T>> r103) {
        boolean r104 = CollectionUtils.isNotEmpty(r102);
        boolean r105 = CollectionUtils.isNotEmpty(r101);
        Log.i(b(), "dataList size is:" + ((ArrayList) r101).size() + ", missingPos:" + r102);
        if (r104 == true) goto L5;
        Log.i(b(), "data completely");
        r103.onSuccess(r101);
        g();
        MessageHitPoint.c(a(), false, false);
        return;
    L5:
        if (r105 == false) goto L7;
        Log.i(b(), "partly completly load missingPos:" + r102);
        r103.onSuccess(r101);
        e(r102, null);
        g();
        return;
    L7:
        Log.i(b(), "no data back, get net data");
        IGetDataCallback<d<T>> r106 = new AnonymousClass2(this, r103);
        ChatCoreModule.a().getPerfEnterChatMonitor().j(true);
        PerfLog.start("chat_loadData_viaNetwork", "");
        if (d() == false) goto L10;
        final com.ss.android.lark.chat.core.model.c r107 = new com.ss.android.lark.chat.core.model.c(0, 15, MessageFetchScene.FIRST_SCREEN, ChannelDataFetcherStrategy.SYNC_SERVER_DATA);
        final com.ss.android.lark.chat.core.model.a<T, PageData> r108 = this.f416879a;
        final b r109 = new b(this, r106);
        Executor r110 = this.f416882d;
        r108.getClass();
        r110.execute(new j(r108, r107, r109));
    L11:
        MessageHitPoint.c(a(), true, true);
        return;
    L10:
        f(true, r106);
        goto L11
    }

    public FirstScreenLoader(com.ss.android.lark.chat.core.model.a<T, PageData> r100, BasePageStore<T, PageData> r101, Executor r102, Executor r103, CallbackManager r104) {
        this.f416879a = r100;
        this.f416880b = r101;
        this.f416882d = r102;
        this.f416881c = r103;
        this.f416883e = r104;
    }
}
