package com.larksuite.component.card.utils;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.select.m;
import com.ss.android.lark.widget.select.p;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283965a = 0;

    public static final class a implements m.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<CharSequence, Unit> f283966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f283967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.widget.select.a f283968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f283969d;

        /* JADX INFO: renamed from: com.larksuite.component.card.utils.c$a$a, reason: collision with other inner class name */
        public static final class C3908a implements u.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.ss.android.lark.widget.select.a f283970a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<CharSequence, Unit> f283971b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f283972c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f283973d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f283974e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f283975f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ boolean f283976g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f283977h;

            /* JADX INFO: renamed from: com.larksuite.component.card.utils.c$a$a$a, reason: collision with other inner class name */
            public static final class RunnableC3909a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.ss.android.lark.widget.select.a f283978a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Function1<CharSequence, Unit> f283979b;

                /* JADX WARN: Multi-variable type inference failed */
                public RunnableC3909a(com.ss.android.lark.widget.select.a r100, Function1<? super CharSequence, Unit> r101) {
                    this.f283978a = r100;
                    this.f283979b = r101;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f283978a.a();     // Catch: Throwable -> L4
                    this.f283979b.invoke("");     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void a() {
                UICallbackExecutor.post(new RunnableC3909a(this.f283970a, this.f283971b));
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void b() {
                this.f283970a.b();
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void c() {
                this.f283970a.f();
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void d(int[] r100) {
                this.f283970a.g(r100);
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final a1 e(boolean r100) {
                if (r100 == true) goto L4;
                com.ss.android.lark.widget.select.g r101 = this.f283970a.c();
                if (r101 != null) goto L10;
                return null;
            L10:
                return new a1(r101.f448426b, r101.f448427c, r101.f448428d, r101.f448429e, r101.f448430f, this.f283977h);
            L4:
                return new a1(this.f283972c, this.f283973d, this.f283974e, this.f283975f, this.f283976g, this.f283977h);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C3908a(com.ss.android.lark.widget.select.a r100, Function1<? super CharSequence, Unit> r101, int r102, int r103, int r104, int r105, boolean r106, boolean r107, int r108) {
                this.f283970a = r100;
                this.f283971b = r101;
                this.f283972c = r102;
                this.f283973d = r103;
                this.f283974e = r104;
                this.f283975f = r105;
                this.f283976g = r106;
                this.f283977h = r108;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super CharSequence, Unit> r100, Function0<Unit> r101, com.ss.android.lark.widget.select.a r102, int r103) {
            this.f283966a = r100;
            this.f283967b = r101;
            this.f283968c = r102;
            this.f283969d = r103;
        }

        @Override // com.ss.android.lark.widget.select.m.d
        public final void a(com.ss.android.lark.widget.select.g r110) {
            Intrinsics.checkNotNullParameter(r110, "<destruct>");
            CharSequence r100 = r110.f448425a;
            int r101 = r110.f448426b;
            int r102 = r110.f448427c;
            int r103 = r110.f448428d;
            int r104 = r110.f448429e;
            boolean r105 = r110.f448430f;
            boolean r111 = r110.f448431g;
            this.f283966a.invoke(r100);
            C3908a r106 = new C3908a(this.f283968c, this.f283966a, r101, r102, r103, r104, r105, r111, this.f283969d);
            u r107 = u.a.f416743a;
            monitor-enter(r107);
            r107.c();     // Catch: Throwable -> L8
            r107.f416736a = r106;     // Catch: Throwable -> L8
            monitor-exit(r107);
            r107.f416738c = r111;
            r107.f416739d = true;
            this.f283967b.invoke();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements m.c {
        public b() {
        }

        @Override // com.ss.android.lark.widget.select.m.c
        public final /* synthetic */ void a() {
        }

        @Override // com.ss.android.lark.widget.select.m.c
        public final void b() {
            u r100 = u.a.f416743a;
            monitor-enter(r100);
            r100.c();     // Catch: Throwable -> L8
            r100.f416736a = null;     // Catch: Throwable -> L8
            monitor-exit(r100);
            r100.e();
            r100.f416741f = true;
            r100.f416742g = 1;
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public static void a(View r100, com.ss.android.lark.widget.select.a r101, Function1 r102, Function0 r103) {
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        r101.d(new a(r102, r103, r101, r104[0]));
        r101.e(new b());
        r101.show();
    }

    @JvmStatic
    public static final void b(AppCompatTextView r100, Activity r101, Function1<? super CharSequence, Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r102, "changeCopyAction");
        Intrinsics.checkNotNullParameter(r103, "onTextSelectedAction");
        p.a r104 = new p.a(r100, r101);
        r104.f448496c = UIUtils.getColor(r100.getContext(), R.color.primary_fill_default);
        r104.f448498e = UIHelper.dp2px(15.0f);
        r104.f448497d = j08.b.c(r100.getContext(), R.color.primary_fill_default, 0.2f);
        p r105 = new p(r104);
        Intrinsics.checkNotNull(r105);
        a(r100, r105, r102, r103);
    }
}
