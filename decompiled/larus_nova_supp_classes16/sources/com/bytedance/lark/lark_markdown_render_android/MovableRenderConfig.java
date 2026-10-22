package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static /* synthetic */ MovableRenderConfig copy$default(MovableRenderConfig r10, DocumentConfig r11, HeadingConfig r12, CodeBlockConfig r13, InlineCodeConfig r14, ThematicBreakConfig r16, ListConfig r17, TableConfig r18, LinkConfig r19, Map r110, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        DocumentConfig r2 = r10.documentConfig;
    L7:
        if ((r20 & 2) == 0) goto L9;
        HeadingConfig r3 = r10.headingConfig;
    L11:
        if ((r20 & 4) == 0) goto L13;
        CodeBlockConfig r4 = r10.codeBlockConfig;
    L15:
        if ((r20 & 8) == 0) goto L17;
        InlineCodeConfig r5 = r10.inlineCodeConfig;
    L19:
        if ((r20 & 16) == 0) goto L21;
        ThematicBreakConfig r6 = r10.thematicBreakConfig;
    L23:
        if ((r20 & 32) == 0) goto L25;
        ListConfig r7 = r10.listConfig;
    L27:
        if ((r20 & 64) == 0) goto L29;
        TableConfig r8 = r10.tableConfig;
    L31:
        if ((r20 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        LinkConfig r9 = r10.linkConfig;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Map r1 = r10.atUsers;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r110;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final MovableRenderConfig copy(DocumentConfig r12, HeadingConfig r13, CodeBlockConfig r14, InlineCodeConfig r16, ThematicBreakConfig r17, ListConfig r18, TableConfig r19, LinkConfig r110, Map<String, MovableRenderAtProperty> r20) {
        Intrinsics.checkNotNullParameter(r20, "atUsers");
        return new MovableRenderConfig(r12, r13, r14, r16, r17, r18, r19, r110, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MovableRenderConfig) == true) goto L8;
        return false;
    L8:
        MovableRenderConfig r6 = (MovableRenderConfig) r5;
        if (Intrinsics.areEqual(this.documentConfig, r6.documentConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headingConfig, r6.headingConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.codeBlockConfig, r6.codeBlockConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inlineCodeConfig, r6.inlineCodeConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thematicBreakConfig, r6.thematicBreakConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.listConfig, r6.listConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tableConfig, r6.tableConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.linkConfig, r6.linkConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.atUsers, r6.atUsers) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        DocumentConfig r0 = this.documentConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HeadingConfig r4 = this.headingConfig;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CodeBlockConfig r7 = this.codeBlockConfig;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        InlineCodeConfig r10 = this.inlineCodeConfig;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ThematicBreakConfig r13 = this.thematicBreakConfig;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        ListConfig r17 = this.listConfig;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        TableConfig r20 = this.tableConfig;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        LinkConfig r23 = this.linkConfig;
        if (r23 == null) goto L35;
        r1 = r23.hashCode();
    L35:
        return ((r22 + r1) * 31) + this.atUsers.hashCode();
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MovableRenderConfig(documentConfig=" + this.documentConfig + ", headingConfig=" + this.headingConfig + ", codeBlockConfig=" + this.codeBlockConfig + ", inlineCodeConfig=" + this.inlineCodeConfig + ", thematicBreakConfig=" + this.thematicBreakConfig + ", listConfig=" + this.listConfig + ", tableConfig=" + this.tableConfig + ", linkConfig=" + this.linkConfig + ", atUsers=" + this.atUsers + ')';
    }

    public final lark_markdown_render.proto.MovableRenderConfig into() {
        DocumentConfig r0 = this.documentConfig;
        lark_markdown_render.proto.LinkConfig r1 = null;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.DocumentConfig r3 = r0.into();
    L6:
        HeadingConfig r2 = this.headingConfig;
        if (r2 == null) goto L9;
        lark_markdown_render.proto.HeadingConfig r4 = r2.into();
    L10:
        CodeBlockConfig r5 = this.codeBlockConfig;
        if (r5 == null) goto L13;
        lark_markdown_render.proto.CodeBlockConfig r6 = r5.into();
    L14:
        InlineCodeConfig r7 = this.inlineCodeConfig;
        if (r7 == null) goto L17;
        lark_markdown_render.proto.InlineCodeConfig r8 = r7.into();
    L18:
        ThematicBreakConfig r9 = this.thematicBreakConfig;
        if (r9 == null) goto L21;
        lark_markdown_render.proto.ThematicBreakConfig r10 = r9.into();
    L22:
        ListConfig r11 = this.listConfig;
        if (r11 == null) goto L25;
        lark_markdown_render.proto.ListConfig r12 = r11.into();
    L26:
        TableConfig r13 = this.tableConfig;
        if (r13 == null) goto L29;
        lark_markdown_render.proto.TableConfig r14 = r13.into();
    L30:
        LinkConfig r16 = this.linkConfig;
        if (r16 == null) goto L33;
        r1 = r16.into();
    L33:
        lark_markdown_render.proto.LinkConfig r17 = r1;
        Map<String, MovableRenderAtProperty> r18 = this.atUsers;
        LinkedHashMap r19 = new LinkedHashMap(MapsKt.mapCapacity(r18.size()));
        Iterator<T> r20 = r18.entrySet().iterator();
    L35:
        if (r20.hasNext() == false) goto L38;
        Map.Entry r21 = (Map.Entry) r20.next();
        r19.put(r21.getKey(), ((MovableRenderAtProperty) r21.getValue()).into());
        goto L35
    L38:
        return new lark_markdown_render.proto.MovableRenderConfig(r3, r4, r6, r8, r10, r12, r14, r17, r19);
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
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

    public final void setAtUsers(Map<String, MovableRenderAtProperty> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.atUsers = r2;
    }

    public final void setCodeBlockConfig(CodeBlockConfig r1) {
        this.codeBlockConfig = r1;
    }

    public final void setDocumentConfig(DocumentConfig r1) {
        this.documentConfig = r1;
    }

    public final void setHeadingConfig(HeadingConfig r1) {
        this.headingConfig = r1;
    }

    public final void setInlineCodeConfig(InlineCodeConfig r1) {
        this.inlineCodeConfig = r1;
    }

    public final void setLinkConfig(LinkConfig r1) {
        this.linkConfig = r1;
    }

    public final void setListConfig(ListConfig r1) {
        this.listConfig = r1;
    }

    public final void setTableConfig(TableConfig r1) {
        this.tableConfig = r1;
    }

    public final void setThematicBreakConfig(ThematicBreakConfig r1) {
        this.thematicBreakConfig = r1;
    }

    public MovableRenderConfig(DocumentConfig r2, HeadingConfig r3, CodeBlockConfig r4, InlineCodeConfig r5, ThematicBreakConfig r6, ListConfig r7, TableConfig r8, LinkConfig r9, Map<String, MovableRenderAtProperty> r10) {
        Intrinsics.checkNotNullParameter(r10, "atUsers");
        this.documentConfig = r2;
        this.headingConfig = r3;
        this.codeBlockConfig = r4;
        this.inlineCodeConfig = r5;
        this.thematicBreakConfig = r6;
        this.listConfig = r7;
        this.tableConfig = r8;
        this.linkConfig = r9;
        this.atUsers = r10;
    }
}
