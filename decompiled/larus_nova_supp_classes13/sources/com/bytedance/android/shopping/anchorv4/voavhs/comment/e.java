package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends VOIdentifier {
    public static final /* synthetic */ int e = 0;
    public AnchorV4CommentDisplay b;
    public AnchorV4CommentMeta c;
    public ComponentDTO d;

    public static final class a {
        public static void a(AnchorV4CommentDisplay r6) {
            if (r6 == null) goto L39;
            MediaScrollBoxComponent r0 = r6.getCommentMedias();
            if (r0 == null) goto L15;
            List r1 = r0.getMedias();
            if (r1 == null) goto L15;
            Iterator r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L15;
            MediaBoxElement r3 = (MediaBoxElement) r2.next();
            if (r3 == null) goto L9;
            ImageModel r4 = r3.getImageModel();
            if (r4 == null) goto L9;
            int r5 = e.e;
            r4.setImageMonitorMeta(new ImageMonitorMeta("ec_detail", "ec_comments_content_image"));
        L15:
            MediaScrollBoxComponent r7 = r6.getBuyersShowMedias();
            if (r7 == null) goto L27;
            List r8 = r7.getMedias();
            if (r8 == null) goto L27;
            Iterator r9 = r8.iterator();
        L21:
            if (r9.hasNext() == false) goto L27;
            MediaBoxElement r10 = (MediaBoxElement) r9.next();
            if (r10 == null) goto L21;
            ImageModel r11 = r10.getImageModel();
            if (r11 == null) goto L21;
            int r12 = e.e;
            r11.setImageMonitorMeta(new ImageMonitorMeta("ec_detail", "ec_comments_content_image"));
        L27:
            TagsScrollBoxComponent r13 = r6.getCommentUser();
            if (r13 == null) goto L61;
            List r14 = r13.getButtonList();
            if (r14 == null) goto L62;
            Iterator r15 = r14.iterator();
        L33:
            if (r15.hasNext() == false) goto L63;
            TextWithOneIconElement r16 = (TextWithOneIconElement) r15.next();
            if (r16 == null) goto L33;
            ImageModel r17 = r16.getIcon();
            if (r17 == null) goto L33;
            r17.setImageMonitorMeta(new ImageMonitorMeta("ec_detail", "ec_comments_avatar_image"));
            goto L33
        L63:
            return;
        L62:
            return;
        L61:
            return;
        }

        public static e b(ComponentDTO r4) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
            e r2 = new e(0);     // Catch: Throwable -> L13
            VO r3 = r4.getVo();     // Catch: Throwable -> L13
            if (r3 == null) goto L6;
            JsonObject r5 = r3.getDisplay();     // Catch: Throwable -> L13
        L7:
            r2.b = (AnchorV4CommentDisplay) u0.a(r5, AnchorV4CommentDisplay.class);     // Catch: Throwable -> L13
            VO r6 = r4.getVo();     // Catch: Throwable -> L13
            if (r6 == null) goto L10;
            JsonObject r7 = r6.getMeta();     // Catch: Throwable -> L13
        L11:
            r2.c = (AnchorV4CommentMeta) u0.a(r7, AnchorV4CommentMeta.class);     // Catch: Throwable -> L13
            r2.d = r4;     // Catch: Throwable -> L13
            a(r2.b);     // Catch: Throwable -> L13
            Object r8 = Result.constructor-impl(r2);     // Catch: Throwable -> L13
        L16:
            if (Result.isFailure-impl(r8) == true) goto L20;
            r0 = r8;
        L20:
            return (e) r0;
        L10:
            r7 = null;
            goto L11
        L6:
            r5 = null;
        L13:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
    }

    public e() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AnchorV4CommentDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4CommentMeta r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ComponentDTO r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4CommentVO(display=" + this.b + ", meta=" + this.c + ", component=" + this.d + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.getComponentId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public e(int r2) {
        this.b = null;
        this.c = null;
        this.d = null;
        scrollConfig(ComponentIDs.COMMENTS.getId(), AnchorV4TabArea.j);
    }
}
