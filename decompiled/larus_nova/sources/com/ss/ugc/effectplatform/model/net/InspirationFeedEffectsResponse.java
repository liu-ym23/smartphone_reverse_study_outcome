package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.AuthorModel;
import com.ss.ugc.effectplatform.model.AuthorThumbModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.InspirationFeedEffectModel;
import com.ss.ugc.effectplatform.model.InspirationModel;
import com.ss.ugc.effectplatform.model.MaterialModel;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.model.VideoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0081\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005¢\u0006\u0004\b/\u00100J\u001d\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005HÂ\u0003J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000f\u001a\u00020\nHÆ\u0003J\t\u0010\u0010\u001a\u00020\nHÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R*\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010.¨\u00061"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/InspirationFeedEffectsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "component5", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "Lcom/ss/ugc/effectplatform/model/InspirationFeedEffectModel;", "component1", "component2", "component3", "component4", "inspiration_awemes", "message", "status_code", "has_more", "effectList", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getInspiration_awemes", "()Ljava/util/List;", "setInspiration_awemes", "(Ljava/util/List;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "getHas_more", "setHas_more", "Ljava/util/ArrayList;", "<init>", "(Ljava/util/List;Ljava/lang/String;IILjava/util/ArrayList;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class InspirationFeedEffectsResponse extends e<List<? extends Effect>> {
    private ArrayList<Effect> effectList;
    private int has_more;
    private List<InspirationFeedEffectModel> inspiration_awemes;
    private String message;
    private int status_code;

    public InspirationFeedEffectsResponse() {
        this(null, null, 0, 0, null, 31, null);
    }

    private final ArrayList<Effect> component5() {
        return this.effectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InspirationFeedEffectsResponse copy$default(InspirationFeedEffectsResponse r100, List r101, String r102, int r103, int r104, ArrayList r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.inspiration_awemes;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.message;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.status_code;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.has_more;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.effectList;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<InspirationFeedEffectModel> component1() {
        return this.inspiration_awemes;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final int component4() {
        return this.has_more;
    }

    public final InspirationFeedEffectsResponse copy(List<InspirationFeedEffectModel> r100, String r101, int r110, int r111, ArrayList<Effect> r112) {
        return new InspirationFeedEffectsResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InspirationFeedEffectsResponse) == false) goto L16;
        InspirationFeedEffectsResponse r101 = (InspirationFeedEffectsResponse) r100;
        if (Intrinsics.areEqual(this.inspiration_awemes, r101.inspiration_awemes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L12;
        return false;
    L12:
        if (this.has_more == r101.has_more) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.effectList, r101.effectList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<InspirationFeedEffectModel> r100 = this.inspiration_awemes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.status_code) * 31) + this.has_more) * 31;
        ArrayList<Effect> r107 = this.effectList;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationFeedEffectsResponse(inspiration_awemes=" + this.inspiration_awemes + ", message=" + this.message + ", status_code=" + this.status_code + ", has_more=" + this.has_more + ", effectList=" + this.effectList + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    /* JADX INFO: renamed from: getResponseData, reason: avoid collision after fix types in other method */
    public List<? extends Effect> getResponseData2() {
        ArrayList<Effect> r100 = this.effectList;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        this.effectList = new ArrayList();
        List<InspirationFeedEffectModel> r102 = this.inspiration_awemes;
        if (r102 == null) goto L51;
        Iterator<T> r103 = r102.iterator();
    L16:
        if (r103.hasNext() == false) goto L51;
        InspirationFeedEffectModel r104 = (InspirationFeedEffectModel) r103.next();
        List<MaterialModel> r105 = r104.getMaterials();
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L16;
        MaterialModel r107 = (MaterialModel) r106.next();
        Effect r108 = r107.getSticker_data();
        if (r108 == null) goto L21;
        InspirationModel r109 = r104.getAweme();
        List<String> r110 = null;
        if (r109 == null) goto L29;
        AuthorModel r111 = r109.getAuthor();
        if (r111 == null) goto L29;
        String r112 = r111.getNickname();
    L30:
        r108.setNickname(r112);
        InspirationModel r113 = r104.getAweme();
        if (r113 == null) goto L35;
        AuthorModel r114 = r113.getAuthor();
        if (r114 == null) goto L35;
        AuthorThumbModel r115 = r114.getAvatar_thumb();
    L36:
        r108.setAvatar_thumb(r115);
        Long r116 = r107.getUse_count();
        if (r116 == null) goto L39;
        long r117 = r116.longValue();
    L40:
        r108.setUse_number(r117);
        InspirationModel r118 = r104.getAweme();
        if (r118 == null) goto L47;
        VideoModel r119 = r118.getVideo();
        if (r119 == null) goto L47;
        UrlModel r120 = r119.getPlay_addr();
        if (r120 == null) goto L47;
        r110 = r120.getUrl_list();
    L47:
        r108.setVideoPlayURLs(r110);
        ArrayList<Effect> r121 = this.effectList;
        if (r121 == null) goto L21;
        r121.add(r108);
        goto L21
    L39:
        r117 = 0;
    L35:
        r115 = null;
    L29:
        r112 = null;
    L51:
        return this.effectList;
    L11:
        return this.effectList;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final int getHas_more() {
        return this.has_more;
    }

    public final List<InspirationFeedEffectModel> getInspiration_awemes() {
        return this.inspiration_awemes;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ List<? extends Effect> getResponseData() {
        return getResponseData2();
    }

    public final void setHas_more(int r100) {
        this.has_more = r100;
    }

    public final void setInspiration_awemes(List<InspirationFeedEffectModel> r100) {
        this.inspiration_awemes = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public InspirationFeedEffectsResponse(List<InspirationFeedEffectModel> r100, String r101, int r102, int r103, ArrayList<Effect> r104) {
        this.inspiration_awemes = r100;
        this.message = r101;
        this.status_code = r102;
        this.has_more = r103;
        this.effectList = r104;
    }

    public /* synthetic */ InspirationFeedEffectsResponse(List r100, String r101, int r102, int r103, ArrayList r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        ArrayList r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
