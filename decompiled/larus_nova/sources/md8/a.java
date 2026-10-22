package md8;

import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollectFrom f513424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f513425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513426c;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("from:");
        r100.append(this.f513424a);
        r100.append(",msg:");
        Message r101 = this.f513425b;
        if (r101 == null) goto L5;
        String r102 = r101.getMessageId();
    L6:
        r100.append(r102);
        r100.append(",collectId:");
        r100.append(this.f513426c);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public a(CollectFrom r100, Message r101, String r102) {
        this.f513424a = r100;
        this.f513425b = r101;
        this.f513426c = r102;
    }
}
