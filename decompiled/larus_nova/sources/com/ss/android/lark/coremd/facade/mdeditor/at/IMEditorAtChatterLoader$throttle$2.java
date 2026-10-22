package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/larksuite/framework/utils/AndroidThrottle;", "Lcom/ss/android/lark/coremd/facade/mdeditor/at/IMEditorAtChatterLoader$FetchChatterRequest;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtChatterLoader$throttle$2 extends Lambda implements Function0<AndroidThrottle<com.ss.android.lark.coremd.facade.mdeditor.at.a.c>> {
    final /* synthetic */ com.ss.android.lark.coremd.facade.mdeditor.at.a this$0;

    public static final class a<T> implements AndroidThrottle.e {
        public a() {
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.e
        public final void a(Collection<com.ss.android.lark.coremd.facade.mdeditor.at.a.c> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            int r101 = com.ss.android.lark.coremd.facade.mdeditor.at.a.f419765a;
            throw null;
        }
    }

    public IMEditorAtChatterLoader$throttle$2(com.ss.android.lark.coremd.facade.mdeditor.at.a r100) {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AndroidThrottle<com.ss.android.lark.coremd.facade.mdeditor.at.a.c> invoke() {
        AndroidThrottle.a r100 = new AndroidThrottle.a();
        r100.f285878b = 0;
        r100.f285877a = CoreThreadPool.getNonblockingHandler();
        r100.f285880d = new com.ss.android.lark.coremd.facade.mdeditor.at.a.b();
        r100.f285881e = new a();
        return new AndroidThrottle(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AndroidThrottle<com.ss.android.lark.coremd.facade.mdeditor.at.a.c> invoke() {
        return invoke();
    }
}
