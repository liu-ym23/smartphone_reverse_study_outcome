package com.ss.android.ugc.aweme.live.alphaplayer.model;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f451124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataInfo f451125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataInfo f451126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f451127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f451128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f451129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f451130g;

    public static final class Area {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f451131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f451132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f451133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f451134d;

        public Area() {
        }

        public Area(int[] r100) {
            int r101 = r100[0];
            int r102 = r100[1];
            this(r101, r102, r101 + r100[2], r102 + r100[3]);
        }

        public Area(float r100, float r101, float r102, float r103) {
            this.f451131a = r100;
            this.f451132b = r101;
            this.f451133c = r102;
            this.f451134d = r103;
        }
    }

    public static class DataInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f451135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ScaleType f451136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f451137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Area f451138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Area f451139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f451140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f451141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f451142h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f451143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f451144j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Map<String, Map<String, Element>> f451145k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<Layer> f451146l;

        public DataInfo() {
            this.f451136b = ScaleType.ScaleAspectFill;
        }

        public DataInfo(String r100) {
            this.f451136b = ScaleType.ScaleAspectFill;
            this.f451135a = r100;
        }

        public static DataInfo a(DataInfo r100) {
            Area r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            DataInfo r102 = new DataInfo();
            r102.f451135a = r100.f451135a;
            r102.f451136b = r100.f451136b;
            r102.f451137c = r100.f451137c;
            Area r103 = r100.f451138d;
            if (r103 != null) goto L8;
            Area r104 = null;
        L9:
            r102.f451138d = r104;
            Area r105 = r100.f451139e;
            if (r105 == null) goto L13;
            r101 = new Area();
            r101.f451131a = r105.f451131a;
            r101.f451132b = r105.f451132b;
            r101.f451133c = r105.f451133c;
            r101.f451134d = r105.f451134d;
        L13:
            r102.f451139e = r101;
            r102.f451140f = r100.f451140f;
            r102.f451141g = r100.f451141g;
            r102.f451142h = r100.f451142h;
            r102.f451143i = r100.f451143i;
            r102.f451144j = r100.f451144j;
            r102.f451145k = r100.f451145k;
            r102.f451146l = r100.f451146l;
            return r102;
        L8:
            r104 = new Area();
            r104.f451131a = r103.f451131a;
            r104.f451132b = r103.f451132b;
            r104.f451133c = r103.f451133c;
            r104.f451134d = r103.f451134d;
            goto L9
        }

        public final void b(int[] r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.length != 4) goto L8;
            this.f451138d = new Area(r100);
            return;
        }

        public final void c(int[] r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.length != 4) goto L8;
            this.f451139e = new Area(r100);
            return;
        }

        public final void d(int r100) {
            this.f451136b = ScaleType.convertFrom(r100);
        }
    }

    public static final class Element extends Renderable {
        public final String toString() {
            return "Element{type=0, fitType=0, sourceFrame=" + Arrays.toString(null) + ", renderFrame=" + Arrays.toString(null) + '}';
        }

        public Element() {
        }
    }

    public static final class Layer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f451147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f451148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Area f451149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Area f451150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f451151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MaskContainer f451152f;

        public Layer() {
        }
    }

    public static final class MaskContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f451153a;

        @Retention(RetentionPolicy.SOURCE)
        public @interface MaskContainerAlignType {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface MaskContainerType {
        }

        public MaskContainer() {
        }
    }

    public static abstract class Renderable {
        public Renderable() {
        }
    }

    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType BottomFill = null;
        public static final ScaleType BottomFit = null;
        public static final ScaleType LeftFill = null;
        public static final ScaleType LeftFit = null;
        public static final ScaleType RightFill = null;
        public static final ScaleType RightFit = null;
        public static final ScaleType ScaleAspectFill = null;
        public static final ScaleType ScaleAspectFitCenter = null;
        public static final ScaleType ScaleToFill = null;
        public static final ScaleType TopFill = null;
        public static final ScaleType TopFit = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScaleType[] f451154a = null;
        int index;

        static {
            ScaleType r100 = new ScaleType("ScaleToFill", 0, 0);
            ScaleToFill = r100;
            ScaleType r101 = new ScaleType("ScaleAspectFitCenter", 1, 1);
            ScaleAspectFitCenter = r101;
            ScaleType r102 = new ScaleType("ScaleAspectFill", 2, 2);
            ScaleAspectFill = r102;
            ScaleType r103 = new ScaleType("TopFill", 3, 3);
            TopFill = r103;
            ScaleType r104 = new ScaleType("BottomFill", 4, 4);
            BottomFill = r104;
            ScaleType r105 = new ScaleType("LeftFill", 5, 5);
            LeftFill = r105;
            ScaleType r110 = new ScaleType("RightFill", 6, 6);
            RightFill = r110;
            ScaleType r111 = new ScaleType("TopFit", 7, 7);
            TopFit = r111;
            ScaleType r112 = new ScaleType("BottomFit", 8, 8);
            BottomFit = r112;
            ScaleType r113 = new ScaleType("LeftFit", 9, 9);
            LeftFit = r113;
            ScaleType r114 = new ScaleType("RightFit", 10, 10);
            RightFit = r114;
            f451154a = new ScaleType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static ScaleType[] values() {
            return (ScaleType[]) f451154a.clone();
        }

        public static ScaleType convertFrom(int r100) {
            switch(r100) {
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L12;
                case 8: goto L10;
                case 9: goto L8;
                case 10: goto L6;
                default: goto L4;
            };
        L4:
            return ScaleAspectFill;
        L6:
            return RightFit;
        L8:
            return LeftFit;
        L10:
            return BottomFit;
        L12:
            return TopFit;
        L14:
            return RightFill;
        L16:
            return LeftFill;
        L18:
            return BottomFill;
        L20:
            return TopFill;
        L22:
            return ScaleAspectFill;
        L24:
            return ScaleAspectFitCenter;
        L26:
            return ScaleToFill;
        }

        public static ScaleType valueOf(String r100) {
            return (ScaleType) a.a(ScaleType.class, r100);
        }

        public ScaleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.index = r102;
        }
    }

    public final void a() {
        DataInfo r100 = this.f451125b;
        boolean r101 = false;
        if (r100 != null) goto L6;
        this.f451128e = "dataInfo is null.";
    L53:
        this.f451124a = r101;
        return;
    L6:
        if (TextUtils.isEmpty(r100.f451135a) == false) goto L9;
        this.f451128e = "dataPath is empty.";
        goto L53
    L9:
        if (new PolarisFileWrapper(r100.f451135a).exists() == true) goto L12;
        this.f451128e = "dataPath is not exist, path: " + r100.f451135a;
        goto L53
    L12:
        if (r100.f451144j <= 0) goto L52;
        Area r102 = r100.f451138d;
        if (r102 == null) goto L51;
        Area r103 = r100.f451139e;
        if (r103 == null) goto L51;
        if (r102.f451131a <= r102.f451133c) goto L21;
    L23:
        boolean r104 = false;
    L24:
        if (r104 == false) goto L50;
        float r105 = r103.f451131a;
        float r106 = r103.f451133c;
        if (r105 <= r106) goto L28;
    L30:
        boolean r107 = false;
    L31:
        if (r107 == false) goto L50;
        if (r100.f451140f > 0) goto L36;
    L49:
        this.f451128e = "video size is wrong";
        goto L53
    L36:
        if (r100.f451141g <= 0) goto L49;
        int r108 = r100.f451142h;
        if (r108 <= 0) goto L48;
        int r109 = r100.f451143i;
        if (r109 <= 0) goto L48;
        if ((r106 - r105) == r108) goto L46;
    L47:
        this.f451128e = "rgb area is not equal to actual size";
        goto L53
    L46:
        if ((r103.f451134d - r103.f451132b) == r109) goto L52;
    L48:
        this.f451128e = "actual size is wrong";
        goto L53
    L28:
        if (r103.f451132b > r103.f451134d) goto L30;
        r107 = true;
    L50:
        this.f451128e = "area is invalid";
        goto L53
    L21:
        if (r102.f451132b > r102.f451134d) goto L23;
        r104 = true;
    L51:
        this.f451128e = "area is empty";
    L52:
        r101 = true;
        goto L53
    }

    public DataSource() {
        this.f451124a = false;
        this.f451127d = false;
        this.f451130g = true;
    }

    public final void b(DataInfo r100) {
        this.f451126c = r100;
        a();
    }

    public final void c(DataInfo r100) {
        this.f451125b = r100;
        a();
    }
}
