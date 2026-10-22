package com.bytedance.ee.bear.lark.selector;

import com.larksuite.component.ui.avatar.ImageKeyType;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Icon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f227470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f227471b;

        public b() {
            this.f227470a = new ArrayList();
            this.f227471b = new ArrayList();
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public ImageKeyType getImageKeyType() {
        Icon r100 = this.icon;
        if (r100 == null) goto L8;
        int r101 = r100.getType();
        ImageKeyType r102 = ImageKeyType.IMAGE;
        if (r101 != r102.getValue()) goto L8;
        return r102;
    L8:
        return ImageKeyType.UNKOWN;
    }

    public int hashCode() {
        return Objects.hashCode(this.docUrl);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        DocSelectorViewData r101 = (DocSelectorViewData) r100;
        String r102 = this.docUrl;
        if (r102 != null) goto L13;
    L15:
        return false;
    L13:
        if (r102.equals(r101.docUrl) == false) goto L15;
        return true;
    }

    public DocSelectorViewData(b r100, a r101) {
        r100.getClass();
        this.docUrl = null;
        this.ownerId = null;
        this.title = null;
        this.updateTime = 0;
        this.ownerName = null;
        this.spaceName = null;
        this.docType = null;
        this.wikiSubType = null;
        this.nameHitTerms = r100.f227470a;
        this.descHitTerms = r100.f227471b;
        this.isFooter = false;
        this.isShowCrossTenantTag = false;
        this.icon = null;
        this.tagData = null;
    }
}
