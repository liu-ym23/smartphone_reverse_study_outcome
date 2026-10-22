package com.obric.assistant.system;

import android.content.ComponentName;
import kotlin.Metadata;
import lha.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/system/ITaskStackService;", "", "init", "", "getTopComponentName", "Landroid/content/ComponentName;", "getTopComponentNameExcludingIgnoredActivities", "getPreviousTopComponentName", "registerTaskStackListener", "listener", "Lcom/obric/assistant/system/ITaskStackListener;", "unregisterTaskStackListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITaskStackService {
    void a(g r100);

    ComponentName b();

    ComponentName c();

    void d(g r100);

    ComponentName e();

    void init();
}
