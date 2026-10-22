package com.bytedance.lark.lark_markdown_render_android;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0010\u0016J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0015\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013HÆ\u0003J\u007f\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013HÆ\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\u0006\u0010J\u001a\u00020KJ\t\u0010L\u001a\u00020\u0014HÖ\u0001R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006M"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "", "documentConfig", "Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;", "headingConfig", "Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;", "codeBlockConfig", "Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "inlineCodeConfig", "Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;", "thematicBreakConfig", "Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "listConfig", "Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "tableConfig", "Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;", "linkConfig", "Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;", "atUsers", "", "", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderAtProperty;", "(Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;Ljava/util/Map;)V", "getAtUsers", "()Ljava/util/Map;", "setAtUsers", "(Ljava/util/Map;)V", "getCodeBlockConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "setCodeBlockConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;)V", "getDocumentConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;", "setDocumentConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;)V", "getHeadingConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;", "setHeadingConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;)V", "getInlineCodeConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;", "setInlineCodeConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;)V", "getLinkConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;", "setLinkConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;)V", "getListConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "setListConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;)V", "getTableConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;", "setTableConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;)V", "getThematicBreakConfig", "()Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "setThematicBreakConfig", "(Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/MovableRenderConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MovableRenderConfig {
    private Map<String, MovableRenderAtProperty> atUsers;
    private CodeBlockConfig codeBlockConfig;
    private DocumentConfig documentConfig;
    private HeadingConfig headingConfig;
    private InlineCodeConfig inlineCodeConfig;
    private LinkConfig linkConfig;
    private ListConfig listConfig;
    private TableConfig tableConfig;
    private ThematicBreakConfig thematicBreakConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovableRenderConfig copy$default(MovableRenderConfig r110, DocumentConfig r111, HeadingConfig r112, CodeBlockConfig r113, InlineCodeConfig r114, ThematicBreakConfig r115, ListConfig r116, TableConfig r117, LinkConfig r118, Map r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        DocumentConfig r100 = r110.documentConfig;
    L7:
        if ((r210 & 2) == 0) goto L9;
        HeadingConfig r101 = r110.headingConfig;
    L11:
        if ((r210 & 4) == 0) goto L13;
        CodeBlockConfig r102 = r110.codeBlockConfig;
    L15:
        if ((r210 & 8) == 0) goto L17;
        InlineCodeConfig r103 = r110.inlineCodeConfig;
    L19:
        if ((r210 & 16) == 0) goto L21;
        ThematicBreakConfig r104 = r110.thematicBreakConfig;
    L23:
        if ((r210 & 32) == 0) goto L25;
        ListConfig r105 = r110.listConfig;
    L27:
        if ((r210 & 64) == 0) goto L29;
        TableConfig r106 = r110.tableConfig;
    L31:
        if ((r210 & 128) == 0) goto L33;
        LinkConfig r107 = r110.linkConfig;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Map r108 = r110.atUsers;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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

    public final DocumentConfig component1() {
        return this.documentConfig;
    }

    public final HeadingConfig component2() {
        return this.headingConfig;
    }

    public final CodeBlockConfig component3() {
        return this.codeBlockConfig;
    }

    public final InlineCodeConfig component4() {
        return this.inlineCodeConfig;
    }

    public final ThematicBreakConfig component5() {
        return this.thematicBreakConfig;
    }

    public final ListConfig component6() {
        return this.listConfig;
    }

    public final TableConfig component7() {
        return this.tableConfig;
    }

    public final LinkConfig component8() {
        return this.linkConfig;
    }

    public final Map<String, MovableRenderAtProperty> component9() {
        return this.atUsers;
    }

    public final MovableRenderConfig copy(DocumentConfig r110, HeadingConfig r111, CodeBlockConfig r112, InlineCodeConfig r113, ThematicBreakConfig r114, ListConfig r115, TableConfig r116, LinkConfig r117, Map<String, MovableRenderAtProperty> r210) {
        Intrinsics.checkNotNullParameter(r210, "atUsers");
        return new MovableRenderConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MovableRenderConfig) == true) goto L8;
        return false;
    L8:
        MovableRenderConfig r101 = (MovableRenderConfig) r100;
        if (Intrinsics.areEqual(this.documentConfig, r101.documentConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headingConfig, r101.headingConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.codeBlockConfig, r101.codeBlockConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inlineCodeConfig, r101.inlineCodeConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thematicBreakConfig, r101.thematicBreakConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.listConfig, r101.listConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tableConfig, r101.tableConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.linkConfig, r101.linkConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.atUsers, r101.atUsers) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        DocumentConfig r100 = this.documentConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HeadingConfig r104 = this.headingConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CodeBlockConfig r107 = this.codeBlockConfig;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        InlineCodeConfig r110 = this.inlineCodeConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ThematicBreakConfig r113 = this.thematicBreakConfig;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ListConfig r116 = this.listConfig;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        TableConfig r119 = this.tableConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        LinkConfig r122 = this.linkConfig;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return ((r121 + r101) * 31) + this.atUsers.hashCode();
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MovableRenderConfig(documentConfig=" + this.documentConfig + ", headingConfig=" + this.headingConfig + ", codeBlockConfig=" + this.codeBlockConfig + ", inlineCodeConfig=" + this.inlineCodeConfig + ", thematicBreakConfig=" + this.thematicBreakConfig + ", listConfig=" + this.listConfig + ", tableConfig=" + this.tableConfig + ", linkConfig=" + this.linkConfig + ", atUsers=" + this.atUsers + ')';
    }

    public final lark_markdown_render.proto.MovableRenderConfig into() {
        DocumentConfig r100 = this.documentConfig;
        lark_markdown_render.proto.LinkConfig r101 = null;
        if (r100 == null) goto L5;
        lark_markdown_render.proto.DocumentConfig r102 = r100.into();
    L6:
        HeadingConfig r103 = this.headingConfig;
        if (r103 == null) goto L9;
        lark_markdown_render.proto.HeadingConfig r104 = r103.into();
    L10:
        CodeBlockConfig r105 = this.codeBlockConfig;
        if (r105 == null) goto L13;
        lark_markdown_render.proto.CodeBlockConfig r106 = r105.into();
    L14:
        InlineCodeConfig r107 = this.inlineCodeConfig;
        if (r107 == null) goto L17;
        lark_markdown_render.proto.InlineCodeConfig r108 = r107.into();
    L18:
        ThematicBreakConfig r109 = this.thematicBreakConfig;
        if (r109 == null) goto L21;
        lark_markdown_render.proto.ThematicBreakConfig r110 = r109.into();
    L22:
        ListConfig r111 = this.listConfig;
        if (r111 == null) goto L25;
        lark_markdown_render.proto.ListConfig r112 = r111.into();
    L26:
        TableConfig r113 = this.tableConfig;
        if (r113 == null) goto L29;
        lark_markdown_render.proto.TableConfig r114 = r113.into();
    L30:
        LinkConfig r115 = this.linkConfig;
        if (r115 == null) goto L33;
        r101 = r115.into();
    L33:
        lark_markdown_render.proto.LinkConfig r116 = r101;
        Map<String, MovableRenderAtProperty> r117 = this.atUsers;
        LinkedHashMap r118 = new LinkedHashMap(MapsKt.mapCapacity(r117.size()));
        Iterator<T> r119 = r117.entrySet().iterator();
    L35:
        if (r119.hasNext() == false) goto L38;
        Map.Entry r120 = (Map.Entry) r119.next();
        r118.put(r120.getKey(), ((MovableRenderAtProperty) r120.getValue()).into());
        goto L35
    L38:
        return new lark_markdown_render.proto.MovableRenderConfig(r102, r104, r106, r108, r110, r112, r114, r116, r118);
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final Map<String, MovableRenderAtProperty> getAtUsers() {
        return this.atUsers;
    }

    public final CodeBlockConfig getCodeBlockConfig() {
        return this.codeBlockConfig;
    }

    public final DocumentConfig getDocumentConfig() {
        return this.documentConfig;
    }

    public final HeadingConfig getHeadingConfig() {
        return this.headingConfig;
    }

    public final InlineCodeConfig getInlineCodeConfig() {
        return this.inlineCodeConfig;
    }

    public final LinkConfig getLinkConfig() {
        return this.linkConfig;
    }

    public final ListConfig getListConfig() {
        return this.listConfig;
    }

    public final TableConfig getTableConfig() {
        return this.tableConfig;
    }

    public final ThematicBreakConfig getThematicBreakConfig() {
        return this.thematicBreakConfig;
    }

    public final void setAtUsers(Map<String, MovableRenderAtProperty> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.atUsers = r100;
    }

    public final void setCodeBlockConfig(CodeBlockConfig r100) {
        this.codeBlockConfig = r100;
    }

    public final void setDocumentConfig(DocumentConfig r100) {
        this.documentConfig = r100;
    }

    public final void setHeadingConfig(HeadingConfig r100) {
        this.headingConfig = r100;
    }

    public final void setInlineCodeConfig(InlineCodeConfig r100) {
        this.inlineCodeConfig = r100;
    }

    public final void setLinkConfig(LinkConfig r100) {
        this.linkConfig = r100;
    }

    public final void setListConfig(ListConfig r100) {
        this.listConfig = r100;
    }

    public final void setTableConfig(TableConfig r100) {
        this.tableConfig = r100;
    }

    public final void setThematicBreakConfig(ThematicBreakConfig r100) {
        this.thematicBreakConfig = r100;
    }

    public MovableRenderConfig(DocumentConfig r100, HeadingConfig r101, CodeBlockConfig r102, InlineCodeConfig r103, ThematicBreakConfig r104, ListConfig r105, TableConfig r106, LinkConfig r107, Map<String, MovableRenderAtProperty> r110) {
        Intrinsics.checkNotNullParameter(r110, "atUsers");
        this.documentConfig = r100;
        this.headingConfig = r101;
        this.codeBlockConfig = r102;
        this.inlineCodeConfig = r103;
        this.thematicBreakConfig = r104;
        this.listConfig = r105;
        this.tableConfig = r106;
        this.linkConfig = r107;
        this.atUsers = r110;
    }
}
