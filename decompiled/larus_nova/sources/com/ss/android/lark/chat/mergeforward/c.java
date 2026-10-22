package com.ss.android.lark.chat.mergeforward;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f415443a = 0;

    static {
    }

    @JvmStatic
    public static final void a(List r100, boolean r101) {
        List r102 = (List) BuildersKt.runBlocking$default(null, new MessagePreviewAttachHelper$completeMessages$1(r100, r101, null), 1, null);
    }
}
