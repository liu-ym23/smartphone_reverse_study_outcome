package com.ss.android.lark.keyboard.keyboard2.content;

import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.j;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.utils.TransitionUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements com.ss.android.lark.keyboard.keyboard2.content.c, com.ss.android.lark.keyboard.keyboard2.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PathInterpolator f429528k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyboardMainContent f429529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BasicKeyboard f429531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f429532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, IKeyboardContent> f429533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, View> f429534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<IKeyboardContent> f429535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IKeyboardContent f429536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f429537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f429538j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.content.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C5102b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429539a = null;

        static {
            int[] r100 = new int[IKeyboardContent.ViewInitStrategy.values().length];
            r100[IKeyboardContent.ViewInitStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IKeyboardContent.ViewInitStrategy.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f429539a = r100;
        }
    }

    public static final class c implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f429540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IKeyboardContent f429541b;

        public c(b r100, IKeyboardContent r101) {
            this.f429540a = r100;
            this.f429541b = r101;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.f429540a.u(this.f429541b);
            return false;
        }
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        this.f429537i = true;
        this.f429531c = (BasicKeyboard) r().y(j.f429553x);
        Iterator r100 = ((ArrayList) this.f429535g).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        n((IKeyboardContent) r100.next());
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        this.f429537i = false;
        Iterator r100 = ((LinkedHashMap) this.f429533e).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IKeyboardContent) ((Map.Entry) r100.next()).getValue()).onDestroy();
        goto L4
    }

    static {
        f429528k = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final IKeyboardContent getContent() {
        Intrinsics.checkNotNullParameter(ImmersiveVoiceInputComponent.f430093a, "key");
        return (IKeyboardContent) ((LinkedHashMap) this.f429533e).get("ImmersiveVoiceKeyboardKey");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final IKeyboardContent l() {
        IKeyboardContent r100 = this.f429536h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        return null;
    L6:
        return r100;
    }

    public final com.ss.android.lark.keyboard.b r() {
        com.ss.android.lark.keyboard.b r100 = this.f429530b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final KeyboardMainContent e() {
        return this.f429529a;
    }

    public b(KeyboardMainContent r100) {
        Intrinsics.checkNotNullParameter(r100, "mainContent");
        this.f429529a = r100;
        this.f429533e = new LinkedHashMap();
        this.f429534f = new LinkedHashMap();
        this.f429535g = new ArrayList();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final void g(boolean r100) {
        a(KeyboardMainContent.f429511m, r100);
    }

    public final void n(IKeyboardContent r100) {
        r100.onCreate();
        IKeyboardContent.ViewInitStrategy r101 = r100.a();
        int r102 = C5102b.f429539a[r101.ordinal()];
        if (r102 != 1) goto L5;
        u(r100);
        return;
    L5:
        if (r102 != 2) goto L11;
        Looper.myQueue().addIdleHandler(new c(this, r100));
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429530b = r100;
    }

    public final View u(IKeyboardContent r100) {
        IKeyboardContent.a r101 = r100.getKey();
        Map<String, View> r102 = this.f429534f;
        String r103 = r101.getTag();
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        Object r106 = r105;
        if (r105 != null) goto L19;
        FrameLayout r107 = this.f429532d;
        FrameLayout r108 = null;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r107 = null;
    L7:
        View r109 = r100.b(r107);
        r109.setVisibility(8);
        if (r109.getLayoutParams() != null) goto L10;
    L12:
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-1, -2);
        r110.gravity = 80;
        r109.setLayoutParams(r110);
    L13:
        FrameLayout r111 = this.f429532d;
        if (r111 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L17:
        r108.addView(r109);
        r104.put(r103, r109);
        r106 = r109;
        goto L19
    L16:
        r108 = r111;
        goto L17
    L10:
        if ((r109.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L12;
    L19:
        return (View) r106;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final void a(IKeyboardContent.a r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        if (this.f429538j == false) goto L6;
        Log.i("KeyboardContentManager", "is in content change transition, ignore change");
        return;
    L6:
        IKeyboardContent r100 = (IKeyboardContent) ((LinkedHashMap) this.f429533e).get(r110.getTag());
        if (r100 != null) goto L10;
        Log.e("KeyboardContentManager", "content not found, key: " + r110.getTag());
        return;
    L10:
        View r101 = u(r100);
        IKeyboardContent r102 = this.f429536h;
        IKeyboardContent r103 = null;
        if (r102 != null) goto L13;
        r101.setVisibility(0);
        r100.onShow();
        IKeyboardContent.a r112 = null;
    L59:
        this.f429536h = r100;
        r100.onShow();
        IKeyboardContent r104 = this.f429536h;
        if (r104 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
    L63:
        r103.c(r().z().height());
        k.a.a(r().e(), new com.ss.android.lark.keyboard.keyboard2.content.a(r112, r110));
        return;
    L62:
        r103 = r104;
        goto L63
    L13:
        final View r105 = u(r102);
        if (Intrinsics.areEqual(r105, r101) == true) goto L49;
        if (r111 == false) goto L47;
        PathInterpolator r113 = f429528k;
        final Transition r114 = new Slide().addTarget(r105).addTarget(r101);
        r114.setInterpolator(r113);
        r114.setDuration(285);
        r114.addListener(new KeyboardContentManagerImpl$changeContentWithAnimation$1(this, r114, r105));
        Lazy r106 = TransitionUtils.f430954a;
        FrameLayout r107 = this.f429532d;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r107 = null;
    L21:
        if (TransitionUtils.a(r107) == true) goto L28;
        FrameLayout r108 = this.f429532d;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r108 = null;
    L26:
        if (ViewCompat.isLaidOut(r108) == false) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == false) goto L37;
        BasicKeyboard r115 = this.f429531c;
        if (r115 == null) goto L33;
        r115.f429448n = true;
    L33:
        FrameLayout r116 = this.f429532d;
        if (r116 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r116 = null;
    L36:
        TransitionManager.beginDelayedTransition(r116, r114);
    L37:
        r105.setVisibility(4);
        r101.setVisibility(0);
        FrameLayout r117 = this.f429532d;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r117 = null;
    L40:
        r117.setMinimumHeight(Math.max(r105.getHeight(), r101.getHeight()));
        BasicKeyboard r118 = this.f429531c;
        if (r118 == null) goto L43;
        r118.U();
    L43:
        FrameLayout r119 = this.f429532d;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r119 = null;
    L46:
        k.a.a(r().e(), new com.ss.android.lark.keyboard.event.a(r119.getHeight(), r101.getMeasuredHeight(), 285, r113));
    L48:
        r().z();
    L28:
        r109 = false;
        goto L29
    L47:
        r105.setVisibility(8);
        r101.setVisibility(0);
    L49:
        IKeyboardContent r120 = this.f429536h;
        if (r120 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r120 = null;
    L52:
        r120.onHide();
        IKeyboardContent r121 = this.f429536h;
        if (r121 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r121 = null;
    L55:
        r121.c(0);
        IKeyboardContent r122 = this.f429536h;
        if (r122 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r122 = null;
    L58:
        r112 = r122.getKey();
        goto L59
    }
}
