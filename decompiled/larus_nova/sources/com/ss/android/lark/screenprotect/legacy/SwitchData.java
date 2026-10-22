package com.ss.android.lark.screenprotect.legacy;

import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
@Deprecated(message = "no need for user scope")
public final class SwitchData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f439788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f439789b = null;

    static {
        f439788a = new MutableLiveData(Boolean.TRUE);
        Boolean r100 = Boolean.FALSE;
        f439789b = new MutableLiveData(r100);
        new ConcurrentHashMap();
        new MutableLiveData(r100);
    }

    public static Object a(Continuation r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SwitchData$getSwitchInSP$2(null), r100);
    }
}
