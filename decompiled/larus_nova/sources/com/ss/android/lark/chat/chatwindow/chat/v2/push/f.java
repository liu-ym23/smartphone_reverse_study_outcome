package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f414571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w4b.c0 f414572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C4843f f414573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f414574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f414575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f414576f;

    public interface a {
        void onFileDownloadFail();

        void onSwitchToCellularDataNetwork(boolean r100);

        com.ss.android.lark.chatbase.l<f5b.b> stream();
    }

    public static final class b implements aqb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f414577a;

        @Override // aqb.b
        public final void a() {
            a r100 = this.f414577a.f414571a.get();
            if (r100 == null) goto L6;
            r100.onSwitchToCellularDataNetwork(true);
            return;
        }

        @Override // aqb.b
        public final void b() {
            a r100 = this.f414577a.f414571a.get();
            if (r100 == null) goto L6;
            r100.onFileDownloadFail();
            return;
        }

        @Override // aqb.b
        public final void c() {
            a r100 = this.f414577a.f414571a.get();
            if (r100 == null) goto L6;
            r100.onSwitchToCellularDataNetwork(false);
            return;
        }

        public b(f r100) {
            this.f414577a = r100;
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements aqb.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f414578a;

        public d(f r100) {
            this.f414578a = r100;
        }

        @Override // aqb.g
        public final void onPushUploadProgress(String r100, int r101) {
            a r102 = this.f414578a.f414571a.get();
            if (r102 == null) goto L10;
            com.ss.android.lark.chatbase.l<f5b.b> r103 = r102.stream();
            if (r103 == null) goto L11;
            Intrinsics.checkNotNull(r100);
            com.ss.android.lark.chatbase.l<f5b.b> r104 = r103.query(r100);
            if (r104 == null) goto L12;
            r104.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.f(r101));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class e implements j5b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f414579a;

        public e(f r100) {
            this.f414579a = r100;
        }

        @Override // j5b.a
        public final void a(String r100, int r101) {
            a r102 = this.f414579a.f414571a.get();
            if (r102 == null) goto L10;
            com.ss.android.lark.chatbase.l<f5b.b> r103 = r102.stream();
            if (r103 == null) goto L11;
            Intrinsics.checkNotNull(r100);
            com.ss.android.lark.chatbase.l<f5b.b> r104 = r103.query(r100);
            if (r104 == null) goto L12;
            r104.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.d(r101));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.push.f$f, reason: collision with other inner class name */
    public static final class C4843f implements aqb.i {
        public C4843f() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().registerSourceMessageRecalledEventListener(this.f414573c);
        ChatCoreModule.a().getDownloadDependency().b(this.f414575e);
        this.f414572b.b(this.f414574d);
        this.f414572b.e();
        this.f414572b.g(this.f414576f);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().unRegisterSourceMessageRecalledEventListener(this.f414573c);
        ChatCoreModule.a().getDownloadDependency().a(this.f414575e);
        this.f414572b.d(this.f414574d);
        this.f414572b.c();
        this.f414572b.a(this.f414576f);
    }

    public f(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f414571a = new WeakReference(r101);
        this.f414572b = ChatCoreModule.a().getPushDependency();
        this.f414573c = new C4843f();
        this.f414574d = new d(this);
        this.f414575e = new b(this);
        new c();
        this.f414576f = new e(this);
    }
}
