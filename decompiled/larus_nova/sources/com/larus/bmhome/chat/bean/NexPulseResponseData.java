package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u0015*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "", "candidateList", "", "Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "categoryCandidateList", "nexPulseType", "", "conf", "Lcom/larus/bmhome/chat/bean/NexPulseConf;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseConf;)V", "getCandidateList", "()Ljava/util/List;", "getCategoryCandidateList", "getNexPulseType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConf", "()Lcom/larus/bmhome/chat/bean/NexPulseConf;", "isValid", "", "toSuggestItems", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "isInTaskMode", "(Ljava/lang/Boolean;)Ljava/util/List;", "isVisibleInMode", "(Lcom/larus/bmhome/chat/bean/NexPulseCandidate;Ljava/lang/Boolean;)Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseConf;)Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NexPulseResponseData {

    @SerializedName("candidate_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<NexPulseCandidate> candidateList;

    @SerializedName("category_candidate_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<NexPulseCandidate> categoryCandidateList;

    @SerializedName("conf")
    private final NexPulseConf conf;

    @SerializedName("nexpulse_type")
    private final Integer nexPulseType;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            TextCandidateConf r102 = ((NexPulseCandidate) r100).getTextConf();
            int r103 = Integer.MAX_VALUE;
            if (r102 == null) goto L7;
            Integer r104 = r102.getPosition();
            if (r104 == null) goto L7;
            int r105 = r104.intValue();
        L8:
            Integer r106 = Integer.valueOf(r105);
            TextCandidateConf r107 = ((NexPulseCandidate) r101).getTextConf();
            if (r107 == null) goto L14;
            Integer r108 = r107.getPosition();
            if (r108 == null) goto L14;
            r103 = r108.intValue();
        L14:
            return ComparisonsKt.compareValues(r106, Integer.valueOf(r103));
        L7:
            r105 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            TextCandidateConf r102 = ((NexPulseCandidate) r100).getTextConf();
            int r103 = Integer.MAX_VALUE;
            if (r102 == null) goto L7;
            Integer r104 = r102.getPosition();
            if (r104 == null) goto L7;
            int r105 = r104.intValue();
        L8:
            Integer r106 = Integer.valueOf(r105);
            TextCandidateConf r107 = ((NexPulseCandidate) r101).getTextConf();
            if (r107 == null) goto L14;
            Integer r108 = r107.getPosition();
            if (r108 == null) goto L14;
            r103 = r108.intValue();
        L14:
            return ComparisonsKt.compareValues(r106, Integer.valueOf(r103));
        L7:
            r105 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            TextCandidateConf r102 = ((NexPulseCandidate) r100).getTextConf();
            int r103 = Integer.MAX_VALUE;
            if (r102 == null) goto L7;
            Integer r104 = r102.getPosition();
            if (r104 == null) goto L7;
            int r105 = r104.intValue();
        L8:
            Integer r106 = Integer.valueOf(r105);
            TextCandidateConf r107 = ((NexPulseCandidate) r101).getTextConf();
            if (r107 == null) goto L14;
            Integer r108 = r107.getPosition();
            if (r108 == null) goto L14;
            r103 = r108.intValue();
        L14:
            return ComparisonsKt.compareValues(r106, Integer.valueOf(r103));
        L7:
            r105 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public NexPulseResponseData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NexPulseResponseData copy$default(NexPulseResponseData r100, List r101, List r102, Integer r103, NexPulseConf r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.candidateList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.categoryCandidateList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.nexPulseType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.conf;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<NexPulseCandidate> component1() {
        return this.candidateList;
    }

    public final List<NexPulseCandidate> component2() {
        return this.categoryCandidateList;
    }

    public final Integer component3() {
        return this.nexPulseType;
    }

    public final NexPulseConf component4() {
        return this.conf;
    }

    public final NexPulseResponseData copy(List<NexPulseCandidate> r100, List<NexPulseCandidate> r101, Integer r102, NexPulseConf r103) {
        return new NexPulseResponseData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NexPulseResponseData) == true) goto L8;
        return false;
    L8:
        NexPulseResponseData r101 = (NexPulseResponseData) r100;
        if (Intrinsics.areEqual(this.candidateList, r101.candidateList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryCandidateList, r101.categoryCandidateList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nexPulseType, r101.nexPulseType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conf, r101.conf) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<NexPulseCandidate> r100 = this.candidateList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<NexPulseCandidate> r104 = this.categoryCandidateList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.nexPulseType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        NexPulseConf r110 = this.conf;
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

    public String toString() {
        return "NexPulseResponseData(candidateList=" + this.candidateList + ", categoryCandidateList=" + this.categoryCandidateList + ", nexPulseType=" + this.nexPulseType + ", conf=" + this.conf + ')';
    }

    public final boolean isValid() {
        Integer r100 = this.nexPulseType;
        if (r100 != null) goto L6;
    L24:
        if (r100 != null) goto L27;
    L28:
        if (r100 != null) goto L31;
        return false;
    L31:
        if (r100.intValue() != 4) goto L43;
    L32:
        List<NexPulseCandidate> r101 = this.candidateList;
        if (r101 != null) goto L35;
    L38:
        boolean r102 = true;
    L39:
        if (r102 == true) goto L44;
    L23:
        return true;
    L44:
        return false;
    L35:
        if (r101.isEmpty() == true) goto L38;
        r102 = false;
        goto L39
    L43:
        return false;
    L27:
        if (r100.intValue() == 2) goto L32;
    L6:
        if (r100.intValue() != 1) goto L24;
        List<NexPulseCandidate> r103 = this.candidateList;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L23;
        List<NexPulseCandidate> r105 = this.categoryCandidateList;
        if (r105 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L23;
        return false;
    L18:
        if (r105.isEmpty() == true) goto L21;
        r106 = false;
        goto L22
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
        goto L14
    }

    public final List<NexPulseCandidate> getCandidateList() {
        return this.candidateList;
    }

    public final List<NexPulseCandidate> getCategoryCandidateList() {
        return this.categoryCandidateList;
    }

    public final NexPulseConf getConf() {
        return this.conf;
    }

    public final Integer getNexPulseType() {
        return this.nexPulseType;
    }

    public final List<PromptContent.SuggestItem> toSuggestItems(Boolean r110) {
        List<NexPulseCandidate> r100 = this.categoryCandidateList;
        if (r100 != null) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if (r100.isEmpty() == false) goto L21;
        List<NexPulseCandidate> r101 = this.candidateList;
        if (r101 != null) goto L10;
        r101 = CollectionsKt.emptyList();
    L10:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if (isVisibleInMode((NexPulseCandidate) r104, r110) == false) goto L12;
        r102.add(r104);
        goto L12
    L16:
        List r111 = CollectionsKt.sortedWith(r102, new a());
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L18:
        if (r112.hasNext() == false) goto L20;
        r105.add(NexPulseCandidate.toSuggestItem$default((NexPulseCandidate) r112.next(), null, false, 3, null));
        goto L18
    L20:
        return r105;
    L21:
        List<NexPulseCandidate> r106 = this.candidateList;
        if (r106 != null) goto L24;
        r106 = CollectionsKt.emptyList();
    L24:
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L26:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        if (isVisibleInMode((NexPulseCandidate) r109, r110) == false) goto L26;
        r107.add(r109);
        goto L26
    L30:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r107.iterator();
    L31:
        boolean r115 = true;
        if (r114.hasNext() == false) goto L53;
        Object r116 = r114.next();
        NexPulseCandidate r117 = (NexPulseCandidate) r116;
        String r118 = r117.getCategoryId();
        if (r118 != null) goto L36;
    L39:
        boolean r119 = true;
    L40:
        if (r119 == false) goto L51;
        String r120 = r117.getParentId();
        if (r120 != null) goto L44;
    L47:
        boolean r121 = true;
    L48:
        if (r121 == false) goto L51;
        r115 = false;
        goto L51
    L44:
        if (r120.length() == 0) goto L47;
        r121 = false;
    L51:
        if (r115 == false) goto L31;
        r113.add(r116);
        goto L31
    L36:
        if (r118.length() == 0) goto L39;
        r119 = false;
        goto L40
    L53:
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator r123 = r113.iterator();
    L55:
        if (r123.hasNext() == false) goto L63;
        Object r124 = r123.next();
        NexPulseCandidate r125 = (NexPulseCandidate) r124;
        String r126 = r125.getCategoryId();
        if (r126 != null) goto L59;
        r126 = r125.getParentId();
    L59:
        Object r127 = r122.get(r126);
        if (r127 != null) goto L62;
        r127 = new ArrayList();
        r122.put(r126, r127);
    L62:
        ((List) r127).add(r124);
        goto L55
    L63:
        ArrayList r128 = new ArrayList();
        Iterator<T> r129 = r100.iterator();
    L65:
        if (r129.hasNext() == false) goto L69;
        Object r130 = r129.next();
        if (isVisibleInMode((NexPulseCandidate) r130, r110) == false) goto L65;
        r128.add(r130);
        goto L65
    L69:
        List r131 = CollectionsKt.sortedWith(r128, new b());
        ArrayList r132 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r131, 10));
        Iterator r133 = r131.iterator();
    L71:
        if (r133.hasNext() == false) goto L86;
        NexPulseCandidate r134 = (NexPulseCandidate) r133.next();
        List r135 = (List) r122.get(r134.getGid());
        if (r135 != null) goto L75;
        r135 = (List) r122.get(r134.getCategoryId());
    L75:
        if (r135 != null) goto L77;
        r135 = CollectionsKt.emptyList();
    L77:
        List r136 = CollectionsKt.sortedWith(r135, new c());
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
        Iterator r138 = r136.iterator();
    L79:
        if (r138.hasNext() == false) goto L82;
        r137.add(NexPulseCandidate.toSuggestItem$default((NexPulseCandidate) r138.next(), null, false, 3, null));
        goto L79
    L82:
        if ((!r137.isEmpty()) == true) goto L85;
        r137 = null;
    L85:
        r132.add(r134.toSuggestItem(r137, true));
        goto L71
    L86:
        return r132;
    }

    private final boolean isVisibleInMode(NexPulseCandidate r100, Boolean r101) {
        Integer r102 = r100.getCandidateType();
        if (r102 != null) goto L6;
    L11:
        if (r102 != null) goto L14;
        return true;
    L14:
        if (r102.intValue() == 2) goto L16;
        return true;
    L16:
        return Intrinsics.areEqual(r101, Boolean.TRUE);
    L6:
        if (r102.intValue() != 1) goto L11;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L19;
        return false;
    L19:
        return true;
    }

    public NexPulseResponseData(List<NexPulseCandidate> r100, List<NexPulseCandidate> r101, Integer r102, NexPulseConf r103) {
        this.candidateList = r100;
        this.categoryCandidateList = r101;
        this.nexPulseType = r102;
        this.conf = r103;
    }

    public static /* synthetic */ List toSuggestItems$default(NexPulseResponseData r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.toSuggestItems(r101);
    }

    public /* synthetic */ NexPulseResponseData(List r100, List r101, Integer r102, NexPulseConf r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
