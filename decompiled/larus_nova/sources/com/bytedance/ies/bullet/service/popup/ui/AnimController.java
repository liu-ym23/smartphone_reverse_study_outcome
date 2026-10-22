package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class AnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimProcessType f248013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimProcessType f248014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f248015c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;", "", UserProfileEvent.POSITION_NONE, "DOING", "DONE", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimProcessType[] f248016a = null;

        public static AnimProcessType valueOf(String r100) {
            return (AnimProcessType) r27.a.a(AnimProcessType.class, r100);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) f248016a.clone();
        }

        static {
            AnimProcessType r100 = new AnimProcessType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AnimProcessType r101 = new AnimProcessType("DOING", 1);
            DOING = r101;
            AnimProcessType r102 = new AnimProcessType("DONE", 2);
            DONE = r102;
            f248016a = new AnimProcessType[]{r100, r101, r102};
        }

        public AnimProcessType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnimController() {
        AnimProcessType r100 = AnimProcessType.NONE;
        this.f248013a = r100;
        this.f248014b = r100;
    }

    public final void a(View r100, ObjectAnimator r101, int r102, Function0<Unit> r103, Function1<? super Float, Unit> r104) {
        Intrinsics.checkNotNullParameter(r103, "succUnits");
        Intrinsics.checkNotNullParameter(r104, "animProgressListener");
        if (this.f248014b == AnimProcessType.NONE) goto L12;
        long r105 = this.f248015c - System.currentTimeMillis();
        if (r105 <= 0) goto L10;
        long r106 = r102;
        if (r105 <= r106) goto L9;
        Thread.sleep(r106);
        goto L10
    L9:
        Thread.sleep(r105);
    L10:
        r103.invoke();
        return;
    L12:
        if (r101 != null) goto L15;
        r103.invoke();
        return;
    L15:
        if (r100 == null) goto L17;
        long r107 = r102;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f}).setDuration(r107);
        r101.setDuration(r107);
        r101.addListener(new h(this, r103));
        r101.addUpdateListener(new i(r104));
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r108, r101});
        r109.start();
    L18:
        this.f248015c = System.currentTimeMillis() + ((long) r102);
        return;
    L17:
        r101.setDuration(r102);
        r101.addListener(new h(this, r103));
        r101.addUpdateListener(new i(r104));
        r101.start();
        goto L18
    }
}
