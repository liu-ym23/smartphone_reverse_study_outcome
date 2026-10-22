package com.ss.android.lark.piece.core;

import android.app.Activity;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \u009a\u0001*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u009a\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020BH\u0017J\b\u0010H\u001a\u00020BH\u0016J\b\u0010I\u001a\u00020BH\u0016J\b\u0010J\u001a\u00020BH\u0016J\b\u0010K\u001a\u00020BH\u0016J\b\u0010L\u001a\u00020BH\u0017J\u001d\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0010¢\u0006\u0002\bRJ\u0018\u0010S\u001a\u00020\u00172\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH&J\u0015\u0010%\u001a\u00028\u00002\u0006\u0010%\u001a\u00020 H\u0016¢\u0006\u0002\u0010TJ\u0015\u0010#\u001a\u00028\u00002\b\b\u0001\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010TJ\u001b\u0010U\u001a\u00028\u00002\u0006\u0010V\u001a\u00020 2\u0006\u0010W\u001a\u00020 ¢\u0006\u0002\u0010XJ3\u0010Y\u001a\u00028\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010Z\u001a\u00020 2\u0006\u0010[\u001a\u00020 2\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020 ¢\u0006\u0002\u0010^J3\u0010Y\u001a\u00028\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010Z\u001a\u00020_2\u0006\u0010[\u001a\u00020_2\u0006\u0010\\\u001a\u00020_2\u0006\u0010]\u001a\u00020_¢\u0006\u0002\u0010`J\u0015\u0010a\u001a\u00028\u00002\b\b\u0001\u0010b\u001a\u00020 ¢\u0006\u0002\u0010TJ\u0015\u0010c\u001a\u00028\u00002\b\b\u0001\u0010d\u001a\u00020 ¢\u0006\u0002\u0010TJ\r\u0010e\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010fJ\u0015\u0010g\u001a\u00020B2\u0006\u0010\u0013\u001a\u00020\u0012H\u0010¢\u0006\u0002\bhJ\u001f\u0010i\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00172\b\b\u0001\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010jJ \u0010k\u001a\b\u0012\u0004\u0012\u0002H\u00010<\"\b\b\u0001\u0010\u0001*\u00020\u00172\b\b\u0001\u0010\u001f\u001a\u00020 J#\u0010l\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020m2\f\u0010n\u001a\b\u0012\u0004\u0012\u0002H\u00010o¢\u0006\u0002\u0010pJ+\u0010l\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020m2\f\u0010n\u001a\b\u0012\u0004\u0012\u0002H\u00010o2\u0006\u0010q\u001a\u00020r¢\u0006\u0002\u0010sJ\u001c\u0010t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0001\u0010\u0001\u0018\u0001*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010uJ'\u0010t\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00032\u000e\u0010v\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030o¢\u0006\u0002\u0010wJ$\u0010t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0001\u0010\u0001\u0018\u0001*\u00020\u00032\u0006\u0010x\u001a\u00020 H\u0086\b¢\u0006\u0002\u0010yJ/\u0010t\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010x\u001a\u00020 2\u000e\u0010v\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030o¢\u0006\u0002\u0010zJ\b\u0010{\u001a\u0004\u0018\u00010|J\u0010\u0010}\u001a\u00020B2\u0006\u0010~\u001a\u00020\u007fH\u0016J\u001a\u0010\u0080\u0001\u001a\u00020B2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0081\u0001\u001a\u00020 H\u0016J&\u0010\u0082\u0001\u001a\u00020\u001d2\u0007\u0010\u0081\u0001\u001a\u00020 2\u0007\u0010\u0083\u0001\u001a\u00020 2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020B2\u0007\u0010\u0083\u0001\u001a\u00020 H\u0016J\u001d\u0010\u0085\u0001\u001a\u00020B2\u0007\u0010\u0083\u0001\u001a\u00020 2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007fH\u0016J\t\u0010\u0086\u0001\u001a\u00020BH\u0016J\t\u0010\u0087\u0001\u001a\u00020\u001dH\u0016J \u0010\u0088\u0001\u001a\u0019\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030o\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0089\u0001H\u0016J\u0013\u0010\u008a\u0001\u001a\u00020B2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0004J\u001d\u0010\u008d\u0001\u001a\u00020B2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0004J\u0019\u0010\u0090\u0001\u001a\u00020B2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u0092\u0001H\u0004J\u0019\u0010\u0093\u0001\u001a\u00020B2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u0092\u0001H\u0004J!\u0010\u0094\u0001\u001a\u00020B2\u0007\u0010\u0095\u0001\u001a\u00020>2\u000f\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0@J\"\u0010\u0097\u0001\u001a\u00020B2\b\u0010\u0095\u0001\u001a\u00030\u0098\u00012\u000f\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0@J\u0007\u0010\u0099\u0001\u001a\u00020OR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020 @BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0012\u0010'\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0012\u0010)\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0012\u0010*\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0012\u0010+\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010,\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u001dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010;\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020>\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020>0@0?0=0<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/ss/android/lark/piece/core/Piece;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/ss/android/lark/piece/core/IPieceExport;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "sharedData", "Lcom/ss/android/lark/piece/data/SharedData;", "getSharedData", "()Lcom/ss/android/lark/piece/data/SharedData;", "setSharedData", "(Lcom/ss/android/lark/piece/data/SharedData;)V", "value", "Lcom/ss/android/lark/piece/core/PieceContext;", "pieceContext", "getPieceContext", "()Lcom/ss/android/lark/piece/core/PieceContext;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "isContentViewInitialized", "", "()Z", "id", "", "getId", "()I", "setId", "(I)V", RemoteMessageConst.Notification.VISIBILITY, "getVisibility", "backgroundResId", "Ljava/lang/Integer;", "backgroundColor", "width", "height", "topMargin", "bottomMargin", "startMargin", "endMargin", "mainHandler", "Landroid/os/Handler;", "isActive", "setActive", "(Z)V", "callbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "getCallbackManager", "()Lcom/larksuite/framework/callback/CallbackManager;", "setCallbackManager", "(Lcom/larksuite/framework/callback/CallbackManager;)V", "dataObserverMap", "Lkotlin/Lazy;", "", "", "", "Lcom/ss/android/lark/piece/data/DataObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "initView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "layoutConfig", "Landroid/view/ViewGroup$MarginLayoutParams;", "initView$piece_release", "getView", "(I)Ljava/lang/Object;", "setSize", "widthPx", "heightPx", "(II)Ljava/lang/Object;", "marginDp", "start", "top", "end", "bottom", "(Landroid/content/Context;IIII)Ljava/lang/Object;", "", "(Landroid/content/Context;FFFF)Ljava/lang/Object;", "setBackgroundResource", "resId", "setBackgroundColor", "color", "self", "()Ljava/lang/Object;", "setPieceContext", "setPieceContext$piece_release", "findViewById", "(I)Landroid/view/View;", "lazyFindView", "getViewModel", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "getPieceExport", "()Lcom/ss/android/lark/piece/core/IPieceExport;", "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/piece/core/IPieceExport;", "pieceId", "(I)Lcom/ss/android/lark/piece/core/IPieceExport;", "(ILjava/lang/Class;)Lcom/ss/android/lark/piece/core/IPieceExport;", "getFragmentManager", "Landroidx/fragment/app/FragmentManager;", "startActivity", "intent", "Landroid/content/Intent;", "startActivityForResult", "requestCode", "onActivityResult", "resultCode", "data", "setResult", VideoEventOneOutSync.END_TYPE_FINISH, "onBackPressed", "providePieceExport", "Lkotlin/Pair;", UGCMonitor.TYPE_POST, "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "runSafely", "block", "Lkotlin/Function0;", "runSafelyOnUI", "observeSharedData", "key", "observer", "unObserveSharedData", "", "requireContext", "Companion", "piece_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Piece<T> implements LifecycleEventObserver, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f438638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f438639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CallbackManager f438640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy<Map<Object, List<com.ss.android.lark.piece.data.a<? extends Object>>>> f438641d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f438642a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f438642a = r100;
        }
    }

    static {
    }

    public void onCreate() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void startActivity(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
    }

    public void startActivityForResult(Intent r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
    }

    public void onDestroy() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        this.f438640c.cancelCallbacks();
        if (this.f438641d.isInitialized() == false) goto L12;
        Iterator<Map.Entry<Object, List<com.ss.android.lark.piece.data.a<? extends Object>>>> r100 = this.f438641d.getValue().entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L12;
        Map.Entry<Object, List<com.ss.android.lark.piece.data.a<? extends Object>>> r101 = r100.next();
        r101.getKey();
        Iterator<com.ss.android.lark.piece.data.a<? extends Object>> r102 = r101.getValue().iterator();
        if (r102.hasNext() == false) goto L6;
        com.ss.android.lark.piece.data.a<? extends Object> r103 = r102.next();
        Intrinsics.throwUninitializedPropertyAccessException("sharedData");
        throw null;
    L12:
        this.f438641d.getValue().clear();
    }

    public Piece() {
        this.f438638a = Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        this.f438640c = new CallbackManager();
        this.f438641d = LazyKt.lazy(Piece$dataObserverMap$1.INSTANCE);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f438638a;
    }

    public void setResult(int r100) {
        Object r101 = null;
        if ((r101 instanceof Activity) == false) goto L6;
        Activity r102 = (Activity) null;
        return;
    }

    public final void a(Object r100, com.ss.android.lark.piece.data.a<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        List<com.ss.android.lark.piece.data.a<? extends Object>> r102 = this.f438641d.getValue().get(r100);
        if (r102 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
        r102 = new ArrayList();
        this.f438641d.getValue().put(r100, r102);
    L9:
        r102.add(r101);
        Intrinsics.throwUninitializedPropertyAccessException("sharedData");
        throw null;
    L5:
        if (r102.contains(r101) == false) goto L7;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        switch(b.f438642a[r101.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L13;
            default: goto L5;
        };
    L6:
        onDestroy();
        return;
    L7:
        onStop();
        return;
    L8:
        onPause();
        return;
    L9:
        onResume();
        return;
    L10:
        onStart();
        return;
    L11:
        onCreate();
        return;
    L13:
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public void setResult(int r100, Intent r101) {
        Object r102 = null;
        if ((r102 instanceof Activity) == false) goto L6;
        Activity r103 = (Activity) null;
        return;
    }
}
