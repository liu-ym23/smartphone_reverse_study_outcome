package com.larus.avatar.impl.upload;

import android.graphics.Bitmap;
import com.larus.avatar.impl.upload.viewmodel.DigitalAvatarUploadViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes23.dex */
public final class DigitalAvatarPreGenManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f291225d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f291226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DigitalAvatarUploadViewModel f291227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, r88.a> f291228c;

    public static final class a {
    }

    static {
    }

    public DigitalAvatarPreGenManager(s r100, DigitalAvatarUploadViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "uiState");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f291226a = r100;
        this.f291227b = r101;
        this.f291228c = new LinkedHashMap();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008d -> B:30:0x0095). Please report as a decompilation issue!!! */
    public final Object a(boolean r110, Continuation<? super List<Pair<r88.a, Bitmap>>> r111) {
        if ((r111 instanceof DigitalAvatarPreGenManager$collectBitmapPairs$1) == false) goto L7;
        DigitalAvatarPreGenManager$collectBitmapPairs$1 r100 = (DigitalAvatarPreGenManager$collectBitmapPairs$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = r100.Z$0;
        r88.a r104 = (r88.a) r100.L$2;
        Iterator r105 = (Iterator) r100.L$1;
        List r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
        List r107 = r106;
        Iterator r108 = r105;
        r88.a r109 = r104;
        Object r113 = r102;
        DigitalAvatarPreGenManager$collectBitmapPairs$1 r114 = r100;
        DigitalAvatarPreGenManager r115 = this;
    L30:
        Bitmap r116 = (Bitmap) r112;
        if (r116 == null) goto L33;
        Boxing.boxBoolean(r107.add(TuplesKt.to(r109, r116)));
    L34:
        DigitalAvatarPreGenManager r117 = r115;
        r100 = r114;
        r102 = r113;
        Iterator r118 = r108;
        List r119 = r107;
    L20:
        if (r118.hasNext() == false) goto L35;
        r88.a r120 = (r88.a) r118.next();
        if (r110 == false) goto L26;
        if (r120.f536666f == true) goto L20;
    L26:
        r100.L$0 = r119;
        r100.L$1 = r118;
        r100.L$2 = r120;
        r100.Z$0 = r110;
        r100.label = 1;
        Object r121 = r117.b(r120, r100);
        if (r121 != r102) goto L29;
        return r102;
    L29:
        DigitalAvatarPreGenManager$collectBitmapPairs$1 r122 = r100;
        r115 = r117;
        r112 = r121;
        r107 = r119;
        r108 = r118;
        r109 = r120;
        r113 = r102;
        r114 = r122;
        goto L30
    L35:
        return r119;
    L33:
        FLogger.f375446a.e("DigitalAvatarPreGenMgr", "collectPreGenBitmapPairs failed for " + r109.f536661a);
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (this.f291228c.isEmpty() == true) goto L17;
        r119 = new ArrayList();
        r118 = ((LinkedHashMap) this.f291228c).values().iterator();
        r117 = this;
        goto L20
    L17:
        return CollectionsKt.emptyList();
    L7:
        r100 = new DigitalAvatarPreGenManager$collectBitmapPairs$1(this, r111);
        goto L8
    }

    public final Object b(r88.a r100, Continuation<? super Bitmap> r101) {
        if ((r101 instanceof DigitalAvatarPreGenManager$ensurePreGenBitmap$1) == false) goto L7;
        DigitalAvatarPreGenManager$ensurePreGenBitmap$1 r102 = (DigitalAvatarPreGenManager$ensurePreGenBitmap$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (r88.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L26:
        Bitmap r107 = (Bitmap) r104;
        r100.f536665e = r107;
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Bitmap r108 = r100.f536665e;
        if (r108 == null) goto L17;
        return r108;
    L17:
        String r109 = r100.f536663c.d();
        if (r109 != null) goto L21;
        r109 = r100.f536663c.c();
    L21:
        if (r109 != null) goto L23;
        return null;
    L23:
        CoroutineDispatcher r110 = Dispatchers.getIO();
        DigitalAvatarPreGenManager$ensurePreGenBitmap$bitmap$1 r111 = new DigitalAvatarPreGenManager$ensurePreGenBitmap$bitmap$1(r109, null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = BuildersKt.withContext(r110, r111, r102);
        if (r104 != r105) goto L26;
        return r105;
    L7:
        r102 = new DigitalAvatarPreGenManager$ensurePreGenBitmap$1(this, r101);
        goto L8
    }
}
