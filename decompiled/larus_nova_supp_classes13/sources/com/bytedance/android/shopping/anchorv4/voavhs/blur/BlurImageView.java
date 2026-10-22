package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.o;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BlurImageView extends ImageView implements fa3.d {
    public boolean a;
    public boolean b;
    public Function0<Unit> c;
    public final Lazy d;
    public final Function1<Bitmap, Unit> e;
    public final /* synthetic */ fa3.b f;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView$a$a, reason: collision with other inner class name */
        public static final class C0006a<T> implements o {
            public final /* synthetic */ ObservableEmitter a;

            public C0006a(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                this.a.onNext(new com.bytedance.android.shopping.anchorv4.voavhs.blur.c((Bitmap) r3));
            }
        }

        public a(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<com.bytedance.android.shopping.anchorv4.voavhs.blur.c> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            ECLiveImageUtils.f(this.a, new C0006a(r3));
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ BlurImageView a;

        public b(BlurImageView r1) {
            this.a = r1;
        }

        public final Object apply(Object r8) {
            com.bytedance.android.shopping.anchorv4.voavhs.blur.c r9 = (com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            Bitmap r2 = r9.a;
            if (r2 == null) goto L5;
            Bitmap r10 = f.b(BlurImageView.a(this.a), r2, this.a.getWidth(), this.a.getHeight(), 1728053247, 32);
        L7:
            return new com.bytedance.android.shopping.anchorv4.voavhs.blur.c(r10);
        L5:
            r10 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BlurImageView a;

        public c(BlurImageView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Bitmap r3 = ((com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r2).a;
            if (r3 == null) goto L5;
            this.a.setImageBitmap(r3);
            this.a.e.invoke(r3);
        L5:
            BlurImageView r4 = this.a;
            r4.b = false;
            r4.a = true;
        }
    }

    private final f getBlurManager() {
        return (f) this.d.getValue();
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.f.add(r2);
        return r2;
    }

    public final boolean getHasBlurred() {
        return this.a;
    }

    public final Function0<Unit> getOnSizeChangedCallback() {
        return this.c;
    }

    public static final /* synthetic */ f a(BlurImageView r0) {
        return r0.getBlurManager();
    }

    public final void setImageAndBlur(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.b = true;
        fa3.c.a(Observable.create(new a(r2)).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).map(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this);
    }

    public final void setOnSizeChangedCallback(Function0<Unit> r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlurImageView(final Context r2, Function1<? super Bitmap, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onBitmapLoad");
        super(r2);
        this.f = new fa3.b();
        this.e = r3;
        this.d = LazyKt.lazy(new BlurImageView$blurManager$2(r2));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Function0<Unit> r5 = this.c;
        if (r5 == null) goto L5;
        Unit r6 = (Unit) r5.invoke();
    L5:
        this.c = null;
    }
}
