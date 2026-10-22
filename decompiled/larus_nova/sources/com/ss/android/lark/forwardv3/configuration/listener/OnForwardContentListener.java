package com.ss.android.lark.forwardv3.configuration.listener;

import android.app.Activity;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "Landroid/os/Parcelable;", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnForwardContentListener extends Parcelable {
    boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102);

    void onFailed(String r100);
}
