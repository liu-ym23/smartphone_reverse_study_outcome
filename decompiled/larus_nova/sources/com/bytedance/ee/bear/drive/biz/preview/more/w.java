package com.bytedance.ee.bear.drive.biz.preview.more;

import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f223656a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.w$a$a, reason: collision with other inner class name */
        public static final class C3207a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.drive.biz.preview.more.a f223657a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BaseMoreMenuAction f223658b;

            public C3207a(com.bytedance.ee.bear.drive.biz.preview.more.a r100, BaseMoreMenuAction r101) {
                this.f223657a = r100;
                this.f223658b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                BaseMoreMenuAction r101 = (BaseMoreMenuAction) r100;
                if (r101.f217004a == null) goto L6;
                tt5.a.h("DriveComponent", "executeMenuActionInBg() execute");
                r101.a();
                return;
            L6:
                if (this.f223657a == null) goto L10;
                tt5.a.h("DriveComponent", "executeMenuActionInBg() run default implements");
                com.bytedance.ee.bear.drive.biz.preview.more.a r102 = this.f223657a;
                if (r102 == null) goto L13;
                r102.a(this.f223658b);
                return;
            L13:
                return;
            L10:
                tt5.a.d("DriveComponent", "executeMenuActionInBg() mistake, no action found");
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f223659a;

            public b(long r100) {
                this.f223659a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                BaseMoreMenuAction r101 = (BaseMoreMenuAction) r100;
                tt5.a.h("DriveComponent", "executeMenuActionInBg#executeMenuActionInBg() execute menu action done, cost time=" + (SystemClock.uptimeMillis() - this.f223659a));
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c<T> f223660a = null;

            static {
                f223660a = new c();
            }

            public c() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.e("DriveComponent", "DriveSdkTitleBarPlugin#executeMenuActionInBg() error", (Throwable) r100, false);
            }
        }

        @JvmStatic
        public static void b(CompositeDisposable r100, BaseMoreMenuAction r101, com.bytedance.ee.bear.drive.biz.preview.more.a r102) {
            Intrinsics.checkNotNullParameter(r100, "cd");
            Intrinsics.checkNotNullParameter(r101, "moreMenuAction");
            long r103 = SystemClock.uptimeMillis();
            r100.add(Flowable.just(r101).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).doOnNext(new C3207a(r102, r101)).subscribe(new b(r103), c.f223660a));
        }

        @JvmStatic
        public static void a(CompositeDisposable r100, FragmentActivity r101, BaseMoreMenuAction r102, com.bytedance.ee.bear.drive.biz.preview.more.a r103) {
            Intrinsics.checkNotNullParameter(r100, "cd");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "downloadMenu");
            new HashMap(1).put("android.permission.WRITE_EXTERNAL_STORAGE", r101.getResources().getString(R.string.Doc_Facade_PermissionStorage));
            tt5.a.h("DriveComponent", "DriveSdkTitleBarPlugin#checkRequestedPermissions");
            v r104 = new v(r100, r102, r103);
            com.ss.android.lark.utils.l r105 = com.ss.android.lark.utils.n.a();
            String r106 = r102.f217016m;
            if (r106 != null) goto L5;
            r106 = "";
        L5:
            com.ss.android.lark.utils.h.g(r101, r104, r105, new Token(r106), new String[0]);
        }
    }

    static {
    }
}
