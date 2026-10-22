package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniConversation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniConversationObserver;", "Lcom/larus/im/internal/jni/observer/Observer;", "notifyChange", "", "conversations", "", "Lcom/larus/im/internal/jni/bean/OmniConversation;", "notifyReplace", "localCvsId", "", "localCvs", "remote", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniConversationObserver extends Observer {
    void notifyChange(List<OmniConversation> r100);

    void notifyReplace(String r100, OmniConversation r101, OmniConversation r102);
}
