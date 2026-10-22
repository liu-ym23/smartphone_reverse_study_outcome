package com.ss.android.lark.watermark.v2;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0014\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/watermark/v2/WatermarkStateMediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/ss/android/lark/watermark/v2/WatermarkState;", "name", "", "source", "Landroidx/lifecycle/LiveData;", "Lcom/ss/android/lark/watermark/dto/WatermarkData;", "imageLoaderFactory", "Lkotlin/Function0;", "Lcom/ss/android/lark/image/api/IRequestCreator;", "timeTicker", "Lcom/ss/android/lark/watermark/v2/TimeTicker;", "textComposer", "Lcom/ss/android/lark/watermark/mysterious/MysteriousWatermarkContentComposer;", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function0;Lcom/ss/android/lark/watermark/v2/TimeTicker;Lcom/ss/android/lark/watermark/mysterious/MysteriousWatermarkContentComposer;)V", "previousWatermarkData", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "toDisplayText", "fetchWatermarkImageBitmap", "Lio/reactivex/Single;", "Landroid/graphics/Bitmap;", "imageUrl", BasicTestActionHandler.TEST_ACTION_RESET, "", "setValue", "value", "Companion", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkStateMediatorLiveData extends MediatorLiveData<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f445527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<IRequestCreator> f445528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f445529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.watermark.mysterious.a f445530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f445531e;

    public static final class a {
    }

    static {
    }

    public final void a(v r100) {
        if (Intrinsics.areEqual(getValue(), r100) == false) goto L5;
        return;
    L5:
        super.setValue(r100);
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f445527a);
        r101.append(" data changed, new text ");
        Lazy r102 = ToolsV3Kt.f445331a;
        int r103 = 0;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L16;
        if (r100 == null) goto L15;
        Object r105 = r100.f445556a;
    L21:
        r101.append(r105);
        Log.i("WatermarkStateMediatorLiveData", r101.toString());
        return;
    L15:
        r105 = null;
        goto L21
    L16:
        if (r100 == null) goto L20;
        String r106 = r100.f445556a;
        if (r106 == null) goto L20;
        r103 = r106.length();
    L20:
        r105 = Integer.valueOf(r103);
        goto L21
    L8:
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == true) goto L11;
        r104 = false;
        goto L12
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final /* bridge */ /* synthetic */ void setValue(Object r100) {
        a((v) r100);
    }

    public WatermarkStateMediatorLiveData(String r100, MutableLiveData r101, Function0 r102, c r103, com.ss.android.lark.watermark.mysterious.a r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "imageLoaderFactory");
        Intrinsics.checkNotNullParameter(r103, "timeTicker");
        Intrinsics.checkNotNullParameter(r104, "textComposer");
        this.f445527a = r100;
        this.f445528b = r102;
        this.f445529c = r103;
        this.f445530d = r104;
        this.f445531e = new CompositeDisposable();
        addSource(r101, new x(this));
    }
}
