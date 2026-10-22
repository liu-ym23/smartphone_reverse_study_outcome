package com.bytedance.bdp.serviceapi.hostimpl.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdp.serviceapi.defaults.ui.model.BdpAnimationConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/ui/BdpAnimationView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "", "getRepeatMode", "()I", "setRepeatMode", "(I)V", "repeatMode", "getRepeatCount", "setRepeatCount", "repeatCount", "Lcom/bytedance/bdp/serviceapi/defaults/ui/model/BdpAnimationConfig;", "getConfig", "()Lcom/bytedance/bdp/serviceapi/defaults/ui/model/BdpAnimationConfig;", "setConfig", "(Lcom/bytedance/bdp/serviceapi/defaults/ui/model/BdpAnimationConfig;)V", "config", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public abstract class BdpAnimationView extends AppCompatImageView implements Animatable {

    public static final class a {
    }

    static {
    }

    public abstract BdpAnimationConfig getConfig();

    public abstract int getRepeatCount();

    public abstract int getRepeatMode();

    public abstract void setConfig(BdpAnimationConfig r100);

    public abstract void setRepeatCount(int r100);

    public abstract void setRepeatMode(int r100);

    public BdpAnimationView(Context r100) {
        super(r100);
    }
}
