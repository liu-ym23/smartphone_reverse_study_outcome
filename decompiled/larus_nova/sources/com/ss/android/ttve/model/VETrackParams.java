package com.ss.android.ttve.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.vesdk.VESize;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class VETrackParams implements Parcelable {
    public static final Parcelable.Creator<VETrackParams> CREATOR = null;
    public static final String EMPTY_PATH = "empty_path";
    private int extFlag;
    private int layer;
    private List<String> paths;
    private List<Integer> seqIns;
    private List<Integer> seqOuts;
    private List<VESize> sizes;
    private List<Double> speeds;
    private TrackPriority trackPriority;
    private List<Integer> trimIns;
    private List<Integer> trimOuts;

    public static final enum TrackPriority extends Enum<TrackPriority> {
        public static final TrackPriority DEFAULT = null;
        public static final TrackPriority External = null;
        public static final TrackPriority HOST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TrackPriority[] f449904a = null;

        static {
            TrackPriority r100 = new TrackPriority("DEFAULT", 0);
            DEFAULT = r100;
            TrackPriority r101 = new TrackPriority(HTTP.HOST, 1);
            HOST = r101;
            TrackPriority r102 = new TrackPriority("External", 2);
            External = r102;
            f449904a = new TrackPriority[]{r100, r101, r102};
        }

        public static TrackPriority[] values() {
            return (TrackPriority[]) f449904a.clone();
        }

        public static TrackPriority valueOf(String r100) {
            return (TrackPriority) r27.a.a(TrackPriority.class, r100);
        }

        public TrackPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VETrackParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VETrackParams createFromParcel(Parcel r100) {
            return new VETrackParams(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VETrackParams[] newArray(int r100) {
            return new VETrackParams[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VETrackParams f449905a;

        public final void b() {
            if (VETrackParams.access$400(this.f449905a) != null) goto L5;
            VETrackParams.access$402(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$400(this.f449905a).add(0);
        }

        public final void c() {
            if (VETrackParams.access$500(this.f449905a) != null) goto L5;
            VETrackParams.access$502(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$500(this.f449905a).add(Integer.MAX_VALUE);
        }

        public final void d() {
            if (VETrackParams.access$600(this.f449905a) != null) goto L5;
            VETrackParams.access$602(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$600(this.f449905a).add(Double.valueOf(1.0d));
        }

        public final void e() {
            if (VETrackParams.access$200(this.f449905a) != null) goto L5;
            VETrackParams.access$202(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$200(this.f449905a).add(0);
        }

        public b() {
            this.f449905a = new VETrackParams(null);
        }

        public final void a(String r100) {
            if (VETrackParams.access$100(this.f449905a) != null) goto L5;
            VETrackParams.access$102(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$100(this.f449905a).add(r100);
        }

        public final void f(int r100) {
            if (VETrackParams.access$300(this.f449905a) != null) goto L5;
            VETrackParams.access$302(this.f449905a, new ArrayList());
        L5:
            VETrackParams.access$300(this.f449905a).add(Integer.valueOf(r100));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "VETrackParams{paths=" + this.paths + ", trimIns=" + this.trimIns + ", trimOuts=" + this.trimOuts + ", seqIns=" + this.seqIns + ", seqOuts=" + this.seqOuts + ", speeds=" + this.speeds + ", layer=" + this.layer + ", trackPriority=" + this.trackPriority + ", extFlag=" + this.extFlag + '}';
    }

    private VETrackParams() {
        this.layer = -1;
        this.trackPriority = TrackPriority.DEFAULT;
        this.extFlag = 0;
    }

    public int getExtFlag() {
        return this.extFlag;
    }

    public int getLayer() {
        return this.layer;
    }

    public List<String> getPaths() {
        return this.paths;
    }

    public List<Integer> getSeqIns() {
        return this.seqIns;
    }

    public List<Integer> getSeqOuts() {
        return this.seqOuts;
    }

    public List<VESize> getSizes() {
        return this.sizes;
    }

    public List<Double> getSpeeds() {
        return this.speeds;
    }

    public TrackPriority getTrackPriority() {
        return this.trackPriority;
    }

    public List<Integer> getTrimIns() {
        return this.trimIns;
    }

    public List<Integer> getTrimOuts() {
        return this.trimOuts;
    }

    public VETrackParams(Parcel r100) {
        this.layer = -1;
        this.trackPriority = TrackPriority.DEFAULT;
        this.extFlag = 0;
        this.paths = r100.createStringArrayList();
        ArrayList r101 = new ArrayList();
        this.trimIns = r101;
        r100.readList(r101, Integer.class.getClassLoader());
        ArrayList r102 = new ArrayList();
        this.trimOuts = r102;
        r100.readList(r102, Integer.class.getClassLoader());
        ArrayList r103 = new ArrayList();
        this.seqIns = r103;
        r100.readList(r103, Integer.class.getClassLoader());
        ArrayList r104 = new ArrayList();
        this.seqOuts = r104;
        r100.readList(r104, Integer.class.getClassLoader());
        ArrayList r105 = new ArrayList();
        this.speeds = r105;
        r100.readList(r105, Double.class.getClassLoader());
        this.layer = r100.readInt();
        int r106 = r100.readInt();
        if (r106 != (-1)) goto L5;
        TrackPriority r107 = null;
    L6:
        this.trackPriority = r107;
        this.extFlag = r100.readInt();
        return;
    L5:
        r107 = TrackPriority.values()[r106];
        goto L6
    }

    public static /* synthetic */ List access$100(VETrackParams r100) {
        return r100.paths;
    }

    public static /* synthetic */ List access$1000(VETrackParams r100) {
        return r100.sizes;
    }

    public static /* synthetic */ List access$200(VETrackParams r100) {
        return r100.trimIns;
    }

    public static /* synthetic */ List access$300(VETrackParams r100) {
        return r100.trimOuts;
    }

    public static /* synthetic */ List access$400(VETrackParams r100) {
        return r100.seqIns;
    }

    public static /* synthetic */ List access$500(VETrackParams r100) {
        return r100.seqOuts;
    }

    public static /* synthetic */ List access$600(VETrackParams r100) {
        return r100.speeds;
    }

    public /* synthetic */ VETrackParams(a r100) {
        this();
    }

    public static /* synthetic */ List access$1002(VETrackParams r100, List r101) {
        r100.sizes = r101;
        return r101;
    }

    public static /* synthetic */ List access$102(VETrackParams r100, List r101) {
        r100.paths = r101;
        return r101;
    }

    public static /* synthetic */ List access$202(VETrackParams r100, List r101) {
        r100.trimIns = r101;
        return r101;
    }

    public static /* synthetic */ List access$302(VETrackParams r100, List r101) {
        r100.trimOuts = r101;
        return r101;
    }

    public static /* synthetic */ List access$402(VETrackParams r100, List r101) {
        r100.seqIns = r101;
        return r101;
    }

    public static /* synthetic */ List access$502(VETrackParams r100, List r101) {
        r100.seqOuts = r101;
        return r101;
    }

    public static /* synthetic */ List access$602(VETrackParams r100, List r101) {
        r100.speeds = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(VETrackParams r100, int r101) {
        r100.layer = r101;
        return r101;
    }

    public static /* synthetic */ TrackPriority access$802(VETrackParams r100, TrackPriority r101) {
        r100.trackPriority = r101;
        return r101;
    }

    public static /* synthetic */ int access$902(VETrackParams r100, int r101) {
        r100.extFlag = r101;
        return r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStringList(this.paths);
        r100.writeList(this.trimIns);
        r100.writeList(this.trimOuts);
        r100.writeList(this.seqIns);
        r100.writeList(this.seqOuts);
        r100.writeList(this.speeds);
        r100.writeInt(this.layer);
        TrackPriority r102 = this.trackPriority;
        if (r102 != null) goto L5;
        int r103 = -1;
    L6:
        r100.writeInt(r103);
        r100.writeInt(this.extFlag);
        return;
    L5:
        r103 = r102.ordinal();
        goto L6
    }
}
