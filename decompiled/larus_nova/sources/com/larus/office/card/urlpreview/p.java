package com.larus.office.card.urlpreview;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f362001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f362002b = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewBizExt$Payload;", "", "version", "", "items", "", "", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewBizExt$StoredItem;", "<init>", "(ILjava/util/Map;)V", "getVersion", "()I", "getItems", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("items")
        private final Map<String, b> items;

        @SerializedName("version")
        private final int version;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.version == r101.version) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.version * 31;
            Map<String, b> r101 = this.items;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Payload(version=" + this.version + ", items=" + this.items + ')';
        }

        public final Map<String, b> a() {
            return this.items;
        }

        public final int b() {
            return this.version;
        }

        public /* synthetic */ a(int r100) {
            this(1, MapsKt.emptyMap());
        }

        public a(int r100, Map<String, b> r101) {
            this.version = r100;
            this.items = r101;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewBizExt$StoredItem;", "", "previewId", "", "needLocalPreview", "", "url", "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getPreviewId", "()Ljava/lang/String;", "getNeedLocalPreview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "getResourceId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/office/card/urlpreview/OfficeUrlPreviewBizExt$StoredItem;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("need_local_preview")
        private final Boolean needLocalPreview;

        @SerializedName("preview_id")
        private final String previewId;

        @SerializedName("resource_id")
        private final String resourceId;

        @SerializedName("url")
        private final String url;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.previewId, r101.previewId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.needLocalPreview, r101.needLocalPreview) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.previewId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.needLocalPreview;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.url;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.resourceId;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
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

        public final String toString() {
            return "StoredItem(previewId=" + this.previewId + ", needLocalPreview=" + this.needLocalPreview + ", url=" + this.url + ", resourceId=" + this.resourceId + ')';
        }

        public b() {
            this(null, Boolean.FALSE, null, null);
        }

        public final Boolean a() {
            return this.needLocalPreview;
        }

        public final String b() {
            return this.previewId;
        }

        public final String c() {
            return this.resourceId;
        }

        public final String d() {
            return this.url;
        }

        public b(String r100, Boolean r101, String r102, String r103) {
            this.previewId = r100;
            this.needLocalPreview = r101;
            this.url = r102;
            this.resourceId = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z0 f362003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f362004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f362005c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f362003a, r101.f362003a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362004b, r101.f362004b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f362005c, r101.f362005c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f362003a.hashCode() * 31) + this.f362004b.hashCode()) * 31) + this.f362005c.hashCode();
        }

        public final String toString() {
            return "StoredPreview(previewInfo=" + this.f362003a + ", url=" + this.f362004b + ", resourceId=" + this.f362005c + ')';
        }

        public c(z0 r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "previewInfo");
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "resourceId");
            this.f362003a = r100;
            this.f362004b = r101;
            this.f362005c = r102;
        }
    }

    public p() {
    }

    static {
        f362001a = new p();
        f362002b = new Gson();
    }
}
