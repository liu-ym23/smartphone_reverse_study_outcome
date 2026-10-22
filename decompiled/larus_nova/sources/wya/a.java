package wya;

import android.view.View;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowRelationshipBanner;
import kotlin.jvm.internal.Intrinsics;
import wya.c;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a<T extends c> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f561887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f561888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f561889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f561890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f561891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f561892f;

    /* JADX INFO: renamed from: wya.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC8174a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f561893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f561894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f561895c;

        public AbstractC8174a() {
            this.f561895c = true;
        }
    }

    @Override // wya.b
    public final void destroy() {
    }

    @Override // wya.b
    public int getLayoutId() {
        return 0;
    }

    @Override // wya.b
    public final void getListener() {
    }

    @Override // wya.b
    public abstract /* synthetic */ int getType();

    @Override // wya.b
    public final int e() {
        return this.f561888b;
    }

    @Override // wya.b
    public final View getBanner() {
        return this.f561892f;
    }

    @Override // wya.b
    public final int getPriority() {
        return this.f561887a;
    }

    @Override // wya.b
    public final boolean isEnabled() {
        return this.f561889c;
    }

    @Override // wya.b
    public final boolean isShown() {
        return this.f561890d;
    }

    public a(FlowRelationshipBanner.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f561887a = r100.f561893a;
        this.f561888b = r100.f561894b;
        this.f561889c = r100.f561895c;
    }

    @Override // wya.b
    public final void a(com.ss.android.lark.chat.chatwindow.biz.component.banner.c r100) {
        this.f561891e = r100;
    }

    @Override // wya.b
    public final void b(boolean r100) {
        this.f561890d = r100;
    }

    @Override // wya.b
    public void c(View r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f561892f = r100;
    }
}
