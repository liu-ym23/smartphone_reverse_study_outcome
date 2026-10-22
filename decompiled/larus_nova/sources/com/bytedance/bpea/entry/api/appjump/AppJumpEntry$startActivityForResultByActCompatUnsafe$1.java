package com.bytedance.bpea.entry.api.appjump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class AppJumpEntry$startActivityForResultByActCompatUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Bundle $options;
    final /* synthetic */ int $requestCode;

    public AppJumpEntry$startActivityForResultByActCompatUnsafe$1(Activity r100, Intent r101, int r102, Bundle r103) {
        this.$activity = r100;
        this.$intent = r101;
        this.$requestCode = r102;
        this.$options = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ActivityCompat.startActivityForResult(this.$activity, this.$intent, this.$requestCode, this.$options);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
