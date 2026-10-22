package baa;

import android.content.Context;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import z9a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c implements w9a.a {
    public static final a c = null;
    public static final Lazy<c> d = null;
    public final Lazy b;

    public static final class a {
        public a() {
        }
    }

    static {
        c = new a();
        d = LazyKt.lazy(new baa.a());
    }

    private final Context getContext() {
        return (Context) this.b.getValue();
    }

    public c() {
        this.b = LazyKt.lazy(new b());
    }

    @Override // w9a.a
    public final void a() {
        d r0 = d.a;
    }

    @Override // w9a.a
    public final RomInfo b() {
        return RomInfo.a;
    }

    @Override // w9a.a
    public final ObricActivityManager.Companion c() {
        return ObricActivityManager.a;
    }

    @Override // w9a.a
    public final void d() {
        aaa.c r0 = aaa.c.a;
    }

    @Override // w9a.a
    public final ObricActivityTaskManager.Companion e() {
        return ObricActivityTaskManager.a;
    }

    @Override // w9a.a
    public final ObricWindowManager.Companion windowManager() {
        return ObricWindowManager.a;
    }
}
