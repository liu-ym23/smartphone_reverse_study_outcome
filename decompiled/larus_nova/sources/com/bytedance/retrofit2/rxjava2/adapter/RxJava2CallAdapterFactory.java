package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes21.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;

    @Nullable
    private final Scheduler scheduler;

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler r100) {
        if (r100 == null) goto L6;
        return new RxJava2CallAdapterFactory(r100, false);
    L6:
        throw new NullPointerException("scheduler == null");
    }

    private RxJava2CallAdapterFactory(@Nullable Scheduler r100, boolean r101) {
        this.scheduler = r100;
        this.isAsync = r101;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter get(Type r110, Annotation[] r111, Retrofit r112) {
        Class<?> r113 = CallAdapter.Factory.getRawType(r110);
        if (r113 != Completable.class) goto L7;
        return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
    L7:
        if (r113 != Flowable.class) goto L9;
        boolean r100 = true;
    L11:
        if (r113 != Single.class) goto L13;
        boolean r101 = true;
    L15:
        if (r113 != Maybe.class) goto L17;
        boolean r114 = true;
    L19:
        if (r113 == Observable.class) goto L26;
        if (r100 == true) goto L26;
        if (r101 == true) goto L26;
        if (r114 == true) goto L26;
        return null;
    L26:
        if ((r110 instanceof ParameterizedType) == true) goto L36;
        if (r100 == true) goto L33;
        if (r101 == true) goto L32;
        if (r114 == false) goto L31;
        String r115 = "Maybe";
    L35:
        throw new IllegalStateException(r115 + " return type must be parameterized as " + r115 + "<Foo> or " + r115 + "<? extends Foo>");
    L31:
        r115 = "Observable";
        goto L35
    L32:
        r115 = "Single";
        goto L35
    L33:
        r115 = "Flowable";
        goto L35
    L36:
        Type r116 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r110);
        Class<?> r117 = CallAdapter.Factory.getRawType(r116);
        if (r117 != SsResponse.class) goto L45;
        if ((r116 instanceof ParameterizedType) == false) goto L43;
        Type r102 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r116);
        boolean r103 = false;
    L41:
        boolean r104 = false;
    L53:
        return new RxJava2CallAdapter(r102, this.scheduler, this.isAsync, r103, r104, r100, r101, r114, false);
    L43:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    L45:
        if (r117 == Result.class) goto L47;
        r102 = r116;
        r103 = false;
        r104 = true;
        goto L53
    L47:
        if ((r116 instanceof ParameterizedType) == false) goto L50;
        r102 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r116);
        r103 = true;
        goto L41
    L50:
        throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
    L17:
        r114 = false;
        goto L19
    L13:
        r101 = false;
        goto L15
    L9:
        r100 = false;
        goto L11
    }
}
