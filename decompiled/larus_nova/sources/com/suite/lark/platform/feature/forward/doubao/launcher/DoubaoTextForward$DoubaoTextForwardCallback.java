package com.suite.lark.platform.feature.forward.doubao.launcher;

import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextForwardCallback;", "Ljava/io/Serializable;", "onSuccess", "", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "onFailed", "errorTitle", "errorMessage", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoubaoTextForward$DoubaoTextForwardCallback extends Serializable {
    void onFailed(String r100, String r101);

    void onSuccess(Map<String, ? extends ForwardTargetBaseInfoNew> r100);
}
