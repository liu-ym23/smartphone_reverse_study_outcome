package com.larus.luckydog.api;

import android.net.Uri;
import android.widget.FrameLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/larus/luckydog/api/ILuckyDogService;", "", "isLuckyDogSchema", "", "uri", "Landroid/net/Uri;", "handleLuckyDogSchema", "", "schema", "", "isFromHandleDeeplink", "reportTaskCompleted", "taskType", "Lcom/larus/luckydog/api/LuckyDogCountTaskType;", "showLuckDogPendantView", "frameLayout", "Landroid/widget/FrameLayout;", "dismissLuckDogPendantView", "initLuckDogSdk", "isNewUserAcquisition", "isUserReactivation", "preInit", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILuckyDogService {
    void a(LuckyDogCountTaskType r100);

    void b(FrameLayout r100);

    void c(FrameLayout r100);

    boolean d(Uri r100);

    boolean e();

    void f(String r100, boolean r101);

    boolean g();

    void h();

    void preInit();
}
