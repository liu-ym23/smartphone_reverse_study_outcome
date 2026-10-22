package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isInAnimation", "", "()Z", "setInAnimation", "(Z)V", "animType", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", "getAnimType", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", "setAnimType", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "AnimType", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListAnimationContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimType f412071a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", "", "<init>", "(Ljava/lang/String;I)V", "Enter", "Exit", "None", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType Enter = null;
        public static final AnimType Exit = null;
        public static final AnimType None = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimType[] f412072a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f412073b = null;

        public static EnumEntries<AnimType> getEntries() {
            return f412073b;
        }

        static {
            AnimType r100 = new AnimType("Enter", 0);
            Enter = r100;
            AnimType r101 = new AnimType("Exit", 1);
            Exit = r101;
            AnimType r102 = new AnimType("None", 2);
            None = r102;
            AnimType[] r103 = {r100, r101, r102};
            f412072a = r103;
            f412073b = EnumEntriesKt.enumEntries(r103);
        }

        public static AnimType[] values() {
            return (AnimType[]) f412072a.clone();
        }

        public static AnimType valueOf(String r100) {
            return (AnimType) a.a(AnimType.class, r100);
        }

        public AnimType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MessageListAnimationContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public MessageListAnimationContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public MessageListAnimationContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void setInAnimation(boolean r100) {
    }

    public final AnimType getAnimType() {
        return this.f412071a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        AnimType r101 = this.f412071a;
        if (r101 != AnimType.Enter) goto L22;
        boolean r102 = true;
        if (r100 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L19;
        if (r100 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r102 == true) goto L19;
        return false;
    L13:
        if (r100.getActionMasked() != 1) goto L15;
    L19:
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.setAction(3);
        return super.dispatchTouchEvent(r104);
    L7:
        if (r100.getActionMasked() != 2) goto L9;
        r103 = true;
        goto L10
    L22:
        if (r101 != AnimType.Exit) goto L28;
        if (Math.abs(getTranslationY()) <= 0.0f) goto L28;
        if (r100 == null) goto L28;
        r100.offsetLocation(0.0f, getTranslationY());
    L28:
        return super.dispatchTouchEvent(r100);
    }

    public final void setAnimType(AnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f412071a = r100;
    }

    public MessageListAnimationContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f412071a = AnimType.None;
    }
}
