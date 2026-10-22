package com.larus.bmhome.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import v19.s5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0004\u0084\u0001\u0085\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0016\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020(J\u0006\u0010I\u001a\u00020\u000bJ\u0006\u0010J\u001a\u00020\u000bJ\u0018\u0010P\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0013H\u0002J\u0010\u0010R\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001e\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020\u001bH\u0002J\u0016\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020$2\u0006\u0010H\u001a\u00020(J\u000e\u0010Z\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010[\u001a\u00020/H\u0002J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020\u000bH\u0002J\f\u0010`\u001a\b\u0012\u0004\u0012\u00020/09J\b\u0010a\u001a\u00020/H\u0002J\u0010\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u00020\u001bH\u0016J\b\u0010d\u001a\u00020/H\u0014J\b\u0010e\u001a\u0004\u0018\u00010!J\u000e\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00020!J\u0006\u0010h\u001a\u00020/J\u000e\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020\u001bJ\u001a\u0010k\u001a\u00020/2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0012\u0010l\u001a\u00020\u001b2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J(\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0012\u0010s\u001a\u00020\u001b2\b\u0010t\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010u\u001a\u00020/2\b\u0010t\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010v\u001a\u00020\u001b2\b\u0010t\u001a\u0004\u0018\u00010nH\u0016J,\u0010w\u001a\u00020\u001b2\b\u0010x\u001a\u0004\u0018\u00010n2\b\u0010y\u001a\u0004\u0018\u00010n2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020{H\u0016J\u0012\u0010}\u001a\u00020/2\b\u0010t\u001a\u0004\u0018\u00010nH\u0016J-\u0010~\u001a\u00020\u001b2\b\u0010x\u001a\u0004\u0018\u00010n2\b\u0010y\u001a\u0004\u0018\u00010n2\u0006\u0010\u007f\u001a\u00020{2\u0007\u0010\u0080\u0001\u001a\u00020{H\u0016J\u0015\u0010\u0081\u0001\u001a\u00020/2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0014R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001b0'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020/0.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00105\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u000e\u00107\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bK\u0010\u001dR\u001b\u0010N\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010M\u001a\u0004\bN\u0010\u001dR\u000e\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/larus/bmhome/view/ChatConstraintLayout;", "Lcom/larus/common_ui/widget/BaseConstraintLayout;", "Lcom/larus/bmhome/view/compat/OnGestureListenerCompileSDK33;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "navigationPadding", "imePadding", "imeActualPadding", "detector", "Landroidx/core/view/GestureDetectorCompat;", "needLoginView1", "Landroid/view/View;", "needLoginView2", "bottomTabHeight", "getBottomTabHeight", "()I", "setBottomTabHeight", "(I)V", "subtractNavigationPaddingFromIme", "", "getSubtractNavigationPaddingFromIme", "()Z", "setSubtractNavigationPaddingFromIme", "(Z)V", "onBottomInsetUpdate", "Lcom/larus/bmhome/view/ChatConstraintLayout$OnBottomInsetUpdateListener;", "isBottomInsetUpdateActive", "pendingImeInsetsFallback", "Landroidx/core/graphics/Insets;", "lazyInsets", "interruptBottomPaddingUpdate", "Lkotlin/Function2;", "", "getInterruptBottomPaddingUpdate", "()Lkotlin/jvm/functions/Function2;", "setInterruptBottomPaddingUpdate", "(Lkotlin/jvm/functions/Function2;)V", "onImePaddingUpdate", "Lkotlin/Function1;", "", "getOnImePaddingUpdate", "()Lkotlin/jvm/functions/Function1;", "setOnImePaddingUpdate", "(Lkotlin/jvm/functions/Function1;)V", "value", "hasUserInteraction", "getHasUserInteraction", "bottomPaddingCache", "isSideBarOpen", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setSideBarOpen", "(Lkotlin/jvm/functions/Function0;)V", "latestNavigationInsetBottom", "Ljava/lang/Integer;", "imeOwnership", "Lcom/larus/bmhome/view/ChatImeOwnership;", "imeInsetsRecovery", "Lcom/larus/bmhome/view/ImeInsetsRecoveryState;", "runningImeAnimations", "", "Landroidx/core/view/WindowInsetsAnimationCompat;", "updateBottomPadding", "bottom", "source", "getBottomPadding", "getActualBottomPadding", "isGestureNavEnabled", "isGestureNavEnabled$delegate", "Lkotlin/Lazy;", "isEmUI", "isEmUI$delegate", "isNavBarShow", "containerView", "checkDeviceHasNavigationBar", "resolveNavigationPadding", "Lkotlin/Pair;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isImeOwnedByChatInput", "updateInsets", "imeInsets", "cinit", "init", "performBottomInsetUpdate", "paddingValue", "bottomInsetUpdateHandler", "Landroid/os/Handler;", "beginImeInsetsRecovery", "reconcileImeInsetsAfterHandoff", "onWindowFocusChanged", "hasWindowFocus", "onDetachedFromWindow", "getOnBottomInsetUpdateListener", "setOnBottomInsetUpdateListener", "callback", "resetImeInsets", "openLimitedState", "open", "setConstrainedView", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setPaddingRelative", "start", "top", "end", "onDown", "e", "onShowPress", "onSingleTapUp", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onLongPress", "onFling", "velocityX", "velocityY", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "OnBottomInsetUpdateListener", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatConstraintLayout extends BaseConstraintLayout implements GestureDetector.OnGestureListener {
    public static final /* synthetic */ int H = 0;
    public Integer A;
    public final u B;
    public final g2 C;
    public final Set<WindowInsetsAnimationCompat> D;
    public final Lazy E;
    public final Lazy F;
    public final Handler G;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f315389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f315390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f315391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GestureDetectorCompat f315392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f315393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f315394o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f315395p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f315396q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f315397r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f315398s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Insets f315399t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Insets f315400u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Boolean> f315401v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function1<? super Integer, Unit> f315402w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f315403x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f315404y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function0<Boolean> f315405z;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public interface b {
        void a();

        void b();

        void onUpdate(int r100);
    }

    static {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
    }

    public static boolean Y5() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Intrinsics.checkNotNull(r100);
        if (StringsKt.contains$default(r100, SystemUtils.PRODUCT_HUAWEI, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c6() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public final int getActualBottomPadding() {
        FLogger.f375446a.d("ChatConstraintLayout", "[getActualBottomPadding] " + this.f315391l);
        return this.f315391l;
    }

    public final int getBottomPadding() {
        FLogger.f375446a.i("ChatConstraintLayout", "[getBottomPadding] " + this.f315404y);
        return this.f315404y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        g2 r100 = this.C;
        r100.f316932a.clear();
        r100.f316933b = false;
        this.D.clear();
        super.onDetachedFromWindow();
    }

    public final void s6() {
        g2 r100 = this.C;
        if ((!r100.f316932a.isEmpty()) == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return;
    L11:
        WindowInsetsCompat r102 = ViewCompat.getRootWindowInsets(this);
        if (r102 != null) goto L14;
        return;
    L14:
        H6(r102.getInsets(WindowInsetsCompat.Type.ime()), "imeWindowHandoff");
        g2 r103 = this.C;
        boolean r104 = hasWindowFocus();
        boolean r105 = true ^ this.D.isEmpty();
        if (r103.f316932a.isEmpty() == false) goto L20;
        if (r104 == false) goto L21;
        if (r105 == true) goto L22;
        r103.f316933b = false;
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r100.f316933b == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void u6() {
        if (this.f315390k == 0) goto L13;
        int r100 = 0;
        this.f315390k = 0;
        if (getDisableBottomPadding() == true) goto L8;
        r100 = this.f315389j;
    L8:
        int r101 = Math.max(r100, this.f315390k);
        this.f315404y = r101;
        FLogger r102 = FLogger.f375446a;
        r102.i("ChatConstraintLayout", "[resetImeInsets] padding:" + this.f315404y);
        if (this.f315401v.invoke(Integer.valueOf(r101), "resetImeInsets").booleanValue() == true) goto L11;
        int r103 = getPaddingStart();
        int r104 = getPaddingTop();
        int r105 = getPaddingEnd();
        r102.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:resetImeInsets,start:" + r103 + ",top:" + r104 + ",end:" + r105 + ",bottom:" + r101);
        setPaddingRelative(r103, r104, r105, r101);
    L11:
        o6(getPaddingBottom());
        return;
    }

    public int getBottomTabHeight() {
        return this.f315395p;
    }

    public final boolean getHasUserInteraction() {
        return this.f315403x;
    }

    public final Function2<Integer, String, Boolean> getInterruptBottomPaddingUpdate() {
        return this.f315401v;
    }

    public final b getOnBottomInsetUpdateListener() {
        return this.f315397r;
    }

    public final Function1<Integer, Unit> getOnImePaddingUpdate() {
        return this.f315402w;
    }

    public final boolean getSubtractNavigationPaddingFromIme() {
        return this.f315396q;
    }

    public ChatConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f315396q = true;
        this.f315401v = new m();
        this.f315402w = new n();
        this.B = new u();
        this.C = new g2();
        this.D = new LinkedHashSet();
        this.E = LazyKt.lazy(new o(this));
        this.F = LazyKt.lazy(new p());
        this.G = new Handler(Looper.getMainLooper(), new q(this));
    }

    public static boolean Z5(ChatConstraintLayout r100) {
        Context r101 = r100.getContext();     // Catch: Exception -> L12
        if (r101 == null) goto L6;
        ContentResolver r102 = r101.getContentResolver();     // Catch: Exception -> L12
    L7:
        if (Settings.Global.getInt(r102, "navigationbar_is_min", 0) != 1) goto L15;
        return true;
    L15:
        return false;
    L6:
        r102 = null;
    L16:
        return false;
    }

    public static boolean i6(Context r100) {
        Class r101 = c6();     // Catch: Exception -> L13
        Object r102 = r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L13
        String r103 = (String) r102;     // Catch: Exception -> L13
        if (Intrinsics.areEqual("1", r103) == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual("0", r103) == false) goto L9;
        return true;
    L9:
        Resources r104 = r100.getResources();     // Catch: Exception -> L13
        int r105 = r104.getIdentifier("config_showNavigationBar", "bool", "android");     // Catch: Exception -> L13
        if (r105 <= 0) goto L16;
        return r104.getBoolean(r105);
    L16:
        return false;
    L17:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.f315403x = true;
    L10:
        if (r100 == null) goto L19;
        GestureDetectorCompat r103 = this.f315392m;
        if (r103 != null) goto L14;
    L16:
        if (r101 == false) goto L19;
        return true;
    L14:
        if (r103.onTouchEvent(r100) != true) goto L16;
        r101 = true;
    L19:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r100.getActionMasked() != 0) goto L7;
        r102 = true;
        goto L8
    }

    public final void k6(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ViewCompat.setWindowInsetsAnimationCallback(this, new ChatConstraintLayout$init$1(this));
        ViewCompat.setOnApplyWindowInsetsListener(this, new r(this));
        post(new s(this));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.larus.utils.w0.f375484a;
        BaseConstraintLayout.f328383g = com.larus.utils.w0.c((Activity) r100) / 5.0f;
        V5();
        FLogger r102 = FLogger.f375446a;
        r102.d("BaseConstraintLayout", "init " + BaseConstraintLayout.f328384h + ' ' + BaseConstraintLayout.f328385i);
        R5();
        ObricChatUIDelegate r103 = ObricChatUIDelegate.f392858b;
        if (r103.m() == false) goto L5;
        this.f315389j = r103.o(r100, n6(r100, this), ViewCompat.getRootWindowInsets(this));
        r102.i("ChatConstraintLayout", "cinit navigationPadding=" + this.f315389j);
    L5:
        Insets r104 = this.f315400u;
        if (r104 == null) goto L9;
        H6(r104, "cinit");
        this.f315400u = null;
        return;
    }

    public final void o6(int r100) {
        if (this.G.hasMessages(1) == false) goto L5;
        this.G.removeMessages(1);
    L8:
        b r101 = this.f315397r;
        if (r101 == null) goto L11;
        r101.onUpdate(r100);
    L11:
        this.G.sendEmptyMessageDelayed(1, 50);
        return;
    L5:
        this.f315398s = true;
        b r102 = this.f315397r;
        if (r102 == null) goto L8;
        r102.a();
        goto L8
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        Context r101 = getContext();
        if (r101 == null) goto L7;
        Resources.Theme r102 = r101.getTheme();
        if (r102 == null) goto L7;
        v19.f.a(r102);
    L7:
        Resources.Theme r103 = AppHost.f326268a.getApplication().getTheme();
        if (r103 == null) goto L10;
        v19.f.a(r103);
    L10:
        FLogger.f375446a.i("ChatConstraintLayout", "ChatConstraintLayout applyTheme");
        super.onConfigurationChanged(r100);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        View r101 = this.f315393n;
        if (r101 == null) goto L8;
        int r102 = r101.getTop();
    L9:
        View r103 = this.f315393n;
        if (r103 == null) goto L12;
        int r104 = r103.getBottom();
    L13:
        View r105 = this.f315394o;
        if (r105 == null) goto L16;
        int r106 = r105.getTop();
    L17:
        View r107 = this.f315394o;
        if (r107 == null) goto L20;
        int r108 = r107.getBottom();
    L22:
        if (r100.getY() < r106) goto L26;
        if (r100.getY() > r108) goto L26;
    L29:
        com.larus.platform.service.i3 r109 = com.larus.platform.service.i3.f365750a;
        com.larus.platform.api.s3.a.b();
        return true;
    L26:
        if (r100.getY() >= r102) goto L28;
        return false;
    L28:
        if (r100.getY() <= r104) goto L29;
        return false;
    L20:
        r108 = 0;
        goto L22
    L16:
        r106 = 0;
        goto L17
    L12:
        r104 = 0;
        goto L13
    L8:
        r102 = 0;
        goto L9
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == false) goto L6;
        s6();
        return;
    }

    public void setBottomTabHeight(int r100) {
        this.f315395p = r100;
    }

    public final void setInterruptBottomPaddingUpdate(Function2<? super Integer, ? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f315401v = r100;
    }

    public final void setOnBottomInsetUpdateListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f315397r = r100;
    }

    public final void setOnImePaddingUpdate(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f315402w = r100;
    }

    public final void setSideBarOpen(Function0<Boolean> r100) {
        this.f315405z = r100;
    }

    public final void setSubtractNavigationPaddingFromIme(boolean r100) {
        this.f315396q = r100;
    }

    public ChatConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f315396q = true;
        this.f315401v = new m();
        this.f315402w = new n();
        this.B = new u();
        this.C = new g2();
        this.D = new LinkedHashSet();
        this.E = LazyKt.lazy(new o(this));
        this.F = LazyKt.lazy(new p());
        this.G = new Handler(Looper.getMainLooper(), new q(this));
    }

    public static void b6(ChatConstraintLayout r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = r101.what;
        Insets r103 = null;
        if (r102 != 1) goto L5;
        FLogger.f375446a.i("ChatConstraintLayout", "handle MSG_FINISH_BOTTOM_INSET_UPDATE");
        r100.f315398s = false;
        b r104 = r100.f315397r;
        if (r104 == null) goto L18;
        r104.b();
    L18:
        Insets r105 = r100.f315399t;
        if (r105 == null) goto L26;
        r100.f315399t = null;
        WindowInsetsCompat r106 = ViewCompat.getRootWindowInsets(r100);
        if (r106 == null) goto L25;
        Insets r107 = r106.getInsets(WindowInsetsCompat.Type.ime());
        if (r107 == null) goto L25;
        r105 = r107;
    L25:
        r100.H6(r105, "bottomInsetUpdateHandler");
    L26:
        r100.s6();
        return;
    L5:
        if (r102 != 2) goto L31;
        Object r108 = r101.obj;
        if ((r108 instanceof Insets) == false) goto L10;
        r103 = (Insets) r108;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        if (r100.f315398s == false) goto L14;
        r100.f315399t = r103;
        return;
    L14:
        r100.H6(r103, "bottomInsetUpdateHandler");
        return;
    }

    public static boolean n6(Context r100, View r101) {
        if (Build.VERSION.SDK_INT < 23) goto L16;
        WindowInsets r102 = r101.getRootWindowInsets();
        if (r102 != null) goto L9;
        return i6(r100);
    L9:
        if (i6(r100) == true) goto L11;
    L13:
        return false;
    L11:
        if (com.larus.utils.m0.d(r102) == false) goto L13;
        return true;
    L16:
        return i6(r100);
    }

    public final void C6(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        FLogger r102 = FLogger.f375446a;
        r102.i("ChatConstraintLayout", "[updateBottomPadding] bottom=" + r100 + ", source:" + r101);
        this.f315404y = r100;
        this.f315390k = r100;
        if (this.f315401v.invoke(Integer.valueOf(r100), r101).booleanValue() == true) goto L6;
        r102.i("ChatConstraintLayout", "[updateBottomPadding] real update");
        int r103 = getPaddingStart();
        int r104 = getPaddingTop();
        int r105 = getPaddingEnd();
        r102.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:" + r101 + ",start:" + r103 + ",top:" + r104 + ",end:" + r105 + ",bottom:" + r100);
        setPaddingRelative(r103, r104, r105, r100);
        return;
    }

    public final void H6(Insets r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "imeInsets");
        Intrinsics.checkNotNullParameter(r111, "source");
        this.f315400u = r110;
        if ((getContext() instanceof FragmentActivity) == true) goto L14;
        Context r100 = getContext();
        if ((r100 instanceof ContextThemeWrapper) == false) goto L7;
        ContextThemeWrapper r101 = (ContextThemeWrapper) r100;
    L8:
        if (r101 == null) goto L10;
        Context r102 = r101.getBaseContext();
    L12:
        if ((r102 instanceof FragmentActivity) == true) goto L14;
        return;
    L10:
        r102 = null;
        goto L12
    L7:
        r101 = null;
    L14:
        this.f315400u = null;
        Context r103 = getContext();
        if ((r103 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r104 = (FragmentActivity) r103;
    L18:
        if (r104 != null) goto L30;
        Context r105 = getContext();
        if ((r105 instanceof ContextThemeWrapper) == false) goto L22;
        ContextThemeWrapper r106 = (ContextThemeWrapper) r105;
    L23:
        if (r106 == null) goto L25;
        Context r107 = r106.getBaseContext();
    L27:
        if ((r107 instanceof FragmentActivity) == false) goto L29;
        r104 = (FragmentActivity) r107;
        goto L30
    L29:
        r104 = null;
        goto L30
    L25:
        r107 = null;
        goto L27
    L22:
        r106 = null;
    L30:
        Integer r108 = this.A;
        boolean r109 = false;
        if (r108 != null) goto L37;
        if (r104 == null) goto L34;
        int r112 = com.larus.utils.u.b(r104);
    L35:
        Pair r113 = TuplesKt.to(Integer.valueOf(r112), Boolean.FALSE);
    L54:
        int r114 = ((Number) r113.component1()).intValue();
        boolean r115 = ((Boolean) r113.component2()).booleanValue();
        this.f315389j = r114;
        if (r115 == false) goto L59;
        if (r114 <= 0) goto L58;
        boolean r116 = true;
    L60:
        if (r115 == true) goto L68;
        if (r116 == false) goto L67;
        if (r104 == null) goto L68;
        if (DeviceUtils.isEmui() == false) goto L68;
        if (DeviceUtils.hasNavBar(r104) == true) goto L68;
    L67:
        this.f315389j = 0;
    L68:
        ObricChatUIDelegate r117 = ObricChatUIDelegate.f392858b;
        if (r117.m() == false) goto L71;
        this.f315389j = r117.o(getContext(), r116, ViewCompat.getRootWindowInsets(this));
    L71:
        this.f315400u = null;
        View r118 = findViewById(R.id.bottom_layout);
        if (r118 == null) goto L74;
        int r119 = r118.getHeight();
    L76:
        if (this.f315396q == false) goto L78;
        int r120 = this.f315389j;
    L80:
        if (getDisableBottomPadding() == false) goto L92;
        WindowInsetsCompat r121 = ViewCompat.getRootWindowInsets(this);
        if (r121 == null) goto L86;
        Insets r122 = r121.getInsets(WindowInsetsCompat.Type.ime());
        if (r122 == null) goto L86;
        int r123 = r122.bottom;
    L87:
        int r124 = r110.bottom;
        if (r124 == (r123 - r120)) goto L91;
        r124 = r124 - r120;
    L91:
        int r125 = (r124 - r119) - getBottomTabHeight();
    L93:
        this.f315391l = r125;
        int r126 = r117.H(this, r125);
        this.f315391l = r126;
        int r127 = Math.max(r126, 0);
        View r128 = findFocus();
        if (r128 != null) goto L96;
    L98:
        boolean r129 = false;
    L99:
        if (r129 == true) goto L108;
        View r130 = getRootView().findFocus();
        if (r130 != null) goto L103;
    L105:
        boolean r131 = false;
    L106:
        if (r131 == false) goto L108;
        boolean r132 = true;
    L109:
        u r133 = this.B;
        if (hasWindowFocus() == true) goto L112;
        r133.f317511a = false;
    L116:
        boolean r134 = r133.f317511a;
        if (r134 == true) goto L119;
    L120:
        if (r134 == false) goto L122;
        r127 = r117.E(this, this.f315391l);
    L123:
        FLogger.f375446a.d("ChatConstraintLayout", "newBottom reset to zero");
    L124:
        FLogger r135 = FLogger.f375446a;
        r135.d("ChatConstraintLayout", "updateInsets, src=" + r111 + ", insets:" + r110.bottom + " imePadding:" + this.f315390k + "->" + r127 + ", curPaddingBottom:" + getPaddingBottom() + " imeActualPadding:" + this.f315391l + " navigationPadding:" + this.f315389j + ", bottomLayoutHeight:" + r119 + ", cachePadding:" + this.f315404y + ", disableBottomPadding:" + getDisableBottomPadding() + ", bottomTabHeight: " + getBottomTabHeight() + ", navBarShow=" + r116 + ", fromWindowInsets=" + r115 + ", isImeOwnedByChatInput=" + r134);
        if (getDisableBottomPadding() == false) goto L127;
        int r136 = 0;
    L128:
        int r137 = Math.max(r136, r127);
        if (this.f315390k == r127) goto L131;
        boolean r138 = true;
    L133:
        if (this.f315404y == r137) goto L135;
    L136:
        r109 = true;
    L137:
        if (r138 == false) goto L139;
    L141:
        this.f315390k = r127;
        this.f315404y = r137;
        if (this.f315401v.invoke(Integer.valueOf(r137), "updateInsets").booleanValue() == true) goto L144;
        int r139 = getPaddingStart();
        int r140 = getPaddingTop();
        int r141 = getPaddingEnd();
        r135.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:updateInsets,start:" + r139 + ",top:" + r140 + ",end:" + r141 + ",bottom:" + r137);
        setPaddingRelative(r139, r140, r141, r137);
    L145:
        if (r138 == false) goto L147;
        this.f315402w.invoke(Integer.valueOf(this.f315390k));
    L147:
        o6(getPaddingBottom());
        return;
    L144:
        r135.i("ChatConstraintLayout", "interruptBottomPaddingUpdate, source=" + r111 + " bottomPadding=" + r137);
        goto L145
    L139:
        if (r117.m() == true) goto L141;
        if (r109 == true) goto L141;
        return;
    L135:
        if (getPaddingBottom() == r137) goto L137;
    L131:
        r138 = false;
        goto L133
    L127:
        r136 = this.f315389j;
        goto L128
    L122:
        r127 = 0;
        goto L123
    L119:
        if (s5.f552609a == false) goto L124;
    L112:
        if (r129 == false) goto L114;
        r133.f317511a = true;
        goto L116
    L114:
        if (r132 == false) goto L116;
        r133.f317511a = false;
        goto L116
    L103:
        if (r130.onCheckIsTextEditor() != true) goto L105;
        r131 = true;
    L108:
        r132 = false;
        goto L109
    L96:
        if (r128.onCheckIsTextEditor() != true) goto L98;
        r129 = true;
    L86:
        r123 = r110.bottom;
        goto L87
    L92:
        r125 = r110.bottom - r119;
        goto L93
    L78:
        r120 = 0;
        goto L80
    L74:
        r119 = 0;
        goto L76
    L58:
        r116 = false;
        goto L60
    L59:
        r116 = n6(getContext(), this);
        goto L60
    L34:
        r112 = 0;
        goto L35
    L37:
        if (r108.intValue() <= 0) goto L39;
        r113 = TuplesKt.to(r108, Boolean.TRUE);
        goto L54
    L39:
        if (r104 == null) goto L53;
        Window r142 = r104.getWindow();
        if (r142 == null) goto L53;
        View r143 = r142.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L47;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r144 = ThreadMethodProxy.currentThread();
        if (r144 == com.larus.home.impl.utils.c.f346341a) goto L47;
        com.larus.home.impl.utils.c.a(r144, "getDecorView");
    L47:
        if (r143 == null) goto L53;
        WindowInsetsCompat r145 = ViewCompat.getRootWindowInsets(r143);
        if (r145 == null) goto L53;
        Insets r146 = r145.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r146 == null) goto L53;
        r113 = TuplesKt.to(Integer.valueOf(r146.bottom), Boolean.TRUE);
    L53:
        r113 = TuplesKt.to(Integer.valueOf(r108.intValue()), Boolean.TRUE);
        goto L54
    L17:
        r104 = null;
        goto L18
    }

    public ChatConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f315396q = true;
        this.f315401v = new m();
        this.f315402w = new n();
        this.B = new u();
        this.C = new g2();
        this.D = new LinkedHashSet();
        this.E = LazyKt.lazy(new o(this));
        this.F = LazyKt.lazy(new p());
        this.G = new Handler(Looper.getMainLooper(), new q(this));
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        if (ObricChatUIDelegate.f392858b.m() == true) goto L5;
        super.setPaddingRelative(r100, r101, r102, r103);
        return;
    L5:
        if (getDisableBottomPadding() == false) goto L7;
        int r104 = 0;
    L8:
        if (r104 <= 0) goto L11;
        if (r103 >= r104) goto L11;
        r103 = r104;
    L11:
        super.setPaddingRelative(r100, r101, r102, r103);
        return;
    L7:
        r104 = Math.max(this.f315389j, this.f315390k);
        goto L8
    }
}
