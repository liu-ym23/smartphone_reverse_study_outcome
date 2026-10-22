package com.larus.avatar.impl.upload.viewmodel;

import android.graphics.Bitmap;
import com.larus.avatar.impl.upload.utils.ApiCallConfig;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlgorithmViewModel f291353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f291354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f291355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f291356d;

    public /* synthetic */ a(AlgorithmViewModel r100, List r101, Bitmap r102, Function1 r103) {
        this.f291353a = r100;
        this.f291354b = r101;
        this.f291355c = r102;
        this.f291356d = r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        return AlgorithmViewModel.yo(this.f291353a, this.f291354b, this.f291355c, this.f291356d, (ApiCallConfig) r100);
    }
}
