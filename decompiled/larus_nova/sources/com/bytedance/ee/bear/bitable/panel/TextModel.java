package com.bytedance.ee.bear.bitable.panel;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/TextModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "color", "getColor", "setColor", "isBold", "", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", e1.REPLY_ACTION_APPLY, "", "textView", "Landroid/widget/TextView;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextModel implements NonProguard {
    private String color;
    private Boolean isBold;
    private String text;

    public TextModel() {
        this.text = "";
        this.isBold = Boolean.FALSE;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getText() {
        return this.text;
    }

    public final Boolean isBold() {
        return this.isBold;
    }

    public final void apply(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        r100.setText(this.text);
        Boolean r101 = this.isBold;
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        com.bytedance.ee.bear.bitable.m.m(r100, r102);
        String r103 = this.color;
        if (r103 == null) goto L10;
        r100.setTextColor(ColorUtils.h(r103));
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setBold(Boolean r100) {
        this.isBold = r100;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }
}
