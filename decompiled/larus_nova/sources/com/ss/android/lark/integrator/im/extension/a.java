package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.im.base.c;
import com.ss.android.lark.locationmessage.message.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.b;
import com.ss.android.lark.message.lynxcard.message.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import r5b.e;
import w4b.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements d, c {
    @Inject
    public a() {
    }

    @Override // w4b.d
    public final List<e<?, ?, ?>> c() {
        ArrayList r100 = new ArrayList();
        nmb.a.a().getOpenFeatureDependency().a(r100);
        new b();
        ArrayList r101 = new ArrayList();
        r101.add(new com.ss.android.lark.message.vote.message.c());
        r101.add(new m());
        r100.addAll(r101);
        new lqb.b(com.ss.android.lark.integrator.im.message.d.f428034a);
        r100.add(new f());
        return r100;
    }

    @Override // com.ss.android.lark.im.base.c
    public final void b() {
        ExtensionManager.a();
        Log.i("ExtensionManager", "injectImExtensionsIfNeed");
    }

    @Override // w4b.d
    public final Collection<k> d() {
        return (CopyOnWriteArrayList) ExtensionManager.a().f427940e.getValue();
    }

    @Override // w4b.d
    public final gya.a<Content> a(MessageType r100) {
        return ExtensionManager.b(r100);
    }
}
