package h94;

import android.os.Looper;
import com.bytedance.bdp.appbase.base.bdptask.BdpHandler;
import com.bytedance.bdp.serviceapi.defaults.permission.b;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "为了兼容小游戏暂时保留 后续删除")
public abstract class a extends b {
    public a() {
        super(new BdpHandler(Looper.getMainLooper()));
    }
}
