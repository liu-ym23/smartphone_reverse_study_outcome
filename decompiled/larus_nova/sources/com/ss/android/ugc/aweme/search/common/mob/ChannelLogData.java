package com.ss.android.ugc.aweme.search.common.mob;

import com.bytedance.ies.modulize.rule.AllowImpl;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BE\b\u0007\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\"\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R-\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028BX\u0083\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR-\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028BX\u0083\u0084\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000bR'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData;", "Ljava/io/Serializable;", "", "", "toMutableMap", "serverLogData", "Ljava/util/Map;", "commonLocalLogData", "mMergedServerLogData$delegate", "Lkotlin/Lazy;", "getMMergedServerLogData", "()Ljava/util/Map;", "getMMergedServerLogData$annotations", "()V", "mMergedServerLogData", "mMergedCommonLocalLogData$delegate", "getMMergedCommonLocalLogData", "getMMergedCommonLocalLogData$annotations", "mMergedCommonLocalLogData", "mMergedCommonLogData$delegate", "getMMergedCommonLogData", "mMergedCommonLogData", "parentChannelLogData", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData;)V", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class ChannelLogData implements Serializable {
    public static final Companion Companion = null;
    private final Map<String, String> commonLocalLogData;
    private final Lazy mMergedCommonLocalLogData$delegate;
    private final Lazy mMergedCommonLogData$delegate;
    private final Lazy mMergedServerLogData$delegate;
    private final Map<String, String> serverLogData;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData$Companion;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @AllowImpl
        @JvmStatic
        public static Map a(Map r100, Map r101) {
            LinkedHashMap r102 = new LinkedHashMap();
            if (r100 == null) goto L5;
            r102.putAll(r100);
        L5:
            if (r101 == null) goto L7;
            r102.putAll(r101);
        L7:
            return r102;
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ChannelLogData() {
        this(null, null, null, 7, null);
    }

    public ChannelLogData(Map<String, String> r100) {
        this(r100, null, null, 6, null);
    }

    public ChannelLogData(Map<String, String> r100, Map<String, String> r101) {
        this(r100, r101, null, 4, null);
    }

    @AllowImpl
    @JvmStatic
    public static final Map<String, String> mergeParentAndChildLogData(Map<String, String> r100, Map<String, String> r101) {
        Companion.getClass();
        return Companion.a(r100, r101);
    }

    @AllowImpl
    public final Map<String, String> toMutableMap() {
        return MapsKt.toMutableMap((Map) this.mMergedCommonLogData$delegate.getValue());
    }

    public static final /* synthetic */ Map access$getCommonLocalLogData$p(ChannelLogData r100) {
        return r100.commonLocalLogData;
    }

    public static final Map access$getMMergedCommonLocalLogData(ChannelLogData r100) {
        return (Map) r100.mMergedCommonLocalLogData$delegate.getValue();
    }

    public static final Map access$getMMergedCommonLogData(ChannelLogData r100) {
        return (Map) r100.mMergedCommonLogData$delegate.getValue();
    }

    public static final Map access$getMMergedServerLogData(ChannelLogData r100) {
        return (Map) r100.mMergedServerLogData$delegate.getValue();
    }

    public static final /* synthetic */ Map access$getServerLogData$p(ChannelLogData r100) {
        return r100.serverLogData;
    }

    @AllowImpl
    @JvmStatic
    public static final Map<String, String> addChannelLogData(Map<String, String> r100, ChannelLogData r101) {
        Companion.getClass();
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        r100.putAll(access$getMMergedCommonLogData(r101));
    L8:
        return r100;
    }

    public ChannelLogData(Map<String, String> r100, Map<String, String> r101, final ChannelLogData r102) {
        this.serverLogData = r100;
        this.commonLocalLogData = r101;
        this.mMergedServerLogData$delegate = LazyKt.lazy(new ChannelLogData$mMergedServerLogData$2(r102, this));
        this.mMergedCommonLocalLogData$delegate = LazyKt.lazy(new ChannelLogData$mMergedCommonLocalLogData$2(r102, this));
        this.mMergedCommonLogData$delegate = LazyKt.lazy(new ChannelLogData$mMergedCommonLogData$2(this, r102));
    }

    public /* synthetic */ ChannelLogData(Map r100, Map r101, ChannelLogData r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
