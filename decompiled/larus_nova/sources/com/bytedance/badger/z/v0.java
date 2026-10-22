package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class v0 extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f199491a;

    public v0(Function0 r100) {
        this.f199491a = r100;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r100, BadgerModuleBase.BadgerRequestData r101) {
        return new BadgerResult.Success(new DataString((String) this.f199491a.invoke()));
    }
}
