package com.ss.android.lark.compose.chatsetting.common.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public interface a {
    Modifier a(boolean r100, Function0<Unit> r101);

    void b(String r100, Modifier r101, Function1<? super List<String>, Unit> r102, String r103, Composer r104, int r105);

    void c();
}
