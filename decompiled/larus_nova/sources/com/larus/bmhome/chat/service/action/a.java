package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.i f308733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConversationModel f308734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConversationChangeModel f308735c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f308733a, r101.f308733a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308734b, r101.f308734b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308735c, r101.f308735c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f308733a.hashCode() * 31) + this.f308734b.hashCode()) * 31) + this.f308735c.hashCode();
    }

    public final String toString() {
        return "ConversationFeedActionExecuteContext(actionContext=" + this.f308733a + ", model=" + this.f308734b + ", conversationChangeModel=" + this.f308735c + ')';
    }

    public a(com.larus.bmhome.chat.api.i r100, ConversationModel r101, ConversationChangeModel r102) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "conversationChangeModel");
        this.f308733a = r100;
        this.f308734b = r101;
        this.f308735c = r102;
    }
}
