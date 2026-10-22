package fgb;

import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.audio.AudioResourceLoadTask;
import com.ss.android.lark.chat.core.api.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.ss.android.lark.chat.core.api.e
    public final List<IMessageResourcePreloadTask> a(f r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = new ArrayList();
        r101.add(new AudioResourceLoadTask(r100));
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((IMessageResourcePreloadTask) r104).getScenes().contains("chat") == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    @Override // com.ss.android.lark.chat.core.api.e
    public final List<IMessageResourcePreloadTask> b(f r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ArrayList();
    }
}
