package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import java.util.HashSet;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "内部解耦用的临时接口，随时下线，请勿使用")
public interface a0 {
    e b(Uri r100, boolean r101, boolean r102, BulletContainerView r103);

    void c(HashSet<String> r100);

    PoolResult d(Uri r100, BulletContainerView r101);

    void e(Uri r100, Context r101, long r102, y r103);
}
