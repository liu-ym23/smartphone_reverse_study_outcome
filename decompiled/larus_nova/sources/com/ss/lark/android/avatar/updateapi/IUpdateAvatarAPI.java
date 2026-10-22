package com.ss.lark.android.avatar.updateapi;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&J&\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/lark/android/avatar/updateapi/IUpdateAvatarAPI;", "Ljava/io/Serializable;", "doRequest", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "avatarPath", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "doRequestByAvatarKey", "avatarKey", "avatar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUpdateAvatarAPI extends Serializable {

    public static final class a {
        public static void a(Context r100, String r101, IGetDataCallback r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "avatarKey");
            Intrinsics.checkNotNullParameter(r102, "callback");
            r102.onError(new ErrorResult(-1, "unsupported avatar key update"));
        }
    }

    void doRequest(Context r100, String r101, IGetDataCallback<String> r102);

    void doRequestByAvatarKey(Context r100, String r101, IGetDataCallback<String> r102);
}
