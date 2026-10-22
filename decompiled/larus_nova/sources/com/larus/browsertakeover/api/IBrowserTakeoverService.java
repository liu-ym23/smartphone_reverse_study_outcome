package com.larus.browsertakeover.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor;
import hv8.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/larus/browsertakeover/api/IBrowserTakeoverService;", "", "open", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "request", "Lcom/larus/browsertakeover/api/BrowserTakeoverRequest;", "delegate", "Lcom/larus/browsertakeover/api/TakeoverTaskDelegate;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBrowserTakeoverService {
    boolean a(FragmentActivity r100, a r101, RequestActionBrowserOperationInterceptor.CompletionDelegate r102);
}
