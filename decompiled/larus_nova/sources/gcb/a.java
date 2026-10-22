package gcb;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.thread.CoreThreadPool;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static hcb.a a() {
        return (hcb.a) ClaymoreServiceLoader.loadFirst(hcb.a.class);
    }

    public static void b() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new jcb.c());
    }
}
