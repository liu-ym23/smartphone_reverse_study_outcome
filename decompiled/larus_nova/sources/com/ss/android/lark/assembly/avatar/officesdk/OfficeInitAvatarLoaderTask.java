package com.ss.android.lark.assembly.avatar.officesdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import sz7.i;
import sz7.j;
import sz7.l;
import sz7.r;
import sz7.v;
import sz7.x;

/* JADX INFO: loaded from: classes34.dex */
public class OfficeInitAvatarLoaderTask extends AbstractLaunchTask {

    public class a implements sz7.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile j f408959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f408960b;

        public a(Context r100) {
            this.f408960b = r100;
        }
    }

    public class b extends sz7.e {
        public b(e r100) {
            super(r100);
        }

        @Override // sz7.b
        public final void a(Context r100, sz7.g r101, sz7.a r102, sz7.c r103, x r104) {
            sz7.d r105 = (sz7.d) r101;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r102, "avatarVO");
            Intrinsics.checkNotNullParameter(r103, "badgeVO");
            Intrinsics.checkNotNullParameter(r104, "miniIconVO");
            this.f543990a.a();
            Drawable r106 = AppCompatResources.getDrawable(r100, 0);
            boolean r107 = v.f544033a;
            if (v.a.a() == false) goto L5;
            r102.f543985d = null;
            r102.f543983b = r105.f543992a;
            r102.f543984c = null;
            r102.f543987f = r105.f543994c;
            r102.f543988g = r105.f543995d;
            r102.f543986e = r106;
        L7:
            if (v.a.a() == false) goto L9;
            this.f543990a.b();
            r104.f544038a = null;
        L10:
            Log.i("OfficeAvatar", String.format("doc name: %s, avatar: %s, fsUnit: %s", new Object[]{r105.f543989e, r105.f543992a, null}));
            return;
        L9:
            r104.f544038a = null;
            goto L10
        L5:
            r102.f543982a = r106;
            goto L7
        }
    }

    public static class c implements xz7.a {
        public c() {
        }

        @Override // xz7.a
        public final void a(final Context r100, final ImageView r101, final AvatarModel r102) {
            r101.setTag(R.id.avatar_tag, r102.f284044c);
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new cwa.a(this, r102, r100, r101));
        }

        @Override // xz7.a
        public final void b(final Context r100, final ImageView r101, final AvatarModel r102) {
            if (TextUtils.isEmpty(r102.f284044c) == true) goto L5;
        L10:
            int r103 = UIHelper.dp2px(r102.f284048g.getDpValue());
            AvatarImage r104 = AvatarImage.Builder.obtain(r102.f284044c, r102.f284045d, r103, r103).build();
            IRequestCreator r105 = ImageLoader.with(r100).load(r104).placeholder(r102.a(r100));
            ListenerParams.a r106 = new ListenerParams.a();
            r106.a(r102.f284050i);
            r106.d(r102.f284051j);
            r106.c(ListenerParams.FromType.AVATAR);
            r106.f426312a = false;
            r106.f426313b = false;
            r106.f426314c = r103;
            r106.f426315d = r103;
            r106.f426326o = r104.getKey();
            r105.listener(new PerfLoadPicMonitor.MonitorRequestListener(r106.b())).override(r103, r103).into(r101);
            return;
        L5:
            if (TextUtils.isEmpty(r102.f284045d) == false) goto L7;
        L8:
            Log.e("OfficeAvatar", "avatar model data invalid, skip load");
            UICallbackExecutor.execute(new cwa.b(r102, r100, r101));
            return;
        L7:
            if (TextUtils.equals(r102.f284045d, "0") == false) goto L10;
            goto L8
        }
    }

    public static class d extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f408962b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            l r101 = this.f408962b;
            if (r101 == null) goto L5;
            r101.onError(new IllegalStateException("icon load failed"));
        L5:
            Log.i("OfficeAvatar", String.format("%s: load failed", new Object[]{this.f408961a}));
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            final Drawable r101 = (Drawable) r100;
            if (this.f408962b == null) goto L9;
            Runnable r102 = new cwa.d(this, r101);
            if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
            UICallbackExecutor.post(r102);
            return;
        L7:
            r102.run();
            return;
        }

        public d(String r100, l r101) {
            this.f408961a = r100;
            this.f408962b = r101;
        }
    }

    public static class e implements xz7.d {
        public e() {
        }

        @Override // xz7.d
        public final void a() {
        }

        @Override // xz7.d
        public final void b() {
        }
    }

    public static class f implements i {
        public f() {
        }

        @Override // sz7.i
        public final void a(Context r100, String r101, int r102, int r103, l r104) {
            EncryptImage r105 = new EncryptImage(r101);
            ImageLoader.with(r100).load(r105).asDrawable().override(r102, r103).into(new d(r101, r104));
        }
    }

    public static class g implements j {
        public g() {
        }

        @Override // sz7.j
        public final void a(Context r100, String r101, String r102, int r103, int r104, ImageView r105) {
            EncryptImage r106 = new EncryptImage(r101);
            ImageLoader.with(r100).load(r106).asDrawable().override(r103, r104).into(r105);
        }

        @Override // sz7.j
        public final void b(Context r100, String r101, String r102, String r103, int r104, int r105, r r106) {
            int r107 = 180;
            if (r104 <= 0) goto L5;
            int r108 = r104;
        L6:
            if (r105 <= 0) goto L8;
            r107 = r105;
        L8:
            AvatarImage r109 = AvatarImage.Builder.obtain(r101, r102, r108, r107).fsUnit(r103).build();
            ImageLoader.with(r100).load(r109).asDrawable().override(r104, r105).into(new d(r101, r106));
            return;
        L5:
            r108 = 180;
            goto L6
        }
    }

    public static class h implements j {
        public h() {
        }

        @Override // sz7.j
        public final void a(final Context r110, final String r111, final String r112, final int r113, final int r114, final ImageView r115) {
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new cwa.e(r111, r112, r113, r114, r110, r115));
        }

        @Override // sz7.j
        public final void b(final Context r100, final String r110, String r111, final String r112, final int r113, final int r114, final r r115) {
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new cwa.f(r110, r112, r113, r114, r100, r115));
        }
    }

    public OfficeInitAvatarLoaderTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        a r101 = new a(r100.getApplicationContext());
        boolean r102 = v.f544033a;
        Intrinsics.checkNotNullParameter(r101, "dependence");
        if (v.f544033a == true) goto L6;
        v.f544034b = r101;
        v.f544033a = true;
    L6:
        b r103 = new b(new e());
        Intrinsics.checkNotNullParameter(sz7.d.class, "modelClass");
        Intrinsics.checkNotNullParameter(r103, "handler");
        v.f544035c.put(sz7.d.class, r103);
    }
}
