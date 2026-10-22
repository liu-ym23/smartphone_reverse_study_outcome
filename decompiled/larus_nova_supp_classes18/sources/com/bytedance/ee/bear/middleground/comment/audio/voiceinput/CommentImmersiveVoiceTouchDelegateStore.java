package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import androidx.lifecycle.ViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\b\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentImmersiveVoiceTouchDelegateStore;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "delegates", "", "", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentImmersiveVoiceTouchDelegate;", "getOrCreate", "key", "factory", "Lkotlin/Function0;", "onCleared", "", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentImmersiveVoiceTouchDelegateStore extends ViewModel {
    private final Map<String, CommentImmersiveVoiceTouchDelegate> delegates;

    public void onCleared() {
        tt5.a.h("CommentImmersiveVoiceTouchDelegate", "CommentImmersiveVoiceTouchDelegateStore onCleared");
        Iterator<T> r0 = this.delegates.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CommentImmersiveVoiceTouchDelegate r1 = (CommentImmersiveVoiceTouchDelegate) r0.next();
        r1.a();
        r1.i = null;
        goto L4
    L6:
        this.delegates.clear();
        super.onCleared();
    }

    public CommentImmersiveVoiceTouchDelegateStore() {
        this.delegates = new LinkedHashMap();
    }

    public final CommentImmersiveVoiceTouchDelegate getOrCreate(String r3, Function0<CommentImmersiveVoiceTouchDelegate> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "factory");
        Map<String, CommentImmersiveVoiceTouchDelegate> r0 = this.delegates;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = r4.invoke();
        r0.put(r3, (CommentImmersiveVoiceTouchDelegate) r1);
    L6:
        return (CommentImmersiveVoiceTouchDelegate) r1;
    }
}
