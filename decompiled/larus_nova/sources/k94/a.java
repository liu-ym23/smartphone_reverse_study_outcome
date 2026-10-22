package k94;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {
    public a() {
    }

    public abstract AbsContextServiceFetcher getContextServiceFetcher();

    public void onAttachedToContext(BdpAppContext r100) {
    }

    public void onDetachedFromContext(BdpAppContext r100) {
    }

    public void preloadClass() {
    }
}
