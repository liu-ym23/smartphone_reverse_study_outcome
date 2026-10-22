package com.larus.share.service;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/share/service/ShareShortUrlCreateResponse;", "", "items", "", "Lcom/larus/share/service/ShareShortUrlItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "shortUrls", "", "getShortUrls", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareShortUrlCreateResponse {
    private static final a Companion = null;
    public static final int SHORT_URL_STATUS_SUCCESS = 0;

    @SerializedName("items")
    private final List<ShareShortUrlItem> items;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareShortUrlCreateResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareShortUrlCreateResponse copy$default(ShareShortUrlCreateResponse r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        return r100.copy(r101);
    }

    public final List<ShareShortUrlItem> component1() {
        return this.items;
    }

    public final ShareShortUrlCreateResponse copy(List<ShareShortUrlItem> r100) {
        return new ShareShortUrlCreateResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareShortUrlCreateResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.items, ((ShareShortUrlCreateResponse) r100).items) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ShareShortUrlItem> r100 = this.items;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ShareShortUrlCreateResponse(items=" + this.items + ')';
    }

    public final List<String> getShortUrls() {
        List<ShareShortUrlItem> r100 = this.items;
        if (r100 == null) goto L41;
        List<ShareShortUrlItem> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L37;
        ShareShortUrlItem r104 = (ShareShortUrlItem) r103.next();
        if (r104 == null) goto L10;
        String r105 = r104.getShortUrl();
    L11:
        boolean r106 = true;
        if (r104 == null) goto L19;
        Integer r107 = r104.getStatus();
        if (r107 == null) goto L19;
        if (r107.intValue() != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L29;
        if (r105 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == true) goto L29;
    L30:
        if (r106 == true) goto L33;
        r105 = null;
    L33:
        if (r105 != null) goto L35;
        r105 = "";
    L35:
        r102.add(r105);
        goto L6
    L23:
        if (StringsKt.isBlank(r105) == true) goto L26;
        r109 = false;
    L29:
        r106 = false;
    L19:
        r108 = false;
        goto L20
    L10:
        r105 = null;
        goto L11
    L37:
        return r102;
    L41:
        return null;
    }

    public final List<ShareShortUrlItem> getItems() {
        return this.items;
    }

    public ShareShortUrlCreateResponse(List<ShareShortUrlItem> r100) {
        this.items = r100;
    }

    public /* synthetic */ ShareShortUrlCreateResponse(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
