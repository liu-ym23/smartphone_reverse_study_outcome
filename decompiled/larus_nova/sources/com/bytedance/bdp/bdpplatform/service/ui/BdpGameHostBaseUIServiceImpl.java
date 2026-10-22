package com.bytedance.bdp.bdpplatform.service.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.o;
import com.bytedance.bdp.bdpplatform.service.ui.loading.LoadingView;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpDatePickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpMultiPickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpNormalPickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpTimePickerCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ib4.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class BdpGameHostBaseUIServiceImpl implements BdpGameHostBaseUIService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<com.bytedance.bdp.serviceapi.defaults.ui.model.b> f201399a;

    /* JADX INFO: loaded from: classes11.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Activity r100) {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f201400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f201401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f201402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f201403d;

        public class a implements ha4.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f201404a;

            public a(b r100) {
                this.f201404a = r100;
            }
        }

        public final void a() {
            Activity r100 = this.f201400a;
            if (r100 == null) goto L44;
            String[] r101 = this.f201401b;
            if (r101 == null) goto L47;
            String r102 = this.f201402c;
            String r103 = this.f201403d;
            a r104 = new a(this);
            ContextThemeWrapper r105 = new ContextThemeWrapper(r100, R.style.bdp_DialogTheme);
            ia4.a.b r106 = new ia4.a.b(r105);
            if (TextUtils.isEmpty(r103) == true) goto L11;
            r106.f488896b = r103;
        L11:
            if (TextUtils.isEmpty(r102) == false) goto L13;
        L15:
            ha4.b r107 = new ha4.b(r104);
            r106.f488898d = r101;
            r106.f488900f = r107;
        L16:
            r106.f488897c = new ha4.c(r104);
            ia4.e r108 = new ia4.e(r105);
            ia4.a r109 = r108.f488909a;
            CharSequence r110 = r106.f488896b;
            if (r110 == null) goto L22;
            r109.f488877d = r110;
            TextView r111 = r109.f488885l;
            if (r111 == null) goto L22;
            r111.setText(r110);
        L22:
            if (r106.f488898d == null) goto L24;
        L25:
            ListView r112 = (ListView) r106.f488895a.inflate(r109.f488890q, null);
            int r113 = r109.f488891r;
            ListAdapter r114 = r106.f488899e;
            if (r114 != null) goto L29;
            r114 = new ia4.a.d(r105, r113, r106.f488898d);
        L29:
            r109.f488887n = r114;
            r109.f488888o = -1;
            if (r106.f488900f == null) goto L32;
            r112.setOnItemClickListener(new ia4.d(r106, r109));
        L32:
            r109.f488878e = r112;
        L33:
            r108.setCancelable(true);
            r108.setCanceledOnTouchOutside(true);
            r108.setOnCancelListener(r106.f488897c);
            r108.setOnDismissListener(null);
            r108.setCanceledOnTouchOutside(true);
            if (r100.isFinishing() == false) goto L36;
            return;
        L36:
            if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L42;
            DialogLancet.handleBlockedDialogShow(r108);
            return;
        L42:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
        L39:
            DialogLancet.beforeDialogShow(r108);
            r108.show();
            DialogLancet.afterDialogShow(r108);
            return;
        L24:
            if (r106.f488899e == null) goto L33;
        L13:
            if (Pattern.matches("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6}|[0-9a-fA-F]{3})$", r102) == false) goto L15;
            ha4.e r115 = new ha4.e(r100, r101, o.c(r102, r100.getResources().getString(R.color.bdp_black_1)));
            ha4.a r116 = new ha4.a(r104);
            r106.f488899e = r115;
            r106.f488900f = r116;
            goto L16
        L47:
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

        public b(Activity r100, String[] r101, String r102, String r103) {
            this.f201400a = r100;
            this.f201401b = r101;
            this.f201402c = r102;
            this.f201403d = r103;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class c implements Callable<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.d.Q);
        }

        public c() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f201405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f201406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BdpNormalPickerCallback f201407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f201408d;

        public class a implements ib4.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f201409a;

            @Override // ib4.e
            public final void onCancel() {
                this.f201409a.f201407c.onCancel();
            }

            public a(d r100) {
                this.f201409a = r100;
            }
        }

        public class b implements DialogInterface.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f201410a;

            public b(d r100) {
                this.f201410a = r100;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r100) {
                this.f201410a.f201407c.onDismiss();
            }
        }

        public class c implements com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.b.InterfaceC2904b<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f201411a;

            public c(d r100) {
                this.f201411a = r100;
            }
        }

        public final void a() {
            com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.b r100 = new com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.b(this.f201405a, this.f201406b);
            r100.C = new a(this);
            b r101 = new b(this);
            r100.f497853c.setOnDismissListener(new ja4.a(r100, r101));
            r100.U = new c(this);
            int r102 = this.f201408d;
            if (r102 >= 0) goto L5;
        L7:
            r100.d();
            return;
        L5:
            if (r102 >= r100.R.size()) goto L7;
            r100.V = r102;
            goto L7
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

        public d(Activity r100, List r101, BdpNormalPickerCallback r102, int r103) {
            this.f201405a = r100;
            this.f201406b = r101;
            this.f201407c = r102;
            this.f201408d = r103;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f201412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BdpTimePickerCallback f201413b;

        @Override // java.lang.Runnable
        public final void run() {
            new com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.c(this.f201412a);     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(Activity r100, BdpTimePickerCallback r101) {
            this.f201412a = r100;
            this.f201413b = r101;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpDatePickerCallback f201414a;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(Activity r100, BdpDatePickerCallback r101) {
            this.f201414a = r101;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f201415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f201416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int[] f201417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BdpMultiPickerCallback f201418d;

        public class a implements ib4.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f201419a;

            @Override // ib4.e
            public final void onCancel() {
                this.f201419a.f201418d.onCancel();
            }

            public a(g r100) {
                this.f201419a = r100;
            }
        }

        public class b implements DialogInterface.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f201420a;

            public b(g r100) {
                this.f201420a = r100;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r100) {
                this.f201420a.f201418d.onCancel();
            }
        }

        public class c implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f201421a;

            public c(g r100) {
                this.f201421a = r100;
            }
        }

        public class d implements ib4.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f201422a;

            public d(g r100) {
                this.f201422a = r100;
            }
        }

        public final void a() {
            com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a r100 = new com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a(this.f201415a, this.f201416b);
            r100.T = this.f201417c;
            r100.d();
            r100.C = new a(this);
            b r101 = new b(this);
            r100.f497853c.setOnDismissListener(new ja4.a(r100, r101));
            r100.W = new c(this);
            r100.V = new d(this);
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

        public g(Activity r100, List r101, int[] r102, BdpMultiPickerCallback r103) {
            this.f201415a = r100;
            this.f201416b = r101;
            this.f201417c = r102;
            this.f201418d = r103;
        }
    }

    public BdpGameHostBaseUIServiceImpl() {
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final ib4.c createToastView(Context r100) {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final synchronized com.bytedance.bdp.serviceapi.defaults.ui.model.b getHostCustomUiConfig() {
        monitor-enter(this);
        WeakReference<com.bytedance.bdp.serviceapi.defaults.ui.model.b> r100 = f201399a;     // Catch: Throwable -> L15
        if (r100 != null) goto L6;
        com.bytedance.bdp.serviceapi.defaults.ui.model.b r101 = null;
    L7:
        if (r101 != null) goto L13;
        com.bytedance.bdp.serviceapi.defaults.ui.model.b r102 = new com.bytedance.bdp.serviceapi.defaults.ui.model.b(new com.bytedance.bdp.serviceapi.defaults.ui.model.b.a());     // Catch: Throwable -> L15
        WeakReference<com.bytedance.bdp.serviceapi.defaults.ui.model.b> r103 = f201399a;     // Catch: Throwable -> L15
        if (r103 == null) goto L11;
        r103.clear();     // Catch: Throwable -> L15
    L11:
        f201399a = new WeakReference(r102);     // Catch: Throwable -> L15
        r101 = r102;
    L13:
        monitor-exit(this);
        return r101;
    L6:
        r101 = r100.get();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final boolean isPickerShowing() {
        FutureTask r100 = new FutureTask(new c());
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(r100);
    L13:
        return ((Boolean) r100.get()).booleanValue();
    L5:
        e = move-exception;
        e.printStackTrace();
    L9:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final ib4.b createMultiPicker(Activity r100) {
        return new com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a(r100, null);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final ib4.a getLoadingView(Context r100) {
        return new LoadingView(r100);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final Dialog getBottomMenuDialog(Activity r100, com.bytedance.bdp.serviceapi.defaults.ui.model.a r101) {
        return new ia4.g(r100);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final Dialog getLoadingDialog(Activity r100, String r101) {
        return new ia4.h(r100, r101);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final String enableAlertBeforeUnload(String r100, String r101, String r102) {
        if (com.bytedance.bdp.bdpbase.util.a.a(r100) <= 100) goto L7;
        return "message is too long";
    L7:
        if (com.bytedance.bdp.bdpbase.util.a.a(r101) <= 8) goto L11;
        return "cancelText is too long";
    L11:
        if (com.bytedance.bdp.bdpbase.util.a.a(r102) <= 8) goto L14;
        return "confirmText is too long";
    L14:
        return "";
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showModal(Activity r100, com.bytedance.bdp.serviceapi.defaults.ui.model.e r101, hb4.b r102) {
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new a(r100));
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final boolean updateMultiPickerView(int r100, List r101, int r102) {
        WeakReference<com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a> r103 = ka4.a.C6525a.f502185a.f502184a;
        if (r103 != null) goto L5;
        com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.a r104 = null;
    L6:
        if (r104 == null) goto L28;
        List<ib4.d> r105 = r104.X;
        if (r105 != null) goto L10;
        return true;
    L10:
        if (((ArrayList) r105).size() < (r100 + 1)) goto L40;
        ib4.d r106 = (ib4.d) ListProtector.get(r104.X, r100);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
    L13:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if ((r109 instanceof String) == false) goto L13;
        if (r104.R == null) goto L13;
        if (r104.O == true) goto L13;
        r107.add(r109.toString());
        goto L13
    L21:
        List r110 = (List) ListProtector.get(r104.R, r100);
        r110.clear();
        if (r107.isEmpty() == true) goto L24;
        r110.addAll(r107);
        r106.setItems(r107);
    L25:
        r106.setSelectedIndex(r102);
        return true;
    L24:
        r110.addAll(r101);
        r106.setItems(r101);
        goto L25
    L40:
        return true;
    L28:
        return false;
    L5:
        r104 = r103.get();
        goto L6
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showActionSheet(Activity r100, String r101, String[] r110, hb4.a r111) {
        showActionSheet(r100, r101, r110, null, null, null);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showDatePickerView(Activity r100, com.bytedance.bdp.serviceapi.defaults.ui.model.c r101, com.bytedance.bdp.serviceapi.defaults.ui.model.g r102, BdpDatePickerCallback<String> r103) {
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new f(r100, r103));
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showTimePickerView(Activity r100, com.bytedance.bdp.serviceapi.defaults.ui.model.f r101, com.bytedance.bdp.serviceapi.defaults.ui.model.g r102, BdpTimePickerCallback<String> r103) {
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new e(r100, r103));
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void overridePendingTransition(Activity r100, int r101, int r102, int r103, String r104) {
        r100.overridePendingTransition(r101, r102);
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showActionSheet(Activity r100, String r101, String[] r102, String r103, String r104, hb4.a r105) {
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new b(r100, r102, r103, r104));
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showMultiPickerView(Activity r100, String r101, List<List<String>> r102, int[] r103, com.bytedance.bdp.serviceapi.defaults.ui.model.g r104, BdpMultiPickerCallback r105) {
        if (r102 != null) goto L5;
    L7:
        if (r103 != null) goto L9;
    L11:
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new g(r100, r102, r103, r105));
        return;
    L9:
        if (r103.length <= 5) goto L11;
        r103 = Arrays.copyOf(r103, 5);
        goto L11
    L5:
        if (r102.size() <= 5) goto L7;
        r102 = r102.subList(0, 5);
        goto L7
    }

    @Override // com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService
    public final void showPickerView(Activity r100, String r101, int r102, List<String> r103, com.bytedance.bdp.serviceapi.defaults.ui.model.g r104, BdpNormalPickerCallback<String> r105) {
        ((BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class)).c(new d(r100, r103, r105, r102));
    }
}
