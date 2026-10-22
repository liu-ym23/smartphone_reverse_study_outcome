package com.obric.assistant;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/IRemoteCard;", "", "init", "", "notifyCardChanged", "params", "Landroid/os/Bundle;", "onAppUpdated", "intent", "Landroid/content/Intent;", "onAppUninstall", "onAppChanged", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRemoteCard {
    void a(Intent r100);

    void b(Intent r100);

    void c(Intent r100);

    void init();

    void notifyCardChanged(Bundle r100);
}
