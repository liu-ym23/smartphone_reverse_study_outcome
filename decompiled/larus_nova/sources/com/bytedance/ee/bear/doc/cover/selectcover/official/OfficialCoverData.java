package com.bytedance.ee.bear.doc.cover.selectcover.official;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0004\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Data;", "<init>", "()V", "handlePrioritize", "", "Data", "CoverSeries", "Series", "CoverItem", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficialCoverData extends Result<Data> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "token", "getToken", "setToken", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CoverItem implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f217836id;

        @JSONField(name = "mime_type")
        private String mimeType;
        private int priority;
        private String token;

        public CoverItem() {
        }

        public final String getId() {
            return this.f217836id;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final String getToken() {
            return this.token;
        }

        public final void setId(String r100) {
            this.f217836id = r100;
        }

        public final void setMimeType(String r100) {
            this.mimeType = r100;
        }

        public final void setPriority(int r100) {
            this.priority = r100;
        }

        public final void setToken(String r100) {
            this.token = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "series", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Series;", "getSeries", "()Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Series;", "setSeries", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Series;)V", "candidateCovers", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverItem;", "getCandidateCovers", "()Ljava/util/List;", "setCandidateCovers", "(Ljava/util/List;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CoverSeries implements NonProguard {

        @JSONField(name = "candidate_covers")
        private List<CoverItem> candidateCovers;
        private Series series;

        public CoverSeries() {
        }

        public final List<CoverItem> getCandidateCovers() {
            return this.candidateCovers;
        }

        public final Series getSeries() {
            return this.series;
        }

        public final void setCandidateCovers(List<CoverItem> r100) {
            this.candidateCovers = r100;
        }

        public final void setSeries(Series r100) {
            this.series = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Data;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "coverSeriesList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "getCoverSeriesList", "()Ljava/util/List;", "setCoverSeriesList", "(Ljava/util/List;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements NonProguard {

        @JSONField(name = "cover_series")
        private List<CoverSeries> coverSeriesList;

        public Data() {
        }

        public final List<CoverSeries> getCoverSeriesList() {
            return this.coverSeriesList;
        }

        public final void setCoverSeriesList(List<CoverSeries> r100) {
            this.coverSeriesList = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$Series;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "zh", "", "getZh", "()Ljava/lang/String;", "setZh", "(Ljava/lang/String;)V", "en", "getEn", "setEn", EnvConst$GEO.JP, "getJp", "setJp", "seriesId", "getSeriesId", "setSeriesId", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Series implements NonProguard {

        /* JADX INFO: renamed from: en, reason: collision with root package name */
        private String f217837en;

        /* JADX INFO: renamed from: jp, reason: collision with root package name */
        private String f217838jp;

        @JSONField(name = "series_id")
        private String seriesId;

        /* JADX INFO: renamed from: zh, reason: collision with root package name */
        private String f217839zh;

        public Series() {
        }

        public final String getEn() {
            return this.f217837en;
        }

        public final String getJp() {
            return this.f217838jp;
        }

        public final String getSeriesId() {
            return this.seriesId;
        }

        public final String getZh() {
            return this.f217839zh;
        }

        public final void setEn(String r100) {
            this.f217837en = r100;
        }

        public final void setJp(String r100) {
            this.f217838jp = r100;
        }

        public final void setSeriesId(String r100) {
            this.seriesId = r100;
        }

        public final void setZh(String r100) {
            this.f217839zh = r100;
        }
    }

    public final void handlePrioritize() {
        Data r100 = (Data) this.data;
        if (r100 == null) goto L19;
        List<CoverSeries> r101 = r100.getCoverSeriesList();
        if (r101 == null) goto L27;
        List r102 = p.a(r101);
        if (r102 == null) goto L28;
        Iterator r103 = r102.iterator();
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L29;
        List<CoverItem> r105 = ((CoverSeries) r103.next()).getCandidateCovers();
        if (r105 == null) goto L10;
        List r106 = p.a(r105);
        if (r106 == null) goto L10;
        Iterator r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L10;
        ((CoverItem) r107.next()).setPriority(r104);
        r104 = r104 + 1;
        goto L17
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public OfficialCoverData() {
    }
}
