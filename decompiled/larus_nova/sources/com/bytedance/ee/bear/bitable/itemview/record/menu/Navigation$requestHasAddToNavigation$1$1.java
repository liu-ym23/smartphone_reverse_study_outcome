package com.bytedance.ee.bear.bitable.itemview.record.menu;

import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/record/menu/Navigation$requestHasAddToNavigation$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", POINativeModule.RESP_EXIST, LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Navigation$requestHasAddToNavigation$1$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ b this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f214153a;

        public a(b r100) {
            this.f214153a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f214153a.b();     // Catch: Throwable -> L4
            m.z(this.f214153a.f214157b, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public Navigation$requestHasAddToNavigation$1$1(b r100) {
        this.this$0 = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        int r101 = b.f214155h;
        tt5.a.d("NavigationItem", "request isExistFavoriteTab err: " + r100);
    }

    public void onSuccess(boolean r100) {
        int r101 = b.f214155h;
        tt5.a.h("NavigationItem", "request isExistFavoriteTab success,exist: " + r100);
        b r102 = this.this$0;
        r102.f214160e = r100;
        m.k(r102.f214157b, new a(r102));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess(((Boolean) r100).booleanValue());
    }
}
