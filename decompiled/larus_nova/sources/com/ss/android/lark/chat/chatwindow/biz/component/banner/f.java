package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerComponent f411982a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBannerComponent f411983a;

        public a(BaseBannerComponent r100) {
            this.f411983a = r100;
        }

        public final void a() {
            int r100 = this.f411983a.E0().getHeight();
            BaseBannerComponent r101 = this.f411983a;
            if (r100 == r101.f411965m) goto L11;
            List<IBannerComponent.a> r102 = r101.F0();
            BaseBannerComponent r103 = this.f411983a;
            Iterator<T> r104 = r102.iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            IBannerComponent.a r105 = (IBannerComponent.a) r104.next();
            int r106 = r103.f411965m;
            r105.a(r100);
            goto L6
        L8:
            this.f411983a.f411965m = r100;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBannerComponent f411984a;

        public b(BaseBannerComponent r100) {
            this.f411984a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseBannerComponent r100 = this.f411984a;     // Catch: Throwable -> L7
            int r101 = BaseBannerComponent.f411963p;     // Catch: Throwable -> L7
            List<IBannerComponent.a> r102 = r100.F0();     // Catch: Throwable -> L7
            BaseBannerComponent r103 = this.f411984a;     // Catch: Throwable -> L7
            Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L7
        L4:
            if (r104.hasNext() == false) goto L16;
            ((IBannerComponent.a) r104.next()).b(r103.E0().getHeight());     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void a() {
        this.f411982a.E0().post(new a(this.f411982a));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void b() {
        BaseBannerComponent r100 = this.f411982a;
        int r101 = BaseBannerComponent.f411963p;
        Iterator<T> r102 = r100.F0().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IBannerComponent.a) r102.next()).c();
        goto L4
    L6:
        this.f411982a.f411965m = 0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.a.b
    public final void onShow() {
        this.f411982a.E0().post(new b(this.f411982a));
    }

    public f(BaseBannerComponent r100) {
        this.f411982a = r100;
    }
}
