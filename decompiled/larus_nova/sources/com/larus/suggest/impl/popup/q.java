package com.larus.suggest.impl.popup;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.larus.bmhome.chat.bean.PopWindowMedia;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.suggest.api.NexPulseDialogRequestScene;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f369896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f369897b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b1 f369898c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f369899d;

    /* JADX INFO: loaded from: classes31.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f369900a = null;

        static {
            int[] r100 = new int[NexPulseDialogRequestScene.values().length];
            r100[NexPulseDialogRequestScene.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[NexPulseDialogRequestScene.PC_GUIDE_SCHEMA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f369900a = r100;
        }
    }

    public q() {
    }

    static {
        f369896a = new q();
        StateFlowImpl r100 = j1.a(null);
        f369897b = r100;
        f369898c = kotlinx.coroutines.flow.e.b(r100);
    }

    public static final Object a(q r100, PopWindowMedia r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof NexPulseDialogManager$preloadImage$1) == false) goto L7;
        NexPulseDialogManager$preloadImage$1 r102 = (NexPulseDialogManager$preloadImage$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        NexPulseDialogManager$preloadImage$1 r104 = r102;
        Object r105 = r104.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r104.L$0;
        ResultKt.throwOnFailure(r105);
    L23:
        ((DataSource) r105).subscribe(new r(r107), CallerThreadExecutor.getInstance());
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        boolean r108 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L17;
        String r109 = r101.getMediaDarkUrl();
    L18:
        r107 = r109;
        if (r107 == null) goto L25;
        r104.L$0 = r107;
        r104.label = 1;
        r105 = ImageLoaderKt.A(r107, "NexPulseDialogManager", null, null, null, r104, 60);
        if (r105 != r111) goto L23;
        return r111;
    L17:
        r109 = r101.getMediaUrl();
    L7:
        r102 = new NexPulseDialogManager$preloadImage$1(r100, r110);
        goto L8
    }

    public static final Object b(q r100, PopWindowMedia r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof NexPulseDialogManager$preloadVideo$1) == false) goto L7;
        NexPulseDialogManager$preloadVideo$1 r102 = (NexPulseDialogManager$preloadVideo$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        NexPulseDialogManager$preloadVideo$1 r104 = r102;
        Object r105 = r104.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r104.L$0;
        ResultKt.throwOnFailure(r105);
    L31:
        ((DataSource) r105).subscribe(new u(r107), CallerThreadExecutor.getInstance());
    L33:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        String r108 = r101.getMediaUrl();
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
        FLogger.f375446a.e("NexPulseDialogManager", "invalid video model " + r108);
        return Unit.INSTANCE;
    L23:
        Lazy r112 = q3.f365794a;
        z3 r113 = q3.a();
        if (r113 == null) goto L26;
        r113.f(r108, new t(r108, r113));
    L26:
        r107 = r101.getVideoCoverUrl();
        if (r107 == null) goto L33;
        r104.L$0 = r107;
        r104.label = 1;
        r105 = ImageLoaderKt.A(r107, "NexPulseDialogManager", null, null, null, r104, 60);
        if (r105 != r111) goto L31;
        return r111;
    L17:
        if (r108.length() == 0) goto L20;
        r109 = false;
    L7:
        r102 = new NexPulseDialogManager$preloadVideo$1(r100, r110);
        goto L8
    }
}
