package com.ss.android.lark.watermark;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.core.IAttachResultCallback;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import com.ss.android.lark.watermark.v2.p;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J)\u0010\f\u001a\u00020\u00062\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J)\u0010\f\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J1\u0010\f\u001a\u00020\u00062\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J1\u0010\f\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00062\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0011\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J!\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00180\u00182\u000e\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n \t*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001JI\u0010\u001e\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u001a0\u001a2\u000e\u0010\u001f\u001a\n \t*\u0004\u0018\u00010 0 H\u0096\u0001J\u0019\u0010!\u001a\u00020\u00062\u000e\u0010\"\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001¨\u0006$"}, d2 = {"Lcom/ss/android/lark/watermark/Watermark;", "Lcom/ss/android/lark/watermark/v2/WatermarkAdapter;", "watermarkAdapter", "<init>", "(Lcom/ss/android/lark/watermark/v2/WatermarkAdapter;)V", "addWatermarkToBitmap", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "callback", "Lcom/ss/android/lark/watermark/core/IAttachToBitmapCallback;", "attachWatermark", "activity", "Landroid/app/Activity;", "Lcom/ss/android/lark/watermark/core/IAttachResultCallback;", "frameLayout", "Landroid/widget/FrameLayout;", "global", "", "detachWatermark", MonitorConstants.CONNECT_TYPE_GET, "Lcom/ss/android/lark/watermark/dto/WatermarkInfo;", "getWatermarkData", "Lcom/ss/android/lark/watermark/dto/WatermarkData;", "watermarkType", "Lcom/ss/android/lark/watermark/core/WatermarkType;", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tryAddFileWatermarkToBitmap", "watermarkPointContext", "Lcom/ss/android/lark/watermark/core/WatermarkPointContext;", "update", "watermarkInfo", "Companion", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Watermark implements p {
    public static final a Companion = null;
    private static final Lazy<Watermark> watermarkInstance$delegate = null;
    private final /* synthetic */ p $$delegate_0;

    public static final class a {
        @JvmStatic
        public static Watermark a() {
            return (Watermark) Watermark.access$getWatermarkInstance$delegate$cp().getValue();
        }

        public a() {
        }
    }

    @JvmStatic
    public static final Watermark inst() {
        Companion.getClass();
        return a.a();
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void addWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101) {
        this.$$delegate_0.addWatermarkToBitmap(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void attachWatermark(Activity r100, IAttachResultCallback r101) {
        this.$$delegate_0.attachWatermark(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void attachWatermark(Activity r100, boolean r101, IAttachResultCallback r102) {
        this.$$delegate_0.attachWatermark(r100, r101, r102);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void attachWatermark(FrameLayout r100, IAttachResultCallback r101) {
        this.$$delegate_0.attachWatermark(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void attachWatermark(FrameLayout r100, boolean r101, IAttachResultCallback r102) {
        this.$$delegate_0.attachWatermark(r100, r101, r102);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void detachWatermark(Activity r100) {
        this.$$delegate_0.detachWatermark(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void detachWatermark(FrameLayout r100) {
        this.$$delegate_0.detachWatermark(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public WatermarkInfo get() {
        return this.$$delegate_0.get();
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public WatermarkData getWatermarkData(WatermarkType r100) {
        return this.$$delegate_0.getWatermarkData(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void init(Context r100) {
        this.$$delegate_0.init(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void tryAddFileWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101, WatermarkType r102, WatermarkPointContext r103) {
        this.$$delegate_0.tryAddFileWatermarkToBitmap(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void update(WatermarkInfo r100) {
        this.$$delegate_0.update(r100);
    }

    static {
        Companion = new a();
        watermarkInstance$delegate = LazyKt.lazy(Watermark$Companion$watermarkInstance$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getWatermarkInstance$delegate$cp() {
        return watermarkInstance$delegate;
    }

    public Watermark(p r100) {
        Intrinsics.checkNotNullParameter(r100, "watermarkAdapter");
        this.$$delegate_0 = r100;
    }
}
