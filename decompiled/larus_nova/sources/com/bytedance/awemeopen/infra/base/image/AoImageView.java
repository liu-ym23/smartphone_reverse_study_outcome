package com.bytedance.awemeopen.infra.base.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/bytedance/awemeopen/servicesapi/image/AoImageService;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getImageService", "()Lcom/bytedance/awemeopen/servicesapi/image/AoImageService;", "imageService", "", "b", "Z", "getOptVisibilityAggregated", "()Z", "setOptVisibilityAggregated", "(Z)V", "optVisibilityAggregated", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public class AoImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f198619b;

    public final AoImageService getImageService() {
        return (AoImageService) this.f198618a.getValue();
    }

    public final boolean getOptVisibilityAggregated() {
        return this.f198619b;
    }

    public AoImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f198618a = LazyKt.lazy(AoImageView$imageService$2.INSTANCE);
    }

    public final void j(b r100) {
        Intrinsics.checkNotNullParameter(r100, "aoAppLoadImageOptions");
        r100.f198623d = this;
        l64.b r101 = r100.a();
        getImageService().Q0(getContext(), r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (this.f198619b == false) goto L8;
        Drawable r101 = getDrawable();
        if (r101 == null) goto L9;
        r101.setVisible(true, false);
        return;
    L9:
        return;
    }

    public final void setOptVisibilityAggregated(boolean r100) {
        this.f198619b = r100;
    }

    public AoImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        this.f198618a = LazyKt.lazy(AoImageView$imageService$2.INSTANCE);
    }

    public AoImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f198618a = LazyKt.lazy(AoImageView$imageService$2.INSTANCE);
    }
}
