package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.AnchorV4KolEvaluationBusinessMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b<\u0010=J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0099\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\t\u0010\u001f\u001a\u00020\u000fHÖ\u0001J\t\u0010!\u001a\u00020 HÖ\u0001J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b,\u0010+R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b-\u0010+R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b.\u0010+R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u00104R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u00107R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b8\u00101R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/HeadBusinessMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "component2", "component3", "component4", "component5", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component6", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "component7", "", "", "component8", "component9", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "component10", "video", "link3D", "linkAR", "replayLink", "liveLink", "imageList", "combinationMeta", "accessLabel", "specIdList", "kolMeta", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getLink3D", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getLinkAR", "getReplayLink", "getLiveLink", "Ljava/util/List;", "getImageList", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "getCombinationMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "Ljava/util/Map;", "getAccessLabel", "()Ljava/util/Map;", "getSpecIdList", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "getKolMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadBusinessMeta implements Serializable {

    @SerializedName("access_label")
    private final Map<String, String> accessLabel;

    @SerializedName("combination_meta")
    private final f combinationMeta;

    @SerializedName("image_list")
    private final List<ImageModel> imageList;

    @SerializedName("kol_meta_struct")
    private final AnchorV4KolEvaluationBusinessMeta kolMeta;

    @SerializedName("entry_3d_link")
    private final Link link3D;

    @SerializedName("entry_ar_link")
    private final Link linkAR;

    @SerializedName("live_link")
    private final Link liveLink;

    @SerializedName("replay_link")
    private final Link replayLink;

    @SerializedName("spec_id_list")
    private final List<String> specIdList;

    @SerializedName("video")
    private final VideoModel video;

    public HeadBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeadBusinessMeta copy$default(HeadBusinessMeta r11, VideoModel r12, Link r13, Link r14, Link r15, Link r16, List r17, f r18, Map r19, List r20, AnchorV4KolEvaluationBusinessMeta r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        VideoModel r2 = r11.video;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Link r3 = r11.link3D;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Link r4 = r11.linkAR;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Link r5 = r11.replayLink;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Link r6 = r11.liveLink;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = r11.imageList;
    L27:
        if ((r22 & 64) == 0) goto L29;
        f r8 = r11.combinationMeta;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Map r9 = r11.accessLabel;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = r11.specIdList;
    L39:
        if ((r22 & 512) == 0) goto L41;
        AnchorV4KolEvaluationBusinessMeta r1 = r11.kolMeta;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
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
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final VideoModel component1() {
        return this.video;
    }

    public final AnchorV4KolEvaluationBusinessMeta component10() {
        return this.kolMeta;
    }

    public final Link component2() {
        return this.link3D;
    }

    public final Link component3() {
        return this.linkAR;
    }

    public final Link component4() {
        return this.replayLink;
    }

    public final Link component5() {
        return this.liveLink;
    }

    public final List<ImageModel> component6() {
        return this.imageList;
    }

    public final f component7() {
        return this.combinationMeta;
    }

    public final Map<String, String> component8() {
        return this.accessLabel;
    }

    public final List<String> component9() {
        return this.specIdList;
    }

    public final HeadBusinessMeta copy(VideoModel r13, Link r14, Link r15, Link r16, Link r17, List<ImageModel> r18, f r19, Map<String, String> r20, List<String> r21, AnchorV4KolEvaluationBusinessMeta r22) {
        return new HeadBusinessMeta(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeadBusinessMeta) == false) goto L26;
        HeadBusinessMeta r4 = (HeadBusinessMeta) r3;
        if (Intrinsics.areEqual(this.video, r4.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.link3D, r4.link3D) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.linkAR, r4.linkAR) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replayLink, r4.replayLink) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveLink, r4.liveLink) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imageList, r4.imageList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.combinationMeta, r4.combinationMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.accessLabel, r4.accessLabel) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.specIdList, r4.specIdList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.kolMeta, r4.kolMeta) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        VideoModel r0 = this.video;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Link r4 = this.link3D;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Link r7 = this.linkAR;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Link r10 = this.replayLink;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Link r13 = this.liveLink;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<ImageModel> r16 = this.imageList;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        f r19 = this.combinationMeta;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, String> r22 = this.accessLabel;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.specIdList;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        AnchorV4KolEvaluationBusinessMeta r28 = this.kolMeta;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeadBusinessMeta(video=" + this.video + ", link3D=" + this.link3D + ", linkAR=" + this.linkAR + ", replayLink=" + this.replayLink + ", liveLink=" + this.liveLink + ", imageList=" + this.imageList + ", combinationMeta=" + this.combinationMeta + ", accessLabel=" + this.accessLabel + ", specIdList=" + this.specIdList + ", kolMeta=" + this.kolMeta + ")";
    }

    public final Map<String, String> getAccessLabel() {
        return this.accessLabel;
    }

    public final f getCombinationMeta() {
        return this.combinationMeta;
    }

    public final List<ImageModel> getImageList() {
        return this.imageList;
    }

    public final AnchorV4KolEvaluationBusinessMeta getKolMeta() {
        return this.kolMeta;
    }

    public final Link getLink3D() {
        return this.link3D;
    }

    public final Link getLinkAR() {
        return this.linkAR;
    }

    public final Link getLiveLink() {
        return this.liveLink;
    }

    public final Link getReplayLink() {
        return this.replayLink;
    }

    public final List<String> getSpecIdList() {
        return this.specIdList;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public HeadBusinessMeta(VideoModel r1, Link r2, Link r3, Link r4, Link r5, List<ImageModel> r6, f r7, Map<String, String> r8, List<String> r9, AnchorV4KolEvaluationBusinessMeta r10) {
        this.video = r1;
        this.link3D = r2;
        this.linkAR = r3;
        this.replayLink = r4;
        this.liveLink = r5;
        this.imageList = r6;
        this.combinationMeta = r7;
        this.accessLabel = r8;
        this.specIdList = r9;
        this.kolMeta = r10;
    }

    public /* synthetic */ HeadBusinessMeta(VideoModel r12, Link r13, Link r14, Link r15, Link r16, List r17, f r18, Map r19, List r20, AnchorV4KolEvaluationBusinessMeta r21, int r22, DefaultConstructorMarker r23) {
        AnchorV4KolEvaluationBusinessMeta r2 = null;
        if ((r22 & 1) == 0) goto L5;
        VideoModel r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Link r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Link r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Link r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Link r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        f r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Map r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
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
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
