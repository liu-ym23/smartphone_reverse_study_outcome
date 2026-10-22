package com.bytedance.ee.bear.drive.biz.preview.more;

import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.supervisor.token.Token;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.w$a$a, reason: collision with other inner class name */
        public static final class C0151a<T> implements Consumer {
            public final /* synthetic */ com.bytedance.ee.bear.drive.biz.preview.more.a a;
            public final /* synthetic */ BaseMoreMenuAction b;

            public C0151a(com.bytedance.ee.bear.drive.biz.preview.more.a r1, BaseMoreMenuAction r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r3) {
                BaseMoreMenuAction r4 = (BaseMoreMenuAction) r3;
                if (r4.a == null) goto L6;
                tt5.a.h("DriveComponent", "executeMenuActionInBg() execute");
                r4.a();
                return;
            L6:
                if (this.a == null) goto L10;
                tt5.a.h("DriveComponent", "executeMenuActionInBg() run default implements");
                com.bytedance.ee.bear.drive.biz.preview.more.a r5 = this.a;
                if (r5 == null) goto L13;
                r5.a(this.b);
                return;
            L13:
                return;
            L10:
                tt5.a.d("DriveComponent", "executeMenuActionInBg() mistake, no action found");
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ long a;

            public b(long r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                BaseMoreMenuAction r6 = (BaseMoreMenuAction) r5;
                tt5.a.h("DriveComponent", "executeMenuActionInBg#executeMenuActionInBg() execute menu action done, cost time=" + (SystemClock.uptimeMillis() - this.a));
            }
        }

        public static final class c<T> implements Consumer {
            public static final c<T> a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final void accept(Object r4) {
                tt5.a.e("DriveComponent", "DriveSdkTitleBarPlugin#executeMenuActionInBg() error", (Throwable) r4, false);
            }
        }

        @JvmStatic
        public static void b(CompositeDisposable r4, BaseMoreMenuAction r5, com.bytedance.ee.bear.drive.biz.preview.more.a r6) {
            Intrinsics.checkNotNullParameter(r4, "cd");
            Intrinsics.checkNotNullParameter(r5, "moreMenuAction");
            long r0 = SystemClock.uptimeMillis();
            r4.add(Flowable.just(r5).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).doOnNext(new C0151a(r6, r5)).subscribe(new b(r0), c.a));
        }

        @JvmStatic
        public static void a(CompositeDisposable r3, FragmentActivity r4, BaseMoreMenuAction r5, com.bytedance.ee.bear.drive.biz.preview.more.a r6) {
            Intrinsics.checkNotNullParameter(r3, "cd");
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "downloadMenu");
            new HashMap(1).put("android.permission.WRITE_EXTERNAL_STORAGE", r4.getResources().getString(2131887805));
            tt5.a.h("DriveComponent", "DriveSdkTitleBarPlugin#checkRequestedPermissions");
            v r0 = new v(r3, r5, r6);
            com.ss.android.lark.utils.l r7 = com.ss.android.lark.utils.n.a();
            String r8 = r5.m;
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            com.ss.android.lark.utils.h.g(r4, r0, r7, new Token(r8), new String[0]);
        }
    }

    static {
    }
}
