package eub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends IOfficeSDKCapacity {
    z0 O9(String r100);

    Object c4(f r100, Continuation<? super String> r101);

    Object jb(h r100, Continuation<? super String> r101);

    void setContext(Context r100);
}
