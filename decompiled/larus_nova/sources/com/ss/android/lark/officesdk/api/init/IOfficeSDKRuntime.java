package com.ss.android.lark.officesdk.api.init;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", "", "run", "", "block", "Lkotlin/Function1;", "runOnUI", "getStrategy", "Lcom/ss/android/lark/officesdk/api/init/RuntimeStrategy;", "getRuntimeFlag", "Lcom/ss/android/lark/officesdk/api/init/LaunchTaskFlag;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKRuntime {
    LaunchTaskFlag getRuntimeFlag();

    RuntimeStrategy getStrategy();

    void run(Function1<? super IOfficeSDKRuntime, Unit> r100);

    void runOnUI(Function1<? super IOfficeSDKRuntime, Unit> r100);
}
