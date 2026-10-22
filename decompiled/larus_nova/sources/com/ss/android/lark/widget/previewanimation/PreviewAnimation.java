package com.ss.android.lark.widget.previewanimation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.widget.previewanimation.animation.d;
import com.ss.android.lark.widget.previewanimation.player.AnimationPlayer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/ss/android/lark/widget/previewanimation/PreviewAnimation;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;", "Landroid/os/Parcelable;", "player", "<init>", "(Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPlayer", "()Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;", "Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;", "duration", "", "getDuration$photo_picker_release", "()J", "setDuration$photo_picker_release", "(J)V", "enter", "Lcom/ss/android/lark/widget/previewanimation/AnimationRecord;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeToParcel", "", "flags", "describeContents", "Success", "Failed", "CREATOR", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewAnimation<T extends AnimationPlayer> implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f447988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f447989b;

    public static final class a implements Parcelable.Creator<PreviewAnimation<AnimationPlayer>> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PreviewAnimation<AnimationPlayer> createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PreviewAnimation.CREATOR.getClass();
            String r101 = r100.readString();
            Intrinsics.checkNotNull(r101);
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == false) goto L39;
            Class<?> r104 = Class.forName(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L30:
            Parcelable r105 = r100.readParcelable(r104.getClassLoader());
            if (r105 == null) goto L35;
            AnimationPlayer r106 = (AnimationPlayer) r105;
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type T of com.ss.android.lark.widget.previewanimation.PreviewAnimation");
            PreviewAnimation<AnimationPlayer> r107 = new PreviewAnimation(r106);
            r107.f447989b = r100.readLong();
            return r107;
        L35:
            throw new IllegalArgumentException("Required value was null.".toString());
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == false) goto L26;
        L29:
            r104 = MiraPluginFix.forName(r101);
            goto L30
        L26:
            if ((th instanceof NoClassDefFoundError) == true) goto L29;
            throw th;
        L39:
            r104 = Class.forName(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        }

        @Override // android.os.Parcelable.Creator
        public final PreviewAnimation<AnimationPlayer>[] newArray(int r100) {
            return new PreviewAnimation[r100];
        }
    }

    public static final class b<T extends AnimationPlayer> implements com.ss.android.lark.widget.previewanimation.a<T> {
        public b() {
        }

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final T a() {
            return null;
        }

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final boolean isSuccess() {
            return false;
        }

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final Object b(ViewGroup r100, Continuation<? super Boolean> r101) {
            return Boxing.boxBoolean(false);
        }
    }

    public static final class c<T extends AnimationPlayer> implements com.ss.android.lark.widget.previewanimation.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PreviewAnimation<T> f447990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f447991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f447992c;

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final T a() {
            return this.f447992c;
        }

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final boolean isSuccess() {
            return this.f447991b;
        }

        public c(PreviewAnimation<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "metaData");
            this.f447990a = r100;
            this.f447991b = true;
            this.f447992c = r100.f447988a;
        }

        @Override // com.ss.android.lark.widget.previewanimation.a
        public final Object b(ViewGroup r100, Continuation<? super Boolean> r101) {
            this.f447992c.c();
            com.ss.android.lark.widget.previewanimation.animation.a r102 = new com.ss.android.lark.widget.previewanimation.animation.a(r100, this.f447990a.f447989b, this.f447992c);
            j r103 = new j(IntrinsicsKt.intercepted(r101), 1);
            r103.C();
            com.ss.android.lark.widget.previewanimation.animation.a.a(r102, r103);
            d r104 = r102.f447995c;
            int r105 = d.f448002g;
            long r106 = MathKt.roundToLong(r104.f448003a.getDuration() * 1.0f);
            r104.f448005c = -1;
            r104.setDuration(r106);
            r104.f448006d = 1.0f;
            r104.f448007e = 1.0f;
            r104.start();
            Object r107 = r103.B();
            if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
            DebugProbesKt.probeCoroutineSuspended(r101);
        L5:
            return r107;
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public PreviewAnimation(T r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        this.f447988a = r100;
        this.f447989b = 400;
    }

    public final Object a(ViewGroup r100, Continuation<? super com.ss.android.lark.widget.previewanimation.a<T>> r110) {
        if ((r110 instanceof PreviewAnimation$enter$1) == false) goto L7;
        PreviewAnimation$enter$1 r101 = (PreviewAnimation$enter$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L20:
        if (((Boolean) r111).booleanValue() == false) goto L23;
        return new c(this);
    L23:
        return new b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        this.f447988a.b(r100);
        com.ss.android.lark.widget.previewanimation.animation.a r112 = new com.ss.android.lark.widget.previewanimation.animation.a(r100, this.f447989b, this.f447988a);
        r101.label = 1;
        j r105 = new j(IntrinsicsKt.intercepted(r101), 1);
        r105.C();
        com.ss.android.lark.widget.previewanimation.animation.a.a(r112, r105);
        d r113 = r112.f447995c;
        int r106 = d.f448002g;
        float r107 = 1 - 0.0f;
        long r108 = MathKt.roundToLong(r113.f448003a.getDuration() * r107);
        r113.f448005c = 1;
        r113.setDuration(r108);
        r113.f448006d = 0.0f;
        r113.f448007e = r107;
        r113.start();
        r111 = r105.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L17:
        if (r111 != r103) goto L20;
        return r103;
    L7:
        r101 = new PreviewAnimation$enter$1(this, r110);
        goto L8
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f447988a.getClass().getName());
        r100.writeParcelable(this.f447988a, r101);
        r100.writeLong(this.f447989b);
    }
}
