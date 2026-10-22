package com.bytedance.ee.bear.middleground.permission.apiimpl;

import by4.b;
import cj5.c;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jg5.q;
import jg5.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory implements Factory<c> {
    private final Provider<b> kvStorageProvider;
    private final r module;

    public c get() {
        return provideIShareUIService(this.module, (b) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m269get() {
        return get();
    }

    public ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory(r r1, Provider<b> r2) {
        this.module = r1;
        this.kvStorageProvider = r2;
    }

    public static ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory create(r r1, Provider<b> r2) {
        return new ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory(r1, r2);
    }

    public static c provideIShareUIService(r r0, b r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "kvStorage");
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r2 = new jg5.b();
    L10:
        return (c) Preconditions.checkNotNullFromProvides(r2);
    L8:
        q r3 = new q();
        r3.b = new jg5.c();
        r2 = r3;
        goto L10
    }
}
