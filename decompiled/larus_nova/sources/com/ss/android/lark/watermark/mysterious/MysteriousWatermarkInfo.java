package com.ss.android.lark.watermark.mysterious;

import com.ss.android.lark.watermark.dto.WatermarkInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0006\u0010\u0019\u001a\u00020\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/watermark/mysterious/MysteriousWatermarkInfo;", "Lcom/ss/android/lark/watermark/dto/WatermarkInfo;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$delegate", "Lkotlin/Lazy;", "imageUrl", "getImageUrl", "setImageUrl", "(Ljava/lang/String;)V", "mysteriousEnabled", "", "getMysteriousEnabled", "()Z", "setMysteriousEnabled", "(Z)V", "toString", "setWatermarkTag", "", "watermarkTag", "getWatermarkTag", "shouldRefreshPeriodically", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MysteriousWatermarkInfo extends WatermarkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f445313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f445314b;

    @Override // com.ss.android.lark.watermark.dto.WatermarkInfo
    public final void setWatermarkTag(String r100) {
    }

    @Override // com.ss.android.lark.watermark.dto.WatermarkInfo
    public final String getWatermarkTag() {
        return (String) this.f445313a.getValue();
    }

    @Override // com.ss.android.lark.watermark.dto.WatermarkInfo
    public final String toString() {
        return "MysteriousWatermarkInfo(imageUrl=" + this.f445314b + ") " + super.toString();
    }

    public MysteriousWatermarkInfo() {
        this.f445313a = LazyKt.lazy(MysteriousWatermarkInfo$tag$2.INSTANCE);
    }
}
