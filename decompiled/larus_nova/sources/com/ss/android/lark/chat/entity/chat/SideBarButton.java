package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/SideBarButton;", "Ljava/io/Serializable;", "labelName", "", "iconKey", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabelName", "()Ljava/lang/String;", "getIconKey", "getUrl", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarButton implements Serializable {
    private final String iconKey;
    private final String labelName;
    private final String url;

    public SideBarButton() {
        this(null, null, null, 7, null);
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final String getUrl() {
        return this.url;
    }

    public SideBarButton(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "labelName");
        Intrinsics.checkNotNullParameter(r101, "iconKey");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.labelName = r100;
        this.iconKey = r101;
        this.url = r102;
    }

    public /* synthetic */ SideBarButton(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
