package com.larus.login.impl.douyinconversationauth;

import com.larus.login.api.DouyinConversationAuthTriggerScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DouyinConversationAuthTriggerScene f357655a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f357655a == ((e) r100).f357655a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f357655a.hashCode();
    }

    public final String toString() {
        return "DouyinConversationAuthTrigger(scene=" + this.f357655a + ')';
    }

    public e(DouyinConversationAuthTriggerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f357655a = r100;
    }
}
