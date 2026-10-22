package com.bytedance.ee.bear.bitable.uikit.empty;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "text", "getText", "setText", "textEx", "", "getTextEx", "()Ljava/lang/CharSequence;", "setTextEx", "(Ljava/lang/CharSequence;)V", "button", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getButton", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setButton", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "secondaryButton", "getSecondaryButton", "setSecondaryButton", "guidelinePercent", "", "getGuidelinePercent", "()Ljava/lang/Float;", "setGuidelinePercent", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyData implements NonProguard {
    private SimpleItemModel button;
    private Float guidelinePercent;
    private Icon icon;
    private SimpleItemModel secondaryButton;
    private String text;
    private CharSequence textEx;
    private String title;

    public EmptyData() {
    }

    public final SimpleItemModel getButton() {
        return this.button;
    }

    public final Float getGuidelinePercent() {
        return this.guidelinePercent;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final SimpleItemModel getSecondaryButton() {
        return this.secondaryButton;
    }

    public final String getText() {
        return this.text;
    }

    public final CharSequence getTextEx() {
        return this.textEx;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setButton(SimpleItemModel r100) {
        this.button = r100;
    }

    public final void setGuidelinePercent(Float r100) {
        this.guidelinePercent = r100;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setSecondaryButton(SimpleItemModel r100) {
        this.secondaryButton = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextEx(CharSequence r100) {
        this.textEx = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
