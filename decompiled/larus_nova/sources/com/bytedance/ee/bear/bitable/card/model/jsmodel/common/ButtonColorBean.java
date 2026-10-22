package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR:\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "styles", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean$ButtonColorBeanStyle;", "Lkotlin/collections/HashMap;", "getStyles", "()Ljava/util/HashMap;", "setStyles", "(Ljava/util/HashMap;)V", "ButtonColorBeanStyle", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonColorBean implements NonProguard {
    public static final a Companion = null;
    public static final String StateActive = "active";
    public static final String StateDefault = "default";
    public static final String StateDisable = "disable";
    public static final String StateDone = "done";
    public static final String StateFocus = "focus";
    public static final String StateLoading = "loading";

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f207116id;
    private String name;
    private HashMap<String, ButtonColorBeanStyle> styles;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean$ButtonColorBeanStyle;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ButtonColorBeanStyle implements NonProguard {
        private String bgColor;
        private String textColor;

        public ButtonColorBeanStyle() {
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final void setBgColor(String r100) {
            this.bgColor = r100;
        }

        public final void setTextColor(String r100) {
            this.textColor = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ButtonColorBean() {
    }

    public final int getId() {
        return this.f207116id;
    }

    public final String getName() {
        return this.name;
    }

    public final HashMap<String, ButtonColorBeanStyle> getStyles() {
        return this.styles;
    }

    public final void setId(int r100) {
        this.f207116id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setStyles(HashMap<String, ButtonColorBeanStyle> r100) {
        this.styles = r100;
    }
}
