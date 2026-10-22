package j18;

import android.content.Context;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;

/* JADX INFO: loaded from: classes24.dex */
public interface b extends h {
    void c();

    void d(i18.d r100);

    i18.c getBridgeContext();

    Context getContext();

    void getParent();

    LKBasePluginResult sendEvent(LKEvent r100);
}
