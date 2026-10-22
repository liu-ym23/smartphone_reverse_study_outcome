package rb6;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import lb6.d;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends d {

    /* JADX INFO: renamed from: rb6.a$a, reason: collision with other inner class name */
    public interface InterfaceC7456a {
        void W(long r100, OperateType r101);

        void c1(long r100, OperateType r101, BaseCheckException r102);
    }

    void x(Context r100, OperateType r101, int r102, InterfaceC7456a r103);
}
