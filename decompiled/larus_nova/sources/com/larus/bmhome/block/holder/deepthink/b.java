package com.larus.bmhome.block.holder.deepthink;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.markdown.reference.AbsSearchResultBlockWidget;
import com.larus.bmhome.chat.markdown.reference.MarkdownReferenceWidget;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactOPBlock;
import com.larus.im.bean.message.block.ArtifactOPStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends jc8.b<gb8.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kc8.b f296248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MarkdownReferenceWidget f296249e;

    public static final class a {
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "ArtifactOpBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownReferenceWidget r100 = this.f296249e;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    public b() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        gb8.a r101 = (gb8.a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return j0.a(this.f498153a, r101);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.block.holder.deepthink.a] */
    @Override // jc8.b
    public final void g(jc8.a r210) {
        final gb8.a r100 = (gb8.a) r210;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        this.f296248d = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r101 = r100.f498145a.getContent();
        if (r101 == null) goto L87;
        final ArtifactOPBlock r102 = r101.getArtifactOpBlock();
        if (r102 == null) goto L91;
        cd8.a r103 = (cd8.a) jc8.c.a(this, cd8.a.class);
        final boolean r104 = false;
        if (r103 == null) goto L10;
        int r105 = r103.f23411a;
    L11:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("onBindBlockView title=");
        DisplayHeader r108 = r102.getHeader();
        ViewGroup.MarginLayoutParams r110 = null;
        if (r108 == null) goto L14;
        String r109 = r108.getSummary();
    L15:
        r107.append(r109);
        r106.d("ArtifactOpBlockHolder", r107.toString());
        kc8.b r111 = (kc8.b) jc8.c.a(this, kc8.b.class);
        ArtifactBlock r112 = r102.getArtifact();
        if (r112 == null) goto L20;
        Integer r113 = r112.getResourceType();
        if (r113 == null) goto L20;
        int r114 = r113.intValue();
    L22:
        if (r114 != 12) goto L24;
    L26:
        r104 = true;
    L27:
        MarkdownReferenceWidget r115 = this.f296249e;
        if (r115 == null) goto L88;
        DisplayHeader r116 = r102.getHeader();
        if (r116 == null) goto L35;
        String r117 = r116.getSummary();
        if (r117 == null) goto L35;
        String r118 = r117;
    L36:
        DisplayHeader r119 = r102.getHeader();
        if (r119 == null) goto L42;
        String r120 = r119.getSummary();
        if (r120 == null) goto L42;
        String r121 = r120;
    L43:
        Integer r122 = r102.getStatus();
        int r123 = ArtifactOPStatus.SUCCEED.getValue();
        if (r122 != null) goto L47;
    L48:
        Integer r124 = r102.getStatus();
        int r125 = ArtifactOPStatus.FAILED.getValue();
        if (r124 != null) goto L52;
    L54:
        int r126 = Stage.Searching.getValue();
    L56:
        Integer r211 = Integer.valueOf(r126);
        DisplayHeader r127 = r102.getHeader();
        if (r127 == null) goto L59;
        String r212 = r127.getIconUrl();
    L60:
        DisplayHeader r128 = r102.getHeader();
        if (r128 == null) goto L63;
        String r213 = r128.getIconUrlDark();
    L64:
        SearchReferenceData r129 = new SearchReferenceData(r118, null, null, r121, r211, null, r212, r213, ToolType.SearchPlugin.getValue(), true, 38, null);
        fh8.f r130 = z3.a(r111, r100.j()).a();
        if (r111 == null) goto L69;
        kc8.p r131 = r111.f502429e;
        if (r131 == null) goto L69;
        Integer r132 = Integer.valueOf(r131.f502539a);
    L70:
        Size r133 = AbsSearchResultBlockWidget.h(r115, r129, r105, r130, r132, Boolean.valueOf(r104), null, new com.larus.bmhome.block.holder.deepthink.a(r102, this, r104, r100), 32);
        if (r133 == null) goto L89;
        MarkdownReferenceWidget r134 = this.f296249e;
        if (r134 == null) goto L75;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
    L77:
        if ((r135 instanceof ViewGroup.MarginLayoutParams) == false) goto L79;
        r110 = (ViewGroup.MarginLayoutParams) r135;
    L79:
        if (r110 == null) goto L81;
        r110.width = r133.getWidth();
    L81:
        if (r110 == null) goto L83;
        r110.height = r133.getHeight();
    L83:
        MarkdownReferenceWidget r136 = this.f296249e;
        if (r136 == null) goto L90;
        r136.setLayoutParams(r110);
        return;
    L90:
        return;
    L75:
        r135 = null;
        goto L77
    L89:
        return;
    L69:
        r132 = null;
        goto L70
    L63:
        r213 = null;
        goto L64
    L59:
        r212 = null;
        goto L60
    L52:
        if (r124.intValue() != r125) goto L54;
    L55:
        r126 = Stage.Searched.getValue();
        goto L56
    L47:
        if (r122.intValue() == r123) goto L55;
    L42:
        r121 = "";
    L35:
        r118 = "";
        goto L36
    L88:
        return;
    L24:
        if (r114 == 5) goto L26;
        if (r114 != 0) goto L27;
    L20:
        r114 = 0;
        goto L22
    L14:
        r109 = null;
        goto L15
    L10:
        r105 = 0;
        goto L11
    L91:
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        MarkdownReferenceWidget r101 = new MarkdownReferenceWidget(r100.getContext(), null);
        this.f296249e = r101;
        return r101;
    }
}
