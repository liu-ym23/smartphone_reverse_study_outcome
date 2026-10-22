package ee6;

import android.app.Application;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {
    public a() {
    }

    public final boolean a() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().isDebug();
    }

    @Override // ee6.b
    public Application getContext() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().getContext();
    }
}
