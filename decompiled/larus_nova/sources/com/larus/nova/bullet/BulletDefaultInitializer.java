package com.larus.nova.bullet;

import com.bytedance.ies.bullet.base.b;
import com.larus.platform.service.c1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/nova/bullet/BulletDefaultInitializer;", "Lcom/bytedance/ies/bullet/base/IBulletDefaultInitializer;", "<init>", "()V", "init", "", "Companion", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BulletDefaultInitializer implements b {
    public static final a Companion = null;
    private static final String TAG = "BulletDefaultInitializer";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BulletDefaultInitializer() {
    }

    @Override // com.bytedance.ies.bullet.base.b
    public void init() {
        c1 r100 = c1.f365723a;
        if (r100.d() == false) goto L5;
        FLogger.f375446a.w(TAG, "anniex is inited");
        return;
    L5:
        FLogger.f375446a.i(TAG, "anniex init by BulletDefaultInitializer");
        r100.f();
    }
}
