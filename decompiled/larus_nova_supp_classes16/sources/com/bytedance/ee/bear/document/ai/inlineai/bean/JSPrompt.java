package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010/\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSPrompt;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "id", "getId", "setId", "key", "getKey", "setKey", "template", "getTemplate", "setTemplate", CustomHeaderConfig.Menu.Style.ICON_STYLE, "getIcon", "setIcon", "text", "getText", "setText", "i18nKey", "getI18nKey", "setI18nKey", "originText", "getOriginText", "setOriginText", "rightArrow", "", "getRightArrow", "()Z", "setRightArrow", "(Z)V", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "extras", "getExtras", "setExtras", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSPrompt implements NonProguard {
    private String extras;
    private String i18nKey;
    private String icon;
    private String id;
    private String key;
    private String originText;
    private ArrayList<String> params;
    private boolean rightArrow;
    private String template;
    private String text;
    private String type;

    public JSPrompt() {
    }

    public String toString() {
        return "JSPrompt(type=" + this.type + ", id=" + this.id + ", key=" + this.key + ", template=" + this.template + ", icon=" + this.icon + ", text=" + this.text + ",  i18nKey=" + this.i18nKey + ", originText=" + this.originText + ", rightArrow=" + this.rightArrow + ", extras=" + this.extras + ')';
    }

    public final String getExtras() {
        return this.extras;
    }

    public final String getI18nKey() {
        return this.i18nKey;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getOriginText() {
        return this.originText;
    }

    public final ArrayList<String> getParams() {
        return this.params;
    }

    public final boolean getRightArrow() {
        return this.rightArrow;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    public final void setI18nKey(String r1) {
        this.i18nKey = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setOriginText(String r1) {
        this.originText = r1;
    }

    public final void setParams(ArrayList<String> r1) {
        this.params = r1;
    }

    public final void setRightArrow(boolean r1) {
        this.rightArrow = r1;
    }

    public final void setTemplate(String r1) {
        this.template = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }
}
