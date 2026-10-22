package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/VideoPinchBar;", "Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/BasePinchBar;", "Lsz3/c;", "params", "", "setupSpeedView", "Lkotlin/Function1;", "", "g", "Lkotlin/jvm/functions/Function1;", "getOnSpeedChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSpeedChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSpeedChangeCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoPinchBar extends BasePinchBar {
    public static final /* synthetic */ int i = 0;
    public final PinchSpeedView f;
    public Function1<? super Float, Unit> g;
    public final a h;

    public static final class a implements k {
        public final /* synthetic */ VideoPinchBar a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public a(VideoPinchBar r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            if (this.a.getPlayPauseViewVisibility() != 0) goto L13;
            r14.c r0 = this.a.getMAweme();
            if (r0 == null) goto L7;
            String r1 = r0.c();
        L9:
            if (Intrinsics.areEqual(r2, r1) == false) goto L14;
            this.a.a(false);
            return;
        L14:
            return;
        L7:
            r1 = null;
            goto L9
        }

        public final void onPlaying(String r2) {
            if (this.a.getPlayPauseViewVisibility() != 0) goto L13;
            r14.c r0 = this.a.getMAweme();
            if (r0 == null) goto L7;
            String r1 = r0.c();
        L9:
            if (Intrinsics.areEqual(r2, r1) == false) goto L14;
            this.a.a(true);
            return;
        L14:
            return;
        L7:
            r1 = null;
            goto L9
        }

        public final void l(String r1, l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }
    }

    public VideoPinchBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoPinchBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function1<Float, Unit> getOnSpeedChangeCallback() {
        return this.g;
    }

    private final void setupSpeedView(final sz3.c r6) {
        com.bytedance.awemeopen.infra.base.player.g r0 = r6.l;
        if (r0 == null) goto L5;
        float r1 = r0.getPlaySpeed();
    L6:
        this.f.l(r1, getMAweme(), getMEventType(), new AnonymousClass1(r6, this));
        return;
    L5:
        r1 = 1.0f;
        goto L6
    }

    public final void b(sz3.c r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r2, "params");
        this.d = r2;
        this.b = r2.f;
        this.c = r2.e;
        setupSpeedView(r2);
        qz3.a r0 = r2.h;
        qz3.b r1 = r2.i;
        o r3 = r2.c;
        if (r3 == null) goto L5;
        r3.addPlayStateListener(this.h);
    L5:
        getMAweme();
    }

    public final void setOnSpeedChangeCallback(Function1<? super Float, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public VideoPinchBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.f = (PinchSpeedView) getMRootView().findViewById(2131387091);
        this.g = VideoPinchBar$onSpeedChangeCallback$1.INSTANCE;
        this.h = new a(this);
        getMRootView().setOnClickListener(new c());
    }

    public /* synthetic */ VideoPinchBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
