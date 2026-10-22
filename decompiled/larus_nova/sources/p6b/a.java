package p6b;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.service.impl.u;
import com.ss.android.lark.chat.service.impl.v;
import com.ss.android.lark.videosend.compress.m;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.b f527953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f527954b;

    public a(d.b r100) {
        this.f527954b = -1;
        this.f527953a = r100;
    }

    @Override // com.ss.android.lark.videosend.tools.VideoTools.b
    public final void a(float r100) {
        if (this.f527954b != (-1)) goto L7;
        IGetDataCallback<String> r101 = this.f527953a.f527964e;
        if ((r101 instanceof v) == false) goto L7;
        ((v) r101).onCompressMediaStart();
    L7:
        int r102 = (int) (r100 * 60.0f);
        if (r102 > this.f527954b) goto L10;
        return;
    L10:
        d.b r103 = this.f527953a;
        if (r103.f527963d == true) goto L13;
    L15:
        this.f527954b = r102;
        return;
    L13:
        if ((r103.f527964e instanceof u) == false) goto L15;
        MediaContent r104 = new MediaContent((MediaContent) this.f527953a.f527961b.getContent());
        r104.setProgress(r102);
        this.f527953a.f527961b.setMessageContent(r104);
        d.b r105 = this.f527953a;
        ((u) r105.f527964e).onUpdateMediaCompressProgress(r105.f527961b);
        goto L15
    }
}
