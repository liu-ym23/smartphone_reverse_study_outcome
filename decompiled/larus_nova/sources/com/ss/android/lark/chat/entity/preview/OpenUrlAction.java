package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/OpenUrlAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", RuleConditionBean.OPEN_URL_KEY, "Lcom/ss/android/lark/export/entity/preview/Url;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Url;)V", "getOpenUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenUrlAction extends BaseAction {
    private final Url openUrl;

    public int hashCode() {
        Url r100 = this.openUrl;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final Url getOpenUrl() {
        return this.openUrl;
    }

    public OpenUrlAction(Url r100) {
        this.openUrl = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenUrlAction) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.openUrl, ((OpenUrlAction) r100).openUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
