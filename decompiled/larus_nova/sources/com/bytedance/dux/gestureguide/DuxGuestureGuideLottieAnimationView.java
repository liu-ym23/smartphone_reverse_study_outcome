package com.bytedance.dux.gestureguide;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/dux/gestureguide/DuxGuestureGuideLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FromMode", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxGuestureGuideLottieAnimationView extends LottieAnimationView {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/gestureguide/DuxGuestureGuideLottieAnimationView$FromMode;", "", "Xml", "Code", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FromMode extends Enum<FromMode> {
        public static final FromMode Code = null;
        public static final FromMode Xml = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FromMode[] f205179a = null;

        public static FromMode valueOf(String r100) {
            return (FromMode) a.a(FromMode.class, r100);
        }

        public static FromMode[] values() {
            return (FromMode[]) f205179a.clone();
        }

        static {
            FromMode r100 = new FromMode("Xml", 0);
            Xml = r100;
            FromMode r101 = new FromMode("Code", 1);
            Code = r101;
            f205179a = new FromMode[]{r100, r101};
        }

        public FromMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DuxGuestureGuideLottieAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxGuestureGuideLottieAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();     // Catch: Exception -> L5
        Unit r100 = Unit.INSTANCE;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r101 = Unit.INSTANCE;
    }

    public DuxGuestureGuideLottieAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.guesture_guide_type});
        switch(r103.getInt(0, -1)) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        GestureType r104 = GestureType.Dynamic;
    L13:
        FromMode r105 = FromMode.Xml;
        Intrinsics.checkNotNullParameter(r104, "type");
        Intrinsics.checkNotNullParameter(r105, "fromMode");
        k.a("init dux guesture type = " + r104.name() + ", fromMode = " + r105);
        if (r104 == GestureType.Dynamic) goto L17;
        String r106 = r104.getAnimResName();
        setImageAssetsFolder(r104.getAnimImgFolderName());
        setAnimation("gesture/" + r106);
    L17:
        r103.recycle();
        return;
    L5:
        r104 = GestureType.Pointer;
        goto L13
    L6:
        r104 = GestureType.Tap;
        goto L13
    L7:
        r104 = GestureType.SwipeUp;
        goto L13
    L8:
        r104 = GestureType.SwipeRight;
        goto L13
    L9:
        r104 = GestureType.SwipeLeft;
        goto L13
    L10:
        r104 = GestureType.SwipeDown;
        goto L13
    L11:
        r104 = GestureType.LongPress;
        goto L13
    L12:
        r104 = GestureType.DoubleTap;
        goto L13
    }

    public /* synthetic */ DuxGuestureGuideLottieAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
