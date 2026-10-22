package lf8;

import android.view.View;
import com.larus.bmhome.chat.cache.MessageHeightCache;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f509091a;

    public d(Message r100) {
        this.f509091a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        if (o0.d(this.f509091a.getMessageId()) == false) goto L9;
        MessageHeightCache r109 = MessageHeightCache.INSTANCE;
        String r110 = this.f509091a.getMessageId();
        if (r110 != null) goto L7;
        r110 = "";
    L7:
        r109.put(r110, Integer.valueOf(r100.getHeight()));
        return;
    }
}
