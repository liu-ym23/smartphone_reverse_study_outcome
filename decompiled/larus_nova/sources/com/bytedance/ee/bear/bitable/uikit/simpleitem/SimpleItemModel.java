package com.bytedance.ee.bear.bitable.uikit.simpleitem;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "text", "getText", "setText", "clickAction", "getClickAction", "setClickAction", "clickActionPayload", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickActionPayload", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickActionPayload", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "style", "getStyle", "setStyle", "textStyle", "", "getTextStyle", "()I", "setTextStyle", "(I)V", "toString", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleItemModel implements NonProguard {
    public static final a Companion = null;
    public static final String ITEM_STYLE_DISABLE = "disable";
    public static final String ITEM_STYLE_NORMAL = "normal";
    private String clickAction;
    private ActionPayload clickActionPayload;
    private Icon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216228id;
    private String style;
    private String text;
    private int textStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "SimpleItemModel(id=" + this.f216228id + ", icon=" + this.icon + ", text=" + this.text + ", clickAction=" + this.clickAction + ')';
    }

    public SimpleItemModel() {
        this.style = "normal";
        this.textStyle = 1;
    }

    public final String getClickAction() {
        return this.clickAction;
    }

    public final ActionPayload getClickActionPayload() {
        return this.clickActionPayload;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f216228id;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public final void setClickAction(String r100) {
        this.clickAction = r100;
    }

    public final void setClickActionPayload(ActionPayload r100) {
        this.clickActionPayload = r100;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        this.f216228id = r100;
    }

    public final void setStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.style = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextStyle(int r100) {
        this.textStyle = r100;
    }
}
