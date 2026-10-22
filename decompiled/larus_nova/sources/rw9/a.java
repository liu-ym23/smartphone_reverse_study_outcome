package rw9;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import sw9.g;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends ym9.a {

    /* JADX INFO: renamed from: rw9.a$a, reason: collision with other inner class name */
    public static final class C7545a {
    }

    static {
    }

    @Override // g45.a
    public final String getPanelName() {
        return "chat_input";
    }

    public a() {
    }

    @Override // g45.a
    public final int getPanelHeight(Context r100) {
        int r101 = g.a().getChatInputHeight();
        FLogger.f375446a.i("SheetEditPanelDelegate", "getPanelHeight: " + r101);
        return r101;
    }
}
