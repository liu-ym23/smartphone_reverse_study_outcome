package com.larus.platform.api;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/IFlowOfficeWikiTokenResolver;", "", "resolveObjectToken", "", WikiFolderPushPlugin.WIKI_TOKEN, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowOfficeWikiTokenResolver {
    Object a(String r100, Continuation<? super String> r101);
}
