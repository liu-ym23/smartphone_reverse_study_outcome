package com.bytedance.locallife.host;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J4\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\b\u0010\u0010\u001a\u00020\nH&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH&J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/host/ILifeBulletService;", "", "Lkotlin/Function0;", "", "onLifeRouterOpen", "initialize", "initBullet", "initXBridge", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "schema", "Landroid/os/Bundle;", "bundle", "closeCallback", "open", "getBid", "Landroid/app/Application;", "ap", "bid", "Lcom/bytedance/ies/bullet/base/c;", "getBulletConfig", "", "getBulletGlobalProps", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public interface ILifeBulletService {
    String getBid();

    c getBulletConfig(Application r100, String r101);

    Map<String, String> getBulletGlobalProps();

    void initBullet();

    void initXBridge();

    void initialize(Function0<Unit> r100);

    void open(Context r100, String r101, Bundle r102, Function0<Unit> r103);
}
