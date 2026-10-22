package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyMediator", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyMediator;", "contentView", "Landroid/view/View;", "loadingConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView$LoadingConfig;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "init", "", "showByResult", "result", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Result;", "showByCode", "serverErrorCode", "", "showByError", "e", "", "show", "emptyState", "checkInit", "Companion", "LoadingConfig", "WikiEmptyConfig", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiEmptyView extends EmptyView {
    public static final /* synthetic */ int j = 0;
    public com.bytedance.ee.bear.facade.common.empty.c f;
    public View g;
    public b h;
    public final CompositeDisposable i;

    public static final class WikiEmptyConfig {
        public final Context a;
        public final String b;
        public final Integer c;
        public final Function0<Config> d;

        public WikiEmptyConfig(Context r2, String r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "lang");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new WikiEmptyView$WikiEmptyConfig$value$1(this);
        }
    }

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WikiEmptyView a;

        public c(WikiEmptyView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            com.bytedance.ee.bear.facade.common.empty.c r5 = this.a.f;
            if (r5 == null) goto L6;
            r5.a(new EmptyStateSource.b(0));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Wiki_WikiEmptyView", "delay loading fail. ", (Throwable) r4, false);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(int r6) {
        if (this.f != null) goto L8;
        getContext();
        this.f = new com.bytedance.ee.bear.facade.common.empty.c(this, this.g);
        Context r1 = getContext();
        Integer r4 = null;
        String r2 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        if (this.h == null) goto L7;
        r4 = 2131560087;
    L7:
        setConfig((Config) new WikiEmptyConfig(r1, r2, r4).d.invoke());
    L8:
        this.i.clear();
        if (r6 == 0) goto L13;
        com.bytedance.ee.bear.facade.common.empty.c r0 = this.f;
        if (r0 == null) goto L15;
        r0.a(new EmptyStateSource.b(r6));
        return;
    L15:
        return;
    L13:
        this.i.add(Flowable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new c(this), d.a));
    }

    public final void d(int r2) {
        if (r2 != (-4)) goto L5;
        int r3 = 10;
    L19:
        c(r3);
        return;
    L5:
        if (r2 != (-3)) goto L7;
        r3 = 9;
        goto L19
    L7:
        if (r2 != (-2)) goto L9;
        r3 = 1;
        goto L19
    L9:
        if (r2 != 920004007) goto L11;
    L15:
        r3 = 99;
        goto L19
    L11:
        if (r2 == 920004012) goto L15;
        switch(r2) {
            case 920004001: goto L14;
            case 920004002: goto L14;
            case 920004003: goto L15;
            case 920004004: goto L15;
            default: goto L13;
        };
    L13:
        r3 = 3;
        goto L19
    L14:
        r3 = 5;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Throwable r2) {
        if ((r2 instanceof WikiException) == false) goto L14;
        int r3 = ((WikiException) r2).getCode();
        if (r3 != (-100001)) goto L7;
        int r4 = 10;
    L13:
        c(r4);
        return;
    L7:
        if (r3 != (-55)) goto L9;
    L11:
        r4 = 5;
        goto L13
    L9:
        if (r3 == 920004002) goto L11;
        r4 = 3;
        goto L13
    L14:
        d(tp5.b.a(r2));
    }

    public WikiEmptyView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.i = new CompositeDisposable();
    }
}
