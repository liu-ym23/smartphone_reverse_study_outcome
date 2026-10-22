package com.ss.android.lark.inline.ai.creationai.editor;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/ProfileModel;", "Ljava/io/Serializable;", "userId", "", "<init>", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileModel implements Serializable {
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getUserId() {
        return this.userId;
    }

    public ProfileModel(String r100) {
        this.userId = r100;
    }

    public /* synthetic */ ProfileModel(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
