package s2b;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends com.ss.android.lark.chat.message.menu.context.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y6b.c f540321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f540322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c f540323j;

    @Override // com.ss.android.lark.chat.message.menu.context.b, yya.a
    public final Fragment d() {
        return this.f540323j.f540328e.getFragment();
    }

    @Override // yya.a
    public final Message g() {
        MessageInfo r100 = this.f540323j.f540328e.p(this.f540321h.f566482c);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMessage();
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        return this.f540323j.f540324a;
    }

    @Override // yya.a
    public final p5b.c k() {
        return this.f540323j.f540328e.p(this.f540321h.f566482c);
    }

    @Override // yya.a
    public final Chatter q() {
        return this.f540323j.f540328e.g7();
    }

    @Override // yya.a
    public final Chatter u() {
        return this.f540323j.f540328e.N0();
    }

    @Override // yya.a
    public final boolean Y() {
        return this.f540322i;
    }

    @Override // yya.a
    public final v5b.c m() {
        return this.f540321h;
    }

    @Override // yya.a
    public final <T extends mya.g> T j(Class<T> r100) {
        return (T) this.f540323j.f540325b.j5().b(r100);
    }

    public b(c r100, yya.n r101, PageType r102, m2b.a r103, com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r104, y6b.c r105) {
        this.f540323j = r100;
        this.f540321h = r105;
        this.f540322i = true;
        super(r101, r102, r103, r104);
    }
}
