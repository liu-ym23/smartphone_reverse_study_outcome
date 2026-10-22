package com.ss.android.lark.coremd.clickcompat;

import b3b.j;
import b3b.s;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatImageClickHandler f419605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatAtClickHandler f419606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatLinkClickHandler f419607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatMediaClickHandler f419608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChatCodeBlockClickHandler f419609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.coremd.clickcompat.b f419610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.coremd.clickcompat.a f419611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f419612h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f419613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f419614b;

        public a(j r100, s r101) {
            this.f419613a = r100;
            this.f419614b = r101;
        }
    }

    public interface b {
        y6b.a<?> getMessageById(String r100);
    }

    public ChatMediaClickHandler a() {
        return this.f419608d;
    }

    public c(m2b.a r100, g.b r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "messageProvider");
        this.f419605a = new ChatImageClickHandler(r100, r101, r102, null);
        this.f419606b = new ChatAtClickHandler(r100, r101);
        this.f419607c = new ChatLinkClickHandler(r100, r101, r102);
        this.f419608d = new ChatMediaClickHandler(r100, r101, null);
        this.f419609e = new ChatCodeBlockClickHandler(r100, r101);
        this.f419610f = new com.ss.android.lark.coremd.clickcompat.b(r100);
        this.f419611g = new com.ss.android.lark.coremd.clickcompat.a(r100, r101);
        this.f419612h = new d(r100, r101);
    }
}
