package com.larus.platform.uimodel;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003J!\u0010(\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J!\u0010)\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u008f\u0001\u00100\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\t\u00105\u001a\u00020\bHÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R.\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018¨\u00066"}, d2 = {"Lcom/larus/platform/uimodel/MediaEntityContainer;", "Ljava/io/Serializable;", "music_list", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "video_list", "search_id", "", "query", "has_more", "", "offset", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "queryParams", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;)V", "getMusic_list", "()Ljava/util/ArrayList;", "getVideo_list", "getSearch_id", "()Ljava/lang/String;", "setSearch_id", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getHas_more", "()Z", "setHas_more", "(Z)V", "getOffset", "()I", "setOffset", "(I)V", "getLimit", "setLimit", "getQueryParams", "setQueryParams", "mediaList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaEntityContainer implements Serializable {
    private boolean has_more;
    private int limit;

    @SerializedName("music_list")
    private final ArrayList<MediaEntity> music_list;
    private int offset;
    private String query;
    private String queryParams;
    private String search_id;

    @SerializedName("video_list")
    private final ArrayList<MediaEntity> video_list;

    public MediaEntityContainer() {
        this(null, null, null, null, false, 0, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaEntityContainer copy$default(MediaEntityContainer r100, ArrayList r110, ArrayList r111, String r112, String r113, boolean r114, int r115, int r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        ArrayList r101 = r100.music_list;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ArrayList r102 = r100.video_list;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.search_id;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.query;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.has_more;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.offset;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.limit;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.queryParams;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final ArrayList<MediaEntity> component1() {
        return this.music_list;
    }

    public final ArrayList<MediaEntity> component2() {
        return this.video_list;
    }

    public final String component3() {
        return this.search_id;
    }

    public final String component4() {
        return this.query;
    }

    public final boolean component5() {
        return this.has_more;
    }

    public final int component6() {
        return this.offset;
    }

    public final int component7() {
        return this.limit;
    }

    public final String component8() {
        return this.queryParams;
    }

    public final MediaEntityContainer copy(ArrayList<MediaEntity> r110, ArrayList<MediaEntity> r111, String r112, String r113, boolean r114, int r115, int r116, String r117) {
        return new MediaEntityContainer(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaEntityContainer) == true) goto L8;
        return false;
    L8:
        MediaEntityContainer r101 = (MediaEntityContainer) r100;
        if (Intrinsics.areEqual(this.music_list, r101.music_list) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.video_list, r101.video_list) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.search_id, r101.search_id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L21;
        return false;
    L21:
        if (this.has_more == r101.has_more) goto L24;
        return false;
    L24:
        if (this.offset == r101.offset) goto L27;
        return false;
    L27:
        if (this.limit == r101.limit) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.queryParams, r101.queryParams) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        ArrayList<MediaEntity> r100 = this.music_list;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<MediaEntity> r104 = this.video_list;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.search_id;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.query;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.has_more == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (((((r112 + r113) * 31) + this.offset) * 31) + this.limit) * 31;
        String r115 = this.queryParams;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
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
        return "MediaEntityContainer(music_list=" + this.music_list + ", video_list=" + this.video_list + ", search_id=" + this.search_id + ", query=" + this.query + ", has_more=" + this.has_more + ", offset=" + this.offset + ", limit=" + this.limit + ", queryParams=" + this.queryParams + ')';
    }

    public final ArrayList<MediaEntity> mediaList() {
        ArrayList<MediaEntity> r100 = this.video_list;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.music_list;
    }

    public final boolean getHas_more() {
        return this.has_more;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final ArrayList<MediaEntity> getMusic_list() {
        return this.music_list;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getQueryParams() {
        return this.queryParams;
    }

    public final String getSearch_id() {
        return this.search_id;
    }

    public final ArrayList<MediaEntity> getVideo_list() {
        return this.video_list;
    }

    public final void setHas_more(boolean r100) {
        this.has_more = r100;
    }

    public final void setLimit(int r100) {
        this.limit = r100;
    }

    public final void setOffset(int r100) {
        this.offset = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setQueryParams(String r100) {
        this.queryParams = r100;
    }

    public final void setSearch_id(String r100) {
        this.search_id = r100;
    }

    public MediaEntityContainer(ArrayList<MediaEntity> r100, ArrayList<MediaEntity> r101, String r102, String r103, boolean r104, int r105, int r106, String r107) {
        this.music_list = r100;
        this.video_list = r101;
        this.search_id = r102;
        this.query = r103;
        this.has_more = r104;
        this.offset = r105;
        this.limit = r106;
        this.queryParams = r107;
    }

    public /* synthetic */ MediaEntityContainer(ArrayList r110, ArrayList r111, String r112, String r113, boolean r114, int r115, int r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        ArrayList r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ArrayList r102 = null;
    L10:
        String r103 = "";
        if ((r118 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r118 & 8) != 0) goto L18;
        r103 = r113;
    L18:
        int r105 = 0;
        if ((r118 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r118 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = 1;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r103, r106, r105, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
