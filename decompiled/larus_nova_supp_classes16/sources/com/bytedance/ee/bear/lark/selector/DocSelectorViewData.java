package com.bytedance.ee.bear.lark.selector;

import com.larksuite.component.ui.avatar.ImageKeyType;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Icon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSelectorViewData implements Serializable {
    public final List<String> descHitTerms;
    public final DocType docType;
    public final String docUrl;
    public final Icon icon;
    public final boolean isFooter;
    public final boolean isShowCrossTenantTag;
    public final List<String> nameHitTerms;
    public final String ownerId;
    public final String ownerName;
    public final String spaceName;
    public final TagData tagData;
    public final String title;
    public final long updateTime;
    public final DocType wikiSubType;

    public static /* synthetic */ class a {
    }

    public static final class b {
        public List<String> a;
        public List<String> b;

        public b() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public ImageKeyType getImageKeyType() {
        Icon r0 = this.icon;
        if (r0 == null) goto L8;
        int r1 = r0.getType();
        ImageKeyType r2 = ImageKeyType.IMAGE;
        if (r1 != r2.getValue()) goto L8;
        return r2;
    L8:
        return ImageKeyType.UNKOWN;
    }

    public int hashCode() {
        return Objects.hashCode(this.docUrl);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        DocSelectorViewData r6 = (DocSelectorViewData) r5;
        String r2 = this.docUrl;
        if (r2 != null) goto L13;
    L15:
        return false;
    L13:
        if (r2.equals(r6.docUrl) == false) goto L15;
        return true;
    }

    public DocSelectorViewData(b r3, a r4) {
        r3.getClass();
        this.docUrl = null;
        this.ownerId = null;
        this.title = null;
        this.updateTime = 0;
        this.ownerName = null;
        this.spaceName = null;
        this.docType = null;
        this.wikiSubType = null;
        this.nameHitTerms = r3.a;
        this.descHitTerms = r3.b;
        this.isFooter = false;
        this.isShowCrossTenantTag = false;
        this.icon = null;
        this.tagData = null;
    }
}
