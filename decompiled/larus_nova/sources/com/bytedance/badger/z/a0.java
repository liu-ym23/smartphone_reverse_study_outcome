package com.bytedance.badger.z;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataULong;
import com.bytedance.badger.module.BadgerModuleBase;
import kotlin.ULong;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 extends u0 {
    public a0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r100, BadgerModuleBase.BadgerRequestData r101) {
        return new BadgerResult.Success(new DataULong(ULong.m9623constructorimpl(MathKt.roundToLong(Build.TIME * 0.001d)), null));
    }
}
