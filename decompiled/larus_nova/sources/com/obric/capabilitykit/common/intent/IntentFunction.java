package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Landroid/os/Parcelable;", "P", "R", "", "intentcommon_release"}, k = 1, mv = {1, 7, 1})
public interface IntentFunction<P extends Parcelable, R> {

    public static final class a {
        public static void a() {
            throw new NotImplementedError(null, 1, null);
        }
    }

    boolean cancelTask(String r100);

    Object doAction(P r100, DispatchContext r101, Continuation<? super IntentResult<R>> r102);

    String getName();

    boolean isBlock();

    Boolean isTaskOnGoing(DispatchContext r100);
}
