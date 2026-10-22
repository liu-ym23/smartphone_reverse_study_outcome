package dt7;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/enroll/audio/enroll/asr/sami/SamiAsrDataBin;", "", "results", "", "Lcom/enroll/audio/enroll/asr/sami/SamiAsrDataBin$ResultItem;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "setResults", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ResultItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("results")
    private List<C5708a> results;

    /* JADX INFO: renamed from: dt7.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/enroll/audio/enroll/asr/sami/SamiAsrDataBin$ResultItem;", "", "text", "", DyPayConstant.KEY_START_TIME, "", "endTime", "isInterim", "", "<init>", "(Ljava/lang/String;FFZ)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getStartTime", "()F", "setStartTime", "(F)V", "getEndTime", "setEndTime", "()Z", "setInterim", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C5708a {

        @SerializedName("end_time")
        private float endTime;

        @SerializedName("is_interim")
        private boolean isInterim;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private float startTime;

        @SerializedName("text")
        private String text;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5708a) == true) goto L8;
            return false;
        L8:
            C5708a r101 = (C5708a) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.startTime, r101.startTime) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.endTime, r101.endTime) == 0) goto L18;
            return false;
        L18:
            if (this.isInterim == r101.isInterim) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.text;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = ((((r101 * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.endTime)) * 31;
            if (this.isInterim == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ResultItem(text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", isInterim=" + this.isInterim + ')';
        }

        public C5708a() {
            this.text = null;
            this.startTime = 0.0f;
            this.endTime = 0.0f;
            this.isInterim = false;
        }

        public final float a() {
            return this.endTime;
        }

        public final float b() {
            return this.startTime;
        }

        public final String c() {
            return this.text;
        }

        public final boolean d() {
            return this.isInterim;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.results, ((a) r100).results) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<C5708a> r100 = this.results;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SamiAsrDataBin(results=" + this.results + ')';
    }

    public a() {
        this.results = null;
    }

    public final List<C5708a> a() {
        return this.results;
    }
}
