package com.bytedance.android.livesdk.ktvimpl.mv;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.cache.CopyCacheItem;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.Error;
import fd2.d0;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/l;", "it", "", "errorCode", "", "errorMsg", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/l;ILjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class MvServiceImpl$prefechMvInfo$1 extends Lambda implements Function3<l, Integer, String, Unit> {
    final /* synthetic */ fd2.o $callback;
    final /* synthetic */ d0 $param;
    final /* synthetic */ Long $preloadSize;
    final /* synthetic */ MvServiceImpl this$0;

    public static final class a implements IPreLoaderItemCallBackListener {
        public final /* synthetic */ MvServiceImpl$prefechMvInfo$1 a;
        public final /* synthetic */ l b;

        public a(MvServiceImpl$prefechMvInfo$1 r1, l r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void preloadItemInfo(final PreLoaderItemCallBackInfo r17) {
            MvServiceImpl$prefechMvInfo$1 r1 = this.a;
            MvServiceImpl r8 = r1.this$0;
            final d0 r3 = r1.$param;
            final l r9 = this.b;
            final fd2.o r2 = r1.$callback;
            int r4 = MvServiceImpl.k;
            r8.getClass();
            if (r17.getKey() != 2) goto L48;
            DataLoaderHelper.DataLoaderTaskProgressInfo r5 = r17.preloadDataInfo;
            if (r5 == null) goto L7;
            String r6 = r5.mLocalFilePath;
        L8:
            if (r5 == null) goto L10;
            String r7 = r5.mKey;
        L11:
            String r12 = r8.a;
            if (r6 != null) goto L14;
        L45:
            if (r2 == null) goto L64;
            r2.a(r3, 10001, "download file not exist", r9.d, r9.c);
            return;
        L64:
            return;
        L14:
            if (TextUtils.isEmpty(r6) == true) goto L45;
            if (TextUtils.isEmpty(r7) == false) goto L20;
            if (r2 == null) goto L59;
            r2.a(r3, 10002, "fileKey is null", r9.d, r9.c);
            return;
        L59:
            return;
        L20:
            if (r12 != null) goto L22;
        L43:
            if (r2 == null) goto L62;
            r2.b(r3, r6, r9.d, r9.c);
            return;
        L62:
            return;
        L22:
            if (r12.length() != 0) goto L24;
            boolean r10 = true;
        L25:
            if (r10 == true) goto L43;
            r9.b = r6;
            final Ref.ObjectRef r11 = new Ref.ObjectRef();
            int r13 = com.bytedance.android.live.ktv.common.music.download.s.a;
            r11.element = com.bytedance.android.live.ktv.common.music.download.s.a.a(r9.d, r12);
            if (TextUtils.isEmpty(r12) == true) goto L36;
            PolarisFileWrapper r14 = new PolarisFileWrapper(r12);
            if (r14.exists() == true) goto L32;
            r14.mkdirs();
        L32:
            KtvMvPlayer r15 = r8.b;
            if (r7 != null) goto L35;
            r7 = "";
        L35:
            String r16 = r7;
            String r18 = (String) r11.element;
            Function1<Boolean, Unit> r19 = new MvServiceImpl$handlePreLoadState$1(r2, r3, r11, r9, r17);
            r15.getClass();
            Intrinsics.checkNotNullParameter(r16, "fileKey");
            Intrinsics.checkNotNullParameter(r18, "exportPath");
            Intrinsics.checkNotNullParameter(r19, "exportCb");
            TTVideoEngine.copyDataLoaderCache(new CopyCacheItem(r16, r18, false, new h(r19)));
            Disposable r20 = Observable.fromCallable(new o(r8, r12)).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(p.a, q.a);
            r8.j.add(r20);
        L36:
            DataLoaderHelper.DataLoaderTaskProgressInfo r21 = r17.preloadDataInfo;
            if (r21 == null) goto L41;
            VideoInfo r22 = r21.mUsingVideoInfo;
            if (r22 == null) goto L41;
            Integer r110 = Integer.valueOf(r22.mVideoDuration);
        L42:
            r9.a = r110;
            return;
        L41:
            r110 = null;
            goto L42
        L24:
            r10 = false;
            goto L25
        L10:
            r7 = null;
            goto L11
        L7:
            r6 = null;
            goto L8
        L48:
            if (r17.getKey() != 3) goto L66;
            Error r23 = r17.preloadError;
            if (r23 == null) goto L52;
            int r24 = r23.code;
        L53:
            if (r2 == null) goto L67;
            if (r23 == null) goto L56;
            String r25 = r23.description;
        L57:
            r2.a(r3, r24, r25, r9.d, r9.c);
            return;
        L56:
            r25 = null;
            goto L57
        L67:
            return;
        L52:
            r24 = 0;
            goto L53
        }
    }

    public MvServiceImpl$prefechMvInfo$1(MvServiceImpl r1, fd2.o r2, d0 r3, Long r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$param = r3;
        this.$preloadSize = r4;
        super(3);
    }

    public final void invoke(l r7, int r8, String r9) {
        if (r7 != null) goto L7;
        fd2.o r0 = this.$callback;
        if (r0 == null) goto L20;
        r0.a(this.$param, r8, r9, "null", null);
        return;
    L20:
        return;
    L7:
        MvServiceImpl r10 = this.this$0;
        final String r11 = r10.a;
        final String r1 = r7.c;
        final String r2 = r7.d;
        if (r10.h == true) goto L10;
    L15:
        Intrinsics.checkNotNullParameter("prefechMvInfo", "<set-?>");
        r7.k = "prefechMvInfo";
        MvServiceImpl r12 = this.this$0;
        KtvMvPlayer r13 = r12.b;
        u r3 = new u(r7.d, r7.e, r7.m);
        Long r4 = this.$preloadSize;
        if (r4 != null) goto L18;
        r4 = this.this$0.i;
    L18:
        r12.g = r13.p(r3, r4, new a(this, r7));
        return;
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        if (r11 == null) goto L15;
        if (r2 == null) goto L15;
        UtilityKotlinExtentionsKt.b(this.this$0, new AnonymousClass1(this, r1, r2, r11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((l) r1, ((Number) r2).intValue(), (String) r3);
        return Unit.INSTANCE;
    }
}
