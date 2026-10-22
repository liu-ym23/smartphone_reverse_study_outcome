package com.ss.android.lark.widget.myai_tool;

import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.bytedance.lark.pb.im.v1.MyAIExtensionBasicInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/widget/myai_tool/MyAIToolsInfo;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "toolId", "", "toolRuntimeId", "statusValue", "Lcom/ss/android/lark/widget/myai_tool/MyAIToolsCotStatus;", "toolText", "toolIcon", "Lcom/bytedance/lark/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;", "toolInfo", "Lcom/bytedance/lark/pb/im/v1/MyAIExtensionBasicInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/widget/myai_tool/MyAIToolsCotStatus;Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;Lcom/bytedance/lark/pb/im/v1/MyAIExtensionBasicInfo;)V", "getToolId", "()Ljava/lang/String;", "getToolRuntimeId", "getStatusValue", "()Lcom/ss/android/lark/widget/myai_tool/MyAIToolsCotStatus;", "getToolText", "getToolIcon", "()Lcom/bytedance/lark/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;", "getToolInfo", "()Lcom/bytedance/lark/pb/im/v1/MyAIExtensionBasicInfo;", "equals", "", "other", "", "hashCode", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIToolsInfo extends SpanInfo {
    private final MyAIToolsCotStatus statusValue;
    private final RichTextElement.MyAIToolProperty.Icon toolIcon;
    private final String toolId;
    private final MyAIExtensionBasicInfo toolInfo;
    private final String toolRuntimeId;
    private final String toolText;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.toolId, this.toolRuntimeId});
    }

    public final MyAIToolsCotStatus getStatusValue() {
        return this.statusValue;
    }

    public final RichTextElement.MyAIToolProperty.Icon getToolIcon() {
        return this.toolIcon;
    }

    public final String getToolId() {
        return this.toolId;
    }

    public final MyAIExtensionBasicInfo getToolInfo() {
        return this.toolInfo;
    }

    public final String getToolRuntimeId() {
        return this.toolRuntimeId;
    }

    public final String getToolText() {
        return this.toolText;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(MyAIToolsInfo.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.myai_tool.MyAIToolsInfo");
        MyAIToolsInfo r102 = (MyAIToolsInfo) r100;
        if (Intrinsics.areEqual(this.toolId, r102.toolId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.toolRuntimeId, r102.toolRuntimeId) == true) goto L22;
        return false;
    L22:
        if (this.statusValue == r102.statusValue) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.toolText, r102.toolText) == true) goto L28;
        return false;
    L28:
        if (this.toolIcon == r102.toolIcon) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public MyAIToolsInfo(String r100, String r101, MyAIToolsCotStatus r102, String r103, RichTextElement.MyAIToolProperty.Icon r104, MyAIExtensionBasicInfo r105) {
        Intrinsics.checkNotNullParameter(r102, "statusValue");
        this.toolId = r100;
        this.toolRuntimeId = r101;
        this.statusValue = r102;
        this.toolText = r103;
        this.toolIcon = r104;
        this.toolInfo = r105;
    }
}
