package cx9;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import ex9.e;

/* JADX INFO: loaded from: classes31.dex */
public final class b extends ym9.a {

    public static final class a {
    }

    static {
    }

    @Override // g45.a
    public final String getPanelName() {
        return "chat_input";
    }

    public b() {
    }

    @Override // g45.a
    public final int getPanelHeight(Context r100) {
        int r101 = e.a().getChatInputHeight();
        FLogger.f375446a.i("SlidesEditPanelDelegate", "getPanelHeight: " + r101);
        return r101;
    }
}
