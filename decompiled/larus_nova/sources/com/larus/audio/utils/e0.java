package com.larus.audio.utils;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 implements m58.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f290030a = null;

    static {
        f290030a = new e0();
    }

    public e0() {
    }

    @Override // m58.m
    public final f0 create() {
        Intrinsics.checkNotNullParameter("VoiceInput", EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter("AsrAbility", "subModule");
        return new f0(new f2a.d("VoiceInput", "AsrAbility"));
    }
}
