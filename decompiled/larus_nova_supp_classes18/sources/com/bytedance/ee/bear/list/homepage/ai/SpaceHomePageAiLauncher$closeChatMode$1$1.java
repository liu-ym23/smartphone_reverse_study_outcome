package com.bytedance.ee.bear.list.homepage.ai;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/ee/bear/list/homepage/ai/SpaceHomePageAiLauncher$closeChatMode$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", WikiFolderPushPlugin.DATA, "(Ljava/lang/Boolean;)V", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceHomePageAiLauncher$closeChatMode$1$1 implements IGetDataCallback<Boolean> {
    public SpaceHomePageAiLauncher$closeChatMode$1$1() {
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        a.d("SpaceHomePageAiLauncher", "closeChatMode error:" + r3);
    }

    public void onSuccess(Boolean r3) {
        a.h("SpaceHomePageAiLauncher", "closeChatMode:" + r3);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Boolean) r1);
    }
}
