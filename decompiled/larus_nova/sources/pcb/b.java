package pcb;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.edit.keyboard.producer.BaseKeyboardHeightProducer;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import rcb.e;
import rcb.f;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements pcb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f528614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.edit.keyboard.producer.b f528615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qcb.a f528616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f528617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f528618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseKeyboardHeightProducer.b f528619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<ocb.a> f528620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<ocb.a> f528621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f528622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC7182b f528623j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f528624k;

    public static final class a implements com.ss.android.lark.edit.keyboard.producer.b.InterfaceC4957b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f528625a;

        public a(b r100) {
            this.f528625a = r100;
        }

        @Override // com.ss.android.lark.edit.keyboard.producer.b.InterfaceC4957b
        public final void a(BaseKeyboardHeightProducer.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
            b r101 = this.f528625a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
            r101.f528619f = r100;
            int r102 = r100.f420589a;
            e.a(r101.f528622i, 60);
            Log.i("InsetsBseKBH#Provider", "keyboard height provider notify: " + r102 + ", " + r101.f528618e);
            Iterator<ocb.a> r103 = r101.f528621h.iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            ocb.a r104 = r103.next();
            if (r104 == null) goto L4;
            r104.onKeyboardHeightChanged(r101, r102, r101.f528618e);
            goto L4
        L9:
            if (r100.f420592d == false) goto L26;
            int r105 = r101.f528618e;
            if (r105 != 2) goto L13;
            int r106 = 200;
        L14:
            if (r102 <= r106) goto L27;
            r101.f528616c.getClass();
            com.ss.android.lark.storage.a r107 = qcb.b.f532534a;
            com.ss.android.lark.storage.kv.repo.a r108 = LarkKVStorage.f(qcb.b.f532534a, ObricActionBarTrackType.KEY_BOARD, new n6c.b(LarkContext.getApplication().getSharedPreferences(ObricActionBarTrackType.KEY_BOARD, 0)));
            if (r105 != 2) goto L18;
            String r109 = "landscape_kh";
        L19:
            Log.d("InsetsBaseKBH#Saver", "saveKeyboardHeight to sp (" + r109 + " : " + r102 + ')');
            r108.putInt(r109, r102);
            return;
        L18:
            r109 = "portrait_kh";
            goto L19
        L27:
            return;
        L13:
            r106 = 250;
            goto L14
        }
    }

    /* JADX INFO: renamed from: pcb.b$b, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC7182b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f528626a;

        public ViewOnAttachStateChangeListenerC7182b(b r100) {
            this.f528626a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Log.d("InsetsBseKBH#Provider", "onViewAttachedToWindow");
            this.f528626a.f528615b.c();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Log.d("InsetsBseKBH#Provider", "onViewDetachedFromWindow");
            b r101 = this.f528626a;
            d r102 = r101.f528622i;
            Handler r103 = e.f537198a;
            r103.removeCallbacks(r102);
            com.ss.android.lark.edit.keyboard.producer.b r104 = r101.f528615b;
            r104.getClass();
            Log.i("InsetsKBH#Producer", "close");
            r103.removeCallbacks(r104.f420603n);
            r103.removeCallbacks(r104.f420604o);
            ViewGroup r105 = r104.f420586b;
            if (r105 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mPopupView");
            r105 = null;
        L6:
            ViewCompat.setOnApplyWindowInsetsListener(r105.getRootView(), null);
            PopupWindow r106 = r104.a();
            PopupWindowLancet.handleDismissBeforeOrigin(r106);
            r106.dismiss();
            Activity r107 = r104.f420585a;
            SparseArray<pcb.a.AbstractC7181a> r108 = ocb.b.f522788a;
            Log.i("InsetsBseKBH#Provider", "remove cache " + r107.getClass().getName() + r107.hashCode() + " from keyboardHeightProviders");
            ocb.b.f522789b.remove(r107.hashCode());
            r101.f528619f = null;
            r101.f528620g.clear();
            r101.f528621h.clear();
            r101.f528624k.removeOnAttachStateChangeListener(r101.f528623j);
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f528627a;

        public d(b r100) {
            this.f528627a = r100;
        }

        public final void a() {
            if (this.f528627a.getActivity().isDestroyed() == false) goto L5;
        L18:
            Log.i("InsetsBseKBH#Provider", "mNotifyKHChangedTask err = activity isDestroyed or isFinishing");
            return;
        L5:
            if (this.f528627a.getActivity().isFinishing() == true) goto L18;
            BaseKeyboardHeightProducer.b r100 = this.f528627a.f528619f;
            if (r100 == null) goto L10;
            int r101 = r100.f420589a;
        L11:
            Log.i("InsetsBseKBH#Provider", "mNotifyKHChangedTask run imeHeight = " + r101);
            b r102 = this.f528627a;
            r102.getClass();
            Log.i("InsetsBseKBH#Provider", "keyboard height provider notify: " + r101 + ", " + r102.f528618e);
            Iterator<ocb.a> r103 = r102.f528620g.iterator();
        L13:
            if (r103.hasNext() == false) goto L17;
            ocb.a r104 = r103.next();
            if (r104 == null) goto L13;
            r104.onKeyboardHeightChanged(r102, r101, r102.f528618e);
            goto L13
        L17:
            return;
        L10:
            r101 = 0;
            goto L11
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

    static {
    }

    @Override // pcb.a
    public final int getKeyboardTop() {
        com.ss.android.lark.edit.keyboard.producer.b r100 = this.f528615b;
        r100.getClass();
        Rect r101 = new Rect();
        ViewGroup r102 = r100.f420586b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPopupView");
        r102 = null;
    L6:
        r102.getWindowVisibleDisplayFrame(r101);
        return r101.bottom;
    }

    @Override // pcb.a
    public final int getVisibleKeyboardHeight() {
        BaseKeyboardHeightProducer.b r100 = this.f528619f;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f420589a;
    }

    @Override // pcb.a
    public final boolean isKeyboardShowing() {
        BaseKeyboardHeightProducer.b r100 = this.f528619f;
        if (r100 == null) goto L10;
        if (r100 == null) goto L6;
        int r101 = r100.f420589a;
    L7:
        if (r101 <= 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        r101 = 0;
        goto L7
    L10:
        return false;
    }

    @Override // pcb.a
    public final int keyBoardRawHeight() {
        return keyBoardRawHeightWithOrientation(this.f528618e);
    }

    @Override // pcb.a
    public final void restart() {
        com.ss.android.lark.edit.keyboard.producer.b r100 = this.f528615b;
        if (r100.f420594e.isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (r100.a().isShowing() == true) goto L9;
        r100.c();
        return;
    }

    public final Activity getActivity() {
        return this.f528614a;
    }

    public b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f528614a = r100;
        qcb.a r101 = new qcb.a(r100);
        this.f528616c = r101;
        this.f528618e = 1;
        this.f528620g = new CopyOnWriteArrayList();
        this.f528621h = new CopyOnWriteArrayList();
        this.f528622i = new d(this);
        this.f528617d = rcb.a.a(r100);
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        View r102 = r100.findViewById(R.id.content);
        this.f528624k = r102;
        com.ss.android.lark.edit.keyboard.producer.b r103 = new com.ss.android.lark.edit.keyboard.producer.b(r100, r102, new a(this));
        this.f528615b = r103;
        Activity r104 = r103.f420585a;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r105 = new LinearLayout(r104);
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r105.setOrientation(1);
        r105.setBackgroundColor(r104.getResources().getColor(R.color.transparent));
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r103.f420586b = r105;
        Configuration r106 = f.f537199a;
        Configuration r107 = r103.f420585a.getResources().getConfiguration();
        Log.i("WindowModeUtils", "newConfiguration: " + r107);
        f.f537199a = r107;
        if (r103.f420594e.isAttachedToWindow() == false) goto L5;
        r103.c();
    L5:
        r101.f532533b = this.f528617d;
        this.f528618e = r100.getResources().getConfiguration().orientation;
        ViewOnAttachStateChangeListenerC7182b r108 = new ViewOnAttachStateChangeListenerC7182b(this);
        this.f528623j = r108;
        r102.addOnAttachStateChangeListener(r108);
    }

    @Override // pcb.a
    public final void a(ocb.a r100) {
        this.f528620g.remove(r100);
    }

    @Override // pcb.a
    public final void b(ocb.a r100) {
        this.f528621h.remove(r100);
    }

    @Override // pcb.a
    public final void c(ocb.a r100) {
        if (this.f528620g.contains(r100) == true) goto L6;
        this.f528620g.add(r100);
        return;
    }

    @Override // pcb.a
    public final void d(ocb.a r100) {
        if (this.f528621h.contains(r100) == true) goto L6;
        this.f528621h.add(r100);
        return;
    }

    @Override // pcb.a
    public final int keyBoardRawHeightWithOrientation(int r110) {
        qcb.a r100 = this.f528616c;
        r100.getClass();
        com.ss.android.lark.storage.a r101 = qcb.b.f532534a;
        com.ss.android.lark.storage.kv.repo.a r102 = LarkKVStorage.f(qcb.b.f532534a, ObricActionBarTrackType.KEY_BOARD, new n6c.b(LarkContext.getApplication().getSharedPreferences(ObricActionBarTrackType.KEY_BOARD, 0)));
        if (r110 != 2) goto L5;
        String r111 = "landscape_kh";
    L6:
        int r103 = r102.getInt(r111, 0);
        Log.i("InsetsBaseKBH#Saver", "loadKeyboardHeight from sp (" + r111 + " : " + r103 + ')');
        double r104 = (double) r100.f532533b;
        if (r103 >= ((int) (0.2d * r104))) goto L10;
        r103 = (int) (r104 * 0.25d);
        Log.i("InsetsBaseKBH#Saver", "loadKeyboardHeight from cal : (" + r111 + " : " + r103 + ')');
    L10:
        if (r103 <= 1) goto L12;
        return r103;
    L12:
        if (f.b() == true) goto L14;
        return r103;
    L14:
        return (int) (((double) this.f528617d) * 0.3d);
    L5:
        r111 = "portrait_kh";
        goto L6
    }

    @Override // pcb.a
    public final void setDelayedDuration(Long r100) {
        this.f528615b.f420588d = r100;
    }

    @Override // pcb.a
    public final void onConfigurationChanged(Configuration r100, boolean r101) {
        com.ss.android.lark.edit.keyboard.producer.b r102 = this.f528615b;
        r102.getClass();
        Log.i("BaseBaseKBH#Producer", "configurationChanged : ");
        Configuration r103 = f.f537199a;
        Log.i("WindowModeUtils", "newConfiguration: " + r100);
        f.f537199a = r100;
        r102.f420599j = r101;
        int r104 = 1;
        r102.f420598i = true;
        e.a(r102.f420603n, 1000);
        if (r102.f420594e.isAttachedToWindow() == true) goto L6;
    L8:
        int r105 = rcb.a.a(this.f528614a);
        this.f528617d = r105;
        this.f528616c.f532533b = r105;
        if (r100 == null) goto L11;
        r104 = r100.orientation;
    L11:
        this.f528618e = r104;
        return;
    L6:
        if (r102.a().isShowing() == true) goto L8;
        r102.c();
        goto L8
    }
}
