package gd1;

import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;

/* JADX INFO: loaded from: classes7.dex */
public interface b {

    public interface a {
        void Ln(String r100);
    }

    /* JADX INFO: renamed from: gd1.b$b, reason: collision with other inner class name */
    public interface InterfaceC6009b {
        void onSendResult(boolean r100, int r101, String r102, String r103);
    }

    void a(XplayBasicMessageType r100, a r101);

    void c(XplayBasicMessageType r100);

    void d(String r100, InterfaceC6009b r101);
}
