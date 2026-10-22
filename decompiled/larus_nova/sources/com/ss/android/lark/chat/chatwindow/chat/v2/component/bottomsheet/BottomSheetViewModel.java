package com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0006J#\u0010\u001c\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u00052\u0006\u0010\u001e\u001a\u0002H\u001d¢\u0006\u0002\u0010\u001fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "state", "Landroidx/lifecycle/MutableLiveData;", "", "getState", "()Landroidx/lifecycle/MutableLiveData;", "bottomSheetStateChangeEvent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel$BottomSheetEvent;", "getBottomSheetStateChangeEvent", "statusBarColorChangeEvent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel$StatusbarColorEvent;", "getStatusBarColorChangeEvent", "orientation", "getOrientation", "uiAnimFraction", "", "getUiAnimFraction", "updateState", "", "triggerEvent", "event", "triggerStatusColorChange", "updateExpandAnimStatus", "fraction", "updateOrientation", "postIfChanged", ExifInterface.GPS_DIRECTION_TRUE, "newValue", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "BottomSheetState", "StatusbarColorEvent", "BottomSheetEvent", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomSheetViewModel extends ViewModel {
    private final MutableLiveData<a> bottomSheetStateChangeEvent;
    private final MutableLiveData<Integer> orientation;
    private final MutableLiveData<Integer> state;
    private final MutableLiveData<b> statusBarColorChangeEvent;
    private final MutableLiveData<Float> uiAnimFraction;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/bottomsheet/BottomSheetViewModel$BottomSheetState;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BottomSheetState {
        public static final a Companion = null;
        public static final int HALF_SCREEN = 1;
        public static final int HIDDEN = 0;
        public static final int TOTAL_SCREEN = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f413552a = null;

            static {
                f413552a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f413552a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f413553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f413554b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel$a$a, reason: collision with other inner class name */
        public static final class C4819a {
        }

        static {
        }

        public final String toString() {
            return "BottomSheetEvent(from=" + this.f413553a + ", to=" + this.f413554b + ')';
        }

        public final int hashCode() {
            return (this.f413553a * 31) + this.f413554b;
        }

        public a(int r100) {
            this.f413553a = 1;
            this.f413554b = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel.BottomSheetEvent");
            a r102 = (a) r100;
            if (this.f413553a == r102.f413553a) goto L16;
            return false;
        L16:
            if (this.f413554b == r102.f413554b) goto L18;
            return false;
        L18:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f413555a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f413555a == ((b) r100).f413555a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413555a;
        }

        public final String toString() {
            return "StatusbarColorEvent(color=" + this.f413555a + ')';
        }

        public b(int r100) {
            this.f413555a = r100;
        }
    }

    public BottomSheetViewModel() {
        this.state = new MutableLiveData(1);
        this.bottomSheetStateChangeEvent = new MutableLiveData();
        this.statusBarColorChangeEvent = new MutableLiveData();
        this.orientation = new MutableLiveData();
        this.uiAnimFraction = new MutableLiveData();
    }

    public final MutableLiveData<a> getBottomSheetStateChangeEvent() {
        return this.bottomSheetStateChangeEvent;
    }

    public final MutableLiveData<Integer> getOrientation() {
        return this.orientation;
    }

    public final MutableLiveData<Integer> getState() {
        return this.state;
    }

    public final MutableLiveData<b> getStatusBarColorChangeEvent() {
        return this.statusBarColorChangeEvent;
    }

    public final MutableLiveData<Float> getUiAnimFraction() {
        return this.uiAnimFraction;
    }

    public final void triggerEvent(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        postIfChanged(this.bottomSheetStateChangeEvent, r100);
    }

    public final void triggerStatusColorChange(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        postIfChanged(this.statusBarColorChangeEvent, r100);
    }

    public final void updateExpandAnimStatus(float r100) {
        postIfChanged(this.uiAnimFraction, Float.valueOf(r100));
    }

    public final void updateOrientation(int r100) {
        postIfChanged(this.orientation, Integer.valueOf(r100));
    }

    public final void updateState(int r100) {
        postIfChanged(this.state, Integer.valueOf(r100));
    }

    public final <T> void postIfChanged(MutableLiveData<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getValue(), r101) == true) goto L6;
        r100.postValue(r101);
        return;
    }
}
