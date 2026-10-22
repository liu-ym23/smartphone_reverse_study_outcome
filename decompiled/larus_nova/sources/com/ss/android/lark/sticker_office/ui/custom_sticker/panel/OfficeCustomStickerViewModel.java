package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sticker.core.model.PushCustomizedStickersRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
public final class OfficeCustomStickerViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<List<Sticker>> f440883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f440884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OfficeCustomStickerModel f440885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoroutineScope f440886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f440887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f440888f;

    public static final class a {
    }

    public static final class b implements e6c.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomStickerViewModel f440889a;

        public b(OfficeCustomStickerViewModel r100) {
            this.f440889a = r100;
        }

        @Override // e6c.b.a
        public final void a(PushCustomizedStickersRequest r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Log.i("OfficeCustomStickerViewModel", "onPushCustomSticker");
            OfficeCustomStickerViewModel r101 = this.f440889a;
            CoroutineScope r102 = r101.f440886d;
            if (r102 == null) goto L6;
            BuildersKt.launch$default(r102, null, null, new OfficeCustomStickerViewModel$loadStickersFromServer$1(r101, null), 3, null);
            return;
        }
    }

    static {
    }

    public OfficeCustomStickerViewModel() {
        MutableLiveData<List<Sticker>> r100 = new MutableLiveData(null);
        this.f440883a = r100;
        this.f440884b = r100;
        this.f440885c = new OfficeCustomStickerModel();
        this.f440888f = new b(this);
    }

    public final Object b(List<? extends Sticker> r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof OfficeCustomStickerViewModel$deleteStickers$1) == false) goto L7;
        OfficeCustomStickerViewModel$deleteStickers$1 r102 = (OfficeCustomStickerViewModel$deleteStickers$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L18:
        if (Result.m9456isSuccessimpl(r107) == false) goto L33;
        List<? extends Sticker> r108 = r100;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        r109.add(((Sticker) r110.next()).getStickerId());
        goto L21
    L23:
        Set r111 = CollectionsKt.toSet(r109);
        MutableLiveData<List<Sticker>> r112 = this.f440883a;
        List<Sticker> r113 = r112.getValue();
        if (r113 == null) goto L31;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r113.iterator();
    L27:
        if (r115.hasNext() == false) goto L32;
        Object r116 = r115.next();
        if ((!r111.contains(((Sticker) r116).getStickerId())) == false) goto L27;
        r114.add(r116);
    L32:
        r112.setValue(r114);
        goto L33
    L31:
        r114 = null;
    L33:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        OfficeCustomStickerModel r117 = this.f440885c;
        r102.L$0 = r100;
        r102.label = 1;
        r107 = r117.a(r100, r102);
        if (r107 != r105) goto L18;
        return r105;
    L7:
        r102 = new OfficeCustomStickerViewModel$deleteStickers$1(this, r101);
        goto L8
    }

    public static final Object a(OfficeCustomStickerViewModel r100, boolean r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof OfficeCustomStickerViewModel$getCustomStickers$1) == false) goto L7;
        OfficeCustomStickerViewModel$getCustomStickers$1 r103 = (OfficeCustomStickerViewModel$getCustomStickers$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L17:
        r106 = r108;
        if (r101 == true) goto L20;
        r100.f440887e = Result.m9455isFailureimpl(r106);
    L20:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        OfficeCustomStickerModel r109 = r100.f440885c;
        r103.Z$0 = r101;
        r103.label = 1;
        r108 = r109.b(r101, r103);
        if (r108 != r106) goto L17;
    L7:
        r103 = new OfficeCustomStickerViewModel$getCustomStickers$1(r100, r102);
        goto L8
    }

    public final Object c(List<String> r100, boolean r101, Continuation<? super Result<? extends c6c.b>> r102) {
        if ((r102 instanceof OfficeCustomStickerViewModel$uploadStickers$1) == false) goto L7;
        OfficeCustomStickerViewModel$uploadStickers$1 r103 = (OfficeCustomStickerViewModel$uploadStickers$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        OfficeCustomStickerModel r108 = this.f440885c;
        r103.label = 1;
        Object r109 = r108.c(r100, r101, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new OfficeCustomStickerViewModel$uploadStickers$1(this, r102);
        goto L8
    }
}
