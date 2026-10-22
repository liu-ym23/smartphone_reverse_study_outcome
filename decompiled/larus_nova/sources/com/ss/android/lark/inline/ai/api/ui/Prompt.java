package com.ss.android.lark.inline.ai.api.ui;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\b\u00105\u001a\u00020\u0003H\u0016J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\u001d\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0097\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010C\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006G"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Prompt;", "Ljava/io/Serializable;", "type", "", "id", "key", ThumbGlideUrl.SOURCE_TEMPLATE, "icon", "", "text", "i18nKey", "originText", "rightArrow", "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extras", "localId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getId", "setId", "getKey", "setKey", "getTemplate", "setTemplate", "getIcon", "()I", "setIcon", "(I)V", "getText", "setText", "getI18nKey", "setI18nKey", "getOriginText", "setOriginText", "getRightArrow", "()Z", "setRightArrow", "(Z)V", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getExtras", "setExtras", "getLocalId", "setLocalId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Prompt implements Serializable {
    private String extras;
    private String i18nKey;
    private int icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f426842id;
    private String key;
    private String localId;
    private String originText;
    private ArrayList<String> params;
    private boolean rightArrow;
    private String template;
    private String text;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Prompt copy$default(Prompt r110, String r111, String r112, String r113, String r114, int r115, String r116, String r210, String r211, boolean r212, ArrayList r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.type;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.f426842id;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.key;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.template;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r104 = r110.icon;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.text;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.i18nKey;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.originText;
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r117 = r110.rightArrow;
    L39:
        if ((r216 & 512) == 0) goto L41;
        ArrayList r118 = r110.params;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.extras;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.localId;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<String> component10() {
        return this.params;
    }

    public final String component11() {
        return this.extras;
    }

    public final String component12() {
        return this.localId;
    }

    public final String component2() {
        return this.f426842id;
    }

    public final String component3() {
        return this.key;
    }

    public final String component4() {
        return this.template;
    }

    public final int component5() {
        return this.icon;
    }

    public final String component6() {
        return this.text;
    }

    public final String component7() {
        return this.i18nKey;
    }

    public final String component8() {
        return this.originText;
    }

    public final boolean component9() {
        return this.rightArrow;
    }

    public final Prompt copy(String r110, String r111, String r112, String r113, int r114, String r210, String r211, String r212, boolean r213, ArrayList<String> r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "id");
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r113, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r210, "text");
        Intrinsics.checkNotNullParameter(r211, "i18nKey");
        Intrinsics.checkNotNullParameter(r212, "originText");
        Intrinsics.checkNotNullParameter(r216, "localId");
        return new Prompt(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Prompt) == true) goto L8;
        return false;
    L8:
        Prompt r101 = (Prompt) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426842id, r101.f426842id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L21;
        return false;
    L21:
        if (this.icon == r101.icon) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.i18nKey, r101.i18nKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originText, r101.originText) == true) goto L33;
        return false;
    L33:
        if (this.rightArrow == r101.rightArrow) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.extras, r101.extras) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.localId, r101.localId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((this.type.hashCode() * 31) + this.f426842id.hashCode()) * 31) + this.key.hashCode()) * 31) + this.template.hashCode()) * 31) + this.icon) * 31) + this.text.hashCode()) * 31) + this.i18nKey.hashCode()) * 31) + this.originText.hashCode()) * 31;
        if (this.rightArrow == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        ArrayList<String> r103 = this.params;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.extras;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return ((r106 + r104) * 31) + this.localId.hashCode();
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "Prompt(type='" + this.type + "', id='" + this.f426842id + "', key='" + this.key + "', template='" + this.template + "', icon=" + this.icon + ", text='" + this.text + "', i18nKey='" + this.i18nKey + "', originText='" + this.originText + "', rightArrow=" + this.rightArrow + ", extras=" + this.extras + ')';
    }

    public final String getExtras() {
        return this.extras;
    }

    public final String getI18nKey() {
        return this.i18nKey;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f426842id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocalId() {
        return this.localId;
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

    public final void setExtras(String r100) {
        this.extras = r100;
    }

    public final void setI18nKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.i18nKey = r100;
    }

    public final void setIcon(int r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f426842id = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setLocalId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.localId = r100;
    }

    public final void setOriginText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originText = r100;
    }

    public final void setParams(ArrayList<String> r100) {
        this.params = r100;
    }

    public final void setRightArrow(boolean r100) {
        this.rightArrow = r100;
    }

    public final void setTemplate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.template = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public Prompt(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, boolean r110, ArrayList<String> r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r105, "text");
        Intrinsics.checkNotNullParameter(r106, "i18nKey");
        Intrinsics.checkNotNullParameter(r107, "originText");
        Intrinsics.checkNotNullParameter(r113, "localId");
        this.type = r100;
        this.f426842id = r101;
        this.key = r102;
        this.template = r103;
        this.icon = r104;
        this.text = r105;
        this.i18nKey = r106;
        this.originText = r107;
        this.rightArrow = r110;
        this.params = r111;
        this.extras = r112;
        this.localId = r113;
    }

    public /* synthetic */ Prompt(String r110, String r111, String r112, String r210, int r211, String r212, String r213, String r214, boolean r215, ArrayList r216, String r217, String r218, int r219, DefaultConstructorMarker r310) {
        if ((r219 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r219 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r219 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r219 & 64) == 0) goto L17;
        String r113 = "";
    L19:
        if ((r219 & 512) == 0) goto L21;
        ArrayList r114 = null;
    L23:
        if ((r219 & 1024) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r219 & 2048) == 0) goto L29;
        String r116 = "";
    L30:
        this(r100, r111, r101, r102, r211, r212, r113, r214, r215, r114, r115, r116);
        return;
    L29:
        r116 = r218;
        goto L30
    L25:
        r115 = r217;
        goto L27
    L21:
        r114 = r216;
        goto L23
    L17:
        r113 = r213;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
